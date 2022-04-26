package com.company;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CarRental extends JFrame{
    private JFrame frame;
    private JPanel Panel2;
    private JPanel childPanel;
    private String color = "";
    private String rentedCars = "Autoturisme inchiriate: ";
    private String[][] cars = {
            {"Volkswagen", "Tiguan", "2012", "1 968 cm3", "140 HP", "Diesel", "Automatic", "30", "3", "Black", "White", "Yellow"},
            {"Skoda", "Octavia", "2011", "1197 cm3", "105 HP", "Gasoline", "Manual","25", "3", "Black", "White", "Red"},
            {"Renault", "Clio", "2016", "999 cm3", "56 HP", "Gasoline", "Manual", "17", "3", "White", "Red", "Yellow"},
            {"BMW", "X6 M", "2019", "4.395 cm3", "400 HP", "Diesel", "Automatic", "45", "2", "White", "Green", ""},
            {"Audi", "A5", "2019", "1984 cm3", "190 HP", "Gasoline", "Automatic", "30", "2", "Black", "Green", ""},
            {"Ford", "Fiesta", "2018", "999 cm3", "95 HP", "Gasoline", "Manual", "16", "3", "Brown", "Red", "Blue"},
            {"Dacia", "Duster", "2020", "1461 cm3", "110 HP", "Diesel", "Manual", "14", "2", "White", "Orange", ""},
            {"Mazda", "3", "2019", "1998 cm3", "181 HP", "Gasoline", "Automatic", "27", "2", "Red", "Black", ""},
            {"Mercedes", "Class C", "2015", "1595 cm3", "129 HP", "Gasoline", "Manual", "19", "2", "White", "Black", ""},
            {"Skoda", "Superb", "2019", "2998 cm3", "156 HP", "Diesel", "Automatic", "30", "1", "Brown", "", ""},
            {"BMW", "E93", "2010", "1995 cm3", "177 HP", "Diesel", "Manual", "8", "2", "White", "Yellow", ""},
            {"Volkswagen", "Golf V", "2006", "1896 cm3", "105 HP", "Diesel", "Manual", "10", "1", "Gray", "", ""},
            {"Renault", "Megane", "2006", "1598 cm3", "110 HP", "Gasoline", "Manual", "7", "1", "Red", "", ""}

    };

    public String username;
    public String password;
    public String backupPassword;

    CarRental(String username , String password, String backupPassword){
        this.username = username;
        this.password = password;
        this.backupPassword = backupPassword;
    }

    //The function creates the application's frame
    public void ApplicationFrame() {
        //The main window
        frame = new JFrame("Inchiriere de automobile");
        frame.setLayout(new BorderLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //The program stops when you exit the application

        MenuBar(frame); //The function that creates the menu bar
        Panel1(frame); //The function that creates the first main panel
        Panel2(frame); //The function that creates the second main panel

        //An icon is assigned to the window
        try {
            ImageIcon img = new ImageIcon("Images/icon.png");
            frame.setIconImage(img.getImage());
        }
        catch(Exception ex){
            System.out.println("Image not found");
        }


        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    //The function creates a menu bar, the objects in it and the accelerators for the buttons in the bar
    public void MenuBar(JFrame frame) {

        JMenuBar bara = new JMenuBar();

        JMenu meniu = new JMenu("Application");
        meniu.setMnemonic('a');
        bara.add(meniu);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic('x');
        exit.addActionListener(e ->{
            CarRental.this.dispose();
            System.exit(0);
        });
        //An accelerator is set for the exit button
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
        meniu.add(exit);

        meniu = new JMenu("Account");
        bara.add(meniu);

        JMenuItem prl = new JMenuItem("Change password / username");
        prl.addActionListener(e ->{
            changePassword();
        });
        prl.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
        meniu.add(prl);

        JMenuItem inc = new JMenuItem("Rented cars");
        inc.addActionListener(e ->{
            JFrame fm = new JFrame();
            fm.setSize(800, 300);
            fm.setResizable(false);
            JPanel pm = new JPanel();
            JLabel lm = new JLabel(rentedCars);
            lm.setFont(new Font("Arial", 0, 20));
            pm.setBackground(Color.white);
            pm.add(lm);
            fm.add(pm);
            fm.setVisible(true);
        });
        inc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.CTRL_MASK));
        meniu.add(inc);

        JMenuItem dsp = new JMenuItem("About");
        dsp.addActionListener(e ->{
            JFrame fm = new JFrame();
            fm.setSize(400, 100);
            fm.setResizable(false);
            JPanel pm = new JPanel();
            JLabel lm = new JLabel("Username: " + username);
            lm.setFont(new Font("Arial", 0, 20));
            pm.setBackground(Color.white);
            pm.add(lm);
            fm.add(pm);
            fm.setVisible(true);
        });
        dsp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK));
        meniu.add(dsp);

        meniu = new JMenu("Terms and conditions");
        meniu.setMnemonic('t');
        bara.add(meniu);
        JMenuItem t = new JMenuItem("Terms and conditions");
        t.setMnemonic('r');
        t.addActionListener(e ->{

            JFrame fm = new JFrame("Terms and conditions");
            fm.setSize(700, 300);
            fm.setResizable(false);
            String s = "<html>     Some terms and conditions</html>";
            JPanel pm = new JPanel();
            JLabel lm = new JLabel(s);
            lm.setFont(new Font("Arial", 0, 20));
            pm.setBackground(Color.white);
            pm.add(lm);
            fm.add(pm);
            fm.setVisible(true);
        });
        t.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, Event.CTRL_MASK));
        meniu.add(t);

        frame.setJMenuBar(bara);
        frame.pack();
    }


    //The application consists of two main panels
    //The first panel contains the car buttons
    public void Panel1(JFrame frame) {
        //The panel is created which consists of 4 smaller panels
        JPanel Panel1 = new JPanel();
        Panel1.setPreferredSize(new Dimension(735, 500));
        Panel1.setMaximumSize(new Dimension(735, 500));
        Panel1.setBackground(Color.white);

        //The first panel introduces the text "Cars available for rent"
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(450, 50));
        p1.setMaximumSize(new Dimension(450, 50));
        p1.setBackground(Color.white);
        JLabel l = new JLabel("<html> Cars available for rent: <br><br></html>");
        l.setFont((new Font("Verdana", Font.PLAIN, 20)));

        p1.add(l);


        //The buttons with the car names are inserted in the second panel
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(5,4));
        p2.setPreferredSize(new Dimension(800, 500));
        p2.setMaximumSize(new Dimension(800, 500));
        p2.setBackground(Color.white);

        JButton button;
        int i;
        for (i=1; i<=10; i++) {
            button = new JButton(cars[i - 1][0] + " " + cars[i - 1][1]);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            int k = i-1;
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
            p2.add(button);

            button.addActionListener(e -> {
                CarDisplay(k);

            });
        }

        //The text "Discounts and promotional prices" is introduced in the third panel:
        JPanel p3 = new JPanel();
        p3.setPreferredSize(new Dimension(450, 50));
        p3.setMaximumSize(new Dimension(450, 50));
        p3.setBackground(Color.white);
        l = new JLabel("<html> Discounts and promotional prices: <br><br></html>");
        l.setFont((new Font("Verdana", Font.PLAIN, 20)));

        p3.add(l);

        //The fourth panel contains the buttons for the last 3 cars
        //from the matrix of cars, these representing the cars that have a discount
        JPanel p4 = new JPanel();
        for (i=11; i<=13; i++) {
            button = new JButton(cars[i-1][0] + " " + cars[i-1][1]);
            button.setFont(new Font("Arial", Font.PLAIN, 20));

            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
            p4.add(button);
            int k = i-1;

            button.addActionListener(e -> {
                CarDisplay(k);

            });
        }
        p4.setBackground(Color.white);
        p4.setPreferredSize(new Dimension(250, 150));
        p4.setMaximumSize(new Dimension(250, 150));

        //The panels are added to the main panel, and then 'Panel1' is added on the left side of the window
        Panel1.add(p1);
        Panel1.add(p2);
        Panel1.add(p3);
        Panel1.add(p4);
        frame.add(Panel1, BorderLayout.WEST);

    }

    //The second panel calls the function that displays the selected car's information and also
    //displays the results of pressing the buttons for renting the car.
    public void Panel2(JFrame frame) {

        Panel2 = new JPanel();
        Panel2.setLayout(new GridLayout(1, 1));
        Panel2.setPreferredSize(new Dimension(800, 500));
        Panel2.setMaximumSize(new Dimension(800, 500));
        Panel2.setBackground(Color.white);

        //A child panel is created, the child of the main panel. This panel will be
        //replaced by another child panel each time a button is pressed to see the specifications of another car
        childPanel = new JPanel();
        childPanel.setPreferredSize(new Dimension(800, 500));
        childPanel.setMaximumSize(new Dimension(800, 500));
        childPanel.setBackground(Color.black);
        childPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 5)));

        //A default message will be shown before pressing a button
        JLabel l = new JLabel("<html> <br><br><br><br>Here will be shown the specifications of the cars. <br><br><br><br>" +
                "<br><br><br><br><br><br><br><br><br><br><br><br>Here you will rent the car.</html>");
        l.setForeground(Color.WHITE);
        l.setFont((new Font("Verdana", Font.PLAIN, 20)));

        //The child panel is added to the main panel, which in turn is added to the right side of the window
        childPanel.add(l);
        Panel2.add(childPanel);
        frame.add(Panel2, BorderLayout.EAST);
        frame.setLocationRelativeTo(null);

        frame.pack();
    }


    //The function displays the specifications of the selected car in the first panel, then creates buttons to display the images
    //of the selected car, radio buttons for selecting the car color, a checkbox, a textField for entering
    //the number of days to rent the car and a button to rent the car.
    //It consists of two smaller panels: pp1 and pp2.
    //The first contains the specifications of the selected car in the first panel, and the second contains the button for display and for rent
    public void CarDisplay(int k) {
        Panel2.remove(childPanel);  //The child panel is removed so that a new panel can be created

        String specifications = "<html>Company: " + cars[k][0] + "<br>Type: " + cars[k][1] + "<br>Year: " + cars[k][2] ;
        specifications = specifications + "<br>Cylinder capacity: " + cars[k][3] + "<br>Power: " + cars[k][4];
        specifications = specifications + "<br>Fuel: " + cars[k][5] + "<br>Transmission: " + cars[k][6];
        specifications = specifications + "<br>Colors: " + cars[k][8] + ":  ";
        int nrColors = Integer.parseInt(cars[k][8]);

        for (int i = 1; i <= nrColors; i++)
            specifications = specifications + cars[k][8 + i] + "    ";

        specifications = specifications + "<br>Price: " + cars[k][7] + " €/day</html>";


        JLabel spec = new JLabel(specifications);
        spec.setFont((new Font("Verdana", Font.PLAIN, 20)));
        spec.setForeground(Color.WHITE);
        JPanel pp1 = new JPanel();
        pp1.setPreferredSize(new Dimension(750, 350));
        pp1.setMaximumSize(new Dimension(750, 350));
        pp1.setBackground(Color.black);

        pp1.add(spec);


        JPanel pp2 = new JPanel();
        pp2.setBackground(Color.black);
        pp2.setPreferredSize(new Dimension(750, 450));
        pp2.setMaximumSize(new Dimension(750, 450));


        int j;
        JButton buton = new JButton();
        for (j = 1; j <= nrColors; j++) {
            buton = new JButton("Display " + cars[k][0] + " " + cars[k][1] + " " + cars[k][8 + j]);
            buton.setPreferredSize(new Dimension(700, 40));
            buton.setBackground(Color.BLACK);
            buton.setForeground(Color.WHITE);
            buton.setFont(new Font("Arial", Font.PLAIN, 30));
            int c = j;

            buton.addActionListener(e -> {
                JFrame imageF = new JFrame(cars[k][0] + " " + cars[k][1] + " " + cars[k][8 + c]);
                imageF.setSize(new Dimension(400, 300));
                JPanel imageP = new JPanel();
                try {
                    JLabel imageL = new JLabel(new ImageIcon("Images/" + cars[k][0] + " " + cars[k][1] + " " + cars[k][8 + c] + ".jpg"));
                    ImageIcon img = new ImageIcon("Images/" + cars[k][0] + " " + cars[k][1] + " " + cars[k][8 + c] + ".jpg");
                    imageF.setIconImage(img.getImage());
                    imageP.add(imageL);
                }
                catch(Exception ex) {
                    System.out.println("The image of the car was not found");
                }
                imageF.add(imageP);
                imageF.setVisible(true);
                imageF.setExtendedState(6);
            });
            pp2.add(buton);
        }

        ButtonGroup group = new ButtonGroup();
        JRadioButton rBtn;
        for (j = 1; j <= nrColors; j++) {
            rBtn = new JRadioButton(cars[k][8 + j]);
            rBtn.setPreferredSize(new Dimension(200, 30));
            group.add(rBtn);
            rBtn.addActionListener(e ->{
                color = e.getActionCommand();
            });

            pp2.add(rBtn);
        }

        JCheckBox cbox = new JCheckBox("I've read and agreed the terms and conditions");
        cbox.setPreferredSize(new Dimension(700, 40));

        pp2.add(cbox);

        JTextField t = new JTextField(30);
        JLabel lt = new JLabel("How many days do you want to rent the car?");
        lt.setFont((new Font("Verdana", Font.PLAIN, 20)));
        lt.setForeground(Color.WHITE);
        pp2.add(lt);
        pp2.add(t);

        buton = new JButton("Rent " + cars[k][0] + " " + cars[k][1]);
        buton.setPreferredSize(new Dimension(700, 40));
        buton.setBackground(Color.BLACK);
        buton.setForeground(Color.WHITE);
        buton.setFont(new Font("Arial", Font.PLAIN, 30));
        pp2.add(buton);

        JLabel rented = new JLabel("");

        pp2.add(rented);

        buton.addActionListener(e ->{

            try {
                int days = Integer.parseInt(t.getText());
                int price = Integer.parseInt(cars[k][7]) * days;
                if(!color.equals("") && days != 0 && cbox.isSelected()) {

                    rented.setFont((new Font("Verdana", Font.PLAIN, 20)));
                    rented.setForeground(Color.WHITE);
                    rented.setText("<html>You've rented the car " + cars[k][0] + " " + cars[k][1] + ", color " + color + ",<br> for " + days + " days!<br>Total price: " + price + " €</html>");
                    rentedCars = rentedCars + cars[k][0] + " " + cars[k][1] + "   ";
                }

            } catch (NumberFormatException ex) {
                rented.setFont((new Font("Verdana", Font.PLAIN, 15)));
                rented.setForeground(Color.RED);
                rented.setText("<html> You must select a color or<br>you must enter a correct number of days or <br> you must check the box and confirm that you agree to the terms and conditions!!!</html>");
            }

        });

        //A new child panel is created to which pp1 and pp2 are added
        childPanel = new JPanel();
        childPanel.add(pp1);
        childPanel.add(pp2);
        childPanel.setBackground(Color.white);
        childPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 5)));
        Panel2.add(childPanel);
        Panel2.revalidate();
        Panel2.repaint();

    }


    //The function displays a window in which the username and password must be entered
    public void start() {
        JFrame login = new JFrame();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setResizable(false);  //The window cannot be enlarged

        login.setSize(400, 400);
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        JLabel l1 = new JLabel("Username");
        l1.setFont((new Font("Verdana", Font.PLAIN, 15)));
        l1.setForeground(Color.WHITE);
        JLabel l2 = new JLabel("Password");
        l2.setFont((new Font("Verdana", Font.PLAIN, 15)));
        l2.setForeground(Color.WHITE);

        JLabel l3 = new JLabel("");  //The label will show if the password or username is wrong
        JTextField text1 = new JTextField(35);
        JPasswordField text2 = new JPasswordField(35);
        JButton b1 = new JButton("Login");
        JButton b2 = new JButton("Forgot the password?");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setPreferredSize(new Dimension(150, 40));


        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        panel.add(l1);
        panel.add(text1);
        panel.add(l2);
        panel.add(text2);
        panel.add(b1);
        panel.add(b2);
        panel.add(l3);

        login.add(panel);
        login.setLocationRelativeTo(null);
        login.setVisible(true);

        //Login button listener: If the password and username are correct, the start window is hidden
        //and the main application function is called
        b1.addActionListener(e ->{
            if(text1.getText().equals(username) && text2.getText().equals(password)) {
                login.setVisible(false);
                ApplicationFrame();
            }

            //if not, the message that something is wrong is displayed
            else {
                l3.setFont((new Font("Verdana", Font.PLAIN, 15)));
                l3.setForeground(Color.RED);
                l3.setText("<html>Wrong username or password!</html>");
            }
        });


        //The password change function is called
        b2.addActionListener(e ->{
            changePassword();
        });
    }

    public void changePassword() {
        JFrame change = new JFrame();
        change.setResizable(false);

        change.setSize(400, 400);
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        JLabel l1 = new JLabel("Backup password:");
        l1.setFont((new Font("Verdana", Font.PLAIN, 15)));
        l1.setForeground(Color.WHITE);
        JLabel l2 = new JLabel("New username:");
        l2.setFont((new Font("Verdana", Font.PLAIN, 15)));
        l2.setForeground(Color.WHITE);

        JLabel l3 = new JLabel("New password:");
        l3.setFont((new Font("Verdana", Font.PLAIN, 15)));
        l3.setForeground(Color.WHITE);

        JLabel l4 = new JLabel("");
        JPasswordField text1 = new JPasswordField(35);
        JTextField text2 = new JTextField(35);
        JPasswordField text3 = new JPasswordField(35);
        JButton b = new JButton("Change");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setPreferredSize(new Dimension(150, 40));

        panel.add(l1);
        panel.add(text1);
        panel.add(l2);
        panel.add(text2);
        panel.add(l3);
        panel.add(text3);
        panel.add(b);
        panel.add(l4);
        change.add(panel);

        change.setLocationRelativeTo(null);
        change.setVisible(true);

        b.addActionListener(e ->{
            if(text1.getText().equals(backupPassword)) {
                username = text2.getText();
                password = text3.getText();
                change.setVisible(false);
            }
            else {
                l4.setFont((new Font("Verdana", Font.PLAIN, 15)));
                l4.setForeground(Color.RED);
                l4.setText("<html>Wrong nackup password!</html>");
            }
        });
    }
}