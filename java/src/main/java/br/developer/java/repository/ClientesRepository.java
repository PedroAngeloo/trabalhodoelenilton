package br.developer.java.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository
import org.springframework.stereotype.Repository; // Importa a anotação @Repository

import br.developer.java.entity.Clientes; // Importa a classe de entidade Clientes

@Repository // Indica que esta é uma classe de repositório gerenciada pelo Spring
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    // Declaração da interface ClientesRepository, estendendo JpaRepository para
    // operações de banco de dados

    // Não é necessário implementar nenhum método aqui, pois JpaRepository fornece
    // métodos de CRUD prontos para uso.
    // Esses métodos incluem salvar, buscar, deletar etc. para a entidade
    // 'Clientes'.
}
