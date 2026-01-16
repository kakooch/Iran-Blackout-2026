package ir.eitaa.ui.DatePicker.date;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.DatePicker.util.LanguageUtils;
import java.util.Locale;

/* loaded from: classes3.dex */
public class SimpleMonthView extends MonthView {
    DatePickerController controller;

    public SimpleMonthView(Context context, AttributeSet attr, DatePickerController controller) {
        super(context, attr, controller);
        this.controller = controller;
    }

    @Override // ir.eitaa.ui.DatePicker.date.MonthView
    public void drawMonthDay(Canvas canvas, int year, int month, int day, int x, int y, int startX, int stopX, int startY, int stopY) {
        if (this.mSelectedDay == day) {
            canvas.drawCircle(x, y - (MonthView.MINI_DAY_NUMBER_TEXT_SIZE / 3), MonthView.DAY_SELECTED_CIRCLE_SIZE, this.mSelectedCirclePaint);
        }
        if (isHighlighted(year, month, day)) {
            this.mMonthNumPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        } else {
            this.mMonthNumPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        }
        if (isOutOfRange(year, month, day)) {
            this.mMonthNumPaint.setColor(this.mDisabledDayTextColor);
        } else if (this.mSelectedDay == day) {
            this.mMonthNumPaint.setColor(this.mSelectedDayTextColor);
        } else if (this.mHasToday && this.mToday == day) {
            this.mMonthNumPaint.setColor(this.mTodayNumberColor);
        } else {
            this.mMonthNumPaint.setColor(isHighlighted(year, month, day) ? this.mHighlightedDayTextColor : this.mDayTextColor);
        }
        canvas.drawText(LanguageUtils.getPersianNumbers(String.format(Locale.getDefault(), "%d", Integer.valueOf(day))), x, y, this.mMonthNumPaint);
    }
}
