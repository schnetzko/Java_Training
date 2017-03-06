package dependency_injection.injector;

import dependency_injection.consumer.IPaymentConsumer;

/**
 * @author schnetzko
 *
 * This interface generates app-objects which are already initialized
 * with the service implementation that they used for.
 */

public interface IPaymentServiceInjector {
	IPaymentConsumer getPaymentConsumer();
}
