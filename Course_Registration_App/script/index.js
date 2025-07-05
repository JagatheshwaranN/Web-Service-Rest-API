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
