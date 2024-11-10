package io.github.ropereralk.vendeur;

public class AccessTokenNotFoundException extends RuntimeException{

    public AccessTokenNotFoundException(){
        super("Access Token Not Found");
    }

}
