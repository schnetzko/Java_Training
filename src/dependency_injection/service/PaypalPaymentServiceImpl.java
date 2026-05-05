package dependency_injection.service;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PaypalPaymentServiceImpl implements IPaymentService {

	private static final Logger LOGGER = Logger.getLogger(PaypalPaymentServiceImpl.class.getName());
	
	@Override
	public void pay(Long money) {
		LOGGER.log(Level.INFO, "{0} payed by Paypal", money.toString());
	}
}
