package ir.resaneh1.iptv.story.poll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class PollView extends FrameLayout {
    public int BLACK;
    public int GRAY;
    public int TEXT_GRAY;
    public int WHITE;
    private long animDuration;
    private Paint backgroundPaint;
    private int centerViewPadding;
    private boolean clickHandled;
    private float cornerSize;
    private int editTextWidth;
    private float finalLeftCx;
    private float finalLeftPercentage;
    private float finalLeftZoomToHalfHeight;
    private float finalPercentageCY;
    private float finalRightCx;
    private float finalRightZoomToHalfHeight;
    private float finalSeparator;
    private float finalTextsCY;
    private boolean firstInitial;
    private Typeface fontRegular;
    private int fontSizeHighStepPx;
    private int fontSizeLowStepPx;
    private boolean hideLeftHolder;
    private boolean hideRightHolder;
    private String hintLeft;
    private String hintRight;
    private float initialLeftCX;
    private float initialLeftPercentage;
    private float initialRightCX;
    private float initialSeparator;
    private float initialTextsCY;
    private Interpolator interpolator;
    private long lastUpdateAnimation;
    private float leftCx;
    private EditText leftEditText;
    private boolean leftEnoughSpace;
    private Paint leftHolderPaint;
    private KeyListener leftKeyListener;
    private FrameLayout.LayoutParams leftLayoutParams;
    private MovementMethod leftMovementMethod;
    private TextPaint leftPercentagePaint;
    private StaticLayout leftPercentageStaticLayout;
    private int leftTempSizePx;
    private StaticLayout leftTempStaticLayout;
    private TextPaint leftTextPaint;
    private StaticLayout leftTextStaticLayout;
    private TextWatcher leftTextWatcher;
    private float leftZoomToHalfHeight;
    private float marginBetweenOptions;
    private int maxOptionSizePx;
    private int minOptionSizePx;
    private float minScale;
    private PollAddStoryMode mode;
    private String optionLeft;
    private int optionLeftEndColor;
    private int optionLeftStartColor;
    private String optionRight;
    private int optionRightEndColor;
    private int optionRightStartColor;
    private int optionSizePx;
    private Path path;
    private float percentageCY;
    private int percentageSizePx;
    private float percentageZoom;
    private PollClickListener pollClickListener;
    private float rightCx;
    private EditText rightEditText;
    private boolean rightEnoughSpace;
    private Paint rightHolderPaint;
    private KeyListener rightKeyListener;
    private FrameLayout.LayoutParams rightLayoutParams;
    private MovementMethod rightMovementMethod;
    private TextPaint rightPercentagePaint;
    private StaticLayout rightPercentageStaticLayout;
    private int rightTempSizePx;
    private StaticLayout rightTempStaticLayout;
    private TextPaint rightTextPaint;
    private StaticLayout rightTextStaticLayout;
    private TextWatcher rightTextWatcher;
    private float rightZoomToHalfHeight;
    private float separator;
    private float separatorInterpolation;
    private Paint separatorPaint;
    private int shareLeftEndColor;
    private int shareLeftStartColor;
    private int shareRightEndColor;
    private int shareRightStartColor;
    private boolean showPercentage;
    private boolean startTransferAnimation;
    private int textStaticLayoutWidth;
    private int textViewPadding;
    private float textsCY;
    private int textsMaxHeight;
    int tryCount;
    private static int pollWidth = AndroidUtilities.dp(243.0f);
    private static int pollHeight = AndroidUtilities.dp(77.0f);

    public enum PollAddStoryMode {
        LOCK,
        EDIT,
        STORY,
        VOTED,
        SHARE
    }

    public interface PollClickListener {
        void onAnimationFinished();

        void onAnimationStart();

        void onLeftClicked();

        void onRightClicked();
    }

    public enum PollOption {
        LEFT,
        RIGHT,
        NONE
    }

    private float realRang(float f, float f2) {
        return f2 * f;
    }

    private float zeroOneRang(long j, long j2) {
        return j / j2;
    }

    static /* synthetic */ int access$020(PollView pollView, int i) {
        int i2 = pollView.leftTempSizePx - i;
        pollView.leftTempSizePx = i2;
        return i2;
    }

    static /* synthetic */ int access$1220(PollView pollView, int i) {
        int i2 = pollView.rightTempSizePx - i;
        pollView.rightTempSizePx = i2;
        return i2;
    }

    public class PollInterpolator implements Interpolator {
        public float f = 2.6f;
        public float d = -28.0f;
        public float b = 100.0f;
        public float w = 0.029f;
        public float A = -40.0f;
        public float p = 400.0f;
        public float a = 0.015f;

        public PollInterpolator(PollView pollView) {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return getBezierCoordinateY(f * 100.0f) / 100.0f;
        }

        protected float getBezierCoordinateY(float f) {
            double d = this.A;
            double dExp = Math.exp((-this.a) * ((this.f * f) + this.d));
            Double.isNaN(d);
            double dCos = d * dExp * Math.cos(this.w * (((f * this.f) + this.d) - this.p));
            double d2 = this.b;
            Double.isNaN(d2);
            return (float) (dCos + d2);
        }
    }

    public PollView(Context context, PollAddStoryMode pollAddStoryMode) {
        super(context);
        this.shareLeftStartColor = -16598282;
        this.shareRightStartColor = -162761;
        this.shareRightEndColor = -48996;
        this.shareLeftEndColor = -14164949;
        this.optionLeftStartColor = -15291656;
        this.optionLeftEndColor = -14695298;
        this.optionRightStartColor = -495562;
        this.optionRightEndColor = -376979;
        this.WHITE = -1;
        this.BLACK = -16777216;
        this.GRAY = -2368549;
        this.TEXT_GRAY = -6710887;
        this.cornerSize = AndroidUtilities.dp(10.0f);
        this.textViewPadding = AndroidUtilities.dp(8.0f);
        this.marginBetweenOptions = AndroidUtilities.dp(3.0f);
        this.centerViewPadding = this.textViewPadding / 2;
        this.maxOptionSizePx = AndroidUtilities.dp(40.0f);
        this.minOptionSizePx = AndroidUtilities.dp(18.0f);
        this.percentageSizePx = AndroidUtilities.dp(50.0f);
        this.animDuration = 550L;
        this.fontSizeHighStepPx = AndroidUtilities.dp(5.0f);
        this.fontSizeLowStepPx = AndroidUtilities.dp(1.0f);
        this.minScale = 1.0f;
        this.initialLeftPercentage = 50.0f;
        this.hintLeft = "YES";
        this.hintRight = "NO";
        this.optionLeft = "YES";
        this.optionRight = "NO";
        int i = this.maxOptionSizePx;
        this.optionSizePx = i;
        this.leftZoomToHalfHeight = 1.0f;
        this.finalLeftZoomToHalfHeight = 1.0f;
        this.rightZoomToHalfHeight = 1.0f;
        this.finalRightZoomToHalfHeight = 1.0f;
        this.leftEnoughSpace = true;
        this.rightEnoughSpace = true;
        this.leftTempSizePx = i;
        this.rightTempSizePx = i;
        this.firstInitial = true;
        this.leftTextWatcher = new TextWatcher() { // from class: ir.resaneh1.iptv.story.poll.PollView.1
            private String lastString;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Editable editableValidateInput = validateInput(editable);
                PollView pollView = PollView.this;
                pollView.leftTempSizePx = pollView.maxOptionSizePx;
                PollView.this.leftEditText.setTextSize(0, PollView.this.maxOptionSizePx);
                PollView.this.leftTempStaticLayout = new StaticLayout(editableValidateInput.toString(), PollView.this.leftEditText.getPaint(), PollView.this.textStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                while (true) {
                    if (PollView.this.leftTempStaticLayout.getHeight() <= PollView.this.textsMaxHeight && (PollView.this.leftTempStaticLayout.getLineCount() <= 2 || PollView.this.leftTempSizePx - PollView.this.fontSizeLowStepPx < PollView.this.minOptionSizePx)) {
                        break;
                    } else {
                        changeLeftEditTextFontSize(editableValidateInput.toString());
                    }
                }
                PollView pollView2 = PollView.this;
                float fMinLeft = pollView2.minLeft(pollView2.leftTempStaticLayout);
                PollView pollView3 = PollView.this;
                float fMinLeft2 = pollView3.minLeft(pollView3.leftTempStaticLayout);
                PollView pollView4 = PollView.this;
                pollView2.setupLeftEditTextShader(fMinLeft, fMinLeft2 + pollView4.maxWidth(pollView4.leftTempStaticLayout));
            }

            private Editable validateInput(Editable editable) {
                TextPaint paint = PollView.this.leftEditText.getPaint();
                paint.setTextSize(PollView.this.minOptionSizePx);
                PollView.this.leftTempStaticLayout = new StaticLayout(editable.toString(), paint, PollView.this.textStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                if (PollView.this.leftTempStaticLayout.getLineCount() > 2) {
                    PollView.this.leftEditText.removeTextChangedListener(PollView.this.leftTextWatcher);
                    editable = editable.replace(0, editable.toString().length(), this.lastString);
                    PollView.this.leftEditText.setText(this.lastString);
                    PollView.this.leftEditText.setSelection(this.lastString.length());
                    PollView.this.leftEditText.addTextChangedListener(PollView.this.leftTextWatcher);
                }
                this.lastString = editable.toString();
                return editable;
            }

            private void changeLeftEditTextFontSize(String str) {
                PollView pollView = PollView.this;
                PollView.access$020(pollView, pollView.fontSizeLowStepPx);
                PollView.this.leftEditText.setTextSize(0, PollView.this.leftTempSizePx);
                PollView.this.leftTempStaticLayout = new StaticLayout(str, PollView.this.leftEditText.getPaint(), PollView.this.textStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            }
        };
        this.rightTextWatcher = new TextWatcher() { // from class: ir.resaneh1.iptv.story.poll.PollView.2
            private String lastString;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Editable editableValidateInput = validateInput(editable);
                PollView pollView = PollView.this;
                pollView.rightTempSizePx = pollView.maxOptionSizePx;
                PollView.this.rightEditText.setTextSize(0, PollView.this.maxOptionSizePx);
                PollView.this.rightTempStaticLayout = new StaticLayout(editableValidateInput.toString(), PollView.this.rightEditText.getPaint(), PollView.this.textStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                while (true) {
                    if (PollView.this.rightTempStaticLayout.getHeight() <= PollView.this.textsMaxHeight && (PollView.this.rightTempStaticLayout.getLineCount() <= 2 || PollView.this.rightTempSizePx - PollView.this.fontSizeLowStepPx < PollView.this.minOptionSizePx)) {
                        break;
                    } else {
                        changeRightEditTextFontSize(editableValidateInput.toString(), PollView.this.textStaticLayoutWidth);
                    }
                }
                PollView pollView2 = PollView.this;
                float fMinLeft = pollView2.minLeft(pollView2.rightTempStaticLayout);
                PollView pollView3 = PollView.this;
                float fMinLeft2 = pollView3.minLeft(pollView3.rightTempStaticLayout);
                PollView pollView4 = PollView.this;
                pollView2.setupRightEditTextShader(fMinLeft, fMinLeft2 + pollView4.maxWidth(pollView4.rightTempStaticLayout));
            }

            private Editable validateInput(Editable editable) {
                TextPaint paint = PollView.this.rightEditText.getPaint();
                paint.setTextSize(PollView.this.minOptionSizePx);
                PollView.this.rightTempStaticLayout = new StaticLayout(editable.toString(), paint, PollView.this.textStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                if (PollView.this.rightTempStaticLayout.getLineCount() > 2) {
                    PollView.this.rightEditText.removeTextChangedListener(PollView.this.rightTextWatcher);
                    editable = editable.replace(0, editable.toString().length(), this.lastString);
                    PollView.this.rightEditText.setText(this.lastString);
                    PollView.this.rightEditText.setSelection(this.lastString.length());
                    PollView.this.rightEditText.addTextChangedListener(PollView.this.rightTextWatcher);
                }
                this.lastString = editable.toString();
                return editable;
            }

            private void changeRightEditTextFontSize(String str, int i2) {
                PollView pollView = PollView.this;
                PollView.access$1220(pollView, pollView.fontSizeLowStepPx);
                PollView.this.rightEditText.setTextSize(0, PollView.this.rightTempSizePx);
                PollView.this.rightTempStaticLayout = new StaticLayout(str, PollView.this.rightEditText.getPaint(), i2, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            }
        };
        this.tryCount = 0;
        setWillNotDraw(false);
        init();
        setMode(pollAddStoryMode);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = pollWidth;
        this.editTextWidth = (int) ((i3 / 2) - (this.marginBetweenOptions / 2.0f));
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(pollHeight, 1073741824));
        PollAddStoryMode pollAddStoryMode = this.mode;
        if (pollAddStoryMode == PollAddStoryMode.EDIT || pollAddStoryMode == PollAddStoryMode.LOCK) {
            this.leftEditText.measure(View.MeasureSpec.makeMeasureSpec(this.editTextWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(pollHeight, 1073741824));
            this.rightEditText.measure(View.MeasureSpec.makeMeasureSpec(this.editTextWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(pollHeight, 1073741824));
            if (this.firstInitial) {
                this.firstInitial = false;
                setupLeftEditTextShader(0.0f, this.editTextWidth);
                setupRightEditTextShader(0.0f, this.editTextWidth);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5 = pollWidth;
        int i6 = pollHeight;
        float f = i5;
        float f2 = (this.initialLeftPercentage / 100.0f) * f;
        this.initialSeparator = f2;
        this.separator = f2;
        int i7 = this.editTextWidth;
        int i8 = this.textViewPadding;
        this.textStaticLayoutWidth = i7 - (i8 * 2);
        this.textsMaxHeight = (i6 - (i8 * 2)) - (this.centerViewPadding * 2);
        setupLeftStaticLayout();
        setupRightStaticLayout();
        float f3 = (this.initialLeftPercentage / 100.0f) * f;
        float f4 = this.marginBetweenOptions;
        float f5 = (f3 - (f4 / 2.0f)) / 2.0f;
        this.initialLeftCX = f5;
        this.leftCx = f5;
        float f6 = f5 + this.textStaticLayoutWidth + f4 + (this.textViewPadding * 2);
        this.initialRightCX = f6;
        this.rightCx = f6;
        float f7 = i6 / 2.0f;
        this.initialTextsCY = f7;
        this.textsCY = f7;
        PollAddStoryMode pollAddStoryMode = this.mode;
        if ((pollAddStoryMode == PollAddStoryMode.VOTED || pollAddStoryMode == PollAddStoryMode.SHARE) && this.firstInitial) {
            this.firstInitial = false;
            calculateDistances(i5, i6);
            if (this.mode == PollAddStoryMode.SHARE) {
                setupShader(i5, i6);
            }
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    private void setupShader(int i, int i2) {
        float f = i2;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.separator, f, this.shareLeftStartColor, this.shareLeftEndColor, Shader.TileMode.REPEAT);
        LinearGradient linearGradient2 = new LinearGradient(this.separator, 0.0f, i, f, this.shareRightStartColor, this.shareRightEndColor, Shader.TileMode.REPEAT);
        if (this.finalLeftPercentage >= 50.0f) {
            this.leftHolderPaint.setShader(linearGradient);
        }
        if (this.finalLeftPercentage <= 50.0f) {
            this.rightHolderPaint.setShader(linearGradient2);
        }
    }

    public boolean onClick(float f, float f2) {
        PollClickListener pollClickListener = this.pollClickListener;
        if (pollClickListener == null || this.clickHandled || this.mode != PollAddStoryMode.STORY) {
            return false;
        }
        float f3 = this.initialSeparator;
        if (f <= f3) {
            this.clickHandled = true;
            pollClickListener.onLeftClicked();
            this.leftHolderPaint.setColor(this.GRAY);
        } else if (f > f3) {
            this.clickHandled = true;
            pollClickListener.onRightClicked();
            this.rightHolderPaint.setColor(this.GRAY);
        }
        return this.clickHandled;
    }

    private void init() {
        setupOptionsPaint();
        this.interpolator = new PollInterpolator(this);
        Paint paint = new Paint(1);
        this.backgroundPaint = paint;
        paint.setColor(this.WHITE);
        Paint paint2 = new Paint(1);
        this.separatorPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.separatorPaint.setColor(this.GRAY);
        this.leftHolderPaint = new Paint(1);
        this.rightHolderPaint = new Paint(1);
        this.path = new Path();
        this.leftHolderPaint.setColor(this.WHITE);
        this.leftHolderPaint.setStyle(Paint.Style.FILL);
        this.rightHolderPaint.setStyle(Paint.Style.FILL);
        this.rightHolderPaint.setColor(this.WHITE);
    }

    private void addEditTexts() {
        addLeftEditText();
        addRightEditText();
    }

    private void addRightEditText() {
        if (this.rightEditText == null) {
            EditText editText = new EditText(getContext());
            this.rightEditText = editText;
            editText.setTypeface(this.fontRegular);
            this.rightEditText.setHint(this.hintRight);
            this.rightEditText.setTextSize(0, this.maxOptionSizePx);
            this.rightEditText.setMaxLines(2);
            this.rightEditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
            if (Build.VERSION.SDK_INT >= 17) {
                this.rightEditText.setTextAlignment(4);
            }
            EditText editText2 = this.rightEditText;
            int i = this.textViewPadding;
            editText2.setPadding(i, i / 2, i, i / 2);
            this.rightEditText.setBackgroundResource(R.drawable.poll_right_round_rect);
            this.rightEditText.setInputType(655361);
            this.rightEditText.addTextChangedListener(this.rightTextWatcher);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 21);
            this.rightLayoutParams = layoutParams;
            addView(this.rightEditText, layoutParams);
        }
    }

    private void addLeftEditText() {
        if (this.leftEditText == null) {
            EditText editText = new EditText(getContext());
            this.leftEditText = editText;
            editText.setTypeface(this.fontRegular);
            this.leftEditText.setHint(this.hintLeft);
            this.leftEditText.setTextSize(0, this.maxOptionSizePx);
            this.leftEditText.setMaxLines(2);
            this.leftEditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
            if (Build.VERSION.SDK_INT >= 17) {
                this.leftEditText.setTextAlignment(4);
            }
            EditText editText2 = this.leftEditText;
            int i = this.textViewPadding;
            editText2.setPadding(i, i / 2, i, i / 2);
            this.leftEditText.setBackgroundResource(R.drawable.poll_left_round_rect);
            this.leftEditText.setInputType(655361);
            this.leftEditText.addTextChangedListener(this.leftTextWatcher);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 19);
            this.leftLayoutParams = layoutParams;
            addView(this.leftEditText, layoutParams);
        }
    }

    private void setupRightStaticLayout() {
        this.optionSizePx = this.maxOptionSizePx;
        this.rightTextStaticLayout = new StaticLayout(this.optionRight, this.rightTextPaint, this.textStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        while (true) {
            if (maxHeight(this.rightTextStaticLayout) > this.textsMaxHeight || this.rightTextStaticLayout.getLineCount() > 2) {
                changeRightTextFontSize(this.textStaticLayoutWidth, -this.fontSizeLowStepPx);
            } else {
                setupRightStaticLayoutShader();
                return;
            }
        }
    }

    private void setupLeftStaticLayout() {
        this.optionSizePx = this.maxOptionSizePx;
        this.leftTextStaticLayout = new StaticLayout(this.optionLeft, this.leftTextPaint, this.textStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        while (true) {
            if (maxHeight(this.leftTextStaticLayout) > this.textsMaxHeight || this.leftTextStaticLayout.getLineCount() > 2) {
                changeLeftTextFontSize(this.textStaticLayoutWidth, -this.fontSizeLowStepPx);
            } else {
                setupLeftStaticLayoutShader();
                return;
            }
        }
    }

    private void setupPercentageStaticLayouts(int i) {
        this.leftPercentageStaticLayout = new StaticLayout(((int) this.finalLeftPercentage) + "%", this.leftPercentagePaint, this.textStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        boundStaticLayoutToHalfOfHeight(true, i);
        this.rightPercentageStaticLayout = new StaticLayout((100 - ((int) this.finalLeftPercentage)) + "%", this.rightPercentagePaint, this.textStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        boundStaticLayoutToHalfOfHeight(false, i);
    }

    private void boundStaticLayoutToHalfOfHeight(boolean z, int i) {
        float fMaxHeight;
        float fMaxHeight2;
        this.optionSizePx = this.maxOptionSizePx;
        float f = ((i / 2.0f) - this.centerViewPadding) - this.textViewPadding;
        while (true) {
            if (z) {
                fMaxHeight = maxHeight(this.leftPercentageStaticLayout);
            } else {
                fMaxHeight = maxHeight(this.rightPercentageStaticLayout);
            }
            if (fMaxHeight <= f) {
                break;
            } else {
                changePercentageFontSize(z, -this.fontSizeHighStepPx);
            }
        }
        while (true) {
            if (z) {
                fMaxHeight2 = maxHeight(this.leftPercentageStaticLayout);
            } else {
                fMaxHeight2 = maxHeight(this.rightPercentageStaticLayout);
            }
            if (fMaxHeight2 <= f) {
                changePercentageFontSize(z, this.fontSizeLowStepPx);
            } else {
                changePercentageFontSize(z, -this.fontSizeLowStepPx);
                return;
            }
        }
    }

    private float maxHeight(StaticLayout staticLayout) {
        return staticLayout.getHeight() + (staticLayout.getTopPadding() * 2);
    }

    private void changeLeftTextFontSize(int i, int i2) {
        int i3 = this.optionSizePx + i2;
        this.optionSizePx = i3;
        this.leftTextPaint.setTextSize(i3);
        this.leftTextStaticLayout = new StaticLayout(this.optionLeft, this.leftTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
    }

    private void changeRightTextFontSize(int i, int i2) {
        int i3 = this.optionSizePx + i2;
        this.optionSizePx = i3;
        this.rightTextPaint.setTextSize(i3);
        this.rightTextStaticLayout = new StaticLayout(this.optionRight, this.rightTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
    }

    private void changePercentageFontSize(boolean z, int i) {
        int i2 = this.optionSizePx + i;
        this.optionSizePx = i2;
        if (z) {
            this.leftPercentagePaint.setTextSize(i2);
        } else {
            this.rightPercentagePaint.setTextSize(i2);
        }
        if (z) {
            this.leftPercentageStaticLayout = new StaticLayout(((int) this.finalLeftPercentage) + "%", this.leftPercentagePaint, this.textStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            return;
        }
        this.rightPercentageStaticLayout = new StaticLayout((100 - ((int) this.finalLeftPercentage)) + "%", this.rightPercentagePaint, this.textStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
    }

    private void setupOptionsPaint() {
        this.fontRegular = Typeface.createFromAsset(getContext().getAssets(), "fonts/AvenyTRegular.otf");
        this.leftTextPaint = new TextPaint();
        this.rightTextPaint = new TextPaint();
        this.leftPercentagePaint = new TextPaint();
        this.rightPercentagePaint = new TextPaint();
        this.rightTextPaint.setAntiAlias(true);
        this.leftTextPaint.setAntiAlias(true);
        this.leftPercentagePaint.setAntiAlias(true);
        this.rightPercentagePaint.setAntiAlias(true);
        this.leftPercentagePaint.setColor(this.BLACK);
        this.rightPercentagePaint.setColor(this.BLACK);
        this.leftTextPaint.setTextSize(this.maxOptionSizePx);
        this.rightTextPaint.setTextSize(this.maxOptionSizePx);
        this.leftPercentagePaint.setTextSize(this.percentageSizePx);
        this.rightPercentagePaint.setTextSize(this.percentageSizePx);
        this.leftTextPaint.setTypeface(this.fontRegular);
        this.rightTextPaint.setTypeface(this.fontRegular);
        this.leftPercentagePaint.setTypeface(this.fontRegular);
        this.rightPercentagePaint.setTypeface(this.fontRegular);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            drawBackground(canvas);
            updateTransferAnimationIfNeeded();
            drawHolders(canvas);
            drawTextsIfNeeded(canvas);
            this.tryCount = 0;
        } catch (Exception unused) {
            if (this.tryCount < 10) {
                invalidate();
            }
            this.tryCount++;
        }
    }

    private void drawHolders(Canvas canvas) {
        if (this.hideLeftHolder) {
            drawLeftHolder(canvas);
            drawRightHolder(canvas);
        } else {
            drawRightHolder(canvas);
            drawLeftHolder(canvas);
        }
        if (this.mode == PollAddStoryMode.SHARE || this.hideLeftHolder || this.hideRightHolder) {
            return;
        }
        float f = this.separator;
        float f2 = this.marginBetweenOptions;
        canvas.drawRect(f - (f2 / 2.0f), 0.0f, f + (f2 / 2.0f), getHeight(), this.separatorPaint);
    }

    private void drawBackground(Canvas canvas) {
        this.path.reset();
        this.path.moveTo(this.cornerSize, 0.0f);
        this.path.rLineTo(getWidth() - (this.cornerSize * 2.0f), 0.0f);
        Path path = this.path;
        float f = this.cornerSize;
        path.rLineTo(f, f);
        this.path.rLineTo(0.0f, getHeight() - (this.cornerSize * 2.0f));
        Path path2 = this.path;
        float f2 = this.cornerSize;
        path2.rLineTo(-f2, f2);
        this.path.rLineTo((-getWidth()) + (this.cornerSize * 2.0f), 0.0f);
        Path path3 = this.path;
        float f3 = this.cornerSize;
        path3.rLineTo(-f3, -f3);
        this.path.rLineTo(0.0f, (-getHeight()) + (this.cornerSize * 2.0f));
        Path path4 = this.path;
        float f4 = this.cornerSize;
        path4.rLineTo(f4, -f4);
        Path path5 = this.path;
        float f5 = this.cornerSize;
        path5.addCircle(f5, f5, f5, Path.Direction.CW);
        Path path6 = this.path;
        float width = getWidth();
        float f6 = this.cornerSize;
        path6.addCircle(width - f6, f6, f6, Path.Direction.CW);
        Path path7 = this.path;
        float width2 = getWidth() - this.cornerSize;
        float height = getHeight();
        float f7 = this.cornerSize;
        path7.addCircle(width2, height - f7, f7, Path.Direction.CW);
        Path path8 = this.path;
        float f8 = this.cornerSize;
        float height2 = getHeight();
        float f9 = this.cornerSize;
        path8.addCircle(f8, height2 - f9, f9, Path.Direction.CW);
        canvas.drawPath(this.path, this.backgroundPaint);
    }

    private void drawLeftHolder(Canvas canvas) {
        if (!this.hideLeftHolder || this.separator >= this.cornerSize) {
            if (this.hideRightHolder) {
                this.path.reset();
                this.path.moveTo(this.cornerSize, 0.0f);
                this.path.rLineTo(this.separator - (this.cornerSize * 2.0f), 0.0f);
                Path path = this.path;
                float f = this.cornerSize;
                path.rLineTo(f, f);
                this.path.rLineTo(0.0f, getHeight() - (this.cornerSize * 2.0f));
                Path path2 = this.path;
                float f2 = this.cornerSize;
                path2.rLineTo(-f2, f2);
                this.path.rLineTo((-this.separator) + (this.cornerSize * 2.0f), 0.0f);
                Path path3 = this.path;
                float f3 = this.cornerSize;
                path3.rLineTo(-f3, -f3);
                this.path.rLineTo(0.0f, (-getHeight()) + (this.cornerSize * 2.0f));
                Path path4 = this.path;
                float f4 = this.cornerSize;
                path4.rLineTo(f4, -f4);
                Path path5 = this.path;
                float f5 = this.cornerSize;
                path5.addCircle(f5, f5, f5, Path.Direction.CW);
                Path path6 = this.path;
                float f6 = this.cornerSize;
                float height = getHeight();
                float f7 = this.cornerSize;
                path6.addCircle(f6, height - f7, f7, Path.Direction.CW);
                Path path7 = this.path;
                float f8 = this.separator;
                float f9 = this.cornerSize;
                path7.addCircle(f8 - f9, f9, f9, Path.Direction.CW);
                Path path8 = this.path;
                float f10 = this.separator - this.cornerSize;
                float height2 = getHeight();
                float f11 = this.cornerSize;
                path8.addCircle(f10, height2 - f11, f11, Path.Direction.CW);
            } else {
                this.path.reset();
                this.path.moveTo(this.cornerSize, 0.0f);
                this.path.rLineTo(this.separator - this.cornerSize, 0.0f);
                this.path.rLineTo(0.0f, getHeight());
                this.path.rLineTo((-this.separator) + this.cornerSize, 0.0f);
                Path path9 = this.path;
                float f12 = this.cornerSize;
                path9.rLineTo(-f12, -f12);
                this.path.rLineTo(0.0f, (-getHeight()) + (this.cornerSize * 2.0f));
                Path path10 = this.path;
                float f13 = this.cornerSize;
                path10.rLineTo(f13, -f13);
                Path path11 = this.path;
                float f14 = this.cornerSize;
                path11.addCircle(f14, f14, f14, Path.Direction.CW);
                Path path12 = this.path;
                float f15 = this.cornerSize;
                float height3 = getHeight();
                float f16 = this.cornerSize;
                path12.addCircle(f15, height3 - f16, f16, Path.Direction.CW);
            }
            canvas.drawPath(this.path, this.leftHolderPaint);
        }
    }

    private void drawRightHolder(Canvas canvas) {
        if (!this.hideRightHolder || this.separator <= getWidth() - this.cornerSize) {
            if (this.hideLeftHolder) {
                this.path.reset();
                this.path.moveTo(this.separator + this.cornerSize, 0.0f);
                this.path.lineTo(getWidth() - this.cornerSize, 0.0f);
                Path path = this.path;
                float f = this.cornerSize;
                path.rLineTo(f, f);
                this.path.rLineTo(0.0f, getHeight() - (this.cornerSize * 2.0f));
                Path path2 = this.path;
                float f2 = this.cornerSize;
                path2.rLineTo(-f2, f2);
                this.path.lineTo(this.separator + this.cornerSize, getHeight());
                Path path3 = this.path;
                float f3 = this.cornerSize;
                path3.rLineTo(-f3, -f3);
                this.path.rLineTo(0.0f, (-getHeight()) + (this.cornerSize * 2.0f));
                Path path4 = this.path;
                float f4 = this.cornerSize;
                path4.rLineTo(f4, -f4);
                Path path5 = this.path;
                float width = getWidth();
                float f5 = this.cornerSize;
                path5.addCircle(width - f5, f5, f5, Path.Direction.CW);
                Path path6 = this.path;
                float width2 = getWidth() - this.cornerSize;
                float height = getHeight();
                float f6 = this.cornerSize;
                path6.addCircle(width2, height - f6, f6, Path.Direction.CW);
                Path path7 = this.path;
                float f7 = this.separator;
                float f8 = this.cornerSize;
                path7.addCircle(f7 + f8, f8, f8, Path.Direction.CW);
                Path path8 = this.path;
                float f9 = this.separator + this.cornerSize;
                float height2 = getHeight();
                float f10 = this.cornerSize;
                path8.addCircle(f9, height2 - f10, f10, Path.Direction.CW);
            } else {
                this.path.reset();
                this.path.moveTo(this.separator, 0.0f);
                this.path.lineTo(getWidth() - this.cornerSize, 0.0f);
                Path path9 = this.path;
                float f11 = this.cornerSize;
                path9.rLineTo(f11, f11);
                this.path.rLineTo(0.0f, getHeight() - (this.cornerSize * 2.0f));
                Path path10 = this.path;
                float f12 = this.cornerSize;
                path10.rLineTo(-f12, f12);
                this.path.lineTo(this.separator, getHeight());
                this.path.rLineTo(0.0f, -getHeight());
                Path path11 = this.path;
                float width3 = getWidth();
                float f13 = this.cornerSize;
                path11.addCircle(width3 - f13, f13, f13, Path.Direction.CW);
                Path path12 = this.path;
                float width4 = getWidth() - this.cornerSize;
                float height3 = getHeight();
                float f14 = this.cornerSize;
                path12.addCircle(width4, height3 - f14, f14, Path.Direction.CW);
            }
            canvas.drawPath(this.path, this.rightHolderPaint);
        }
    }

    private void drawTextsIfNeeded(Canvas canvas) {
        PollAddStoryMode pollAddStoryMode = this.mode;
        if (pollAddStoryMode == PollAddStoryMode.STORY || pollAddStoryMode == PollAddStoryMode.VOTED || pollAddStoryMode == PollAddStoryMode.SHARE) {
            float width = this.leftCx - (this.leftTextStaticLayout.getWidth() / 2.0f);
            float height = this.textsCY - (this.leftTextStaticLayout.getHeight() / 2.0f);
            float width2 = this.rightCx - (this.rightTextStaticLayout.getWidth() / 2.0f);
            float height2 = this.textsCY - (this.rightTextStaticLayout.getHeight() / 2.0f);
            boolean z = this.leftEnoughSpace;
            if (z && this.rightEnoughSpace) {
                drawTextsCenter(canvas, width, height, width2, height2);
            } else if (z) {
                drawNoEnoughSpaceForRightText(canvas, width2, height2, width, height);
            } else {
                drawNoEnoughSpaceForLeftText(canvas, width, height, width2, height2);
            }
        }
    }

    private void drawNoEnoughSpaceForLeftText(Canvas canvas, float f, float f2, float f3, float f4) {
        canvas.save();
        float f5 = this.leftZoomToHalfHeight;
        canvas.scale(f5, f5);
        float f6 = this.leftZoomToHalfHeight;
        canvas.translate(f, (f2 / f6) + (((1.0f - f6) * this.leftTextStaticLayout.getHeight()) / (this.leftZoomToHalfHeight * 2.0f)));
        this.leftTextStaticLayout.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate((this.leftCx * this.leftZoomToHalfHeight) - (this.leftPercentageStaticLayout.getWidth() / 2.0f), this.percentageCY - (this.leftPercentageStaticLayout.getHeight() / 2.0f));
        float f7 = this.percentageZoom;
        canvas.scale(f7, f7, this.leftPercentageStaticLayout.getWidth() / 2.0f, this.leftPercentageStaticLayout.getHeight() / 2.0f);
        this.leftPercentageStaticLayout.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate(f3, f4);
        float f8 = this.rightZoomToHalfHeight;
        canvas.scale(f8, f8);
        float width = (1.0f - this.rightZoomToHalfHeight) * this.rightTextStaticLayout.getWidth();
        float f9 = this.rightZoomToHalfHeight;
        canvas.translate(width / (f9 * 2.0f), ((1.0f - f9) * this.rightTextStaticLayout.getHeight()) / (this.rightZoomToHalfHeight * 2.0f));
        if (!this.hideLeftHolder) {
            canvas.translate(((-(1.0f - this.leftZoomToHalfHeight)) * this.leftTextStaticLayout.getWidth()) / (this.rightZoomToHalfHeight * 2.0f), 0.0f);
        }
        this.rightTextStaticLayout.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate(this.rightCx - (this.rightPercentageStaticLayout.getWidth() / 2.0f), this.percentageCY - (this.rightPercentageStaticLayout.getHeight() / 2.0f));
        if (!this.hideLeftHolder) {
            canvas.translate(((-(1.0f - this.leftZoomToHalfHeight)) * this.leftTextStaticLayout.getWidth()) / 2.0f, 0.0f);
        }
        float f10 = this.percentageZoom;
        canvas.scale(f10, f10, this.rightPercentageStaticLayout.getWidth() / 2.0f, this.rightPercentageStaticLayout.getHeight() / 2.0f);
        this.rightPercentageStaticLayout.draw(canvas);
        canvas.restore();
    }

    private void drawNoEnoughSpaceForRightText(Canvas canvas, float f, float f2, float f3, float f4) {
        canvas.save();
        float f5 = this.rightZoomToHalfHeight;
        canvas.scale(f5, f5, getWidth(), 0.0f);
        float f6 = this.rightZoomToHalfHeight;
        canvas.translate(f, (f2 / f6) + (((1.0f - f6) * this.rightTextStaticLayout.getHeight()) / (this.rightZoomToHalfHeight * 2.0f)));
        this.rightTextStaticLayout.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate((((1.0f - this.rightZoomToHalfHeight) * getWidth()) + (this.rightCx * this.rightZoomToHalfHeight)) - (this.rightPercentageStaticLayout.getWidth() / 2.0f), this.percentageCY - (this.rightPercentageStaticLayout.getHeight() / 2.0f));
        float f7 = this.percentageZoom;
        canvas.scale(f7, f7, this.rightPercentageStaticLayout.getWidth() / 2.0f, this.rightPercentageStaticLayout.getHeight() / 2.0f);
        this.rightPercentageStaticLayout.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate(f3, f4);
        float f8 = this.leftZoomToHalfHeight;
        canvas.scale(f8, f8);
        float width = (1.0f - this.leftZoomToHalfHeight) * this.leftTextStaticLayout.getWidth();
        float f9 = this.leftZoomToHalfHeight;
        canvas.translate(width / (f9 * 2.0f), ((1.0f - f9) * this.leftTextStaticLayout.getHeight()) / (this.leftZoomToHalfHeight * 2.0f));
        if (!this.hideRightHolder) {
            canvas.translate(((1.0f - this.rightZoomToHalfHeight) * (this.textViewPadding + (maxWidth(this.rightTextStaticLayout) / 2.0f))) / this.leftZoomToHalfHeight, 0.0f);
        }
        this.leftTextStaticLayout.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate(this.leftCx - (this.leftPercentageStaticLayout.getWidth() / 2.0f), this.percentageCY - (this.leftPercentageStaticLayout.getHeight() / 2.0f));
        if (!this.hideRightHolder) {
            canvas.translate((1.0f - this.rightZoomToHalfHeight) * (this.textViewPadding + (maxWidth(this.rightTextStaticLayout) / 2.0f)), 0.0f);
        }
        float f10 = this.percentageZoom;
        canvas.scale(f10, f10, this.leftPercentageStaticLayout.getWidth() / 2.0f, this.leftPercentageStaticLayout.getHeight() / 2.0f);
        this.leftPercentageStaticLayout.draw(canvas);
        canvas.restore();
    }

    private void drawTextsCenter(Canvas canvas, float f, float f2, float f3, float f4) {
        canvas.save();
        canvas.translate(f, f2);
        float f5 = this.leftZoomToHalfHeight;
        canvas.scale(f5, f5);
        float width = (1.0f - this.leftZoomToHalfHeight) * this.leftTextStaticLayout.getWidth();
        float f6 = this.leftZoomToHalfHeight;
        canvas.translate(width / (f6 * 2.0f), ((1.0f - f6) * this.leftTextStaticLayout.getHeight()) / (this.leftZoomToHalfHeight * 2.0f));
        this.leftTextStaticLayout.draw(canvas);
        canvas.restore();
        if (this.showPercentage) {
            canvas.save();
            canvas.translate(this.leftCx - (this.leftPercentageStaticLayout.getWidth() / 2.0f), this.percentageCY - (this.leftPercentageStaticLayout.getHeight() / 2.0f));
            float f7 = this.percentageZoom;
            canvas.scale(f7, f7, this.leftPercentageStaticLayout.getWidth() / 2.0f, this.leftPercentageStaticLayout.getHeight() / 2.0f);
            this.leftPercentageStaticLayout.draw(canvas);
            canvas.restore();
        }
        canvas.save();
        canvas.translate(f3, f4);
        float f8 = this.rightZoomToHalfHeight;
        canvas.scale(f8, f8);
        float width2 = (1.0f - this.rightZoomToHalfHeight) * this.rightTextStaticLayout.getWidth();
        float f9 = this.rightZoomToHalfHeight;
        canvas.translate(width2 / (f9 * 2.0f), ((1.0f - f9) * this.rightTextStaticLayout.getHeight()) / (this.rightZoomToHalfHeight * 2.0f));
        this.rightTextStaticLayout.draw(canvas);
        canvas.restore();
        if (this.showPercentage) {
            canvas.save();
            canvas.translate(this.rightCx - (this.rightPercentageStaticLayout.getWidth() / 2.0f), this.percentageCY - (this.rightPercentageStaticLayout.getHeight() / 2.0f));
            float f10 = this.percentageZoom;
            canvas.scale(f10, f10, this.rightPercentageStaticLayout.getWidth() / 2.0f, this.rightPercentageStaticLayout.getHeight() / 2.0f);
            this.rightPercentageStaticLayout.draw(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float maxWidth(StaticLayout staticLayout) {
        float fMax = 0.0f;
        for (int i = 0; i < staticLayout.getLineCount(); i++) {
            fMax = Math.max(staticLayout.getLineWidth(i), fMax);
        }
        return fMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float minLeft(StaticLayout staticLayout) {
        float lineLeft = staticLayout.getLineLeft(0);
        for (int i = 1; i < staticLayout.getLineCount(); i++) {
            lineLeft = Math.min(staticLayout.getLineLeft(i), lineLeft);
        }
        return lineLeft;
    }

    private void setupRightStaticLayoutShader() {
        LinearGradient linearGradient = new LinearGradient(minLeft(this.rightTextStaticLayout), 0.0f, minLeft(this.rightTextStaticLayout) + maxWidth(this.rightTextStaticLayout), 0.0f, this.optionRightStartColor, this.optionRightEndColor, Shader.TileMode.REPEAT);
        if (this.mode != PollAddStoryMode.SHARE) {
            this.rightTextPaint.setShader(linearGradient);
        } else if (this.finalLeftPercentage <= 50.0f) {
            this.rightTextPaint.setColor(this.WHITE);
            this.rightPercentagePaint.setColor(this.WHITE);
        } else {
            this.rightTextPaint.setColor(this.TEXT_GRAY);
            this.rightPercentagePaint.setColor(this.TEXT_GRAY);
        }
        this.rightTextStaticLayout = new StaticLayout(this.optionRight, this.rightTextPaint, this.textStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
    }

    private void setupLeftStaticLayoutShader() {
        LinearGradient linearGradient = new LinearGradient(minLeft(this.leftTextStaticLayout), 0.0f, minLeft(this.leftTextStaticLayout) + maxWidth(this.leftTextStaticLayout), 0.0f, this.optionLeftStartColor, this.optionLeftEndColor, Shader.TileMode.REPEAT);
        if (this.mode != PollAddStoryMode.SHARE) {
            this.leftTextPaint.setShader(linearGradient);
        } else if (this.finalLeftPercentage >= 50.0f) {
            this.leftTextPaint.setColor(this.WHITE);
            this.leftPercentagePaint.setColor(this.WHITE);
        } else {
            this.leftTextPaint.setColor(this.TEXT_GRAY);
            this.leftPercentagePaint.setColor(this.TEXT_GRAY);
        }
        this.leftTextStaticLayout = new StaticLayout(this.optionLeft, this.leftTextPaint, this.textStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupLeftEditTextShader(float f, float f2) {
        this.leftEditText.getPaint().setShader(new LinearGradient(f, 0.0f, f2, 0.0f, this.optionLeftStartColor, this.optionLeftEndColor, Shader.TileMode.CLAMP));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupRightEditTextShader(float f, float f2) {
        this.rightEditText.getPaint().setShader(new LinearGradient(f, 0.0f, f2, 0.0f, this.optionRightStartColor, this.optionRightEndColor, Shader.TileMode.CLAMP));
    }

    private void updateTransferAnimationIfNeeded() {
        if (this.startTransferAnimation) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.lastUpdateAnimation == 0) {
                this.lastUpdateAnimation = jCurrentTimeMillis;
            }
            long j = jCurrentTimeMillis - this.lastUpdateAnimation;
            if (j > this.animDuration) {
                this.startTransferAnimation = false;
                PollClickListener pollClickListener = this.pollClickListener;
                if (pollClickListener != null) {
                    pollClickListener.onAnimationFinished();
                }
            }
            float interpolation = this.interpolator.getInterpolation(zeroOneRang(j, this.animDuration));
            if (this.separatorInterpolation != 1.0f) {
                this.separatorInterpolation = interpolation;
            }
            if (this.separatorInterpolation > 1.0f) {
                this.separatorInterpolation = 1.0f;
            }
            float f = this.initialSeparator;
            this.separator = f + realRang(this.finalSeparator - f, this.separatorInterpolation);
            this.leftZoomToHalfHeight = 1.0f - realRang(1.0f - this.finalLeftZoomToHalfHeight, interpolation);
            this.rightZoomToHalfHeight = 1.0f - realRang(1.0f - this.finalRightZoomToHalfHeight, interpolation);
            float f2 = this.initialLeftCX;
            this.leftCx = f2 + realRang(this.finalLeftCx - f2, interpolation);
            float f3 = this.initialRightCX;
            this.rightCx = f3 + realRang(this.finalRightCx - f3, interpolation);
            float f4 = this.initialTextsCY;
            this.textsCY = f4 + realRang(this.finalTextsCY - f4, interpolation);
            this.percentageZoom = realRang(1.0f, interpolation);
            invalidate();
        }
    }

    public void setLeftHolderPercentage(float f, boolean z, PollOption pollOption) {
        PollClickListener pollClickListener;
        if (pollOption == PollOption.LEFT) {
            this.leftHolderPaint.setColor(this.GRAY);
        } else if (pollOption == PollOption.RIGHT) {
            this.rightHolderPaint.setColor(this.GRAY);
        }
        this.startTransferAnimation = z;
        if (z) {
            this.separatorInterpolation = 0.0f;
        }
        if (z && (pollClickListener = this.pollClickListener) != null) {
            pollClickListener.onAnimationStart();
        }
        this.finalLeftPercentage = f;
        this.showPercentage = true;
        this.hideLeftHolder = f == 0.0f;
        this.hideRightHolder = f == 100.0f;
        if (getHeight() != 0) {
            calculateDistances(getWidth(), getHeight());
        }
    }

    private void calculateDistances(int i, int i2) {
        setupPercentageStaticLayouts(i2);
        this.separator = calculateFinalSeparator(i);
        this.leftZoomToHalfHeight = calculateFinalLeftScale(i, i2);
        this.rightZoomToHalfHeight = calculateFinalRightScale(i, i2);
        calculateTextX(i);
        this.textsCY = calculateTextY(i2);
        this.percentageCY = calculatePercentageY(i2);
        this.percentageZoom = 1.0f;
        invalidate();
    }

    private float calculatePercentageY(int i) {
        float f = i / 2.0f;
        int i2 = this.centerViewPadding;
        float f2 = i2 + f + (((f - i2) - this.textViewPadding) / 2.0f);
        this.finalPercentageCY = f2;
        return f2;
    }

    private float calculateFinalLeftScale(int i, int i2) {
        this.finalLeftZoomToHalfHeight = (((i2 / 2.0f) - this.textViewPadding) - this.centerViewPadding) / maxHeight(this.leftTextStaticLayout);
        float f = ((this.finalLeftPercentage / 100.0f) * i) - ((this.textViewPadding * 2) + (this.marginBetweenOptions / 2.0f));
        if (maxWidth(this.leftTextStaticLayout) > f) {
            this.finalLeftZoomToHalfHeight *= Math.max(f / maxWidth(this.leftTextStaticLayout), this.minScale);
            if (maxWidth(this.leftTextStaticLayout) * this.finalLeftZoomToHalfHeight > f || maxWidth(this.leftPercentageStaticLayout) > f) {
                this.leftEnoughSpace = false;
            }
        }
        return this.finalLeftZoomToHalfHeight;
    }

    private float calculateFinalRightScale(int i, int i2) {
        this.finalRightZoomToHalfHeight = (((i2 / 2.0f) - this.textViewPadding) - this.centerViewPadding) / maxHeight(this.rightTextStaticLayout);
        float f = (((100.0f - this.finalLeftPercentage) / 100.0f) * i) - ((this.textViewPadding * 2) + (this.marginBetweenOptions / 2.0f));
        if (maxWidth(this.rightTextStaticLayout) > f) {
            this.finalRightZoomToHalfHeight *= Math.max(f / maxWidth(this.rightTextStaticLayout), this.minScale);
            if (maxWidth(this.rightTextStaticLayout) * this.finalRightZoomToHalfHeight > f || maxWidth(this.rightPercentageStaticLayout) > f) {
                this.rightEnoughSpace = false;
            }
        }
        return this.finalRightZoomToHalfHeight;
    }

    private float calculateTextY(int i) {
        int i2 = this.textViewPadding;
        float f = i2 + ((((i / 2.0f) - i2) - this.centerViewPadding) / 2.0f);
        this.finalTextsCY = f;
        return f;
    }

    private float calculateFinalSeparator(int i) {
        float f = i;
        float f2 = (this.finalLeftPercentage / 100.0f) * f;
        this.finalSeparator = f2;
        float f3 = this.marginBetweenOptions;
        float f4 = this.cornerSize;
        if (f2 < (f3 / 2.0f) + (f4 * 2.0f) && !this.hideLeftHolder) {
            this.finalSeparator = (f3 / 2.0f) + (f4 * 2.0f);
        } else if (f2 > (f - (f4 * 2.0f)) - (f3 / 2.0f) && !this.hideRightHolder) {
            this.finalSeparator = (f - (f4 * 2.0f)) - (f3 / 2.0f);
        }
        return this.finalSeparator;
    }

    private void calculateTextX(int i) {
        boolean z = this.leftEnoughSpace;
        if (z && this.rightEnoughSpace) {
            float f = this.finalLeftPercentage;
            float f2 = i;
            float f3 = this.marginBetweenOptions;
            this.finalLeftCx = (((f / 100.0f) * f2) - (f3 / 2.0f)) / 2.0f;
            this.finalRightCx = f2 - (((((100.0f - f) / 100.0f) * f2) - (f3 / 2.0f)) / 2.0f);
        } else if (z) {
            if (this.hideRightHolder) {
                float f4 = i;
                this.finalRightCx = Math.max(maxWidth(this.rightPercentageStaticLayout) / (this.rightZoomToHalfHeight * 2.0f), maxWidth(this.rightTextStaticLayout) / 2.0f) + f4;
                this.finalLeftCx = f4 / 2.0f;
            } else {
                if (maxWidth(this.rightPercentageStaticLayout) > this.rightZoomToHalfHeight * maxWidth(this.rightTextStaticLayout)) {
                    this.finalRightCx = (i - (this.textViewPadding / this.rightZoomToHalfHeight)) - (maxWidth(this.rightPercentageStaticLayout) / (this.rightZoomToHalfHeight * 2.0f));
                } else {
                    this.finalRightCx = (i - this.textViewPadding) - (maxWidth(this.rightTextStaticLayout) / 2.0f);
                }
                this.finalLeftCx = (this.finalRightCx - (maxWidth(this.rightTextStaticLayout) / 2.0f)) / 2.0f;
            }
        } else if (this.rightEnoughSpace) {
            if (this.hideLeftHolder) {
                this.finalLeftCx = -Math.max(maxWidth(this.leftPercentageStaticLayout) / (this.leftZoomToHalfHeight * 2.0f), maxWidth(this.leftTextStaticLayout) / 2.0f);
                this.finalRightCx = i / 2.0f;
            } else {
                if (maxWidth(this.leftPercentageStaticLayout) > this.leftZoomToHalfHeight * maxWidth(this.leftTextStaticLayout)) {
                    this.finalLeftCx = (this.textViewPadding + (maxWidth(this.leftPercentageStaticLayout) / 2.0f)) / this.leftZoomToHalfHeight;
                } else {
                    this.finalLeftCx = this.textViewPadding + (maxWidth(this.leftTextStaticLayout) / 2.0f);
                }
                this.finalRightCx = this.finalLeftCx + (maxWidth(this.leftTextStaticLayout) / 2.0f) + ((i - (this.finalLeftCx + (maxWidth(this.leftTextStaticLayout) / 2.0f))) / 2.0f);
            }
        }
        this.leftCx = this.finalLeftCx;
        this.rightCx = this.finalRightCx;
    }

    public String getOptionLeft() {
        EditText editText = this.leftEditText;
        return editText == null ? this.optionLeft : editText.getText().toString();
    }

    public String getOptionRight() {
        EditText editText = this.rightEditText;
        return editText == null ? this.optionRight : editText.getText().toString();
    }

    public void setOptionLeft(String str) {
        EditText editText = this.leftEditText;
        if (editText == null) {
            this.optionLeft = str;
        } else {
            editText.setText(str);
        }
    }

    public void setOptionRight(String str) {
        EditText editText = this.rightEditText;
        if (editText == null) {
            this.optionRight = str;
        } else {
            editText.setText(str);
        }
    }

    /* renamed from: ir.resaneh1.iptv.story.poll.PollView$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$ir$resaneh1$iptv$story$poll$PollView$PollAddStoryMode;

        static {
            int[] iArr = new int[PollAddStoryMode.values().length];
            $SwitchMap$ir$resaneh1$iptv$story$poll$PollView$PollAddStoryMode = iArr;
            try {
                iArr[PollAddStoryMode.EDIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$poll$PollView$PollAddStoryMode[PollAddStoryMode.LOCK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void setMode(PollAddStoryMode pollAddStoryMode) {
        this.mode = pollAddStoryMode;
        int i = AnonymousClass3.$SwitchMap$ir$resaneh1$iptv$story$poll$PollView$PollAddStoryMode[pollAddStoryMode.ordinal()];
        if (i == 1) {
            addEditTexts();
            enableEditTexts(true);
        } else {
            if (i != 2) {
                return;
            }
            addEditTexts();
            if (this.leftEditText.getText().toString().isEmpty()) {
                this.leftEditText.setText(this.hintLeft);
            }
            if (this.rightEditText.getText().toString().isEmpty()) {
                this.rightEditText.setText(this.hintRight);
            }
            enableEditTexts(false);
        }
    }

    private void enableEditTexts(boolean z) {
        if (!z) {
            disableLeftEdtText();
            disableRightEditText();
        } else {
            enableLeftEditText();
            enableRightEditText();
        }
    }

    private void enableRightEditText() {
        this.rightEditText.setEnabled(true);
        this.rightEditText.setFocusableInTouchMode(true);
        MovementMethod movementMethod = this.rightMovementMethod;
        if (movementMethod != null) {
            this.rightEditText.setMovementMethod(movementMethod);
        }
        KeyListener keyListener = this.rightKeyListener;
        if (keyListener != null) {
            this.rightEditText.setKeyListener(keyListener);
        }
    }

    private void enableLeftEditText() {
        this.leftEditText.setEnabled(true);
        this.leftEditText.setFocusableInTouchMode(true);
        MovementMethod movementMethod = this.leftMovementMethod;
        if (movementMethod != null) {
            this.leftEditText.setMovementMethod(movementMethod);
        }
        KeyListener keyListener = this.leftKeyListener;
        if (keyListener != null) {
            this.leftEditText.setKeyListener(keyListener);
        }
    }

    private void disableRightEditText() {
        this.rightMovementMethod = this.rightEditText.getMovementMethod();
        this.rightKeyListener = this.rightEditText.getKeyListener();
        this.rightEditText.setMovementMethod(null);
        this.rightEditText.setKeyListener(null);
        this.rightEditText.setEnabled(false);
        this.rightEditText.setTextColor(this.BLACK);
    }

    private void disableLeftEdtText() {
        this.leftMovementMethod = this.leftEditText.getMovementMethod();
        this.leftKeyListener = this.leftEditText.getKeyListener();
        this.leftEditText.setMovementMethod(null);
        this.leftEditText.setKeyListener(null);
        this.leftEditText.setEnabled(false);
        this.leftEditText.setTextColor(this.BLACK);
    }

    public void setClickListener(PollClickListener pollClickListener) {
        this.pollClickListener = pollClickListener;
    }

    public static int getPollHeight() {
        return pollHeight;
    }

    public static int getPollWidth() {
        return pollWidth;
    }
}
