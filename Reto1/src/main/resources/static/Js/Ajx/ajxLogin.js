function emailExist (email){

    $.ajax({

        dataType: "json",
        url:"http://localhost:8080/api/user/"+email,
        type:"GET",
        success: function(response){

            console.log(response);

        },
        error: function(jqXHR, textStatus, errorThrown){

        }
    });
}