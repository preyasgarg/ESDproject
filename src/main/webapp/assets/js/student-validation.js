let course_form = document.getElementById('course-validation');
window.onload = fetch_courses;
async function fetch_courses(){
    let response = await fetch("api/courses/get/"+sessionStorage.getItem("id"),
        {method: 'GET'}
        );
    let courses = await response.json(); // read response body and parse as JSON
    console.log(courses);
    let courses_option = document.getElementById('courses');
    courses_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i<courses.length ; i++){
        courses_option.innerHTML += '<option value="'+courses[i].id+'">'+courses[i].name+'</option>';
    }
}

let form = document.getElementById('choose-course');

form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    sessionStorage.setItem("course_id",document.getElementById("courses").value);
    location.href = "studentsTable.html";
});