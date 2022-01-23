package modelcalculator.view;

import moneycalculator.model.Currency;

public interface View {
    Currency currencyFrom();
    Currency currencyTo();
    Double amount();
}
