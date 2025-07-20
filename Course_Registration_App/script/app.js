function handleLogin() {
  const loginForm = document.getElementById("loginForm");
  const message = document.getElementById("loginMessage");
  if(!loginForm) {
    console.warn("Login form not found on this page.");
    return;
  }
  loginForm.addEventListener("submit", async (event) => {
    event.preventDefault();
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const roleType = document.getElementById("role").value;
    try {
      const response = await fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: {
          "Content-Type":"application/json"
        },
        body:JSON.stringify({username, password})
      });

      const result = await response.json();

      if(response.ok) {
        sessionStorage.setItem("jwtToken", result.token);
        sessionStorage.setItem("role", roleType);
        console.log('Token: ', result.token);
        message.innerText = "Login successful! Redirecting...";
        setTimeout(() => window.location.href = "home.html", 1000);
      } else {
        message.innerText = result.message || 'Login failed!';
      }
    }catch(err) {
      console.error('Login error: ', err);
      message.innerText = 'Server error. Try agai later.';
    }
  });
}

function showAvailableCourses() {
  
  if (redirectIfBackendDown()) return;

  authFetch("http://localhost:8080/courses")
    .then((response) => {
      if (!response.ok) {
        throw new Error(`HTTP Error! status: ${response.status}`);
      }
      return response.json();
    })
    .then((courses) => {
      const courseSection = document.getElementById("courseSection");
      const dataTable = document.getElementById("courseTable");

      if (courses.length === 0) {
        dataTable.innerHTML = `<tr><td colspan="4">No courses available at the moment.</td></tr>`;
      } else {
        courses.forEach((course) => {
          const row = `<tr>
                        <td>${course.courseId}</td>
                        <td>${course.courseName}</td>
                        <td>${course.trainer}</td>
                        <td>${course.durationInWeeks}</td>
                    </tr>`;
          dataTable.innerHTML += row;
        });
      }

      courseSection.style.display = "block";
    })
    .catch((error) => {
      console.error("Error fetching courses:", error);
      window.location.href = "app-down.html";
    });
}

function showEnrolledStudents() {

  if (redirectIfBackendDown()) return;

  authFetch("http://localhost:8080/admin/courses/enrolled")
    .then((response) => {
      if (!response.ok) {
        throw new Error(`HTTP Error! status : ${response.status}`);
      }
      return response.json();
    })
    .then((students) => {
      const studentSection = document.getElementById("studentSection");
      const dataTable = document.getElementById("studentTable");

      if (students.length === 0) {
        dataTable.innerHTML = `<tr><td colspan="4">No students enrolled at the moment.</td></tr>`;
      } else {
        students.forEach((student) => {
          var row = `<tr>
                    <td>${student.name}</td> <!-- Student's Name -->
                    <td>${student.emailId}</td> <!-- Student's Email ID -->
                    <td>${student.courseName}</td> <!-- Course Name -->
                </tr>`;
          dataTable.innerHTML += row;
        });
      }
      studentSection.style.display = "block";
    })
    .catch((error) => {
      console.error("Error fetching enrolled students:", error);
      window.location.href = "app-down.html";
    });
}

function addStudent() {
  const form = document.getElementById("registrationForm");

  if (redirectIfBackendDown()) return;

  if (form) {
    form.style.display = "block";

    form.addEventListener("submit", function (event) {
      event.preventDefault();

      const formData = new FormData(form);

      authFetch("http://localhost:8080/courses/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/x-www-form-urlencoded",
        },
        body: new URLSearchParams(formData),
      })
        .then((response) => {
          if (!response.ok) {
            throw new Error(`HTTP Error! status: ${response.status}`);
          }
          return response.json();
        })
        .then((data) => {
          sessionStorage.setItem("registrationMessage", data.message);
          window.location.href = "register-success.html";
        })
        .catch((error) => {
          console.error("Error during registration:", error);
          window.location.href = "app-down.html";
        });
    });
  } else {
    console.warn("Registration form not found on this page.");
    return;
  }
}

function redirectIfBackendDown() {
  const backendUp = sessionStorage.getItem("backendHealthStatus") === "ok";
  const currentPage = window.location.pathname;
  if (!backendUp && !currentPage.includes("app-down.html")) {
    console.error("Backend is down. Redirecting to app-down page.");
    window.location.href = "app-down.html";
    return true;
  }
  return false;
}

function handleLogout() {
  const logoutBtn = document.getElementById("logoutBtn");
  if(logoutBtn) {
    logoutBtn.addEventListener("click", ()=> {
      sessionStorage.removeItem("jwtToken");
      window.location.href = "login.html";
    });
  }
}

function enrolledStudentsButton() {
  const role = sessionStorage.getItem('role');
  const enrolledStudentsButton = document.getElementById('adminButton');
  if(!enrolledStudentsButton) {
    return;
  }
  if(role === 'USER') {
    enrolledStudentsButton.style.display = "none";
  } 
}

function authFetch(url, options = {}) {
  const token = sessionStorage.getItem("jwtToken");
  if (!token) {
    window.location.href = "login.html";
    return;
  }

  const headers = {
    ...options.headers,
    Authorization: `Bearer ${token}`,
  };

  const config = {
    ...options,
    headers,
  };

  return fetch(url, config);
}

window.addEventListener("DOMContentLoaded", () => {
  const currentPage = window.location.pathname;

  if (currentPage.includes("/login.html")) {
  handleLogin();
  }

  if (currentPage.includes("/register-course.html")) {
    addStudent();
  }

  if (currentPage.includes("/available-courses.html")) {
    showAvailableCourses();
  }

  if (currentPage.includes("/enrolled-students.html")) {
    showEnrolledStudents();
  }

  if (currentPage.includes("/home.html")) {
    //enrolledStudentsButton();
    //handleLogout();
  }
  
  if (currentPage.includes("/register-success.html")) {
    const box = document.getElementById("messageBox");
    if (box) {
      const message = sessionStorage.getItem("registrationMessage");
      if (message) {
        box.textContent = message;
        box.style.display = "block";
        sessionStorage.removeItem("registrationMessage");
      } else {
        box.textContent = "No registration message found.";
        box.style.display = "block";
      }
    }
  }
});

window.addEventListener("DOMContentLoaded", enrolledStudentsButton);
window.addEventListener("DOMContentLoaded", handleLogout);
