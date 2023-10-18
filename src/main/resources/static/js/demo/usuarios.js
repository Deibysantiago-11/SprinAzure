$(document).ready(function() {

    cargarUsuarios()

  $('#usuarios').DataTable();
  actulizarEmailUsuario();
});

function actulizarEmailUsuario() {
    document.getElementById('txt-correo-admin').outerHTML = localStorage.correo;

}

async function cargarUsuarios(){
  try {
    const request = await fetch('api/usuarios', {
      method: 'GET',
      headers: getHeaders ()
    });

    if (!request.ok) {
      throw new Error('Error al cargar usuarios');
    }

    const usuarios = await request.json();
    console.log(usuarios);




    let ListadoHtml = '';
    for(let usuario of usuarios){
     let botonEliminar = '<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';


    let usuarioHtml ='<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+'</td><td>'+usuario.apellido+'</td><td>'+usuario.documento+'</td><td>'+usuario.genero+'</td><td>'+usuario.nacionalidad+'</td><td>'+usuario.direccion+'</td><td>'+usuario.email+'</td><td>'+usuario.telefono+'</td><td>'+botonEliminar+'</td><tr>';

     ListadoHtml += usuarioHtml;
    }

document.querySelector('#usuarios tbody').outerHTML = ListadoHtml;


// Inicializar la tabla DataTables
         $('#usuarios').DataTable();
       } catch (error) {

}
}

function getHeaders(){
return {
  'Accept': 'application/json',
  'Content-Type': 'application/json'


   };

}

async function eliminarUsuario(id){

if (!confirm('¿Desea eleminar este usuario?')) {
return;
}

 const request = await fetch('api/usuarios/' + id, {
      method: 'DELETE',
      headers: getHeaders ()
      });
      alert("Borrado correctamente")
       location.reload()

}
