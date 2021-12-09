function validateEmpty() {
    const userName=document.getElementById("name");
    const userEmail=document.getElementById("email");
    const userPassword=document.getElementById("password");
    const userPassword2=document.getElementById("password2");
    const regEx=/^([\da-z_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;

    
    if (userName.value.length==0 && userEmail.value.length==0 && userPassword.value.length==0 && userPassword2.value.length==0) {
        alert("Debe digitar los datos requeridos.")
        return 0;
    } else if (userName.value.length==0) {
        alert("Debe digitar su nombre.")
        userName.focus()
        return 0;
    } else if (userEmail.value.length==0) {
        alert("Debe digitar Un correo Electrónico.")
        userEmail.focus()
        return 0;
    } else if (regEx.test(userEmail.value)==false) {
        alert("Debe digitar un correo Electrónico válido, ejemplo@ejemplo.com. ")
        userEmail.focus()
        return 0;
    } else if (userPassword.value.length==0) {
        alert("Debe digitar una contraseña.")
        userPassword.focus()
        return 0;
    } else if (userPassword2.value.length==0) {
        alert("Debe digitar la confirmación de contraseña.")
        userPassword2.focus()
        return 0;
    } else if (userPassword.value.length<6) {
        alert("La contraseña debe tener minimo 6 caracteres.")
        userPassword2.focus()
        return 0;
    } else if (userPassword.value!=userPassword2.value) {
        alert("las contraseñas no coinciden")
        userPassword.focus()
        return 0;
    } else {
        userExist(userEmail.value,userPassword.value)

    }
    function userExist (email,password){

        $.ajax({

            dataType: "json",
            url:"http://129.151.122.220/api/user/"+email+"/"+password,
            type:"GET",
            success: function(response){

                console.log(response);
                var userData = response.name;
                if(userData == "NO DEFINIDO"){
                    postUser();
                    return 0;
                } else{
                    alert("Ya existe un usuario asociado a ese correo y contraseña ")
                    return 0;
                }
            },
            error: function(jqXHR, textStatus, errorThrown){

            }
        });

    }

}
function postUser (){
    var data={

        email:$("#email").val(),
        password:$("#password").val(),
        name:$("#name").val(),
    }
    var dataTosend =JSON.stringify(data);

    $.ajax({

        dataType: "json",
        data:dataTosend,
        contentType:"application/json",
        url:"http://129.151.122.220/api/user/new",
        type:"POST",
        success: function(response){
            console.log(response);

            if (response.name == $("#name").val()){
                alert("Cuenta creada satisfactoriamente ")
                return 0;
            } else {
                alert("No fue posible crear la cuenta")
                return 0;
            }
            },
        error: function(jqXHR, textStatus, errorThrown){

        }
    });
}
