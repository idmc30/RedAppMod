package proyecto.contol.idmc.appred.redapp;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Juajo on 10/05/2016.
 */
public class Fecha {


    public static String getDiffDates(Date fechaInicio, Date fechaFin) {

        Calendar calendarInicio = Calendar.getInstance();
        calendarInicio.setTime(fechaInicio);
        int diaInicio = calendarInicio.get(Calendar.DAY_OF_MONTH);
        int mesInicio = calendarInicio.get(Calendar.MONTH) + 1; // 0 Enero, 11 Diciembre
        int anioInicio = calendarInicio.get(Calendar.YEAR);

        // Fecha fin
        Calendar calendarFin = Calendar.getInstance();
        calendarFin.setTime(fechaFin);
        int diaFin = calendarFin.get(Calendar.DAY_OF_MONTH);
        int mesFin = calendarFin.get(Calendar.MONTH) + 1; // 0 Enero, 11 Diciembre
        int anioFin = calendarFin.get(Calendar.YEAR);

        int anios = 0;
        int mesesPorAnio = 0;
        int diasPorMes = 0;
        int diasTipoMes = 0;

        //
        // Calculo de días del mes
        //
        if (mesInicio == 2) {
            // Febrero
            if ((anioFin % 4 == 0) && ((anioFin % 100 != 0) || (anioFin % 400 == 0))) {
                // Bisiesto
                diasTipoMes = 29;
            } else {
                // No bisiesto
                diasTipoMes = 28;
            }
        } else if (mesInicio <= 7) {
            // De Enero a Julio los meses pares tienen 30 y los impares 31
            if (mesInicio % 2 == 0) {
                diasTipoMes = 30;
            } else {
                diasTipoMes = 31;
            }
        } else if (mesInicio > 7) {
            // De Julio a Diciembre los meses pares tienen 31 y los impares 30
            if (mesInicio % 2 == 0) {
                diasTipoMes = 31;
            } else {
                diasTipoMes = 30;
            }
        }


        //
        // Calculo de diferencia de año, mes y dia
        //
        if ((anioInicio > anioFin) || (anioInicio == anioFin && mesInicio > mesFin)
                || (anioInicio == anioFin && mesInicio == mesFin && diaInicio > diaFin)) {
            // La fecha de inicio es posterior a la fecha fin
            // System.out.println("La fecha de inicio ha de ser anterior a la fecha fin");
            return "-1";
        } else {
            if (mesInicio <= mesFin) {
                anios = anioFin - anioInicio;
                if (diaInicio <= diaFin) {
                    mesesPorAnio = mesFin - mesInicio;
                    diasPorMes = diaFin - diaInicio;
                } else {
                    if (mesFin == mesInicio) {
                        anios = anios - 1;
                    }
                    mesesPorAnio = (mesFin - mesInicio - 1 + 12) % 12;
                    diasPorMes = diasTipoMes - (diaInicio - diaFin);
                }
            } else {
                anios = anioFin - anioInicio - 1;
                System.out.println(anios);
                if (diaInicio > diaFin) {
                    mesesPorAnio = mesFin - mesInicio - 1 + 12;
                    diasPorMes = diasTipoMes - (diaInicio - diaFin);
                } else {
                    mesesPorAnio = mesFin - mesInicio + 12;
                    diasPorMes = diaFin - diaInicio;
                }
            }
        }
        //System.out.println("Han transcurrido " + anios + " Años, " + mesesPorAnio + " Meses y " + diasPorMes + " Días.");

        //
        // Totales
        //
        long returnValue = -1;
        int anio=anios;
        int mes=anios * 12 + mesesPorAnio;
        if(mes>12){
            mes=mesesPorAnio;
        }else{
            mes=anios * 12 + mesesPorAnio;
        }

        long millsecsPerDay = 86400000; // Milisegundos al día
        long dias=(fechaFin.getTime() - fechaInicio.getTime()) / millsecsPerDay;


        return ""+anio+","+mes+","+dias+","+diasPorMes;

    }




}
