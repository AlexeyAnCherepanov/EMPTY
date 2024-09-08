package Task3;

/**
 1 Написать аналог Enum (как если бы до Java 1.5) на примере какого-нибудь
 2 перечислимого списка, например списка валют.
 3 Нужно:
 4 самое важное требование, которое следует удовлетворять в процессе всей реализации - расставить как
 можно меньшее количество граблей для разработчика, который в будущем будет добавлять новые значения
 5 иметь фиксированный список значений, задаваемый на этапе компиялции
 6 иметь строгую типизацию значений
 7 уметь безопасно сравнивать значения по --
 8 получать все значения
 9 иметь неизменяемый ordinal (порядковый номер с 0 в порядке объявления значений)
 10 получать значения по ordinal
 11 иметь название значения, совпадающее с названием поля для значения
 12 искать по имени
 13
 */
public class AnalogEnum {
    public static final int PENNY = 1;
    public static final int NICKLE = 5;
    public static final int DIME = 10;
    public static final int QUARTER = 25;

    private AnalogEnum() {
    } // Приватный конструктор для предотвращения создания экземпляров

    public static String getName(int currency) {
        switch (currency) {
            case PENNY:
                return "Penny";
            case NICKLE:
                return "Nickle";
            case DIME:
                return "Dime";
            case QUARTER:
                return "Quarter";
            default:
                return "Unknown";
        }
    }

    public static int[] getAllValues() {
        return new int[]{PENNY, NICKLE, DIME, QUARTER};
    }

    public static boolean isValidCurrency(int currency) {
        return currency == PENNY ||
                currency == NICKLE ||
                currency == DIME ||
                currency == QUARTER;
    }

    public static int getOrdinal(String name) {
        switch (name.toLowerCase()) {
            case "penny":
                return PENNY;
            case "nickle":
                return NICKLE;
            case "dime":
                return DIME;
            case "quarter":
                return QUARTER;
            default:
                throw new IllegalArgumentException("Invalid currency name");
        }
    }
}

