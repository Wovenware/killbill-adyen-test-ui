$(document).ready(function() {
	let checkout = async function(result) {
		const configuration = {
			environment: 'test', // Change to 'live' for the live environment.
			clientKey: 'test_2FCWDBJMTVHHJCAPWPO4NWOERANT6YWA', // Public key used for client-side authentication: https://docs.adyen.com/development-resources/client-side-authentication
			session: {
				id: result.id, // Unique identifier for the payment session.
				sessionData: result.sessionData // The payment session data.
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
		const checkout = await new AdyenCheckout(configuration);

		// Create an instance of Drop-in and mount it to the container you created.
		const dropinComponent = checkout.create('dropin').mount('#dropin-container');
	};

	$("#checkoutClick").on("click", function(event) {
		let amount = $("#amountToPaid").val();
		$.ajax({
			url: "/api/session?amount=" + amount,
			success: function(result) {
				console.log("wawa", result);
				checkout(result);
			}
		});
	});
});
