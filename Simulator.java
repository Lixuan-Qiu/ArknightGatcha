import java.util.Scanner;
import java.util.Random;
public class Simulator{
    public static void main(String args[]){
        //总范围为1000，已知抽到六星的概率是2%，所以
        int totalSix = 20; //六星范围为1-20
        int upSix = 10; //up六星范围为1-10
        int singleUp = 5; //双up中单个六星范围为1-5
        System.out.println("Menu:");
        System.out.println("[1]双up池抽到两个up六星");
        System.out.println("[2]双up池抽到一个特定六星");
        System.out.println("[3]单up池抽到up六星");
        System.out.println("[0]退出");
        Scanner scan = new Scanner(System.in);
        int choice;
        int j = 0;
        int totalGatcha = 0;
        while ((choice = scan.nextInt()) !=0){
        boolean fst = false;
        boolean scd = false;
        boolean six = false; 
        boolean finalFst = false;
        boolean finalScd = false;
        j++;
        int chu = 0;
        int total = 0;
        int total_x = 0;
        int i = 0;
        int stone = 0;
        double money = 0;
        switch (choice) {
            case 1:
                fst = false;
                scd = false;
                total = 0;
                i = 0;
                while (finalFst == false || finalScd == false){

                    upSix = totalSix/2;
                    singleUp = upSix/2;
                    if (i>50 & fst == false & scd==false & six == false){
                        //连续五十抽都没出货
                        totalSix += 20;
                        upSix = totalSix/2;
                        singleUp = upSix/2;
                    }
                    
                    else if (i>50){
                        //到了五十抽以后而且抽到了六星，reset各项flag值
                        i = 0;
                        fst = false; 
                        scd = false;
                        six = false; 
                    }

                    int result = (int)(Math.random() * 1000 + 1);
                    //随机产生一个一到一千的整数作为抽卡结果的判定

                    if (result <= singleUp){
                    //如果随机值在第一个up六星的范围内则判定为抽到了第一个up六星
                        totalSix = 20;
                        total_x++;
                        fst = true;
                        finalFst =true;
                    }
                    else if (result <= upSix){
                    //随机值在第二个up六星范围内
                        totalSix = 20;
                        total_x++;

                        finalScd = true;
                        scd = true;
                    }
                    else if (result <=totalSix){
                    //随机值在up外但是在六星内
                        chu++;
                        total_x++;

                        totalSix = 20; 
                        six = true; 
                    }
                    //i记录离上个六星已经抽了多少抽，total记录总共花费的红石头
                    i++;
                    total += 600;
                }
                stone = (int)(total/180+1);
                money = stone *3.5;
                break;

            case 2:
                fst = false;
                scd = false;
                total = 0;
                i = 0;
                while (fst == false){
                    upSix = totalSix/2;
                    singleUp = upSix/2;
                    if (i>50 & fst == false & scd==false & six == false){
                        totalSix += 20;
                        upSix = totalSix/2;
                        singleUp = upSix/2;
                    }
                    else if (i>50){
                        i = 0;
                        six = false; 
                    }
                    int result = (int)(Math.random() * 1000 + 1);
                   // System.out.println(result);

                    if (result <= singleUp){
                        totalSix = 20;
                        total_x++;

                        fst = true;
                    }
                    else if (result <= upSix){
                        chu++;
                        total_x++;

                        totalSix = 20;
                        scd = true;
                    }
                    else if (result <=totalSix){
                        chu++;
                        total_x++;

                        totalSix = 20; 
                        six = true; 
                    }
                    i++;
                    total += 600;
                }
                stone = (int)(total/180+1);
                money = stone *3.5;
                break;

            case 3:
                fst = false;
                scd = false;
                total = 0;
                i = 0;
                while (fst == false){
                    upSix = totalSix/2;
                    singleUp = upSix/2;
                    if (i>50 & fst == false & six == false){
                        totalSix += 20;
                        upSix = totalSix/2;
                    }
                    else if (i>50){
                        i = 0;
                        fst = false; 
                        six = false; 
                    }
                    int result = (int)(Math.random() * 1000 + 1);
                    //System.out.println(result);
                    if (result <= upSix){
                        totalSix = 20;
                        total_x++;

                        fst = true;
                    }
                    else if (result <=totalSix){
                    	chu++;
                        totalSix = 20; 
                        total_x++;

                        six = true; 
                    }
                    i++;
                    total += 600;
                }
                
                stone = (int)(total/180+1);
                money = stone *3.5;
                break;
            default:
            System.out.print("Invalid choice");
            break;
        }
        totalGatcha+=total/600;
        System.out.println("你抽了"+total/600+"次，花了"+total +"个红石头, "+ stone +"个源石," +money+"人民币, "+"出了"+total_x+"个六星，"+"其中歪了"+chu+"个六星");
    }
    System.out.println("\n为了实现你设定的目标，平均下来你需要抽"+totalGatcha/j+"次");
    scan.close();
}
}