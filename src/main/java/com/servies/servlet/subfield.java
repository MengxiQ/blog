package com.servies.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybatis.dao.*;
import com.mybatis.domain.*;
import com.servies.domain.subfieldData;
import com.sun.org.apache.xerces.internal.xs.StringList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/subfield")
public class subfield extends HttpServlet {
    private SqlSession session;
    private IaticleDao aticleDao;
    private ItagDao tagDao;
    private IsubfieldDao subfieldDao;
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
        tagDao = session.getMapper(ItagDao.class);
        subfieldDao = session.getMapper(IsubfieldDao.class);

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

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        //拿到请求参数
        String title = req.getParameter("title");
//        创建一个数据对象
        subfieldData subfieldData = new subfieldData();
//        从持久层查询所需的信息
        com.mybatis.domain.subfield intro = subfieldDao.findSubfieldByTitle(title);
        List<String> tags = new ArrayList<String>();
        List<tag> getTags = tagDao.findTagBySubfield(title);
        List<aticle> aticles = aticleDao.findAticlesBySubTitle(title);
//        将查询到tag对象遍历到一个字符串数组中
        for (tag item : getTags){
            tags.add(item.getTagName());
        }

//        将所有数据封装到实体类
        subfieldData.setIntro(intro);
        subfieldData.setTags(tags);
        subfieldData.setAticles(aticles);

//        将数据对象转化成json
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(dateFormat);

        data = mapper.writeValueAsString(subfieldData);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
}
