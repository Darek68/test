package org.example;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");
        persistDemo();

    }
    public static void persistDemo() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SingleUnit");
        EntityManager entityManager = emf.createEntityManager();
        Client client2 = new Client("Imie");
        System.out.println(client2.getId() + "  " + client2.getName());
        EntityTransaction transaction = entityManager.getTransaction();
//        Выполняется открытие транзакции
        transaction.begin();
//        Объект помещается в Persistence Context - INSERT не выполняется
      //  entityManager.persist(client);
        entityManager.persist(client2);
//        Объект (тот же самый) возвращается из Persistent Context - SELECT не выполняется
      //  Client clientFromContext = entityManager.find(Client.class, client.getId());
        Client clientFromContext = entityManager.find(Client.class, client2.getId());
//        Выполняется коммит транзакции - выполняется INSERT
        transaction.commit();
        entityManager.close();
    }
}
