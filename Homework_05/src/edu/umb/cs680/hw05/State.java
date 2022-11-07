package edu.umb.cs680.hw05;

public interface State {

    void login(EncryptedString pwd);

    void logout();
}

