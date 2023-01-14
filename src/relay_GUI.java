import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.pi4j.io.gpio.*;

public class relay_GUI {
    private JFrame frame;
    private JButton btnRelay1, btnRelay2, btnRelay3, btnRelay4, btnRelay5, btnRelay6, btnRelay7, btnRelay8;
    String btnText1, btnText2, btnText3, btnText4, btnText5, btnText6, btnText7, btnText8;

    // The relay is triggered by a low level due to the pull down circuit (when the line is high the relay is off) 

    GpioController gpio = GpioFactory.getInstance();
    final GpioPinDigitalOutput relay1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "Relay1", PinState.HIGH);
    final GpioPinDigitalOutput relay2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "Relay2", PinState.HIGH);
    final GpioPinDigitalOutput relay3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, "Relay3", PinState.HIGH);
    final GpioPinDigitalOutput relay4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "Relay4", PinState.HIGH);
    final GpioPinDigitalOutput relay5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "Relay5", PinState.HIGH);
    final GpioPinDigitalOutput relay6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "Relay6", PinState.HIGH);
    final GpioPinDigitalOutput relay7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "Relay7", PinState.HIGH);
    final GpioPinDigitalOutput relay8 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, "Relay8", PinState.HIGH);
    

    public relay_GUI() {
        // Create the JFrame and set its properties
        frame = new JFrame("Pi Relay Control by Hans Johrend");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Create the button and set its properties

        btnRelay1 = new JButton("Relay 1: Off");
        btnRelay1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnText1 = btnRelay1.getText();
                if(relay1.getState() == PinState.HIGH && btnText1.equals("Relay 1: Off")){
                    relay1.low();
                    btnRelay1.setText("Relay 1: On");
                }else{
                    relay1.high();
                    btnRelay1.setText("Relay 1: Off");
                }
                
            }
        });

        btnRelay2 = new JButton("Relay 2: Off");
        btnRelay2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnText2 = btnRelay2.getText();
                if(relay2.getState() == PinState.HIGH && btnText2.equals("Relay 2: Off")){
                    relay2.low();
                    btnRelay2.setText("Relay 2: On");
                }else{
                    relay2.high();
                    btnRelay2.setText("Relay 2: Off");
                }
                
            }
        });

        btnRelay3 = new JButton("Relay 3: Off");
        btnRelay3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnText3 = btnRelay3.getText();
                if(relay3.getState() == PinState.HIGH && btnText3.equals("Relay 3: Off")){
                    relay3.low();
                    btnRelay3.setText("Relay 3: On");
                }else{
                    relay3.high();
                    btnRelay3.setText("Relay 3: Off");
                }
                
            }
        });

        btnRelay4 = new JButton("Relay 4: Off");
        btnRelay4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnText4 = btnRelay4.getText();
                if(relay4.getState() == PinState.HIGH && btnText4.equals("Relay 4: Off")){
                    relay4.low();
                    btnRelay4.setText("Relay 4: On");
                }else{
                    relay4.high();
                    btnRelay4.setText("Relay 4: Off");
                }
                
            }
        });

        btnRelay5 = new JButton("Relay 5: Off");
        btnRelay5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnText5 = btnRelay5.getText();
                if(relay5.getState() == PinState.HIGH && btnText5.equals("Relay 5: Off")){
                    relay5.low();
                    btnRelay5.setText("Relay 5: On");
                }else{
                    relay5.high();
                    btnRelay5.setText("Relay 5: Off");
                }
                
            }
        });

        btnRelay6 = new JButton("Relay 6: Off");
        btnRelay6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnText6 = btnRelay6.getText();
                if(relay6.getState() == PinState.HIGH && btnText6.equals("Relay 6: Off")){
                    relay6.low();
                    btnRelay6.setText("Relay 6: On");
                }else{
                    relay6.high();
                    btnRelay6.setText("Relay 6: Off");
                }
                
            }
        });

        btnRelay7 = new JButton("Relay 7: Off");
        btnRelay7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnText7 = btnRelay7.getText();
                if(relay7.getState() == PinState.HIGH && btnText7.equals("Relay 7: Off")){
                    relay7.low();
                    btnRelay7.setText("Relay 7: On");
                }else{
                    relay7.high();
                    btnRelay7.setText("Relay 7: Off");
                }
                
            }
        });

        btnRelay8 = new JButton("Relay 8: Off");
        btnRelay8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnText8 = btnRelay8.getText();
                if(relay8.getState() == PinState.HIGH && btnText8.equals("Relay 8: Off")){
                    relay8.low();
                    btnRelay8.setText("Relay 8: On");
                }else{
                    relay8.high();
                    btnRelay8.setText("Relay 8: Off");
                }
                
            }
        });

        // Create a panel to hold the label and button
        JPanel panel = new JPanel();
        //panel.setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(8, 1));
        //panel.add(label, BorderLayout.CENTER);
        panel.add(btnRelay1, BorderLayout.SOUTH);
        panel.add(btnRelay2, BorderLayout.SOUTH);
        panel.add(btnRelay3, BorderLayout.SOUTH);
        panel.add(btnRelay4, BorderLayout.SOUTH);
        panel.add(btnRelay5, BorderLayout.SOUTH);
        panel.add(btnRelay6, BorderLayout.SOUTH);
        panel.add(btnRelay7, BorderLayout.SOUTH);
        panel.add(btnRelay8, BorderLayout.SOUTH);

        // Add the panel to the JFrame
        frame.add(panel);

        // Show the JFrame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new relay_GUI();
    }
}