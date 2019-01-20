import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
public class GUI extends JFrame implements ActionListener {
	JPanel cpanel, npanel;
	JTextField nfield,mfield,gfield;
	JLabel nlabel, mlabel, glabel;
	JButton dbutton, cbutton, qbutton;
	ServerSocket server;
	Socket socket,socket1,socket2, socket3;
	ObjectInputStream input;
	ObjectOutputStream output, output1, output2, output3;
	JOptionPane opane;
public  GUI() {
	setTitle("RafScore");
	nlabel = new JLabel("Players Name"); 
	nfield = new JTextField(20);
	mlabel = new JLabel("         Matches");                           
	mfield = new JTextField(20);
	glabel = new JLabel("              Runs");
	gfield = new JTextField(20);
	cpanel = new JPanel();
	cpanel.setLayout(new FlowLayout());
	cpanel.add(nlabel);
	cpanel.add(nfield);
	cpanel.add(mlabel);
	cpanel.add(mfield);
	cpanel.add(glabel);
	cpanel.add(gfield);
	add(cpanel, BorderLayout.CENTER);
	
	npanel = new JPanel();
	cpanel.setLayout(new FlowLayout());
	dbutton = new JButton("Done");
	dbutton.addActionListener(this);
	cbutton = new JButton("Start Over");
	cbutton.addActionListener(this);
	qbutton = new JButton("Quit");
	qbutton.addActionListener(this);
	npanel.add(dbutton);
	npanel.add(cbutton);
	npanel.add(qbutton);
	add(npanel, BorderLayout.SOUTH);
	
	setSize(400,200);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public void actionPerformed(ActionEvent event) {
	
	if(event.getSource()== dbutton) { // If user clicks the done button 
		String playerName = nfield.getText();
		String Match = mfield.getText();
		int mtch = Integer.parseInt(Match);
		String goals = gfield.getText();
		int gls = Integer.parseInt(goals);
	    double average = gls / mtch;
		String insert = "insert into records(Name, Matches,Runs, Average) values('" + playerName + "' , " + mtch + " , " + gls + " , " + average + " );";
		String select = "Select Runs from records where Name = " + "'" + playerName + "'";
		System.out.println(select);
		
		try {
		socket = new Socket("", 1097);
		socket1 = new Socket("", 1098);
		socket2 = new Socket("", 1099);
		socket3 = new Socket("", 1096);
		output = new ObjectOutputStream(socket.getOutputStream());
		output1 = new ObjectOutputStream(socket1.getOutputStream());
		output2 = new ObjectOutputStream(socket2.getOutputStream());
		output3 = new ObjectOutputStream(socket3.getOutputStream());
		output.writeObject(insert); // Sends the insert statement to the server
		output1.writeObject(select); // Sends the select statement to the server
		output2.writeObject(gls);    // Sends the runs to the server
		output3.writeObject(playerName); // Sends player name to the server
		
		output.flush();
		output1.flush();
		output2.flush();
		output3.flush();
		
		}catch (IOException e) {
			e.printStackTrace(System.out);
		}
		
		
	}else if (event.getSource() == cbutton) { // If user clicks on cancel button
		mfield.setText(" ");
		nfield.setText(" ");
		gfield.setText(" ");
	}else if (event.getSource() == qbutton) { // If user clicks on quit button
		opane.showMessageDialog(null,"Thank you for using my app, Rafsan");
		
	}
}

   public static void main(String[] args) {
		GUI s = new GUI();

	}

}
