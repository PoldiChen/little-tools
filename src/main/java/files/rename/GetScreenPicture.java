package files.rename;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author poldi.chen
 * @className GetScreenPicture
 * @description TODO
 * @date 2019/6/8 12:48
 **/
public class GetScreenPicture {

    public static void main(String[] args) {
        String win10CachePath = "C:\\Users\\12133\\AppData\\Local\\Packages\\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\\LocalState\\Assets";
        String tempPath = "D:\\@file\\03.图片\\win10-temp";
        String extension = "png";

        int delCount = clearTempPath(tempPath);
        System.out.println("clear temp path: " + delCount);

        File file = new File(win10CachePath);
        File[] files = file.listFiles();
        for (File f : files) {
            if (!isScreen(f)) {
                continue;
            }
            String oldName = f.getName();
            String newName = oldName + "." + extension;
            String newPath = tempPath + "/" + newName;
            try {
                Files.copy(f.toPath(), new File(newPath).toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("get picture [" + newName + "] from system cache path.");
        }
    }

    private static int clearTempPath(String tempPath) {
        File file = new File(tempPath);
        File[] files = file.listFiles();
        int delCount = 0;
        for (File f : files) {
            if (f.delete()) {
                delCount ++;
            }
        }
        return delCount;
    }

    private static boolean isScreen(File file) {
        BufferedImage bi;
        try {
            bi = ImageIO.read(file);
            int width = bi.getWidth();
            int height = bi.getHeight();
            return (width == 1920 && height == 1080);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
