package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.ui.ActionBar.Theme;
import java.util.Locale;

/* loaded from: classes3.dex */
public class NumberPicker extends LinearLayout {
    private int SELECTOR_MIDDLE_ITEM_INDEX;
    private int SELECTOR_WHEEL_ITEM_COUNT;
    private SeekBarAccessibilityDelegate accessibilityDelegate;
    private boolean drawDividers;
    private Scroller mAdjustScroller;
    private int mBottomSelectionDividerBottom;
    private ChangeCurrentByOneFromLongPressCommand mChangeCurrentByOneFromLongPressCommand;
    private boolean mComputeMaxWidth;
    private int mCurrentScrollOffset;
    private boolean mDecrementVirtualButtonPressed;
    private String[] mDisplayedValues;
    private Scroller mFlingScroller;
    private Formatter mFormatter;
    private boolean mIncrementVirtualButtonPressed;
    private boolean mIngonreMoveEvents;
    private int mInitialScrollOffset;
    private TextView mInputText;
    private long mLastDownEventTime;
    private float mLastDownEventY;
    private float mLastDownOrMoveEventY;
    private int mLastHandledDownDpadKeyCode;
    private long mLongPressUpdateInterval;
    private int mMaxHeight;
    private int mMaxValue;
    private int mMaxWidth;
    private int mMaximumFlingVelocity;
    private int mMinHeight;
    private int mMinValue;
    private int mMinWidth;
    private int mMinimumFlingVelocity;
    private OnScrollListener mOnScrollListener;
    private OnValueChangeListener mOnValueChangeListener;
    private PressedStateHelper mPressedStateHelper;
    private int mPreviousScrollerY;
    private int mScrollState;
    private Paint mSelectionDivider;
    private int mSelectionDividerHeight;
    private int mSelectionDividersDistance;
    private int mSelectorElementHeight;
    private final SparseArray<String> mSelectorIndexToStringCache;
    private int[] mSelectorIndices;
    private int mSelectorTextGapHeight;
    private Paint mSelectorWheelPaint;
    private int mSolidColor;
    private int mTextSize;
    private int mTopSelectionDividerTop;
    private int mTouchSlop;
    private int mValue;
    private VelocityTracker mVelocityTracker;
    private boolean mWrapSelectorWheel;
    private final Theme.ResourcesProvider resourcesProvider;
    private int textOffset;

    public interface Formatter {
        String format(int value);
    }

    public interface OnScrollListener {
        void onScrollStateChange(NumberPicker view, int scrollState);
    }

    public interface OnValueChangeListener {
        void onValueChange(NumberPicker picker, int oldVal, int newVal);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, byte] */
    static /* synthetic */ boolean access$380(NumberPicker numberPicker, int i) {
        ?? r2 = (byte) (i ^ (numberPicker.mIncrementVirtualButtonPressed ? 1 : 0));
        numberPicker.mIncrementVirtualButtonPressed = r2;
        return r2;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, byte] */
    static /* synthetic */ boolean access$580(NumberPicker numberPicker, int i) {
        ?? r2 = (byte) (i ^ (numberPicker.mDecrementVirtualButtonPressed ? 1 : 0));
        numberPicker.mDecrementVirtualButtonPressed = r2;
        return r2;
    }

    public void setItemCount(int count) {
        if (this.SELECTOR_WHEEL_ITEM_COUNT == count) {
            return;
        }
        this.SELECTOR_WHEEL_ITEM_COUNT = count;
        this.SELECTOR_MIDDLE_ITEM_INDEX = count / 2;
        this.mSelectorIndices = new int[count];
        initializeSelectorWheelIndices();
    }

