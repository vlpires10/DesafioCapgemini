package capgemini_desafio_1;

/**
 *Questão 1- Escreva um algoritmo que mostre na tela uma escada de tamanho n 
 * utilizando o caractere * e espaços. A base e altura da escada devem ser 
 * iguais ao valor de n. A última linha não deve conter nenhum espaço.
 * @author Valdson Lima Pires
 * 22/02/2022
 */
import java.util.Scanner; // importando a classe Scanner para leitura via teclado

public class Capgemini_Desafio_1 {
        
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in); // instanciando e criando objeto Scanner
        System.out.println("*** DESAFIO DE PROGRAMAÇÃO - ACADEMIA CAPGEMINI ****");
        System.out.println("\n\nQuestão2"); 
        int n;
         
      //lendo do teclado o valor n que será o tamanho da base da escada em *
        System.out.print("Digite o valor de n ==>> ");
        n = ler.nextInt();
        for (int i=1; i<=n; i++){ // determina o numero de niveis da escada
            System.out.println("");
            for (int j=n-i; j>0; j--){ // imprime j vezes espaços em branco 
                System.out.print(" ");
            }
            for (int k=i; k>0; k--) {    //imprime k vezes *   
                System.out.print("*");
            }
       }
   }
}
 