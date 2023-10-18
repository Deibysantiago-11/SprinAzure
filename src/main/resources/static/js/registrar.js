$(document).ready(function() {

});

async function registrarUsuarios(){
    let datos = {};
    datos.id =  document.getElementById('txtId').value;
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.documento = document.getElementById('txtDocumento').value;
    datos.genero = document.getElementById('txtGenero').value;
    datos.nacionalidad = document.getElementById('txtNacionalidad').value;
    datos.direccion = document.getElementById('txtDireccion').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.telefono = document.getElementById('txtTelefono').value;


    const request = await fetch('api/usuarios', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(datos)
    });
    alert("Agregado Correctamente")
           location.reload()
}

