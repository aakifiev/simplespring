package ru.aakifiev;

import com.sun.glass.ui.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import ru.aakifiev.model.Contact;
import ru.aakifiev.servicesDao.ContactDao;
import ru.aakifiev.servicesDao.PlainContactDao;

import java.util.List;


public class Hello {

    private static ContactDao contactDao = new PlainContactDao();

    public static void main(String[] srgs) {
        System.out.println("Listing initial contact data: ");
        listAllContacts();
        System.out.println();
        System.out.println("Insert a new contact");
        Contact contact = new Contact();
    }

    private static void listAllContacts(){
        List<Contact> contacts = contactDao.findAll();
        for (Contact contact : contacts){
            System.out.println(contact);
        }
    }
}

















