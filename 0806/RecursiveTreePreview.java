import java.util.*;

public class RecursiveTreePreview {
    // 模擬資料夾結構
    static class Folder {
        String name;
        List<Folder> subfolders = new ArrayList<>();
        int files;

        Folder(String name, int files) {
            this.name = name;
            this.files = files;
        }

        void addSubfolder(Folder f) {
            subfolders.add(f);
        }
    }

    public static int countFiles(Folder folder) {
        int total = folder.files;
        for (Folder sub : folder.subfolders)
            total += countFiles(sub);
        return total;
    }

    public static void printMenu(String[] items, int level) {
        for (String item : items) {
            System.out.println("  ".repeat(level) + "- " + item);
            // 可遞迴子選單
        }
    }

    public static void flatten(List<Object> nested, List<Object> flat) {
        for (Object obj : nested) {
            if (obj instanceof List)
                flatten((List<Object>) obj, flat);
            else
                flat.add(obj);
        }
    }

    public static int maxDepth(List<Object> nested) {
        int max = 1;
        for (Object obj : nested) {
            if (obj instanceof List)
                max = Math.max(max, 1 + maxDepth((List<Object>) obj));
        }
        return max;
    }
}
