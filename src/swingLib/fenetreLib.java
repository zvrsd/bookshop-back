package swingLib;

import java.awt.Container;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class fenetreLib extends JFrame{
	
	ImageIcon img = new ImageIcon("image4.png");
       // JPanel contenair = new JPanel();

	public fenetreLib() {
		super(); 
		setVisible(true); 
              // getContentPane().add(contenair);
		setBounds(240, 240, 560, 560);
		setTitle("Book Shop"); 
		setIconImage(img.getImage());
		setLocation(this.getX()/2 + this.getWidth()/2, this.getY()/2);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public static void main (String[]args) {
		fenetreLib f1 = new fenetreLib();
	}
}

