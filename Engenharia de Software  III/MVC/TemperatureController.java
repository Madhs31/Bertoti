public class TemperatureController {
    private TemperatureModel model;

    public TemperatureController(TemperatureModel model) {
        this.model = model;
    }

    // Ação do usuário: Mudar a temperatura Celsius
    public void changeTemperature(double newCelsius) {
        System.out.println("\n[CONTROLLER] Ação do usuário: Mudando temperatura para " + newCelsius + "°C...");
        // O Controller chama o método de alteração de estado no Model
        model.setCelsius(newCelsius);
    }
}