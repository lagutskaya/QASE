package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class ProjectsPage {

    private final SelenideElement CREATE_NEW_PROJECT_BUTTON = $(byText("Create new project"));
    private final SelenideElement REMOVE_BUTTON = $("[data-testid=remove]");
    private final SelenideElement DELETE_PROJECT_BUTTON = $x("//span[text()='Delete project']");
    private final SelenideElement PROJECT_NAME_FIELD = $(byId("project-name"));
    private final SelenideElement PROJECT_CODE_FIELD = $(byId("project-code"));
    private final SelenideElement PROJECT_DESCRIPTION_FIELD = $(byId("description-area"));
    private final SelenideElement PROJECT_ACCESS_PUBLIC_BUTTON = $("[value='public']");
    private final SelenideElement CREATE_PROJECT_BUTTON = $(byText("Create project"));

    public ProjectsPage openPage() {
        open("/projects");
        return this;

    }

    public ProjectsPage waitTillOpened() {
        CREATE_NEW_PROJECT_BUTTON.shouldBe(visible);
        return this;
    }

    public ProjectsPage createNewProject(String projectName, String projectCode, String projectDescription) {
        CREATE_NEW_PROJECT_BUTTON.click();
        PROJECT_NAME_FIELD.setValue(projectName);
        PROJECT_CODE_FIELD.setValue(projectCode);
        PROJECT_DESCRIPTION_FIELD.setValue(projectDescription);
        PROJECT_ACCESS_PUBLIC_BUTTON.click();
        CREATE_PROJECT_BUTTON.submit();
        return this;
    }

    public ProjectsPage deleteProject(String project) {
        $(byText(project))
                .ancestor("tr")
                .find("button[aria-label='Open action menu']")
                .click();
        REMOVE_BUTTON.click();
        DELETE_PROJECT_BUTTON.click();
        return this;
    }
}
