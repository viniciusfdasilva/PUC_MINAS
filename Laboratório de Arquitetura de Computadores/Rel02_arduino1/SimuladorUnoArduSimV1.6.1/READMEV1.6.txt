UnoArduSimV1.6 README

When you first run UnoArduSim.exe, you will see a default set of I/O devices (one of each of eight of nine available "big" I/O devices, and several of each of the "small" I/O devices), and a dummy "simple.ino" default program which you can immediately run.

You can use the Configure menu to adjust the set of I/O devices, and from the provided dialog "Save" that configuration for next time (as a named text file). That file name will be automatically added to the myArduPrefs.txt file that gets loaded at the next program startup -- to go back to the default startup configuration, delete the IODevs line in the myArduPrefs.txt file (or just delete that entire file).

When ready, you can load and try out the provided DemoProg1.ino demonstration program -- that program needs to have a particular set of I/O devices attached, so use "Configure->IO Devices" and "Load" the myUnoDevs_DemoProg1.txt file. That will load the devices (with pre-set pin connections and settings and values) that are needed by the DemoProg1.ino program. Run it to see the IO devices and program in action. 

Note that DemoProg1.ino has been updated since V1.5 to fix the inadequate drive on the DC motor DIR pin by adding pinMode(dirPin, OUTPUT). Withot that, only the driver's internal 20K pullup was driving high, and the attached LED loading dragged down the output voltage to a level barely accepted as HIGH by the DC motor. Also note that myUnoDevs_DemoProg1.txt has been modified in V1.6 to make the PULSER's pulsewidth scalable (by adding an 'S' suffix). During execution, drag the new I/O Values Scaler slider found on the main toolbar to control the driven DC motor's speed.

You can then try out a more complex (and fun) program DemoProg2.ino that has musical playback and I/O devices moving to the music (my acknowledgment to the animated TV program, the Simpsons, for that one). This second demo program also shows that you can split your code (and included data) between multiple files for better viewing and navigation.

Finally, DemoProg3.ino demonstrates the new 1SHOT I/O device, and generates waveforms which can be viewed in the Digital Waveforms window. Load DemoProg3.ino and then the myUnoDevs_DemoProg3.txt file. Now left-click on pins 2,3,4, and 5 in turn on the border of the Uno board -- four waveforms will be showing. Run the program to see the waveforms created by a loop() instruction repeatedly triggering the first 1SHOT device. You can manually trigger the second 1SHOT at any time by pressing and then releasing the pushbutton attached to pin 3 to cause a rising edge. You can halt the program at any point and use the blue and red cursors inside the Digital Waveforms window to measure the produced pulse widths and delays.

