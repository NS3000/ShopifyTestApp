package org.example.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface WebhookService {

    public void handleProducts(String topic, String data) throws JsonProcessingException;
    public void handleCustomers(String topic, String data) throws JsonProcessingException;
    public void handleOrders(String topic, String data) throws JsonProcessingException;
}
