package tests;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void checkCreateProject() {
        loginPage.openPage()
                .login("polinalagutskaya@gmail.com", "TestQaseUser1");
        projectsPage.waitTillOpened()
                .createNewProject("TEST", "QA30", "Description for QASE project");
    }

    @Test
    public void checkDeleteProject() {
        loginPage.openPage()
                .login("polinalagutskaya@gmail.com", "TestQaseUser1");
        projectsPage.waitTillOpened()
                .deleteProject("TEST");
    }
}

