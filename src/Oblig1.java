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
        }
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

    public static String flettFeil(String... s){
        String d = "";
        for (int i = 0; i < s.length; i++){
            for (int k = 0; k < s[i].length(); k++){
                    String c = (s[i].substring(k,k+1));
                    d = d + c;
                    System.out.println(d);
                }
            }

        return "s";
    }


    public static String flett(String... s) {
        String d = "";
        System.out.println(s.length);
        //if()
        //Må avsluttes når vi ikke har flere bokstaver
        //k er nå 8  men bedre med s.length
        for (int k = 0; k < 8; k++) {
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

    //Oppgave 2


}
