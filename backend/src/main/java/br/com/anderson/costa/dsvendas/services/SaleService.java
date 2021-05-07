package br.com.anderson.costa.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.anderson.costa.dsvendas.dto.SaleDTO;
import br.com.anderson.costa.dsvendas.dto.SaleSuccessDTO;
import br.com.anderson.costa.dsvendas.dto.SaleSumDTO;
import br.com.anderson.costa.dsvendas.entites.Sale;
import br.com.anderson.costa.dsvendas.repositores.SaleRepository;
import br.com.anderson.costa.dsvendas.repositores.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	@Autowired
	private SellerRepository sellerRepository;

	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> list = repository.findAll(pageable);
		return list.map(item -> new SaleDTO(item));
	}

	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupBySeller() {

		return repository.amountGroupBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupBySeller() {

		return repository.successGroupBySeller();
	}
}
