package dependency_injection;

public class Demo {

	public static void main(String[] args) {
		Long moneyPayedByCash = new Long (40000);
		Long moneyPayedByVisa = new Long (50000);
		Long moneyPayedByPaypal = new Long (60000);

		IPaymentServiceInjector injector = null;
		IPaymentConsumer app = null;
		
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
