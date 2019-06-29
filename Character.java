public class Character
{
  static int i;
  String n;
  int h;
  int[] a = new int[4];
  String[] an = new String[4];
  
  public Character(int i)
  {
    
    if(i==0)
    {
      this.h=100;
      
      this.n = "Articuno";
      
      this.a[0]=10;
      this.a[1]=3;
      this.a[2]=5;
      this.a[3]=5;
      
      this.an[0]="IceBeam";
      this.an[1]="Gust";
      this.an[2]="Fly";
      this.an[3]="Airial Ace";
    }
    
    if(i==1)
    {
      this.h=125;
      
      this.n = "Moltres";
      
      this.a[0]=10;
      this.a[1]=7;
      this.a[2]=8;
      this.a[3]=3;
      
      this.an[0]="Flamethrower";
      this.an[1]="Wing Attack";
      this.an[2]="Fire";
      this.an[3]="Ember";
    }
    
    if(i==2)
    {
      this.h=150;
      
      this.n = "Zapdos";
      
      this.a[0]=15;
      this.a[1]=0;
      this.a[2]=13;
      this.a[3]=0;
      
      this.an[0]="ThunderBolt";
      this.an[1]="Paralyze";
      this.an[2]="Thunder";
      this.an[3]="Roost";
    }
    
    if(i==3)
    {
      this.h=200;
      
      this.n = "Mewtwo";
      
      this.a[0]=0;
      this.a[1]=10;
      this.a[2]=0;
      this.a[3]=17;
      
      this.an[0]="Recover";
      this.an[1]="Psychic";
      this.an[2]="Confusion";
      this.an[3]="Aura Sphere";
    }
  }
}