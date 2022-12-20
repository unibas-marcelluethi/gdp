import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.lang.String;

public class Application {
    public static void main(String[] args) {

        // rendering of the game
        Field gameView = new Field(60,40);
        gameView.addMouseListener(gameView);
        gameView.addMouseMotionListener(gameView);
        

        // control elements
        JButton runButton = new JButton("Start");
        JLabel frameTimeLabel = new JLabel("Frametime 1 .. 1000 [ms]");
        JSlider frameTimeControl = new JSlider(1,1000);

        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.add(runButton);
        controlPanel.add(frameTimeLabel);
        controlPanel.add(frameTimeControl);


        // setup content
        JPanel mainWindowContent = new JPanel();
        BorderLayout layout = new BorderLayout();
        mainWindowContent.setLayout(layout);
        mainWindowContent.add(controlPanel, BorderLayout.NORTH);
        mainWindowContent.add(gameView, BorderLayout.CENTER);

        // setup window
        JFrame frame = new JFrame("Game of life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setContentPane(mainWindowContent);
        frame.pack();
        frame.setVisible(true);

        // rules the animation
        Timer clock = new Timer(500, e -> { gameView.evolve(); gameView.repaint(); });
        clock.start();

        // reaction when slider is changed
        frameTimeControl.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                clock.setDelay(frameTimeControl.getValue());
                // e.getSource() could be used to access the object which issued the change event
            }
        });

        // reaction when button is pressed
        runButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(runButton.getText()=="Start") {
                    clock.start();
                    runButton.setText("Stop");
                } else {
                    clock.stop();
                    runButton.setText("Start");
                }
            }
        });

        // abuse to put timer on pause when drawing with mouse
        gameView.setButton(runButton);
    }
}