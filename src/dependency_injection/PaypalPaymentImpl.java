package dependency_injection;

import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

public class PaypalPaymentImpl implements IPaymentService {

	private static final Logger LOGGER = Logger.getLogger(PaypalPaymentImpl.class);
	
	@Override
	public void pay(Long money) {
		LOGGER.log(Level.INFO, "{0} payed by Paypal", money.toString());
	}
}
