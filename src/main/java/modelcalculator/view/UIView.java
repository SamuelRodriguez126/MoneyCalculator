package modelcalculator.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import modelcalculator.controller.MoneyCalculator;
import moneycalculator.model.Currency;


public final class UIView extends JFrame implements View {

    private Currency currencyFrom;
    private Currency currencyTo;
    private double amount;
    private MoneyCalculator mc;
    private final JLabel importe = new JLabel();
    
    public UIView(ArrayList<Currency> currencies) {
        this.setTitle("Money Calculator");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.getContentPane().add(this.configPanel(currencies));
        this.getContentPane().add(this.displayPanel());
        this.setVisible(true);
    }
    
    private JPanel configPanel(ArrayList<Currency> currencies){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("Currency From: "));
        panel.add(new JLabel("Currency To: "));
        panel.add(this.comboFrom(currencies));
        panel.add(this.comboTo(currencies));
        panel.add(new JLabel("Amount: "));
        panel.add(this.amountText());        
        return panel;
    }
    
    private JPanel displayPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.add(new JLabel("Result: "));
        panel.add(this.importe);
        return panel;
    }
    
    private JTextField amountText(){
        JTextField text = new JTextField();
        text.addActionListener(this.amountListener());
        return text;
    }
    
    private ActionListener amountListener(){
        return (ActionEvent ae) -> {
            amount = Double.parseDouble(((JTextField) ae.getSource()).getText());
            try {
                UIView.this.mc.update();
            }catch (IOException ex) {
                Logger.getLogger(UIView.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
    }
    
    private JComboBox comboFrom(ArrayList<Currency> currencies){
        JComboBox<Currency> combo = new JComboBox();
        currencies.forEach((currency) -> {
            combo.addItem(currency);
        });
        combo.addActionListener(this.comboFromListener());
        this.currencyFrom = (Currency) combo.getSelectedItem();
        return combo;
    }
    
    public void setResult(double value){
        this.importe.setText(String.valueOf(value));
    }
    
    private JComboBox comboTo(ArrayList<Currency> currencies){
        JComboBox<Currency> combo = new JComboBox();
        currencies.forEach((currency) -> {
            combo.addItem(currency);
        });
        combo.addActionListener(this.comboToListener());
        this.currencyTo = (Currency) combo.getSelectedItem();
        return combo;
    }
    
    private ActionListener comboFromListener(){
        return (ActionEvent ae) -> {
            currencyFrom = (Currency) ((JComboBox) ae.getSource()).getSelectedItem();
            try {
                UIView.this.mc.update();
            }catch (IOException ex) {
                Logger.getLogger(UIView.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
    }
    
    private ActionListener comboToListener(){
        return (ActionEvent ae) -> {
            currencyTo = (Currency) ((JComboBox) ae.getSource()).getSelectedItem();
            try {
                UIView.this.mc.update();
            }catch (IOException ex) {
                Logger.getLogger(UIView.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
    }
    
    @Override
    public Double amount() {
        return this.amount;
    }

    @Override
    public Currency currencyFrom() {
        return this.currencyFrom;
    }

    @Override
    public Currency currencyTo() {
        return this.currencyTo;
    }
    
    public void setController(MoneyCalculator mc){
        this.mc = mc;
    }
}
