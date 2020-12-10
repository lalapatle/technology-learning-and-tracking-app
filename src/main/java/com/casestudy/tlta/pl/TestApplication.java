package com.casestudy.tlta.pl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.jboss.logging.Logger;

import com.casestudy.tlta.boundry.AssessmentActivityBoundry;
import com.casestudy.tlta.boundry.AssessmentActivityBoundryImpl;
import com.casestudy.tlta.boundry.LearningActivityBoundry;
import com.casestudy.tlta.boundry.LearningActivityBoundryImpl;
import com.casestudy.tlta.boundry.RegisterUserBoundary;
import com.casestudy.tlta.boundry.RegisterUserBoundaryImpl;
import com.casestudy.tlta.boundry.UserActivityBoundry;
import com.casestudy.tlta.boundry.UserActivityBoundryImpl;
import com.casestudy.tlta.entity.Assessment;
import com.casestudy.tlta.entity.LearningActivity;
import com.casestudy.tlta.entity.RegisterUser;
import com.casestudy.tlta.entity.Role;
import com.casestudy.tlta.entity.UserActivity;
import com.casestudy.tlta.exception.ActivityException;
import com.casestudy.tlta.exception.AssesmentException;
import com.casestudy.tlta.exception.RegisterUserException;

public class TestApplication {
	private static Scanner scanner = new Scanner(System.in);
	private static RegisterUserBoundary loginBoundry = new RegisterUserBoundaryImpl();
	private static LearningActivityBoundry learningActivityBoundry = new LearningActivityBoundryImpl();
	private static AssessmentActivityBoundry assessmentActivivtyBoundry = new AssessmentActivityBoundryImpl();
	private static Logger plLogger = Logger.getLogger(TestApplication.class);
	private static UserActivityBoundry userActivityBoundry = new UserActivityBoundryImpl();

