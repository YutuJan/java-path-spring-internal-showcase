package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.BaseEntity;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractRepository<T extends BaseEntity> implements BaseRepository<T, Long> {
	public abstract List<T> getStorage();

	@Override
	public T create(final T entity) {
		getStorage().add(entity);
		return entity;
	}

	@Override
	public List<T> createAll(final List<T> entities) {
		getStorage().addAll(entities);
		return entities;
	}

	@Override
	public List<T> createAll(final T... entities) {
		return createAll(Arrays.asList(entities));
	}

	@Override
	public void update(final T entity) {
	}

	@Override
	public void delete(final T entity) {
		getStorage().remove(entity);
	}

	@Override
	public void deleteById(Long id) {
	}

	@Override
	public List<T> findAll() {
		return getStorage();
	}

	@Override
	public boolean exists(T entity) {
		return false;
	}

	@Override
	public T findById(Long id) {
		return null;
	}
}
