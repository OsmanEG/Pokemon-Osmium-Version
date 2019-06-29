/*******************************************************                                               
  * Osman El-Ghotmi                                    *
  * Pokemon Osmium Version                             *
  * Cairine Wilson S.S.                                *
  * ICS4U Computer Science Course                      *
  * ****************************************************/
import java.util.Random;
import javax.swing.JFrame; //Imports
import java.awt.image.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PokemonOsmiumVersion extends JFrame 
{
  static Character enemyArticuno = new Character(0);
  static Character enemyMoltres = new Character(1);
  static Character enemyZapdos = new Character(2);
  static Character enemyMewtwo = new Character(3);
  static boolean battle = false;
  static boolean charizardParalyzed=false;
  static double charizardAttack;
  static double enemyAttack;
  static double charizardHealth;
  static double enemyHealth;
  static double charizardAttackBoost=1;
  static double enemyAttackBoost=1;
  static boolean pokemon1Defeated=false;
  static boolean pokemon2Defeated=false;
  static boolean pokemon3Defeated=false;
  static int upWalk=0;
  static int sideWalk=0;
  static int positionY = 0;
  static int positionX = 0;
  static JCanvas canvas = new JCanvas();
  static BufferedImage gbaLayout = canvas.loadImage("gba.png.png");
  static BufferedImage screenGrass = canvas.loadImage("routeImage.png");
  static BufferedImage redForward = canvas.loadImage("redForward.png");
  static BufferedImage redBackward = canvas.loadImage("redBackward.png");
  static BufferedImage redLeft = canvas.loadImage("redLeft.png");
  static BufferedImage redRight = canvas.loadImage("redRight.png");
  static BufferedImage battleLayout = canvas.loadImage("battleLayout.png");
  static BufferedImage megaCharizard = canvas.loadImage("megaCharizard.png");
  static BufferedImage articuno = canvas.loadImage("articuno.png");
  static BufferedImage moltres = canvas.loadImage("moltres.png");
  static BufferedImage zapdos = canvas.loadImage("zapdos.png");
  static BufferedImage cave = canvas.loadImage("cave.png");
  static BufferedImage mewtwoSprite = canvas.loadImage("mewtwoSprite.png");
  static BufferedImage mewtwo = canvas.loadImage("mewtwo.png");
  static BufferedImage mewtwoArena = canvas.loadImage("mewtwoArena.png");
  static BufferedImage textbox = canvas.loadImage("textbox.png");
  static BufferedImage winScreen = canvas.loadImage("winScreen.jpg");
  static JFrame pokeBorder = new JFrame("Pokemon Osmium Version");
  static boolean canMove = true;
  static boolean mewtwoCave = false;
  static int mewtwoCaveY=0;
  static boolean mewtwoEngage = false;
  static boolean charizardConfused = false;
  static String actionText = "Find and defeat the three legendray birds, as well as a mystery enemy!";
  static String yourAction = "...";
  static String enemyAction = "...";
  
  
  public static void main(String[]args)
  {
    PokemonOsmiumVersion myGame = new PokemonOsmiumVersion();
  }
  
  public static void gameReset()
  {
    actionText="YOU BEAT MEWTWO!!! You truly are Red...";
    yourAction="...the very best";
    enemyAction="Play Again? Press any key to continue!";
    mewtwoEngage=false;
    mewtwoCave=false;
    mewtwoCaveY=0;
    upWalk=0;
    sideWalk=0;
    positionY = 0;
    positionX = 0;
    battle=false;
    pokemon1Defeated=false;
    pokemon2Defeated=false;
    pokemon3Defeated=false;
    canMove=true;
    charizardHealth=100;
    enemyHealth=0;
    charizardAttackBoost=1;
    charizardConfused=false;
    charizardParalyzed=false;
    canvas.startBuffer();
    pokemonBattle();
    canvas.startBuffer();
    canvas.clear();
    canvas.drawImage(gbaLayout,-425,-75); 
    canvas.drawImage(winScreen,20,20);
    canvas.drawImage(textbox,7,555);
    canvas.drawOutline(actionText,20,580);
    canvas.drawOutline(yourAction,20,600);
    canvas.drawOutline(enemyAction,20,620);
    canvas.endBuffer();
  }
  
  public PokemonOsmiumVersion()
  {
    pokeBorder.setSize(450,700);
    pokeBorder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    canvas.setBackground(Color.gray);
    canvas.drawImage(gbaLayout,-425,-75); 
    canvas.drawImage(screenGrass,20,20);
    canvas.drawImage(redForward,126+positionX,20+positionY);
    canvas.drawImage(textbox,7,555);
    canvas.drawOutline(actionText,20,580);
    canvas.drawOutline(yourAction,20,600);
    canvas.drawOutline(enemyAction,20,620);
    pokeBorder.add(canvas);
    DirectionKeys direction = new DirectionKeys();
    pokeBorder.addKeyListener(direction);
    pokeBorder.setFocusable(true);
    pokeBorder.setVisible(true);
  }
  
  public static void mewtwoBattle()
  {
    canvas.startBuffer();
    canvas.clear();
    canvas.drawImage(gbaLayout,-425,-75);
    canvas.drawImage(cave,20,20);
    canvas.drawImage(mewtwoSprite,200,100);
    canvas.drawImage(redBackward,210,180+mewtwoCaveY);
    canvas.drawImage(textbox,7,555);
    canvas.drawOutline(actionText,20,580);
    canvas.drawOutline(yourAction,20,600);
    canvas.drawOutline(enemyAction,20,620);
    canvas.endBuffer();
    if(mewtwoCaveY <= -51)
    {
      actionText = "GET READY, YOUR FIGHTING MEGA MEWTWO Y!";
      mewtwoEngage=true;
    }
    if(mewtwoEngage==true)
    {
      enemyHealth=enemyMewtwo.h;
      mewtwoBattleEngaged();
    }
  }
  
  public class DirectionKeys implements KeyListener
  {
    public void keyPressed (KeyEvent e)
    {
      Random pokemonBattle = new Random();
      int pokemonEncounter = pokemonBattle.nextInt(100);
      int check = e.getKeyCode();
      if(check==KeyEvent.VK_UP)
      {
        canvas.startBuffer();
        canvas.clear();
        upWalk = -3;
        sideWalk = 0;
        if(battle==true)
        {
          canMove=false;
        }
        if(mewtwoCave == true && mewtwoEngage == false)
        {
          mewtwoCaveY = mewtwoCaveY-3;
          canMove=false;
          mewtwoBattle();
          //System.out.println(mewtwoCaveY);
        }
        if(positionX > 75 && positionX < 126 && positionY == 42)
        {
          canMove=false;
        }
        if(positionX > -9 && positionX < 42 && positionY == 63)
        {
          canMove=false;
        }
        if(positionX > -45 && positionX < 9 && positionY == 117)
        {
          canMove=false;
        }
        if(positionX > 153 && positionX < 204 && positionY == 114)
        {
          canMove=false;
        }
        if(positionX >24 && positionX < 48 && positionY == 111)
        {
          canMove=false;
        }
        if(positionX > 57 && positionX < 72 && positionY == 111)
        {
          canMove=false;
        }
        if(positionX >93 && positionX < 126 && positionY == 96)
        {
          canMove=false;
        }
        if(positionX >=42 && positionX <= 93 && positionY == 75)
        {
          canMove=false;
        }
        if(positionX >105 && positionX <= 252 && positionY == 147)
        {
          canMove=false;
        }
        if(positionX >=-93 && positionX < 96 && positionY == 147)
        {
          canMove=false;
        }
        if(positionX >=-18 && positionX < 216 && positionY == 243)
        {
          canMove=false;
        }
        if(positionY !=6 && positionY !=-3 && canMove == true)
        {
          positionY = positionY + upWalk;
          positionX = positionX + sideWalk;
        }
        if(pokemonEncounter ==10)
        {
          battle=true;
          if(pokemon1Defeated==false && pokemon2Defeated==false && pokemon3Defeated==false && battle==true)
          {
            actionText = "What's this? Your fighting Articuno!";
            enemyHealth=enemyArticuno.h;
            charizardHealth=100;
            pokemonBattle();
          }
          if(pokemon1Defeated==true && pokemon2Defeated==false && pokemon3Defeated==false && battle==true)
          {
            actionText = "What's this? Your fighting Moltres!";
            enemyHealth=enemyMoltres.h;
            charizardHealth=100;
            pokemonBattle();
          }
          if(pokemon1Defeated==true && pokemon2Defeated==true && pokemon3Defeated==false && battle==true)
          {
            actionText = "What's this? Your fighting Zapdos!";
            enemyHealth=enemyZapdos.h;
            charizardHealth=100;
            pokemonBattle();
          }
          if(pokemon1Defeated==true && pokemon2Defeated==true && pokemon3Defeated==true && battle==true)
          {
            battle=false;
          }
        }
        if(battle==false && mewtwoCave==false)
        {
          canvas.drawImage(gbaLayout,-425,-75); 
          canvas.drawImage(screenGrass,20,20);
          canvas.drawImage(redBackward,126+positionX,20+positionY);
          canvas.drawImage(textbox,7,555);
          canvas.drawOutline(actionText,20,580);
          canvas.drawOutline(yourAction,20,600);
          canvas.drawOutline(enemyAction,20,620);
          canvas.endBuffer();
          canMove=true;
        }
        //System.out.println(positionX + "," + positionY);
        
      }
      if(check==KeyEvent.VK_DOWN)
      {
        canvas.startBuffer();
        canvas.clear();
        upWalk = 3;
        sideWalk = 0;
        if(battle==true)
        {
          canMove=false;
        }
        if(mewtwoCave == true)
        {
          canMove=false;
        }
        if(positionX > -9 && positionX < 42 && positionY == 24)
        {
          canMove=false;
        }
        if(positionX > -45 && positionX < 9 && positionY == 75)
        {
          canMove=false;
        }
        if(positionX > 153 && positionX < 204 && positionY == 72)
        {
          canMove=false;
        }
        if(positionX > 21 && positionX < 147 && positionY == 63)
        {
          canMove=false;
        }
        if(positionX >= -93 && positionX < 69 && positionY == 117)
        {
          canMove=false;
        }
        if(positionX >= 147 && positionX <= 252 && positionY == 117)
        {
          canMove=false;
        }
        if(positionX >= 42 && positionX < 48 && positionY == 93)
        {
          canMove=false;
        }
        if(positionX >= 60 && positionX < 87 && positionY == 96)
        {
          canMove=false;
        }
        if(positionX >= 123 && positionX < 129 && positionY == 87)
        {
          canMove=false;
        }
        if(positionX > -18 && positionX < 216 && positionY == 204)
        {
          canMove=false;
        }
        if(positionX < 96 && positionY == 129)
        {
          canMove=false;
        }
        if(positionX > 105 && positionY == 129)
        {
          canMove=false;
        }
        if(positionX == 93 && positionY == 129)
        {
          canMove=false;
        }
        if(positionY != 270  && canMove==true)
        {
          positionY = positionY + upWalk;
          positionX = positionX + sideWalk;
        }
        if(pokemonEncounter ==10)
        {
          battle=true;
          if(pokemon1Defeated==false && pokemon2Defeated==false && pokemon3Defeated==false && battle==true)
          {
            actionText = "What's this? Your fighting Articuno!";
            enemyHealth=enemyArticuno.h;
            charizardHealth=100;
            pokemonBattle();
          }
          if(pokemon1Defeated==true && pokemon2Defeated==false && pokemon3Defeated==false && battle==true)
          {
            actionText = "What's this? Your fighting Moltres!";
            enemyHealth=enemyMoltres.h;
            charizardHealth=100;
            pokemonBattle();
          }
          if(pokemon1Defeated==true && pokemon2Defeated==true && pokemon3Defeated==false && battle==true)
          {
            actionText = "What's this? Your fighting Zapdos!";
            enemyHealth=enemyZapdos.h;
            charizardHealth=100;
            pokemonBattle();
          }
          if(pokemon1Defeated==true && pokemon2Defeated==true && pokemon3Defeated==true && battle==true)
          {
            battle=false;
          }
        }
        if(battle==false && mewtwoCave==false)
        {
          canvas.drawImage(gbaLayout,-425,-75); 
          canvas.drawImage(screenGrass,20,20);
          canvas.drawImage(redForward,126+positionX,20+positionY);
          canvas.drawImage(textbox,7,555);
          canvas.drawOutline(actionText,20,580);
          canvas.drawOutline(yourAction,20,600);
          canvas.drawOutline(enemyAction,20,620);
          canvas.endBuffer();
          canMove=true;
        }
        //System.out.println(positionX + "," + positionY);
      }
      if(check==KeyEvent.VK_LEFT)
      {
        canvas.startBuffer();
        canvas.clear();
        upWalk = 0;
        sideWalk = -3;
        if(battle==true)
        {
          canMove=false;
        }
        if(mewtwoCave == true)
        {
          canMove=false;
        }
        if(positionX == 42 && positionY > 24 && positionY < 63)
        {
          canMove=false;
        }
        if(positionX == 9 && positionY > 75 && positionY < 117)
        {
          canMove=false;
        }
        if(positionX == 204 && positionY > 72 && positionY < 114)
        {
          canMove=false;
        }
        if(positionX == 147 && positionY > 63 && positionY < 120)
        {
          canMove=false;
        }
        if(positionX == 48 && positionY > 72 && positionY <= 108)
        {
          canMove=false;
        }
        if(positionX == 87 && positionY > 96 && positionY <= 129)
        {
          canMove=false;
        }
        if(positionX == 216 && positionY > 204 && positionY <= 242)
        {
          canMove=false;
        }
        if(positionX == 96 && positionY >= 132 && positionY <= 144)
        {
          canMove=false;
        }
        if(positionX==126 && positionY<42)
        {
          canMove=false;
        }
        if(positionX !=-93 && canMove==true)
        {
          positionY = positionY + upWalk;
          positionX = positionX + sideWalk;
        }
        if(pokemonEncounter ==10)
        {
          battle=true;
          if(pokemon1Defeated==false && pokemon2Defeated==false && pokemon3Defeated==false && battle==true)
          {
            actionText = "What's this? Your fighting Articuno!";
            enemyHealth=enemyArticuno.h;
            charizardHealth=100;
            pokemonBattle();
          }
          if(pokemon1Defeated==true && pokemon2Defeated==false && pokemon3Defeated==false && battle==true)
          {
            actionText = "What's this? Your fighting Moltres!";
            enemyHealth=enemyMoltres.h;
            charizardHealth=100;
            pokemonBattle();
          }
          if(pokemon1Defeated==true && pokemon2Defeated==true && pokemon3Defeated==false && battle==true)
          {
            actionText = "What's this? Your fighting Zapdos!";
            enemyHealth=enemyZapdos.h;
            charizardHealth=100;
            pokemonBattle();
          }
          if(pokemon1Defeated==true && pokemon2Defeated==true && pokemon3Defeated==true && battle==true)
          {
            battle=false;
          }
        }
        if(battle==false && mewtwoCave==false)
        {
          canvas.drawImage(gbaLayout,-425,-75); 
          canvas.drawImage(screenGrass,20,20);
          canvas.drawImage(redLeft,126+positionX,20+positionY);
          canvas.drawImage(textbox,7,555);
          canvas.drawOutline(actionText,20,580);
          canvas.drawOutline(yourAction,20,600);
          canvas.drawOutline(enemyAction,20,620);
          canvas.endBuffer();
          canMove=true;
        }
        //System.out.println(positionX + "," + positionY);
      }
      if(check==KeyEvent.VK_RIGHT)
      {
        canvas.startBuffer();
        canvas.clear();
        upWalk = 0;
        sideWalk = 3;
        if(battle==true)
        {
          canMove=false;
        }
        if(mewtwoCave == true)
        {
          canMove=false;
        }
        if(positionX == -9 && positionY > 24 && positionY < 63)
        {
          canMove=false;
        }
        if(positionX == -45 && positionY > 75 && positionY < 117)
        {
          canMove=false;
        }
        if(positionX == 153 && positionY > 72 && positionY < 114)
        {
          canMove=false;
        }
        if(positionX == 21 && positionY > 63 && positionY < 117)
        {
          canMove=false;
        }
        if(positionX == 69 && positionY > 111 && positionY < 117)
        {
          canMove=false;
        }
        if(positionX == 66 && positionY > 111 && positionY <= 117)
        {
          canMove=false;
        }
        if(positionX == 93 && positionY > 72 && positionY < 96)
        {
          canMove=false;
        }
        if(positionX == 123 && positionY >= 96 && positionY <= 129)
        {
          canMove=false;
        }
        if(positionX == -18 && positionY > 204 && positionY < 243)
        {
          canMove=false;
        }
        if(positionX == 105 && positionY >= 132 && positionY <= 144)
        {
          canMove=false;
        }
        if(positionX == 57 && positionY > 96 && positionY < 114)
        {
          canMove=false;
        }
        if(positionX==75 && positionY<42)
        {
          canMove=false;
        }
        if(positionX != 252  && canMove==true)
        {
          positionY = positionY + upWalk;
          positionX = positionX + sideWalk;
        }
        if(pokemonEncounter == 10)
        {
          battle=true;
          if(pokemon1Defeated==false && pokemon2Defeated==false && pokemon3Defeated==false && battle==true)
          {
            actionText = "What's this? Your fighting Articuno!";
            enemyHealth=enemyArticuno.h;
            charizardHealth=100;
            pokemonBattle();
          }
          if(pokemon1Defeated==true && pokemon2Defeated==false && pokemon3Defeated==false && battle==true)
          {
            actionText = "What's this? Your fighting Moltres!";
            enemyHealth=enemyMoltres.h;
            charizardHealth=100;
            pokemonBattle();
          }
          if(pokemon1Defeated==true && pokemon2Defeated==true && pokemon3Defeated==false && battle==true)
          {
            actionText = "What's this? Your fighting Zapdos!";
            enemyHealth=enemyZapdos.h;
            charizardHealth=100;
            pokemonBattle();
          }
          if(pokemon1Defeated==true && pokemon2Defeated==true && pokemon3Defeated==true && battle==true)
          {
            battle=false;
          }
        }
        if(battle==false && mewtwoCave==false)
        {
          canvas.drawImage(gbaLayout,-425,-75); 
          canvas.drawImage(screenGrass,20,20);
          canvas.drawImage(redRight,126+positionX,20+positionY);
          canvas.drawImage(textbox,7,555);
          canvas.drawOutline(actionText,20,580);
          canvas.drawOutline(yourAction,20,600);
          canvas.drawOutline(enemyAction,20,620);
          canvas.endBuffer();
          canMove=true;
        }
        //System.out.println(positionX + "," + positionY);
      }
      
    }
    public void keyReleased (KeyEvent e)
    {
    }
    public void keyTyped (KeyEvent e)
    {
      if(pokemon1Defeated==false && pokemon2Defeated==false && pokemon3Defeated==false && battle==true)
      {
        if(e.getKeyChar()=='1' && battle==true)
        {
          charizardAttack=0;
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          if(enemyArticuno.an[i]=="Fly")
          {
            charizardAttack=0;
          }
          yourAction="Charizard used Dragon Dance: Attack ^ 35%";
          enemyAction="Articuno used " + enemyArticuno.an[i]; 
          charizardAttackBoost=charizardAttackBoost*1.35;
          charizardHealth=charizardHealth-enemyArticuno.a[i];
          pokemonBattle();
        }
        if(e.getKeyChar()=='2' && battle==true)
        {
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          charizardAttack=3;
          if(enemyArticuno.an[i]=="Fly")
          {
            charizardAttack=0;
          }
          yourAction="Charizard used Outrage";
          enemyAction="Articuno used " + enemyArticuno.an[i]; 
          enemyHealth=enemyHealth-charizardAttack*charizardAttackBoost;
          charizardHealth=charizardHealth-enemyArticuno.a[i];
          pokemonBattle();
        }
        if(e.getKeyChar()=='3' && battle==true)
        {
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          charizardAttack=10;
          if(enemyArticuno.an[i]=="Fly")
          {
            charizardAttack=0;
          }
          yourAction="Charizard used Fire Fang";
          enemyAction="Articuno used " + enemyArticuno.an[i]; 
          enemyHealth=enemyHealth-charizardAttack*charizardAttackBoost;
          charizardHealth=charizardHealth-enemyArticuno.a[i];
          pokemonBattle();
        }
        if(e.getKeyChar()=='4' && battle==true)
        {
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          charizardAttack=0;
          if(enemyArticuno.an[i]=="Fly")
          {
            charizardAttack=0;
          }
          yourAction="Charizard used Earthquake";
          enemyAction="Articuno used " + enemyArticuno.an[i]; 
          enemyHealth=enemyHealth-charizardAttack*charizardAttackBoost;
          charizardHealth=charizardHealth-enemyArticuno.a[i];
          pokemonBattle();
        }
        if(enemyHealth <= 0)
        {
          actionText="YOU BEAT ARTICUNO!";
          yourAction="...";
          enemyAction="...";
          battle=false;
          pokemon1Defeated=true;
          canMove=true;
          charizardHealth=100;
          enemyHealth=0;
          charizardAttackBoost=1;
          canvas.startBuffer();
          canvas.clear();
          canvas.drawImage(gbaLayout,-425,-75); 
          canvas.drawImage(screenGrass,20,20);
          canvas.drawImage(redLeft,126+positionX,20+positionY);
          canvas.drawImage(textbox,7,555);
          canvas.drawOutline(actionText,20,580);
          canvas.drawOutline(yourAction,20,600);
          canvas.drawOutline(enemyAction,20,620);
          canvas.endBuffer();
        }
        else if(charizardHealth <= 0)
        {
          actionText="ARTICUNO BEAT YOU!";
          yourAction="...";
          enemyAction="...";
          battle=false;
          pokemon1Defeated=false;
          canMove=true;
          charizardHealth=100;
          enemyHealth=0;
          charizardAttackBoost=1;
          canvas.startBuffer();
          canvas.clear();
          canvas.drawImage(gbaLayout,-425,-75); 
          canvas.drawImage(screenGrass,20,20);
          canvas.drawImage(redLeft,126+positionX,20+positionY);
          canvas.drawImage(textbox,7,555);
          canvas.drawOutline(actionText,20,580);
          canvas.drawOutline(yourAction,20,600);
          canvas.drawOutline(enemyAction,20,620);
          canvas.endBuffer();
        }
      }
      if(pokemon1Defeated==true && pokemon2Defeated==false && pokemon3Defeated==false && battle==true)
      { 
        if(e.getKeyChar()=='1' && battle==true)
        {
          charizardAttackBoost=charizardAttackBoost*1.35;
          yourAction="Charizard used Dragon Dance: Attack ^ 35%";
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          enemyAction="Moltres used " + enemyMoltres.an[i]; 
          charizardHealth=charizardHealth-enemyMoltres.a[i];
          pokemonBattle();
        }
        if(e.getKeyChar()=='2' && battle==true)
        {
          yourAction="Charizard used Outrage";
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          enemyAction="Moltres used " + enemyMoltres.an[i]; 
          enemyHealth=enemyHealth-7*charizardAttackBoost;
          charizardHealth=charizardHealth-enemyMoltres.a[i];
          pokemonBattle();
        }
        if(e.getKeyChar()=='3' && battle==true)
        {
          yourAction="Charizard used Fire Fang";
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          enemyAction="Moltres used " + enemyMoltres.an[i]; 
          enemyHealth=enemyHealth-2*charizardAttackBoost;
          charizardHealth=charizardHealth-enemyMoltres.a[i];
          pokemonBattle();
        }
        if(e.getKeyChar()=='4' && battle==true)
        {
          yourAction="Charizard used Earthquake";
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          enemyAction="Moltres used " + enemyMoltres.an[i]; 
          enemyHealth=enemyHealth-0*charizardAttackBoost;
          charizardHealth=charizardHealth-enemyMoltres.a[i];
          pokemonBattle();
        }
        if(enemyHealth <= 0)
        {
          actionText="YOU BEAT MOLTRES!";
          yourAction="...";
          enemyAction="...";
          battle=false;
          pokemon2Defeated=true;
          canMove=true;
          charizardHealth=100;
          enemyHealth=0;
          charizardAttackBoost=1;
          canvas.startBuffer();
          canvas.clear();
          canvas.drawImage(gbaLayout,-425,-75); 
          canvas.drawImage(screenGrass,20,20);
          canvas.drawImage(redLeft,126+positionX,20+positionY);
          canvas.drawImage(textbox,7,555);
          canvas.drawOutline(actionText,20,580);
          canvas.drawOutline(yourAction,20,600);
          canvas.drawOutline(enemyAction,20,620);
          canvas.endBuffer();
        }
        else if(charizardHealth <= 0)
        {
          actionText="MOLTRES BEAT YOU!";
          yourAction="...";
          enemyAction="...";
          battle=false;
          pokemon2Defeated=false;
          canMove=true;
          charizardHealth=100;
          enemyHealth=0;
          charizardAttackBoost=1;
          canvas.startBuffer();
          canvas.clear();
          canvas.drawImage(gbaLayout,-425,-75); 
          canvas.drawImage(screenGrass,20,20);
          canvas.drawImage(redLeft,126+positionX,20+positionY);
          canvas.drawImage(textbox,7,555);
          canvas.drawOutline(actionText,20,580);
          canvas.drawOutline(yourAction,20,600);
          canvas.drawOutline(enemyAction,20,620);
          canvas.endBuffer();
        }
      }
      if(pokemon1Defeated==true && pokemon2Defeated==true && pokemon3Defeated==false && battle==true)
      {
        if(e.getKeyChar()=='1' && battle==true)
        {
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          enemyAction="Zapdos used " + enemyZapdos.an[i]; 
          charizardHealth=charizardHealth-enemyZapdos.a[i];
          if(enemyZapdos.an[i]=="Roost")
          {
            enemyHealth=150;
          }
          if(enemyZapdos.an[i]=="Paralyze")
          {
            charizardParalyzed=true;
          }
          if(charizardParalyzed == false)
          {
            yourAction="Charizard used Dragon Dance: Attack ^ 35%";
            charizardAttackBoost=charizardAttackBoost*1.35;
          }
          for(i=0;i<3;i++)
          {
            Random paralyzeHeal = new Random();
            int j = paralyzeHeal.nextInt(4);
            if(j == i)
            {
              yourAction="Charizard is no longer paralyzed";
              charizardParalyzed=false;
            }
            else
            {
              yourAction="Charizard is paralyzed and unable to move";
            }
          }
          pokemonBattle();
        }
        if(e.getKeyChar()=='2' && battle==true)
        {
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          charizardHealth=charizardHealth-enemyZapdos.a[i];
          enemyAction="Zapdos used " + enemyZapdos.an[i]; 
          if(enemyZapdos.an[i]=="Roost")
          {
            enemyHealth=150;
          }
          if(enemyZapdos.an[i]=="Paralyze")
          {
            charizardParalyzed=true;
          }
          if(charizardParalyzed == false)
          {
            yourAction="Charizard used Outrage";
            enemyHealth=enemyHealth-15*charizardAttackBoost;
          }
          for(i=0;i<3;i++)
          {
            Random paralyzeHeal = new Random();
            int j = paralyzeHeal.nextInt(4);
            if(j == i)
            {
              yourAction="Charizard is no longer paralyzed";
              charizardParalyzed=false;
            }
            else
            {
              yourAction="Charizard is paralyzed and unable to move";
            }
          }
          pokemonBattle();
        }
        if(e.getKeyChar()=='3' && battle==true)
        {
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          enemyAction="Zapdos used " + enemyZapdos.an[i]; 
          if(enemyZapdos.an[i]=="Roost")
          {
            enemyHealth=150;
          }
          if(enemyZapdos.an[i]=="Paralyze")
          {
            charizardParalyzed=true;
          }
          charizardHealth=charizardHealth-enemyZapdos.a[i];
          if(charizardParalyzed == false)
          {
            yourAction="Charizard used Fire Fang";
            enemyHealth=enemyHealth-8*charizardAttackBoost;
          }
          for(i=0;i<3;i++)
          {
            Random paralyzeHeal = new Random();
            int j = paralyzeHeal.nextInt(4);
            if(j == i)
            {
              yourAction="Charizard is no longer paralyzed";
              charizardParalyzed=false;
            }
            else
            {
              yourAction="Charizard is paralyzed and unable to move";
            }
          }
          pokemonBattle();
        }
        if(e.getKeyChar()=='4' && battle==true)
        {
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          charizardHealth=charizardHealth-enemyZapdos.a[i];
          enemyAction="Zapdos used " + enemyZapdos.an[i]; 
          if(enemyZapdos.an[i]=="Roost")
          {
            enemyHealth=150;
          }
          if(enemyZapdos.an[i]=="Paralyze")
          {
            charizardParalyzed=true;
          }
          if(charizardParalyzed == false)
          {
            yourAction="Charizard used Earthquake";
            enemyHealth=enemyHealth-8*charizardAttackBoost;
          }
          enemyHealth=enemyHealth-0*charizardAttackBoost;
          pokemonBattle();
          for(i=0;i<3;i++)
          {
            Random paralyzeHeal = new Random();
            int j = paralyzeHeal.nextInt(4);
            if(j == i)
            {
              yourAction="Charizard is no longer paralyzed";
              charizardParalyzed=false;
            }
            else
            {
              yourAction="Charizard is paralyzed and unable to move";
            }
          }
        }
        if(charizardHealth <= 0)
        {
          actionText="ZAPDOS BEAT YOU!!!";
          yourAction="...";
          enemyAction="...";
          battle=false;
          pokemon3Defeated=false;
          canMove=true;
          charizardHealth=100;
          enemyHealth=0;
          charizardAttackBoost=1;
          charizardParalyzed=false;
          canvas.startBuffer();
          canvas.clear();
          canvas.drawImage(gbaLayout,-425,-75); 
          canvas.drawImage(screenGrass,20,20);
          canvas.drawImage(redLeft,126+positionX,20+positionY);
          canvas.drawImage(textbox,7,555);
          canvas.drawOutline(actionText,20,580);
          canvas.drawOutline(yourAction,20,600);
          canvas.drawOutline(enemyAction,20,620);
          canvas.endBuffer();
        }
        else if(enemyHealth <= 0)
        {
          actionText="YOU BEAT ZAPDOS!";
          yourAction="...";
          enemyAction="...";
          battle=false;
          pokemon3Defeated=true;
          canMove=true;
          charizardHealth=100;
          enemyHealth=0;
          charizardAttackBoost=1;
          charizardParalyzed=false;
          canvas.startBuffer();
          pokemonBattle();
        }
      }
      if(pokemon1Defeated==true && pokemon2Defeated==true && pokemon3Defeated==true && mewtwoEngage==true)
      {
        if(e.getKeyChar()=='1' && mewtwoEngage==true)
        {
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          charizardHealth=charizardHealth-enemyMewtwo.a[i];
          enemyAction="Mewtwo used " + enemyMewtwo.an[i]; 
          if(enemyMewtwo.an[i]=="Recover")
          {
            enemyHealth=200;
          }
          if(enemyMewtwo.an[i]=="Confusion")
          {
            charizardConfused=true;
            charizardHealth=charizardHealth-5;
          }
          if(charizardConfused == false)
          {
            yourAction="Charizard used Dragon Dance: Attack ^ 35%";
            charizardAttackBoost=charizardAttackBoost*1.35;
          }
          for(i=0;i<2;i++)
          {
            Random confusionHeal = new Random();
            int j = confusionHeal.nextInt(3);
            if(j == i)
            {
              yourAction="Charizard is no longer Confused";
              charizardConfused=false;
            }
          }
          mewtwoBattleEngaged();
        }
        if(e.getKeyChar()=='2' && mewtwoEngage==true)
        {
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          enemyAction="Mewtwo used " + enemyMewtwo.an[i]; 
          charizardHealth=charizardHealth-enemyMewtwo.a[i];
          if(enemyMewtwo.an[i]=="Recover")
          {
            enemyHealth=200;
          }
          if(enemyMewtwo.an[i]=="Confusion")
          {
            charizardConfused=true;
            charizardHealth=charizardHealth-5;
          }
          if(charizardConfused == false)
          {
            yourAction="Charizard used Outrage";
            enemyHealth=enemyHealth-0*charizardAttackBoost;
          }
          for(i=0;i<2;i++)
          {
            Random confusionHeal = new Random();
            int j = confusionHeal.nextInt(3);
            if(j == i)
            {
              yourAction="Charizard is no longer Confused";
              charizardConfused=false;
            }
          }
          mewtwoBattleEngaged();
        }
        if(e.getKeyChar()=='3' && mewtwoEngage==true)
        {
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          enemyAction="Mewtwo used " + enemyMewtwo.an[i]; 
          charizardHealth=charizardHealth-enemyMewtwo.a[i];
          if(enemyMewtwo.an[i]=="Recover")
          {
            enemyHealth=200;
          }
          if(enemyMewtwo.an[i]=="Confusion")
          {
            charizardConfused=true;
            charizardHealth=charizardHealth-5;
          }
          if(charizardConfused == false)
          {
            yourAction="Charizard used Fire Fang";
            enemyHealth=enemyHealth-20*charizardAttackBoost;
          }
          for(i=0;i<2;i++)
          {
            Random confusionHeal = new Random();
            int j = confusionHeal.nextInt(3);
            if(j == i)
            {
              yourAction="Charizard is no longer Confused";
              charizardConfused=false;
            }
          }
          mewtwoBattleEngaged();
        }
        if(e.getKeyChar()=='4' && mewtwoEngage==true)
        {
          Random enemyAttack = new Random();
          int i = enemyAttack.nextInt(4);
          enemyAction="Mewtwo used " + enemyMewtwo.an[i]; 
          charizardHealth=charizardHealth-enemyMewtwo.a[i];
          if(enemyMewtwo.an[i]=="Recover")
          {
            enemyHealth=200;
          }
          if(enemyMewtwo.an[i]=="Confusion")
          {
            charizardConfused=true;
            charizardHealth=charizardHealth-5;
          }
          if(charizardConfused == false)
          {
            yourAction="Charizard used Earthquake";
            enemyHealth=enemyHealth-15*charizardAttackBoost;
          }
          for(i=0;i<2;i++)
          {
            Random confusionHeal = new Random();
            int j = confusionHeal.nextInt(3);
            if(j == i)
            {
              yourAction="Charizard is no longer Confused";
              charizardConfused=false;
            }
          }
          mewtwoBattleEngaged();
        }
        if(charizardHealth <= 0)
        {
          actionText="MEWTWO BEAT YOU! TRY AGAIN!!!";
          yourAction="...";
          enemyAction="...";
          mewtwoEngage=false;
          mewtwoCaveY=0;
          battle=false;
          canMove=true;
          charizardHealth=100;
          enemyHealth=0;
          charizardAttackBoost=1;
          charizardConfused=false;
          mewtwoBattle();
        }
        else if(enemyHealth <= 0)
        {
          gameReset();
        }
      }
    }
  }
  
  public static void pokemonBattle()
  {
    canvas.endBuffer();
    
    if(pokemon1Defeated==false && pokemon2Defeated==false && pokemon3Defeated==false && battle==true)
    {
      canvas.startBuffer();
      canvas.clear();
      canvas.drawImage(gbaLayout,-425,-75); 
      canvas.drawImage(battleLayout,20,20); 
      canvas.drawImage(megaCharizard,40,100);
      canvas.drawImage(articuno,280,65);
      canvas.drawOutline("Articuno",120,75);
      canvas.drawOutline("MEGA CHARIZARD X",290,200);
      canvas.drawOutline("(1) DRAGON DANCE",75,290);
      canvas.drawOutline("(2) OUTRAGE",250,290);
      canvas.drawOutline("(3) FIRE FANG",75,315);
      canvas.drawOutline("(4) EARTHQUAKE",250,315);
      canvas.drawOutline("HP:" + (Double.toString(enemyHealth)),60,75);
      canvas.drawOutline("HP:" + charizardHealth,260,235);
      canvas.drawImage(textbox,7,555);
      canvas.drawOutline(actionText,20,580);
      canvas.drawOutline(yourAction,20,600);
      canvas.drawOutline(enemyAction,20,620);
      canvas.endBuffer();
    }
    if(pokemon1Defeated==true && pokemon2Defeated==false && pokemon3Defeated==false && battle==true)
    { 
      canvas.startBuffer();
      canvas.clear();
      canvas.drawImage(gbaLayout,-425,-75); 
      canvas.drawImage(battleLayout,20,20); 
      canvas.drawImage(megaCharizard,40,100);
      canvas.drawImage(moltres,280,65);
      canvas.drawOutline("Moltres",120,75);
      canvas.drawOutline("MEGA CHARIZARD X",290,200);
      canvas.drawOutline("(1) DRAGON DANCE",75,290);
      canvas.drawOutline("(2) OUTRAGE",250,290);
      canvas.drawOutline("(3) FIRE FANG",75,315);
      canvas.drawOutline("(4) EARTHQUAKE",250,315);
      canvas.drawOutline("HP:" + (Double.toString(enemyHealth)),60,75);
      canvas.drawOutline("HP:" + charizardHealth,260,235);
      canvas.drawImage(textbox,7,555);
      canvas.drawOutline(actionText,20,580);
      canvas.drawOutline(yourAction,20,600);
      canvas.drawOutline(enemyAction,20,620);
      canvas.endBuffer();
    }
    if(pokemon1Defeated==true && pokemon2Defeated==true && pokemon3Defeated==false && battle==true)
    {
      canvas.startBuffer();
      canvas.clear();
      canvas.drawImage(gbaLayout,-425,-75); 
      canvas.drawImage(battleLayout,20,20); 
      canvas.drawImage(megaCharizard,40,100);
      canvas.drawImage(zapdos,280,65);
      canvas.drawOutline("Zapdos",120,75);
      canvas.drawOutline("MEGA CHARIZARD X",290,200);
      canvas.drawOutline("(1) DRAGON DANCE",75,290);
      canvas.drawOutline("(2) OUTRAGE",250,290);
      canvas.drawOutline("(3) FIRE FANG",75,315);
      canvas.drawOutline("(4) EARTHQUAKE",250,315);
      canvas.drawOutline("HP:" + (Double.toString(enemyHealth)),60,75);
      canvas.drawOutline("HP:" + charizardHealth,260,235);
      canvas.drawImage(textbox,7,555);
      canvas.drawOutline(actionText,20,580);
      canvas.drawOutline(yourAction,20,600);
      canvas.drawOutline(enemyAction,20,620);
      if(charizardParalyzed==true)
      {
        canvas.drawOutline("Paralyzed",335,235);
      }
      canvas.endBuffer();
    }
    if(pokemon1Defeated==true && pokemon2Defeated==true && pokemon3Defeated==true)
    {
      battle=false;
      mewtwoCave=true;
      mewtwoBattle();
    }
  }
  
  public static void mewtwoBattleEngaged()
  {
    canvas.startBuffer();
    canvas.clear();
    canvas.drawImage(gbaLayout,-425,-75); 
    canvas.drawImage(mewtwoArena,20,20); 
    canvas.drawImage(megaCharizard,50,80);
    canvas.drawImage(mewtwo,280,45);
    canvas.drawOutline("MEGA MEWTWO Y",30,40);
    canvas.drawOutline("HP: "+ (Double.toString(enemyHealth)),30,65);
    canvas.drawOutline("MEGA CHARIZARD X",290,190);
    canvas.drawOutline("HP: "+ (Double.toString(charizardHealth)),290,235);
    canvas.drawOutline("(1) DRAGON DANCE",75,280);
    canvas.drawOutline("(2) OUTRAGE",250,280);
    canvas.drawOutline("(3) FIRE FANG",75,305);
    canvas.drawOutline("(4) EARTHQUAKE",250,305);
    canvas.drawImage(textbox,7,555);
    canvas.drawOutline(actionText,20,580);
    canvas.drawOutline(yourAction,20,600);
    canvas.drawOutline(enemyAction,20,620);
    canvas.endBuffer();
  }
}