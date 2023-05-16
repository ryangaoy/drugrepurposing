package cn.ultragy.redrug.module.redrug.config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Properties;

@Configuration
@Slf4j
public class SshConfiguration implements ServletContextInitializer {

    public SshConfiguration() {
        try {
            Properties p = new Properties();
            p.load(getClass().getResourceAsStream("/application.properties"));
            //如果配置文件包含ssh.forward.enabled属性，则使用ssh转发
            if(p.getProperty("ssh.forward.enabled")!=null){
                log.info("ssh forward is opend.");
                log.info("ssh init ……");
                Session session = new JSch().getSession(p.getProperty("ssh.forward.username"),p.getProperty("ssh.forward.host"),Integer.valueOf(p.getProperty("ssh.forward.port")));
                session.setConfig("StrictHostKeyChecking", "no");
                session.setPassword(p.getProperty("ssh.forward.password"));
                session.connect();
                session.setPortForwardingL(p.getProperty("ssh.forward.from_host"),Integer.valueOf(p.getProperty("ssh.forward.from_port")) ,p.getProperty("ssh.forward.to_host") ,Integer.valueOf(p.getProperty("ssh.forward.to_port")) );
            }else{
                log.info("ssh forward is closed.");
            }
        } catch (IOException e) {
            log.error("ssh IOException failed.", e);
        } catch (JSchException e) {
            log.error("ssh JSchException failed.", e);
        } catch (Exception e) {
            log.error("ssh settings is failed. skip!", e);
        }
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:30016");
    }
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "ucapf_b519");
    }
}
