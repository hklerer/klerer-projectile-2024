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
    private ProjectileGraph graph = new ProjectileGraph();

    public ProjectileFrame() {
        setSize(1000, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        // tells the JFrame to use this JPanel
        setContentPane(main);

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);

        west.setLayout(new GridLayout(8, 2));

        angleSlider = new JSlider(JSlider.HORIZONTAL,
                ANGLE_MIN, ANGLE_MAX, ANGLE_INIT);

        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);

        JLabel velocityLabel = new JLabel("Velocity");
        west.add(velocityLabel);
        velocityField = new JTextField();
        west.add(velocityField);

        JLabel angleLabel = new JLabel("Angle");
        west.add(angleLabel);
        west.add(angleSlider);

        JLabel secondsLabel = new JLabel("Seconds");
        west.add(secondsLabel);
        secondsField = new JTextField("0");
        west.add(secondsField);

        JLabel emptyLabelX = new JLabel("X");
        west.add(emptyLabelX);
        labelX = new JLabel();
        west.add(labelX);

        JLabel emptyLabelY = new JLabel("Y");
        west.add(emptyLabelY);
        labelY = new JLabel();
        west.add(labelY);

        JLabel labelPeakY = new JLabel("Peak Y");
        west.add(labelPeakY);
        peakY = new JLabel();
        west.add(peakY);

        JLabel interceptLabelX = new JLabel("Intercept X");
        west.add(interceptLabelX);
        interceptX = new JLabel();
        west.add(interceptX);

        JLabel empty = new JLabel();
        west.add(empty);
        JButton calculateButton = new JButton("Calculate");
        west.add(calculateButton);

        velocityField.getDocument().addDocumentListener((SimpleDocumentListener)
                documentEvent -> generateProjectile());

        angleSlider.addChangeListener(changeEvent -> generateProjectile());

        calculateButton.addActionListener(actionEvent -> generateProjectile());

        main.add(graph, BorderLayout.CENTER);



        // make a projectile
        // an arch is a series of small lines
        // one blue dot at peak
        // PR must include screenshot
    }

    private void generateProjectile() {
        Projectile projectile = new Projectile(
                angleSlider.getValue(),
                Double.parseDouble(velocityField.getText())
        );
        projectile.setSeconds(
                Double.parseDouble(secondsField.getText())
        );
        labelX.setText(Double.toString(projectile.getX()));
        labelY.setText(Double.toString(projectile.getY()));
        peakY.setText(Double.toString(projectile.getPeakY()));
        interceptX.setText(Double.toString(projectile.getInterceptX()));
        graph.setProjectile(projectile);
    }
}
