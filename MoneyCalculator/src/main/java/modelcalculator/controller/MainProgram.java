package modelcalculator.controller;

import java.io.IOException;
import java.util.ArrayList;
import modelcalculator.model.Currency;
import modelcalculator.persistance.CurrenciesFileReader;

public class MainProgram {
    public static void main(String[] args) throws IOException{
        String file = "currencies.txt";
        CurrenciesFileReader reader = new CurrenciesFileReader(file);
        ArrayList<Currency> currencies = reader.load();
        
        MoneyCalculator mc = new MoneyCalculator(currencies);
    }
}
