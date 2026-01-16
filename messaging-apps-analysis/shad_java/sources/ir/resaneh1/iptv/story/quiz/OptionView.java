package ir.resaneh1.iptv.story.quiz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import ir.medu.shad.R;
import ir.resaneh1.iptv.story.quiz.QuizSticker;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class OptionView extends FrameLayout {
    private long animDurationEditMode;
    private long animDurationLockMode;
    private Paint backGroundPaint;
    private RectF backgroundRect;
    private int blackHintColor;
    private float borderWidth;
    private boolean changeFromCorrectModeAnimation;
    private boolean changeToCorrectModeAnimation;
    private Drawable correctDrawable;
    private Paint dashBorderGrayPaint;
    private int grayBorderColor;
    private int grayIconTextColor;
    private int greenColor;
    private int holderPadding;
    private Rect iconBoundRect;
    private Rect iconDrawableBoundRect;
    private Paint iconPaint;
    private Interpolator interpolator;
    private boolean isLock;
    private KeyListener keyListener;
    private long lastUpdateAnimation;
    private int marginEditText;
    private OptionMode mode;
    private MovementMethod movementMethod;
    private EditText optionEditText;
    private int optionEditTextPadding;
    private FrameLayout.LayoutParams optionEditTextParams;
    private String optionIcon;
    private int optionIconFontSizeDp;
    private int optionIconSize;
    private float optionIconWidthFactor;
    private int optionTextFontSizeDp;
    private int optionTextWidth;
    private OptionOrder order;
    private String previewText;
    private QuizSticker.QuizMode quizMode;
    private int redColor;
    private float scale;
    private Shader shader;
    private Paint simpleBorderGrayPaint;
    private Paint simpleBorderPaint;
    private boolean startAnimation;
    private StatusChecker statusChecker;
    private StaticLayout tempStaticLayout;
    private TextPaint tempTextPaint;
    private TextWatcher textWatcher;
    private ThemeModel theme;
    private int whiteColor;
    private int whiteHintColor;
    private Drawable wrongDrawable;

    public enum OptionMode {
        EMPTY,
        NOT_EMPTY,
        PREVIEW,
        CORRECT_ANSWER_SELECTED,
        WRONG_ANSWER_SELECTED,
        CORRECT_OPTION,
        WRONG_OPTION
    }

    public interface StatusChecker {
        void changeState(OptionOrder optionOrder, boolean z);
    }

    private float zeroOneRang(long j, long j2) {
        return j / j2;
    }

    public enum OptionOrder {
        A("Option 1"),
        B("Option 2"),
        C("Option 3"),
        D("Option 4");

        private final String text;

        OptionOrder(String str) {
            this.text = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.text;
        }
    }

    public OptionView(Context context, OptionOrder optionOrder, OptionMode optionMode, QuizSticker.QuizMode quizMode) {
        super(context);
        this.grayBorderColor = -3684409;
        this.grayIconTextColor = -6710887;
        this.blackHintColor = -862019938;
        this.greenColor = -10960094;
        this.redColor = -1226410;
        this.whiteColor = -1;
        this.whiteHintColor = -2130706433;
        this.borderWidth = AndroidUtilities.dp(2.0f);
        this.holderPadding = AndroidUtilities.dp(14.0f);
        this.marginEditText = AndroidUtilities.dp(7.0f);
        this.optionEditTextPadding = AndroidUtilities.dp(4.0f);
        this.optionTextFontSizeDp = 15;
        this.optionIconFontSizeDp = 16;
        this.animDurationLockMode = 1000L;
        this.animDurationEditMode = 200L;
        this.optionIconWidthFactor = 0.1f;
        this.previewText = "Add";
        this.textWatcher = new TextWatcher() { // from class: ir.resaneh1.iptv.story.quiz.OptionView.1
            private String lastString;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                callChecker(editable);
                changeIconColor(editable);
                OptionView.this.tempStaticLayout = new StaticLayout(editable.toString(), OptionView.this.tempTextPaint, OptionView.this.optionTextWidth - (OptionView.this.optionEditTextPadding * 2), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                if (OptionView.this.tempStaticLayout.getLineCount() > 2) {
                    OptionView.this.optionEditText.removeTextChangedListener(OptionView.this.textWatcher);
                    OptionView.this.optionEditText.setText(this.lastString);
                    OptionView.this.optionEditText.setSelection(this.lastString.length());
                    OptionView.this.optionEditText.addTextChangedListener(OptionView.this.textWatcher);
                    return;
                }
                this.lastString = editable.toString();
            }

            private void callChecker(Editable editable) {
                if (OptionView.this.statusChecker != null) {
                    if (editable.toString().length() > 0) {
                        OptionView.this.statusChecker.changeState(OptionView.this.order, false);
                    } else {
                        OptionView.this.statusChecker.changeState(OptionView.this.order, true);
                    }
                }
            }

            private void changeIconColor(Editable editable) {
                if (OptionView.this.mode == OptionMode.CORRECT_ANSWER_SELECTED || OptionView.this.mode == OptionMode.WRONG_ANSWER_SELECTED) {
                    return;
                }
                if (editable.toString().length() > 0) {
                    OptionView.this.setMode(OptionMode.NOT_EMPTY);
                } else {
                    OptionView.this.setMode(OptionMode.EMPTY);
                }
            }
        };
        this.scale = 1.0f;
        setWillNotDraw(false);
        this.mode = optionMode;
        this.quizMode = quizMode;
        if (quizMode == QuizSticker.QuizMode.STORY_LOCK) {
            setAlpha(0.5f);
        }
        setOrder(optionOrder);
        setBackgroundColor(-1);
        init();
    }

    private void init() {
        this.interpolator = new AccelerateDecelerateInterpolator();
        this.backgroundRect = new RectF();
        this.iconBoundRect = new Rect();
        this.iconDrawableBoundRect = new Rect();
        this.correctDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_correct);
        this.wrongDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_wrong);
        addOptionEdiText();
        initIconPaint();
        initDashPaint();
        initSimpleGrayPaint();
        initSimpleBlackPaint();
        initBackgroundPaint();
        initTextPaint();
        setMode(this.mode);
    }

    private void initIconPaint() {
        Paint paint = new Paint();
        this.iconPaint = paint;
        paint.setAntiAlias(true);
        this.iconPaint.setTextSize(AndroidUtilities.dp(this.optionIconFontSizeDp));
        this.iconPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.iconPaint.setColor(this.grayIconTextColor);
    }

    private void initTextPaint() {
        TextPaint textPaint = new TextPaint();
        this.tempTextPaint = textPaint;
        textPaint.setTextSize(AndroidUtilities.dp(this.optionTextFontSizeDp));
    }

    private void addOptionEdiText() {
        EditText editText = new EditText(getContext());
        this.optionEditText = editText;
        editText.setTextColor(-16777216);
        this.optionEditText.setBackground(null);
        this.optionEditText.setTextSize(1, this.optionTextFontSizeDp);
        EditText editText2 = this.optionEditText;
        int i = this.optionEditTextPadding;
        editText2.setPadding(i, i, i, i);
        if (this.quizMode == QuizSticker.QuizMode.ADD_STORY) {
            this.optionEditText.addTextChangedListener(this.textWatcher);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388627);
        this.optionEditTextParams = layoutParams;
        addView(this.optionEditText, layoutParams);
    }

    private void initBackgroundPaint() {
        Paint paint = new Paint();
        this.backGroundPaint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.backGroundPaint.setAntiAlias(true);
        this.backGroundPaint.setStrokeWidth(this.borderWidth);
    }

    private void initSimpleBlackPaint() {
        Paint paint = new Paint();
        this.simpleBorderPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.simpleBorderPaint.setAntiAlias(true);
        this.simpleBorderPaint.setStrokeWidth(this.borderWidth);
    }

    private void initSimpleGrayPaint() {
        Paint paint = new Paint();
        this.simpleBorderGrayPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.simpleBorderGrayPaint.setAntiAlias(true);
        this.simpleBorderGrayPaint.setColor(this.grayBorderColor);
        this.simpleBorderGrayPaint.setStrokeWidth(this.borderWidth);
    }

    private void initDashPaint() {
        Paint paint = new Paint();
        this.dashBorderGrayPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.dashBorderGrayPaint.setAntiAlias(true);
        this.dashBorderGrayPaint.setColor(this.grayBorderColor);
        this.dashBorderGrayPaint.setStrokeWidth(this.borderWidth);
        this.dashBorderGrayPaint.setPathEffect(new DashPathEffect(new float[]{15.0f, 10.0f, 15.0f, 10.0f}, 0.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = (int) ((1.0f - this.optionIconWidthFactor) * ((View.MeasureSpec.getSize(i) - (this.holderPadding * 2)) - this.marginEditText));
        this.optionTextWidth = size;
        this.optionEditText.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        float f = this.optionIconWidthFactor;
        int i5 = this.holderPadding;
        int i6 = this.marginEditText;
        int i7 = (int) (f * ((i - (i5 * 2)) - i6));
        this.optionIconSize = i7;
        this.optionEditTextParams.leftMargin = i5 + i7 + i6;
        setupBackgroundRect(i, i2);
        setupIconBoundRect();
        super.onSizeChanged(i, i2, i3, i4);
    }

    private void setupIconBoundRect() {
        Rect rect = this.iconDrawableBoundRect;
        rect.top = 0;
        rect.left = 0;
        int i = this.optionIconSize;
        rect.right = i;
        rect.bottom = i;
    }

    private void setupBackgroundRect(int i, int i2) {
        RectF rectF = this.backgroundRect;
        float f = this.borderWidth;
        rectF.top = f;
        rectF.left = f;
        rectF.bottom = i2 - f;
        rectF.right = i - f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        updateAnimationIfNeeded();
        drawBackground(canvas);
        drawIconBackground(canvas);
        drawIcon(canvas);
    }

    private void updateAnimationIfNeeded() {
        QuizSticker.QuizMode quizMode = this.quizMode;
        QuizSticker.QuizMode quizMode2 = QuizSticker.QuizMode.ADD_STORY;
        boolean z = quizMode == quizMode2 && (this.changeFromCorrectModeAnimation || this.changeToCorrectModeAnimation);
        this.startAnimation = z;
        if (z) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.lastUpdateAnimation == 0) {
                this.lastUpdateAnimation = jCurrentTimeMillis;
            }
            long j = jCurrentTimeMillis - this.lastUpdateAnimation;
            long j2 = (this.isLock && this.quizMode == quizMode2) ? this.animDurationLockMode : this.animDurationEditMode;
            if (j > j2) {
                this.startAnimation = false;
                this.changeToCorrectModeAnimation = false;
                this.changeFromCorrectModeAnimation = false;
            }
            float interpolation = this.interpolator.getInterpolation(zeroOneRang(j, j2));
            this.scale = interpolation;
            if (this.changeToCorrectModeAnimation) {
                this.scale = 1.0f - interpolation;
            }
            invalidate();
        }
    }

    private void drawIcon(Canvas canvas) {
        OptionMode optionMode = this.mode;
        if (optionMode == OptionMode.PREVIEW) {
            return;
        }
        OptionMode optionMode2 = OptionMode.CORRECT_OPTION;
        if (optionMode == optionMode2 || optionMode == OptionMode.WRONG_OPTION || optionMode == OptionMode.CORRECT_ANSWER_SELECTED || optionMode == OptionMode.WRONG_ANSWER_SELECTED || this.startAnimation) {
            this.correctDrawable.setBounds(this.iconDrawableBoundRect);
            this.wrongDrawable.setBounds(this.iconDrawableBoundRect);
            canvas.save();
            canvas.translate((this.holderPadding + (this.optionIconSize / 2.0f)) - this.iconDrawableBoundRect.centerX(), (getHeight() / 2.0f) - this.iconDrawableBoundRect.centerY());
            if (this.startAnimation) {
                float f = this.scale;
                canvas.scale(1.0f - f, 1.0f - f, this.iconDrawableBoundRect.centerX(), this.iconDrawableBoundRect.centerY());
            }
            OptionMode optionMode3 = this.mode;
            if (optionMode3 == optionMode2 || optionMode3 == OptionMode.CORRECT_ANSWER_SELECTED || this.startAnimation) {
                this.correctDrawable.draw(canvas);
            } else {
                this.wrongDrawable.draw(canvas);
            }
            canvas.restore();
        }
        OptionMode optionMode4 = this.mode;
        if (optionMode4 == OptionMode.EMPTY || optionMode4 == OptionMode.NOT_EMPTY || this.startAnimation) {
            Paint paint = this.iconPaint;
            String str = this.optionIcon;
            paint.getTextBounds(str, 0, str.length(), this.iconBoundRect);
            setIconPaintColor();
            canvas.save();
            float f2 = this.scale;
            canvas.scale(f2, f2, this.holderPadding + (this.optionIconSize / 2.0f), getHeight() / 2.0f);
            canvas.drawText(this.optionIcon, (this.holderPadding + (this.optionIconSize / 2.0f)) - this.iconBoundRect.centerX(), (getHeight() / 2.0f) - this.iconBoundRect.centerY(), this.iconPaint);
            canvas.restore();
        }
    }

    private void setIconPaintColor() {
        int startColor;
        if (this.theme.isGradient() && this.mode != OptionMode.EMPTY) {
            LinearGradient linearGradient = new LinearGradient((this.holderPadding + (this.optionIconSize / 2.0f)) - this.iconBoundRect.centerX(), 0.0f, this.holderPadding + (this.optionIconSize / 2.0f) + this.iconBoundRect.centerX(), 0.0f, this.theme.getStartColor(), this.theme.getEndColor(), Shader.TileMode.REPEAT);
            this.shader = linearGradient;
            this.iconPaint.setShader(linearGradient);
            return;
        }
        this.iconPaint.setShader(null);
        Paint paint = this.iconPaint;
        OptionMode optionMode = this.mode;
        if (optionMode == OptionMode.EMPTY || optionMode == OptionMode.PREVIEW) {
            startColor = this.grayIconTextColor;
        } else {
            startColor = this.theme.getStartColor();
        }
        paint.setColor(startColor);
    }

    private void drawIconBackground(Canvas canvas) {
        Paint paint;
        OptionMode optionMode = this.mode;
        OptionMode optionMode2 = OptionMode.CORRECT_OPTION;
        if (optionMode == optionMode2 || optionMode == OptionMode.WRONG_OPTION || optionMode == OptionMode.CORRECT_ANSWER_SELECTED || optionMode == OptionMode.WRONG_ANSWER_SELECTED || this.startAnimation) {
            if (optionMode == optionMode2 || optionMode == OptionMode.WRONG_OPTION) {
                this.backGroundPaint.setColor(optionMode == optionMode2 ? this.greenColor : this.redColor);
                canvas.save();
                canvas.drawCircle(this.holderPadding + (this.optionIconSize / 2.0f), getHeight() / 2.0f, this.optionIconSize / 2.0f, this.backGroundPaint);
                this.backGroundPaint.setColor(this.whiteColor);
                canvas.drawCircle(this.holderPadding + (this.optionIconSize / 2.0f), getHeight() / 2.0f, (this.optionIconSize / 2.0f) - this.borderWidth, this.backGroundPaint);
            } else {
                this.backGroundPaint.setColor(this.whiteColor);
                canvas.save();
                if (this.startAnimation) {
                    float f = this.scale;
                    canvas.scale(1.0f - f, 1.0f - f, this.holderPadding + (this.optionIconSize / 2.0f), getHeight() / 2.0f);
                }
                canvas.drawCircle(this.holderPadding + (this.optionIconSize / 2.0f), getHeight() / 2.0f, this.optionIconSize / 2.0f, this.backGroundPaint);
            }
            canvas.restore();
        }
        OptionMode optionMode3 = this.mode;
        OptionMode optionMode4 = OptionMode.PREVIEW;
        if (optionMode3 == optionMode4 || optionMode3 == OptionMode.EMPTY || optionMode3 == OptionMode.NOT_EMPTY || this.startAnimation) {
            setSimpleBorderPaintColor();
            canvas.save();
            float f2 = this.scale;
            canvas.scale(f2, f2, this.holderPadding + (this.optionIconSize / 2.0f), getHeight() / 2.0f);
            float f3 = this.holderPadding + (this.optionIconSize / 2.0f);
            float height = getHeight() / 2.0f;
            float f4 = this.optionIconSize / 2.0f;
            OptionMode optionMode5 = this.mode;
            if (optionMode5 == optionMode4) {
                paint = this.dashBorderGrayPaint;
            } else {
                paint = optionMode5 == OptionMode.NOT_EMPTY ? this.simpleBorderPaint : this.simpleBorderGrayPaint;
            }
            canvas.drawCircle(f3, height, f4, paint);
            canvas.restore();
        }
    }

    private void setSimpleBorderPaintColor() {
        if (this.theme.isGradient()) {
            LinearGradient linearGradient = new LinearGradient(this.holderPadding, 0.0f, this.optionIconSize + r1, (getHeight() / 2.0f) + (this.optionIconSize / 2.0f), this.theme.getStartColor(), this.theme.getEndColor(), Shader.TileMode.CLAMP);
            this.shader = linearGradient;
            this.simpleBorderPaint.setShader(linearGradient);
            return;
        }
        this.simpleBorderPaint.setShader(null);
        this.simpleBorderPaint.setColor(this.theme.getStartColor());
    }

    private void drawBackground(Canvas canvas) {
        OptionMode optionMode = this.mode;
        if (optionMode == OptionMode.CORRECT_ANSWER_SELECTED || optionMode == OptionMode.WRONG_ANSWER_SELECTED || this.startAnimation) {
            this.backGroundPaint.setColor(optionMode == OptionMode.WRONG_ANSWER_SELECTED ? this.redColor : this.greenColor);
            if (this.startAnimation) {
                this.backGroundPaint.setAlpha((int) ((1.0f - this.scale) * 255.0f));
            }
            canvas.drawRoundRect(this.backgroundRect, getHeight() / 2.0f, getHeight() / 2.0f, this.backGroundPaint);
        }
        OptionMode optionMode2 = this.mode;
        if (optionMode2 == OptionMode.CORRECT_OPTION || optionMode2 == OptionMode.WRONG_OPTION || optionMode2 == OptionMode.PREVIEW || optionMode2 == OptionMode.EMPTY || optionMode2 == OptionMode.NOT_EMPTY || this.startAnimation) {
            if (this.startAnimation) {
                this.simpleBorderGrayPaint.setAlpha((int) (this.scale * 255.0f));
            }
            canvas.drawRoundRect(this.backgroundRect, getHeight() / 2.0f, getHeight() / 2.0f, this.mode == OptionMode.PREVIEW ? this.dashBorderGrayPaint : this.simpleBorderGrayPaint);
        }
    }

    public void setMode(OptionMode optionMode) {
        this.scale = 1.0f;
        OptionMode optionMode2 = this.mode;
        OptionMode optionMode3 = OptionMode.CORRECT_ANSWER_SELECTED;
        if (optionMode2 == optionMode3) {
            this.changeFromCorrectModeAnimation = true;
            this.lastUpdateAnimation = 0L;
        }
        this.mode = optionMode;
        this.optionEditText.setHint(optionMode == OptionMode.PREVIEW ? this.previewText : this.order.text);
        OptionMode optionMode4 = this.mode;
        if (optionMode4 == optionMode3 || optionMode4 == OptionMode.WRONG_ANSWER_SELECTED) {
            this.changeToCorrectModeAnimation = true;
            this.lastUpdateAnimation = 0L;
            this.optionEditText.setTextColor(this.whiteColor);
            this.optionEditText.setHintTextColor(this.whiteHintColor);
        } else {
            this.optionEditText.setTextColor(QuizSticker.Colors.BLACK_COLOR.getColor());
            this.optionEditText.setHintTextColor(this.blackHintColor);
        }
        invalidate();
    }

    public void setStatusChecker(StatusChecker statusChecker) {
        this.statusChecker = statusChecker;
    }

    public OptionOrder getOrder() {
        return this.order;
    }

    public void setOrder(OptionOrder optionOrder) {
        this.order = optionOrder;
        this.optionIcon = optionOrder.name();
        EditText editText = this.optionEditText;
        if (editText != null) {
            editText.setHint(this.mode == OptionMode.PREVIEW ? this.previewText : optionOrder.text);
        }
        invalidate();
    }

    public OptionMode getMode() {
        return this.mode;
    }

    public boolean isEmpty() {
        return this.optionEditText.getText().length() == 0;
    }

    public void setLock(boolean z) {
        this.isLock = z;
        if (z) {
            if (this.quizMode == QuizSticker.QuizMode.ADD_STORY && this.mode == OptionMode.CORRECT_ANSWER_SELECTED) {
                setMode(OptionMode.NOT_EMPTY);
                invalidate();
            }
            disableViews();
            return;
        }
        enableViews();
    }

    private void enableViews() {
        this.optionEditText.setEnabled(true);
        this.optionEditText.setFocusable(true);
        this.optionEditText.setFocusableInTouchMode(true);
        MovementMethod movementMethod = this.movementMethod;
        if (movementMethod != null) {
            this.optionEditText.setMovementMethod(movementMethod);
        }
        KeyListener keyListener = this.keyListener;
        if (keyListener != null) {
            this.optionEditText.setKeyListener(keyListener);
        }
    }

    private void disableViews() {
        this.optionEditText.setEnabled(false);
        this.optionEditText.setFocusable(false);
        this.optionEditText.setFocusableInTouchMode(false);
        this.movementMethod = this.optionEditText.getMovementMethod();
        this.keyListener = this.optionEditText.getKeyListener();
        this.optionEditText.setMovementMethod(null);
        this.optionEditText.setKeyListener(null);
    }

    public void setText(String str) {
        this.optionEditText.setText(str);
    }

    public String getText() {
        return this.optionEditText.getText().toString();
    }

    public void setTheme(ThemeModel themeModel) {
        this.theme = themeModel;
        invalidate();
    }
}
