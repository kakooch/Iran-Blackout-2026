package com.tsongkha.spinnerdatepicker;

import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes3.dex */
public class DatePicker extends FrameLayout {
    private Calendar mCurrentDate;
    private NumberPicker mDaySpinner;
    private boolean mIsDayShown;
    private boolean mIsEnabled;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private NumberPicker mMonthSpinner;
    private EditText mMonthSpinnerInput;
    private int mNumberOfMonths;
    private String[] mShortMonths;
    private Calendar mTempDate;
    private NumberPicker mYearSpinner;

    /* renamed from: com.tsongkha.spinnerdatepicker.DatePicker$1, reason: invalid class name */
    class AnonymousClass1 implements NumberPicker.OnValueChangeListener {
    }

    int getYear() {
        return this.mCurrentDate.get(1);
    }

    int getMonth() {
        return this.mCurrentDate.get(2);
    }

    int getDayOfMonth() {
        return this.mCurrentDate.get(5);
    }

    void setMinDate(long j) {
        this.mTempDate.setTimeInMillis(j);
        if (this.mTempDate.get(1) == this.mMinDate.get(1) && this.mTempDate.get(6) == this.mMinDate.get(6)) {
            return;
        }
        this.mMinDate.setTimeInMillis(j);
        if (this.mCurrentDate.before(this.mMinDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
        }
        updateSpinners();
    }

    void setMaxDate(long j) {
        this.mTempDate.setTimeInMillis(j);
        if (this.mTempDate.get(1) == this.mMaxDate.get(1) && this.mTempDate.get(6) == this.mMaxDate.get(6)) {
            return;
        }
        this.mMaxDate.setTimeInMillis(j);
        if (this.mCurrentDate.after(this.mMaxDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
        }
        updateSpinners();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.mDaySpinner.setEnabled(z);
        this.mMonthSpinner.setEnabled(z);
        this.mYearSpinner.setEnabled(z);
        this.mIsEnabled = z;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        setCurrentLocale(configuration.locale);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    protected void setCurrentLocale(Locale locale) {
        this.mTempDate = getCalendarForLocale(this.mTempDate, locale);
        this.mMinDate = getCalendarForLocale(this.mMinDate, locale);
        this.mMaxDate = getCalendarForLocale(this.mMaxDate, locale);
        this.mCurrentDate = getCalendarForLocale(this.mCurrentDate, locale);
        this.mNumberOfMonths = this.mTempDate.getActualMaximum(2) + 1;
        this.mShortMonths = new DateFormatSymbols().getShortMonths();
        if (usingNumericMonths()) {
            this.mShortMonths = new String[this.mNumberOfMonths];
            int i = 0;
            while (i < this.mNumberOfMonths) {
                int i2 = i + 1;
                this.mShortMonths[i] = String.format("%d", Integer.valueOf(i2));
                i = i2;
            }
        }
    }

    private boolean usingNumericMonths() {
        return Character.isDigit(this.mShortMonths[0].charAt(0));
    }

    private Calendar getCalendarForLocale(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    private String getOrderJellyBeanMr2() {
        DateFormat mediumDateFormat;
        if (this.mShortMonths[0].startsWith("1")) {
            mediumDateFormat = android.text.format.DateFormat.getDateFormat(getContext());
        } else {
            mediumDateFormat = android.text.format.DateFormat.getMediumDateFormat(getContext());
        }
        if (mediumDateFormat instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) mediumDateFormat).toPattern();
        }
        return new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
    }

    private void updateSpinners() {
        this.mDaySpinner.setVisibility(this.mIsDayShown ? 0 : 8);
        if (this.mCurrentDate.equals(this.mMinDate)) {
            this.mDaySpinner.setMinValue(this.mCurrentDate.get(5));
            this.mDaySpinner.setMaxValue(this.mCurrentDate.getActualMaximum(5));
            this.mDaySpinner.setWrapSelectorWheel(false);
            this.mMonthSpinner.setDisplayedValues(null);
            this.mMonthSpinner.setMinValue(this.mCurrentDate.get(2));
            this.mMonthSpinner.setMaxValue(this.mCurrentDate.getActualMaximum(2));
            this.mMonthSpinner.setWrapSelectorWheel(false);
        } else if (this.mCurrentDate.equals(this.mMaxDate)) {
            this.mDaySpinner.setMinValue(this.mCurrentDate.getActualMinimum(5));
            this.mDaySpinner.setMaxValue(this.mCurrentDate.get(5));
            this.mDaySpinner.setWrapSelectorWheel(false);
            this.mMonthSpinner.setDisplayedValues(null);
            this.mMonthSpinner.setMinValue(this.mCurrentDate.getActualMinimum(2));
            this.mMonthSpinner.setMaxValue(this.mCurrentDate.get(2));
            this.mMonthSpinner.setWrapSelectorWheel(false);
        } else {
            this.mDaySpinner.setMinValue(1);
            this.mDaySpinner.setMaxValue(this.mCurrentDate.getActualMaximum(5));
            this.mDaySpinner.setWrapSelectorWheel(true);
            this.mMonthSpinner.setDisplayedValues(null);
            this.mMonthSpinner.setMinValue(0);
            this.mMonthSpinner.setMaxValue(11);
            this.mMonthSpinner.setWrapSelectorWheel(true);
        }
        this.mMonthSpinner.setDisplayedValues((String[]) Arrays.copyOfRange(this.mShortMonths, this.mMonthSpinner.getMinValue(), this.mMonthSpinner.getMaxValue() + 1));
        this.mYearSpinner.setMinValue(this.mMinDate.get(1));
        this.mYearSpinner.setMaxValue(this.mMaxDate.get(1));
        this.mYearSpinner.setWrapSelectorWheel(false);
        this.mYearSpinner.setValue(this.mCurrentDate.get(1));
        this.mMonthSpinner.setValue(this.mCurrentDate.get(2));
        this.mDaySpinner.setValue(this.mCurrentDate.get(5));
        if (usingNumericMonths()) {
            this.mMonthSpinnerInput.setRawInputType(2);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mCurrentDate, this.mMinDate, this.mMaxDate, this.mIsDayShown);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        Calendar calendar = Calendar.getInstance();
        this.mCurrentDate = calendar;
        calendar.setTimeInMillis(savedState.currentDate);
        Calendar calendar2 = Calendar.getInstance();
        this.mMinDate = calendar2;
        calendar2.setTimeInMillis(savedState.minDate);
        Calendar calendar3 = Calendar.getInstance();
        this.mMaxDate = calendar3;
        calendar3.setTimeInMillis(savedState.maxDate);
        updateSpinners();
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.tsongkha.spinnerdatepicker.DatePicker.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final long currentDate;
        final boolean isDaySpinnerShown;
        final long maxDate;
        final long minDate;

        /* synthetic */ SavedState(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        SavedState(Parcelable parcelable, Calendar calendar, Calendar calendar2, Calendar calendar3, boolean z) {
            super(parcelable);
            this.currentDate = calendar.getTimeInMillis();
            this.minDate = calendar2.getTimeInMillis();
            this.maxDate = calendar3.getTimeInMillis();
            this.isDaySpinnerShown = z;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentDate = parcel.readLong();
            this.minDate = parcel.readLong();
            this.maxDate = parcel.readLong();
            this.isDaySpinnerShown = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.currentDate);
            parcel.writeLong(this.minDate);
            parcel.writeLong(this.maxDate);
            parcel.writeByte(this.isDaySpinnerShown ? (byte) 1 : (byte) 0);
        }
    }
}
