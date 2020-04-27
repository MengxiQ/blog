package com.servies.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybatis.dao.*;
import com.mybatis.domain.*;
import com.servies.domain.homeData;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class home extends javax.servlet.http.HttpServlet {
    private SqlSession session;
    private IaticleDao aticleDao;
    private IblogDao blogDao;
    private IblogerDao blogerDao;
    private IfieldLsitDao fieldLsitDao;
    private ItagDao tagDao;
    private InputStream in;

    private String data;

    public void init() throws ServletException
    {
        //1.读取配置文件
        try {
            in = Resources.getResourceAsStream("mysqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

        ObjectMapper mapper = new ObjectMapper();
        // 添加功能，让时间格式更具有可读性
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(dateFormat);

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

        homeData homedata = new homeData();

        homedata.setBlog(blog);
        homedata.setBloger(bloger);
        homedata.setFieldList(fieldList);
        homedata.setRecommend(recommend);
        homedata.setAllTag(allTag);
        homedata.setAticles(aticles);

        data = mapper.writeValueAsString(homedata);



    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //设置请求头，让前端可以访问资源
        /* 允许跨域的主机地址 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        response.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        response.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        response.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        response.setHeader("Access-Control-Allow-Credentials", "false");


        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/javascript;charset=UTF-8");


        //
        PrintWriter out = response.getWriter();
        out.println(data);
    }
    public void destroy(){
        //      注意更新操作要提交事务。
        session.commit();
        //6.释放资源
        session.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
