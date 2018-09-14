import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {


    /*
    1. Det blir flest ombyttinger hvis arrayet er sortert fra lavest til høyest. Eks. {1,2,3,4,5}. Da vil if statement
    alltid være sann.
    2. Det er derimot færrest ombyttinger hvis det største tallet ligger forrerst.
     */

    //Oppgave 1

    public static int ombyttinger(int [] a){
        int ombyttinger = 0;


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

    //Oppgave 2

    public static int antallUlikeSortert (int [] a) {
        int antallUnike = 0;
        int hjelpetall = 0;


        if (a == null) {
            antallUnike=0;
            return antallUnike;
        }
        if (a.length==0){
            antallUnike=0;
            return antallUnike;
        }
        if (a.length==1){
            antallUnike=1;
            return antallUnike;
        }
        boolean feilSortert = false;
        if (a.length>1) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    feilSortert = true;
                }
            }
        }

        if (feilSortert){
            throw new IllegalStateException("Listen er ikke sortert" + a);
        }

        if (a.length>2){
            antallUnike=1;
            hjelpetall=a[0];
        }
        boolean tofyrstelike = false;
        if (a[0]==a[1]){
            tofyrstelike=true;
        }
        if (a.length==2 && tofyrstelike) {
            antallUnike=1;
            return antallUnike;
        }

        for (int i = 1; i < a.length; i++){
            if (a[i] == hjelpetall){
                if (tofyrstelike){
                    antallUnike++;
                }
                antallUnike--;
            } else{
                antallUnike++;
                hjelpetall = a[i];
            }
        }
        return antallUnike;
    }

    //Oppgave 3

    public static int antallUlikeUsortert(int [] a) {

        if(a.length==0)
            return 0;

        int antallUlike = 0;

        for(int i = 0; i<a.length; i++){
            antallUlike ++;

            for(int j = i + 1; j< a.length; j++){
                if(a[i] == a[j]){
                    antallUlike--;
                    break;
                }

            }
        }

        return antallUlike;
    }


    //Oppgave 4

    public static void delsortering(int[] a) {
        if(a.length == 0) return;
        if(a.length < 2) return;
        int fra = 0;
        int til = a.length - 1;

        switch(scanDataSet(a)){
            case 0:
                delsortering_partisjon_subrutine(a, fra, til);
                int pivotIndex = findIndexOfFirstEvenInteger(a);
                quicksort(a, 0, pivotIndex-1);
                quicksort(a, pivotIndex,a.length-1);
                break;

            case 1:
                quicksort(a, 0, a.length - 1);
                break;

            case 2:
                quicksort(a, 0, a.length - 1);
                break;
        }
    }


    //Oppgave 5

    public static void rotasjon(char [] a){
        if (a==null || a.length==0){
            return;
        }

        for(int i = a.length-1; i > 0; i--){
            char temp = a[i];
            a[i] = a[i-1];
            a[i-1] = temp;
        }

    }


    //Oppgave 6

    // Vi har brukt mye tid på denne oppgaven og pga av liten tid måtte vi
    // se til kompendiet.


    public static void rotasjon(char[] c, int d) {
        int n = c.length;  if (n < 2) return;
        if ((d %= n) < 0) d += n;
        int s = gcd(n, d);

        for (int k = 0; k < s; k++) {

            char value = c[k];
            for (int i = k - d, j = k; i != k; i -= d) {
                if (i < 0) i += n;
                c[j] = c[i]; j = i;
            }
            c[k + d] = value;
        }
    }


    //Oppgave 7 a

    public static String flett(String s, String t){
        String d="";
        if(s==null ||s.length()==0){
            return t;
        }
        if(t==null ||t.length()==0){
            return s;
        }
        int value = 0;
        value = t.length();
        value = s.length();
        boolean tt = false;
        boolean ss = false;

        if (s.length()>t.length()) {
            value = t.length();
            tt=true;
        }
        else {
            value = s.length();
            ss=true;
        }
            for (int i = 0; i < value; i++) {
                String c = (s.substring(i, i + 1) + t.substring(i, i + 1));
                d = d + c;
                if (tt && i == t.length() - 1 ){
                    d = d + s.substring(i + 1);
                }
                    else if (ss && i == s.length() - 1){
                        d = d + t.substring(i + 1);
            }
        }
        return d;
    }

    //Oppgave 7 b

    public static String flett(String... s) {
        String d = "";
        //k er nå 8  men bør være en ikke statisk verdi
        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < s.length; i++) {
                if (s[i] != null && s[i].length() != 0 && s[i].substring(0).length() > k) {
                    String c = (s[i].substring(k, k + 1));
                    d = d + c;
                }
            }
        }
        return d;
    }


    //Oppgave 8

    public static int[] indekssortering(int[] a){
        int[] c = a.clone();
        int[] b = new int[a.length];

        for(int i = 0; i < a.length; i++){
            int var = min(a);
            b[i] = var;
            a[var] = Integer.MAX_VALUE;
        }
        for (int i=0; i<a.length; i++){
            a[i]=c[i];
        }
        return b;
    }

    //Oppgave 9

    public static int[] tredjeMin(int[] a){
        int size = 3;
        int[] b = new int[size];
        int[] c = a.clone();
        if (a.length<3){
            throw new NoSuchElementException("For liten tabell!");
        }

        for(int i = 0; i < size; i++){
            int var = min(a);
            b[i] = var;
            a[var] = Integer.MAX_VALUE;
        }
        for (int i = 0; i<a.length; i++){
            a[i] = c[i];
        }
        return b;
    }

    //Oppgave 10

    public static boolean inneholdt(String a, String b){
        boolean z = false;
        a = sortString(a);
        b = sortString(b);
        int counter = 0;
        int k = 0;

        for (int i = 0; i<a.length(); i++){

            for (; k<b.length() ;k++){

                if ( a.substring(i,i+1).equals( b.substring(k,k+1) ) ){
                    k++;
                    counter++;
                    if ( k==b.length() ){
                        i=a.length()+1;
                    }
                    break;
                }
            }
        }
        if ( counter == a.length() ){
            z=true;
        }
        return z;
    }




    // Hjelpemetoder



    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


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

    public static int min(int[] array){

        int min = Integer.MAX_VALUE;
        int index = 0;

        for(int i = 0; i < array.length; i++){
            if(min > array[i]){
                min = array[i];
                index = i;
            }
        }
        return index;
    }



    public static int partition(int[] array, int fra, int til){
        int pivot = array[(fra+til)/2];

        while(fra <= til){
            while(array[fra] < pivot) ++fra;
            while(array[til] > pivot) --til;

            if(fra <= til) {
                bytt(array,fra,til);
                fra++;
                til--;
            }
        }


        return fra;
    }

    public static int delsortering_partisjon_subrutine(int[] a, int fra, int til){
        while (fra <= til) {
            while ((a[fra] % 2) != 0) fra++;
            while ((a[til] % 2) == 0) til--;

            if(fra <= til) {
                int temp = a[fra];
                a[fra] = a[til];
                a[til] = temp;
                fra++;
                til--;
            }
        }
        return fra;
    }

    public static int findIndexOfFirstEvenInteger(int[] a){
        int index = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i]%2==0){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int scanDataSet(int[] array){
        int partall = 0;
        int oddetall = 0;
        int state = -1;

        for(int i = 0; i < array.length; i++){
            if(array[i]%2 == 0) {
                partall++;
            }
            if(array[i]%2 != 0){
                oddetall++;
            }
            if(partall > 0 && oddetall > 0) state = 0;
        }
        if(partall > 0 && oddetall == 0) state = 1;
        if(oddetall > 0 && partall == 0) state = 2;

        return state;
    }

    public static void quicksort(int[] array, int fra, int til) {

        int index = partition(array, fra, til);

        if (fra < index - 1) quicksort(array, fra, index - 1);

        if (index < til) quicksort(array, index , til);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    public static String sortString(String inputString) {

        char tempArray[] = inputString.toCharArray();


        Arrays.sort(tempArray);


        return new String(tempArray);
    }
}
