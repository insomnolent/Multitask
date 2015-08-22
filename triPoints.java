public class triPoints
{
    private int[] xpts, ypts;
    private int length;

    public triPoints(int[] x, int[] y, int n){
        length = n;
        xpts = x;
        ypts = y;
    }
    
    public int getMidy()
    {
        return ypts[1];
    }
    
    public int[] getX()
    {
        return xpts;
    }

    public int[] getY()
    {
        return ypts;
    }

    public int getLength()
    {
        return length; 
    }
    
    public void move(){
        for(int i=0; i<xpts.length;i++){
            xpts[i]+=2;
        }
       length+=2;
    }

}