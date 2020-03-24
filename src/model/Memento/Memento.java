package model.Memento;

import eg.edu.alexu.csd.oop.game.GameObject;
public class Memento {

    private GameObject GameObject;

    public Memento(GameObject GameObject) {
        super();
        this.GameObject = GameObject;
    }

    public void setGameObject(GameObject GameObject) {
        this.GameObject = GameObject;
    }

    public GameObject getGameObject() {
        return this.GameObject;
    }

}
