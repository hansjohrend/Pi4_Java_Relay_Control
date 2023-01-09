# About

This Java project enables the user to:

- control relays via a graphical user intreface 
- trigger a relay automatically with the help of an event listener. 

The program is meant to be used on the Raspberry Pi 4, which ia SBC (Single Board Computer) made by the Raspberry Pi Foundation, based in England, Cambridge.

## Setup

### 1. Necessary hardware

- Raspberry Pi 4
- Micro SD card, minimally 16Gb b
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

### Useful Reads

- [Using GPIO pins to interact with hardware](https://www.raspberrypi.com/documentation/computers/os.html#gpio-and-the-40-pin-header)
- [Remote Access](https://www.raspberrypi.com/documentation/computers/remote-access.html)
