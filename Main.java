import java.util.Scanner;
public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static Boolean escape = false;

    public static int round = 30;

    // Define position
    public static Boolean infoyer = true;
    public static Boolean inlibrary = false;
    public static Boolean inconservatory = false;
    // Define objects in room foyer
    public static Boolean chest_opened = false;
    public static Boolean has_matches = false;
    public static Boolean candle_lighted = false;
    public static Boolean foyer_door_locked = true;
    public static Boolean foyer_door_opened = false;


    // Define objects in library
    public static Boolean has_pen = false;
    public static Boolean Book_titled = false;
    public static Boolean library_door_locked = true;
    public static Boolean library_door_opened = false;

    // Define objects in conservatory
    public static Boolean trumpet_played = false;
    public static Boolean drum_played = false;
    public static Boolean piano_played = false;
    public static Boolean conservatory_door_locked = true;
    public static Boolean conservatory_door_opened = true;

    public static String output = "When you open your eyes, you find yourself in a foyer.\nInside the foyer is a bench, a chest, an unlit candle, and a note. \"The note says, “May my light show you the way.”\nThere is a door to the north, but it is locked.";
    public static void main(String[] args) {

        System.out.println(output);
        System.out.println("You have 30 moves to escape\nGood luck!\n");

        for (int a = 1; a < 31; a++) {
            gameUsage();
            round--;
            if (trumpet_played && piano_played && drum_played) {
                break;
            }
        }
        if (trumpet_played && piano_played && drum_played) {
            escape = true;
            System.out.printf("\nCongratulations! You have completed the escape room challenge successfully in with %d moves to spare.", round);
        }
        else {
            System.out.printf("\nYou have failed the escape room challenge. Try again!");
        }
    }

    public static void gameUsage() {
        if (infoyer) {
            foyer();
        }
        else if (inlibrary) {
            library();
        }
        else if (inconservatory) {
            conservatory();
        }
    }
    public static void foyer() {
        System.out.println("you have " + round + " rounds left.");
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your command");
        String input = scan.nextLine();

        switch (input) {
            case "look chest":
                output = "the chest is closed";
                System.out.println(output);
                break;
            case "open chest":
                chest_opened = true;
                output = "There are matches in the chest.";
                System.out.println(output);
                break;

            case "get matches":
                has_matches = true;
                output = "You have a box of matches.";
                System.out.println(output);
                break;

            case "light candle":
            case "light candles":
                if (has_matches) {
                    candle_lighted = true;
                    foyer_door_locked = false;
                    output = "The candle is lit. You heard a metal grinding sound from the north.";
                } else {
                    output = "You don't have any matches.";
                }
                System.out.println(output);
                break;

            case "look door":
                if (!foyer_door_locked) {
                    if (foyer_door_opened=true) {
                        output = "The door is unlocked and open.";
                    } else {
                        output = "The door is unlocked, but closed.";
                    }
                } else {
                    output = "The door is locked.";
                }
                System.out.println(output);
                break;

            case "open door":
                if (!foyer_door_locked) {
                    foyer_door_opened = true;
                    output = "The north door is open.";
                }
                System.out.println(output);
                break;

            case "go north":
                if (foyer_door_opened) {
                    infoyer = false;
                    inlibrary = true;
                    output = "Congratulation! You have left the foyer. On your way out, the door slammed and locked. You now find yourself in a library full of shelves of books. In the center of the room is a desk, which has a pen and a scroll on it. A door is on the north side wall waiting for you to open";
                }
                System.out.println(output);
                break;

        }
    }

    public static void library(){
        System.out.println("you have " + round + " rounds left.");
        scan = new Scanner(System.in);
        String input = scan.nextLine();

        switch (input) {

            case "get pen":
                has_pen = true;
                output = "You now holding the pen.";
                System.out.println(output);
                break;

            case "read scroll":
                output = "the scroll says, 'Share your story.'";
                System.out.println(output);
                break;

            case "search shelves":
                output = "there is an open book on the shelves titled “The Autobiography of...” with the rest of the title empty.";
                System.out.println(output);
                break;

            case "write book":
            case "write name":
                Book_titled = true;
                library_door_locked = false;
                output = "you now have finished the book with your pen. You are ready to leave";
                System.out.println(output);
                break;

            case "look door":
                if (!library_door_locked) {
                    if (library_door_opened=true) {
                        output = "The door is unlocked and open.";
                    } else {
                        output = "The door is unlocked, but closed.";
                    }
                } else {
                    output = "The door is locked.";
                }
                System.out.println(output);
                break;

            case "open door":
                if (!library_door_locked) {
                    library_door_opened = true;
                    output = "The north door is open.";
                }
                System.out.println(output);
                break;

            case "go north":
                if (foyer_door_opened) {
                    inlibrary = false;
                    inconservatory = true;
                    output = "Congratulation! You have left the library. On your way out, the door slammed and locked. You are now in the conservatory. You now find yourself in a conservatory having three music instruments:Trumpet, Piano, and Drum. In order to escape, you need to play them in order. Good luck.";
                }
                System.out.println(output);
                break;
        }
    }

    public static void conservatory() {
        System.out.println("you have " + round + " rounds left.");
        scan = new Scanner(System.in);
        String input= scan.nextLine();

        switch (input) {

            case "play trumpet":
                if (!piano_played==true && !drum_played==true) {
                    trumpet_played = true;
                    output = "you have played the trumpet!";
                } else {
                    output = "the trumpet is broken";
                }
                System.out.println(output);
                break;

            case "play piano":
                if (trumpet_played==true && !drum_played==true) {
                    piano_played = true;
                    output = "you have played the piano";
                } else {
                    output = "the piano is broken";
                }
                System.out.println(output);
                break;

            case "play drum":
                if (trumpet_played==true && piano_played==true) {
                    drum_played = true;
                    output = "you have played the drum";
                } else {
                    output = "the drum is broken";
                }
                System.out.println(output);
                break;

            case "look door":
                if (!conservatory_door_locked) {
                    if (conservatory_door_opened=true) {
                        output = "The door is unlocked and open.";
                    } else {
                        output = "The door is unlocked, but closed.";
                    }
                } else {
                    output = "The door is locked.";
                }
                System.out.println(output);
                break;

            case "open door":
                if (!conservatory_door_locked) {
                    conservatory_door_opened = true;
                    output = "The north door is open.";
                }
                System.out.println(output);
                break;
        }

    }
}
