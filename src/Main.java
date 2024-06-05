import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner input = new Scanner(System.in);

        String opcoes = """
                1- Dollar -> Real
                2- Real -> Dollar
                3- Euro - Real
                4- Real -> Euro
                5- Yuan -> Real
                6- Real -> Yuan
                7- Sair
                """;
        System.out.println("Seja bem vindo ao conversor de moedas :)");

        Integer resposta = 0;
        while (resposta != 7){
            System.out.println(opcoes);
            resposta = input.nextInt();

            if (resposta == 7){
                System.out.println("Encerrando o programa...");
                break;
            }

            String siglaMoeda;
            String siglaMoedaDestino;

            switch (resposta){
                case 1:
                    siglaMoeda = "USD";
                    siglaMoedaDestino = "BRL";
                    break;
                case 2:
                    siglaMoeda = "BRL";
                    siglaMoedaDestino = "USD";
                    break;
                case 3:
                    siglaMoeda = "EUR";
                    siglaMoedaDestino = "BRL";
                    break;
                case 4:
                    siglaMoeda = "BRL";
                    siglaMoedaDestino = "EUR";
                    break;
                case 5:
                    siglaMoeda = "RMB";
                    siglaMoedaDestino = "BRL";
                    break;
                default:
                    siglaMoeda = "BRL";
                    siglaMoedaDestino = "RMB";
                    break;
            }

            BuscarMoedas buscar = new BuscarMoedas();
            ConversionRate lista = buscar.buscarValores(siglaMoeda);
            Map<String, Double> conversionRates = lista.getConversionRate();

            System.out.println("Digite o valor a ser convertido:");
            input.nextLine();
            Double valor = input.nextDouble();

            Double valorConvertido;

            Double valorDaMoedaAtual = conversionRates.get(siglaMoedaDestino);

            valorConvertido = valorDaMoedaAtual * valor;
            System.out.println(valorConvertido);

        }



    }
}
