import javax.swing.SwingUtilities;
import ui.RoleSelection;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new RoleSelection();
        });

    }
}