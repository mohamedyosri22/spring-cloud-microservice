package com.spring.team.model;


public class Team {

    private Long id;

    private String from;

    private String to;

    private int moneyTeam;

    private String note;

    private String numberTeam;

    private String port;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Team() {
    }

    public Team(Long id, String from, String to, int moneyTeam, String note, String numberTeam) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.moneyTeam = moneyTeam;
        this.note = note;
        this.numberTeam = numberTeam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getMoneyTeam() {
        return moneyTeam;
    }

    public void setMoneyTeam(int moneyTeam) {
        this.moneyTeam = moneyTeam;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNumberTeam() {
        return numberTeam;
    }

    public void setNumberTeam(String numberTeam) {
        this.numberTeam = numberTeam;
    }
}
