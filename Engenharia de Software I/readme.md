# Aula I
  We see three critical differences between programming and software engineering: time, scale, and the trade-offs at play. On a software engineering project, engineers need to be more concerned with the passage of time and the eventual need for change. 
In a software engineering organization, we need to be more concerned about scale and efficiency, both for the software we produce as well as for the organization that is producing it. 
Finally, as software engineers, we are asked to make more complex decisions with higher-stakes outcomes, often based on imprecise estimates of time and growth.

### Comentário:
  No texto, é ressaltado como os engenheiros de software enfrentam decisões mais complexas e arriscadas, muitas vezes baseadas em hipóteses. Isso implica que a engenharia de software requer uma visão estratégica e uma abordagem mais holística em comparação à programação, que é mais focada em tarefas específicas e imediatas.

# Aula II
  Within Google, we sometimes say, “Software engineering is programming integrated over time.” Programming is certainly a significant part of software engineering: after all, programming is how you generate new software in the first place. If you accept this distinction, it also becomes clear that we might need to delineate between programming tasks (development) and software engineering tasks (development, modification, maintenance). The addition of time adds an important new dimension to programming. Cubes aren’t squares, distance isn’t velocity. Software engineering isn’t programming.

### Comentário:
  O trecho destaca que a engenharia de software é mais ampla do que a programação. Embora a programação seja essencial para criar software, a engenharia de software inclui também o desenvolvimento, a modificação e a manutenção ao longo do tempo. Enquanto a programação foca na escrita de código, a engenharia de software considera o ciclo de vida do software e as mudanças que ele sofrerá. Assim, a engenharia de software envolve uma visão mais abrangente e temporal.

# Exemplos de trade-offs com requisitos não funcionais

## Desempenho vs. Segurança:

### ► Desempenho:

**• Vantagem:** Sistemas mais rápidos e responsivos.
**• Desvantagem:** A redução na segurança pode deixar o sistema mais vulnerável a ataques e falhas.

###  ► Segurança:

**• Vantagem:** Maior proteção contra ataques e brechas de segurança.
**• Desvantagem:** Pode haver uma redução na velocidade de resposta e na eficiência geral do sistema.

##

## Escalabilidade vs. Custo:

### ► Escalabilidade:

**• Vantagem:** Capacidade de suportar crescimento e aumento de usuários sem necessidade de grandes reengenharias.
**• Desvantagem:** Arquiteturas escaláveis, como microserviços, podem ser caras para implementar e manter.

### ► Custo:

**• Vantagem:** Soluções mais baratas reduzem os custos iniciais e de manutenção.
**• Desvantagem:** A capacidade de crescimento do sistema pode ser limitada e pode exigir reengenharia para escalar.

##

## Usabilidade vs. Funcionalidade:

### ► Usabilidade:

**• Vantagem:** Interface intuitiva e fácil de usar melhora a experiência do usuário e reduz a curva de aprendizado.
**• Desvantagem:** Pode limitar a adição de funcionalidades avançadas, tornando o sistema menos poderoso.

### ► Funcionalidade:

**• Vantagem:** Maior gama de recursos e capacidades para atender necessidades específicas dos usuários.
**• Desvantagem:** A complexidade adicional pode tornar a interface mais difícil de usar e entender.

# Atividade 3

## Análise das trade-offs na arquitetura da Netflix

<img src="/assets/img/Netinha.jpg" height="550">

1. Escalabilidade vs. Complexidade
   
Escalabilidade:
Netflix usa uma arquitetura de microsserviços, permitindo a escalabilidade horizontal dos serviços, o que é crucial para lidar com grandes volumes de tráfego e dados.

Vantagens:
Escalabilidade Flexível: Permite que partes específicas da aplicação sejam escaladas conforme a demanda, melhorando a eficiência dos recursos.
Resiliência: Falhas em um serviço não afetam diretamente outros serviços, aumentando a robustez da aplicação.

Desvantagens:
Complexidade: A gestão de uma rede de microsserviços requer ferramentas e práticas avançadas para monitoramento e comunicação entre serviços.
Manutenção: A manutenção e a coordenação entre vários serviços podem ser desafiadoras e exigem mais esforço.

Complexidade:
Ferramentas como Eureka (descoberta de serviços), Zuul (roteamento) e outros componentes são usados para gerenciar a comunicação e o roteamento.

Vantagens:
Desacoplamento: Serviços independentes permitem atualizações e implementações sem afetar o sistema como um todo.
Inovação Ágil: Facilita a experimentação e a introdução de novas funcionalidades em partes específicas da aplicação.

Desvantagens:
Sobrecarga Operacional: Aumenta a carga sobre a equipe de operações para gerenciar a comunicação e a integridade entre os serviços.
Gerenciamento de Falhas: Aumenta a complexidade no gerenciamento de falhas e na garantia de consistência entre os serviços.

