package ro.uvt.services;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component("asyncExecutor")
public class AsynchronousCommandExecutor implements CommandExecutor {
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    @Override
    public <T> T executeCommand(Command<T> command) {
        // Execută comanda asincron pe un thread separat
        executor.submit(command::execute);
        return null;
    }
}