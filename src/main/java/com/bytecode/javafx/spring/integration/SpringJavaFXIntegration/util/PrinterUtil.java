package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.util;

import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * @author vinsfran
 */
public class PrinterUtil {

    public static boolean print(Printable printable, String nombreImpresora) {

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(printable);

        PageFormat pf = job.defaultPage();

        Paper paper = new Paper();
//        paper.setSize(745.0, 100.0);
        paper.setSize(612.0, 802.0);
        double margin = 1;
//        paper.setImageableArea(margin, margin, paper.getWidth(), paper.getHeight() - margin);
        paper.setImageableArea(margin, margin, paper.getWidth(), paper.getHeight() - margin);
        pf.setPaper(paper);
        pf.setOrientation(PageFormat.PORTRAIT);
        job.setPrintable(printable, pf);

//        if (job.printDialog()) {
//            try {
//                job.defaultPage(pf);
//                job.print();
//                return true;
//            } catch (PrinterException e) {
//                System.out.println(e);
//            }
//        }
        job.setJobName(nombreImpresora);
        try {
            job.defaultPage(pf);
            job.print();
            return true;
        } catch (PrinterException e) {
            System.out.println("PrinterUtil:print:ERROR: " + e.getCause());
        }
        return false;
    }

}
