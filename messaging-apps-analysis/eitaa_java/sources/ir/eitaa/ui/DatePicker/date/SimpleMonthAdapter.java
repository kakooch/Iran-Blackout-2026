package ir.eitaa.ui.DatePicker.date;

import android.content.Context;

/* loaded from: classes3.dex */
public class SimpleMonthAdapter extends MonthAdapter {
    public SimpleMonthAdapter(Context context, DatePickerController controller) {
        super(context, controller);
    }

    @Override // ir.eitaa.ui.DatePicker.date.MonthAdapter
    public MonthView createMonthView(Context context) {
        return new SimpleMonthView(context, null, this.mController);
    }
}
