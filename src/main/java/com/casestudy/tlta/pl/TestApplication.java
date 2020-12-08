package com.casestudy.tlta.pl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.casestudy.tlta.boundry.AssessmentActivityBoundry;
import com.casestudy.tlta.boundry.AssessmentActivityBoundryImpl;
import com.casestudy.tlta.boundry.LearningActivityBoundry;
import com.casestudy.tlta.boundry.LearningActivityBoundryImpl;
import com.casestudy.tlta.boundry.LoginBoundary;
import com.casestudy.tlta.boundry.LoginBoundaryImpl;
import com.casestudy.tlta.entity.Assessment;
import com.casestudy.tlta.entity.LearningActivity;
import com.casestudy.tlta.entity.Login;
import com.casestudy.tlta.entity.Role;
import com.casestudy.tlta.exception.ActivityException;
import com.casestudy.tlta.exception.AssesmentException;
import com.casestudy.tlta.exception.LoginException;

public class TestApplication {
	private static Scanner scanner = new Scanner(System.in);
	private static LoginBoundary loginBoundry = new LoginBoundaryImpl();
	private static LearningActivityBoundry learningActivityBoundry = new LearningActivityBoundryImpl();
	private static AssessmentActivityBoundry assessmentActivivtyBoundry = new AssessmentActivityBoundryImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {

			System.out.println(
					"Enter 1.Login 2.Create(Admin/Moderator/User/Assessment/) 3.Update(Admin/Moderator/User) 4. Delete(Admin/Moderator/User) 5. Search");
			int option = Integer.parseInt(scanner.nextLine());
			Login login = null;
			Assessment assessment = null;
			LearningActivity learningActivity = null;
			try {
				switch (option) {
				case 1: {
//					System.out.println("Enter your ID and Password:");
//					Integer id = Integer.parseInt(scanner.nextLine());
//					String password = scanner.nextLine();
				}

					break;
				case 2: {
					System.out.println("Create 1. Admin 2. User 3.Moderator 4. Activity 5. Assessment");
					int choice = Integer.parseInt(scanner.nextLine());
					switch (choice) {
					case 1:

						login = new Login();
						addPerson(login, Role.ADMIN);
						System.out.println("New ADMIN added successfully");

						break;
					case 2:
						login = new Login();
						addPerson(login, Role.USER);
						System.out.println("New USER added successfully");

						break;
					case 3:
						login = new Login();
						addPerson(login, Role.MODERATOR);
						System.out.println("New MODERATOR added successfully");

						break;
					case 4:
						assessment = new Assessment();
						addAssessment(assessment);
						System.out.println("New ASSESSMENT added successfully");

						break;
					case 5:
						learningActivity = new LearningActivity();
						addLearningActivity(learningActivity);
						System.out.println("New LEARNING ACTIVITY added successfully");

						break;
					default:
						System.out.println("Invalid option");
						break;

					}
				}
					break;
				case 3: {System.out.println("Update details of :  1. Admin 2. Moderator 3. User");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                case 1:
            	 System.out.println("Update 1. Password 2. First Name 3. Last Name");
                 int chi = Integer.parseInt(scanner.nextLine());
                 switch (chi) {
                 case 1:
                     login = new Login();
                     updatePassword(login);
                     System.out.println("Password changed successfully");
                     break;
                 case 2:
                     login = new Login();
                     updateFirstName(login);
                     System.out.println("First name changed successfully");
                     break;
                 case 3:
                     login = new Login();
                     updateLastName(login);
                     System.out.println("Last name changed successfully");
                     break;
                 default:
                     System.out.println("Invalid option");
                     break;
                 }
                case 2 : 
                	System.out.println("Update 1. Password 2. First Name 3. Last Name");
                    int cho = Integer.parseInt(scanner.nextLine());
                    switch (cho) {
                    case 1:
                        login = new Login();
                        updatePassword(login);
                        System.out.println("Password changed successfully");
                        break;
                    case 2:
                        login = new Login();
                        updateFirstName(login);
                        System.out.println("First name changed successfully");
                        break;
                    case 3:
                        login = new Login();
                        updateLastName(login);
                        System.out.println("Last name changed successfully");
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                    }
                case 3 :
                	System.out.println("Update 1. Password 2. First Name 3. Last Name");
                    int ch = Integer.parseInt(scanner.nextLine());
                    switch (ch) {
                    case 1:
                        login = new Login();
                        updatePassword(login);
                        System.out.println("Password changed successfully");
                        break;
                    case 2:
                        login = new Login();
                        updateFirstName(login);
                        System.out.println("First name changed successfully");
                        break;
                    case 3:
                        login = new Login();
                        updateLastName(login);
                        System.out.println("Last name changed successfully");
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                    }
            }
            

				}
					break;
				case 4: {
					System.out.println("Delete 1. Admin 2. User 3.Moderator");
					int choice = Integer.parseInt(scanner.nextLine());
					switch (choice) {
					case 1:
						login = new Login();
						deleteUser(login, Role.ADMIN);
						System.out.println("Admin deleted successfully.");
						break;
					case 2:
						login = new Login();
						deleteUser(login, Role.USER);
						System.out.println("User deleted successfully.");
						break;
					case 3:
						deleteUser(login, Role.MODERATOR);
						System.out.println("Moderator deleted successfully.");
						break;
					default:
						System.out.println("Invalid option");
						break;
					}
				}
					break;
				case 5: {

				}
					break;
				default:
					System.out.println("Invalid option");
					break;

				}

			} catch (ActivityException | LoginException | AssesmentException e) {
				e.printStackTrace();
			}

