package utils;

import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> dataNegativePassword() {
        List<Object[]> list = new LinkedList<>();
        list.add(new Object[]{"aaaaa@mail.com", "12345"});
        list.add(new Object[]{"aaaaa@mail.com", "12345aaaaa"});
        return list.iterator();
    }
}