2. Disponibilidade vs. Consistência

Disponibilidade:
A Netflix adota práticas de replicação e redundância para garantir que o serviço permaneça disponível mesmo diante de falhas.

Vantagens:
Resiliência: Garante que o serviço esteja disponível para os usuários, minimizando o impacto de falhas.
Experiência do Usuário: Mantém uma experiência de usuário contínua e sem interrupções.

Desvantagens:
Consistência Eventual: Pode levar a uma inconsistência temporária nos dados, onde as informações podem não estar atualizadas em todos os pontos do sistema.

Consistência:
Para garantir alta disponibilidade, a Netflix pode optar por consistência eventual em vez de consistência forte.

Vantagens:
Desempenho: Melhora o desempenho ao reduzir a necessidade de sincronização instantânea entre todos os serviços.
Escalabilidade: Facilita a escalabilidade ao permitir operações distribuídas de forma mais flexível.

Desvantagens:
Desafios de Sincronização: Pode complicar a lógica de aplicação e a garantia de que todos os serviços estão operando com dados atualizados.

3. Desempenho vs. Custo
Desempenho:
Netflix utiliza caches em larga escala e CDNs para melhorar o desempenho e reduzir a latência na entrega de conteúdo.

Vantagens:
Experiência Rápida: Melhora a velocidade de resposta e a experiência do usuário.
Eficiência: Reduz a carga sobre os servidores e redes, otimizando o uso de recursos.

Desvantagens:
Custo: Investimentos em tecnologia de cache e infraestrutura de CDNs podem ser altos.
Complexidade Adicional: A implementação de estratégias de cache pode adicionar complexidade ao sistema.

Custo:
A Netflix utiliza serviços em nuvem, como AWS, para gerenciar a escalabilidade e otimizar os custos de hardware.

Vantagens:
Eficiência de Recursos: Pagamento por uso pode reduzir custos operacionais em comparação com a compra e manutenção de hardware próprio.
Escalabilidade Econômica: Aumenta a capacidade conforme necessário sem grandes investimentos iniciais.

Desvantagens:
Custo Variável: Os custos de uso da nuvem podem se tornar significativos, especialmente com grandes volumes de dados e tráfego.
Gerenciamento: A gestão de recursos em nuvem pode ser complexa e exigir estratégias eficazes de controle de custos.

4. Segurança vs. Usabilidade
Segurança:

Escolha: A Netflix implementa criptografia, autenticação forte e outras práticas rigorosas de segurança.

Vantagens:
Proteção de Dados: Garante a proteção dos dados dos usuários contra acessos não autorizados e ameaças.
Conformidade: Atende a requisitos de conformidade e regulatórios.

Desvantagens:
Impacto na Usabilidade: Medidas de segurança podem introduzir etapas adicionais para os usuários, impactando a experiência geral.
Complexidade Adicional: Requer práticas contínuas de atualização e monitoramento para garantir que as medidas de segurança sejam eficazes.

Usabilidade:
Netflix foca em proporcionar uma experiência de usuário fluida e intuitiva.

Vantagens:
Experiência Positiva: Facilita o uso do serviço e melhora a satisfação do usuário.
Acesso Rápido: Minimiza barreiras e permite acesso rápido e fácil ao conteúdo.

Desvantagens:
Compromissos de Segurança: Pode ser necessário fazer concessões na segurança para manter a usabilidade.
Risco de Fraudes: Menos segurança pode aumentar o risco de fraudes e acessos não autorizados.

5. Desenvolvimento Rápido vs. Estabilidade
Desenvolvimento Rápido:

A arquitetura de microsserviços permite que equipes desenvolvam e implantem novos recursos rapidamente.

Vantagens:
Inovação Ágil: Facilita a experimentação e a implementação de novas funcionalidades.
Ciclo de Lançamento Acelerado: Permite lançamentos frequentes e rápidos de atualizações.

Desvantagens:
Risco de Instabilidade: A velocidade de desenvolvimento pode levar a instabilidades e bugs, se não for acompanhada por práticas rigorosas de testes.
Complexidade de Integração: A integração rápida de novos recursos pode introduzir desafios na consistência e na integração com outros sistemas.

Estabilidade:
A Netflix investe em práticas rigorosas de testes e monitoramento para manter a estabilidade do sistema.

Vantagens:
Confiabilidade: Garante que a aplicação opere de forma confiável e consistente.
Redução de Falhas: Minimiza a probabilidade de falhas críticas e problemas de desempenho.

Desvantagens:
Velocidade de Implementação: Pode desacelerar a capacidade de lançar novos recursos e atualizações rapidamente.
Custo Adicional: Exige investimento em ferramentas e práticas para garantir a estabilidade.
