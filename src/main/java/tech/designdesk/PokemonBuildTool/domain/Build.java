package tech.designdesk.PokemonBuildTool.domain;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Build {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pokemonName;
    private String pokemonImgUrl;
    private String ability;
    private ArrayList<String> moves;
    private String item;
    private String nature;
    private Integer points;
    private String description;
    @ManyToOne(optional = false)
    private User user;
    // TODO: private User buildCreator;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPokemonImgUrl() {
        return pokemonImgUrl;
    }

    public void setPokemonImgUrl(String pokemonImgUrl) {
        this.pokemonImgUrl = pokemonImgUrl;
    }

    public Build() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<String> moves) {
        this.moves = moves;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
