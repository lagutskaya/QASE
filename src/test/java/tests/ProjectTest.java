package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProjectTest extends BaseTest {

    @Test(testName = "Создание проекта")
    public void checkCreateProject() {
        loginPage.openPage()
                .login(user, password);
        projectsPage.waitTillOpened()
                .createNewProject("TEST",
                        "QA30",
                        "Description for QASE project");
        assertTrue(projectsPage.getCreatedProjectName("TEST"), "Project isn't created");

    }

    @Test(testName = "Удаление проекта")
    public void checkDeleteProject() {
        loginPage.openPage()
                .login("polinalagutskaya@gmail.com", "TestQaseUser1");
        projectsPage.waitTillOpened()
                .deleteProject("TEST");
    }
}

