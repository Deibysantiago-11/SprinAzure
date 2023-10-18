$(document).ready(function() {

});

async function guardar() {
let datos = {};
datos.sn = document.getElementById('txtSN').value;
datos.marca = document.getElementById('txtMarca').value;
datos.procesador = document.getElementById('txtProcesador').value;
datos.ram = document.getElementById('txtMemoria').value;
datos.sistema = document.getElementById('txtSistema').value;
datos.disco = document.getElementById('txtDisco').value;
datos.puertos = document.getElementById('txtPuertos').value;

    const request = await fetch('api/Equipo', {
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
