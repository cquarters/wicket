package wicket.authentication.example;

import wicket.authentication.AuthenticatedWebApplication;
import wicket.authentication.AuthenticatedWebSession;
import wicket.authorization.strategies.role.example.pages.AdminBookmarkablePage;
import wicket.authorization.strategies.role.example.pages.AdminInternalPage;
import wicket.authorization.strategies.role.metadata.MetaDataRoleAuthorizationStrategy;
import wicket.markup.html.WebPage;

/**
 * A role-authorized, authenticated web application in just a few lines of code.
 * 
 * @author Jonathan Locke
 */
public class MyAuthenticatedWebApplication extends AuthenticatedWebApplication
{
	@Override
	protected Class< ? extends AuthenticatedWebSession> getWebSessionClass()
	{
		return MyAuthenticatedWebSession.class;
	}

	@Override
	protected Class< ? extends WebPage> getSignInPageClass()
	{
		return MySignInPage.class;
	}

	/**
	 * @see wicket.Application#getHomePage()
	 */
	@Override
	public Class getHomePage()
	{
		return HomePage.class;
	}
	
	@Override
	protected void init()
	{
		MetaDataRoleAuthorizationStrategy.authorize(AdminBookmarkablePage.class, "ADMIN");
		MetaDataRoleAuthorizationStrategy.authorize(AdminInternalPage.class, "ADMIN");
	}
}
