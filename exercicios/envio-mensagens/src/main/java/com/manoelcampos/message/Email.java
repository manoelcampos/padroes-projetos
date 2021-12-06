package com.manoelcampos.message;

/**
 * Envia mensagens de email.
 * @author Manoel Campos da Silva Filho
 */
public class Email implements MessageService {
    @Override
    public void send(final String destination, final String msg) throws MessageSendException {
        //TODO: Inclua um print para simular o envio da mensagem
    }
}
