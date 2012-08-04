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

function showDiv( idName, value ){
    //funcao ShowDiv retirada de: http://www.guj.com.br/java/136558-mudar-conteudo-de-uma-div-resolvido 
    objDiv = document.getElementById( idName );
    if( value )
        objDiv.style.display = "";
    else
        objDiv.style.display = "none";
}

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

function wikiListInsere(){
    var texto = document.getElementById("wiki").value;
    var valor = texto;
    document.getElementById("wikis").options[document.getElementById("wikis").options.length] = new Option (texto, valor, true, true);
}

function wikiListRemove(){
    document.getElementById("wikis").remove(document.getElementById("wikis").selectedIndex);
}

function tipoListInsere(){
    var cat = document.getElementById("categoria");
    var txtCat = cat[cat.selectedIndex].text;
    
    var tipo = document.getElementById("tipo");
    var txtTipo = tipo[tipo.selectedIndex].text;
    
    var texto = txtCat + txtTipo;
    var valor = cat.value + '/' + tipo.value;

    document.getElementById("listaTipos").options[document.getElementById("listaTipos").options.length] = new Option (texto, valor, true, true);

}

function tipoListRemove(){
    document.getElementById("listaTipos").remove(document.getElementById("listaTipos").selectedIndex);
}

function VerificaCadastro(){
    var erMail, erNome, erSenha, erData;
    erMail = /^[\w\.?]+@[\w]+\.[\w]{2,4}\b(\.[\w]+)?\b$/;
    erNome = /^[\w +]+$/;
    erSenha = /^.{6,10}$/;
    erData = /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/
    
    var nome, email, senha, rsenha;
    
    nome = trim(document.getElementById("cadNome").value);
    email = trim(document.getElementById("cadEMail").value);
    senha = trim(document.getElementById("cadSenha").value);
    rsenha = trim(document.getElementById("cadRSenha").value);
    edata = trim(document.getElementById("cadData").value);
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
    }
    else if(edata.match(erData)==null){
        alert("Data de Nascimento deve estar no formato dd/mm/aaaa!");
        return false;
    }else{
        return document.getElementById("search-form").submit();
    }
}

function catListInsere(){
   
    var texto = document.getElementById("ncateg").value;
    var valor = texto;
    
    document.getElementById("listaCategorias").options[document.getElementById("listaCategorias").options.length] = new Option (texto, valor, true, true);
}

function catListRemove(){
    document.getElementById("listaCategorias").remove(document.getElementById("listaCategorias").selectedIndex);
}


function tipoCatListInsere(){
    var texto = "/"+document.getElementById("categ").value + "/" + document.getElementById("ntipo").value;
    var valor = texto;

    document.getElementById("categoriass").options[document.getElementById("categoriass").options.length] = new Option (texto, valor, true, true);

}

function tipoCatListRemove(){
    document.getElementById("categoriass").remove(document.getElementById("categoriass").selectedIndex);
}

var xmlHttpReq;
function chamaServlet(param,param2){
    
    try {
        var dado = "acao="+param2+"&cat="+ document.getElementById("categoria").value;
        
        xmlHttpReq = new XMLHttpRequest();  // Não funciona em versoes antigas do IE

        // Abre uma conexão com o servidor usando o método GET
        xmlHttpReq.open("POST",'VerificarSolicitacoes',true);
        
        xmlHttpReq.setRequestHeader('Content-Type','application/x-www-form-urlencoded');

        // Define uma função que o servidor chama qdo estiver pronto (recebida como parametro)
        xmlHttpReq.onreadystatechange = param;

        // Faz a requisição ao servidor
        xmlHttpReq.send(dado);
    } catch(exception){
        alert("Requisição falhou");
    }
}

function carregaCategorias(){
    
    if (xmlHttpReq.readyState==4 && xmlHttpReq.status==200)
    {
        var txt = xmlHttpReq.responseText;
        document.getElementById("categoria").innerHTML=txt;
    }
}

function carregaTipos(){
    
    if (xmlHttpReq.readyState==4 && xmlHttpReq.status==200)
    {
        var txt = xmlHttpReq.responseText;
        document.getElementById("tipo").innerHTML=txt;
    }
}