package model.Memento;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Originator {

    private GameObject GameObject;
    public Originator() {}
    public void setGameObject(GameObject GameObject) {
        this.GameObject= GameObject;
    }
    public GameObject getGameObject() {
        return this.GameObject;
    }
    public Memento createMemento() {
        return new Memento(this.GameObject);
    }
    public void setMemento (Memento Memento) {
        GameObject=Memento.getGameObject();
    }
}
