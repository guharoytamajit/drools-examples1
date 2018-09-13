package com.tacoshop;

import java.math.BigDecimal;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class PurchaseTest {
	public static void main(String[] args) {


		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules2");

			Purchase firstPurchase = new Purchase(new BigDecimal("26"), 2, true);
			  kSession.insert(firstPurchase);
			  
//				Purchase secondPurchase = new Purchase(new BigDecimal("21"), 1, true);
//				  kSession.insert(secondPurchase);
	            kSession.fireAllRules();
	            System.out.println("========================================");
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	}
}
