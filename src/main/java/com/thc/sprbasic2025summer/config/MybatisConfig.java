package com.thc.sprbasic2025summer.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages={"com.thc.sprbasic2025summer.mapper"}, sqlSessionFactoryRef="sqlSessionFactory")
//베이스 페키지는 내 자바 메퍼 파일의 위치를 설명해주는 것 입니다!
public class MybatisConfig {
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("com.thc.sprbasic2025summer.dto"); //dto 있는 패키지 주소 적는 곳!!!
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources("classpath:/mapper/*.xml"));
		// 자바 메퍼 파일이랑 연결될 xml 파일의 위치를 알려주는 코드!
		return sqlSessionFactoryBean.getObject();
	}
}