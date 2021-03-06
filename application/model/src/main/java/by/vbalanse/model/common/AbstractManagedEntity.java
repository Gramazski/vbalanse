/*
 * Copyright (c) 2008, Itision Corporation. All Rights Reserved.
 *
 * The content of this file is copyrighted by Itision Corporation and can not be
 * reproduced, distributed, altered or used in any form, in whole or in part.
 */
package by.vbalanse.model.common;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Abstract baseclass for all managed entities which using database generated identifier
 *
 * @author <a href="mailto: e.terehov@itision.com">Eugene Terehov</a>
 */
@MappedSuperclass
public abstract class AbstractManagedEntity extends AbstractEntity<Long> {

  @Id
  @GeneratedValue
  @Column(name = COLUMN_ID)
  private Long id;

  protected AbstractManagedEntity() {
  }

  protected AbstractManagedEntity(Long id) {
    this.id = id;
  }

  /**
   * The id attribute used to uniquelly identify the instance of the subclass
   *
   * @return the unique id (primary key) of the instance
   */
  public Long getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return getClass().getName() + "{" +
        "id=" + id +
        '}';
  }

}