/*To develop the Electra artisans programmed system, the following guidelines need to be followed:-

A. The Electra artisans e-portal will be divided into two sections within a class like an online gallery(which will be displayed as a menu), where one section will be allocated
to the administrators to analyze the performance of their business by getting the businesses profit margin based on the cost of goods sold, the businesses “ net income calculated,
determining the six sigma value of the business.

B. The other section will be for customers to find out about the local traditional arts and crafts sold in two Latin American countries(which are:- Mexico, and Bolivia. Two options 
will be provided to the customers which are: 1. Read the Jinformation(by playing an audio file) 2. Display an e-gallery of the traditional arts and crafts along with some information 
about the arts and crafts(without the need to play an audio file) for customers to learn about. The customers will also be able to purchase the arts and crafts of their choice in US dollars.

C. Administrators will be required to enter the correct username and password given to them to be able to gain authorized access to the Electra artisans e-system.

D. Conditional statements should be used to control what type of information would be displayed based on the customer ‘s selection.

E. The correct finance formulas and calculations should be used to calculate the cost of goods, profit margin, and the six sigma value.

F. There should be at least two customer purchases to test the system. The customer ‘s purchases and the businesses financial information needs to be computed by the Electra artisans 
programmed system and display the results.

G.Images will need to be included in the program to display the arts and crafts to the customers.*/

