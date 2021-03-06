package com.example.custhy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.custhy.entity.ShoppingCart;
import com.example.custhy.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServices {
	
	@Autowired
	ShoppingCartRepository shopRepository;
	
    public Page<ShoppingCart> findPagina(Integer pageNumber, Integer pageSize,String sortField, String sortDirection){
		
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
		
		return shopRepository.findAll(pageable);
	}

}
