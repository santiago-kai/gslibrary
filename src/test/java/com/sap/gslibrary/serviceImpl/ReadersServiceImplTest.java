package com.sap.gslibrary.serviceImpl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sap.gslibrary.entity.Reader;
import com.sap.gslibrary.service.ReaderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadersServiceImplTest {
	
	@Autowired
    private ReaderService readersService;

    private String userId1 = "I326864";
    private String name1 = "Santiago";
    private int borrowBooksCount1 = 2;

    private String userId2 = "C505034";
    private String name2 = "Veronica";
    private int borrowBooksCount2 = 1;

    @Before
    public void setUp() throws Exception {
        Reader reader1 = new Reader(userId1, name1, borrowBooksCount1);
        Reader reader2 = new Reader(userId2, name2, borrowBooksCount2);
        readersService.insertReader(reader1);
        readersService.insertReader(reader2);
    }

    @Test
    public void testInsert_and_Find() throws Exception {
        Reader reader = readersService.findByName(name1).get(0);
        assertEquals(userId1, reader.getUserId());
        assertEquals(name1, reader.getName());
        assertEquals(borrowBooksCount1, reader.getBorrowBooksCount());
    }

    @Test
    public void testDeleteById() throws Exception {
        readersService.deleteById(1);
        List<Reader> readers = readersService.findByName(name1);
        for (Reader reader : readers) {
            assertTrue(reader.getId() != 1);
        }
    }

    @Test
    public void testUpdateReaders() throws Exception {
        Reader reader = new Reader("I000219", "Abby", 3);
        reader.setId(2);
        readersService.updateReader(reader);
        Reader newReader = readersService.findByName("Abby").get(0);
        assertEquals("I000219", newReader.getUserId());
        assertEquals("Abby", newReader.getName());
        assertEquals(3, newReader.getBorrowBooksCount());
        assertEquals(2, newReader.getId());
    }
}
