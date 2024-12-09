import java.util.ArrayList;
import java.util.Scanner;

class Equipo {
    public String nombre;
    public String entrenador;
    public ArrayList<String> jugadores;

    public Equipo(String nombre, String entrenador) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(String jugador) {
        jugadores.add(jugador);
    }

    public void mostrarEquipo() {
        System.out.println("Equipo: " + nombre);
        System.out.println("Entrenador: " + entrenador);
        System.out.println("Jugadores: " + jugadores);
    }
}

class Partido {
    public String equipo1;
    public String equipo2;
    public String fecha;
    public String estado; // "Pendiente" o "Finalizado"
    public String resultado;

    public Partido(String equipo1, String equipo2, String fecha, String resultado) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fecha = fecha;
        this.estado = "Finalizado"; // Ahora siempre se ingresa el resultado
        this.resultado = resultado;
    }

    public void mostrarPartido() {
        System.out.println("Partido: " + equipo1 + " vs " + equipo2);
        System.out.println("Fecha: " + fecha);
        System.out.println("Estado: " + estado);
        System.out.println("Resultado: " + resultado);
    }
}

public class GestionTorneos {
    public ArrayList<Equipo> equipos;
    public ArrayList<Partido> partidos;

    public GestionTorneos() {
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public void registrarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void registrarPartido(Partido partido) {
        partidos.add(partido);
    }

    public void listarEquipos() {
        for (Equipo equipo : equipos) {
            equipo.mostrarEquipo();
        }
    }

    public void listarPartidos() {
        for (Partido partido : partidos) {
            partido.mostrarPartido();
        }
    }

    public static void main(String[] args) {
        GestionTorneos gestion = new GestionTorneos();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gestión de Torneos - Registro de Equipos y Partidos");

        // Registrar Equipos
        System.out.println("\nRegistro de Equipos:");
        for (int i = 1; i <= 2; i++) {
            System.out.print("Ingrese el nombre del equipo " + i + ": ");
            String nombreEquipo = scanner.nextLine();
            System.out.print("Ingrese el nombre del entrenador del equipo " + i + ": ");
            String entrenador = scanner.nextLine();
            Equipo equipo = new Equipo(nombreEquipo, entrenador);

            System.out.println("Ingrese los nombres de 5 jugadores para el equipo " + nombreEquipo + ":");
            for (int j = 1; j <= 5; j++) {
                System.out.print("Jugador " + j + ": ");
                String jugador = scanner.nextLine();
                equipo.agregarJugador(jugador);
            }

            gestion.registrarEquipo(equipo);
        }

        // Registrar Partido
        System.out.println("\nRegistro de un Partido:");
        System.out.print("Ingrese el nombre del primer equipo que jugará: ");
        String equipoPartido1 = scanner.nextLine();
        System.out.print("Ingrese el nombre del segundo equipo que jugará: ");
        String equipoPartido2 = scanner.nextLine();
        System.out.print("Ingrese la fecha del partido (dd/mm/aaaa): ");
        String fecha = scanner.nextLine();
        System.out.print("Ingrese el resultado del partido (Ejemplo: 2-1): ");
        String resultado = scanner.nextLine();

        Partido partido = new Partido(equipoPartido1, equipoPartido2, fecha, resultado);
        gestion.registrarPartido(partido);

        // Mostrar Información
        System.out.println("\nEquipos Registrados:");
        gestion.listarEquipos();

        System.out.println("\nPartidos Registrados:");
        gestion.listarPartidos();

        scanner.close();
    }
}
