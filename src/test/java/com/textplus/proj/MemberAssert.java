package com.textplus.proj;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractAssert;

import com.textplus.proj.domain.Member;

public class MemberAssert extends AbstractAssert<MemberAssert, Member>{

	protected MemberAssert(Member actual) {
		super(actual, MemberAssert.class);
	}

	 static MemberAssert assertThatMember(Member actual) {
	        return new MemberAssert(actual);
	    }

	 MemberAssert hasName(String expectedName) {
	        isNotNull();

	        String actualName = actual.getName();
	        assertThat(actualName)
	                .overridingErrorMessage("Expected name to be <%s> but was <%s>",
	                		expectedName,
	                		actualName
	                )
	                .isEqualTo(expectedName);

	        return this;
	    }

	 MemberAssert hasEmail(String expectedEmail) {
	        isNotNull();

	        String actualEmail = actual.getEmail();
	        assertThat(actualEmail)
	                .overridingErrorMessage("Expected email to be <%s> but was <%s>",
	                		expectedEmail,
	                		actualEmail
	                )
	                .isEqualTo(expectedEmail);

	        return this;
	    }
	 
	 MemberAssert hasPhone(String expectedPhone) {
	        isNotNull();

	        String actualPhone = actual.getPhone();
	        assertThat(actualPhone)
	                .overridingErrorMessage("Expected phone to be <%s> but was <%s>",
	                		expectedPhone,
	                		actualPhone
	                )
	                .isEqualTo(expectedPhone);

	        return this;
	    }
}
