# 🌡️ Conversor de Temperatura MVC em Java

Este é um projeto pequeno e didático em Java para demonstrar a aplicação dos padrões de design **Model-View-Controller (MVC)**.

O objetivo é simular um conversor de temperatura simples, onde o dado (temperatura em Celsius) é manipulado por um Controller e a View é automaticamente atualizada sem saber como a mudança ocorreu, apenas reagindo a ela.

## 📐 Padrões de Design Utilizados

| Padrão | Componente |
| :--- | :--- |
| **Model-View-Controller (MVC)** | Arquitetura principal para separar responsabilidades. |

## 📁 Estrutura do Projeto

O projeto é dividido em três camadas principais de acordo com o MVC:

### 1. Model (`TemperatureModel.java`)

* **Responsabilidade**: Gerenciar o estado dos dados e a lógica de negócio.
* **Detalhes**: Armazena as temperaturas em Celsius e Fahrenheit.
* Implementa a interface `Observable`: Notifica todas as Views (Observers) registradas sempre que a temperatura em Celsius é alterada (`setCelsius()`), garantindo que o estado do sistema seja consistente.
* Contém a lógica de conversão de `Celsius` para `Fahrenheit`.

### 2. View (`TemperatureView.java`)

* **Responsabilidade**: Apresentar os dados ao usuário.
* **Detalhes**: Recebe o Modelo no construtor e registra-se como um `Observer`.
* Implementa a interface `Observer`: Contém o método `update()`, que é invocado pelo Modelo para que a View possa buscar e exibir os novos valores de temperatura.

### 3. Controller (`TemperatureController.java`)

* **Responsabilidade**: Lidar com as entradas do usuário e atualizar o Modelo.
* **Detalhes**: Contém o método `changeTemperature(double newCelsius)`, que simula a ação de um usuário inserindo um novo valor.
* **Fluxo**: O Controller manipula **apenas** o Modelo, chamando o método `setCelsius()`. Ele não interage diretamente com a View.

## 🚀 Execução (Simulação em `Main.java`)

O arquivo `Main.java` orquestra a inicialização dos componentes e simula duas interações de usuário:

1.  O sistema é iniciado com 25°C. A View exibe o estado inicial.
2.  O Controller simula a mudança para 100°C.
3.  O Controller simula a mudança para 20°C.
