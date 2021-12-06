package com.manoelcampos.message;

/**
 * Interface para a implementação
 * de serviços de envio de mensagens, como {@link Sms},
 * {@link Email} e {@link WhatsApp}.
 * @author Manoel Campos da Silva Filho
 */
public interface MessageService {
    /**
     * Envia uma mensagem para um determinado cliente.
     * @param destination destino da mensagem, que pode ser um email ou número de telefone,
     *                    dependendo da implementação do serviço.
     * @param msg texto da mensagem
     * @throws MessageSendException
     */
    void send(String destination, String msg) throws MessageSendException;
}
