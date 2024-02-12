import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;












public class Main {




        private final int MAX = 10;
        private final int MIN = 0;
        private int sub[] = new int[4];
        private int frig[] = new int[6];
        private int destroy[] = new int[8];
        private int air[] = new int[10];
        private String map[][] = new String[10][10];
        private String userMap[][] = new String[10][10];
        private String userMap2[][] = new String[10][10];
        private String enemyMap[][] = new String[10][10];
        private boolean continues = true;




        private String letterChoice = "ABCDEFGHIJ";




        public boolean submarine(int orientation, String space, String player)
        {
                char letter = space.charAt(0);
                sub[0] = letter - 'A';
                sub[1] = space.charAt(1) - '0';




                if (player.equals("player1")) {
                        if (sub[0] >= 0 && sub[0] < 10 && sub[1] >= 0 && sub[1] < 10) {
                                switch (orientation) {
                                        case 1:
                                                sub[3] = sub[1];
                                                if (sub[0] >= 0 && sub[0] < 9) {
                                                        sub[2] = sub[0] + 1;
                                                } else if (sub[0] > 0 && sub[1] <= 9) {
                                                        sub[2] = sub[0] - 1;
                                                } else {
                                                        continues = false;
                                                        return continues;
                                                }
                                                break;




                                        case 2:
                                                sub[2] = sub[0];
                                                if (sub[1] >= 0 && sub[1] < 9) {
                                                        sub[3] = sub[1] + 1;
                                                } else if (sub[1] > 0 && sub[1] <= 9) {
                                                        sub[3] = sub[1] - 1;
                                                } else {
                                                        continues = false;
                                                        return continues;
                                                }
                                                break;




                                        default:
                                                continues = false;
                                                return continues;
                                }




                                continues = true;
                                updateMap(sub, "S");
                        }
                        else
                        {
                                continues = false;
                        }
                }
                else if (player.equals("player2"))
                {
                        if (sub[0] >= 0 && sub[0] < 10 && sub[1] >= 0 && sub[1] < 10) {
                                switch (orientation) {
                                        case 1:
                                                sub[3] = sub[1];
                                                if (sub[0] >= 0 && sub[0] < 9) {
                                                        sub[2] = sub[0] + 1;
                                                }
                                                else if (sub[0] > 0 && sub[0] <= 9) {
                                                        sub[2] = sub[0] - 1;
                                                }
                                                else {
                                                        continues = false;
                                                        return continues;
                                                }
                                                break;




                                        case 2:
                                                sub[2] = sub[0];
                                                if (sub[1] >= 0 && sub[1] < 9) {
                                                        sub[3] = sub[1] + 1;
                                                } else if (sub[1] > 0 && sub[1] <= 9) {
                                                        sub[3] = sub[1] - 1;
                                                } else {
                                                        continues = false;
                                                        return continues;
                                                }
                                                break;




                                        default:
                                                continues = false;
                                                return continues;
                                }




                                continues = true;
                                updateEnemyMap(sub, "S");
                        }
                        else {
                                continues = false;
                        }
                }




                return continues;
        }








        public boolean frigate(int orientation, String space, String player)
        {
                char letter = space.charAt(0);
                frig[0] = letter - 'A';
                frig[1] = space.charAt(1) - '0';




                if (player.equals("player1")) {
                        if (frig[0] >= 0 && frig[0] < 10 && frig[1] >= 0 && frig[1] < 10) {
                                if (frig[0] != sub[0] && frig[1] != sub[1]) {
                                        switch (orientation) {
                                                case 1:
                                                        frig[3] = frig[1];
                                                        frig[5] = frig[1];
                                                        if (frig[0] >= 0 && frig[0] < 8) {
                                                                frig[2] = frig[0] + 1;
                                                                frig[4] = frig[2] + 1;
                                                        } else if (frig[0] > 1 && frig[0] <= 9) {
                                                                frig[2] = frig[0] - 1;
                                                                frig[4] = frig[2] - 1;
                                                        } else {
                                                                continues = false;
                                                                return continues;
                                                        }
                                                        break;




                                                case 2:
                                                        frig[2] = frig[0];
                                                        frig[4] = frig[0];
                                                        if (frig[1] >= 0 && frig[1] < 8) {
                                                                frig[3] = frig[1] + 1;
                                                                frig[5] = frig[3] + 1;
                                                        } else if (frig[1] > 1 && frig[1] <= 9) {
                                                                frig[3] = frig[1] - 1;
                                                                frig[5] = frig[3] - 1;
                                                        } else {
                                                                continues = false;
                                                                return continues;
                                                        }
                                                        break;




                                                default:
                                                        continues = false;
                                                        return continues;
                                        }
                                        if (frig[2] != sub[0] && frig[3] != sub[1] && frig[4] != sub[0] && frig[5] != sub[1] && frig[2] != sub[2] && frig[3] != sub[3] && frig[4] != sub[2] && frig[5] != sub[3])
                                        {
                                                continues = true;
                                                updateMap(frig, "F");
                                        }
                                        else {
                                                continues = false;
                                        }
                                }
                                else {
                                        continues = false;
                                }




                        } else {
                                continues = false;
                        }
                }
                else if (player.equals("player2"))
                {
                        if (frig[0] >= 0 && frig[0] < 10 && frig[1] >= 0 && frig[1] < 10) {
                                if (frig[0] != sub[0] && frig[1] != sub[1]) {
                                        switch (orientation) {
                                                case 1:
                                                        frig[3] = frig[1];
                                                        frig[5] = frig[1];
                                                        if (frig[0] >= 0 && frig[0] < 8) {
                                                                frig[2] = frig[0] + 1;
                                                                frig[4] = frig[2] + 1;
                                                        } else if (frig[0] > 1 && frig[0] <= 9) {
                                                                frig[2] = frig[0] - 1;
                                                                frig[4] = frig[2] - 1;
                                                        } else {
                                                                continues = false;
                                                                return continues;
                                                        }
                                                        break;




                                                case 2:
                                                        frig[2] = frig[0];
                                                        frig[4] = frig[0];
                                                        if (frig[1] >= 0 && frig[1] < 8) {
                                                                frig[3] = frig[1] + 1;
                                                                frig[5] = frig[3] + 1;
                                                        } else if (frig[1] > 1 && frig[1] <= 9) {
                                                                frig[3] = frig[1] - 1;
                                                                frig[5] = frig[3] - 1;
                                                        } else {
                                                                continues = false;
                                                                return continues;
                                                        }
                                                        break;




                                                default:
                                                        continues = false;
                                                        return continues;
                                        }




                                        if (frig[2] != sub[0] && frig[3] != sub[1] && frig[4] != sub[0] && frig[5] != sub[1] && frig[2] != sub[2] && frig[3] != sub[3] && frig[4] != sub[2] && frig[5] != sub[3])
                                        {
                                                continues = true;
                                                updateEnemyMap(frig, "F");
                                        }
                                        else {
                                                continues = false;
                                        }
                                } else {
                                        continues = false;
                                }




                        } else {
                                continues = false;
                        }
                }
                return continues;
        }




