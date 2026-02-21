package mx.florinda.leitor;

public record ItemCardapioJsonDTO(
        long id,
        String nome,
        String descricao,
        double preco,
        String categoria,
        boolean emPromocao,
        Double precoComDesconto,
        boolean impostoIsento,
        boolean semGluten
) {}
