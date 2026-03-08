package com.example.payments;

public class SafeCashAdapter  implements PaymentGateway{
    private final SafeCashClient client;
    SafeCashAdapter(SafeCashClient c){
        this.client=c;
    }
    public String charge(String customerId, int amountCents){
        return client.createPayment(amountCents,customerId).confirm();
    }
}