        public boolean destroyer(int orientation, String space, String player)
        {
                char letter = space.charAt(0);
                destroy[0] = letter - 'A';
                destroy[1] = space.charAt(1) - '0';




                if (player.equals("player1")) {
                        if (destroy[0] >= 0 && destroy[0] < 10 && destroy[1] >= 0 && destroy[1] < 10) {
                                if ((destroy[0] != sub[0]) && (destroy[1] != sub[1]) || (destroy[0] != frig[0]) && (destroy[1] != frig[1])) {
                                        switch (orientation) {
                                                case 1:
                                                        destroy[3] = destroy[1];
                                                        destroy[5] = destroy[1];
                                                        destroy[7] = destroy[1];
                                                        if (destroy[0] >= 0 && destroy[0] < 7) {
                                                                destroy[2] = destroy[0] + 1;
                                                                destroy[4] = destroy[2] + 1;
                                                                destroy[6] = destroy[4] + 1;
                                                        } else if (destroy[0] > 2 && destroy[0] <= 9) {
                                                                destroy[2] = destroy[0] - 1;
                                                                destroy[4] = destroy[2] - 1;
                                                                destroy[6] = destroy[4] - 1;
                                                        } else {
                                                                continues = false;
                                                                return continues;
                                                        }
                                                        break;




                                                case 2:
                                                        destroy[2] = destroy[0];
                                                        destroy[4] = destroy[0];
                                                        destroy[6] = destroy[0];
                                                        if (destroy[1] >= 0 && destroy[1] < 7) {
                                                                destroy[3] = destroy[1] + 1;
                                                                destroy[5] = destroy[3] + 1;
                                                                destroy[7] = destroy[5] + 1;
                                                        } else if (destroy[1] > 2 && destroy[1] <= 9) {
                                                                destroy[3] = destroy[1] - 1;
                                                                destroy[5] = destroy[3] - 1;
                                                                destroy[7] = destroy[5] - 1;
                                                        } else {
                                                                continues = false;
                                                                return continues;
                                                        }
                                                        break;




                                                default:
                                                        continues = false;
                                                        return continues;
                                        }




                                        // Check if the destroy array does not overlap with frig, sub, or air
                                        if (!((destroy[4] == frig[2] && destroy[5] == frig[3]) ||
                                                        (destroy[2] == sub[0] && destroy[3] == sub[1]) ||
                                                        (destroy[4] == sub[0] && destroy[5] == sub[1]) ||
                                                        (destroy[2] == sub[2] && destroy[3] == sub[3]) ||
                                                        (destroy[4] == sub[2] && destroy[5] == sub[3]) ||
                                                        (destroy[2] == frig[4] && destroy[3] == frig[5]) ||
                                                        (destroy[4] == frig[4] && destroy[5] == frig[5]) ||
                                                        (destroy[6] == frig[0] && destroy[7] == frig[1]) ||
                                                        (destroy[6] == frig[2] && destroy[7] == frig[3]) ||
                                                        (destroy[6] == sub[0] && destroy[7] == sub[1]) ||
                                                        (destroy[6] == sub[2] && destroy[7] == sub[3]) ||
                                                        (destroy[6] == frig[4] && destroy[7] == frig[5]) ||
                                                        (destroy[4] == air[2] && destroy[5] == air[3]) ||
                                                        (destroy[6] == air[6] && destroy[7] == air[7]))) {
                                                continues = true;
                                                updateMap(destroy, "D");
                                        } else {
                                                continues = false;
                                        }
                                } else {
                                        continues = false;
                                }




                        } else {
                                continues = false;
                        }
                }
                else if (player.equals("player2"))
                {
                        if (destroy[0] >= 0 && destroy[0] < 10 && destroy[1] >= 0 && destroy[1] < 10) {
                                if ((destroy[0] != sub[0]) && (destroy[1] != sub[1]) || (destroy[0] != frig[0]) && (destroy[1] != frig[1])) {
                                        switch (orientation) {
                                                case 1:
                                                        destroy[3] = destroy[1];
                                                        destroy[5] = destroy[1];
                                                        destroy[7] = destroy[1];
                                                        if (destroy[0] >= 0 && destroy[0] < 7) {
                                                                destroy[2] = destroy[0] + 1;
                                                                destroy[4] = destroy[2] + 1;
                                                                destroy[6] = destroy[4] + 1;
                                                        }
                                                        else if (destroy[0] > 2 && destroy[0] <= 9) {
                                                                destroy[2] = destroy[0] - 1;
                                                                destroy[4] = destroy[2] - 1;
                                                                destroy[6] = destroy[4] - 1;
                                                        } else {
                                                                continues = false;
                                                                return continues;
                                                        }
                                                        break;




                                                case 2:
                                                        destroy[2] = destroy[0];
                                                        destroy[4] = destroy[0];
                                                        destroy[6] = destroy[0];
                                                        if (destroy[1] >= 0 && destroy[1] < 7) {
                                                                destroy[3] = destroy[1] + 1;
                                                                destroy[5] = destroy[3] + 1;
                                                                destroy[7] = destroy[5] + 1;
                                                        } else if (destroy[1] > 2 && destroy[1] <= 9) {
                                                                destroy[3] = destroy[1] - 1;
                                                                destroy[5] = destroy[3] - 1;
                                                                destroy[7] = destroy[5] - 1;
                                                        } else {
                                                                continues = false;
                                                                return continues;
                                                        }
                                                        break;




                                                default:
                                                        continues = false;
                                                        return continues;
                                        }




                                        // Check if the destroy array does not overlap with frig, sub, or air
                                        if (!((destroy[4] == frig[2] && destroy[5] == frig[3]) ||
                                                        (destroy[2] == sub[0] && destroy[3] == sub[1]) ||
                                                        (destroy[4] == sub[0] && destroy[5] == sub[1]) ||
                                                        (destroy[2] == sub[2] && destroy[3] == sub[3]) ||
                                                        (destroy[4] == sub[2] && destroy[5] == sub[3]) ||
                                                        (destroy[2] == frig[4] && destroy[3] == frig[5]) ||
                                                        (destroy[4] == frig[4] && destroy[5] == frig[5]) ||
                                                        (destroy[6] == frig[0] && destroy[7] == frig[1]) ||
                                                        (destroy[6] == frig[2] && destroy[7] == frig[3]) ||
                                                        (destroy[6] == sub[0] && destroy[7] == sub[1]) ||
                                                        (destroy[6] == sub[2] && destroy[7] == sub[3]) ||
                                                        (destroy[6] == frig[4] && destroy[7] == frig[5]) ||
                                                        (destroy[4] == air[2] && destroy[5] == air[3]) ||
                                                        (destroy[6] == air[6] && destroy[7] == air[7]))) {
                                                continues = true;
                                                updateEnemyMap(destroy, "D");
                                        } else {
                                                continues = false;
                                        }
                                }
                                else {
                                        continues = false;
                                }




                        } else {
                                continues = false;
                        }
                }




                return continues;
        }




