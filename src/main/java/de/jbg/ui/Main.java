package de.jbg.ui;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        UI.lossHihi();
        memeClient client = new memeClient();
        System.out.println(client.getAll());
    }

}
