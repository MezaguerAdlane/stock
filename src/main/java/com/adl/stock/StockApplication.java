package com.adl.stock;

import com.adl.stock.Entity.DetailEntre;
import com.adl.stock.Entity.Entre;
import com.adl.stock.dao.EntreDetailRepo;
import com.adl.stock.dao.EntreRepo;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class StockApplication implements CommandLineRunner {
    @Autowired
    public EntreRepo entreRepo;
    @Autowired
    public EntreDetailRepo entreDetailRepo;

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200")); // Provide list of origins if you want multiple origins
        config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
        config.setAllowCredentials(true);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Override
    public void run(String... args) throws Exception {
        Random rnd = new Random();
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        LocalDate now = LocalDate.now();
        Date d = df.parse(now.toString());
        System.out.print(d);
        Entre e = new Entre();
        e.setDateIn(d);
        e.setFactur(RandomString.make(10));
        entreRepo.save(e);
        for (int i = 1; i < rnd.nextInt(8); i++) {
            DetailEntre de = new DetailEntre();
            de.setPuHt(rnd.nextFloat());
            de.setEntre(e);
            entreDetailRepo.save(de);

        }
    }
}
