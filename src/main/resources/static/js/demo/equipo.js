$(document).ready(function() {

    cargarEquipos()

  $('#equipos').DataTable();
});

async function cargarEquipos(){
  try {
    const request = await fetch('api/Equipo', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });

    if (!request.ok) {
      throw new Error('Error al cargar equipos');
    }

    const equipos = await request.json();
    console.log(equipos);




    let ListaHtml = '';
    for(let equipo of equipos){
     let botonEliminar = '<a href="#" onclick="eliminarEquipo('+equipo.sn+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';


    let equipoHtml ='<tr><td>'+equipo.sn+'</td><td>'+equipo.marca+'</td><td>'+equipo.procesador+'</td><td>'+equipo.ram+'</td><td>'+equipo.sistema+'</td><td>'+equipo.disco+'</td><td>'+equipo.puertos+'</td><td>'+botonEliminar+'</td><td>     <a href="#" class="btn btn-success btn-circle btn-sm"> <i class="fas fa-pencil-alt"></i></a></td><tr>';

     ListaHtml += equipoHtml;
    }

document.querySelector('#equipos tbody').outerHTML = ListaHtml;


// Inicializar la tabla DataTables
         $('#equipos').DataTable();
       } catch (error) {

}
}

async function eliminarEquipo(sn){

if (!confirm('¿Desea eleminar este Equipo?')) {
return;
}

 const request = await fetch('api/Equipo/' + sn, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
      });
      alert("Borrado correctamente")
       location.reload()

}
