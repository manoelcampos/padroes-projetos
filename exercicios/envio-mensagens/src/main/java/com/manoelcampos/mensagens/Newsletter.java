package com.manoelcampos.mensagens;

import com.manoelcampos.people.Customer;

import java.util.List;

/**
 * Envia mensagens em massa para uma lista de clientes,
 * utilizando algum {@link MessageService}.
 *
 * @author Manoel Campos da Silva Filho
 */
public class Newsletter {
    private final List<Customer> customers;
    private WhatsApp whatsapp;

    public Newsletter(List<Customer> customers){
        this.customers = customers;
        this.whatsapp = new WhatsApp();
    }

    /**
     * Envia uma mensagem personalizada para uma lista de clientes.
     * Não é obrigatória a inclusão de marcadores no template.
     * Um exemplo de template seria:
     *      Olá #name, seu telefone foi atualizado para #phone.
     * @param msgTemplate Um template de mensagem com marcações (placeholders)
     *        que serão substituídos por atributos do cliente de destino.
     */
    public void send(String msgTemplate) {
        for (Customer customer : customers) {
            whatsapp.send(customer.getPhone(), formatMsg(customer, msgTemplate));
        }
    }

    /**
     * Substitui marcações (placeholders) na mensagem por valores
     * de atributos de um cliente.
     *
     * @param customer cliente de destino
     * @param msgTemplate Um template de mensagem com marcações (placeholders)
     *        que serão substituídos por atributos do cliente de destino.
     * @return a mensagem com as marcações substituídas pelos atributos do cliente.
     */
    private String formatMsg(Customer customer, String msgTemplate) {
        return msgTemplate
            .replaceAll("#name", customer.getName())
            .replaceAll("#email", customer.getName())
            .replaceAll("#phone", customer.getName());
    }


}
