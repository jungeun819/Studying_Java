package slot_machine.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import slot_machine.model.vo.Product;

public class ProductIO {
	private File snackFile = new File("snackList,ser");
	private File beverageFile = new File("beverageList,ser");
	private File dailyFile = new File("dailyList,ser");
	
	// 과자
	public List<Product> loadSnackList() {
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(snackFile)))){
			return (List<Product>)ois.readObject();
		} catch (IOException | ClassNotFoundException  e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void saveSnackList(List<Product> snackList) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(snackFile)))){
			oos.writeObject(snackList);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// 음료
	public List<Product> loadbeverageList() {
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(beverageFile)))){
			return (List<Product>)ois.readObject();
		} catch (IOException | ClassNotFoundException  e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void savebeverageList(List<Product> beverageList) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(beverageFile)))){
			oos.writeObject(beverageList);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// 생필품
	public List<Product> loadDailyList() {
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dailyFile)))){
			return (List<Product>)ois.readObject();
		} catch (IOException | ClassNotFoundException  e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void savedailyList(List<Product> dailyList) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dailyFile)))){
			oos.writeObject(dailyList);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
