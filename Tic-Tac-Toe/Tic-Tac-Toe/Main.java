import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String p00 = " "; // these are empty string that will later be turned to either X or 0
        String p01 = " ";
        String p02 = " ";
        String p10 = " ";
        String p11 = " ";
        String p12 = " ";
        String p20 = " ";
        String p21 = " ";
        String p22 = " ";
        int turn = 0; // used for determining which player is active

        boolean Gameover = false;
        while (!Gameover) {
            // this is the grid
            System.out.println("-------------------");
            System.out.println("| " + "    | " + "    | " + "    |");
            System.out.println("| " + p00 + "   | " + p01 + "   | " + p02 + "   |");
            System.out.println("| " + "    | " + "    | " + "    |");
            System.out.println("-------------------");
            System.out.println("| " + "    | " + "    | " + "    |");
            System.out.println("| " + p10 + "   | " + p11 + "   | " + p12 + "   |");
            System.out.println("| " + "    | " + "    | " + "    |");
            System.out.println("-------------------");
            System.out.println("| " + "    | " + "    | " + "    |");
            System.out.println("| " + p20 + "   | " + p21 + "   | " + p22 + "   |");
            System.out.println("| " + "    | " + "    | " + "    |");
            System.out.println("-------------------");

            // chooses which player is active and asks them for placement
            String playerSymbol = (turn % 2 == 0) ? "X" : "O";
            System.out.println("Player " + (turn % 2) + " (" + playerSymbol + ") turn");
            System.out.print("Enter row (0, 1 or 2): ");
            int row = input.nextInt();
            System.out.print("Enter a column (0, 1 or 2): ");
            int column = input.nextInt();
            if (row == 0 && column == 0 && p00.equals(" "))
                p00 = playerSymbol;
            else if (row == 0 && column == 1 && p01.equals(" "))
                p01 = playerSymbol;
            else if (row == 0 && column == 2 && p02.equals(" "))
                p02 = playerSymbol;
            else if (row == 1 && column == 0 && p10.equals(" "))
                p10 = playerSymbol;
            else if (row == 1 && column == 1 && p11.equals(" "))
                p11 = playerSymbol;
            else if (row == 1 && column == 2 && p12.equals(" "))
                p12 = playerSymbol;
            else if (row == 2 && column == 0 && p20.equals(" "))
                p20 = playerSymbol;
            else if (row == 2 && column == 1 && p21.equals(" "))
                p21 = playerSymbol;
            else if (row == 2 && column == 2 && p22.equals(" "))
                p22 = playerSymbol;
            else {
                System.out.println("That placement is invalid, try a different one.");
                continue; // if the placement is already taken or invalid then it loops and asks again
            }
            turn++;
            if ((p00.equals(playerSymbol) && p01.equals(playerSymbol) && p02.equals(playerSymbol)) || // rows
                    (p10.equals(playerSymbol) && p11.equals(playerSymbol) && p12.equals(playerSymbol)) ||
                    (p20.equals(playerSymbol) && p21.equals(playerSymbol) && p22.equals(playerSymbol)) ||
                    (p00.equals(playerSymbol) && p10.equals(playerSymbol) && p20.equals(playerSymbol)) || // columns
                    (p01.equals(playerSymbol) && p11.equals(playerSymbol) && p21.equals(playerSymbol)) ||
                    (p02.equals(playerSymbol) && p12.equals(playerSymbol) && p22.equals(playerSymbol)) ||
                    (p00.equals(playerSymbol) && p11.equals(playerSymbol) && p22.equals(playerSymbol)) || // diagonals
                    (p02.equals(playerSymbol) && p11.equals(playerSymbol) && p20.equals(playerSymbol))) {

                System.out.println("Player " + ((turn - 1) % 2) + " (" + playerSymbol + ") wins!");
                Gameover = true;
            } else if (!p00.equals(" ") && !p01.equals(" ") && !p02.equals(" ") &&
                    !p10.equals(" ") && !p11.equals(" ") && !p12.equals(" ") &&
                    !p20.equals(" ") && !p21.equals(" ") && !p22.equals(" ")) {
                System.out.println("It's a draw!");
                Gameover = true;
            }

        }
        input.close();
    }
}
