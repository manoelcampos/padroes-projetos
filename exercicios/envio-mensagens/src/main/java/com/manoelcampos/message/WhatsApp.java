package com.manoelcampos.message;

/**
 * Envia mensagens pelo WhatsApp.
 * @author Manoel Campos da Silva Filho
 */
public class WhatsApp implements MessageService {
    /**
     * {@inheritDoc}
     * @param destination telefone de destino da mensagem
     * @param msg {@inheritDoc}
     * @throws MessageSendException {@inheritDoc}
     */
    @Override
    public void send(final String destination, final String msg) throws MessageSendException {
        System.out.printf("Enviando msg WhatsApp para %s: %s%n", destination, msg);
    }
}
