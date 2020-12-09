package com.casestudy.tlta.pl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.casestudy.tlta.boundry.AssessmentActivityBoundry;
import com.casestudy.tlta.boundry.AssessmentActivityBoundryImpl;
import com.casestudy.tlta.boundry.LearningActivityBoundry;
import com.casestudy.tlta.boundry.LearningActivityBoundryImpl;
import com.casestudy.tlta.boundry.LoginBoundary;
import com.casestudy.tlta.boundry.LoginBoundaryImpl;
import com.casestudy.tlta.boundry.UserActivityBoundry;
import com.casestudy.tlta.boundry.UserActivityBoundryImpl;
import com.casestudy.tlta.entity.Assessment;
import com.casestudy.tlta.entity.LearningActivity;
import com.casestudy.tlta.entity.RegisterUser;
import com.casestudy.tlta.entity.Role;
import com.casestudy.tlta.entity.UserActivity;
import com.casestudy.tlta.exception.ActivityException;
import com.casestudy.tlta.exception.AssesmentException;
import com.casestudy.tlta.exception.LoginException;

public class TestApplication {
	private static Scanner scanner = new Scanner(System.in);
	private static LoginBoundary loginBoundry = new LoginBoundaryImpl();
	private static LearningActivityBoundry leaarningActivityBoundry = new LearningActivityBoundryImpl();
	private static AssessmentActivityBoundry assessmentActivivtyBoundry = new AssessmentActivityBoundryImpl();
	private static Logger plLogger = Logger.getLogger(TestApplication.class);
	private static UserActivityBoundry userActivityBoundry = new UserActivityBoundryImpl();

