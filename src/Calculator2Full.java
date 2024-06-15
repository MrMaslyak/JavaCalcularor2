import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class Calculator2Full extends JFrame {
    static String text = "";
    static String sign = "";
    boolean resultDisplayed = false;
    JTextField textField = new JTextField();
    JFrame jFrame = new JFrame();
    DecimalFormat df = new DecimalFormat("#.####");

    Calculator2Full() {
        jFrame.setSize(393, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        Color twelveButtonColor = new Color(94, 97, 97);
        Color otherButtonColor = new Color(133, 136, 136);
        Font font = new Font("Arial", Font.PLAIN, 20);
        Dimension buttonSize = new Dimension(90, 60);

        textField.setLocation(0, 0);
        textField.setSize(377, 178);
        textField.setBackground(new Color(31, 36, 36));
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Arial", Font.PLAIN, 40));
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        jFrame.add(textField);

        JLabel historyLabel = new JLabel("");
        historyLabel.setForeground(Color.gray);
        historyLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        historyLabel.setSize(200, 20);
        historyLabel.setLocation(50, 30);
        textField.add(historyLabel);


        JButton buttonPiMi = new JButton("+/-");
        buttonPiMi.setSize(buttonSize);
        buttonPiMi.setBackground(twelveButtonColor);
        buttonPiMi.setForeground(Color.WHITE);
        buttonPiMi.setFont(font);
        buttonPiMi.setLocation(5, 495);
        buttonPiMi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Double.parseDouble(textField.getText().replace(',', '.')) * -1));
                historyLabel.setText(historyLabel.getText().replace(',', '.') + " × -1");
                if (resultDisplayed){
                    historyLabel.setText("");
                    historyLabel.setText("negative(" + textField.getText().replace(',', '.') + ")");
                }
                resultDisplayed = false;
            }
        });
        jFrame.add(buttonPiMi);

        JButton button0 = new JButton("0");
        button0.setSize(buttonSize);
        button0.setBackground(twelveButtonColor);
        button0.setForeground(Color.WHITE);
        button0.setFont(font);
        button0.setLocation(97, 495);
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ErrorByZero();
                textField.setFont(new Font("Arial", Font.PLAIN, 40));
                textField.setText(textField.getText().replace(',', '.') + "0");
                historyLabel.setText(historyLabel.getText().replace(',', '.') + "0");
                resultDisplayed = false;
            }
        });
        jFrame.add(button0);

        JButton buttonZap = new JButton(",");
        buttonZap.setSize(buttonSize);
        buttonZap.setBackground(twelveButtonColor);
        buttonZap.setForeground(Color.WHITE);
        buttonZap.setFont(font);
        buttonZap.setLocation(189, 495);
        buttonZap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (resultDisplayed){
                    textField.setText("0");
                    historyLabel.setText("0");
                }
                if (!textField.getText().contains(".") && !textField.getText().contains(",")) {
                    textField.setFont(new Font("Arial", Font.PLAIN, 40));
                    textField.setText(textField.getText().replace(',', '.') + ",");
                    historyLabel.setText(historyLabel.getText().replace(',', '.') + ",");
                    resultDisplayed = false;
                } else {
                    textField.setFont(new Font("Arial", Font.PLAIN, 20));
                    historyLabel.setText("");
                    textField.setText("You have already ,");
                    resultDisplayed = false;
                }
            }
        });
        jFrame.add(buttonZap);

        JButton buttonRavno = new JButton("=");
        buttonRavno.setSize(buttonSize);
        buttonRavno.setBackground(new Color(246, 122, 41));
        buttonRavno.setForeground(Color.BLACK);
        buttonRavno.setFont(font);
        buttonRavno.setLocation(282, 495);
        buttonRavno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sign.equals("+")) {
                    textField.setText((String.valueOf(df.format(Double.parseDouble(text) + (Double.parseDouble(textField.getText().replace(',', '.')))))));
                }
                if (sign.equals("-")) {
                    textField.setText((String.valueOf(df.format(Double.parseDouble(text) - (Double.parseDouble(textField.getText().replace(',', '.')))))));
                }
                if (sign.equals("×")) {
                    textField.setText((String.valueOf(df.format(Double.parseDouble(text) * (Double.parseDouble(textField.getText().replace(',', '.')))))));
                }
                if (sign.equals("÷")) {
                    double divisor = Double.parseDouble(textField.getText().replace(',', '.'));
                    if (divisor == 0) {
                        textField.setText("Division by zero is impossible");
                        historyLabel.setText("");
                    } else {
                        textField.setText((String.valueOf(df.format(Double.parseDouble(text.replace(',', '.')) / divisor))));
                    }
                }
                resultDisplayed = true;
            }
        });
        jFrame.add(buttonRavno);

        JButton button1 = new JButton("1");
        button1.setSize(buttonSize);
        button1.setBackground(twelveButtonColor);
        button1.setForeground(Color.WHITE);
        button1.setFont(font);
        button1.setLocation(5, 433);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ErrorByZero();
                textField.setFont(new Font("Arial", Font.PLAIN, 40));
                textField.setText(textField.getText().replace(',', '.') + "1");
                historyLabel.setText(historyLabel.getText().replace(',', '.') + "1");
                resultDisplayed = false;
            }
        });
        jFrame.add(button1);

        JButton button2 = new JButton("2");
        button2.setSize(buttonSize);
        button2.setBackground(twelveButtonColor);
        button2.setForeground(Color.WHITE);
        button2.setFont(font);
        button2.setLocation(97, 433);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ErrorByZero();
                textField.setFont(new Font("Arial", Font.PLAIN, 40));
                textField.setText(textField.getText().replace(',', '.') + "2");
                historyLabel.setText(historyLabel.getText().replace(',', '.') + "2");
                resultDisplayed = false;
            }
        });
        jFrame.add(button2);

        JButton button3 = new JButton("3");
        button3.setSize(buttonSize);
        button3.setBackground(twelveButtonColor);
        button3.setForeground(Color.WHITE);
        button3.setFont(font);
        button3.setLocation(189, 433);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ErrorByZero();
                textField.setFont(new Font("Arial", Font.PLAIN, 40));
                textField.setText(textField.getText().replace(',', '.') + "3");
                historyLabel.setText(historyLabel.getText().replace(',', '.') + "3");
                resultDisplayed = false;
            }
        });
        jFrame.add(button3);

        JButton buttonP = new JButton("+");
        buttonP.setSize(buttonSize);
        buttonP.setBackground(otherButtonColor);
        buttonP.setForeground(Color.WHITE);
        buttonP.setFont(font);
        buttonP.setLocation(282, 433);
        buttonP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = textField.getText().replace(',', '.');
                textField.setText("");
                sign = "+";
                historyLabel.setText(text + " + ");
                resultDisplayed = false;
            }
        });
        jFrame.add(buttonP);

        JButton button4 = new JButton("4");
        button4.setSize(buttonSize);
        button4.setBackground(twelveButtonColor);
        button4.setForeground(Color.WHITE);
        button4.setFont(font);
        button4.setLocation(5, 370);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ErrorByZero();
                textField.setFont(new Font("Arial", Font.PLAIN, 40));
                textField.setText(textField.getText().replace(',', '.') + "4");
                historyLabel.setText(historyLabel.getText().replace(',', '.') + "4");
                resultDisplayed = false;

            }
        });
        jFrame.add(button4);

        JButton button5 = new JButton("5");
        button5.setSize(buttonSize);
        button5.setBackground(twelveButtonColor);
        button5.setForeground(Color.WHITE);
        button5.setFont(font);
        button5.setLocation(97, 370);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ErrorByZero();
                textField.setFont(new Font("Arial", Font.PLAIN, 40));
                textField.setText(textField.getText().replace(',', '.') + "5");
                historyLabel.setText(historyLabel.getText().replace(',', '.') + "5");

                resultDisplayed = false;
            }
        });
        jFrame.add(button5);

        JButton button6 = new JButton("6");
        button6.setSize(buttonSize);
        button6.setBackground(twelveButtonColor);
        button6.setForeground(Color.WHITE);
        button6.setFont(font);
        button6.setLocation(189, 370);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ErrorByZero();
                textField.setFont(new Font("Arial", Font.PLAIN, 40));
                textField.setText(textField.getText().replace(',', '.') + "6");
                historyLabel.setText(historyLabel.getText().replace(',', '.') + "6");
                resultDisplayed = false;

            }
        });
        jFrame.add(button6);

        JButton buttonM = new JButton("-");
        buttonM.setSize(buttonSize);
        buttonM.setBackground(otherButtonColor);
        buttonM.setForeground(Color.WHITE);
        buttonM.setFont(font);
        buttonM.setLocation(282, 370);
        buttonM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = textField.getText();
                textField.setText("");
                sign = "-";
                historyLabel.setText(text + " - ");
                resultDisplayed = false;

            }
        });
        jFrame.add(buttonM);

        JButton button7 = new JButton("7");
        button7.setSize(buttonSize);
        button7.setBackground(twelveButtonColor);
        button7.setForeground(Color.WHITE);
        button7.setFont(font);
        button7.setLocation(5, 307);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ErrorByZero();
                textField.setFont(new Font("Arial", Font.PLAIN, 40));
                textField.setText(textField.getText().replace(',', '.') + "7");
                historyLabel.setText(historyLabel.getText().replace(',', '.') + "7");
                resultDisplayed = false;
            }
        });
        jFrame.add(button7);

        JButton button8 = new JButton("8");
        button8.setSize(buttonSize);
        button8.setBackground(twelveButtonColor);
        button8.setForeground(Color.WHITE);
        button8.setFont(font);
        button8.setLocation(97, 307);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ErrorByZero();
                textField.setFont(new Font("Arial", Font.PLAIN, 40));
                textField.setText(textField.getText().replace(',', '.') + "8");
                historyLabel.setText(historyLabel.getText().replace(',', '.') + "8");
                resultDisplayed = false;
            }
        });
        jFrame.add(button8);

        JButton button9 = new JButton("9");
        button9.setSize(buttonSize);
        button9.setBackground(twelveButtonColor);
        button9.setForeground(Color.WHITE);
        button9.setFont(font);
        button9.setLocation(189, 307);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ErrorByZero();
                textField.setFont(new Font("Arial", Font.PLAIN, 40));
                textField.setText(textField.getText().replace(',', '.') + "9");
                historyLabel.setText(historyLabel.getText().replace(',', '.') + "9");
                resultDisplayed = false;
            }
        });
        jFrame.add(button9);

        JButton buttonY = new JButton("×");
        buttonY.setSize(buttonSize);
        buttonY.setBackground(otherButtonColor);
        buttonY.setForeground(Color.WHITE);
        buttonY.setFont(font);
        buttonY.setLocation(282, 307);
        buttonY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = textField.getText().replace(',', '.');
                textField.setText("");
                sign = "×";
                resultDisplayed = false;
                historyLabel.setText(text + " × ");
            }
        });
        jFrame.add(buttonY);

        JButton button1x = new JButton("1/x");
        button1x.setSize(buttonSize);
        button1x.setBackground(otherButtonColor);
        button1x.setForeground(Color.WHITE);
        button1x.setFont(font);
        button1x.setLocation(5, 244);
        button1x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentValueText = textField.getText().replace(',', '.');
                currentValueText = currentValueText.replace(',', '.');
                double currentValue = Double.parseDouble(currentValueText);
                double result = 1 / currentValue;
                String formattedResult = df.format(result);
                textField.setText(formattedResult);
                historyLabel.setText("1 /" + currentValue);
                if (resultDisplayed) {
                    historyLabel.setText("");
                    historyLabel.setText("1 /" + currentValue);
                    textField.setText(formattedResult);
                }

                resultDisplayed = false;
            }
        });
        jFrame.add(button1x);

        JButton buttonX2 = new JButton("x2");
        buttonX2.setSize(buttonSize);
        buttonX2.setBackground(otherButtonColor);
        buttonX2.setForeground(Color.WHITE);
        buttonX2.setFont(font);
        buttonX2.setLocation(97, 244);
        buttonX2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double currentValue = Double.parseDouble(textField.getText().replace(',', '.'));
                double result = (Double.parseDouble(df.format(currentValue * currentValue)));
                textField.setText(String.valueOf(result));
                historyLabel.setText(historyLabel.getText().replace(',', '.') + "²");
                if (resultDisplayed){
                   historyLabel.setText("");
                    historyLabel.setText(String.valueOf(currentValue) + "²");
                }
                resultDisplayed = false;
            }
        });
        jFrame.add(buttonX2);

        JButton buttonC = new JButton("√");
        buttonC.setSize(buttonSize);
        buttonC.setBackground(otherButtonColor);
        buttonC.setForeground(Color.WHITE);
        buttonC.setFont(font);
        buttonC.setLocation(189, 244);
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentValueText = textField.getText();
                currentValueText = currentValueText.replace(',', '.');
                double currentValue = Double.parseDouble(currentValueText);
                double result = Math.sqrt(currentValue);
                String formattedResult = df.format(result);
                textField.setText(formattedResult);
                historyLabel.setText("√" + currentValueText);
                if (resultDisplayed) {
                    historyLabel.setText("√" + currentValueText);
                    textField.setText(formattedResult);
                }
                resultDisplayed = false;
            }
        });
        jFrame.add(buttonC);

        JButton buttonD = new JButton("÷");
        buttonD.setSize(buttonSize);
        buttonD.setBackground(otherButtonColor);
        buttonD.setForeground(Color.WHITE);
        buttonD.setFont(font);
        buttonD.setLocation(282, 244);
        buttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = textField.getText().replace(',', '.');
                textField.setText("");
                sign = "÷";
                historyLabel.setText(text + " ÷ ");
                resultDisplayed = false;
            }
        });
        jFrame.add(buttonD);

        JButton buttonCos = new JButton("cos");
        buttonCos.setSize(buttonSize);
        buttonCos.setBackground(otherButtonColor);
        buttonCos.setForeground(Color.WHITE);
        buttonCos.setFont(font);
        buttonCos.setLocation(5, 180);
        buttonCos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double currentValue = Double.parseDouble(textField.getText().replace(',', '.'));
                textField.setText(df.format(Math.cos(currentValue)));
                historyLabel.setText("cos" + historyLabel.getText().replace(',', '.'));
                resultDisplayed = false;
            }
        });
        jFrame.add(buttonCos);

        JButton buttonSin = new JButton("sin");
        buttonSin.setSize(buttonSize);
        buttonSin.setBackground(otherButtonColor);
        buttonSin.setForeground(Color.WHITE);
        buttonSin.setFont(font);
        buttonSin.setLocation(97, 180);
        buttonSin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double currentValue = Double.parseDouble(textField.getText().replace(',', '.'));
                textField.setText(df.format(Math.sin(currentValue)));
                historyLabel.setText("sin" + historyLabel.getText().replace(',', '.'));
                resultDisplayed = false;
            }
        });
        jFrame.add(buttonSin);

        JButton buttonCl = new JButton("C");
        buttonCl.setSize(buttonSize);
        buttonCl.setBackground(otherButtonColor);
        buttonCl.setForeground(Color.WHITE);
        buttonCl.setFont(font);
        buttonCl.setLocation(189, 180);
        buttonCl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                historyLabel.setText("");
                resultDisplayed = false;
            }
        });
        jFrame.add(buttonCl);

        JButton buttonChist = new JButton("←");
        buttonChist.setSize(buttonSize);
        buttonChist.setBackground(otherButtonColor);
        buttonChist.setForeground(Color.WHITE);
        buttonChist.setFont(font);
        buttonChist.setLocation(282, 180);
        buttonChist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (resultDisplayed) {
                    historyLabel.setText("");
                    return;
                }
                if ("Division by zero is impossible".equals(textField.getText().replace(',', '.')) || "You have already .".equals(textField.getText().replace(',', '.'))) {
                    return;
                } else
                    textField.setText(textField.getText().substring(0, textField.getText().replace(',', '.').length() - 1));
                historyLabel.setText(historyLabel.getText().substring(0, historyLabel.getText().replace(',', '.').length() - 1));
            }
        });
        jFrame.add(buttonChist);

        jFrame.setVisible(true);
    }

    private void ErrorByZero() {
        if ("Division by zero is impossible".equals(textField.getText()) || "You have already .".equals(textField.getText())) {
            textField.setText("");
        }
    }


}
