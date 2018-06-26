package com.epam.creatures.entity;

import java.util.Objects;

public class Creature implements Entity {

    public enum Gender{
        MALE,FEMALE,NONE
    }

    private long creatureId;
    private String creatureName;
    private int limbQuantity;
    private int headQuantity;
    private int eyeQuantity;
    private Gender creatureGender;
    private String description;
    private Double creatureRating;
    private Integer creatorId;

    public Creature(long creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                    Gender creatureGender, String description, Double creatureRating, Integer creatorId) {

        this.creatureId = creatureId;
        this.creatureName = creatureName;
        this.limbQuantity = limbQuantity;
        this.headQuantity = headQuantity;
        this.eyeQuantity = eyeQuantity;
        this.creatureGender = creatureGender;
        this.description = description;
        this.creatureRating = creatureRating;
        this.creatorId = creatorId;
    }

    public Creature(long creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity, Gender creatureGender, Integer creatorId){
        this.creatureId = creatureId;
        this.creatureName = creatureName;
        this.limbQuantity = limbQuantity;
        this.headQuantity = headQuantity;
        this.eyeQuantity = eyeQuantity;
        this.creatureGender = creatureGender;
        this.creatorId = creatorId;
    }

    public long getCreatureId() {
        return creatureId;
    }

    public void setCreatureId(long creatureId) {
        this.creatureId = creatureId;
    }

    public String getCreatureName() {
        return creatureName;
    }

    public void setCreatureName(String creatureName) {
        this.creatureName = creatureName;
    }

    public int getLimbQuantity() {
        return limbQuantity;
    }

    public void setLimbQuantity(int limbQuantity) {
        this.limbQuantity = limbQuantity;
    }

    public int getEyeQuantity() {
        return eyeQuantity;
    }

    public void setEyeQuantity(int eyeQuantity) {
        this.eyeQuantity = eyeQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHeadQuantity() {
        return headQuantity;
    }

    public void setHeadQuantity(int headQuantity) {
        this.headQuantity = headQuantity;
    }

    public Gender getCreatureGender() {
        return creatureGender;
    }

    public void setCreatureGender(Gender creatureGender) {
        this.creatureGender = creatureGender;
    }

    public Double getCreatureRating() {
        return creatureRating;
    }

    public void setCreatureRating(Double creatureRating) {
        this.creatureRating = creatureRating;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return creatureId == creature.creatureId &&
                limbQuantity == creature.limbQuantity &&
                headQuantity == creature.headQuantity &&
                eyeQuantity == creature.eyeQuantity &&
                Objects.equals(creatureName, creature.creatureName) &&
                creatureGender == creature.creatureGender &&
                Objects.equals(description, creature.description) &&
                Objects.equals(creatureRating, creature.creatureRating) &&
                Objects.equals(creatorId, creature.creatorId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(creatureId, creatureName, limbQuantity, headQuantity, eyeQuantity, creatureGender, description, creatureRating, creatorId);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "creatureId=" + creatureId +
                ", creatureName='" + creatureName + '\'' +
                ", limbQuantity=" + limbQuantity +
                ", headQuantity=" + headQuantity +
                ", eyeQuantity=" + eyeQuantity +
                ", creatureGender=" + creatureGender +
                ", description='" + description + '\'' +
                ", creatureRating=" + creatureRating +
                ", creatorId='" + creatorId + '\'' +
                '}';
    }
}
