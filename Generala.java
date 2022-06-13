import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Generala
{
// ESTA ES LA FUNCIÓN QUE HAY QUE IMPLEMENTAR
// TAMBIÉN PUEDEN AGREGAR OTRAS FUNCIONES y/o CLASES
// QUE NECESITEN PARA RESOLVER EL EJERCICIO DE LA
// MANERA MÁS ORDENADA POSIBLE

    public String jugada(String dados)
    {
        //1. GENERALA
        //Todos los dados, con el mismo valor.
        //Ejemplo: 55555
        try{
            Integer.parseInt(dados);
        }catch (NumberFormatException nfe){
            return "INVALIDO";
        }

        int[] dadosInt = this.pasarInt(dados);
        if( dadosInt[0] == 7)
            return "INVALIDO";

        int[] apariciones = this.verRepeticiones(dadosInt);

        boolean rep2 = false;
        boolean rep3 = false;
        for(int i  = 0 ; i <  apariciones.length ; i++){
             if(apariciones[i] == 5)
                 return "GENERALA";
             else if(apariciones[i] == 4)
                 return "POKER";
             else if(apariciones[i] == 3)
                 rep3 = true;
             else if(apariciones[i] == 2)
                 rep2 = true;
        }

        if(rep2 && rep3)
            return "FULL";

        int escalera = 0;
        for(int i = 0; i < dados.length() - 1 ; i++){
            if(dados.charAt(i) < dados.charAt(i+1)){
                escalera++;
            }
        }
        if(dados.charAt(3) == '6' && dados.charAt(4) == '1') {
            escalera++;
        }

        if(escalera == 4)
            return "ESCALERA";


        return "NADA";
    }

    private int[] pasarInt(String dados) {
        int[] retorno =  new int[dados.length()];
        for(int i = 0 ; i < dados.length() ; i++){
            if(dados.charAt(i) > '6' || dados.charAt(i) < '1'){
                retorno[0] = 7;
                break;
            }else
                retorno[i] = Character.getNumericValue(dados.charAt(i));
        }
        return retorno;
    }

    private int[] verRepeticiones(int[] dados){
        int[] retorno = new int[6];

        for(int i  = 0 ; i <  dados.length ; i++){
            //Verificamos que este dentro del rango
            retorno[dados[i]-1]++;
        }

        return retorno;
    }




    // Ustedes pueden ignorar esto
    String[] jugadas(String[] losdados)
    {

        /*java-e003.md 10/17/2018

        3 / 4*/

        String[] ret = new String[losdados.length];
        int i = 0;
        for (String dados : losdados)
        {
            ret[i] = this.jugada(dados);
            i++;
        }
        return ret;
    }
    // Ustedes pueden ignorar esto
    static String[] processBatch(String fileName)
            throws Exception
    {
        Scanner sc = new Scanner(new File(fileName));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        return lines.toArray(new String[0]);
    }
    public static void main(String[] args)
            throws Exception
    {
        Generala g = new Generala();
        /* IGNORAR PORQUE ESTO NO SE VA A EJECUTAR PARA USTEDES */
        if (args.length > 0) {
            String[] jugadas = processBatch(args[0]);
            String resultados[] = g.jugadas(jugadas);
            for(String res : resultados) {
                System.out.println(res);
            }
            return;
        }
// ESTO SI SE EJECUTA PARA USTEDES


        int num;
        String parametro;
        /*for(int i = 0 ; i <= 10 ; i++){
            parametro = "";
            for(int j = 1;j <= 5 ; j++) {
                num = (int) (Math.random() * (6 - 1)) + 1;
                parametro = parametro + num;
            }
            System.out.println("Parametro :" + parametro);
            System.out.println(g.jugada(parametro));

        }*/


        parametro = "55533";
        System.out.println("Parametro :" + parametro);
        System.out.println(g.jugada(parametro));

        parametro = "55553";
        System.out.println("Parametro :" + parametro);
        System.out.println(g.jugada(parametro));

        parametro = "55555";
        System.out.println("Parametro :" + parametro);
        System.out.println(g.jugada(parametro));



        parametro = "12345";
        System.out.println("Parametro :" + parametro);
        System.out.println(g.jugada(parametro));

        parametro = "23456";
        System.out.println("Parametro :" + parametro);
        System.out.println(g.jugada(parametro));
        parametro = "34561";
        System.out.println("Parametro :" + parametro);
        System.out.println(g.jugada(parametro));



    }
}
