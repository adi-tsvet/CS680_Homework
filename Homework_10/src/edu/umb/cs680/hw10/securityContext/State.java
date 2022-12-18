package edu.umb.cs680.hw10.securityContext;

public interface State {

    void login(EncryptedString pwd);

    void logout();
}

