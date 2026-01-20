package dev.ragul.jps.todo;

public record Todo(
        Integer userId,
        Integer id,
        String title,
        Boolean Completed
) {
}
