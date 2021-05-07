package br.com.anderson.costa.dsvendas.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anderson.costa.dsvendas.entites.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
