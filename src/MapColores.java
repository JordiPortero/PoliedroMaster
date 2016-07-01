import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by professor on 27/06/2016.
 */
public class MapColores {

    private static Map<String, List< Cubo>> mapColores = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero de poliedros, para cada tipo:  ");
        int numero = sc.nextInt();
        obtenerCubos(sc, numero, "rojo");
        obtenerCubos(sc, numero, "verde");
        obtenerCubos(sc, numero, "amarillo");
        System.out.println(mapColores);


    }

    private static void obtenerCubos(Scanner sc, int numero, String color) {
        List<Cubo> coloresList = new ArrayList<>();
        for (int i = 1; i <= numero; i++)

        {
            System.out.println("Introduce los datos del cubo " + i);
            System.out.println("Introduce la arista:");
            double arista = sc.nextDouble();



            Cubo cubo = new Cubo(arista, +i, color);

            coloresList.add(cubo);//añadimos el arraylist particular
            //guardamos el cubo una sola vez. No esta por duplicado.


        }
        mapColores.put(color,coloresList);

    }


}







