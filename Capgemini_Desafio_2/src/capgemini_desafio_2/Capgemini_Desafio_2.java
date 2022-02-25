package capgemini_desafio_2;

import java.util.Scanner;// importando a classe Scanner para leitura via teclado

/**
 * Débora se inscreveu em uma rede social para se manter em contato com seus 
 * amigos. A página de cadastro exigia o preenchimento dos campos de nome e 
 * senha, porém a senha precisa ser forte. O site considera uma senha forte 
 * quando ela satisfaz os seguintes critérios:
 *-Possui no mínimo 6 caracteres
 *  -Contém no mínimo 1 digito.
 *  -Contém no mínimo 1 letra em minúsculo.
 *  -Contém no mínimo 1 letra em maiúsculo.
 *  -Contém no mínimo 1 caractere especial, que são: !@#$%^&*()-+
 * Débora digitou uma string aleatória no campo de senha, porém ela não tem 
 * certeza se é uma senha forte. Para ajudar Débora, construa um algoritmo que 
 * informe qual é o número mínimo de caracteres que devem ser adicionados para 
 * uma string qualquer ser considerada segura.
 *
 * @author Valdson Lima Pires
 * 22/02/2022
 */

    
public class Capgemini_Desafio_2 {   
   
//Função para verifica se tem pelo menos 1 numeros na senha 
    static Boolean temNumero(String senha){  
        String numeros = "0123456789";
        for (int i=0; i< senha.length();i++){
            for (int j=0;j<10;j++){
                if (senha.charAt(i) == numeros.charAt(j))
                    return true;//encontrou um caracter
            } 
        }    
        return false;// não tem caracter especial
    }
   
    
    
    
//Função para verifica se tem pelo menos 1 CaracterEspecial na senha 
    static Boolean temCaracterEspecial(String senha){  //verifica se carater especial
        String caracEspec = "!@#$%^&*()-+";
        for (int i=0; i < senha.length(); i++){
            for (int j=0; j<12; j++){
                if (senha.charAt(i) == caracEspec.charAt(j))
                    return true; // encontrou um caracter
                
            } 
        }    
        return false;
    }
   
//Função para verifica se tem pelo menos 1 letra maiuscula na senha 
    static Boolean temMaiuscula(String senha){  //verifica se tem numero (true para tem numero)
        String alfaMaiuscula = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i=0; i< senha.length();i++){
            for (int j=0;j<26;j++){
                if (senha.charAt(i) == alfaMaiuscula.charAt(j))
                    return true;
            } 
        }    
        return false;    
    }
//Função para verifica se tem pelo menos 1 letra minuscula na senha         
    static Boolean temMinuscula(String senha){  //verifica se tem numero (true para tem numero)
        String alfaMinuscula = "abcdefghijklmnopqrstuvwxyz";
        for (int i=0; i < senha.length() ;i++){
            for (int j = 0; j < 26; j++){
                if (senha.charAt(i) == alfaMinuscula.charAt(j))
                    return true;
            }
        }        
        return false;    
    }
    //        ____________________    
    //********|                  | **********//
    //********| TESTES UNITARIOS | **********//
    //********|__________________| **********//
    
    //****** teste para fução 'temNumero' *********/
    static Boolean teste_temNumero(){ // Código OK para retorno true
        String[] massa = new String[7];
        massa[0] = "asdfgh1";
        massa[1] = "1adffgs";
        massa[2] = "123affg";
        massa[3] = "httaf1g";
        massa[4] = "gg3affg";
        massa[5] = "caffg22";
        massa[6] = "caffg22";
        
        int valorEsperado = 7;
        int teste = 0;
        //teste positivo =>toda massa de teste contem o caracter a ser testado
        for(int i=0; i < valorEsperado; i++){
            if (temNumero(massa[i])){
                teste++;
            System.out.println(i+ "-"+massa[i]+" - "+temNumero(massa[i])); //imprime cada exemplo do teste
            }    
        }
        if (temNumero("adfadgafg") == false && teste == valorEsperado)
            return true;
        else
            return false;
        
    }
    
