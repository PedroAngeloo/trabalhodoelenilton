package br.developer.java.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository
import org.springframework.stereotype.Repository; // Importa a anotação @Repository

import br.developer.java.entity.Produtos; // Importa a classe de entidade Produtos

@Repository // Indica que esta é uma classe de repositório gerenciada pelo Spring
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
    // Declaração da interface ProdutosRepository, estendendo JpaRepository para
    // operações de banco de dados

    // Não é necessário implementar nenhum método aqui, pois JpaRepository fornece
    // métodos de CRUD prontos para uso.
    // Esses métodos incluem salvar, buscar, deletar etc. para a entidade
    // 'Produtos'.
}