        public boolean carrier(int orientation, String space, String player)
        {




                char letter = space.charAt(0);
                air[0] = letter - 'A';
                air[1] = space.charAt(1) - '0';




                if (player.equals("player1")) {
                        if (air[0] >= 0 && air[0] < 10 && air[1] >= 0 && air[1] < 10) {
                                if ((air[0] != sub[0] && air[1] != sub[1]) || (air[0] != frig[0] && air[1] != frig[1]) || (air[0] != destroy[0] && air[1] != destroy[1])) {
                                        switch (orientation) {
                                                case 1:
                                                        air[3] = air[1];
                                                        air[5] = air[1];
                                                        air[7] = air[1];
                                                        air[9] = air[1];
                                                        if (air[0] >= 0 && air[0] < 6) {
                                                                air[2] = air[0] + 1;
                                                                air[4] = air[2] + 1;
                                                                air[6] = air[4] + 1;
                                                                air[8] = air[6] + 1;
                                                        } else if (air[0] > 3 && air[0] <= 9) {
                                                                air[2] = air[0] - 1;
                                                                air[4] = air[2] - 1;
                                                                air[6] = air[4] - 1;
                                                                air[8] = air[6] - 1;
                                                        } else {
                                                                continues = false;
                                                                return continues;
                                                        }
                                                        break;




                                                case 2:
                                                        air[2] = air[0];
                                                        air[4] = air[0];
                                                        air[6] = air[0];
                                                        air[8] = air[0];
                                                        if (air[1] >= 0 && air[1] < 6) {
                                                                air[3] = air[1] + 1;
                                                                air[5] = air[3] + 1;
                                                                air[7] = air[5] + 1;
                                                                air[9] = air[7] + 1;
                                                        } else if (air[1] > 3 && air[1] <= 9) {
                                                                air[3] = air[1] - 1;
                                                                air[5] = air[3] - 1;
                                                                air[7] = air[5] - 1;
                                                                air[9] = air[7] - 1;
                                                        } else {
                                                                continues = false;
                                                                return continues;
                                                        }
                                                        break;




                                                default:
                                                        continues = false;
                                                        return continues;
                                        }




                                        // Check if the air array does not overlap with frig, sub, or destroy
                                        if (!((air[4] == frig[2] && air[5] == frig[3]) ||
                                                        (air[2] == sub[0] && air[3] == sub[1]) ||
                                                        (air[4] == sub[0] && air[5] == sub[1]) ||
                                                        (air[2] == sub[2] && air[3] == sub[3]) ||
                                                        (air[4] == sub[2] && air[5] == sub[3]) ||
                                                        (air[2] == frig[4] && air[3] == frig[5]) ||
                                                        (air[4] == frig[4] && air[5] == frig[5]) ||
                                                        (air[6] == frig[0] && air[7] == frig[1]) ||
                                                        (air[6] == frig[2] && air[7] == frig[3]) ||
                                                        (air[6] == sub[0] && air[7] == sub[1]) ||
                                                        (air[6] == sub[2] && air[7] == sub[3]) ||
                                                        (air[6] == frig[4] && air[7] == frig[5]) ||
                                                        (air[4] == destroy[2] && air[5] == destroy[3]) ||
                                                        (air[6] == destroy[6] && air[7] == destroy[7]))) {
                                                continues = true;
                                                updateMap(air, "A");
                                        } else {
                                                continues = false;
                                        }
                                } else {
                                        continues = false;
                                }




                        } else {
                                continues = false;
                        }
                }
                else if (player.equals("player2"))
                {
                        if (air[0] >= 0 && air[0] < 10 && air[1] >= 0 && air[1] < 10) {
                                if ((air[0] != sub[0] && air[1] != sub[1]) || (air[0] != frig[0] && air[1] != frig[1]) || (air[0] != destroy[0] && air[1] != destroy[1])) {
                                        switch (orientation) {
                                                case 1:
                                                        air[3] = air[1];
                                                        air[5] = air[1];
                                                        air[7] = air[1];
                                                        air[9] = air[1];
                                                        if (air[0] >= 0 && air[0] < 6) {
                                                                air[2] = air[0] + 1;
                                                                air[4] = air[2] + 1;
                                                                air[6] = air[4] + 1;
                                                                air[8] = air[6] + 1;
                                                        } else if (air[0] > 3 && air[0] <= 9) {
                                                                air[2] = air[0] - 1;
                                                                air[4] = air[2] - 1;
                                                                air[6] = air[4] - 1;
                                                                air[8] = air[6] - 1;
                                                        } else {
                                                                continues = false;
                                                                return continues;
                                                        }
                                                        break;




                                                case 2:
                                                        air[2] = air[0];
                                                        air[4] = air[0];
                                                        air[6] = air[0];
                                                        air[8] = air[0];
                                                        if (air[1] >= 0 && air[1] < 6) {
                                                                air[3] = air[1] + 1;
                                                                air[5] = air[3] + 1;
                                                                air[7] = air[5] + 1;
                                                                air[9] = air[7] + 1;
                                                        } else if (air[1] > 3 && air[1] <= 9) {
                                                                air[3] = air[1] - 1;
                                                                air[5] = air[3] - 1;
                                                                air[7] = air[5] - 1;
                                                                air[9] = air[7] - 1;
                                                        } else {
                                                                continues = false;
                                                                return continues;
                                                        }
                                                        break;




                                                default:
                                                        continues = false;
                                                        return continues;
                                        }




                                        // Check if the air array does not overlap with frig, sub, or destroy
                                        if (!((air[4] == frig[2] && air[5] == frig[3]) ||
                                                        (air[2] == sub[0] && air[3] == sub[1]) ||
                                                        (air[4] == sub[0] && air[5] == sub[1]) ||
                                                        (air[2] == sub[2] && air[3] == sub[3]) ||
                                                        (air[4] == sub[2] && air[5] == sub[3]) ||
                                                        (air[2] == frig[4] && air[3] == frig[5]) ||
                                                        (air[4] == frig[4] && air[5] == frig[5]) ||
                                                        (air[6] == frig[0] && air[7] == frig[1]) ||
                                                        (air[6] == frig[2] && air[7] == frig[3]) ||
                                                        (air[6] == sub[0] && air[7] == sub[1]) ||
                                                        (air[6] == sub[2] && air[7] == sub[3]) ||
                                                        (air[6] == frig[4] && air[7] == frig[5]) ||
                                                        (air[4] == destroy[2] && air[5] == destroy[3]) ||
                                                        (air[6] == destroy[6] && air[7] == destroy[7]))) {
                                                continues = true;
                                                updateEnemyMap(air, "A");
                                        } else {
                                                continues = false;
                                        }
                                } else {
                                        continues = false;
                                }




                        } else {
                                continues = false;
                        }
                }




                return continues;
        }




