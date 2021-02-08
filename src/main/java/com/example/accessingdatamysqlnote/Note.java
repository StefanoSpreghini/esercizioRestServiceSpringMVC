package com.example.accessingdatamysqlnote;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Note {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

  private String content;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  
}