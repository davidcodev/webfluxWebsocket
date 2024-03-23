package org.hexa.prueba.websocket;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Preguntas {
    private List<String> preguntas;
}
