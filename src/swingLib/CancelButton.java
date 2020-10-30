package swingLib;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CancelButton extends JButton {

    final String text = "Annuler";
    final Color couleur = Color.red;
    final ImageIcon icon = new ImageIcon("icone.png");
    Image image2 = icon.getImage().getScaledInstance(32, 32, 0);

    public CancelButton() {
        super();
        setText(text);
        setBackground(couleur);
        setPreferredSize(new Dimension(90, 27));
        addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(new JFrame(), "Confirmer la sortie de la page ? ", "Fermeture sans sauvegarde", JOptionPane.CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, new ImageIcon(image2));

                if (result == JOptionPane.YES_OPTION) {
                    if (getTopLevelAncestor() instanceof Window) {
                        ((Window) getTopLevelAncestor()).dispose();
                    }
                }
            }
        });
    }
}
