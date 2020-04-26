package com.mybatis.test;

import com.mybatis.dao.*;
import com.mybatis.domain.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class mybatisTest {
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
    public void testFindAticlesByPage(){
        List<aticle> aticles = aticleDao.findAticlesByPage(0);
        for (aticle aticle : aticles){
            System.out.println(aticle);
        }
    }
    @Test
    public void testFindTotal(){
        int total = aticleDao.findTotal();
        System.out.println(total);
    }
    @Test
    public void testFindReacommendAticles(){
        List<aticle> aticles = aticleDao.findReacommendAticles();
        for (aticle aticle : aticles){
            System.out.println(aticle);
        }
    }
    @Test
    public void testFindAticlesByTag(){
        List<aticle> aticles = aticleDao.findAticlesByTag("vue");
        for (aticle aticle : aticles){
            System.out.println(aticle);
        }
    }
    @Test
    public void testFindBlogByUid(){
        blog blog = blogDao.findBlogByUid("A-001");
        System.out.println(blog);
    }
    @Test
    public void testFindBlogerByName(){
        bloger bloger = blogerDao.findBlogerByName("MengxiQ");
        System.out.println(bloger);
    }

    @Test
    public void testFindSubfieldListByUid(){
        List<fieldList> list = fieldLsitDao.findSubfieldListByUid("A-001");
        for (fieldList item : list){
            System.out.println(item);
        }
    }

    @Test
    public void testFindTagBySubfield(){
        List<tag> tags= tagDao.findTagBySubfield("VUE CLI");
        for (tag item : tags){
            System.out.println(item);
        }
    }
}
