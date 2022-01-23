package moneycalculator.persistance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.model.Currency;


public class CurrenciesFileReader implements CurrenciesLoader {

    private final String file;

    public CurrenciesFileReader(String file) {
        this.file = file;
    }
    
    @Override
    public ArrayList<Currency> load() {
        ArrayList<Currency> currencies = new ArrayList<>();
        String line;
        
        try {
            BufferedReader bf = new BufferedReader(new FileReader(this.file));
            
            while((line = bf.readLine()) != null){
                String[] c = line.split(",");
                Currency currency = new Currency(c[1], c[0], "hola");
                currencies.add(currency);
            }
            return currencies;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CurrenciesFileReader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(CurrenciesFileReader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
