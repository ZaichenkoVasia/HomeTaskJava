package ua.mycompany.xtasks;

import javax.swing.*;
import java.awt.*;

public class T6_CleanBattleField extends JPanel
{

    final boolean COLORED_MODE = false;
    final boolean IS_GRID = true;

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    // 1 - top, 2 - right, 3 - down, 4 - left
    int tankDirection = 2;

    int tankX = 128;
    int tankY = 512;

    int bulletX = -100;
    int bulletY = -100;

    int tankSpeed = 10;
    int bulletSpeed = 5;

    final String BRICK = "B";
    final String BLANK = " ";

    String[][] battleField = {
            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
            {" ", " ", " ", " ", " ", " ", " ", " ", "B"},
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", "B", "B", " ", " ", " ", "B", "B", "B"},
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", "B", " ", "B", "B", "B", " ", "B", "B"},
            {"B", "B", " ", " ", " ", " ", " ", "B", "B"},
            {"B", " ", " ", "B", "B", "B", " ", " ", "B"},
            {"B", " ", " ", "B", "B", "B", " ", " ", "B"}
    };

    void runTheGame() throws Exception
    {
        clean();
    }

    /**
     *
     *  When method called tank should destroy all the objects on battle field in less then 30 seconds.
     * 1- top, 2 - right, 3 - down, 4 - left
     *  String yLine="ABCDEFGHI";
     */
    void clean()
    {
        int counterDirection=0;
        int[] directionOfClean = {1, 2, 4};
        String[] moveDirection={"H3","G3","F3","E3","D3","C3","B3","A3"};
        while (true)
        {
            for (String s : moveDirection) {

                for (int direction : directionOfClean) {
                    if (counterDirection != 3) {
                        tankDirection = direction;
                        sleep(100);
                        fire();
                        counterDirection++;
                    } else {
                        tankDirection = direction;
                        if (tankDirection != 1) {
                            sleep(100);
                            fire();
                        }

                    }
                }
                moveToQuadrant(s);
            }
        }
    }

    /**
     *
     * When called tank should produce new bullet.
     * This bullet should smoothly move to the opposite side.
     *
     * Bullet should be destroyed when rich the opposite side.
     *
     * When the bullet shoot something method would clean appropriate quadrant and destroy the bullet.
     */
    void fire()
    {
        //directions
        // 1- top, 2 - right, 3 - down, 4 - left

        if (tankDirection==1){
            bulletX=tankX+25;
            bulletY=tankY;
            while (bulletY>0 && bulletY <BF_HEIGHT){
                bulletY--;
                if(bulletY % 64 == 0 ){
                    checkAndProcessInterception();
                    repaint();
                }
                sleep(2);


            }
        }else if(tankDirection==2){
            bulletX=tankX+35;
            bulletY=tankY+25;
            while (bulletX>0 && bulletX<BF_HEIGHT-64){
                sleep(2);
                bulletX++;
                if(bulletX % 64 == 0 ){
                    checkAndProcessInterception();
                    repaint();
                }

            }
        }else if(tankDirection==3){
            bulletX=tankX+25;
            bulletY=tankY+35;
            while (bulletY<BF_HEIGHT-64 && bulletY >0){
                sleep(2);
                bulletY++;
                if(bulletY % 64 == 0 ){
                    checkAndProcessInterception();
                    repaint();
                }
            }
        }else if(tankDirection==4){
            bulletX=tankX+5;
            bulletY=tankY+25;
            while (bulletX>0 && bulletX<BF_WIDTH){
                sleep(2);
                bulletX--;
                if(bulletX % 64 == 0){
                    checkAndProcessInterception();
                    repaint();
                }
            }
        }
    }

    /**
     *
     * Should return true if bullet located in non-empty quadrant.
     *
     */
    private boolean checkAndProcessInterception()
    {
        int[] bulletPos=getQuadrant(bulletX,bulletY);

        if (battleField[bulletPos[1]][bulletPos[0]].equalsIgnoreCase("B")){
            battleField[bulletPos[1]][bulletPos[0]]="";

            return true;
        }else
            return false;
    }

