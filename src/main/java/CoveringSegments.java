import java.util.*;

public class CoveringSegments {
    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        //Sorting stuff
        for(int a =0; a < segments.length-1;a++ ){
            for(int b = a+1; b< segments.length;b++){
                if(segments[a].end > segments[b].end){
                    Segment seg = segments[a];
                    segments[a] = segments[b];
                    segments[b] = seg;
                }
            }
        }

        int c=0, d = 0;
        //int[] points = new int[2 * segments.length];

        int point = segments[0].end;
        ArrayList commonPoints = new ArrayList();
        commonPoints.add(point);

        for(int a =0; a <segments.length;a++){
            if(point < segments[a].start || point > segments[a].end){
                point = segments[a].end;
                commonPoints.add(point);
            }
        }
        int a[] = new int[commonPoints.size()];
        for(int b =0;b<commonPoints.size();b++){
            a[b] = (int)commonPoints.get(b);
        }
        return a;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }

}