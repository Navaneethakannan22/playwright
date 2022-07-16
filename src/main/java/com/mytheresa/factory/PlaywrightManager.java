package com.mytheresa.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class PlaywrightManager {

    private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();


    public static Playwright getPlaywright() {
        return playwrightThreadLocal.get();
    }

    public static Browser getBrowser() {
        return browserThreadLocal.get();
    }

    public static BrowserContext getBrowserContext() {
        return browserContextThreadLocal.get();
    }

    public static Page getPage() {
        return pageThreadLocal.get();
    }

    public static void setPlaywright(Playwright playwright) {
        playwrightThreadLocal.set(playwright);

    }

    public static void setBrowser(Browser launch) {
        browserThreadLocal.set(launch);
    }

    public static void setBrowserContext(BrowserContext browserContext) {
        browserContextThreadLocal.set(browserContext);
    }

    public static void setPage(Page page) {
        pageThreadLocal.set(page);
    }

}
