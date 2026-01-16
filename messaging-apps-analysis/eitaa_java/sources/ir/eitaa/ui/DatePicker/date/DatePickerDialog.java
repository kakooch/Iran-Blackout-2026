package ir.eitaa.ui.DatePicker.date;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.DatePicker.AccessibleLinearLayout;
import ir.eitaa.ui.DatePicker.AccessibleTextView;
import ir.eitaa.ui.DatePicker.Utils;
import ir.eitaa.ui.DatePicker.date.MonthAdapter;
import ir.eitaa.ui.DatePicker.util.LanguageUtils;
import ir.eitaa.ui.DatePicker.util.PersianCalendar;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DatePickerDialog extends AlertDialog implements View.OnClickListener, DatePickerController {
    private TextView foreverButton;
    private PersianCalendar[] highlightedDays;
    private AccessibleDateAnimator mAnimator;
    private OnDateSetListener mCallBack;
    private int mCurrentView;
    private String mDayPickerDescription;
    private DayPickerView mDayPickerView;
    private boolean mDelayAnimation;
    private HashSet<OnDateChangedListener> mListeners;
    private PersianCalendar mMaxDate;
    private int mMaxYear;
    private PersianCalendar mMinDate;
    private int mMinYear;
    private LinearLayout mMonthAndDayView;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final PersianCalendar mPersianCalendar;
    private String mSelectDay;
    private String mSelectYear;
    private TextView mSelectedDayTextView;
    private TextView mSelectedMonthTextView;
    private boolean mThemeDark;
    private int mWeekStart;
    private String mYearPickerDescription;
    private YearPickerView mYearPickerView;
    private TextView mYearView;
    private PersianCalendar[] selectableDays;

    public interface OnDateChangedListener {
        void onDateChanged();
    }

    public interface OnDateSetListener {
        void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth);
    }

    private void adjustDayInMonthIfNeeded(int month, int year) {
    }

    public DatePickerDialog(Context context, OnDateSetListener listener, int year, int monthOfYear, int dayOfMonth) {
        super(context);
        this.mPersianCalendar = new PersianCalendar();
        this.mListeners = new HashSet<>();
        this.mCurrentView = -1;
        this.mWeekStart = 7;
        this.mMinYear = 1350;
        this.mMaxYear = 1450;
        this.mDelayAnimation = true;
        initialize(listener, year, monthOfYear, dayOfMonth);
    }

    public void initialize(OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        this.mCallBack = onDateSetListener;
        this.mPersianCalendar.setPersianDate(i, i2, i3);
        this.mThemeDark = false;
        Log.d("DatePickerDialog", "onCreateView: ");
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(LayoutHelper.createFrame(270, -1, 17));
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(Theme.getColor("chats_actionBackground"));
        linearLayout.addView(linearLayout2, LayoutHelper.createFrame(-1, 155.0f));
        AccessibleLinearLayout accessibleLinearLayout = new AccessibleLinearLayout(getContext(), null);
        this.mMonthAndDayView = accessibleLinearLayout;
        accessibleLinearLayout.setTag("date_picker_month_and_day");
        this.mMonthAndDayView.setClickable(true);
        this.mMonthAndDayView.setOrientation(1);
        linearLayout2.addView(this.mMonthAndDayView, LayoutHelper.createFrame(-1, -2, 17));
        TextView textView = new TextView(getContext());
        this.mSelectedMonthTextView = textView;
        textView.setDuplicateParentStateEnabled(true);
        this.mSelectedMonthTextView.setIncludeFontPadding(false);
        this.mSelectedMonthTextView.setTextColor(Theme.getColor("actionBarDefaultTitle"));
        this.mSelectedMonthTextView.setTextSize(25.0f);
        this.mSelectedMonthTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.mSelectedMonthTextView.setGravity(17);
        this.mMonthAndDayView.addView(this.mSelectedMonthTextView, LayoutHelper.createFrame(-1, -2, 81));
        TextView textView2 = new TextView(getContext());
        this.mSelectedDayTextView = textView2;
        textView2.setDuplicateParentStateEnabled(true);
        this.mSelectedDayTextView.setIncludeFontPadding(false);
        this.mSelectedDayTextView.setTextColor(Theme.getColor("actionBarDefaultTitle"));
        this.mSelectedDayTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.mSelectedDayTextView.setTextSize(70.0f);
        this.mSelectedDayTextView.setGravity(17);
        this.mMonthAndDayView.addView(this.mSelectedDayTextView, LayoutHelper.createFrame(-1, -2.0f, 17, 0.0f, -10.0f, 0.0f, -10.0f));
        AccessibleTextView accessibleTextView = new AccessibleTextView(getContext(), null);
        this.mYearView = accessibleTextView;
        accessibleTextView.setTag("date_picker_year");
        this.mYearView.setIncludeFontPadding(false);
        this.mYearView.setTextColor(Theme.getColor("actionBarDefaultTitle"));
        this.mYearView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.mYearView.setTextSize(25.0f);
        this.mYearView.setGravity(17);
        linearLayout2.addView(this.mYearView, LayoutHelper.createFrame(-1, -2, 49));
        AccessibleDateAnimator accessibleDateAnimator = new AccessibleDateAnimator(getContext(), null);
        this.mAnimator = accessibleDateAnimator;
        accessibleDateAnimator.setPadding(8, 0, 8, 0);
        linearLayout.addView(this.mAnimator, LayoutHelper.createFrame(-1, 252.0f));
        LinearLayout linearLayout3 = new LinearLayout(getContext());
        linearLayout3.setOrientation(0);
        linearLayout3.setPadding(16, 0, 16, 0);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 17) {
            linearLayout3.setLayoutDirection(LocaleController.isRTL ? 1 : 0);
        }
        linearLayout.addView(linearLayout3, LayoutHelper.createFrame(-1, 56.0f));
        TextView textView3 = new TextView(getContext());
        textView3.setText("بیخیال");
        textView3.setTypeface(AndroidUtilities.getFontFamily(false));
        textView3.setTextColor(Theme.getColor("chats_actionBackground"));
        textView3.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), 0, ColorUtils.setAlphaComponent(Theme.getColor("chats_actionBackground"), 70)));
        textView3.setPadding(32, 16, 32, 16);
        linearLayout3.addView(textView3, LayoutHelper.createFrame(-2, -2.0f, 8388613, 0.0f, 0.0f, 8.0f, 0.0f));
        TextView textView4 = new TextView(getContext());
        textView4.setText("تایید");
        textView4.setTypeface(AndroidUtilities.getFontFamily(false));
        textView4.setTextColor(Theme.getColor("chats_actionBackground"));
        textView4.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), 0, ColorUtils.setAlphaComponent(Theme.getColor("chats_actionBackground"), 70)));
        textView4.setPadding(32, 16, 32, 16);
        linearLayout3.addView(textView4, LayoutHelper.createFrame(-2, -2.0f, 8388613, 0.0f, 0.0f, 16.0f, 0.0f));
        TextView textView5 = new TextView(getContext());
        this.foreverButton = textView5;
        textView5.setText("همیشه");
        this.foreverButton.setTypeface(AndroidUtilities.getFontFamily(false));
        this.foreverButton.setTextColor(Theme.getColor("chats_actionBackground"));
        this.foreverButton.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), 0, ColorUtils.setAlphaComponent(Theme.getColor("chats_actionBackground"), 70)));
        this.foreverButton.setPadding(32, 16, 32, 16);
        this.foreverButton.setVisibility(4);
        linearLayout3.addView(this.foreverButton, LayoutHelper.createFrame(-2, -2.0f, 8388611, 16.0f, 0.0f, 16.0f, 0.0f));
        this.mMonthAndDayView.setOnClickListener(this);
        this.mYearView.setOnClickListener(this);
        if (i4 >= 26) {
            this.mSelectedDayTextView.setTypeface(Typeface.create(new Typeface.Builder(getContext().getApplicationContext().getAssets(), "fonts/iransans.ttf").build(), 0));
        }
        SimpleDayPickerView simpleDayPickerView = new SimpleDayPickerView(getContext(), this);
        this.mDayPickerView = simpleDayPickerView;
        simpleDayPickerView.setPadding(16, 0, 16, 0);
        this.mYearPickerView = new YearPickerView(getContext(), this);
        getContext().getResources();
        this.mDayPickerDescription = "روز های ماه";
        this.mSelectDay = "ماه و روز را انتخاب کنید";
        this.mYearPickerDescription = "لیست سال";
        this.mSelectYear = "سال را انتخاب کنید";
        linearLayout.setBackgroundColor(Theme.getColor("dialogBackground"));
        this.mAnimator.addView(this.mDayPickerView);
        this.mAnimator.addView(this.mYearPickerView);
        this.mAnimator.setDateMillis(this.mPersianCalendar.getTimeInMillis());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        this.mAnimator.setInAnimation(alphaAnimation);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(300L);
        this.mAnimator.setOutAnimation(alphaAnimation2);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.DatePicker.date.DatePickerDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DatePickerDialog.this.mCallBack != null) {
                    OnDateSetListener onDateSetListener2 = DatePickerDialog.this.mCallBack;
                    DatePickerDialog datePickerDialog = DatePickerDialog.this;
                    onDateSetListener2.onDateSet(datePickerDialog, datePickerDialog.mPersianCalendar.getPersianYear(), DatePickerDialog.this.mPersianCalendar.getPersianMonth(), DatePickerDialog.this.mPersianCalendar.getPersianDay());
                }
                DatePickerDialog.this.dismiss();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.DatePicker.date.DatePickerDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DatePickerDialog.this.cancel();
            }
        });
        textView3.setVisibility(0);
        updateDisplay(false);
        setCurrentView(0);
        setView(linearLayout);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.mPersianCalendar.setPersianDate(savedInstanceState.getInt("year"), savedInstanceState.getInt("month"), savedInstanceState.getInt("day"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [ir.eitaa.ui.DatePicker.util.PersianCalendar[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r1v17, types: [ir.eitaa.ui.DatePicker.util.PersianCalendar[], java.io.Serializable] */
    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        int mostVisiblePosition;
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.putInt("year", this.mPersianCalendar.getPersianYear());
        bundleOnSaveInstanceState.putInt("month", this.mPersianCalendar.getPersianMonth());
        bundleOnSaveInstanceState.putInt("day", this.mPersianCalendar.getPersianDay());
        bundleOnSaveInstanceState.putInt("week_start", this.mWeekStart);
        bundleOnSaveInstanceState.putInt("year_start", this.mMinYear);
        bundleOnSaveInstanceState.putInt("year_end", this.mMaxYear);
        bundleOnSaveInstanceState.putInt("current_view", this.mCurrentView);
        int i = this.mCurrentView;
        if (i == 0) {
            mostVisiblePosition = this.mDayPickerView.getMostVisiblePosition();
        } else if (i == 1) {
            mostVisiblePosition = 0;
            bundleOnSaveInstanceState.putInt("list_position_offset", this.mYearPickerView.getFirstPositionOffset());
        } else {
            mostVisiblePosition = -1;
        }
        bundleOnSaveInstanceState.putInt("list_position", mostVisiblePosition);
        bundleOnSaveInstanceState.putSerializable("min_date", this.mMinDate);
        bundleOnSaveInstanceState.putSerializable("max_date", this.mMaxDate);
        bundleOnSaveInstanceState.putSerializable("highlighted_days", this.highlightedDays);
        bundleOnSaveInstanceState.putSerializable("selectable_days", this.selectableDays);
        bundleOnSaveInstanceState.putBoolean("theme_dark", this.mThemeDark);
        return bundleOnSaveInstanceState;
    }

    private void setCurrentView(final int viewIndex) {
        if (viewIndex == 0) {
            ObjectAnimator pulseAnimator = Utils.getPulseAnimator(this.mMonthAndDayView, 0.9f, 1.05f);
            if (this.mDelayAnimation) {
                pulseAnimator.setStartDelay(500L);
                this.mDelayAnimation = false;
            }
            this.mDayPickerView.onDateChanged();
            if (this.mCurrentView != viewIndex) {
                this.mMonthAndDayView.setSelected(true);
                this.mYearView.setSelected(false);
                this.mAnimator.setDisplayedChild(0);
                this.mCurrentView = viewIndex;
            }
            pulseAnimator.start();
            String persianNumbers = LanguageUtils.getPersianNumbers(this.mPersianCalendar.getPersianLongDate());
            this.mAnimator.setContentDescription(this.mDayPickerDescription + ": " + persianNumbers);
            Utils.tryAccessibilityAnnounce(this.mAnimator, this.mSelectDay);
            return;
        }
        if (viewIndex != 1) {
            return;
        }
        ObjectAnimator pulseAnimator2 = Utils.getPulseAnimator(this.mYearView, 0.85f, 1.1f);
        if (this.mDelayAnimation) {
            pulseAnimator2.setStartDelay(500L);
            this.mDelayAnimation = false;
        }
        this.mYearPickerView.onDateChanged();
        if (this.mCurrentView != viewIndex) {
            this.mMonthAndDayView.setSelected(false);
            this.mYearView.setSelected(true);
            this.mAnimator.setDisplayedChild(1);
            this.mCurrentView = viewIndex;
        }
        pulseAnimator2.start();
        String persianNumbers2 = LanguageUtils.getPersianNumbers(String.valueOf(this.mPersianCalendar.getPersianYear()));
        this.mAnimator.setContentDescription(this.mYearPickerDescription + ": " + persianNumbers2);
        Utils.tryAccessibilityAnnounce(this.mAnimator, this.mSelectYear);
    }

    private void updateDisplay(boolean announce) {
        this.mSelectedMonthTextView.setText(LanguageUtils.getPersianNumbers(this.mPersianCalendar.getPersianMonthName()));
        this.mSelectedDayTextView.setText(LanguageUtils.getPersianNumbers(String.valueOf(this.mPersianCalendar.getPersianDay())));
        this.mYearView.setText(LanguageUtils.getPersianNumbers(String.valueOf(this.mPersianCalendar.getPersianYear())));
        this.mAnimator.setDateMillis(this.mPersianCalendar.getTimeInMillis());
        this.mMonthAndDayView.setContentDescription(LanguageUtils.getPersianNumbers(this.mPersianCalendar.getPersianMonthName() + " " + this.mPersianCalendar.getPersianDay()));
        if (announce) {
            Utils.tryAccessibilityAnnounce(this.mAnimator, LanguageUtils.getPersianNumbers(this.mPersianCalendar.getPersianLongDate()));
        }
    }

    @Override // ir.eitaa.ui.DatePicker.date.DatePickerController
    public boolean isThemeDark() {
        return this.mThemeDark;
    }

    public void setMinDate(PersianCalendar calendar) {
        this.mMinDate = calendar;
        DayPickerView dayPickerView = this.mDayPickerView;
        if (dayPickerView != null) {
            dayPickerView.onChange();
        }
    }

    @Override // ir.eitaa.ui.DatePicker.date.DatePickerController
    public PersianCalendar getMinDate() {
        return this.mMinDate;
    }

    public void setMaxDate(PersianCalendar calendar) {
        this.mMaxDate = calendar;
        DayPickerView dayPickerView = this.mDayPickerView;
        if (dayPickerView != null) {
            dayPickerView.onChange();
        }
    }

    @Override // ir.eitaa.ui.DatePicker.date.DatePickerController
    public PersianCalendar getMaxDate() {
        return this.mMaxDate;
    }

    @Override // ir.eitaa.ui.DatePicker.date.DatePickerController
    public PersianCalendar[] getHighlightedDays() {
        return this.highlightedDays;
    }

    @Override // ir.eitaa.ui.DatePicker.date.DatePickerController
    public PersianCalendar[] getSelectableDays() {
        return this.selectableDays;
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setForeverButton(View.OnClickListener onClickListener) {
        this.foreverButton.setOnClickListener(onClickListener);
        this.foreverButton.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getTag().toString().equals("date_picker_year")) {
            setCurrentView(1);
        } else if (v.getTag().toString().equals("date_picker_month_and_day")) {
            setCurrentView(0);
        }
    }

    @Override // ir.eitaa.ui.DatePicker.date.DatePickerController
    public void onYearSelected(int year) {
        adjustDayInMonthIfNeeded(this.mPersianCalendar.getPersianMonth(), year);
        PersianCalendar persianCalendar = this.mPersianCalendar;
        persianCalendar.setPersianDate(year, persianCalendar.getPersianMonth(), this.mPersianCalendar.getPersianDay());
        updatePickers();
        setCurrentView(0);
        updateDisplay(true);
    }

    @Override // ir.eitaa.ui.DatePicker.date.DatePickerController
    public void onDayOfMonthSelected(int year, int month, int day) {
        this.mPersianCalendar.setPersianDate(year, month, day);
        updatePickers();
        updateDisplay(true);
    }

    private void updatePickers() {
        Iterator<OnDateChangedListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onDateChanged();
        }
    }

    @Override // ir.eitaa.ui.DatePicker.date.DatePickerController
    public MonthAdapter.CalendarDay getSelectedDay() {
        return new MonthAdapter.CalendarDay(this.mPersianCalendar);
    }

    @Override // ir.eitaa.ui.DatePicker.date.DatePickerController
    public int getMinYear() {
        PersianCalendar[] persianCalendarArr = this.selectableDays;
        if (persianCalendarArr != null) {
            return persianCalendarArr[0].getPersianYear();
        }
        PersianCalendar persianCalendar = this.mMinDate;
        return (persianCalendar == null || persianCalendar.getPersianYear() <= this.mMinYear) ? this.mMinYear : this.mMinDate.getPersianYear();
    }

    @Override // ir.eitaa.ui.DatePicker.date.DatePickerController
    public int getMaxYear() {
        PersianCalendar[] persianCalendarArr = this.selectableDays;
        if (persianCalendarArr != null) {
            return persianCalendarArr[persianCalendarArr.length - 1].getPersianYear();
        }
        PersianCalendar persianCalendar = this.mMaxDate;
        return (persianCalendar == null || persianCalendar.getPersianYear() >= this.mMaxYear) ? this.mMaxYear : this.mMaxDate.getPersianYear();
    }

    @Override // ir.eitaa.ui.DatePicker.date.DatePickerController
    public int getFirstDayOfWeek() {
        return this.mWeekStart;
    }

    @Override // ir.eitaa.ui.DatePicker.date.DatePickerController
    public void registerOnDateChangedListener(OnDateChangedListener listener) {
        this.mListeners.add(listener);
    }

    public void goTo(PersianCalendar calendar) {
        this.mDayPickerView.goTo(new MonthAdapter.CalendarDay(calendar), false, true, true);
    }
}
