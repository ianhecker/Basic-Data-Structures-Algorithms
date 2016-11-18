package javastackslab;
/**
 *
 * @author Ian Hecker
 */
public class PixelRegion {
    
    private final int xCoor, yCoor;
    private boolean [] adjPixels = new boolean[8];//8 for all pixels around chosen pixel
    
    public PixelRegion(int xCoor, int yCoor){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        
        for(boolean position : adjPixels)
        {
            position = false;
        }
    }
    
    public int getX()
    {
        return xCoor;
    }
    
    public int getY()
    {
        return yCoor;
    }
    
    public boolean checkAdjPix(int position)
    {
         return adjPixels[position];
    }
    
    public void setAdjPix(int position, boolean booleanState)
    {
         adjPixels[position] = booleanState;
    }
}
