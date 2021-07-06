
function mensaje(message, output) {


    if (message === 'on') {
        output.innerHTML = '';
        output.innerHTML += `<i class="fas fa-toggle-on" style="color:green;"></i>`;

        //console.log("esta encendido")
    } else if (message === 'off') {
        output.innerHTML = '';
        output.innerHTML += `<i class="fas fa-toggle-off" style="color:red;"></i>`;
//        console.log("esta apagado")
    }
}


function h() {
    var valor = document.getElementById("seg1verde").innerHTML;
    let output = document.getElementById('verconts1');


    var seg1rojo = document.getElementById('seg1roj').innerHTML;
    let conts1rojo = document.getElementById("conts1rojo");

    var seg1azul = document.getElementById('seg1azul').innerHTML;
    var conts1azul = document.getElementById("conts1azul");

    var seg1blink = document.getElementById('seg1blink').innerHTML;
    var conts1blink = document.getElementById("conts1blink");



    var valor2 = document.getElementById("seg1flashing").innerHTML;
    let output2 = document.getElementById('conts1flash');


    mensaje(valor, output);
    mensaje(seg1rojo, conts1rojo);
    mensaje(seg1azul, conts1azul);

    mensaje(seg1blink, conts1blink);
    mensaje(valor2, output2);
//    
//    
//    console.log(valor);
//    console.log('hola');

}
setInterval(h, 800);

function seg2() {
    var seg2verde = document.getElementById("seg2verde").innerHTML;
    let conts2verde = document.getElementById('conts2verde');

    var seg2rojo = document.getElementById("seg2rojo").innerHTML;
    let conts2rojo = document.getElementById('conts2rojo');

    var seg2azul = document.getElementById("seg2azul").innerHTML;
    let conts2azul = document.getElementById('conts2azul');

    var seg2blink = document.getElementById("seg2blink").innerHTML;
    let conts2blink = document.getElementById('conts2blink');

    var s2flashing = document.getElementById("seg2flashing").innerHTML;
    let conts2flash = document.getElementById('conts2flash');


    mensaje(seg2verde, conts2verde);
    mensaje(seg2rojo, conts2rojo);
    mensaje(seg2azul, conts2azul);
    mensaje(seg2blink, conts2blink);
    mensaje(s2flashing, conts2flash);
}

setInterval(seg2, 800);
function seg3() {
    var seg3verde = document.getElementById("seg3verde").innerHTML;
    let conts3verde = document.getElementById('conts3verde');

    var seg3rojo = document.getElementById("seg3rojo").innerHTML;
    let conts3rojo = document.getElementById('conts3rojo');

    var seg3azul = document.getElementById("seg3azul").innerHTML;
    let conts3azul = document.getElementById('conts3azul');

    var seg3blink = document.getElementById("seg3blink").innerHTML;
    let conts3blink = document.getElementById('conts3blink');

    var s3flashing = document.getElementById("seg3flashing").innerHTML;
    let conts3flash = document.getElementById('conts3flash');


    mensaje(seg3verde, conts3verde);
    mensaje(seg3rojo, conts3rojo);
    mensaje(seg3azul, conts3azul);
    mensaje(seg3blink, conts3blink);
    mensaje(s3flashing, conts3flash);
}

setInterval(seg3, 800);


function seg4() {
    var seg4verde = document.getElementById("seg4verde").innerHTML;
    let conts4verde = document.getElementById('conts4verde');

    var seg4rojo = document.getElementById("seg4rojo").innerHTML;
    let conts4rojo = document.getElementById('conts4rojo');

    var seg4azul = document.getElementById("seg4azul").innerHTML;
    let conts4azul = document.getElementById('conts4azul');

    var seg4blink = document.getElementById("seg4blink").innerHTML;
    let conts4blink = document.getElementById('conts4blink');

    var s4flashing = document.getElementById("seg4flashing").innerHTML;
    let conts4flash = document.getElementById('conts4flash');


    mensaje(seg4verde, conts4verde);
    mensaje(seg4rojo, conts4rojo);
    mensaje(seg4azul, conts4azul);
    mensaje(seg4blink, conts4blink);
    mensaje(s4flashing, conts4flash);
}

setInterval(seg4, 800);

function seg5() {
    var seg5verde = document.getElementById("seg5verde").innerHTML;
    let conts5verde = document.getElementById('conts5verde');

    var seg5rojo = document.getElementById("seg5rojo").innerHTML;
    let conts5rojo = document.getElementById('conts5rojo');

    var seg5azul = document.getElementById("seg5azul").innerHTML;
    let conts5azul = document.getElementById('conts5azul');

    var seg5blink = document.getElementById("seg5blink").innerHTML;
    let conts5blink = document.getElementById('conts5blink');

    var s5flashing = document.getElementById("seg5flashing").innerHTML;
    let conts5flash = document.getElementById('conts5flash');


    mensaje(seg5verde, conts5verde);
    mensaje(seg5rojo, conts5rojo);
    mensaje(seg5azul, conts5azul);
    mensaje(seg5blink, conts5blink);
    mensaje(s5flashing, conts5flash);
}

setInterval(seg5, 800);

function buzzer() {
    var buzzers = document.getElementById("buzzers").innerHTML;
    let buzz = document.getElementById('buzz');

    var buzzerlhz = document.getElementById("buzzerlhz").innerHTML;
    let buzzl = document.getElementById('buzzl');

    var buzzershz = document.getElementById("buzzershz").innerHTML;
    let buzzs = document.getElementById('buzzs');

    


    mensaje(buzzers, buzz);
    mensaje(buzzerlhz, buzzl);
    mensaje(buzzershz, buzzs);
   
}

setInterval(buzzer, 800);

$(document).ready(function () {

    $(".setbtn").click(function () {
        event.preventDefault();
        //alert("The paragraph was clicked.");
        $(".segmentos").removeAttr("hidden")
    });

    $('.verges1').change(function () {
//        console.log('cambio');
//        alert('hola');
    });






});

