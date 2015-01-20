package objects;

import java.util.ArrayList;
import java.util.List;

public class careTaker {
	
   private List<memento> mementoList = new ArrayList<memento>();

   public void add(memento state){
      mementoList.add(state);
   }

   public memento get(int index){
      return mementoList.get(index);
   }
}