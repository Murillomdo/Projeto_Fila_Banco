import java.util.Scanner;

public class App_FilaBanco {

    public static void main(String args[]) {

        int temp;
        ManageAttendance filaClientes = new ManageAttendance(6);

        do {
            Menu();

            Scanner input = new Scanner(System.in);

            System.out.print("Selecione a opçao desejada: ");
            int user = input.nextInt();

            temp = user;

            switch (temp) {
                case 1:

                    System.out.print("Qual o nome do cliente? ");
                    String nome = input.next();

                    System.out.print("Qual a idade do cliente? ");
                    int idade = input.nextInt();

                    filaClientes.addClient(nome, idade);
                    break;
                case 2:
                    filaClientes.showNext();
                    break;
                case 3:
                    filaClientes.getNext();
                    break;
                case 4:
                    filaClientes.showQueues();
                    break;
                case 5:
                    System.out.println("Programa encerrado. Obrigado! Volte sempre!");
                    break;
                default:
                    System.out.println("\nOpçao inválida. Favor tentar novamente.");
                    break;
            }

        } while (temp != 5);
    }

    public static void Menu() {
        System.out.println("\n----// Menu de Opçoes do Programa //----\n");
        System.out.println("1 - Chegada do cliente na agência"); // addClient();
        System.out.println("2 - Verificar quem é o próximo a ser atendido"); // showNext();
        System.out.println("3 - Atender um cliente"); // getNext();
        System.out.println("4 - Exibir as filas"); // showQueues();
        System.out.println("5 - Finalizar o programa\n"); // FIM
    }

}