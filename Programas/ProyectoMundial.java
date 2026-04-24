import java.util.Scanner;

public class ProyectoMundial {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String RESET = "\u001B[0m";
        String BG_BLACK = "\u001B[40m";
        String BG_RED = "\u001B[41m";
        String BG_GREEN = "\u001B[42m";
        String BG_YELLOW = "\u001B[43m";
        String BG_BLUE = "\u001B[44m";
        String BG_WHITE = "\u001B[47m";
        String BG_CYAN = "\u001B[46m";

        String[] grupos = {
            "A","B","C","D","E","F",
            "G","H","I","J","K","L"
        };

        String[][] paises = {
            {"Mexico","Sudafrica","Corea","Chequia"},
            {"Canada","Bosnia","Qatar","Suiza"},
            {"Brasil","Marruecos","Haiti","Escocia"},
            {"EEUU","Paraguay","Australia","Turquia"},
            {"Alemania","Curazao","Costa de Marfil","Ecuador"},
            {"Paises Bajos","Japon","Suecia","Tunez"},
            {"Belgica","Egipto","Iran","Nueva Zelanda"},
            {"Espana","Cabo Verde","Arabia Saudita","Uruguay"},
            {"Francia","Senegal","Irak","Noruega"},
            {"Argentina","Argelia","Austria","Jordania"},
            {"Portugal","RD Congo","Uzbekistan","Colombia"},
            {"Inglaterra","Croacia","Ghana","Panama"}
        };

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE BANDERAS MUNDIAL 2026 =====");
            System.out.println("1. Ver grupos");
            System.out.println("2. Imprimir UNA bandera");
            System.out.println("3. Imprimir UN grupo");
            System.out.println("4. Imprimir TODAS las banderas");
            System.out.println("0. Salir");
            System.out.print("Escoge una opcion: ");

            while (!sc.hasNextInt()) {
                System.out.print("Ingresa un numero valido: ");
                sc.next();
            }
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("\n===== LISTA DE GRUPOS =====");
                    for (int i = 0; i < grupos.length; i++) {
                        System.out.println("\nGRUPO " + grupos[i]);
                        for (int j = 0; j < paises[i].length; j++) {
                            System.out.println("  " + (j + 1) + ". " + paises[i][j]);
                        }
                    }
                    break;

                case 2:
                case 3:
                case 4:

                    System.out.println("\nEscoge el tamaño de la bandera:");
                    System.out.println("1. Miniatura");
                    System.out.println("2. Pequena");
                    System.out.println("3. Mediana");
                    System.out.println("4. Grande");
                    System.out.print("Tu opcion: ");

                    while (!sc.hasNextInt()) {
                        System.out.print("Ingresa un numero valido: ");
                        sc.next();
                    }
                    int t = sc.nextInt();

                    int f = 0;
                    int c = 0;

                    if (t == 1) { f = 3;  c = 9;  }
                    else if (t == 2) { f = 6;  c = 18; }
                    else if (t == 3) { f = 9;  c = 27; }
                    else if (t == 4) { f = 12; c = 36; }
                    else {
                        System.out.println("Tamaño invalido.");
                        break;
                    }

                    int gInicio = 0;
                    int gFin = grupos.length;
                    int pInicio = 0;
                    int pFin = 0;

                    if (opcion == 2 || opcion == 3) {
                        System.out.println("\nEscoge el grupo:");
                        for (int i = 0; i < grupos.length; i++) {
                            System.out.println((i + 1) + ". Grupo " + grupos[i]);
                        }
                        System.out.print("Tu opcion: ");

                        while (!sc.hasNextInt()) {
                            System.out.print("Ingresa un numero valido: ");
                            sc.next();
                        }
                        int g = sc.nextInt() - 1;

                        if (g < 0 || g >= grupos.length) {
                            System.out.println("Grupo invalido.");
                            break;
                        }

                        gInicio = g;
                        gFin = g + 1;

                        if (opcion == 2) {
                            System.out.println("\nEscoge la bandera del grupo " + grupos[g] + ":");
                            for (int i = 0; i < paises[g].length; i++) {
                                System.out.println((i + 1) + ". " + paises[g][i]);
                            }
                            System.out.print("Tu opcion: ");

                            while (!sc.hasNextInt()) {
                                System.out.print("Ingresa un numero valido: ");
                                sc.next();
                            }
                            int p = sc.nextInt() - 1;

                            if (p < 0 || p >= paises[g].length) {
                                System.out.println("Pais invalido.");
                                break;
                            }

                            pInicio = p;
                            pFin = p + 1;
                        } else {
                            pInicio = 0;
                            pFin = paises[g].length;
                        }

                    } else {
                        pInicio = 0;
                        pFin = 4;
                    }

