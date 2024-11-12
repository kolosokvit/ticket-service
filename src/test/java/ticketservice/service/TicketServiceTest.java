package ticketservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ticketservice.model.Ticket;
import ticketservice.model.TicketType;
import ticketservice.model.User;
import ticketservice.repository.TicketRepository;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {
  @Mock private TicketRepository ticketRepository;

  @InjectMocks private TicketService ticketService;

  @Test
  void Should_SaveTicket_When_CallSaveTicket() {
    Ticket actualTicket = new Ticket();
    Mockito.when(ticketRepository.save(actualTicket)).thenReturn(actualTicket);
    Ticket resultTicket = ticketService.saveTicket(actualTicket);
    assertEquals(actualTicket, resultTicket);
    verify(ticketRepository, times(1)).save(actualTicket);
  }

  @Test
  void Should_ThrowIllegalArgumentException_When_CallSaveTicketWithNullArgument() {
    Mockito.when(ticketRepository.save(null)).thenThrow(new IllegalArgumentException());
    assertThrows(IllegalArgumentException.class, () -> ticketService.saveTicket(null));
    verify(ticketRepository, times(1)).save(null);
  }

  @Test
  void Should_ReturnOptionalWithTicket_When_CallGetTicket() {
    Ticket actualTicket = new Ticket();
    int id = actualTicket.getId();
    Mockito.when(ticketRepository.findById(id)).thenReturn(Optional.of(actualTicket));
    Ticket resultTicket = ticketService.getTicket(id);
    assertEquals(actualTicket, resultTicket);
    verify(ticketRepository, times(1)).findById(id);
  }

  @Test
  void Should_ThrowIllegalArgumentException_When_CallGetTicketWithNonexistentTicketId() {
    int nonexistentId = 0;
    Mockito.when(ticketRepository.findById(nonexistentId))
        .thenThrow(new IllegalArgumentException("Can't find ticket with id: " + nonexistentId));
    assertThrows(IllegalArgumentException.class, () -> ticketService.getTicket(nonexistentId));
    verify(ticketRepository, times(1)).findById(nonexistentId);
  }

  @Test
  void Should_ReturnNothing_When_CallDeleteTicketWithExistentId() {
    Ticket ticket = new Ticket();
    Mockito.doNothing().when(ticketRepository).deleteById(ticket.getId());
    ticketService.deleteTicket(ticket.getId());
    verify(ticketRepository, times(1)).deleteById(ticket.getId());
  }

  @Test
  void Should_ReturnListOfTickets_When_CallGetTicketsByUserId() {
    User user = new User();
    Ticket ticket1 = new Ticket();
    ticket1.setUser(user);
    Ticket ticket2 = new Ticket();
    ticket2.setUser(user);
    List<Ticket> expectedList = new ArrayList<>();
    expectedList.add(ticket1);
    expectedList.add(ticket2);
    Mockito.when(ticketRepository.getTicketsByUserId(user.getId())).thenReturn(expectedList);
    List<Ticket> actualList = ticketService.getTicketsByUserId(user.getId());
    assertEquals(expectedList, actualList);
    verify(ticketRepository, times(1)).getTicketsByUserId(user.getId());
  }

  @Test
  void Should_ReturnEmptyList_When_CallGetTicketsByUserIdWithNonexistentUserId() {
    User user = new User();
    List<Ticket> expectedEmptyList = new ArrayList<>();
    Mockito.when(ticketRepository.getTicketsByUserId(user.getId())).thenReturn(expectedEmptyList);
    List<Ticket> actualList = ticketService.getTicketsByUserId(user.getId());
    assertEquals(expectedEmptyList, actualList);
    verify(ticketRepository, times(1)).getTicketsByUserId(user.getId());
  }

  @Test
  void Should_ReturnUpdatedTicket_When_CallUpdateTicketType() {
    Ticket expectedTicket = new Ticket();
    expectedTicket.setTicketType(TicketType.YEAR);
    Mockito.when(ticketRepository.updateTicketType(TicketType.YEAR, expectedTicket.getId()))
        .thenReturn(expectedTicket);
    Ticket actualTicket = ticketService.updateTicketType(TicketType.YEAR, expectedTicket.getId());
    assertEquals(expectedTicket, actualTicket);
    verify(ticketRepository, times(1)).updateTicketType(TicketType.YEAR, expectedTicket.getId());
  }
}
