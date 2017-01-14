package folder;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class FolderScript1 {

    /*
     * 폴더에서 파일명이 같은 *.png 파일과 *.jpg 파일의 크기를 비교하여
     * 크기가 큰 것을 삭제함.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Command Line Param: d:/temp");
            return;
        }

        File root = new File(args[0]);
        Map<String, File>  pngFiles = new TreeMap<String, File>();
        Map<String, File>  jpgFiles = new TreeMap<String, File>();
        for (File f : root.listFiles((dir, name) -> name.matches(".+.png"))) {
            String name = f.getName().replaceAll(".png$", "");
            pngFiles.put(name, f);
        }
        for (File f : root.listFiles((dir, name) -> name.matches(".+.jpg"))) {
            String name = f.getName().replaceAll(".jpg$", "");
            jpgFiles.put(name, f);
        }
        for (String key : pngFiles.keySet()) {
            File pngFile = pngFiles.get(key);
            File jpgFile = jpgFiles.get(key);
            if (pngFile != null && jpgFile != null) {
                if (pngFile.length() > jpgFile.length()) {
                    System.out.println("delete " + pngFile.getName());
                    pngFile.delete();
                } else {
                    System.out.println("delete " + jpgFile.getName());
                    jpgFile.delete();
                }
            }
        }
    }

}
