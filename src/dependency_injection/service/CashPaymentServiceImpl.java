package dependency_injection.service;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CashPaymentServiceImpl implements IPaymentService {

	private static final Logger LOGGER = Logger.getLogger(CashPaymentServiceImpl.class.getName());
	
	@Override
	public void pay(Long money) {
		LOGGER.log(Level.INFO, "{0} payed by cash", money.toString());
	}
}
