package LibretaDeNotas;

import java.text.DecimalFormat;
import java.util.*;

public class LibretaDeNotas {
    public static void main(String[] args) {
        //Hashmap para almacenar las calificaciones de los estudiantes, donde la llave es el nombre y el valor es un Arraylist de notas
        //solicitas ingreso de cantidad de alumnos y la cantidad de notas por alumno
        //solicita el nombre de cada alumno y las notas correspondientes, almacenandolas en el hashmap
        //utilizar bucle para recorrer el hashmap de calificaciones

        //Despues de evaluar las calificaciones mostrar para cada estudiante:
        //      promedio de notas
        //      nota maxima
        //      nota minima
        //menu de opciones
        //      1 mostrar promedio de notas por estudiante
        //      2 mostrar si la nota es aprobatoria o reprobatoria
        //      3 mostrar si la nota esta por sobre o por debajo del promedio del curso
        //Validar que las notas ingresadas esten en un rango valido y que la cantidad de alumnos sea un numero positivo
        Double notaMax;
        Double notaMin;
        Double acumCantNotas = 0.0;
        Double acumuladorNota = 0.0;
        DecimalFormat df = new DecimalFormat("#.0");
        Scanner sc = new Scanner(System.in);
        Map<String, List> calificaciones = new HashMap<>();
        List<Double> notas = new ArrayList<>();//array notas
        List<Double> promedios = new ArrayList<>();
        System.out.println("Ingresa la cantidad de alumnos: ");
        Integer cantidadAlumnos = sc.nextInt();//dato cantida ingresado
        sc.nextLine();
        System.out.println("Ingresa la cantidad de notas: ");
        Integer cantidadNotas = sc.nextInt();
        sc.nextLine();//dato cantidad de notas
        if (cantidadAlumnos > 0) {
            for (int i = 0; i < cantidadAlumnos; i++) {
                notaMax = 0.0;
                notaMin = 7.0;
                notas.clear();
                System.out.println("Ingresa el nombre del alumno: ");
                String nombreAlumno = sc.nextLine();
                calificaciones.put(nombreAlumno, notas);
                double sumaNotas = 0;
                for (int j = 0; j < cantidadNotas; j++) {
                    System.out.println("Ingrese nota " + (j+1) + " del alumno " + nombreAlumno + ": ");
                    Double nota = sc.nextDouble();
                    sc.nextLine();
                    if (nota > 0 && nota <= 7) {
                        acumuladorNota = nota + acumuladorNota;
                        acumCantNotas = acumCantNotas + 1;
                        notas.add(nota);
                        if (nota > notaMax) {
                            notaMax = nota;
                        }
                        if (nota < notaMin) {
                            notaMin = nota;
                        }
                    }else {
                        System.out.println("Nota ingresada no valida");
                        j--;
                    }
                }

                for (Double k:notas)
                {
                    sumaNotas = sumaNotas+k;//Acumulador de notas
                }

                double promedio = sumaNotas/notas.size();
                promedios.add(promedio);
                System.out.println("El promedio de las notas de " + nombreAlumno + " es: " + df.format(promedio));
                System.out.println("La nota maxima de " + nombreAlumno + " es " + notaMax);
                System.out.println("La nota minima de " + nombreAlumno + " es " + notaMin);


            }
            Double notaApr = 3.9;
            boolean salir = false;
            while (!salir) {
                System.out.println("Menú:");
                System.out.println("1. Mostrar el Promedio de Notas por Estudiante.");
                System.out.println("2. Mostrar si la Nota es Aprobatoria o Reprobatoria por Estudiante.");
                System.out.println("3. Mostrar si la Nota está por Sobre o por Debajo del Promedio del Curso por Estudiante.");
                System.out.println("0. Salir del Menú.");
                System.out.print("Ingrese una opción: ");
                int opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion){
                    case 1:
                        for (int l = 0; l < cantidadAlumnos; l++) {
                            System.out.println("El promedio del alumno" + (l+1) + " es: " + promedios.get(l) );
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese nombre del alumno: :");
                        String nombreAlumnoP = sc.nextLine();
                        System.out.println("Ingrese nota:");
                        Double notaAlumnoP = sc.nextDouble();
                        sc.nextLine();
                        if (notaAlumnoP <= notaApr) {
                            System.out.println("Con esta nota reprobaste ");
                        }else {
                            System.out.println("Con esta nota aprobaste!");
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese nombre del alumno: :");
                        nombreAlumnoP = sc.nextLine();
                        System.out.println("Ingrese nota:");
                        notaAlumnoP = sc.nextDouble();
                        sc.nextLine();
                        Double promGeneral = acumuladorNota/acumCantNotas;
                        if (promGeneral <= notaAlumnoP) {
                            System.out.println("Estas por debajo del promedio de la clase ");
                        }else {
                            System.out.println("Estas por encima del promedio de la clase");
                        }
                        break;
                    case 0:
                        salir = true;
                        System.out.println("Saliendo del menú.");
                        break;
                }
            }
        } else if (cantidadAlumnos < 0) {
            System.out.println("Cantidad de notas ingresada no valida");
        }
    }
}
