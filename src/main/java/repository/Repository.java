package repository;

import domain.Ticket;

public class Repository {
    private Ticket[] tickets = new Ticket[0];

    public void add(Ticket ticket) {       //добавить
        int length = tickets.length + 1;
        Ticket[] temp = new Ticket[length];
        System.arraycopy(tickets, 0, temp, 0, tickets.length);
        int lastInd = temp.length - 1;
        temp[lastInd] = ticket;
        tickets = temp;
    }

    public Ticket[] findAll() {            //получить список
        return tickets;
    }

    public void removeById(int id) {      //удалить
        int length = tickets.length + 1;
        Ticket[] temp = new Ticket[length];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                temp[index] = ticket;
                index++;
            }
        }
        tickets = temp;
    }
}
