package br.com.anderson.costa.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anderson.costa.dsvendas.dto.SellerDTO;
import br.com.anderson.costa.dsvendas.entites.Seller;
import br.com.anderson.costa.dsvendas.repositores.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;

	public List<SellerDTO> findAll() {

		List<Seller> list = repository.findAll();
		return list.stream().map(item -> new SellerDTO(item)).collect(Collectors.toList());
	}

}
