/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function ltrim(texto) {
    return texto.replace(/^[ ]+/, '');
}

function rtrim(texto) {
    return texto.replace(/[ ]+$/, '');
}

function trim(texto) {
    return ltrim(rtrim(texto));
}

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
     
    erMail = /^\w+@\w+\.\w{2,4}\b(\.\w+)?\b$/;
    vMail();
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

function inserirUsuario(){
    var erMail, erNome, erSenha;
    erMail = /^[\w]+@[\w]+\.[\w]{2,4}\b(\.[\w]+)?\b$/;
    erNome = /^[\w]+$/;
    erSenha = /^.+$/;
    
    var nome, email, senha, rsenha;
    
    nome = trim(document.getElementById("nome").value);
    email = trim(document.getElementById("cemail").value);
    senha = trim(document.getElementById("pass").value);
    rsenha = trim(document.getElementById("rpass").value);

    if(nome.match(erNome)==null){
        alert("Nome inválido!");
        return false;
    }
    else if(email.match(erMail)==null){
        alert("Email inválido!");
        return false;
    }   
    else if(senha.match(erSenha) == null){
        alert("Senhas inválidas!");
        return false;
    }
    else if(rsenha != senha ){
        alert("As senhas não coincidem!");
        return false;
    }else
        return alert("Cadastro solicitado com sucesso!");
    
    
}