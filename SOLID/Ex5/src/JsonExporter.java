import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {

    @Override
    protected ExportResult doExport(ExportRequest req) {

        String body =
                req.body == null
                        ? ""
                        : req.body
                            .replace(",", " ")
                            .replace("\n", " ")
                            .replaceAll("\\s+", " ")
                            .trim();

        String json =
                "{\"title\":\"" + escape(req.title) +
                "\",\"body\":\"" + escape(body) + "\"}";

        return new ExportResult(
                "application/json",
                json.getBytes(StandardCharsets.UTF_8)
        );
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace("\"", "\\\"");
    }
}