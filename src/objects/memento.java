package objects;

public class memento {
	
   private String state;

   public memento(String state){
      this.state = state;
   }

   public String getState(){
      return state;
   }	
}