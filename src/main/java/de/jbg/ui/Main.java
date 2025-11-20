package de.jbg.ui;

public class Main {

    public static void main(String[] args) throws Exception {
        memeClient client = new memeClient();
        System.out.println(client.getAll());
    }

}
