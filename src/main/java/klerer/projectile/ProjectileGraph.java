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

        g.setColor(Color.BLUE);
        projectile.getPeakY();
        g.fillOval((int) (projectile.getInterceptX() / 2 - 3.5),
                (int) (-projectile.getPeakY() - 3.5),
                10,
                10);

    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;

        // tells the operating system to call paintComponent() again.
        repaint();
    }

}
