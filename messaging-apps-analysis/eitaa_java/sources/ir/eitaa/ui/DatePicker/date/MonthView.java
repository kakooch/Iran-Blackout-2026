package ir.eitaa.ui.DatePicker.date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.DatePicker.Utils;
import ir.eitaa.ui.DatePicker.date.MonthAdapter;
import ir.eitaa.ui.DatePicker.util.LanguageUtils;
import ir.eitaa.ui.DatePicker.util.PersianCalendar;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class MonthView extends View {
    protected static int DAY_SELECTED_CIRCLE_SIZE = 0;
    protected static int DAY_SEPARATOR_WIDTH = 1;
    protected static int DEFAULT_HEIGHT = 32;
    protected static int MINI_DAY_NUMBER_TEXT_SIZE = 0;
    protected static int MIN_HEIGHT = 10;
    protected static int MONTH_DAY_LABEL_TEXT_SIZE;
    protected static int MONTH_HEADER_SIZE;
    protected static int MONTH_LABEL_TEXT_SIZE;
    protected DatePickerController mController;
    protected final PersianCalendar mDayLabelCalendar;
    private int mDayOfWeekStart;
    protected int mDayTextColor;
    protected int mDisabledDayTextColor;
    protected int mEdgePadding;
    protected int mFirstJulianDay;
    protected int mFirstMonth;
    protected boolean mHasToday;
    protected int mHighlightedDayTextColor;
    protected int mLastMonth;
    private boolean mLockAccessibilityDelegate;
    protected int mMonth;
    protected TextPaint mMonthDayLabelPaint;
    protected int mMonthDayTextColor;
    protected TextPaint mMonthNumPaint;
    protected int mMonthTitleColor;
    protected TextPaint mMonthTitlePaint;
    protected int mNumCells;
    protected int mNumDays;
    protected int mNumRows;
    protected OnDayClickListener mOnDayClickListener;
    private final PersianCalendar mPersianCalendar;
    protected int mRowHeight;
    protected Paint mSelectedCirclePaint;
    protected int mSelectedDay;
    protected int mSelectedDayTextColor;
    protected int mSelectedLeft;
    protected int mSelectedRight;
    private final StringBuilder mStringBuilder;
    protected int mToday;
    protected int mTodayNumberColor;
    private final MonthViewTouchHelper mTouchHelper;
    protected int mWeekStart;
    protected int mWidth;
    protected int mYear;
    private float rightSpace;

    public interface OnDayClickListener {
        void onDayClick(MonthView view, MonthAdapter.CalendarDay day);
    }

    public abstract void drawMonthDay(Canvas canvas, int year, int month, int day, int x, int y, int startX, int stopX, int startY, int stopY);

    public MonthView(Context context, AttributeSet attr, DatePickerController controller) {
        super(context, attr);
        this.mEdgePadding = 0;
        this.mFirstJulianDay = -1;
        this.mFirstMonth = -1;
        this.mLastMonth = -1;
        this.mRowHeight = DEFAULT_HEIGHT;
        this.mHasToday = false;
        this.mSelectedDay = -1;
        this.mToday = -1;
        this.mWeekStart = 7;
        this.mNumDays = 7;
        this.mNumCells = 7;
        this.mSelectedLeft = -1;
        this.mSelectedRight = -1;
        this.mNumRows = 6;
        this.rightSpace = 30.0f;
        this.mDayOfWeekStart = 0;
        this.mController = controller;
        context.getResources();
        this.mDayLabelCalendar = new PersianCalendar();
        this.mPersianCalendar = new PersianCalendar();
        DatePickerController datePickerController = this.mController;
        if (datePickerController != null) {
            datePickerController.isThemeDark();
        }
        this.mDayTextColor = Theme.getColor("dialogTextBlack");
        this.mMonthDayTextColor = Theme.getColor("dialogTextGray2");
        this.mDisabledDayTextColor = Theme.getColor("dialogTextGray3");
        this.mHighlightedDayTextColor = Theme.getColor("dialogTextBlack");
        this.mSelectedDayTextColor = Theme.getColor("actionBarDefaultTitle");
        this.mTodayNumberColor = Theme.getColor("chats_actionBackground");
        this.mMonthTitleColor = Theme.getColor("actionBarDefaultTitle");
        this.mStringBuilder = new StringBuilder(50);
        MINI_DAY_NUMBER_TEXT_SIZE = AndroidUtilities.dp(12.0f);
        MONTH_LABEL_TEXT_SIZE = AndroidUtilities.dp(14.0f);
        MONTH_DAY_LABEL_TEXT_SIZE = AndroidUtilities.dp(12.0f);
        MONTH_HEADER_SIZE = AndroidUtilities.dp(56.0f);
        DAY_SELECTED_CIRCLE_SIZE = AndroidUtilities.dp(16.0f);
        this.mRowHeight = (AndroidUtilities.dp(252.0f) - getMonthHeaderSize()) / 6;
        MonthViewTouchHelper monthViewTouchHelper = getMonthViewTouchHelper();
        this.mTouchHelper = monthViewTouchHelper;
        ViewCompat.setAccessibilityDelegate(this, monthViewTouchHelper);
        ViewCompat.setImportantForAccessibility(this, 1);
        this.mLockAccessibilityDelegate = true;
        initView();
    }

    public void setDatePickerController(DatePickerController controller) {
        this.mController = controller;
    }

    protected MonthViewTouchHelper getMonthViewTouchHelper() {
        return new MonthViewTouchHelper(this);
    }

    @Override // android.view.View
    public void setAccessibilityDelegate(View.AccessibilityDelegate delegate) {
        if (this.mLockAccessibilityDelegate) {
            return;
        }
        super.setAccessibilityDelegate(delegate);
    }

    public void setOnDayClickListener(OnDayClickListener listener) {
        this.mOnDayClickListener = listener;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent event) {
        if (this.mTouchHelper.dispatchHoverEvent(event)) {
            return true;
        }
        return super.dispatchHoverEvent(event);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int dayFromLocation;
        if (event.getAction() == 1 && (dayFromLocation = getDayFromLocation(event.getX(), event.getY())) >= 0) {
            onDayClick(dayFromLocation);
        }
        return true;
    }

    protected void initView() {
        TextPaint textPaint = new TextPaint();
        this.mMonthTitlePaint = textPaint;
        textPaint.setFakeBoldText(true);
        this.mMonthTitlePaint.setAntiAlias(true);
        this.mMonthTitlePaint.setTextSize(MONTH_LABEL_TEXT_SIZE);
        this.mMonthTitlePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.mMonthTitlePaint.setColor(this.mDayTextColor);
        this.mMonthTitlePaint.setTextAlign(Paint.Align.CENTER);
        this.mMonthTitlePaint.setStyle(Paint.Style.FILL);
        Paint paint = new Paint();
        this.mSelectedCirclePaint = paint;
        paint.setFakeBoldText(true);
        this.mSelectedCirclePaint.setAntiAlias(true);
        this.mSelectedCirclePaint.setColor(this.mTodayNumberColor);
        this.mSelectedCirclePaint.setTextAlign(Paint.Align.CENTER);
        this.mSelectedCirclePaint.setStyle(Paint.Style.FILL);
        this.mSelectedCirclePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.mSelectedCirclePaint.setAlpha(255);
        TextPaint textPaint2 = new TextPaint();
        this.mMonthDayLabelPaint = textPaint2;
        textPaint2.setAntiAlias(true);
        this.mMonthDayLabelPaint.setTextSize(MONTH_DAY_LABEL_TEXT_SIZE);
        this.mMonthDayLabelPaint.setColor(this.mMonthDayTextColor);
        this.mMonthDayLabelPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        this.mMonthDayLabelPaint.setStyle(Paint.Style.FILL);
        this.mMonthDayLabelPaint.setTextAlign(Paint.Align.CENTER);
        this.mMonthDayLabelPaint.setFakeBoldText(true);
        TextPaint textPaint3 = new TextPaint();
        this.mMonthNumPaint = textPaint3;
        textPaint3.setAntiAlias(true);
        this.mMonthNumPaint.setTextSize(MINI_DAY_NUMBER_TEXT_SIZE);
        this.mMonthNumPaint.setStyle(Paint.Style.FILL);
        this.mMonthNumPaint.setTextAlign(Paint.Align.CENTER);
        this.mMonthNumPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        this.mMonthNumPaint.setFakeBoldText(false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        drawMonthTitle(canvas);
        drawMonthDayLabels(canvas);
        drawMonthNums(canvas);
    }

    public void setMonthParams(HashMap<String, Integer> params) {
        if (!params.containsKey("month") && !params.containsKey("year")) {
            throw new InvalidParameterException("You must specify month and year for this view");
        }
        setTag(params);
        if (params.containsKey("height")) {
            int iIntValue = params.get("height").intValue();
            this.mRowHeight = iIntValue;
            int i = MIN_HEIGHT;
            if (iIntValue < i) {
                this.mRowHeight = i;
            }
        }
        if (params.containsKey("selected_day")) {
            this.mSelectedDay = params.get("selected_day").intValue();
        }
        this.mMonth = params.get("month").intValue();
        this.mYear = params.get("year").intValue();
        PersianCalendar persianCalendar = new PersianCalendar();
        int i2 = 0;
        this.mHasToday = false;
        this.mToday = -1;
        this.mPersianCalendar.setPersianDate(this.mYear, this.mMonth, 1);
        this.mDayOfWeekStart = this.mPersianCalendar.get(7);
        if (params.containsKey("week_start")) {
            this.mWeekStart = params.get("week_start").intValue();
        } else {
            this.mWeekStart = 7;
        }
        this.mNumCells = Utils.getDaysInMonth(this.mMonth, this.mYear);
        while (i2 < this.mNumCells) {
            i2++;
            if (sameDay(i2, persianCalendar)) {
                this.mHasToday = true;
                this.mToday = i2;
            }
        }
        this.mNumRows = calculateNumRows();
        this.mTouchHelper.invalidateRoot();
    }

    public void setSelectedDay(int day) {
        this.mSelectedDay = day;
    }

    public void reuse() {
        this.mNumRows = 6;
        requestLayout();
    }

    private int calculateNumRows() {
        int iFindDayOffset = findDayOffset();
        int i = this.mNumCells;
        int i2 = this.mNumDays;
        return ((iFindDayOffset + i) / i2) + ((iFindDayOffset + i) % i2 > 0 ? 1 : 0);
    }

    private boolean sameDay(int day, PersianCalendar today) {
        return this.mYear == today.getPersianYear() && this.mMonth == today.getPersianMonth() && day == today.getPersianDay();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), (this.mRowHeight * this.mNumRows) + getMonthHeaderSize() + 5);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.mWidth = w;
        this.mTouchHelper.invalidateRoot();
    }

    public int getMonth() {
        return this.mMonth;
    }

    public int getYear() {
        return this.mYear;
    }

    protected int getMonthHeaderSize() {
        return MONTH_HEADER_SIZE;
    }

    private String getMonthAndYearString() {
        this.mStringBuilder.setLength(0);
        return LanguageUtils.getPersianNumbers(this.mPersianCalendar.getPersianMonthName() + " " + this.mPersianCalendar.getPersianYear());
    }

    protected void drawMonthTitle(Canvas canvas) {
        canvas.drawText(getMonthAndYearString(), (this.mWidth + (this.mEdgePadding * 2)) / 2, (getMonthHeaderSize() - MONTH_DAY_LABEL_TEXT_SIZE) / 2, this.mMonthTitlePaint);
    }

    protected void drawMonthDayLabels(Canvas canvas) {
        int monthHeaderSize = getMonthHeaderSize() - (MONTH_DAY_LABEL_TEXT_SIZE / 2);
        int i = (this.mWidth - (this.mEdgePadding * 2)) / (this.mNumDays * 2);
        float f = ((((r2 - 1) * 2) + 1) * i) + this.rightSpace;
        int i2 = 0;
        while (true) {
            int i3 = this.mNumDays;
            if (i2 >= i3) {
                return;
            }
            int i4 = (this.mWeekStart + i2) % i3;
            this.mDayLabelCalendar.set(7, i4);
            canvas.drawText(this.mDayLabelCalendar.getPersianWeekDayName().substring(0, 1), (int) ((f - (((i2 * 2) + 1) * i)) + this.mEdgePadding), monthHeaderSize, this.mMonthDayLabelPaint);
            i2++;
        }
    }

    protected void drawMonthNums(Canvas canvas) {
        int monthHeaderSize = (((this.mRowHeight + MINI_DAY_NUMBER_TEXT_SIZE) / 2) - DAY_SEPARATOR_WIDTH) + getMonthHeaderSize();
        float f = (this.mWidth - (this.mEdgePadding * 2)) / (this.mNumDays * 2.0f);
        int iFindDayOffset = findDayOffset();
        float f2 = ((((this.mNumDays - 1) * 2) + 1) * f) + this.rightSpace;
        int i = monthHeaderSize;
        int i2 = iFindDayOffset;
        int i3 = 1;
        while (i3 <= this.mNumCells) {
            int i4 = (int) (f2 - ((((i2 * 2) + 1) * f) + this.mEdgePadding));
            int i5 = this.mRowHeight;
            float f3 = i4;
            int i6 = i - (((MINI_DAY_NUMBER_TEXT_SIZE + i5) / 2) - DAY_SEPARATOR_WIDTH);
            int i7 = i3;
            drawMonthDay(canvas, this.mYear, this.mMonth, i3, i4, i, (int) (f3 - f), (int) (f3 + f), i6, i6 + i5);
            int i8 = i2 + 1;
            if (i8 == this.mNumDays) {
                i += this.mRowHeight;
                i2 = 0;
            } else {
                i2 = i8;
            }
            i3 = i7 + 1;
        }
    }

    protected int findDayOffset() {
        int i = this.mDayOfWeekStart;
        int i2 = this.mWeekStart;
        if (i < i2) {
            i += this.mNumDays;
        }
        return i - i2;
    }

    public int getDayFromLocation(float x, float y) {
        int internalDayFromLocation = getInternalDayFromLocation(x, y);
        if (internalDayFromLocation < 1 || internalDayFromLocation > this.mNumCells) {
            return -1;
        }
        return internalDayFromLocation;
    }

    protected int getInternalDayFromLocation(float x, float y) {
        float f = this.mEdgePadding;
        if (x < f || x > this.mWidth - r0) {
            return -1;
        }
        int monthHeaderSize = ((int) (y - getMonthHeaderSize())) / this.mRowHeight;
        int i = this.mNumDays;
        return (((int) (i - (((x - f) * i) / ((this.mWidth - r0) - this.mEdgePadding)))) - findDayOffset()) + 1 + (monthHeaderSize * this.mNumDays);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDayClick(int day) {
        if (isOutOfRange(this.mYear, this.mMonth, day)) {
            return;
        }
        OnDayClickListener onDayClickListener = this.mOnDayClickListener;
        if (onDayClickListener != null) {
            onDayClickListener.onDayClick(this, new MonthAdapter.CalendarDay(this.mYear, this.mMonth, day));
        }
        this.mTouchHelper.sendEventForVirtualView(day, 1);
    }

    protected boolean isOutOfRange(int year, int month, int day) {
        if (this.mController.getSelectableDays() != null) {
            return !isSelectable(year, month, day);
        }
        return isBeforeMin(year, month, day) || isAfterMax(year, month, day);
    }

    private boolean isSelectable(int year, int month, int day) {
        for (PersianCalendar persianCalendar : this.mController.getSelectableDays()) {
            if (year < persianCalendar.getPersianYear()) {
                break;
            }
            if (year <= persianCalendar.getPersianYear()) {
                if (month < persianCalendar.getPersianMonth()) {
                    break;
                }
                if (month > persianCalendar.getPersianMonth()) {
                    continue;
                } else {
                    if (day < persianCalendar.getPersianDay()) {
                        break;
                    }
                    if (day <= persianCalendar.getPersianDay()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isBeforeMin(int year, int month, int day) {
        PersianCalendar minDate;
        DatePickerController datePickerController = this.mController;
        if (datePickerController == null || (minDate = datePickerController.getMinDate()) == null) {
            return false;
        }
        if (year < minDate.getPersianYear()) {
            return true;
        }
        if (year > minDate.getPersianYear()) {
            return false;
        }
        if (month < minDate.getPersianMonth()) {
            return true;
        }
        return month <= minDate.getPersianMonth() && day < minDate.getPersianDay();
    }

    private boolean isAfterMax(int year, int month, int day) {
        PersianCalendar maxDate;
        DatePickerController datePickerController = this.mController;
        if (datePickerController == null || (maxDate = datePickerController.getMaxDate()) == null) {
            return false;
        }
        if (year > maxDate.getPersianYear()) {
            return true;
        }
        if (year < maxDate.getPersianYear()) {
            return false;
        }
        if (month > maxDate.getPersianMonth()) {
            return true;
        }
        return month >= maxDate.getPersianMonth() && day > maxDate.getPersianDay();
    }

    protected boolean isHighlighted(int year, int month, int day) {
        PersianCalendar[] highlightedDays = this.mController.getHighlightedDays();
        if (highlightedDays == null) {
            return false;
        }
        for (PersianCalendar persianCalendar : highlightedDays) {
            if (year < persianCalendar.getPersianYear()) {
                break;
            }
            if (year <= persianCalendar.getPersianYear()) {
                if (month < persianCalendar.getPersianMonth()) {
                    break;
                }
                if (month > persianCalendar.getPersianMonth()) {
                    continue;
                } else {
                    if (day < persianCalendar.getPersianDay()) {
                        break;
                    }
                    if (day <= persianCalendar.getPersianDay()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public MonthAdapter.CalendarDay getAccessibilityFocus() {
        int focusedVirtualView = this.mTouchHelper.getFocusedVirtualView();
        if (focusedVirtualView >= 0) {
            return new MonthAdapter.CalendarDay(this.mYear, this.mMonth, focusedVirtualView);
        }
        return null;
    }

    public void clearAccessibilityFocus() {
        this.mTouchHelper.clearFocusedVirtualView();
    }

    public boolean restoreAccessibilityFocus(MonthAdapter.CalendarDay day) {
        int i;
        if (day.year != this.mYear || day.month != this.mMonth || (i = day.day) > this.mNumCells) {
            return false;
        }
        this.mTouchHelper.setFocusedVirtualView(i);
        return true;
    }

    protected class MonthViewTouchHelper extends ExploreByTouchHelper {
        private final PersianCalendar mTempCalendar;
        private final Rect mTempRect;

        public MonthViewTouchHelper(View host) {
            super(host);
            this.mTempRect = new Rect();
            this.mTempCalendar = new PersianCalendar();
        }

        public void setFocusedVirtualView(int virtualViewId) {
            getAccessibilityNodeProvider(MonthView.this).performAction(virtualViewId, 64, null);
        }

        public void clearFocusedVirtualView() {
            int focusedVirtualView = getFocusedVirtualView();
            if (focusedVirtualView != Integer.MIN_VALUE) {
                getAccessibilityNodeProvider(MonthView.this).performAction(focusedVirtualView, 128, null);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float x, float y) {
            int dayFromLocation = MonthView.this.getDayFromLocation(x, y);
            if (dayFromLocation >= 0) {
                return dayFromLocation;
            }
            return Integer.MIN_VALUE;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> virtualViewIds) {
            for (int i = 1; i <= MonthView.this.mNumCells; i++) {
                virtualViewIds.add(Integer.valueOf(i));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int virtualViewId, AccessibilityEvent event) {
            event.setContentDescription(getItemDescription(virtualViewId));
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int virtualViewId, AccessibilityNodeInfoCompat node) {
            getItemBounds(virtualViewId, this.mTempRect);
            node.setContentDescription(getItemDescription(virtualViewId));
            node.setBoundsInParent(this.mTempRect);
            node.addAction(16);
            if (virtualViewId == MonthView.this.mSelectedDay) {
                node.setSelected(true);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int virtualViewId, int action, Bundle arguments) {
            if (action != 16) {
                return false;
            }
            MonthView.this.onDayClick(virtualViewId);
            return true;
        }

        protected void getItemBounds(int day, Rect rect) {
            MonthView monthView = MonthView.this;
            int i = monthView.mEdgePadding;
            int monthHeaderSize = monthView.getMonthHeaderSize();
            MonthView monthView2 = MonthView.this;
            int i2 = monthView2.mRowHeight;
            int i3 = (monthView2.mWidth - (monthView2.mEdgePadding * 2)) / monthView2.mNumDays;
            int iFindDayOffset = (day - 1) + monthView2.findDayOffset();
            int i4 = MonthView.this.mNumDays;
            int i5 = i + ((iFindDayOffset % i4) * i3);
            int i6 = monthHeaderSize + ((iFindDayOffset / i4) * i2);
            rect.set(i5, i6, i3 + i5, i2 + i6);
        }

        protected CharSequence getItemDescription(int day) {
            PersianCalendar persianCalendar = this.mTempCalendar;
            MonthView monthView = MonthView.this;
            persianCalendar.setPersianDate(monthView.mYear, monthView.mMonth, day);
            String persianNumbers = LanguageUtils.getPersianNumbers(this.mTempCalendar.getPersianLongDate());
            if (day != MonthView.this.mSelectedDay) {
                return persianNumbers;
            }
            return persianNumbers + "انتخاب شد";
        }
    }
}
