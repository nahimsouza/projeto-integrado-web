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
    var login, senha;
     login = document.getElementById("email").value;
     senha = document.getElementById("senha").value;
    
    if(login == "colaborador"){
        if(senha == "senha"){
            alert("Bem vindo Colaborador!");
            //red
        }
    }else if(login == "adm"){
        if(senha == "adm"){
            alert("Bem vindo ADM!");
            //red
        }
     }else
         alert("Usuario ou senha inválido!");
        
     document.getElementById("senha").value = "";
}