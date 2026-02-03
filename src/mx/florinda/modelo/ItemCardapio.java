package mx.florinda.modelo;

public class ItemCardapio {

    // atributos
    private long id;
    private String nome;
    private String descricao;
    private boolean emPromocao;
    private double preco;
    private double precoComDesconto;
    private CategoriaCardapio categoria;

    //construtor
    protected ItemCardapio(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    //metodos
    public double getPorcentagemDesconto() {
        return (preco - precoComDesconto) / preco * 100;
    }

    public void setPromocao(double precoComDesconto) {
        emPromocao = true;
        this.precoComDesconto = precoComDesconto;
    }

    public double getImposto() {
        double imposto;
        if (emPromocao) {
            imposto = precoComDesconto * 0.1;
        } else {
            imposto = preco * 0.1;
        }
        return imposto;
    }

    public boolean ehSemGluten() { return false; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isEmPromocao() {
        return emPromocao;
    }

    public void setEmPromocao(boolean emPromocao) {
        this.emPromocao = emPromocao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPrecoComDesconto() {
        return precoComDesconto;
    }

    public void setPrecoComDesconto(double precoComDesconto) {
        this.precoComDesconto = precoComDesconto;
    }

    public CategoriaCardapio getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaCardapio categoria) {
        this.categoria = categoria;
    }
}