			System.out.println("Enter y to continue..");
			String ch = scanner.nextLine();
			if (!ch.equalsIgnoreCase("y")) {
				break;
			}

		}

	}

//	private static void deleteUser(Login login, Role moderator) {
//		// TODO Auto-generated method stub
//
//	}

	private static void updatePassword(Login login) {
		// TODO Auto-generated method stub
		
	}

	private static void updateFirstName(Login login) {
		// TODO Auto-generated method stub
		
	}

	private static void updateLastName(Login login) {
		// TODO Auto-generated method stub
		
	}

	private static void deleteUser(Login login, Role moderator) {
		// TODO Auto-generated method stub
		
	}

	private static void addAssessment(Assessment assessment) throws AssesmentException {
		// TODO Auto-generated method stub
		System.out.println("Enter Assesment name ");
		assessment.setAssesment_name(scanner.nextLine());
		System.out.println("Enter Assessment type: ");
		assessment.setAssesment_type(scanner.nextLine());

		System.out.println("Enter Assessment time duration:");
		// assessment.setAssesment_time_duration(dateFormat.parse(strTime)));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter Release date date(dd/mm/yyyy): ");
		String dt = scanner.nextLine();
		assessment.setAssesment_release_date(LocalDate.parse(dt, formatter));
		assessmentActivivtyBoundry.addAssessmentActivity(assessment);

	}

	private static void addLearningActivity(LearningActivity learningActivity) throws ActivityException {
		// TODO Auto-generated method stub
		System.out.println("Enter Activity name: ");
		learningActivity.setActivity_name(scanner.nextLine());
		System.out.println("Enter Activity link: ");
		learningActivity.setActivity_link(scanner.nextLine());
		System.out.println("Enter Activity level: ");
		learningActivity.setActivity_level(scanner.nextLine());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter Release date date(dd/mm/yyyy): ");
		String dt = scanner.nextLine();
		learningActivity.setActivity_realsedate(LocalDate.parse(dt, formatter));
		System.out.println("Enter Activity time: ");
		// learningActivity.setActivity_time(activity_time);

	//	learningActivity.setAssesment(learningActivity);
		learningActivityBoundry.addLearningActivity(learningActivity);

	}

	private static void addPerson(Login login, Role role) throws LoginException {
		// TODO Auto-generated method stub
		System.out.println("Enter First Name");
		login.setFirstName(scanner.nextLine());
		System.out.println("Enter Last Name");
		login.setLastName(scanner.nextLine());
		System.out.println("Enter EmaiID");
		login.setEmailId(scanner.nextLine());
		System.out.println("Enter Password");

		login.setPassword(scanner.nextLine());
		login.setRole(role);

		loginBoundry.addUser(login);

	}

}
