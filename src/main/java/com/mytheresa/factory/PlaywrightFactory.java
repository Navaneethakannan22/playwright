package com.mytheresa.factory;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.mytheresa.utils.PropertyFileReader;


public class PlaywrightFactory {



	public Page initializeBrowser() {

		String browserName = PropertyFileReader.getPropertyValue("browser").trim();
		System.out.println(browserName+" browser is launching...");

		PlaywrightManager.setPlaywright(Playwright.create());

		switch (browserName.toLowerCase()) {
		case "firefox":
			PlaywrightManager.setBrowser(PlaywrightManager.getPlaywright().firefox().launch(new LaunchOptions().setHeadless(false)));
			break;
		case "safari":
			PlaywrightManager.setBrowser(PlaywrightManager.getPlaywright().webkit().launch(new LaunchOptions().setHeadless(false)));
			break;

		default:
			PlaywrightManager.setBrowser(PlaywrightManager.getPlaywright().chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome")));
			break;
		}

		PlaywrightManager.setBrowserContext(PlaywrightManager.getBrowser().newContext());
		PlaywrightManager.setPage(PlaywrightManager.getBrowserContext().newPage());

		String environment = PropertyFileReader.getPropertyValue("env").trim();
		switch (environment.toLowerCase()) {
			case "local":
				PlaywrightManager.getPage().navigate("https://local.mytheresa.com/en-de/men.html");
				break;
			case "qa":
				PlaywrightManager.getPage().navigate("https://test.mytheresa.com/en-de/men.html");
				break;
			case "staging":
				PlaywrightManager.getPage().navigate("https://staging.mytheresa.com/en-de/men.html");
				break;

			default:
				PlaywrightManager.getPage().navigate("https://www.mytheresa.com/en-de/men.html");
				break;
		}
		//public static String url=PlaywrightManager.getPage().url();
		return PlaywrightManager.getPage();

	}

}
