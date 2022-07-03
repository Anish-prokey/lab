package questions;

import java.util.Scanner;
public class GetStringThread extends Thread {
public String string;
public static String vowels = "aeiou";
public void run() {
Scanner s = new Scanner(System.in);
System.out.println("Enter a string: ");
string = s.next();
int x = 0;
for(char c : string.toCharArray())
for(char ch : vowels.toCharArray())
if(c==ch) x++;
System.out.print(x+" vowels present\n");
}
}


~~~~~~~~~~~~~~~~~~~~~~~~
GetNumberThread.java
~~~~~~~~~~~~~~~~~~~~~~~~
import java.util.Scanner;
public class GetNumberThread extends Thread {
public String number;
private static String[] digit = new String[] 
{"zero","one","two","three","four","five","six","seven","eight","nine"};
public void run() {
Scanner s = new Scanner(System.in);
System.out.println("Enter number with more than 4 digits: ");
number = s.next();
for(char c : number.toCharArray()) {
if(c<48||c>57) {
System.out.println("Invalid inputs");
break;
}
System.out.print(digit[((int)c-48)]+" ");
}
System.out.print("\n");
}
}



~~~~~~~~~~~~~~~~~~~~~~~~
InputThreads.java
~~~~~~~~~~~~~~~~~~~~~~~~
public class InputThreads {
public static void main(String[] args) throws InterruptedException { 
GetStringThread getStringThread;
GetNumberThread getNumberThread;
getNumberThread = new GetNumberThread();
getStringThread = new GetStringThread();
//getNumberThread.start();
getStringThread.start();
Thread.sleep(100);
//getStringThread.start();
getNumberThread.start();
}
}


b. //server program
import java.io.*; 
import java.net.*; 
public class MyServer { 
public static void main(String[] args){ 
try{ 
ServerSocket ss=new ServerSocket(6666); 
Socket s=ss.accept();//establishes connection 
DataInputStream dis=new DataInputStream(s.getInputStream()); 
String str=(String)dis.readUTF(); 
System.out.println("message= "+str); 
ss.close(); 
}catch(Exception e){System.out.println(e);} 
} 
} 
//client program


import java.io.*; 
import java.net.*; 
public class MyClient { 
public static void main(String[] args) { 
try{ 
Socket s=new Socket("localhost",6666); 
DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
dout.writeUTF("Hello Server"); 
dout.flush(); 
dout.close(); 
s.close(); 
}catch(Exception e){System.out.println(e);} 
} 
} 