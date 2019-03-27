// Contrôleur 


package application;
/*Robert Liu 865826
 * */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


/*
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}*/

import java.util.Scanner;

public class RobotFindsKitten extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Grille gameMap = new Grille(5, 2, 11, 5, 50);

			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/*public void victoryScreen(Stage primaryStage) {
		BorderPane root = new BorderPane();
		//VBox root = new VBox();
		Scene scene = new Scene(root,400,400);
		Image victoire = new Image ("/found-kitten.png");
		victoire.isPreserveRatio();
		ImageView victoryScreen = new ImageView (victoire);
		victoryScreen.fitHeightProperty().bind(root.heightProperty());
		victoryScreen.fitWidthProperty().bind(root.widthProperty());
		victoryScreen.isPreserveRatio();
		root.getChildren().add(victoryScreen);
		
		Text congratulation = new Text();
		congratulation.setText("You found kitten! Way to go, robot.\nCaramel <3 ");
		congratulation.setFill(Color.RED);
		congratulation.setFont(Font.font("Arial", 25));
		congratulation.setTextAlignment(TextAlignment.CENTER);
		congratulation.wrappingWidthProperty().bind(root.widthProperty());
		root.setAlignment(congratulation, Pos.BOTTOM_CENTER);
		root.setBottom(congratulation);
		
		primaryStage.setTitle("Super Dungeon Master 3000 Ultra Turbo Edition");
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.show();
	}*/
	
	public static void test(String[] args) {
		
		/*
		 * Pour rendre notre jeu un plus interactif, on demande à l'utilisateur de
		 * nommer le Robot :)
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenue dans RobotFindsKitten\n" + 
				"Super Dungeon Master 3000 Ultra Turbo Edition !\n\nEntrez un nom pour le Robot ou appuyez sur 'Entrer' pour sauter cette étape");
		String playerName = scanner.nextLine();

		if (playerName.length() == 0) {
			System.out.println("Vous n'avez entré aucun nom. \n" + "Votre Robot se nomme Jimmy Whooper Bot!\n\n");
			playerName = "Jimmy Whooper Bot";
		} else {
			System.out.println("Votre Robot se nomme : " + playerName);
		}
		Robot player = new Robot(playerName);

		
		/*Nous prenons ici des dimensions standards.
		 * En ce moment, il y a un bogue si l'utilisateur entre
		 * une hauteur ou largeur paire. Nous n'avons pas été en mesure 
		 * de résoudre ce problème.
		 * */
		Grille gameMap = new Grille(5, 2, 11, 5, 50);
		//On initiale la position de départ du joueur une fois la Grille créée.
		player.setPosition(gameMap.randomEmptyCell());
		

		
		
		//gameMap.afficher(player);

		//Boucle principale de notre jeu. Tant que le chat n'est pas trouvé, le joueur est invité
		//à entrer une commande.
		while (player.hasChat() == false) {
			System.out.println("Il faut trouver le Chat! Pour déplacer le Robot, appuyer sur W, A, S, D");
			Scanner mouvement = new Scanner(System.in);
			String entree = mouvement.next();
			
			//Ce if est nécessaire pour empêcher des entrées vides (qui font échouer le jeu)
			if(entree.length()>0) {
				char move = entree.charAt(0);
				if (move == 'w') {
					boolean condition = gameMap.deplacementPossible(player, player.getPositionX(), player.getPositionY()-1);
					if (condition == true) {
						Point point = new Point(player.getPositionX(), player.getPositionY()-1);
						player.setPosition(point);
					}
				}
				
				if (move == 's') {
					boolean condition = gameMap.deplacementPossible(player, player.getPositionX(), player.getPositionY()+1);
					if (condition == true) {
						Point point = new Point(player.getPositionX(), player.getPositionY()+1);
						player.setPosition(point);
					}
				}
				
				if (move == 'a') {
					boolean condition = gameMap.deplacementPossible(player, player.getPositionX()-1, player.getPositionY());
					if (condition == true) {
						Point point = new Point(player.getPositionX()-1, player.getPositionY());
						player.setPosition(point);
					}
				}
				
				if (move == 'd') {
					boolean condition = gameMap.deplacementPossible(player, player.getPositionX()+1, player.getPositionY());
					if (condition == true) {
						Point point = new Point(player.getPositionX()+1, player.getPositionY());
						player.setPosition(point);
					}
				}
				
				if (move =='t') {
					if (player.getTeleport()==true) {
						Point position = gameMap.randomEmptyCell();
						player.setPosition(position);					
					}
				}
				//à chaque entrée du joueur, la carte du jeu est réimprimée pour illustrer le nouvel état.
				gameMap.afficher(player);

			}
		}
		//Une fois la boucle while termineé, la partie est réputée terminée.
		System.out.println("You found kitten! Way to go, robot.\nCaramel <3 "+player.getNom());
	}
}

