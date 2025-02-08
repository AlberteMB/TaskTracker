package storage;

import model.Task;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class taskStorage {

    private static final String FILE_NAME = "tasks.json";
    //private static final URI FILE_PATH = Task.class.getClassLoader().getResource(FILE_NAME).toURI();  ;
    private List<Task> tasks = new ArrayList<Task>();

    public void TaskStorage() {
        loadTasks();
    }

    public void loadTasks() {
        try {
            String json = Files.readString(Paths.get(FILE_PATH));
            if (!json.isEmpty()) {
                parseJson(json);
            }
        } catch (IOException e) {
            System.out.println("JSON file not found.");
        }
    }

    private void parseJson(String json) {
        tasks.clear();
        json = json.replace("[", "").replace("]", ""); // Deleting brackets
        String[] taskEntries = json.split("},\\{"); // Splitting tasks

        for (String entry : taskEntries) {
            entry = entry.replace("{", "").replace("}", ""); // Cleaning brackets
            String[] fields = entry.split(","); // Dividing fields

            String id = "", description = "";
            Task.Status status = Task.Status.TODO;
            LocalTime createdAt = LocalTime.now(), updatedAt = LocalTime.now();

            for (String field : fields) {
                String[] keyValue = field.split(":");
                String key = keyValue[0].trim().replace("\"", "");
                String value = keyValue[1].trim().replace("\"", "");

                switch (key) {
                    case "id" -> id = value;
                    case "description" -> description = value;
                    case "status" -> status = Task.Status.valueOf(value);
                    case "createdAt" -> createdAt = LocalTime.parse(value);
                    case "updatedAt" -> updatedAt = LocalTime.parse(value);
                }
            }
            tasks.add(new Task(id, description, status, createdAt, updatedAt));
        }
    }

    private void saveTasks() {
        String json = tasks.stream()
                .map(task -> String.format("{\"id\":\"%s\",\"description\":\"%s\",\"status\":\"%s\",\"createdAt\":\"%s\",\"updatedAt\":\"%s\"}",
                        task.getId(), task.getDescription(), task.getStatus(), task.getCreatedAt(), task.getUpdatedAt()))
                .collect(Collectors.joining(",", "[", "]"));

        try {
            Files.writeString(Paths.get(FILE_PATH), json);
        } catch (IOException e) {
            System.out.println("Error al guardar las tareas.");
        }
    }

//    public void addTask(){
//
//    }
//
//    public boolean updateTask (){
//
//        return false;
//    }
//
//    public boolean deleteTask () {
//
//        return false;
//    }
//
//    public List<Task> getTasksTodo (){
//
//        return ;
//    }
//
//    public List<Task> getTasksInProgress (){
//
//        return ;
//    }
//
//    public List<Task> getTasksDone (){
//
//        return ;
//    }






}



