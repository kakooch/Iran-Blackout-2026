package ir.eitaa.ui.DatePicker.date;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ViewAnimator;
import ir.eitaa.ui.DatePicker.util.LanguageUtils;
import ir.eitaa.ui.DatePicker.util.PersianCalendar;

/* loaded from: classes3.dex */
public class AccessibleDateAnimator extends ViewAnimator {
    private long mDateMillis;

    public AccessibleDateAnimator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setDateMillis(long dateMillis) {
        this.mDateMillis = dateMillis;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == 32) {
            event.getText().clear();
            PersianCalendar persianCalendar = new PersianCalendar();
            persianCalendar.setTimeInMillis(this.mDateMillis);
            event.getText().add(LanguageUtils.getPersianNumbers(persianCalendar.getPersianMonthName() + " " + persianCalendar.getPersianYear()));
            return true;
        }
        return super.dispatchPopulateAccessibilityEvent(event);
    }
}
