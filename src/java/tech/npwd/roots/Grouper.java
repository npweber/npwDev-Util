package tech.npwd.roots;

import java.util.*;

//Grouper: A Better ArrayList

public class Grouper<T> extends ArrayList<T> {

    //Importing from primitive array
    //NOTE: Sets up the Grouper FROM SCRATCH
    public void importFromArray(T[] array){
        clear();
        addAll(Arrays.asList(array));
    }

    //Adds the primitive array to the end of this grouper
    //**Useful for working with primitive arrays
    public void addFromArray(T[] array){
        addAll(Arrays.asList(array));
    }

    //Gets the string containing the regex if the Grouper holds String's
    public String getStringContaining(String regex){
        //Check that the Grouper is Grouper<String>
        if(get(0) instanceof String)
            //Look for the String contain the Regex
            for(T object : this) {
                String string = (String) object;
                if (string.contains(regex))
                    return string;
            }
        else Printer.print("This Grouper is not of type String.");
        return null;
    }

    //Gets an object that is equal to the given object
    public T getIfEqual(T regex){
        for(T object : this)
            if(regex.equals(object))
                return object;
        return null;
    }

    //Sets an object that is equal to the given object with a new object
    public void setIfEqual(T regex, T replacement) {
        //Look for the String contain the Regex
        for (int i = 0; i < this.size(); i++)
            if (this.get(i).equals(regex))
                this.set(i, replacement);
    }

    //Sorts int's in ascending or descending order (0 OR 1)
    public void sort(int order){
        //Check if empty
        if(size() == 0) {
            Printer.print("Grouper empty. Nothing to sort.");
            return;
        }
        //Check for type "Integer"
        if(!(get(0) instanceof Integer)) {
            Printer.print("This is an incompatible Grouper for sorting.");
            return;
        }

        //Use primitive array in Arrays.java sort method
        T[] sortedArray = (T[]) toArray(new Integer[size() - 1]);
        Arrays.sort(sortedArray);

        //Wipe the exist contents and import sorted contents in respective ordering from primitive array
        clear();
        if(order == 0)
            importFromArray(sortedArray);
        if(order == 1)
            for (int i = sortedArray.length - 1; i > -1; i--)
                add(sortedArray[i]);
    }
}