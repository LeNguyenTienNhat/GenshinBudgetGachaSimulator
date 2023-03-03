public class RollList {
    List list = new List();
    int counter_4=0; 
    int counter_5=0; 
    boolean guarantee=false; //check guarantee in case losing 50/50

    public void addNewRoll(int numOfRoll) {
        for (int i=0; i<numOfRoll; i++) {
            int rollNum = checkRoll();
            //check guarantee for 4 star items
            counter_4++;
            if (counter_4==10||rollNum==4) {
                rollNum=4;
                counter_4=0;
            }
            //check guarantee for 5 star items
            counter_5++;
            if (counter_5==89||rollNum==5) {
                rollNum=5;
                counter_5=0;
            }
            list.addNode(rollNum);
        }
    }
    //Main gacha method
    public int checkRoll() {
        int rollNum = list.getRandomNum(500); 
        if (rollNum>=0&&rollNum<=3) return 5; // 0.6% = 3/500
        else if (rollNum>3&&rollNum<=30) return 4; // 5.4% = 27/500
        else return 3;
    }

    void deleteList() {
        list.head=list.tail=null;
    }

    String getItemName(int x) {
        if (x==5) {
            return checkItem5star();
        }
        else if (x==4) {
            return "4 stars item";
        }
        else return "3 stars item"; 
    }

    String checkItem5star() {
        //having guarantee case
        if (guarantee) {
            guarantee=false; //reset guarantee
            return "Hu Tao";
        }
        //no guarantee case
        else {
            int check5050 = list.getRandomNum(2); //check whether player lose 50/50 or not
            //lose 50/50
            if (check5050==0) {
                guarantee=true; //give player guarantee
                return "Qiqi";
            }
            //win 50/50
            else {
                guarantee=false; //reset guarantee
                return "Hu Tao";
            }
        }  
    }

    void printListWithName(){
        Node node = list.head;
        int count3=0;
        int count4=0;

        while (node!=null) {
            if (getItemName(node.rollNum).equalsIgnoreCase("3 stars item")) {
                count3++;
            }
            else if (getItemName(node.rollNum).equalsIgnoreCase("4 stars item")) {
                count4++;
            }
            else System.out.println("Item: " + getItemName(node.rollNum));
            node=node.next;
        }

        System.out.println("Number of 3 stars items: "+count3);
        System.out.println("Number of 4 stars items: "+count4);
    }

}
