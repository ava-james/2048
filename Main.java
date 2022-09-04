// with help from https://www.instructables.com/Program-Your-Own-2048-Game-WJava/
//https://github.com/patturtestsite/2048

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JPanel implements KeyListener
{
  Board board = new Board();
  static Main newGame = new Main();
  static JFrame frame = new JFrame();
  String gameBoard = board.toString();
  static String mode = "light";
  public String gameMessage= " ";

  public static void setUpGUI()
  {
    frame.addKeyListener(newGame);
    frame.getContentPane().add(newGame);
    frame.setSize(450,450);
    frame.setVisible(true);
    frame.setResizable(false);
  }

  @Override
  public void keyPressed( KeyEvent e ){
    if(e.getKeyCode() == KeyEvent.VK_ENTER){
      board.clearBoard();
      board.start();
      repaint();
    }else if(e.getKeyCode() == KeyEvent.VK_UP){
      if(board.isUpPossible()==true){
        board.up();
        board.addNewValue();
        repaint();
      }else{
        repaint();
      }
    }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
      if(board.isDownPossible()==true){
        board.down();
        board.addNewValue();
        repaint();
      }
    }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
      if(board.isRightPossible()==true){
        board.right();
        board.addNewValue();
        repaint();
      }
    }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
      if(board.isLeftPossible()==true){
        board.left();
        board.addNewValue();
        repaint();
      }
    }else if(e.getKeyCode() == KeyEvent.VK_1){
      board.add8();
      repaint();
    }else if(e.getKeyCode() == KeyEvent.VK_2){
      board.add16();
      repaint();
    }else if(e.getKeyCode() == KeyEvent.VK_3){
      board.add32();
      repaint();
    }else if(e.getKeyCode() == KeyEvent.VK_4){
      board.add64();
      repaint();
    }else if(e.getKeyCode() == KeyEvent.VK_5){
      board.add128();
      repaint();
    }else if(e.getKeyCode() == KeyEvent.VK_6){
      board.add256();
      repaint();
    }else if(e.getKeyCode() == KeyEvent.VK_7){
      board.add512();
      repaint();
    }else if(e.getKeyCode() == KeyEvent.VK_8){
      board.add1024();
      repaint();
    }else if(e.getKeyCode() == KeyEvent.VK_9){
      board.add2048();
      repaint();
    }else if(e.getKeyCode() == KeyEvent.VK_L){
      mode = "light";
      repaint();
    }else if(e.getKeyCode() == KeyEvent.VK_D){
      mode = "dark";
      repaint();
    }else if(e.getKeyCode() == KeyEvent.VK_R){
      mode = "rainbow";
      repaint();
    }
    else if(e.getKeyCode() == KeyEvent.VK_C){
      mode = "cupcake";
      repaint();
    }
  }

  @Override
  public void keyReleased( KeyEvent e ){}

  @Override
  public void keyTyped( KeyEvent e ){}

  public void paint(Graphics g){
    super.paint(g);
    Graphics2D g2 = (Graphics2D)g;
    //light mode
    if(mode.equals("light")){
      g2.setColor(Color.black);
      g2.drawString("2048", 205, 20);
      g2.drawString("Press Enter to Start", 163, 40);
      g2.drawString("Score: "+board.getScore(), 130, 70);
      g2.drawString("Highest Tile: "+board.getHighTile(),215,70);
      g2.drawString("L=Light Mode",5,20);
      g2.drawString("D=Dark Mode",5,35);
      g2.drawString("R=Rainbow Mode",5,50);
      g2.drawString("C=Cupcake Mode",5,65);
      
      g2.drawString("1=8",5,95);
      g2.drawString("2=16",5,110);
      g2.drawString("3=32",5,125);
      g2.drawString("4=64",5,140);
      g2.drawString("5=128",5,155);
      g2.drawString("6=256",5,170);
      g2.drawString("7=512",5,185);
      g2.drawString("8=1024",5,200);
      g2.drawString("9=2048",5,215);
      
      g2.fillRect(75,85,300,300);

      for(int r=0; r<4; r++){
        for(int c=0; c<4; c++){
           drawTiles(g, board.board[r][c], c * 75 + 80, r * 75 + 90);
        }
      }

      if(board.isWin()){
        gameMessage = "You win!!";
        g2.drawString(gameMessage, 205, 400);
      }

      if(board.gameOver()){
        g2.setColor(Color.red);
        gameMessage = "Game Over";
        g2.drawString(gameMessage, 187, 400);
        g2.setColor(Color.black);
      }
      
     //dark mode
    }else if(mode.equals("dark")){
      g2.setColor(Color.darkGray);
      g2.fillRect(0,0,450,450);
      
      g2.setColor(Color.white);
      g2.drawString("2048", 205, 20);
      g2.drawString("Press Enter to Start", 160, 40);
      g2.drawString("Score: "+board.getScore(), 130, 70);
      g2.drawString("Highest Tile: "+board.getHighTile(),215,70);
      g2.drawString("L=Light Mode",5,20);
      g2.drawString("D=Dark Mode",5,35);
      g2.drawString("R=Rainbow Mode",5,50);
      g2.drawString("C=Cupcake Mode",5,65);

      g2.drawString("1=8",5,95);
      g2.drawString("2=16",5,110);
      g2.drawString("3=32",5,125);
      g2.drawString("4=64",5,140);
      g2.drawString("5=128",5,155);
      g2.drawString("6=256",5,170);
      g2.drawString("7=512",5,185);
      g2.drawString("8=1024",5,200);
      g2.drawString("9=2048",5,215);
      
      g2.setColor(Color.black);
      g2.fillRect(75,85,300,300);

      for(int r=0; r<4; r++){
        for(int c=0; c<4; c++){
           drawDarkTiles(g, board.board[r][c], c * 75 + 80, r * 75 + 90);
        }
      }

      if(board.isWin()){
        gameMessage = "You win!!";
        g2.drawString(gameMessage, 205, 400);
      }

      if(board.gameOver()){
        g2.setColor(Color.red);
        gameMessage = "Game Over";
        g2.drawString(gameMessage, 187, 400);
        g2.setColor(Color.black);
      }
      //rainbow mdoe
    }else if(mode.equals("rainbow")){
      g2.setColor(Color.pink);
      g2.fillRect(0,0,450,450);
      
      g2.setColor(Color.white);
      g2.drawString("2048", 205, 20);
      g2.drawString("Press Enter to Start", 160, 40);
      g2.drawString("Score: "+board.getScore(), 130, 70);
      g2.drawString("Highest Tile: "+board.getHighTile(),215,70);
      g2.drawString("L=Light Mode",5,20);
      g2.drawString("D=Dark Mode",5,35);
      g2.drawString("R=Rainbow Mode",5,50);
      g2.drawString("C=Cupcake Mode",5,65);

      g2.drawString("1=8",5,95);
      g2.drawString("2=16",5,110);
      g2.drawString("3=32",5,125);
      g2.drawString("4=64",5,140);
      g2.drawString("5=128",5,155);
      g2.drawString("6=256",5,170);
      g2.drawString("7=512",5,185);
      g2.drawString("8=1024",5,200);
      g2.drawString("9=2048",5,215);
      
      g2.setColor(Color.lightGray);
      g2.fillRect(75,85,300,300);

      for(int r=0; r<4; r++){
        for(int c=0; c<4; c++){
           drawRainbowTiles(g, board.board[r][c], c * 75 + 80, r * 75 + 90);
        }
      }

      if(board.isWin()){
        gameMessage = "You win!!";
        g2.drawString(gameMessage, 205, 400);
      }

      if(board.gameOver()){
        g2.setColor(Color.red);
        gameMessage = "Game Over";
        g2.drawString(gameMessage, 187, 400);
        g2.setColor(Color.black);
      }
    }
      //cupcake mode
    else if(mode.equals("cupcake")){
      Color color = new Color(209,245,252);
      g2.setColor(color);
      g2.fillRect(0,0,450,450);
      
      g2.setColor(Color.black);
      g2.drawString("2048", 205, 20);
      g2.drawString("Press Enter to Start", 160, 40);
      g2.drawString("Score: "+board.getScore(), 130, 70);
      g2.drawString("Highest Tile: "+board.getHighTile(),215,70);
      g2.drawString("L=Light Mode",5,20);
      g2.drawString("D=Dark Mode",5,35);
      g2.drawString("R=Rainbow Mode",5,50);
      g2.drawString("C=Cupcake Mode",5,65);

      g2.drawString("1=8",5,95);
      g2.drawString("2=16",5,110);
      g2.drawString("3=32",5,125);
      g2.drawString("4=64",5,140);
      g2.drawString("5=128",5,155);
      g2.drawString("6=256",5,170);
      g2.drawString("7=512",5,185);
      g2.drawString("8=1024",5,200);
      g2.drawString("9=2048",5,215);
      
      g2.setColor(Color.lightGray);
      g2.fillRect(75,85,300,300);

      for(int r=0; r<4; r++){
        for(int c=0; c<4; c++){
           drawCupcakeTiles(g, board.board[r][c], c * 75 + 80, r * 75 + 90);
        }
      }

      if(board.isWin()){
        gameMessage = "You win!!";
        g2.setColor(Color.black);
        g2.drawString(gameMessage, 205, 400);
      }

      if(board.gameOver()){
        g2.setColor(Color.red);
        gameMessage = "Game Over";
        g2.drawString(gameMessage, 187, 400);
        g2.setColor(Color.black);
      }
    }
  }

  public void drawTiles(Graphics g, Tile tile, int x, int y){
    int tileVal = tile.getValue();
    int length = String.valueOf(tileVal).length();
    Graphics2D g2 = (Graphics2D)g;
    
    g2.setColor(Color.white);
    g2.fillRect(x, y, 65, 65);
    g2.setColor(Color.black);
    
    if(tileVal == 0){
      g.drawString( "", x + 30 - 3 * length, y + 35);
    }else{
      g2.setColor(tile.getColor());
      g2.fillRect(x, y, 65, 65);
      g2.setColor(Color.black);
      g.drawString(tile.toString(), x + 30 - 3 * length, y + 35);
    }
  }

  public void drawDarkTiles(Graphics g, Tile tile, int x, int y){
    int tileVal = tile.getValue();
    int length = String.valueOf(tileVal).length();
    Graphics2D g2 = (Graphics2D)g;
    
    g2.setColor(Color.gray);
    g2.fillRect(x, y, 65, 65);
    
    if(tileVal == 0){
      g.drawString("", x + 30 - 3 * length, y + 35);
    }else{
      g2.setColor(tile.getDarkColor());
      g2.fillRect(x, y, 65, 65);
      g2.setColor(Color.white);
      g.drawString(tile.toString(), x + 30 - 3 * length, y + 35);
    }
  }

  public void drawRainbowTiles(Graphics g, Tile tile, int x, int y){
    int tileVal = tile.getValue();
    int length = String.valueOf(tileVal).length();
    Graphics2D g2 = (Graphics2D)g;
    
    g2.setColor(Color.white);
    g2.fillRect(x, y, 65, 65);
    
    if(tileVal == 0){
      g.drawString("", x + 30 - 3 * length, y + 35);
    }else{
      g2.setColor(tile.getRainbowColor());
      g2.fillRect(x, y, 65, 65);
      g2.setColor(Color.white);
      g.drawString(tile.toString(), x + 30 - 3 * length, y + 35);
    }
  }

  public void drawCupcakeTiles(Graphics g, Tile tile, int x, int y){
    int tileVal = tile.getValue();
    int length = String.valueOf(tileVal).length();
    Graphics2D g2 = (Graphics2D)g;
    Color color;
    
    g2.setColor(Color.white);
    g2.fillRect(x, y, 65, 65);
    
    if(tileVal == 0){
      g.drawString("", x + 30 - 3 * length, y + 35);
    }else if(tileVal == 2){
      g2.setColor(Color.black);
      int[] polyX = {x+20,x+15,x+50};
      int[] polyY = {y+50,y+30,y+30};
      g2.fillPolygon(polyX, polyY, 3);
      int[] polyX2 = {x+20,x+50,x+45};
      int[] polyY2= {y+50,y+30,y+50};
      g2.fillPolygon(polyX2, polyY2, 3);
      g2.drawArc(x+15,y+20,35,20,0,180);
    }else if(tileVal == 4){
      g2.setColor(Color.black);
      int[] polyX = {x+20,x+15,x+50};
      int[] polyY = {y+50,y+30,y+30};
      g2.fillPolygon(polyX, polyY, 3);
      int[] polyX2 = {x+20,x+50,x+45};
      int[] polyY2= {y+50,y+30,y+50};
      g2.fillPolygon(polyX2, polyY2, 3);
      g2.setColor(Color.red);
      g2.fillArc(x+15,y+20,35,20,0,180);
    }else if(tileVal == 8){
      g2.setColor(Color.black);
      int[] polyX = {x+20,x+15,x+50};
      int[] polyY = {y+50,y+30,y+30};
      g2.fillPolygon(polyX, polyY, 3);
      int[] polyX2 = {x+20,x+50,x+45};
      int[] polyY2= {y+50,y+30,y+50};
      g2.fillPolygon(polyX2, polyY2, 3);
      g2.setColor(Color.blue);
      g2.fillArc(x+15,y+15,35,30,0,180);
      color = new Color(245,245,0);
      g2.setColor(color);
      g2.drawArc(x+15,y+15,35,30,0,180);
    }else if(tileVal == 16){
      g2.setColor(Color.black);
      int[] polyX = {x+20,x+15,x+50};
      int[] polyY = {y+50,y+30,y+30};
      g2.fillPolygon(polyX, polyY, 3);
      int[] polyX2 = {x+20,x+50,x+45};
      int[] polyY2= {y+50,y+30,y+50};
      g2.fillPolygon(polyX2, polyY2, 3);
      color = new Color(0,68,7);
      g2.setColor(color);
      g2.fillArc(x+15,y+15,35,30,0,180);
      color = new Color(174,168,0);
      g2.setColor(color);
      g2.drawArc(x+15,y+15,35,30,0,180);
    }else if(tileVal == 32){
      color = new Color(159,2,108);
      g2.setColor(color);
      int[] polyX = {x+20,x+15,x+50};
      int[] polyY = {y+50,y+30,y+30};
      g2.fillPolygon(polyX, polyY, 3);
      int[] polyX2 = {x+20,x+50,x+45};
      int[] polyY2= {y+50,y+30,y+50};
      g2.fillPolygon(polyX2, polyY2, 3);
      color = new Color(255,171,253);
      g2.setColor(color);
      g2.fillArc(x+15,y+20,35,20,0,180);
      g2.fillArc(x+18,y+15,29,17,0,180);
      g2.fillArc(x+22,y+10,21,15,0,180);
    }else if(tileVal == 64){
      g2.setColor(Color.black);
      int[] polyX = {x+20,x+15,x+50};
      int[] polyY = {y+50,y+30,y+30};
      g2.fillPolygon(polyX, polyY, 3);
      int[] polyX2 = {x+20,x+50,x+45};
      int[] polyY2= {y+50,y+30,y+50};
      g2.fillPolygon(polyX2, polyY2, 3);
      g2.setColor(Color.yellow);
      g2.fillArc(x+15,y+15,35,30,0,180);
      color = new Color(245,245,0);
      g2.setColor(color);
      g2.drawArc(x+15,y+15,35,30,0,180);
      g2.setColor(Color.red);
      g2.fillArc(x+30,y+12,8,8,0,360);
      g2.drawArc(x+35,y+9,10,10,100,80);
    }else if(tileVal == 128){
      color = new Color(59,2,108);
      g2.setColor(color);
      int[] polyX = {x+20,x+15,x+50};
      int[] polyY = {y+50,y+30,y+30};
      g2.fillPolygon(polyX, polyY, 3);
      int[] polyX2 = {x+20,x+50,x+45};
      int[] polyY2= {y+50,y+30,y+50};
      g2.fillPolygon(polyX2, polyY2, 3);
      color = new Color(145,223,255);
      g2.setColor(color);
      g2.fillArc(x+15,y+20,35,20,0,180);
      g2.fillArc(x+18,y+15,29,17,0,180);
      g2.fillArc(x+22,y+10,21,15,0,180);
    }else if(tileVal == 256){
      g2.setColor(Color.black);
      int[] polyX = {x+20,x+15,x+50};
      int[] polyY = {y+50,y+30,y+30};
      g2.fillPolygon(polyX, polyY, 3);
      int[] polyX2 = {x+20,x+50,x+45};
      int[] polyY2= {y+50,y+30,y+50};
      g2.fillPolygon(polyX2, polyY2, 3);
      color = new Color(200,200,200);
      g2.drawArc(x+15,y+20,35,20,0,180);
      g2.setColor(color);
      g2.fillArc(x+15,y+20,35,20,0,180);
      g2.setColor(Color.black);
      g2.drawArc(x+18,y+15,29,17,0,180);
      g2.setColor(color);
      g2.fillArc(x+18,y+15,29,17,0,180);
      g2.setColor(Color.black);
      g2.drawArc(x+22,y+12,21,10,0,180);
      g2.setColor(color);
      g2.fillArc(x+22,y+13,21,9,0,180);
      g2.setColor(Color.black);
      g2.drawString(".",x+25,y+25);
      g2.drawString(".",x+35,y+28);
      g2.drawString(".",x+23,y+20);
      g2.drawString(".",x+30,y+18);
      g2.drawString(".",x+40,y+22);
      g2.drawString(".",x+30,y+29);
      g2.drawString(".",x+25,y+25);
      g2.drawString(".",x+35,y+23);
      g2.drawString(".",x+21,y+28);
      g2.drawString(".",x+44,y+28);
    }else if(tileVal == 512){
      g2.setColor(Color.black);
      int[] polyX = {x+20,x+15,x+50};
      int[] polyY = {y+50,y+30,y+30};
      g2.fillPolygon(polyX, polyY, 3);
      int[] polyX2 = {x+20,x+50,x+45};
      int[] polyY2= {y+50,y+30,y+50};
      g2.fillPolygon(polyX2, polyY2, 3);
      g2.drawArc(x+15,y+20,35,20,0,180);
      g2.setColor(Color.white);
      g2.fillArc(x+15,y+20,35,20,0,180);
      g2.setColor(Color.black);
      g2.drawArc(x+18,y+15,29,17,0,180);
      g2.setColor(Color.white);
      g2.fillArc(x+18,y+15,29,17,0,180);
      g2.setColor(Color.black);
      g2.drawArc(x+22,y+12,21,10,0,180);
      g2.setColor(Color.white);
      g2.fillArc(x+22,y+13,21,9,0,180);
      g2.setColor(Color.red);
      g2.drawString(".",x+25,y+25);
      g2.setColor(Color.orange);
      g2.drawString(".",x+35,y+28);
      g2.setColor(Color.yellow);
      g2.drawString(".",x+23,y+20);
      g2.setColor(Color.green);
      g2.drawString(".",x+30,y+18);
      g2.setColor(Color.blue);
      g2.drawString(".",x+40,y+22);
      g2.setColor(Color.cyan);
      g2.drawString(".",x+30,y+29);
      g2.setColor(Color.pink);
      g2.drawString(".",x+25,y+25);
      g2.setColor(Color.magenta);
      g2.drawString(".",x+35,y+23);
      g2.setColor(Color.red);
      g2.drawString(".",x+21,y+28);
      g2.setColor(Color.orange);
      g2.drawString(".",x+44,y+28);
    }else if(tileVal == 1024){
      g2.setColor(Color.black);
      int[] polyX = {x+20,x+15,x+50};
      int[] polyY = {y+50,y+30,y+30};
      g2.fillPolygon(polyX, polyY, 3);
      int[] polyX2 = {x+20,x+50,x+45};
      int[] polyY2= {y+50,y+30,y+50};
      g2.fillPolygon(polyX2, polyY2, 3);
      color = new Color(153,204,255);
      g2.setColor(color);
      g2.drawArc(x+15,y+20,35,20,0,180);
      g2.fillArc(x+15,y+20,35,20,0,180);
      g2.drawArc(x+18,y+15,29,17,0,180);
      g2.fillArc(x+18,y+15,29,17,0,180);
      g2.drawArc(x+22,y+12,21,10,0,180);
      g2.fillArc(x+22,y+13,21,9,0,180);
      color = new Color(239,218,28);
      g2.setColor(color);
      int[] polyX3 = {x+33,x+36,x+42,x+38,x+42,x+33,x+24,x+28,x+24,x+30};
      int[] polyY3 = {y+2,y+9,y+9,y+15,y+21,y+17,y+21,y+15,y+9,y+9};
      g2.fillPolygon(polyX3,polyY3,10);
    }else if(tileVal == 2048){
      g2.setColor(Color.black);
      int[] polyX = {x+20,x+15,x+50};
      int[] polyY = {y+50,y+30,y+30};
      g2.fillPolygon(polyX, polyY, 3);
      int[] polyX2 = {x+20,x+50,x+45};
      int[] polyY2= {y+50,y+30,y+50};
      g2.fillPolygon(polyX2, polyY2, 3);
      g2.setColor(Color.black);
      g2.drawArc(x+15,y+15,35,30,0,180);
      g2.setColor(Color.red);
      g2.fillRect(x+15,y+25,5,5);
      int[] polyX3 = {x+15,x+20,x+20} ;
      int[] polyY3 = {y+25,y+25,y+18};
      g2.fillPolygon(polyX3,polyY3,3);
      color = new Color(255,154,0);
      g2.setColor(color);
      g2.fillRect(x+20,y+20,5,10);
      int[] polyX4 = {x+20,x+25,x+25} ;
      int[] polyY4 = {y+20,y+20,y+15};
      g2.fillPolygon(polyX4,polyY4,3);
      g2.setColor(Color.yellow);
      g2.fillRect(x+25,y+18,5,12);
      int[] polyX5 = {x+25,x+30,x+30,x+25} ;
      int[] polyY5 = {y+18,y+18,y+14,y+15};
      g2.fillPolygon(polyX5,polyY5,4);
      color = new Color(0,168,28);
      g2.setColor(color);
      g2.fillRect(x+30,y+15,5,15);
      color = new Color(0,111,255);
      g2.setColor(color);
      int[] polyX6 = {x+35,x+40,x+40,x+35};
      int[] polyY6 = {y+18,y+18,y+15,y+14};
      g2.fillPolygon(polyX6,polyY6,4);
      g2.fillRect(x+35,y+18,5,12);
      color = new Color(154,0,255);
      g2.setColor(color);
      g2.fillRect(x+40,y+20,5,10);
      int[] polyX7 = {x+45,x+40,x+40} ;
      int[] polyY7 = {y+20,y+20,y+14};
      g2.fillPolygon(polyX7,polyY7,3);
      color = new Color(255,127,255);
      g2.setColor(color);
      g2.fillRect(x+45,y+25,5,5);
      int[] polyX8 = {x+45,x+50,x+45} ;
      int[] polyY8 = {y+25,y+25,y+18};
      g2.fillPolygon(polyX8,polyY8,3);
      }
  }

  public static void main(String[] arguments){
    setUpGUI();
	}
  
}