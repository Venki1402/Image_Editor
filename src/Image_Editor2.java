import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.util.*;
import java.lang.*;

public class Image_Editor2 {

    public static void printpixelvalues(BufferedImage inImage) {
        int height = inImage.getHeight();
        int width = inImage.getWidth();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(inImage.getRGB(j, i) + " ");
            }
        }
    }

    // convert to grey

    public static BufferedImage convertToGrayScale(BufferedImage inputImage) {
        int height = inputImage.getHeight();
        int width = inputImage.getWidth();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                outputImage.setRGB(j, i, inputImage.getRGB(j, i));
            }
        }
        return outputImage;
    }

    // Right-transpose the image

    public static BufferedImage Righttransposeimage(BufferedImage inImage) {
        int height = inImage.getHeight();
        int width = inImage.getWidth();
        BufferedImage rotatedImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rotatedImage.setRGB(i,j,inImage.getRGB(j,i));
            }
        }
        int index=rotatedImage.getWidth()-1;
        for(int i=0;i<rotatedImage.getHeight();i++){
            for(int j=0;j<rotatedImage.getWidth()/2;j++){
                Color temp=new Color(rotatedImage.getRGB(j,i));
                rotatedImage.setRGB(j,i,rotatedImage.getRGB(index-j,i));
                rotatedImage.setRGB(index-j,i,temp.getRGB());
            }
        }
        return rotatedImage;
    }

    // Left the image

    public static BufferedImage Lefttransposeimage(BufferedImage inImage) {
        int height = inImage.getHeight();
        int width = inImage.getWidth();
        BufferedImage rotatedImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rotatedImage.setRGB(i,j,inImage.getRGB(j,i));
            }
        }
        int index=rotatedImage.getHeight()-1;
        for(int j=0;j<rotatedImage.getWidth();j++){
            for(int i=0;i<rotatedImage.getHeight()/2;i++){
                Color temp=new Color(rotatedImage.getRGB(j,i));
                rotatedImage.setRGB(j,i,rotatedImage.getRGB(j,index-i));
                rotatedImage.setRGB(j,index-i,temp.getRGB());
            }
        }
        return rotatedImage;
    }

    // horizontal image

    public static BufferedImage horizontallyinvert(BufferedImage inImage) {
        int height = inImage.getHeight();
        int width = inImage.getWidth();
        BufferedImage HinvertImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                HinvertImage.setRGB(width - j - 1, i, inImage.getRGB(j, i));
            }
        }

        return HinvertImage;
    }

    // vertical image

    public static BufferedImage verticallyinvert(BufferedImage inImage) {
        int height = inImage.getHeight();
        int width = inImage.getWidth();
        BufferedImage VinvertImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                VinvertImage.setRGB(j, height - i - 1, inImage.getRGB(j,i));
            }
        }

        return VinvertImage;
    }

    // brightness
    public static BufferedImage changebrightness(BufferedImage inImage,int a){
        int height = inImage.getHeight();
        int width = inImage.getWidth();
        BufferedImage output = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                Color pixel = new Color(inImage.getRGB(j,i));
                int red = pixel.getRed();
                int green = pixel.getGreen();
                int blue = pixel.getBlue();
                red+= (a*red)/100;
                green+=(a*green)/100;
                blue+=(a*blue)/100;
                if(red>255)
                    red=255;
                if(green>255)
                    green=255;
                if(blue>255)
                    blue=255;
                if(red<0)
                    red=0;
                if(green<0)
                    green=0;
                if(blue<0)
                    blue=0;
                Color newpixel = new Color(red,green,blue);
                inImage.setRGB(j,i,newpixel.getRGB());}}
        return inImage;
    }

    public static BufferedImage GreenScale(BufferedImage inImage){
        int height = inImage.getHeight();
        int width = inImage.getWidth();
        BufferedImage output = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                Color pixel = new Color(inImage.getRGB(j,i));
                int red = pixel.getRed();
                int green = pixel.getGreen();
                int blue = pixel.getBlue();
                green+=(50*green)/100;
                if(green>255)
                    green=255;
                if(green<0)
                    green=0;
                Color newpixel = new Color(red,green,blue);
                output.setRGB(j,i,newpixel.getRGB());}}
        return output;
    }

    public static BufferedImage BlueScale(BufferedImage inImage){
        int height = inImage.getHeight();
        int width = inImage.getWidth();
        BufferedImage output = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                Color pixel = new Color(inImage.getRGB(j,i));
                int red = pixel.getRed();
                int green = pixel.getGreen();
                int blue = pixel.getBlue();
                blue+=(100*blue)/100;

                if(blue>255)
                    blue=255;

                if(blue<0)
                    blue=0;
                Color newpixel = new Color(red,green,blue);
                inImage.setRGB(j,i,newpixel.getRGB());}}
        return inImage;
    }

    public static BufferedImage RedScale(BufferedImage inImage){
        int height = inImage.getHeight();
        int width = inImage.getWidth();
        BufferedImage output = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                Color pixel = new Color(inImage.getRGB(j,i));
                int red = pixel.getRed();
                int green = pixel.getGreen();
                int blue = pixel.getBlue();
                red+= (50*red)/100;
                if(red>255)
                    red=255;
                if(red<0)
                    red=0;
                Color newpixel = new Color(red,green,blue);
                inImage.setRGB(j,i,newpixel.getRGB());}}
        return inImage;


    }


    public static BufferedImage blurImage(BufferedImage inImage,int blrRatio){
        int height = inImage.getHeight();
        int width = inImage.getWidth();
        BufferedImage outputImage = new BufferedImage(width, height , BufferedImage.TYPE_INT_RGB);
        for (int i=0;i<height;i+=blrRatio){
            for (int j=0;j<width;j+=blrRatio){
                int sumofRED=0,sumofGREEN=0,sumofBLUE=0,sumofAlpha=0;
                int count=0;
                for(int k=i;k<i+blrRatio;k++){
                    for (int l=j;l<j+blrRatio;l++){
                        if (k<height && l<width) {
                            Color pixel = new Color(inImage.getRGB(l, k));
                            sumofRED += pixel.getRed();
                            sumofGREEN += pixel.getGreen();
                            sumofBLUE += pixel.getBlue();
                            sumofAlpha += pixel.getAlpha();
                            count++;
                        }
                    }
                }
                sumofRED=sumofRED/count;
                sumofGREEN=sumofGREEN/count;
                sumofBLUE=sumofBLUE/count;
                sumofAlpha=sumofAlpha/count;
                for(int k=i;k<i+blrRatio;k++){
                    for(int l=j;l<j+blrRatio;l++){
                        if (k<height && l<width){
                            Color newpixel = new Color(sumofRED,sumofGREEN,sumofBLUE,sumofAlpha);
                            outputImage.setRGB(l,k,newpixel.getRGB());
                        }
                    }
                }

            }
        }
        return outputImage;
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String S = sc.next();

        File inputFile = new File(S);
        BufferedImage inputImage = ImageIO.read(inputFile);

        System.out.println("Enter 1 for VERTICAL Inversion");
        System.out.println("Enter 2 for HORIZONTAL Inversion");
        System.out.println("Enter 3 for Rotate Left");
        System.out.println("Enter 4 for Rotate Right");
        System.out.println("Enter 5 for Print PIXEL VALUES of image");
        System.out.println("Enter 6 for Change IMAGE BRIGHTNESS");
        System.out.println("Enter 7 for convert image to GRAYSCALE");
        System.out.println("Enter 8 for convert image to GREENSCALE");
        System.out.println("Enter 9 for convert image to BLUESCALE");
        System.out.println("Enter 10 for convert image to REDSCALE");
        System.out.println("Enter 11 for convert image to BlurImage");





        int operation = sc.nextInt();
        if (operation == 1) {
            BufferedImage result = verticallyinvert(inputImage);
            File output = new File("output.jpg");
            ImageIO.write(result, "jpg", output);
        } else if (operation == 2) {
            BufferedImage result = horizontallyinvert(inputImage);
            File output = new File("output.jpg");
            ImageIO.write(result, "jpg", output);

        } else if (operation == 3) {
            BufferedImage result = Lefttransposeimage(inputImage);
            File output = new File("output.jpg");
            ImageIO.write(result, "jpg", output);
        } else if (operation == 4) {
            BufferedImage result = Righttransposeimage(inputImage);
            File output = new File("output.jpg");
            ImageIO.write(result, "jpg", output);
        } else if (operation == 5) {
            printpixelvalues(inputImage);
        }
        else if(operation==6){
            System.out.println("Please specify the percentage by which you would like to increase the brightness");
            int a = sc.nextInt();
            BufferedImage result = changebrightness(inputImage,a);
            File output = new File("output.jpg");
            ImageIO.write(result, "jpg", output);

        }
        else if (operation == 7) {
            BufferedImage result = convertToGrayScale(inputImage);
            File output = new File("output.jpg");
            ImageIO.write(result, "jpg", output);
        }
        else if(operation == 8) {
            BufferedImage result = GreenScale(inputImage);
            File output = new File("output.jpg");
            ImageIO.write(result, "jpg", output);

        }
        else if(operation == 9) {
            BufferedImage result = BlueScale(inputImage);
            File output = new File("output.jpg");
            ImageIO.write(result, "jpg", output);

        }
        else if(operation == 10) {
            BufferedImage result = RedScale(inputImage);
            File output = new File("output.jpg");
            ImageIO.write(result, "jpg", output);

        }
        else if(operation == 11) {
            System.out.println("Please input the blur amount");
            int B = sc.nextInt();
            BufferedImage result = blurImage(inputImage,B);
            File output = new File("output.jpg");
            ImageIO.write(result, "jpg", output);

        }

    }
 }


