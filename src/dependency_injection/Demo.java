package dependency_injection;

import dependency_injection.consumer.IPaymentConsumer;
import dependency_injection.injector.CashPaymentServiceInjectorImpl;
import dependency_injection.injector.IPaymentServiceInjector;
import dependency_injection.injector.PaypalPaymentServiceInjectorImpl;
import dependency_injection.injector.VisaPaymentServiceInjectorImpl;

public class Demo {

	public static void main(String[] args) {
		Long moneyPayedByCash = new Long (40000);
		Long moneyPayedByVisa = new Long (50000);
		Long moneyPayedByPaypal = new Long (60000);

		IPaymentServiceInjector injector = null;
		IPaymentConsumer app = null;
		
		/* create an injection obj, generate an app from it and run this app */
		injector = new CashPaymentServiceInjectorImpl();
		app = injector.getPaymentConsumer();
		app.orderPayment(moneyPayedByCash);		
		
		injector = new VisaPaymentServiceInjectorImpl();
		app = injector.getPaymentConsumer();
		app.orderPayment(moneyPayedByVisa);

		injector = new PaypalPaymentServiceInjectorImpl();
		app = injector.getPaymentConsumer();
		app.orderPayment(moneyPayedByPaypal);		
	}
}
