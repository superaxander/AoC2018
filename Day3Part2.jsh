public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int hashCode() {
        return x * 31 + y;
    }

    public boolean equals(Object other) {
        if(other instanceof Point) {
            return x == ((Point)other).x && y == ((Point)other).y;
        }
        return false;
    }
}

public class Claim {
    public final int id;
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public Claim(int id, int x, int y, int width, int height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean inClaim(Point point) {
        return point.x >= this.x && point.x < this.x + this.width
                && point.y >= this.y && point.y < this.y + this.height;
    }

    public void getIntersection(Set<Point> list, Claim other) {
        int startX = Math.min(this.x, other.x);
        int startY = Math.min(this.y, other.y);
        int endX = Math.max(this.x + this.width, other.x + other.width);
        int endY = Math.max(this.y + this.height, other.y + other.height); 
        for(int x = startX; x < endX; x++) {
            for(int y = startY; y < endY; y++) {
                Point p = new Point(x, y);
                if(this.inClaim(p) && other.inClaim(p)) {
                    list.add(p);
                }
            }
        }
    }

    public void addPoints(List<Point> list, Set<Point> dups) {
        for(int x = this.x; x < this.x + this.width; x++) { 
            for(int y = this.y; y < this.y + this.height; y++) {
                Point p = new Point(x, y);
                if(list.contains(p))
                    dups.add(p);
                else
                    list.add(p);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("#%d @ %d,%d: %dx%d", id, x, y, width, height);
    }
}

File file = new File("D:/Programming/AdventOfCode/day3_input.txt");
if (!file.exists()) {
    System.err.println("Can't find day3_input.txt");
} else {    
    Scanner scanner = new Scanner(file);
    ArrayList<Claim> claims = new ArrayList<>();  
    String line;
    while(scanner.hasNext()) {
        scanner.findInLine("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)");
        MatchResult res = scanner.match();
        claims.add(new Claim(
                    Integer.parseInt(res.group(1)),
                    Integer.parseInt(res.group(2)),
                    Integer.parseInt(res.group(3)),
                    Integer.parseInt(res.group(4)),
                    Integer.parseInt(res.group(5))
                    ));
        scanner.nextLine();
    }
    scanner.close();
    
    List<Point> squares = new ArrayList<>();
    Set<Point> dups = new HashSet<>();
    for(Claim c : claims)
        c.addPoints(squares, dups);

outer:
    for(Claim c: claims){
        for(Point p : dups)
            if(c.inClaim(p))
                continue outer;
        System.out.println(c);
        break;   
    }

    /*
    Set<Point> squares = new HashSet<>();
    int length = claims.size();
    for(int i = 0; i < length; i++) {
        for(int j = i; j < length; j++) {
            claims.get(i).getIntersection(squares, claims.get(j));
        }
        if(i % 25 == 0)
            System.out.println("i: "+i+" size: "+squares.size());
    }*/
    
    System.out.println("Result: "+dups.size());
}
Thread.sleep(1000);
/exit
