import java.awt.*;
import javax.swing.JFrame;

public class Frame extends JFrame
{
    protected static int width = 1200;
    protected static int height = 700;
    protected static Color backgroundColor = Color.GRAY;
    private Convex convex;

    public Frame(Convex convex)
    {
        super("CONVEX");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.convex=convex;
    }

    public void paint(Graphics g)
    {
        Rectangle s = this.getBounds();
        g.setColor(backgroundColor);
        g.translate(s.width/2, s.height/2);//Charge coord to center
        g.fillRect(-s.width/2, -s.height/2, s.width, s.height);
        g.setColor(Color.WHITE);
        g.drawLine(-s.width /2, 0, s.width/2, 0);
        g.drawLine(0, -s.height/2, 0, s.height/2);
        g.setColor(Color.BLACK);
        convex.draw(g);
    }
}
