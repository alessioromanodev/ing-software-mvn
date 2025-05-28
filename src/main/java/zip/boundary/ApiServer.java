package zip.boundary;

import static spark.Spark.*;
import com.google.gson.Gson;
import zip.control.FumettoController;
import zip.entity.Fumetto;

import java.util.List;

public class ApiServer {
    public static void main(String[] args) {
        port(8080);

        FumettoController controller = new FumettoController();
        Gson gson = new Gson();

        get("/fumetti", (req, res) -> {
            res.type("application/json");
            List<Fumetto> lista = controller.findAll(); 
            return gson.toJson(lista);
        });
    }
}