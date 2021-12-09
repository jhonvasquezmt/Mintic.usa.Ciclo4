function delAdmin (idItem){
    var dataDel={
        id:idItem,

    }
    var dataTosend =JSON.stringify(dataDel);

    $.ajax({

        dataType: "json",
        data:dataTosend,
        contentType:"application/json",
        url:"http://129.151.122.220:8080/api/Admin",
        type:"DELETE",
        success: function(response){
            console.log(response);
        },
        error: function(jqXHR, textStatus, errorThrown){

        }
    });
}