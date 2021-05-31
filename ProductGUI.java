//These are protocols, or Applicaton Programming Interfaces (APIs) that allow the creation of the content of Graphical User Interfaces (GUIs).
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class ProductGUI extends JFrame implements ActionListener
{
    //These are the text beside the text field boxes.
	private JLabel stockLevelLabel = new JLabel("ReStock");
	private JLabel setPriceLabel = new JLabel("Set Price");	
	private JLabel sellLabel = new JLabel("Sell Stock");

    //These are the default content of the text field boxes.
	private JTextField stockLevelField = new JTextField("0", 5);
	private JTextField setPriceField = new JTextField("0",5);
	private JTextField sellField = new JTextField("0",5);
	
	//These are the buttons in the program.
	private JButton reStockButton = new JButton("Re Stock");
	private JButton setPriceButton = new JButton("Set Price");
	private JButton sellButton = new JButton("Sell");
		
	//This is the size of the program's box.
	private JTextArea productsTextArea = new JTextArea(5,20);
	
	//These defines the panels used.
	private JPanel topPanel = new JPanel();
	private JPanel middlePanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
		
	//This names the program's main content.
	Product p1 = new Product("Bass Guitar", 103, 350.00);
	
	//This sets the 'Price' number type to decimal.
	DecimalFormat decimalFormat = new DecimalFormat("£#,##0.00");
    String getPrice = decimalFormat.format(p1.getPrice());
	
	//This code is of the layout of the frame.
	public ProductGUI()
	{			
		setTitle("Product GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
			
		setSize(500, 200);
		setLocation(300,300);
		reStockButton.addActionListener(this);
		setPriceButton.addActionListener(this);
		sellButton.addActionListener(this);
		
		topPanel.add(stockLevelLabel);
		topPanel.add(stockLevelField);
		topPanel.add(setPriceLabel);
		topPanel.add(setPriceField);
		topPanel.add(sellLabel);
		topPanel.add(sellField);
		
		middlePanel.add(reStockButton);
		middlePanel.add(setPriceButton);
		middlePanel.add(sellButton);
		
		bottomPanel.add(productsTextArea);		

		add(BorderLayout.NORTH, topPanel);
		add(BorderLayout.CENTER, middlePanel);
		add(BorderLayout.SOUTH, bottomPanel);
		
		productsTextArea.setText("Product Name: " + p1.getName() + "\nStock Level: " + p1.getStockLevel() + "\nPrice: "  + getPrice);
	}
	
	// This code is for a response when an action is performed.
	public void actionPerformed(ActionEvent e)
	{		
		//These convert their respective types of data into another type of data with 'parse'.
		int restock = Integer.parseInt(stockLevelField.getText());
		double  setprice = Double.parseDouble(setPriceField.getText());
		int Sell = Integer.parseInt(sellField.getText());
		
		//This sets the 'Sell' number type to decimal.
		DecimalFormat decimalFormat = new DecimalFormat("£#,##0.00");
        String numberAsString = decimalFormat.format(p1.sell(Sell));
		
		//This code is the response if the 'Re Stock' button is clicked.
		if (e.getSource() == reStockButton)
		{
			p1.reStock(restock);
			String newPrice = decimalFormat.format(p1.getPrice());
			productsTextArea.setText("Product Name: " + p1.getName() + "\nStock Level: " + p1.getStockLevel() + "\nPrice: " + newPrice);
		}
		
		//This code is the response if the 'Set Price' button is clicked.
		if (e.getSource() == setPriceButton)
		{
			p1.setPrice(setprice);
			String newPrice = decimalFormat.format(p1.getPrice());
			productsTextArea.setText("Product Name: " + p1.getName() + "\nStock Level: " + p1.getStockLevel() + "\nPrice: " + newPrice);
		}
		
		//This code is the response if the 'Sell' button is clicked.		
		if (e.getSource() == sellButton)
		{
			productsTextArea.setText("Product Name: " + p1.getName() + "\nAmount Bought: " + Sell + "\nPrice: " + numberAsString);
		}
		
	}
}