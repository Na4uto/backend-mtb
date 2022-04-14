//package com.example.angular_mtb.service;
//
//import org.springframework.stereotype.Service;
//
//
//import com.example.angular_mtb.repo.TicketRepository;
//
//@Service
//public class TicketServiceImplementation implements TicketService {
//	private TicketRepository ticketRepository;
//
//	public TicketServiceImpl(TicketRepository ticketRepository) {
//		this.ticketRepository = ticketRepository;
//	}
//	
//	@Autowired
//	private SeatRepository seatRepository;
//	
//	@Autowired
//	private BookingRepository bookingRepository;
//	
//	@Override
//	public Ticket addTicket(Ticket ticket,Integer transactionId) throws TicketNotFoundException {
//		Booking booking=new Booking();
//		if(transactionId!=null) {
//			booking=bookingRepository.findById(transactionId).get();
//			booking.setTransactionStatus("Completed");
//			ticket.setBooking(booking);
//		}
//		ticketRepository.saveAndFlush(ticket);
//		/*
//		 * for(Seat s:ticket.getSeats()) { s.setTickett(ticket);
//		 * seatRepository.saveAndFlush(s); }
//		 */
//		return ticket;
//	}
//
//	@Override
//	public List<Ticket> viewTicketList() throws TicketNotFoundException {
//		List<Ticket> ti = ticketRepository.findAll();
//		if (ti.size() == 0)
//			throw new TicketNotFoundException("No tickets are avaliable");
//		return ti;
//	}
//
//	@Override
//	public Ticket findTicket(int ticketId) {
//		// TODO Auto-generated method stub
//		return ticketRepository.findById(ticketId).get();
//	}
//}
