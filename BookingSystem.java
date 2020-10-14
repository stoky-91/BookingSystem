package bookingsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

public class BookingSystem {

    //public static int str_int;
    /**
     * Input Scanner
     */
    public static Scanner sc = new Scanner(System.in);
    /**
     * variables for determining the size of cinema halls
     */
    public static int numberOfRows, numberOfSeats, numberOfRows1, numberOfSeats1, numberOfRows2, numberOfSeats2, numberOfRows3, numberOfSeats3;
    /**
     * projection time in hours
     */
    public static int timeH1, timeH2, timeH3, timeH4, timeH5, timeH6;
    /**
     * projection time in minutes
     */
    public static int timeM1, timeM2, timeM3, timeM4, timeM5, timeM6;
    /**
     * projected film
     */
    public static String film1, film2, film3;
    /**
     * variable for loading the movie
     */
    public static String film4;
    /**
     * auxiliary calculation for summing sectors
     */
    public static int count;
    /**
     * field for the first hall, the first time
     */
    public static int[][] firstHallFirstTime = new int[numberOfRows1][numberOfSeats1];

    /**
     * field for the first hall, the second time
     */
    public static int[][] firstHallSecondTime = new int[numberOfRows1][numberOfSeats1];
    /**
     * field for the second hall, the first time
     */
    public static int[][] secondHallFirstTime = new int[numberOfRows2][numberOfSeats2];
    /**
     * field for the second hall, the second time
     */
    public static int[][] secondHallSecondTime = new int[numberOfRows2][numberOfSeats2];
    /**
     * field for the third hall, the first time
     */
    public static int[][] thirdHallFirstTime = new int[numberOfRows3][numberOfSeats3];
    /**
     * field for the third hall, the second time
     */
    public static int[][] thirdHallSecondTime = new int[numberOfRows3][numberOfSeats3];
    /**
     * the size of the sector in the cinema
     */
    public static int sector1, sector2, sector3;
    /**
     * time lag between the beginnings of screenings between films
     */
    public static int timeLag = 120;

    /**
     *
     * @return Question on the number of rows
     */
    public static String hallNumberOfRows() {
        return "How many rows will the hall have?";
    }

    /**
     * @return Question on the number of seats in rows
     */
    public static String hallNumberOfSeats() {
        return "How many places will the rows have??";
    }

    /**
     *
     * @return Number of rows in the cinema hall
     */
    public static int numberOfRows() {
        do {
            System.out.println("Enter the number of rows.(1-8)");
            numberOfRows = sc.nextInt();
        } while (numberOfRows < 1 || numberOfRows > 8);
        return numberOfRows;
    }

    /**
     *
     * @return Number of seats in the cinema hall
     */
    public static int numberOfPlaces() {
        do {
            System.out.println("Enter the number of seats.(1-8)");
            numberOfSeats = sc.nextInt();
        } while (numberOfSeats < 1 || numberOfSeats > 8);
        return numberOfSeats;
    }

    /**
     * @return Time in hours entered by the user
     */
    public static int timeH() {
        int time = 0;
        do {
            System.out.println("Choose hour(hh).");
            time = sc.nextInt();
        } while (time < 0 || time > 23);
        return time;
    }

    /**
     * @return Time in minutes entered by the user
     */
    public static int timeM() {
        int time1 = 0;
        do {
            System.out.println("Choose minutes(mm).");
            time1 = sc.nextInt();
        } while (time1 < 0 || time1 > 59);
        return time1;
    }

