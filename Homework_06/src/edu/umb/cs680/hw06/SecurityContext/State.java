package edu.umb.cs680.hw06.SecurityContext;

public interface State {

    void login(EncryptedString pwd);

    void logout();
}

