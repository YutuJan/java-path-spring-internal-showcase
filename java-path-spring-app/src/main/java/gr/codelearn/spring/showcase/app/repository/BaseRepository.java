package gr.codelearn.spring.showcase.app.repository;

import java.util.List;

public interface BaseRepository<T, ID> {
	T create(T entity);

	List<T> createAll(List<T> entities);

	List<T> createAll(T... entities);

	void update(T entity);

	void delete(T entity);

	void deleteById(ID id);

	boolean exists(T entity);

	T findById(ID id);

	List<T> findAll();
}