	public static void main(String[] args) throws NumberFormatException, RegisterUserException {

		while (true) {
			System.out.println("Enter 1. Login" + "\n2. Create" + "\n3. Update" + "\n4. Delete" + "\n5. Search "
					+ "\n6. View All " + "\n7. User can register to activity " );
			int option = Integer.parseInt(scanner.nextLine());
			RegisterUser login = null;
			Assessment assessment = null;
			LearningActivity learningActivity = null;
			try {
				switch (option) {
				case 1: {
					System.out.println("Enter your ID and Password:");
					Integer id = Integer.parseInt(scanner.nextLine());
					String password = scanner.nextLine();
					RegisterUser logn = checkValid(id, password);
					if (logn != null) {
						plLogger.info("Login successfully");
					} else {
						plLogger.info("Invalid ID or Password");
					}
				}

					break;
				case 2: {
					System.out.println("Create 1. Admin 2. User 3.Moderator 4. Activity 5. Assessment");
					int choice = Integer.parseInt(scanner.nextLine());
					switch (choice) {
					case 1:

						login = new RegisterUser();
						login.setRole(Role.ADMIN);
						addPerson(login);
						plLogger.info("New ADMIN added successfully with id " + login.getId());

						break;
					case 2:
						login = new RegisterUser();
						login.setRole(Role.USER);
						addPerson(login);
						plLogger.info("New USER added successfully with id " + login.getId());

						break;
					case 3:
						login = new RegisterUser();
						login.setRole(Role.USER);
						addPerson(login);
						plLogger.info("New MODERATOR added successfully with id " + login.getId());

						break;
					case 4:
						learningActivity = new LearningActivity();
						int id = addLearningActivity(learningActivity);
						// System.out.println("New LEARNING ACTIVITY added successfully with id: " +
						// id);
						plLogger.info(" learning activity added with id: " + id);
						break;
					case 5:
						assessment = new Assessment();
						int assessmentId = addAssessment(assessment);
						// System.out.println("New ASSESSMENT added successfully with id:
						// "+assessmentId);
						plLogger.info("1 assessment added with id: " + assessmentId);
						break;

					default:
						plLogger.error("Invalid option");
						break;

					}
				}
					break;
				case 3: {
					System.out.println(
							"Update details of :  1. Admin 2. Moderator 3. User 4. Update assessment 5.Update Activity");
					int choice = Integer.parseInt(scanner.nextLine());
					switch (choice) {
					case 1:
						System.out.println("Update 1. Password 2. First Name 3. Last Name");
						choice = Integer.parseInt(scanner.nextLine());
						switch (choice) {
						case 1:
							updatePassword();
							break;
						case 2:
							updateFirstName();
							break;
						case 3:
							updateLastName();
							break;
						default:

							plLogger.error("Invalid option");
							break;
						}
					case 2:
						System.out.println("Update 1. Password 2. First Name 3. Last Name");
						choice = Integer.parseInt(scanner.nextLine());
						switch (choice) {
						case 1:
							updatePassword();
							break;
						case 2:
							updateFirstName();
							break;
						case 3:
							updateLastName();
							break;
						default:
							plLogger.error("Invalid option");
							break;

						}
					case 3: {
						System.out.println("Update 1. Password 2. First Name 3. Last Name");
						choice = Integer.parseInt(scanner.nextLine());
						switch (choice) {
						case 1:
							updatePassword();
							break;
						case 2:
							updateFirstName();
							break;
						case 3:
							updateLastName();
							break;
						default:
							plLogger.error("Invalid option");
							break;

						}
					}
						break;
					case 4:
						System.out.println("Enter assessment id to be updated: ");
						Integer assessmentId = Integer.parseInt(scanner.nextLine());
						assessment = getAssessmentById(assessmentId);
						Assessment updatedAssessment = updateAssessment(assessment);
						System.out.println(updatedAssessment);
						System.out.println("Assessment updated successfully");
						break;
					case 5:
						System.out.println("Enter Learning activity id to be updated:");
						Integer activityId = Integer.parseInt(scanner.nextLine());
						learningActivity = getLearningActivityById(activityId);
						LearningActivity updateLearningActivity = updateLearningActivity(learningActivity);
						System.out.println(updateLearningActivity);
						System.out.println("Assessment updated successfully");
						break;
					default:
						plLogger.error("Invalid Option");
					}
				}
					break;
				case 4: {
					System.out.println(
							"Delete 1. Admin 2.Moderator 3. User 4.Delete Learning Activity 5.Delete assessment");
					int choice = Integer.parseInt(scanner.nextLine());
					Integer id = 0;
					switch (choice) {
					case 1:
						System.out.println("Enter id to be deleted");
						id = deleteUser(Integer.parseInt(scanner.nextLine()));
						plLogger.info("Admin deleted successfully.");
						break;
					case 2:
						System.out.println("Enter id to be deleted");
						id = deleteUser(Integer.parseInt(scanner.nextLine()));
						plLogger.info("Moderator deleted successfully.");
						break;
					case 3:
						System.out.println("Enter id to be deleted");
						id = deleteUser(Integer.parseInt(scanner.nextLine()));
						plLogger.info("User deleted successfully.");
						break;
					case 4:

						System.out.println("Enter id to be deleted");
						id = deleteActivivty(Integer.parseInt(scanner.nextLine()));
						plLogger.info("Activity deleted successfully.");
						break;
					case 5:

						System.out.println("Enter id to be deleted");
						id = deleteAssessment(Integer.parseInt(scanner.nextLine()));
						plLogger.info("Assessment deleted successfully.");
						break;
					default:
						plLogger.error("Invalid option");
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
						Integer adminId = (Integer.parseInt(scanner.nextLine()));
						login = getUserById(adminId);
						plLogger.info("Admin found." + login);
						break;
					case 2:
						System.out.println("Enter the moderator id : ");
						Integer ModeratorId = (Integer.parseInt(scanner.nextLine()));
						login = getUserById(ModeratorId);

						plLogger.info("Moderator found." + login);
						break;
					case 3:
						System.out.println("Enter the user id : ");
						Integer userId = (Integer.parseInt(scanner.nextLine()));
						login = getUserById(userId);

						plLogger.info("User found." + login);
						break;
					case 4:
						System.out.println("Enter the activity id : ");
						Integer activivtyId = (Integer.parseInt(scanner.nextLine()));
						LearningActivity xx = getActivityById(activivtyId);
						plLogger.info("Activity found." + xx);

						break;
					case 5:
						System.out.println("Enter the assessment id : ");
						Integer assessmentId = (Integer.parseInt(scanner.nextLine()));
						Assessment xy = getAssessmentById(assessmentId);
						plLogger.info("Assessment found." + xy);
						break;
					default:
						plLogger.error("Invalid option");
						break;
					}
				}

					break;
				case 6: {
					System.out.println("View All: 1. Registered User 2.Activity 3. Assessment");
					int choice = Integer.parseInt(scanner.nextLine());
					switch (choice) {
					case 1:
						List<RegisterUser> userList = getAllUser();
						userList.stream().forEach(System.out::println);
						break;
					case 2:
						List<LearningActivity> activityList = getAllActivity();
						activityList.stream().forEach(System.out::println);
						break;
					case 3:
						List<Assessment> assessmentList = getAllAssessment();
						assessmentList.stream().forEach(System.out::println);
						break;
					default:
						plLogger.error("Invalid option");
						break;
					}
				}
					break;
				case 7:
					System.out.println("Enter user Id:");
					Integer userId = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter activity id: ");
					Integer activityId = Integer.parseInt(scanner.nextLine());
					UserActivity userActivity = new UserActivity();
					Integer userActivityId = userRegisterToActivity(userActivity, userId, activityId);
					System.out.println("User with id " + userId + " register activity with id: " + userActivityId);
					break;

				default:
					plLogger.error("Invalid option");
					break;

				}

			} catch (RegisterUserException | ActivityException | AssesmentException e) {
				plLogger.error(e.getMessage());
			} catch (ParseException e) {
				plLogger.error(e.getMessage());
			}

			System.out.println("Enter y to continue..");
			String ch = scanner.nextLine();
			if (!ch.equalsIgnoreCase("y")) {
				break;
			}

		}

	}

