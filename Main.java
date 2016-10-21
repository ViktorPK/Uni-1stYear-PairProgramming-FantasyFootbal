package umarviktor;
import umarviktor.model.*;
import umarviktor.view.*;
import umarviktor.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Fantasy fantasy = new Fantasy();
        Squad squad = new Squad();
        Controller controller = new Controller(fantasy, squad);
    }
}
