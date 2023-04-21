async function loadAllProduct(){
    var roles = localStorage.getItem("roles");
    var url = 'http://localhost:8080/api/products/all';
    const response = await fetch(url, {
        method: 'GET',
        headers: new Headers({
        })
    });
    var listpro = await response.json();
    var main = ''

    for(i=0; i< listpro.length; i++){
        var action = '<i class="fa fa-edit" onclick="loadProduct('+listpro[i].id+')" data-toggle="modal" data-target=".bd-example-modal-lg"></i><br><br>'+
            '<i class="fa fa-trash" onclick="deletePro('+listpro[i].id+')"></i>'
        if(roles == 'USER'){
            action = '<i onclick="addcart('+listpro[i].id+')" class="fa fa-shopping-cart"></i>'
        }
        main +=
            `<tr>
            <td>${listpro[i].id}</td>
            <td>${listpro[i].name}</td>
            <td>${listpro[i].brand}</td>
            <td>${listpro[i].color}</td>
            <td>${listpro[i].price}</td>
            <td>${action}</td>
        </tr>`
    }
    document.getElementById("listpro").innerHTML = main
}

async function search(){
    var roles = localStorage.getItem("roles");
    var name = document.getElementById("namesearch").value
    var brand = document.getElementById("brandsearch").value
    var color = document.getElementById("colorsearch").value
    var cateogry = document.getElementById("listcategory").value
    var pricesmal = document.getElementById("pricesmal").value
    var pricelager = document.getElementById("pricelager").value
    var search = {
        "name":name,
        "fromPrice":pricesmal,
        "toPrice":pricelager,
        "brand":brand,
        "color":color,
        "categoryId": cateogry
    }
    var url = 'http://localhost:8080/api/products/search';
    const response = await fetch(url, {
        method: 'POST',
        headers: new Headers({
            'Content-Type': 'application/json'
        }),
        body: JSON.stringify(search)
    });
    var listpro = await response.json();
    var main = ''

    for(i=0; i< listpro.length; i++){
        var action = '<i class="fa fa-edit" onclick="loadProduct('+listpro[i].id+')" data-toggle="modal" data-target=".bd-example-modal-lg"></i><br><br>'+
            '<i onclick="deletePro('+listpro[i].id+')" class="fa fa-trash"></i>'
        if(roles == 'USER'){
            action =
                '<i onclick="addcart('+listpro[i].id+')" class="fa fa-shopping-cart"></i>'
        }
        main +=
            `<tr>
            <td>${listpro[i].id}</td>
            <td>${listpro[i].name}</td>
            <td>${listpro[i].brand}</td>
            <td>${listpro[i].color}</td>
            <td>${listpro[i].price}</td>
            <td>${action}</td>
        </tr>`
    }
    document.getElementById("listpro").innerHTML = main
}

async function loadCategory(){
    var url = 'http://localhost:8080/api/categories';
    const response = await fetch(url, {
        method: 'GET',
        headers: new Headers({
        })
    });
    var listcategory = await response.json();
    var mains = '';
    for (i = 0; i < listcategory.length; i++) {
        mains += '<option value="'+listcategory[i].id+'">'+listcategory[i].name+'</option>'
    }
    document.getElementById("listcategory").innerHTML = mains
    document.getElementById("listcateadd").innerHTML = mains
}

async function deletePro(id){
    var url = 'http://localhost:8080/api/products/'+id;
    const response = await fetch(url, {
        method: 'DELETE',
        headers: new Headers({
        })
    });
    if(response.status == 500){
        swal({title: "Thông báo", text: "Xóa thất bại!", type: "warning"},
            function(){
                return;
            });

    }
    else if(response.status < 300){
        swal({title: "Thông báo", text: "Xóa thành công!", type: "success"},
            function(){
                window.location.reload()
            });
    }
}

async function loadProduct(id){
    var url = 'http://localhost:8080/api/products/findById?id='+id;
    const response = await fetch(url, {
        method: 'GET',
        headers: new Headers({
        })
    });
    var pro = await response.json();
    console.log(pro)
    document.getElementById("idpro").value = id
    document.getElementById("name").value = pro.name
    document.getElementById("brand").value = pro.brand
    document.getElementById("color").value = pro.color
    document.getElementById("price").value = pro.price
    document.getElementById("listcateadd").value = pro.categoryId
}

