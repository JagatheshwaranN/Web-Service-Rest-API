// Function to display available courses
function showAvailableCourses() {
    // Fetching the course data from the backend API (http://localhost:8080/courses)
    fetch("http://localhost:8080/courses")
        .then((response) => response.json()) // Convert the response to JSON
        .then((courses) => { // Once the data is received, we loop through the courses
            const dataTable = document.getElementById("courseTable"); // Get the table element where data will be displayed
            courses.forEach(course => { // Loop over each course
                // Create a new table row with the course details
                var row = `<tr>
                    <td>${course.courseId}</td> <!-- Course ID -->
                    <td>${course.courseName}</td> <!-- Course Name -->
                    <td>${course.trainer}</td> <!-- Trainer Name -->
                    <td>${course.durationInWeeks}</td> <!-- Duration in weeks -->
                </tr>`;
                dataTable.innerHTML += row; // Append the row to the table body (courseTable)
            });
        })
        .catch((error) => { // Handle errors if the fetch fails
            console.error('Error fetching courses:', error);
        });
}

// Function to display enrolled students
function showEnrolledStudents() {
    // Fetching the enrolled students data from the backend API (http://localhost:8080/courses/enrolled)
    fetch("http://localhost:8080/courses/enrolled")
        .then((response) => response.json()) // Convert the response to JSON
        .then((students) => { // Once the data is received, we loop through the students
            const dataTable = document.getElementById("studentTable"); // Get the table element where data will be displayed
            students.forEach(student => { // Loop over each student
                // Create a new table row with the student's details
                var row = `<tr>
                    <td>${student.name}</td> <!-- Student's Name -->
                    <td>${student.emailId}</td> <!-- Student's Email ID -->
                    <td>${student.courseName}</td> <!-- Course Name -->
                </tr>`;
                dataTable.innerHTML += row; // Append the row to the table body (studentTable)
            });
        })
        .catch((error) => { // Handle errors if the fetch fails
            console.error('Error fetching enrolled students:', error);
        });
}

// Wait until the DOM is fully loaded
document.addEventListener("DOMContentLoaded", function () {
    // Get the registration form element
    const form = document.getElementById("registrationForm");
    // Get the div to show response messages (if you were showing it on the same page)
    const responseDiv = document.getElementById("responseMessage");

    // Add a submit event listener to the form
    form.addEventListener("submit", function (event) {
        // Prevent default form submission behavior (which reloads the page)
        event.preventDefault();

        // Gather form data into FormData object
        const formData = new FormData(form);

        // Send the form data to the backend using Fetch API (POST request)
        fetch("http://localhost:8080/courses/register", {
            method: "POST",
            body: new URLSearchParams(formData) // Convert to URL-encoded format
        })
        .then(response => response.json()) // Parse response as JSON
        .then(data => {
            // Save the success message into sessionStorage so it can be accessed on the next page
            sessionStorage.setItem("registrationMessage", data.message);

            // Redirect to success page
            window.location.href = "register-success.html";

            // (Optional: you could show it on the same page instead of redirecting)
            // responseDiv.textContent = data.message;
            // responseDiv.style.display = "block";
        })
        .catch(error => {
            // Handle any error during fetch (e.g. server down, network issue)
            alert("An error occurred. Please try again later.");
            console.error("Error: ", error);

            // Optional: show message in the responseDiv instead
            // responseDiv.textContent = "An error occurred. Please try again later.";
            // responseDiv.style.display = "block";
        });
    });
});

// This part will run on the success page (register-success.html)
document.addEventListener("DOMContentLoaded", function () {
    // Retrieve the message from sessionStorage
    const message = sessionStorage.getItem("registrationMessage");

    // Get the box element where we will display the message
    const box = document.getElementById("messageBox");

    // If a message was found in sessionStorage
    if (message) {
        box.textContent = message;         // Show the message
        box.style.display = "block";       // Make the message box visible
        sessionStorage.removeItem("registrationMessage"); // Clear it after use
    } else {
        // If no message was found, show a fallback message
        box.textContent = "No registration message found.";
        box.style.display = "block";
    }
});
