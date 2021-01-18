package br.com.andriuscastro.firstapp.providers.hashProvider;

public interface IHashProvider {
    String generateHash(String password);
    Boolean compare(String password, String hashPassword);
}
