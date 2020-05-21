import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;

public class GameBoard
{
 private GameArena PoolTable = new GameArena(1000,550,true);
 private Text Welcome = new Text("Welcome To Cool Pool!",10,50,8,"WHITE",1); 
 private Rectangle GreenBit = new Rectangle(30,30,900,450,"#006400",1);
 private Ball TopLeftHole = new Ball(35,30,40,"BLACK",2);
 private Ball BtmLeftHole = new Ball(35,480,40,"BLACK",2);
 private Ball TopMidHole = new Ball(465,30,40,"BLACK",2);
 private Ball BtmMidHole = new Ball(465,480,40,"BLACK",2);
 private Ball TopRightHole = new Ball(925,30,40,"BLACK",2);
 private Ball BtmRightHole = new Ball(925,480,40,"BLACK",2);
 private Line WhiteLine = new Line(225,30,225,480,1,"WHITE",3);
 private Rectangle TopBrown = new Rectangle(10,10,940,20,"#654321",4);
 private Rectangle BtmBrown = new Rectangle(10,480,940,20,"#654321",4);
 private Rectangle LeftBrown = new Rectangle(10,30,20,450,"#654321",4);
 private Rectangle RightBrown = new Rectangle(930,30,20,450,"#654321",4);
 private Ball CueBall = new Ball(225,255,20,"WHITE",4);
 private Ball BlackBall = new Ball(735,255,20,"BLACK",4);
 private Ball RedBall[] = new Ball[7];
 private Ball YellowBall[] = new Ball[7];
 private Line PoolCue = new Line(212,255,-450,255,3,"WHITE",5);
 private Rectangle EmptyBar = new Rectangle(970,30,20,500,"LIGHTGREY",4);
 private Rectangle RedBar = new Rectangle(970,280,20,250,"RED",5);
 private double Power = 0.5;
 private double xSpeed1, xSpeed2, ySpeed1, ySpeed2;
 private double changeInX[] = new double[16];
 private double changeInY[] = new double[16];
 public GameBoard()
 {
  RedBall[0] = new Ball(695,255,20,"RED",4);  
  RedBall[1] = new Ball(715,244,20,"RED",4);
  RedBall[2] = new Ball(735,277,20,"RED",4);
  RedBall[3] = new Ball(755,222,20,"RED",4);
  RedBall[4] = new Ball(755,266,20,"RED",4);
  RedBall[5] = new Ball(775,233,20,"RED",4);
  RedBall[6] = new Ball(775,299,20,"RED",4); 
  
  YellowBall[0] = new Ball(715,266,20,"YELLOW",4);
  YellowBall[1] = new Ball(735,233,20,"YELLOW",4);
  YellowBall[2] = new Ball(755,244,20,"YELLOW",4);
  YellowBall[3] = new Ball(755,288,20,"YELLOW",4);
  YellowBall[4] = new Ball(775,211,20,"YELLOW",4);
  YellowBall[5] = new Ball(775,255,20,"YELLOW",4);
  YellowBall[6] = new Ball(775,277,20,"YELLOW",4);
  
  for(int i=0;i<16;i++)
  {
   changeInX[i] = 0;
   changeInY[i] = 0;   
  }
  PoolTable.addText(Welcome);
  PoolTable.addRectangle(GreenBit);
  PoolTable.addBall(TopLeftHole);
  PoolTable.addBall(BtmLeftHole);
  PoolTable.addBall(TopMidHole);
  PoolTable.addBall(BtmMidHole);
  PoolTable.addBall(TopRightHole);
  PoolTable.addBall(BtmRightHole);
  PoolTable.addLine(WhiteLine);
  PoolTable.addRectangle(TopBrown);
  PoolTable.addRectangle(BtmBrown);
  PoolTable.addRectangle(LeftBrown);
  PoolTable.addRectangle(RightBrown);
  PoolTable.addBall(CueBall);
  PoolTable.addBall(BlackBall);
  PoolTable.addBall(RedBall[0]);
  PoolTable.addBall(RedBall[1]);
  PoolTable.addBall(RedBall[2]);
  PoolTable.addBall(RedBall[3]);
  PoolTable.addBall(RedBall[4]);
  PoolTable.addBall(RedBall[5]);
  PoolTable.addBall(RedBall[6]);
  PoolTable.addBall(YellowBall[0]);
  PoolTable.addBall(YellowBall[1]);
  PoolTable.addBall(YellowBall[2]);
  PoolTable.addBall(YellowBall[3]);
  PoolTable.addBall(YellowBall[4]);
  PoolTable.addBall(YellowBall[5]);
  PoolTable.addBall(YellowBall[6]);
  PoolTable.addLine(PoolCue);
  PoolTable.addRectangle(EmptyBar);
  PoolTable.addRectangle(RedBar);
       
       while (true)
       {    
        if (PoolTable.leftPressed() == true)
        {
         double cueEnd1X = rotateCueClockWiseX(CueBall.getXPosition(), CueBall.getYPosition(), PoolCue.getXStart(), PoolCue.getYStart() , 3);
         double cueEnd1Y = rotateCueClockWiseY(CueBall.getXPosition(), CueBall.getYPosition(), PoolCue.getXStart(), PoolCue.getYStart() , 3);
         double cueEnd2X = rotateCueClockWiseX(CueBall.getXPosition(), CueBall.getYPosition(), PoolCue.getXEnd(), PoolCue.getYEnd() , 3);
         double cueEnd2Y = rotateCueClockWiseY(CueBall.getXPosition(), CueBall.getYPosition(), PoolCue.getXEnd(), PoolCue.getYEnd() , 3);
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
         double cueEnd1X = rotateCueClockWiseX(CueBall.getXPosition(), CueBall.getYPosition(), PoolCue.getXStart(), PoolCue.getYStart() , -3);
         double cueEnd1Y = rotateCueClockWiseY(CueBall.getXPosition(), CueBall.getYPosition(), PoolCue.getXStart(), PoolCue.getYStart() , -3);
         double cueEnd2X = rotateCueClockWiseX(CueBall.getXPosition(), CueBall.getYPosition(), PoolCue.getXEnd(), PoolCue.getYEnd() , -3);
         double cueEnd2Y = rotateCueClockWiseY(CueBall.getXPosition(), CueBall.getYPosition(), PoolCue.getXEnd(), PoolCue.getYEnd() , -3);
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
         changeInY[0] = 3 * Power * (PoolCue.getYStart() - PoolCue.getYEnd()) / 100;
         changeInX[0] = 3 * Power * (PoolCue.getXStart() - PoolCue.getXEnd()) / 100;
         while (Math.abs(changeInX[0]) +  Math.abs(changeInY[0]) + Math.abs(changeInX[1]) + Math.abs(changeInY[1]) + Math.abs(changeInX[2]) + Math.abs(changeInY[2])+ Math.abs(changeInX[3]) + Math.abs(changeInY[3])+ Math.abs(changeInX[4]) + Math.abs(changeInY[4])+ Math.abs(changeInX[5]) + Math.abs(changeInY[5])+ Math.abs(changeInX[6]) + Math.abs(changeInY[6])+ Math.abs(changeInX[7]) + Math.abs(changeInY[7])+ Math.abs(changeInX[8]) + Math.abs(changeInY[8])+ Math.abs(changeInX[9]) + Math.abs(changeInY[9])+ Math.abs(changeInX[10]) + Math.abs(changeInY[10])+ Math.abs(changeInX[11]) + Math.abs(changeInY[11])+ Math.abs(changeInX[12]) + Math.abs(changeInY[12])+ Math.abs(changeInX[13]) + Math.abs(changeInY[13])+ Math.abs(changeInX[14]) + Math.abs(changeInY[14]) + Math.abs(changeInX[15]) + Math.abs(changeInY[15]) > 2)   
         {  
          CueBall.move(changeInX[0],changeInY[0]);
          BlackBall.move(changeInX[1],changeInY[1]);
          for (int i=0;i<7;i++)
          {
           RedBall[i].move(changeInX[i+2],changeInY[i+2]);   
           YellowBall[i].move(changeInX[i+9],changeInY[i+9]);  
          }
          for (int i = 0;i < 16; i++)
          {
          changeInX[i] = changeInX[i] * 0.99;
          changeInY[i] = changeInY[i] * 0.99;
          }
          if(CueBall.getXPosition() < 30 && changeInX[0] < 0)
          {
           changeInX[0] = - changeInX[0];   
          }
          else if(CueBall.getXPosition() > 930 && changeInX[0] > 0)
          {
           changeInX[0] = - changeInX[0];     
          }
          if(CueBall.getYPosition() < 30 && changeInY[0] < 0)
          {
           changeInY[0] = - changeInY[0];   
          }
          else if(CueBall.getYPosition() > 480 && changeInY[0] > 0)
          {
           changeInY[0] = - changeInY[0];     
          }
          if(BlackBall.getXPosition() < 30 && changeInX[1] < 0)
          {
           changeInX[1] = - changeInX[1];   
          }
          else if(BlackBall.getXPosition() > 930 && changeInX[1] > 0)
          {
           changeInX[1] = - changeInX[1];     
          }
          if(BlackBall.getYPosition() < 30 && changeInY[1] < 0)
          {
           changeInY[1] = - changeInY[1];   
          }
          else if(BlackBall.getYPosition() > 480 && changeInY[1] > 0)
          {
           changeInY[1] = - changeInY[1];     
          }

          for (int i=0;i<7;i++)
          {
           if(RedBall[i].getXPosition() < 30 && changeInX[i+2] < 0)
           {
            changeInX[i+2] = - changeInX[i+2];   
           }
           else if(RedBall[i].getXPosition() > 930 && changeInX[i+2] > 0)
           {
            changeInX[i+2] = - changeInX[i+2];     
           }
           if(RedBall[i].getYPosition() < 30 && changeInY[i+2] < 0)
           {
            changeInY[i+2] = - changeInY[i+2];   
           }
           else if(RedBall[i].getYPosition() > 480 && changeInY[i+2] > 0)
           {
            changeInY[i+2] = - changeInY[i+2];     
           }
           if(YellowBall[i].getXPosition() < 30 && changeInX[i+9] < 0)
           {
            changeInX[i+9] = - changeInX[i+9];   
           }
           else if(YellowBall[i].getXPosition() > 930 && changeInX[i+9] > 0)
           {
            changeInX[i+9] = - changeInX[i+9];     
           }
           if(YellowBall[i].getYPosition() < 30 && changeInY[i+9] < 0)
           {
            changeInY[i+9] = - changeInY[i+9];   
           }
           else if(YellowBall[i].getYPosition() > 480 && changeInY[i+9] > 0)
           {
            changeInY[i+9] = - changeInY[i+9];     
           }   
          }
          if (CueBall.collides(BlackBall) == true )
          {
           deflect(CueBall, BlackBall, changeInX[0],changeInX[1],changeInY[0],changeInY[1]); 
          }
          for(int i=0; i<7; i++)
          {
           if (CueBall.collides(RedBall[i]) == true )
           {
            deflect(CueBall, RedBall[i] ,changeInX[0],changeInX[i+2],changeInY[0],changeInY[i+2]); 
           }
           if (CueBall.collides(YellowBall[i]) == true )
           {
            deflect(CueBall, YellowBall[i] , changeInX[0],changeInX[i+9],changeInY[0],changeInY[i+9]); 
           }
          }
          for(int i=0; i<7; i++)
          {
           for(int j=0; j<7; j++)
           {
            if (RedBall[i].collides(RedBall[j]) == true && i != j)
           {
            deflect(RedBall[i], RedBall[j] ,changeInX[i+2],changeInX[j+2],changeInY[i+2],changeInY[j+2]); 
           }
           if (RedBall[i].collides(YellowBall[j]) == true )
           {
            deflect(RedBall[i], YellowBall[j] , changeInX[i+2],changeInX[j+9],changeInY[i+2],changeInY[j+9]); 
           }
           if (YellowBall[i].collides(RedBall[j]) == true )
           {
            deflect(YellowBall[i], RedBall[j] ,changeInX[i+9],changeInX[j+2],changeInY[i+9],changeInY[j+2]); 
           }
           if (YellowBall[i].collides(YellowBall[j]) == true && i != j )
           {
            deflect(YellowBall[i], YellowBall[j] , changeInX[i+9],changeInX[j+9],changeInY[i+9],changeInY[j+9]); 
           }   
           }
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
         for (int i = 0;i < 16; i++)
          {
          changeInX[i] = 0;
          changeInY[i] = 0;
          }
         try
         {
          Thread.sleep(10);
         }
         catch(InterruptedException ex)
         {
          Thread.currentThread().interrupt();
         } 
         PoolCue.setLinePosition(CueBall.getXPosition() - 13,CueBall.getYPosition(), CueBall.getXPosition() - 675, CueBall.getYPosition());    
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
    
    void deflect(Ball Ball1, Ball Ball2, double xSpeed1, double xSpeed2, double ySpeed1, double ySpeed2)
    {
     // Calculate initial momentum of the balls... We assume unit mass here.
     double p1InitialMomentum = Math.sqrt(xSpeed1 * xSpeed1 + ySpeed1 * ySpeed1);
     double p2InitialMomentum = Math.sqrt(xSpeed2 * xSpeed2 + ySpeed2 * ySpeed2);
     // calculate motion vectors
     double[] p1Trajectory = {xSpeed1, ySpeed1};
     double[] p2Trajectory = {xSpeed2, ySpeed2};
     // Calculate Impact Vector
     double[] impactVector = {Ball2.getXPosition() - Ball1.getXPosition(), Ball2.getYPosition() - Ball1.getYPosition()};
     double[] impactVectorNorm = normalizeVector(impactVector);
     // Calculate scalar product of each trajectory and impact vector
     double p1dotImpact = Math.abs(p1Trajectory[0] * impactVectorNorm[0] + p1Trajectory[1] * impactVectorNorm[1]);
     double p2dotImpact = Math.abs(p2Trajectory[0] * impactVectorNorm[0] + p2Trajectory[1] * impactVectorNorm[1]);
     // Calculate the deflection vectors - the amount of energy transferred from one ball to the other in each axis
     double[] p1Deflect = { -impactVectorNorm[0] * p2dotImpact, -impactVectorNorm[1] * p2dotImpact };
     double[] p2Deflect = { impactVectorNorm[0] * p1dotImpact, impactVectorNorm[1] * p1dotImpact };
     // Calculate the final trajectories
     double[] p1FinalTrajectory = {p1Trajectory[0] + p1Deflect[0] - p2Deflect[0], p1Trajectory[1] + p1Deflect[1] - p2Deflect[1]};
     double[] p2FinalTrajectory = {p2Trajectory[0] + p2Deflect[0] - p1Deflect[0], p2Trajectory[1] + p2Deflect[1] - p1Deflect[1]};
     // Calculate the final energy in the system.
     double p1FinalMomentum = Math.sqrt(p1FinalTrajectory[0] * p1FinalTrajectory[0] + p1FinalTrajectory[1] * p1FinalTrajectory[1]);
     double p2FinalMomentum = Math.sqrt(p2FinalTrajectory[0] * p2FinalTrajectory[0] + p2FinalTrajectory[1] * p2FinalTrajectory[1]); 

     // Scale the resultant trajectories if we've accidentally broken the laws of physics.
     double mag = (p1InitialMomentum + p2InitialMomentum) / (p1FinalMomentum + p2FinalMomentum);
     // Calculate the final x and y speed settings for the two balls after collision.
     if(Ball1 == CueBall)
     {
      changeInX[0] = p1FinalTrajectory[0] * mag;
      changeInY[0] = p1FinalTrajectory[1] * mag;
     }
     else if(Ball1 == BlackBall)
     {
     changeInX[1] = p1FinalTrajectory[0] * mag;
     changeInY[1] = p1FinalTrajectory[1] * mag;
     }
     for(int i =0; i<7; i++)
     {
      if(Ball1 == RedBall[i])
      {
      changeInX[i+2] = p1FinalTrajectory[0] * mag;
      changeInY[i+2] = p1FinalTrajectory[1] * mag;
      }
      else if(Ball1 == YellowBall[i])
      {
      changeInX[i+9] = p1FinalTrajectory[0] * mag;
      changeInY[i+9] = p1FinalTrajectory[1] * mag;
      }
     }

     if(Ball2 == CueBall)
     {
      changeInX[0] = p2FinalTrajectory[0] * mag;
      changeInY[0] = p2FinalTrajectory[1] * mag;
     }
     else if(Ball2 == BlackBall)
     {
     changeInX[1] = p2FinalTrajectory[0] * mag;
     changeInY[1] = p2FinalTrajectory[1] * mag;
     }
     for(int i =0; i<7; i++)
     {
      if(Ball2 == RedBall[i])
      {
      changeInX[i+2] = p2FinalTrajectory[0] * mag;
      changeInY[i+2] = p2FinalTrajectory[1] * mag;
      }
      else if(Ball2 == YellowBall[i])
      {
      changeInX[i+9] = p2FinalTrajectory[0] * mag;
      changeInY[i+9] = p2FinalTrajectory[1] * mag;
      }
     }
    }

    /**
    * Converts a vector into a unit vector.
    * Used by the deflect() method to calculate the resultnt direction after a collision.
    */
    static double[] normalizeVector(double[] vec)
    {
     double mag = 0.0;
     int dimensions = vec.length;
     double[] result = new double[dimensions];
     for (int i=0; i < dimensions; i++)
     mag += vec[i] * vec[i];
     mag = Math.sqrt(mag);
     if (mag == 0.0)
     {
      result[0] = 1.0;
      for (int i=1; i < dimensions; i++)
       result[i] = 0.0;
     }
     else
     {
      for (int i=0; i < dimensions; i++)
      result[i] = vec[i] / mag;
     }
     return result;
 }
}