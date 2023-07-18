package model.entites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {

	private Integer number;
	private LocalDate date;
	private double totalValue;
	
	private List<Installment> list = new ArrayList<>();
	private DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public Contract(Integer number, LocalDate date, double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getList() {
		return list;
	}
	
	
	public void setList(List<Installment> list) {
		this.list = list;
	}

	public String toString() {
		String valor="";
		for(Installment i : list) {
		 valor+=i.getDueDate().format(ftm)+" - "+String.format("%.2f",i.getAmount() )+"\n";
		}
		return valor;
	}
}
