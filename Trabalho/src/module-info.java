import java.util.Scanner;

class Animal {
    private String nome;
    private String classe;
    private String familia;
    private int idade;
    private boolean vivo;
    private int caloria;
    private int força;

    public Animal(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0;
        this.vivo = true;
        this.caloria = 10;
        this.força = 10;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void exibirStatus() {
        System.out.println("Status do " + nome + ": Força = " + força + ", Caloria = " + caloria + ", Idade = " + idade + (vivo ? ", Vivo" : ", Morto"));
    }

    public void comer() {
        if (!vivo) {
            System.out.println("O " + nome + " está morto e não pode comer.");
            return;
        }
        if (caloria >= 100) {
            System.out.println("O " + nome + " está cheio e não pode comer mais.");
        } else {
            caloria = Math.min(100, caloria + 10);
            força = Math.max(0, força - 2);
            System.out.println("O " + nome + " comeu e agora sua força é " + força + " e suas calorias valem " + caloria + ".");
        }
    }

    public void correr() {
        if (!vivo) {
            System.out.println("O " + nome + " está morto e não pode correr.");
            return;
        }
        if (caloria <= 0 || força <= 0) {
            System.out.println("O " + nome + " está exausto e não pode correr.");
        } else {
            caloria = Math.max(0, caloria - 5);
            força = Math.max(0, força - 5);
            System.out.println("O " + nome + " está correndo!! Agora sua força é de " + força + " e suas calorias valem " + caloria + ".");
        }
    }

    public void dormir() {
        if (!vivo) {
            System.out.println("O " + nome + " está morto e não pode dormir.");
            return;
        }
        força = Math.min(100, força + 10);
        caloria = Math.max(0, caloria - 2);
        System.out.println("O " + nome + " está dormindo agora! Sua força aumentou para " + força + " e suas calorias diminuíram para " + caloria + ".");
    }

    public void morrer() {
        força = 0;
        vivo = false;
        System.out.println("O " + nome + " morreu!");
    }
}

public class BichinhoVirtual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cadastro do animal
        System.out.println("Crie seu novo animal");
        System.out.print("Insira o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Insira a classe: ");
        String classe = scanner.nextLine();
        System.out.print("Insira a família: ");
        String familia = scanner.nextLine();

        Animal animal = new Animal(nome, classe, familia);
        System.out.println("O animal se chama " + nome + ", é da classe " + classe + " da família " + familia + ". O animal possui força 10, caloria de 10 e idade 0.");

        while (animal.isVivo()) {
            animal.exibirStatus();
            System.out.println("O que o " + nome + " vai fazer agora?");
            System.out.println("1- Comer");
            System.out.println("2- Correr");
            System.out.println("3- Dormir");
            System.out.println("4- Morrer");
            System.out.print("Escolha uma opção: ");
            
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    animal.comer();
                    break;
                case 2:
                    animal.correr();
                    break;
                case 3:
                    animal.dormir();
                    break;
                case 4:
                    animal.morrer();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

        System.out.println("GAME OVER!");
        scanner.close();
    }
}