    /**
     *
     * @return Saves the movie specified by the admin
     */
    public static String projectedFilm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What film will be projected here?");
        film4 = sc.nextLine();
        return film4;
    }

    /**
     *
     * @return Auxiliary calculation for the time interval between projection
     * times in the first cinema and first time
     */
    public static int calculationTimeFirstHall() {
        int calculation1 = timeH1 * 60 + timeM1;
        int calculation2 = timeH2 * 60 + timeM2;
        int result = calculation1 - calculation2;
        return result;
    }

    /**
     *
     * @return Auxiliary calculation for the time interval between projection
     * times in the first cinema and seond time
     */
    public static int calculationTimeFirstHall2() {
        int calculation1 = timeH1 * 60 + timeM1;
        int calculation2 = timeH2 * 60 + timeM2;
        int result = calculation2 - calculation1;
        return result;
    }

    /**
     *
     * @return Auxiliary calculation for the time interval between projection
     * times in the second cinema and first time
     */
    public static int calculationTimeSecondHall() {
        int calculation1 = timeH3 * 60 + timeM3;
        int calculation2 = timeH4 * 60 + timeM4;
        int result = calculation1 - calculation2;
        return result;
    }

    /**
     *
     * @return Auxiliary calculation for the time interval between projection
     * times in the second cinema and second time
     */
    public static int calculationTimeSecondHall2() {
        int calculation1 = timeH3 * 60 + timeM3;
        int calculation2 = timeH4 * 60 + timeM4;
        int result = calculation2 - calculation1;
        return result;
    }

    /**
     *
     * @return Auxiliary calculation for the time interval between projection
     * times in the third cinema and first time
     */
    public static int calculationTimeThirdHall() {
        int calculation1 = timeH5 * 60 + timeM5;
        int calculation2 = timeH6 * 60 + timeM6;
        int result = calculation1 - calculation2;
        return result;
    }

    /**
     *
     * @return Auxiliary calculation for the time interval between projection
     * times in the third cinema and second time
     */
    public static int calculationTimeThirdHall2() {
        int calculation1 = timeH5 * 60 + timeM5;
        int calculation2 = timeH6 * 60 + timeM6;
        int result = calculation2 - calculation1;
        return result;
    }

    /**
     * Enter the first and second projection time, with a time interval of 2
     * hours.
     */
    public static void filmTime1() {

        film1 = projectedFilm();

        System.out.println("What will be the first projection time?");
        timeH1 = timeH();
        timeM1 = timeM();

        do {
            System.out.println("What will be the second projection time? (The time interval must be at least 2 hours)");
            timeH2 = timeH();
            timeM2 = timeM();
        } while ((calculationTimeFirstHall() < timeLag) && (calculationTimeFirstHall2() < timeLag));

    }

    /**
     * Enter the third and fourth projection time, with a time interval of 2
     * hours.
     */
    public static void filmTime2() {
        film2 = projectedFilm();
        System.out.println("What will be the first projection time?");
        timeH3 = timeH();
        timeM3 = timeM();
        do {
            System.out.println("What will be the second projection time? (The time interval must be at least 2 hours)");
            timeH4 = timeH();
            timeM4 = timeM();
        } while ((calculationTimeSecondHall() < timeLag) && (calculationTimeSecondHall2() < timeLag));
    }

    /**
     * Enter the fifth and sixth projection time, with a time interval of 2
     * hours.
     */
    public static void filmTime3() {
        film3 = projectedFilm();
        System.out.println("What will be the first projection time?");
        timeH5 = timeH();
        timeM5 = timeM();
        do {
            System.out.println("What will be the second projection time? (The time interval must be at least 2 hours)");
            timeH6 = timeH();
            timeM6 = timeM();
        } while ((calculationTimeThirdHall() < timeLag) && (calculationTimeThirdHall2() < timeLag));
    }

    /**
     * Determining the size of the first cinema hall - 1st and 2nd projecting
     * time. int a - lists the coordinates of the number of rows. column [m] -
     * lists the coordinates of the number seats. sectorsFirstHall () - method
     * at the end referring to the division cinema hall to sectors
     */
    public static void sizeFirstHall() {
        System.out.println("Size of 1. cinema hall.");

        hallNumberOfRows();
        numberOfRows1 = numberOfRows();
        hallNumberOfSeats();
        numberOfSeats1 = numberOfPlaces();
        firstHallFirstTime = new int[numberOfSeats1][numberOfRows1];
        firstHallSecondTime = new int[numberOfSeats1][numberOfRows1];
        System.out.print("       ");
        for (int i = 0; i < numberOfRows1; i++) {
            for (int j = 0; j < numberOfSeats1; j++) {
            }
        }
        int[] column = new int[numberOfSeats1 + 1];
        int a = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);

        }
        System.out.println();
        for (int j = 0; j < firstHallFirstTime[0].length; j++) {

            System.out.print(a + ". row  ");
            a++;
            for (int i = 0; i < firstHallFirstTime.length; i++) {
                System.out.print(firstHallFirstTime[i][j] + "  ");
            }
            System.out.println();
        }
        sectorsFirstHall();
    }

    /**
     * Listing of the first cinema hall - 1st projecting time. int a1 - lists
     * coordinat number of rows column [m] - lists the coordinates of the number
     * of column. reservationFirstHall() - method referring to the reservation
     * by the customer
     */
    public static void listFirstHall() {
        System.out.print("       ");
        int[] column = new int[numberOfSeats1 + 1];
        int a1 = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);
        }
        System.out.println();
        for (int j = 0; j < firstHallFirstTime[0].length; j++) {
            System.out.print(a1 + ". row  ");
            a1++;
            for (int i = 0; i < firstHallFirstTime.length; i++) {
                System.out.print(firstHallFirstTime[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("(5-occupied seat.)");
        reservationFirstHall();
    }

    /**
     * Reservation of the first cinema hall - 1st projecting time. int a2 -
     * print coordinates of the number of rows. column [m] - lists the
     * coordinates of the number of seats. row - enter the selected rows. seat -
     * enter the selected seat. if-else cycle to booking the seat - be marked
     * with the number 5
     */
    public static void reservationFirstHall() {

        int[] column = new int[numberOfSeats1 + 1];
        System.out.println("\nEnter the row.");
        int row = sc.nextInt();
        System.out.println("Enter the seat:");
        int seat = sc.nextInt();
        if ((seat > 0 && seat <= numberOfSeats1) && (row > 0 && row <= numberOfRows1) && ((firstHallFirstTime[seat - 1][row - 1] == 1) || (firstHallFirstTime[seat - 1][row - 1] == 2) || (firstHallFirstTime[seat - 1][row - 1] == 3))) {
            firstHallFirstTime[seat - 1][row - 1] = 5;
            System.out.println("Ordered");

        } else if ((seat > 0 && seat <= numberOfSeats1) && (row > 0 && row <= numberOfRows1) && firstHallFirstTime[seat - 1][row - 1] == 5) {
            System.out.println("This place is already taken.");

        } else if ((seat <= 0 || seat > numberOfSeats1) || (row <= 0 || row > numberOfRows1)) {
            System.out.println("You cannot select seats off schedule.");
        }
        System.out.print("       ");
        for (int i = 0; i < numberOfRows1; i++) {
            for (int j = 0; j < numberOfSeats1; j++) {
            }
        }
        int a2 = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);
        }
        System.out.println();
        for (int j = 0; j < firstHallFirstTime[0].length; j++) {
            System.out.print(a2 + ". row  ");
            a2++;
            for (int i = 0; i < firstHallFirstTime.length; i++) {
                System.out.print(firstHallFirstTime[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("(5-occupied seat.)");
    }

    /**
     * Listing of the first cinema hall - 2nd projecting time. int a1 - lists
     * coordinat number of rows. column [m] - lists the coordinates of the
     * number of column. reservationFirstHall() - method referring to the
     * reservation by the customer
     */
    public static void listFirstHall2() {
        System.out.print("       ");
        int[] column = new int[numberOfSeats1 + 1];
        int a1 = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);
        }
        System.out.println();
        for (int j = 0; j < firstHallSecondTime[0].length; j++) {
            System.out.print(a1 + ". row  ");
            a1++;
            for (int i = 0; i < firstHallSecondTime.length; i++) {
                System.out.print(firstHallSecondTime[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("(5-occupied seat.)");
        reservationFirstHall2();
    }

    /**
     * Reservation of the first cinema hall - 2nd projecting time. int a2- print
     * coordinates of the number of rows. column [m] - lists the coordinates of
     * the number of seats. row - enter the selected rows. seat - enter the
     * selected seat. if-else cycle to booking the seat - be marked with the
     * number 5
     */
    public static void reservationFirstHall2() {

        int[] column = new int[numberOfSeats1 + 1];
        System.out.println("\nEnter the row:");
        int row = sc.nextInt();
        System.out.println("Enter the seat:");
        int seat = sc.nextInt();
        if ((seat > 0 && seat <= numberOfSeats1) && (row > 0 && row <= numberOfRows1) && ((firstHallSecondTime[seat - 1][row - 1] == 1) || (firstHallSecondTime[seat - 1][row - 1] == 2) || (firstHallSecondTime[seat - 1][row - 1] == 3))) {
            firstHallSecondTime[seat - 1][row - 1] = 5;
            System.out.println("Orderer");

        } else if ((seat > 0 && seat <= numberOfSeats1) && (row > 0 && row <= numberOfRows1) && firstHallSecondTime[seat - 1][row - 1] == 5) {
            System.out.println("This place is already taken.");

        } else if ((seat <= 0 || seat > numberOfSeats1) || (row <= 0 || row > numberOfRows1)) {
            System.out.println("You cannot select seats off schedule.");
        }

        System.out.print("       ");
        for (int i = 0; i < numberOfRows1; i++) {
            for (int j = 0; j < numberOfSeats1; j++) {
            }
        }
        int a2 = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);
        }
        System.out.println();
        for (int j = 0; j < firstHallSecondTime[0].length; j++) {
            System.out.print(a2 + ". row  ");
            a2++;
            for (int i = 0; i < firstHallSecondTime.length; i++) {
                System.out.print(firstHallSecondTime[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("(5-occupied seat.)");
    }

    /**
     * Division of the first cinema hall into 3 sectors. count - the count of
     * the specified three sectors must be equal to the number of rows in the
     * cinema
     */
    public static void typeSectorsFirstHall() {
        System.out.println("You divide the cinema hall into 3 sectors in rows.");
        do {
            System.out.print("The sum of the rows must be equal to the number of selected rows in the cinema. Ie.");
            System.out.println(numberOfRows1);
            System.out.println("How many rows will the 1st sector have?");
            sector1 = sc.nextInt();
            System.out.println("How many rows will the 2nd sector have?");
            sector2 = sc.nextInt();
            System.out.println("How many rows will the 3rd sector have?");
            sector3 = sc.nextInt();
            count = sector1 + sector2 + sector3;
        } while (count != numberOfRows1);
    }

    /**
     * Fill the first cinema hall with sectors according to the user specified
     * in the method typeSectorsFirstHall (). First sector = 1, second sector =
     * 2, third sector = 3
     */
    public static void sectorsFirstHall() {
        typeSectorsFirstHall();
        for (int i = 0; i < numberOfSeats1; i++) {
            for (int j = 0; j < sector1; j++) {
                firstHallFirstTime[i][j] = 1;
                firstHallSecondTime[i][j] = 1;
            }
        }
        for (int i = 0; i < numberOfSeats1; i++) {

            for (int j = sector1; j < sector1 + sector2; j++) {
                firstHallFirstTime[i][j] = 2;
                firstHallSecondTime[i][j] = 2;
            }
        }
        for (int i = 0; i < numberOfSeats1; i++) {
            for (int j = sector1 + sector2; j < sector1 + sector2 + sector3; j++) {
                firstHallFirstTime[i][j] = 3;
                firstHallSecondTime[i][j] = 3;
            }
        }
    }

    /**
     * Determining the size of the second cinema hall - 1st and 2nd projecting
     * time. int a - lists the coordinates of the number of rows. column [m] -
     * lists the coordinates of the number seats. sectorsSecondHall () - method
     * at the end referring to the division cinema hall to sectors
     */
    public static void sizeSecondHall() {
        System.out.println("Size of 2. cinema hall.");
        hallNumberOfRows();
        numberOfRows2 = numberOfRows();
        hallNumberOfSeats();
        numberOfSeats2 = numberOfPlaces();
        secondHallFirstTime = new int[numberOfSeats2][numberOfRows2];
        secondHallSecondTime = new int[numberOfSeats2][numberOfRows2];
        System.out.print("       ");
        for (int i = 0; i < numberOfRows2; i++) {
            for (int j = 0; j < numberOfSeats2; j++) {
            }
        }
        int[] column = new int[numberOfSeats2 + 1];
        int a = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);
        }
        System.out.println();
        for (int j = 0; j < secondHallFirstTime[0].length; j++) {

            System.out.print(a + ". row  ");
            a++;
            for (int i = 0; i < secondHallFirstTime.length; i++) {
                System.out.print(secondHallFirstTime[i][j] + "  ");
            }
            System.out.println();
        }
        sectorsSecondHall();
    }

    /**
     * Listing of the second cinema hall - 1st projecting time. int a1 - lists
     * coordinat number of rows. column [m] - lists the coordinates of the
     * number of column. reservationSecondHall() - method referring to the
     * reservation by the customer
     */
    public static void listSecondHall() {
        System.out.print("       ");
        int[] column = new int[numberOfSeats2 + 1];
        int a1 = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);
        }
        System.out.println();
        for (int j = 0; j < secondHallFirstTime[0].length; j++) {
            System.out.print(a1 + ". row  ");
            a1++;
            for (int i = 0; i < secondHallFirstTime.length; i++) {
                System.out.print(secondHallFirstTime[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("(5-occupied seat.)");
        reservationSecondHall();
    }

    /**
     * Reservation of the second cinema hall - 1st projecting time int a2 -
     * print coordinates of the number of rows. column [m] - lists the
     * coordinates of the number of seats. row - enter the selected rows. seat -
     * enter the selected seat. if-else cycle to booking the seat - be marked
     * with the number 5
     */
    public static void reservationSecondHall() {
        int[] column = new int[numberOfSeats2 + 1];
        System.out.println("\nEnter the row:");
        int row = sc.nextInt();
        System.out.println("Enter the seat:");
        int sedadlo = sc.nextInt();
        if ((sedadlo > 0 && sedadlo <= numberOfSeats2) && (row > 0 && row <= numberOfRows2) && ((secondHallFirstTime[sedadlo - 1][row - 1] == 1) || (secondHallFirstTime[sedadlo - 1][row - 1] == 2) || (secondHallFirstTime[sedadlo - 1][row - 1] == 3))) {
            secondHallFirstTime[sedadlo - 1][row - 1] = 5;
            System.out.println("Orderer");

        } else if ((sedadlo > 0 && sedadlo <= numberOfSeats2) && (row > 0 && row <= numberOfRows2) && secondHallFirstTime[sedadlo - 1][row - 1] == 5) {
            System.out.println("This place is already taken.");

        } else if ((sedadlo <= 0 || sedadlo > numberOfSeats2) || (row <= 0 || row > numberOfRows2)) {
            System.out.println("You cannot select seats off schedule.");
        }

        System.out.print("       ");
        for (int i = 0; i < numberOfRows2; i++) {
            for (int j = 0; j < numberOfSeats2; j++) {
            }
        }
        int a2 = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);
        }
        System.out.println();
        for (int j = 0; j < secondHallFirstTime[0].length; j++) {
            System.out.print(a2 + ". row  ");
            a2++;
            for (int i = 0; i < secondHallFirstTime.length; i++) {
                System.out.print(secondHallFirstTime[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("(5-occupied seat.)");
    }

    /**
     * Listing of the second cinema hall - 2nd projecting time. int a1 - lists
     * coordinat number of rows. column [m] - lists the coordinates of the
     * number of column. reservationSecondHall() - method referring to the
     * reservation by the customer
     */
    public static void listSecondHall2() {
        System.out.print("       ");
        int[] column = new int[numberOfSeats2 + 1];
        int a1 = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);
        }
        System.out.println();
        for (int j = 0; j < secondHallSecondTime[0].length; j++) {
            System.out.print(a1 + ". row  ");
            a1++;
            for (int i = 0; i < secondHallSecondTime.length; i++) {
                System.out.print(secondHallSecondTime[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("(5-occupied seat.)");
        reservationSecondHall2();
    }

    /**
     * Reservation of the second cinema hall - 2nd projecting time int a2 -
     * print coordinates of the number of rows. column [m] - lists the
     * coordinates of the number of seats. row - enter the selected rows. seat -
     * enter the selected seat. if-else cycle to booking the seat - be marked
     * with the number 5
     */
    public static void reservationSecondHall2() {
        int[] column = new int[numberOfSeats2 + 1];
        System.out.println("\nEnter the row:");
        int row = sc.nextInt();
        System.out.println("Enter the seat:");
        int seat = sc.nextInt();

        if ((seat > 0 && seat <= numberOfSeats2) && (row > 0 && row <= numberOfRows2) && ((secondHallSecondTime[seat - 1][row - 1] == 1) || (secondHallSecondTime[seat - 1][row - 1] == 2) || (secondHallSecondTime[seat - 1][row - 1] == 3))) {
            secondHallSecondTime[seat - 1][row - 1] = 5;
            System.out.println("Orderer");

        } else if ((seat > 0 && seat <= numberOfSeats2) && (row > 0 && row <= numberOfRows2) && secondHallSecondTime[seat - 1][row - 1] == 5) {
            System.out.println("This place is already taken.");

        } else if ((seat <= 0 || seat > numberOfSeats2) || (row <= 0 || row > numberOfRows2)) {
            System.out.println("You cannot select seats off schedule.");
        }

        System.out.print("       ");
        for (int i = 0; i < numberOfRows2; i++) {
            for (int j = 0; j < numberOfSeats2; j++) {
            }
        }
        int a2 = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);
        }
        System.out.println();
        for (int j = 0; j < secondHallSecondTime[0].length; j++) {
            System.out.print(a2 + ". row  ");
            a2++;
            for (int i = 0; i < secondHallSecondTime.length; i++) {
                System.out.print(secondHallSecondTime[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("(5-occupied seat.)");
    }

    /**
     * Division of the second cinema hall into 3 sectors. count - the count of
     * the specified three sectors must be equal to the number of rows in the
     * cinema
     */
    public static void typeSectorsSecondHall() {
        System.out.println("You divide the cinema hall into 3 sectors in rows.");
        do {
            System.out.print("The sum of the rows must be equal to the number of selected rows in the cinema. Ie.");
            System.out.println(numberOfRows2);
            System.out.println("How many rows will the 1st sector have?");
            sector1 = sc.nextInt();
            System.out.println("How many rows will the 2nd sector have?");
            sector2 = sc.nextInt();
            System.out.println("How many rows will the 3rd sector have?");
            sector3 = sc.nextInt();
            count = sector1 + sector2 + sector3;
        } while (count != numberOfRows2);
    }

    /**
     * Fill the second cinema hall with sectors according to the user specified
     * in the method typeSectorsSecondHall (). First sector = 1, second sector =
     * 2, third sector = 3
     */
    public static void sectorsSecondHall() {
        typeSectorsSecondHall();

        for (int i = 0; i < numberOfSeats2; i++) {
            for (int j = 0; j < sector1; j++) {
                secondHallFirstTime[i][j] = 1;
                secondHallSecondTime[i][j] = 1;
            }
        }
        for (int i = 0; i < numberOfSeats2; i++) {

            for (int j = sector1; j < sector1 + sector2; j++) {
                secondHallFirstTime[i][j] = 2;
                secondHallSecondTime[i][j] = 2;
            }
        }
        for (int i = 0; i < numberOfSeats2; i++) {
            for (int j = sector1 + sector2; j < sector1 + sector2 + sector3; j++) {
                secondHallFirstTime[i][j] = 3;
                secondHallSecondTime[i][j] = 3;
            }
        }
    }

    /**
     * Determining the size of the third cinema hall - 1st and 2nd projecting
     * time. int a - lists the coordinates of the number of rows. column [m] -
     * lists the coordinates of the number seats. sectorsThirdHall () - method
     * at the end referring to the division cinema hall to sectors
     */
    public static void sizeThirdHall() {
        System.out.println("Size of 3. cinema hall.");
        hallNumberOfRows();
        numberOfRows3 = numberOfRows();
        hallNumberOfSeats();
        numberOfSeats3 = numberOfPlaces();
        thirdHallFirstTime = new int[numberOfSeats3][numberOfRows3];
        thirdHallSecondTime = new int[numberOfSeats3][numberOfRows3];
        System.out.print("       ");
        for (int i = 0; i < numberOfRows3; i++) {
            for (int j = 0; j < numberOfSeats3; j++) {
            }
        }
        int[] column = new int[numberOfSeats3 + 1];
        int a = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);
        }
        System.out.println();
        for (int j = 0; j < thirdHallFirstTime[0].length; j++) {
            System.out.print(a + ". row  ");
            a++;
            for (int i = 0; i < thirdHallFirstTime.length; i++) {
                System.out.print(thirdHallFirstTime[i][j] + "  ");
            }
            System.out.println();
        }
        sectorsThirdHall();
    }

    /**
     * Listing of the third cinema hall - 1st projecting time. int a1 - lists
     * coordinat number of rows. column [m] - lists the coordinates of the
     * number of column. reservationThirdHall() - method referring to the
     * reservation by the customer
     */
    public static void listThirdHall() {
        System.out.print("       ");
        int[] column = new int[numberOfSeats3 + 1];
        int a1 = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);
        }
        System.out.println();
        for (int j = 0; j < thirdHallFirstTime[0].length; j++) {
            System.out.print(a1 + ". row  ");
            a1++;
            for (int i = 0; i < thirdHallFirstTime.length; i++) {
                System.out.print(thirdHallFirstTime[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("(5-occupied seat.)");
        reservationThirdHall();
    }

    /**
     * Reservation of the third cinema hall - 1st projecting time int a2 - print
     * coordinates of the number of rows. column [m] - lists the coordinates of
     * the number of seats. row - enter the selected rows. seat - enter the
     * selected seat. if-else cycle to booking the seat - be marked with the
     * number 5
     */
    public static void reservationThirdHall() {
        int[] column = new int[numberOfSeats3 + 1];
        System.out.println("\nEnter the row:");
        int row = sc.nextInt();
        System.out.println("Enter the seat:");
        int seat = sc.nextInt();
        if ((seat > 0 && seat <= numberOfSeats3) && (row > 0 && row <= numberOfRows3) && ((thirdHallFirstTime[seat - 1][row - 1] == 1) || (thirdHallFirstTime[seat - 1][row - 1] == 2) || (thirdHallFirstTime[seat - 1][row - 1] == 3))) {
            thirdHallFirstTime[seat - 1][row - 1] = 5;
            System.out.println("Orderer");

        } else if ((seat > 0 && seat <= numberOfSeats3) && (row > 0 && row <= numberOfRows3) && thirdHallFirstTime[seat - 1][row - 1] == 5) {
            System.out.println("This place is already taken.");

        } else if ((seat <= 0 || seat > numberOfSeats3) || (row <= 0 || row > numberOfRows3)) {
            System.out.println("You cannot select seats off schedule.");
        }

        System.out.print("       ");
        for (int i = 0; i < numberOfRows3; i++) {
            for (int j = 0; j < numberOfSeats3; j++) {
            }
        }
        int a2 = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);
        }
        System.out.println();
        for (int j = 0; j < thirdHallFirstTime[0].length; j++) {
            System.out.print(a2 + ". row  ");
            a2++;
            for (int i = 0; i < thirdHallFirstTime.length; i++) {
                System.out.print(thirdHallFirstTime[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("(5-occupied seat.)");
    }

    /**
     * Listing of the third cinema hall - 2nd projecting time. int a1 - lists
     * coordinat number of rows. column [m] - lists the coordinates of the
     * number of column. reservationThirdHall2() - method referring to the
     * reservation by the customer
     */
    public static void listThirdHall2() {
        System.out.print("       ");

        int[] column = new int[numberOfSeats3 + 1];
        int a1 = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);
        }
        System.out.println();
        for (int j = 0; j < thirdHallSecondTime[0].length; j++) {
            System.out.print(a1 + ". row  ");
            a1++;
            for (int i = 0; i < thirdHallSecondTime.length; i++) {
                System.out.print(thirdHallSecondTime[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("(5-occupied seat.)");
        reservationThirdHall2();
    }

    /**
     * Reservation of the third cinema hall - 2nd projecting time int a2 - print
     * coordinates of the number of rows. column [m] - lists the coordinates of
     * the number of seats. row - enter the selected rows. seat - enter the
     * selected seat. if-else cycle to booking the seat - be marked with the
     * number 5
     */
    public static void reservationThirdHall2() {
        int[] column = new int[numberOfSeats3 + 1];
        System.out.println("\nEnter the row:");
        int row = sc.nextInt();
        System.out.println("Enter the seat:");
        int seat = sc.nextInt();
        if ((seat > 0 && seat <= numberOfSeats3) && (row > 0 && row <= numberOfRows3) && ((thirdHallSecondTime[seat - 1][row - 1] == 1) || (thirdHallSecondTime[seat - 1][row - 1] == 2) || (thirdHallSecondTime[seat - 1][row - 1] == 3))) {
            thirdHallSecondTime[seat - 1][row - 1] = 5;
            System.out.println("Orderer");

        } else if ((seat > 0 && seat <= numberOfSeats3) && (row > 0 && row <= numberOfRows3) && thirdHallSecondTime[seat - 1][row - 1] == 5) {
            System.out.println("This place is already taken.");

        } else if ((seat <= 0 || seat > numberOfSeats3) || (row <= 0 || row > numberOfRows3)) {
            System.out.println("You cannot select seats off schedule.");
        }

        System.out.print("       ");
        for (int i = 0; i < numberOfRows3; i++) {
            for (int j = 0; j < numberOfSeats3; j++) {
            }
        }
        int a2 = 1;
        for (int m = 1; m < column.length; m++) {
            column[m] = m;
            System.out.print("  " + column[m]);
        }
        System.out.println();
        for (int j = 0; j < thirdHallSecondTime[0].length; j++) {
            System.out.print(a2 + ". row  ");
            a2++;
            for (int i = 0; i < thirdHallSecondTime.length; i++) {
                System.out.print(thirdHallSecondTime[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("(5-occupied seat.)");
    }

    /**
     * Division of the third cinema hall into 3 sectors. count - the count of
     * the specified three sectors must be equal to the number of rows in the
     * cinema
     */
    public static void typeSectorsThirdHall() {
        System.out.println("You divide the cinema hall into 3 sectors in rows.");
        do {
            System.out.print("The sum of the rows must be equal to the number of selected rows in the cinema. Ie.");
            System.out.println(numberOfRows3);
            System.out.println("How many rows will the 1st sector have?");
            sector1 = sc.nextInt();
            System.out.println("How many rows will the 2nd sector have?");
            sector2 = sc.nextInt();
            System.out.println("How many rows will the 3rd sector have?");
            sector3 = sc.nextInt();
            count = sector1 + sector2 + sector3;
        } while (count != numberOfRows3);
    }

    /**
     * Fill the third cinema hall with sectors according to the user specified
     * in the method typeSectorsThirdHall (). First sector = 1, second sector =
     * 2, third sector = 3
     */
    public static void sectorsThirdHall() {
        typeSectorsThirdHall();
        for (int i = 0; i < numberOfSeats3; i++) {
            for (int j = 0; j < sector1; j++) {
                thirdHallFirstTime[i][j] = 1;
                thirdHallSecondTime[i][j] = 1;
            }
        }
        for (int i = 0; i < numberOfSeats3; i++) {

            for (int j = sector1; j < sector1 + sector2; j++) {
                thirdHallFirstTime[i][j] = 2;
                thirdHallSecondTime[i][j] = 2;
            }
        }
        for (int i = 0; i < numberOfSeats3; i++) {
            for (int j = sector1 + sector2; j < sector1 + sector2 + sector3; j++) {
                thirdHallFirstTime[i][j] = 3;
                thirdHallSecondTime[i][j] = 3;
            }
        }
    }

    /**
     * Display of the cinema program
     */
    public static void movieSchedule() {
        System.out.println(film1 + "\n" + timeH1 + ":" + timeM1 + "\n" + timeH2 + ":" + timeM2 + "\n");
        System.out.println(film2 + "\n" + timeH3 + ":" + timeM3 + "\n" + timeH4 + ":" + timeM4 + "\n");
        System.out.println(film3 + "\n" + timeH5 + ":" + timeM5 + "\n" + timeH6 + ":" + timeM6 + "\n");
    }

    /**
     * Switch for movie selection, time and seat reservation
     */
    public static void mainSwitch() {
        movieSchedule();
        int choice = 0;
        do {
            System.out.println("Select 1-2.\n1. Reservation\n2. End ");
            choice = sc.nextInt();
        } while (choice != 1 && choice != 2);

        int contin = 1;
        while (contin == 1) {
            switch (choice) {
                case 1:
                    System.out.println("Select film.\n1. " + film1 + "\n2. " + film2 + "\n3. " + film3);
                    int film = sc.nextInt();
                    switch (film) {
                        case 1:
                            System.out.println("Select the projection time(1-2).\n1. " + timeH1 + ":" + timeM1 + "\n2. " + timeH2 + ":" + timeM2);
                            int time = sc.nextInt();
                            switch (time) {
                                case 1:
                                    listFirstHall();
                                    break;
                                case 2:
                                    listFirstHall2();
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Select the projection time(1-2).\n1. " + timeH3 + ":" + timeM3 + "\n2. " + timeH4 + ":" + timeM4);
                            int time2 = sc.nextInt();
                            switch (time2) {
                                case 1:
                                    listSecondHall();
                                    break;
                                case 2:
                                    listSecondHall2();
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("Select the projection time(1-2).\n1. " + timeH5 + ":" + timeM5 + "\n2. " + timeH6 + ":" + timeM6);
                            int time3 = sc.nextInt();
                            switch (time3) {
                                case 1:
                                    listThirdHall();
                                    break;
                                case 2:
                                    listThirdHall2();
                                    break;
                            }
                            break;
                        default:
                            continue;
                    }
                case 2:
                    break;
            }
            do {
                System.out.println("\nDo you want to book a seat - select a number. [1-yes/2-no]");
                contin = sc.nextInt();
            } while (contin != 1 && contin != 2);
        }
    }

    /**
     * Save already entered data
     */
    public static void save() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("soubor.txt"))) {
            bw.write("film:" + film1 + ";" + timeH1 + ";" + timeM1 + ";" + timeH2 + ";" + timeM2 + ";" + numberOfRows1 + ";" + numberOfSeats1 + ";" + film2 + ";" + timeH3 + ";" + timeM3 + ";" + timeH4 + ";" + timeM4 + ";" + numberOfRows2 + ";" + numberOfSeats2 + ";" + film3 + ";" + timeH5 + ";" + timeM5 + ";" + timeH6 + ";" + timeM6 + ";" + numberOfRows3 + ";" + numberOfSeats3 + ";");
            bw.newLine();
            bw.flush();
            for (int j = 0; j < firstHallFirstTime[0].length; j++) {
                bw.write("line11:");
                for (int i = 0; i < firstHallFirstTime.length; i++) {
                    bw.write(firstHallFirstTime[i][j] + ";");
                }
                bw.newLine();
                bw.flush();
            }

            for (int j = 0; j < firstHallSecondTime[0].length; j++) {
                bw.write("line12:");
                for (int i = 0; i < firstHallSecondTime.length; i++) {
                    bw.write(firstHallSecondTime[i][j] + ";");
                }
                bw.newLine();
                bw.flush();
            }

            for (int j = 0; j < secondHallFirstTime[0].length; j++) {
                bw.write("line21:");
                for (int i = 0; i < secondHallFirstTime.length; i++) {
                    bw.write(secondHallFirstTime[i][j] + ";");
                }
                bw.newLine();
                bw.flush();
            }

            for (int j = 0; j < secondHallSecondTime[0].length; j++) {
                bw.write("line22:");
                for (int i = 0; i < secondHallSecondTime.length; i++) {
                    bw.write(secondHallSecondTime[i][j] + ";");
                }
                bw.newLine();
                bw.flush();
            }

            for (int j = 0; j < thirdHallFirstTime[0].length; j++) {
                bw.write("line31:");
                for (int i = 0; i < thirdHallFirstTime.length; i++) {
                    bw.write(thirdHallFirstTime[i][j] + ";");
                }
                bw.newLine();
                bw.flush();
            }

            for (int j = 0; j < thirdHallSecondTime[0].length; j++) {
                bw.write("line32:");
                for (int i = 0; i < thirdHallSecondTime.length; i++) {
                    bw.write(thirdHallSecondTime[i][j] + ";");
                }
                bw.newLine();
                bw.flush();
            }

        } catch (Exception e) {
            System.err.println("Failed to write to file.");
        }

    }

    /**
     * data retrieval for movies and first hall, first time
        */
    public static void continue11() throws IOException {
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader("soubor.txt"));

            while ((line = in.readLine()) != null) {
                if (line.startsWith("film:")) {
                    line = line.replaceAll("film:", "");
                    String[] record = line.split(";");

                    film1 = record[0];
                    timeH1 = Integer.parseInt(record[1]);
                    timeM1 = Integer.parseInt(record[2]);
                    timeH2 = Integer.parseInt(record[3]);
                    timeM2 = Integer.parseInt(record[4]);
                    numberOfRows1 = Integer.parseInt(record[5]);
                    numberOfSeats1 = Integer.parseInt(record[6]);
                    film2 = record[7];
                    timeH3 = Integer.parseInt(record[8]);
                    timeM3 = Integer.parseInt(record[9]);
                    timeH4 = Integer.parseInt(record[10]);
                    timeM4 = Integer.parseInt(record[11]);
                    numberOfRows2 = Integer.parseInt(record[12]);
                    numberOfSeats2 = Integer.parseInt(record[13]);
                    film3 = record[14];
                    timeH5 = Integer.parseInt(record[15]);
                    timeM5 = Integer.parseInt(record[16]);
                    timeH6 = Integer.parseInt(record[17]);
                    timeM6 = Integer.parseInt(record[18]);
                    numberOfRows3 = Integer.parseInt(record[19]);
                    numberOfSeats3 = Integer.parseInt(record[20]);

                }
                firstHallFirstTime = new int[numberOfRows1][numberOfSeats1];
                int lineCount = 0;
                while ((line = in.readLine()) != null) {

                    if (line.startsWith("line11:")) {

                        line = line.replaceAll("line11:", "");
                        String[] record = line.split(";");
                        for (int i = 0; i < record.length; i++) {
                            firstHallFirstTime[i][lineCount] = Integer.parseInt(record[i]);
                        }
                        lineCount++;
                    }
                }
            }
        } catch (IOException ioException) {
        }
    }

    /**
     * data retrieval for movies and first hall, second time
     */
    public static void continue12() throws IOException {
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader("soubor.txt"));

            firstHallSecondTime = new int[numberOfRows1][numberOfSeats1];
            int lineCount = 0;
            while ((line = in.readLine()) != null) {

                if (line.startsWith("line12:")) {

                    line = line.replaceAll("line12:", "");
                    String[] record = line.split(";");
                    for (int i = 0; i < record.length; i++) {
                        firstHallSecondTime[i][lineCount] = Integer.parseInt(record[i]);
                    }
                    lineCount++;
                }
            }
        } catch (IOException ioException) {
        }
    }

    /**
 data retrieval for movies and second hall, first time
     */
    public static void continue21() throws IOException {
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader("soubor.txt"));

            secondHallFirstTime = new int[numberOfRows2][numberOfSeats2];
            int lineCount = 0;
            while ((line = in.readLine()) != null) {

                if (line.startsWith("line21:")) {

                    line = line.replaceAll("line21:", "");
                    String[] record = line.split(";");
                    for (int i = 0; i < record.length; i++) {
                        secondHallFirstTime[i][lineCount] = Integer.parseInt(record[i]);
                    }
                    lineCount++;
                }

            }
        } catch (IOException ioException) {
        }
    }

    /**
     * data retrieval for movies and second hall, second time
     */
    public static void continue22() throws IOException {
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader("soubor.txt"));

            secondHallSecondTime = new int[numberOfRows2][numberOfSeats2];
            int lineCount = 0;
            while ((line = in.readLine()) != null) {

                if (line.startsWith("line22:")) {

                    line = line.replaceAll("line22:", "");
                    String[] record = line.split(";");
                    for (int i = 0; i < record.length; i++) {
                        secondHallSecondTime[i][lineCount] = Integer.parseInt(record[i]);
                    }
                    lineCount++;
                }
            }
        } catch (IOException ioException) {
        }
    }

    /**
     * data retrieval for movies and third hall, first time
     */
    public static void continue31() throws IOException {
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader("soubor.txt"));

            thirdHallFirstTime = new int[numberOfRows3][numberOfSeats3];
            int lineCount = 0;
            while ((line = in.readLine()) != null) {

                if (line.startsWith("line31:")) {

                    line = line.replaceAll("line31:", "");
                    String[] record = line.split(";");
                    for (int i = 0; i < record.length; i++) {
                        thirdHallFirstTime[i][lineCount] = Integer.parseInt(record[i]);
                    }
                    lineCount++;
                }
            }
        } catch (IOException ioException) {
        }
    }

    /**
    data retrieval for movies and third hall, secibd time
     */
    public static void continue32() throws IOException {
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader("soubor.txt"));

            thirdHallSecondTime = new int[numberOfRows3][numberOfSeats3];
            int lineCount = 0;
            while ((line = in.readLine()) != null) {

                if (line.startsWith("line32:")) {

                    line = line.replaceAll("line32:", "");
                    String[] record = line.split(";");
                    for (int i = 0; i < record.length; i++) {
                        thirdHallSecondTime[i][lineCount] = Integer.parseInt(record[i]);
                    }
                    lineCount++;
                }
            }
        } catch (IOException ioException) {
        }
    }

    /**
     * načtení všech dat ze souboru
     *
     * @throws IOException
     */
    public static void loadData() throws IOException {
        continue11();
        continue12();
        continue21();
        continue22();
        continue31();
        continue32();
    }

    /**
     * main program
     *
     * @throws IOException
     */
    public static void program() throws IOException {
        int choice = 0;
        do {
            System.out.println("Welcome to our AA Cinemas system. Choose::\n1- redefine sizes, projected movies and times. \n2- load already saved data.");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("As an operator you can choose the size of the three cinemas, the topology, the individual films and the projecting times now.");
                sizeFirstHall();
                filmTime1();
                sizeSecondHall();
                filmTime2();
                sizeThirdHall();
                filmTime3();
                System.out.println("\nProgram:");
                mainSwitch();
                System.out.println("Thank you.");
                save();
            } else if (choice == 2) {
                loadData();
                System.out.println("\nProgram:");
                mainSwitch();
                System.out.println("Thank you.");
                save();
            }
        } while (choice != 1 && choice != 2);

    }

    public static void main(String[] args) throws IOException, Exception {
        program();

    }
}
