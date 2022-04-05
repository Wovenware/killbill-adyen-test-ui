const configuration = {
	environment: 'test', // Change to 'live' for the live environment.
	clientKey: 'test_QYMXCLW4DBCE3HRQURKINSOM2456R3FQ', // Public key used for client-side authentication: https://docs.adyen.com/development-resources/client-side-authentication
	session: {
		id: 'CSD9CAC3...', // Unique identifier for the payment session.
		sessionData: 'Ab02b4c...' // The payment session data.
	},
	onPaymentCompleted: (result, component) => {
		console.info(result, component);
	},
	onError: (error, component) => {
		console.error(error.name, error.message, error.stack, component);
	},
	// Any payment method specific configuration. Find the configuration specific to each payment method:  https://docs.adyen.com/payment-methods
	// For example, this is 3D Secure configuration for cards:
	paymentMethodsConfiguration: {
		card: {
			hasHolderName: true,
			holderNameRequired: true,
			billingAddressRequired: true
		}
	}
};

// Create an instance of AdyenCheckout using the configuration object.
const checkout = await AdyenCheckout(configuration);

// Create an instance of Drop-in and mount it to the container you created.
const dropinComponent = checkout.create('dropin').mount('#dropin-container');