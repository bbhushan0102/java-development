
For normal Hibernate use following code in App class
// Hibernate operations
        try {
            // Create object of entity class type

            Users user = new Users();

            // Start transaction
            session.beginTransaction();

            // Perform operation
            // Read from table
//            user = session.get(Users.class, 22);
//            update table with user details

//            user = session.get(Users.class, 22);
//            user.setEmail("hibernate-test@gmail.com");
//            user.setUsername("hibernate-test");

//            Delete user from table
            user = session.get(Users.class, 22);
            session.delete(user);

            // Commit the transaction
            session.getTransaction().commit();
            System.out.println(user);