        public boolean mine(String mines, String player)
        {
                if (mines.length() >= 2 && mines.length() <= 3) {
                        char letter = mines.charAt(0);
                        int row = letter - 'A';
                        int col = 0;
                        String part = mines.substring(1);




                        if (mines.length() == 2) {
                                col = Integer.valueOf(part);
                        } else if (mines.length() == 3) {
                                col = 10;
                        }




                        if (player.equals("player1")) {
                                if (row >= 0 && row < 10 && col >= 0 && col < 10) {
                                        if (!map[row][col].equals("S") && !map[row][col].equals("F") && !map[row][col].equals("D") && !map[row][col].equals("A")) {
                                                map[row][col] = "M";
                                                continues = true;
                                        }
                                        else
                                        {
                                                continues = false;
                                                return continues;
                                        }




                                }
                        }
                        else if (player.equals("player2")) {
                                if (row >= 0 && row < 10 && col >= 0 && col < 10) {
                                        if (!enemyMap[row][col].equals("S") && !enemyMap[row][col].equals("F") && !enemyMap[row][col].equals("D") && !enemyMap[row][col].equals("A")) {
                                                enemyMap[row][col] = "M";
                                                continues = true;
                                        }
                                        else
                                        {
                                                continues = false;
                                                return continues;
                                        }




                                }
                        }
                }
                return continues;
        }




