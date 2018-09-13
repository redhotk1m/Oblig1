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

        sortering(a);
        System.out.println(Arrays.toString(a) + " la");

        for (int i = 0, j = 0; i<a.length-1; i++){
            if (a[i] % 2 != 0){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }
        }
        for (int k = 0; k<100000; k++){ //Bør være sortering fra x,y hvor x er der oddetallene slutter og partallene starter
            // og y er lengden av arrayet, altså der partallene slutter. DETTE KLARER VI IKKE.
            for (int i = 0, j = 0; i < a.length - 1; i++) {
                if (a[i] % 2 == 0 && (a[i] > a[i + 1])) {
                    int temp;
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
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
        if (s.length()>t.length()) {
            for (int i = 0; i < t.length(); i++) {
                String c = (s.substring(i, i + 1) + t.substring(i, i + 1));
                d = d + c;
                if (i == t.length() - 1) {
                    d = d + s.substring(i + 1);
                }
            }
        } //Vet det er overflødig kode, skal fikse dersom vi har tid.
        else{
            for (int i = 0; i < s.length(); i++) {
                String c = (s.substring(i, i + 1) + t.substring(i, i + 1));
                d = d + c;
                if (i == s.length() - 1) {
                    d = d + t.substring(i + 1);
                }

            }
        }
        System.out.println(d);
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


}
