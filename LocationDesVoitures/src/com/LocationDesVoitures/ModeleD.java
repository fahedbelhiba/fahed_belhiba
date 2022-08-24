package com.LocationDesVoitures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.swing.table.AbstractTableModel;

public class ModeleD extends AbstractTableModel {
	
	   private ArrayList<Client> clients = new ArrayList<Client>();
	    private final String[] entetes = {"id", "Nom", "Prénom","CIN","Phone","Car","version","time remaining","Amount"};
	    private long days;
	    private ArrayList<Long> allPrices = new ArrayList<Long>() ;
	    private  long a;
	    public ModeleD() {
	        super();
	        Connexion conn = new Connexion();
	        clients = conn.getAllClients();
	        for (int i = 0;i< clients.size();i++ ) {
	        fireTableRowsInserted(clients.size() , clients.size() );
	   
	        }}
	    

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			  return clients.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return entetes.length;
		}
		 public void removeClient(int rowIndex) {
		       
		        fireTableRowsDeleted(rowIndex, rowIndex);
		    }

		
	
	   
	 
	    public String getColumnName(int columnIndex) {
	        return entetes[columnIndex];
	    }
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        Object p;
			switch(columnIndex){
	            case 0:
	                return clients.get(rowIndex).getId();
	            case 1:
	                return clients.get(rowIndex).getNom();
	            case 2:
	                return clients.get(rowIndex).getPrenom();
	            case 3:
	                return clients.get(rowIndex).getCin();
	            case 4:
	                return clients.get(rowIndex).getPhone();
	            case 5	:
	                return clients.get(rowIndex).getCar();
	            case 6	:
	                return clients.get(rowIndex).getTypeCar();
	            case 7 : 
	            	   SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
	            		  
	           	    String inputString1 = clients.get(rowIndex).getDateFrom();
	           	    String inputString2 =  clients.get(rowIndex).getDateTo();
	           	    try {
	           	        Date date1 = myFormat.parse(inputString1);
	           	        Date date2 = myFormat.parse(inputString2);
	           	        long diff = date2.getTime() - date1.getTime();
	           	     days = (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS ));
	           	        		
	           	          
	           	      return (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS )+ "Days");
	           	    } catch (ParseException e) {
	           	        e.printStackTrace();
	           	    }
	            case 8 : 
	            	Connexion conn = new Connexion();
	            	allPrices.add((long) conn.CalcP(clients.get(rowIndex).getTypeCar()));
	             	 
	            
	            	return days*conn.CalcP(clients.get(rowIndex).getTypeCar())+ "DT";
	            	
	         
	            default:
	                return null; 
	        }
	        
	    }

	    public ArrayList<Long> getAllPrices() {

        	for (long c :  allPrices) {
	    	
			System.out.println(c);
	    }
	   
        	return allPrices;
	  
}
	    
	    public void removeC(int rowIndex) {
	        clients.remove(rowIndex);
	        fireTableRowsDeleted(rowIndex, rowIndex);
	    }
	    

}
