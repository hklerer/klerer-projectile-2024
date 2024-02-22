package klerer.projectile;

import javax.swing.*;

import java.awt.*;


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

        velocityField.getDocument().addDocumentListener((SimpleDocumentListener)
                documentEvent -> generateProjectile());

        angleSlider.addChangeListener(changeEvent -> generateProjectile());

        calculateButton.addActionListener(actionEvent -> generateProjectile());

    }

    private void generateProjectile() {
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
