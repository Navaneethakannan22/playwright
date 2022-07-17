package com.mytheresa.assertions;

import org.assertj.core.api.Assertions;

public class ProfilePageAssertion extends BaseAssertions {

    public static void verifyMyOverview(boolean isDisplayed){
        Assertions.assertThat(isDisplayed).isTrue();
    }
}
