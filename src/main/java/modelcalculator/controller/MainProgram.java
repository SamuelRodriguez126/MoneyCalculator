package modelcalculator.controller;

import java.util.ArrayList;
import moneycalculator.model.Currency;
import moneycalculator.persistance.CurrenciesFileReader;

public class MainProgram {
    public static void main(String[] args){
        String file = "currencies.txt";
        CurrenciesFileReader reader = new CurrenciesFileReader(file);
        ArrayList<Currency> currencies = reader.load();
        
        MoneyCalculator mc = new MoneyCalculator(currencies);
        
    }
}
