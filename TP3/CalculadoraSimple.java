import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSimple extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subButton, mulButton, divButton;

    public CalculadoraSimple() {
        setTitle("Calculadora");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);

        panel.add(num1Field);
        panel.add(num2Field);
        panel.add(resultField);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double num1 = Double.parseDouble(num1Field.getText());
        double num2 = Double.parseDouble(num2Field.getText());
        double result = 0;

        if (e.getSource() == addButton) {
            result = num1 + num2;
        } else if (e.getSource() == subButton) {
            result = num1 - num2;
        } else if (e.getSource() == mulButton) {
            result = num1 * num2;
        } else if (e.getSource() == divButton) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                resultField.setText("Error: División por cero");
                return;
            }
        }

        resultField.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraSimple());
    }
}
