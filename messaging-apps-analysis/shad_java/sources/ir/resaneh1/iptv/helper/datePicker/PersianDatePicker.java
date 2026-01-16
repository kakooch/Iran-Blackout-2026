package ir.resaneh1.iptv.helper.datePicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.NumberUtils;
import java.util.Date;

/* loaded from: classes3.dex */
public class PersianDatePicker extends LinearLayout {
    NumberPicker.OnValueChangeListener dateChangeListener;
    private NumberPicker dayNumberPicker;
    private TextView descriptionTextView;
    private boolean displayDescription;
    private OnDateChangedListener mListener;
    private int maxYear;
    private int minYear;
    private NumberPicker monthNumberPicker;
    private NumberPicker yearNumberPicker;
    private int yearRange;

    public interface OnDateChangedListener {
        void onDateChanged(int i, int i2, int i3);
    }

    public PersianDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public PersianDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dateChangeListener = new NumberPicker.OnValueChangeListener() { // from class: ir.resaneh1.iptv.helper.datePicker.PersianDatePicker.1
            @Override // android.widget.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i2, int i3) {
                boolean zIsPersianLeapYear = PersianCalendarUtils.isPersianLeapYear(PersianDatePicker.this.yearNumberPicker.getValue());
                int value = PersianDatePicker.this.monthNumberPicker.getValue();
                int value2 = PersianDatePicker.this.dayNumberPicker.getValue();
                if (value < 7) {
                    PersianDatePicker.this.dayNumberPicker.setMinValue(1);
                    PersianDatePicker.this.dayNumberPicker.setMaxValue(31);
                } else if (value > 6 && value < 12) {
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
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.my_sl_persian_date_picker, this);
        this.yearNumberPicker = (NumberPicker) viewInflate.findViewById(R.id.yearNumberPicker);
        this.monthNumberPicker = (NumberPicker) viewInflate.findViewById(R.id.monthNumberPicker);
        this.dayNumberPicker = (NumberPicker) viewInflate.findViewById(R.id.dayNumberPicker);
        this.descriptionTextView = (TextView) viewInflate.findViewById(R.id.descriptionTextView);
        setPersianFormatter(this.yearNumberPicker);
        setPersianFormatter(this.monthNumberPicker);
        setPersianFormatter(this.dayNumberPicker);
        PersianCalendar persianCalendar = new PersianCalendar();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, org.rbmain.messenger.R.styleable.PersianDatePicker, 0, 0);
        this.yearRange = typedArrayObtainStyledAttributes.getInteger(7, 100);
        this.minYear = typedArrayObtainStyledAttributes.getInt(3, persianCalendar.getPersianYear() - this.yearRange);
        this.maxYear = typedArrayObtainStyledAttributes.getInt(2, persianCalendar.getPersianYear() + this.yearRange);
        this.yearNumberPicker.setMinValue(this.minYear);
        this.yearNumberPicker.setMaxValue(this.maxYear);
        int i2 = typedArrayObtainStyledAttributes.getInt(6, persianCalendar.getPersianYear());
        if (i2 > this.maxYear || i2 < this.minYear) {
            throw new IllegalArgumentException(String.format("Selected year (%d) must be between minYear(%d) and maxYear(%d)", Integer.valueOf(i2), Integer.valueOf(this.minYear), Integer.valueOf(this.maxYear)));
        }
        this.yearNumberPicker.setValue(i2);
        this.yearNumberPicker.setOnValueChangedListener(this.dateChangeListener);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.monthNumberPicker.setMinValue(1);
        this.monthNumberPicker.setMaxValue(12);
        if (z) {
            this.monthNumberPicker.setDisplayedValues(PersianCalendarConstants.persianMonthNames);
        }
        int integer = typedArrayObtainStyledAttributes.getInteger(5, persianCalendar.getPersianMonth());
        if (integer < 1 || integer > 12) {
            throw new IllegalArgumentException(String.format("Selected month (%d) must be between 1 and 12", Integer.valueOf(integer)));
        }
        this.monthNumberPicker.setValue(integer);
        this.monthNumberPicker.setOnValueChangedListener(this.dateChangeListener);
        this.dayNumberPicker.setMinValue(1);
        this.dayNumberPicker.setMaxValue(31);
        int integer2 = typedArrayObtainStyledAttributes.getInteger(4, persianCalendar.getPersianDay());
        if (integer2 > 31 || integer2 < 1) {
            throw new IllegalArgumentException(String.format("Selected day (%d) must be between 1 and 31", Integer.valueOf(integer2)));
        }
        if ((integer > 6 && integer < 12 && integer2 == 31) || (PersianCalendarUtils.isPersianLeapYear(i2) && integer2 == 31)) {
            integer2 = 30;
        } else if (integer2 > 29) {
            integer2 = 29;
        }
        this.dayNumberPicker.setValue(integer2);
        this.dayNumberPicker.setOnValueChangedListener(this.dateChangeListener);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.displayDescription = z2;
        if (z2) {
            this.descriptionTextView.setVisibility(0);
            this.descriptionTextView.setText(getDisplayPersianDate().getPersianLongDate());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setPersianFormatter(NumberPicker numberPicker) {
        numberPicker.setFormatter(new NumberPicker.Formatter(this) { // from class: ir.resaneh1.iptv.helper.datePicker.PersianDatePicker.2
            @Override // android.widget.NumberPicker.Formatter
            public String format(int i) {
                return NumberUtils.toPersian(String.valueOf(i));
            }
        });
    }

    public void setOnDateChangedListener(OnDateChangedListener onDateChangedListener) {
        this.mListener = onDateChangedListener;
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
        this.dayNumberPicker.setValue(persianDay);
        int i = this.yearRange;
        int i2 = persianYear - i;
        this.minYear = i2;
        this.maxYear = i + persianYear;
        this.yearNumberPicker.setMinValue(i2);
        this.yearNumberPicker.setMaxValue(this.maxYear);
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
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: ir.resaneh1.iptv.helper.datePicker.PersianDatePicker.SavedState.1
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
