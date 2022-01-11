package estrutura.dados.arvore;

import estrutura.dados.arvore.model.Arvore;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria<Arvore> minhaArvore = new ArvoreBinaria<>();
        minhaArvore.inserir(new Arvore(13));
        minhaArvore.inserir(new Arvore(10));
        minhaArvore.inserir(new Arvore(25));
        minhaArvore.inserir(new Arvore(2));
        minhaArvore.inserir(new Arvore(20));
        minhaArvore.inserir(new Arvore(31));
        minhaArvore.inserir(new Arvore(29));

        minhaArvore.exibirEmOrdem();
        minhaArvore.exibirEmPreOrdem();
        minhaArvore.exibirEmPosOrdem();
    }
}
