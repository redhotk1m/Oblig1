import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    public static int maks (int[] a){
        if (a.length<=0){
            throw new NoSuchElementException("Listen er tom. a: " + a.length + " < 1");
        }
        int maksverdi;
        for (int i = 0; i<a.length-1; i++){
            int temp;
            if (a[i]>a[i+1]){
                temp = a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }

        }
        maksverdi = a[a.length-1];
        return maksverdi;
    }

    /*
    1. Det blir flest ombyttinger hvis arrayet er sortert fra lavest til høyest. Eks. {1,2,3,4,5}. Da vil if statement
    alltid være sann.
    2. Det er derimot færrest ombyttinger hvis det største tallet ligger forrerst.
     */

    public static int ombyttinger(int [] a){
        int ombyttinger = 0;

        int maksverdi;

        for (int i = 0; i<a.length-1; i++){
            int temp;
            if (a[i]>a[i+1]){
                temp = a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
                ombyttinger++;
            }

        }

        return ombyttinger;
    }

    //Bruk O(N) formel for å regne ut gjennomsnittlig operasjoner.
    //I worst case scenario blir det n antall ombyttinger, og i best case scenario blir det 0 ombyttinger.
    //SPØR OM HJELP!

    public static int antallUlikeSortert (int [] a) {
        int antallUlike=1;

        if (a == null) {
            return 0;
        }else if (a.length == 1){
            return 1;
        }

            for (int i = 0; i < a.length-1; i++) {
                if(a[i] > a[i + 1]){
                    throw new IllegalStateException("Listen er ikke sortert" + a);
                }
                else if (a[i] != a[i + 1]){
                    antallUlike++;
                    System.out.print(antallUlike);
                }



            }

        return antallUlike;
    }


    public static void delsortering(int [] a){


        sortering(a);
        System.out.println(Arrays.toString(a) + " la");

        for (int i = 0, j = 0, k = 0; i<a.length-1; i++){
            if (a[i] % 2 != 0){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }
            System.out.println(Arrays.toString(a));
        }
        for (int i = 0, j = 0, k = 0; i<a.length-1; i++)
            if (a[i] % 2 == 0 && (a[i]>a[i+1])){
                int temp;
                temp = a[i];
                a[i] = a[i+1];
                a[i+1]=temp;
            }

        System.out.println(Arrays.toString(a) + " leeee");
    }

    public static int maks(int [] a, int fra, int til){


        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }
        return m;
    }

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sortering(int[] a){

        int n = a.length;

        if (n<2) throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m;
        for (int i = 0; i<a.length; i++){
            m = maks(a,0,a.length-i);
            bytt(a,m,a.length-1-i);
        }

    }

    public static void rotasjon(char [] a){
        if (a==null || a.length==0){
            return;
        }

        for(int i = a.length-1; i > 0; i--){
            char temp = a[i];
            a[i] = a[i-1];
            a[i-1] = temp;
        }


        System.out.print(Arrays.toString(a));

    }
}
