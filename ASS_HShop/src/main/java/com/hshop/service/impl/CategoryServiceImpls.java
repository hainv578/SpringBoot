package com.hshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hshop.entity.Category;
import com.hshop.repository.CategoryRepository;
import com.hshop.service.CategoryService;

@Service
public class CategoryServiceImpls implements CategoryService{
	CategoryRepository categoryRepository;

	public CategoryServiceImpls(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	public <S extends Category> S save(S entity) {
		return categoryRepository.save(entity);
	}

	@Override
	public Page<Category> findByNameContaining(String name, Pageable pageable) {
		return categoryRepository.findByNameContaining(name, pageable);
	}

	@Override
	public List<Category> findByNameContaining(String name) {
		return categoryRepository.findByNameContaining(name);
	}

	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}

	public List<Category> findAllById(Iterable<Long> ids) {
		return categoryRepository.findAllById(ids);
	}

	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}

	public <S extends Category> List<S> saveAll(Iterable<S> entities) {
		return categoryRepository.saveAll(entities);
	}

	public void flush() {
		categoryRepository.flush();
	}

	public <S extends Category> S saveAndFlush(S entity) {
		return categoryRepository.saveAndFlush(entity);
	}

	public boolean existsById(Long id) {
		return categoryRepository.existsById(id);
	}

	public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
		return categoryRepository.saveAllAndFlush(entities);
	}

	public <S extends Category> boolean exists(Example<S> example) {
		return categoryRepository.exists(example);
	}

	public void deleteAllInBatch(Iterable<Category> entities) {
		categoryRepository.deleteAllInBatch(entities);
	}

	public long count() {
		return categoryRepository.count();
	}

	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}

	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		categoryRepository.deleteAllByIdInBatch(ids);
	}

	public void delete(Category entity) {
		categoryRepository.delete(entity);
	}

	public void deleteAllById(Iterable<? extends Long> ids) {
		categoryRepository.deleteAllById(ids);
	}

	public void deleteAllInBatch() {
		categoryRepository.deleteAllInBatch();
	}

	public void deleteAll(Iterable<? extends Category> entities) {
		categoryRepository.deleteAll(entities);
	}

	public void deleteAll() {
		categoryRepository.deleteAll();
	}

	public Category getById(Long id) {
		return categoryRepository.getById(id);
	}
	
}
