package Client;

import Client.Form.MovieForm;
import Client.Form.OperatorForm;
import Commands.*;
import Enums.ConsoleColor;
import InputOutput.ConsoleReader;
import InputOutput.Reader;
import Models.Movie;
import Server.Receiver;
import exceptions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ConsoleClient implements Client {
    private final Reader reader = new ConsoleReader();
    private boolean stopWorker = false;
    private final Receiver receiver;
    private String[] command;

    public ConsoleClient(Receiver receiver) {
        this.receiver = receiver;

        System.out.println("Можете вводить команды");
    }

    public void worker() {
        while (!stopWorker) {
            try {
                String line = reader.readLine().trim();
                executeCommand(line);

            } catch (WrongCommandException | WrongArgumentsLengthException | IOException | WrongArgumentException |
                     InputInterruptionException | MovieNotFoundException e) {
                System.out.println("Неверные данные " + e.getMessage());
            }
        }
    }
    private void executeCommand(String line) throws WrongCommandException, WrongArgumentsLengthException, IOException,
            WrongArgumentException, InputInterruptionException, MovieNotFoundException {
        String[] splitLine = line.split(" ");
        String commandName = splitLine[0].toLowerCase();
        String[] arguments = Arrays.copyOfRange(splitLine, 1, splitLine.length);
        switch (commandName) {
                case "exit" -> {
                    if (arguments.length != Exit.ARGS_LENGTH) {
                        throw new WrongArgumentsLengthException();
                    }
                    Command command = new Exit(this, receiver);
                    command.execute();
                }
                case "clear" -> {
                    if (arguments.length != Clear.ARGS_LENGTH) {
                        throw new WrongArgumentsLengthException();
                    }
                    Command command = new Clear(this, receiver);
                    command.execute();
                    System.out.println("Коллекция очищена");
                }
                case "add" -> {
                    if (arguments.length != Add.ARGS_LENGTH) {
                        throw new WrongArgumentsLengthException();
                    }

                    String[] movieArgs = new MovieForm(reader).getData();
                    Command command = new Add(this, receiver, movieArgs);
                    command.execute();
                    System.out.println("Фильм добавлен");
                }
                case "save" -> {
                    if (arguments.length != Save.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    Command command = new Save(this, receiver);
                    command.execute();
                    System.out.println("Фильм сохранен");
                }
                case "show" -> {
                    if (arguments.length != Show.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    CommandWithResult<ArrayDeque<Movie>> command = new Show(this, receiver);
                    command.execute();
                    ArrayDeque<Movie> movies = command.getResult();
                    if (movies.size() == 0){
                        System.out.println("В коллекции нет фильмов");
                    }
                    FilmConsole.printMovie(movies);
                }
                case "updateid" -> {
                    if (arguments.length != UpdateId.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    Integer id;
                    try {
                        id = Integer.parseInt(arguments[0]);
                    } catch (NumberFormatException e) {
                        throw new WrongCommandException(", id указан не верно");
                    }

                    String[] movieArgs = new MovieForm(reader).getData();
                    Command command = new UpdateId(this, receiver, id, movieArgs);
                    command.execute();
                    System.out.println("Фильм с id " + id + " обновлен");
                }
                case "head" -> {
                    if (arguments.length != Head.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    CommandWithResult<Movie> command = new Head(this, receiver);
                    command.execute();
                    Movie firstMovie = command.getResult();
                    FilmConsole.oneMovie(firstMovie);
                }
                case "removebyid" -> {
                    if (arguments.length != RemoveById.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    int id = Integer.parseInt(arguments[0]);
                    CommandWithResult<Boolean> command = new RemoveById(this, receiver, id);
                    command.execute();
                    boolean result = command.getResult();
                    if (result) {
                        System.out.println("Фильм с id " + id + " удален");
                    } else {
                        System.out.println("Фильм с id " + id + " не удален");
                    }
                }
                case "removefirst" -> {
                    if (arguments.length != RemoveFirst.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    Command command = new RemoveFirst(this, receiver);
                    command.execute();
                    System.out.println(ConsoleColor.BLUE.getCode() + "Первый фильм удален");
                }
                case "removehead" -> {
                    if (arguments.length != RemoveHead.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    CommandWithResult<Movie> command = new RemoveHead(this, receiver);
                    command.execute();
                    Movie firstMovie = command.getResult();
                    FilmConsole.oneMovie(firstMovie);
                    System.out.println(ConsoleColor.BLUE.getCode() + "Фильм удален");
                }
                case "countlessthanoperator" -> {
                    if (arguments.length != CountLessThanOperator.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    String[] operatorArgs = new OperatorForm(reader).getData();
                    CommandWithResult<Integer> command = new CountLessThanOperator(this, receiver, operatorArgs);
                    command.execute();
                    int count = command.getResult();
                    System.out.println(ConsoleColor.BLUE.getCode() + "Количество фильмов, значение поля operator которых меньше заданного: " + count);
                }
                case "filtercontainsname" -> {
                    if (arguments.length != FilterContainsName.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    String name = arguments[0];
                    CommandWithResult<ArrayList<Movie>> command = new FilterContainsName(this, receiver, name);
                    command.execute();
                    ArrayList<Movie> movies = command.getResult();
                    if (movies.size() == 0){
                        System.out.println(ConsoleColor.PURPLE.getCode() + "Нет фильмов, которые содержат заданную подстроку");
                    }
                    FilmConsole.printMovie(movies);
                }
                case "filterlessthanoscarscount" -> {
                    if (arguments.length != FilterLessThanOscarsCount.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    Long oscars;
                    try {
                        oscars = Long.valueOf(arguments[0]);
                    } catch (NumberFormatException e) {
                        throw new WrongCommandException(", количество оскаров указано не верно");
                    }
                    CommandWithResult<ArrayDeque<Movie>> command = new FilterLessThanOscarsCount(this, receiver, oscars);
                    command.execute();
                    ArrayDeque<Movie> movies = command.getResult();
                    if (movies.size() == 0){
                        System.out.println(ConsoleColor.PURPLE.getCode() + "Нет фильмов меньше заданного количества оскаров");
                    }
                    FilmConsole.printMovie(movies);
                }
                case "info" -> {
                    if (arguments.length != Info.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    CommandWithResult<String[]> command = new Info(this, receiver);
                    command.execute();
                    String[] result = command.getResult();
                    System.out.println(ConsoleColor.BLUE.getCode() + "Тип коллекции: " + result[0] + ", Размер коллекции: " + result[1] + ", Дата инициализации: " + result[2]);
                }
                case "help" -> {
                    if (arguments.length != Help.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    Command command = new Help(this, receiver);
                    command.execute();
                }
                case "executescript" -> {
                    if (arguments.length != ExecuteScript.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    String filepath = arguments[0];
                    Command command = new ExecuteScript(this, receiver, filepath);
                    command.execute();
                }
                default -> {
                    throw new WrongCommandException(ConsoleColor.PURPLE.getCode() + "Неверная команда " + commandName);
                }

            }
    }

    @Override
    public void exit() {
        stopWorker = true;
    }

    @Override
    public void help() {
        System.out.println("Help: " + Help.DESCRIPTION);
        System.out.println("Info: " + Info.DESCRIPTION);
        System.out.println("Show: " + Show.DESCRIPTION);
        System.out.println("Add: " + Add.DESCRIPTION);
        System.out.println("UpdateId: " + UpdateId.DESCRIPTION);
        System.out.println("RemoveById: " + RemoveById.DESCRIPTION);
        System.out.println("Clear: " + Clear.DESCRIPTION);
        System.out.println("Save: " + Save.DESCRIPTION);
        System.out.println("ExecuteScript: " + ExecuteScript.DESCRIPTION);
        System.out.println("Exit: " + Exit.DESCRIPTION);
        System.out.println("RemoveFirst: " + RemoveFirst.DESCRIPTION);
        System.out.println("Head: " + Head.DESCRIPTION);
        System.out.println("RemoveHead: " + RemoveHead.DESCRIPTION);
        System.out.println("CountLessThanOperator: " + CountLessThanOperator.DESCRIPTION);
        System.out.println("FilterContainsName: " + FilterContainsName.DESCRIPTION);
        System.out.println("FilterLessThanOscarsCount: " + FilterLessThanOscarsCount.DESCRIPTION);
    }

    @Override
    public void executeScript(String filepath) {
        boolean found = false;
        for (String i: command) {
            if (Objects.equals(i, "executeScript")){
                System.out.println("Файл содержит команду executeScript, что приводит к рекурсии, удалите команду");
                found = true;
                break;
            }
        }
        if (found){
            return;
        }
        try ( BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line = reader.readLine()) != null){

                executeCommand(line);
            }
        } catch (IOException | WrongCommandException | WrongArgumentsLengthException | WrongArgumentException |
                 InputInterruptionException | MovieNotFoundException e){
            System.err.println(ConsoleColor.PURPLE.getCode() + "Ошибка чтения файла: " + e.getMessage());
        }

    }
}
