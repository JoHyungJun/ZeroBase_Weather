package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaMemoRepositoryTest {
    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo memo = new Memo(10, "10 Memo");

        //when
        jpaMemoRepository.save(memo);

        //then
        assertTrue(jpaMemoRepository.findAll().size() > 0);
    }

    @Test
    void findByIdTest() {
        //given
        Memo memo = new Memo(11, "11 Memo");

        //when
        Memo getMemo = jpaMemoRepository.save(memo);

        //then
        Optional<Memo> result = jpaMemoRepository.findById(getMemo.getId());
        assertEquals(memo.getText(), result.get().getText());
    }
}