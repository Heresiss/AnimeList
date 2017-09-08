package sample;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    File f;
    private ArrayList<String> list;

    public FileHandler() {
        list = new ArrayList<>();
        f = new File("AnimeList.txt");
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load() throws IOException {
        Scanner scanner = null;

        try {
            scanner = new Scanner(f);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File 'AnimeList.txt' not found. lul", "FileNotFoundException", 0);
            System.exit(0);
        }

        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }
    }

    protected void save() {

        try {
            FileWriter fw = new FileWriter(f);
            fw.write("");
            fw.close();

            fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            for (int i = 0; i <= list.size() - 1; i++) {
                if (i < list.size() - 1) {
                    out.println(list.get(i));
                } else {
                    out.print(list.get(i));
                }
            }

            out.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File 'AnimeList.txt' not found. Lick my lips", "IOException", 0);
            System.exit(0);
        }

    }

    protected ArrayList<String> getList() {
        return list;
    }

    protected boolean add(String s) {
        boolean bool = false;
        for (String anime : list) {
            if (anime.compareTo(s) == 0) bool = true;
        }

        if (bool) {
            JOptionPane.showMessageDialog(null, "This anime is already on your list. I can slack. Yay!", "Sup bruh", 1);
            return false;
        }

        int i = 0;
        while (i <= list.size() - 1 && list.get(i).compareToIgnoreCase(s) < 0) {
            i++;
        }
        list.add(i, s);
        return true;
    }
}
