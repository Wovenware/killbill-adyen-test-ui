package com.wovenware.adyentestui;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.killbill.billing.client.KillBillClientException;
import org.killbill.billing.client.model.gen.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	private String theSessionId = "CS7862662B1AFF0D88";
	private String theSessionData = "Ab02b4c0!BQABAgBlUSAC8zSnEE7jEIGkDviT2RVe448Wao9b61IrUlzhyVc3nU2beo79Lbnlp2FOOX3aW4XGgGf2htLVJ3uxVmR9BczAusC+bVkeVgjkg7EcETBUd/SNEFCcKHdkRA5tpI6QheWxAz+V+LLoBPKEBPHQHnqih2Npe2fon1HfNGRoTFUMSZCdXXZnfq2xUP2oWJwITaJc3SOOvmbpXIOskg6XHwsphCRIQuB/acLUo8C6zX+QWAdDB9WeJJxzRwcaGiLVjLDguv9eY/s5Ojp+uU7D2shtyxRoXUkdKdpQ7AO0ndcdekbV9jtkusv6tlhrSgNfLTzHKTIigw0YnINsynLDsugLDaTRN48EQXgzjvMfPWKnfYT/NauvrEE1wc/vDlEnjo9OossE62X1uLLL2PFpUYAkmHW9h4GoFK9+84ho0dNzZ/Usa5n7j1RWtAr/t7vPXAsuyD268CRDvz5hyo7i/hrI0xG1AteRF1L2EGvPTcsWkj6Zc6zeUjDdP68xifAVVBsZfRz5K0/fKr/fjUsVSW5GV7WlouTUYHMlzNvIxuDW8KviVJH/W1FVMZt8GO29VG6Xcebi+lgkOFFJ+frQC9OdiIeE/czQmNk4Sj/XFgl1KDHVKT2+ruJRkQ7TaiyZhhsBuPZVC8KzGih+pIs/hFinHwEMsQndCtUN8COOjRCLFEx8UO9BVrZtwGZU45cdAEp7ImtleSI6IkFGMEFBQTEwM0NBNTM3RUFFRDg3QzI0REQ1MzkwOUI4MEE3OEE5MjNFMzgyM0Q2OERBQ0M5NEI5RkY4MzA1REMifUYy96OulplMuZRGc96ldcGqx7hBJIJB6eW3rK5H6+Q/ggWLfNJRHndLJ2lhdsxpwhvjHnRwG4MR4YCcW6nd64pmkQWYoENhKJiBcTBLybY80JWMQm3Hlb78JAGwc3/JnbhEpaEhlXP1zHYjThPI17qmfTVO+dFyk4CV+D/PPI9soXypMV1pte6dwBfQwPCR/o+DeSzbJkrW8Wr/T1yniBYQc6iWvnK63lzvb7LLGlcy6pDB7fp3+1nK4hqlAxzceqLl/ZURYw0m3IDj8eU1BUStZSvfV0YXKqCsn/Hr5lkwN5GYnK1aIRu48Jc4OcZSgtaw0XAs5/OA4fXdgG7azKZbIncpqZdyjzXD17QsHAdnDrr/GqdAlMKkRDidZWFDhH/6R2npS6J8VmwgwmlDOhXHMiTxsFEKBPnCHPd8Qc2c6O0f28cN8qhHSaRJC5mA8WgVw9RD6hhvjfKYuO/qJJc9Y3SF";

	@Autowired
	ClientService clientService;

	@GetMapping("/session")
	public SessionModel getSession(@RequestParam(name = "amount") BigDecimal amount) throws KillBillClientException {
		SessionModel ss = new SessionModel();
		ss.setId(theSessionId);
		ss.setSessionData(theSessionData);

//		if (amount != null) {
//			return ss;
//		}
		Account account = clientService.createKBAccount();
		if (amount == null) {
			amount = BigDecimal.TEN;
		}
		Map<String, String> prop = new HashMap<>();
		prop.put(ClientService.NEW_SESSION_AMOUNT, amount.toPlainString());
		return clientService.createSession(account, prop);
	}
}
