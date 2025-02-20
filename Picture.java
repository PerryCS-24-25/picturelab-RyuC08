import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture() {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param file the name of the file to create the picture from
     */
    public Picture(java.io.File file) {
        // let the parent class handle this fileName
        super(file);
    }

    /**
     * Constructor that takes the width and height
     * 
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int width, int height) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a copy of that picture
     *
     * @param copyPicture the picture to copy
     */
    public Picture(SimplePicture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     *
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////
    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName()
            + " height " + getHeight()
            + " width " + getWidth();
        return output;

    }

    /**
     * Method to create a new picture by scaling the current picture by the given
     * x and y factors
     *
     * @param xFactor the amount to scale in x
     * @param yFactor the amount to scale in y
     * @return the resulting picture
     */
    public Picture scale(double xFactor, double yFactor) {
        // set up the scale transform
        AffineTransform scaleTransform = new AffineTransform();
        scaleTransform.scale(xFactor, yFactor);

        // create a new picture object that is the right size
        Picture result = new Picture((int) (getWidth() * xFactor),
                (int) (getHeight() * yFactor));

        // get the graphics 2d object to draw on the result
        Graphics graphics = result.getGraphics();
        Graphics2D g2 = (Graphics2D) graphics;

        // draw the current image onto the result image scaled
        g2.drawImage(this.getImage(), scaleTransform, null);

        result.setTitle(getTitle());
        return result;
    }

    /**
     * Method to set the blue to 0
     */
    public void zeroBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setBlue(0);
            }
        }
    }

    /**
     * Removes all the red from this image.
     */
    public void zeroRed() {
        //TODO: Write this method.
    }

    /**
     * Removes all the green from this image.
     */
    public void zeroGreen() {
        //TODO: Write this method.   
    }

    /**
     * Method to only keep the blue in this image
     */ 
    public void keepOnlyBlue(){
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }
    /**
     * Method to only keep the blue in this image
     */ 
    public void keepOnlyRed(){
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setBlue(0);
                pixelObj.setGreen(0);
            }
        }
    }
    /**
     * Method to only keep the blue in this image
     */ 
    public void keepOnlyGreen(){
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(0);
                pixelObj.setBlue(0);
            }
        }
    }
    /**
     * All colors are 255 the original
     */
    public void negate(){
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }
    /**
     * All colors are 1/3 of the original avg
     */
    public void grayscale(){
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                int avg = (pixelObj.getRed() + pixelObj.getGreen()+ pixelObj.getBlue())/3;
                pixelObj.setRed(avg);
                pixelObj.setGreen(avg);
                pixelObj.setBlue(avg);
            }
        }
    }
    /**
     * All colors are made either black or white
     */
    public void blackandwhite(){
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                int avg = (pixelObj.getRed() + pixelObj.getGreen()+ pixelObj.getBlue())/3;
                if(avg > 127){
                    pixelObj.setRed(255);
                    pixelObj.setGreen(255);
                    pixelObj.setBlue(255);
                }
                else{
                    pixelObj.setRed(0);
                    pixelObj.setGreen(0);
                    pixelObj.setBlue(0);
                }
                
            }
        }
    }

    /**
     * Make water more clear
     */
    public void fixUnderwater(){
        Pixel[][] pixels = this.getPixels2D();
        int lR = lowestRed();
        int lG = lowestGreen();
        int lB = lowestBlue();
        int hR = highestRed();
        int hG = highestGreen();
        int hB = highestBlue();
        double rScale = 255 / ((double)(hR - lR));
        double gScale = 255 / ((double)(hG - lG));
        double bScale = 255 / ((double)(hB - lB));
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                double newR = ((double)(pixelObj.getRed() - lR))*rScale;
                double newG = ((double)(pixelObj.getGreen() - lG))*gScale;
                double newB = ((double)(pixelObj.getBlue() - lB))*bScale;
                pixelObj.setRed((int)(newR));
                pixelObj.setGreen((int)(newG));
                pixelObj.setBlue((int)(newB));
            }
        }
    }

    /*
     * Find the lowest red value of an entire image
     */
    public int lowestRed(){
        Pixel[][] pixels = this.getPixels2D();
        int rLow = 255;
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                if(pixelObj.getRed() < rLow){
                    rLow = pixelObj.getRed();
                }
            }
        }
        return rLow;
    }
    /*
     * Find the lowest green value of an entire image
     */
    public int lowestGreen(){
        Pixel[][] pixels = this.getPixels2D();
        int gLow = 255;
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                if(pixelObj.getGreen() < gLow){
                    gLow = pixelObj.getGreen();
                }
            }
        }
        return gLow;
    }
    /*
     * Find the lowest blue value of an entire image
     */
    public int lowestBlue(){
        Pixel[][] pixels = this.getPixels2D();
        int bLow = 255;
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                if(pixelObj.getBlue() < bLow){
                    bLow = pixelObj.getBlue();
                }
            }
        }
        return bLow;
    }
    /*
     * Find the highest red value of an entire image
     */
    public int highestRed(){
        Pixel[][] pixels = this.getPixels2D();
        int rHigh = 0;
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                if(pixelObj.getRed() > rHigh){
                    rHigh = pixelObj.getRed();
                }
            }
        }
        return rHigh;
    }
    /*
     * Find the highest red value of an entire image
     */
    public int highestGreen(){
        Pixel[][] pixels = this.getPixels2D();
        int gHigh = 0;
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                if(pixelObj.getGreen() > gHigh){
                    gHigh = pixelObj.getGreen();
                }
            }
        }
        return gHigh;
    }
    /*
     * Find the highest red value of an entire image
     */
    public int highestBlue(){
        Pixel[][] pixels = this.getPixels2D();
        int bHigh = 0;
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                if(pixelObj.getBlue() > bHigh){
                    bHigh = pixelObj.getBlue();
                }
            }
        }
        return bHigh;
    }

    /**
     * Method that mirrors the picture around a vertical mirror in the center of
     * the picture from left to right
     */
    public void mirrorVertical() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    /**
     * Method that  mirrors the picture around a mirror placed vertically from right to left
     */
    public void mirrorVerticalRightToLeft() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }
    /**
     * Method that mirrors the picture around a horizontal mirror in the center of
     * the picture from top to bottom
     */
    public void mirrorHorizontal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int col = 0; col < pixels[0].length; col++) {
            for (int row = 0; row < height / 2; row++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }
    /**
     * Method that mirrors the picture around a horizontal mirror in the center of
     * the picture from bottom to top
     */
    public void mirrorHorizontalBotToTop() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int col = 0; col < pixels[0].length; col++) {
            for (int row = 0; row < height / 2; row++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        }
    }
    /**
     * Method that mirrors the picture around a horizontal mirror in the center of
     * the picture from top to bottom
     */
    public void mirrorDiagonal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel bottomLPixel = null;
        Pixel topRPixel = null;
        int length;
        if(pixels.length > pixels[0].length){
            length = pixels[0].length;
        }
        else{
            length = pixels.length;
        }
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                bottomLPixel = pixels[col][row];
                topRPixel = pixels[row][col];
                topRPixel.setColor(bottomLPixel.getColor());
            }
        }
    }   
    /**
     *  Creates a vertical mirror image of the this picture.
     */
    public void verticalReflection() {
        //TODO: Write this method.
    }

    /**
     * Converts this image into a horizontal mirror image of itself.
     */
    public void horizontalReflection() {
        //TODO: Write this method.
    }

    /**
     * Mirror just part of a picture of a temple
     */
    public void mirrorTemple() {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++) {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    /**
     * Mirror just the arms of a snowman
     */
    public void mirrorArms() {
        int mirrorPoint1 = 190;
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop from 159 to mirror point
        for (int row = 159; row <= mirrorPoint1; row++) {
            // loop through the columns
            for (int col = 105; col < 170; col++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[mirrorPoint1 - row + mirrorPoint1][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
        topPixel = null;
        bottomPixel = null;
        // loop from 172 to mirror point
        for (int row = 172; row <= mirrorPoint1; row++) {
            // loop through the columns
            for (int col = 239; col < 294; col++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[mirrorPoint1 - row + mirrorPoint1][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }
    /**
     * Mirror a seagull
     */
    public void mirrorGull() {
        int mirrorPoint = 344;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();
        // loop through the rows
        for (int row = 234; row < 320; row++) {
            // loop from 239 to just before the mirror point
            for (int col = 239; col < mirrorPoint; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /*
     * Takes the black and white picture message and changes the current picture to hide the message picture inside of it
     */
    public void encode(Picture newImage){
        Pixel[][] pixels = this.getPixels2D();
        Picture hidden = newImage;
        hidden.blackandwhite();
        Pixel[][] msg = hidden.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                if((pixelObj.getRed() % 2) != 0){
                    pixelObj.setRed(pixelObj.getRed() - 1);
                }
            }
        }
        int width = pixels[0].length;
        int length = pixels.length;
        if(msg[0].length < pixels[0].length){
            width = msg[0].length;
        }
        if(msg.length < pixels.length){
            length = msg.length;
        }
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                if(msg[row][col].getRed() == 0){
                    pixels[row][col].setRed(pixels[row][col].getRed() + 1);
                }
            }
        }
    }
    /*
     * returns the picture hidden in the current picture
     */
    public void decode(){
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                if((pixelObj.getRed() % 2) == 0){
                    pixelObj.setRed(255);
                    pixelObj.setGreen(255);
                    pixelObj.setBlue(255);
                }
                else{
                    pixelObj.setRed(0);
                    pixelObj.setGreen(0);
                    pixelObj.setBlue(0);
                }
            }
        }
    }
    
    /*
     * replace a given pixel color with the color from another picture
     */
    public void chromakey(Picture background, int red, int green, int blue){
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] bGroundPixels = background.getPixels2D();
        int rRange = 50;
        int gRange = 50;
        int bRange = 50;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                if((pixels[row][col].getRed() > (red - rRange) && (pixels[row][col].getRed() < (red + rRange))) &&
                    (pixels[row][col].getGreen() > (green - gRange) && (pixels[row][col].getGreen() < (green + gRange))) &&
                    (pixels[row][col].getBlue() > (blue - bRange) && (pixels[row][col].getBlue() < (blue + bRange)))
                )
                {   
                    pixels[row][col].setRed(bGroundPixels[row][col].getRed());
                    pixels[row][col].setGreen(bGroundPixels[row][col].getGreen());
                    pixels[row][col].setBlue(bGroundPixels[row][col].getBlue());
                }
            }
        }
    }

    /*
     * Make image more pixelated
     */
    public void pixelate(int threshold){
        double scale = (double)(1/((double)threshold));
        Pixel[][] pixels = this.getPixels2D();
        Picture temp = this.scale(scale, scale);
        Picture pixelated = temp.scale(1/scale, 1/scale);
        Pixel[][] nPixels = pixelated.getPixels2D();
        int sRow;
        int sCol;
        if(nPixels.length>pixels.length){
            sRow = pixels.length;
        }
        else{
            sRow = nPixels.length;
        }
        if(nPixels.length>pixels.length){
            sCol = pixels[0].length;
        }
        else{
            sCol = nPixels[0].length;
        }
        for (int row = 0; row < sRow; row++) {
            for (int col = 0; col < sCol; col++) {
                pixels[row][col].setRed(nPixels[row][col].getRed());
                pixels[row][col].setGreen(nPixels[row][col].getGreen());
                pixels[row][col].setBlue(nPixels[row][col].getBlue());
            }
        }
    }
    /**
     * copy from the passed fromPic to the specified startRow and startCol in the
     * current picture
     *
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, int startRow, int startCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow;
        fromRow < fromPixels.length
        && toRow < toPixels.length;
        fromRow++, toRow++) {
            for (int fromCol = 0, toCol = startCol;
            fromCol < fromPixels[0].length
            && toCol < toPixels[0].length;
            fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    /**
     * 
     * @param fromPic The source image we are copying from
     * @param destRow the start row to copy to
     * @param destCol the start col to copy to
     * @param fromRow The start row of fromPic
     * @param fromCol The start col of fromPic
     * @param w Width of the area we wish to copy.
     * @param h Height of the area we wish to copy.
     */
    public void copy(Picture fromPic,int destRow, int destCol, int fromRow, int fromCol, int w, int h) {
        //TODO: Write and test this method
    }

    /**
     * Method to show large changes in color
     *
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist) {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0;
            col < pixels[0].length - 1; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor)
                > edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
