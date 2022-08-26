package database;


import Data.Persons;

public class DBQueryTesting {

    public static void main(String[] args) throws Exception {
        String sqlQuery = "Select * from Persons";
        DatabaseUtil databaseUtil = new DatabaseUtil();

        databaseUtil
                .getQueryResultWithType(sqlQuery, Persons.class)
                .forEach(System.out::println);
        
       databaseUtil
               .getQueryResult(sqlQuery)
               .forEach(System.out::println);

    }






}
