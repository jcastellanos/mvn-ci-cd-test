package co.jcastellanos.test.config;

import co.jcastellanos.test.util.GlobalConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    /**
     * Perfil de entorno de la aplicacion.
     */
    @Value("${spring.profiles.active}")
    private String activeProfile;
    
    /**
     * Permite habilitar el CORS desde cualquier origen en enterno de desarrollo. 
     * En entorno productivo el CORS debe ser manejado por el API Gateway.
     * @param registry CorsRegistry.
     * @author Juan Carlos Castellanos <jccastellanos@grupoasd.com.co>
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (GlobalConstants.PROFILE_DEV.equals(activeProfile)) {
            registry.addMapping("/**");
        }   
    }
    
}
