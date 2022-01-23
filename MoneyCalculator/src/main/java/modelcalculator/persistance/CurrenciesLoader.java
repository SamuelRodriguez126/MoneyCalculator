package modelcalculator.persistance;

import java.util.ArrayList;
import modelcalculator.model.Currency;

public interface CurrenciesLoader {
    ArrayList<Currency> load();
}
