package dependency_injection.service;

import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

public class VisaPaymentServiceImpl implements IPaymentService {

	private static final Logger LOGGER = Logger.getLogger(VisaPaymentServiceImpl.class);
	
	@Override
	public void pay(Long money) {
		LOGGER.log(Level.INFO, "{0} payed by visa", money.toString());
	}

}
