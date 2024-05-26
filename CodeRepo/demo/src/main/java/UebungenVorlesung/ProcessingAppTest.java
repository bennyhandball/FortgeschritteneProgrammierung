package UebungenVorlesung;

import processing . core .*; // import processing
public class ProcessingAppTest extends PApplet{
 
 public static void main ( String [] args ) {
 PApplet . main ("main.java.GeneratePasswort.HelloProcessing") ;
 }
 public void settings () { // startup settings
 size (800 , 600) ;
 }
 public void setup () { // setup called after settings
 stroke (255 , 0 , 0 , 255) ;
 textSize (72) ;
 }
 int bgCol = 0;
 public void draw () { // draw called every frame
 background ( bgCol ); // clear background
 textSize ( bgCol ) ;
 text (" Hello World !" ,10 ,300) ; // set text
 bgCol = ( bgCol + 1) % 128; // animate color
}}

