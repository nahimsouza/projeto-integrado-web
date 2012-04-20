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
"Faz a consulta avançada entre 2 tipos diferentes ", // element 1
"Selecione o que deseja inserir", // element 2
"Clique aqui para inserir uma nova entidade", // element 3
"Clique aqui para inserir uma nova categoria", // element 4
"Clique aqui para inserir um novo tipo", // element 5
"Selecione a operação", // element 6
"Abre a tela de requisições de novos colaboradores",// element 7
"Abre a lista de todos colaboradores para exclusão",// element 8
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



function buscaSimples(){
    var palavra;
        palavra = document.getElementById("palavra").value;
    var pal = document.getElementById("resultado");

    
    var html = "<html>" 
        + "<head>"
        + "<script type = 'text/javascript' src='javascript.js'></script>"
        + "</head>"
        + "<body>"
        + "<table id='myTable' border='1'>"
        + "<tr>"
        +"<td>Display Name</td>"
        +"<td>Description</td>"
        +"<td>Wikikeys</td>"
        +"<td>Categoria</td>"
        +"<td>Tipo</td>"
    
        +"</tr>"
        +"<tr>"
        +"<td>The Sound of Music</td>"
        +"<td>...</td>"
        +"<td>\n</td>"
        +"<td>music,common</td>"
        +"<td>/common/topic, /music/single </td>"
        +"<td><input type='button' value='Delete' onclick='deleteRow(this.parentNode.parentNode.rowIndex)'></td>"
        +"<td><input type='button' value='Alterar' onclick='alterarEntidade(1);'></td>"
        +"</tr>"
        +"<tr>"
        +"<td>Music to See</td>"
        +"<td>Music to See is a Canadian music educational television miniseries which aired on CBC Television in 1957.\nHelmut Blume presented this televised course on aspects of music such as electronic music, how opera is associated with drama and the conductor's role.\nOhio University presented Music to See with an award for educational broadcasting.\nThis half-hour series was broadcast Tuesdays at 10:30 p.m. (Eastern) from 3 September to 29 October 1957.</td>"
        +"<td>/wikipedia/en_id/28377018</td>"
        +"<td>tv,common</td>"
        +"<td>/tv/tv_program,/common/topic</td>"
        +"<td><input type='button' value='Delete' onclick='deleteRow(this.parentNode.parentNode.rowIndex)'></td>"
        +"<td><input type='button' value='Alterar'></td>"
        +"</tr>"
        +"<tr>"
        +"<td>Electronic Music Laboratories</td>"
        +"<td>Electronic Music Laboratories, commonly abbreviated to EML, was an audio synthesizer company. Founded in 1968 in Vernon, Connecticut by four former engineers, the company manufactured and designed a variety of synthesizers sharing the same basic design but configured in different ways.\nThe company originated by accident, after Dale Blake, Norman Millard, Dennis Daugherty, and Jeff Murray, employees of Gerber Scientific, founded the company in order to ensure that they all continued to have a job following an impending layoff. Following the schematics of a fellow audio engineer, Fred Locke, the four made synthesizers that directly competed with those of Moog Music and ARP. Although their synthesizers were not as sophisticated or capable as those designed by Bob Moog or Alan R. Pearlman, they were marketed as being much more reliable, which was true due to their use of op-amps instead of transistors.\nAlthough the company stopped manufacturing synthesizers in 1976, following the departure of two of their employees, the company continued to operate until 1984, designing and manufacturing products for others and repairing their synthesizers.\nSynthesizer modules were also available,</td>"
        +"<td>/wikipedia/en_id/4319270</td>"
        +"<td>common</td>"
        +"<td>/common/topic</td>"
        +"<td><input type='button' value='Delete' onclick='deleteRow(this.parentNode.parentNode.rowIndex)'></td>"
        +"<td><input type='button' value='Alterar'></td>"
        +"</tr>"
        +"</table>"
        +"</body>"
        +"</html>";
    
 
    
    if(palavra == "music" ){
        pal.innerHTML=html;
    }else{
        pal.innerHTML="Nenhum resultado encontrado.";
    }

}


function deleteRow(i){
    document.getElementById('myTable').deleteRow(i)
}



