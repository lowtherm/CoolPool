public class GameStarter 
{
    public static void main(String[] args) 
    {
       GameArena PoolTable = new GameArena(1000,550,true);
       Text Welcome = new Text("Welcome To Cool Pool!",10,50,8,"WHITE",1); 
       PoolTable.addText(Welcome);
       Rectangle GreenBit = new Rectangle(30,30,900,450,"#006400",1);
       PoolTable.addRectangle(GreenBit);
       Ball TopLeftHole = new Ball(35,30,40,"BLACK",2);
       PoolTable.addBall(TopLeftHole);
       Ball BtmLeftHole = new Ball(35,480,40,"BLACK",2);
       PoolTable.addBall(BtmLeftHole);
       Ball TopMidHole = new Ball(465,30,40,"BLACK",2);
       PoolTable.addBall(TopMidHole);
       Ball BtmMidHole = new Ball(465,480,40,"BLACK",2);
       PoolTable.addBall(BtmMidHole);
       Ball TopRightHole = new Ball(925,30,40,"BLACK",2);
       PoolTable.addBall(TopRightHole);
       Ball BtmRightHole = new Ball(925,480,40,"BLACK",2);
       PoolTable.addBall(BtmRightHole);
       Line WhiteLine = new Line(225,30,225,480,1,"WHITE",3);
       PoolTable.addLine(WhiteLine);
       Rectangle TopBrown = new Rectangle(10,10,940,20,"#654321",4);
       PoolTable.addRectangle(TopBrown);
       Rectangle BtmBrown = new Rectangle(10,480,940,20,"#654321",4);
       PoolTable.addRectangle(BtmBrown);
       Rectangle LeftBrown = new Rectangle(10,30,20,450,"#654321",4);
       PoolTable.addRectangle(LeftBrown);
       Rectangle RightBrown = new Rectangle(930,30,20,450,"#654321",4);
       PoolTable.addRectangle(RightBrown);
       Ball CueBall = new Ball(225,255,20,"WHITE",4);
       PoolTable.addBall(CueBall);
       Ball BlackBall = new Ball(735,255,20,"BLACK",4);
       PoolTable.addBall(BlackBall);
       Ball RedBall1 = new Ball(695,255,20,"RED",4);
       PoolTable.addBall(RedBall1);
       Ball RedBall2 = new Ball(715,244,20,"RED",4);
       PoolTable.addBall(RedBall2);
       Ball RedBall3 = new Ball(735,277,20,"RED",4);
       PoolTable.addBall(RedBall3);
       Ball RedBall4 = new Ball(755,222,20,"RED",4);
       PoolTable.addBall(RedBall4);
       Ball RedBall5 = new Ball(755,266,20,"RED",4);
       PoolTable.addBall(RedBall5);
       Ball RedBall6 = new Ball(775,233,20,"RED",4);
       PoolTable.addBall(RedBall6);
       Ball RedBall7 = new Ball(775,299,20,"RED",4);
       PoolTable.addBall(RedBall7);
       Ball YellowBall1 = new Ball(715,266,20,"YELLOW",4);
       PoolTable.addBall(YellowBall1);
       Ball YellowBall2 = new Ball(735,233,20,"YELLOW",4);
       PoolTable.addBall(YellowBall2);
       Ball YellowBall3 = new Ball(755,244,20,"YELLOW",4);
       PoolTable.addBall(YellowBall3);
       Ball YellowBall4 = new Ball(755,288,20,"YELLOW",4);
       PoolTable.addBall(YellowBall4);
       Ball YellowBall5 = new Ball(775,211,20,"YELLOW",4);
       PoolTable.addBall(YellowBall5);
       Ball YellowBall6 = new Ball(775,255,20,"YELLOW",4);
       PoolTable.addBall(YellowBall6);
       Ball YellowBall7 = new Ball(775,277,20,"YELLOW",4);
       PoolTable.addBall(YellowBall7);
       Line PoolCue = new Line(212,255,-450,255,3,"WHITE",5);
       PoolTable.addLine(PoolCue);
       Rectangle EmptyBar = new Rectangle(970,30,20,500,"LIGHTGREY",4);
       PoolTable.addRectangle(EmptyBar);
       Rectangle RedBar = new Rectangle(970,280,20,250,"RED",5);
       PoolTable.addRectangle(RedBar);
       double Power = 0.5;
       while (true)
       {    
        if (PoolTable.leftPressed() == true)
        {
         double cueEnd1X = rotateCueClockWiseX(225, 255, PoolCue.getXStart(), PoolCue.getYStart() , 3);
         double cueEnd1Y = rotateCueClockWiseY(225, 255, PoolCue.getXStart(), PoolCue.getYStart() , 3);
         double cueEnd2X = rotateCueClockWiseX(225, 255, PoolCue.getXEnd(), PoolCue.getYEnd() , 3);
         double cueEnd2Y = rotateCueClockWiseY(225, 255, PoolCue.getXEnd(), PoolCue.getYEnd() , 3);
         PoolCue.setLinePosition(cueEnd1X,cueEnd1Y,cueEnd2X,cueEnd2Y);
         try
         {
          Thread.sleep(100);
         }
         catch(InterruptedException ex)
         {
          Thread.currentThread().interrupt();
         }
        }
        else if (PoolTable.rightPressed() == true)
        {
         double cueEnd1X = rotateCueClockWiseX(225, 255, PoolCue.getXStart(), PoolCue.getYStart() , -3);
         double cueEnd1Y = rotateCueClockWiseY(225, 255, PoolCue.getXStart(), PoolCue.getYStart() , -3);
         double cueEnd2X = rotateCueClockWiseX(225, 255, PoolCue.getXEnd(), PoolCue.getYEnd() , -3);
         double cueEnd2Y = rotateCueClockWiseY(225, 255, PoolCue.getXEnd(), PoolCue.getYEnd() , -3);
         PoolCue.setLinePosition(cueEnd1X,cueEnd1Y,cueEnd2X,cueEnd2Y);
         try
         {
          Thread.sleep(100);
         }
         catch(InterruptedException ex)
         {
          Thread.currentThread().interrupt();
         }  
        }
        else if (PoolTable.upPressed() == true)
        {
         if (RedBar.getHeight() < 500)
         {
          RedBar.setYPosition(RedBar.getYPosition() - 10);
          RedBar.setHeight(RedBar.getHeight() + 10);
          Power += 0.02;
         }
         try
         {
          Thread.sleep(100);
         }
         catch(InterruptedException ex)
         {
           Thread.currentThread().interrupt();
         }
         
        }
        else if (PoolTable.downPressed() == true)
        {  
         if (10 < RedBar.getHeight())
         {
          RedBar.setYPosition(RedBar.getYPosition() + 10);
          RedBar.setHeight(RedBar.getHeight() - 10);
          Power += -0.02;
         }
         try
         {
          Thread.sleep(100);
         }
         catch(InterruptedException ex)
         {
          Thread.currentThread().interrupt();
         }     
        }
        else if (PoolTable.spacePressed() == true)
        {
         double changeInY = Power * (PoolCue.getYStart() - PoolCue.getYEnd()) / 100;
         double changeInX = Power * (PoolCue.getXStart() - PoolCue.getXEnd()) / 100;
         while (Math.abs(changeInX) > 1 || Math.abs(changeInY) > 1)   
         {  
          CueBall.move(changeInX,changeInY);
          changeInX = changeInX * 0.99;
          changeInY = changeInY * 0.99;
          if(CueBall.getXPosition() < 30 && changeInX < 0)
          {
           changeInX = - changeInX;   
          }
          else if(CueBall.getXPosition() > 930 && changeInX > 0)
          {
           changeInX = - changeInX;     
          }
          if(CueBall.getYPosition() < 30 && changeInY < 0)
          {
           changeInY = - changeInY;   
          }
          else if(CueBall.getYPosition() > 480 && changeInY > 0)
          {
           changeInY = - changeInY;     
          }
          try
         {
          Thread.sleep(10);
         }
         catch(InterruptedException ex)
         {
          Thread.currentThread().interrupt();
         } 
         
         }
         try
         {
          Thread.sleep(100);
         }
         catch(InterruptedException ex)
         {
          Thread.currentThread().interrupt();
         }     
        }
        else
        {
         try
        {
          Thread.sleep(1);
        }
        catch(InterruptedException ex)
        {
          Thread.currentThread().interrupt();
        }
        }
       }
    }
     static double rotateCueClockWiseX(double centreOfRotX, double centreOfRotY, double edgeX, double edgeY, double angle) 
     {
      double xRot = centreOfRotX + Math.cos(Math.toRadians(angle)) * (edgeX - centreOfRotX) - Math.sin(Math.toRadians(angle)) * (edgeY - centreOfRotY);
      return xRot;
     }
     static double rotateCueClockWiseY(double centreOfRotX, double centreOfRotY, double edgeX, double edgeY, double angle) 
     {
      double yRot = centreOfRotY + Math.sin(Math.toRadians(angle)) * (edgeX - centreOfRotX) + Math.cos(Math.toRadians(angle)) * (edgeY - centreOfRotY);
      return yRot;
     }
}