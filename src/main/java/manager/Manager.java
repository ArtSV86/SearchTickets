package manager;


import domain.Ticket;
import repository.Repository;

import java.util.Arrays;

public class Manager {
    Repository repositoryM = new Repository();

    public void save(Ticket ticket) {
        repositoryM.add(ticket);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repositoryM.findAll()) {
            Ticket[] temp = new Ticket[result.length + 1];
            if (ticket.getAirportFrom().equals(from) || ticket.getAirportTo().equals(to)) {
                System.arraycopy(result, 0, temp, 0, result.length);
                temp[temp.length - 1] = ticket;
                result = temp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}