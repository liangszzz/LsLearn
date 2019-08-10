package commend;

import com.beust.jcommander.Parameter;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Args {

    @Parameter
    private List<String> paramters = new ArrayList<>();

    @Parameter(
            names = {"-log", "-verbose"},
            description = "Level of verbosity")
    private Integer verbose = 1;

    @Parameter(names = "-groups", description = "list")
    private String groups;

    @Parameter(names = "-debug", description = "Debug mode")
    private boolean debug = false;
}
