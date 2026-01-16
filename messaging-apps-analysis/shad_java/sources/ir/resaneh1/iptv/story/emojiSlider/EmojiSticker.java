package ir.resaneh1.iptv.story.emojiSlider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import ir.resaneh1.iptv.story.ExtraView;
import ir.resaneh1.iptv.story.emojiSlider.EmojiSeekbar;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class EmojiSticker extends FrameLayout {
    public static int BLACK_COLOR = -16777216;
    public static int BLUE_COLOR = -13068304;
    public static int ORANGE_COLOR = -160462;
    public static int PINK_COLOR = -3078039;
    public static int PURPLE_COLOR = -3078039;
    public static int RED_COLOR = -1226410;
    public static int SEEK_BAR_BACKGROUND_COLOR = 1295990591;
    public static int WHITE_COLOR = -1;
    public static int YELLOW_COLOR = -144548;
    private static int width = AndroidUtilities.dp(280.0f);
    private Paint backgroundPaint;
    private RectF backgroundRect;
    private int cornerSize;
    private int editTextBottomMargin;
    private final FrameLayout.LayoutParams editTextParams;
    private EmojiMode emojiMode;
    private final FrameLayout.LayoutParams emojiParams;
    private EmojiSeekbar emojiSeekbar;
    private String hint;
    private int hintColor;
    private boolean isLock;
    private KeyListener keyListener;
    private MovementMethod movementMethod;
    private int paddingHeight;
    private int paddingHeightPreview;
    private int paddingTVWidth;
    private SliderTheme sliderTheme;
    private int textSizeDp;
    private TextWatcher textWatcher;
    private EditText titleEditText;

    public enum EmojiMode {
        PREVIEW,
        ADD_STORY,
        STORY,
        STORY_LOCK
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BLACK' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class SliderTheme {
        private static final /* synthetic */ SliderTheme[] $VALUES;
        public static final SliderTheme BLACK;
        public static final SliderTheme BLUE;
        public static final SliderTheme ORANGE;
        public static final SliderTheme PINK;
        public static final SliderTheme PURPLE;
        public static final SliderTheme RED;
        public static final SliderTheme WHITE;
        public static final SliderTheme YELLOW;
        private ThemeModel themeModel;

        public static SliderTheme valueOf(String str) {
            return (SliderTheme) Enum.valueOf(SliderTheme.class, str);
        }

        public static SliderTheme[] values() {
            return (SliderTheme[]) $VALUES.clone();
        }

        static {
            SliderTheme sliderTheme = new SliderTheme("WHITE", 0, new ThemeModel(EmojiSticker.WHITE_COLOR, EmojiSticker.SEEK_BAR_BACKGROUND_COLOR, 0, EmojiSticker.BLACK_COLOR, true));
            WHITE = sliderTheme;
            int i = EmojiSticker.BLACK_COLOR;
            int i2 = EmojiSticker.SEEK_BAR_BACKGROUND_COLOR;
            int i3 = EmojiSticker.WHITE_COLOR;
            SliderTheme sliderTheme2 = new SliderTheme("BLACK", 1, new ThemeModel(i, i2, i3, i3, false));
            BLACK = sliderTheme2;
            int i4 = EmojiSticker.BLUE_COLOR;
            int i5 = EmojiSticker.SEEK_BAR_BACKGROUND_COLOR;
            int i6 = EmojiSticker.WHITE_COLOR;
            SliderTheme sliderTheme3 = new SliderTheme("BLUE", 2, new ThemeModel(i4, i5, i6, i6, false));
            BLUE = sliderTheme3;
            int i7 = EmojiSticker.YELLOW_COLOR;
            int i8 = EmojiSticker.SEEK_BAR_BACKGROUND_COLOR;
            int i9 = EmojiSticker.WHITE_COLOR;
            SliderTheme sliderTheme4 = new SliderTheme("YELLOW", 3, new ThemeModel(i7, i8, i9, i9, false));
            YELLOW = sliderTheme4;
            int i10 = EmojiSticker.ORANGE_COLOR;
            int i11 = EmojiSticker.SEEK_BAR_BACKGROUND_COLOR;
            int i12 = EmojiSticker.WHITE_COLOR;
            SliderTheme sliderTheme5 = new SliderTheme("ORANGE", 4, new ThemeModel(i10, i11, i12, i12, false));
            ORANGE = sliderTheme5;
            int i13 = EmojiSticker.RED_COLOR;
            int i14 = EmojiSticker.SEEK_BAR_BACKGROUND_COLOR;
            int i15 = EmojiSticker.WHITE_COLOR;
            SliderTheme sliderTheme6 = new SliderTheme("RED", 5, new ThemeModel(i13, i14, i15, i15, false));
            RED = sliderTheme6;
            int i16 = EmojiSticker.PINK_COLOR;
            int i17 = EmojiSticker.SEEK_BAR_BACKGROUND_COLOR;
            int i18 = EmojiSticker.WHITE_COLOR;
            SliderTheme sliderTheme7 = new SliderTheme("PINK", 6, new ThemeModel(i16, i17, i18, i18, false));
            PINK = sliderTheme7;
            int i19 = EmojiSticker.PURPLE_COLOR;
            int i20 = EmojiSticker.SEEK_BAR_BACKGROUND_COLOR;
            int i21 = EmojiSticker.WHITE_COLOR;
            SliderTheme sliderTheme8 = new SliderTheme("PURPLE", 7, new ThemeModel(i19, i20, i21, i21, false));
            PURPLE = sliderTheme8;
            $VALUES = new SliderTheme[]{sliderTheme, sliderTheme2, sliderTheme3, sliderTheme4, sliderTheme5, sliderTheme6, sliderTheme7, sliderTheme8};
        }

        private SliderTheme(String str, int i, ThemeModel themeModel) {
            this.themeModel = themeModel;
        }

        public ThemeModel getThemeModel() {
            return this.themeModel;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.emojiSeekbar.measure(i, i2);
        this.editTextParams.bottomMargin = this.editTextBottomMargin + this.emojiSeekbar.getMeasuredHeight();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 0));
        this.emojiSeekbar.setParentOffsetY((getMeasuredHeight() - this.paddingHeight) - this.emojiSeekbar.getMeasuredHeight());
    }

    public EmojiSticker(Context context, EmojiMode emojiMode, EmojiSeekbar.Delegate delegate) {
        super(context);
        this.hintColor = 1295990591;
        this.hint = "Ask a question...";
        this.paddingHeight = AndroidUtilities.dp(22.0f);
        this.paddingHeightPreview = AndroidUtilities.dp(18.0f);
        this.paddingTVWidth = AndroidUtilities.dp(16.0f);
        this.textSizeDp = 21;
        this.editTextBottomMargin = AndroidUtilities.dp(8.0f);
        this.cornerSize = AndroidUtilities.dp(15.0f);
        this.textWatcher = new TextWatcher() { // from class: ir.resaneh1.iptv.story.emojiSlider.EmojiSticker.1
            private String lastString;
            private int selectionStart;

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.selectionStart = EmojiSticker.this.titleEditText.getSelectionStart();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                EmojiSticker.this.titleEditText.removeTextChangedListener(EmojiSticker.this.textWatcher);
                if (EmojiSticker.this.titleEditText.getLayout().getLineCount() > 3) {
                    EmojiSticker.this.titleEditText.setText(this.lastString);
                    EmojiSticker.this.titleEditText.setSelection(this.selectionStart);
                } else {
                    this.lastString = editable.toString();
                }
                EmojiSticker.this.titleEditText.addTextChangedListener(EmojiSticker.this.textWatcher);
            }
        };
        setWillNotDraw(false);
        Paint paint = new Paint(1);
        this.backgroundPaint = paint;
        paint.setColor(WHITE_COLOR);
        this.emojiMode = emojiMode;
        if (emojiMode == EmojiMode.PREVIEW) {
            this.paddingHeight = this.paddingHeightPreview;
        }
        int i = this.paddingHeight;
        setPadding(0, i, 0, i);
        setClipChildren(false);
        setClipToPadding(false);
        this.emojiSeekbar = new EmojiSeekbar(getContext(), delegate);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, -2, 80);
        this.emojiParams = layoutParams;
        setupEditText();
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2, 80);
        this.editTextParams = layoutParams2;
        setSliderTheme(SliderTheme.WHITE);
        setEmojiMode(emojiMode);
        addView(this.titleEditText, layoutParams2);
        addView(this.emojiSeekbar, layoutParams);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        RectF rectF = new RectF();
        this.backgroundRect = rectF;
        rectF.top = 0.0f;
        rectF.left = 0.0f;
        rectF.right = i;
        rectF.bottom = i2;
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.backgroundRect;
        int i = this.cornerSize;
        canvas.drawRoundRect(rectF, i, i, this.backgroundPaint);
    }

    public void setSliderTheme(SliderTheme sliderTheme) {
        this.sliderTheme = sliderTheme;
        setSeekBarBackgroundColor(sliderTheme.getThemeModel().getSeekBarBackgroundColor());
        setSeekBarForegroundColor(sliderTheme.getThemeModel().isGradient(), sliderTheme.getThemeModel().getSeekBarForegroundColor());
        setTextColor(sliderTheme.themeModel.getTextColor());
        setBackGroundColor(sliderTheme.themeModel.getBackgroundColor());
    }

    private void setupEditText() {
        EditText editText = new EditText(getContext());
        this.titleEditText = editText;
        editText.setHint(this.hint);
        this.titleEditText.setHintTextColor(this.hintColor);
        if (Build.VERSION.SDK_INT >= 17) {
            this.titleEditText.setTextAlignment(4);
        }
        this.titleEditText.setTextSize(1, this.textSizeDp);
        this.titleEditText.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        EditText editText2 = this.titleEditText;
        int i = this.paddingTVWidth;
        editText2.setPadding(i, 0, i, 0);
        this.titleEditText.setMaxLines(3);
        this.titleEditText.setBackgroundColor(0);
        if (this.emojiMode == EmojiMode.ADD_STORY) {
            this.titleEditText.addTextChangedListener(this.textWatcher);
        }
    }

    /* renamed from: ir.resaneh1.iptv.story.emojiSlider.EmojiSticker$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$ir$resaneh1$iptv$story$emojiSlider$EmojiSticker$EmojiMode;

        static {
            int[] iArr = new int[EmojiMode.values().length];
            $SwitchMap$ir$resaneh1$iptv$story$emojiSlider$EmojiSticker$EmojiMode = iArr;
            try {
                iArr[EmojiMode.PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$emojiSlider$EmojiSticker$EmojiMode[EmojiMode.ADD_STORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$emojiSlider$EmojiSticker$EmojiMode[EmojiMode.STORY_LOCK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$emojiSlider$EmojiSticker$EmojiMode[EmojiMode.STORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void setEmojiMode(EmojiMode emojiMode) {
        this.emojiSeekbar.setMode(emojiMode);
        int i = AnonymousClass2.$SwitchMap$ir$resaneh1$iptv$story$emojiSlider$EmojiSticker$EmojiMode[emojiMode.ordinal()];
        if (i == 1) {
            titleEditTextVisibility(8, false);
            this.emojiSeekbar.setPreviewMode(true);
            this.emojiSeekbar.lockTouchMode(true);
        } else {
            if (i == 2) {
                titleEditTextVisibility(0, true);
                this.emojiSeekbar.setPreviewMode(false);
                this.emojiSeekbar.lockTouchMode(false);
                return;
            }
            if (i == 3) {
                lockDragging(true);
            } else if (i != 4) {
                return;
            }
            titleEditTextVisibility(this.titleEditText.length() != 0 ? 0 : 8, false);
            this.emojiSeekbar.setPreviewMode(false);
            this.emojiSeekbar.lockTouchMode(false);
        }
    }

    public void setValues(String str, float f, float f2, String str2) {
        setEmoji(str);
        this.emojiSeekbar.setFinalPercentage(f);
        if (f == f2) {
            f2 = -1.0f;
        }
        setAverage(f2);
        setTitle(str2);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.titleEditText.setText(str);
            titleEditTextVisibility(this.titleEditText.length() == 0 ? 8 : 0, false);
        }
    }

    public void setUserProfileImage(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.emojiSeekbar.setUserProfileImage(bitmap);
    }

    public void setEmoji(String str) {
        this.emojiSeekbar.setEmoji(str);
    }

    public void lockAddStoryMode(boolean z) {
        if (this.emojiMode == EmojiMode.ADD_STORY) {
            this.isLock = z;
            if (z) {
                titleEditTextVisibility(this.titleEditText.length() == 0 ? 8 : 0, false);
                this.emojiSeekbar.lockTouchMode(true);
            } else {
                titleEditTextVisibility(0, true);
                this.emojiSeekbar.lockTouchMode(false);
            }
        }
    }

    public void lockDragging(boolean z) {
        this.emojiSeekbar.lockDragging(z);
    }

    public EmojiMode getEmojiMode() {
        return this.emojiMode;
    }

    private void titleEditTextVisibility(int i, boolean z) {
        this.titleEditText.setVisibility(i);
        this.titleEditText.setEnabled(z);
        if (z) {
            MovementMethod movementMethod = this.movementMethod;
            if (movementMethod != null) {
                this.titleEditText.setMovementMethod(movementMethod);
            }
            KeyListener keyListener = this.keyListener;
            if (keyListener != null) {
                this.titleEditText.setKeyListener(keyListener);
                return;
            }
            return;
        }
        this.movementMethod = this.titleEditText.getMovementMethod();
        this.keyListener = this.titleEditText.getKeyListener();
        this.titleEditText.setKeyListener(null);
        this.titleEditText.setMovementMethod(null);
    }

    public static int getViewWidth() {
        return width;
    }

    public static int getPreviewHeight() {
        return EmojiSeekbar.heightPreview;
    }

    public boolean onTouch(float f, float f2, int i) {
        return this.emojiSeekbar.onTouch(f, f2, i);
    }

    public String getTitle() {
        return this.titleEditText.getText().toString();
    }

    public String getEmoji() {
        return this.emojiSeekbar.getEmoji();
    }

    public SliderTheme getTheme() {
        return this.sliderTheme;
    }

    public EditText getFocusEditText() {
        return this.titleEditText;
    }

    public void setBackGroundColor(int i) {
        this.backgroundPaint.setColor(i);
        invalidate();
    }

    public void setSeekBarBackgroundColor(int i) {
        this.emojiSeekbar.setBackGroundColor(i);
    }

    public void setSeekBarForegroundColor(boolean z, int i) {
        this.emojiSeekbar.setProgressColor(z, i);
    }

    public boolean isGradient() {
        return this.emojiSeekbar.isGradient();
    }

    public void setTextColor(int i) {
        this.titleEditText.setTextColor(i);
    }

    public void setExtraView(ExtraView extraView) {
        this.emojiSeekbar.setExtraView(extraView);
    }

    public void setAverage(float f) {
        this.emojiSeekbar.setAverage(f);
    }
}
