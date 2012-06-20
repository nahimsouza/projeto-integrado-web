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
    var texto = "/"+document.getElementById("categoria").value + "/" + document.getElementById("tipo").value;
    var valor = texto;

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
        return alert("Cadastro solicitado com sucesso!");
        document.getElementById("search-form").submit();
    }
    
}