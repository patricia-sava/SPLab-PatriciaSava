package ro.uvt.services;

import org.springframework.stereotype.Component;

@Component("syncExecutor")
public class SynchronousCommandExecutor implements CommandExecutor {
    @Override
    public <T> T executeCommand(Command<T> command) {
        return command.execute();
    }
}