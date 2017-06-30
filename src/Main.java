import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int numberOfItems = scan.nextInt();
        ArrayList<Item> items = new ArrayList<Item>();
        for (int i = 0; i < numberOfItems; i++) {
            Item item = new Item();
            item.setSize(scan.nextInt());
            item.setValue(scan.nextInt());
            items.add(item);
        }
        Main main = new Main();
        System.out.println(main.myFunc(size,items));
    }

    private int myFunc(int sizeLeft, ArrayList<Item> itemsLeft){
        if (sizeLeft < 1 || itemsLeft.size() < 1){
            return 0;
        }
        if(itemsLeft.get(0).getSize() > sizeLeft) {
            return 0;
        }
        else{
            int value = itemsLeft.get(0).getValue();
            int itemSize = itemsLeft.get(0).getSize();
            itemsLeft.remove(0);
            return Math.max((value+myFunc(sizeLeft-itemSize,itemsLeft)),myFunc(sizeLeft,itemsLeft));
        }
    }
}

class Item{
    private int size;
    private int value;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}