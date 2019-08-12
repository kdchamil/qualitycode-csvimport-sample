package com.chamil.qualitycoder.csvimport.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class CSVDataSourceTest {

    @Test
    void should_ReturnFalse_when_HasNextCalledOnEmptyCSV(){
        InputStream stream = CSVDataSourceTest.class.getResourceAsStream("/empty.csv");
        CSVDataSource source = new CSVDataSource(stream);

        assertThat(source.hasNext(), is(false));
    }

    @Test
    void should_ReturnTrue_when_HasNextCalledOnOneLineCSV(){
        InputStream stream = CSVDataSourceTest.class.getResourceAsStream("/oneline.csv");
        CSVDataSource source = new CSVDataSource(stream);

        assertThat(source.hasNext(), is(true));
    }

    @Test
    void should_ReturnRecord_when_OneLineCSVIsGiven(){
        InputStream stream = CSVDataSourceTest.class.getResourceAsStream("/oneline.csv");
        CSVDataSource source = new CSVDataSource(stream);

        assertThat(source.hasNext(), is(true));
        Record r = source.next();

        assertThat(r.get(0), is("Kamal"));
        assertThat(r.get(1), is("55, Thotupola Road, Welisara, Ragama"));
        assertThat(r.get(2), is("25"));

        assertThat(source.hasNext(), is(false));
    }

    void should_SkipEmptyLine_when_FirstLineEmptyCSVIsGiven(){
        InputStream stream = CSVDataSourceTest.class.getResourceAsStream("/firstlineempty.csv");
        CSVDataSource source = new CSVDataSource(stream);

        assertThat(source.hasNext(), is(true));
        Record r = source.next();

        assertThat(r.get(0), is("Kamal"));
        assertThat(r.get(1), is("55, Thotupola Road, Welisara, Ragama"));
        assertThat(r.get(2), is("25"));

        assertThat(source.hasNext(), is(false));
    }
}
