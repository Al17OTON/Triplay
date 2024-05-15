package com.triplay.config;

import java.sql.Driver;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.lookup.IsolationLevelDataSourceRouter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



@Configuration
//@PropertySource(value={"classpath:/mybatis/database.properties","classpath:/application.properties"})
@EnableTransactionManagement
@ComponentScan("com.triplay")
//@MapperScan("com.triplay.repository")
public class RootConfig {
	
//	@Value("${jdbc.driver}")
//	private String driver;
//	@Value("${jdbc.url}")
//	private String url;
//	@Value("${jdbc.username}")
//	private String userName;
//	@Value("${jdbc.password}")
//	private String password;
	
	//@Autowired
	//private DataSource dataSource;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() throws Exception {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		return dataSource;
	}
	
//	@Bean
//	public DataSource dataSource() throws ClassNotFoundException {
//		
//		SimpleDriverDataSource ds = new SimpleDriverDataSource();
//		ds.setDriverClass((Class<Driver>)Class.forName(driver));
//		ds.setUrl(url);
//		ds.setUsername(userName);
//		ds.setPassword(password);
//		return ds;
//	}
	
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(@Autowired DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//		bean.setDataSource(dataSource);
//		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:/mybatis/mybatisConfig.xml"));
//		return bean.getObject();
//	}
//	@Bean
//	public SqlSessionTemplate sqlSession(@Autowired SqlSessionFactory fac) {
//		SqlSessionTemplate tem = new SqlSessionTemplate(fac);
//		return tem;
//	}
//	
//	@Bean
//	public DataSourceTransactionManager transactionManager(@Autowired DataSource dataSource) {
//		DataSourceTransactionManager man = new DataSourceTransactionManager();
//		man.setDataSource(dataSource);
//		return man;
//	}
	
}
