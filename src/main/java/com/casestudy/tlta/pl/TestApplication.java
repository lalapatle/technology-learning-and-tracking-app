package com.casestudy.tlta.pl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.casestudy.tlta.boundry.AssessmentActivityBoundry;
import com.casestudy.tlta.boundry.AssessmentActivityBoundryImpl;
import com.casestudy.tlta.boundry.LearningActivityBoundry;
import com.casestudy.tlta.boundry.LearningActivityBoundryImpl;
import com.casestudy.tlta.boundry.RegisterUserBoundary;
import com.casestudy.tlta.boundry.RegisterUserBoundaryImpl;
import com.casestudy.tlta.entity.Assessment;
import com.casestudy.tlta.entity.LearningActivity;
import com.casestudy.tlta.entity.RegisterUser;
import com.casestudy.tlta.entity.Role;
import com.casestudy.tlta.exception.ActivityException;
import com.casestudy.tlta.exception.AssesmentException;
import com.casestudy.tlta.exception.LoginException;

public class TestApplication {
	private static Scanner scanner = new Scanner(System.in);
	private static RegisterUserBoundary loginBoundry = new RegisterUserBoundaryImpl();
	private static LearningActivityBoundry learningActivityBoundry = new LearningActivityBoundryImpl();
	private static AssessmentActivityBoundry assessmentActivivtyBoundry = new AssessmentActivityBoundryImpl();

	public static void main(String[] args) throws NumberFormatException, LoginException {

		while (true) {
			System.out.println(
					"Enter 1.RegisterUser() 2.Create(Admin/Moderator/User/Activity/Assessment/) 3.Update(Admin/Moderator/User) 4. Delete(Admin/Moderator/User) 5. Search");
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
						login.setRole(Role.ADMIN);
						addPerson(login);
						System.out.println("New ADMIN added successfully");

						break;
					case 2:
						login = new RegisterUser();
						login.setRole(Role.USER);
						addPerson(login);
						System.out.println("New USER added successfully");

						break;
					case 3:
						login = new RegisterUser();
						login.setRole(Role.USER);
						addPerson(login);
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
				case 3: {
					System.out.println("Update details of :  1. Admin 2. Moderator 3. User ");
					int choice = Integer.parseInt(scanner.nextLine());
					switch (choice) {
					case 1:
						System.out.println("Update 1. Password 2. First Name 3. Last Name");
						choice = Integer.parseInt(scanner.nextLine());
						switch (choice) {
						case 1:
							login = new RegisterUser();
							updatePassword(login);
							System.out.println("Password changed successfully");
							break;
						case 2:
							login = new RegisterUser();
							updateFirstName(login);
							System.out.println("First name changed successfully");
							break;
						case 3:
							login = new RegisterUser();
							updateLastName(login);
							System.out.println("Last name changed successfully");
							break;
						default:
							System.out.println("Invalid option");
							break;
						}
					case 2:
						System.out.println("Update 1. Password 2. First Name 3. Last Name");
						choice = Integer.parseInt(scanner.nextLine());
						switch (choice) {
						case 1:
							login = new RegisterUser();
							updatePassword(login);
							System.out.println("Password changed successfully");
							break;
						case 2:
							login = new RegisterUser();
							updateFirstName(login);
							System.out.println("First name changed successfully");
							break;
						case 3:
							login = new RegisterUser();
							updateLastName(login);
							System.out.println("Last name changed successfully");
							break;
						default:
							System.out.println("Invalid option");
							break;
						}
					case 3:
						System.out.println("Update 1. Password 2. First Name 3. Last Name");
						choice = Integer.parseInt(scanner.nextLine());
						switch (choice) {
						case 1:
							login = new RegisterUser();
							updatePassword(login);
							System.out.println("Password changed successfully");
							break;
						case 2:
							login = new RegisterUser();
							updateFirstName(login);
							System.out.println("First name changed successfully");
							break;
						case 3:
							login = new RegisterUser();
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
					System.out.println("Delete 1. Admin 2.Moderator 3. User");
					int choice = Integer.parseInt(scanner.nextLine());
					Integer id = 0;
					switch (choice) {
					case 1:
						System.out.println("Enter id to be deleted");
						id = deleteUser(Integer.parseInt(scanner.nextLine()));
						System.out.println("Admin deleted successfully.");
						break;
					case 2:
						System.out.println("Enter id to be deleted");
						id = deleteUser(Integer.parseInt(scanner.nextLine()));
						System.out.println("Moderator deleted successfully.");
						break;
					case 3:
						System.out.println("Enter id to be deleted");
						id = deleteUser(Integer.parseInt(scanner.nextLine()));
						System.out.println("User deleted successfully.");
						break;
					case 4:

						System.out.println("Enter id to be deleted");
						id = deleteActivivty(Integer.parseInt(scanner.nextLine()));
						System.out.println("Activity deleted successfully.");
						break;
					case 5:

						System.out.println("Enter id to be deleted");
						id = deleteAssessment(Integer.parseInt(scanner.nextLine()));
						System.out.println("Assessment deleted successfully.");
						break;
					default:
						System.out.println("Invalid option");
						break;
					}
				}
					break;
				case 5: {
					System.out.println("Search by id : 1. Admin 2. Moderator 3. User");
					int choice = Integer.parseInt(scanner.nextLine());
					switch (choice) {
					case 1:
						System.out.println("Enter the admin id : ");
						Integer adminId = scanner.nextInt();
						login = getUserById(adminId);
						System.out.println("Admin found." + login);
						break;
					case 2:
						System.out.println("Enter the moderator id : ");
						Integer ModeratorId = scanner.nextInt();
						login = getUserById(ModeratorId);

						System.out.println("Moderator found." + login);
						break;
					case 3:
						System.out.println("Enter the user id : ");
						Integer userId = scanner.nextInt();
						login = getUserById(userId);

						System.out.println("User found." + login);
						break;
					case 4:
						System.out.println("Enter the activity id : ");
						Integer activivtyId = scanner.nextInt();
						LearningActivity xx = getActivityById(activivtyId);
						System.out.println("Activity found.");

						break;
					case 5:
						System.out.println("Enter the assessment id : ");
						Integer assessmentId = scanner.nextInt();
						Assessment xy = getAssessmentById(assessmentId);
						System.out.println("Assessment found.");
						break;
					default:
						System.out.println("Invalid option");
						break;
					}
				}

					break;
				default:
					System.out.println("Invalid option");
					break;

				}

			} catch (AssesmentException e) {
				e.printStackTrace();
			} catch (ActivityException e1) {
				e1.printStackTrace();
			} catch (ParseException e2) {

			}

			System.out.println("Enter y to continue..");
			String ch = scanner.nextLine();
			if (!ch.equalsIgnoreCase("y")) {
				break;
			}

		}

	}

