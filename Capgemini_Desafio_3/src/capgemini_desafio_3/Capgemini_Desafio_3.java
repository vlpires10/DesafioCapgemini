
package capgemini_desafio_3;

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

/**
 *Duas palavras podem ser consideradas anagramas de si mesmas se as letras 
 * de uma palavra podem ser realocadas para formar a outra palavra. Dada uma
 * string qualquer, desenvolva um algoritmo que encontre o número de pares de
 * substrings que são anagramas.
 * 
 * @author Valdson Lima Pires
 * 22/02/2022
 */
public class Capgemini_Desafio_3 {

        
    //****Função que determina o tamanho do vetor que vai armazenar as substrings**
    static int tamanhoVet(String str){ //recebe a string a ser testada como parametro
        int aux = Math.round(str.length()/2);
        int tamanho = 0;
        for (int i = str.length(); i >= aux; i--){
            tamanho = tamanho + i;
        }    

        return tamanho;
        
    }
    
        
    //Função para verifica duas estrings são anagramas 
    static Boolean isAnagrama(String s1, String s2){  //Recebe como parametros 2 strings
        
        //verifica se as string são do mesmo tamanho
        int tamanho = s1.length();
        if ( s1.length() != s2.length() )
            return false;
        else{    
             //coloca as strings s1 e s2 em ordem alfabetica
            char[] test1 = s1.toCharArray();
            Arrays.sort(test1);
            char[] test2 = s2.toCharArray();
            Arrays.sort(test2);
            s1="";
            s2="";
            for(int i=0; i< tamanho; i++){
                s1 = s1 + test1[i];
                s2 = s2 + test2[i];
            }
            if (s1.equals(s2))
                return true;
            else
                return false;

        }

    }
    
    //        ____________________    
    //********|                  | **********//
    //********| TESTES UNITARIOS | **********//
    //********|__________________| **********//
    
    
    //****** teste para fução 'isAnagrama()' *********/
    static Boolean teste_isAnagrama(){ // Código OK para retorno true
        String[] massa1 = new String[6];
        String[] massa2 = new String[6];
        String[] contra_massa1 = new String[4];
        String[] contra_massa2 = new String[4];
        massa1[0] = "ov";
        massa2[0] = "vo";
        massa1[1] = "ifa";
        massa2[1] = "fai";
        massa1[2] = "ALDV";
        massa2[2] = "VALD";
        massa1[3] = "AA@AA";
        massa2[3] = "AAAA@";
        massa1[4] = "ini";
        massa2[4] = "iin";
        massa1[5] = "1234";
        massa2[5] = "4321";
        
        //masa de teste não atende requisitos para ser anagrama
        contra_massa1[0] = "ovo";
        contra_massa2[0] = "ov";
        contra_massa1[1] = "ini";
        contra_massa2[1] = "ina";
        contra_massa1[2] = "Valdson ";
        contra_massa2[2] = "valdson_";
        contra_massa1[3] = "01234";
        contra_massa2[3] = "12345";
        
        //teste positivo =>toda massa de teste que é anagrama
        int valorEsperado1 = 6;
        int teste1 = 0;
        for(int i=0; i < valorEsperado1; i++){ 
            System.out.println("TESTE POSITIVO - Vetor 'massa1' e 'massa2'  |Pos - "+ i + "   |Conteudo " + massa1[i] +  " X " + massa2[i]+" |"); //imprime cada exemplo do teste
            if (isAnagrama(massa1[i],massa2[i])){
                teste1++;
            }    
        }  
        
        
        //teste negativo =>toda massa de teste que não é anagrama
        
        System.out.println("================================================================================");   
        int valorEsperado2 = 4;
        int teste2 = 0;
        for(int i=0; i < valorEsperado2; i++){ 
            System.out.println("TESTE NEGATIVO - Vetor 'contra_massa1' e 'contra_massa2'  |Pos - "+ i + "   |Conteudo " + contra_massa1[i] +  " X " + contra_massa2[i]+" |"); //imprime cada exemplo do teste
            if (isAnagrama(contra_massa2[i] , contra_massa2[i])){
                teste2++;
            }    
        }     

        if ( teste1 == valorEsperado1 && teste2 == valorEsperado2)
            return true;
        else
            return false;

    }
    
       //****** teste para fução 'tamanhoVet' *********/
    static Boolean teste_tamanhoVet(){ // Código OK para retorno true
        String[] massa = new String[8];
        massa[0] = "";
        massa[1] = "a";
        massa[2] = "aa";
        massa[3] = "123";
        massa[4] = "VALD";
        massa[5] = "AA@AA";
        massa[6] = "a VALD";
        massa[7] = "iIhj8@%";
        
        int[] esperado = new int[8];
        esperado[0] = 0;
        esperado[1] = 1;
        esperado[2] = 3;
        esperado[3] = 6;
        esperado[4] = 9;
        esperado[5] = 14;
        esperado[6] = 18;
        esperado[7] = 25;
        
        int valorEsperado = 8;
        int teste = 0;
        
//teste positivo =>toda massa de teste contem o caracter a ser testado
        for(int i=0; i < valorEsperado; i++){ 
            String teste1 = massa[i];
            System.out.println("vetor massa[] |Posição - "+ i + "   |Conteudo " + massa[i] + "   |Tamanho calculado " + tamanhoVet(massa[i]) +  " X " + esperado[i] + " Tamanho esperado|"); //imprime cada exemplo do teste
            if (tamanhoVet(teste1) == esperado[i]){
                teste++;
            }    
        }     
        
        if ( teste == valorEsperado)
            return true;
        else
            return false;

    }
    
    
    
   // Programa Principal
    public static void main(String[] args) {
        
    
        Scanner ler = new Scanner(System.in); // instanciando e criando objeto Scanner
        System.out.println("*** DESAFIO DE PROGRAMAÇÃO - ACADEMIA CAPGEMINI ****");
        System.out.println("\n\nQuestão3"); 
       
        //Lendo a STRING do teclado
        String str; //variavel - String principal
        System.out.print("Digite a STRING ==>>> ");
        str = ler.nextLine();
        int n = tamanhoVet(str); //tamanho do vetor de Substrings
        
        // * cria um vetor para armazenar todas substrings 'str' possívies
        String[] vetSub = new String[n];     
        int tamSub=1;
        int inicio;
        int cont=0;
        
        //Carrega vetor 'vetSub' com as sub strings da string 'str' 
        int j=0;
        while ( j < n )  { 
            inicio = 0;
            for (int i = 0; i < (str.length()-tamSub+1) ; i++){
                cont++;
               // System.out.println(str.length()-tamSub+1);
                vetSub[j] = str.substring(inicio, inicio+tamSub); 
                inicio++;
                j++;
            } 
            tamSub++;
        }
//*************************************************************
        
        // faz a avaliação de vada substring
        inicio=0;
        int result = 0;
        for( int i=inicio; i < n-1 ; i++ ){
            for( j = i+1; j < n; j++ ){
                if (isAnagrama(vetSub[i] , vetSub[j])){
                    result++;
                }
            }
        }
        System.out.println(result);    
        
        /******************************************************/
        /***************** TESTES UNITÁRIOS *******************/
        /******************************************************/
        
        System.out.println("<<<=== RESULTADO DO TESTE 'teste_tamanhoVet()' ===>>> "+teste_tamanhoVet()); //testa funçao tamanhoVet() 
        //System.out.println("<<<=== RESULTADO DO TESTE 'teste_isAnagrama()' ===>>> "+teste_isAnagrama()); //testa funçao isAnagrama() 
        


    }
}
