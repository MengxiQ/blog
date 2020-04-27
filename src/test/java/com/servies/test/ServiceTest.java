package com.servies.test;

import com.mybatis.dao.*;
import com.mybatis.domain.*;
import com.servies.domain.homeData;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ServiceTest {
    private SqlSession session;
    private IaticleDao aticleDao;
    private IblogDao blogDao;
    private IblogerDao blogerDao;
    private IfieldLsitDao fieldLsitDao;
    private ItagDao tagDao;
    private InputStream in;

    @Before
    public void init() throws IOException, IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("mysqlMapConfig.xml");
        //2.创建工厂生产sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产sqlSession
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理
        aticleDao = session.getMapper(IaticleDao.class);
        blogDao = session.getMapper(IblogDao.class);
        blogerDao = session.getMapper(IblogerDao.class);
        fieldLsitDao = session.getMapper(IfieldLsitDao.class);
        tagDao = session.getMapper(ItagDao.class);
        //5.使用代理对象执行方法
    }
    @After
    public void destory() throws IOException {
//      注意更新操作要提交事务。
        session.commit();
        //6.释放资源
        session.close();
        in.close();
    }
    @Test
    public void testHome(){
        blog blog = blogDao.findBlogByUid("A-001");
        bloger bloger = blogerDao.findBlogerByName("MengxiQ");
        List<fieldList> fieldList = fieldLsitDao.findSubfieldListByUid("A-001");
        List<aticle> recommend = aticleDao.findReacommendAticles();
        List<aticle> aticles = aticleDao.findAticlesByPage(0);

        List<String> allTag = new ArrayList<>();
        List<tag> tags = tagDao.findTagByUid("A-001");
        for (tag item : tags){
            allTag.add(item.getTagName());
        }

        homeData data = new homeData();

        data.setBlog(blog);
        data.setBloger(bloger);
        data.setRecommend(recommend);
        data.setAllTag(allTag);
        data.setAticles(aticles);
        System.out.println(data);


    }
}
