package com.LocationDesVoitures;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class Connexion {
	private static String id, password, url;
	private static Connection cn;
	private static Statement st;
	private static ResultSet rs;
	private static PreparedStatement pst;
	
	
	
	public Connexion() {

		Connexion.url = "jdbc:mysql://localhost/LocationVoitures";
		Connexion.id = "root";
			Connexion.password = "";
			cn = null;
			st = null;
			rs = null;

	}

	public boolean connexion(String log, String pass) {
		boolean rep = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				cn = DriverManager.getConnection(url, id, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st = cn.createStatement();
			String query = "select * from login where username = ? and password = ? ";
			pst = cn.prepareStatement(query);
			pst.setString(1, log);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			
			
			while(rs.next()) {
				
				if((rs.getString(1) != "") && (rs.getString(2) != "") ){
			   
					rep = true;
				}
				else {
					rep = false;
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
			// Libérer les ressources de la mémoire
			cn.close();
			pst.close();
			st.close();
			rs.close();
			}
			catch(SQLException e) {
			e.printStackTrace();
			}}
	
		if (rep == true)
			return true;
		else return false ;

	}
	
	
	public List<String>  retriveCat (String column) {
		List<String> categories = new ArrayList<String>();
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				cn = DriverManager.getConnection(url, id, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st = cn.createStatement();
			String query1 = "select distinct $column from voitures ";
			String query =query1.replace("$column",column);
			pst = cn.prepareStatement(query);
			rs = pst.executeQuery();
			int size =0;
		
			while (rs.next()) {
			 
				  
			     categories.add(rs.getString(1));
			}
			 
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
			// Libérer les ressources de la mémoire
			cn.close();
			st.close();
			rs.close();
			}
			catch(SQLException e) {
			e.printStackTrace();
			}}
		return categories;
		
	}
	public List<String>  retriveName (String column, String cat) {
		List<String> names = new ArrayList<String>();
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				cn = DriverManager.getConnection(url, id, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st = cn.createStatement();
			String query1 = "select  $column from voitures where category = ? ";
			String query =query1.replace("$column",column);
			pst = cn.prepareStatement(query);
			pst.setString(1, cat);
			rs = pst.executeQuery();
			while (rs.next()) {
			 
				  
			   names.add(rs.getString(1));
			}
			 
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
			// Libérer les ressources de la mémoire
			cn.close();
			st.close();
			rs.close();
			}
			catch(SQLException e) {
			e.printStackTrace();
			}}
		return names;
		
	}

	public void  insertClient(String nom , String prenom , int cin , int phone ,String car, String typeC,  String datef, String datet) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				cn = DriverManager.getConnection(url, id, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st = cn.createStatement();
		
			String query = "INSERT INTO clients (nom,prenom,cin,phone,car,typeC,datef,datet) " + "VALUES (?,?,?,?,?,?,?,?)";
			pst = cn.prepareStatement(query);
			pst.setString(1,nom);
			pst.setString(2,prenom);
			pst.setInt(3,cin);
			pst.setInt(4, phone);
			pst.setString(5, car);
			pst.setString(6, typeC);
			pst.setString(7, datef);
			pst.setString(8, datet);
			pst.executeUpdate();
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
			}
	
//////////////////////////////////////////////////////////////////
	
public void  insertAClient(String nom , String prenom , int cin , int phone ,String car, String typeC,  String datef, String datet) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				cn = DriverManager.getConnection(url, id, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st = cn.createStatement();
		
			String query = "INSERT INTO ancienClients (nom,prenom,cin,phone,car,typeC,datef,datet) " + "VALUES (?,?,?,?,?,?,?,?)";
			pst = cn.prepareStatement(query);
			pst.setString(1,nom);
			pst.setString(2,prenom);
			pst.setInt(3,cin);
			pst.setInt(4, phone);
			pst.setString(5, car);
			pst.setString(6, typeC);
			pst.setString(7, datef);
			pst.setString(8, datet);
			pst.executeUpdate();
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
			}
	
