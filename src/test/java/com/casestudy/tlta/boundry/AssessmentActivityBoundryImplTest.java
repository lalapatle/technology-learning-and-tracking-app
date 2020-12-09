package com.casestudy.tlta.boundry;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.casestudy.tlta.dao.AssessmentActivityDaoImpl;
import com.casestudy.tlta.entity.Assessment;
import com.casestudy.tlta.exception.AssesmentException;

@RunWith(MockitoJUnitRunner.class)

class AssessmentActivityBoundryImplTest {
	@InjectMocks
	private AssessmentActivityBoundryImpl assessmentImpl;

	@Mock
	private AssessmentActivityDaoImpl assessmentDao;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddAssessmentActivity() throws ParseException, AssesmentException {
		Assessment assess = new Assessment();
		String date = "2020-05-20";
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		assess.setId(1);
		assess.setAssesment_name("Java Module 1");
		assess.setAssesment_type("MCQ");
		assess.setAssesment_release_date(date1);
		assess.setAssesment_time_duration(02.30);
		if( assessmentImpl != null) {
			assessmentImpl.addAssessmentActivity(assess);
			verify(assessmentDao, times(1)).addAssessmentActivity(assess);
		}
	}


	@Test
	void testSearchAssessmentActivityById() throws AssesmentException {
		Assessment assess = new Assessment();
		if(assessmentImpl!= null) {
			if( assess.getId() != null) {
				assess.setId(2);
			}
			assessmentImpl.searchAssessmentActivityById(2);
			verify(assessmentDao, times(1)).searchAssessmentActivityById(2);
		}
	}

	@Test
	void testDeleteAssessmentActivity() throws AssesmentException {
		Assessment assess = new Assessment();
		if(assessmentImpl != null) {
			if(assess.getId() != null) {
				assess.setId(2);
			}
			assessmentImpl.deleteAssessmentActivity(2);
			verify(assessmentDao, times(1)).deleteAssessmentActivity(2);
		}
	}

	@Test
	void testGetAllAssessmentActivity() throws AssesmentException {

		Assessment assess = new Assessment();
		if(assessmentImpl != null) {
			if(assess.getId() != null) {
				assessmentImpl.getAllAssessmentActivity();
				verify(assessmentDao, times(1)).getAllAssessmentActivity();
			}
		}
	}

	@Test
	void testUpdateAssessmentActivity() throws AssesmentException {
		Assessment assess = new Assessment();
		if(assessmentImpl != null) {
			if(assess.getId()!= null) {
				assess.setAssesment_name("Coding");
			}

			assessmentImpl.updateAssessmentActivity(assess);
			verify(assessmentDao, times(1)).updateAssessmentActivity(assess);
		}
	}

}