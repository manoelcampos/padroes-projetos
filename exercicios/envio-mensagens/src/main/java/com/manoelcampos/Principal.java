package com.manoelcampos;

import com.manoelcampos.people.Customer;
import com.manoelcampos.message.Newsletter;

import java.util.List;

/**
 * Executa a aplicação
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        final List<Customer> customers = List.of(
            new Customer("Manoel", "(63) 1111-2222", "manoel@teste.com"),
            new Customer("Breno",  "(63) 3333-4444", "breno@teste.com"),
            new Customer("Raysa",  "(63) 5555-6666", "raysa@teste.com")
        );

        final Newsletter newsletter = new Newsletter(customers);
        final String msgTemplate = "Aproveite as promoções de natal #name.";
        newsletter.send(msgTemplate);
    }
}
