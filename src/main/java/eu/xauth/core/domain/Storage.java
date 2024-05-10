package eu.xauth.core.domain;

import java.util.UUID;

/**
 * Generic interface to stare and get model objects.
 *
 * @param <T> The type of the object
 */
public interface Storage<T> {

  /**
   * Returns a model object by its ID.
   *
   * @param id The ID by which the model object is returned.
   * @return The model object.
   */
  T getById(UUID id);

  /**
   * Saves a model object.
   *
   * @param model The model object to save.
   */
  void save(T model);
}
