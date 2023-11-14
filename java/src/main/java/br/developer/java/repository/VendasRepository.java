package br.developer.java.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository

import br.developer.java.entity.Vendas; // Importa a classe de entidade Vendas

public interface VendasRepository extends JpaRepository<Vendas, Long> {
    // Declaração da interface VendasRepository, estendendo JpaRepository para
    // operações de banco de dados

    // Não é necessário implementar nenhum método aqui, pois JpaRepository fornece
    // métodos de CRUD prontos para uso.
    // Esses métodos incluem salvar, buscar, deletar etc. para a entidade 'Vendas'.
}
