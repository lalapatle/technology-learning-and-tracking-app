package com.casestudy.tlta.boundry;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.casestudy.tlta.dao.UserActivityDaoImpl;
import com.casestudy.tlta.entity.UserActivity;
import com.casestudy.tlta.exception.ActivityException;
@RunWith(MockitoJUnitRunner.class)

class UserActivityBoundryImplTest {
	@InjectMocks
	private UserActivityBoundryImpl userImpl;

	@Mock
	private UserActivityDaoImpl userDaoImpl;
	

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testUploadCerificate() throws ActivityException {
		UserActivity user = new UserActivity();
		if(userImpl != null) {
			if(user.getStatus().equalsIgnoreCase("Completed")) {
				userImpl.uploadCerificate(user, "C:/");
			}
			verify(userDaoImpl, times(1)).uploadCerificate(user, "C:/");
		}
	}

	@Test
	void testUpdateStatus() throws ActivityException {
		UserActivity user = new UserActivity();
		if(userImpl != null) {
			if(user.getUserActivityId() != null) {
				user.setStatus("Completed");
			}

			userImpl.updateStatus(user, "Completed");
			verify(userDaoImpl, times(1)).updateStatus(user, "Completed");
		}
	}

}
