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
    document.getElementById("metodo").value = "removeWiki";
    document.getElementById("selected").value = document.getElementById('wikis').value;
    document.getElementById("wikis").remove(document.getElementById("wikis").selectedIndex);
    document.getElementById("search-form").action = "ValidarInsercao";
    return document.getElementById("search-form").submit();
}

function tipoListInsere(){
    var cat = document.getElementById("categoria");
    var txtCat = cat[cat.selectedIndex].text;
    
    var tipo = document.getElementById("tipo");
    var txtTipo = tipo[tipo.selectedIndex].text;
    
    if(cat.selectedIndex > 0 && tipo.selectedIndex > 0){
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
}

function tipoListRemove(){
    document.getElementById("metodo").value = "removeCatTipo";
    document.getElementById("selected").value = document.getElementById('listaTipos').value;
    document.getElementById("listaTipos").remove(document.getElementById("listaTipos").selectedIndex);
    document.getElementById("search-form").action = "ValidarInsercao";
    return document.getElementById("search-form").submit();
}

function VerificaCadastro(){
    var erMail, erNome, erSenha, erData;
    erMail = /^[\w\.?]+@[\w]+\.[\w]{2,4}\b(\.[\w]+)?\b$/;
    erNome = /^[A-Z a-z]+$/;             // /^[\w +]+$/;
    erSenha = /^.{6,10}$/;
    erData = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19|20)[0-9]{2}$/
    
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
        alert("Data de Nascimento deve estar no formato dd/mm/aaaa!\n\n\Ano deve estar entre 1900 e 2099");
        return false;
    }else{
        return document.getElementById("search-form").submit();
    }
}

function catListInsere(){
   
    var texto = document.getElementById("ncateg").value;
    var valor = "/" + texto;
    
    var cat = document.getElementById("listaCategorias");
    
    for(i=0; i<cat.options.length; i++){
        if(cat[cat.selectedIndex].value == valor)
            i = cat.options.length+1;
    }
    
    if(i==cat.options.length)
        cat.options[cat.options.length] = new Option (texto, valor, true, true);
}

function catListRemove(){
    var cat = document.getElementById("listaCategorias");
    document.getElementById("metodo").value = "removeCat";
    document.getElementById("selected").value = document.getElementById('listaCategorias').value;
    cat.remove(cat.selectedIndex);
    document.getElementById("search-form").action = "ValidarInsercao";
    return document.getElementById("search-form").submit();
}


function tipoCatListInsere(){
    var categ = document.getElementById("categ");
    var ntipo = document.getElementById("ntipo");
    
    if(categ.selectedIndex > 0){
        var texto = categ[categ.selectedIndex].text + "/" + ntipo.value;
        var valor = categ.value + "/" + ntipo.value;
        
    
        var cat = document.getElementById("categoriass");
    
        for(i=0; i<cat.options.length; i++){
            if(cat[cat.selectedIndex].value == valor)
                i = cat.options.length+1;
        }
    
        if(i==cat.options.length){
            cat.options[cat.options.length] = new Option(texto, valor, true, true);
            cat.options[(cat.options.length) - 1].name = "tipocat";
        }
    }
}

function tipoCatListRemove(){
    cat = document.getElementById("categoriass");
    document.getElementById("metodo").value = "remove";
    document.getElementById("selected").value = document.getElementById('categoriass').value;
    cat.remove(cat.selectedIndex);
    document.getElementById("search-form").action = "ValidarInsercao";
    return document.getElementById("search-form").submit();
}

