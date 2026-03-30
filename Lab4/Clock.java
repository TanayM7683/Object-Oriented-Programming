package Lab4;

import java.time.LocalTime;

 class Clock {

     // alarmHour and alarmMinute set to -1 because initialized and alarm is not yet set
     private int alarmHour = -1;
     private int alarmMinute = -1;
     private boolean alarmON = false; //this keeps a track of whether the alarm exists

     //return the current hour
     public int getHours() {
         String time = LocalTime.now().toString();//gets current time and converts to string
         return Integer.parseInt(time.substring(0, 2));

     }

     //returns the current minute
     public int getMinutes() {
         String time = LocalTime.now().toString();
         // time format is hh:mm:ss, so indices 3–5 give minutes
         return Integer.parseInt(time.substring(3, 5));

     }

     //sets the alarm time
     public void setAlarm(int hours, int minutes) {
         //takes the hour and minutes as inputs
         alarmHour = hours;
         alarmMinute = minutes;
         alarmON = true; //when alarm time is stored, AlarmON becomes true which means alarm status to ON
     }

     // Return the Time and also check if alarm should ring or not
     public String getTime() {

         String CurrentTime = getHours() + ":" + getMinutes();

         //bonus part
         if (alarmON) { //checks if alarm is active, if yes then continues
             //the alarm triggers if hour is greater than alarmHour
             // the alarm or triggers when it is the same hour but the minutes have exceeded the alarmMinuites
             if (getHours() > alarmHour || (getHours() == alarmHour && getMinutes() >= alarmMinute)) {

                 alarmON = false; // to clear the alarm so it only rings once
                 return CurrentTime + "\u23F0 + ALARM!!!";
             }
         }
         return CurrentTime;
     }
     }

     //World Clock inherits for CLock class
     class WorldClock extends Clock {

         //stores the time differecne from the local time
         private int TimeDiff;

         //constructor
         public WorldClock(int offset) {
             this.TimeDiff = offset;
         }

         @Override
         //getHours is overridden because if we change getHOurs, getTime will automatcially work for world time
         public int getHours() {
             int hours = super.getHours() + TimeDiff;//call the Clock method of getHours

             //this handles time excedence, if 26 then 26 -24 = 2
             if (hours >= 24) {
                 hours = hours - 24;
             }
             //this handles negative time, -1 + 24 = 23
             if (hours < 0) {
                 hours = hours + 24;
             }

             return hours;
         }


         public static void main(String[] args) {

             // Testing Clock by creating an object, localClock, of Clock
             Clock localClock = new Clock();
             System.out.println("Local Clock Time is " + localClock.getTime());

             // Testing WorldClock by creating an object, New York, of WorldClock
             WorldClock NewYork = new WorldClock(3); //this creates a world clock with +5 hours off set
             System.out.println("New York time is  " + NewYork.getTime());

             // gets current local time and gives it to h and m varibles
             int h = localClock.getHours();
             int m = localClock.getMinutes() ;

             //sets alarms for current time for local
             localClock.setAlarm(h, m);
             System.out.println("Alarm set for " + h + ":" + m);
             System.out.println(" ");
             System.out.println("Alarm Set ");
             System.out.println("Current Time : " + localClock.getTime());
         }
     }


