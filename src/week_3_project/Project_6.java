package week_3_project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Project_6 {

    static class Task {
        String description;
        boolean isCompleted;

        Task(String description) {
            this.description = description;
            this.isCompleted = false;
        }

        @Override
        public String toString() {
            return (isCompleted ? "[✔] " : "[ ] ") + description;
        }
    }

    private static final String FILE_NAME = "tasks.txt";
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static DefaultListModel<String> listModel;
    private static JList<String> taskList;

    public static void main(String[] args) {
        loadTasksFromFile();

        JFrame frame = new JFrame("To-Do List Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 480);
        frame.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        updateTaskList();

        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        JTextField taskInput = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton completeButton = new JButton("Mark Completed");
        JButton removeMarkButton = new JButton("Remove Marking");
        JButton deleteButton = new JButton("Delete Task");
        JButton saveButton = new JButton("Save and Exit");

        
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.add(completeButton);
        buttonPanel.add(removeMarkButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);

        
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        
        addButton.addActionListener(e -> {
            String desc = taskInput.getText().trim();
            if (!desc.isEmpty()) {
                tasks.add(new Task(desc));
                taskInput.setText("");
                updateTaskList();
            }
        });

        completeButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                tasks.get(index).isCompleted = true;
                updateTaskList();
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a task to mark as completed.");
            }
        });

        removeMarkButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                tasks.get(index).isCompleted = false;
                updateTaskList();
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a task to remove the completion marking.");
            }
        });

        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                tasks.remove(index);
                updateTaskList();
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a task to delete.");
            }
        });

        saveButton.addActionListener(e -> {
            saveTasksToFile();
            JOptionPane.showMessageDialog(frame, "Tasks saved. Exiting...");
            System.exit(0);
        });

        
        frame.setVisible(true);
    }

    private static void updateTaskList() {
        listModel.clear();
        for (Task task : tasks) {
            listModel.addElement(task.toString());
        }
    }

    private static void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.description + "," + task.isCompleted + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving tasks: " + e.getMessage());
        }
    }

    private static void loadTasksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] taskData = line.split(",");
                Task task = new Task(taskData[0]);
                task.isCompleted = Boolean.parseBoolean(taskData[1]);
                tasks.add(task);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading tasks: " + e.getMessage());
        }
    }
}
