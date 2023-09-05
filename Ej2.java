import java.util.Scanner;

import Ej2.entities.Tv;
import Ej2.entities.WashingMachine;
import Ej2.services.TvService;
import Ej2.services.WashingMachineService;


public class Ej2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        WashingMachineService wmserv = new WashingMachineService();
        TvService tvserv = new TvService();

        System.out.println("-------Let's generate a tv-------");
        Tv tv = tvserv.createTv(scan);
        System.out.println("-------Let's generate a Washing Machine-------");
        WashingMachine wm = wmserv.createWashingMachine(scan);

        System.out.println("The prices of the objects created are: ");
        System.out.println("Tv: " + tv.getPrice());
        System.out.println("Washing Machine: " + wm.getPrice());

        tvserv.finalPrice(tv);
        wmserv.finalPrice(wm);
        
        System.out.println("With the current pricing standards, the new prices are: ");
        System.out.println("Tv: " + tv.getPrice());
        System.out.println("Washing Machine: " + wm.getPrice());
    }
    
}


/**Crear una superclase llamada Electrodoméstico con los siguientes atributos: precio, color, consumo energético (letras entre A y F) y peso.
Los constructores que se deben implementar son los siguientes:
• Un constructor vacío.
• Un constructor con todos los atributos pasados por parámetro. Los métodos a implementar son:
• Métodos getters y setters de todos los atributos.
• Método comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta, sino es correcta usara la letra F por defecto.
Este método se debe invocar al crear el objeto y no será visible.
• Método comprobarColor(String color): comprueba que el color es correcto, y si no lo es, usa el color blanco por defecto.
Los colores disponibles para los electrodomésticos son blanco, negro, rojo, azul y gris. No importa si el nombre está en mayúsculas o en minúsculas.
Este método se invocará al crear el objeto y no será visible. */