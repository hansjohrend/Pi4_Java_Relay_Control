# About

This Java project enables the user to control relays via a graphical user intreface and have the state of the relays displayed. 
It is meant to be used on the Raspberry Pi 4, which is an SBC (Single Board Computer) made by the Raspberry Pi Foundation, based in England, Cambridge.

## Setup

### 1. Necessary hardware

- Raspberry Pi 4
- Micro SD card, minimally 16Gb
- Another computer to write the system image on the Micro SD card.
- Power supply (5V, 3A - for Pi 4)
- Monitor, keyboard, mouse
- [Waveshare 8 Channel Relay Expansion Board](https://www.waveshare.com/rpi-relay-board-b.htm)

### 2. Installing the OS

You can download the image yourself from the web and use any popular software (such as Win32DiskImager, Rufus, Balena Etcher, etc) to write it to the SD card.
Or, you can use the official [Pi Imager](https://www.raspberrypi.com/software/) and you also have the possibility of setting up thigs such as WiFi, SSH, main user account right before starting. This is useful in case you need a fast deployment of your Pi and have no monitor at a moment's notice.

![image](https://user-images.githubusercontent.com/59418297/211258822-32676736-82fb-4870-9f55-d8b976581b40.png)\
*Source: https://www.raspberrypi.com/software/*

In this project's case, make sure you are not running a headless version (that means not having any desktop environment installed).

### 2.1 Useful reads before moving to the next steps

- [Using GPIO pins to interact with hardware](https://www.raspberrypi.com/documentation/computers/os.html#gpio-and-the-40-pin-header)
- [Remote Access](https://www.raspberrypi.com/documentation/computers/remote-access.html)

### 3. Java
The most recent build of the RPi OS should already come wtih a Java Run-Time Environment preinstalled, make sure you have it installed by chekcing the version:
```
java -version
```

### 4. Make sure your system and apps are up to date

```bash
sudo apt update
sudo apt full-upgrade
```

### 5. Installating libraries

The main library we will need in order for this project to work is pi4j which is a "friendly object-oriented I/O API and implementation libraries for Java Programmers to access the full I/O capabilities of the Raspberry Pi platform".

![pi4j-overview](https://user-images.githubusercontent.com/59418297/211250201-867855a3-8ab5-4874-a94b-538d8b8cd2f5.jpg)\
*Source: https://pi4j.com/*

We have one dependecny to take care of which is WiringPi (it is a PIN based GPIO access library written in C). It should be preinstalled with the RPi OS, but if for whatever reason it is not, we use the following command to install it:

```
sudo apt-get install wiringpi
```

Installing pi4j:

```
curl -sSL https://pi4j.com/install | sudo bash
sudo apt-get install pi4j
sudo pi4j --update
```

### 6. Setting up the hardware

In case you want to connect remotely to the Pi and have some useful info on a physical display then the PiOled is a great addition. It requires Python, the pip manager and a package made by [Adafruit](learn.adafruit.com).

![image](https://user-images.githubusercontent.com/59418297/212502961-5b34d903-db63-4a1a-9fa8-4d5b46090d6b.png)\
*Source: https://www.adafruit.com/product/3527*

- Install the OLED Package
```console
sudo apt-get install python3-pip
sudo pip3 install adafruit-circuitpython-ssd1306
```
- Enable I2C bus from the Configuration tab
- Reboot
- Check for the OLED on the I2C bus
```console
sudo i2cdetect -y 1
```
- To make the script from the package to run on startup:
```console
sudo nano /etc/rc.local
```
- Then add the line
```console
sudo python3 /{folder_where_you_saved_the_script}/stats.py &
```



- After setting up the Pi insert it into the Waveshare Relay Board and secure it with the included screws

- Connect the power pins of the relay board to a regulated 5V 3A PSU (or the official USB C 5V 3A Pi power brick)

- If you have only a 12V power supply at hand make sure to use a step down converter such as the LM2596 (supports 3A) to bring it down to 5V.

![image](https://user-images.githubusercontent.com/59418297/212502116-4da22583-04cb-41bf-b3a0-a2cfc46892d0.png)

### 7. Using the app

1. Open the terminal

2. Compile the source in the direcory where you downloaded the file. This will create ```relay_GUI.class```
```console
javac relay_GUI.java
```
3. Run the app with:
```console
java relay_GUI
```
4. All relays are off by default, turn them on by clicking the buttons, the state is displayed on the button. 
![image](https://user-images.githubusercontent.com/59418297/212502496-29ac5730-ce85-4d09-98d2-8a37e8c22607.png)
![IMG_0109](https://user-images.githubusercontent.com/59418297/212502539-fae05180-d9a7-4943-a244-b755bd679f0c.jpg)