    private void init() {
        this.mSolidColor = 0;
        Paint paint = new Paint();
        this.mSelectionDivider = paint;
        paint.setColor(getThemedColor("dialogButton"));
        this.mSelectionDividerHeight = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.mSelectionDividersDistance = (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics());
        this.mMinHeight = -1;
        int iApplyDimension = (int) TypedValue.applyDimension(1, 180.0f, getResources().getDisplayMetrics());
        this.mMaxHeight = iApplyDimension;
        int i = this.mMinHeight;
        if (i != -1 && iApplyDimension != -1 && i > iApplyDimension) {
            throw new IllegalArgumentException("minHeight > maxHeight");
        }
        this.mMinWidth = (int) TypedValue.applyDimension(1, 64.0f, getResources().getDisplayMetrics());
        this.mMaxWidth = -1;
        this.mComputeMaxWidth = true;
        this.mPressedStateHelper = new PressedStateHelper();
        setWillNotDraw(false);
        TextView textView = new TextView(getContext());
        this.mInputText = textView;
        textView.setGravity(17);
        this.mInputText.setSingleLine(true);
        this.mInputText.setTextColor(getThemedColor("dialogTextBlack"));
        this.mInputText.setBackgroundResource(0);
        this.mInputText.setTextSize(0, this.mTextSize);
        this.mInputText.setTypeface(AndroidUtilities.getFontFamily(false));
        this.mInputText.setVisibility(4);
        addView(this.mInputText, new LinearLayout.LayoutParams(-1, -2));
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setTextSize(this.mTextSize);
        paint2.setTypeface(this.mInputText.getTypeface());
        paint2.setColor(this.mInputText.getTextColors().getColorForState(LinearLayout.ENABLED_STATE_SET, -1));
        this.mSelectorWheelPaint = paint2;
        this.mFlingScroller = new Scroller(getContext(), null, true);
        this.mAdjustScroller = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
        updateInputTextView();
        setImportantForAccessibility(1);
        SeekBarAccessibilityDelegate seekBarAccessibilityDelegate = new SeekBarAccessibilityDelegate() { // from class: ir.eitaa.ui.Components.NumberPicker.1
            @Override // ir.eitaa.ui.Components.SeekBarAccessibilityDelegate
            protected boolean canScrollBackward(View host) {
                return true;
            }

            @Override // ir.eitaa.ui.Components.SeekBarAccessibilityDelegate
            protected boolean canScrollForward(View host) {
                return true;
            }

            @Override // ir.eitaa.ui.Components.SeekBarAccessibilityDelegate
            protected void doScroll(View host, boolean backward) {
                NumberPicker.this.changeValueByOne(!backward);
            }

            @Override // ir.eitaa.ui.Components.SeekBarAccessibilityDelegate
            public CharSequence getContentDescription(View host) {
                NumberPicker numberPicker = NumberPicker.this;
                return numberPicker.getContentDescription(numberPicker.mValue);
            }
        };
        this.accessibilityDelegate = seekBarAccessibilityDelegate;
        setAccessibilityDelegate(seekBarAccessibilityDelegate);
    }

    protected CharSequence getContentDescription(int value) {
        return this.mInputText.getText();
    }

    public void setTextColor(int color) {
        this.mInputText.setTextColor(color);
        this.mSelectorWheelPaint.setColor(color);
    }

    public void setSelectorColor(int color) {
        this.mSelectionDivider.setColor(color);
    }

    public NumberPicker(Context context) {
        this(context, (Theme.ResourcesProvider) null);
    }

    public NumberPicker(Context context, Theme.ResourcesProvider resourcesProvider) {
        this(context, 18, resourcesProvider);
    }

    public NumberPicker(Context context, int textSize) {
        this(context, textSize, null);
    }

