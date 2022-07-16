package com.mytheresa.assertions;

import org.assertj.core.api.Assertions;

public class ProfilePageAssertion {

    public static void verifyMyOverview(boolean isDisplayed){
        Assertions.assertThat(isDisplayed).isTrue();
    }
}
