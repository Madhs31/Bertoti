public class Main {
    public static void main(String[] args) {
        // 1. Criação do MODELO (inicia em 25°C)
        TemperatureModel model = new TemperatureModel(25.0); 

        // 2. Criação da VIEW (registra-se no Model)
        TemperatureView view = new TemperatureView(model);
        
        // 3. Criação do CONTROLLER (recebe a referência do Model)
        TemperatureController controller = new TemperatureController(model);
        
        // --- SIMULAÇÃO DE AÇÕES DO USUÁRIO ---
        
        // Ação 1: O usuário insere a temperatura de fervura (100°C)
        controller.changeTemperature(100.0);
        
        // Ação 2: O usuário insere a temperatura ambiente (20°C)
        controller.changeTemperature(20.0);
    }
}