        private void updateMap(int[] ship, String shipType) {




                int startX = ship[0];
                int startY = ship[1];
                int endX = ship[2];
                int endY = ship[3];








                if (shipType.equals("S"))
                {
                        startX = ship[0];
                        startY = ship[1];
                        endX = ship[2];
                        endY = ship[3];
                }
                else if (shipType.equals("F"))
                {
                        startX = ship[0];
                        startY = ship[1];
                        endX = ship[4];
                        endY = ship[5];
                }
                else if (shipType.equals("D"))
                {
                        startX = ship[0];
                        startY = ship[1];
                        endX = ship[6];
                        endY = ship[7];
                }
                else if (shipType.equals("A"))
                {
                        startX = ship[0];
                        startY = ship[1];
                        endX = ship[8];
                        endY = ship[9];
                }












                for (int i = startX; i <= endX; i++) {
                        for (int j = startY; j <= endY; j++) {
                                map[i][j] = shipType;
                        }
                }
        }




        private void updateEnemyMap(int[] ship, String shipType) {




                int startX = ship[0];
                int startY = ship[1];
                int endX = ship[2];
                int endY = ship[3];








                if (shipType.equals("S"))
                {
                        startX = ship[0];
                        startY = ship[1];
                        endX = ship[2];
                        endY = ship[3];
                }
                else if (shipType.equals("F"))
                {
                        startX = ship[0];
                        startY = ship[1];
                        endX = ship[4];
                        endY = ship[5];
                }
                else if (shipType.equals("D"))
                {
                        startX = ship[0];
                        startY = ship[1];
                        endX = ship[6];
                        endY = ship[7];
                }
                else if (shipType.equals("A"))
                {
                        startX = ship[0];
                        startY = ship[1];
                        endX = ship[8];
                        endY = ship[9];
                }












                for (int i = startX; i <= endX; i++) {
                        for (int j = startY; j <= endY; j++) {
                                enemyMap[i][j] = shipType;
                        }
                }
        }