package arts_crafts;
import java.util.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Electra_Artisans extends JFrame {
	private ImageIcon image1;
	private JLabel label1;
	private ImageIcon image2;
	private JLabel label2;
	
	Electra_Artisans(String image_1, String image_2){
		setLayout(new FlowLayout());
		image1 = new ImageIcon(getClass().getResource(image_1));
		label1 = new JLabel(image1);
		add(label1);

		image2 = new ImageIcon(getClass().getResource(image_2));
		label2 = new JLabel(image2);
		add(label2);
	}
	
	private static String auth_username = "artisan123";
	private static String auth_password = "artisaneportal@22";
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Scanner text = new Scanner(System.in); // For taking string inputs.
		Scanner number = new Scanner(System.in); // For taking integer inputs.
		Electra_Artisans Mexico = new Electra_Artisans("huichol.jpg", "talavera.jpg");
		Electra_Artisans Bolivia = new Electra_Artisans("poncho.jpg", "aguayo.jpg");
		
		String six_sigma = "";
		System.out.println("Welcome to Electra Artisans Programmed system!");
		System.out.println("Please select \nA.Administrator \nB.Customer");
		String selection = text.nextLine();
		
		switch(selection) {
		case("A"):
			//Administrators Section.
			System.out.println("Dear Administrator, to login please give the following credentials");
			System.out.println("Username:- ");
			String username = text.nextLine();
			System.out.println("Password:- ");
			String password = text.nextLine();
			if(auth_username.equals(username) && auth_password.equals(password)) {
				System.out.println("Login Successful, welcome administrator!");
				System.out.println("Dear Administrator, Please select how would you like to analyze the performance of the busniness: \n1.Cost Of Goods Sold(COGS) \n2.Profit Margin \n3.Six Sigma value\n");
				int admin_response = number.nextInt();
				
				if(admin_response == 1) {
					System.out.println("*********************************** Cost Of Goods Sold(COGS)***********************************");
					System.out.println("Enter the Beginning Inventory in US dollars:- ");
					double beg_inventory = number.nextDouble();
					System.out.println("Enter the Purchase Price:- ");
					double purchase_price = number.nextDouble();
					System.out.println("Enter the Ending Inventory in US dollars:- ");
					double end_inventory = number.nextDouble();
					System.out.println("calculating......................");
					//COGS = Beginning Inventory + Purchases During The Period - Ending Inventory
					double cogs = beg_inventory + purchase_price - end_inventory;
					System.out.printf("%10s %s %s %n","The Cost Of Goods Sold(COGS) for your business is ",cogs,"$");
				}
					
				else if(admin_response == 2) {
					System.out.println("************************************** Profit Margin **************************************");
					System.out.println("Enter the Net Income in US dollars:- ");
					double net_income = number.nextDouble();
					System.out.println("Enter the Revenue in US dollars:- ");
					double revenue = number.nextDouble();
					System.out.println("calculating......................");
					//Profit Margin = (Net Income/Revenue) x 100
					double profit_margin = (net_income/revenue) * 100 ;
					System.out.printf("%10s %s %s %n","The Profit Margin is ",profit_margin,"$");
					System.out.printf("%10s %s %s %s %n","This means you get to keep ",profit_margin,"%","of your business.");	
				}
				
				else if(admin_response == 3) {
					System.out.println("************************************* Six Sigma value *************************************");
					System.out.println("*************************** Calculating DPO(Defects Per Opportunity)***************************");
					System.out.println("Enter the total number of defects:- ");
					double defects = number.nextDouble();
					System.out.println("Enter the total number of units:- ");
					double total_units = number.nextDouble();
					System.out.println("Enter opportunities per units:- ");
					double oppo_perunit = number.nextDouble();
					System.out.println("calculating......................");
					//DPO = Defects / (Total number of units * opportunities per unit)
					double dpo = defects/(total_units * oppo_perunit) ;
					//Calculating Yield
					double yield = (1-dpo)* 100;
					
					if(yield >= 69.10 && yield < 93.33) {
						six_sigma = "2";
						}
					else if(yield >= 93.33 && yield < 99.38) {
						six_sigma = "3";
						}
					else if(yield >= 99.38 && yield < 99.97) {
						six_sigma = "4";
						}
					else if(yield >= 99.97 && yield < 99.99) {
						six_sigma = "5";
						}
					else if(yield >= 99.99 && yield <100) {
						six_sigma = "6";
						}
					System.out.println("Most businesses run at 3 or 4 sigma values, acheiving 6 sigma value means delivering near perfect products or services.");
					System.out.println("************************************* Six Sigma Result *************************************");
					System.out.printf("%10s %s %n","Six Sigma Value is ",six_sigma);
					}
									
			}
			else {
				System.out.println("Sorry! You've entered Invalid Credentials");
			}
			break;
			
			
		case("B"):
			//Customer Section.
			System.out.println("Dear customer, Welcome to Electra Artisans Programmed System!");
		    System.out.println("Please select which local traditional arts and crafts you would like to view from Latin America \nA.Mexico \nB.Bolivia");
		    String customer_response = text.nextLine();
		    
		    if(customer_response.equals("A")) {
		    	System.out.println("************************************* Mexican Arts & Crafts *************************************\");");
		    	System.out.println("************************************* Huichol Arts & Crafts *************************************\");");
		    	System.out.println("Find out more about Huichol arts and crafts by \n1.Play the Huichol arts & crafts audiotrack \n2.Read about Huichol Arts & Crafts");
		    	int user_response_huichol = number.nextInt();
		    	
		    	if(user_response_huichol == 1) {
		    		File file = new File("Huichol.wav");
		    		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		    		Clip clip = AudioSystem.getClip();
		    		clip.open(audioStream);
		    		System.out.println("Enter P to play the audiotrack ");
		    		String audio_response = text.nextLine();
		    		audio_response = audio_response.toUpperCase();
		    		clip.start();
		    		
		    		System.out.println("Enter S to stop and PA to pause the audiotrack");
		    		String audio_response2 = text.nextLine();
		    		audio_response2 = audio_response2.toUpperCase();
		    		if(audio_response2.equals("S")) {
		    			clip.stop();
		    			System.out.println("Thank you for listening");
		    		}
		    		
		    		else if(audio_response2.equals("PA")) {
		    			long clip_position = clip.getMicrosecondPosition();
		    			clip.stop();
		    			
		    			System.out.println("Enter RE to resume and R to replay");
		    			String audio_response3 = text.nextLine();
			    		audio_response3 = audio_response3.toUpperCase();
			    		
			    		if(audio_response3.equals("RE")) {
			    			clip.setMicrosecondPosition(clip_position);
			    			clip.start();
			    			
			    			System.out.println("Enter E to exit");
			    			String audio_response4 = text.nextLine();
				    		audio_response4 = audio_response4.toUpperCase();
				    		clip.stop();
				    		System.out.println("Thank you for listening");
				    		
			    		}
			    		
			    		else if(audio_response3.equals("R")) {
			    			clip.setMicrosecondPosition(0);
			    			clip.start();
			    			
			    			System.out.println("Enter E to exit");
			    			String audio_response4 = text.nextLine();
				    		audio_response4 = audio_response4.toUpperCase();
				    		clip.stop();
				    		System.out.println("Thank you for listening");
		    		        }	
		    	      }
		        }
		    	if(user_response_huichol == 2) {
		    		System.out.println("Huichol art broadly groups the most traditional and most recent innovations in the folk art and handcrafts produced by the Huichol people, who live in the states of Jalisco, Durango, Zacatecas and Nayarit in Mexico. The unifying factor of the work is the colorful decoration using symbols and designs which date back centuries. The most common and commercially successful products are \"yarn paintings\" and objects decorated with small commercially produced beads.");
		    	}
		    	
		    	System.out.println("************************************* Talavera Arts & Crafts *************************************\");");
		    	System.out.println("Find out more about Talavera arts and crafts by \n1.Play the Talavera arts & crafts audiotrack \n2.Read about Talavera Arts & Crafts");
		    	int user_response_talavera = number.nextInt();
		    	
		    	if(user_response_talavera == 1) {
		    		File file2 = new File("Talavera.wav");
		    		AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
		    		Clip clip2 = AudioSystem.getClip();
		    		clip2.open(audioStream2);
		    		System.out.println("Enter P to play the audiotrack ");
		    		String audio_response = text.nextLine();
		    		audio_response = audio_response.toUpperCase();
		    		clip2.start();
		    		
		    		System.out.println("Enter S to stop and PA to pause the audiotrack");
		    		String audio_response2 = text.nextLine();
		    		audio_response2 = audio_response2.toUpperCase();
		    		if(audio_response2.equals("S")) {
		    			clip2.stop();
		    			System.out.println("Thank you for listening");
		    		}
		    		
		    		else if(audio_response2.equals("PA")) {
		    			long clip_position = clip2.getMicrosecondPosition();
		    			clip2.stop();
		    			
		    			System.out.println("Enter RE to resume and R to replay");
		    			String audio_response3 = text.nextLine();
			    		audio_response3 = audio_response3.toUpperCase();
			    		
			    		if(audio_response3.equals("RE")) {
			    			clip2.setMicrosecondPosition(clip_position);
			    			clip2.start();
			    			
			    			System.out.println("Enter E to exit");
			    			String audio_response4 = text.nextLine();
				    		audio_response4 = audio_response4.toUpperCase();
				    		clip2.stop();
				    		System.out.println("Thank you for listening");
			    		}
			    		
			    		else if(audio_response3.equals("R")) {
			    			clip2.setMicrosecondPosition(0);
			    			clip2.start();
			    			
			    			System.out.println("Enter E to exit");
			    			String audio_response4 = text.nextLine();
				    		audio_response4 = audio_response4.toUpperCase();
				    		clip2.stop();
				    		System.out.println("Thank you for listening");
		    		        }	
		    	      }
		        }
		    	if(user_response_talavera == 2) {
		    		System.out.println("Talavera pottery (Spanish: Talavera poblana) is a Mexican and Spanish pottery tradition from Talavera de la Reina, in Spain. The Mexican pottery is a type of majolica (faience) or tin-glazed earthenware, with a white base glaze typical of the type");
		    		    		
		        }
		    	
		    	//Inserting Mexican Arts.
		    	System.out.println("The Huichol Art picture is on the left (costs $550.50), The Talavera Art picture is on the right(costs $780.00)");
		    	Mexico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //is to close the image once it's not being viewed.
		    	Mexico.setVisible(true); //so it can image the photo.
		    	Mexico.pack(); //to put the two imsge together.
		    	Mexico.setTitle("Mexican Arts & Crafts"); //to set title for the images.
	        }
		    
		    
		    
		    if(customer_response.equals("B")) {
		    	System.out.println("************************************* Bolivia Arts & Crafts *************************************\");");
		    	System.out.println("************************************* Aguayo Arts & Crafts *************************************\");");
		    	System.out.println("Find out more about Aguayo arts and crafts by \n1.Play the Aguayo arts & crafts audiotrack \n2.Read about Aguayo Arts & Crafts");
		    	int user_response_aguayo = number.nextInt();
		    	
		    	if(user_response_aguayo == 1) {
		    		File file3 = new File("Aguayo.wav");
		    		AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
		    		Clip clip3 = AudioSystem.getClip();
		    		clip3.open(audioStream3);
		    		System.out.println("Enter P to play the audiotrack ");
		    		String audio_response = text.nextLine();
		    		audio_response = audio_response.toUpperCase();
		    		clip3.start();
		    		
		    		System.out.println("Enter S to stop and PA to pause the audiotrack");
		    		String audio_response2 = text.nextLine();
		    		audio_response2 = audio_response2.toUpperCase();
		    		if(audio_response2.equals("S")) {
		    			clip3.stop();
		    			System.out.println("Thank you for listening");
		    		}
		    		
		    		else if(audio_response2.equals("PA")) {
		    			long clip_position = clip3.getMicrosecondPosition();
		    			clip3.stop();
		    			
		    			System.out.println("Enter RE to resume and R to replay");
		    			String audio_response3 = text.nextLine();
			    		audio_response3 = audio_response3.toUpperCase();
			    		
			    		if(audio_response3.equals("RE")) {
			    			clip3.setMicrosecondPosition(clip_position);
			    			clip3.start();
			    			
			    			System.out.println("Enter E to exit");
			    			String audio_response4 = text.nextLine();
				    		audio_response4 = audio_response4.toUpperCase();
				    		clip3.stop();
				    		System.out.println("Thank you for listening");
			    		}
			    		
			    		else if(audio_response3.equals("R")) {
			    			clip3.setMicrosecondPosition(0);
			    			clip3.start();
			    			
			    			System.out.println("Enter E to exit");
			    			String audio_response4 = text.nextLine();
				    		audio_response4 = audio_response4.toUpperCase();
				    		clip3.stop();
				    		System.out.println("Thank you for listening");
		    		        }	
		    	      }
		        }
		    	if(user_response_aguayo == 2) {
		    		System.out.println("The aguayo(possibly from awayu, Aymara for diaper and for a woven blanket to carry things on the back or to cover the back)or also quepina (possibly from Quechua q'ipi bundle)is a rectangular crrying cloth used in traditional communities in the Andes region of Argentina, Bolivia, Chile, Colombia, Ecuador and Peru.Aymara and Quechua people use it to carry small children or various other items in it on their backs");
		    	}
		    	
		    	System.out.println("************************************* Poncho Arts & Crafts *************************************\");");
		    	System.out.println("Find out more about Poncho arts and crafts by \n1.Play the Poncho arts & crafts audiotrack \n2.Read about Poncho Arts & Crafts");
		    	int user_response_poncho = number.nextInt();
		    	
		    	if(user_response_poncho == 1) {
		    		File file4 = new File("Poncho.wav");
		    		AudioInputStream audioStream4 = AudioSystem.getAudioInputStream(file4);
		    		Clip clip4 = AudioSystem.getClip();
		    		clip4.open(audioStream4);
		    		System.out.println("Enter P to play the audiotrack ");
		    		String audio_response = text.nextLine();
		    		audio_response = audio_response.toUpperCase();
		    		clip4.start();
		    		
		    		System.out.println("Enter S to stop and PA to pause the audiotrack");
		    		String audio_response2 = text.nextLine();
		    		audio_response2 = audio_response2.toUpperCase();
		    		if(audio_response2.equals("S")) {
		    			clip4.stop();
		    			System.out.println("Thank you for listening");
		    		}
		    		
		    		else if(audio_response2.equals("PA")) {
		    			long clip_position = clip4.getMicrosecondPosition();
		    			clip4.stop();
		    			
		    			System.out.println("Enter RE to resume and R to replay");
		    			String audio_response3 = text.nextLine();
			    		audio_response3 = audio_response3.toUpperCase();
			    		
			    		if(audio_response3.equals("RE")) {
			    			clip4.setMicrosecondPosition(clip_position);
			    			clip4.start();
			    			
			    			System.out.println("Enter E to exit");
			    			String audio_response4 = text.nextLine();
				    		audio_response4 = audio_response4.toUpperCase();
				    		clip4.stop();
				    		System.out.println("Thank you for listening");
			    		}
			    		
			    		else if(audio_response3.equals("R")) {
			    			clip4.setMicrosecondPosition(0);
			    			clip4.start();
			    			
			    			System.out.println("Enter E to exit");
			    			String audio_response4 = text.nextLine();
				    		audio_response4 = audio_response4.toUpperCase(); 			
		    		        }	
		    	      }
		        }
		    	if(user_response_poncho == 2) {
		    		System.out.println("A poncho(Spanish pronunciation: [ˈpontʃo]; Quechua: punchu; Mapudungun: pontro; \"blanket\", \"woolen fabric\") is an outer garment designed to keep the body warm. A rain poncho is made from a watertight material designed to keep the body dry from the rain.");
		    		    		
		        }
		    	
		    	//Inserting Bolivian Arts.
		    	System.out.println("The Poncho Art picture is on the left (costs $673.50), The Aguayo Art picture is on the right(costs 850.00)");
		    	Bolivia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		    	Bolivia.setVisible(true); 
		    	Bolivia.pack(); 
		    	Bolivia.setTitle("Mexican Arts & Crafts"); 
		}
		
		    //Customer Buying Section.    
		    System.out.println("Dear Customer, which one would you like to buy?\n1.Huichol \n2.Talavera \n3.Poncho \n4.Aguayo\n");
			int buyer_response = number.nextInt();
			if(buyer_response == 1) {
				double price = 550.50;
				System.out.println("How many would you like to buy? ");
				int count = number.nextInt();
				double total_price = price * count;
				System.out.println("Please pick your order at Electra Artisans Store.");
				System.out.println("*********************************************************************************************");
				System.out.println();
				System.out.printf("%50s","Customer Receipt:- ");
				System.out.println();
				System.out.printf("%50s","Huichol Arts & Crafts");
				System.out.println();
				System.out.printf("%40s %.3f","Price($)",total_price);
				System.out.println();
				System.out.println("*********************************************************************************************");
			}
			
			else if(buyer_response == 2) {
				double price = 780.00;
				System.out.println("How many would you like to buy? ");
				int count = number.nextInt();
				double total_price = price * count;
				System.out.println("Please pick your order at Electra Artisans Store.");
				System.out.println("*********************************************************************************************");
				System.out.println();
				System.out.printf("%50s","Customer Receipt:- ");
				System.out.println();
				System.out.printf("%50s","Talavera Arts & Crafts");
				System.out.println();
				System.out.printf("%40s %.3f","Price($)",total_price);
				System.out.println();
				System.out.println("*********************************************************************************************");
			}
			
			else if(buyer_response == 3) {
				double price = 673.50;
				System.out.println("How many would you like to buy? ");
				int count = number.nextInt();
				double total_price = price * count;
				System.out.println("Please pick your order at Electra Artisans Store.");
				System.out.println("*********************************************************************************************");
				System.out.println();
				System.out.printf("%50s","Customer Receipt:- ");
				System.out.println();
				System.out.printf("%50s","Poncho Arts & Crafts");
				System.out.println();
				System.out.printf("%40s %.3f","Price($)",total_price);
				System.out.println();
				System.out.println("*********************************************************************************************");
			}
			
			else if(buyer_response == 4) {
				double price = 840.00;
				System.out.println("How many would you like to buy? ");
				int count = number.nextInt();
				double total_price = price * count;
				System.out.println("Please pick your order at Electra Artisans Store.");
				System.out.println("*********************************************************************************************");
				System.out.println();
				System.out.printf("%50s","Customer Receipt:- ");
				System.out.println();
				System.out.printf("%50s","Aguayo Arts & Crafts");
				System.out.println();
				System.out.printf("%40s %.3f","Price($)",total_price);
				System.out.println();
				System.out.println("*********************************************************************************************");
				System.out.println();
			}
			
			System.out.println("Thank You for buying! have a great day.");
			break;
	  }
   }		
}

