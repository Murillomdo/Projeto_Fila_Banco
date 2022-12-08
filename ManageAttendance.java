public class ManageAttendance {
    private Client inicio, fim;
    public int tamanho;
    private int maxsize;

    public static ManageAttendance filaIdoso = new ManageAttendance(50);
    public static ManageAttendance filaNormal = new ManageAttendance(50);

    public ManageAttendance(int maxsize) {
        this.maxsize = maxsize;
    }

    private int getMaxSize() {
        return maxsize;
    }

    public boolean isEmpty() {
        if (filaIdoso.tamanho + filaNormal.tamanho > 0) {
            return false;
        }
        return true;
    }

    public int numClients() {
        return filaIdoso.tamanho + filaNormal.tamanho;
    }

    public int numElderlyClients() {
        return filaIdoso.tamanho;
    }

    private void printIdoso() {

        Client cliente = filaIdoso.inicio;

        if (filaIdoso.tamanho == 0) {
            System.out.print("Idoso:Vazia;");
        } else {
            System.out.print("Idoso:");
            while (cliente != null) {
                if (cliente.next == null) {
                    System.out.print(cliente.name + ":" + cliente.age + ";");
                } else {
                    System.out.print(cliente.name + ":" + cliente.age + "-");
                }
                cliente = cliente.next;
            }
        }
    }

    private void printNormal() {

        Client cliente = filaNormal.inicio;

        if (filaNormal.tamanho == 0) {
            System.out.print("Normal:Vazia;");
        } else {
            System.out.print("Normal:");
            while (cliente != null) {
                if (cliente.next == null) {
                    System.out.print(cliente.name + ":" + cliente.age + ";");
                } else {
                    System.out.print(cliente.name + ":" + cliente.age + "-");
                }
                cliente = cliente.next;
            }
        }
    }

    public void showQueues() {
        filaIdoso.printIdoso();
        filaNormal.printNormal();
    }

    public void addClient(String name, int age) {

        Client novo_cliente = new Client(name, age);

        if (filaIdoso.numClients() == this.getMaxSize()) {
            System.out.println("A fila está cheia, o(a) cliente " + novo_cliente.name + " não foi inserido(a).");
        } else {
            if (novo_cliente.age >= 60) {
                if (filaIdoso.fim == null) {
                    filaIdoso.inicio = novo_cliente;
                    filaIdoso.fim = novo_cliente;
                    filaIdoso.tamanho++;
                } else {
                    filaIdoso.fim.next = novo_cliente;
                    filaIdoso.fim = novo_cliente;
                    filaIdoso.tamanho++;
                }
            } else {
                if (filaNormal.fim == null) {
                    filaNormal.inicio = novo_cliente;
                    filaNormal.fim = novo_cliente;
                    filaNormal.tamanho++;
                } else {
                    filaNormal.fim.next = novo_cliente;
                    filaNormal.fim = novo_cliente;
                    filaNormal.tamanho++;
                }
            }
        }
    }

    public void showNext() { // Mostra o próximo, mas não o remove
        if (filaIdoso.tamanho >= 1 && filaNormal.tamanho == 0) {
            System.out.printf("O(A) próximo(a) cliente a ser atendido(a) é: %s com %s anos", filaIdoso.inicio.name,
                    filaIdoso.inicio.age);
        } else if (filaIdoso.tamanho == 0 && filaNormal.tamanho >= 1) {
            System.out.printf("O(A) próximo(a) cliente a ser atendido(a) é: %s com %s anos", filaNormal.inicio.name,
                    filaNormal.inicio.age);
        } else if (filaIdoso.tamanho == 0 && filaNormal.tamanho == 0) {
            System.out.println("Não há nenhum cliente para ser atendido(a).");
        } else if (filaIdoso.tamanho == 1 && filaNormal.tamanho == 1) {
            System.out.printf("O(A) próximo(a) cliente a ser atendido(a) é: %s com %s anos", filaIdoso.inicio.name,
                    filaIdoso.inicio.age);
        } else {
            System.out.printf("O(A) próximo(a) cliente a ser atendido(a) é: %s com %s anos", filaIdoso.inicio.name,
                    filaIdoso.inicio.age);
        }
    }

    public void getNext() { // Mostra o próximo da fila e o remove!
        if (filaIdoso.tamanho >= 1 && filaNormal.tamanho == 0) {
            System.out.printf("O(A) cliente %s de %s anos foi atendido(a).", filaIdoso.inicio.name,
                    filaIdoso.inicio.age);
            filaIdoso.dequeueIdoso();
        } else if (filaIdoso.tamanho == 0 && filaNormal.tamanho >= 1) {
            System.out.printf("O(A) cliente %s de %s anos foi atendido(a).", filaNormal.inicio.name,
                    filaNormal.inicio.age);
            filaNormal.dequeueNormal();
        } else if (filaIdoso.tamanho == 0 && filaNormal.tamanho == 0) {
            System.out.println("Não há nenhum cliente para ser atendido(a).");
        } else if (filaIdoso.tamanho == 1 && filaNormal.tamanho == 1) {
            System.out.printf("O(A) cliente %s de %s anos foi atendido(a).", filaIdoso.inicio.name,
                    filaIdoso.inicio.age);
            filaIdoso.dequeueIdoso();
        } else {
            System.out.printf("O(A) cliente %s de %s anos foi atendido(a).", filaIdoso.inicio.name,
                    filaIdoso.inicio.age);
            filaIdoso.dequeueIdoso();
        }
    }

    private Client dequeueIdoso() {

        Client cliente_idoso = filaIdoso.inicio;
        Client cliente_atendido = filaIdoso.inicio;

        if (filaIdoso.inicio == null) {
            cliente_idoso = null;
            filaIdoso.tamanho = 0;
        } else {
            cliente_idoso = filaIdoso.inicio;
            filaIdoso.inicio = filaIdoso.inicio.next;
            cliente_idoso.next = null;
            filaIdoso.tamanho--;
        }
        if (filaIdoso.inicio == null) {
            filaIdoso.fim = null;
        }

        return cliente_atendido;
    }

    private Client dequeueNormal() {

        Client cliente_normal = filaNormal.inicio;
        Client cliente_atendido = filaNormal.inicio;

        if (filaNormal.inicio == null) {
            cliente_normal = null;
            filaNormal.tamanho = 0;
        } else {
            cliente_normal = filaNormal.inicio;
            filaNormal.inicio = filaNormal.inicio.next;
            cliente_normal.next = null;
            filaNormal.tamanho--;
        }
        if (filaNormal.inicio == null) {
            filaNormal.fim = null;
        }

        return cliente_atendido;
    }

}