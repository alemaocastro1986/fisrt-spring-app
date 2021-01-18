package br.com.andriuscastro.firstapp.providers.hashProvider;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class BcryptHashProvider implements IHashProvider{
    private Integer salt = 10;
    @Override
    public String generateHash(String password) {
        return BCrypt.withDefaults().hashToString(salt, password.toCharArray());
    }

    @Override
    public Boolean compare(String password, String hashPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hashPassword);
        return result.verified;
    }
}
