package br.com.ada.projeto.locadoraveiculos.persistence;

public interface RepositoryGenerico<T> {

    void salvar(T entidade);

    void remover(T entidade);

    T buscarPeloId(String identificador);
}
