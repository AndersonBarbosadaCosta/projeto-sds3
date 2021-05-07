package br.com.anderson.costa.dsvendas.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.anderson.costa.dsvendas.dto.SaleSuccessDTO;
import br.com.anderson.costa.dsvendas.dto.SaleSumDTO;
import br.com.anderson.costa.dsvendas.entites.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new br.com.anderson.costa.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP By obj.seller")
	List<SaleSumDTO> amountGroupBySeller();
	
	@Query("SELECT new br.com.anderson.costa.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj GROUP By obj.seller")
	List<SaleSuccessDTO> successGroupBySeller();
}
