
let choose_schedule_form = document.getElementById('choose-schedule');
choose_schedule_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();

    sessionStorage.setItem("term",document.getElementById("term").value);
    sessionStorage.setItem("year",document.getElementById("year").value);
    location.href = "viewTimetable.html";


});