package ir.eitaa.ui.DatePicker.date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import ir.eitaa.ui.DatePicker.Utils;
import ir.eitaa.ui.DatePicker.date.DatePickerDialog;
import ir.eitaa.ui.DatePicker.date.MonthAdapter;
import ir.eitaa.ui.DatePicker.util.LanguageUtils;
import ir.eitaa.ui.DatePicker.util.PersianCalendar;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public abstract class DayPickerView extends ListView implements AbsListView.OnScrollListener, DatePickerDialog.OnDateChangedListener {
    public static int LIST_TOP_OFFSET = -1;
    protected MonthAdapter mAdapter;
    protected Context mContext;
    private DatePickerController mController;
    protected int mCurrentMonthDisplayed;
    protected int mCurrentScrollState;
    protected int mDaysPerWeek;
    protected float mFriction;
    protected Handler mHandler;
    protected int mNumWeeks;
    private boolean mPerformingScroll;
    protected long mPreviousScrollPosition;
    protected int mPreviousScrollState;
    protected ScrollStateRunnable mScrollStateChangedRunnable;
    protected MonthAdapter.CalendarDay mSelectedDay;
    protected boolean mShowWeekNumber;
    protected MonthAdapter.CalendarDay mTempDay;

    public abstract MonthAdapter createMonthAdapter(Context context, DatePickerController controller);

    public DayPickerView(Context context, DatePickerController controller) {
        super(context);
        this.mNumWeeks = 6;
        this.mShowWeekNumber = false;
        this.mDaysPerWeek = 7;
        this.mFriction = 1.0f;
        this.mSelectedDay = new MonthAdapter.CalendarDay();
        this.mTempDay = new MonthAdapter.CalendarDay();
        this.mPreviousScrollState = 0;
        this.mCurrentScrollState = 0;
        this.mScrollStateChangedRunnable = new ScrollStateRunnable();
        init(context);
        setController(controller);
    }

    public void setController(DatePickerController controller) {
        this.mController = controller;
        controller.registerOnDateChangedListener(this);
        refreshAdapter();
        onDateChanged();
    }

    public void init(Context context) {
        this.mHandler = new Handler();
        setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        setDrawSelectorOnTop(false);
        this.mContext = context;
        setUpListView();
    }

    public void onChange() {
        refreshAdapter();
    }

    protected void refreshAdapter() {
        MonthAdapter monthAdapter = this.mAdapter;
        if (monthAdapter == null) {
            this.mAdapter = createMonthAdapter(getContext(), this.mController);
        } else {
            monthAdapter.setSelectedDay(this.mSelectedDay);
        }
        setAdapter((ListAdapter) this.mAdapter);
    }

    protected void setUpListView() {
        setCacheColorHint(0);
        setDivider(null);
        setItemsCanFocus(true);
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnScrollListener(this);
        setFadingEdgeLength(0);
        setFriction(ViewConfiguration.getScrollFriction() * this.mFriction);
    }

    public boolean goTo(MonthAdapter.CalendarDay day, boolean animate, boolean setSelected, boolean forceScroll) {
        View childAt;
        if (setSelected) {
            this.mSelectedDay.set(day);
        }
        this.mTempDay.set(day);
        int minYear = ((day.year - this.mController.getMinYear()) * 12) + day.month;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            childAt = getChildAt(i);
            if (childAt == null) {
                break;
            }
            int top = childAt.getTop();
            if (Log.isLoggable("MonthFragment", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("child at ");
                sb.append(i2 - 1);
                sb.append(" has top ");
                sb.append(top);
                Log.d("MonthFragment", sb.toString());
            }
            if (top >= 0) {
                break;
            }
            i = i2;
        }
        int positionForView = childAt != null ? getPositionForView(childAt) : 0;
        if (setSelected) {
            this.mAdapter.setSelectedDay(this.mSelectedDay);
        }
        if (Log.isLoggable("MonthFragment", 3)) {
            Log.d("MonthFragment", "GoTo position " + minYear);
        }
        if (minYear != positionForView || forceScroll) {
            setMonthDisplayed(this.mTempDay);
            this.mPreviousScrollState = 2;
            if (animate) {
                smoothScrollToPositionFromTop(minYear, LIST_TOP_OFFSET, 250);
                return true;
            }
            postSetSelection(minYear);
        } else if (setSelected) {
            setMonthDisplayed(this.mSelectedDay);
        }
        return false;
    }

    public void postSetSelection(final int position) {
        clearFocus();
        post(new Runnable() { // from class: ir.eitaa.ui.DatePicker.date.DayPickerView.1
            @Override // java.lang.Runnable
            public void run() {
                DayPickerView.this.setSelection(position);
            }
        });
        onScrollStateChanged(this, 0);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (((MonthView) view.getChildAt(0)) == null) {
            return;
        }
        this.mPreviousScrollPosition = (view.getFirstVisiblePosition() * r2.getHeight()) - r2.getBottom();
        this.mPreviousScrollState = this.mCurrentScrollState;
    }

    protected void setMonthDisplayed(MonthAdapter.CalendarDay date) {
        this.mCurrentMonthDisplayed = date.month;
        invalidateViews();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        this.mScrollStateChangedRunnable.doScrollStateChange(view, scrollState);
    }

    protected class ScrollStateRunnable implements Runnable {
        private int mNewState;

        protected ScrollStateRunnable() {
        }

        public void doScrollStateChange(AbsListView view, int scrollState) {
            DayPickerView.this.mHandler.removeCallbacks(this);
            this.mNewState = scrollState;
            DayPickerView.this.mHandler.postDelayed(this, 40L);
        }

        @Override // java.lang.Runnable
        public void run() {
            DayPickerView dayPickerView;
            int i;
            DayPickerView.this.mCurrentScrollState = this.mNewState;
            if (Log.isLoggable("MonthFragment", 3)) {
                Log.d("MonthFragment", "new scroll state: " + this.mNewState + " old state: " + DayPickerView.this.mPreviousScrollState);
            }
            int i2 = this.mNewState;
            if (i2 == 0 && (i = (dayPickerView = DayPickerView.this).mPreviousScrollState) != 0) {
                if (i != 1) {
                    dayPickerView.mPreviousScrollState = i2;
                    View childAt = dayPickerView.getChildAt(0);
                    int i3 = 0;
                    while (childAt != null && childAt.getBottom() <= 0) {
                        i3++;
                        childAt = DayPickerView.this.getChildAt(i3);
                    }
                    if (childAt == null) {
                        return;
                    }
                    boolean z = (DayPickerView.this.getFirstVisiblePosition() == 0 || DayPickerView.this.getLastVisiblePosition() == DayPickerView.this.getCount() - 1) ? false : true;
                    int top = childAt.getTop();
                    int bottom = childAt.getBottom();
                    int height = DayPickerView.this.getHeight() / 2;
                    if (!z || top >= DayPickerView.LIST_TOP_OFFSET) {
                        return;
                    }
                    if (bottom > height) {
                        DayPickerView.this.smoothScrollBy(top, 250);
                        return;
                    } else {
                        DayPickerView.this.smoothScrollBy(bottom, 250);
                        return;
                    }
                }
            }
            DayPickerView.this.mPreviousScrollState = i2;
        }
    }

    public int getMostVisiblePosition() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int height = getHeight();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < height) {
            View childAt = getChildAt(i2);
            if (childAt == null) {
                break;
            }
            int bottom = childAt.getBottom();
            int iMin = Math.min(bottom, height) - Math.max(0, childAt.getTop());
            if (iMin > i3) {
                i4 = i2;
                i3 = iMin;
            }
            i2++;
            i = bottom;
        }
        return firstVisiblePosition + i4;
    }

    @Override // ir.eitaa.ui.DatePicker.date.DatePickerDialog.OnDateChangedListener
    public void onDateChanged() {
        goTo(this.mController.getSelectedDay(), false, true, true);
    }

    private MonthAdapter.CalendarDay findAccessibilityFocus() {
        MonthView monthView;
        MonthAdapter.CalendarDay accessibilityFocus;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof MonthView) && (accessibilityFocus = (monthView = (MonthView) childAt).getAccessibilityFocus()) != null) {
                if (Build.VERSION.SDK_INT == 17) {
                    monthView.clearAccessibilityFocus();
                }
                return accessibilityFocus;
            }
        }
        return null;
    }

    private boolean restoreAccessibilityFocus(MonthAdapter.CalendarDay day) {
        if (day == null) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof MonthView) && ((MonthView) childAt).restoreAccessibilityFocus(day)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        MonthAdapter.CalendarDay calendarDayFindAccessibilityFocus = findAccessibilityFocus();
        super.layoutChildren();
        if (this.mPerformingScroll) {
            this.mPerformingScroll = false;
        } else {
            restoreAccessibilityFocus(calendarDayFindAccessibilityFocus);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setItemCount(-1);
    }

    private static String getMonthAndYearString(MonthAdapter.CalendarDay day) {
        PersianCalendar persianCalendar = new PersianCalendar();
        persianCalendar.setPersianDate(day.year, day.month, day.day);
        return (("" + persianCalendar.getPersianMonthName()) + " ") + persianCalendar.getPersianYear();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        if (Build.VERSION.SDK_INT >= 21) {
            info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        } else {
            info.addAction(Factory.DEVICE_HAS_CRAPPY_AAUDIO);
            info.addAction(8192);
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public boolean performAccessibilityAction(int action, Bundle arguments) {
        View childAt;
        if (action != 4096 && action != 8192) {
            return super.performAccessibilityAction(action, arguments);
        }
        int firstVisiblePosition = getFirstVisiblePosition();
        MonthAdapter.CalendarDay calendarDay = new MonthAdapter.CalendarDay((firstVisiblePosition / 12) + this.mController.getMinYear(), firstVisiblePosition % 12, 1);
        if (action == 4096) {
            int i = calendarDay.month + 1;
            calendarDay.month = i;
            if (i == 12) {
                calendarDay.month = 0;
                calendarDay.year++;
            }
        } else if (action == 8192 && (childAt = getChildAt(0)) != null && childAt.getTop() >= -1) {
            int i2 = calendarDay.month - 1;
            calendarDay.month = i2;
            if (i2 == -1) {
                calendarDay.month = 11;
                calendarDay.year--;
            }
        }
        Utils.tryAccessibilityAnnounce(this, LanguageUtils.getPersianNumbers(getMonthAndYearString(calendarDay)));
        goTo(calendarDay, true, false, true);
        this.mPerformingScroll = true;
        return true;
    }
}
