package com.sky.server.mvc.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jcooky on 2014. 7. 30..
 */
@Entity
public class Worker {
  @Id
  @GeneratedValue
  private long id;

  private String address;
  private int port;
  private Date updateTime = new Date(System.currentTimeMillis());

  @Enumerated
  private State state = State.IDLE;

  @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
  private List<Work> works = new ArrayList<Work>();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public List<Work> getWorks() {
    return works;
  }

  public void setWorks(List<Work> works) {
    this.works = works;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public static enum State {
    IDLE,
    WORKING,
    QUIT
  }

  @Override
  public String toString() {
    return "Worker{" +
        "state=" + state +
        ", updateTime=" + updateTime +
        ", port=" + port +
        ", address='" + address + '\'' +
        ", id=" + id +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Worker worker = (Worker) o;

    if (id != worker.id) return false;
    if (port != worker.port) return false;
    if (address != null ? !address.equals(worker.address) : worker.address != null) return false;
    if (state != worker.state) return false;
    if (works != null ? !works.equals(worker.works) : worker.works != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + port;
    result = 31 * result + (state != null ? state.hashCode() : 0);
    result = 31 * result + (works != null ? works.hashCode() : 0);
    return result;
  }
}