var xmlHttpReq;
function chamaServlet(param,param2){
   
    try {
        try{
            var dado = "acao="+param2+"&cat="+ document.getElementById("categoria").value;
        }catch(e){
            // funciona quando nao tem o parametro cat
            dado = "acao="+param2;
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

function chamaServlet2(param,param2){
        
    try {
        try{
            var dado = "acao="+param2+"&cat="+ document.getElementById("categoria").selectedIndex;
        }catch(e){
            // funciona quando nao tem o parametro cat
            dado = "acao="+param2;
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


function mudaPaginaAvancada(tipoP, tipoNP){
    location.href="?acao=conAvancada&tipoP="+tipoP+"&tipoNP="+tipoNP+"&pag="+document.getElementById("npag").value;
    
};

function mudaPagina(ent){
    location.href="?acao="+document.getElementById("acao").value+"&nomeEntidade="+ent+"&pag="+document.getElementById("npag").value;
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
            dado = "acao="+param2;
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

function alterarSenha(userId){
    
    if(confirm("Sim")){
        document.getElementById("tipo").value = 'alterarSenha';
        document.getElementById('user').value = userId;
        document.getElementById("search-form").submit();
    }
}

function excluirUsuario(userId){

    if(confirm("Deseja Excluir o Usuário?")){
        
        document.getElementById('tipo').value = 'rejeitarSelecionado';
        document.getElementById('user').value = userId;
        document.getElementById("search-form").action = "ValidarUsuario";
        document.getElementById("search-form").submit();
    }
    
}

function VerificaAltCadastro(){
    var erMail, erNome, erSenha, erData;
    erMail = /^([\w\.?]+@[\w]+\.[\w]{2,4}\b(\.[\w]+)?\b)?$/;
    erNome = /^[A-Z a-z]*$/;            //   /^([\w +]+)?$/;
    erSenha = /^(.{6,10})?$/;
    erData = /^((0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19|20)[0-9]{2})?$/
    
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
        if(nome == "" && email == "" && senha == "" && rsenha == "" && edata == ""){
            alert("Preencha pelo menos um campo para que a alteração seja realizada!");
            return false;
        }
        else{
            return document.getElementById("search-form").submit();
        }
    }
}


function VerificaCategoria(){
    // Para fazer a validação dos campos na inserção de categorias
    
    var arrayCat = new Array();
    
    
    var cat = document.getElementById("listaCategorias");
    
    for(i=0; i<cat.options.length; i++){
        arrayCat[i] = (cat[cat.selectedIndex].value);
    }
 
    // categoria = trim(document.getElementById("cadData").value);
    
    if(document.getElementById("listaCategorias").options.length == 0){
        alert("Adicione pelo menos uma categoria à lista");
        return false;
    }else{
        return document.getElementById("search-form").submit(arrayCat);
    }
}

function VerificaTipo(){
    // Para fazer a validação dos campos na inserção de tipos

    var arrayTipo = new Array();
    
    var tipo = document.getElementById("categoriass");
    
    
    for(i=0; i<tipo.options.length; i++){
        arrayTipo[i] = (tipo[tipo.selectedIndex].value);
    }
 
    if(document.getElementById("categoriass").options.length == 0){
        alert("Adicione pelo menos um tipo à lista");
        return false;
    }else{
        return document.getElementById("search-form").submit(arrayTipo);
    }
}

function VerificaEMail(){
    var erMail;
    erMail = /^[\w\.?]+@[\w]+\.[\w]{2,4}\b(\.[\w]+)?\b$/;
    
    var email;

    email = trim(document.getElementById("email").value);
    if(email.match(erMail)==null){
        alert("Email inválido!");
        return false;
    }else{ 
        return document.getElementsByName('conUsuario').item(0).submit();
    }
}

function VerificaIns(){
    if(document.getElementById("categ").selectedIndex == 0){
        alert("Selecione pelo menos uma categoria");
        return false;
    }else if(document.getElementById("ntipo").value == ""){ 
        alert("Escreva o nome do tipo"); 
        return false;
    }else { 
        tipoCatListInsere();
        document.getElementById("metodo").value = "insere";
        document.getElementById("search-form").action = "ValidarInsercao";
        return document.getElementById("search-form").submit();
    }
}

function VerificaCatIns(){
    if(document.getElementById("ncateg").value == ""){ 
        alert("Escreva o nome da categoria"); 
        return false;
    }else { 
        catListInsere();
        document.getElementById("metodo").value = "insereCat";
        document.getElementById("search-form").action = "ValidarInsercao";
        return document.getElementById("search-form").submit();
    }
}

function VerificaWikiIns(){
    if(document.getElementById("wiki").value == ""){ 
        alert("Escreva o nome da wikikey"); 
        return false;
    }else { 
        wikiListInsere();
        document.getElementById("metodo").value = "insereWiki";
        document.getElementById("search-form").action = "ValidarInsercao";
        return document.getElementById("search-form").submit();
    }
}

function VerificaListIns(){
    if(document.getElementById("categoria").selectedIndex == 0){ 
        alert("Selecione uma categoria");
        return false;
    }else if(document.getElementById("tipo").selectedIndex == 0){
        alert("Selecione um tipo");
        return false;
    }else { 
        tipoListInsere();
        document.getElementById("metodo").value = "insereCatTipo";
        document.getElementById("search-form").action = "ValidarInsercao";
        return document.getElementById("search-form").submit();
    }
}

function RemoverTipo(a){
    alert("Requisição falhou");
    var hid=document.createElement('hidden');
    hid.value = a;
    alert("Requisição falhou");
    document.getElementById("search-form").appendChild(hid);
     alert("Requisição falhou");
     
    document.getElementById("search-form").submit();

 
   
}

function RemoverCategoria(a){

    alert("Remover Categoria");

    var valor=document.getElementsByName('valor');
    valor.value=a;
    document.getElementById("search-form").submit();
    
}

