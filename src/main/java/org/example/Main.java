package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        //args = new String[]{"src/main/resources/bild01.png"};

        if (args.length == 0) {
            throw new IllegalArgumentException("file to read from is missing");
        }

        final BufferedImage image = ImageIO.read(new File(args[0]));

        final StringBuilder sb = new StringBuilder();

        int x = 0;
        int y = 0;
        Color color;

        do {
            color = new Color(image.getRGB(x, y));
            sb.append((char) color.getRed());
            x += color.getGreen();
            y += color.getBlue();
            x %= image.getWidth();
            y %= image.getHeight();
        } while (color.getGreen() != 0 && color.getBlue() != 0);

        System.out.println();
        System.out.println(sb);
    }
}