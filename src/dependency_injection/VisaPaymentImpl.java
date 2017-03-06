package dependency_injection;

import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

public class VisaPaymentImpl implements IPaymentService {

	private static final Logger LOGGER = Logger.getLogger(VisaPaymentImpl.class);
	
	@Override
	public void pay(Long money) {
		LOGGER.log(Level.INFO, "{0} payed by visa", money.toString());
	}

}
