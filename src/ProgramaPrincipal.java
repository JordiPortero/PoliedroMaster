import java.util.*;

public class ProgramaPrincipal {

    public static final String OCTAEDROS = "Octaedros";
    public static final String TETRAEDROS = "Tetraedros";
    public static final String CUBOS = "Cubos";

    private static Map<String,List<? extends Poliedro>> mapPoliedros =new HashMap<>();

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        List<Poliedro> arrayList = new ArrayList<>();
        System.out.println("Introduce el numero de poliedros, para cada tipo:  ");
        int numero = sc.nextInt();




        obtenerCubo(sc, arrayList, numero);

        obtenerOctaedros(sc, arrayList, numero);

        obtenerTetraedros(sc, arrayList, numero);


        procesarPoliedros(arrayList, numero);


        mostrarMapPoliedros();

        consultarMapPoliedros(CUBOS);


    }

    private static void consultarMapPoliedros(String tipoPoliedro) {
        List<Poliedro> poliedroList = (List<Poliedro>)mapPoliedros.get(tipoPoliedro);
        System.out.println("La lista de "+tipoPoliedro+" es: ");
        System.out.println(poliedroList);
        //System.out.println(mapPoliedros.get(CUBOS));
    }

    private static void mostrarMapPoliedros() {
        System.out.println("Map de poliedros: ");
        System.out.println(mapPoliedros);
    }

    private static void procesarPoliedros(List<Poliedro> arrayList, int numero) {
        Poliedro max = null;
        Poliedro min = null;
        double totalVolumen = 0.0;
        int cont20to = 0;
        int cont20to100 = 0;
        int contOver100 = 0;

        int controjo = 0;
        int contverde = 0;
        int contazul = 0;
        int contamarillo = 0;
        int contblanco = 0;


        for (Poliedro poliedro : arrayList) // recorremos el array
        {
            double volumenActual = poliedro.calculaVolumen();
            //double perimetro = figuraGeometrica.calculaPerimetro();
            System.out.println("El volumen de la figura geometrica " + poliedro.getId() + " es = " + volumenActual);
            //System.out.println("El perimetro de la figura geometrica " + " es =" + perimetro);

            totalVolumen = totalVolumen + volumenActual;

            if (poliedro instanceof Cubo) {
                Cubo cubo = (Cubo) poliedro;
                double diagonal = cubo.calculaDiagonal();
                System.out.println("La diagonal del cubo es= " + diagonal);

            }

            if (max == null) {
                max = poliedro;
            } else {
                if (volumenActual > max.calculaVolumen()) {
                    max = poliedro;
                }
            }

            if (min == null) {
                min = poliedro;
            } else {
                if (volumenActual < min.calculaVolumen()) {
                    min = poliedro;
                }
            }

            if (volumenActual <= 20) {
                cont20to++;
            } else if (volumenActual <= 100) {
                cont20to100++;
            } else {
                contOver100++;
            }


            if (poliedro.getColor().equals("rojo")) {
                controjo++;
            }
            if (poliedro.getColor().equals("verde")) {
                contverde++;
            }
            if (poliedro.getColor().equals("azul")) {
                contazul++;
            }
            if (poliedro.getColor().equals("amarillo")) {
                contamarillo++;
            }
            if (poliedro.getColor().equals("blanco")) {
                contblanco++;
            }
        }


        int totalFiguras = numero * 3;
        double media = totalVolumen / totalFiguras;
        System.out.println("La media del volumen de las figuras geometricas es: " + media);
        System.out.println("El poliedro con volumen maximo es: " + max);
        System.out.println("El poliedro con volumen min es " + min);

        System.out.println("El numero de figuras con volumen inferior a 20 es:" + cont20to);
        System.out.println("El numero de figuras con volumen entre 20 y 100 es:" + cont20to100);
        System.out.println("El numero de figuras con volumen superior a 100 es:" + contOver100);

        System.out.println("El numero de poliedros de color rojo es: " + controjo);
        System.out.println("El numero de poliedros de color verde es: " + contverde);
        System.out.println("El numero de poliedros de color azul es: " + contazul);
        System.out.println("El numero de poliedros de color amarillo es: " + contamarillo);
        System.out.println("El numero de poliedros de color blanco es: " + contblanco);
    }

    private static void obtenerTetraedros(Scanner sc, List<Poliedro> arrayList, int numero) {
        List<Tetraedro> tetraedroList = new ArrayList<>();
        for (int i = 1; i <= numero; i++)

        {
            System.out.println("Introduce los datos del Tetraedro " + i);
            System.out.println("Introduce la arista:");
            double arista = sc.nextDouble();
            String colorSeleccionado = solicitarColor();
            System.out.println("El color seleccionado es: " + colorSeleccionado);

            Tetraedro tetraedro = new Tetraedro(arista,  i + numero * 2, colorSeleccionado);
            arrayList.add(tetraedro);
            tetraedroList.add(tetraedro);
        }
        mapPoliedros.put(TETRAEDROS,tetraedroList);
    }

    private static void obtenerOctaedros(Scanner sc, List<Poliedro> arrayList, int numero) {
        List<Octaedro> octaedroList=new ArrayList<>();
        for (int i = 1; i <= numero; i++)

        {
            System.out.println("Introduce los datos del Octaedro " + i);
            System.out.println("Introduce la arista:");
            double arista = sc.nextDouble();
            String colorSeleccionado = solicitarColor();
            System.out.println("El color seleccionado es: "+colorSeleccionado);

            Octaedro octaedro = new Octaedro(arista, i + numero, colorSeleccionado);
            arrayList.add(octaedro);
            octaedroList.add(octaedro);
        }
        mapPoliedros.put(OCTAEDROS, octaedroList);
    }

    private static void obtenerCubo(Scanner sc, List<Poliedro> arrayList, int numero) {
        List<Cubo> cuboList = new ArrayList<>();
        for (int i = 1; i <= numero; i++)

        {
            System.out.println("Introduce los datos del cubo " + i);
            System.out.println("Introduce la arista:");
            double arista = sc.nextDouble();
            String colorSeleccionado = solicitarColor();
            System.out.println("El color seleccionado es: " + colorSeleccionado);

            Cubo cubo = new Cubo(arista, +i, colorSeleccionado);
            arrayList.add(cubo);//aádimos el cubo al arraylist gral
            cuboList.add(cubo);//añadimos el arraylist particular
            //guardamos el cubo una sola vez. No esta por duplicado.


        }
        mapPoliedros.put(CUBOS,cuboList);
    }

    private static String solicitarColor() {
        // crear con el scanner una petición
        // el usuario debera introducir el numero entero de 1 a 5
        // por lo tanto se mostrará un menu del estilo de :
        //1.azul 2.blanco 3.rojo 4.verde 5.naranja
        //si selecciona el cuatro, se debera devolver 4.verde

        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un numero del 1 al 5 para el color: ");
        int colorSeleccionado = sc.nextInt();
        switch (colorSeleccionado) {
            case 1:
                return "rojo";


            case 2:
                return "verde";

            case 3:
                return "azul";


            case 4:
                return "amarillo";


            case 5:
                return "blanco";


           default:
             return "Error, introduce un numero del 1 al 5";


        }


    }
}




