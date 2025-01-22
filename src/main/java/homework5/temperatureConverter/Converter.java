package homework5.temperatureConverter;

public class Converter {
    private double resultCelsius = 0;
    private double resultFahrenheit = 0;
    private double resultKelvins = 0;

    public Converter(double value, CI CIFrom) {
        switch (CIFrom) {
            case CI.C : {
                setResultCelsius(value);
                break;
            }
            case CI.F : {
                setResultFahrenheit(value);
                break;
            }
            case CI.K : {
                setResultKelvins(value);
                break;
            }
        }
    }

    public double getResultCelsius() {
        return resultCelsius;
    }

    public static void convertPrint(double value, CI CIFrom, CI CITo) {
        Converter converter = new Converter(value, CIFrom);
        double result = 0;

        switch (CITo){
            case CI.C : {
                result = converter.getResultCelsius();
                break;
            }
            case CI.F : {
                result = converter.getResultFahrenheit();
                break;
            }
            case CI.K : {
                result = converter.getResultKelvins();
                break;
            }
        }
        System.out.println(value + CIFrom.toString() + " = " + result + CITo.toString());
    }

    public void setResultCelsius(double resultCelsius) {
        this.resultCelsius = resultCelsius;
        this.resultFahrenheit = (9 / 5) * resultCelsius + 32;
        this.resultKelvins = resultCelsius + 273.15D;
    }

    public double getResultFahrenheit() {
        return resultFahrenheit;
    }

    public void setResultFahrenheit(double resultFahrenheit) {
        this.resultFahrenheit = resultFahrenheit;
        this.resultCelsius = (5 / 9) * resultFahrenheit - 32;
        this.resultKelvins = 5 * (resultFahrenheit - 32) / 9 + 273.15D;
    }

    public double getResultKelvins() {
        return resultKelvins;
    }

    public void setResultKelvins(double resultKelvins) {
        this.resultKelvins = resultKelvins;
        this.resultCelsius = resultKelvins - 273.15D;
        this.resultFahrenheit = 9 * (resultKelvins - 273.15D) / 5 + 32;
    }
}
