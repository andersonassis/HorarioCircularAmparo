package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.testarConexao;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by AndersonLuis on 26/09/2017.
 */

public class TestarConexao  {
    public static boolean verificaConexao(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return  false;
        }else {
            NetworkInfo[]networkInfo = connectivityManager.getAllNetworkInfo();
            if (networkInfo != null){
                for (int i=0; i< networkInfo.length;i++){
                    if (networkInfo[i].getState()== NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }

        }

        return  false;
    }
}
