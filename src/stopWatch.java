import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class stopWatch {
    private JPanel stopWatch;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private JLabel hours;
    private JLabel minutes;
    private JLabel seconds;
    private JLabel milli_seconds;
    static int hours_=0;
    static int minutes_=0;
    static int seconds_=0;
    static int milliseconds_=0;
    static boolean state=true;



    public stopWatch() {
        stopButton.setEnabled(false);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                state = true;
                Thread t = new Thread() {
                    public void run() {
                        for (; ; ) {
                            if (state == true) {
                                try {
                                    sleep(9);
                                    if (milliseconds_ > 97) {milliseconds_ = 00;
                                        seconds_++;
                                    }
                                    if (seconds_ > 59) {
                                        milliseconds_ = 00;
                                        seconds_ = 00;
                                        minutes_++;
                                    }
                                    if (minutes_ > 59) {
                                        milliseconds_ = 00;
                                        seconds_ = 00;
                                        minutes_ = 00;
                                        hours_++;
                                    }
                                    milli_seconds.setText(" : " + milliseconds_);
                                    milliseconds_++;
                                    seconds.setText(" : " + seconds_);
                                    minutes.setText(" : " + minutes_);
                                    hours.setText(" " + hours_);
                                } catch (Exception e) {

                                }
                            } else {
                                break;
                            }
                        }

                    }
                };
                t.start();

            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = false;
                startButton.setEnabled(true);
                startButton.setText("Resume");


            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setText("Start");startButton.setEnabled(true);
                stopButton.setEnabled(false);
                state = false;
                hours_ = 0;
                minutes_ = 0;
                seconds_ = 0;
                milliseconds_ = 0;
                hours.setText("00  : ");
                minutes.setText("00  : ");
                seconds.setText("00  : ");
                milli_seconds.setText("00");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("stopWatch");
        frame.setContentPane(new stopWatch().stopWatch);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
