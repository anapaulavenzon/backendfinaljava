package com.atividadefinaldemodulobackend.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice // captura possiveis problemas
public class ResourceExceptionHandler {
    // a anotação captura a determinada exceção.class
    // o método deve ser publico (a exceção, objeto especial do java web que contem as requisições)
    @ExceptionHandler({ExcecaoDePaginaNaoEncontrada.class})
    public ResponseEntity<StandarError> entityNotFound(
            ExcecaoDePaginaNaoEncontrada excecao,
            HttpServletRequest request
    ){
        StandarError error = new StandarError();

        error.setTimestamp(Instant.now()); // pego o horario atual
        error.setStatus(HttpStatus.NOT_FOUND.value()); // pega o status do erro 404 . value conte em número
        error.setError("Recurso não encontrado"); // mostra uma mensagem
        error.setMessage(excecao.getMessage()); // pega a mensagem la do service
        error.setPath(request.getRequestURI()); // pega o caminho url
        // retorna o status junto as informações
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
