/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agarrunner;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * It starts run project.
 */
public class AgarRunner extends JFrame {

        private static Environment env;
        private static Display disp;
        private static boolean pause=false;
        private static double deltaTime = 0.2;
        private static JFrame mainWindow;
	/**
	 * Default constructor
	 */
	public AgarRunner() {

        }

	/**
	 * 
	 * 
         * Main is used for keystrokes and calls stepAll.
	 */
	public static void main(String[] args) {
            int numberofCells=-1;int numberofOrganisms=-1;int numberofSugars=-1;
            System.out.println("Press G to toggle grid");
            System.out.println("Press P to play/pause");
            System.out.println("Press Q to quit");
            System.out.println("Press F to speed up animation");
            System.out.println("Press S to slow down animation");

           try {
 numberofCells = Integer.parseInt(args[0]);
 numberofOrganisms =Integer.parseInt(args[1]);
 numberofSugars=Integer.parseInt(args[2]);
} catch (ArrayIndexOutOfBoundsException exc) {
if(numberofCells==-1)
    numberofCells=10;
if(numberofOrganisms==-1)
    numberofOrganisms=10;
if(numberofSugars==-1)
    numberofSugars=10;
}

	
         env= new Environment(numberofCells,numberofOrganisms,numberofSugars);
         disp=new Display(env) ;

         mainWindow = new JFrame();
		mainWindow.setTitle("AgarOO");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		mainWindow.add(disp);
		mainWindow.pack();
		mainWindow.setVisible(true);
		     java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher
	    (
	      new java.awt.KeyEventDispatcher()
	      {
	        @Override
	        public boolean dispatchKeyEvent ( java.awt.event.KeyEvent event )
	        {

	          String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString() ;

	          if ( key.equals( "pressed Q" ) )  {  System.exit( 0 )                                ;  return true ; }
                  if ( key.equals( "pressed G" ) )  {  env.setDrawGrid(!env.isDrawGrid());                                ;  return true ; }
	          if ( key.equals( "pressed S" ) )  {  if(deltaTime>0.01)deltaTime-=0.01;  return true ; }
                  if ( key.equals( "pressed F" ) )  {  deltaTime+=0.01 ; return true ; }
                   if ( key.equals( "pressed P" ) )  {  pause=!pause ;  return true ; }

	          return false ;
	        }
	      }
	    ) ;
            while (true) {
                        if(!pause)
			env.stepAll(deltaTime );

			disp.repaint(); 
			 try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

}
