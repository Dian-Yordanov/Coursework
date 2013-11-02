import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * User: Nocturnal Cyan
 * Date: 14/02/13
 * Time: 11:56
 * Cynnect's class
 */
public class layoutBuilder extends JFrame{

public layoutBuilder(){
uiBuilder();
}
public void uiBuilder()
{

    JPanel panel1 = new JPanel(new BorderLayout());

    add(panel1);
    panel1.setVisible(true);
    JLabel label1 = new JLabel(" ");
    panel1.add(label1, BorderLayout.NORTH);
    JLabel label2 = new JLabel(" ");
    panel1.add(label2, BorderLayout.SOUTH);
    JLabel label3 = new JLabel("     ");
    panel1.add(label3, BorderLayout.EAST);
    JLabel label4 = new JLabel("     ");
    panel1.add(label4, BorderLayout.WEST);

    JPanel panel2 = new JPanel(new BorderLayout());
    panel1.add(panel2, BorderLayout.CENTER);
    JLabel label11 = new JLabel("Supported by backstage.bbc.co.uk / Data from UK MET Office");
    panel2.add(label11, BorderLayout.SOUTH);

    JPanel panel3 = new JPanel(new BorderLayout());
    panel2.add(panel3,BorderLayout.WEST);

        JPanel panel4 = new JPanel(new BorderLayout());
        panel3.add(panel4,BorderLayout.NORTH);
        JLabel label111 = new JLabel("Search:");
        panel4.add(label111, BorderLayout.WEST);
        JTextField textField1 = new JTextField("                                              ");
        panel4.add(textField1, BorderLayout.EAST);
        JLabel label22 = new JLabel(" ");
        panel4.add(label22, BorderLayout.SOUTH);



        JPanel panel5 = new JPanel(new BorderLayout());
        panel3.add(panel5,BorderLayout.SOUTH);
        JLabel label32 = new JLabel(" ");
        panel5.add(label32, BorderLayout.SOUTH);
        JLabel label42 = new JLabel(" ");
        panel5.add(label42, BorderLayout.NORTH);
        JRadioButton rButton1 = new JRadioButton("Metric units");
        panel5.add(rButton1, BorderLayout.WEST);
        JRadioButton rButton2 = new JRadioButton("Imperial units");
        panel5.add(rButton2, BorderLayout.EAST);
        ButtonGroup metricSystem = new ButtonGroup();
        metricSystem.add(rButton1);
        metricSystem.add(rButton2);

        JPanel panel6 = new JPanel(new BorderLayout());
        panel3.add(panel6,BorderLayout.CENTER);
        final DefaultListModel listModel = new DefaultListModel();
        JList list = new JList(listModel);
        panel6.add(list, BorderLayout.CENTER);
        JLabel label5 = new JLabel("Possible Weather Stations:");
        panel6.add(label5, BorderLayout.NORTH);

    JPanel panel31 = new JPanel(new BorderLayout());
    panel2.add(panel31,BorderLayout.EAST);
        JTextField day1 = new JTextField(" ");
        panel31.add(day1, BorderLayout.NORTH);
        JTextField day2 = new JTextField(" ");
        panel31.add(day2, BorderLayout.CENTER);
        JTextField day3 = new JTextField(" ");
        panel31.add(day3, BorderLayout.SOUTH);











    setSize(720, 480);
    setTitle("Three Day Weathe Forecast");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Image icon = Toolkit.getDefaultToolkit().getImage("AppIcon5.png");
    setIconImage(icon);
}
}

