import edu.duke.*;

public class PerimeterAssignmentRunner {
    double Perimeter;
    public int getNumPoints(Shape s){
        int count=0;
        for(Point Pt: s.getPoints()){
            count++;
        }
        
        return count;
    }    
    
    public double getAverageLength(Shape s){
        double avg=0;
        double totalPerim = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt: s.getPoints()){
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        avg = totalPerim/getNumPoints(s);
        return avg;
    }
    
    public double getLargestSide(Shape s){
        double largest=0;
        Point prevPt = s.getLastPoint();
        for(Point currPt: s.getPoints()){
            double currDist = prevPt.distance(currPt);
            if(currDist>largest){
                largest=currDist;
            }
            prevPt = currPt;
        }
        
        return largest;
    }
    
    public double getLargestX(Shape s){
        int largestX=0;
        for(Point currPt: s.getPoints()){
            int currX = currPt.getX();
            if(currX>largestX){
                largestX=currX;
            }
        }
        return largestX;
    }
    
    public double getPerimeter(Shape s){
        double totalPerim = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt: s.getPoints()){
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        
        return totalPerim; 
    }
    
    public void testPerimeter(){
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int count = getNumPoints(s);
        double avg = getAverageLength(s);
        double largest = getLargestSide(s);
        double largestX = getLargestX(s);
        double shape = mysteryShape(s);
        System.out.println("Number of Points = "+count);
        System.out.println("Perimeter = "+length);
        System.out.println("Average of sides' lengths = "+avg);
        System.out.println("Largest of sides' length = "+largest);
        System.out.println("Largest X of all points = "+largestX);
    }
    
    public double mysteryShape (Shape s) {
        double tmp = 0;
        for (Point p : s.getPoints()) {
            if (p.getX() > 0) {
                if (p.getY() < 0) {
                    tmp = tmp + 1;
                }
            }
        }
        return tmp / getNumPoints(s);    
    }
    
    public static void main (String[] args){
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
