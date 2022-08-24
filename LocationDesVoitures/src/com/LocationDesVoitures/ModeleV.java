package com.LocationDesVoitures;


import java.util.ArrayList;


import javax.swing.table.AbstractTableModel;

public class ModeleV extends AbstractTableModel {
	
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Car> cars = new ArrayList<Car>();
	    private final String[] entetes = {"id", "Matricule", "category","name","car R/j"};
	    private ArrayList<Integer> allPrices = new ArrayList<Integer>() ;
	    public ModeleV() {
	        super();
	        Connexion conn = new Connexion();
	        cars = conn.getAllCars();
	        for (int i = 0;i< cars.size();i++ ) {
	        fireTableRowsInserted(cars.size() , cars.size() );
	   
	        }}
	    

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			  return cars.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return entetes.length;
		}

		
	
	   
	 
	    public String getColumnName(int columnIndex) {
	        return entetes[columnIndex];
	    }
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        @SuppressWarnings("unused")
			Object p;
			switch(columnIndex){
	            case 0:
	                return cars.get(rowIndex).getId();
	            case 1:
	                return cars.get(rowIndex).getMatricule();
	            case 2:
	                return cars.get(rowIndex).getCatgory();
	            case 3:
	                return cars.get(rowIndex).getName();
	            case 4:
	            	allPrices.add(cars.get(rowIndex).getCarRJ());	   
	            	return cars.get(rowIndex).getCarRJ();
	          
	     
	            default:
	                return null; 
	        }
	        
	    }

	    public ArrayList<Integer> getAllPrices() {

     	for (int c :  allPrices) {
	    	
			System.out.println(c);
	    }
	   
     	return allPrices;
	  

	    }
	    public void removeV(int rowIndex) {
	        cars.remove(rowIndex);
	        fireTableRowsDeleted(rowIndex, rowIndex);
	    }
	    





}
