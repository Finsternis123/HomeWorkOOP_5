package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.models.TableModel;
import ru.geekbrains.lesson5.presenters.BookingPresenter;
import ru.geekbrains.lesson5.presenters.Model;
import ru.geekbrains.lesson5.presenters.View;
import ru.geekbrains.lesson5.views.BookingView;

import java.util.Date;

public class Program {

    /**
     * TODO: Домашняя работа: Метод changeReservationTable ДОЛЖЕН ЗАРАБОТАТЬ!
     * @param args
     */
    public static void main(String[] args) {
        Model tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.showTables();

        // Клиент нажимает на кнопку "Зарезервировать", возбуждается событие,
        // вызывается метод reservationTable()
        bookingView.reservationTable(new Date(), 101, "Станислав");

        bookingView.changeReservationTable(0, new Date(), 102, "Станислав");

        bookingView.reservationTable(new Date(), 103, "Станислав");

        bookingView.changeReservationTable(0, new Date(), 104, "Станислав");

        bookingView.reservationTable(new Date(), 105, "Станислав");

        bookingView.changeReservationTable(0, new Date(), 106, "Станислав");
    }
}