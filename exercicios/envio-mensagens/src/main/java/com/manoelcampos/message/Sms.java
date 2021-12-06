package com.manoelcampos.message;

/**
 * Envia mensagens pelo Short Message Service (SMS)
 * @author Manoel Campos da Silva Filho
 */
public class Sms implements MessageService {
    @Override
    public void send(final String destination, final String msg) throws MessageSendException {
        //TODO: Inclua um print para simular o envio da mensagem
    }
}
