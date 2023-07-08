package  ma.sir.vaccination;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.cache.annotation.EnableCaching;


import ma.sir.vaccination.bean.core.*;
import ma.sir.vaccination.service.facade.admin.*;

import ma.sir.vaccination.zynerator.security.common.AuthoritiesConstants;
import ma.sir.vaccination.zynerator.security.bean.User;
import ma.sir.vaccination.zynerator.security.bean.Permission;
import ma.sir.vaccination.zynerator.security.bean.Role;
import ma.sir.vaccination.zynerator.security.service.facade.UserService;
import ma.sir.vaccination.zynerator.security.service.facade.RoleService;


import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableFeignClients("ma.sir.vaccination.required.facade")
public class VaccinationApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(VaccinationApplication.class, args);
    }


    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
    return (args) -> {
        if(false){



    // Role admin

        User userForAdmin = new User("admin");

        Role roleForAdmin = new Role();
        roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
        List<Permission> permissionsForAdmin = new ArrayList<>();
        addPermissionForAdmin(permissionsForAdmin);
        roleForAdmin.setPermissions(permissionsForAdmin);
        if(userForAdmin.getRoles()==null)
            userForAdmin.setRoles(new ArrayList<>());

        userForAdmin.getRoles().add(roleForAdmin);
        userService.save(userForAdmin);
            }
        };
    }




    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }
    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("Dose.edit"));
        permissions.add(new Permission("Dose.list"));
        permissions.add(new Permission("Dose.view"));
        permissions.add(new Permission("Dose.add"));
        permissions.add(new Permission("Dose.delete"));
        permissions.add(new Permission("CategorieRdv.edit"));
        permissions.add(new Permission("CategorieRdv.list"));
        permissions.add(new Permission("CategorieRdv.view"));
        permissions.add(new Permission("CategorieRdv.add"));
        permissions.add(new Permission("CategorieRdv.delete"));
        permissions.add(new Permission("EtatRendezVous.edit"));
        permissions.add(new Permission("EtatRendezVous.list"));
        permissions.add(new Permission("EtatRendezVous.view"));
        permissions.add(new Permission("EtatRendezVous.add"));
        permissions.add(new Permission("EtatRendezVous.delete"));
        permissions.add(new Permission("Medecin.edit"));
        permissions.add(new Permission("Medecin.list"));
        permissions.add(new Permission("Medecin.view"));
        permissions.add(new Permission("Medecin.add"));
        permissions.add(new Permission("Medecin.delete"));
        permissions.add(new Permission("Gender.edit"));
        permissions.add(new Permission("Gender.list"));
        permissions.add(new Permission("Gender.view"));
        permissions.add(new Permission("Gender.add"));
        permissions.add(new Permission("Gender.delete"));
        permissions.add(new Permission("Center.edit"));
        permissions.add(new Permission("Center.list"));
        permissions.add(new Permission("Center.view"));
        permissions.add(new Permission("Center.add"));
        permissions.add(new Permission("Center.delete"));
        permissions.add(new Permission("EffetIndesirable.edit"));
        permissions.add(new Permission("EffetIndesirable.list"));
        permissions.add(new Permission("EffetIndesirable.view"));
        permissions.add(new Permission("EffetIndesirable.add"));
        permissions.add(new Permission("EffetIndesirable.delete"));
        permissions.add(new Permission("RendezVous.edit"));
        permissions.add(new Permission("RendezVous.list"));
        permissions.add(new Permission("RendezVous.view"));
        permissions.add(new Permission("RendezVous.add"));
        permissions.add(new Permission("RendezVous.delete"));
        permissions.add(new Permission("Patient.edit"));
        permissions.add(new Permission("Patient.list"));
        permissions.add(new Permission("Patient.view"));
        permissions.add(new Permission("Patient.add"));
        permissions.add(new Permission("Patient.delete"));
        permissions.add(new Permission("EtatDose.edit"));
        permissions.add(new Permission("EtatDose.list"));
        permissions.add(new Permission("EtatDose.view"));
        permissions.add(new Permission("EtatDose.add"));
        permissions.add(new Permission("EtatDose.delete"));
        permissions.add(new Permission("Quartier.edit"));
        permissions.add(new Permission("Quartier.list"));
        permissions.add(new Permission("Quartier.view"));
        permissions.add(new Permission("Quartier.add"));
        permissions.add(new Permission("Quartier.delete"));
        permissions.add(new Permission("Ville.edit"));
        permissions.add(new Permission("Ville.list"));
        permissions.add(new Permission("Ville.view"));
        permissions.add(new Permission("Ville.add"));
        permissions.add(new Permission("Ville.delete"));
    }

}


