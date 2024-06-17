package com.example.kiemtra.connect;

import com.example.kiemtra.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=java4;Encrypt=True;TrustServerCertificate=True");
        properties.put(Environment.USER, "SA");
        properties.put(Environment.PASS, "Password.1");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(DanhMuc.class); // khai báo class  kết nối đến csdl
        conf.addAnnotatedClass(Sizes.class); // khai báo class  kết nối đến csdl
        conf.addAnnotatedClass(mausacc.class); // khai báo class  kết nối đến csdl
        conf.addAnnotatedClass(KhachHang.class); // khai báo class  kết nối đến csdl
        conf.addAnnotatedClass(SanPham.class); // khai báo class  kết nối đến csdl
        conf.addAnnotatedClass(ChiTietSanPham.class); // khai báo class  kết nối đến csdl
        conf.addAnnotatedClass(hoadon.class); // khai báo class  kết nối đến csdl
        conf.addAnnotatedClass(hdct.class); // khai báo class  kết nối đến csdl
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }


    public static void main(String[] args) {
        getFACTORY();
    }
}
