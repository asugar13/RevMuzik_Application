package com.company.util;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ShowFileReader {
	
	/*@Autowired
	private TicketService ticketService;

	@Autowired
	private ShowService showService;	
	
	private String getShowtIdFromFileName(String fileName) {
		String[] splitedFileName = fileName.split( "_" );
		if ( splitedFileName.length != 5 )
			return null;
		return splitedFileName[3];
	}

	public Long importExcelContentToDatabase(MultipartFile file) {
		String showId = getShowtIdFromFileName( file.getOriginalFilename() );
		if ( showService.get( new Long(showId) ) == null ) {
			showService.insert( new Show( new Long( showId ), "Evento " + showId ) );
		}
		
		System.out.println("Preparing to import excel file from event id: " + showId);
		ApachePOIExcelRead excelReader = new ApachePOIExcelRead();
		List<Ticket> ticketList;
		try {
			ticketList = excelReader.readFile(showId, file.getInputStream(), 1);
			System.out.println("Start to import to database: " + showId);
			for ( Ticket ticket : ticketList ) {
				if ( ticketService.findByOrderKey( ticket.getOrderKey() ) == null ) {
					ticketService.insert( ticket );
				}
			}
			System.out.println("Event tickets well imported to database!!!");
			return new Long(showId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	*/
}
