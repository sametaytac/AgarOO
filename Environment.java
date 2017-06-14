package agarrunner;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.*;
import static java.util.Arrays.asList;



/**
 *All steps are executed in here.
 */




public class Environment {






        private boolean drawGrid;
        private int windowWidth;

	private int windowHeight;

	private int leftPanelWidth;
        private double delTime=0.1;
	private BufferedImage logo;

	private int numberOfTotalSteps;

        private OrganismFactory org = new OrganismFactory();
               private SugarFactory org2 = new SugarFactory();


        private ArrayList<Entity> entities;

	/**
 *Constructor which give form to game.
 */
	public Environment(int numberofCells,int numberofOrganisms,int numberofSugars) {
	    drawGrid=true;
	entities= new ArrayList <Entity> ();
        numberOfTotalSteps=0;
        windowWidth=800;
        windowHeight=680;


             for(int i=0;i<numberofSugars;i++)
               {
                  entities.add(createFood(org2));

                   

               }
             
             for(int i=0;i<numberofCells;i++)
               {
                 

                   entities.add(this.createCell());

               }

        
        
               for(int i=0;i<numberofOrganisms;i++)
               {
                  entities.add(createFood(org));


               }

        for(int i=0;i<numberofCells+numberofOrganisms+numberofSugars;i++)
        {

                    entities.get(i).setStrategy(generateSugarStepStrategy(0));



        }




        }




        public Food createFood(FoodFactory factory) {
               return factory.createFood(this);
	}
        public double getdelTime(){
        return delTime;
        }
	/**
 *This function is called over and over and executed.It arrange which strategies,check if any cells eaten etc.
 */

        public void stepAll(double deltaTime) {
            delTime=deltaTime;
            int temp=50;
        int countorg=0;
        int countsug=0;
	for(int i=0;i<getEntities().size();i++){
           if(getEntities().get(i) instanceof Cell)
            entities.get(i).setSpeed(2000/getEntities().get(i).getMass());
         if(getEntities().get(i) instanceof Organism && getEntities().get(i).getStrategy().isFinished())
         {  Random rand = new Random();
            temp=rand.nextInt(90) + 10;
             entities.get(i).setStrategy(generateOrganismStepStrategy(temp));

         }


         if(getEntities().get(i) instanceof Cell && getEntities().get(i).getStrategy().isFinished())
         {  Random rand = new Random();
            temp=rand.nextInt(90) + 10;
             entities.get(i).setStrategy(generateCellStepStrategy((Cell) getEntities().get(i),temp));

         }




            getEntities().get(i).step(deltaTime);
            setNumberOfTotalSteps(getNumberOfTotalSteps() + 1);

                        }

        for(int i=0;i<getEntities().size();i++)
        {

                for(Entity bigger:getEntities())
                {
                    if(bigger instanceof Cell)
                    {
                        double radius=bigger.getMass()/(2*Math.PI);
if((bigger.getPosition().getX()-radius<getEntities().get(i).getPosition().getX() && bigger.getPosition().getX()+radius>getEntities().get(i).getPosition().getX() )
        && (bigger.getPosition().getY()-radius<getEntities().get(i).getPosition().getY() && bigger.getPosition().getY()+radius>getEntities().get(i).getPosition().getY() )
        && bigger.getMass()>getEntities().get(i).getMass())
{
Cell b2=(Cell) bigger;
b2.addMass(getEntities().get(i).getMass());

b2.setFoodEaten(b2.getFoodEaten()+1);
if(                     getEntities().get(i) instanceof Cell)
b2.setCellsSwallowed(b2.getCellsSwallowed()+1);
                        getEntities().remove(getEntities().get(i));
break;
}


                    }


                }

        }

for(Entity sa:getEntities())
{
if(sa instanceof Sugar)
countsug++;
else if (sa instanceof Organism)
countorg++;
}
while(countorg<10)
{
            getEntities().add(createFood(getOrg()));
 entities.get(entities.size()-1).setStrategy(generateOrganismStepStrategy(0));
 countorg++;
}
while(countsug<10)
{
            getEntities().add(createFood(getOrg2()));
 entities.get(entities.size()-1).setStrategy(generateSugarStepStrategy(0));
countsug++;
}

for(int i=0;i<getEntities().size();i++)
{
if(         getEntities().get(i) instanceof BasicCell && getEntities().get(i).getMass()>200)
{
Cell a=new Roamer((Cell) getEntities().get(i));
a.setStrategy(generateCellStepStrategy(a,1));
                getEntities().remove(getEntities().get(i));
                getEntities().add(i, a);
}
else if(    getEntities().get(i) instanceof Roamer && getEntities().get(i).getMass()>350)
{
Cell a=new Evader((Cell) getEntities().get(i));
a.setStrategy(generateCellStepStrategy(a,1));
                getEntities().remove(getEntities().get(i));
                getEntities().add(i, a);
}

else if(    getEntities().get(i) instanceof Evader && getEntities().get(i).getMass()>500)
{
Cell a=new Hunter((Cell) getEntities().get(i));
a.setStrategy(generateCellStepStrategy(a,1));
                getEntities().remove(getEntities().get(i));
                getEntities().add(i, a);
}

}


        }

	/**
 *Generate sugar strategy.
 */
        public StepStrategy generateSugarStepStrategy(int temp) {
            StepStrategy stand=new StandStill(temp);
            return stand;
	}
	/**
 *Generate organism strategy.
 */

