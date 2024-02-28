package klerer.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    private Projectile projectile = new Projectile(0, 0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.translate(0, getHeight());

        g.setColor(Color.BLACK);

        projectile.setSeconds(0);

        for (int i = 0; i <= (projectile.getApexTime() * 2) + 1; i += 1) {
            double currentX = projectile.getX();
            double currentY = projectile.getY();

            projectile.setSeconds(i);

            g.drawLine((int) currentX,
                    -(int) currentY,
                    (int) projectile.getX(),
                    -(int) projectile.getY());
        }

        g.drawString("(100, 100)", 100, -100);
        g.setColor(Color.GREEN);
        g.drawLine(0, 0, getWidth(), -getHeight());
        g.drawRect(200, -200, 50, 50);
        g.setColor(Color.MAGENTA);
        g.fillRect(400, -400, 25, 25);
        g.setColor(Color.ORANGE);
        g.drawOval(200, -200, 50, 50);
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;

        // tells the operating system to call paintComponent() again.
        repaint();
    }

}
