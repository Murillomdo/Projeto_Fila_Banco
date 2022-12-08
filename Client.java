public class Client {
    String name;
    int age;
    Client next;

    public Client(String name, int age) {

        name = name.trim();

        if (name.length() >= 5 && age >= 16) {
            this.name = name;
            this.age = age;
        }
        else if (name.length() < 5 && age < 16){
            System.out.println("\nAVISO: Nome inválido. É necessário que o nome do cliente tenha pelo menos 5 caracteres. Novo cliente não foi inserido. | A idade mínima do cliente deve ser maior ou igual a 16 anos. Novo cliente não foi inserido.");
        } 
        else if (name.length() < 5) {
            System.out.println("\nAVISO: Nome inválido. É necessário que o nome do cliente tenha pelo menos 5 caracteres. Novo cliente não foi inserido.");
        }
        else if (age < 16) {
            System.out.println("\nAVISO: A idade mínima do cliente deve ser maior ou igual a 16 anos. Novo cliente não foi inserido.");
        }

        this.next = null;
    }

    public static boolean isValido(String name, int age){
        if (name.length() >= 5 && age >= 16) {
            return true;
        }
        else if (name.length() < 5 && age < 16){
            System.out.println("\nAVISO: Nome inválido. É necessário que o nome do cliente tenha pelo menos 5 caracteres. Novo cliente não foi inserido. | A idade mínima do cliente deve ser maior ou igual a 16 anos. Novo cliente não foi inserido.");
            return false;
        } 
        else if (name.length() < 5) {
            System.out.println("\nAVISO: Nome inválido. É necessário que o nome do cliente tenha pelo menos 5 caracteres. Novo cliente não foi inserido.");
            return false;
        }
        else if (age < 16) {
            System.out.println("\nAVISO: A idade mínima do cliente deve ser maior ou igual a 16 anos. Novo cliente não foi inserido.");
            return false;
        }
        return true;
    }; 

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isElderly() {
        if (age >= 60) {
            return true;
        }
        return false;
    }
}