	public static void main(String[] args) {

		while (true) {
			System.out.println(
					"Enter 1.Login 2.Create(Admin/Moderator/User/Activity/Assessment/) \n3.Update(Admin/Moderator/User/Assessment/activity) \n4. Delete(Admin/Moderator/User/Assessment/activity) \n5. Search \n6. View all"
							+ "\n 7.User can register to activity \n 8.User can upload certificate");
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

//                    break;
				case 2: {
					
					System.out.println("Create 1. Admin 2. User 3.Moderator 4. Activity 5. Assessment");
					int choice = Integer.parseInt(scanner.nextLine());
					switch (choice) {
					case 1:

						login = new RegisterUser();
						login.setRole(Role.ADMIN);
						addPerson(login);
						// System.out.println("New ADMIN added successfully");
						plLogger.info("1 admin record added");
						break;
					case 2:
						login = new RegisterUser();
						login.setRole(Role.USER);
						addPerson(login);
						// System.out.println("New USER added successfully");
						plLogger.info("1 new user added");
						break;
					case 3:
						login = new RegisterUser();
						login.setRole(Role.MODERATOR);
						addPerson(login);
						// System.out.println("New MODERATOR added successfully");
						plLogger.info("1 new moderator added");
						break;
					case 4:
						learningActivity = new LearningActivity();
						int id = addLearningActivity(learningActivity);
						System.out.println("New LEARNING ACTIVITY added successfully with id: " + id);
						// plLogger.info("1 learning activity added with id: "+id);
						break;
					case 5:
						assessment = new Assessment();
						int assessmentId = addAssessment(assessment);
						// System.out.println("New ASSESSMENT added successfully with id:
						// "+assessmentId);
						plLogger.info("1 assessment added with id: " + assessmentId);
						break;

					default:
						System.out.println("Invalid option");
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
							login = new RegisterUser();
							updatePassword(login);
							// System.out.println("Password changed successfully");
							plLogger.info("Password changed successfully");
							break;
						case 2:
							login = new RegisterUser();
							updateFirstName(login);
							// System.out.println("First name changed successfully");
							plLogger.info("first name changed ");
							break;
						case 3:
							login = new RegisterUser();
							updateLastName(login);
							// System.out.println("Last name changed successfully");
							plLogger.info("last name changed");
							break;
						default:
							// System.out.println("Invalid option");
							plLogger.info("Invalid option");
							break;
						}
					case 2:
						System.out.println("Update 1. Password 2. First Name 3. Last Name");
						choice = Integer.parseInt(scanner.nextLine());
						switch (choice) {
						case 1:
							login = new RegisterUser();
							updatePassword(login);
							// System.out.println("Password changed successfully");
							plLogger.info("Password changed successfully");
							break;
						case 2:
							login = new RegisterUser();
							updateFirstName(login);
							// System.out.println("First name changed successfully");
							plLogger.info("first name changed ");
							break;
						case 3:
							login = new RegisterUser();
							updateLastName(login);
							// System.out.println("Last name changed successfully");
							plLogger.info("last name changed");
							break;
						default:
							// System.out.println("Invalid option");
							plLogger.info("Invalid option");
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
						System.out.println("Invalid Option");
						break;
					}
				}
					break;
				case 4: {
					System.out.println(
							"Enter 1. Delete Admin \n 2. Delete Moderator \n 3 Delete User \n4.Delete Learning Activity \n5.Delete assessment");

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
						System.out.println("Enter learning activity id to be deleted");
						id = deleteActivivty(Integer.parseInt(scanner.nextLine()));
						System.out.println("Activity deleted successfully.");
						break;
					case 5:
						System.out.println("Enter assessment id for deletion:");
						Integer assessmentId = Integer.parseInt(scanner.nextLine());
						Integer deletedId = deleteAssessment(assessmentId);
						System.out.println("Assessment is deleted with id: " + deletedId);
						break;

					default:
						break;
					}
				}
					break;
				case 5: {
					System.out.println("Search by id : 1. Admin 2. Moderator 3. User 4.Activity 5.Assessment");

					Integer choice4 = Integer.parseInt(scanner.nextLine());
					switch (choice4) {

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
						LearningActivity getlearningActivity = getActivityById(activivtyId);
						System.out.println(getlearningActivity);
						System.out.println("Activity found.");
						break;
					case 5:
						System.out.println("Enter assessment id for searching:");
						Integer id = Integer.parseInt(scanner.nextLine());
						assessment = getAssessmentById(id);
						if (assessment != null)
							System.out.println(assessment);
						else
							System.out.println("Not present");
						break;

					default:
						System.out.println("Invalid option");
						break;
					}
				}
					break;
				case 6:
					System.out.println("Enter 1 View all Users 2. View all activities 3. View all assessments");
					Integer choice = Integer.parseInt(scanner.nextLine());
					switch (choice) {
					case 1:
						break;
					case 2:
						List<LearningActivity> Llist = getAllLearningActivity();
						Llist.stream().forEach(System.out::println);
						break;
					case 3:
						List<Assessment> list = getAllAssessmentActivity();
						list.stream().forEach(System.out::println);
						break;
					default:
						System.out.println("Invalid option");
						break;
					}
					break;
				case 7:
//					System.out.println("Enter user Id:");
//					Integer userId = Integer.parseInt(scanner.nextLine());
//					System.out.println("Enter activity id: ");
//					Integer activityId = Integer.parseInt(scanner.nextLine());
//					UserActivity userActivity = new UserActivity();
//					Integer userActivityId = userRegisterToActivity(userActivity, userId, activityId);
//					System.out.println("User with id " + userId + " register activity with id: " + userActivityId);
					break;
				case 8:
					System.out.println("Enter user Id:");
					Integer userId1 = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter activity Id:");
					Integer activityId2 = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter file path");
					String path = scanner.nextLine();
					Integer status = uploadCertificate(path,userId1,activityId2);
					System.out.println(status);
					System.out.println("Cerificate uploaded successfully");
					break;
				default:
					System.out.println("Invalid option");
					break;
					
				}
			}

			catch (AssesmentException e) {
				e.printStackTrace();
			} catch (ActivityException e1) {
				e1.printStackTrace();
			} catch (ParseException e2) {

			} catch (LoginException e2) {

			}

			System.out.println("Enter y to continue..");
			String ch = scanner.nextLine();
			if (!ch.equalsIgnoreCase("y")) {
				break;
			}

		}

	}

	private static Integer uploadCertificate(String path, Integer userId1, Integer activityId2) throws ActivityException {
		
		return userActivityBoundry.uploadCerificate(path, userId1, activityId2);
	}

	private static List<LearningActivity> getAllLearningActivity() throws ActivityException {

		return leaarningActivityBoundry.getAllLearningActivity();
	}

	private static LearningActivity getLearningActivityById(Integer activityId) throws ActivityException {
		return leaarningActivityBoundry.searchLearningActivityById(activityId);

	}

	private static Integer userRegisterToActivity(UserActivity userActivity, Integer userId, Integer activityId)
			throws ActivityException {
		return userActivityBoundry.userRegisterToLearningActivity(userActivity, userId, activityId);
	}

	private static RegisterUser getUserById(Integer userId) throws LoginException {

		// TODO Auto-generated method stub
		return loginBoundry.getUserById(userId);

	}

	private static LearningActivity getActivityById(Integer userId) throws ActivityException {
		return leaarningActivityBoundry.searchLearningActivityById(userId);
		// TODO Auto-generated method stub

	}

	private static Integer deleteUser(Integer id) throws LoginException {
		return loginBoundry.deleteUser(id);

	}

	private static Integer deleteActivivty(int parseInt) throws ActivityException {
		// TODO Auto-generated method stub
		return leaarningActivityBoundry.deleteLearningActivity(parseInt);
	}

	private static void updateLastName(RegisterUser login) throws LoginException {
		System.out.println("Your last name is: " + login.getLastName());
		System.out.println("Enter updated last name: ");
		login.setLastName(scanner.nextLine());
		loginBoundry.updateLastName(login);
	}

	private static void updateFirstName(RegisterUser login) throws LoginException {
		System.out.println("Your first name is: " + login.getFirstName());
		System.out.println("Enter updated first name: ");
		login.setFirstName(scanner.nextLine());
		loginBoundry.updateFirstName(login);

	}

	private static void updatePassword(RegisterUser login) throws LoginException {
		// System.out.println("Your password name is: "+login.getLastName());
		System.out.println("Enter updated password: ");
		login.setPassword(scanner.nextLine());
		loginBoundry.updatePassword(login);

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

	private static List<Assessment> getAllAssessmentActivity() throws AssesmentException {
		return assessmentActivivtyBoundry.getAllAssessmentActivity();

	}

	private static Integer deleteAssessment(Integer id) throws AssesmentException {
		return assessmentActivivtyBoundry.deleteAssessmentActivity(id);

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
			updatedActivity = leaarningActivityBoundry.updateLearningActivity(learningActivity);
			break;
		case 2:
			System.out.println("Existing activity link is: " + learningActivity.getActivity_link());
			System.out.println("Enter new activity link ::");
			String link = scanner.nextLine();
			learningActivity.setActivity_link(link);
			updatedActivity = leaarningActivityBoundry.updateLearningActivity(learningActivity);
			break;
		case 3:
			System.out.println("Existing activity level is: " + learningActivity.getActivity_level());
			System.out.println("Enter new activity level ::");
			String level = scanner.nextLine();
			learningActivity.setActivity_level(level);
			updatedActivity = leaarningActivityBoundry.updateLearningActivity(learningActivity);
			break;
		case 4:
			System.out.println("Existing time duration is: " + learningActivity.getActivity_time() + " hours.");
			System.out.println("Enter new duration in hours ::");
			Double timeDuration = Double.parseDouble(scanner.nextLine());
			learningActivity.setActivity_time(timeDuration);
			updatedActivity = leaarningActivityBoundry.updateLearningActivity(learningActivity);
			break;
		case 5:
			System.out.println(
					"Existing release date of learning activity is: " + learningActivity.getActivity_realsedate());
			System.out.println("Enter new assessment release date(yyyy-mm-dd)::");
			String strDate = scanner.nextLine();
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			learningActivity.setActivity_realsedate(date1);
			updatedActivity = leaarningActivityBoundry.updateLearningActivity(learningActivity);
		default:
			plLogger.error("Invalid option");
			break;
		}
		return updatedActivity;
	}

	private static Assessment getAssessmentById(Integer assessmentId) throws AssesmentException {

		return assessmentActivivtyBoundry.searchAssessmentActivityById(assessmentId);
	}

	private static Integer addLearningActivity(LearningActivity learningActivity)
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

		int id = leaarningActivityBoundry.addLearningActivity(learningActivity);
		return id;
	}

	private static Integer addAssessment(Assessment assessment) throws AssesmentException, ParseException {
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