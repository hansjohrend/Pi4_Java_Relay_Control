import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


public class ControlGpioExample {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("<--Pi4J--> GPIO Control Example ... started.");

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pins as output pins and turn on
        //GPIO codes are from the wiringpi lib
        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "Relay_1", PinState.HIGH);
        final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "Relay_2", PinState.HIGH);
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, "Relay_3", PinState.HIGH);
        final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "Relay_4", PinState.HIGH);
        final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "Relay_5", PinState.HIGH);
        final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "Relay_6", PinState.HIGH);
        final GpioPinDigitalOutput pin7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "Relay_7", PinState.HIGH);
        final GpioPinDigitalOutput pin8 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, "Relay_8", PinState.HIGH);


        // set shutdown state for this pin
        pin1.setShutdownOptions(true, PinState.LOW);
        pin2.setShutdownOptions(true, PinState.LOW);
        pin3.setShutdownOptions(true, PinState.LOW);
        pin4.setShutdownOptions(true, PinState.LOW);
        pin5.setShutdownOptions(true, PinState.LOW);
        pin6.setShutdownOptions(true, PinState.LOW);
        pin7.setShutdownOptions(true, PinState.LOW);
        pin8.setShutdownOptions(true, PinState.LOW);
        

        System.out.println("--> GPIO state should be: ON");

        Thread.sleep(2000);

        // turn off gpio pins
        pin1.low();
        Thread.sleep(300);
        pin2.low();
        Thread.sleep(300);
        pin3.low();
        Thread.sleep(300);
        pin4.low();
        Thread.sleep(300);
        pin5.low();
        Thread.sleep(300);
        pin6.low();
        Thread.sleep(300);
        pin7.low();
        Thread.sleep(300);
        pin8.low();
        Thread.sleep(300);
        System.out.println("--> GPIO state should be: OFF");

        Thread.sleep(2000);

        // toggle the current state of gpio pin #01 (should turn on)
        pin1.toggle();
        Thread.sleep(300);
        pin2.toggle();
        Thread.sleep(300);
        pin3.toggle();
        Thread.sleep(300);
        pin4.toggle();
        Thread.sleep(300);
        pin5.toggle();
        Thread.sleep(300);
        pin6.toggle();
        Thread.sleep(300);
        pin7.toggle();
        Thread.sleep(300);
        pin8.toggle();
        Thread.sleep(300);
        System.out.println("--> GPIO state should be: ON");

        Thread.sleep(5000);

        // toggle the current state of gpio pin #01  (should turn off)
        pin1.toggle();
        System.out.println("--> GPIO state should be: OFF");

        Thread.sleep(3000);

        // turn on gpio pin #01 for 1 second and then off
        System.out.println("--> GPIO state should be: ON for only 1 second");
        pin1.pulse(1000, true); // set second argument to 'true' use a blocking call
        pin2.pulse(1000, true);
        pin3.pulse(1000, true);
        pin4.pulse(1000, true);
        pin5.pulse(1000, true);
        pin6.pulse(1000, true);
        pin7.pulse(1000, true);
        pin8.pulse(1000, true);
        // stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
        gpio.shutdown();

        System.out.println("Exiting ControlGpioExample");
    }
}