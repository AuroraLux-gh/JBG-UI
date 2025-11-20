//https://github.com/danvega/todos-http-client/blob/main/src/main/java/todo/TodoClient.java

package de.jbg.ui;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import de.jbg.ui.Execption;

public class memeClient {

    private final static String BASE_URL = "http://localhost:8000/api/memes";
    private final HttpClient client;

    public memeClient() {
        client = HttpClient.newHttpClient();
    }

    public String getAll() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL)).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String findById(int memeID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + memeID))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        /*
        if(response.statusCode() == 404) {
            throw new memeNotFoundException("memeID.Meme not found");
        }
         */

        return response.body();
    }


    /* further methods which could be implemented

    public HttpResponse<String> create(Todo todo) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(todo)))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> update(Todo todo) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + todo.id()))
                .PUT(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(todo)))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> delete(Todo todo) throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + todo.id()))
                .DELETE()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    */


}