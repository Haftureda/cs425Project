// $(document).ready(function () {
//     $("#lookup").click(function(){
//         var word = $("#word").val();
//         $.ajax({
//             url: "dictServlet",
//             data: {word:word},
//             type: "POST",
//             dataType: "JSON",
//             success: function (data2) {
//                 // alert(data2[0].definition);
//                 var myData="\n";
//                    for(i=0;i<data2.length;i++){
//                    var p=data2[i];
//                        myData+="<tr><td> "+ (i+1) +"(" +p.wordtype +")::  "+p.definition+"</td></tr>";
//                       }
//                     $('#content').html(myData);
//                     },
//                   error: function (data2) {
//                 alert("Failed" + data2.toString());
//             }
//         });
//     });
// });

    $(document).ready(function () {
        $('#btn_submit').on("click",function (e) {
            e.preventDefault();
            var productName, productPrice;
            productName = $('#product_name').val();
            productPrice = $('#product_price').val();
            if($.trim(productName) === ""){
                alert("Product name cannot be empty");
            }
            else if(!$.trim($.isNumeric(productPrice))){
                alert("Price must be numeric");
            }
            else {
                var data = {};
                data["productName"] = productName;
                data["productPrice"] = productPrice;
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "/saveproduct",
                    data: JSON.stringify(data),
                    dataType: 'json',
                    timeout: 6000,
                    success: function (data) {
                        if (confirm("Product with Id " +data + " Saved")){
                            window.location.reload();
                        }
                    }
                });
            }
        });
    });
