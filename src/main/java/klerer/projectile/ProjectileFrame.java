package klerer.projectile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame {

    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8, 2));
        JLabel velocityLabel = new JLabel("Velocity");
        JLabel angleLabel = new JLabel("Angle");

        final int ANGLE_MIN = 0;
        final int ANGLE_MAX = 90;
        final int ANGLE_INIT = 45;    //initial frames per second

        JSlider angleSlider = new JSlider(JSlider.HORIZONTAL,
                ANGLE_MIN, ANGLE_MAX, ANGLE_INIT);
       // angleSlider.addChangeListener((ChangeListener) this);

//Turn on labels at major tick marks.
        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);

        JLabel secondsLabel = new JLabel("Seconds");
        JLabel XLabel = new JLabel("X");
        JLabel YLabel = new JLabel("Y");        // add row under Y that displays peakY, XIntercept

        JTextField velocityField = new JTextField();
        //JTextField angleField = new JTextField();       // make into JSlider from 0 - 90
        JTextField secondsField = new JTextField();
        JLabel calculatedXLabel = new JLabel();
        JLabel calculatedYLabel = new JLabel();
        JLabel empty = new JLabel();
        JButton calculateButton = new JButton("Calculate");
        JLabel peakYLabel = new JLabel("Peak Y");
        JLabel interceptXLabel = new JLabel("Intercept X");
        JLabel peakY = new JLabel();
        JLabel interceptX = new JLabel();

        add(velocityLabel);
        add(velocityField);

        add(angleLabel);
        add(angleSlider);
        //add(angleField);

        add(secondsLabel);
        add(secondsField);

        add(XLabel);
        add(calculatedXLabel);

        add(YLabel);
        add(calculatedYLabel);

        add(peakYLabel);
        add(peakY);

        add(interceptXLabel);
        add(interceptX);

        add(empty);
        add(calculateButton);


        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                Projectile projectile = new Projectile(
                        Double.parseDouble(velocityField.getText()),
                        Double.parseDouble(String.valueOf(angleSlider.getValue()))
                );
                projectile.setSeconds(
                        Double.parseDouble(secondsField.getText())
                );
                calculatedXLabel.setText(Double.toString(projectile.getX()));
                calculatedYLabel.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        });

        angleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Projectile projectile = new Projectile(
                        Double.parseDouble(velocityField.getText()),
                        Double.parseDouble(String.valueOf(angleSlider.getValue()))
                );
                projectile.setSeconds(
                        Double.parseDouble(secondsField.getText())
                );
                calculatedXLabel.setText(Double.toString(projectile.getX()));
                calculatedYLabel.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        });


        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Projectile projectile = new Projectile(
                        Double.parseDouble(velocityField.getText()),
                        Double.parseDouble(String.valueOf(angleSlider.getValue()))
                );
                projectile.setSeconds(
                        Double.parseDouble(secondsField.getText())
                );
                calculatedXLabel.setText(Double.toString(projectile.getX()));
                calculatedYLabel.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        });
    }
}
