// C'est la vue du programme (affichage + démarrer le programme)

package application;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Vue {

	Stage primaryStage;
	VBox root = new VBox();
	Text message = new Text();
	GridPane zoneJeu = new GridPane();
	Text statut = new Text();
	
	/**
	 * Le constructeur de la Vue
	 * @param grille : La grille contient toute l'information sur l'emplacement 
	 * des objets du jeu.
	 */
	public Vue (Case[][] grille) {
		
		for (int i = 0;i<grille.length;i++) {
			for (int j = 0 ; j<grille[0].length;j++) {
				if(grille[i][j]!= null) {
					Image objet = new Image(grille[i][j].getImage());
					ImageView conteneur = new ImageView(objet);
					conteneur.resize(30, 30);
					conteneur.setX(i);
					conteneur.setY(j);
					zoneJeu.getChildren().add(conteneur);
				}else {
					//Si l'élément i,j de la grille == null, c'est un espace vide
					Image objet = new Image ("/back.png");
					ImageView conteneur = new ImageView(objet);
					conteneur.resize(30, 30);
					conteneur.setX(i);
					conteneur.setY(j);
					zoneJeu.getChildren().add(conteneur);
				}
			}
		}
	
	}
	
	/**
	 * Méthode qui prend en entrée le Robot et la Grille.
	 * Sert à mettre à jour l'Affichage.
	 * @param grille
	 * @param robot
	 */
	public void update (Case[][] grille, Robot robot) {
		if (robot.getTeleport()==true) {
			statut.setText(robot.getNom()+ "["+ robot.getKeys()+"]T>");
		}else {
			statut.setText(robot.getNom()+ "["+ robot.getKeys()+"]>");
		}
	}
	
	public void afficher() {
		primaryStage.show();
	}
	
	public void victoryScreen() {
		BorderPane root = new BorderPane();
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
	}
	


}
