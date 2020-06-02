package own.exams.Scritto_PO2_06_SETTEMBRE_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

/**
  (a) [1 punti]
  Si implementi un tipo che rappresenta punti
  bidimensionali immutabili, ovvero una classe Point in
  cui le componenti x ed y sono di tipo double.
*/
class Point {
    final double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * (b) [2 punti]
 * Si implementi un tipo che rappresenta segmenti
 * bidimensionali immutabili, ovvero una classe Line
 * il cui costruttore prende due argomenti di tipo Point.
 * Essa deve fornire un metodo length() che ne calcola
 * la lunghezza tramite la distanza euclidea tra i due punti.
 */
class Line{
    final Point p1,p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double length(){
        return Math.sqrt(
                (Math.pow(p1.x - p2.x,2)) +
                (Math.pow(p1.y - p2.y,2)));
    }
}


/**
 * (c) Si prenda in considerazione la seguente classe
 * astratta Polygon che rappresenta poligoni regolari come liste
 * di punti (minimo 3, verificato a runtime).
 * I punti nella lista determinano l’ordine di costruzione dei segmenti
 * di cui `e composto il poligono. Ad esempio,
 * una lista contenente i seguenti 3 punti A = (0, 0), B = (3, 3) e
 * C = (3, 0) rappresenta un triangolo rettangolo in cui il
 * primo lato `e AB, il secondo `e BC ed il terzo `e CA.
 * */
abstract class Polygon {
    protected final List<Point> points;
    protected Polygon(List<Point> points) {
        assert points.size() >= 3;
        this.points = points;
    }
    /**
     * ii. 6 punti
     * Si implementi il metodo lineIterator() che costruisce un
     * iteratore su oggetti di tipo Line e
     * si comporta come un wrapper dell’iteratore estratto dal
     * campo points. Gli oggetti prodotti dall’iteratore
     * di Line devono essere costruiti dinamicamente leggendo
     * coppie di punti adiacenti dall’iteratore di Point.
     * Si implementi una logica di caching dell’ultimo punto
     * letto per permettere la costruzione di un nuovo
     * segmento adiacente all’ultimo ad ogni invocazione del
     * metodo next(). Si badi inoltre a riusare opportunamente
     * il primo punto come secondo estremo dell’ultimo segmento costruito
     * */
    public Iterator<Line> lineIterator() {
        return new Iterator<Line>() {
            Iterator<Point> pointIterator = points.iterator();

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Line next() {
                return null;
            }
        };
    }
    public double perimeter() {
        Iterator<Line> lineIterator = lineIterator();

        double perimeter = 0.;

        while(lineIterator.hasNext()){
            Line line = lineIterator.next();
            perimeter += line.length();
        }
        return perimeter;
    }
    public abstract double area();
}



class Triangle extends Polygon {
    public Triangle(Point p1, Point p2, Point p3) {
        super(List.of(p1,p2,p3));
    }

    @Override
    public double area() { }
}




