package ru.aakifiev.servicesDao;

import ru.aakifiev.model.Contact;

import java.util.List;

/**
 * Created by aakifiev on 28.12.2016.
 */
public interface ContactDao {
    List<Contact> findAll();
    List<Contact> findByFirstName();
    String findLastNameById(Long id);
    String findFirstNameById(Long id);
    void insert(Contact contact);
    void update(Contact contact);
    void delete(Long contactId);
}
