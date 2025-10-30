# Observer Anti-Pattern - Exemplo em Java

Este exemplo mostra um anti-pattern: o Subject conhece detalhes das classes concretas e usa `instanceof` para chamar métodos diferentes.  
Isso viola o princípio do aberto/fechado (OCP) e gera forte acoplamento.

## UML
                    ┌───────────────────────────────────────┐
                    │         GerenciadorDeBiblioteca       │
                    ├───────────────────────────────────────┤
                    │ - livros: List<Livro>                 │
                    │ - usuarios: List<Usuario>             │
                    ├───────────────────────────────────────┤
                    │ + adicionarLivro(l: Livro)            │
                    │ + adicionarUsuario(u: Usuario)        │
                    │ + emprestarLivro(l: Livro, u: Usuario)│
                    │ - notificarTodos(msg: String)         │
                    └───────────────┬───────────────────────┘
                                    │
                Notifica todos      │
                (sem filtro)        │
                                    ▼
                    ┌──────────────────────────────────┐
                    │             Usuario              │
                    ├──────────────────────────────────┤
                    │ - nome: String                   │
                    ├──────────────────────────────────┤
                    │ + getNome(): String              │
                    │ + receberNotificacao(msg: String)│
                    └──────────────────────────────────┘
                                    ▲
                                    │
                Empresta livro      │
                                    │
                    ┌──────────────────────────────┐
                    │            Livro             │
                    ├──────────────────────────────┤
                    │ - titulo: String             │
                    │ - disponivel: boolean        │
                    ├──────────────────────────────┤
                    │ + getTitulo(): String        │
                    │ + isDisponivel(): boolean    │
                    │ + setDisponivel(b: boolean)  │
                    └──────────────────────────────┘

## Código

```java
    // CLASSE CENTRALIZADORA (Antipadrão)
    class GerenciadorDeBiblioteca {
        private List<Livro> livros = new ArrayList<>();
        private List<Usuario> usuarios = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Lógica de empréstimo totalmente centralizada
    public void emprestarLivro(Livro livro, Usuario usuario) {
        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            System.out.println(usuario.getNome() + " emprestou o livro: " + livro.getTitulo());
            notificarTodos("O livro '" + livro.getTitulo() + "' foi emprestado por " + usuario.getNome());
        } else {
            System.out.println("Livro indisponível: " + livro.getTitulo());
        }
    }

    // Centraliza a notificação em vez de deixar os objetos interessados se registrarem
    private void notificarTodos(String mensagem) {
        for (Usuario usuario : usuarios) {
            usuario.receberNotificacao(mensagem);
        }
    }

    // E se um usuário quiser receber apenas notificações de um gênero ou autor?
    // Não há como — todos recebem tudo (exemplo clássico do antipadrão).
    }
    
    // CLASSE DE DOMÍNIO
    class Livro {
        private String titulo;
        private boolean disponivel;

    public Livro(String titulo, boolean disponivel) {
        this.titulo = titulo;
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    }

    // CLASSE QUE REPRESENTA O USUÁRIO
    class Usuario {
        private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void receberNotificacao(String mensagem) {
        System.out.println(nome + ", notificação: " + mensagem);
    }
    }

    // PROGRAMA PRINCIPAL
    public class BibliotecaCentralizada {
        public static void main(String[] args) {
            GerenciadorDeBiblioteca gerenciador = new GerenciadorDeBiblioteca();

        Livro livro1 = new Livro("1984", true);
        Livro livro2 = new Livro("O Senhor dos Anéis", true);

        Usuario usuario1 = new Usuario("Ana");
        Usuario usuario2 = new Usuario("Carlos");
        Usuario usuario3 = new Usuario("Marina");

        gerenciador.adicionarLivro(livro1);
        gerenciador.adicionarLivro(livro2);
        gerenciador.adicionarUsuario(usuario1);
        gerenciador.adicionarUsuario(usuario2);
        gerenciador.adicionarUsuario(usuario3);

        // Ana pega um livro — todos recebem notificação, mesmo quem não se importa
        gerenciador.emprestarLivro(livro1, usuario1);

        // Carlos tenta pegar o mesmo livro
        gerenciador.emprestarLivro(livro1, usuario2);
    }
}

