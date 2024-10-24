
import java.util.Scanner;

public class GeneraPC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Array de componentes

        String[][] componentesPc = {
                {"AAA", "Placa Madre", "20000", "S"},
                {"BBB", "Procesador", "25000", "S"},
                {"CCC", "Memoria RAM", "5000", "S"},
                {"DDD", "Placa de Red", "3000", "N"},
                {"EEE", "Disco Rígido SSD", "22000", "S"},
                {"FFF", "Placa de Video", "42000", "N"},
                {"GGG", "Monitor Led 21", "32000", "N"},
                {"HHH", "Monitor Led 24", "41000", "N"},
                {"JJJ", "Kit Teclado - Mouse", "9000", "N"},
                {"KKK", "Gabinete", "6500", "S"},
                {"LLL", "Fuente Alimentación", "6500", "S"},
                {"MMM", "Placa de Sonido", "16500", "N"}};


        //Cree una instancia de la clase Computadora, solicite al usuario y asigne únicamente los
        //correspondientes atributos marca, modelo, y código de barras. Valide que el código de
        //barras tenga entre 7 y 15 caracteres inclusive, caso contrario solicite nuevamente el código
        //de barras
        Computadora pc = new Computadora();
        System.out.println("Ingrese la marca de la computadora");
        pc.setMarca(scanner.nextLine());

        System.out.println("Ingrese el modelo de la computadora");
        pc.setModelo(scanner.nextLine());

        long codigoBarras;
        do {
            System.out.println("Ingrese el código de barras `entre 7 y 15 dígitos´");
            codigoBarras = scanner.nextLong();
        } while (String.valueOf(codigoBarras).length() < 7 || String.valueOf(codigoBarras).length() > 15);
        pc.setCodigoBarras(codigoBarras);

        //Solicite al usuario que indique la cantidad de componentes que tendrá la computadora.
        //Valide que sea mayor o igual a 5 y menor o igual a 12, caso contrario solicite nuevamente la
        //cantidad.

        int cantidadComponentes;
        do {
            System.out.println("Ingrese el la cantidad de componentes `entre 5 y 12´");
            cantidadComponentes = scanner.nextInt();
        } while (cantidadComponentes < 5 || cantidadComponentes > 12);
        pc.setCodigoBarras(codigoBarras);

        //Inicialice el atributo componentes de la clase Computadora con el tamaño de la matriz, que
        //será equivalente a la cantidad de artículos ingresados en el punto anterior por 4 columnas
        //que se corresponderán con:
        //Código Componente / Denominación / Precio Componente / Es obligatorio
        //Nota Ayuda: una forma sencilla de hacer esto es a través de un metodo publico codificado
        //en la clase Computadora

        pc.inicializarComponentes(cantidadComponentes);
        scanner.nextLine();
        for (int i = 0; i < cantidadComponentes; i++) {
            String codigo;
            boolean componenteValido;
            do {
                componenteValido = true;
                System.out.println("Ingrese el código del componente");
                codigo = scanner.nextLine();

                //buscar componente en el array de componentes disponibles
                boolean encontrado = false;
                for (String[] componente : componentesPc) {
                    if (componente[0].equals(codigo)) {
                        encontrado = true;
                        //verificar si ya fue agregado
                        for (int j = 0; j < i; j++) {
                            if (pc.getComponentes()[j][0].equals(codigo)) {
                                System.out.println("El componente ya fue agregado anteriormente");
                                componenteValido = false;
                                break;
                            }
                        }
                        //si es valido, agregar componente
                        if (componenteValido) {
                            pc.agregarComponente(componente, i);
                        }
                        break;
                    }
                }
                if (!encontrado){
                    System.out.println("El código ingresado es incorrecto.");
                    componenteValido= false;
                }
            } while (!componenteValido);
        }
        //verificacion de componentes obligatorios y cálculo de recargo
        boolean recargo = false;
        for (String[] componente : componentesPc){
            if (componente[3].equals("S")){
                boolean encontrado = false;
                for (String[] agregado : pc.getComponentes()) {
                    if (agregado[0].equals(componente[0])) {
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado){
                    recargo = true;
                    break;
                }
            }
        }
        //calculo del monto final
        double montoFinal = 0;
        for (String[] componente : pc.getComponentes()){
            montoFinal += Double.parseDouble(componente[2]);
        }
        if (recargo){
            System.out.println("“Atención, 1 o más de los componentes obligatorios no fueron agregados, por este motivo se cobrara un recargo del 20%”");
            montoFinal *= 1.20;
        }
        pc.setMontoFinal(montoFinal);

        //mostrar resultado final
        System.out.println("La computadora especificada es:");
        System.out.println("Marca: " + pc.getMarca());
        System.out.println("Modelo: " + pc.getModelo());
        System.out.println("Monto final: $" + pc.getMontoFinal());
    }
}




