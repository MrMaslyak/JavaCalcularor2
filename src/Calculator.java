import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    static String text = "";
    static String sign = "";
    JTextField textField = new JTextField();


    Calculator() {
        setSize(225, 430);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension buttonSize = new Dimension(48, 30);
        Color twelveButtonColor = new Color(89, 98, 98);
        Color twelveButtonColorN = Color.white;

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBackground(new Color(68, 71, 71));
        textField.setForeground(twelveButtonColorN);
        textField.setBorder(new LineBorder(Color.RED));
        textField.setSize(200, 75);
        textField.setLocation(5, 74);
        add(textField);

        JLabel historyLabel = new JLabel("");
        historyLabel.setForeground(Color.RED);
        historyLabel.setSize(200, 20);
        historyLabel.setLocation(5, 50);
        add(historyLabel);

        JButton buttonPlusMinis = new JButton("+/-");
        buttonPlusMinis.setSize(buttonSize);
        buttonPlusMinis.setForeground(twelveButtonColorN);
        buttonPlusMinis.setBackground(twelveButtonColor);
        buttonPlusMinis.setLocation(5, 278);
        buttonPlusMinis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Double.parseDouble(textField.getText()) * -1));
                historyLabel.setText(historyLabel.getText() + " × -1");

            }
        });
        add(buttonPlusMinis);

        JButton button0 = new JButton("0");
        button0.setSize(buttonSize);
        button0.setForeground(twelveButtonColorN);
        button0.setBackground(twelveButtonColor);
        button0.setLocation(55, 278);
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearErrorMessage2();
                clearErrorMessage();
                textField.setText(textField.getText() + "0");
                historyLabel.setText(historyLabel.getText() + "0");

            }
        });
        add(button0);

        JButton buttonZap = new JButton(",");
        buttonZap.setSize(buttonSize);
        buttonZap.setForeground(twelveButtonColorN);
        buttonZap.setBackground(twelveButtonColor);
        buttonZap.setLocation(105, 278);
        buttonZap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().contains(".") ){
                    textField.setText("You have already .");
                    historyLabel.setText("");
                }else {
                    clearErrorMessage2();
                    clearErrorMessage();
                    textField.setText(textField.getText() + ".");
                    historyLabel.setText(historyLabel.getText() + ".");
                }


            }
        });

        add(buttonZap);

        JButton buttonR = new JButton("=");
        buttonR.setBackground(new Color(254, 120, 71));
        buttonR.setForeground(twelveButtonColorN);
        buttonR.setSize(buttonSize);
        buttonR.setLocation(155, 278);
        buttonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sign.equals("+")) {
                     textField.setText(String.valueOf(Double.parseDouble(text) + (Double.parseDouble(textField.getText()))));
                }
                if (sign.equals("-")) {
                    textField.setText(String.valueOf(Double.parseDouble(text) - (Double.parseDouble(textField.getText()))));
                }
                if (sign.equals("×")) {
                    textField.setText(String.valueOf(Double.parseDouble(text) * (Double.parseDouble(textField.getText()))));
                }
                if (sign.equals("÷")) {
                    double divisor = Double.parseDouble(textField.getText());
                    if (divisor == 0) {
                        textField.setText("Division by zero is impossible");
                        historyLabel.setText("");
                    } else {
                        textField.setText(String.valueOf(Double.parseDouble(text) / divisor));
                    }
                }
            }
        });
        add(buttonR);

        JButton button1 = new JButton("1");
        button1.setSize(buttonSize);
        button1.setForeground(twelveButtonColorN);
        button1.setBackground(twelveButtonColor);
        button1.setLocation(5, 246);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearErrorMessage2();
                clearErrorMessage();
                textField.setText(textField.getText() + "1");
                historyLabel.setText(historyLabel.getText() + "1");
            }
        });
        add(button1);

        JButton button2 = new JButton("2");
        button2.setSize(buttonSize);
        button2.setForeground(twelveButtonColorN);
        button2.setBackground(twelveButtonColor);
        button2.setLocation(55, 246);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearErrorMessage2();
                clearErrorMessage();
                textField.setText(textField.getText() + "2");
                historyLabel.setText(historyLabel.getText() + "2");
            }
        });
        add(button2);

        JButton button3 = new JButton("3");
        button3.setSize(buttonSize);
        button3.setForeground(twelveButtonColorN);
        button3.setBackground(twelveButtonColor);
        button3.setLocation(105, 246);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearErrorMessage2();
                clearErrorMessage();
                textField.setText(textField.getText() + "3");
                historyLabel.setText(historyLabel.getText() + "3");
            }
        });
        add(button3);

        JButton buttonPlus = new JButton("+");
        buttonPlus.setSize(buttonSize);
        buttonPlus.setLocation(155, 246);
        add(buttonPlus);
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = textField.getText();
                textField.setText("");
                sign = "+";
                historyLabel.setText(text + " + ");

            }
        });


        JButton button4 = new JButton("4");
        button4.setSize(buttonSize);
        button4.setForeground(twelveButtonColorN);
        button4.setBackground(twelveButtonColor);
        button4.setLocation(5, 214);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearErrorMessage2();
                clearErrorMessage();
                textField.setText(textField.getText() + "4");
                historyLabel.setText(historyLabel.getText() + "4");
            }
        });

        add(button4);

        JButton button5 = new JButton("5");
        button5.setSize(buttonSize);
        button5.setForeground(twelveButtonColorN);
        button5.setBackground(twelveButtonColor);
        button5.setLocation(55, 214);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearErrorMessage2();
                clearErrorMessage();
                textField.setText(textField.getText() + "5");
                historyLabel.setText(historyLabel.getText() + "5");
            }
        });
        add(button5);

        JButton button6 = new JButton("6");
        button6.setSize(buttonSize);
        button6.setForeground(twelveButtonColorN);
        button6.setBackground(twelveButtonColor);
        button6.setLocation(105, 214);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearErrorMessage2();
                clearErrorMessage();
                textField.setText(textField.getText() + "6");
                historyLabel.setText(historyLabel.getText() + "6");
            }
        });
        add(button6);

        JButton buttonMinus = new JButton("-");
        buttonMinus.setSize(buttonSize);
        buttonMinus.setLocation(155, 214);
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = textField.getText();
                textField.setText("");
                sign = "-";
                historyLabel.setText(text + " - ");

            }
        });
        add(buttonMinus);

        JButton button7 = new JButton("7");
        button7.setSize(buttonSize);
        button7.setForeground(twelveButtonColorN);
        button7.setBackground(twelveButtonColor);
        button7.setLocation(5, 182);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearErrorMessage2();
                clearErrorMessage();
                textField.setText(textField.getText() + "7");
                    historyLabel.setText(historyLabel.getText() + "7");
            }
        });
        add(button7);

        JButton button8 = new JButton("8");
        button8.setSize(buttonSize);
        button8.setForeground(twelveButtonColorN);
        button8.setBackground(twelveButtonColor);
        button8.setLocation(55, 182);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearErrorMessage2();
                clearErrorMessage();
                textField.setText(textField.getText() + "8");
                historyLabel.setText(historyLabel.getText() + "8");
            }
        });
        add(button8);

        JButton button9 = new JButton("9");
        button9.setSize(buttonSize);
        button9.setForeground(twelveButtonColorN);
        button9.setBackground(twelveButtonColor);
        button9.setLocation(105, 182);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearErrorMessage2();
                clearErrorMessage();
                textField.setText(textField.getText() + "9");
                historyLabel.setText(historyLabel.getText() + "9");
            }
        });
        add(button9);

        JButton buttonY = new JButton("×");
        buttonY.setSize(buttonSize);
        buttonY.setLocation(155, 182);
        buttonY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = textField.getText();
                textField.setText("");
                sign = "×";
                historyLabel.setText(text + " × ");
            }
        });
        add(buttonY);

        JButton buttonX2 = new JButton("x2");
        buttonX2.setSize(buttonSize);
        buttonX2.setBackground(new Color(254, 120, 71));
        buttonX2.setForeground(twelveButtonColorN);
        buttonX2.setLocation(5, 150);
        buttonX2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Double.parseDouble(textField.getText()) * Double.parseDouble(textField.getText())));
                historyLabel.setText(textField.getText() + " x2 ");

            }
        });
        add(buttonX2);

        JButton buttonC = new JButton("C");
        buttonC.setSize(buttonSize);
        buttonC.setLocation(55, 150);
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                historyLabel.setText("");
            }
        });
        add(buttonC);

        JButton buttonV = new JButton("<---");
        buttonV.setSize(buttonSize);
        buttonV.setLocation(105, 150);
        buttonV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText  = textField.getText();
                if (!currentText.isEmpty() && !currentText.equals("You have already .") && !currentText.equals("Division by zero is impossible")){
                    textField.setText(currentText.substring(0, currentText.length()-1 ));
                    historyLabel.setText(historyLabel.getText().substring(0, historyLabel.getText().length()-1));
                }
            }
        });
        add(buttonV);

        JButton buttonD = new JButton("÷");
        buttonD.setSize(buttonSize);
        buttonD.setBackground(new Color(254, 120, 71));
        buttonD.setForeground(twelveButtonColorN);
        buttonD.setLocation(155, 150);
        buttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = textField.getText();
                textField.setText("");
                sign = "÷";
                historyLabel.setText(text + " ÷ ");
            }
        });
        add(buttonD);
        setVisible(true);
    }

    private void clearErrorMessage() {
        if ("Division by zero is impossible".equals(textField.getText())) {
            textField.setText("");
        }
    }
    private void clearErrorMessage2() {
        if ("You have already .".equals(textField.getText())) {
            textField.setText("");
        }
    }

}
