let login_form = document.getElementById('login-validation');

login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();

    if (login_form.checkValidity() === true) {
        let response = await fetch('api/faculty/verify', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                email: document.getElementById('email').value,
                password: document.getElementById('password').value
            })
        });

            try{
                let result = await response.json();
                console.log(result);
                console.log(response);
                sessionStorage.setItem("id",result);
                location.href = "dashboard.html";
            }catch(err){
                document.getElementById("login-alert").style.display = "block";
            }



        /*if(result != null){

            /!*location.href = "dashboard.html";*!/
        }else{

        }*/

    }
});