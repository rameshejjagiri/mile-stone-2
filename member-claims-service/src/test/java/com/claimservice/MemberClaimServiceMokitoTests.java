package com.claimservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.claimservice.models.MemberClaims;
import com.claimservice.repositories.MemberClaimsRepo;
import com.claimservice.services.MemberClaimService;

@RunWith(MockitoJUnitRunner.class)
public class MemberClaimServiceMokitoTests {

	@InjectMocks
	MemberClaimService memberClaimsService;

	@Mock
	MemberClaimsRepo memberclaiClaimsRepo;
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testGetClaims() {

		when(memberclaiClaimsRepo.findAll()).thenReturn(Arrays.asList(new MemberClaims(255, "Ramesh", "Ejjagiri",
				"2021-09-01", "2021-09-03", "2000-09-01", "2255", "Apolo", "R-0002")));
		assertEquals(1, memberClaimsService.getClaims().size());

	}

}
