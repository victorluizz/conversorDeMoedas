import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscarMoedas {


    public ConversionRate buscarValores(String moeda) throws IOException, InterruptedException {
        URI requisicao = URI.create("https://v6.exchangerate-api.com/v6/a02c56f625cb6e300c85ddda/latest/" + moeda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(requisicao)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), ConversionRate.class);
    }
}
