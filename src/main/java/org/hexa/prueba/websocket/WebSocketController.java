package org.hexa.prueba.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.Session;
import jakarta.websocket.WebSocketContainer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/websocket")
public class WebSocketController {
    @PostMapping
    public ResponseEntity<String> simulaRecopilador(@RequestBody List<String> preguntas) {
        ObjectMapper mapper = new ObjectMapper();
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String canal = "ws://localhost:8080/canalWS";

        try (Session session = container.connectToServer(ClienteEndpoint.class, new URI(canal))){
            String preguntasJson = mapper.writeValueAsString(new Preguntas(preguntas));
            session.getBasicRemote().sendText(preguntasJson);
        } catch (Exception e) {
            e.printStackTrace();
            
        }

        return ResponseEntity.ok("PREGUNTAS ENVIADAS AL FRONT!");
    }
}
