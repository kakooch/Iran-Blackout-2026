package ir.eitaa.ui.DatePicker.date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import ir.eitaa.ui.DatePicker.date.MonthView;
import ir.eitaa.ui.DatePicker.util.PersianCalendar;
import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class MonthAdapter extends BaseAdapter implements MonthView.OnDayClickListener {
    private final Context mContext;
    protected final DatePickerController mController;
    private CalendarDay mSelectedDay;

    public abstract MonthView createMonthView(Context context);

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public static class CalendarDay {
        int day;
        private PersianCalendar mPersianCalendar;
        int month;
        int year;

        public CalendarDay() {
            setTime(System.currentTimeMillis());
        }

        public CalendarDay(long timeInMillis) {
            setTime(timeInMillis);
        }

        public CalendarDay(PersianCalendar calendar) {
            this.year = calendar.getPersianYear();
            this.month = calendar.getPersianMonth();
            this.day = calendar.getPersianDay();
        }

        public CalendarDay(int year, int month, int day) {
            setDay(year, month, day);
        }

        public void set(CalendarDay date) {
            this.year = date.year;
            this.month = date.month;
            this.day = date.day;
        }

        public void setDay(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        private void setTime(long timeInMillis) {
            if (this.mPersianCalendar == null) {
                this.mPersianCalendar = new PersianCalendar();
            }
            this.mPersianCalendar.setTimeInMillis(timeInMillis);
            this.month = this.mPersianCalendar.getPersianMonth();
            this.year = this.mPersianCalendar.getPersianYear();
            this.day = this.mPersianCalendar.getPersianDay();
        }
    }

    public MonthAdapter(Context context, DatePickerController controller) {
        this.mContext = context;
        this.mController = controller;
        init();
        setSelectedDay(controller.getSelectedDay());
    }

    public void setSelectedDay(CalendarDay day) {
        this.mSelectedDay = day;
        notifyDataSetChanged();
    }

    protected void init() {
        this.mSelectedDay = new CalendarDay(System.currentTimeMillis());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ((this.mController.getMaxYear() - this.mController.getMinYear()) + 1) * 12;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"NewApi"})
    public View getView(int position, View convertView, ViewGroup parent) {
        MonthView monthViewCreateMonthView;
        HashMap<String, Integer> map;
        if (convertView != null) {
            monthViewCreateMonthView = (MonthView) convertView;
            map = (HashMap) monthViewCreateMonthView.getTag();
        } else {
            monthViewCreateMonthView = createMonthView(this.mContext);
            monthViewCreateMonthView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            monthViewCreateMonthView.setClickable(true);
            monthViewCreateMonthView.setOnDayClickListener(this);
            map = null;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.clear();
        int i = position % 12;
        int minYear = (position / 12) + this.mController.getMinYear();
        int i2 = isSelectedDayInMonth(minYear, i) ? this.mSelectedDay.day : -1;
        monthViewCreateMonthView.reuse();
        map.put("selected_day", Integer.valueOf(i2));
        map.put("year", Integer.valueOf(minYear));
        map.put("month", Integer.valueOf(i));
        map.put("week_start", Integer.valueOf(this.mController.getFirstDayOfWeek()));
        monthViewCreateMonthView.setMonthParams(map);
        monthViewCreateMonthView.invalidate();
        return monthViewCreateMonthView;
    }

    private boolean isSelectedDayInMonth(int year, int month) {
        CalendarDay calendarDay = this.mSelectedDay;
        return calendarDay.year == year && calendarDay.month == month;
    }

    @Override // ir.eitaa.ui.DatePicker.date.MonthView.OnDayClickListener
    public void onDayClick(MonthView view, CalendarDay day) {
        if (day != null) {
            onDayTapped(day);
        }
    }

    protected void onDayTapped(CalendarDay day) {
        this.mController.onDayOfMonthSelected(day.year, day.month, day.day);
        setSelectedDay(day);
    }
}
