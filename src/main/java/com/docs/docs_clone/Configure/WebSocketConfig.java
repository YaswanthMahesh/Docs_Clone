package com.docs.docs_clone.Configure;

import com.docs.docs_clone.Model.Doc;
import com.docs.docs_clone.Model.DocPojo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Bean
    public ConcurrentHashMap<String, DocPojo> unsavedChangesMap() {
        return new ConcurrentHashMap<>();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // This sets up a simple in-memory message broker to broadcast messages
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // This is the endpoint that clients will connect to
        registry.addEndpoint("/ws").withSockJS();
    }
}
