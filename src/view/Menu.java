package view;

import java.util.Date;

import controller.ChevalController;
import controller.CourseController;
import controller.HippodromeController;
import utils.Utilitaires;

public class Menu {
	HippodromeController hippodromeController;
	CourseController courseController;
	ChevalController chevalController;
	public Menu() {
		hippodromeController = new HippodromeController();
		courseController = new CourseController();
		chevalController = new ChevalController();
	}
	
	public void bonjour() {
		System.out.println("Bonjour !");
	}
	
	String hippodromeName;
	String courseName;
	Date courseDate;
	String chevalName;
	int age;
	int nbVictoire;
	
	public void choix() {
		System.out.println("Quel action souhaitez-vous faire ?");
		System.out.println("1 Afficher le nom de l'hippodrome");
		System.out.println("2 Modifier le nom de l'hippodrome");
		System.out.println("3 Ajouter une course");
		System.out.println("4 Afficher toutes les courses");
		System.out.println("5 Afficher les 10 dernieres courses");
		System.out.println("6 supprimer une course");
		System.out.println("7 Modifier le nom d'une course");
		System.out.println("8 Ajouter un cheval � une course");
		System.out.println("9 Afficher la liste des chevaux");
		System.out.println("10 Modifier nom d'un cheval");
		System.out.println("11 Supprimer un cheval");
		choixInput(Utilitaires.saisieString());
	}
	public void choix(int input) {
		System.out.println("Quel action souhaitez-vous faire ?");
		System.out.println("1 Afficher le nom de l'hippodrome");
		System.out.println("2 Modifier le nom de l'hippodrome");
		System.out.println("3 Ajouter une course");
		System.out.println("4 Afficher toutes les courses");
		System.out.println("5 Afficher les 10 dernieres courses");
		System.out.println("6 supprimer une course");
		System.out.println("7 Modifier le nom d'une course");
		System.out.println("8 Ajouter un cheval � une course");
		System.out.println("9 Afficher la liste des chevaux");
		System.out.println("10 Modifier nom d'un cheval");
		System.out.println("11 Supprimer un cheval");
		choixInput(String.valueOf(input));
	}
	public void choixInput(String saisie) {
		switch (saisie) {
		case "1":
			System.out.println("--------------");
			System.out.println("1 Nom de l'hippodrome");
			hippodromeController.printHippodrome();
			System.out.println("--------------");
			break;
		case "2":
			System.out.println("--------------"); 
			System.out.println("2 Modifier le nom de l'hippodrome");
			System.out.println("Saisissez le nouveau nom de l'hippodrome: ");
			hippodromeName = Utilitaires.saisieString();
			if (hippodromeController.updateHippodrome(hippodromeName)) {
				System.out.println("Nom de l'hippodrome mis � jour");
			} else {
				System.out.println("mise � jour du nom de l'hippodrome �chou�");
			}
			System.out.println("--------------");
			break;
		case "3":
			System.out.println("--------------");
			System.out.println("3 Ajouter une course");
			System.out.println("Saisissez le nom de la course");
			courseName = Utilitaires.saisieString();
			System.out.println("Saisissez la date de la course au format yyyy-mm-jj");
			courseDate = Utilitaires.parseDate(Utilitaires.saisieString());
			if (courseController.addCourse(courseName, courseDate)) {
				System.out.println("Course ajout�e");
			} else {
				System.out.println("Ajout de la course �chou�");
			}
			break;
		case "4":
			System.out.println("--------------");
			System.out.println("4 Afficher toutes les courses");
			courseController.printCourses();
			System.out.println("--------------");
			break;
		case "5":
			System.out.println("--------------");
			System.out.println("5 Afficher les 10 dernieres courses");
			courseController.printLastCourses();
			System.out.println("--------------");
			break;
		case "6":
			System.out.println("--------------");
			System.out.println("6 supprimer une course");
			System.out.println("Saisissez le nom de la course � supprimer: ");
			courseController.printCourses();System.out.println();
			courseName = Utilitaires.saisieString();
			if (courseController.deleteCourse(courseName)) {
				System.out.println("Course supprim�e");
			} else {
				System.out.println("La suppression a �chou�");				
			}
			break;
		case "7":
			System.out.println("--------------");
			System.out.println("7 Modifier le nom d'une course");
			System.out.println("Saisissez le nom de la course � modifier: ");
			courseController.printCourses();
			courseName = Utilitaires.saisieString();
			System.out.println("Saisissez le nouveau nom la course: ");
			String newCourseName = Utilitaires.saisieString();
			if (courseController.updateCourse(courseName, newCourseName)) {
				System.out.println("Nom de la course mis � jour: ");				
			} else {
				System.out.println("Mise � jour de la course a �chou�");
			}
			System.out.println("--------------");
			break;
		case "8":
			System.out.println("--------------");
			System.out.println("8 Ajouter un cheval � une course");
			System.out.println("Saisissez le nom de la course � selectionner : ");
			courseController.printCourses();
			courseName = Utilitaires.saisieString();
			System.out.println("Saisissez le nom du cheval: ");
			String chevalName = Utilitaires.saisieString();
			System.out.println("Saisissez l'age du cheval: ");
			age = Integer.parseInt(Utilitaires.saisieString());
			System.out.println("Saisissez le nombre de victoire du cheval: ");
			nbVictoire = Integer.parseInt(Utilitaires.saisieString());
			if (chevalController.addChevalToCourse(courseName, chevalName, age, nbVictoire)) {
				System.out.println("Cheval ajout�");
			} else {
				System.out.println("Ajout du cheval �chou�");
			}
			System.out.println("--------------");
			break;
		case "9":
			System.out.println("--------------");
			System.out.println("9 Afficher la liste des chevaux");
			System.out.println("Saisissez le nom de la course � selectionner : ");
			courseController.printCourses();
			courseName = Utilitaires.saisieString();
			chevalController.printChevaux(courseName);
			System.out.println("--------------");
			break;
		case "10":
			System.out.println("--------------");
			System.out.println("10 Modifier nom d'un cheval");
			System.out.println("Saisissez le nom de la course � modifier: ");
			courseController.printCourses();
			courseName = Utilitaires.saisieString();
			System.out.println("Saisissez le nom du cheval � modifier: ");
			chevalController.printChevaux(courseName);
			chevalName = Utilitaires.saisieString();
			System.out.println("Saisissez le nouveau nom du cheval: ");
			String newChevalName = Utilitaires.saisieString();
			if (chevalController.updateCheval(chevalName, newChevalName)) {
				System.out.println("Cheval mis � jour: ");				
			} else {
				System.out.println("Mise � jour du cheval a �chou�");
			}
			System.out.println("--------------");
			break;
		case "11":
			System.out.println("--------------");
			System.out.println("11 Supprimer un cheval");
			System.out.println("Saisissez le nom du cheval � supprimer: ");
			chevalController.printChevaux(courseName);
			chevalName = Utilitaires.saisieString();
			if (chevalController.deleteCheval(chevalName)) {
				System.out.println("Cheval supprim�: ");				
			} else {
				System.out.println("Suppression du cheval a �chou�");
			}
			break;		
		default:
			break;
		}
	}
	
	/*public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }*/
	
}
