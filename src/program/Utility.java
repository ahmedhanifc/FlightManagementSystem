package program;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Utility {
	
	public static <T> boolean addIfNotExistsCollection(Collection<T> collection, T item) {
		if(item !=null && !collection.contains(item)) {
			collection.add(item);
			System.out.printf("%s has been successfully added to the system\n",item);
			return true;
		}
		else {
            return false;
		}
	}
	public static <T> boolean removeIfExistsCollection(Collection<T> collection,T item) {
		if(item != null && collection.contains(item)) {
			collection.remove(item);
			return true;
		}
		else {
			return false;
		}
	}
	public static <T> boolean addIfNotExistsMap(Map<String, T> map, String identifier, T item) {
		if(!map.containsKey(identifier)) {
			map.put(identifier, item);
			return true;
		}
		else {
			return false;
		}
	}
	public static <T> boolean removeIfExistsMap(Map<String, T> map, String identifier) {
		if(map.containsKey(identifier)) {
			map.remove(identifier);
			return true;
		}
		else {
			return false;
		}
	}
	public static <T> T searchCollection(Collection<T> collection, String identifier) {
		T foundItem = null;
		for(T item:collection) {
			if(item instanceof Airplane) {
				if(((Airplane) item).getModel().equals(identifier)) {
					foundItem = item;
				}
			}
		}
		
		return foundItem;
	}

}
