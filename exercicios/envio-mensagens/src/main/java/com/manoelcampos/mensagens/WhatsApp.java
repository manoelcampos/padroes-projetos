package com.manoelcampos.mensagens;

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
    public void send(String destination, String msg) throws MessageSendException {
        System.out.printf("Enviando msg WhatsApp para %s: %s%n", destination, msg);
    }
}
