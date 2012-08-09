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

/*
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
*/

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

    var lista = document.getElementById("listaTipos");

    for(i=0; i<lista.options.length; i++){
        if(lista[lista.selectedIndex].value == valor)
            i = lista.options.length+1;
    }
    
    if(i==lista.options.length)
        lista.options[lista.options.length] = new Option (texto, valor, true, true);
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
    var valor = "/" + texto;
    
    var cat = document.getElementById("listaCategorias");
    cat.options[cat.options.length] = new Option (texto, valor, true, true);
}

function catListRemove(){
    var cat = document.getElementById("listaCategorias");
    cat.remove(cat.selectedIndex);
}


function tipoCatListInsere(){
    var categ = document.getElementById("categ");
    var ntipo = document.getElementById("ntipo");
    
    var texto = categ[categ.selectedIndex].text + "/" + ntipo.value;
    var valor = categ.value + "/" + ntipo.value;
    ;
    
    var cat = document.getElementById("categoriass");
    cat.options[cat.options.length] = new Option (texto, valor, true, true);
    
}

function tipoCatListRemove(){
    var cat = document.getElementById("categoriass");
    cat.remove(cat.selectedIndex);
}

var xmlHttpReq;
function chamaServlet(param,param2){
   
    try {
        try{
            var dado = "acao="+param2+"&cat="+ document.getElementById("categoria").value;
        }catch(e){
            // funciona quando nao tem o parametro cat
            var dado = "acao="+param2;
        }
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
        
        // Para funcionar com a combo que carrega as categorias na insercao de tipo:
        document.getElementById("categ").innerHTML=txt;
        
    }
}

function carregaTipos(){
    
    if (xmlHttpReq.readyState==4 && xmlHttpReq.status==200)
    {
        var txt = xmlHttpReq.responseText;
        document.getElementById("tipo").innerHTML=txt;
    }
}

function inserirEntidade(){
    if(document.getElementById("displayname").value==""){
        alert("Informe o displayname");
        return false;
    }else if(document.getElementById("listaTipos").options.length == 0){
        alert("Defina uma categoria e um tipo para a entidade");
        return false;
    }else{
        return document.getElementById("search-form").submit();
    }
}

function mudaPagina(ent){
    location.href="?acao="+document.getElementById("acao")+"nomeEntidade="+ent+"&pag="+document.getElementById("npag").value;
}

function mudaPagina(tipoP, tipoNP){
    location.href="?acao=conAvancada&tipoP="+tipoP+"&tipoNP="+tipoNP+"&pag="+document.getElementById("npag").value;
    
}

function carregaCategoriasConsulta(){
    
    if (xmlHttpReq.readyState==4 && xmlHttpReq.status==200)
    {
        var txt = xmlHttpReq.responseText;
        // Carrega as duas combos de categorias
        document.getElementById("catP").innerHTML=txt;
        document.getElementById("catNP").innerHTML=txt;
        
    }
}

function chamaServletConsulta(param,param2,cat){
    
    try {
        try{
            // para funcionar genericamente com catP e catNP
            var dado = "acao="+param2+"&cat="+ document.getElementById(cat).value;
        }catch(e){
            var dado = "acao="+param2;
        }
          
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

function carregaTiposConsultaP(){
    
    if (xmlHttpReq.readyState==4 && xmlHttpReq.status==200)
    {
        var txt = xmlHttpReq.responseText;
        document.getElementById('tipoP').innerHTML=txt;
    }
}

function carregaTiposConsultaNP(){
    
    if (xmlHttpReq.readyState==4 && xmlHttpReq.status==200)
    {
        var txt = xmlHttpReq.responseText;
        document.getElementById('tipoNP').innerHTML=txt;
    }
}

function acaoAlterarSenha(){
    
    if(confirm("Sim")){
        document.getElementById("tipo").value = 'alterarSenha';
        document.getElementById('user').value = '<%= objUsuario.getEmail() %>';
        document.getElementById("search-form").submit();
        alert("Será que submeteu????");
    }
}

function acaoExcluirUsuario(){
    
    alert("Entrou no acaoExcluirUsuario");
    
    if(confirm("Deseja Excluir o Usuário?")){
        alert("Entrou dentro do if!!!!")
        document.getElementById('tipo').value = 'rejeitar';
        alert("Passou pelo rejeitar")
        document.getElementById('user').value = '<%= objUsuario.getEmail()%>';
        alert("Passou pelo user")
        document.getElementById("search-form").submit();
        alert("Será que submeteu????");
    }
}