function buscaUsuario(){
    var palavra;
        palavra = document.getElementById("palavra").value;
    var pal = document.getElementById("resultado");

    var html = "<html>" 
        + "<head>"
        + "<script type = 'text/javascript' src='javascript.js'></script>"
        + "</head>"
        + "<body>"
        + "<table id='myTable' border='1'>"
        + "<tr>"
        +"<td>Nome</td>"
        +"<td>Email</td>"
        
    
        +"</tr>"
        +"<tr>"
        +"<td> Nahim Alves de Souza</td>"
        +"<td> nahimsouza@yahoo.com.br </td>"
        +"<td><input type='button' value='Delete' onclick='deleteRow(this.parentNode.parentNode.rowIndex)'></td>"
        +"</tr>"
        +"<tr>"
        +"<td>Francisco Guiraldelli</td>"
        +"<td> francisco.guiraldelli@gmail.com </td>"
        +"<td><input type='button' value='Delete' onclick='deleteRow(this.parentNode.parentNode.rowIndex)'></td>"
        +"</tr>"
        +"<tr>"
        +"<td>Erico Alexandre Nielsen Matthiesen</td>"
        +"<td>erico.matt@gmail.com</td>"
        +"<td><input type='button' value='Delete' onclick='deleteRow(this.parentNode.parentNode.rowIndex)'></td>"
        +"</tr>"
        +"</table>"
        +"</body>"
        +"</html>";
    
    var html2 = "<html>" 
        + "<head>"
        + "<script type = 'text/javascript' src='javascript.js'></script>"
        + "</head>"
        + "<body>"
        + "<table id='myTable' border='1'>"
        + "<tr>"
        +"<td>Nome</td>"
        +"<td>Email</td>"
        +"</tr>"
        +"<tr>"
        +"<td>Erico Alexandre Nielsen Matthiesen</td>"
        +"<td>erico.matt@gmail.com</td>"
        +"<td><input type='button' value='Delete' onclick='deleteRow(this.parentNode.parentNode.rowIndex)'></td>"
        +"</tr>"
        +"</table>"
        +"</body>"
        +"</html>";
 
    
    if(palavra == "Erico" ){
        pal.innerHTML=html2;
    }else{
        pal.innerHTML=html;
    }

}


function buscaAvancada(){
    var tipoP, tipoNP;
        
        tipoP = document.getElementById("tipoP").value;
        tipoNP = document.getElementById("tipoNP").value;
        
    var pal = document.getElementById("resultadoAvancado");

    
    var html = "<html>" 
        + "<head>"
        + "<script type = 'text/javascript' src='javascript.js'></script>"
        + "</head>"
        + "<body>"
        +"<p> 3 Entidades encontradas </p>"
        + "<table id='myTable' border='1'>"
        + "<tr>"
        +"<td>Display Name</td>"
        +"<td>Tipo</td>"
    
        +"</tr>"
        +"<tr>"
        +"<td>The Sound of Music</td>"
        +"<td>/common/topic, /music/single </td>"
        +"<td><input type='button' value='Delete' onclick='deleteRow(this.parentNode.parentNode.rowIndex)'></td>"
        +"<td><input type='button' value='Alterar'></td>"
        +"</tr>"
        
        +"<tr>"
        +"<td>Music to See</td>"
        +"<td>/tv/tv_program,/common/topic</td>"
        +"<td><input type='button' value='Delete' onclick='deleteRow(this.parentNode.parentNode.rowIndex)'></td>"
        +"<td><input type='button' value='Alterar'></td>"
        +"</tr>"
        
        +"<tr>"
        +"<td>Electronic Music Laboratories</td>"      
        +"<td>/common/topic</td>"
        +"<td><input type='button' value='Delete' onclick='deleteRow(this.parentNode.parentNode.rowIndex)'></td>"
        +"<td><input type='button' value='Alterar'></td>"
        +"</tr>"
        +"</table>"
        +"</body>"
        +"</html>";
    
 
    if(tipoP == "music" && tipoNP == "history"){
        pal.innerHTML=html;
    }else{
        pal.innerHTML="Nenhum resultado encontrado.";
    }

}


function alterarEntidade(i){
    alert("entrei");
    
    var displayname, descricao, wikikeys, categoria, tipo;
    
    var x=document.getElementById('myTable').rows[i].cells;
    
    v = new Array(5);
    
    for(i=0;i<5;i++)
        v[i] = x[i].innerHTML;

    abrirPag("iEntidade.html");
        
        preencheEntidade(v);
}


function preencheEntidade(v){
    
    alert("to entrando devagarzinho");
    
        alert(document.getElementById("conteudo"));
    
    alert("preenchi tudo");
}

function user(i){
    if(i==1)
        alert("Adicionado como colaborador.");
    else
        alert("Colaborador rejeitado.");
}