function showAvailableCourses() {
  
  if (redirectIfBackendDown()) return;

  fetch("http://localhost:8080/courses")
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

  fetch("http://localhost:8080/courses/enrolled")
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

      fetch("http://localhost:8080/courses/register", {
        method: "POST",
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

window.addEventListener("DOMContentLoaded", () => {
  const currentPage = window.location.pathname;

  if (currentPage.includes("/register.html")) {
    addStudent();
  }

  if (currentPage.includes("/courses.html")) {
    showAvailableCourses();
  }

  if (currentPage.includes("/students.html")) {
    showEnrolledStudents();
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

