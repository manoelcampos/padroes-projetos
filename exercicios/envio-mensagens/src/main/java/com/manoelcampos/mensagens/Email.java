package com.manoelcampos.mensagens;

/**
 * Envia mensagens de email.
 * @author Manoel Campos da Silva Filho
 */
public class Email implements MessageService {
    @Override
    public void send(String destination, String msg) throws MessageSendException {
        //TODO: Inclua um print para simular o envio da mensagem
    }
}
