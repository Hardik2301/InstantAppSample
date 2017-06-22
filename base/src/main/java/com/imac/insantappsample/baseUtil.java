package com.imac.insantappsample;

/**
 * Created by imac on 6/21/17.
 */

public class baseUtil {

    public static boolean checkLogin(String uname,String pass)
    {
        if(uname.equalsIgnoreCase("hardik") && pass.equalsIgnoreCase("hardik")){
            return true;
        }else{
            return false;
        }
    }
}
