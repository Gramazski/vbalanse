/*
 * Copyright (c) 2008, Itision Corporation. All Rights Reserved.
 *
 * The content of this file is copyrighted by Itision Corporation and can not be
 * reproduced, distributed, altered or used in any form, in whole or in part.
 */
package by.vbalanse.model.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 * Abstract baseclass for all managed entities which using an optimistic locking strategy and database generated
 * identifier provided by the baseclass {@link AbstractManagedEntity}
 *
 * @author <a href="mailto: e.terehov@itision.com">Eugene Terehov</a>
 */
@MappedSuperclass
public abstract class AbstractManagedVersionedEntity extends AbstractManagedEntity {

  @NotNull
  @Version
  @Column(name = COLUMN_OBJ_VERSION)
  private long objVersion = -1;

  protected AbstractManagedVersionedEntity() {
  }

  public long getObjVersion() {
    return objVersion;
  }

  public void setObjVersion(long param) {
    objVersion = param;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    AbstractManagedVersionedEntity that = (AbstractManagedVersionedEntity) o;

    return objVersion == that.objVersion;

  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (int) (objVersion ^ (objVersion >>> 32));
    return result;
  }

}