                    for (int g = gInicio; g < gFin; g++) {

                        System.out.println("\n===== GRUPO " + grupos[g] + " =====");

                        for (int p = pInicio; p < pFin; p++) {

                            String pais = paises[g][p];
                            System.out.println("\nBandera de: " + pais);

                            char[][] base = null;

                            // ===== TODAS LAS BANDERAS =====

                            if (pais.equals("Mexico")) {
                                base = new char[][]{
                                    {'G','G','W','W','R','R'},
                                    {'G','G','W','W','R','R'},
                                    {'G','G','W','W','R','R'}
                                };
                            }

                            else if (pais.equals("Sudafrica")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','G','G','Y','B','B'},
                                    {'K','G','G','Y','B','B'},
                                    {'K','G','G','Y','B','B'},
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'}
                                };
                            }

                            else if (pais.equals("Corea")) {
                                base = new char[][]{
                                    {'W','W','W','W','W','W'},
                                    {'W','W','R','R','W','W'},
                                    {'W','R','R','B','B','W'},
                                    {'W','B','B','R','R','W'},
                                    {'W','W','B','B','W','W'},
                                    {'W','W','W','W','W','W'}
                                };
                            }

                            else if (pais.equals("Chequia")) {
                                base = new char[][]{
                                    {'W','W','W','W','W','W'},
                                    {'B','W','W','W','W','W'},
                                    {'B','B','W','W','W','W'},
                                    {'B','B','R','R','R','R'},
                                    {'B','R','R','R','R','R'},
                                    {'R','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Canada")) {
                                base = new char[][]{
                                    {'R','R','W','W','R','R'},
                                    {'R','R','W','W','R','R'},
                                    {'R','R','W','R','R','R'},
                                    {'R','R','R','R','W','R'},
                                    {'R','R','W','W','R','R'},
                                    {'R','R','W','W','R','R'}
                                };
                            }

                            else if (pais.equals("Bosnia")) {
                                base = new char[][]{
                                    {'B','B','B','Y','Y','Y'},
                                    {'B','B','B','B','Y','Y'},
                                    {'B','B','B','B','B','Y'},
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'}
                                };
                            }

                            else if (pais.equals("Qatar")) {
                                base = new char[][]{
                                    {'W','R','R','R','R','R'},
                                    {'W','R','R','R','R','R'},
                                    {'W','R','R','R','R','R'},
                                    {'W','R','R','R','R','R'},
                                    {'W','R','R','R','R','R'},
                                    {'W','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Suiza")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','R','W','W','R','R'},
                                    {'R','W','W','W','W','R'},
                                    {'R','R','W','W','R','R'},
                                    {'R','R','W','W','R','R'},
                                    {'R','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Brasil")) {
                                base = new char[][]{
                                    {'G','G','G','G','G','G'},
                                    {'G','G','Y','Y','G','G'},
                                    {'G','Y','Y','Y','Y','G'},
                                    {'G','Y','B','B','Y','G'},
                                    {'G','G','Y','Y','G','G'},
                                    {'G','G','G','G','G','G'}
                                };
                            }

                            else if (pais.equals("Marruecos")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','R','G','G','R','R'},
                                    {'R','G','R','R','G','R'},
                                    {'R','G','R','R','G','R'},
                                    {'R','R','G','G','R','R'},
                                    {'R','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Haiti")) {
                                base = new char[][]{
                                    {'B','B','B','B','B','B'},
                                    {'B','B','W','W','B','B'},
                                    {'B','B','W','W','B','B'},
                                    {'R','R','W','W','R','R'},
                                    {'R','R','W','W','R','R'},
                                    {'R','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Escocia")) {
                                base = new char[][]{
                                    {'W','B','B','B','B','W'},
                                    {'B','W','B','B','W','B'},
                                    {'B','B','W','W','B','B'},
                                    {'B','B','W','W','B','B'},
                                    {'B','W','B','B','W','B'},
                                    {'W','B','B','B','B','W'}
                                };
                            }

                            else if (pais.equals("EEUU")) {
                                base = new char[][]{
                                    {'B','B','R','R','R','R'},
                                    {'B','B','W','W','W','W'},
                                    {'R','R','R','R','R','R'},
                                    {'W','W','W','W','W','W'},
                                    {'R','R','R','R','R','R'},
                                    {'W','W','W','W','W','W'}
                                };
                            }

                            else if (pais.equals("Paraguay")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','R','R','R','R','R'},
                                    {'W','W','W','W','W','W'},
                                    {'W','W','W','W','W','W'},
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'}
                                };
                            }

                            else if (pais.equals("Australia")) {
                                base = new char[][]{
                                    {'B','B','B','B','B','B'},
                                    {'B','W','B','B','W','B'},
                                    {'B','B','B','W','B','B'},
                                    {'B','B','W','B','B','B'},
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'}
                                };
                            }

                            else if (pais.equals("Turquia")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','W','W','R','R','R'},
                                    {'R','W','R','W','R','R'},
                                    {'R','W','R','W','R','R'},
                                    {'R','W','W','R','R','R'},
                                    {'R','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Alemania")) {
                                base = new char[][]{
                                    {'K','K','K','K','K','K'},
                                    {'K','K','K','K','K','K'},
                                    {'R','R','R','R','R','R'},
                                    {'R','R','R','R','R','R'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'Y','Y','Y','Y','Y','Y'}
                                };
                            }

                            else if (pais.equals("Curazao")) {
                                base = new char[][]{
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'}
                                };
                            }

                            else if (pais.equals("Costa de Marfil")) {
                                base = new char[][]{
                                    {'R','R','W','W','G','G'},
                                    {'R','R','W','W','G','G'},
                                    {'R','R','W','W','G','G'},
                                    {'R','R','W','W','G','G'},
                                    {'R','R','W','W','G','G'},
                                    {'R','R','W','W','G','G'}
                                };
                            }

                            else if (pais.equals("Ecuador")) {
                                base = new char[][]{
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'B','B','B','B','B','B'},
                                    {'R','R','R','R','R','R'},
                                    {'R','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Paises Bajos")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','R','R','R','R','R'},
                                    {'W','W','W','W','W','W'},
                                    {'W','W','W','W','W','W'},
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'}
                                };
                            }

                            else if (pais.equals("Japon")) {
                                base = new char[][]{
                                    {'W','W','W','W','W','W'},
                                    {'W','W','R','R','W','W'},
                                    {'W','R','R','R','R','W'},
                                    {'W','R','R','R','R','W'},
                                    {'W','W','R','R','W','W'},
                                    {'W','W','W','W','W','W'}
                                };
                            }

                            else if (pais.equals("Suecia")) {
                                base = new char[][]{
                                    {'B','B','Y','B','B','B'},
                                    {'B','B','Y','B','B','B'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'B','B','Y','B','B','B'},
                                    {'B','B','Y','B','B','B'},
                                    {'B','B','Y','B','B','B'}
                                };
                            }

                            else if (pais.equals("Tunez")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','R','W','W','R','R'},
                                    {'R','W','W','W','W','R'},
                                    {'R','W','W','W','W','R'},
                                    {'R','R','W','W','R','R'},
                                    {'R','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Belgica")) {
                                base = new char[][]{
                                    {'K','K','Y','Y','R','R'},
                                    {'K','K','Y','Y','R','R'},
                                    {'K','K','Y','Y','R','R'},
                                    {'K','K','Y','Y','R','R'},
                                    {'K','K','Y','Y','R','R'},
                                    {'K','K','Y','Y','R','R'}
                                };
                            }

                            else if (pais.equals("Egipto")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','R','R','R','R','R'},
                                    {'W','W','W','W','W','W'},
                                    {'W','W','W','W','W','W'},
                                    {'K','K','K','K','K','K'},
                                    {'K','K','K','K','K','K'}
                                };
                            }

                            else if (pais.equals("Iran")) {
                                base = new char[][]{
                                    {'G','G','G','G','G','G'},
                                    {'G','G','G','G','G','G'},
                                    {'W','W','W','W','W','W'},
                                    {'W','W','W','W','W','W'},
                                    {'R','R','R','R','R','R'},
                                    {'R','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Nueva Zelanda")) {
                                base = new char[][]{
                                    {'B','B','B','B','B','B'},
                                    {'B','R','B','B','R','B'},
                                    {'B','B','B','R','B','B'},
                                    {'B','B','R','B','B','B'},
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'}
                                };
                            }

                            else if (pais.equals("Espana")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'R','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Cabo Verde")) {
                                base = new char[][]{
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'},
                                    {'W','W','W','W','W','W'},
                                    {'R','R','R','R','R','R'},
                                    {'W','W','W','W','W','W'},
                                    {'G','G','G','G','G','G'}
                                };
                            }

                            else if (pais.equals("Arabia Saudita")) {
                                base = new char[][]{
                                    {'G','G','G','G','G','G'},
                                    {'G','G','G','G','G','G'},
                                    {'G','W','W','W','W','G'},
                                    {'G','W','W','W','W','G'},
                                    {'G','G','G','G','G','G'},
                                    {'G','G','G','G','G','G'}
                                };
                            }

                            else if (pais.equals("Uruguay")) {
                                base = new char[][]{
                                    {'W','W','W','W','W','W'},
                                    {'B','B','B','B','B','B'},
                                    {'W','W','W','W','W','W'},
                                    {'B','B','B','B','B','B'},
                                    {'W','W','W','W','W','W'},
                                    {'B','B','B','B','B','B'}
                                };
                            }

                            else if (pais.equals("Francia")) {
                                base = new char[][]{
                                    {'B','B','W','W','R','R'},
                                    {'B','B','W','W','R','R'},
                                    {'B','B','W','W','R','R'},
                                    {'B','B','W','W','R','R'},
                                    {'B','B','W','W','R','R'},
                                    {'B','B','W','W','R','R'}
                                };
                            }

                            else if (pais.equals("Senegal")) {
                                base = new char[][]{
                                    {'G','G','Y','Y','R','R'},
                                    {'G','G','Y','Y','R','R'},
                                    {'G','G','Y','Y','R','R'},
                                    {'G','G','Y','Y','R','R'},
                                    {'G','G','Y','Y','R','R'},
                                    {'G','G','Y','Y','R','R'}
                                };
                            }

                            else if (pais.equals("Irak")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','R','R','R','R','R'},
                                    {'W','W','W','W','W','W'},
                                    {'W','W','W','W','W','W'},
                                    {'K','K','K','K','K','K'},
                                    {'K','K','K','K','K','K'}
                                };
                            }

                            else if (pais.equals("Noruega")) {
                                base = new char[][]{
                                    {'R','R','B','R','R','R'},
                                    {'R','R','B','R','R','R'},
                                    {'B','B','B','B','B','B'},
                                    {'R','R','B','R','R','R'},
                                    {'R','R','B','R','R','R'},
                                    {'R','R','B','R','R','R'}
                                };
                            }

                            else if (pais.equals("Argentina")) {
                                base = new char[][]{
                                    {'C','C','C','C','C','C'},
                                    {'C','C','C','C','C','C'},
                                    {'W','W','W','W','W','W'},
                                    {'W','W','Y','Y','W','W'},
                                    {'C','C','C','C','C','C'},
                                    {'C','C','C','C','C','C'}
                                };
                            }

                            else if (pais.equals("Argelia")) {
                                base = new char[][]{
                                    {'G','G','G','W','W','W'},
                                    {'G','G','G','W','W','W'},
                                    {'G','G','G','W','W','W'},
                                    {'G','G','G','W','W','W'},
                                    {'G','G','G','W','W','W'},
                                    {'G','G','G','W','W','W'}
                                };
                            }

                            else if (pais.equals("Austria")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','R','R','R','R','R'},
                                    {'W','W','W','W','W','W'},
                                    {'W','W','W','W','W','W'},
                                    {'R','R','R','R','R','R'},
                                    {'R','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Jordania")) {
                                base = new char[][]{
                                    {'K','K','K','K','K','K'},
                                    {'W','W','W','W','W','W'},
                                    {'G','G','G','G','G','G'},
                                    {'R','R','R','G','G','G'},
                                    {'R','R','W','W','W','W'},
                                    {'R','R','K','K','K','K'}
                                };
                            }

                            else if (pais.equals("Portugal")) {
                                base = new char[][]{
                                    {'G','G','R','R','R','R'},
                                    {'G','G','R','R','R','R'},
                                    {'G','G','R','R','R','R'},
                                    {'G','G','R','R','R','R'},
                                    {'G','G','R','R','R','R'},
                                    {'G','G','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("RD Congo")) {
                                base = new char[][]{
                                    {'B','B','Y','R','B','B'},
                                    {'B','Y','R','B','B','B'},
                                    {'Y','R','B','B','B','B'},
                                    {'R','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'}
                                };
                            }

                            else if (pais.equals("Uzbekistan")) {
                                base = new char[][]{
                                    {'B','B','B','B','B','B'},
                                    {'W','W','W','W','W','W'},
                                    {'R','R','R','R','R','R'},
                                    {'W','W','W','W','W','W'},
                                    {'G','G','G','G','G','G'},
                                    {'G','G','G','G','G','G'}
                                };
                            }

                            else if (pais.equals("Colombia")) {
                                base = new char[][]{
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'B','B','B','B','B','B'},
                                    {'R','R','R','R','R','R'},
                                    {'R','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Inglaterra")) {
                                base = new char[][]{
                                    {'W','W','R','R','W','W'},
                                    {'W','W','R','R','W','W'},
                                    {'R','R','R','R','R','R'},
                                    {'R','R','R','R','R','R'},
                                    {'W','W','R','R','W','W'},
                                    {'W','W','R','R','W','W'}
                                };
                            }

                            else if (pais.equals("Croacia")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','R','R','R','R','R'},
                                    {'W','W','B','B','W','W'},
                                    {'W','W','B','B','W','W'},
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'}
                                };
                            }

                            else if (pais.equals("Ghana")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','R','R','R','R','R'},
                                    {'Y','Y','K','K','Y','Y'},
                                    {'Y','Y','K','K','Y','Y'},
                                    {'G','G','G','G','G','G'},
                                    {'G','G','G','G','G','G'}
                                };
                            }

                            else if (pais.equals("Panama")) {
                                base = new char[][]{
                                    {'W','W','R','R'},
                                    {'W','W','R','R'},
                                    {'B','B','W','W'},
                                    {'B','B','W','W'}
                                };
                            }

                            else {
                                base = new char[][]{
                                    {'R','R','R'},
                                    {'R','R','R'},
                                    {'R','R','R'}
                                };
                            }

                            char[][] bandera = new char[f][c];

                            for (int i = 0; i < f; i++) {
                                for (int j = 0; j < c; j++) {
                                    int filaBase = (i * base.length) / f;
                                    int colBase = (j * base[0].length) / c;
                                    bandera[i][j] = base[filaBase][colBase];
                                }
                            }

                            for (int i = 0; i < f; i++) {
                                for (int j = 0; j < c; j++) {

                                    String color = RESET;

                                    if (bandera[i][j] == 'K') color = BG_BLACK;
                                    else if (bandera[i][j] == 'R') color = BG_RED;
                                    else if (bandera[i][j] == 'G') color = BG_GREEN;
                                    else if (bandera[i][j] == 'Y') color = BG_YELLOW;
                                    else if (bandera[i][j] == 'B') color = BG_BLUE;
                                    else if (bandera[i][j] == 'W') color = BG_WHITE;
                                    else if (bandera[i][j] == 'C') color = BG_CYAN;

                                    System.out.print(color + "  " + RESET);
                                }
                                System.out.println();
                            }
                        }
                    }

                    break;

                case 0:
                    System.out.println("\nPrograma finalizado.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}