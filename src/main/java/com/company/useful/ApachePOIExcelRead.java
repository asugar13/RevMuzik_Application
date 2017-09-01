package com.company.useful;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;



public class ApachePOIExcelRead {

    /*public List<Ticket> readFile(String showId, InputStream fileContent, int sheetIndex) {

        try {
        	List<Ticket> ticketList = new ArrayList<Ticket>();
        	
            Workbook workbook = new HSSFWorkbook( fileContent );
            Sheet datatypeSheet = workbook.getSheetAt( sheetIndex );
            Iterator<Row> iterator = datatypeSheet.iterator();

            System.out.println( "Reading excel file content: " + showId );
            
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                if ( currentRow.getRowNum() != 0 ) {
                	Ticket ticket = convertCurrentRowIntoTicketObject(currentRow);
                	ticket.setShow( new Show( new Long( showId ), "Evento " + showId ) );
                	ticketList.add( ticket );
                }
            }
            workbook.close();
            return ticketList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;

    }
    
    private Ticket convertCurrentRowIntoTicketObject(Row currentRow) {

        Ticket ticket = new Ticket();
        
        ticket.setOrderNumber( new Long( getStringValueFromCell( currentRow.getCell(0) ) ) );
        ticket.setOrderType( getStringValueFromCell( currentRow.getCell(1) ) );
        ticket.setSector( getStringValueFromCell( currentRow.getCell(2) ) );
        ticket.setSeat( getStringValueFromCell( currentRow.getCell(3) ) );
        ticket.setOrderKey( getStringValueFromCell( currentRow.getCell(4) ) );
        
        return ticket;
    	
    }
    
    private boolean isCellFilled(Cell cell) {
    	return cell.getCellTypeEnum() != CellType.BLANK;
    }
    
    private String getStringValueFromCell(Cell cell) {
    	if ( !isCellFilled(cell) )
    		return "";
    	if ( cell.getCellTypeEnum() == CellType.STRING ) {
    		return Normalizer.normalize(cell.getStringCellValue(), Normalizer.Form.NFD).replaceAll("[^\\p{Alpha}\\p{Digit}& |-]+","");
    	} else if ( cell.getCellTypeEnum() == CellType.NUMERIC ) {
    		return String.valueOf( (long)cell.getNumericCellValue() );
    	}
    	return null;
    }*/
    
}
