public class TemperatureView implements Observer {
    private TemperatureModel model;

    public TemperatureView(TemperatureModel model) {
        this.model = model;
        this.model.addObserver(this); // A View se registra no Modelo
        System.out.println("--- View Inicializada ---");
        display(); // Exibe o estado inicial
    }

    // Chamado pelo Modelo via notifyObservers()
    @Override
    public void update() {
        display();
    }
    
    // Método para exibir o estado atual
    private void display() {
        System.out.println("------------------------------------------");
        System.out.printf("Temperatura em Celsius: %.2f°C%n", model.getCelsius());
        System.out.printf("Temperatura em Fahrenheit: %.2f°F%n", model.getFahrenheit());
        System.out.println("------------------------------------------");
    }
}