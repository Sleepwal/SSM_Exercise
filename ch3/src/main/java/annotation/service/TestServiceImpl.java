package annotation.service;

import annotation.dao.TestDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class TestServiceImpl implements TestService {
    @Resource(name="testDaoImpl")
    private TestDao testDao;

    @Override
    public void save() {
        testDao.save();
        System.out.println("testService save!");
    }
}
