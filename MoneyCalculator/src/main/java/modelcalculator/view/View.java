package modelcalculator.view;

import modelcalculator.model.Currency;

public interface View {
    Currency currencyFrom();
    Currency currencyTo();
    Double amount();
}