//////////////////////////////////////////////////////////////////

	public ArrayList<Client> getAllClients() 
	{
		ArrayList<Client> clients  = new ArrayList<Client>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				cn = DriverManager.getConnection(url, id, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st = cn.createStatement();
			String query = "select * from clients  ";
			pst = cn.prepareStatement(query);
			rs = pst.executeQuery();
			
		
			while (rs.next()) {
				Client client = new Client();
				  client.setId(rs.getInt("id"));
				  client.setNom(rs.getString("nom"));
				  client.setPrenom(rs.getString("prenom"));
				  client.setCin(rs.getInt("cin"));
				  client.setPhone(rs.getInt("phone"));
				  client.setCar(rs.getString("car"));
				  client.setTypeCar(rs.getString("typeC"));
				  client.setDateFrom(rs.getString("datef"));
				  client.setDateTo(rs.getString("datet"));
				 
				 
			        clients.add(client);
			}
			 
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
			// Libérer les ressources de la mémoire
			cn.close();
			st.close();
			rs.close();
			}
			catch(SQLException e) {
			e.printStackTrace();
			}}
		return clients ;
}
	
	
	  public int CalcP(String idC) {
		  int rep = 0;
		  try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					cn = DriverManager.getConnection(url, id, password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				st = cn.createStatement();
				String query = "select carPJ from voitures WHERE nameV = ? ";
				pst = cn.prepareStatement(query);
				pst.setString(1, idC);
				rs = pst.executeQuery();
				 while(rs.next()) {
					 
					  rep = rs.getInt(1);
					 
				 }
	    }
		  
		 catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
			// Libérer les ressources de la mémoire
			cn.close();
			st.close();
			rs.close();
			}
			catch(SQLException e) {
			e.printStackTrace();
			}}
		  	return rep;
}
	  
	  
	  

		public void  insertCar( int matricule ,String category , String nameV , int carPJ ) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					cn = DriverManager.getConnection(url, id, password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				st = cn.createStatement();
			
				String query = "INSERT INTO voitures (matricule,category,nameV,carPJ) " + "VALUES (?,?,?,?)";
				pst = cn.prepareStatement(query);
				pst.setInt(1,matricule);
				pst.setString(2,category);
				pst.setString(3,nameV);
				pst.setInt(4, carPJ);
				

				pst.executeUpdate();
				
				
				

			} catch (Exception e) {
				e.printStackTrace();
			}
				}
		public ArrayList<Car> getAllCars() 
		{
			ArrayList<Car> cars  = new ArrayList<Car>();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					cn = DriverManager.getConnection(url, id, password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				st = cn.createStatement();
				String query = "select * from voitures  ";
				pst = cn.prepareStatement(query);
				rs = pst.executeQuery();
				
			
				while (rs.next()) {
					Car car = new Car();
					  car.setId(rs.getInt("id"));
					  car.setCatgory(rs.getString("category"));
					  car.setName(rs.getString("nameV"));
					  car.setCarRJ(rs.getInt("CarPJ"));
					
					  car.setMatricule(rs.getInt("matricule"));
					 
					 
				        cars.add(car);
				}
				 
				  
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				try {
				// Libérer les ressources de la mémoire
				cn.close();
				st.close();
				rs.close();
				}
				catch(SQLException e) {
				e.printStackTrace();
				}}
			return cars ;
	}
		
	public void deleteVById(int id1) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					cn = DriverManager.getConnection(url, id, password);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				st = cn.createStatement();
				String query = "DELETE FROM voitures where id = ? ";
				pst = cn.prepareStatement(query);
				pst.setInt(1, id1);
				 pst.executeUpdate();
				JOptionPane.showMessageDialog(null, " Car Deleted successfully ");
			
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				try {
				
				cn.close();
				pst.close();
				st.close();
			
				}
				catch(SQLException e) {
				e.printStackTrace();
				}}
		
		
		  }
	public void deleteCById(int id1) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				cn = DriverManager.getConnection(url, id, password);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			st = cn.createStatement();
			String query = "DELETE FROM clients where id = ? ";
			pst = cn.prepareStatement(query);
			pst.setInt(1, id1);
			 pst.executeUpdate();
			JOptionPane.showMessageDialog(null, " Client Deleted successfully ");
		
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
			// Libérer les ressources de la mémoire
			cn.close();
			pst.close();
			st.close();
		
			}
			catch(SQLException e) {
			e.printStackTrace();
			}}
	
	
	  }
	public List<String>  retriveSelectedC (int idC) {
		List<String> client = new ArrayList<String>();
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				cn = DriverManager.getConnection(url, id, password);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			st = cn.createStatement();
			String query = "select  * from clients where id= ? ";
			
			pst = cn.prepareStatement(query);
			pst.setInt(1, idC);
			rs = pst.executeQuery();
			while (rs.next()) {
				client.add(rs.getString(2));				  
			   client.add(rs.getString(3));
			   client.add(rs.getString(4));
			   client.add(rs.getString(5));
			   client.add(rs.getString(6));
			   client.add(rs.getString(7));
			   client.add(rs.getString(8));
			   client.add(rs.getString(9));
			}
			 
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
			// Libérer les ressources de la mémoire
			cn.close();
			st.close();
			rs.close();
			}
			catch(SQLException e) {
			e.printStackTrace();
			}}
		return client;
		


}
	public void  UpdateClient(String id1,String nom , String prenom , int cin , int phone ,String car, String typeC,  String datef, String datet) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				cn = DriverManager.getConnection(url, id, password);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			st = cn.createStatement();
		
			String query1 = "Update  clients set nom = ?,prenom = ?,cin = ? ,phone = ? , car = ? , typeC = ? , datef = ? , datet = ? WHERE id = $id";
			String query =query1.replace("$id",id1);
			pst = cn.prepareStatement(query);
			pst.setString(1,nom);
			pst.setString(2,prenom);
			pst.setInt(3,cin);
			pst.setInt(4, phone);
			pst.setString(5, car);
			pst.setString(6, typeC);
			pst.setString(7, datef);
			pst.setString(8, datet);
			pst.executeUpdate();
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
			}
	
	
	
	
	/////////////////////////////////////////////£
	public List<String>  retriveSelectedCar (int idC) {
		List<String> cars = new ArrayList<String>();
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				cn = DriverManager.getConnection(url, id, password);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			st = cn.createStatement();
			String query = "select  * from voitures where id= ? ";
			
			pst = cn.prepareStatement(query);
			pst.setInt(1, idC);
			rs = pst.executeQuery();
			while (rs.next()) {
				cars.add(rs.getString(2));				  
			   cars.add(rs.getString(3));
			   cars.add(rs.getString(4));
			   cars.add(rs.getString(5));
			   cars.add(rs.getString(6));
			   
			}
			 
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
			// Libérer les ressources de la mémoire
			cn.close();
			st.close();
			rs.close();
			}
			catch(SQLException e) {
			e.printStackTrace();
			}}
		return cars;
	}
		

	
