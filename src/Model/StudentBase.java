package Model;

import java.util.ArrayList;

public class StudentBase {
    public ArrayList<Student> studentArrayList = new ArrayList<>();

    public void add(Student student)
    {
        studentArrayList.add(student);
    }

    public int size()
    {
        return studentArrayList.size();
    }

    public Student get(int i)
    {
        return studentArrayList.get(i);
    }

    public void delete(int j)
    {
        studentArrayList.remove(j);
    }

    public void deleteAllStudent()
    {
        studentArrayList.clear();
    }

}