    public NumberPicker(Context context, int textSize, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.SELECTOR_WHEEL_ITEM_COUNT = 3;
        this.SELECTOR_MIDDLE_ITEM_INDEX = 3 / 2;
        this.mLongPressUpdateInterval = 300L;
        this.mSelectorIndexToStringCache = new SparseArray<>();
        this.mSelectorIndices = new int[this.SELECTOR_WHEEL_ITEM_COUNT];
        this.mInitialScrollOffset = Integer.MIN_VALUE;
        this.mScrollState = 0;
        this.mLastHandledDownDpadKeyCode = -1;
        this.drawDividers = true;
        this.resourcesProvider = resourcesProvider;
        this.mTextSize = AndroidUtilities.dp(textSize);
        init();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.mInputText.getMeasuredWidth();
        int measuredHeight2 = this.mInputText.getMeasuredHeight();
        int i = (measuredWidth - measuredWidth2) / 2;
        int i2 = (measuredHeight - measuredHeight2) / 2;
        this.mInputText.layout(i, i2, measuredWidth2 + i, measuredHeight2 + i2);
        if (changed) {
            initializeSelectorWheel();
            initializeFadingEdges();
            int height = getHeight();
            int i3 = this.mSelectionDividersDistance;
            int i4 = this.mSelectionDividerHeight;
            int i5 = ((height - i3) / 2) - i4;
            this.mTopSelectionDividerTop = i5;
            this.mBottomSelectionDividerBottom = i5 + (i4 * 2) + i3;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(makeMeasureSpec(widthMeasureSpec, this.mMaxWidth), makeMeasureSpec(heightMeasureSpec, this.mMaxHeight));
        setMeasuredDimension(resolveSizeAndStateRespectingMinSize(this.mMinWidth, getMeasuredWidth(), widthMeasureSpec), resolveSizeAndStateRespectingMinSize(this.mMinHeight, getMeasuredHeight(), heightMeasureSpec));
    }

    private boolean moveToFinalScrollerPosition(Scroller scroller) {
        scroller.forceFinished(true);
        int finalY = scroller.getFinalY() - scroller.getCurrY();
        int i = this.mInitialScrollOffset - ((this.mCurrentScrollOffset + finalY) % this.mSelectorElementHeight);
        if (i == 0) {
            return false;
        }
        int iAbs = Math.abs(i);
        int i2 = this.mSelectorElementHeight;
        if (iAbs > i2 / 2) {
            i = i > 0 ? i - i2 : i + i2;
        }
        scrollBy(0, finalY + i);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (!isEnabled() || event.getActionMasked() != 0) {
            return false;
        }
        removeAllCallbacks();
        this.mInputText.setVisibility(4);
        float y = event.getY();
        this.mLastDownEventY = y;
        this.mLastDownOrMoveEventY = y;
        this.mLastDownEventTime = event.getEventTime();
        this.mIngonreMoveEvents = false;
        float f = this.mLastDownEventY;
        if (f < this.mTopSelectionDividerTop) {
            if (this.mScrollState == 0) {
                this.mPressedStateHelper.buttonPressDelayed(2);
            }
        } else if (f > this.mBottomSelectionDividerBottom && this.mScrollState == 0) {
            this.mPressedStateHelper.buttonPressDelayed(1);
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.mFlingScroller.isFinished()) {
            this.mFlingScroller.forceFinished(true);
            this.mAdjustScroller.forceFinished(true);
            onScrollStateChange(0);
        } else if (!this.mAdjustScroller.isFinished()) {
            this.mFlingScroller.forceFinished(true);
            this.mAdjustScroller.forceFinished(true);
        } else {
            float f2 = this.mLastDownEventY;
            if (f2 < this.mTopSelectionDividerTop) {
                postChangeCurrentByOneFromLongPress(false, ViewConfiguration.getLongPressTimeout());
            } else if (f2 > this.mBottomSelectionDividerBottom) {
                postChangeCurrentByOneFromLongPress(true, ViewConfiguration.getLongPressTimeout());
            }
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(event);
        int actionMasked = event.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2 && !this.mIngonreMoveEvents) {
                float y = event.getY();
                if (this.mScrollState != 1) {
                    if (((int) Math.abs(y - this.mLastDownEventY)) > this.mTouchSlop) {
                        removeAllCallbacks();
                        onScrollStateChange(1);
                    }
                } else {
                    scrollBy(0, (int) (y - this.mLastDownOrMoveEventY));
                    invalidate();
                }
                this.mLastDownOrMoveEventY = y;
            }
        } else {
            removeChangeCurrentByOneFromLongPress();
            this.mPressedStateHelper.cancel();
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
            int yVelocity = (int) velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) > this.mMinimumFlingVelocity) {
                fling(yVelocity);
                onScrollStateChange(2);
            } else {
                int y2 = (int) event.getY();
                int iAbs = (int) Math.abs(y2 - this.mLastDownEventY);
                long eventTime = event.getEventTime() - this.mLastDownEventTime;
                if (iAbs <= this.mTouchSlop && eventTime < ViewConfiguration.getTapTimeout()) {
                    int i = (y2 / this.mSelectorElementHeight) - this.SELECTOR_MIDDLE_ITEM_INDEX;
                    if (i > 0) {
                        changeValueByOne(true);
                        this.mPressedStateHelper.buttonTapped(1);
                    } else if (i < 0) {
                        changeValueByOne(false);
                        this.mPressedStateHelper.buttonTapped(2);
                    }
                } else {
                    ensureScrollWheelAdjusted();
                }
                onScrollStateChange(0);
            }
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        int actionMasked = event.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            removeAllCallbacks();
        }
        return super.dispatchTouchEvent(event);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        requestFocus();
        r5.mLastHandledDownDpadKeyCode = r0;
        removeAllCallbacks();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        if (r5.mFlingScroller.isFinished() == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
    
        if (r0 != 20) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
    
        changeValueByOne(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
    
        return true;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getKeyCode()
            r1 = 19
            r2 = 20
            if (r0 == r1) goto L19
            if (r0 == r2) goto L19
            r1 = 23
            if (r0 == r1) goto L15
            r1 = 66
            if (r0 == r1) goto L15
            goto L60
        L15:
            r5.removeAllCallbacks()
            goto L60
        L19:
            int r1 = r6.getAction()
            r3 = 1
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L23
            goto L60
        L23:
            int r1 = r5.mLastHandledDownDpadKeyCode
            if (r1 != r0) goto L60
            r6 = -1
            r5.mLastHandledDownDpadKeyCode = r6
            return r3
        L2b:
            boolean r1 = r5.mWrapSelectorWheel
            if (r1 != 0) goto L3d
            if (r0 != r2) goto L32
            goto L3d
        L32:
            int r1 = r5.getValue()
            int r4 = r5.getMinValue()
            if (r1 <= r4) goto L60
            goto L47
        L3d:
            int r1 = r5.getValue()
            int r4 = r5.getMaxValue()
            if (r1 >= r4) goto L60
        L47:
            r5.requestFocus()
            r5.mLastHandledDownDpadKeyCode = r0
            r5.removeAllCallbacks()
            ir.eitaa.ui.Components.Scroller r6 = r5.mFlingScroller
            boolean r6 = r6.isFinished()
            if (r6 == 0) goto L5f
            if (r0 != r2) goto L5b
            r6 = 1
            goto L5c
        L5b:
            r6 = 0
        L5c:
            r5.changeValueByOne(r6)
        L5f:
            return r3
        L60:
            boolean r6 = super.dispatchKeyEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.NumberPicker.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTrackballEvent(MotionEvent event) {
        int actionMasked = event.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            removeAllCallbacks();
        }
        return super.dispatchTrackballEvent(event);
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller scroller = this.mFlingScroller;
        if (scroller.isFinished()) {
            scroller = this.mAdjustScroller;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        int currY = scroller.getCurrY();
        if (this.mPreviousScrollerY == 0) {
            this.mPreviousScrollerY = scroller.getStartY();
        }
        scrollBy(0, currY - this.mPreviousScrollerY);
        this.mPreviousScrollerY = currY;
        if (scroller.isFinished()) {
            onScrollerFinished(scroller);
        } else {
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.mInputText.setEnabled(enabled);
    }

    @Override // android.view.View
    public void scrollBy(int x, int y) {
        int[] iArr = this.mSelectorIndices;
        boolean z = this.mWrapSelectorWheel;
        if (!z && y > 0 && iArr[this.SELECTOR_MIDDLE_ITEM_INDEX] <= this.mMinValue) {
            int i = this.mCurrentScrollOffset + y;
            int i2 = this.mInitialScrollOffset;
            if (i > i2) {
                this.mCurrentScrollOffset = i2;
                return;
            }
        }
        if (!z && y < 0 && iArr[this.SELECTOR_MIDDLE_ITEM_INDEX] >= this.mMaxValue) {
            int i3 = this.mCurrentScrollOffset + y;
            int i4 = this.mInitialScrollOffset;
            if (i3 < i4) {
                this.mCurrentScrollOffset = i4;
                return;
            }
        }
        this.mCurrentScrollOffset += y;
        while (true) {
            int i5 = this.mCurrentScrollOffset;
            if (i5 - this.mInitialScrollOffset <= this.mSelectorTextGapHeight) {
                break;
            }
            this.mCurrentScrollOffset = i5 - this.mSelectorElementHeight;
            decrementSelectorIndices(iArr);
            setValueInternal(iArr[this.SELECTOR_MIDDLE_ITEM_INDEX], true);
            if (!this.mWrapSelectorWheel && iArr[this.SELECTOR_MIDDLE_ITEM_INDEX] <= this.mMinValue) {
                int i6 = this.mCurrentScrollOffset;
                int i7 = this.mInitialScrollOffset;
                if (i6 > i7) {
                    this.mCurrentScrollOffset = i7;
                }
            }
        }
        while (true) {
            int i8 = this.mCurrentScrollOffset;
            if (i8 - this.mInitialScrollOffset >= (-this.mSelectorTextGapHeight)) {
                return;
            }
            this.mCurrentScrollOffset = i8 + this.mSelectorElementHeight;
            incrementSelectorIndices(iArr);
            setValueInternal(iArr[this.SELECTOR_MIDDLE_ITEM_INDEX], true);
            if (!this.mWrapSelectorWheel && iArr[this.SELECTOR_MIDDLE_ITEM_INDEX] >= this.mMaxValue) {
                int i9 = this.mCurrentScrollOffset;
                int i10 = this.mInitialScrollOffset;
                if (i9 < i10) {
                    this.mCurrentScrollOffset = i10;
                }
            }
        }
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        return this.mCurrentScrollOffset;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return ((this.mMaxValue - this.mMinValue) + 1) * this.mSelectorElementHeight;
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        return getHeight();
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.mSolidColor;
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangedListener) {
        this.mOnValueChangeListener = onValueChangedListener;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public void setFormatter(Formatter formatter) {
        if (formatter == this.mFormatter) {
            return;
        }
        this.mFormatter = formatter;
        initializeSelectorWheelIndices();
        updateInputTextView();
    }

    public void setValue(int value) {
        setValueInternal(value, false);
    }

    public void setTextOffset(int value) {
        this.textOffset = value;
        invalidate();
    }

    private void tryComputeMaxWidth() {
        int i;
        if (this.mComputeMaxWidth) {
            String[] strArr = this.mDisplayedValues;
            int i2 = 0;
            if (strArr == null) {
                float f = 0.0f;
                for (int i3 = 0; i3 <= 9; i3++) {
                    float fMeasureText = this.mSelectorWheelPaint.measureText(formatNumberWithLocale(i3));
                    if (fMeasureText > f) {
                        f = fMeasureText;
                    }
                }
                for (int i4 = this.mMaxValue; i4 > 0; i4 /= 10) {
                    i2++;
                }
                i = (int) (i2 * f);
            } else {
                int length = strArr.length;
                int i5 = 0;
                while (i2 < length) {
                    float fMeasureText2 = this.mSelectorWheelPaint.measureText(strArr[i2]);
                    if (fMeasureText2 > i5) {
                        i5 = (int) fMeasureText2;
                    }
                    i2++;
                }
                i = i5;
            }
            int paddingLeft = i + this.mInputText.getPaddingLeft() + this.mInputText.getPaddingRight();
            if (this.mMaxWidth != paddingLeft) {
                int i6 = this.mMinWidth;
                if (paddingLeft > i6) {
                    this.mMaxWidth = paddingLeft;
                } else {
                    this.mMaxWidth = i6;
                }
                invalidate();
            }
        }
    }

    public boolean getWrapSelectorWheel() {
        return this.mWrapSelectorWheel;
    }

    public void setWrapSelectorWheel(boolean wrapSelectorWheel) {
        boolean z = this.mMaxValue - this.mMinValue >= this.mSelectorIndices.length;
        if ((!wrapSelectorWheel || z) && wrapSelectorWheel != this.mWrapSelectorWheel) {
            this.mWrapSelectorWheel = wrapSelectorWheel;
        }
    }

    public void setOnLongPressUpdateInterval(long intervalMillis) {
        this.mLongPressUpdateInterval = intervalMillis;
    }

    public int getValue() {
        return this.mValue;
    }

    public int getMinValue() {
        return this.mMinValue;
    }

    public void setMinValue(int minValue) {
        if (this.mMinValue == minValue) {
            return;
        }
        if (minValue < 0) {
            throw new IllegalArgumentException("minValue must be >= 0");
        }
        this.mMinValue = minValue;
        if (minValue > this.mValue) {
            this.mValue = minValue;
        }
        setWrapSelectorWheel(this.mMaxValue - minValue > this.mSelectorIndices.length);
        initializeSelectorWheelIndices();
        updateInputTextView();
        tryComputeMaxWidth();
        invalidate();
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public void setMaxValue(int maxValue) {
        if (this.mMaxValue == maxValue) {
            return;
        }
        if (maxValue < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        this.mMaxValue = maxValue;
        if (maxValue < this.mValue) {
            this.mValue = maxValue;
        }
        setWrapSelectorWheel(maxValue - this.mMinValue > this.mSelectorIndices.length);
        initializeSelectorWheelIndices();
        updateInputTextView();
        tryComputeMaxWidth();
        invalidate();
    }

    public String[] getDisplayedValues() {
        return this.mDisplayedValues;
    }

    public void setDisplayedValues(String[] displayedValues) {
        if (this.mDisplayedValues == displayedValues) {
            return;
        }
        this.mDisplayedValues = displayedValues;
        updateInputTextView();
        initializeSelectorWheelIndices();
        tryComputeMaxWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeAllCallbacks();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        float right = ((getRight() - getLeft()) / 2) + this.textOffset;
        float f = this.mCurrentScrollOffset;
        int[] iArr = this.mSelectorIndices;
        for (int i = 0; i < iArr.length; i++) {
            String str = this.mSelectorIndexToStringCache.get(iArr[i]);
            if (str != null && (i != this.SELECTOR_MIDDLE_ITEM_INDEX || this.mInputText.getVisibility() != 0)) {
                canvas.drawText(str, right, f, this.mSelectorWheelPaint);
            }
            f += this.mSelectorElementHeight;
        }
        if (this.drawDividers) {
            canvas.drawRect(0.0f, this.mTopSelectionDividerTop, getRight(), this.mSelectionDividerHeight + r0, this.mSelectionDivider);
            canvas.drawRect(0.0f, r0 - this.mSelectionDividerHeight, getRight(), this.mBottomSelectionDividerBottom, this.mSelectionDivider);
        }
    }

    private int makeMeasureSpec(int measureSpec, int maxSize) {
        if (maxSize == -1) {
            return measureSpec;
        }
        int size = View.MeasureSpec.getSize(measureSpec);
        int mode = View.MeasureSpec.getMode(measureSpec);
        if (mode == Integer.MIN_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, maxSize), 1073741824);
        }
        if (mode == 0) {
            return View.MeasureSpec.makeMeasureSpec(maxSize, 1073741824);
        }
        if (mode == 1073741824) {
            return measureSpec;
        }
        throw new IllegalArgumentException("Unknown measure mode: " + mode);
    }

    private int resolveSizeAndStateRespectingMinSize(int minSize, int measuredSize, int measureSpec) {
        return minSize != -1 ? resolveSizeAndState(Math.max(minSize, measuredSize), measureSpec, 0) : measuredSize;
    }

    public static int resolveSizeAndState(int size, int measureSpec, int childMeasuredState) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size2 = View.MeasureSpec.getSize(measureSpec);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                size = size2;
            }
        } else if (size2 < size) {
            size = 16777216 | size2;
        }
        return size | ((-16777216) & childMeasuredState);
    }

    private void initializeSelectorWheelIndices() {
        this.mSelectorIndexToStringCache.clear();
        int[] iArr = this.mSelectorIndices;
        int value = getValue();
        for (int i = 0; i < this.mSelectorIndices.length; i++) {
            int wrappedSelectorIndex = (i - this.SELECTOR_MIDDLE_ITEM_INDEX) + value;
            if (this.mWrapSelectorWheel) {
                wrappedSelectorIndex = getWrappedSelectorIndex(wrappedSelectorIndex);
            }
            iArr[i] = wrappedSelectorIndex;
            ensureCachedScrollSelectorValue(iArr[i]);
        }
    }

    private void setValueInternal(int current, boolean notifyChange) {
        int iMin;
        if (this.mValue == current) {
            return;
        }
        if (this.mWrapSelectorWheel) {
            iMin = getWrappedSelectorIndex(current);
        } else {
            iMin = Math.min(Math.max(current, this.mMinValue), this.mMaxValue);
        }
        int i = this.mValue;
        this.mValue = iMin;
        updateInputTextView();
        if (notifyChange) {
            notifyChange(i, iMin);
        }
        initializeSelectorWheelIndices();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeValueByOne(boolean increment) {
        this.mInputText.setVisibility(4);
        if (!moveToFinalScrollerPosition(this.mFlingScroller)) {
            moveToFinalScrollerPosition(this.mAdjustScroller);
        }
        this.mPreviousScrollerY = 0;
        if (increment) {
            this.mFlingScroller.startScroll(0, 0, 0, -this.mSelectorElementHeight, 300);
        } else {
            this.mFlingScroller.startScroll(0, 0, 0, this.mSelectorElementHeight, 300);
        }
        invalidate();
    }

    private void initializeSelectorWheel() {
        initializeSelectorWheelIndices();
        int[] iArr = this.mSelectorIndices;
        int bottom = (int) ((((getBottom() - getTop()) - (iArr.length * this.mTextSize)) / iArr.length) + 0.5f);
        this.mSelectorTextGapHeight = bottom;
        this.mSelectorElementHeight = this.mTextSize + bottom;
        int baseline = (this.mInputText.getBaseline() + this.mInputText.getTop()) - (this.mSelectorElementHeight * this.SELECTOR_MIDDLE_ITEM_INDEX);
        this.mInitialScrollOffset = baseline;
        this.mCurrentScrollOffset = baseline;
        updateInputTextView();
    }

    private void initializeFadingEdges() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - this.mTextSize) / 2);
    }

    private void onScrollerFinished(Scroller scroller) {
        if (scroller == this.mFlingScroller) {
            if (!ensureScrollWheelAdjusted()) {
                updateInputTextView();
            }
            onScrollStateChange(0);
        } else if (this.mScrollState != 1) {
            updateInputTextView();
        }
    }

    private void onScrollStateChange(int scrollState) {
        if (this.mScrollState == scrollState) {
            return;
        }
        this.mScrollState = scrollState;
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChange(this, scrollState);
        }
        if (scrollState == 0) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
            if (accessibilityManager.isTouchExplorationEnabled()) {
                String[] strArr = this.mDisplayedValues;
                String number = strArr == null ? formatNumber(this.mValue) : strArr[this.mValue - this.mMinValue];
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(16384);
                accessibilityEventObtain.getText().add(number);
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
            }
        }
    }

    private void fling(int velocityY) {
        this.mPreviousScrollerY = 0;
        if (velocityY > 0) {
            this.mFlingScroller.fling(0, 0, 0, velocityY, 0, 0, 0, ConnectionsManager.DEFAULT_DATACENTER_ID);
        } else {
            this.mFlingScroller.fling(0, ConnectionsManager.DEFAULT_DATACENTER_ID, 0, velocityY, 0, 0, 0, ConnectionsManager.DEFAULT_DATACENTER_ID);
        }
        invalidate();
    }

    private int getWrappedSelectorIndex(int selectorIndex) {
        int i = this.mMaxValue;
        if (selectorIndex > i) {
            int i2 = this.mMinValue;
            return (i2 + ((selectorIndex - i) % (i - i2))) - 1;
        }
        int i3 = this.mMinValue;
        return selectorIndex < i3 ? (i - ((i3 - selectorIndex) % (i - i3))) + 1 : selectorIndex;
    }

    private void incrementSelectorIndices(int[] selectorIndices) {
        System.arraycopy(selectorIndices, 1, selectorIndices, 0, selectorIndices.length - 1);
        int i = selectorIndices[selectorIndices.length - 2] + 1;
        if (this.mWrapSelectorWheel && i > this.mMaxValue) {
            i = this.mMinValue;
        }
        selectorIndices[selectorIndices.length - 1] = i;
        ensureCachedScrollSelectorValue(i);
    }

    private void decrementSelectorIndices(int[] selectorIndices) {
        System.arraycopy(selectorIndices, 0, selectorIndices, 1, selectorIndices.length - 1);
        int i = selectorIndices[1] - 1;
        if (this.mWrapSelectorWheel && i < this.mMinValue) {
            i = this.mMaxValue;
        }
        selectorIndices[0] = i;
        ensureCachedScrollSelectorValue(i);
    }

    private void ensureCachedScrollSelectorValue(int selectorIndex) {
        String number;
        SparseArray<String> sparseArray = this.mSelectorIndexToStringCache;
        if (sparseArray.get(selectorIndex) != null) {
            return;
        }
        int i = this.mMinValue;
        if (selectorIndex < i || selectorIndex > this.mMaxValue) {
            number = "";
        } else {
            String[] strArr = this.mDisplayedValues;
            if (strArr != null) {
                number = strArr[selectorIndex - i];
            } else {
                number = formatNumber(selectorIndex);
            }
        }
        sparseArray.put(selectorIndex, number);
    }

    private String formatNumber(int value) {
        Formatter formatter = this.mFormatter;
        return formatter != null ? formatter.format(value) : formatNumberWithLocale(value);
    }

    private boolean updateInputTextView() {
        String[] strArr = this.mDisplayedValues;
        String number = strArr == null ? formatNumber(this.mValue) : strArr[this.mValue - this.mMinValue];
        if (TextUtils.isEmpty(number) || number.equals(this.mInputText.getText().toString())) {
            return false;
        }
        this.mInputText.setText(number);
        return true;
    }

    private void notifyChange(int previous, int current) {
        OnValueChangeListener onValueChangeListener = this.mOnValueChangeListener;
        if (onValueChangeListener != null) {
            onValueChangeListener.onValueChange(this, previous, this.mValue);
        }
    }

    private void postChangeCurrentByOneFromLongPress(boolean increment, long delayMillis) {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand == null) {
            this.mChangeCurrentByOneFromLongPressCommand = new ChangeCurrentByOneFromLongPressCommand();
        } else {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
        this.mChangeCurrentByOneFromLongPressCommand.setStep(increment);
        postDelayed(this.mChangeCurrentByOneFromLongPressCommand, delayMillis);
    }

    private void removeChangeCurrentByOneFromLongPress() {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand != null) {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
    }

    private void removeAllCallbacks() {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand != null) {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
        this.mPressedStateHelper.cancel();
    }

    private boolean ensureScrollWheelAdjusted() {
        int i = this.mInitialScrollOffset - this.mCurrentScrollOffset;
        if (i == 0) {
            return false;
        }
        this.mPreviousScrollerY = 0;
        int iAbs = Math.abs(i);
        int i2 = this.mSelectorElementHeight;
        if (iAbs > i2 / 2) {
            if (i > 0) {
                i2 = -i2;
            }
            i += i2;
        }
        this.mAdjustScroller.startScroll(0, 0, 0, i, 800);
        invalidate();
        return true;
    }

    class PressedStateHelper implements Runnable {
        private final int MODE_PRESS = 1;
        private final int MODE_TAPPED = 2;
        private int mManagedButton;
        private int mMode;

        PressedStateHelper() {
        }

        public void cancel() {
            this.mMode = 0;
            this.mManagedButton = 0;
            NumberPicker.this.removeCallbacks(this);
            if (NumberPicker.this.mIncrementVirtualButtonPressed) {
                NumberPicker.this.mIncrementVirtualButtonPressed = false;
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.invalidate(0, numberPicker.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
            }
            NumberPicker.this.mDecrementVirtualButtonPressed = false;
            if (NumberPicker.this.mDecrementVirtualButtonPressed) {
                NumberPicker numberPicker2 = NumberPicker.this;
                numberPicker2.invalidate(0, 0, numberPicker2.getRight(), NumberPicker.this.mTopSelectionDividerTop);
            }
        }

        public void buttonPressDelayed(int button) {
            cancel();
            this.mMode = 1;
            this.mManagedButton = button;
            NumberPicker.this.postDelayed(this, ViewConfiguration.getTapTimeout());
        }

        public void buttonTapped(int button) {
            cancel();
            this.mMode = 2;
            this.mManagedButton = button;
            NumberPicker.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.mMode;
            if (i == 1) {
                int i2 = this.mManagedButton;
                if (i2 == 1) {
                    NumberPicker.this.mIncrementVirtualButtonPressed = true;
                    NumberPicker numberPicker = NumberPicker.this;
                    numberPicker.invalidate(0, numberPicker.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                    return;
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    NumberPicker.this.mDecrementVirtualButtonPressed = true;
                    NumberPicker numberPicker2 = NumberPicker.this;
                    numberPicker2.invalidate(0, 0, numberPicker2.getRight(), NumberPicker.this.mTopSelectionDividerTop);
                    return;
                }
            }
            if (i != 2) {
                return;
            }
            int i3 = this.mManagedButton;
            if (i3 == 1) {
                if (!NumberPicker.this.mIncrementVirtualButtonPressed) {
                    NumberPicker.this.postDelayed(this, ViewConfiguration.getPressedStateDuration());
                }
                NumberPicker.access$380(NumberPicker.this, 1);
                NumberPicker numberPicker3 = NumberPicker.this;
                numberPicker3.invalidate(0, numberPicker3.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                return;
            }
            if (i3 != 2) {
                return;
            }
            if (!NumberPicker.this.mDecrementVirtualButtonPressed) {
                NumberPicker.this.postDelayed(this, ViewConfiguration.getPressedStateDuration());
            }
            NumberPicker.access$580(NumberPicker.this, 1);
            NumberPicker numberPicker4 = NumberPicker.this;
            numberPicker4.invalidate(0, 0, numberPicker4.getRight(), NumberPicker.this.mTopSelectionDividerTop);
        }
    }

    class ChangeCurrentByOneFromLongPressCommand implements Runnable {
        private boolean mIncrement;

        ChangeCurrentByOneFromLongPressCommand() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStep(boolean increment) {
            this.mIncrement = increment;
        }

        @Override // java.lang.Runnable
        public void run() {
            NumberPicker.this.changeValueByOne(this.mIncrement);
            NumberPicker numberPicker = NumberPicker.this;
            numberPicker.postDelayed(this, numberPicker.mLongPressUpdateInterval);
        }
    }

    private static String formatNumberWithLocale(int value) {
        return String.format(Locale.getDefault(), "%d", Integer.valueOf(value));
    }

    public void setDrawDividers(boolean drawDividers) {
        this.drawDividers = drawDividers;
        invalidate();
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
