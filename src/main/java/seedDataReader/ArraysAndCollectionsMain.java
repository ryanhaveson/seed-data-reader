package seedDataReader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by rhaveson on 5/24/2017.
 */
public class ArraysAndCollectionsMain {
    public static void main(String args[]) {
        System.out.println("Array Sample");
        arraySample();

        System.out.println("ArrayList Sample");
        arrayListSample();

        System.out.println("Generics Sample");
        // genericsSample();

        Shape<Circle> shape = new Shape<Circle>();

        // Create a circle object
        Circle circle = new Circle(5.0);

        // Assign circle to shape

        shape.setShape(circle);
        Gson gson = new Gson();


        // Define a type shapeType of shape of type circle
        Type shapeType = new TypeToken<Shape<Circle>>(){}.getType();

        // Serialize the json as ShapeType

        String jsonString = gson.toJson(shape, shapeType);
        System.out.println(jsonString);
        Shape shape1 = gson.fromJson(jsonString, Shape.class);


        System.out.println(shape1.get().getClass());
        System.out.println(shape1.get().toString());
        System.out.println(shape1.getArea());
        Shape shape2 = gson.fromJson(jsonString, shapeType);
        System.out.println(shape2.get().getClass());
        System.out.println(shape2.get().toString());
        System.out.println(shape2.getArea());
    }

    public static void arraySample() {
        Gson gson = new Gson();
        int[] marks = {100, 92, 77};
        String[] names = {"Ram", "Shyam", "Mohan"};

        // Serializitanio
        System.out.println("{");
        System.out.println("marks:" + gson.toJson(marks) + ", ");
        System.out.println("names:" + gson.toJson(names) + ", ");
        System.out.println("}");

        // De-serialization

        marks = gson.fromJson("[100,90, 85]", int[].class);
        names = gson.fromJson("[\"Ram\", \"Shyam\", \"Mohan\"]", String[].class);

        System.out.println("marks: " + Arrays.toString(marks));
        System.out.println("names: " + Arrays.toString(names));

    }

    public static void arrayListSample() {
        Gson gson = new Gson();
        Collection<Integer> marks = new ArrayList<>();
        marks.add(100); marks.add(90); marks.add(75);

        // Serialization
        System.out.print("{");
        System.out.print("marks:" + gson.toJson(marks));
        System.out.println("}");

        // de-serialization

        Type listType = new TypeToken<Collection<Integer>>(){}.getType();
        marks = gson.fromJson("[100, 930, 33]", listType);
        System.out.println("marks:" + marks);
    }

    public void genericsSample() {
        Shape<Circle> shape = new Shape<Circle>();

        // Create a circle object
        Circle circle = new Circle(5.0);

        // Assign circle to shape

        shape.setShape(circle);
        Gson gson = new Gson();


        // Define a type shapeType of shape of type circle
        Type shapeType = new TypeToken<Shape<Circle>>(){}.getType();

        // Serialize the json as ShapeType

        String jsonString = gson.toJson(shape, shapeType);
        System.out.println(jsonString);
        Shape shape1 = gson.fromJson(jsonString, Shape.class);


        System.out.println(shape1.get().getClass());
        System.out.println(shape1.get().toString());
        System.out.println(shape1.getArea());

        Shape shape2 = gson.fromJson(jsonString, shapeType);
        System.out.println(shape2.get().getClass());
        System.out.println(shape2.get().toString());
        System.out.println(shape2.getArea());
    }

}


class Shape<T> {
    public T shape;

    public void setShape(T shape) {
        this.shape = shape;
    }
    public T get() { return shape; }

    public double getArea() {
        if(shape instanceof Circle) {
            return ((Circle) shape).getArea();
        } else {
            return 0.0;
        }
    }
}

class Circle {
    private double radius;
    public Circle(double radius) { this.radius = radius;}
    public String toString() { return "Circle";}
    public double getRadius() { return radius;}
    public double getArea() { return radius*radius* 3.14;}
}

