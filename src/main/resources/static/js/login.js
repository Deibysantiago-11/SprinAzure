$(document).ready(function() {
});



async function IniciarSesion(){
    let clave = {};
    clave.id = document.getElementById('txtid').value;
    clave.correo = document.getElementById('txtGmail').value;
   clave.password = document.getElementById('txtPassword').value;


    const request = await fetch('api/login', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(clave)
    });
       const respuesta = await request.text();
       if (respuesta !='FAIL') {
       localStorage.token = respuesta;
       localStorage.correo = clave.correo;
       window.location.href = 'index.html'
    } else {
    alert("Las credenciales son incorrectas");
    }

}