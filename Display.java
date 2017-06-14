package agarrunner;

import com.sun.javafx.tk.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *Display of logo,table,grid and calling cells draw method is made in here.
 */
public class Display extends JPanel {




        private Environment env;

	/**
	 * @param environment
	 */
	public Display(Environment environment) {
                super();
            setBackground(Color.white);
		env=environment;
	}

	/**
	 * 
	 */
	public Dimension getPreferredSize() {
    return new Dimension(env.getWindowWidth(), env.getWindowHeight());
	}

	/**
	 *
	 *
         * 
 *Display of logo,table,grid and calling cells draw method is made by these method.
 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);


        Graphics2D g2d=(Graphics2D) g;
/**
 draw logo
 */
            try {
                Image image = ImageIO.read(this.getClass().getResource("Logo.bmp"));
                  int w = image.getWidth(null);
                int h = image.getHeight(null);
                g.drawImage(image,0, env.getWindowHeight()-h, w, h, null);


            } catch (IOException ex) {
                Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            }
/**
 draw table
 */
            for(int i=0;i<env.getEntities().size();i++)
            {for(int j=i;j<env.getEntities().size();j++)
                if(env.getEntities().get(i) instanceof Cell && env.getEntities().get(j) instanceof Cell)
                    if(env.getEntities().get(i).getMass()<env.getEntities().get(j).getMass())
                    {
                        Entity tempc=env.getEntities().get(i);
                        env.getEntities().set(i,env.getEntities().get(j));
                        env.getEntities().set(j,tempc);
                    }
                }
                
            
            g2d.drawString("Step:" + env.getNumberOfTotalSteps(), 10, 20);
            int cellcount=0;
            for(Entity c: env.getEntities())
            {   if(c instanceof Cell)
                cellcount++;}
           g2d.drawString("Cells:" + cellcount, 180, 20);
            g2d.drawString("LeaderBoard", 75, 75);


            g2d.drawString("Name", 0, 120);

            g2d.drawString("Mass", 70, 120);

            g2d.drawString("Spd", 110, 120);

            g2d.drawString("Fd", 150, 120);

            g2d.drawString("C", 180, 120);

            g2d.drawString("St", 210, 120);


            int heighst=120;

            try{
            for(Entity e:env.getEntities())
            {
            if(e instanceof Cell)
            {
                String str=null;
                if(e.getStrategy() instanceof AvoidLarger)
                    str="AL";
                else if(e.getStrategy() instanceof StandStill)
                    str="SS";
                else if(e.getStrategy() instanceof GrabFood)
                    str="GF";
                else if(e.getStrategy() instanceof ChaseSmaller)
                    str="CS";
                else if(e.getStrategy() instanceof LoseMass)
                    str="LM";
                else if(e.getStrategy() instanceof MoveRandom)
                    str="MR";
                else if(e.getStrategy() instanceof MoveLinear)
                    str="ML";


                heighst+=20;
                Cell sam=(Cell) e;
                NumberFormat formatter = new DecimalFormat("#0.0");

            g2d.drawString(sam.getName() , 0, heighst);

            g2d.drawString(formatter.format(sam.getMass()) + "", 70, heighst);
                formatter = new DecimalFormat("#0.00");

            g2d.drawString(formatter.format(sam.getSpeed()*env.getdelTime()) + "", 110, heighst);

            g2d.drawString(sam.getFoodEaten() + "", 150, heighst);

            g2d.drawString(sam.getCellsSwallowed() + "", 180, heighst);

            g2d.drawString(str, 210, heighst);

            }



            }} catch (ConcurrentModificationException err) {
				
			}

/**
 draw grid
 */
            int wgrid=300;
            int hgrid=0;
            g2d.setColor(Color.black);
            if( env.isDrawGrid())
            {
                for(int i=0;i<11;i++)
                {
            g2d.drawLine(wgrid, 0, wgrid, 680);
            wgrid+=50;}
                for(int i=0;i<14;i++)
                {
            g2d.drawLine(250, hgrid, 800,hgrid);
            hgrid+=50;}
            }



/**
call for cells draw function */


        for(int i=0;i<env.getEntities().size();i++)
        {
                    env.getEntities().get(i).draw(g2d);
        }

	}




}
