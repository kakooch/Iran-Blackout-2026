package ir.resaneh1.iptv.story;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
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
import android.widget.ImageView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class QuestionSticker extends FrameLayout {
    private int BLACK;
    private int BLUE;
    private int GRAY_DARK;
    private int GRAY_LIGHT;
    private int GREEN;
    private int RESPONSE_HINT_COLOR;
    private int WHITE;
    private int animationDuration;
    private Paint backgroundPaint;
    private Path backgroundPath;
    private float cornerSize;
    private int editTextsWidth;
    private float finalDistanceY;
    private int gradientEndColor;
    private LinearGradient gradientShader;
    private int gradientStartColor;
    private ImageView imageView;
    private FrameLayout.LayoutParams imageViewParams;
    private int imageViewSize;
    private int margin;
    private int padding;
    private Paint previewPaint;
    private long previewStartTime;
    private StaticLayout previewStaticLayout;
    private String previewText;
    private TextPaint previewTextPaint;
    private int previewTextSizeDp;
    private RectF previewTripleRectOne;
    private RectF previewTripleRectThree;
    private RectF previewTripleRectTwo;
    private int questionFontSizeDp;
    private String questionHint;
    private final QuestionMode questionMode;
    private FrameLayout.LayoutParams questionParams;
    private TextWatcher questionTextWatcher;
    private int responseFontSizeDp;
    private KeyListener responseKeyListener;
    private MovementMethod responseMovementMethod;
    private StaticLayout sendLayout;
    private String sendText;
    private TextPaint sendTextPaint;
    private int sendViewHeight;
    private Paint sendViewPaint;
    private Path sendViewPath;
    private boolean sent;
    private StaticLayout sentLayout;
    private String sentText;
    private Paint sentViewPaint;
    private boolean showSendView;
    private EditText titleEditText;
    private KeyListener titleKeyListener;
    private MovementMethod titleMovementMethod;
    private int tripleRectMargin;
    private EditText userResponseEditText;
    private String userResponseHint;
    private FrameLayout.LayoutParams userResponseParams;
    private TextWatcher userResponseTextWatcher;
    private static int width = AndroidUtilities.dp(280.0f);
    public static Interpolator previewInterpolator = new Interpolator() { // from class: ir.resaneh1.iptv.story.QuestionSticker.3
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        float animStep = 0.1f;
        float stopStep = 0.1f + 0.4f;

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.animStep;
            if (f <= f2) {
                return this.accelerateDecelerateInterpolator.getInterpolation(f / f2);
            }
            if (f2 < f && f < this.stopStep) {
                return 1.0f;
            }
            float f3 = this.stopStep;
            if (f >= f3 && f <= f2 + f3) {
                return 1.0f - this.accelerateDecelerateInterpolator.getInterpolation((f - f3) / f2);
            }
            if (f > f2 + f3) {
                return 0.0f;
            }
            return f;
        }
    };

    public enum QuestionMode {
        PREVIEW,
        ADD_STORY,
        STORY,
        SHARE
    }

    public interface SendClickListener {
    }

    private float realRang(float f, float f2) {
        return f2 * f;
    }

    private float zeroOneRang(long j, long j2) {
        return j / j2;
    }

    public QuestionSticker(Context context, QuestionMode questionMode, SendClickListener sendClickListener) {
        super(context);
        this.RESPONSE_HINT_COLOR = -10855846;
        this.WHITE = -1;
        this.BLACK = -16777216;
        this.GRAY_LIGHT = -1315861;
        this.GRAY_DARK = -4473925;
        this.BLUE = -15697688;
        this.GREEN = -11814117;
        this.gradientStartColor = -5767005;
        this.gradientEndColor = -1179640;
        this.cornerSize = AndroidUtilities.dp(10.0f);
        this.imageViewSize = AndroidUtilities.dp(48.0f);
        this.margin = AndroidUtilities.dp(15.0f);
        this.padding = AndroidUtilities.dp(16.0f);
        this.sendViewHeight = AndroidUtilities.dp(55.0f);
        this.editTextsWidth = AndroidUtilities.dp(250.0f);
        this.questionFontSizeDp = 20;
        this.responseFontSizeDp = 15;
        this.sendText = "Send";
        this.sentText = "Sent!";
        this.userResponseHint = "Type something...";
        this.questionHint = "Ask me a question";
        this.questionTextWatcher = new TextWatcher() { // from class: ir.resaneh1.iptv.story.QuestionSticker.1
            private String lastString;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (QuestionSticker.this.titleEditText.getLayout().getLineCount() > 3) {
                    QuestionSticker.this.titleEditText.removeTextChangedListener(QuestionSticker.this.questionTextWatcher);
                    QuestionSticker.this.titleEditText.setText(this.lastString);
                    QuestionSticker.this.titleEditText.setSelection(this.lastString.length());
                    QuestionSticker.this.titleEditText.addTextChangedListener(QuestionSticker.this.questionTextWatcher);
                    return;
                }
                this.lastString = editable.toString();
            }
        };
        this.userResponseTextWatcher = new TextWatcher() { // from class: ir.resaneh1.iptv.story.QuestionSticker.2
            private String lastString;

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (QuestionSticker.this.showSendView) {
                    return;
                }
                QuestionSticker.this.showSendView = true;
                QuestionSticker.this.invalidate();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (QuestionSticker.this.userResponseEditText.getLayout().getLineCount() > 3) {
                    QuestionSticker.this.userResponseEditText.removeTextChangedListener(QuestionSticker.this.userResponseTextWatcher);
                    QuestionSticker.this.userResponseEditText.setText(this.lastString);
                    QuestionSticker.this.userResponseEditText.setSelection(this.lastString.length());
                    QuestionSticker.this.userResponseEditText.addTextChangedListener(QuestionSticker.this.userResponseTextWatcher);
                    return;
                }
                this.lastString = editable.toString();
            }
        };
        this.previewText = "QUESTIONS";
        this.previewTextSizeDp = 60;
        this.tripleRectMargin = AndroidUtilities.dp(12.0f);
        this.animationDuration = 3000;
        setWillNotDraw(false);
        this.questionMode = questionMode;
        init();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        QuestionMode questionMode = this.questionMode;
        if (questionMode == QuestionMode.PREVIEW) {
            if (this.previewStaticLayout == null) {
                this.previewTextPaint.setShader(new LinearGradient(0.0f, 0.0f, width, 0.0f, this.gradientStartColor, this.gradientEndColor, Shader.TileMode.REPEAT));
                this.previewStaticLayout = new StaticLayout(this.previewText, this.previewTextPaint, width, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
            int i3 = width;
            setupTripleRect(i3, i3 / 3);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(width / 3, 1073741824));
            return;
        }
        if (questionMode == QuestionMode.SHARE) {
            measureChild(this.userResponseEditText, View.MeasureSpec.makeMeasureSpec(width, 1073741824), i2);
            this.questionParams.bottomMargin = this.userResponseEditText.getMeasuredHeight();
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), i2);
            return;
        }
        measureChild(this.userResponseEditText, View.MeasureSpec.makeMeasureSpec(width, 1073741824), i2);
        measureChild(this.titleEditText, View.MeasureSpec.makeMeasureSpec(width, 1073741824), i2);
        this.imageViewParams.bottomMargin = (this.margin * 3) + this.titleEditText.getMeasuredHeight() + this.userResponseEditText.getMeasuredHeight() + this.sendViewHeight;
        FrameLayout.LayoutParams layoutParams = this.questionParams;
        int measuredHeight = (this.margin * 2) + this.userResponseEditText.getMeasuredHeight();
        int i4 = this.sendViewHeight;
        layoutParams.bottomMargin = measuredHeight + i4;
        this.userResponseParams.bottomMargin = this.margin + i4;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), i2);
    }

    private void setupTripleRect(int i, int i2) {
        RectF rectF = this.previewTripleRectOne;
        rectF.top = 0.0f;
        float f = i2;
        rectF.bottom = f;
        rectF.left = 0.0f;
        float f2 = i;
        rectF.right = f2;
        RectF rectF2 = this.previewTripleRectTwo;
        int i3 = this.tripleRectMargin;
        float f3 = i3 + 0.0f;
        rectF2.top = f3;
        float f4 = f - i3;
        rectF2.bottom = f4;
        float f5 = 0.0f + i3;
        rectF2.left = f5;
        float f6 = f2 - i3;
        rectF2.right = f6;
        RectF rectF3 = this.previewTripleRectThree;
        rectF3.top = f3 + i3;
        rectF3.bottom = f4 - i3;
        rectF3.left = f5 + i3;
        rectF3.right = f6 - i3;
    }

    private void init() {
        QuestionMode questionMode = this.questionMode;
        if (questionMode == QuestionMode.PREVIEW) {
            setupPreviewMode();
        } else if (questionMode == QuestionMode.SHARE) {
            setupBackgroundPaint();
            setupAndAddQuestionEditText();
            setupAndAddUserResponseEditText();
        } else {
            setupBackgroundPaint();
            setupSendViewPaint();
            setupSentViewPaint();
            setupAndAddImageView();
            setupSendTextPaint();
            setupAndAddUserResponseEditText();
            setupAndAddQuestionEditText();
        }
        setEditTextsConfig(this.questionMode);
    }

    private void setupPreviewMode() {
        TextPaint textPaint = new TextPaint();
        this.previewTextPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.previewTextPaint.setTextSize(AndroidUtilities.dp(this.previewTextSizeDp));
        this.previewTextPaint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/AvenyTRegular.otf"));
        this.previewTripleRectOne = new RectF();
        this.previewTripleRectTwo = new RectF();
        this.previewTripleRectThree = new RectF();
        Paint paint = new Paint();
        this.previewPaint = paint;
        paint.setAntiAlias(true);
        this.previewPaint.setStyle(Paint.Style.FILL);
        this.previewPaint.setColor(this.WHITE);
    }

    private void setupSendTextPaint() {
        TextPaint textPaint = new TextPaint();
        this.sendTextPaint = textPaint;
        textPaint.setTextSize(AndroidUtilities.dp(this.responseFontSizeDp));
        this.sendTextPaint.setColor(this.WHITE);
        this.sendTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
    }

    private void setupAndAddImageView() {
        ImageView imageView = new ImageView(getContext());
        this.imageView = imageView;
        imageView.setImageResource(R.drawable.account_image);
        this.imageView.setBackgroundResource(R.drawable.image_background);
        int i = this.imageViewSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i, 81);
        this.imageViewParams = layoutParams;
        addView(this.imageView, layoutParams);
    }

    private void setupAndAddQuestionEditText() {
        EditText editText = new EditText(getContext());
        this.titleEditText = editText;
        editText.setBackground(null);
        this.titleEditText.setTypeface(Typeface.DEFAULT_BOLD);
        this.titleEditText.setText(this.questionHint);
        this.titleEditText.setTextColor(this.BLACK);
        if (Build.VERSION.SDK_INT >= 17) {
            this.titleEditText.setTextAlignment(4);
        }
        this.questionParams = new FrameLayout.LayoutParams(this.editTextsWidth, -2, 81);
        if (this.questionMode == QuestionMode.SHARE) {
            EditText editText2 = this.titleEditText;
            int i = this.padding;
            editText2.setPadding(i, i, i, i);
            this.titleEditText.setBackgroundResource(R.drawable.question_background);
            this.titleEditText.getPaint().setShader(null);
            this.titleEditText.setTextColor(this.WHITE);
            this.titleEditText.setTextSize(1, this.responseFontSizeDp);
        } else {
            this.titleEditText.setPadding(0, 0, 0, 0);
            this.titleEditText.setMaxLines(3);
            this.titleEditText.addTextChangedListener(this.questionTextWatcher);
            this.questionParams.bottomMargin = (this.margin * 2) + this.userResponseEditText.getMeasuredHeight();
            this.titleEditText.setTextSize(1, this.questionFontSizeDp);
        }
        addView(this.titleEditText, this.questionParams);
    }

    private void setupAndAddUserResponseEditText() {
        this.gradientShader = new LinearGradient(0.0f, 0.0f, this.editTextsWidth * 1.5f, 0.0f, this.gradientStartColor, this.gradientEndColor, Shader.TileMode.REPEAT);
        EditText editText = new EditText(getContext());
        this.userResponseEditText = editText;
        int i = this.padding;
        editText.setPadding(i, i, i, i);
        if (Build.VERSION.SDK_INT >= 17) {
            this.userResponseEditText.setTextAlignment(4);
        }
        this.userResponseEditText.setBackgroundResource(R.drawable.user_response_background);
        this.userResponseEditText.setHint(this.userResponseHint);
        this.userResponseEditText.setHintTextColor(this.RESPONSE_HINT_COLOR);
        this.userResponseParams = new FrameLayout.LayoutParams(this.editTextsWidth, -2, 81);
        if (this.questionMode == QuestionMode.SHARE) {
            this.userResponseEditText.setBackgroundResource(R.drawable.response_background);
            this.userResponseEditText.setTextSize(1, this.questionFontSizeDp);
            this.userResponseEditText.setTypeface(Typeface.DEFAULT_BOLD);
            this.userResponseEditText.getPaint().setShader(this.gradientShader);
        } else {
            this.userResponseEditText.addTextChangedListener(this.userResponseTextWatcher);
            this.userResponseEditText.setTextSize(1, this.responseFontSizeDp);
            this.userResponseParams.bottomMargin = this.margin;
        }
        addView(this.userResponseEditText, this.userResponseParams);
    }

    private void setupBackgroundPaint() {
        this.backgroundPath = new Path();
        Paint paint = new Paint();
        this.backgroundPaint = paint;
        paint.setAntiAlias(true);
        this.backgroundPaint.setColor(this.WHITE);
        this.backgroundPaint.setStyle(Paint.Style.FILL);
    }

    private void setupSendViewPaint() {
        this.sendViewPath = new Path();
        Paint paint = new Paint();
        this.sendViewPaint = paint;
        paint.setAntiAlias(true);
        this.sendViewPaint.setColor(this.BLUE);
        this.sendViewPaint.setStyle(Paint.Style.FILL);
    }

    private void setupSentViewPaint() {
        Paint paint = new Paint();
        this.sentViewPaint = paint;
        paint.setAntiAlias(true);
        this.sentViewPaint.setColor(this.GREEN);
        this.sentViewPaint.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        drawPreviewIfNeeded(canvas);
        drawBackgroundIfNeeded(canvas);
    }

    private void drawBackgroundIfNeeded(Canvas canvas) {
        QuestionMode questionMode = this.questionMode;
        if (questionMode == QuestionMode.ADD_STORY || questionMode == QuestionMode.STORY) {
            if (this.showSendView) {
                drawBackgroundRect(canvas);
                drawSendView(canvas);
                drawSendText(canvas);
                return;
            }
            drawBackgroundRoundRect(canvas);
        }
    }

    private void drawPreviewIfNeeded(Canvas canvas) {
        if (this.questionMode == QuestionMode.PREVIEW) {
            drawTripleRect(canvas);
            updateAnimation();
        }
    }

    private void updateAnimation() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.previewStartTime;
        long j2 = jCurrentTimeMillis - j;
        int i = this.animationDuration;
        if (j2 >= i || j == 0) {
            this.previewStartTime = jCurrentTimeMillis;
            j2 = 0;
        }
        this.finalDistanceY = realRang(this.tripleRectMargin * 2, previewInterpolator.getInterpolation(zeroOneRang(j2, i)));
        invalidate();
    }

    private void drawTripleRect(Canvas canvas) {
        this.previewPaint.setColor(this.GRAY_DARK);
        canvas.save();
        canvas.translate(0.0f, this.finalDistanceY);
        RectF rectF = this.previewTripleRectThree;
        float f = this.cornerSize;
        canvas.drawRoundRect(rectF, f, f, this.previewPaint);
        canvas.restore();
        this.previewPaint.setColor(this.GRAY_LIGHT);
        RectF rectF2 = this.previewTripleRectTwo;
        float f2 = this.cornerSize;
        canvas.drawRoundRect(rectF2, f2, f2, this.previewPaint);
        this.previewPaint.setColor(this.WHITE);
        canvas.save();
        canvas.translate(0.0f, -this.finalDistanceY);
        RectF rectF3 = this.previewTripleRectOne;
        float f3 = this.cornerSize;
        canvas.drawRoundRect(rectF3, f3, f3, this.previewPaint);
        canvas.translate(0.0f, (getHeight() / 2.0f) - (this.previewStaticLayout.getHeight() / 2.0f));
        this.previewStaticLayout.draw(canvas);
        canvas.restore();
    }

    private void drawSendText(Canvas canvas) {
        setupStaticLayouts();
        canvas.save();
        canvas.translate(0.0f, (getHeight() - (this.sendViewHeight / 2.0f)) - (this.sendLayout.getHeight() / 2.0f));
        if (this.sent) {
            this.sentLayout.draw(canvas);
        } else {
            this.sendLayout.draw(canvas);
        }
        canvas.restore();
    }

    private void drawSendView(Canvas canvas) {
        this.sendViewPath.reset();
        this.sendViewPath.moveTo(0.0f, getHeight() - this.sendViewHeight);
        this.sendViewPath.rLineTo(getWidth(), 0.0f);
        this.sendViewPath.rLineTo(0.0f, this.sendViewHeight - this.cornerSize);
        Path path = this.sendViewPath;
        float f = this.cornerSize;
        path.rLineTo(-f, f);
        this.sendViewPath.rLineTo((-getWidth()) + (this.cornerSize * 2.0f), 0.0f);
        Path path2 = this.sendViewPath;
        float f2 = this.cornerSize;
        path2.rLineTo(-f2, -f2);
        this.sendViewPath.rLineTo(0.0f, (-this.sendViewHeight) + this.cornerSize);
        Path path3 = this.sendViewPath;
        float f3 = this.cornerSize;
        float height = getHeight();
        float f4 = this.cornerSize;
        path3.addCircle(f3, height - f4, f4, Path.Direction.CW);
        Path path4 = this.sendViewPath;
        float width2 = getWidth() - this.cornerSize;
        float height2 = getHeight();
        float f5 = this.cornerSize;
        path4.addCircle(width2, height2 - f5, f5, Path.Direction.CW);
        canvas.drawPath(this.sendViewPath, this.sent ? this.sentViewPaint : this.sendViewPaint);
    }

    private void setupStaticLayouts() {
        if (this.sendLayout == null) {
            this.sendLayout = new StaticLayout(this.sendText, this.sendTextPaint, getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        }
        if (this.sentLayout == null) {
            this.sentLayout = new StaticLayout(this.sentText, this.sendTextPaint, getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        }
    }

    private void drawBackgroundRect(Canvas canvas) {
        this.backgroundPath.reset();
        this.backgroundPath.moveTo(this.cornerSize, this.imageViewSize / 2.0f);
        this.backgroundPath.rLineTo(getWidth() - (this.cornerSize * 2.0f), 0.0f);
        Path path = this.backgroundPath;
        float f = this.cornerSize;
        path.rLineTo(f, f);
        this.backgroundPath.rLineTo(0.0f, ((getHeight() - this.sendViewHeight) - (this.imageViewSize / 2.0f)) - this.cornerSize);
        this.backgroundPath.rLineTo(-getWidth(), 0.0f);
        this.backgroundPath.rLineTo(0.0f, (-getHeight()) + this.sendViewHeight + (this.imageViewSize / 2.0f) + this.cornerSize);
        Path path2 = this.backgroundPath;
        float f2 = this.cornerSize;
        path2.rLineTo(f2, -f2);
        Path path3 = this.backgroundPath;
        float f3 = this.cornerSize;
        path3.addCircle(f3, (this.imageViewSize / 2.0f) + f3, f3, Path.Direction.CW);
        Path path4 = this.backgroundPath;
        float width2 = getWidth();
        float f4 = this.cornerSize;
        path4.addCircle(width2 - f4, (this.imageViewSize / 2.0f) + f4, f4, Path.Direction.CW);
        canvas.drawPath(this.backgroundPath, this.backgroundPaint);
    }

    private void drawBackgroundRoundRect(Canvas canvas) {
        this.backgroundPath.reset();
        this.backgroundPath.moveTo(this.cornerSize, this.imageViewSize / 2.0f);
        this.backgroundPath.rLineTo(getWidth() - (this.cornerSize * 2.0f), 0.0f);
        Path path = this.backgroundPath;
        float f = this.cornerSize;
        path.rLineTo(f, f);
        this.backgroundPath.rLineTo(0.0f, ((getHeight() - this.sendViewHeight) - (this.imageViewSize / 2.0f)) - (this.cornerSize * 2.0f));
        Path path2 = this.backgroundPath;
        float f2 = this.cornerSize;
        path2.rLineTo(-f2, f2);
        this.backgroundPath.rLineTo((-getWidth()) + (this.cornerSize * 2.0f), 0.0f);
        Path path3 = this.backgroundPath;
        float f3 = this.cornerSize;
        path3.rLineTo(-f3, -f3);
        this.backgroundPath.rLineTo(0.0f, (-getHeight()) + this.sendViewHeight + (this.imageViewSize / 2.0f) + (this.cornerSize * 2.0f));
        Path path4 = this.backgroundPath;
        float f4 = this.cornerSize;
        path4.rLineTo(f4, -f4);
        Path path5 = this.backgroundPath;
        float f5 = this.cornerSize;
        path5.addCircle(f5, (this.imageViewSize / 2.0f) + f5, f5, Path.Direction.CW);
        Path path6 = this.backgroundPath;
        float width2 = getWidth();
        float f6 = this.cornerSize;
        path6.addCircle(width2 - f6, (this.imageViewSize / 2.0f) + f6, f6, Path.Direction.CW);
        Path path7 = this.backgroundPath;
        float width3 = getWidth() - this.cornerSize;
        float height = getHeight() - this.sendViewHeight;
        float f7 = this.cornerSize;
        path7.addCircle(width3, height - f7, f7, Path.Direction.CW);
        Path path8 = this.backgroundPath;
        float f8 = this.cornerSize;
        float height2 = getHeight() - this.sendViewHeight;
        float f9 = this.cornerSize;
        path8.addCircle(f8, height2 - f9, f9, Path.Direction.CW);
        canvas.drawPath(this.backgroundPath, this.backgroundPaint);
    }

    /* renamed from: ir.resaneh1.iptv.story.QuestionSticker$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$ir$resaneh1$iptv$story$QuestionSticker$QuestionMode;

        static {
            int[] iArr = new int[QuestionMode.values().length];
            $SwitchMap$ir$resaneh1$iptv$story$QuestionSticker$QuestionMode = iArr;
            try {
                iArr[QuestionMode.ADD_STORY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$QuestionSticker$QuestionMode[QuestionMode.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$QuestionSticker$QuestionMode[QuestionMode.STORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void setEditTextsConfig(QuestionMode questionMode) {
        int i = AnonymousClass4.$SwitchMap$ir$resaneh1$iptv$story$QuestionSticker$QuestionMode[questionMode.ordinal()];
        if (i == 1) {
            disableUserResponse();
            enableTitleText();
        } else if (i == 2) {
            disableTitleText();
            disableUserResponse();
        } else {
            if (i != 3) {
                return;
            }
            enableUserResponse();
            disableTitleText();
            this.showSendView = false;
            invalidate();
        }
    }

    private void disableTitleText() {
        this.titleEditText.setEnabled(false);
        this.titleEditText.setTextColor(this.questionMode == QuestionMode.ADD_STORY ? this.BLACK : this.WHITE);
        this.titleMovementMethod = this.titleEditText.getMovementMethod();
        this.titleKeyListener = this.titleEditText.getKeyListener();
        this.titleEditText.setMovementMethod(null);
        this.titleEditText.setKeyListener(null);
    }

    private void enableTitleText() {
        this.titleEditText.setEnabled(true);
        MovementMethod movementMethod = this.titleMovementMethod;
        if (movementMethod != null) {
            this.titleEditText.setMovementMethod(movementMethod);
        }
        KeyListener keyListener = this.titleKeyListener;
        if (keyListener != null) {
            this.titleEditText.setKeyListener(keyListener);
        }
    }

    private void disableUserResponse() {
        this.userResponseEditText.setEnabled(false);
        this.userResponseEditText.setHintTextColor(this.RESPONSE_HINT_COLOR);
        this.userResponseEditText.setTextColor(this.RESPONSE_HINT_COLOR);
        this.responseMovementMethod = this.userResponseEditText.getMovementMethod();
        this.responseKeyListener = this.userResponseEditText.getKeyListener();
        this.userResponseEditText.setKeyListener(null);
        this.userResponseEditText.setMovementMethod(null);
    }

    private void enableUserResponse() {
        this.userResponseEditText.setEnabled(true);
        MovementMethod movementMethod = this.responseMovementMethod;
        if (movementMethod != null) {
            this.userResponseEditText.setMovementMethod(movementMethod);
        }
        KeyListener keyListener = this.responseKeyListener;
        if (keyListener != null) {
            this.userResponseEditText.setKeyListener(keyListener);
        }
    }

    public void setLockView(boolean z) {
        if (z) {
            disableTitleText();
            disableUserResponse();
            if (this.questionMode == QuestionMode.STORY) {
                this.titleEditText.setTextColor(this.BLACK);
                this.userResponseEditText.removeTextChangedListener(this.userResponseTextWatcher);
                this.userResponseEditText.setText(BuildConfig.FLAVOR);
                this.userResponseEditText.addTextChangedListener(this.userResponseTextWatcher);
                this.showSendView = false;
                this.sent = false;
                return;
            }
            return;
        }
        setEditTextsConfig(this.questionMode);
        if (this.questionMode == QuestionMode.STORY) {
            this.titleEditText.getPaint().setShader(this.gradientShader);
        }
    }

    public EditText getFocusEditText() {
        return this.questionMode == QuestionMode.STORY ? this.userResponseEditText : this.titleEditText;
    }

    public static int getViewWidth() {
        return width;
    }

    public void setTitleText(String str) {
        this.titleEditText.setText(str);
    }

    public void setUserResponseText(String str) {
        this.userResponseEditText.setText(str);
    }

    public String getTitleEditText() {
        return this.titleEditText.getText().toString();
    }

    public String getUserResponseEditText() {
        return this.userResponseEditText.getText().toString();
    }
}
