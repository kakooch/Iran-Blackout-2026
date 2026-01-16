package ir.hamsaa.persiandatepicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;
import ir.hamsaa.persiandatepicker.util.PersianCalendarConstants;
import ir.hamsaa.persiandatepicker.util.PersianCalendarUtils;
import ir.hamsaa.persiandatepicker.util.PersianHelper;
import ir.hamsaa.persiandatepicker.view.PersianNumberPicker;
import java.lang.reflect.Field;
import java.util.Date;

/* loaded from: classes3.dex */
class PersianDatePicker extends LinearLayout {
    NumberPicker.OnValueChangeListener dateChangeListener;
    private PersianNumberPicker dayNumberPicker;
    private TextView descriptionTextView;
    private boolean displayDescription;
    private boolean displayMonthNames;
    private int dividerColor;
    private OnDateChangedListener mListener;
    private int maxYear;
    private int minYear;
    private PersianNumberPicker monthNumberPicker;
    private final PersianCalendar pCalendar;
    private int selectedDay;
    private int selectedMonth;
    private int selectedYear;
    private Typeface typeFace;
    private PersianNumberPicker yearNumberPicker;
    private int yearRange;

    public interface OnDateChangedListener {
        void onDateChanged(int i, int i2, int i3);
    }

    public PersianDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    private void updateVariablesFromXml(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PersianDatePicker, 0, 0);
        this.yearRange = typedArrayObtainStyledAttributes.getInteger(R$styleable.PersianDatePicker_yearRange, 10);
        this.minYear = typedArrayObtainStyledAttributes.getInt(R$styleable.PersianDatePicker_minYear, this.pCalendar.getPersianYear() - this.yearRange);
        this.maxYear = typedArrayObtainStyledAttributes.getInt(R$styleable.PersianDatePicker_maxYear, this.pCalendar.getPersianYear() + this.yearRange);
        this.displayMonthNames = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PersianDatePicker_displayMonthNames, false);
        this.displayDescription = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PersianDatePicker_displayDescription, false);
        this.selectedDay = typedArrayObtainStyledAttributes.getInteger(R$styleable.PersianDatePicker_selectedDay, this.pCalendar.getPersianDay());
        this.selectedYear = typedArrayObtainStyledAttributes.getInt(R$styleable.PersianDatePicker_selectedYear, this.pCalendar.getPersianYear());
        this.selectedMonth = typedArrayObtainStyledAttributes.getInteger(R$styleable.PersianDatePicker_selectedMonth, this.pCalendar.getPersianMonth());
        int i = this.minYear;
        int i2 = this.selectedYear;
        if (i > i2) {
            this.minYear = i2 - this.yearRange;
        }
        if (this.maxYear < i2) {
            this.maxYear = i2 + this.yearRange;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public PersianDatePicker(Context context, AttributeSet attributeSet, int i) throws IllegalAccessException, IllegalArgumentException {
        super(context, attributeSet, i);
        this.dateChangeListener = new NumberPicker.OnValueChangeListener() { // from class: ir.hamsaa.persiandatepicker.PersianDatePicker.4
            @Override // android.widget.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i2, int i3) {
                boolean zIsPersianLeapYear = PersianCalendarUtils.isPersianLeapYear(PersianDatePicker.this.yearNumberPicker.getValue());
                int value = PersianDatePicker.this.monthNumberPicker.getValue();
                int value2 = PersianDatePicker.this.dayNumberPicker.getValue();
                if (value < 7) {
                    PersianDatePicker.this.dayNumberPicker.setMinValue(1);
                    PersianDatePicker.this.dayNumberPicker.setMaxValue(31);
                } else if (value < 12) {
                    if (value2 == 31) {
                        PersianDatePicker.this.dayNumberPicker.setValue(30);
                    }
                    PersianDatePicker.this.dayNumberPicker.setMinValue(1);
                    PersianDatePicker.this.dayNumberPicker.setMaxValue(30);
                } else if (value == 12) {
                    if (zIsPersianLeapYear) {
                        if (value2 == 31) {
                            PersianDatePicker.this.dayNumberPicker.setValue(30);
                        }
                        PersianDatePicker.this.dayNumberPicker.setMinValue(1);
                        PersianDatePicker.this.dayNumberPicker.setMaxValue(30);
                    } else {
                        if (value2 > 29) {
                            PersianDatePicker.this.dayNumberPicker.setValue(29);
                        }
                        PersianDatePicker.this.dayNumberPicker.setMinValue(1);
                        PersianDatePicker.this.dayNumberPicker.setMaxValue(29);
                    }
                }
                if (PersianDatePicker.this.displayDescription) {
                    PersianDatePicker.this.descriptionTextView.setText(PersianDatePicker.this.getDisplayPersianDate().getPersianLongDate());
                }
                if (PersianDatePicker.this.mListener != null) {
                    PersianDatePicker.this.mListener.onDateChanged(PersianDatePicker.this.yearNumberPicker.getValue(), PersianDatePicker.this.monthNumberPicker.getValue(), PersianDatePicker.this.dayNumberPicker.getValue());
                }
            }
        };
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.sl_persian_date_picker, this);
        this.yearNumberPicker = (PersianNumberPicker) viewInflate.findViewById(R$id.yearNumberPicker);
        this.monthNumberPicker = (PersianNumberPicker) viewInflate.findViewById(R$id.monthNumberPicker);
        this.dayNumberPicker = (PersianNumberPicker) viewInflate.findViewById(R$id.dayNumberPicker);
        this.descriptionTextView = (TextView) viewInflate.findViewById(R$id.descriptionTextView);
        this.yearNumberPicker.setFormatter(new NumberPicker.Formatter(this) { // from class: ir.hamsaa.persiandatepicker.PersianDatePicker.1
            @Override // android.widget.NumberPicker.Formatter
            public String format(int i2) {
                return PersianHelper.toPersianNumber(i2 + BuildConfig.FLAVOR);
            }
        });
        this.monthNumberPicker.setFormatter(new NumberPicker.Formatter(this) { // from class: ir.hamsaa.persiandatepicker.PersianDatePicker.2
            @Override // android.widget.NumberPicker.Formatter
            public String format(int i2) {
                return PersianHelper.toPersianNumber(i2 + BuildConfig.FLAVOR);
            }
        });
        this.dayNumberPicker.setFormatter(new NumberPicker.Formatter(this) { // from class: ir.hamsaa.persiandatepicker.PersianDatePicker.3
            @Override // android.widget.NumberPicker.Formatter
            public String format(int i2) {
                return PersianHelper.toPersianNumber(i2 + BuildConfig.FLAVOR);
            }
        });
        this.pCalendar = new PersianCalendar();
        updateVariablesFromXml(context, attributeSet);
        updateViewData();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.yearNumberPicker.setBackgroundColor(i);
        this.monthNumberPicker.setBackgroundColor(i);
        this.dayNumberPicker.setBackgroundColor(i);
    }

    private void setDividerColor(NumberPicker numberPicker, int i) throws IllegalAccessException, IllegalArgumentException {
        for (Field field : NumberPicker.class.getDeclaredFields()) {
            if (field.getName().equals("mSelectionDivider")) {
                field.setAccessible(true);
                try {
                    field.set(numberPicker, new ColorDrawable(i));
                    return;
                } catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                    return;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    return;
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
        }
    }

    private void updateViewData() throws IllegalAccessException, IllegalArgumentException {
        Typeface typeface = this.typeFace;
        if (typeface != null) {
            this.yearNumberPicker.setTypeFace(typeface);
            this.monthNumberPicker.setTypeFace(this.typeFace);
            this.dayNumberPicker.setTypeFace(this.typeFace);
        }
        int i = this.dividerColor;
        if (i > 0) {
            setDividerColor(this.yearNumberPicker, i);
            setDividerColor(this.monthNumberPicker, this.dividerColor);
            setDividerColor(this.dayNumberPicker, this.dividerColor);
        }
        this.yearNumberPicker.setMinValue(this.minYear);
        this.yearNumberPicker.setMaxValue(this.maxYear);
        int i2 = this.selectedYear;
        int i3 = this.maxYear;
        if (i2 > i3) {
            this.selectedYear = i3;
        }
        int i4 = this.selectedYear;
        int i5 = this.minYear;
        if (i4 < i5) {
            this.selectedYear = i5;
        }
        this.yearNumberPicker.setValue(this.selectedYear);
        this.yearNumberPicker.setOnValueChangedListener(this.dateChangeListener);
        this.monthNumberPicker.setMinValue(1);
        this.monthNumberPicker.setMaxValue(12);
        if (this.displayMonthNames) {
            this.monthNumberPicker.setDisplayedValues(PersianCalendarConstants.persianMonthNames);
        }
        int i6 = this.selectedMonth;
        if (i6 < 1 || i6 > 12) {
            throw new IllegalArgumentException(String.format("Selected month (%d) must be between 1 and 12", Integer.valueOf(this.selectedMonth)));
        }
        this.monthNumberPicker.setValue(i6);
        this.monthNumberPicker.setOnValueChangedListener(this.dateChangeListener);
        this.dayNumberPicker.setMinValue(1);
        this.dayNumberPicker.setMaxValue(31);
        int i7 = this.selectedDay;
        if (i7 > 31 || i7 < 1) {
            throw new IllegalArgumentException(String.format("Selected day (%d) must be between 1 and 31", Integer.valueOf(this.selectedDay)));
        }
        int i8 = this.selectedMonth;
        if (i8 > 6 && i8 < 12 && i7 == 31) {
            this.selectedDay = 30;
        } else if (PersianCalendarUtils.isPersianLeapYear(this.selectedYear) && this.selectedDay == 31) {
            this.selectedDay = 30;
        } else if (this.selectedDay > 29) {
            this.selectedDay = 29;
        }
        this.dayNumberPicker.setValue(this.selectedDay);
        this.dayNumberPicker.setOnValueChangedListener(this.dateChangeListener);
        if (this.displayDescription) {
            this.descriptionTextView.setVisibility(0);
            this.descriptionTextView.setText(getDisplayPersianDate().getPersianLongDate());
        }
    }

    public Date getDisplayDate() {
        PersianCalendar persianCalendar = new PersianCalendar();
        persianCalendar.setPersianDate(this.yearNumberPicker.getValue(), this.monthNumberPicker.getValue(), this.dayNumberPicker.getValue());
        return persianCalendar.getTime();
    }

    public void setDisplayDate(Date date) {
        setDisplayPersianDate(new PersianCalendar(date.getTime()));
    }

    public PersianCalendar getDisplayPersianDate() {
        PersianCalendar persianCalendar = new PersianCalendar();
        persianCalendar.setPersianDate(this.yearNumberPicker.getValue(), this.monthNumberPicker.getValue(), this.dayNumberPicker.getValue());
        return persianCalendar;
    }

    public void setDisplayPersianDate(PersianCalendar persianCalendar) {
        int persianYear = persianCalendar.getPersianYear();
        int persianMonth = persianCalendar.getPersianMonth();
        int persianDay = persianCalendar.getPersianDay();
        if ((persianMonth > 6 && persianMonth < 12 && persianDay == 31) || (PersianCalendarUtils.isPersianLeapYear(persianYear) && persianDay == 31)) {
            persianDay = 30;
        } else if (persianDay > 29) {
            persianDay = 29;
        }
        this.selectedYear = persianYear;
        this.selectedMonth = persianMonth;
        this.selectedDay = persianDay;
        if (this.minYear > persianYear) {
            int i = persianYear - this.yearRange;
            this.minYear = i;
            this.yearNumberPicker.setMinValue(i);
        }
        int i2 = this.maxYear;
        int i3 = this.selectedYear;
        if (i2 < i3) {
            int i4 = i3 + this.yearRange;
            this.maxYear = i4;
            this.yearNumberPicker.setMaxValue(i4);
        }
        this.yearNumberPicker.setValue(persianYear);
        this.monthNumberPicker.setValue(persianMonth);
        this.dayNumberPicker.setValue(persianDay);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.datetime = getDisplayDate().getTime();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setDisplayDate(new Date(savedState.datetime));
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: ir.hamsaa.persiandatepicker.PersianDatePicker.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        long datetime;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.datetime = parcel.readLong();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.datetime);
        }
    }
}
