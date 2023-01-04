//Inserting image in java Using JFrame and Constructor.
package arts_crafts;

import java.awt.*;

import javax.swing.*; //is a Toolkit for creating User Interface.

//extend is a keyword which is used to inherit attributes and methods from one Class to another Class.
public class Test extends JFrame{
	private ImageIcon image1; //Declearing image1 object of ImageIcon Class for first image.
	private JLabel label1; //Declearing label1 object of JLabel Class which is basically holder for image1.
	private ImageIcon image2; //Declearing image2 object of ImageIcon Class for second image.
	private JLabel label2; //Declearing label2 object of JLabel Class which is basically holder for image2.
	
	//Creating Constructor which are used whenever we wanna pass values to objects that are being created from a Class.
	Test(String image_1, String image_2) {
		
		setLayout(new FlowLayout()); //Using setLayou() method to be able to specify the layout of how we wanna see the images.
		image1 = new ImageIcon(getClass().getResource(image_1)); //Creating object of our image so we can be able to get the image from source and display the image.
		//getClass() method is used so we can get the Class where the image'll be stored under.
		//getResouce will get the resource(in this case the image_1).
		// Getting the first image from where it's stored.
		label1 = new JLabel(image1); //Using label1 object to be able to pass the image so you can display the image on this empty label which acts as holder for the image.
		add(label1); //add() method to be actually add the image to the label.
		
		image2 = new ImageIcon(getClass().getResource(image_2));
		label2 = new JLabel(image2);
		add(label2);
	}
	
	public static void main(String[] args) {
		

	}

}
