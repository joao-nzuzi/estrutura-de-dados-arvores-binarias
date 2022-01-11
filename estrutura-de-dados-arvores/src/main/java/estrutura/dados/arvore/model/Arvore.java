package estrutura.dados.arvore.model;

import java.util.Objects;

public class Arvore extends ObjArvore<Arvore>{
    Integer meuValor;

    public Arvore(Integer meuValor) {
        this.meuValor = meuValor;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Arvore arvore = (Arvore) o;
        return Objects.equals(meuValor, arvore.meuValor);
    }

    public int hashCode() {
        return Objects.hash(meuValor);
    }

    public int compareTo(Arvore outro) {
        int i = 0;
        if(this.meuValor > outro.meuValor){
            i = 1;
        }else if(this.meuValor < outro.meuValor){
            i = -1;
        }
        return i;
    }

    public String toString() {
        return meuValor.toString();
    }
}
