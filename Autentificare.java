import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

  
@SuppressWarnings("serial")
class Autentificare extends Frame{
	
	Autentificare() 
	{
		Frame f = new Frame();
		
		setTitle("Autentificare");
		setSize(250,340);
		setLayout(null);
		setVisible(true);
		
//Nume		
		Label lab_id= new Label("Nume:");
		lab_id.setBounds(50, 70, 100, 20);
		add(lab_id);	
		
		TextField text_nume = new TextField();
		text_nume.setBounds(50,95,150,25);
		add(text_nume);

//Parola
		Label lab_parola = new Label("Parola:");
		lab_parola.setBounds(50, 150, 100, 20);
		add(lab_parola);
	
		TextField text_parola = new TextField();
		text_parola.setBounds(50,175,150,25);
		add(text_parola);

//Buton autentificare
		Button buton_autentificare = new Button("Autentificare");
		buton_autentificare.setBounds(50,225,150,30);
		add(buton_autentificare);	
		
		buton_autentificare.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					File f= new File( "autentificare.csv" );
	
					BufferedReader br = new BufferedReader (new FileReader (f));
				    String id_fisier = "";
				    String parola_fisier = "" ;
				    String id = text_nume.getText();
				    String parola = text_parola.getText();
				    String line=br.readLine();
				    int i=0;
				    
					while((line!=null)&&(i<3))
					{		
						String[] splituri = line.split(",");
						id_fisier = splituri[0];
						parola_fisier = splituri[1].trim();
						
						System.out.println(id_fisier + " "+parola_fisier);
						System.out.println(id +" "+ parola);
						if ((id_fisier==id)&(parola_fisier==parola))
						{
							
							setVisible(false);
						}
					
						i=i+1;
						line = br.readLine();
						
					}	
					
					br.close();
				}	 
				catch (Exception ex) 
				{
					System.out.println("Eroare");
				}

			}  
		});  

//Buton iesire
		Button buton_iesire = new Button("Iesire");
		buton_iesire.setBounds(50,270,150,30);
		add(buton_iesire);
		
		buton_iesire.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{  
				setVisible(false);
			}  
		}); 
				

		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		}); 
	}	
	
}