	public StepStrategy generateOrganismStepStrategy(int temp2) {

                Random rand = new Random();
                 int temp=rand.nextInt(2);
                 StepStrategy ret;
                 if(temp==0)
                 ret=new StandStill(temp2);
                 else
                 ret=new MoveRandom(temp2);

		return ret;
	}



	/**
 *Generate cell strategy.
 */

        public StepStrategy generateCellStepStrategy(Cell c,int temp2) {

                Random rand = new Random();
                int temp=0;
                StepStrategy ret = null;

                 if(c instanceof BasicCell)
                 temp=rand.nextInt(2);
                 else if(c instanceof Roamer)
                 temp=rand.nextInt(4);
                 else if(c instanceof Evader)
                 temp=rand.nextInt(6);
                 else if(c instanceof Hunter)
                 temp=rand.nextInt(7);

                 if(temp==0)
                 ret=new StandStill(temp2);
                 else if(temp==1)
                 ret=new GrabFood(this.getEntities(),temp2);
                 else if(temp==2)
                 ret=new MoveRandom(temp2);
                 else if(temp==3)
                 ret=new MoveLinear(temp2);
                 else if(temp==4)
                 ret=new LoseMass(temp2);
                 else if(temp==5)
                 ret=new AvoidLarger(this.getEntities(),temp2);
                 else if(temp==6)
                 ret=new ChaseSmaller(this.getEntities(),temp2);
		return ret;
	}



	/**
 *Create cell,for first creation,it is basic cell very time.
 */


        public Cell createCell() {
		 Random rand = new Random();
                 double x=rand.nextInt(getWindowWidth()-300) + 300;
                 double y=rand.nextInt(getWindowHeight()-50)+50;

                   float r = (rand.nextFloat());
                 float g =  (rand.nextFloat());
                 float b =  (rand.nextFloat());
                 Color randomColor = new Color(r, g, b,.42f );
                 double mass=rand.nextInt(30)+100;
                 double hiz=4000/mass;
                 Cell temp=new BasicCell(randomColor,mass,hiz,x,y,generateName());
                return (Cell) temp;
	}



	/**
 *Generate names.check for dublicates.
 */


         public String generateName() {



List<String> warriors=asList("Abrafo","Achilles","Alvar","Finn","Hector","Hehewuti",
        "Herbert","Keon","Kerbasi","Khalfani","Khalon","Kiaskari","Kijani","Cadabyr",
"Cadby","Cadda","Cadman","Cahira","Calhoun","Cammi","Cenewig","Ingvar","Iphito","Irapeke","Itaghai",
"Samurai","Sashenka","Serilda","Sgathaich","Shogun","Shomari","Swahili","Sigurd","Valasca","Valda","Victorio","Vidar");

                 Random rand = new Random();
                 int x=rand.nextInt(warriors.size()-1);

  lay:

for(Entity e:getEntities())
{
 if(e instanceof Cell)
 {
 Cell a=(Cell) e;

  if(a.getName().equals(warriors.get(x)))
  {
     x=rand.nextInt(warriors.size()-1);

      break lay;
  }

 }

}

    return warriors.get(x);

         }

    /**
     * @return the drawGrid
     */
    public boolean isDrawGrid() {
        return drawGrid;
    }

    /**
     * @param drawGrid the drawGrid to set
     */
    public void setDrawGrid(boolean drawGrid) {
        this.drawGrid = drawGrid;
    }

    /**
     * @return the windowWidth
     */
    public int getWindowWidth() {
        return windowWidth;
    }

    /**
     * @param windowWidth the windowWidth to set
     */
    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    /**
     * @return the windowHeight
     */
    public int getWindowHeight() {
        return windowHeight;
    }

    /**
     * @param windowHeight the windowHeight to set
     */
    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    /**
     * @return the leftPanelWidth
     */
    public int getLeftPanelWidth() {
        return leftPanelWidth;
    }

    /**
     * @param leftPanelWidth the leftPanelWidth to set
     */
    public void setLeftPanelWidth(int leftPanelWidth) {
        this.leftPanelWidth = leftPanelWidth;
    }

    /**
     * @return the logo
     */
    public BufferedImage getLogo() {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(BufferedImage logo) {
        this.logo = logo;
    }

    /**
     * @return the numberOfTotalSteps
     */
    public int getNumberOfTotalSteps() {
        return numberOfTotalSteps;
    }

    /**
     * @param numberOfTotalSteps the numberOfTotalSteps to set
     */
    public void setNumberOfTotalSteps(int numberOfTotalSteps) {
        this.numberOfTotalSteps = numberOfTotalSteps;
    }

    /**
     * @return the entities
     */
    public ArrayList<Entity> getEntities() {
        return entities;
    }

    /**
     * @param entities the entities to set
     */
    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    /**
     * @return the org
     */
    public OrganismFactory getOrg() {
        return org;
    }

    /**
     * @param org the org to set
     */
    public void setOrg(OrganismFactory org) {
        this.org = org;
    }

    /**
     * @return the org2
     */
    public SugarFactory getOrg2() {
        return org2;
    }

    /**
     * @param org2 the org2 to set
     */
    public void setOrg2(SugarFactory org2) {
        this.org2 = org2;
    }

	/**
	 *
	 */


	/**
	 * @return
	 *//*
	public String generateName() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 *//*



	/**
	 * @return
	 *//*
	public Cell createCell() {
		// TODO implement here
		return null;
	}

*/
}
