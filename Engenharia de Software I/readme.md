# Aula I
We see three critical differences between programming and software engineering: time, scale, and the trade-offs at play. On a software engineering project, engineers need to be more concerned with the passage of time and the eventual need for change. 
In a software engineering organization, we need to be more concerned about scale and efficiency, both for the software we produce as well as for the organization that is producing it. 
Finally, as software engineers, we are asked to make more complex decisions with higher-stakes outcomes, often based on imprecise estimates of time and growth.

## Comentário:
No texto, é ressaltado como os engenheiros de software enfrentam decisões mais complexas e arriscadas, muitas vezes baseadas em hipóteses. Isso implica que a engenharia de software requer uma visão estratégica e uma abordagem mais holística em comparação à programação, que é mais focada em tarefas específicas e imediatas.

# Aula II

Within Google, we sometimes say, “Software engineering is programming integrated over time.” Programming is certainly a significant part of software engineering: after all, programming is how you generate new software in the first place. If you accept this distinction, it also becomes clear that we might need to delineate between programming tasks (development) and software engineering tasks (development, modification, maintenance). The addition of time adds an important new dimension to programming. Cubes aren’t squares, distance isn’t velocity. Software engineering isn’t programming.

## Comentário:

O trecho destaca que a engenharia de software é mais ampla do que a programação. Embora a programação seja essencial para criar software, a engenharia de software inclui também o desenvolvimento, a modificação e a manutenção ao longo do tempo. Enquanto a programação foca na escrita de código, a engenharia de software considera o ciclo de vida do software e as mudanças que ele sofrerá. Assim, a engenharia de software envolve uma visão mais abrangente e temporal.

# Exemplos de trade-offs com requisitos não funcionais

## Desempenho vs. Segurança:

### Desempenho (Trade-off com Segurança):

#### Vantagem
Sistemas mais rápidos e responsivos.
#### Desvantagem
A redução na segurança pode deixar o sistema mais vulnerável a ataques e falhas.

### Segurança (Trade-off com Desempenho):

#### Vantagem
Maior proteção contra ataques e brechas de segurança.
#### Desvantagem
Pode haver uma redução na velocidade de resposta e na eficiência geral do sistema.

## Escalabilidade vs. Custo:

### Escalabilidade (Trade-off com Custo):

#### Vantagem
Capacidade de suportar crescimento e aumento de usuários sem necessidade de grandes reengenharias.
#### Desvantagem
Arquiteturas escaláveis, como microserviços, podem ser caras para implementar e manter.

### Custo (Trade-off com Escalabilidade):

#### Vantagem
Soluções mais baratas reduzem os custos iniciais e de manutenção.
#### Desvantagem
A capacidade de crescimento do sistema pode ser limitada e pode exigir reengenharia para escalar.

## Usabilidade vs. Funcionalidade:

### Usabilidade (Trade-off com Funcionalidade):

#### Vantagem
Interface intuitiva e fácil de usar melhora a experiência do usuário e reduz a curva de aprendizado.
#### Desvantagem
Pode limitar a adição de funcionalidades avançadas, tornando o sistema menos poderoso.

### Funcionalidade (Trade-off com Usabilidade):

#### Vantagem
Maior gama de recursos e capacidades para atender necessidades específicas dos usuários.
#### Desvantagem
A complexidade adicional pode tornar a interface mais difícil de usar e entender.
