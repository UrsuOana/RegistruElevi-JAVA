import java.awt.*;
import java.awt.event.*;
import java.io.*;
 

public class AWT extends ManagerCursCSV{

	AWT() 
	{  	

		Frame f = new Frame();   
		f.setTitle("Cursuri");
		f.setSize(500,600);  

		f.setLayout(null);   		 
		f.setVisible(true);  

		TextArea textArea = new TextArea();
		textArea.setBounds(50,50,400,300);   
		f.add(textArea); 
		
		Button butoncurs = new Button("Raport cursuri");  
		butoncurs.setBounds(50, 400, 100, 50) ;
		f.add(butoncurs);		
		butoncurs.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					try
					{
						File f= new File( "cursuri.csv" );
		
						BufferedReader br = new BufferedReader (new FileReader (f));
					    String line = "";
					    String curs="";
					    
						while(line!=null)
						{						
								line=br.readLine();	
								if(line!=null)
									curs = curs + "\n" + line;
						}	
						textArea.setText(curs);
						
						br.close();
					}	 
					catch (Exception ex) 
					{
						textArea.setText("Eroare");
					}

				}});

		Button butonprofesori = new Button("Raport profesori");  
		butonprofesori.setBounds(200, 400, 100, 50) ;
		f.add(butonprofesori);		
		butonprofesori.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					try
					{
						File f = new File( "profesori.csv");
						BufferedReader br = new BufferedReader (new FileReader (f));
					    String line = "";
					    String prof = "";
					    
						while(line!=null)
						{						
								line=br.readLine();	
								if(line!=null)
									prof = prof + "\n" + line;
						}	

						textArea.setText(prof);				
						br.close();
					}	 
					catch (Exception ex) 
					{
						textArea.setText("Eroare");
					}

				}});
		
		Button butonstudenti = new Button("Raport studenti");  
		butonstudenti.setBounds(350, 400, 100, 50) ;
		f.add(butonstudenti);		
		butonstudenti.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					try
					{
						File f = new File( "studenti.csv");
						BufferedReader br = new BufferedReader (new FileReader (f));
					    String line = "";
					    String stud = "";
					    
						while(line!=null)
						{						
								line=br.readLine();	
								if(line!=null)
									stud = stud + "\n" + line;
						}	

						textArea.setText(stud);				
						br.close();
					}	 
					catch (Exception ex) 
					{
						textArea.setText("Eroare");
					}
				}});

		Button butonlista= new Button("Lista cursuri");
		butonlista.setBounds(150, 500, 200, 50) ;
		f.add(butonlista);
		butonlista.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ManagerCursCSV.ScrieListaCursuri();
					try
					{
						File f = new File( "listacursuri.txt");
						BufferedReader br = new BufferedReader (new FileReader (f));
					    String line = "";
					    String stud = "";
					    
						while(line!=null)
						{						
								line=br.readLine();	
								if(line!=null)
									stud = stud + "\n" + line;
						}	

						textArea.setText(stud);				
						br.close();
					}	 
					catch (Exception ex) 
					{
						textArea.setText("Eroare");
					}
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
		
   