package bobcat.author;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.cognifide.qa.bb.page.BobcatPageFactory;
import com.google.inject.Inject;
import org.junit.jupiter.api.Test;
import com.cognifide.qa.bb.junit5.guice.Modules;

import com.cognifide.qa.bb.modules.BobcatRunModule;
import bobcat.author.pageobjects.AuthorLoginPage;
import bobcat.author.pageobjects.LoginPage;
import bobcat.author.pageobjects.TitlePage;

@Modules(BobcatRunModule.class)
public class LoginTest {

  //private static final String SEARCH_QUERY = "hello world";
  //private static final String HEADING = "\"Hello, World!\" program";

  @Inject
  private BobcatPageFactory bobcatPageFactory;

  @Inject
  private TitlePage titlePage;

  @Test
  public void loginSearchTest() {
    AuthorLoginPage authorPage = bobcatPageFactory.create("http://localhost:4502/libs/granite/core/content/login.html?resource=%2F&$$login$$=%24%24login%24%24&j_reason=unknown&j_reason_code=unknown", AuthorLoginPage.class);
    authorPage.open().login("admin","admin");
    
    LoginPage homePage = bobcatPageFactory.create("http://localhost:4502/content/etap/loginpage.html", LoginPage.class);
    homePage.open().login("chandreyee","chandreyee");
    assertThat(titlePage.getHeading(), is("This is the English page"));
    System.out.println("Result3");
  }
}
