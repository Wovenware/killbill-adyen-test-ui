Kill Bill Adyen demo
=====================

Inspired from the Adyen Drop-In implemantation [Here](https://docs.adyen.com/online-payments/web-drop-in) 

Prerequisites
-------------

* Kill Bill is [already setup](https://docs.killbill.io/latest/getting_started.html)
* The default tenant (bob/lazar) has been created
* The Adyen plugin is installed and configured

Set up
------

Go to the application.property and change the information of the fields that need to be changed 


Run
---

To run the app:
```
mvn spring-boot:run
```

Test 
----

Go to [http://localhost:8086/](http://localhost:8086/) where you should see a box where the amount of the payment need to be input.

Enter dummy data (4242 4242 4242 4242 as the credit card number, any three digit CVC and any expiry date in the future work) and complete one of the two checkout processes.

This will:

* Tokenize the card in Stripe
* Create a new Kill Bill account
* Add a default payment method on this account associated with this token (a customer object is also created in Stripe, so the token can be re-used)
* Create a new subscription for the sports car monthly plan (with a $10 30-days trial)
* Charge the token for $10

![Shopping cart](./screen1.png)

![Checkout](./screen2.png)