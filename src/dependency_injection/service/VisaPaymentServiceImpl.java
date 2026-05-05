package dependency_injection.service;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VisaPaymentServiceImpl implements IPaymentService {

	private static final Logger LOGGER = Logger.getLogger(VisaPaymentServiceImpl.class.getName());
	
	@Override
	public void pay(Long money) {
		LOGGER.log(Level.INFO, "{0} payed by visa", money.toString());
	}

}
