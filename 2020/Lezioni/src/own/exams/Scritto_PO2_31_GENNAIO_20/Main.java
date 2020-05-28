package own.exams.Scritto_PO2_31_GENNAIO_20;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Function;



class Point {
    public final double x, y, z;

    Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Point move(double dx, double dy, double dz) {
        return new Point(x + dx, y + dy, z + dz);
    }
}

interface Solid extends Comparable<Solid> {
    PositionedSolid at(Point origin);

    double area();

    double volume();

    static <S extends Solid> int compareBy(Function<S, Double> f, S s1, S s2) {
        return Double.compare(f.apply(s1), f.apply(s2));
    }

    static <S extends Solid> Comparator<S> comparatorBy(Function<S, Double> f) {
        return (s1, s2) -> compareBy(f, s1, s2);
    }

    static  <S extends Solid> Comparator<S> comparatorBy_(Function<S, Double> f) {
        return new Comparator<S>() {
            @Override
            public int compare(S s1, S s2) {
                return compareBy(f,s1,s2);
            }
        };
    }

    @Override
    default int compareTo(Solid s) {
        return compareBy((x) -> x.volume(), this, s);
    }
}

interface Polyhedron extends Solid {
    double perimeter();

    @Override
    PositionedPolyhedron at(Point origin);
}

interface PositionedSolid {
    Point origin();
}

interface PositionedPolyhedron extends PositionedSolid, Iterable<Point> {
}

class Cube implements Polyhedron {
    private double side; // lato del cubo

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double volume() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public PositionedPolyhedron at(Point o) {

        return new PositionedPolyhedron() {

            @Override
            public Point origin() {
                return o;
            }

            @NotNull
            @Override
            public Iterator<Point> iterator() {
                final Point u = o.move(side, side, side);
                final Point[] ps = new Point[]{
                        o,
                        o.move(side, 0., 0.),
                        o.move(0., side, 0.),
                        o.move(0., 0., side),
                        u,
                        u.move(side, 0., 0.),
                        u.move(0., side, 0.),
                        u.move(0., 0., side),
                };
                return Arrays.asList(ps).iterator();
            }
        };
    }


}

class Sphere implements Solid {
    private double ray; // raggio della sfera

    /* implementare il resto */

    public Sphere(double ray) {
        this.ray = ray;
    }

    @Override
    public double area() {
        return 4 * Math.PI * Math.pow(ray,2);
    }

    @Override
    public double volume() {
        return Math.PI * (4./3.) * (Math.pow(ray,3));
    }

    @Override
    public PositionedSolid at(Point origin) {
        return new PositionedSolid() {
            @Override
            public Point origin() {
                return origin;
            }
        };
    }

}

public class Main{
    public static void main(String[] args) {
//        Cube cube1 = new Cube(11.), cube2 = new Cube(23.);
//        Sphere sphere1 = new Sphere(12.), sphere2 = new Sphere(35.);
//        List<Solid> solids = List.of(cube1, cube2, sphere1, sphere2);
//        List<Cube> cubes = List.of(cube1, cube2);
//        List<Sphere> spheres = List.of(sphere1, sphere2);
//        List<? extends Polyhedron> polys = ,;
//
//        // 5.a: questa invocazione è legale perché Cube implementa Comparable<Solid>
//        Collections.sort(cubes);
//
//        // 5.b
//        Collections.sort(spheres, Solid.comparatorBy(Sphere::area));
//
//        // 5.c
//        Comparator<Cube> cmpCube = Solid.comparatorBy(Cube::perimeter);
//        Comparator<Solid> cmpSolid = Solid.comparatorBy(Solid::area);
//        Comparator<Sphere> cmpSphere = Solid.comparatorBy(Sphere::perimeter);   // non compila
//        Comparator<Solid> cmpSolid2 = Solid.comparatorBy(Cube::area);           // non compila
//        Comparator<Polyhedron> cmpPoly = Solid.comparatorBy(Polyhedron::volume);
//        Comparator<Sphere> cmpSphere2 = Solid.comparatorBy(Solid::area);
//        Comparator<Polyhedron> cmpPoly2 = Solid.comparatorBy(Solid::volume);
//        Comparator<Cube> cmpCube2 = Solid.comparatorBy(Polyhedron::perimeter);
//
//        // 5.d
//        Collections.sort(solids, cmpCube2);     // non compila
//        Collections.sort(cubes, cmpSolid);
//        Collections.sort(spheres, cmpSphere2);
//        Collections.sort(solids, cmpPoly2);     // non compila
//        Collections.sort(cubes, cmpSolid2);
//        Collections.sort(cubes, cmpPoly);
//        Collections.sort(spheres, cmpPoly2);    // non compila
//        Collections.sort(polys, cmpSolid);
//
//        // 5.e
//        Point o = new Point(1., -1.5, 2.);
//        for (Polyhedron poly : polys) {
//            for (Point p : poly.at(o)) {
//                System.out.println(p);
//            }
//        }
    }
}








