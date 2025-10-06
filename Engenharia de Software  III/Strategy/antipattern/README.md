    
    // Enum para tipo de serviço na biblioteca
    public enum TipoServico {
        EMPRESTIMO,
        DEVOLUCAO,
        MULTA
    }
    
    // Classe com o Anti-Padrão
    public class Biblioteca {
        private int livrosDisponiveis;

    public Biblioteca(int livrosDisponiveis) {
        this.livrosDisponiveis = livrosDisponiveis;
    }

    // Método que concentra toda a lógica e viola o Princípio Aberto/Fechado
    public double realizarServico(TipoServico tipo, int diasAtraso) {
        double valor = 0.0;

        switch (tipo) {
            case EMPRESTIMO:
                // Lógica de empréstimo
                if (livrosDisponiveis > 0) {
                    valor = 0.0; // Não cobra para emprestar
                    livrosDisponiveis--;
                } else {
                    throw new IllegalStateException("Não há livros disponíveis para empréstimo.");
                }
                break;
            case DEVOLUCAO:
                // Lógica de devolução
                valor = 0.0;
                livrosDisponiveis++;
                break;
            case MULTA:
                // Lógica de multa
                valor = diasAtraso * 2.0; // R$2 por dia de atraso
                break;
            // Para adicionar um novo tipo de serviço,
            // seria necessário adicionar um novo "case" aqui,
            // modificando a classe Biblioteca.
            default:
                throw new IllegalArgumentException("Tipo de serviço desconhecido.");
        }

        return valor;
    }
    }
    
    // Classe principal para testar o antipadrão
    public class SistemaBiblioteca {
        public static void main(String[] args) {
            Biblioteca biblioteca = new Biblioteca(3);

        double multa = biblioteca.realizarServico(TipoServico.MULTA, 4);
        System.out.println("Valor da multa: R$ " + multa);

        biblioteca.realizarServico(TipoServico.EMPRESTIMO, 0);
        System.out.println("Livro emprestado. Livros restantes: " + biblioteca.livrosDisponiveis);

        biblioteca.realizarServico(TipoServico.DEVOLUCAO, 0);
        System.out.println("Livro devolvido. Livros disponíveis: " + biblioteca.livrosDisponiveis);
    }
}
