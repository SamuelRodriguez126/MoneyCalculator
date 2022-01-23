package moneycalculator.persistance;

import java.util.ArrayList;
import moneycalculator.model.Currency;

public interface CurrenciesLoader {
    ArrayList<Currency> load();
}
