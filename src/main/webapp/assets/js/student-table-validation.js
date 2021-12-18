window.onload = fetch_students;
async function fetch_students(){
    let response = await fetch("api/courses/getstudents/"+sessionStorage.getItem("course_id"),
        {method: 'GET'}
    );
    let students = await response.json(); // read response body and parse as JSON
    console.log(students);
    let courses_option = document.getElementById('students');
    courses_option.innerHTML = '<tr>\n' +
        '                            <th>Roll Number</th>\n' +
        '                            <th>Name</th>\n' +
        '                            <th>Email</th>\n' +
        '                            <th>CGPA</th>\n' +
        '                            <th>Total Credits</th>\n' +
        '                            <th>Graduation Year</th>\n' +
        '                            <th>Grade</th>\n'+
        '                        </tr>';

    for(let i = 0 ; i<students.length ; i++){
        courses_option.innerHTML += '<tr><td>'+students[i].rollnumber+'</td><td>'+students[i].name+'</td><td>'+students[i].email+'</td><td>'+students[i].cgpa+'</td><td>'+students[i].totalCredits+'</td><td>'+students[i].graduationYear+'</td><td>'+students[i].grade+'</td></tr>';
    }
}