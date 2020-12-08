package com.casestudy.tlta.pl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.casestudy.tlta.boundry.AssessmentActivityBoundry;
import com.casestudy.tlta.boundry.AssessmentActivityBoundryImpl;
import com.casestudy.tlta.entity.Assessment;
import com.casestudy.tlta.entity.LearningActivity;
import com.casestudy.tlta.entity.RegisterUser;
import com.casestudy.tlta.exception.ActivityException;
import com.casestudy.tlta.exception.AssesmentException;

public class TestApplication {
	private static Scanner scanner = new Scanner(System.in);
//	private static LoginBoundary loginBoundry = new LoginBoundaryImpl();
//	private static LearningActivityBoundry leaarningActivityBoundry = new LearningActivityBoundryImpl();
	private static AssessmentActivityBoundry assessmentActivivtyBoundry = new AssessmentActivityBoundryImpl();

	public static void main(String[] args) {

		while (true) {
			System.out.println(
					"Enter 1.Login 2.Create(Admin/Moderator/User/Activity/Assessment/) 3.Update(Admin/Moderator/User) 4. Delete(Admin/Moderator/User) 5. Search");
			int option = Integer.parseInt(scanner.nextLine());
			RegisterUser login = null;
			Assessment assessment = null;
			LearningActivity learningActivity = null;
			try {
				switch (option) {
//                case 1: {
//                    System.out.println("Enter your ID and Password:");
//                    Integer id = Integer.parseInt(scanner.nextLine());
//                    String password = scanner.nextLine();
//                }
//
// 
//
//                    break;
				case 2: {
					System.out.println("Create 1. Admin 2. User 3.Moderator 4. Activity 5. Assessment");
					int choice = Integer.parseInt(scanner.nextLine());
					switch (choice) {
					case 1:

						login = new RegisterUser();
//                        addPerson(login);
						System.out.println("New ADMIN added successfully");

						break;
					case 2:
						login = new RegisterUser();
//                        addPerson(login);
						System.out.println("New USER added successfully");

						break;
					case 3:
						login = new RegisterUser();
//                        addPerson(login);
						System.out.println("New MODERATOR added successfully");

						break;
					case 4:
						learningActivity = new LearningActivity();
                        addLearningActivity(learningActivity);
						System.out.println("New LEARNING ACTIVITY added successfully");

						break;
					case 5:
						assessment = new Assessment();
						addAssessment(assessment);
						System.out.println("New ASSESSMENT added successfully");
						break;

					default:
						System.out.println("Invalid option");
						break;

					}
				}
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					System.out.println("Invalid option");
					break;

				}

			} catch ( AssesmentException e) {
				e.printStackTrace();
			}
			catch(ActivityException e1) {
				e1.printStackTrace();
			}
			catch(ParseException e2) {
				
			}

			System.out.println("Enter y to continue..");
			String ch = scanner.nextLine();
			if (!ch.equalsIgnoreCase("y")) {
				break;
			}

		}

	}

	private static void addLearningActivity(LearningActivity learningActivity)throws ActivityException {
		System.out.println("Enter activity name: ");
		learningActivity.setActivity_name(scanner.nextLine());
		System.out.println("Enter activity link :");
		learningActivity.setActivity_link(scanner.nextLine());
		System.out.println("Enter activity level :");
		learningActivity.setActivity_level(scanner.nextLine());
		System.out.println("Enter activity time in hours:");
		learningActivity.setActivity_time(Double.parseDouble(scanner.nextLine()));
		
	}

	private static void addAssessment(Assessment assessment) throws AssesmentException, ParseException {
		System.out.println("Enter assessment name: ");
		assessment.setAssesment_name(scanner.nextLine());
		System.out.println("Enter assessment type : ");
		assessment.setAssesment_type(scanner.nextLine());
		System.out.println("Enter assessment release date(yyyy-mm-dd)::");
		String strDate=scanner.nextLine();	
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(strDate);  
		assessment.setAssesment_release_date(date1);
		System.out.println("Enter assessment time duration in hours:");
		assessment.setAssesment_time_duration(Double.parseDouble(scanner.nextLine()));
		assessmentActivivtyBoundry.addAssessmentActivity(assessment);
	}

}