package invoiceSys;

import java.sql.Date;

public class Invoice {

			String customer_full_name;
			int phone_number;
			Date invoice_date;
			int number_of_items;
			Double total_amount;
			Double paid_amount;
			Double balance;
			public String getCustomer_full_name() {
				return customer_full_name;
			}
			public void setCustomer_full_name(String customer_full_name) {
				this.customer_full_name = customer_full_name;
			}
			public int getPhone_number() {
				return phone_number;
			}
			public void setPhone_number(int phone_number) {
				this.phone_number = phone_number;
			}
			public Date getInvoice_date() {
				return invoice_date;
			}
			public void setInvoice_date(Date invoice_date) {
				this.invoice_date = invoice_date;
			}
			public int getNumber_of_items() {
				return number_of_items;
			}
			public void setNumber_of_items(int number_of_items) {
				this.number_of_items = number_of_items;
			}
			public Double getTotal_amount() {
				return total_amount;
			}
			public void setTotal_amount(Double total_amount) {
				this.total_amount = total_amount;
			}
			public Double getPaid_amount() {
				return paid_amount;
			}
			public void setPaid_amount(Double paid_amount) {
				this.paid_amount = paid_amount;
			}
			public Double getBalance() {
				return balance;
			}
			public void setBalance(Double balance) {
				this.balance = balance;
			}
			

}