function clearInputProduct(){
    document.getElementById("idpro").value = ""
    document.getElementById("name").value = ""
    document.getElementById("brand").value = ""
    document.getElementById("color").value = ""
    document.getElementById("price").value = ""
}

async function addproduct(){
    var id = document.getElementById("idpro").value
    var name = document.getElementById("name").value
    var brand = document.getElementById("brand").value
    var color = document.getElementById("color").value
    var price = document.getElementById("price").value
    var categoryId = document.getElementById("listcateadd").value
    var product = {
        "id":id,
        "name":name,
        "price":price,
        "brand":brand,
        "color":color,
        "categoryId":categoryId
    }
    var url = 'http://localhost:8080/api/products';
    const response = await fetch(url, {
        method: 'POST',
        headers: new Headers({
            'Content-Type': 'application/json'
        }),
        body: JSON.stringify(product)
    });
    if(response.status < 300){
        swal({title: "Thông báo", text: "Thêm/ sửa sản phẩm thành công!", type: "success"},
            function(){
                window.location.reload()
            });
    }
    else{
        swal({title: "Thông báo", text: "Thêm/ sửa sản phẩm thất bại!", type: "error"},
            function(){
            });
    }
}

function loadInit(){
    var username = localStorage.getItem("username");
    var role = localStorage.getItem("roles");
    document.getElementById("username").innerText = ' '+username
    if(role == 'ADMIN'){
        document.getElementById("mycart").innerText = ''
    }
    if(role == 'USER'){
        document.getElementById("btnadd").style.display = 'none'
    }
}

async function addcart(id) {
    var url = 'http://localhost:8080/api/products/findById?id='+id;
    const res = await fetch(url, {
        method: 'GET',
        headers: new Headers({
        })
    });
    var pro = await res.json();
    var cart = {
        "productId":pro.id,
        "productName":pro.name,
        "productCost":pro.price,
        "ordered":false
    }
    var username = localStorage.getItem("username");
    var url = 'http://localhost:8080/api/carts/add?username='+username;
    const response = await fetch(url, {
        method: 'POST',
        headers: new Headers({
            'Content-Type': 'application/json'
        }),
        body: JSON.stringify(cart)
    });
    if(response.status == 500){
        swal({title: "Thông báo", text: "Sản phẩm đã được thêm vào giỏ hàng trước đó!", type: "warning"},
            function(){
                return;
            });

    }
    else if(response.status < 300){
        swal({title: "Thông báo", text: "Đã thêm sản phẩm vào giỏ hàng!", type: "success"},
            function(){
                window.location.reload()
            });
    }
}

async function loadcart() {
    var username = localStorage.getItem("username");
    var url = 'http://localhost:8080/api/carts/order/'+username
    const res = await fetch(url, {
        method: 'GET',
        headers: new Headers({
        })
    });
    var carts = await res.json();
    console.log(carts)
    var main = ''
    for(i=0; i< carts.length; i++){
        main +=
            `<tr>
            <td>${carts[i].productId}</td>
            <td>${carts[i].productName}</td>
            <td>${carts[i].productCost}</td>
            <td><i class="fa fa-trash" onclick="deleteCartItem(${carts[i].id})"></i></td>                      
        </tr>`
    }
    document.getElementById("listcart").innerHTML = main
}

async function deleteCartItem(id){
    var url = 'http://localhost:8080/api/carts/'+id;
    const response = await fetch(url, {
        method: 'DELETE',
        headers: new Headers({
        })
    });
    if(response.status == 500){
        swal({title: "Thông báo", text: "Xóa thất bại!", type: "warning"},
            function(){
                return;
            });

    }
    else if(response.status < 300){
        swal({title: "Thông báo", text: "Đã xoá sản phẩm khỏi giỏ hàng !", type: "success"},
            function(){
                loadcart();
            });
    }
}

