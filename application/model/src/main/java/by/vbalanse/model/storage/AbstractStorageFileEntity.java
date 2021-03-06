/*
 * This Learning Management System (“Software”) is the exclusive and sole property of Baja Education. Inc. (“Baja”).
 * Baja has the sole rights to copy the software, create derivatives or modified versions of it, distribute copies
 * to End Users by license, sale or otherwise. Anyone exercising any of these exclusive rights which also includes
 * indirect copying  such as unauthorized translation of the code into a different programming language without
 * written explicit permission from Baja is an infringer and subject to liability for damages or statutory fines.
 * Interested parties may contact bpozos@gmail.com.
 *
 * (c) 2012 Baja Education
 */

package by.vbalanse.model.storage;

import by.vbalanse.model.common.AbstractManagedEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = AbstractStorageFileEntity.TABLE_NAME)
@Inheritance(strategy = InheritanceType.JOINED)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public abstract class AbstractStorageFileEntity extends AbstractManagedEntity {
  public static final String IMAGE_FOLDER = "IMG";
  public static final String TEMP_FOLDER = "TMP";

  public static final String TABLE_NAME = "stg_file";

  private static final String COLUMN_EXTENSION = "extension_";
  private static final String COLUMN_REAL_FILE_NAME = "real_file_name_";
  private static final String COLUMN_IS_TEMP = "is_temp_";
  private static final String COLUMN_DATE_OF_LAST_UPDATE = "date_of_last_update_";
  private static final String COLUMN_DATE_OF_CREATE = "date_of_create_";
  private static final String COLUMN_CAS_USER_ID = "cas_user_id";
  private static final String COLUMN_FK_FOLDER = "fk_" + StorageFolderEntity.TABLE_NAME;

  @NotNull
  @Column(name = COLUMN_REAL_FILE_NAME)
  private String realFileName;

  @NotNull
  @Column(name = COLUMN_EXTENSION)
  private String extension;

  @NotNull
  @Column(name = COLUMN_IS_TEMP, columnDefinition = "BIT", length = 1)
  private boolean temp;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = COLUMN_DATE_OF_LAST_UPDATE)
  private Date dateOfLastUpdate;

  @NotNull
  @Column(name = COLUMN_DATE_OF_CREATE)
  private Date dateOfCreate;

  @NotNull
  @Column(name = COLUMN_CAS_USER_ID)
  private Long creatorId;

  @NotNull
  @ManyToOne
  @JoinColumn(name = COLUMN_FK_FOLDER)
  @ForeignKey(name = TABLE_NAME + DELIMITER_INDEX + COLUMN_FK_FOLDER)
  private StorageFolderEntity folder;

  protected AbstractStorageFileEntity() {
  }

  public String getFileName() {
    return "" + getId() + "." + getExtension();
  }

  public Date getDateOfLastUpdate() {
    return dateOfLastUpdate;
  }

  public void setDateOfLastUpdate(Date dateOfLastUpdate) {
    this.dateOfLastUpdate = dateOfLastUpdate;
  }

  public String getRealFileName() {
    return realFileName;
  }

  public void setRealFileName(String realFileName) {
    this.realFileName = realFileName;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public boolean isTemp() {
    return temp;
  }

  public void setTemp(boolean temp) {
    this.temp = temp;
  }

  public Date getDateOfCreate() {
    return dateOfCreate;
  }

  public void setDateOfCreate(Date dateOfCreate) {
    this.dateOfCreate = dateOfCreate;
  }

  public Long getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(Long creatorId) {
    this.creatorId = creatorId;
  }

  public StorageFolderEntity getFolder() {
    return folder;
  }

  public void setFolder(StorageFolderEntity folder) {
    this.folder = folder;
  }

}
