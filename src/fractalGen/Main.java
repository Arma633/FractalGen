package fractalGen;




import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Main extends Application {

	public static void sierpinski(Point2D p0, Point2D p1, Point2D p2,Pane p,int limit) {
		if(limit > 0) {
			Point2D pA = new Point2D((p0.getX()+p2.getX())/2, (p0.getY()+p2.getY())/2);
			Point2D pB = new Point2D((p1.getX()+p2.getX())/2, (p1.getY()+p2.getY())/2);
			Point2D pC = new Point2D((p0.getX()+p1.getX())/2, (p0.getY()+p1.getY())/2);

			sierpinski(p0, pC, pA, p, limit-1);
			sierpinski(pC, p1, pB, p, limit-1);
			sierpinski(pA, pB, p2, p, limit-1);
		} else p.getChildren().add(new Polygon(p0.getX(),p0.getY(),
											   p1.getX(),p1.getY(),
											   p2.getX(),p2.getY()));



	}

	@Override
	public void start(Stage s) throws Exception {
		s.setTitle("Fractal Gen");
		Pane p = new Pane();
		Scene scene = new Scene(p, 500, 500);
		Point2D p0 = new Point2D(100, 300);
		Point2D p1 = new Point2D(400, 300);
		Point2D p2 = new Point2D(250, 100);
		sierpinski(p0, p1, p2,p,6);
		s.setScene(scene);
		s.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}


}
