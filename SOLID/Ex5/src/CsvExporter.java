import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {

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

        String csv =
                "title,body\n" +
                req.title + "," + body;

        return new ExportResult(
                "text/csv",
                csv.getBytes(StandardCharsets.UTF_8)
        );
    }
}