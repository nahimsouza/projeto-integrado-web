/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var helpArray = 
["Faz a consulta da entidade que você quer procurar", // element 0
"Escreva aqui o nome ao qual gostaria de ser chamado. ", // element 1
"Digite aqui o seu primeiro nome, ou pressione a tecla \"TAB\".", // element 2
"Digite aqui o seu sobrenome.", // element 3
"Digite aqui o seu CPF.", // element 4
"Digite aqui seu RG.", // element 5
"Digite aqui o dia do seu Nascimento.", // element 6
"Digite aqui o mês do seu Nascimento.",// element 7
"Digite aqui o ano do seu Nascimento.",// element 8
"Selecione o seu sexo.",// element 9
"Digite aqui a sua nova senha.",// element 10
"Repita aqui a senha que você digitou no campo anterior",// element 11
"" ]; // element 12
// -->
function helpText(messageNum)
{
    document.getElementById("tip").innerHTML = helpArray[messageNum];
}

function login(){
    var login, senha, erMail;
    login = document.getElementById("email").value;
    senha = document.getElementById("senha").value;
     
    erMail = /^\w+@\w+\.\w{2,4}\b(\.\w+)?\b$/
    
    if(erMail.test(login)){    
        if(login == "colaborador@email.com"){
            if(senha == "senha"){
                alert("Bem vindo Colaborador!");
                document.location = "colaborador.html";
            }
        }else if(login == "adm@adm.com.br"){
            if(senha == "adm"){
                alert("Bem vindo ADM!");
                document.location = "adm.html";
            }
        }else
            alert("Usuario ou senha inválido!");
    }
    document.getElementById("senha").value = "";
}

function abre(url){
    alert("oi");
    $("conteudo").load('http://9gag.com/');
    alert("tchau");
}

 
 

 function load_content ( id, content ) {
     content = "<html>" +
    "<head> "+
    "    <title></title>"+
    "    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>"+
    "</head>"+
    "<body>"+
    "    <p>"+
    "        Nome: <input type='text' name='display' "+
    "    </p>"+
    "    <p>"+
    "        Descrição: <input type='text' name='description'/>"+
    "    </p>"+
    "</body>"+
"</html>";
    var node = document.getElementById( id );
    node.innerHTML = content;
}


function GetXMLHttp() {
    if(navigator.appName == "Microsoft Internet Explorer") {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    else {
        xmlHttp = new XMLHttpRequest();
    }
    return xmlHttp;
}

var xmlRequest = GetXMLHttp();

function abrirPag(valor){
    var url = valor;

    xmlRequest.onreadystatechange = mudancaEstado;
    xmlRequest.open("GET",url,true);
    xmlRequest.send(null);

    /*if (xmlRequest.readyState == 1) {
        document.getElementById("conteudo_mostrar").innerHTML = "<img src='loader.gif'>";
    }*/

    return url;
}

function mudancaEstado(){
    if (xmlRequest.readyState == 4){
        document.getElementById("conteudo").innerHTML = xmlRequest.responseText;
    }
}


function inserirEntidade(){
    alert("Entidade inserida com sucesso!");
}
function inserirCategoria(){
    alert("Categoria inserida com sucesso!");
}
function inserirTipo(){
    alert("Tipo inserido com sucesso!");
}

function verDados(){
    var erEmail = /^\w+@\w+\.\w{2,4}\b(\.\w+)?\b$/;
    var erNome = /^[\a]+$/;
    
    if(!erNome.test(nome))
        alert("Nome inválido!");
}