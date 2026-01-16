package ir.eitaa.ui.DatePicker.date;

import android.content.Context;

/* loaded from: classes3.dex */
public class SimpleDayPickerView extends DayPickerView {
    public SimpleDayPickerView(Context context, DatePickerController controller) {
        super(context, controller);
    }

    @Override // ir.eitaa.ui.DatePicker.date.DayPickerView
    public MonthAdapter createMonthAdapter(Context context, DatePickerController controller) {
        return new SimpleMonthAdapter(context, controller);
    }
}
