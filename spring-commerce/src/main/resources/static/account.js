async function login() {
    var url = 'http://localhost:8080/api/auth/login'
    var username = document.getElementById("username").value
    var password = document.getElementById("password").value
    var user = {
        "username": username,
        "password": password
    }
    console.log(user)
    const response = await fetch(url, {
        method: 'POST',
        headers: new Headers({
            'Content-Type': 'application/json'
        }),
        body: JSON.stringify(user)
    });
    if(response.status == 500){
        swal({title: "Thông báo", text: "Tài khoản hoặc mật khẩu không chính xác!", type: "warning"},
            function(){
                window.location.reload()
            });

    }
    else if(response.status < 300){
        var user = await response.json();
        window.localStorage.setItem('username', user.username);
        window.localStorage.setItem('roles', user.role);
        window.location.replace('product')
    }
}

async function regis() {
    var url = 'http://localhost:8080/api/auth/signup'
    var username = document.getElementById("username").value
    var password = document.getElementById("password").value
    var user = {
        "username": username,
        "password": password,
        "role":"USER"
    }
    console.log(user)
    const response = await fetch(url, {
        method: 'POST',
        headers: new Headers({
            'Content-Type': 'application/json'
        }),
        body: JSON.stringify(user)
    });
    if(response.status == 500){
        swal({title: "Thông báo", text: "Tài khoản đã tồn tại!", type: "warning"},
            function(){
                return;
            });

    }
    else if(response.status < 300){
        swal({title: "Thông báo", text: "Đăng ký tài khoản thành công!", type: "success"},
            function(){
                window.location.reload()
            });
    }
}

