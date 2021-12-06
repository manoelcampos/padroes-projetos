package com.manoelcampos.mensagens;

/**
 * Interface para a implementação
 * de serviços de envio de mensagens, como {@link Sms},
 * {@link Email} e {@link WhatsApp}.
 * @author Manoel Campos da Silva Filho
 */
public interface MessageService {
    void enviar() throws MessageSendException;
}
