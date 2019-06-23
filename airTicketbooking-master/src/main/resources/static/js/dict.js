// $(document).ready(function () {
//     $("#add").click(function(){
//
//         var airportCode = $("#airportCode").val();
//         var airportName = $("#airportName").val();
//         var city = $("#city").val();
//         var country = $("#country").val();
//
//         $.ajax({
//             url: "/airport",
//             data: {airportCode:airportCode,airportName:airportName, city:city,country:country},
//             type: "POST",
//             dataType: "JSON",
//             success: function (data2) {
//                 // alert(data2[0].definition);
//                 var myData="\n";
//                 for(i=0;i<data2.length;i++){
//                     var airport=data2[i];
//                     myData+="<tr><td> "+ (i+1) +"(" +airport.airportCode +")::  "+airport.airportName+"</td></tr>";
//                 }
//                 $('#airportlist').html(myData);
//             },
//             error: function (data2) {
//                 alert("Failed" + data2.toString());
//             }
//         });
//     });
// });


$(document).ready(function () {
    $('#add').on("click",function (e) {
        // e.preventDefault();
        var airportCode = $('#airportCode').val();
        var airportName = $('#airportName').val();
        var city = $('#city').val();
        var country = $('#country').val();
        var data = {};
        data["airportCode"] = airportCode;
        data["airportName"] = airportName;
        data["city"] = city;
        data["country"] = country;
        $.ajax({
            type: "POST",
            contentType: "json",
            url: "/airport",
            data: JSON.stringify(data),
            dataType: 'json',
            timeout: 6000,
            success: function (data) {
                if (confirm("Airport with Id " +data + " Saved")){
                    window.location.reload();
                }
            }
        });
    });
});
