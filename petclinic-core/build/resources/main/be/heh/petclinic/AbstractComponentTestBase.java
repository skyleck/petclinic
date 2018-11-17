package be.heh.petclinic;

import be.heh.petclinic.component.owner.OwnerComponent;
import be.heh.petclinic.component.pet.PetComponent;
import be.heh.petclinic.component.vet.VetComponent;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.io.File;
import java.io.FilenameFilter;

public abstract class AbstractComponentTestBase {

    protected static ApplicationContext applicationContext;

    @BeforeAll
    public static void loadApplicationContext(){
        applicationContext = new ClassPathXmlApplicationContext("be/heh/petclinic/component/applicationContext.xml");

        initMySql();

    }

    protected static JdbcTemplate getJdbcTemplate() {
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        return new JdbcTemplate(dataSource);
    }

    private static void initMySql(){
        System.out.println("ici");
        DataSource dataSource = (DataSource)applicationContext.getBean("dataSource");

        File schemaDirectory = new File("src/be/heh/petclinic/sql/");
        File[] sqlFiles = schemaDirectory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".sql");
            }
        });
        if (sqlFiles != null) {
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
            for (File sqlFile : sqlFiles) {
                System.out.println(sqlFile);
                Resource resource = new FileSystemResource(sqlFile);
                populator.addScript(resource);
                DatabasePopulatorUtils.execute(populator, dataSource);
            }
        }
    }

    protected static VetComponent getVetComponent(){
        return (VetComponent)applicationContext.getBean("vetComponent");
    }

    protected static OwnerComponent getOwnerComponent(){
        return (OwnerComponent)applicationContext.getBean("ownerComponent");
    }

    protected static PetComponent getPetComponent(){
        return (PetComponent)applicationContext.getBean("petComponent");
    }
}