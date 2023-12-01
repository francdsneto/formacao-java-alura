package estudos.designpattern.loja.http;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class JavaHttpClient implements HttpAdapter {

    @Override
    public void post(String url, Map<String, Object> dados) {
        try {
            URL urlApi = new URL(url);
            URLConnection openedConnection = urlApi.openConnection();
            openedConnection.connect();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar requisição HTTP",e);
        }
    }
}
