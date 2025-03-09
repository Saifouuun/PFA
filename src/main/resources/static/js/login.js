let btn = document.getElementById('btn');
btn.addEventListener('click' ,verif);
function verif(event){
    
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    if(username == '' || password==''){
        alert("erreur");
    }
    
};
