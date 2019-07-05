package iterator;

import java.util.Iterator;
import java.util.List;

public class ListIterator< E > implements Iterator{

    private int posistion = 0;
    private List< E > items;

    public ListIterator(List< E > items){
        this.items = items;
    }

    public boolean hasNext(){
        if (posistion >= items.size() || items.get(posistion) == null){
            return false;
        }
        return true;
    }

    public boolean hasPrevious(){
        if (posistion <= 0|| items.get(posistion - 1 ) == null){
            return false;
        }
        return true;
    }

    public E next(){
        E item = items.get(posistion);
        posistion++;
        return item;
    }

    public E previous(){
        posistion--;
        E item = items.get(posistion);
        return item;
    }

    public E current(){
        E item = items.get(posistion);
        return item;
    }

}

