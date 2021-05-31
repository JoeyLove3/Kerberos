package TGS;

public class test {
    public static void main(String[] args){
        String AD="192.168.137.1";
        String[] ADarr=AD.split("\\.");
        String a="0";
        String G_ADc="";
        for(int i=0;i<ADarr.length;i++){
            if(ADarr[i].length()<3){
                if(ADarr[i].length()==1)
                    ADarr[i]=a+a+i;
                else
                    ADarr[i]=a+i;
            }
            G_ADc+=ADarr[i];
        }
        System.out.println(G_ADc);
    }
}
