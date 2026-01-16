package ir.resaneh1.iptv.story.quiz;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import ir.resaneh1.iptv.story.ExtraView;
import ir.resaneh1.iptv.story.quiz.OptionView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class QuizSticker extends FrameLayout implements OptionView.StatusChecker, View.OnClickListener {
    private int HINT_COLOR;
    private int WHITE;
    private String addStoryHint;
    private float alpha;
    private int backgroundCorner;
    private Paint backgroundPaint;
    private RectF backgroundRectF;
    private OptionView.OptionOrder correctOptionOrder;
    private Delegate delegate;
    private boolean enableToLockMode;
    private ExtraView extraView;
    private boolean firstClick;
    private boolean isHintEnable;
    private boolean isLock;
    private KeyListener keyListener;
    private List<FrameLayout.LayoutParams> layoutParamsList;
    private int marginBetweenTitleOption;
    private QuizMode mode;
    private MovementMethod movementMethod;
    private boolean noEnoughOption;
    private boolean notCorrectAnswerSelected;
    private boolean optionAIsEmpty;
    private boolean optionBIsEmpty;
    private boolean optionCIsEmpty;
    private int optionMargin;
    private float optionViewPercent;
    private List<OptionView> optionViews;
    private EditText quizTitle;
    private int quizTitleFontSizeDp;
    private LinearGradient shader;
    private int shadowColor;
    private int shadowRadius;
    private String storyHint;
    private ThemeModel theme;
    private Paint titleBackgroundPaint;
    private Path titleBackgroundPath;
    private String titleHint;
    private int titlePaddingHeight;
    private int titlePaddingWidth;
    private TextWatcher titleTextWatcher;
    public static int quizStickerWidth = AndroidUtilities.dp(280.0f);
    public static int optionViewHeight = AndroidUtilities.dp(52.0f);

    public interface Delegate {
        void onDisableLockMode(LockError lockError);

        void onEnableLockMode();

        void onSelectOption(int i);

        Point realValueOfEventPosition(int i, int i2);
    }

    public enum LockError {
        NoEnoughOptions,
        NoCorrectAnswer
    }

    public enum QuizMode {
        PREVIEW,
        ADD_STORY,
        STORY,
        STORY_LOCK
    }

    public enum Colors {
        BLACK_COLOR(-14211289),
        GREEN_COLOR(-9387952),
        GREEN_G_COLOR(-9453484),
        BLUE_COLOR(-13068304),
        BLUE_G_COLOR(-10310401),
        YELLOW_COLOR(-144547),
        YELLOW_G_COLOR(-211108),
        ORANGE_COLOR(-148174),
        RED_COLOR(-1226410),
        RED_G_COLOR(-104586),
        PURPLE_COLOR(-6092615),
        PURPLE_G_COLOR(-3592223);

        private int color;

        Colors(int i) {
            this.color = i;
        }

        public int getColor() {
            return this.color;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BLUE_GRADIENT' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class QuizTheme {
        private static final /* synthetic */ QuizTheme[] $VALUES;
        public static final QuizTheme BLACK;
        public static final QuizTheme BLUE;
        public static final QuizTheme BLUE_GRADIENT;
        public static final QuizTheme GREEN;
        public static final QuizTheme GREEN_GRADIENT;
        public static final QuizTheme ORANGE;
        public static final QuizTheme PURPLE;
        public static final QuizTheme PURPLE_GRADIENT;
        public static final QuizTheme RED;
        public static final QuizTheme RED_GRADIENT;
        public static final QuizTheme YELLOW;
        private ThemeModel themeModel;

        public static QuizTheme valueOf(String str) {
            return (QuizTheme) Enum.valueOf(QuizTheme.class, str);
        }

        public static QuizTheme[] values() {
            return (QuizTheme[]) $VALUES.clone();
        }

        static {
            QuizTheme quizTheme = new QuizTheme("BLACK", 0, new ThemeModel(Colors.BLACK_COLOR.color, 0, false));
            BLACK = quizTheme;
            QuizTheme quizTheme2 = new QuizTheme("BLUE", 1, new ThemeModel(Colors.BLUE_COLOR.color, 0, false));
            BLUE = quizTheme2;
            Colors colors = Colors.PURPLE_G_COLOR;
            int i = colors.color;
            Colors colors2 = Colors.BLUE_G_COLOR;
            QuizTheme quizTheme3 = new QuizTheme("BLUE_GRADIENT", 2, new ThemeModel(i, colors2.color, true));
            BLUE_GRADIENT = quizTheme3;
            QuizTheme quizTheme4 = new QuizTheme("GREEN", 3, new ThemeModel(Colors.GREEN_COLOR.color, 0, false));
            GREEN = quizTheme4;
            QuizTheme quizTheme5 = new QuizTheme("GREEN_GRADIENT", 4, new ThemeModel(Colors.GREEN_G_COLOR.color, colors2.color, true));
            GREEN_GRADIENT = quizTheme5;
            QuizTheme quizTheme6 = new QuizTheme("YELLOW", 5, new ThemeModel(Colors.YELLOW_COLOR.color, 0, false));
            YELLOW = quizTheme6;
            QuizTheme quizTheme7 = new QuizTheme("ORANGE", 6, new ThemeModel(Colors.ORANGE_COLOR.color, 0, false));
            ORANGE = quizTheme7;
            Colors colors3 = Colors.RED_COLOR;
            QuizTheme quizTheme8 = new QuizTheme("RED", 7, new ThemeModel(colors3.color, 0, false));
            RED = quizTheme8;
            QuizTheme quizTheme9 = new QuizTheme("RED_GRADIENT", 8, new ThemeModel(colors3.color, Colors.YELLOW_G_COLOR.color, true));
            RED_GRADIENT = quizTheme9;
            QuizTheme quizTheme10 = new QuizTheme("PURPLE", 9, new ThemeModel(Colors.PURPLE_COLOR.color, 0, false));
            PURPLE = quizTheme10;
            QuizTheme quizTheme11 = new QuizTheme("PURPLE_GRADIENT", 10, new ThemeModel(colors.color, Colors.RED_G_COLOR.color, true));
            PURPLE_GRADIENT = quizTheme11;
            $VALUES = new QuizTheme[]{quizTheme, quizTheme2, quizTheme3, quizTheme4, quizTheme5, quizTheme6, quizTheme7, quizTheme8, quizTheme9, quizTheme10, quizTheme11};
        }

        private QuizTheme(String str, int i, ThemeModel themeModel) {
            this.themeModel = themeModel;
        }

        public ThemeModel getThemeModel() {
            return this.themeModel;
        }
    }

    @Override // ir.resaneh1.iptv.story.quiz.OptionView.StatusChecker
    public void changeState(OptionView.OptionOrder optionOrder, boolean z) {
        Delegate delegate;
        ExtraView extraView;
        Delegate delegate2;
        if (!this.enableToLockMode && isEnableToLock() && (delegate2 = this.delegate) != null) {
            this.enableToLockMode = true;
            delegate2.onEnableLockMode();
        } else if (this.enableToLockMode && !isEnableToLock() && (delegate = this.delegate) != null) {
            this.enableToLockMode = false;
            delegate.onDisableLockMode(this.noEnoughOption ? LockError.NoEnoughOptions : LockError.NoCorrectAnswer);
        }
        if (this.isHintEnable && !this.enableToLockMode && !this.noEnoughOption && this.notCorrectAnswerSelected && (extraView = this.extraView) != null) {
            this.isHintEnable = false;
            extraView.showHint(this.addStoryHint, getWidth() / 2, this.quizTitle.getHeight() + this.marginBetweenTitleOption, 0, false);
        }
        if (optionOrder == OptionView.OptionOrder.A) {
            this.optionAIsEmpty = z;
        } else if (optionOrder == OptionView.OptionOrder.B) {
            this.optionBIsEmpty = z;
        } else if (optionOrder == OptionView.OptionOrder.C) {
            this.optionCIsEmpty = z;
        }
        addAnotherOption();
    }

    private void addAnotherOption() {
        if (!this.optionCIsEmpty && this.optionViews.size() == 3) {
            addOptionViewFour();
        }
        if (this.optionAIsEmpty || this.optionBIsEmpty || this.optionViews.size() != 2) {
            return;
        }
        addOptionViewThree();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        QuizMode quizMode = this.mode;
        if (quizMode == QuizMode.ADD_STORY && this.isLock) {
            return;
        }
        if (quizMode == QuizMode.STORY && this.isLock && this.firstClick) {
            this.firstClick = false;
            clickAction(view);
            if (this.correctOptionOrder.ordinal() == view.getId()) {
                scaleAnimate();
                return;
            } else {
                scaleAndShakeAnimate();
                return;
            }
        }
        if (this.isLock) {
            return;
        }
        clickAction(view);
    }

    public void clickAction(View view) {
        int id = view.getId();
        OptionView.OptionOrder optionOrder = OptionView.OptionOrder.A;
        if (id == optionOrder.ordinal()) {
            checkSelectedOption(optionOrder);
            return;
        }
        int id2 = view.getId();
        OptionView.OptionOrder optionOrder2 = OptionView.OptionOrder.B;
        if (id2 == optionOrder2.ordinal()) {
            checkSelectedOption(optionOrder2);
            return;
        }
        int id3 = view.getId();
        OptionView.OptionOrder optionOrder3 = OptionView.OptionOrder.C;
        if (id3 == optionOrder3.ordinal()) {
            checkSelectedOption(optionOrder3);
            return;
        }
        int id4 = view.getId();
        OptionView.OptionOrder optionOrder4 = OptionView.OptionOrder.D;
        if (id4 == optionOrder4.ordinal()) {
            checkSelectedOption(optionOrder4);
        }
    }

    private void checkSelectedOption(OptionView.OptionOrder optionOrder) {
        Delegate delegate;
        Delegate delegate2;
        OptionView optionView = this.optionViews.get(optionOrder.ordinal());
        if (optionView.getMode() != OptionView.OptionMode.PREVIEW) {
            QuizMode quizMode = this.mode;
            if (quizMode == QuizMode.STORY) {
                Delegate delegate3 = this.delegate;
                if (delegate3 != null) {
                    delegate3.onSelectOption(optionView.getOrder().ordinal());
                }
                showResult(optionView);
                return;
            }
            if (quizMode == QuizMode.ADD_STORY) {
                setCorrectAnswer(optionView);
                if (!this.enableToLockMode && isEnableToLock() && (delegate2 = this.delegate) != null) {
                    this.enableToLockMode = true;
                    delegate2.onEnableLockMode();
                } else {
                    if (!this.enableToLockMode || isEnableToLock() || (delegate = this.delegate) == null) {
                        return;
                    }
                    this.enableToLockMode = false;
                    delegate.onDisableLockMode(this.noEnoughOption ? LockError.NoEnoughOptions : LockError.NoCorrectAnswer);
                }
            }
        }
    }

    private void scaleAndShakeAnimate() {
        animate().scaleX(1.2f).scaleY(1.2f).setDuration(500L).setListener(new Animator.AnimatorListener() { // from class: ir.resaneh1.iptv.story.quiz.QuizSticker.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator.ofFloat(QuizSticker.this, "rotation", 0.0f, -10.0f, 10.0f, -5.0f, 0.0f).setDuration(700L).start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QuizSticker.this.animate().scaleX(1.0f).scaleY(1.0f).setDuration(500L).setListener(new Animator.AnimatorListener() { // from class: ir.resaneh1.iptv.story.quiz.QuizSticker.2.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        for (OptionView optionView : QuizSticker.this.optionViews) {
                            if (optionView.getOrder() == QuizSticker.this.correctOptionOrder) {
                                optionView.setMode(OptionView.OptionMode.CORRECT_ANSWER_SELECTED);
                            }
                        }
                    }
                }).start();
            }
        }).start();
    }

    private void scaleAnimate() {
        animate().scaleX(1.1f).scaleY(1.1f).setDuration(300L).setListener(new Animator.AnimatorListener() { // from class: ir.resaneh1.iptv.story.quiz.QuizSticker.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QuizSticker.this.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300L).setListener(new Animator.AnimatorListener() { // from class: ir.resaneh1.iptv.story.quiz.QuizSticker.3.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        if (QuizSticker.this.extraView != null) {
                            QuizSticker.this.extraView.showFireWorks();
                        }
                    }
                }).start();
            }
        }).start();
    }

    private void setCorrectAnswer(OptionView optionView) {
        OptionView.OptionMode optionMode;
        this.correctOptionOrder = optionView.getOrder();
        for (OptionView optionView2 : this.optionViews) {
            if (optionView2.getMode() == OptionView.OptionMode.CORRECT_ANSWER_SELECTED) {
                if (optionView2.isEmpty()) {
                    optionMode = OptionView.OptionMode.EMPTY;
                } else {
                    optionMode = OptionView.OptionMode.NOT_EMPTY;
                }
                optionView2.setMode(optionMode);
            }
        }
        optionView.setMode(OptionView.OptionMode.CORRECT_ANSWER_SELECTED);
    }

    private void showResult(OptionView optionView) {
        OptionView.OptionOrder optionOrder = this.correctOptionOrder;
        if (optionOrder != null) {
            if (optionOrder == optionView.getOrder()) {
                optionView.setMode(OptionView.OptionMode.CORRECT_ANSWER_SELECTED);
                for (OptionView optionView2 : this.optionViews) {
                    if (optionView != optionView2) {
                        optionView2.setAlpha(this.alpha);
                        optionView2.setMode(OptionView.OptionMode.WRONG_OPTION);
                    }
                }
            } else {
                optionView.setMode(OptionView.OptionMode.WRONG_ANSWER_SELECTED);
                for (OptionView optionView3 : this.optionViews) {
                    if (optionView != optionView3) {
                        optionView3.setAlpha(this.alpha);
                        if (optionView3.getOrder() == this.correctOptionOrder) {
                            optionView3.setMode(OptionView.OptionMode.CORRECT_OPTION);
                        } else {
                            optionView3.setMode(OptionView.OptionMode.WRONG_OPTION);
                        }
                    }
                }
            }
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.quizTitle.measure(View.MeasureSpec.makeMeasureSpec(quizStickerWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = this.quizTitle.getMeasuredHeight() + this.optionMargin + this.marginBetweenTitleOption;
        for (OptionView optionView : this.optionViews) {
            FrameLayout.LayoutParams layoutParams = this.layoutParamsList.get(optionView.getOrder().ordinal());
            layoutParams.topMargin = measuredHeight;
            optionView.setLayoutParams(layoutParams);
            measuredHeight += this.optionMargin + optionViewHeight;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(quizStickerWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        RectF rectF = this.backgroundRectF;
        rectF.top = 0.0f;
        rectF.left = 0.0f;
        rectF.right = i;
        rectF.bottom = i2;
        super.onSizeChanged(i, i2, i3, i4);
    }

    public QuizSticker(Context context, QuizMode quizMode, ThemeModel themeModel) {
        super(context);
        this.WHITE = -1;
        this.HINT_COLOR = -2046820353;
        this.shadowColor = 1694498816;
        this.backgroundCorner = AndroidUtilities.dp(12.0f);
        this.titlePaddingHeight = AndroidUtilities.dp(12.0f);
        this.titlePaddingWidth = AndroidUtilities.dp(17.0f);
        this.marginBetweenTitleOption = AndroidUtilities.dp(4.0f);
        this.optionMargin = AndroidUtilities.dp(11.0f);
        this.shadowRadius = AndroidUtilities.dp(3.0f);
        this.quizTitleFontSizeDp = 22;
        this.alpha = 0.6f;
        this.optionViewPercent = 0.89f;
        this.titleHint = "GUESS MY FAVORITE ...";
        this.storyHint = "select your answer";
        this.addStoryHint = "tap to select answer";
        this.isHintEnable = true;
        this.noEnoughOption = true;
        this.notCorrectAnswerSelected = true;
        this.titleTextWatcher = new TextWatcher() { // from class: ir.resaneh1.iptv.story.quiz.QuizSticker.1
            private String lastString;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (QuizSticker.this.quizTitle.getLayout().getLineCount() > 2) {
                    QuizSticker.this.quizTitle.removeTextChangedListener(QuizSticker.this.titleTextWatcher);
                    QuizSticker.this.quizTitle.setText(this.lastString);
                    QuizSticker.this.quizTitle.setSelection(this.lastString.length());
                    QuizSticker.this.quizTitle.addTextChangedListener(QuizSticker.this.titleTextWatcher);
                    return;
                }
                this.lastString = editable.toString();
            }
        };
        this.optionAIsEmpty = true;
        this.optionBIsEmpty = true;
        this.optionCIsEmpty = true;
        this.firstClick = true;
        this.mode = quizMode;
        this.theme = themeModel;
        setWillNotDraw(false);
        init();
        setTheme(themeModel);
    }

    private void init() {
        setClipChildren(false);
        setClipToPadding(false);
        this.optionViews = new ArrayList();
        this.layoutParamsList = new ArrayList();
        initBackground();
        initQuizTitle();
        addTwoOptionViews();
        setPadding(0, 0, 0, this.optionMargin);
    }

    private void initQuizTitle() {
        this.titleBackgroundPaint = new Paint(1);
        this.titleBackgroundPath = new Path();
        EditText editText = new EditText(getContext());
        this.quizTitle = editText;
        editText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        this.quizTitle.setTextSize(1, this.quizTitleFontSizeDp);
        this.quizTitle.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/AvenyTMedium.otf"));
        this.quizTitle.setHint(this.titleHint);
        this.quizTitle.setHintTextColor(this.HINT_COLOR);
        this.quizTitle.setGravity(17);
        if (Build.VERSION.SDK_INT >= 17) {
            this.quizTitle.setTextAlignment(4);
        }
        this.quizTitle.setTextColor(this.WHITE);
        this.quizTitle.setBackground(null);
        EditText editText2 = this.quizTitle;
        int i = this.titlePaddingWidth;
        int i2 = this.titlePaddingHeight;
        editText2.setPadding(i, i2, i, i2);
        if (this.mode == QuizMode.ADD_STORY) {
            this.quizTitle.addTextChangedListener(this.titleTextWatcher);
        }
        addView(this.quizTitle, new FrameLayout.LayoutParams(-1, -2, 49));
    }

    public void setTitleBackgroundColor(ThemeModel themeModel) {
        if (themeModel.isGradient()) {
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, quizStickerWidth, 0.0f, themeModel.getStartColor(), themeModel.getEndColor(), Shader.TileMode.REPEAT);
            this.shader = linearGradient;
            this.titleBackgroundPaint.setShader(linearGradient);
        } else {
            this.titleBackgroundPaint.setShader(null);
            this.titleBackgroundPaint.setColor(themeModel.getStartColor());
        }
        invalidate();
    }

    private void initBackground() {
        this.backgroundRectF = new RectF();
        Paint paint = new Paint(1);
        this.backgroundPaint = paint;
        paint.setColor(this.WHITE);
        this.backgroundPaint.setShadowLayer(this.shadowRadius, 0.0f, 0.0f, this.shadowColor);
    }

    private void addTwoOptionViews() {
        Context context = getContext();
        OptionView.OptionOrder optionOrder = OptionView.OptionOrder.A;
        QuizMode quizMode = this.mode;
        QuizMode quizMode2 = QuizMode.ADD_STORY;
        OptionView optionView = new OptionView(context, optionOrder, quizMode == quizMode2 ? OptionView.OptionMode.EMPTY : OptionView.OptionMode.NOT_EMPTY, quizMode);
        optionView.setStatusChecker(this);
        optionView.setOnClickListener(this);
        optionView.setId(optionOrder.ordinal());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (this.optionViewPercent * quizStickerWidth), optionViewHeight, 49);
        this.optionViews.add(optionView);
        this.layoutParamsList.add(layoutParams);
        addView(optionView);
        Context context2 = getContext();
        OptionView.OptionOrder optionOrder2 = OptionView.OptionOrder.B;
        QuizMode quizMode3 = this.mode;
        OptionView optionView2 = new OptionView(context2, optionOrder2, quizMode3 == quizMode2 ? OptionView.OptionMode.EMPTY : OptionView.OptionMode.NOT_EMPTY, quizMode3);
        optionView2.setStatusChecker(this);
        optionView2.setOnClickListener(this);
        optionView2.setId(optionOrder2.ordinal());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (this.optionViewPercent * quizStickerWidth), optionViewHeight, 49);
        this.optionViews.add(optionView2);
        this.layoutParamsList.add(layoutParams2);
        addView(optionView2);
    }

    private void addOptionViewThree() {
        Context context = getContext();
        OptionView.OptionOrder optionOrder = OptionView.OptionOrder.C;
        QuizMode quizMode = this.mode;
        OptionView optionView = new OptionView(context, optionOrder, quizMode == QuizMode.ADD_STORY ? OptionView.OptionMode.PREVIEW : OptionView.OptionMode.NOT_EMPTY, quizMode);
        optionView.setStatusChecker(this);
        optionView.setOnClickListener(this);
        optionView.setId(optionOrder.ordinal());
        optionView.setTheme(this.theme);
        this.optionViews.add(optionView);
        if (this.layoutParamsList.size() == optionOrder.ordinal()) {
            this.layoutParamsList.add(new FrameLayout.LayoutParams((int) (this.optionViewPercent * quizStickerWidth), optionViewHeight, 49));
        }
        addView(optionView);
    }

    private void addOptionViewFour() {
        Context context = getContext();
        OptionView.OptionOrder optionOrder = OptionView.OptionOrder.D;
        QuizMode quizMode = this.mode;
        OptionView optionView = new OptionView(context, optionOrder, quizMode == QuizMode.ADD_STORY ? OptionView.OptionMode.PREVIEW : OptionView.OptionMode.NOT_EMPTY, quizMode);
        optionView.setStatusChecker(this);
        optionView.setOnClickListener(this);
        optionView.setId(optionOrder.ordinal());
        optionView.setTheme(this.theme);
        this.optionViews.add(optionView);
        if (this.layoutParamsList.size() == optionOrder.ordinal()) {
            this.layoutParamsList.add(new FrameLayout.LayoutParams((int) (this.optionViewPercent * quizStickerWidth), optionViewHeight, 49));
        }
        addView(optionView);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Delegate delegate;
        RectF rectF = this.backgroundRectF;
        int i = this.backgroundCorner;
        canvas.drawRoundRect(rectF, i, i, this.backgroundPaint);
        drawTitleBackground(canvas);
        if (this.mode != QuizMode.STORY || !this.isHintEnable || this.extraView == null || (delegate = this.delegate) == null) {
            return;
        }
        this.isHintEnable = false;
        Point pointRealValueOfEventPosition = delegate.realValueOfEventPosition(getWidth() / 2, getHeight());
        this.extraView.showHint(this.storyHint, pointRealValueOfEventPosition.x, pointRealValueOfEventPosition.y, 0, true);
    }

    private void drawTitleBackground(Canvas canvas) {
        this.titleBackgroundPath.reset();
        this.titleBackgroundPath.moveTo(this.backgroundCorner, 0.0f);
        this.titleBackgroundPath.rLineTo(getWidth() - (this.backgroundCorner * 2), 0.0f);
        Path path = this.titleBackgroundPath;
        int i = this.backgroundCorner;
        path.rLineTo(i, i);
        this.titleBackgroundPath.rLineTo(0.0f, this.quizTitle.getHeight() - this.backgroundCorner);
        this.titleBackgroundPath.rLineTo(-getWidth(), 0.0f);
        this.titleBackgroundPath.rLineTo(0.0f, (-this.quizTitle.getHeight()) + this.backgroundCorner);
        this.titleBackgroundPath.rLineTo(this.backgroundCorner, -r1);
        Path path2 = this.titleBackgroundPath;
        int i2 = this.backgroundCorner;
        path2.addCircle(i2, i2, i2, Path.Direction.CW);
        Path path3 = this.titleBackgroundPath;
        int width = getWidth();
        int i3 = this.backgroundCorner;
        path3.addCircle(width - i3, i3, i3, Path.Direction.CW);
        canvas.drawPath(this.titleBackgroundPath, this.titleBackgroundPaint);
    }

    public int getCorrectOptionOrder() {
        OptionView.OptionOrder optionOrder = this.correctOptionOrder;
        if (optionOrder == null) {
            return -1;
        }
        return optionOrder.ordinal();
    }

    public void setCorrectOptionOrder(int i) {
        for (OptionView.OptionOrder optionOrder : OptionView.OptionOrder.values()) {
            if (optionOrder.ordinal() == i) {
                this.correctOptionOrder = optionOrder;
            }
        }
    }

    public boolean setLock(boolean z) {
        if (z && !isEnableToLock()) {
            this.enableToLockMode = false;
            Delegate delegate = this.delegate;
            if (delegate != null) {
                delegate.onDisableLockMode(this.noEnoughOption ? LockError.NoEnoughOptions : LockError.NoCorrectAnswer);
            }
            return false;
        }
        this.enableToLockMode = true;
        this.isLock = z;
        if (!z) {
            OptionView.OptionOrder optionOrder = this.correctOptionOrder;
            if (optionOrder != null) {
                checkSelectedOption(optionOrder);
            }
            addAnotherOption();
        }
        invalidateOptionViewsIfNeeded();
        Iterator<OptionView> it = this.optionViews.iterator();
        while (it.hasNext()) {
            it.next().setLock(z);
        }
        if (this.isLock) {
            this.quizTitle.setHintTextColor(this.WHITE);
            this.quizTitle.setEnabled(false);
            this.quizTitle.setFocusable(false);
            this.quizTitle.setFocusableInTouchMode(false);
            this.movementMethod = this.quizTitle.getMovementMethod();
            this.keyListener = this.quizTitle.getKeyListener();
            this.quizTitle.setMovementMethod(null);
            this.quizTitle.setKeyListener(null);
        } else {
            this.quizTitle.setHintTextColor(this.HINT_COLOR);
            this.quizTitle.setEnabled(true);
            this.quizTitle.setFocusable(true);
            this.quizTitle.setFocusableInTouchMode(true);
            MovementMethod movementMethod = this.movementMethod;
            if (movementMethod != null) {
                this.quizTitle.setMovementMethod(movementMethod);
            }
            KeyListener keyListener = this.keyListener;
            if (keyListener != null) {
                this.quizTitle.setKeyListener(keyListener);
            }
        }
        return true;
    }

    public boolean isEnableToLock() {
        this.noEnoughOption = noEnoughOption();
        boolean zNotCorrectAnswerSelected = notCorrectAnswerSelected();
        this.notCorrectAnswerSelected = zNotCorrectAnswerSelected;
        return (this.mode == QuizMode.ADD_STORY && (this.noEnoughOption || zNotCorrectAnswerSelected)) ? false : true;
    }

    private boolean notCorrectAnswerSelected() {
        if (this.correctOptionOrder == null) {
            return true;
        }
        for (OptionView optionView : this.optionViews) {
            if (!optionView.isEmpty() && optionView.getMode() == OptionView.OptionMode.CORRECT_ANSWER_SELECTED) {
                return false;
            }
        }
        return true;
    }

    private boolean noEnoughOption() {
        Iterator<OptionView> it = this.optionViews.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!it.next().isEmpty()) {
                i++;
            }
        }
        return i < 2;
    }

    private void invalidateOptionViewsIfNeeded() {
        if (this.mode == QuizMode.ADD_STORY && this.isLock) {
            Iterator<OptionView> it = this.optionViews.iterator();
            while (it.hasNext()) {
                OptionView next = it.next();
                if (next.isEmpty()) {
                    it.remove();
                    removeView(next);
                }
            }
            int i = 0;
            for (OptionView optionView : this.optionViews) {
                OptionView.OptionOrder[] optionOrderArrValues = OptionView.OptionOrder.values();
                int length = optionOrderArrValues.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        OptionView.OptionOrder optionOrder = optionOrderArrValues[i2];
                        if (optionOrder.ordinal() == i) {
                            optionView.setOrder(optionOrder);
                            optionView.setId(optionOrder.ordinal());
                            i++;
                            break;
                        }
                        i2++;
                    }
                }
            }
            this.optionAIsEmpty = false;
            this.optionBIsEmpty = false;
            this.optionCIsEmpty = true;
            if (this.optionViews.size() > 2) {
                this.optionCIsEmpty = false;
            }
            invalidate();
        }
    }

    public void setTitle(String str) {
        this.quizTitle.setText(str);
    }

    public String getTitle() {
        String string = this.quizTitle.getText().toString();
        return string.isEmpty() ? this.titleHint : string;
    }

    public void setOptions(List<String> list) {
        this.optionViews.get(0).setText(list.get(0));
        this.optionViews.get(1).setText(list.get(1));
        for (int i = 2; i < list.size(); i++) {
            if (this.optionViews.size() <= i) {
                addOptionViewThree();
                this.optionViews.get(i).setText(list.get(i));
            }
        }
        setLock(true);
    }

    public List<String> getOptions() {
        ArrayList arrayList = new ArrayList();
        Iterator<OptionView> it = this.optionViews.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getText());
        }
        return arrayList;
    }

    public EditText getDefaultFocusEditText() {
        return this.quizTitle;
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    public void setExtraView(ExtraView extraView) {
        this.extraView = extraView;
    }

    public void setTheme(ThemeModel themeModel) {
        this.theme = themeModel;
        setOptionsTheme(themeModel);
        setTitleBackgroundColor(themeModel);
    }

    public void setOptionsTheme(ThemeModel themeModel) {
        Iterator<OptionView> it = this.optionViews.iterator();
        while (it.hasNext()) {
            it.next().setTheme(themeModel);
        }
    }

    public ThemeModel getTheme() {
        return this.theme;
    }

    public void setHintEnable(boolean z) {
        this.isHintEnable = z;
        invalidate();
    }

    public static int getQuizStickerWidth() {
        return quizStickerWidth;
    }
}