	private static LearningActivity getLearningActivityById(Integer activityId) throws ActivityException {
		return learningActivityBoundry.searchLearningActivityById(activityId);

	}

	private static Assessment updateAssessment(Assessment assessment) throws AssesmentException, ParseException {
		System.out.println(
				"Enter 1. Update assessment name \n 2. Update assessment type\n 3. Update assessment release date\n 4. update assessment time duration");
		Integer choice2 = Integer.parseInt(scanner.nextLine());
		Assessment updateAssessment = new Assessment();
		switch (choice2) {
		case 1:
			System.out.println("Existing name of assessment is: " + assessment.getAssesment_name());
			System.out.println("Enter new name: ");
			assessment.setAssesment_name(scanner.nextLine());
			updateAssessment = assessmentActivivtyBoundry.updateAssessmentActivity(assessment);
			break;
		case 2:
			System.out.println("Existing type of assessment is: " + assessment.getAssesment_type());
			System.out.println("Enter new type: ");
			assessment.setAssesment_type(scanner.nextLine());
			updateAssessment = assessmentActivivtyBoundry.updateAssessmentActivity(assessment);
			break;

		case 3:
			System.out.println("Existing release date of assessment is: " + assessment.getAssesment_release_date());
			System.out.println("Enter new assessment release date(yyyy-mm-dd)::");
			String strDate = scanner.nextLine();
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			assessment.setAssesment_release_date(date1);
			updateAssessment = assessmentActivivtyBoundry.updateAssessmentActivity(assessment);
			break;
		case 4:
			System.out.println(
					"Existing time duration of assessment is: " + assessment.getAssesment_time_duration() + " hours");
			System.out.println("Enter new type: ");
			assessment.setAssesment_time_duration(Double.parseDouble(scanner.nextLine()));
			updateAssessment = assessmentActivivtyBoundry.updateAssessmentActivity(assessment);
			break;
		default:
			plLogger.error("Invalid option");
			break;
		}
		return updateAssessment;

	}

	private static LearningActivity updateLearningActivity(LearningActivity learningActivity)
			throws ActivityException, ParseException {
		System.out.println(
				"Enter \n1. update activity name \n2.update activity link \n3.update activity level \n4.update time duration \n5.update release date");
		Integer choice = Integer.parseInt(scanner.nextLine());
		LearningActivity updatedActivity = new LearningActivity();
		switch (choice) {
		case 1:
			System.out.println("Existing activity name is: " + learningActivity.getActivity_name());
			System.out.println("Enter new activity name ::");
			String name = scanner.nextLine();
			learningActivity.setActivity_name(name);
			updatedActivity = learningActivityBoundry.updateLearningActivity(learningActivity);
			break;
		case 2:
			System.out.println("Existing activity link is: " + learningActivity.getActivity_link());
			System.out.println("Enter new activity link ::");
			String link = scanner.nextLine();
			learningActivity.setActivity_link(link);
			updatedActivity = learningActivityBoundry.updateLearningActivity(learningActivity);
			break;
		case 3:
			System.out.println("Existing activity level is: " + learningActivity.getActivity_level());
			System.out.println("Enter new activity level ::");
			String level = scanner.nextLine();
			learningActivity.setActivity_level(level);
			updatedActivity = learningActivityBoundry.updateLearningActivity(learningActivity);
			break;
		case 4:
			System.out.println("Existing time duration is: " + learningActivity.getActivity_time() + " hours.");
			System.out.println("Enter new duration in hours ::");
			Double timeDuration = Double.parseDouble(scanner.nextLine());
			learningActivity.setActivity_time(timeDuration);
			updatedActivity = learningActivityBoundry.updateLearningActivity(learningActivity);
			break;
		case 5:
			System.out.println(
					"Existing release date of learning activity is: " + learningActivity.getActivity_realsedate());
			System.out.println("Enter new assessment release date(yyyy-mm-dd)::");
			String strDate = scanner.nextLine();
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			learningActivity.setActivity_realsedate(date1);
			updatedActivity = learningActivityBoundry.updateLearningActivity(learningActivity);
		default:
			plLogger.error("Invalid option");
			break;
		}
		return updatedActivity;
	}

