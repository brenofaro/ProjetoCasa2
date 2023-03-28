public class KeyFormatter {

    // Método usado para formatar o enum para texto
    public static String keyFormat(Chave key){
        if (key == Chave.CHAVE_GARAGEM){
            return "Chave da Garagem";
        } else if (key == Chave.CHAVE_CARRO) {
            return "Chave do Carro";
        }
        return null;
    }
}
