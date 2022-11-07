package edu.umb.cs680.hw05;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class SecurityContext {

    LinkedList<LocalTime> loginTime = new LinkedList<LocalTime>();
    private static State state;


    public SecurityContext(User user){
        state = LoggedOut.getInstance(this);
    }

    public State getState() {
        return state;
    }
    public void changeState(State newState){

        state = newState;
    }

    public void login(EncryptedString pwd){
        loginTime.add(LocalTime.now());
        state.login(pwd);
    }

    public void logout(){
        state.logout();
    }

    boolean isActive(){
        if (!loginTime.isEmpty()) {
            return ((loginTime.getLast().getMinute() - LocalTime.now().getMinute()) < 15) && (loginTime.getLast().getHour() == LocalTime.now().getHour());
        }
        return false;
    }

}


