package View;

import Model.Student;
import Model.StudentBase;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

import static Controller.ClassOfConst.*;

public class ModelTable extends AbstractTableModel {

    private static final int columnCount = 4;
    private List<Student> tableData;

    public ModelTable()
    {
        tableData = new ArrayList<>();
    }

    public String getColumnName(int columnIndex)
    {
        switch(columnIndex)
        {
            case FIO: return "ФИО студента";
            case BIRTHDAY: return "Дата рождения";
            case RECEIPT: return "Дата поступления в вуз";
            case EXPIRATION: return "Дата окончания вуза";
        }
        return "";
    }

    public int getRowCount()
    {
        return tableData.size();
    }

    public int getColumnCount()
    {
        return columnCount;
    }

    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Student rows = tableData.get(rowIndex);
        return rows.getValue(columnIndex);
    }

    public void addDate(Student row)
    {
        tableData.add(row);
        fireTableDataChanged();
    }

    public void addStudent(StudentBase base, int nowNumberStr, int numberRecord)
    {
        deleteAllStudent();

        int begin = (nowNumberStr - 1)*numberRecord;
        int end;
        if(base.size() >= begin+numberRecord) {
            end = begin+numberRecord;
        }
        else {
            end = ((base.size()%numberRecord) + begin);
        }
        for (int i = begin; i < end; i++) {
            addDate(base.get(i));
        }
        fireTableDataChanged();
    }

    public void deleteAllStudent()
    {
        tableData.clear();
        fireTableDataChanged();
    }
}