	private static Integer userRegisterToActivity(UserActivity userActivity, Integer userId, Integer activityId)
			throws ActivityException {
		return userActivityBoundry.userRegisterToLearningActivity(userActivity, userId, activityId);
	}

	
	private static List<Assessment> getAllAssessment() throws AssesmentException {
		// TODO Auto-generated method stub
		return assessmentActivivtyBoundry.getAllAssessmentActivity();
	}

	private static List<LearningActivity> getAllActivity() throws ActivityException {
		// TODO Auto-generated method stub
		return learningActivityBoundry.getAllLearningActivity();
	}

	private static List<RegisterUser> getAllUser() throws RegisterUserException {
		// TODO Auto-generated method stub
		return loginBoundry.getAllRegisteredUser();
	}

	private static RegisterUser checkValid(Integer id, String password) throws RegisterUserException {
		// TODO Auto-generated method stub
		RegisterUser obj = loginBoundry.getUserById(id);
		if (obj == null) {
			return null;
		} else {
			if (obj.getPassword().equals(password))
				return obj;
		}

		return null;
	}

	private static RegisterUser getUserById(Integer userId) throws RegisterUserException {

		// TODO Auto-generated method stub
		return loginBoundry.getUserById(userId);

	}

	private static void addPerson(RegisterUser login) throws RegisterUserException {
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

	private static Integer deleteUser(Integer id) throws RegisterUserException {
		return loginBoundry.deleteUser(id);

	}

	private static void updateLastName() throws RegisterUserException {
		System.out.println("Your ID to update Last name is: ");
		Integer id = Integer.parseInt(scanner.nextLine());
		RegisterUser obj = loginBoundry.getUserById(id);
		if (obj != null) {
			System.out.println("Your last name is: " + obj.getLastName());
			plLogger.info("Enter last name that to be your updated last name");
			obj.setFirstName(scanner.nextLine());
			loginBoundry.updateLastName(obj);
		} else {
			plLogger.error("Id doesn't exists.");
		}
	}

	private static void updateFirstName() throws RegisterUserException {
		System.out.println("Your ID to update First name is: ");
		Integer id = Integer.parseInt(scanner.nextLine());
		RegisterUser obj = loginBoundry.getUserById(id);
		if (obj != null) {
			System.out.println("Your first name is: " + obj.getFirstName());
			plLogger.info("Enter name that to be your updated name");
			obj.setFirstName(scanner.nextLine());
			loginBoundry.updateFirstName(obj);
		} else {
			plLogger.error("Id doesn't exists.");
		}

	}

	private static void updatePassword() throws RegisterUserException {
		System.out.println("Your ID to update password is: ");
		Integer id = Integer.parseInt(scanner.nextLine());
		RegisterUser obj = loginBoundry.getUserById(id);
		if (obj != null) {
			System.out.println("Your last name is: " + obj.getPassword());
			plLogger.info("Enter password that to be your updated password");
			obj.setPassword(scanner.nextLine());
			loginBoundry.updatePassword(obj);
		} else {
			plLogger.error("Id doesn't exists.");
		}

	}

	private static int addLearningActivity(LearningActivity learningActivity)
			throws ActivityException, ParseException, AssesmentException {
		System.out.println("Enter activity name: ");
		learningActivity.setActivity_name(scanner.nextLine());
		System.out.println("Enter activity link :");
		learningActivity.setActivity_link(scanner.nextLine());
		System.out.println("Enter activity level :");
		learningActivity.setActivity_level(scanner.nextLine());
		System.out.println("Enter activity time in hours:");
		learningActivity.setActivity_time(Double.parseDouble(scanner.nextLine()));
		System.out.println("Enter activity release date(yyyy-mm-dd)::");
		String strDate = scanner.nextLine();
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		learningActivity.setActivity_realsedate(date1);
		int id = learningActivityBoundry.addLearningActivity(learningActivity);
		return id;

	}

	private static int addAssessment(Assessment assessment) throws AssesmentException, ParseException {
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
		int id = assessmentActivivtyBoundry.addAssessmentActivity(assessment);
		return id;
	}

}