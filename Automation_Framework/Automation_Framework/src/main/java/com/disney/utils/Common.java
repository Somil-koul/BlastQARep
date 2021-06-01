package com.disney.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Common {

	public static void copyFile(String copyFrom, String copyTo, String fileTobeCopied) {
		try {
			String copyFrompath = copyFrom;
			String copyTopath = copyTo;
			FileReader fr = new FileReader(copyFrompath + "report.html");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(copyTopath + "report.html", true);
			String s;

			while ((s = br.readLine()) != null) { // read a line
				fw.write(s); // write to output file
				fw.flush();
			}
			br.close();
			fw.close();
			System.out.println("file copied");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
