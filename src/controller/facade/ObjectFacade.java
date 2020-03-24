package controller.facade;

public class ObjectFacade {
    
    private Facade facade;
    public Facade getInstance () {
        if (facade == null) {
            facade= new Facade();
        }
            return facade;
        
    }
}
