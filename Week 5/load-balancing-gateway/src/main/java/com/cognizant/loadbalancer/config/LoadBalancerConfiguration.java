package com.cognizant.loadbalancer.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadBalancerConfiguration {

    @Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier() {

        return new ServiceInstanceListSupplier() {

            @Override
            public String getServiceId() {
                return "my-service";
            }

            @Override
            public reactor.core.publisher.Flux<List<ServiceInstance>> get() {

                ServiceInstance instance1 =
                        new org.springframework.cloud.client.DefaultServiceInstance(
                                "my-service-1",
                                "my-service",
                                "localhost",
                                8081,
                                false
                        );

                ServiceInstance instance2 =
                        new org.springframework.cloud.client.DefaultServiceInstance(
                                "my-service-2",
                                "my-service",
                                "localhost",
                                8082,
                                false
                        );

                return reactor.core.publisher.Flux.just(
                        List.of(instance1, instance2)
                );
            }
        };
    }
}