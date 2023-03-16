package UI;

import javax.swing.*;
import java.io.File;
import java.util.Optional;

public class ChooseFile {
    private final JFrame frame;
    public ChooseFile() {
        frame = new JFrame();

        frame.setVisible(true);
        BringToFront();
    }
    public Optional<File> getFile() {
        JFileChooser fc = new JFileChooser();
        if(JFileChooser.APPROVE_OPTION == fc.showOpenDialog(null)){
            frame.setVisible(false);
            return Optional.ofNullable(fc.getSelectedFile());
        }else {
            System.out.println("Next time select a file.");
        }
        return Optional.empty();
    }

    private void BringToFront() {
        frame.setExtendedState(JFrame.ICONIFIED);
        frame.setExtendedState(JFrame.NORMAL);
    }

}
