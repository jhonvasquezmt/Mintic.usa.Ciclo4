//import * as ajxlog from 'Ajx/ajxLogin';


function validateEmpty() {
    const userNick=document.getElementById("userEmail");
    const userPassword=document.getElementById("password");
    const regEx=/^([\da-z_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
    let answer = 0;

    if (userNick.value.length==0 && userPassword.value.length==0) {
        alert("Debe digitar correo electrónico y contraseña.")
        return 0;
    } else if (userNick.value.length==0) {
        alert("Debe digitar un correo electrónico.")
        userNick.focus()
        return 0;
    } else if (regEx.test(userNick.value)==false) {
        alert("Debe digitar un correo Electrónico válido, ejemplo@ejemplo.com.")
        userNick.focus()
        return 0;
    } else if (userPassword.value.length==0) {
        alert("Debe digitar una contraseña.")
        userPassword.focus()
        return 0;
    } else {
        emailExist(userNick.value)
    }


    /*else if (userNick.value.length>0) {
        emailExist(userNick.value)
        userNick.focus()
        return 0;
    } else if (userNick.value.length>0 && userPassword.value.length>0) {
        userExist(userNick.value,userPassword.value)
        return 0;
    }*/



    function emailExist (email){

        $.ajax({

            dataType: "json",
            url:"http://129.151.122.220/api/user/"+email,
            type:"GET",
            success: function(response){

                console.log(response);
                if(response == false){
                    alert("Correo electrónico no existe en el sistema.")
                    return 0;
                } else {
                    userExist(userNick.value,userPassword.value)
                    return 0;
                }
            },
            error: function(jqXHR, textStatus, errorThrown){

            }
        });

    }
    function userExist (email,password){

        $.ajax({

            dataType: "json",
            url:"http://129.151.122.220/api/user/"+email+"/"+password,
            type:"GET",
            success: function(response){

                console.log(response);
                var userData = response.name;
                if(userData === "NO DEFINIDO"){
                    alert("No existe un usuario asociado a ese correo y contraseña ")
                    return 0;
                } else{
                    alert("Bienvenido " + userData)
                    return 0;
                }
            },
            error: function(jqXHR, textStatus, errorThrown){

            }
        });

    }
}