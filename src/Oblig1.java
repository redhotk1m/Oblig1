public class Oblig1 {

    public static int maks (int[] a){
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
