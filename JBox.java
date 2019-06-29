//package dk.ruc.madsr.swing;
//----------------------------------------------------------------------
// This class is written by Mads Rosendahl, University of Roskilde, Denmark
// You may uncomment the first line, but otherwise, please do not change the code.
// If you find errors or have any suggestions contact me at madsr@ruc.dk
//
// version 1.1 : 09-10-06
//----------------------------------------------------------------
import javax.swing.*; 
import java.awt.*;

/**  */
public class JBox extends JPanel {  
    
    /** [Internal] */
    public JBox( int orientation ) { 
        BoxLayout boxLayout = new BoxLayout( this, orientation );
        setLayout( boxLayout );
        this.orientation=orientation;
    } 
    /** [Internal] */
    public JBox( int orientation ,float alignment) { 
        this(orientation);
        doalign=true; this.alignment=alignment;
    } 
    private boolean doalign=false; private float alignment=0;
    private int orientation=0;
    //
    /**  */
    public static final int LINE_AXIS=BoxLayout.LINE_AXIS;
    /**  */
    public static final int PAGE_AXIS=BoxLayout.PAGE_AXIS;
    /**  */
    public static final int X_AXIS=BoxLayout.X_AXIS;
    /**  */
    public static final int Y_AXIS=BoxLayout.Y_AXIS;

    /**  */
    public static final float BOTTOM_ALIGNMENT =Component.BOTTOM_ALIGNMENT;
    /**  */
    public static final float CENTER_ALIGNMENT=Component.CENTER_ALIGNMENT ;
    /**  */
    public static final float LEFT_ALIGNMENT=Component.LEFT_ALIGNMENT; 
    /**  */
    public static final float RIGHT_ALIGNMENT=Component.RIGHT_ALIGNMENT; 
    /**  */
    public static final float TOP_ALIGNMENT=Component.TOP_ALIGNMENT ;

    /**  */
    public static final float BOTTOM =Component.BOTTOM_ALIGNMENT;
    /**  */
    public static final float CENTER=Component.CENTER_ALIGNMENT ;
    /**  */
    public static final float LEFT=Component.LEFT_ALIGNMENT; 
    /**  */
    public static final float RIGHT=Component.RIGHT_ALIGNMENT; 
    /**  */
    public static final float TOP=Component.TOP_ALIGNMENT ;
    
    /** Create a hbox */
    public static JBox createHorizontalJBox(){ return new JBox(LINE_AXIS );} 
    /** Create a vbox */
    public static JBox createVerticalJBox() {  return new JBox( PAGE_AXIS );} 
    /** Create a hbox */
    public static JBox hbox(){ return new JBox(LINE_AXIS,BOTTOM_ALIGNMENT );} 
    /** Create a vbox */
    public static JBox vbox(){ return new JBox( PAGE_AXIS,LEFT_ALIGNMENT );} 
    /** Create a hbox with bottom aligned content */
    public static JBox hbox(Component... bb){ 
        JBox b= new JBox(LINE_AXIS,BOTTOM_ALIGNMENT );
        for(Component c:bb)b.add(c);return b;} 
    /** Create a vbox with left aligned content */
    public static JBox vbox(Component... bb) {
        JBox b= new JBox(PAGE_AXIS,LEFT_ALIGNMENT );
        for(Component c:bb)b.add(c);return b;}

    /** Create a hbox component */
    public static JBox hbox(float a,Component... bb){ 
        JBox b= new JBox(LINE_AXIS,a);
        for(Component c:bb)b.add(c);return b;} 
    /** Create a vbox component */
    public static JBox vbox(float a,Component... bb) {
        JBox b= new JBox(PAGE_AXIS,a);
        for(Component c:bb)b.add(c);return b;}
    
    /** Create a hbox component */
    public static JBox createHorizontalJBox(float a){ return new JBox(LINE_AXIS,a );} 
    /** Create a vbox component */
    public static JBox createVerticalJBox(float a) {  return new JBox( PAGE_AXIS,a );} 
    /** Create a hbox component */
    public static JBox hbox(float a){ return new JBox(LINE_AXIS,a );} 
    /** Create a vbox component */
    public static JBox vbox(float a) {  return new JBox( PAGE_AXIS,a );} 
    //public static Component glue(){ return Box.createGlue();  } 
    /** Create a hglue component */
    public static Component hglue(){ return Box.createHorizontalGlue();  } 
    /** Create a vglue component */
    public static Component vglue(){ return Box.createVerticalGlue();  } 
    /** Create a hspace component */
    public static Component hspace(int n){ 
        return Box.createRigidArea(new Dimension( n, 1));}
    /** Create a vspace component */
    public static Component vspace(int n){ 
        return Box.createRigidArea(new Dimension( 1, n));}

    /** set size of a component */
    public static JComponent setSize(JComponent c,int w,int h){ 
       Dimension d= new Dimension(w,h);
       c.setMinimumSize(d);
       c.setPreferredSize(d);
       c.setMaximumSize(d);
       return c;
    }
    /** set strechable size of a component */
    public static JComponent setSize(JComponent c,int w,int h,int dw,int dh){ 
       c.setMinimumSize(new Dimension(Math.max(0,w-dw),Math.max(0,h-dh)));
       c.setPreferredSize(new Dimension(w,h));
       c.setMaximumSize(new Dimension(w+dw,h+dh));
       return c;
    }
    /** set font of components in a box */
    public void setFont(Font f){
        Component[] cs=getComponents();
        for(Component c:cs)c.setFont(f);
    }
    /** set foreground color of a box */
    public void setForeground(Color cl){
        Component[] cs=getComponents();
        for(Component c:cs)c.setForeground(cl);
    }
    /** set background color of a box */
    public void setBackground(Color cl){
        super.setBackground(cl);
        super.setOpaque(true);
        Component[] cs=getComponents();
        for(Component c:cs)c.setBackground(cl);
    }
    /** make the box opaque */
    public void setOpaque(boolean b){
        super.setOpaque(b);
        Component[] cs=getComponents();
        for(Component c:cs)
          if(c instanceof JComponent)
             ((JComponent)c).setOpaque(b);
    }
    /** add component to a box */
    public Component add(Component c){
        Component c1=super.add(c);
        if(doalign&&c instanceof JComponent){
           if(orientation==LINE_AXIS||orientation==X_AXIS)
              ((JComponent) c).setAlignmentY(alignment);    
           else
              ((JComponent) c).setAlignmentX(alignment);    
        }
        return c1;
    }
    
    /** Return height of the screen */
    public static int getScreenHeight(){
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      // Get size
      Dimension dimension = toolkit.getScreenSize();
      return dimension.height;
    }
    /** Return width of the screen */
    public static int getScreenWidth(){
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      // Get size
      Dimension dimension = toolkit.getScreenSize();
      return dimension.width;
    }
    /** Layout components in a box */
    public void revalidate(){
      Component[] body=getComponents();
      if(body!=null)
        for(Component c:body)
          if(c!=null&&c instanceof JComponent)
            ((JComponent)c).revalidate();
      super.revalidate();
    }

    /** [Internal] */
  public static final long serialVersionUID = 42L;    
}  
