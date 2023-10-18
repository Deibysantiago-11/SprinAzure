$(document).ready(function() {

});

async function guardarAdmin(){
    let subir = {};
    subir.id =  document.getElementById('txtId').value;
    subir.correo = document.getElementById('txtEmail').value;
    subir.password = document.getElementById('txtPassword').value;


    const request = await fetch('api/login/admin', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(subir)
    });
    alert("se registro correctamente")
     window.location.href = 'login.html'
}


