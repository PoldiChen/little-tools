package files.rename;

import java.io.File;
import java.util.Random;

/**
 * @author poldi.chen
 * @className AddPrefix
 * @description TODO
 * @date 2019/5/26 11:08
 **/
public class AddPrefix {

    public static void main(String[] args) {
        String path = "H:\\新建文件夹\\@rename";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            String newName = getRandomNumber() + "--" + f.getName();
            f.renameTo(new File(path + "/" + newName));
            System.out.println("rename to: " + newName);
        }
    }

    private static String getRandomNumber() {
        Random random = new Random();
        int a = random.nextInt(800) + 100;
        return String.valueOf(a);
    }
}
