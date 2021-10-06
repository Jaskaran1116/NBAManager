package model;

public class ClubFullException extends Exception {
    ClubFullException() {
        super("Club is full, cannot add more players !!!");
    }
}
