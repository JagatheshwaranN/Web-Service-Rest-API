// import { checkBackendHealth } from "./health.js";

// // Function to display available courses
// function showAvailableCourses() {
//     // Fetching the course data from the backend API (http://localhost:8080/courses)
//     fetch("http://localhost:8080/courses")
//         .then((response) => {
//             if(!response.ok) {
//                 throw new Error(`HTTP Error! status: ${response.status}`);
//             }
//             return response.json();
//         }) // Convert the response to JSON
//         .then((courses) => { // Once the data is received, we loop through the courses
//             const courseSection = document.getElementById("courseSection");
//             const dataTable = document.getElementById("courseTable"); // Get the table element where data will be displayed
//             if(courses.length === 0) {
//                 dataTable.innerHTML = `<tr><td colspan="4">No courses available at the moment.</td></tr>`;
//             }else{
//             courses.forEach(course => { // Loop over each course
//                 // Create a new table row with the course details
//                 var row = `<tr>
//                     <td>${course.courseId}</td> <!-- Course ID -->
//                     <td>${course.courseName}</td> <!-- Course Name -->
//                     <td>${course.trainer}</td> <!-- Trainer Name -->
//                     <td>${course.durationInWeeks}</td> <!-- Duration in weeks -->
//                 </tr>`;
//                 dataTable.innerHTML += row; // Append the row to the table body (courseTable)
//             });
//             }
//             courseSection.style.display = 'block';
//         })
//         .catch((error) => { // Handle errors if the fetch fails
//             console.error('Error fetching courses:', error);
//             //showErrorMessage("⚠️ Application is down. Please try again later.");
//             window.location.href = "app-down.html";
//         });
// }

function showAvailableCourses() {
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

function showErrorMessage(message) {
  const dataTable = document.getElementById("courseTable");
  dataTable.innerHTML = `<tr><td colspan="4" style="color: red; text-align: center;">${message}</td></tr>`;
}

// Function to display enrolled students
function showEnrolledStudents() {
  // Fetching the enrolled students data from the backend API (http://localhost:8080/courses/enrolled)
  fetch("http://localhost:8080/courses/enrolled")
    .then((response) => {
      if (!response.ok) {
        throw new Error(`HTTP Error! status : ${response.status}`);
      }
      return response.json();
    }) // Convert the response to JSON
    .then((students) => {
      // Once the data is received, we loop through the students

      const studentSection = document.getElementById("studentSection");
      const dataTable = document.getElementById("studentTable"); // Get the table element where data will be displayed

      if (students.length === 0) {
        dataTable.innerHTML = `<tr><td colspan="4">No students enrolled at the moment.</td></tr>`;
      } else {
        students.forEach((student) => {
          // Loop over each student
          // Create a new table row with the student's details
          var row = `<tr>
                    <td>${student.name}</td> <!-- Student's Name -->
                    <td>${student.emailId}</td> <!-- Student's Email ID -->
                    <td>${student.courseName}</td> <!-- Course Name -->
                </tr>`;
          dataTable.innerHTML += row; // Append the row to the table body (studentTable)
        });
      }
      studentSection.style.display = "block";
    })
    .catch((error) => {
      // Handle errors if the fetch fails
      console.error("Error fetching enrolled students:", error);
      window.location.href = "app-down.html";
    });
}

// Wait until the DOM is fully loaded
//document.addEventListener("DOMContentLoaded", function () {
// function addStudent() {    
//   // Get the registration form element
//   const form = document.getElementById("registrationForm");
//   // Get the div to show response messages (if you were showing it on the same page)
//   const responseDiv = document.getElementById("responseMessage");
//   fetch("http://localhost:8080/health")
//     .then((response) => {
//       if (response.ok) {
//         form.style.display = "block";
//         if (form) {
//           // Add a submit event listener to the form
//           form.addEventListener("submit", function (event) {
//             // Prevent default form submission behavior (which reloads the page)
//             event.preventDefault();

//             // Gather form data into FormData object
//             const formData = new FormData(form);

//             // Send the form data to the backend using Fetch API (POST request)
//             fetch("http://localhost:8080/courses/register", {
//               method: "POST",
//               body: new URLSearchParams(formData), // Convert to URL-encoded format
//             })
//               .then((response) => response.json()) // Parse response as JSON
//               .then((data) => {
//                 // Save the success message into sessionStorage so it can be accessed on the next page
//                 sessionStorage.setItem("registrationMessage", data.message);

//                 // Redirect to success page
//                 window.location.href = "register-success.html";

//                 // (Optional: you could show it on the same page instead of redirecting)
//                 // responseDiv.textContent = data.message;
//                 // responseDiv.style.display = "block";
//               })
//               .catch((error) => {
//                 // Handle any error during fetch (e.g. server down, network issue)
//                 alert("An error occurred. Please try again later.");
//                 console.error("Error: ", error);

//                 // Optional: show message in the responseDiv instead
//                 // responseDiv.textContent = "An error occurred. Please try again later.";
//                 // responseDiv.style.display = "block";
//               });
//           });
//         }
//       }
//     })
//     .catch((error) => {
//       console.error("Health Check Failed: ", error);
//       window.location.href = "app-down.html";
//     });
// };

function addStudent() {
  const form = document.getElementById("registrationForm");
  const responseDiv = document.getElementById("responseMessage");

  const backendUp = sessionStorage.getItem("backendHealthStatus") === "ok";
  const currentPage = window.location.pathname;

  // if (!backendUp) {
  //   console.error("Backend is down. Redirecting to app-down page.");
  //   window.location.href = "app-down.html";
  //   return;
  // }

  if (!backendUp && !currentPage.includes("app-down.html")) {
    console.error("Backend is down. Redirecting to app-down page.");
    window.location.href = "app-down.html";
    return;
  }

  if (form) {
  // Show the form
  form.style.display = "block";
  
    // Add a submit event listener to the form
    form.addEventListener("submit", function (event) {
      event.preventDefault();

      const formData = new FormData(form);

      fetch("http://localhost:8080/courses/register", {
        method: "POST",
        body: new URLSearchParams(formData),
      })
        .then((response) => response.json())
        .then((data) => {
          sessionStorage.setItem("registrationMessage", data.message);
          window.location.href = "register-success.html";
        })
        .catch((error) => {
          alert("An error occurred. Please try again later.");
          console.error("Error: ", error);
        });
    });
  }
}


// This part will run on the success page (register-success.html)
document.addEventListener("DOMContentLoaded", function () {
  // Get the box element where we will display the message
  const box = document.getElementById("messageBox");

  if (box) {
    // Retrieve the message from sessionStorage
    const message = sessionStorage.getItem("registrationMessage");

    // If a message was found in sessionStorage
    if (message) {
      box.textContent = message; // Show the message
      box.style.display = "block"; // Make the message box visible
      sessionStorage.removeItem("registrationMessage"); // Clear it after use
    } else {
      // If no message was found, show a fallback message
      box.textContent = "No registration message found.";
      box.style.display = "block";
    }
  }
});

window.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("registrationForm");
});

window.addEventListener("DOMContentLoaded", addStudent);