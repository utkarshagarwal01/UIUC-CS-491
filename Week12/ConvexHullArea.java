import java.util.*;
  
class Point
{
    int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
  
class ConvexHullArea {
      
    public static int orientation(Point p, Point q, Point r)
    {
        int val = (q.y - p.y) * (r.x - q.x) -
                  (q.x - p.x) * (r.y - q.y);
       
        if (val == 0) return 0;  
        return (val > 0)? 1: 2; 
    }
      
    
    public static void convexHull(Point points[], int n)
    {
        
        if (n < 3) return;
       
        
        Vector<Point> hull = new Vector<Point>();
       
        
        int l = 0;
        for (int i = 1; i < n; i++)
            if (points[i].x < points[l].x)
                l = i;
       
        
        
        
        
        int p = l, q;
        do
        {
            
            hull.add(points[p]);
       
            
            
            
            
            
            
            q = (p + 1) % n;
              
            for (int i = 0; i < n; i++)
            {
               
               
               if (orientation(points[p], points[i], points[q])
                                                   == 2)
                   q = i;
            }
       
            
            
            
            p = q;
       
        } while (p != l);  
                           
       
        
        for (Point temp : hull)
            System.out.println("(" + temp.x + ", " +
                                temp.y + ")");
    }
      
    /* Driver program to test above function */
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point points[] = new Point[n];
        for(int i=0;i<n;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i]=new Point(x,y);
        }
        convexHull(points, n);
    }
}