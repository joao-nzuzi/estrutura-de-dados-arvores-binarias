package estrutura.dados.arvore;

public class ArvoreBinaria<T extends Comparable<T>> {

    private NoBinario<T> raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void inserir(T conteudo){
        NoBinario<T> novoNo = new NoBinario<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }

    private NoBinario<T> inserir(NoBinario<T> noAtual, NoBinario<T> novoNo) {
        if(noAtual == null){
            return novoNo;
        }else if(novoNo.getConteudo().compareTo(noAtual.getConteudo()) < 0){
            noAtual.setNoEsquerdo(inserir(noAtual.getNoEsquerdo(), novoNo));
        }else{
            noAtual.setNoDireito(inserir(noAtual.getNoDireito(), novoNo));
        }

        return noAtual;
    }

    public void exibirEmOrdem(){
        System.out.println("\nExibição da árvore em ordem");
        exibirEmOrdem(this.raiz);
    }

    private void exibirEmOrdem(NoBinario<T> noAtual) {
        if(noAtual != null){
            exibirEmOrdem(noAtual.getNoEsquerdo());
            System.out.print(noAtual.getConteudo() + ", ");
            exibirEmOrdem(noAtual.getNoDireito());
        }
    }

    public void exibirEmPreOrdem(){
        System.out.println("\nExibição da árvore em pré-ordem");
        exibirEmPreOrdem(this.raiz);
    }

    private void exibirEmPreOrdem(NoBinario<T> noAtual) {
        if(noAtual != null){
            System.out.print(noAtual.getConteudo() + ", ");
            exibirEmOrdem(noAtual.getNoEsquerdo());
            exibirEmOrdem(noAtual.getNoDireito());
        }
    }

    public void exibirEmPosOrdem(){
        System.out.println("\nExibição da árvore em pós-ordem");
        exibirEmPosOrdem(this.raiz);
    }

    private void exibirEmPosOrdem(NoBinario<T> noAtual) {
        if(noAtual != null){
            exibirEmOrdem(noAtual.getNoEsquerdo());
            exibirEmOrdem(noAtual.getNoDireito());
            System.out.print(noAtual.getConteudo() + ", ");
        }
    }

    public void remover(T conteudo){
        try {

            NoBinario<T> noAtual = this.raiz;
            NoBinario<T> pai = null;
            NoBinario<T> filho = null;
            NoBinario<T> temporario = null;
            while (noAtual != null && noAtual.getConteudo().equals(conteudo)){
                pai = noAtual;
                if(conteudo.compareTo(noAtual.getConteudo()) < 0){
                    noAtual = noAtual.getNoEsquerdo();
                }else{
                    noAtual = noAtual.getNoDireito();
                }
            }

            if(noAtual == null){
                System.out.println("Conteúdo não encontrado.");
            }

            if(pai == null){
                if(noAtual.getNoDireito() == null){
                    this.raiz = noAtual.getNoEsquerdo();
                }else if(noAtual.getNoEsquerdo() == null) {
                    this.raiz = noAtual.getNoDireito();
                }else{
                    for (temporario = noAtual, filho = noAtual.getNoEsquerdo();
                         filho.getNoDireito() != null;
                         temporario = filho, filho = filho.getNoEsquerdo())
                    {
                        if(filho != noAtual.getNoEsquerdo()){
                            temporario.setNoDireito(filho.getNoEsquerdo());
                            filho.setNoEsquerdo(raiz.getNoEsquerdo());
                        }
                    }
                    filho.setNoDireito(raiz.getNoDireito());
                    raiz = filho;
                }
            }else if(noAtual.getNoDireito() == null){
                if(pai.getNoEsquerdo() == noAtual){
                    pai.setNoEsquerdo(noAtual.getNoEsquerdo());
                }else{
                    pai.setNoDireito(noAtual.getNoEsquerdo());
                }
            }else if(noAtual.getNoEsquerdo() == null){
                if(pai.getNoEsquerdo() == noAtual){
                    pai.setNoEsquerdo(noAtual.getNoDireito());
                }else{
                    pai.setNoDireito(noAtual.getNoDireito());
                }
            }else{
                for (temporario = noAtual, filho = noAtual.getNoEsquerdo();
                     filho.getNoDireito() != null;
                     temporario = filho, filho = filho.getNoDireito())
                {
                    if(filho != noAtual.getNoEsquerdo()){
                        temporario.setNoDireito(filho.getNoEsquerdo());
                        filho.setNoEsquerdo(noAtual.getNoEsquerdo());
                    }
                    filho.setNoDireito(noAtual.getNoDireito());
                    if(pai.getNoEsquerdo() == noAtual){
                        pai.setNoEsquerdo(filho);
                    }else{
                        pai.setNoDireito(filho);
                    }
                }
            }

        }catch (NullPointerException npe){
            System.out.println("Ocorreu a seguinte excepção: \n" +npe.getMessage() +"\nA causa é: \n" +npe.getCause());
        }
    }
}
