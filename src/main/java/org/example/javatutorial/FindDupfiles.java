package org.example.javatutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FindDupfiles {

    public static void main(String[] args) throws FileNotFoundException {


        File file = new File("C://Users//Kittu//Desktop//files");
        File[] files = file.listFiles();
        String[] allfiles = file.list();
        for (String s : allfiles) {
            File newfile = new File(file, s);
            if (newfile.isFile()) {
                System.out.println(s);
            }
        }
        System.out.println("Duplicate files are:");
        for (int x = 0; x < files.length; x++) {
            for (int y = x + 1; y < files.length; y++) {
                if (files[x].length() == files[y].length()) {
                    if (CompareFiles(files[x], files[y])) {
                        System.out.println(allfiles[y]);
                    }
                }
            }
        }


    }

    private static boolean CompareFiles(File file, File file1) throws FileNotFoundException {
        try {

            FileInputStream a = new FileInputStream(file);
            FileInputStream b = new FileInputStream(file1);
            boolean result = true;
            while (result == true) {
                int p = a.read();
                int q = b.read();
                if (p != q) {
                    result = false;
                    break;

                }
                if (p == -1) {
                    break;
                }
                return result;


            }


        }catch (FileNotFoundException e) {
            System.out.println("File not found");

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

