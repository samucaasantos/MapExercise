package model.entities;

public class VoteCandidates {
    private String name;
    private Integer numOfVotes;

    public VoteCandidates() {}

    public VoteCandidates(String name, Integer numOfVotes) {
        this.name = name;
        this.numOfVotes = numOfVotes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumOfVotes() {
        return numOfVotes;
    }

    public void setNumOfVotes(Integer numOfVotes) {
        this.numOfVotes = numOfVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        VoteCandidates that = (VoteCandidates) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