//////////////////////////////////////////////////////////////////
public void  UpdateCar(String id1,int matricule , String category , String  name , int carRJ ) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				cn = DriverManager.getConnection(url, id, password);
			} catch (Exception e) {
		
				e.printStackTrace();
			}
			st = cn.createStatement();
		
			String query1 = "Update  voitures set matricule = ?,category = ?,nameV = ? ,carPJ = ? , qte = ?  WHERE id = $id";
			String query =query1.replace("$id",id1);
			pst = cn.prepareStatement(query);
			pst.setInt(1,matricule);
			pst.setString(2,category);
			pst.setString(3,name);
			pst.setInt(4, carRJ);
			pst.executeUpdate();
			
			
			
			
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
			// Libérer les ressources de la mémoire
			cn.close();
			st.close();
			
			}
			catch(SQLException e) {
			e.printStackTrace();
			}}
			}
	
//////////////////////////////////////////////////////////////////
   public List<String> retriveDateFCar(String nameC){
	   		List<String> Rdates = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				cn = DriverManager.getConnection(url, id, password);
			} catch (Exception e) {
		
				e.printStackTrace();
			}
			st = cn.createStatement();
		
			String query = "Select datef from clients where typeC = ? ";
			
			pst = cn.prepareStatement(query);
			pst.setString(1,nameC);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				Rdates.add(rs.getString(1));

				
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
			// Libérer les ressources de la mémoire
			cn.close();
			st.close();
			rs.close();
			}
			catch(SQLException e) {
			e.printStackTrace();
			}}
	   return Rdates;
	   
	   
	   
	   
	   
	   
   }








   public List<String> retriveDatetCar(String nameC){
  		List<String> Rdates = new ArrayList<String>();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			cn = DriverManager.getConnection(url, id, password);
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		st = cn.createStatement();
	
		String query = "Select datet from clients where typeC = ? ";
		
		pst = cn.prepareStatement(query);
		pst.setString(1,nameC);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			
			Rdates.add(rs.getString(1));
		
			
			
			
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		try {
		// Libérer les ressources de la mémoire
		cn.close();
		st.close();
		rs.close();
		}
		catch(SQLException e) {
		e.printStackTrace();
		}}
  return Rdates;
  
  
  
  
  
  
}


















/////////////////////////////////////////////////////////////////////////////////

}

