import java.util.ArrayList;
import java.util.List;

public class TemperatureModel implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private double celsius;
    private double fahrenheit;

    public TemperatureModel(double initialTemp) {
        this.celsius = initialTemp;
        this.fahrenheit = convertToFahrenheit(initialTemp);
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    // Setter: Atualiza o estado e notifica a View
    public void setCelsius(double celsius) {
        this.celsius = celsius;
        this.fahrenheit = convertToFahrenheit(celsius);
        notifyObservers(); // <<< Notifica as Views
    }

    // Lógica de Negócio
    private double convertToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    // Implementação Observable
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }
}