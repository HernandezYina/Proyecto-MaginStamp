/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*------------------------
 INICIAMOS WOW
 -------------------------*/
/* global smoothScroll */

new WOW().init();

/*----------------------------------
 Iniciamos smoothScroll (Scroll Suave)
 
$('a').click(function(e){
	e.preventDefault();
  $('html, body').stop().animate({scrollTop: $($(this).attr('href')).offset().top}, 1000);
});
--------------------------------*/
/*---------------------------------
 OCULTAR Y MOSTRAR BOTON IR ARRIBA
 ----------------------------------*/
$(function () {
    $(window).scroll(function () {
        var scrolltop = $(this).scrollTop();
        if (scrolltop >= 50) {
            $(".ir-arriba").fadeIn();
        } else {
            $(".ir-arriba").fadeOut();
        }
    });

});
/*---------------------------------
 CABECERA ANIMADA
 ----------------------------------*/
$(window).scroll(function () {

    var nav = $('.encabezado');
    var scroll = $(window).scrollTop();

    if (scroll >= 80) {
        nav.addClass("fondo-menu");
    } else {
        nav.removeClass("fondo-menu");
    }
});


/*---------------------------------
 VALIDACIONES
 ----------------------------------*/
(function () {
    'use strict';
    window.addEventListener('load', function () {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();


/*---------------------------------
 CARROUSEL
 ----------------------------------*/
$('.owl-carousel').owlCarousel({
    loop: true,
    margin: 0,
    nav: true,
    autoWidth: false,
    navText: ['<div class="container" style="font-size: 3rem"><i class="fa fa-arrow-circle-left text-info" title="Anterior"></i>', '<i class="fa  fa-arrow-circle-right text-info" title="Siguiente" style="font-size: 3rem"></i></div>'],
    responsive: {
        0: {
            items: 1
        },
        500: {
            items: 2,
            margin: 20
        },
        800: {
            items: 3,
            margin: 20
        },
        1000: {
            items: 4,
            margin: 20
        }
    }
});

/*---------------------------------
 TOOLTIPS
 ----------------------------------*/

$(function () {
  $('[data-toggle="tooltip"]').tooltip()
});


