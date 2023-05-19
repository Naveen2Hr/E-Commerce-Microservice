package com.softtek.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("OrderManagement")
public interface OrderServiceClient {

}