//****** teste para fução 'temCaracterEspecial' *********/
    static Boolean teste_temCaracterEspecial(){ // Código OK para retorno true
        String[] massa = new String[11];
        massa[0] = "1aC00+";              
        massa[1] = "Ad!fa1dfaf";
        massa[2] = "dfh31dfadf@";
        massa[3] = "lkuia89k#";
        massa[4] = "$1Tfafadfa";
        massa[5] = "adfa1fadfa%dsf";
        massa[6] = "a^df1ad";
        massa[7] = "afd&a1f";
        massa[8] = "*d1f";
        massa[9] = "valdson10(";
        massa[10] = "adfa-+dfa1df)a";
        
        int valorEsperado = 11;
        int teste = 0;
        //teste positivo =>toda massa de teste contem o caracter a ser testado
        for(int i=0; i < valorEsperado; i++){
            if (temNumero(massa[i])){
                teste++;
                System.out.println(i+ "-"+massa[i]+" - "+temNumero(massa[i])); //imprime cada exemplo do teste
            }
        }
        //teste negativo - a massa nnão contem o caracter a ser testado
        if ( temCaracterEspecial("12dfad2fg") == false && (teste == valorEsperado))
            return true;
        else
            return false;
    }    
    

    //****** teste para fução 'temMaiuscula' *********/
    static Boolean teste_temMaiuscula(){ // Código OK para retorno true
        String[] massa = new String[7];
        massa[0] = "Dsdfgh1";
        massa[1] = "1adfAgs";
        massa[2] = "123affT";
        massa[3] = "RRRRRRR";
        massa[4] = "AAAAAAAa";
        massa[5] = "Aa";
        massa[6] = "A";
        
        int valorEsperado = 7;
        int teste = 0;
        //teste positivo =>toda massa de teste contem o caracter a ser testado
        for(int i=0; i < valorEsperado; i++){ 
            if (temMaiuscula(massa[i])){
                teste++;
                System.out.println(i+ "-"+massa[i]+" - "+temMaiuscula(massa[i])); //imprime cada exemplo do teste
            }    
        }   
        //teste negativo - a massa nnão contem o caracter a ser testado
        if (temMaiuscula("adfad123g") == false && teste == valorEsperado)
            return true;
        else
            return false;
    
    }
    
    
    //****** teste para fução 'temMinuscula' *********/
    static Boolean teste_temMinuscula(){ // Código OK para retorno true
        String[] massa = new String[7];
        massa[0] = "ADGRGHJa";
        massa[1] = "sFGRTYU";
        massa[2] = "123apFRT";
        massa[3] = "VALDSON0a";
        massa[4] = "AAAAAAAa";
        massa[5] = "aVALDSON0 a";
        massa[6] = "iI";
        
        int valorEsperado = 7;
        int teste = 0;
        //teste positivo =>toda massa de teste contem o caracter a ser testado
        for(int i=0; i < valorEsperado; i++){ 
            if (temMaiuscula(massa[i])){
                teste++;
                System.out.println(i+ "-"+massa[i]+" - "+temMinuscula(massa[i])); //imprime cada exemplo do teste
            }    
        }     
        //teste negativo - a massa nnão contem o caracter a ser testado
        if (temMinuscula("223ERVALDSON00") == false && teste == valorEsperado) //teste negativo - a massa nnão contem o caracter a ser testado
            return true;
        else
            return false;

    }
    
    
    
  
    //programa principal
    public static void main(String[] args) { 
        Scanner ler = new Scanner(System.in); //instanciando e criando objeto Scanner
        System.out.println("*** DESAFIO DE PROGRAMAÇÃO - ACADEMIA CAPGEMINI ****");
        System.out.println("\n\nQuestão 2");
        //Lendo a senha do teclado
        String senha;
        System.out.print("Digite a Senha ==>>> ");
        senha = ler.nextLine();
        
        
          //**** apurando os resultados ****
        int cont = 0;
        int resultado=0;
        

        // incrementa variavel "cont" para cada requisito nao atendido
        if (!temNumero(senha)) 
            cont++;
        if (!temCaracterEspecial(senha))
            cont++;
        if (!temMaiuscula(senha))    
            cont++;
        if (!temMinuscula(senha))
            cont++;
        
       
        if(6 - senha.length() >= cont)
            resultado = 6 - senha.length();
        else
            resultado = cont;
                    
        System.out.println(resultado);
        
        /******************************************************/
        /***************** TESTES UNITÁRIOS *******************/
        /******************************************************/
        System.out.println("<<<=== RESULTADO DO TESTE 'temNumero' ===>>> "+teste_temNumero()); //testa funçao temNumero 
        //System.out.println("<<<=== RESULTADO DO TESTE 'temCaracterEspecial' ===>>> "+teste_temCaracterEspecial()); //testa funçao temCaracterEspecial
        //System.out.println("<<<=== RESULTADO DO TESTE 'temMaiuscula' ===>>> "+teste_temMaiuscula()); //testa funçao temMaiuscula
        //System.out.println("<<<=== RESULTADO DO TESTE 'temMMinuscula' ===>>> "+teste_temMinuscula()); //testa funçao temMaiuscula
        
            
        
        
    
    }
}    
    