        public void shoot(String shot)
        {
                Random randint = new Random();
                if (shot.length() >= 2 && shot.length() <= 3) {
                        char letter = shot.charAt(0);
                        int row = letter - 'A';
                        int col = 0;
                        String part = shot.substring(1);




                        if (shot.length() == 2)
                        {
                                col = Integer.valueOf(part);
                        }
                        else if (shot.length() == 3)
                        {
                                col = 10;
                        }




                        if (row >= 0 && row < 10 && col >= 0 && col < 10) {
                                if (!enemyMap[row][col].equals("X")) {
                                        // Check if the target square is occupied by an opponent's ship
                                        if (enemyMap[row][col].equals("S") || enemyMap[row][col].equals("F") || enemyMap[row][col].equals("D") || enemyMap[row][col].equals("A")) {
                                                System.out.println("Hit! You've hit an opponent's ship!");
                                                userMap[row][col] = "X";
                                                enemyMap[row][col] = "X";
                                        }
                                        else if (enemyMap[row][col].equals("M"))
                                        {
                                                System.out.println("Hit! But You've hit an opponent's mine!");
                                                userMap[row][col] = "M";
                                                enemyMap[row][col] = "X";
                                                letter = letterChoice.charAt(randint.nextInt(9));
                                                String shotSpace = String.valueOf(letter) + randint.nextInt(10);
                                                compShoot(shotSpace);
                                        }
                                        else
                                        {
                                                System.out.println("Miss! Your shot missed the opponent's ship.");
                                                userMap[row][col] = "O"; // Mark the miss
                                        }
                                }
                                else
                                {
                                        System.out.println("Invalid shot. The target square has already been shot.");
                                }
                        }
                }
                else
                {
                        System.out.println("Invalid shot. Please choose valid coordinates.");
                }




                for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                                System.out.print(userMap[i][j] + " ");
                        }
                        System.out.println();
                }
                System.out.println();
        }




        public void compShoot(String shot)
        {
                Random randint = new Random();
                if (shot.length() >= 2 && shot.length() <= 3) {
                        char letter = shot.charAt(0);
                        int row_2 = letter - 'A';
                        int col_2 = 0;
                        String part = shot.substring(1);




                        if (shot.length() == 2)
                        {
                                col_2 = Integer.valueOf(part);
                        }
                        else if (shot.length() == 2)
                        {
                                col_2 = 10;
                        }




                        if (row_2 >= 0 && row_2 < 10 && col_2 >= 0 && col_2 < 10) {
                                if (!map[row_2][col_2].equals("X")) {
                                        // Check if the target square is occupied by an opponent's ship
                                        if (map[row_2][col_2].equals("S") || map[row_2][col_2].equals("F") || map[row_2][col_2].equals("D") || map[row_2][col_2].equals("A")) {
                                                System.out.println("Hit! You've hit an opponent's ship!");
                                                userMap2[row_2][col_2] = "X";
                                                map[row_2][col_2] = "X";
                                        }
                                        else if (map[row_2][col_2].equals("M"))
                                        {
                                                System.out.println("Hit! But You've hit an opponent's mine!");
                                                userMap2[row_2][col_2] = "M";
                                                map[row_2][col_2] = "X";
                                                letter = letterChoice.charAt(randint.nextInt(9));
                                                String shotSpace = String.valueOf(letter) + randint.nextInt(10);
                                                shoot(shotSpace);
                                        }
                                        else {
                                                System.out.println("Miss! Your shot missed the opponent's ship.");
                                                userMap2[row_2][col_2] = "O"; // Mark the miss
                                        }
                                }
                        }
                }
                for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                                System.out.print(map[i][j] + " ");
                        }
                        System.out.println();
                }
                System.out.println();
        }


        public void printPlayer1Map()
        {
                for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                                System.out.print(map[i][j] + " ");
                        }
                        System.out.println();
                }
                System.out.println();
        }


        public void printPlayer2Map()
        {
                for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                                System.out.print(enemyMap[i][j] + " ");
                        }
                        System.out.println();
                }
                System.out.println();
        }


        public void makeMap()
        {
                for (int i = MIN; i < MAX; i++) {
                        for (int j = MIN; j < MAX; j++) {
                                enemyMap[i][j] = "-";
                        }
                }




                for (int i = MIN; i < MAX; i++) {
                        for (int j = MIN; j < MAX; j++) {
                                map[i][j] = "-";
                        }
                }




                for (int i = MIN; i < MAX; i++) {
                        for (int j = MIN; j < MAX; j++) {
                                userMap[i][j] = "-";
                        }
                }




                for (int i = MIN; i < MAX; i++) {
                        for (int j = MIN; j < MAX; j++) {
                                userMap2[i][j] = "-";
                        }
                }
        }




        public boolean isGameOver(String[][] map) {
                boolean play = false;
                for (int i = 0; i < MAX; i++) {
                        for (int j = 0; j < MAX; j++) {
                                if (map[i][j].equals("S") || map[i][j].equals("F") || map[i][j].equals("D") || map[i][j].equals("A")) {
                                        play = true;
                                }
                        }
                }
                return play;
        }




        public boolean isGameOverForPlayer1() {
                return isGameOver(enemyMap);
        }




        public boolean isGameOverForPlayer2() {
                return isGameOver(map);
        }




        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                Random randint = new Random();
                Main player1 = new Main();




                String letterChoice = "ABCDEFGHIJ";
                String[] mapping = new String[100];
                boolean continues = false;




                player1.makeMap();




                // rules menu for game.




                System.out.println("Welcome to Battlleships!");
                System.out.println("This is a game where 2 fleets shoot at each other and try to sink each other's ships.");
                System.out.println("You and your opponent only get 1 shot per move, even when you hit the opponent's ship.");
                System.out.println("You only get 1 opportunity to place your ships down on the 10x10 map with coordinates.");
                System.out.println("The coordinates are supposed to have a capital letter followed by a number.");
                System.out.println("The letter represents the rows of your map.");
                System.out.println("The number represents the columns of your map.");
                System.out.println("\n" + "You only have 1 opportunity to place down three attacking mines on your map.");
                System.out.println("If one of your mines are hit, a random square on your opponent's map is hit.");
                System.out.println("Do you want to play single player or 2 player mode? (enter 1 for single or 2 for two players)");
                int choice = input.nextInt();




                switch (choice) {
                        case 1:
                                System.out.println("\n" + "It is time to deploy your fleet!");
                                System.out.println("You have 4 ships to deploy with different sizes for each.");
                                System.out.println("You will have to place the coordinates for each of them starting with the letter (A-J) and then followed by your chosen number(0-9).");
                                System.out.println("\n" + "Place down the coordinates for the attack submarine (2 spaces).");
                                do
                                {
                                        System.out.println("Select ship orientation, either vertical or horizontal (enter 1 for vertical and 2 for horizontal)");
                                        int orientation_sub = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Where do you want the head of the ship?");
                                        String sub_space = input.nextLine();
                                        continues = player1.submarine(orientation_sub, sub_space, "player1");




                                        if (!continues) {
                                                System.out.println("You cannot place your ship there.");
                                        }
                                } while (!continues);




                                continues = false;




                                int orientation_sub2 = randint.nextInt(11);
                                char letter = letterChoice.charAt(randint.nextInt(9));
                                String sub_space2 = String.valueOf(letter) + randint.nextInt(10);
                                continues = player1.submarine(orientation_sub2, sub_space2, "player2");




                                continues = false;




                                System.out.println("\n" + "Place down the coordinates for the frigate (3 spaces).");
                                do
                                {
                                        System.out.println("Select ship orientation, either vertical or horizontal (enter 1 for vertical and 2 for horizontal)");
                                        int orientation_frig = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Where do you want the head of the ship?");
                                        String frig_space = input.nextLine();
                                        continues = player1.frigate(orientation_frig, frig_space, "player1");




                                        if (!continues) {
                                                System.out.println("You cannot place your ship there.");
                                        }
                                } while (!continues);




                                continues = false;




                                do
                                {
                                        int orientation_frig2 = randint.nextInt(11);
                                        letter = letterChoice.charAt(randint.nextInt(9));
                                        String frig_space2 = String.valueOf(letter) + randint.nextInt(10);
                                        continues = player1.frigate(orientation_frig2, frig_space2, "player2");




                                } while (!continues);




                                continues = false;




                                System.out.println("\n" + "Place down the coordinates for the destroyer (4 spaces).");
                                do
                                {
                                        System.out.println("Select ship orientation, either vertical or horizontal (enter 1 for vertical and 2 for horizontal)");
                                        int orientation_destroy = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Where do you want the head of the ship?");
                                        String destroy_space = input.nextLine();
                                        continues = player1.destroyer(orientation_destroy, destroy_space, "player1");




                                        if (!continues) {
                                                System.out.println("You cannot place your ship there.");
                                        }
                                } while (!continues);




                                continues = false;




                                do
                                {
                                        int orientation_destroy2 = randint.nextInt(11);
                                        letter = letterChoice.charAt(randint.nextInt(9));
                                        String destroy_space2 = String.valueOf(letter) + randint.nextInt(10);
                                        continues = player1.destroyer(orientation_destroy2, destroy_space2, "player2");




                                } while (!continues);




                                continues = false;




                                System.out.println("\n" + "Place down the coordinates for the aircraft carrier (5 spaces).");
                                do
                                {
                                        System.out.println("Select ship orientation, either vertical or horizontal (enter 1 for vertical and 2 for horizontal)");
                                        int orientation_air = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Where do you want the head of the ship?");
                                        String air_space = input.nextLine();
                                        continues = player1.carrier(orientation_air, air_space, "player1");




                                        if (!continues) {
                                                System.out.println("You cannot place your ship there.");
                                        }
                                } while (!continues);




                                continues = false;




                                do
                                {
                                        int orientation_air2 = randint.nextInt(11);
                                        letter = letterChoice.charAt(randint.nextInt(9));
                                        String air_space2 = String.valueOf(letter) + randint.nextInt(10);
                                        continues = player1.carrier(orientation_air2, air_space2, "player1");




                                } while (!continues);




                                continues = false;




                                System.out.println("Put down your 3 mines.");
                                do
                                {
                                        System.out.println("Enter the coordinates of the first mine.");
                                        String mine_space1 = input.nextLine();
                                        continues = player1.mine(mine_space1, "player1");




                                        if (!continues) {
                                                System.out.println("You cannot place your mine there.");
                                        }
                                } while (!continues);








                                continues = false;




                                do
                                {
                                        letter = letterChoice.charAt(randint.nextInt(9));
                                        String mine_2_space1 = String.valueOf(letter) + randint.nextInt(10);
                                        continues = player1.mine(mine_2_space1, "player2");




                                } while (!continues);




                                continues = false;




                                do
                                {
                                        System.out.println("Enter the coordinates of the second mine.");
                                        String mine_space2 = input.nextLine();
                                        continues = player1.mine(mine_space2, "player1");




                                        if (!continues) {
                                                System.out.println("You cannot place your mine there.");
                                        }
                                } while (!continues);




                                continues = false;




                                do
                                {
                                        letter = letterChoice.charAt(randint.nextInt(9));
                                        String mine_2_space2 = String.valueOf(letter) + randint.nextInt(10);
                                        continues = player1.mine(mine_2_space2, "player2");




                                } while (!continues);




                                continues = false;




                                do
                                {
                                        System.out.println("Enter the coordinates of the third mine.");
                                        String mine_space3 = input.nextLine();
                                        continues = player1.mine(mine_space3, "player1");




                                        if (!continues) {
                                                System.out.println("You cannot place your mine there.");
                                        }
                                } while (!continues);




                                continues = false;




                                do
                                {
                                        letter = letterChoice.charAt(randint.nextInt(9));
                                        String mine_2_space3 = String.valueOf(letter) + randint.nextInt(10);
                                        continues = player1.mine(mine_2_space3, "player2");




                                } while (!continues);












                                System.out.println("It is time to attack");
                                boolean play = true;












                                do {
                                        int position = 0;
                                        System.out.println("Where do you want to fire your shot?");
                                        String shot_1 = input.nextLine();
                                        player1.shoot(shot_1);




                                        play = player1.isGameOverForPlayer1();
                                        if (!play)
                                        {
                                                System.out.println("The game is over! You win.");
                                                break;
                                        }












                                        System.out.println("\n" + "It is the opponents turn.");
                                        letter = letterChoice.charAt(randint.nextInt(9));
                                        String shot_2 = String.valueOf(letter) + randint.nextInt(10);
                                        player1.compShoot(shot_1);
                                        play = player1.isGameOverForPlayer2();
                                        if (!play)
                                        {
                                                System.out.println("The game is over! The computer wins.");
                                                break;
                                        }




                                } while (play);
                                break;








                        case 2:
                                System.out.println("Player 1 deploy your fleet!");
                                System.out.println("You have 4 ships to deploy with different sizes for each.");
                                System.out.println("You will have to place the coordinates for each of them starting with the letter (A-J) and then followed by your chosen number(0-9).");
                                System.out.println("\n" + "Place down the coordinates for the attack submarine (2 spaces).");
                                do
                                {
                                        System.out.println("Select ship orientation, either vertical or horizontal (enter 1 for vertical and 2 for horizontal)");
                                        int orientation_sub = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Where do you want the head of the ship?");
                                        String sub_space = input.nextLine();
                                        continues = player1.submarine(orientation_sub, sub_space, "player1");








                                        if (!continues) {
                                                System.out.println("You cannot place your ship there.");
                                        }
                                } while (!continues);








                                continues = false;








                                System.out.println("\n" + "Place down the coordinates for the frigate (3 spaces).");
                                do
                                {
                                        System.out.println("Select ship orientation, either vertical or horizontal (enter 1 for vertical and 2 for horizontal)");
                                        int orientation_frig = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Where do you want the head of the ship?");
                                        String frig_space = input.nextLine();
                                        continues = player1.frigate(orientation_frig, frig_space, "player1");








                                        if (!continues) {
                                                System.out.println("You cannot place your ship there.");
                                        }
                                } while (!continues);








                                continues = false;




                                System.out.println("\n" + "Place down the coordinates for the destroyer (4 spaces).");
                                do
                                {
                                        System.out.println("Select ship orientation, either vertical or horizontal (enter 1 for vertical and 2 for horizontal)");
                                        int orientation_destroy = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Where do you want the head of the ship?");
                                        String destroy_space = input.nextLine();
                                        continues = player1.destroyer(orientation_destroy, destroy_space, "player1");








                                        if (!continues) {
                                                System.out.println("You cannot place your ship there.");
                                        }
                                } while (!continues);








                                continues = false;








                                System.out.println("\n" + "Place down the coordinates for the aircraft carrier (5 spaces).");
                                do
                                {
                                        System.out.println("Select ship orientation, either vertical or horizontal (enter 1 for vertical and 2 for horizontal)");
                                        int orientation_air = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Where do you want the head of the ship?");
                                        String air_space = input.nextLine();
                                        continues = player1.carrier(orientation_air, air_space, "player1");








                                        if (!continues) {
                                                System.out.println("You cannot place your ship there.");
                                        }
                                } while (!continues);








                                continues = false;








                                System.out.println("Put down your 3 mines.");
                                do
                                {
                                        System.out.println("Enter the coordinates of the first mine.");
                                        String mine_space1 = input.nextLine();
                                        continues = player1.mine(mine_space1, "player1");








                                        if (!continues) {
                                                System.out.println("You cannot place your mine there.");
                                        }
                                } while (!continues);




                                continues = false;




                                do
                                {
                                        System.out.println("Enter the coordinates of the second mine.");
                                        String mine_space2 = input.nextLine();
                                        continues = player1.mine(mine_space2, "player1");








                                        if (!continues) {
                                                System.out.println("You cannot place your mine there.");
                                        }
                                } while (!continues);








                                continues = false;




                                do
                                {
                                        System.out.println("Enter the coordinates of the third mine.");
                                        String mine_space3 = input.nextLine();
                                        continues = player1.mine(mine_space3, "player1");








                                        if (!continues) {
                                                System.out.println("You cannot place your mine there.");
                                        }
                                } while (!continues);


                                System.out.println("Player 2 deploy your fleet!");
                                System.out.println("You have 4 ships to deploy with different sizes for each.");
                                System.out.println("You will have to place the coordinates for each of them starting with the letter (A-J) and then followed by your chosen number(0-9).");
                                System.out.println("\n" + "Place down the coordinates for the attack submarine (2 spaces).");




                                do
                                {
                                        System.out.println("Select ship orientation, either vertical or horizontal (enter 1 for vertical and 2 for horizontal)");
                                        int orientation_sub = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Where do you want the head of the ship?");
                                        String sub_space = input.nextLine();
                                        continues = player1.submarine(orientation_sub, sub_space, "player2");


                                        if (!continues) {
                                                System.out.println("You cannot place your ship there.");
                                        }
                                } while (!continues);




                                continues = false;






                                System.out.println("\n" + "Place down the coordinates for the frigate (3 spaces).");
                                do
                                {
                                        System.out.println("Select ship orientation, either vertical or horizontal (enter 1 for vertical and 2 for horizontal)");
                                        int orientation_frig = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Where do you want the head of the ship?");
                                        String frig_space = input.nextLine();
                                        continues = player1.frigate(orientation_frig, frig_space, "player2");




                                        if (!continues) {
                                                System.out.println("You cannot place your ship there.");
                                        }
                                } while (!continues);




                                continues = false;








                                System.out.println("\n" + "Place down the coordinates for the destroyer (4 spaces).");
                                do
                                {
                                        System.out.println("Select ship orientation, either vertical or horizontal (enter 1 for vertical and 2 for horizontal)");
                                        int orientation_destroy = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Where do you want the head of the ship?");
                                        String destroy_space = input.nextLine();
                                        continues = player1.destroyer(orientation_destroy, destroy_space, "player2");






                                        if (!continues) {
                                                System.out.println("You cannot place your ship there.");
                                        }
                                } while (!continues);










                                continues = false;


                                System.out.println("\n" + "Place down the coordinates for the aircraft carrier (5 spaces).");
                                do
                                {
                                        System.out.println("Select ship orientation, either vertical or horizontal (enter 1 for vertical and 2 for horizontal)");
                                        int orientation_air = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Where do you want the head of the ship?");
                                        String air_space = input.nextLine();
                                        continues = player1.carrier(orientation_air, air_space, "player2");




                                        if (!continues) {
                                                System.out.println("You cannot place your ship there.");
                                        }
                                } while (!continues);










                                continues = false;




                                System.out.println("Put down your 3 mines.");
                                do
                                {
                                        System.out.println("Enter the coordinates of the first mine.");
                                        String mine_space1 = input.nextLine();
                                        continues = player1.mine(mine_space1, "player2");








                                        if (!continues) {
                                                System.out.println("You cannot place your mine there.");
                                        }
                                } while (!continues);








                                continues = false;








                                do
                                {
                                        System.out.println("Enter the coordinates of the second mine.");
                                        String mine_space2 = input.nextLine();
                                        continues = player1.mine(mine_space2, "player2");






                                        if (!continues) {
                                                System.out.println("You cannot place your mine there.");
                                        }
                                } while (!continues);




                                continues = false;








                                do
                                {
                                        System.out.println("Enter the coordinates of the third mine.");
                                        String mine_space3 = input.nextLine();
                                        continues = player1.mine(mine_space3, "player2");






                                        if (!continues) {
                                                System.out.println("You cannot place your mine there.");
                                        }
                                } while (!continues);




                                System.out.println("It is time to attack");
                                play = true;


                                do {
                                        System.out.println("\n" + "It is player 1's turn.");
                                        System.out.println("Player 1, where do you want to fire your shot?");
                                        String shot_1 = input.nextLine();
                                        player1.shoot(shot_1);
                                        System.out.println("Your map:");
                                        player1.printPlayer1Map();




                                        play = player1.isGameOverForPlayer1();
                                        if (!play)
                                        {
                                                System.out.println("The game is over! You win.");
                                                break;
                                        }




                                        System.out.println("\n" + "It is player 2's turn.");
                                        System.out.println("Player 2, where do you want to fire your shot?");
                                        String shot_2 = input.nextLine();
                                        player1.compShoot(shot_2);
                                        System.out.println("Your map:");
                                        player1.printPlayer2Map();




                                        play = player1.isGameOverForPlayer2();
                                        if (!play)
                                        {
                                                System.out.println("The game is over! player 2 wins.");
                                                break;
                                        }




                                } while (play);
                                break;




                        default:
                                System.out.println("Incorrect input (enter a number between 1 - 2).");
                }
        }
}