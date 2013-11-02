import javax.swing.*;

/**
 * User: Nocturnal Cyan
 * Date: 04/02/13
 * Time: 10:10
 * Cynnect's class
 */
public class mClass
{
    public static void main(String arg[])
    {




        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                smClass o1 = new smClass();
                layoutBuilder o2 = new layoutBuilder();

                o1.setVisible(true);
                o2.setVisible(true);
            }
        });
    }

}
