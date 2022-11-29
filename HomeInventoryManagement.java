package HomeInventery;

//package HomeInventery;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//import com.toedter.calendar.*;
import java.beans.*;

//photopanel
import java.awt.geom.*;

//file io
import java.io.*;


public class HomeInventoryManagement extends JFrame
{
    public static void main(String[] args) {
        new HomeInventoryManagement().show();
    }

    public HomeInventoryManagement()
    {
        setTitle("Home Inventory Maanagement");
        setResizable(true);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                exitForm(evt);
            }
        });
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints;
        pack();
        //getting screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //placing application window in middle
        setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height- getHeight())), getWidth(), getHeight());
    

        //frame design 
        //toolbar
        JToolBar inventoryToolBar = new JToolBar();
        inventoryToolBar.setFloatable(false);
        inventoryToolBar.setBackground(Color.BLUE);
        inventoryToolBar.setOrientation(SwingConstants.VERTICAL);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx =0;
        gridConstraints.gridy =0;
        gridConstraints.gridheight =8;
        gridConstraints.fill = GridBagConstraints.VERTICAL;
        getContentPane().add(inventoryToolBar,gridConstraints);
        inventoryToolBar.addSeparator();
        
        //general
        Dimension bSize = new Dimension(70,50);
        
        //new button
        JButton newButton = new JButton(new ImageIcon("new.gif"));
        newButton.setText("New");
        sizeButton(newButton,bSize);
        newButton.setToolTipText("Add New Item");
        newButton.setHorizontalTextPosition(SwingConstants.CENTER);
        newButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        inventoryToolBar.add(newButton);
        newButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                newButtonActionPerformed(e);
            }
        });

        //delete button
        JButton deleteButton = new JButton(new ImageIcon("delete.gif"));
        deleteButton.setText("Delete");
        sizeButton(deleteButton,bSize);
        deleteButton.setToolTipText("Delete Current Item");
        deleteButton.setHorizontalTextPosition(SwingConstants.CENTER);
        deleteButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        inventoryToolBar.add(deleteButton);
        deleteButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                deleteButtonActionPerformed(e);
            }
        });

        //save button
        JButton saveButton = new JButton(new ImageIcon("save.gif"));
        saveButton.setText("Save");
        sizeButton(saveButton, bSize);
        saveButton.setToolTipText("Save Current Item");
        saveButton.setHorizontalTextPosition(SwingConstants.CENTER);
        saveButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        inventoryToolBar.add(saveButton);
        saveButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                saveButtonActionPerformed(e);
            }
        });

        inventoryToolBar.addSeparator();
        
        //previous button
        JButton previousButton = new JButton(new ImageIcon("previous.gif"));
        previousButton.setText("Previous");
        sizeButton(previousButton, bSize);
        previousButton.setToolTipText("display previous Item");
        previousButton.setHorizontalTextPosition(SwingConstants.CENTER);
        previousButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        inventoryToolBar.add(previousButton);
        previousButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                previousButtonActionPerformed(e);
            }
        });
        

        //next button
        JButton nextButton = new JButton(new ImageIcon("next.gif"));
        nextButton.setText("Next");
        sizeButton(nextButton, bSize);
        nextButton.setToolTipText("display next Item");
        nextButton.setHorizontalTextPosition(SwingConstants.CENTER);
        nextButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        inventoryToolBar.add(nextButton);
        nextButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                nextButtonActionPerformed(e);
            }
        });

        inventoryToolBar.addSeparator();

        //print button
        JButton printButton = new JButton(new ImageIcon("next.gif"));
        printButton.setText("Print");
        sizeButton(printButton, bSize);
        printButton.setToolTipText("Print Inventory List");
        printButton.setHorizontalTextPosition(SwingConstants.CENTER);
        printButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        inventoryToolBar.add(printButton);
        printButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                printButtonActionPerformed(e);
            }
        });        

        //exit button
        JButton exitButton = new JButton();
        exitButton.setText("Exit");
        exitButton.setToolTipText("Exit Program");
        sizeButton(exitButton, bSize);
        inventoryToolBar.add(exitButton);
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                exitButtonActionPerformed(e);
            }
        });;


        //Frame 
        
        JLabel itemLabel = new JLabel("Inventory Item");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10,10,0,10);
        gridConstraints.anchor = GridBagConstraints.EAST;
        getContentPane().add(itemLabel,gridConstraints);
        
        JTextField itemTextField = new JTextField();
        itemTextField.setPreferredSize(new Dimension(400,25));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 5;
        gridConstraints.insets = new Insets(10,0,0,10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(itemTextField,gridConstraints);
        
        //enter to focus next element
        /*itemTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                itemTextFieldActionPerformed(e);
            }
        });
        */
        
        JLabel locationLabel = new JLabel("Location");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10,10,0,10);
        gridConstraints.anchor = GridBagConstraints.EAST;
        getContentPane().add(locationLabel,gridConstraints);

        
        JComboBox locationComboBox = new JComboBox();
        locationComboBox.setEditable(true);
        locationComboBox.setBackground(Color.WHITE);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 3;
        gridConstraints.insets = new Insets(10,0,0,10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(locationComboBox,gridConstraints);
        /*locationComboBox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                locationComboBoxActionPerformed(e);
            }
        });*/
        
        //JCheckBox markedCheckBox = new JCheckBox();
        JCheckBox markedCheckBox = new JCheckBox();
        markedCheckBox.setText("Marked?");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 5;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10,10,0,0);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(markedCheckBox,gridConstraints);


        JLabel serialLabel = new JLabel();
        serialLabel.setText("Serial Number");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx =1;
        gridConstraints.gridy =2;
        gridConstraints.insets = new Insets(10,10,0,10);
        gridConstraints.anchor = GridBagConstraints.EAST;
        getContentPane().add(serialLabel,gridConstraints);
        
        JTextField serialTextField = new JTextField();
        serialTextField.setPreferredSize(new Dimension(270,25));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy  = 2;
        gridConstraints.gridwidth = 3;
        gridConstraints.insets = new Insets(10,0,0,10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(serialTextField,gridConstraints);
        /*serialTextField.addActionListener(new ActionListener ()
        {
            public void actionPerformed(ActionEvent e)
            {
                serialTextFieldActionPerformed(e);
            }
        });
        */

        //
        JLabel priceLabel = new JLabel();
        priceLabel.setText("Purchase Price");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(10,10,0,10);
        gridConstraints.anchor = GridBagConstraints.EAST;
        getContentPane().add(priceLabel,gridConstraints);



        JTextField priceTextField = new JTextField();
        priceTextField.setPreferredSize(new Dimension(160,25));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 3;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(10,0,0,10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(priceTextField,gridConstraints);


        JLabel dateLabel = new JLabel();
        dateLabel.setText("Date Purchased");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 4;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(10,10,0,0);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(dateLabel,gridConstraints);


        // JDateChooser dataDateChooser = new JDateChooser();
        JLabel storeLabel = new JLabel();
        storeLabel.setText("Store/website");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 4;
        gridConstraints.insets = new Insets(10,10,0,10);
        gridConstraints.anchor = GridBagConstraints.EAST;
        getContentPane().add(storeLabel,gridConstraints);

        
        JTextField storeTextField = new JTextField();
        storeTextField.setPreferredSize(new Dimension(400,25));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 4;
        gridConstraints.insets = new Insets(10,0,0,10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(storeTextField,gridConstraints);


        JLabel noteLabel = new JLabel();
        noteLabel.setText("Note");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 5;
        gridConstraints.insets = new Insets(10,10,0,10);
        gridConstraints.anchor = GridBagConstraints.EAST;
        getContentPane().add(noteLabel,gridConstraints);


        JTextField noteTextField = new JTextField();
        noteTextField.setPreferredSize(new Dimension(400,25));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 5;
        gridConstraints.gridwidth = 5;
        gridConstraints.insets = new Insets(10,10,0,10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(noteTextField,gridConstraints);


        JLabel photoLabel = new JLabel();
        photoLabel.setText("Photo");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 6;
        gridConstraints.insets = new Insets(10,10,0,10);
        gridConstraints.anchor = GridBagConstraints.EAST;
        getContentPane().add(photoLabel,gridConstraints);


        JTextArea photoTextArea = new JTextArea();
        photoTextArea.setPreferredSize(new Dimension(350,35));
        photoTextArea.setFont(new Font("Arial",Font.PLAIN,12));
        photoTextArea.setEditable(false);
        photoTextArea.setLineWrap(true);
        photoTextArea.setWrapStyleWord(true);
        photoTextArea.setBackground(new Color(255,255,192));
        photoTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 6;
        gridConstraints.insets = new Insets(10,0,0,10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(photoTextArea,gridConstraints);


        JButton photoButton = new JButton();
        photoButton.setText("...");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 6;
        gridConstraints.gridy = 6;
        gridConstraints.insets = new Insets(10,0,0,10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(photoButton,gridConstraints);
        photoButton.addActionListener(new ActionListener ()
        {
        public void actionPerformed(ActionEvent e)
        {
            photoButtonActionPerformed(e);
        }
        });


        //search alphas
        JPanel searchPanel = new JPanel();
        JButton[] searchButton = new JButton[26];
        searchPanel.setPreferredSize(new Dimension(240,160));
        searchPanel.setBorder(BorderFactory.createTitledBorder("Item Search"));
        //page 32 --26/11/22
        searchPanel.setLayout(new GridBagLayout());
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 7;
        gridConstraints.gridwidth = 3;
        gridConstraints.insets = new Insets(10,0,10,0);
        gridConstraints.anchor = GridBagConstraints.CENTER;
        getContentPane().add(searchPanel,gridConstraints);

        //creating and positioning 26 buttons
        int x=0,y=0;
        for(int i=0;i<26;i++)
        {
            //createbbutton
            searchButton[i] = new JButton();
            searchButton[i].setText(String.valueOf((char)(65+i)));
            searchButton[i].setFont(new Font("Arial", Font.BOLD, 12));
            searchButton[i].setMargin(new Insets(-10, -10, -10, -10));
            sizeButton(searchButton[i], new Dimension(37, 27));
            searchButton[i].setBackground(Color.YELLOW);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = x;
            gridConstraints.gridy = y;
            searchPanel.add(searchButton[i], gridConstraints);

            //method for button
            searchButton[i].addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    searchButtonActionPerformed(e);
                }
            });
            x++;
            //we will have 6 button each row
            if(x%6==0)
            {
                x=0;
                y++;
            }
        }
        



        //photopanel
        PhotoPanel photoPanel = new PhotoPanel();
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 4;
        gridConstraints.gridy = 7;
        gridConstraints.gridwidth = 3;
        gridConstraints.insets = new Insets(10, 0, 10, 10);
        gridConstraints.anchor = GridBagConstraints.CENTER;
        getContentPane().add(photoPanel, gridConstraints);
        

        //listener for enter to next elements
        //file io
        final int maximumEntries = 300;
        int numberEntries;
        InventoryItem[] myInventory = new InventoryItem[maximumEntries];

        int n;
        try 
        {
            String filename = "C:\Users\Admin\Desktop\vd\MyProjects\HomeInventery\inventory.txt";
            BufferedReader inputFile = new BufferedReader(new FileReader(filename));
            numberEntries = Integer.valueOf(inputFile.readLine()).intValue();
            if(numberEntries!=0)
            {
                for(int i=0;i<numberEntries;i++)
                {
                myInventory[i] = new InventoryItem();
                myInventory[i].desscription = inputFile.readLine();
                myInventory[i].location = inputFile.readLine();
                myInventory[i].serialNumber = inputFile.readLine();
                myInventory[i].marked = Boolean.valueOf(inputFile.readLine()).booleanValue();
                myInventory[i].purchasePrice = inputFile.readLine();
                myInventory[i].purchaseDate = inputFile.readLine();
                myInventory[i].purchaseLocation = inputFile.readLine();
                myInventory[i].note = inputFile.readLine();
                myInventory[i].photoFile = inputFile.readLine();
                }
            }
            //combobox element
            n = Integer.valueOf(inputFile.readLine()).intValue();
            if(n!=0)
            {
                for(int i=0;i<n;i++)
                {
                    locationComboBox.addItem(inputFile.readLine());
                }
            }
            inputFile.close();

        }
        catch(Exception ex)
        {
            numberEntries = 0;
            ex.printStackTrace();
        }
        if(numberEntries == 0)
        {
            newButton.setEnabled(false);
            deleteButton.setEnabled(false);
            nextButton.setEnabled(false);
            previousButton.setEnabled(false);
            printButton.setEnabled(false);
        }
    
    }//constructor of HIM
    private void exitForm(WindowEvent evt)
    {
        System.exit(0);
    }
    private void sizeButton(JButton b,Dimension d)
    {
        b.setPreferredSize(d);
        b.setMaximumSize(d);
        b.setMinimumSize(d);
    }

    //actions of the buttons
    private void newButtonActionPerformed(ActionEvent e)
    {

    }
    private void deleteButtonActionPerformed(ActionEvent e)
    {

    }
    private void saveButtonActionPerformed(ActionEvent e)
    {

    }
    private void previousButtonActionPerformed(ActionEvent e)
    {
        
    }
    private void nextButtonActionPerformed(ActionEvent e)
    {
        
    }
    private void printButtonActionPerformed(ActionEvent e)
    {
        
    }
    private void exitButtonActionPerformed(ActionEvent e)
    {
        
    }
    private void photoButtonActionPerformed(ActionEvent e)
    {
        
    }
    private void searchButtonActionPerformed(ActionEvent e)
    {
        
    }
    /*private void itemTextFieldActionPerformed(ActionEvent e)
    {
        locationComboBox.requestFocus();
    }
    private void locationComboBoxActionPerformed(ActionEvent e)
    {
        serialTextField.requestFocus();
    }
    private void serialTextFieldActionPerformed(ActionEvent e)
    {
        priceTextField.requestFocus();
    }
    */
}


class PhotoPanel extends JPanel{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);
        
        //draing border
        g2D.setPaint(Color.BLACK);
        g2D.draw(new Rectangle2D.Double(0,0,getWidth()-1,getHeight()-1));

        g2D.dispose();
    }
}