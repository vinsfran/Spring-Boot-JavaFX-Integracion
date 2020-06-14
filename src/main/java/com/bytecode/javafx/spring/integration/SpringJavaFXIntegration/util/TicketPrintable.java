package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.util;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.Date;

/**
 *
 * @author vinsfran
 */
public class TicketPrintable implements Printable {

    private TicketModel ticketModel;

    public TicketPrintable(TicketModel ticketModel) {
        this.ticketModel = ticketModel;
    }

    @Override
    public int print(Graphics graphics, PageFormat f, int pageIndex) {
        if (pageIndex == 0) {

            Graphics2D g2d = (Graphics2D) graphics;
            //Punto donde empezará a imprimir dentro la pagina (100, 50)
//            g2d.translate(f.getImageableX() - 0, f.getImageableY() - 0);
//            g2d.scale(1.0, 1.0); //Reducción de la impresión al 50% - (0.50,0.50)

            g2d.setFont(new Font(Font.MONOSPACED, Font.BOLD, 10));
            g2d.drawString("MUNICIPALIDAD DE ASUNCION", 20, 46);

            g2d.setFont(new Font(Font.MONOSPACED, Font.BOLD, 8));
            g2d.drawString(ticketModel.getDependenciaNombre(), 20, 56);

            g2d.setFont(new Font("Arial Black", Font.BOLD, 24));
            g2d.drawString(ticketModel.getLetra() + ticketModel.getNumero(), 20, 80);

            g2d.setFont(new Font(Font.MONOSPACED, Font.BOLD, 7));
            g2d.drawString(DateUtil.parseToString(new Date(), ConstantUtil.DATE_FORMAT_DD_MM_YYYY_DD_HH_MM), 20, 90);

            return PAGE_EXISTS; //La página 1 existe y se imprimirá
        } else {
            return NO_SUCH_PAGE;        //No se imprimirán más páginas
        }
    }
}
