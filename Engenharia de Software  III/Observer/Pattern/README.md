# Observer Pattern - Exemplo em Java

O Observer é usado para desacoplar a fonte de eventos (Subject) dos seus consumidores (Observers).  
Cada Observer se registra no Subject, e este notifica todos quando seu estado muda.

## UML

                ┌──────────────────────────────────┐
                │            <<interface>>         │
                │               Usuario            │
                ├──────────────────────────────────┤
                │ + atualizar(tituloLivro: String) │
                └───────────────┬──────────────────┘
                                │
                                │ implements
                                ▼
                ┌──────────────────────────────────┐
                │           UsuarioConcreto        │
                ├──────────────────────────────────┤
                │ - nome: String                   │
                ├──────────────────────────────────┤
                │ + atualizar(tituloLivro: String) │
                └──────────────────────────────────┘


                ┌────────────────────────────────┐
                │         <<interface>>          │
                │          LivroSubject          │
                ├────────────────────────────────┤
                │ + registrarUsuario(u: Usuario) │
                │ + removerUsuario(u: Usuario)   │
                │ + notificarUsuarios()          │
                └───────────────┬────────────────┘
                                │
                                │ implements
                                ▼
                ┌───────────────────────────────────────┐
                │                 Livro                 │
                ├───────────────────────────────────────┤
                │ - titulo: String                      │
                │ - disponivel: boolean                 │
                │ - usuariosInteressados: List<Usuario> │
                ├───────────────────────────────────────┤
                │ + getTitulo(): String                 │
                │ + isDisponivel(): boolean             │
                │ + emprestar(): void                   │
                │ + devolver(): void                    │
                │ + registrarUsuario(u: Usuario)        │
                │ + removerUsuario(u: Usuario)          │
                │ + notificarUsuarios(): void           │
                └───────────────────────────────────────┘

## Código

    // ===================== OBSERVER =====================
    interface Usuario {
        void atualizar(String tituloLivro);
    }
    
    // ===================== SUBJECT =====================
    interface LivroSubject {
        void registrarUsuario(Usuario usuario);
        void removerUsuario(Usuario usuario);
        void notificarUsuarios();
    }
    
    // ===================== CONCRETE SUBJECT =====================
    class Livro implements LivroSubject {
        private String titulo;
        private boolean disponivel;
        private List<Usuario> usuariosInteressados = new ArrayList<>();

    public Livro(String titulo) {
        this.titulo = titulo;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println(" O livro '" + titulo + "' foi emprestado.");
        } else {
            System.out.println(" O livro '" + titulo + "' não está disponível.");
        }
    }

    public void devolver() {
        disponivel = true;
        System.out.println(" O livro '" + titulo + "' foi devolvido.");
        notificarUsuarios();
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuariosInteressados.add(usuario);
    }

    @Override
    public void removerUsuario(Usuario usuario) {
        usuariosInteressados.remove(usuario);
    }

    @Override
    public void notificarUsuarios() {
        for (Usuario usuario : usuariosInteressados) {
            usuario.atualizar(titulo);
        }
    }
    }
    
    // ===================== CONCRETE OBSERVER =====================
    class UsuarioConcreto implements Usuario {
        private String nome;

    public UsuarioConcreto(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String tituloLivro) {
        System.out.println(" + nome + ", o livro '" + tituloLivro + "' está disponível para empréstimo!");
    }
    }
    
    // ===================== MAIN =====================
    public class BibliotecaObserver {
        public static void main(String[] args) {
            Livro livro1 = new Livro("1984");
            Livro livro2 = new Livro("O Senhor dos Anéis");

        Usuario usuario1 = new UsuarioConcreto("Ana");
        Usuario usuario2 = new UsuarioConcreto("Carlos");

        // Usuários se registram para receber notificações de livros específicos
        livro1.registrarUsuario(usuario1);
        livro1.registrarUsuario(usuario2);
        livro2.registrarUsuario(usuario2);

        // Ana pega o livro "1984"
        livro1.emprestar();

        // Quando o livro é devolvido, apenas os interessados são notificados
        livro1.devolver();

        // Carlos pega e devolve "O Senhor dos Anéis"
        livro2.emprestar();
        livro2.devolver();
    }
    }
