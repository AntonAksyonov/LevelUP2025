package homework5.temperatureConverter;

public class ConverterRunner {

    private static void convertPrint(double value, Converter converterFrom, Converter converterTo) {
        double result = 0;
        switch (converterFrom) {
            case Converter.C : {
                converterFrom.setResultCelsius(value);
                break;
            }
            case Converter.F : {
                converterFrom.setResultFahrenheit(value);
                break;
            }
            case Converter.K : {
                converterFrom.setResultKelvins(value);
                break;
            }
        }

        switch (converterTo){
            case Converter.C : {
                result = converterFrom.getResultCelsius();
                break;
            }
            case Converter.F : {
                result = converterFrom.getResultFahrenheit();
                break;
            }
            case Converter.K : {
                result = converterFrom.getResultKelvins();
                break;
            }
        }
        System.out.println(value + converterFrom.toString() + " = " + result + converterTo.toString());
    }

    public static void main(String[] args) {
        convertPrint(32, Converter.C, Converter.K);
    }
}
