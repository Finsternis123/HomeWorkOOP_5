package ru.geekbrains.lesson5.presenters;

import ru.geekbrains.lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model tableModel;
    private final View bookingView;
    protected int reservationId;
    public BookingPresenter(Model tableModel, View bookingView){
        this.tableModel = tableModel;
        this.bookingView = bookingView;
        bookingView.setObserver(this);
    }

    private Collection<Table> loadTables(){
        return tableModel.loadTables();
    }

    public void showTables(){
        bookingView.showTables(loadTables());
    }

    public void printReservationTableResult(int reservationId){
        bookingView.printReservationTableResult(reservationId);
    }

    public void printChangeReservationTableResult(int reservationNewId){
        bookingView.printChangeReservationTableResult(reservationNewId);
    }

    public void printReservationTableError(String errorMessage){
        bookingView.printReservationTableError(errorMessage);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try
        {
            reservationId = tableModel.reservationTable(orderDate, tableNo, name);
            printReservationTableResult(reservationId);
        }
        catch (RuntimeException e){
            printReservationTableError(e.getMessage());
        }

    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date orderDate, int tableNo, String name) {
        try
        {
            oldReservation = reservationId + 1;
            printChangeReservationTableResult(oldReservation);
        }
        catch (RuntimeException e){
            printReservationTableError(e.getMessage());
        }

    }
}
