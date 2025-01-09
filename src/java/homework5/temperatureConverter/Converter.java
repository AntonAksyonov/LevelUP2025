package homework5.temperatureConverter;

public enum Converter {
    C, F, K;

    private double resultCelsius = 0;
    private double resultFahrenheit = 0;
    private double resultKelvins = 0;

    public double getResultCelsius() {
        return resultCelsius;
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
