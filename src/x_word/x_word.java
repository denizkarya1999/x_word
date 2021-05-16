package x_word;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class x_word extends JFrame implements ActionListener{
	JMenuBar bar;
	
	JMenu File;
	JMenuItem New;
	JMenuItem Open;
	JMenuItem Save;
	JMenuItem Print;
	JMenuItem Exit;
	
	JMenu Edit;
	JMenuItem Cut;
	JMenuItem Copy;
	JMenuItem Paste;
	JMenuItem Delete;
	
	JMenu Format;
	JMenuItem Style;
	JMenuItem bold = null;
	JMenuItem italic = null;
	
	JMenuItem size = null;
	JMenuItem size_10 = null;
	JMenuItem size_20 = null;
	JMenuItem size_52 = null;
	JMenuItem size_72 = null;
	
	JMenu View;
	JMenuItem Resolution = null;
	JMenuItem screen_250 = null;
	JMenuItem screen_500 = null;
	JMenuItem screen_720 = null;
	JMenuItem screen_1024 = null;
	
	JMenuItem background_color = null;
	JMenuItem yellow = null;
	JMenuItem pink = null;
	JMenuItem grey = null;
	JMenuItem white = null;
	
	JMenu Help;
	JMenuItem contact_us = null;
	JMenuItem about = null;
	
	JTextArea user_text_area;
	
	private int fstyle = Font.PLAIN;
	private int fsize = 20;
	private Font f = null;

	public static void main(String[] args) {
		x_word start = new x_word();
		start.setVisible(true);
	}
	
	public x_word() {
		super();
		this.setSize(500, 500);
		this.setTitle("X Word");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bar = new JMenuBar();
		
		File = new JMenu("File");
		New = new JMenuItem("New");
		New.addActionListener(this);
		Open = new JMenuItem("Open...");
		Open.addActionListener(this);
		Save = new JMenuItem("Save");
		Save.addActionListener(this);
		Print = new JMenuItem("Print");
		Print.addActionListener(this);
		Exit = new JMenuItem("Exit");
		Exit.addActionListener(this);
		File.add(New);
		File.add(Open);
		File.add(Save);
		File.addSeparator();
		File.add(Print);
		File.addSeparator();
		File.add(Exit);
		
		Edit = new JMenu("Edit");
		Cut = new JMenuItem("Cut");
		Cut.addActionListener(this);
		Copy = new JMenuItem("Copy");
		Copy.addActionListener(this);
		Paste = new JMenuItem("Paste");
		Paste.addActionListener(this);
		Delete = new JMenuItem("Delete");
		Delete.addActionListener(this);
		Edit.add(Cut);
		Edit.add(Copy);
		Edit.add(Paste);
		Edit.addSeparator();
		Edit.add(Delete);
		
		Format = new JMenu("Format");
		Style = new JMenu("Style");
		bold = new JCheckBoxMenuItem("Bold");
		bold.addActionListener(this);
		italic = new JCheckBoxMenuItem("Italic");
		italic.addActionListener(this);
		Style.add(bold);
		Style.add(italic);
		
		size = new JMenu("Size");
		size_10 = new JMenuItem("Size 10");
		size_10.addActionListener(this);
		size_20 = new JMenuItem("Size 20");
		size_20.addActionListener(this);
		size_52 = new JMenuItem("Size 52");
		size_52.addActionListener(this);
		size_72 = new JMenuItem("Size 72");
		size_72.addActionListener(this);
		size.add(size_10);
		size.add(size_20);
		size.add(size_52);
		size.add(size_72);
		Format.add(Style);
		Format.add(size);
		
		View = new JMenu("View");
		Resolution = new JMenu("Screen Resolution");
		JMenuItem screen_250 = new JMenuItem("250 x 250");
		screen_250.addActionListener(this);
		JMenuItem screen_500 = new JMenuItem("500 x 500");
		screen_500.addActionListener(this);
		JMenuItem screen_720 = new JMenuItem("720 x 720");
		screen_720.addActionListener(this);
		JMenuItem screen_1024 = new JMenuItem("1024 x 768");
		screen_1024.addActionListener(this);
		Resolution.add(screen_250);
		Resolution.add(screen_500);
		Resolution.add(screen_720);
		Resolution.add(screen_1024);
		background_color = new JMenu("Background Color");
		JMenuItem yellow = new JMenuItem("Yellow");
		yellow.addActionListener(this);
		JMenuItem pink = new JMenuItem("Pink");
		pink.addActionListener(this);
		JMenuItem grey = new JMenuItem("Gray");
		grey.addActionListener(this);
		JMenuItem white = new JMenuItem("White");
		white.addActionListener(this);
		background_color.add(yellow);
		background_color.add(pink);
		background_color.add(grey);
		background_color.add(white);
		View.add(Resolution);
		View.add(background_color);
		
		Help = new JMenu("Help");
		about = new JMenuItem("About");
		about.addActionListener(this);
		contact_us = new JMenuItem("Contact Us");
		contact_us.addActionListener(this);
		Help.add(contact_us);
		Help.addSeparator();
		Help.add(about);
		
		bar.add(File);
		bar.add(Edit);
		bar.add(Format);
		bar.add(View);
		bar.add(Help);
		
		user_text_area = new JTextArea("", 5, 30);
		f = new Font(Font.SERIF, fstyle, fsize);
		user_text_area.setFont(f);
		
		JScrollPane jsp = new JScrollPane(user_text_area);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.setJMenuBar(bar);
		this.add(jsp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Exit": System.exit(0); break;
		case "Bold": case "Italic":
			fstyle = 0;
            if (bold.isSelected()) fstyle += Font.BOLD;
            if (italic.isSelected()) fstyle += Font.ITALIC;
			f = new Font(Font.SERIF, fstyle, fsize);
			user_text_area.setFont(f); break;
		case "Size 10":
			fsize = 10;
			f = new Font(Font.SERIF, fstyle, fsize);						 
			user_text_area.setFont(f); break;
		case "Size 20":
			 fsize = 20;
			 f = new Font(Font.SERIF, fstyle, fsize);						 
			 user_text_area.setFont(f); break;
		case "Size 52":
			 fsize = 52;
			 f = new Font(Font.SERIF, fstyle, fsize);						 
			 user_text_area.setFont(f); break;
		case "Size 72":
			 fsize = 72;
			 f = new Font(Font.SERIF, fstyle, fsize);						 
			 user_text_area.setFont(f); break;
		case "Delete":
			user_text_area.setText("");
			break;
		case "Cut":
			user_text_area.cut();
			break;
		case "Copy":
			user_text_area.copy();
			break;
		case "Paste":
			user_text_area.paste();
			break;
		case "Open...":
			 // Create an object of JFileChooser class 
	         JFileChooser j_1 = new JFileChooser("f:"); 

	         // Invoke the showsOpenDialog function to show the save dialog 
	         int r_1 = j_1.showOpenDialog(null); 

	         // If the user selects a file 
	         if (r_1 == JFileChooser.APPROVE_OPTION) { 
	             // Set the label to the path of the selected directory 
	             File fi = new File(j_1.getSelectedFile().getAbsolutePath()); 

	             try { 
	                 // String 
	                 String s1 = "", sl = ""; 

	                 // File reader 
	                 FileReader fr = new FileReader(fi); 

	                 // Buffered reader 
	                 BufferedReader br = new BufferedReader(fr); 

	                 // Initilize sl 
	                 sl = br.readLine(); 

	                 // Take the input from the file 
	                 while ((s1 = br.readLine()) != null) { 
	                     sl = sl + "\n" + s1; 
	                 } 

	                 // Set the text 
	                 user_text_area.setText(sl); 
	             } 
	             catch (Exception evt) { 
	                 JOptionPane.showMessageDialog(this, evt.getMessage()); 
	             } 
	         } 
	         break;
		case "Save":
	         // Create an object of JFileChooser class 
	         JFileChooser j = new JFileChooser("f:"); 

	         // Invoke the showsSaveDialog function to show the save dialog 
	         int r = j.showSaveDialog(null); 

	         if (r == JFileChooser.APPROVE_OPTION) { 

	             // Set the label to the path of the selected directory 
	             File fi = new File(j.getSelectedFile().getAbsolutePath()); 

	             try { 
	                 // Create a file writer 
	                 FileWriter wr = new FileWriter(fi, false); 

	                 // Create buffered writer to write 
	                 BufferedWriter w = new BufferedWriter(wr); 

	                 // Write 
	                 w.write(user_text_area.getText()); 

	                 w.flush(); 
	                 w.close(); 
	             } 
	             catch (Exception evt) { 
	                 JOptionPane.showMessageDialog(this, evt.getMessage()); 
	             } 
	         }
	         break;
		case "Print":
	         try { 
	             // print the file 
	             user_text_area.print(); 
	         } 
	         catch (Exception evt) { 
	             JOptionPane.showMessageDialog(this, evt.getMessage()); 
	         } 
		case "New":
			user_text_area.setText("");
		case "250 x 250":
			this.setSize(250, 250);
			break;
		case "500 x 500":
			this.setSize(500, 500);
			break;
		case "720 x 720":
			this.setSize(720, 720);
			break;
		case "1024 x 768":
			this.setSize(1024, 768);
			break;
		case "Yellow":
			user_text_area.setBackground(Color.YELLOW);
			break;
		case "Pink":
			user_text_area.setBackground(Color.PINK);
			break;
		case "Gray":
			user_text_area.setBackground(Color.GRAY);
			break;
		case "White":
			user_text_area.setBackground(Color.WHITE);
			break;
		case "About":
			JOptionPane.showMessageDialog(null, "X Word for Bus X OS: Version 0.1 Beta",
					 "About",JOptionPane.INFORMATION_MESSAGE);
			break;
		case "Contact Us":
			Runtime rt = Runtime.getRuntime();
			String url = "https://www.linkedin.com/in/deniz-karya-acikbas-8491a8170/";
			try {
				rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}
	}
