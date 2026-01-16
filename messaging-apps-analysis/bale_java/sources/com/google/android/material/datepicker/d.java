package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import ir.nasim.AbstractC23026wD5;
import ir.nasim.YC5;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes3.dex */
class d extends BaseAdapter {
    private static final int d;
    private final Calendar a;
    private final int b;
    private final int c;

    static {
        d = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public d() {
        Calendar calendarI = m.i();
        this.a = calendarI;
        this.b = calendarI.getMaximum(7);
        this.c = calendarI.getFirstDayOfWeek();
    }

    private int b(int i) {
        int i2 = i + this.c;
        int i3 = this.b;
        return i2 > i3 ? i2 - i3 : i2;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i) {
        if (i >= this.b) {
            return null;
        }
        return Integer.valueOf(b(i));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(YC5.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.a.set(7, b(i));
        textView.setText(this.a.getDisplayName(7, d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(AbstractC23026wD5.mtrl_picker_day_of_week_column_header), this.a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
