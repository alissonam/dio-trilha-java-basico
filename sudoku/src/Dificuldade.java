public enum Dificuldade {
    FACIL(35),
    MEDIO(45),
    DIFICIL(55);

    private final int celulasVazias;

    Dificuldade(int celulasVazias) {
        this.celulasVazias = celulasVazias;
    }

    public int getCelulasVazias() {
        return celulasVazias;
    }
}
