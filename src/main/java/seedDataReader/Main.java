package seedDataReader; /**
 * Created by rhaveson on 5/24/2017.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


// import net.rithms.riot.api.endpoints.match.dto.Match;
// import net.rithms.riot.api.endpoints.match.dto.MatchList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Main tester = new Main();
        try {

            List<Student> myStudentList = new ArrayList<Student>();

            Student student1 = new Student();
            student1.setAge(45);
            student1.setName("Ryan");

            Student student2 = new Student();
            student2.setAge(50);
            student2.setName("Older Ryan");

            Student student3 = new Student();
            student3.setAge(2);
            student3.setName("Little Baby");

            myStudentList.add(student1);
            myStudentList.add(student2);
            myStudentList.add(student3);

            System.out.println(myStudentList);

            tester.writeJSONList(myStudentList);

            List<Student> myReadStudentList = tester.readJSONList();
            System.out.println(myReadStudentList);

            MatchList matchList = tester.readMatches();

            if( null != matchList) {
                System.out.printf("totalGames = %d", matchList.matches.size());
                Match m = matchList.matches.get(0);
                System.out.println(m);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeJSON(Student student) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("student.json");
        writer.write(gson.toJson(student));
        writer.close();
    }

    private Student readJSON() throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("student.json"));
        Student student = gson.fromJson(bufferedReader, Student.class);
        return student;
    }


    private void writeJSONList(List<Student> studentList) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("studentList.json");
        writer.write(gson.toJson(studentList));
        writer.close();
    }

    private List<Student> readJSONList() throws FileNotFoundException {
        List<Student> studentList;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("studentList.json"));
        studentList = gson.fromJson(bufferedReader, ArrayList.class);
        return studentList;
    }

    private MatchList readMatches() throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("C:\\users\\rhaveson\\seed-data\\matches1.json"));

        MatchList matches = null;


        matches = gson.fromJson(bufferedReader, MatchList.class);
/*
        try {
            matches = gson.fromJson(bufferedReader, MatchList.class);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */
        return matches;
    }
}

        /*

        String jsonString = "{\"name\":\"Ryan\", \"age\":45}";

        System.out.println(jsonString);

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        Student student = gson.fromJson(jsonString, Student.class);
        System.out.println(student);

        jsonString = gson.toJson(student);
        System.out.println(jsonString);
        */


