package com.labb1;
import java.util.Scanner;

public class Laboration1 {
    public static void main(String[] args) {
        int antalSidor = 6;
        int summaSpelare = 0;
        int summaDator = 0;
        int highScore[] = new int [3];
        int antalRundor;
        int datorSlag;
        int spelareSlag;

        Scanner scan = new Scanner(System.in);

        do{
            System.out.print("Skriv antal rundor du vill spela: ");
            antalRundor = scan.nextInt();

            for(int i = 1; i <= antalRundor; i++){

                spelareSlag = (int)(1 + (Math.random() * antalSidor));
                datorSlag = (int)(1 + (Math.random() * antalSidor));

                summaSpelare += spelareSlag;
                summaDator += datorSlag;
                System.out.println("Omgång: " + i);
                System.out.println("* Spelare slår: " + spelareSlag);
                System.out.println("* Dator slår: " + datorSlag);
                System.out.println("Total för spelare är: " + summaSpelare);
                System.out.println("Total för dator är: " + summaDator);
                System.out.println("---------------------------------");
            }

            if(summaSpelare > summaDator){
                instruktioner(summaSpelare,summaDator);
                sorteraHighscore(highScore, summaSpelare );
            }

            else if(summaSpelare < summaDator){
                instruktioner(summaSpelare,summaDator );
                sorteraHighscore(highScore, summaSpelare );
            }

            else if(summaDator == summaSpelare && summaDator != 0){
                instruktioner(summaSpelare,summaDator);
                sorteraHighscore(highScore, summaSpelare );
            }

            System.out.println("High score");
            System.out.println("----------");
            for(int j= highScore.length -1;j>=0;j--){
                System.out.print(highScore[j]+ "\r\n");
            }
            System.out.println();
            summaDator=0;summaSpelare=0;
        }while(antalRundor != 0);
    }

    public static void instruktioner(int summaSpelare, int summaDator){
        String status = (summaSpelare > summaDator) ? "spelaren!" : "datorn!";
        if (summaSpelare == summaDator) {
            status = "ingen. Det blev oavgjort!";
        }
        System.out.println("Vinnaren är " + status);
        System.out.println(" ");
    }

    public static void sorteraHighscore(int[] highScore, int summaSpelare){

        if(summaSpelare > highScore[0]){
            highScore[0] = summaSpelare;
        }

        else if(summaSpelare == highScore[0]){
            for(int j=1; j < highScore.length && highScore[j] == summaSpelare ;j++){
                if(summaSpelare > highScore[j]){
                    highScore[j] = summaSpelare;
                }
            }
        }
        int i;
        int temporary;
        for (int n = 1; n < highScore.length; n++) {
            temporary = highScore[n];
            i = n - 1;

            while (i >= 0 && highScore[i] > temporary) {
                highScore[i + 1] = highScore[i];
                i--;
            }
            highScore[i + 1] = temporary;
        }
    }
}