package dependency_injection.injector;

import dependency_injection.consumer.BankConsumerImpl;
import dependency_injection.consumer.IPaymentConsumer;
import dependency_injection.service.PaypalPaymentServiceImpl;

/**
 * @author schnetzko
 *
 * This class generates app-objects (here BankConsumerImpl) which are already initialized
 * with the service implementation that they used for (here PaypalPaymentServiceImpl).
 */
public class PaypalPaymentServiceInjectorImpl implements IPaymentServiceInjector{

	@Override
	public IPaymentConsumer getPaymentConsumer(){
		return new BankConsumerImpl (new PaypalPaymentServiceImpl());
	}
}
