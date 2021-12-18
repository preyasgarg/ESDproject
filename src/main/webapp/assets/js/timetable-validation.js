window.onload = fetch_schedule;
async function fetch_schedule(){
    let response = await fetch('api/courses/getschedule/'+sessionStorage.getItem("id")+'/values?year='+sessionStorage.getItem("year")+'&term='+sessionStorage.getItem("term"), {
        method: 'GET',

    });

    try{
        let result = await response.json();
        console.log(result);
        console.log(response);


    let table = document.getElementById('schedule');
    table.innerHTML = '<tr><th></th><th>MON</th><th>TUE</th><th>WED</th><th>THU</th><th>FRI</th></tr>';


        table.innerHTML += '<tr><th>9 AM to 11 AM</th><td>'+result[0].MON+'</td><td>'+result[0].TUE+'</td><td>'+result[0].WED+'</td><td>'+result[0].THU+'</td><td>'+result[0].FRI+'</td></tr>' +
            '<tr><th>11 AM to 1 PM</th><td>'+result[1].MON+'</td><td>'+result[1].TUE+'</td><td>'+result[1].WED+'</td><td>'+result[1].THU+'</td><td>'+result[1].FRI+'</td></tr>' +
            '<tr><th>2 PM to 4 PM</th><td>'+result[2].MON+'</td><td>'+result[2].TUE+'</td><td>'+result[2].WED+'</td><td>'+result[2].THU+'</td><td>'+result[2].FRI+'</td></tr>' +
            '<tr><th>4 PM to 6 PM</th><td>'+result[3].MON+'</td><td>'+result[3].TUE+'</td><td>'+result[3].WED+'</td><td>'+result[3].THU+'</td><td>'+result[3].FRI+'</td></tr>';

    }catch(err){
        document.getElementById("login-alert").style.display = "block";
    }

}