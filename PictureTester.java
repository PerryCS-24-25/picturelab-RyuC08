/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 *
 * @author Barbara Ericson
 */
public class PictureTester {

    /**
     * Method to test the PictureExplorer
     */
    public static void testExplorer() {
        Picture bKarl = new Picture("blueKarl.jpg");
        bKarl.explore();
        Picture lebron = new Picture("lebron.jpg");
        lebron.explore();
        Picture lesmall = lebron.scale(0.25, 0.25);
        lesmall.write("smallLebron.jpg");
        Picture test = lesmall.scale(4, 4);
        test.explore();
    }

    /**
     * Method to test zeroBlue
     */
    public static void testZeroBlue() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

    /**
     * Method to test keepOnlyBlue
     */
    public static void testKeepOnlyBlue(){
        Picture bMotor = new Picture("blueMotorcycle.jpg");
        bMotor.explore();
        bMotor.keepOnlyBlue();
        bMotor.explore();
    }
    /**
     * Method to test keepOnlyRed
     */
    public static void testKeepOnlyRed(){
        Picture flower2 = new Picture("flower2.jpg");
        flower2.explore();
        flower2.keepOnlyRed();
        flower2.explore();
    }
    /**
     * Method to test keepOnlyGreen
     */
    public static void testKeepOnlyGreen(){
        Picture flower = new Picture("flower1.jpg");
        flower.explore();
        flower.keepOnlyGreen();
        flower.explore();
    }
    /**
     * Method to test negate
     */
    public static void testNegate(){
        Picture T7 = new Picture("T7.jpg");
        T7.explore();
        T7.negate();
        T7.explore();
    }
    /**
     * Method to test grayscale
     */
    public static void testGrayscale(){
        Picture wall = new Picture("wall.jpg");
        wall.explore();
        wall.grayscale();
        wall.explore();
    }

    /**
     * Method to test fixUnderwater
     */
    public static void testFixUnderwater(){
        Picture water = new Picture("water.jpg");
        water.explore();
        water.fixUnderwater();
        water.explore();
    }

    /**
     * Method to test mirrorVertical
     */
    public static void testMirrorVertical() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }
    /**
     * Method to test mirrorVertical
     */
    public static void testMirrorVerticalRightToLeft() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVerticalRightToLeft();
        caterpillar.explore();
    }
     /**
     * Method to test mirrorHorizontal
     */
    public static void testMirrorHorizontal() {
        Picture rMotor = new Picture("redMotorcycle.jpg");
        rMotor.explore();
        rMotor.mirrorHorizontal();
        rMotor.explore();
    }
    /**
     * Method to test mirrorHorizontal
     */
    public static void testMirrorHorizontalBotToTop() {
        Picture rMotor = new Picture("redMotorcycle.jpg");
        rMotor.explore();
        rMotor.mirrorHorizontalBotToTop();
        rMotor.explore();
    }
    /**
     * Method to test mirrorHorizontal
     */
    public static void testMirrorDiagonal() {
        Picture robot = new Picture("robot.jpg");
        robot.explore();
        robot.mirrorDiagonal();
        robot.explore();
    }
    /**
     * Method to test mirrorTemple
     */
    public static void testMirrorTemple() {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }
    /**
     * Method to test mirrorArms
     */
    public static void testMirrorArms() {
        Picture snowman = new Picture("snowman.jpg");
        snowman.explore();
        snowman.mirrorArms();
        snowman.explore();
    }
    /**
     * Method to test mirrorGull
     */
    public static void testMirrorGull() {
        Picture gull = new Picture("seagull.jpg");
        gull.explore();
        gull.mirrorGull();
        gull.explore();
    }
    /*
     * Method to test encode and decode
     */
    public static void testEncodeAndDecode(){
        Picture hall = new Picture("femaleLionAndHall.jpg");
        hall.explore();
        Picture msg = new Picture("msg.jpg");
        hall.encode(msg);
        hall.explore();
        hall.decode();
        hall.explore();
    }
    /*
     * Method to test chromakey
     */
    public static void testChromakey(){
        Picture img = new Picture("blue-mark.jpg");
        img.explore();
        Picture bGround = new Picture("moon-surface.jpg");
        img.chromakey(bGround, 10, 40, 70);
        img.explore();
    }
    /*
     * Method to test pixelate
     */
    public static void testPixelate(){
        Picture img = new Picture("lebron.jpg");
        img.explore();
        img.pixelate(25);
        img.explore();
    }
    /**
     * Method to test edgeDetection
     */
    public static void testEdgeDetection() {
        Picture swan = new Picture("swan.jpg");
        swan.edgeDetection(10);
        swan.explore();
    }

    /**
     * Method to test scaling a picture
     */
    public static void testScale() {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        Picture temple2 = temple.scale(0.5, 0.5);
        temple2.explore();
    }

    /**
     * Main method for testing. Every class can have a main method in Java
     */
    public static void main(String[] args) {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run

        //testExplorer();
        //testScale();
        //testZeroBlue();
        //testKeepOnlyBlue();
        //testKeepOnlyRed();
        //testKeepOnlyGreen();
        //testNegate();
        //testGrayscale();
        //testFixUnderwater();
        //testMirrorVertical();
        //testMirrorVerticalRightToLeft();
        //testMirrorHorizontal();
        //testMirrorHorizontalBotToTop();
        //testMirrorTemple();
        //testMirrorArms();
        //testMirrorGull();
        //testMirrorDiagonal();
        //testCollage();
        //testCopy();
        //testEdgeDetection();
        //testEdgeDetection2();
        //testChromakey();
        testPixelate();
        //testEncodeAndDecode();
        //testGetCountRedOverValue(250);
        //testSetRedToHalfValueInTopHalf();
        //testClearBlueOverValue(200);
        //testGetAverageForColumn(0);
    }
}
