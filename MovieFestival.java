import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;
public class MovieTickets {
  //This Reader class is for taking input only
// Not a part of logic
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
    }
 
    public static void main(String[] args) throws IOException{
        Reader br = new Reader();
        int n= br.nextInt();
        int[][] pt=new int[n][2];
        for(int i=0;i<n;i++){
            pt[i][0]= br.nextInt();
            pt[i][1]= br.nextInt();
        }
        System.out.println(findMinArrowShots(pt));
    }
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->{
            if(a[1]<b[1]) return -1;
            if(a[1]>b[1]) return 1;
            else return 0;
        });
        int count=1;
        int lastend=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]>=lastend){
                count++;
                lastend=points[i][1];
            }
        }
        return count;
    }
}
