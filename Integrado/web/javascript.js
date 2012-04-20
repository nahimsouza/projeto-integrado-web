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
"Entre com o nome da entidade",// element 9
"Descreva a entidade",// element 10
"Digite aqui a wikikey e aperte ok para adicioná-la",// element 11
"", // element 12
"Selecione a categoria",// element 13
"Selecione o tipo e aperte OK para confirmar a Categoria/Tipo",// element 14
"Insira o nome da categoria desejada",// element 15
"Entre com o nome do tipo",// element 16
""];// element 17
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
    var aux = document.getElementById("ncateg").value;
    if(valida(aux)){
        alert("Categoria inserida com sucesso!");
        return;
    }
    alert("Campo inválido!")
    
}
function inserirTipo(){
    var aux = document.getElementById("ntipo").value;
    if(valida(aux)){
        alert("Tipo inserido com sucesso!");
        return;
    }
    alert("Campo inválido!")
    
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
    if(document.getElementById("buscaE").checked)
        buscaEntidade();
    else if(document.getElementById("buscaT").checked)
        buscaTipo();
    else if(document.getElementById("buscaC").checked)
        buscaCategoria();
}

function buscaCategoria(){
    var palavra = document.getElementById("palavra").value;
    var res = document.getElementById("resultado");
    
     var html = "<html>" 
    + "<head>"
    + "<script type = 'text/javascript' src='javascript.js'></script>"
    + "</head>"
    + "<body>"
    + "<table id='myTable' border='1'>"
    + "<tr>"
    +"<td>Categoria</td>"
    +"</tr>"
    +"<tr>"
    +"<td>music</td>"
    +"<td><input type='button' value='Delete' onclick='deleteRow(this.parentNode.parentNode.rowIndex)'></td>"
    +"<td><input type='button' value='Alterar' onclick='alterarCategoria();'></td>"
    +"</tr>"
    +"</table>"
    +"</body>"
    +"</html>";
    
 
    
    if(palavra == "music" ){
        res.innerHTML=html;
    }else{
        res.innerHTML="Nenhum resultado encontrado.";
    }
}

function buscaTipo(){
    var palavra = document.getElementById("palavra").value;
    var res = document.getElementById("resultado");
    
     var html = "<html>" 
    + "<head>"
    + "<script type = 'text/javascript' src='javascript.js'></script>"
    + "</head>"
    + "<body>"
    + "<table id='myTable' border='1'>"
    + "<tr>"
    +"<td>Categoria</td>"
    +"<td>Tipo</td>"
    +"</tr>"
    +"<tr>"
    +"<td>music</td>"
    +"<td>artist</td>"
    +"<td><input type='button' value='Delete' onclick='deleteRow(this.parentNode.parentNode.rowIndex)'></td>"
    +"<td><input type='button' value='Alterar' onclick='alterarTipo(1);'></td>"
    +"</tr>"
    +"<tr>"
    +"<td>broadcast</td>"
    +"<td>artist</td>"
    +"<td><input type='button' value='Delete' onclick='deleteRow(this.parentNode.parentNode.rowIndex)'></td>"
    +"<td><input type='button' value='Alterar' onclick='alterarTipo(2);'></td>"
    +"</tr>"
    +"</table>"
    +"</body>"
    +"</html>";
    
 
    
    if(palavra == "artist" ){
        res.innerHTML=html;
    }else{
        res.innerHTML="Nenhum resultado encontrado.";
    }
}

function buscaEntidade(){
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
    +"<center>"
    + "<table id='myTable' border='1'>"
    + "<tr>"
    +"<td>Display Name</td>"
    +"<td>Tipo</td>"
    
    +"</tr>"
    +"<tr>"
    +"<td>The Sound of Music</td>"
    +"<td>/common/topic, /music/single </td>"
    +"</tr>"
        
    +"<tr>"
    +"<td>Music to See</td>"
    +"<td>/tv/tv_program,/common/topic</td>"
    +"</tr>"
        
    +"<tr>"
    +"<td>Electronic Music Laboratories</td>"      
    +"<td>/common/topic</td>"
    +"</tr>"
    +"</table>"
    +"</center>"
    +"</body>"
    +"</html>";
    
 
    if(tipoP == "music" && tipoNP == "history"){
        pal.innerHTML=html;
    }else{
        pal.innerHTML="Nenhum resultado encontrado.";
    }

}

var interval;

function alterarCategoria(){
    var x=document.getElementById('myTable').rows[1].cells;
    var y;
    y = x[0].innerHTML;
    abrirPag("iCategoria.html");
  
    interval = setInterval("pCat(y)",3000);
}

function pCat(y){
    alert("entrei no pcat");
    document.getElementById("ncateg").value = y;
    alert("passei o y")
    alert(y);
        clearInterval(interval);
}

function alterarTipo(i){
    var x=document.getElementById('myTable').rows[i].cells;
        v = new Array(2);
    for(i=0;i<2;i++)
        v[i] = x[i].innerHTML;
    abrirPag("iTipo.html");
        
    interval = setInterval("preencheTipo(v)",2000);

}

function preencheTipo(v){
    document.getElementById("ntipo").value = v[1];
        clearInterval(interval);
}

function alterarEntidade(i){
    var displayname, descricao, wikikeys, categoria, tipo;
    
    var x=document.getElementById('myTable').rows[i].cells;
    
    v = new Array(5);
    
    for(i=0;i<5;i++)
        v[i] = x[i].innerHTML;

    abrirPag("iEntidade.html");
        
    interval = setInterval("preencheEntidade(v)",2000);
}


function preencheEntidade(v){
    var t, cont;
    t = new Array(10);
    cont = 0;
    
    for(i=0;i<v[4].length;i++)
        if(v[4][i]==",")
            cont++;
    cont++;
    t=v[4].split(",",cont);
    
    document.getElementById("displayname").value = v[0];
    document.getElementById("description").value = v[1];
    var wikiOpt = document.getElementById("wikis").options;
    wikiOpt[wikiOpt.length] = new Option (v[2],v[2], true, true);

    var listOpt = document.getElementById("listaTipos").options;
    for(i=0;i<cont;i++)
        listOpt[listOpt.length] = new Option (t[i], t[i], true, true);
    
    clearInterval(interval);
}

function user(i){
    if(i==1)
        alert("Adicionado como colaborador.");
    else
        alert("Colaborador rejeitado.");
}

function valida(string){
    var erBranco = /^.+$/;
    if(trim(string).match(erBranco) != null)
        return true;
    return false;
}

function wikiListInsere(){
    var texto = document.getElementById("wiki").value;
    var valor = texto;
    document.getElementById("wikis").options[document.getElementById("wikis").options.length] = new Option (texto, valor, true, true);
}

function wikiListRemove(){
    document.getElementById("wikis").remove(document.getElementById("wikis").selectedIndex);
}

function tipoListInsere(){
    var texto = "/"+document.getElementById("categoria").value + "/" + document.getElementById("tipo").value;
    var valor = texto;

    document.getElementById("listaTipos").options[document.getElementById("listaTipos").options.length] = new Option (texto, valor, true, true);

}

function tipoListRemove(){
    document.getElementById("listaTipos").remove(document.getElementById("listaTipos").selectedIndex);
}