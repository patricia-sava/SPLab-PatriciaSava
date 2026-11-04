package ro.uvt.services;

public interface CommandExecutor {
    <T> T executeCommand(Command<T> command);
}