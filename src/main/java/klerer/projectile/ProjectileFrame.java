package klerer.projectile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame {

    static final int ANGLE_MIN = 0;
    static final int ANGLE_MAX = 90;
    static final int ANGLE_INIT = 45;
    private final JSlider angleSlider;
    private final JTextField velocityField;
    private final JTextField secondsField;
    private final JLabel labelX;
    private final JLabel labelY;
    private final JLabel peakY;
    private final JLabel interceptX;


    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8, 2));

        angleSlider = new JSlider(JSlider.HORIZONTAL,
                ANGLE_MIN, ANGLE_MAX, ANGLE_INIT);

        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);

        JLabel velocityLabel = new JLabel("Velocity");
        add(velocityLabel);
        velocityField = new JTextField();
        add(velocityField);

        JLabel angleLabel = new JLabel("Angle");
        add(angleLabel);
        add(angleSlider);

        JLabel secondsLabel = new JLabel("Seconds");
        add(secondsLabel);
        secondsField = new JTextField("0");
        add(secondsField);

        JLabel emptyLabelX = new JLabel("X");
        add(emptyLabelX);
        labelX = new JLabel();
        add(labelX);

        JLabel emptyLabelY = new JLabel("Y");
        add(emptyLabelY);
        labelY = new JLabel();
        add(labelY);

        JLabel labelPeakY = new JLabel("Peak Y");
        add(labelPeakY);
        peakY = new JLabel();
        add(peakY);

        JLabel interceptLabelX = new JLabel("Intercept X");
        add(interceptLabelX);
        interceptX = new JLabel();
        add(interceptX);

        JLabel empty = new JLabel();
        add(empty);
        JButton calculateButton = new JButton("Calculate");
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
                labelX.setText(Double.toString(projectile.getX()));
                labelY.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        });

        angleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                createProjectile();
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Projectile projectile = new Projectile(
                        angleSlider.getValue(),
                        Double.parseDouble(String.valueOf(velocityField.getX()))
                );
                projectile.setSeconds(
                        Double.parseDouble(secondsField.getText())
                );
                labelX.setText(Double.toString(projectile.getX()));
                labelY.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        });

    }

    private void createProjectile() {
        Projectile projectile = new Projectile(
                angleSlider.getValue(),
                Double.parseDouble(String.valueOf(velocityField.getX()))
        );
        projectile.setSeconds(
                Double.parseDouble(secondsField.getText())
        );
        labelX.setText(Double.toString(projectile.getX()));
        labelY.setText(Double.toString(projectile.getY()));
        peakY.setText(Double.toString(projectile.getPeakY()));
        interceptX.setText(Double.toString(projectile.getInterceptX()));
    }
}
