import java.util.Scanner;

public class MenuMundial {

    static Scanner sc = new Scanner(System.in);

                    static String RESET = "\u001B[0m";
                    static String BG_BLACK = "\u001B[40m";
                    static String BG_RED = "\u001B[41m";
                    static String BG_GREEN = "\u001B[42m";
                    static String BG_DARK_GREEN = "\u001B[48;5;22m";
                    static String BG_YELLOW = "\u001B[43m";
                    static String BG_BLUE = "\u001B[44m";
                    static String BG_DARK_BLUE = "\u001B[48;5;17m";
                    static String BG_WHITE = "\u001B[47m";
                    static String BG_CYAN = "\u001B[46m";
                    static String BG_BROWN = "\u001B[48;5;94m";
                    static String BG_DARK_RED = "\u001B[48;5;88m";
                    static String BG_ORANGE = "\u001B[48;5;208m";

    static String[] grupos = {
        "A","B","C","D","E","F",
        "G","H","I","J","K","L"
    };

    static String[][] paises = {
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

    static String[] horas = {"10:00","13:00","16:00","19:00"};

    static int[][] puntos = new int[grupos.length][4];
    static int[][] amarillas = new int[grupos.length][4];
    static int[][] rojas = new int[grupos.length][4];
    static int[][] pj = new int[grupos.length][4];
    static int[][] ganados = new int[grupos.length][4];
    static int[][] empatados = new int[grupos.length][4];
    static int[][] perdidos = new int[grupos.length][4];
    static int[][] gf = new int[grupos.length][4];
    static int[][] gc = new int[grupos.length][4];

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("");


            switch (opcion) {

                case 1:
                    mostrarPartidos();
                    break;

                case 2:
                    mostrarTabla();
                    break;

                case 3:
                    infoPais();
                    break;

                case 4:
                    ingresarDatos();
                    break;

                case 5:
                    System.out.println("\nSaliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 5);
    }

    // ================= MENU =================
    static void mostrarMenu() {
        System.out.println(
" .--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--.\n" +
"/ .. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\\n" +
"\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/ /\n" +
" \\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\n" +
" / /\\/ /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /\\/ /\\\n" +
"/ /\\ \\/`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'\\ \\/\\ \\\n" +
"\\ \\/\\ \\                                                    /\\ \\/ /\n" +
" \\/ /\\ \\              MENU MUNDIAL 2026                   / /\\/ /\n" +
" / /\\/ /     Bienvenido, seleccione una opción del menú   \\ \\/ /\\\n" +
"/ /\\ \\/                                                    \\ \\/\\ \\\n" +
"\\ \\/\\ \\            1. Ver Partidos                         /\\ \\/ /\n" +
" \\/ /\\ \\           2. Ver Tabla de Posiciones             / /\\/ /\n" +
" / /\\/ /           3. Ver Información Países              \\ \\/ /\\\n" +
"/ /\\ \\/            4. Ingresar Resultados                  \\ \\/\\ \\\n" +
"\\ \\/\\ \\            5. Salir                                /\\ \\/ /\n" +
" \\/ /\\ \\                                                  / /\\/ /\n" +
" / /\\/ /                                                  \\ \\/ /\\\n" +
"/ /\\ \\/                                                    \\ \\/\\ \\\n" +
"\\ \\/\\ \\.--..--..--..--..--..--..--..--..--..--..--..--..--./\\ \\/ /\n" +
" \\/ /\\/ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ /\\/ /\n" +
" / /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\\n" +
"/ /\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\\n" +
"\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `' /\n" +
" `--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'\n"
);

System.out.print("\nEscoge una opcion: ");
    }

    // ================= PARTIDOS =================
    static void mostrarPartidos() {
        int contador = 0;
        int h = 0;

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║               PARTIDOS               ║");
        System.out.println("╚══════════════════════════════════════╝");

        for (int i = 0; i < grupos.length; i++) {

            for (int j = 0; j < 2; j++) {

                String p1 = paises[i][j*2];
                String p2 = paises[i][j*2+1];

                System.out.println("Grupo " + grupos[i] +
                        " -> " + p1 + " vs " + p2 +
                        "  " + horas[h % 4]);

                h++;
                contador++;

                if (contador % 5 == 0) {
                    if (!pausar()) return;
                }
            }
        }
    }

    // ================= TABLA =================
   
    static void mostrarTabla() {
        int gruposPorPagina = 3;
        int contadorGrupos = 0;

        for (int i = 0; i < grupos.length; i++) {

            System.out.println("\n============= Grupo " + grupos[i] + " =============\n");

            System.out.printf("%-15s %3s %3s %3s %3s %4s %4s %4s %5s %4s %4s\n",
                    "Equipo","PJ","G","E","P","GF","GC","DG","PTS","TA","TR");

            for (int j = 0; j < paises[i].length; j++) {

                System.out.printf("%-15s %3d %3d %3d %3d %4d %4d %4d %5d %4d %4d\n",
                    paises[i][j],
                    pj[i][j],
                    ganados[i][j],
                    empatados[i][j],
                    perdidos[i][j],
                    gf[i][j],
                    gc[i][j],
                    (gf[i][j] - gc[i][j]),
                    puntos[i][j],
                    amarillas[i][j],
                    rojas[i][j]
                );
            }

            contadorGrupos++;

            // 🔥 cada 3 grupos → pausa
            if (contadorGrupos % gruposPorPagina == 0 && i != grupos.length - 1) {

                if (!pausar()) return; // Q sale
            }

        }

    }
    
    // ================= INFO PAIS =================
    static void infoPais() {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         GRUPOS DISPONIBLES           ║");
        System.out.println("╚══════════════════════════════════════╝");

        for (int i = 0; i < grupos.length; i++) {
            System.out.println((i+1) + ". Grupo " + grupos[i]);
        }

        int g = leerEntero("Grupo: ") - 1;

        if (g < 0 || g >= grupos.length) {
            System.out.println("Grupo inválido");
            return;
        }

        System.out.println("\nSelecciona país:");

        for (int i = 0; i < paises[g].length; i++) {
            System.out.println((i+1) + ". " + paises[g][i]);
        }

        int p = leerEntero("País: ") - 1;

        if (p < 0 || p >= paises[g].length) {
            System.out.println("País inválido");
            return;
        }

        String pais = paises[g][p];

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║          INFORMACIÓN PAIS            ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Nombre: " + pais);
        // Capitales 
                if (pais.equals("Mexico")) System.out.println("Capital: Ciudad de México");
                else if (pais.equals("Sudafrica")) System.out.println("Capital: Pretoria");
                else if (pais.equals("Corea")) System.out.println("Capital: Seúl");
                else if (pais.equals("Chequia")) System.out.println("Capital: Praga");
                else if (pais.equals("Canada")) System.out.println("Capital: Ottawa");
                else if (pais.equals("Bosnia")) System.out.println("Capital: Sarajevo");
                else if (pais.equals("Qatar")) System.out.println("Capital: Doha");
                else if (pais.equals("Suiza")) System.out.println("Capital: Berna");
                else if (pais.equals("Brasil")) System.out.println("Capital: Brasilia");
                else if (pais.equals("Marruecos")) System.out.println("Capital: Rabat");
                else if (pais.equals("Haiti")) System.out.println("Capital: Puerto Príncipe");
                else if (pais.equals("Escocia")) System.out.println("Capital: Edimburgo");
                else if (pais.equals("EEUU")) System.out.println("Capital: Washington D.C.");
                else if (pais.equals("Paraguay")) System.out.println("Capital: Asunción");
                else if (pais.equals("Australia")) System.out.println("Capital: Canberra");
                else if (pais.equals("Turquia")) System.out.println("Capital: Ankara");
                else if (pais.equals("Alemania")) System.out.println("Capital: Berlín");
                else if (pais.equals("Curazao")) System.out.println("Capital: Willemstad");
                else if (pais.equals("Costa de Marfil")) System.out.println("Capital: Yamoussoukro");
                else if (pais.equals("Ecuador")) System.out.println("Capital: Quito");
                else if (pais.equals("Paises Bajos")) System.out.println("Capital: Ámsterdam");
                else if (pais.equals("Japon")) System.out.println("Capital: Tokio");
                else if (pais.equals("Suecia")) System.out.println("Capital: Estocolmo");
                else if (pais.equals("Tunez")) System.out.println("Capital: Túnez");
                else if (pais.equals("Belgica")) System.out.println("Capital: Bruselas");
                else if (pais.equals("Egipto")) System.out.println("Capital: El Cairo");
                else if (pais.equals("Iran")) System.out.println("Capital: Teherán");
                else if (pais.equals("Nueva Zelanda")) System.out.println("Capital: Wellington");
                else if (pais.equals("Espana")) System.out.println("Capital: Madrid");
                else if (pais.equals("Cabo Verde")) System.out.println("Capital: Praia");
                else if (pais.equals("Arabia Saudita")) System.out.println("Capital: Riad");
                else if (pais.equals("Uruguay")) System.out.println("Capital: Montevideo");
                else if (pais.equals("Francia")) System.out.println("Capital: París");
                else if (pais.equals("Senegal")) System.out.println("Capital: Dakar");
                else if (pais.equals("Irak")) System.out.println("Capital: Bagdad");
                else if (pais.equals("Noruega")) System.out.println("Capital: Oslo");
                else if (pais.equals("Argentina")) System.out.println("Capital: Buenos Aires");
                else if (pais.equals("Argelia")) System.out.println("Capital: Argel");
                else if (pais.equals("Austria")) System.out.println("Capital: Viena");
                else if (pais.equals("Jordania")) System.out.println("Capital: Amman");
                else if (pais.equals("Portugal")) System.out.println("Capital: Lisboa");
                else if (pais.equals("RD Congo")) System.out.println("Capital: Kinshasa");
                else if (pais.equals("Uzbekistan")) System.out.println("Capital: Taskent");
                else if (pais.equals("Colombia")) System.out.println("Capital: Bogotá");
                else if (pais.equals("Inglaterra")) System.out.println("Capital: Londres");
                else if (pais.equals("Croacia")) System.out.println("Capital: Zagreb");
                else if (pais.equals("Ghana")) System.out.println("Capital: Accra");
                else if (pais.equals("Panama")) System.out.println("Capital: Ciudad de Panamá");

                // Jugadores
                if (pais.equals("Mexico")) System.out.println("Titulares: Hirving Lozano, Santiago Gimenez, Edson Alvarez, Luis Chávez.");
                else if (pais.equals("Sudafrica")) System.out.println("Titulares: Percy Tau, Themba Zwane, Kamohelo Mokotjo, Bongani Zungu.");
                else if (pais.equals("Corea")) System.out.println("Titulares: Son Heung-min, Kim Young-gwon, Cho Gue-sung, Hwang Hee-chan.");
                else if (pais.equals("Chequia")) System.out.println("Titulares: Tomas Rosicky, Petr Cech, Milan Baros, Jan Kodes.");
                else if (pais.equals("Canada")) System.out.println("Titulares: Alphonso Davies, Atiba Hutchinson, Stephen Eustáquio, Jonathan Osorio.");
                else if (pais.equals("Bosnia")) System.out.println("Titulares: Edin Džeko, Miralem Pjanić, Emir Spahic, Admir Mehmedi.");
                else if (pais.equals("Qatar")) System.out.println("Titulares: Ahmed Al-Maamari, Hassan Al-Huwaidi, Yousef Hassan, Mohamed Al-Abdulrahman.");
                else if (pais.equals("Suiza")) System.out.println("Titulares: Granit Xhaka, Ricardo Rodríguez, Benni McCarthy, Fabian Frei.");
                else if (pais.equals("Brasil")) System.out.println("Titulares: Neymar, Alisson, Casemiro, Vinicius Jr.");
                else if (pais.equals("Marruecos")) System.out.println("Titulares: Hakim Ziyech, Achraf Hakimi, Youssef En-Nesyri, Sofyan Amrabat.");
                else if (pais.equals("Haiti")) System.out.println("Titulares: Duckens Nazon, Wilde-Donald Guerrier, Frantzdy Pierrot, Carlens Arcus.");
                else if (pais.equals("Escocia")) System.out.println("Titulares: Andrew Robertson, Kieran Tierney, John McGinn, Che Adams.");
                else if (pais.equals("EEUU")) System.out.println("Titulares: Christian Pulisic, Weston McKennie, Sergiño Dest, Tyler Adams.");
                else if (pais.equals("Paraguay")) System.out.println("Titulares: Miguel Almirón, Gustavo Gómez, Ángel Romero, Óscar Cardozo.");
                else if (pais.equals("Australia")) System.out.println("Titulares: Aaron Mooy, Mathew Ryan, Tom Rogic, Martin Boyle.");
                else if (pais.equals("Turquia")) System.out.println("Titulares: Hakan Çalhanoğlu, Cengiz Ünder, Merih Demiral, Burak Yilmaz.");
                else if (pais.equals("Alemania")) System.out.println("Titulares: Manuel Neuer, Joshua Kimmich, Kai Havertz, Leroy Sané.");
                else if (pais.equals("Curazao")) System.out.println("Titulares: Jarchinio Antonia, Cuco Martina, Leandro Bacuna, Elson Hooi.");
                else if (pais.equals("Costa de Marfil")) System.out.println("Titulares: Nicolas Pépé, Serge Aurier, Franck Kessié, Wilfried Zaha.");
                else if (pais.equals("Ecuador")) System.out.println("Titulares: Enner Valencia, Alexander Domínguez, Moisés Caicedo, Antonio Valencia.");
                else if (pais.equals("Paises Bajos")) System.out.println("Titulares: Virgil van Dijk, Frenkie de Jong, Memphis Depay, Matthijs de Ligt.");
                else if (pais.equals("Japon")) System.out.println("Titulares: Takumi Minamino, Maya Yoshida, Gaku Shibasaki, Yuya Osako.");
                else if (pais.equals("Suecia")) System.out.println("Titulares: Zlatan Ibrahimović, Emil Forsberg, Victor Lindelöf, Dejan Kulusevski.");
                else if (pais.equals("Tunez")) System.out.println("Titulares: Wahbi Khazri, Youssef Msakni, Dylan Bronn, Ferjani Sassi.");
                else if (pais.equals("Belgica")) System.out.println("Titulares: Kevin De Bruyne, Romelu Lukaku, Thibaut Courtois, Eden Hazard.");
                else if (pais.equals("Egipto")) System.out.println("Titulares: Mohamed Salah, Mohamed Elneny, Trezeguet, Ahmed Hegazi.");
                else if (pais.equals("Iran")) System.out.println("Titulares: Sardar Azmoun, Alireza Jahanbakhsh, Mehdi Taremi, Ehsan Hajsafi.");
                else if (pais.equals("Nueva Zelanda")) System.out.println("Titulares: Chris Wood, Winston Reid, Ryan Thomas, Michael Boxall.");
                else if (pais.equals("Espana")) System.out.println("Titulares: Sergio Ramos, Sergio Busquets, David Silva, Álvaro Morata.");
                else if (pais.equals("Cabo Verde")) System.out.println("Titulares: Ryan Mendes, Garry Rodrigues, Stopira, Djaniny.");
                else if (pais.equals("Arabia Saudita")) System.out.println("Titulares: Salem Al-Dawsari, Fahad Al-Muwallad, Yasser Al-Shahrani, Abdullah Otayf.");
                else if (pais.equals("Uruguay")) System.out.println("Titulares: Luis Suárez, Edinson Cavani, Diego Godín, Federico Valverde.");
                else if (pais.equals("Francia")) System.out.println("Titulares: Kylian Mbappé, Antoine Griezmann, N'Golo Kanté, Paul Pogba.");
                else if (pais.equals("Senegal")) System.out.println("Titulares: Moussa Sow, Idrissa Gana Gueye, Ousmane Dembélé, Cheikhou Khouma.");
                else if (pais.equals("Irak")) System.out.println("Titulares: Younis Mahmoud, Nashat Akram, Ali Adnan, Ahmed Radhi.");
                else if (pais.equals("Noruega")) System.out.println("Titulares: Erling Haaland, Martin Ødegaard, Joshua King, Sander Berge.");
                else if (pais.equals("Argentina")) System.out.println("Titulares: Lionel Messi, Ángel Di María, Paulo Dybala, Lautaro Martínez.");
                else if (pais.equals("Argelia")) System.out.println("Titulares: Riyad Mahrez, Islam Slimani, Youcef Atal, Faouzi Ghoulam.");
                else if (pais.equals("Austria")) System.out.println("Titulares: David Alaba, Marko Arnautović, Marcel Sabitzer, Valentino Lazaro.");
                else if (pais.equals("Jordania")) System.out.println("Titulares: Baha' Abdel-Rahman, Musa Al-Taamari, Yazan Al-Arab, Amer Shafi.");
                else if (pais.equals("Portugal")) System.out.println("Titulares: Cristiano Ronaldo, Bruno Fernandes, Bernardo Silva, João Félix.");
                else if (pais.equals("RD Congo")) System.out.println("Titulares: Cédric Bakambu, Yannick Bolasie, Dieumerci Mbokani, Gaël Kakuta.");
                else if (pais.equals("Uzbekistan")) System.out.println("Titulares: Eldor Shomurodov, Odil Ahmedov, Server Djeparov, Igor Sergeev.");
                else if (pais.equals("Colombia")) System.out.println("Titulares: James Rodríguez, Radamel Falcao, Juan Cuadrado, Davinson Sánchez.");
                else if (pais.equals("Inglaterra")) System.out.println("Titulares: Harry Kane, Raheem Sterling, Jordan Henderson, Jadon Sancho.");
                else if (pais.equals("Croacia")) System.out.println("Titulares: Luka Modrić, Ivan Rakitić, Dejan Lovren, Marcelo Brozović");
                else if (pais.equals("Ghana")) System.out.println("Titulares: Asamoah Gyan, André Ayew, Thomas Partey, Kwadwo Asamoah");
                else if (pais.equals("Panama")) System.out.println("Titulares: Blas Pérez, Gabriel Gómez, Román Torres, Felipe Baloy");
            char[][] base = null;
                int f = 9;
                int c = 27;

                            if (pais.equals("Mexico")) {
                                base = new char[][]{
                                    {'G','G','W','W','R','R'},
                                    {'G','G','W','M','R','R'},
                                    {'G','G','M','M','R','R'},
                                    {'G','G','M','W','R','R'},
                                    {'G','G','M','M','R','R'},
                                    {'G','G','W','W','R','R'}
                                
                                };
                            }
                            else if (pais.equals("Sudafrica")) {
                                base = new char[][]{
                                    {'Y','G','R','R','R','R'},
                                    {'K','Y','G','R','R','R'},
                                    {'K','K','Y','G','G','G'},
                                    {'K','K','Y','G','G','G'},
                                    {'K','Y','G','B','B','B'},
                                    {'Y','G','B','B','B','B'}
                                };
                            }
                            else if (pais.equals("Corea")) {
                                base = new char[][]{
                                    {'W','W','W','W','W','W'},
                                    {'W','W','R','R','W','W'},
                                    {'W','R','R','B','R','W'},
                                    {'W','B','R','B','B','W'},
                                    {'W','W','B','B','W','W'},
                                    {'W','W','W','W','W','W'}
                                };
                            }
         
                            else if (pais.equals("Chequia")) {
                                base = new char[][]{
                                    {'B','W','W','W','W','W'},
                                    {'B','B','W','W','W','W'},
                                    {'B','B','B','W','W','W'},
                                    {'B','B','B','R','R','R'},
                                    {'B','B','R','R','R','R'},
                                    {'B','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Canada")) {
                                base = new char[][]{
                                    {'R','R','W','W','W','R','R'},
                                    {'R','D','W','D','W','D','R'},
                                    {'R','R','D','D','D','R','R'},
                                    {'R','D','D','D','D','D','R'},
                                    {'R','R','W','D','W','R','R'},
                                    {'R','R','W','D','W','R','R'},
                                    {'R','R','W','W','W','R','R'}
                                };
                            }

                            else if (pais.equals("Bosnia")) {
                                base = new char[][]{
                                    {'B','Y','Y','Y','Y','Y','Y','B','B'},
                                    {'B','W','Y','Y','Y','Y','Y','B','B'},
                                    {'B','B','W','Y','Y','Y','Y','B','B'},
                                    {'B','B','B','W','Y','Y','Y','B','B'},
                                    {'B','B','B','B','W','Y','Y','B','B'},
                                    {'B','B','B','B','B','W','Y','B','B'}
                                };
                            }

                            else if (pais.equals("Qatar")) {
                                base = new char[][]{
                                    {'W','R','R','R','R','R'},
                                    {'W','W','R','R','R','R'},
                                    {'W','R','R','R','R','R'},
                                    {'W','W','R','R','R','R'},
                                    {'W','R','R','R','R','R'},
                                    {'W','W','R','R','R','R'},
                                    {'W','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Suiza")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','R','W','W','R','R'},
                                    {'R','R','W','W','R','R'},
                                    {'R','W','W','W','W','R'},
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
                                    {'G','Y','B','B','Y','G'},
                                    {'G','Y','B','B','Y','G'},
                                    {'G','G','Y','Y','G','G'},
                                    {'G','G','G','G','G','G'}
                                };
                            }

                            else if (pais.equals("Marruecos")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R','R'},
                                    {'R','R','R','G','R','R','R'},
                                    {'R','R','G','G','G','R','R'},
                                    {'R','R','R','G','R','R','R'},
                                    {'R','R','G','R','G','R','R'},
                                    {'R','R','R','R','R','R','R'}
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
                                    {'W','r','W','B','B','B'},
                                    {'r','r','r','B','W','B'},
                                    {'W','r','W','B','B','W'},
                                    {'B','B','B','B','W','B'},
                                    {'B','W','B','W','B','B'},
                                    {'B','B','B','B','B','B'}
                                };
                            }

                            else if (pais.equals("Turquia")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','W','W','R','R','R'},
                                    {'R','W','R','R','W','R'},
                                    {'R','W','R','R','W','R'},
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
                                    {'B','W','B','B','B','B'},
                                    {'B','B','W','B','B','B'},
                                    {'B','B','B','B','B','B'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'}
                                };
                            }

                            else if (pais.equals("Costa de Marfil")) {
                                base = new char[][]{
                                    {'O','O','W','W','G','G'},
                                    {'O','O','W','W','G','G'},
                                    {'O','O','W','W','G','G'},
                                    {'O','O','W','W','G','G'},
                                    {'O','O','W','W','G','G'},
                                    {'O','O','W','W','G','G'}
                                };
                            }

                            else if (pais.equals("Ecuador")) {
                                base = new char[][]{
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'b','b','b','b','b','b'},
                                    {'r','r','r','r','r','r'},
                                    {'r','r','r','r','r','r'}
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
                                    {'W','W','r','r','W','W'},
                                    {'W','r','r','r','r','W'},
                                    {'W','r','r','r','r','W'},
                                    {'W','W','r','r','W','W'},
                                    {'W','W','W','W','W','W'}
                                };
                            }

                            else if (pais.equals("Suecia")) {
                                base = new char[][]{
                                    {'b','b','Y','b','b','b'},
                                    {'b','b','Y','b','b','b'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'b','b','Y','b','b','b'},
                                    {'b','b','Y','b','b','b'},
                                    {'b','b','Y','b','b','b'}
                                };
                            }

                            else if (pais.equals("Tunez")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'R','R','W','W','R','R'},
                                    {'R','W','R','R','W','R'},
                                    {'R','W','R','W','W','R'},
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
                                    {'W','W','Y','Y','W','W'},
                                    {'W','W','Y','Y','W','W'},
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
                                    {'W','R','W','B','B','B'},
                                    {'R','R','R','B','R','B'},
                                    {'W','R','W','B','B','R'},
                                    {'B','B','B','R','B','B'},
                                    {'B','B','B','B','R','B'},
                                    {'B','B','B','B','B','B'}
                                };
                            }

                            else if (pais.equals("Espana")) {
                                base = new char[][]{
                                    {'R','R','R','R','R','R'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'Y','R','R','Y','Y','Y'},
                                    {'Y','R','R','Y','Y','Y'},
                                    {'Y','Y','Y','Y','Y','Y'},
                                    {'R','R','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("Cabo Verde")) {
                                base = new char[][]{
                                    {'B','B','B','B','B','B'},
                                    {'B','B','B','B','B','B'},
                                    {'W','W','Y','W','W','W'},
                                    {'R','Y','R','Y','R','R'},
                                    {'W','W','Y','W','W','W'},
                                    {'B','B','B','B','B','B'}
                                };
                            }

                            else if (pais.equals("Arabia Saudita")) {
                                base = new char[][]{
                                    {'G','G','G','G','G','G'},
                                    {'G','G','W','W','G','G'},
                                    {'G','W','W','W','W','G'},
                                    {'G','G','G','G','G','G'},
                                    {'G','G','W','W','G','G'},
                                    {'G','G','G','G','G','G'}
                                };
                            }

                            else if (pais.equals("Uruguay")) {
                                base = new char[][]{
                                    {'W','Y','W','W','W','W'},
                                    {'Y','Y','Y','B','B','B'},
                                    {'W','Y','W','W','W','W'},
                                    {'B','B','B','B','B','B'},
                                    {'W','W','W','W','W','W'},
                                    {'B','B','B','B','B','B'},
                                    {'W','W','W','W','W','W'}
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
                                    {'W','W','G','G','W','W'},
                                    {'W','W','W','W','W','W'},
                                    {'K','K','K','K','K','K'},
                                    {'K','K','K','K','K','K'}
                                };
                            }

                            else if (pais.equals("Noruega")) {
                                base = new char[][]{
                                    {'R','W','B','W','R','R'},
                                    {'W','W','B','W','W','W'},
                                    {'B','B','B','B','B','B'},
                                    {'W','W','B','W','W','W'},
                                    {'R','W','B','W','R','R'},
                                    {'R','W','B','W','R','R'}
                                };
                            }

                            else if (pais.equals("Argentina")) {
                                base = new char[][]{
                                    {'C','C','C','C','C','C'},
                                    {'C','C','C','C','C','C'},
                                    {'W','W','Y','Y','W','W'},
                                    {'W','W','Y','Y','W','W'},
                                    {'C','C','C','C','C','C'},
                                    {'C','C','C','C','C','C'}
                                };
                            }

                            else if (pais.equals("Argelia")) {
                                base = new char[][]{
                                    {'G','G','G','W','W','W'},
                                    {'G','G','R','R','W','W'},
                                    {'G','G','R','W','W','W'},
                                    {'G','G','R','W','W','W'},
                                    {'G','G','R','R','W','W'},
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
                                    {'R','K','K','K','K','K'},
                                    {'R','R','K','K','K','K'},
                                    {'R','R','R','W','W','W'},
                                    {'R','R','R','W','W','W'},
                                    {'R','R','G','G','G','G'},
                                    {'R','G','G','G','G','G'}
                                };
                            }

                            else if (pais.equals("Portugal")) {
                                base = new char[][]{
                                    {'G','G','R','R','R','R'},
                                    {'G','G','Y','R','R','R'},
                                    {'G','Y','R','Y','R','R'},
                                    {'G','Y','R','Y','R','R'},
                                    {'G','G','Y','R','R','R'},
                                    {'G','G','R','R','R','R'}
                                };
                            }

                            else if (pais.equals("RD Congo")) {
                                base = new char[][]{
                                    {'C','C','C','C','Y','R'},
                                    {'C','Y','C','Y','R','Y'},
                                    {'C','C','Y','R','Y','C'},
                                    {'C','Y','R','Y','C','C'},
                                    {'Y','R','Y','C','C','C'},
                                    {'R','Y','C','C','C','C'}
                                };
                            }

                            else if (pais.equals("Uzbekistan")) {
                                base = new char[][]{
                                    {'C','C','C','C','C','C'},
                                    {'C','C','C','C','C','C'},
                                    {'R','R','R','R','R','R'},
                                    {'W','W','W','W','W','W'},
                                    {'W','W','W','W','W','W'},
                                    {'R','R','R','R','R','R'},
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
                                    {'r','r','r','r','r','r'},
                                    {'r','r','r','r','r','r'},
                                    {'W','W','W','W','W','W'},
                                    {'W','W','W','W','W','W'},
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
                                    else if (bandera[i][j] == 'r') color = BG_RED;
                                    else if (bandera[i][j] == 'g') color = BG_GREEN;
                                    else if (bandera[i][j] == 'Y') color = BG_YELLOW;
                                    else if (bandera[i][j] == 'b') color = BG_BLUE;
                                    else if (bandera[i][j] == 'W') color = BG_WHITE;
                                    else if (bandera[i][j] == 'C') color = BG_CYAN;
                                    else if (bandera[i][j] == 'M') color = BG_BROWN;
                                    else if (bandera[i][j] == 'R') color = BG_DARK_RED;
                                    else if (bandera[i][j] == 'B') color = BG_DARK_BLUE;
                                    else if (bandera[i][j] == 'O') color = BG_ORANGE;
                                    else if (bandera[i][j] == 'G') color = BG_DARK_GREEN;

                                    System.out.print(color + "  " + RESET);
                                }
                                System.out.println();
                            
                                }   
                        
                            }
                        static void ingresarDatos() {

                        System.out.println("╔══════════════════════════════════════╗");
                        System.out.println("║           Ingresar Datos             ║");
                        System.out.println("╚══════════════════════════════════════╝");

                        // seleccionar grupo
                        for (int i = 0; i < grupos.length; i++) {
                            System.out.println((i+1) + ". Grupo " + grupos[i]);
                        }

                        int g = leerEntero("Grupo: ") - 1;

                        if (g < 0 || g >= grupos.length) {
                            System.out.println("Grupo inválido");
                            return;
                        }

                        // seleccionar partido
                        System.out.println("\nPartidos:");
                        System.out.println("1. " + paises[g][0] + " vs " + paises[g][1]);
                        System.out.println("2. " + paises[g][2] + " vs " + paises[g][3]);

                        int partido;

                        do {
                            partido = leerEntero("Elige partido: ");

                            if (partido != 1 && partido != 2) {
                                System.out.println("Elige un partido válido");
                            }

                        } while (partido != 1 && partido != 2);

                        int e1 = 0, e2 = 1;

                        if (partido == 2) {
                            e1 = 2;
                            e2 = 3;
                        }

                        // goles
                        System.out.println("\n--- GOLES ---");

                        int goles1 = leerEntero("Goles " + paises[g][e1] + ": ");
                        int goles2 = leerEntero("Goles " + paises[g][e2] + ": ");

                        // tarjetas
                        System.out.println("\n--- TARJETAS ---");

                        int amar1 = leerEntero("Amarillas " + paises[g][e1] + ": ");
                        int amar2 = leerEntero("Amarillas " + paises[g][e2] + ": ");

                        int roja1 = leerEntero("Rojas " + paises[g][e1] + ": ");
                        int roja2 = leerEntero("Rojas " + paises[g][e2] + ": ");

                        // ================= ACTUALIZAR =================

                        // PJ
                        pj[g][e1]++;
                        pj[g][e2]++;

                        // goles
                        gf[g][e1] += goles1;
                        gf[g][e2] += goles2;

                        gc[g][e1] += goles2;
                        gc[g][e2] += goles1;

                        // tarjetas
                        amarillas[g][e1] += amar1;
                        amarillas[g][e2] += amar2;

                        rojas[g][e1] += roja1;
                        rojas[g][e2] += roja2;

                        // resultado
                        if (goles1 > goles2) {
                            ganados[g][e1]++;
                            perdidos[g][e2]++;
                            puntos[g][e1] += 3;
                        }
                        else if (goles2 > goles1) {
                            ganados[g][e2]++;
                            perdidos[g][e1]++;
                            puntos[g][e2] += 3;
                        }
                        else {
                            empatados[g][e1]++;
                            empatados[g][e2]++;
                            puntos[g][e1] += 1;
                            puntos[g][e2] += 1;
                        }

                        System.out.println("\nResultado guardado correctamente");
                    }
    // ================= PAUSA =================
                static boolean pausar() {
                while (true) {
                    System.out.print("\n[ENTER] continuar | [Q] salir: ");
                    String input = sc.nextLine().trim().toLowerCase();

                    if (input.equals("q")) {
                        return false; // 
                    }

                    if (input.isEmpty()) {
                        return true; // continuar
                    }

                    System.out.println("Por favor elija una opción válida");
                }
            }
    
    static int leerEntero(String mensaje) {
    System.out.print(mensaje);

    while (!sc.hasNextInt()) {
        System.out.print("Ingresa un número válido: ");
        sc.next();
    }

    int num = sc.nextInt();
    sc.nextLine(); // LIMPIA EL BUFFER AQUÍ

    return num;

}
}
