package Model;

import java.sql.Date;

import static Controller.ClassOfConst.*;

public class Student {

    public String surName;
    private String firstName;
    private String middleName;
    private Date dateBirthday;
    private Date dateReceipt;
    private Date dateExpiration;

    public Student()
    {

    }

    public Student(String surName, String firstName, String middleName,
                   Date dateBirthday, Date dateReceipt, Date dateExpiration)
    {
        this.surName = surName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateBirthday = dateBirthday;
        this.dateReceipt = dateReceipt;
        this.dateExpiration = dateExpiration;
    }

    public void setSurName(String surName)
    {
        this.surName = surName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getSurName()
    {
        return surName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setDateBirthday(String str1)
    {
        this.dateBirthday = (Date.valueOf(str1));
    }

    public void setDateReceipt(String str2)
    {
        this.dateReceipt = Date.valueOf(str2);
    }

    public void setDateExpiration(String str3)
    {
        this.dateExpiration = Date.valueOf(str3);
    }

    public Date getDateBirthday()
    {
        return dateBirthday;
    }

    public Date getDateReceipt()
    {
        return dateReceipt;
    }

    public Date getDateExpiration()
    {
        return dateExpiration;
    }

    public  Date sel(int index)
    {
        switch (index)
        {
            case BIRTHDAY: return dateBirthday;
            case RECEIPT: return dateReceipt;
            case EXPIRATION: return dateExpiration;
        }
        return null;
    }

    public Object getValue(int index)
    {
        switch (index)
        {
            case FIO: return surName+" "+firstName+" "+middleName;
            case BIRTHDAY: return dateBirthday;
            case RECEIPT: return dateReceipt;
            case EXPIRATION: return dateExpiration;

        }
        return null;
    }
}

