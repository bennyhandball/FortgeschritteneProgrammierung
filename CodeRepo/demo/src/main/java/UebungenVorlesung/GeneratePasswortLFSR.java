/*package UebungenVorlesung;

public class GeneratePasswortLFSR {
    
        public static void main(String []args){
            
            int bitsMask = (0x01 <<4) -1; //11110000...
            int state = 9;
        for(int i = 0; i <200; i++){
            System.out.print(i%15);
            System.out.print(": ");
            System.out.print(state);
            int newbit = state ^(state >>1 ) & 1;
            state = (state >> 1)| (newbit << 3);
            state = state & bitsMask;
            }
        }
        
}*/
