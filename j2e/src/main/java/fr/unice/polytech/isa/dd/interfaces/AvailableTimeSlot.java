package fr.unice.polytech.isa.dd.interfaces;

public interface AvailableTimeSlot {

    public void getAllSlot();
    public boolean verify(String date, String hour);
}
