package ir.eitaa.ui.DatePicker.date;

import ir.eitaa.ui.DatePicker.date.DatePickerDialog;
import ir.eitaa.ui.DatePicker.date.MonthAdapter;
import ir.eitaa.ui.DatePicker.util.PersianCalendar;

/* loaded from: classes3.dex */
public interface DatePickerController {
    int getFirstDayOfWeek();

    PersianCalendar[] getHighlightedDays();

    PersianCalendar getMaxDate();

    int getMaxYear();

    PersianCalendar getMinDate();

    int getMinYear();

    PersianCalendar[] getSelectableDays();

    MonthAdapter.CalendarDay getSelectedDay();

    boolean isThemeDark();

    void onDayOfMonthSelected(int year, int month, int day);

    void onYearSelected(int year);

    void registerOnDateChangedListener(DatePickerDialog.OnDateChangedListener listener);
}
