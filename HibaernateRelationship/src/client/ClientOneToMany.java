package client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Stock;
import domain.StockDailyRecord;

public class ClientOneToMany {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		session.beginTransaction();

		Stock stock = new Stock();
		stock.setStockCode("6574");
		stock.setStockName("Srini");
		session.save(stock);

		StockDailyRecord stockDailyRecords = new StockDailyRecord();
		stockDailyRecords.setPriceOpen(new Float("1.2"));
		stockDailyRecords.setPriceClose(new Float("1.1"));
		stockDailyRecords.setPriceChange(new Float("10.0"));
		stockDailyRecords.setVolume(3000000L);
		stockDailyRecords.setDate(new Date());
		stockDailyRecords.setStock(stock);

		StockDailyRecord stockDailyRecord = new StockDailyRecord();
		stockDailyRecord.setPriceOpen(new Float("9.5"));
		stockDailyRecord.setPriceClose(new Float("5.5"));
		stockDailyRecord.setPriceChange(new Float("0.2"));
		stockDailyRecord.setVolume(80006L);
		stockDailyRecord.setDate(new Date());

		stockDailyRecord.setStock(stock);
		stock.getStockDailyRecords().add(stockDailyRecords);
		stock.getStockDailyRecords().add(stockDailyRecord);

		session.save(stockDailyRecords);
		session.save(stockDailyRecord);

		session.getTransaction().commit();
		System.out.println("Done");
	}

}
