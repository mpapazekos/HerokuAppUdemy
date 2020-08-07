package com.herokuapp.theinternet.qa.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import org.testng.annotations.DataProvider;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class CsvDataProvider
{
    @DataProvider(name ="csvReader")
    public static Iterator<Object[]> getDataByCsvFormatDefault(Method _callingMethod)
    {
        String _filePath =  System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "test_data"
                + File.separator + _callingMethod.getDeclaringClass().getSimpleName()
                + File.separator + _callingMethod.getName() + ".csv";

        List<Object[]> _dataHolder = new ArrayList<Object[]>();

        try
        {
            Reader _input = new FileReader(_filePath);
            Iterable<CSVRecord> _csvRecords = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(_input);

            for (CSVRecord _currentRecord : _csvRecords)
            {
                Map<String,String> _mappedRecord = _currentRecord.toMap();

                _dataHolder.add(new Object[]{_mappedRecord});
            }
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException("[ERROR] File " + _filePath + " was not found.\n" + Arrays.toString(e.getStackTrace()));
        }
        catch (IOException e)
        {
            throw new RuntimeException("[ERROR] Could not read " + _filePath + " file.\n" + Arrays.toString(e.getStackTrace()));
        }

        return _dataHolder.iterator();
    }
}
