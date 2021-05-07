package br.com.anderson.costa.dsvendas.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anderson.costa.dsvendas.entites.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
