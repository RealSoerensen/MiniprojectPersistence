package model;

public class Invoice {
	int invoiceNo;
	String paymentDate;
	public Invoice(int InvoiceNo, String paymentDate){
		this.invoiceNo = InvoiceNo;
		this.paymentDate = paymentDate;
	}
	public int getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	};
}
