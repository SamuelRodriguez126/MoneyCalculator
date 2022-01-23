package modelcalculator.controller;

import java.io.IOException;
import java.util.ArrayList;
import modelcalculator.view.UIView;
import modelcalculator.model.Currency;
import modelcalculator.model.ExchangeRate;

public final class MoneyCalculator {
    
    private final ArrayList<Currency> currencies;
    private final UIView view;
    private final ExchangeRate exchangeRate;
    
    public MoneyCalculator(ArrayList<Currency> currencies) throws IOException {
        this.currencies = currencies;
        this.view = new UIView(this.currencies);
        this.exchangeRate = new ExchangeRate();
        this.start();
    }

    public void start() throws IOException{
        this.view.setController(this);
    }
    
    public void update() throws IOException{
        this.exchangeRate.setCurrencyFrom(this.view.currencyFrom());
        this.exchangeRate.setCurrencyTo(this.view.currencyTo());
        double rate = this.exchangeRate.getRate();
        this.view.setResult(rate * this.view.amount());
    }
}
