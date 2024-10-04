package Loja;

import java.util.ArrayList;
import java.util.List;

class Loja {
    private List<Clientes> clientes;
    private List<Produtos> produtos;

    public Loja() {
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.produtos = produtos;
    }

    public void adicionarProduto(Produtos produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(Produtos produto) {
        this.produtos.remove(produto);
    }
}