	private static RegisterUser getUserById(Integer userId) throws LoginException {
		
		// TODO Auto-generated method stub
		return loginBoundry.getUserById(userId);

	}

	private static void addPerson(RegisterUser login) throws LoginException {
		// TODO Auto-generated method stub
		System.out.println("Enter First name");
		login.setFirstName(scanner.nextLine());
		System.out.println("Enter Last name");
		login.setLastName(scanner.nextLine());
		System.out.println("Enter EmailID");
		login.setEmailId(scanner.nextLine());
		System.out.println("Enter password");
		login.setPassword(scanner.nextLine());
		loginBoundry.addUser(login);

	}

	private static Integer deleteAssessment(int parseInt) throws AssesmentException {
		// TODO Auto-generated method stub
		return assessmentActivivtyBoundry.deleteAssessmentActivity(parseInt);
	}

	private static Integer deleteActivivty(int parseInt) throws ActivityException {
		// TODO Auto-generated method stub
		return learningActivityBoundry.deleteLearningActivity(parseInt);
	}

	private static Assessment getAssessmentById(Integer userId) throws AssesmentException {
		return assessmentActivivtyBoundry.searchAssessmentActivityById(userId);
		// TODO Auto-generated method stub

	}

	private static LearningActivity getActivityById(Integer userId) throws ActivityException {
		return learningActivityBoundry.searchLearningActivityById(userId);
		// TODO Auto-generated method stub

	}

	private static Integer deleteUser(Integer id) throws LoginException {
		return loginBoundry.deleteUser(id);

	}
	private static void updateLastName(RegisterUser login) throws LoginException {
		System.out.println("Your last name is: "+login.getLastName());
		System.out.println("Enter updated last name: ");
		login.setLastName(scanner.nextLine());
		loginBoundry.updateLastName(login);
	}

	private static void updateFirstName(RegisterUser login) throws LoginException {
		System.out.println("Your first name is: "+login.getFirstName());
		System.out.println("Enter updated first name: ");
		login.setFirstName(scanner.nextLine());
		loginBoundry.updateFirstName(login);

	}

	private static void updatePassword(RegisterUser login) throws LoginException {
		//System.out.println("Your password name is: "+login.getLastName());
		System.out.println("Enter updated password: ");
		login.setPassword(scanner.nextLine());
		loginBoundry.updatePassword(login);

	}
	
	private static void addLearningActivity(LearningActivity learningActivity) throws ActivityException {
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
		String strDate = scanner.nextLine();
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		assessment.setAssesment_release_date(date1);
		System.out.println("Enter assessment time duration in hours:");
		assessment.setAssesment_time_duration(Double.parseDouble(scanner.nextLine()));
		assessmentActivivtyBoundry.addAssessmentActivity(assessment);
	}

}
