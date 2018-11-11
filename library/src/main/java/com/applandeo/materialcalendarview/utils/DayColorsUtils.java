package com.applandeo.materialcalendarview.utils;

import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.applandeo.materialcalendarview.R;

import java.util.Calendar;

/**
 * This class is used to set a style of calendar cells.
 * <p>
 * Created by Mateusz Kornakiewicz on 24.05.2017.
 */

public class DayColorsUtils {


    /**
     * This is general method which sets a color of the text, font type and a background of a TextView object.
     * It is used to set day cell (numbers) style.
     *
     * @param textColor  A resource of a color of the day number
     * @param typeface   A type of text style, can be set as NORMAL or BOLD
     * @param background A resource of a background drawable
     */

    public static void setDayColors(View view, int textColor, int typeface, int background) {
        TextView textView = (TextView) view.findViewById(R.id.dayLabel);
        LinearLayout dayLayout = (LinearLayout) view.findViewById(R.id.dayLayout);

        if (textView == null) {
            return;
        }

        textView.setTypeface(null, typeface);
        textView.setTextColor(textColor);
        dayLayout.setBackgroundResource(background);
    }


    /**
     * This method sets a color of the text, font type and a background of a TextView object.
     * It is used to set day cell (numbers) style in the case of selected day (when calendar is in
     * the picker mode). It also colors a background of the selection.
     *
     * @param dayView           View containing a day number
     * @param calendarProperties A resource of a selection background color
     */

    public static void setSelectedDayColors(View dayView, CalendarProperties calendarProperties,
                                            Calendar day, Calendar today) {

        if (today.equals(day)) {
            setDayColors(dayView, calendarProperties.getSelectionLabelColor(), Typeface.NORMAL,
                    R.drawable.background_color_filled_border_selector);
        } else {
            setDayColors(dayView, calendarProperties.getSelectionLabelColor(), Typeface.NORMAL,
                    R.drawable.background_color_empty_border_selector);
        }

        dayView.getBackground().setColorFilter(calendarProperties.getSelectionColor(),
                android.graphics.PorterDuff.Mode.MULTIPLY);
    }


    /**
     * This method is used to set a color of texts, font types and backgrounds of TextView objects
     * in a current visible month. Visible day labels from previous and forward months are set using
     * setDayColors() method. It also checks if a day number is a day number of today and set it
     * a different color and bold face type.
     *
     * @param day                A calendar instance representing day date
     * @param today              A calendar instance representing today date
     * @param calendarProperties A resource of a color used to mark today day
     */
      public static void setCurrentMonthDayColors(Calendar day, Calendar today, View dayView,
                                                CalendarProperties calendarProperties) {
        if (today.equals(day)) {
            setDayColors(dayView, calendarProperties.getTodayLabelColor(), Typeface.BOLD,
                    R.drawable.background_orange);
        } else {
            setDayColors(dayView, calendarProperties.getDaysLabelsColor(), Typeface.NORMAL,
                    R.drawable.background_transparent);
        }
    }



}
