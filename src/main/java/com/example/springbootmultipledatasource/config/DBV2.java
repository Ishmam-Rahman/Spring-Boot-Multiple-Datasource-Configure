package com.example.springbootmultipledatasource.config;


import java.util.Objects;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManagerV2",
    transactionManagerRef = "transactionManagerV2",
    basePackages = {"com.example.springbootmultipledatasource.repository.product"}
)
public class DBV2 {

  @Bean(name = "datasourceV2")
  @ConfigurationProperties(prefix = "spring.datasource-v")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "entityManagerV2")
  public LocalContainerEntityManagerFactoryBean entityManagerV2(
      @Qualifier("datasourceV2") DataSource dataSource, EntityManagerFactoryBuilder builder) {
    return builder
        .dataSource(dataSource)
        .packages("com.example.springbootmultipledatasource.entity.product")
        .build();
  }

  @Bean(name = "transactionManagerV2")
  public PlatformTransactionManager transactionManagerV2(
      @Qualifier("entityManagerV2") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
    return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactory.getObject()));
  }
}
