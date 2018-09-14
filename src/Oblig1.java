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

    //Oppgave 2

    public static int antallUlikeSortert (int [] a) {
        int antallUnike = 0;
        int hjelpetall = 0;


        if (a == null) {
            antallUnike=0;
            System.out.println(antallUnike + "<-- Her er det et tomt array");
            return antallUnike;
        }
        if (a.length==0){
            antallUnike=0;
            System.out.println(antallUnike + "<-- Her er det ingen verdier i arrayet");
            return antallUnike;
        }
        if (a.length==1){
            antallUnike=1;
            System.out.println(antallUnike + "<-- Her er det bare 1 verdi i arrayet");
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
            System.out.println("Nå ble det kastet en IllegalStateException fordi listen ikke er sortert");
            throw new IllegalStateException("Listen er ikke sortert" + a);
        }

        if (a.length>2){
            antallUnike=1;
            hjelpetall=a[0];
        }
        boolean toførstelike = false;
        if (a[0]==a[1]){
            toførstelike=true;
        }
        if (a.length==2 && toførstelike) {
            antallUnike=1;
            return antallUnike;
        }

        for (int i = 1; i < a.length; i++){
            System.out.println(antallUnike + " u " + hjelpetall + "h");;
            if (a[i] == hjelpetall){
                if (toførstelike){
                    antallUnike++;
                }
                antallUnike--;
            } else{
                antallUnike++;
                hjelpetall = a[i];
            }
            System.out.println(antallUnike + " Dette returneres når vi har loopet gjennom for løkken");
        }
        return antallUnike;
    }

    //Oppgave 3

    public static int antallUlikeUsortert(int [] a){

        if (a == null) {
            return 0;
        }
        if (a.length==0){
            return 0;
        }
        if (a.length==1){
            return 1;
        }
        int antallUnike=0;
        boolean toførstelike=false;
        if (a[0]==a[1]){
            toførstelike=true;
        }
        if (a.length==2 && toførstelike) {
            antallUnike=1;
            return antallUnike;
        }

        boolean ikkeUnik = false;
        boolean totaltUnik = false;
        int ikkeunik = 0;
        int unik = 0;
        for (int k = 0; k<a.length; k++){
            for (int i = k; i<a.length-k; i++){
                if (ikkeUnik){
                    System.out.println("hei");
                    ikkeUnik=false;
                    unik++;
                }
                int Temp = a[k];
                if (a[i+k] == a[k]){
                    System.out.println("yoyoy");
                    ikkeUnik = true;
                    ikkeunik++;
                }else{
                    totaltUnik=true;
                }
            }
            if (totaltUnik){
                totaltUnik=false;
                //unik++;
            }
        }
        System.out.println(unik);
        return unik;
    }


        public static void test(int [] a) {
            int[] array = {5, 6, 2, 5, 2, 2, 0, 1, 6};
            for (int i = 0; i < array.length; i++) {
                int count = 0;
                int val = array[i];
                for (int j = 0; j < array.length; j++) {
                    if (val == array[j]) {
                        count += 1;
                    }
                }
                System.out.println(val + " occurs" + " " + count);

            }
        }


    //Oppgave 4

    public static void delsortering(int [] a){
        if (a == null || a.length==0){
            return;
        }
        if (a.length==1){
            return;
        }

        sorteringUtenUnntak(a);
        int k = a.length;
        int testverdi = 0;
            for (int i = 0, j = 0; i < a.length - 1; i++) {
                if (a[i] % 2 != 0) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    j++;
                    testverdi=a[i];
                }
            }
        System.out.println("HEI!" + testverdi);
        partition(a,(testverdi+1+a.length)/2,testverdi,a.length);
        System.out.println(Arrays.toString(a) + " leeeeeeeeeeeee");
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

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

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
        System.out.println(s.length);
        //if()
        //Må avsluttes når vi ikke har flere bokstaver
        //k er nå 8  men bedre med s.length
        for (int k = 0; k < 8; k++) { //Vet vi ikke bør ha konstant verdi 8 her, skal fikses dersom vi har tid.
            for (int i = 0; i < s.length; i++) {
                //int k = 0; // Må inkrementeres, når vi har skrevet ut ALLE strengene, og sjekke at strengen har K bokstaver.
                if (s[i] != null && s[i].length() != 0 && s[i].substring(0).length() > k) {
                    String c = (s[i].substring(k, k + 1));
                    d = d + c;
                    System.out.println(d);
                }
            }
        }
        return d;
    }


    //Oppgave 8

    public static int[] indekssortering(int[] a){
        int arrayLen = a.length;
        int[] c = a.clone();
        int[] b = new int[arrayLen];

        for(int i = 0; i < arrayLen; i++){
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


    // Method to sort a string alphabetically
    public static String sortString(String inputString)
    {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }

    // Hjelpemetode

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

    public static void sorteringUtenUnntak(int[] a){

        int n = a.length;

        if (n<2) throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m;
        for (int i = 0; i<a.length; i++){
            m = maks(a,0,a.length-i);
            bytt(a,m,a.length-1-i);
        }

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
        int arrayLen = array.length;
        int min = Integer.MAX_VALUE;
        int index = 0;

        for(int i = 0; i < arrayLen; i++){
            if(min > array[i]){
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void bubble(int[] a, int fra, int til) {
        System.out.println(Arrays.toString(a));
        // Loop over alle elementene i a
        for (int i=fra; i<til-1; ++i){
            if (a[i] > a[i+1]) {
                int tmp = a[i];
                a[i] = a[i+1];
                a[i+1] = tmp;
            }

        }

    }

    public static void partition(int [] a, int pivot, int fra, int til){ //Pivot er tallet vi skal partisjonere med. (Sorter etter pivot).

        int v = fra + 1;
        int h = til - 1;

        while (true) {

            //Flytt venstrepeker mot høyre
            //til vi har et ikke-pivotert tall
            while (a[v] < pivot && v <= h) {
                v++;
            }
            //Flytt høyrepeker tilsvarende
            while (a[h] > pivot && h >= v) {
                h--;
            }
            //Hvis høyre er lik venstre
            //Er alle tallene sortert
            if (v == h){
                break;
            }

            System.out.println(v + " - " + h);

            //Ellers burde vi ende opp med å bytte dem
            //Denne testen er overflødig.

            System.out.println("vi bytter " + h + " med " + v);
            int tmp = a[v];
            a[v] = a[h];
            a[h] = tmp;


            System.out.println(Arrays.toString(a) + "<- Inni Partition");
        }




    }


}
