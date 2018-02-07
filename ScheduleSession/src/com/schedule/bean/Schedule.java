package com.schedule.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ScheduledSessions")
public class Schedule {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="duration")
	private int duration;
	@Column(name="faculty")
	private String faculty;
	@Column(name="mode1")
	private String mode;
	public Schedule() {
		super();
	}
	public Schedule(int id, String name, int duration, String faculty,
			String mode) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.faculty = faculty;
		this.mode = mode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", name=" + name + ", duration="
				+ duration + ", faculty=" + faculty + ", mode=" + mode + "]";
	}
	
	
}