    int[] getQuadrant(int x, int y)
    {
        return new int[] {x / 64, y / 64};
    }


    void moveToQuadrant(String quadrant)
    {
        //Getting Y position
        //get char from quadrant - for getting x position
        char yChar= quadrant.toUpperCase().charAt(0);
        String yLine="ABCDEFGHI";
        int yPos = (yLine.indexOf(yChar,0) * 64);

        //Getting X position
        int  xPos=Integer.parseInt(quadrant.substring(1));
        xPos*=64;
        xPos-=64;

        while (tankX!=xPos) {
            if (tankX<xPos) {
                move(2);
            }
            else if(tankX>xPos) {
                move(4);
            }
            else{
                break;
            }
        }


        while (tankY!=yPos) {
            if (tankY<yPos) {
                move(3);
            }
            else if(tankY>yPos) {
                move(1);
            }
            else{
                break;
            }
        }
    }

    void move(int direction)
    {
        if (direction==2){
            if(tankX<=512){
                moveRight();
            }
        }
        else if (direction==4){
            if (tankX>=64) {
                moveLeft();
            }
        }
        else if (direction==1) {
            if (tankY >= 64) {
                moveUp();
            }
        }
        else if (direction==3) {
            if (tankY <= 512) {
                moveDown();
            }
        }
        repaint();
    }

    private void moveDown() {
        int stopTank = tankY + 64;
        while (tankY < stopTank) {
            sleep(10);
            tankY += 1;
            repaint();
        }
    }

    private void moveUp() {
        int stopTank = tankY - 64;
        while (tankY > stopTank) {
            sleep(10);
            tankY -= 1;
            repaint();
        }

    }

    void moveLeft() {
        int stopTank = tankX - 64;
        while (tankX > stopTank) {
            sleep(10);
            tankX -= 1;
            repaint();
        }
    }

    void moveRight() {
        int stopTank = tankX + 64;
        while (tankX < stopTank) {
            sleep(10);
            tankX += 1;
            repaint();
        }
    }

    void turn(int direction)
    {
        tankDirection = direction;
        repaint();
    }

    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.


    public static void main(String[] args) throws Exception
    {
        T6_CleanBattleField bf = new T6_CleanBattleField();
        bf.runTheGame();
    }

    public T6_CleanBattleField() throws Exception
    {
        JFrame frame = new JFrame("YOUR TANK SHOULD FIRE!!!");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    void sleep(int millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (Exception ignore)
        {
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        paintBF(g);

        paintBorders(g);

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tankX, tankY, 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (tankDirection == 1)
        {
            g.fillRect(tankX + 20, tankY, 24, 34);
        }
        else if (tankDirection == 3)
        {
            g.fillRect(tankX + 20, tankY + 30, 24, 34);
        }
        else if (tankDirection == 4)
        {
            g.fillRect(tankX, tankY + 20, 34, 24);
        }
        else
        {
            g.fillRect(tankX + 30, tankY + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bulletX, bulletY, 14, 14);
    }

    private void paintBorders(Graphics g)
    {
        for (int j = 0; j < battleField.length; j++)
        {
            for (int k = 0; k < battleField.length; k++)
            {
                if (battleField[j][k].equals("B"))
                {
                    String coordinates = getQuadrantXY(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates.substring(0, separator));
                    int x = Integer.parseInt(coordinates.substring(separator + 1));
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x, y, 64, 64);

                    if (IS_GRID)
                    {
                        g.setColor(new Color(0, 0, 0));
                        g.drawRect(x, y, 64, 64);
                    }
                }
            }
        }
    }

    private void paintBF(Graphics g)
    {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++)
        {
            for (int h = 0; h < 9; h++)
            {
                if (COLORED_MODE)
                {
                    if (i % 2 == 0)
                    {
                        cc = new Color(252, 241, 177);
                    }
                    else
                    {
                        cc = new Color(233, 243, 255);
                    }
                }
                else
                {
                    cc = new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }
    }

    private String getQuadrantXY(int v, int h)
    {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

}
