package com.tfprojarq.tfprojarq.domain.entities;

public class ApplicationEntity {
    private Long id;
    private String name;
    private double monthlyCost;

    public ApplicationEntity(Long id, String name, double monthlyCost) {
        this.id = id;
        this.name = name;
        this.monthlyCost = monthlyCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", monthlyCost=" + monthlyCost +
                '}';
    }
}