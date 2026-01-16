package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ColorPicker extends FrameLayout {
    private ImageView addButton;
    private Drawable circleDrawable;
    private Paint circlePaint;
    private boolean circlePressed;
    private ImageView clearButton;
    private EditTextBoldCursor[] colorEditText;
    private LinearGradient colorGradient;
    private float[] colorHSV;
    private boolean colorPressed;
    private Bitmap colorWheelBitmap;
    private Paint colorWheelPaint;
    private int colorWheelWidth;
    private AnimatorSet colorsAnimator;
    private int colorsCount;
    private int currentResetType;
    private final ColorPickerDelegate delegate;
    private float[] hsvTemp;
    boolean ignoreTextChange;
    private long lastUpdateTime;
    private Paint linePaint;
    private LinearLayout linearLayout;
    private float maxBrightness;
    private int maxColorsCount;
    private float maxHsvBrightness;
    private ActionBarMenuItem menuItem;
    private float minBrightness;
    private float minHsvBrightness;
    private boolean myMessagesColor;
    private float pressedMoveProgress;
    private RadioButton[] radioButton;
    private FrameLayout radioContainer;
    private TextView resetButton;
    private int selectedColor;
    private RectF sliderRect;
    private Paint valueSliderPaint;

    public interface ColorPickerDelegate {
        void deleteTheme();

        int getDefaultColor(int num);

        void openThemeCreate(boolean share);

        void setColor(int color, int num, boolean applyNow);
    }

    static /* synthetic */ void lambda$new$4(View view) {
    }

    private static class RadioButton extends View {
        private ObjectAnimator checkAnimator;
        private boolean checked;
        private float checkedState;
        private int currentColor;
        private final Paint paint;

        public RadioButton(Context context) {
            super(context);
            this.paint = new Paint(1);
        }

        void updateCheckedState(boolean animate) {
            ObjectAnimator objectAnimator = this.checkAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (animate) {
                float[] fArr = new float[1];
                fArr[0] = this.checked ? 1.0f : 0.0f;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "checkedState", fArr);
                this.checkAnimator = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(200L);
                this.checkAnimator.start();
                return;
            }
            setCheckedState(this.checked ? 1.0f : 0.0f);
        }

        public void setChecked(boolean value, boolean animated) {
            this.checked = value;
            updateCheckedState(animated);
        }

        public void setColor(int color) {
            this.currentColor = color;
            invalidate();
        }

        public int getColor() {
            return this.currentColor;
        }

        @Keep
        public void setCheckedState(float state) {
            this.checkedState = state;
            invalidate();
        }

        @Keep
        public float getCheckedState() {
            return this.checkedState;
        }

        @Override // android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            updateCheckedState(false);
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(30.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(30.0f), 1073741824));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float fDp = AndroidUtilities.dp(15.0f);
            float measuredWidth = getMeasuredWidth() * 0.5f;
            float measuredHeight = getMeasuredHeight() * 0.5f;
            this.paint.setColor(this.currentColor);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(AndroidUtilities.dp(3.0f));
            this.paint.setAlpha(Math.round(this.checkedState * 255.0f));
            canvas.drawCircle(measuredWidth, measuredHeight, fDp - (this.paint.getStrokeWidth() * 0.5f), this.paint);
            this.paint.setAlpha(255);
            this.paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(measuredWidth, measuredHeight, fDp - (AndroidUtilities.dp(5.0f) * this.checkedState), this.paint);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setText(LocaleController.getString("ColorPickerMainColor", R.string.ColorPickerMainColor));
            info.setClassName(Button.class.getName());
            info.setChecked(this.checked);
            info.setCheckable(true);
            info.setEnabled(true);
        }
    }

    public ColorPicker(Context context, boolean hasMenu, ColorPickerDelegate colorPickerDelegate) {
        super(context);
        this.sliderRect = new RectF();
        this.radioButton = new RadioButton[4];
        this.colorsCount = 1;
        this.maxColorsCount = 1;
        this.colorHSV = new float[]{0.0f, 0.0f, 1.0f};
        this.hsvTemp = new float[3];
        this.pressedMoveProgress = 1.0f;
        this.minBrightness = 0.0f;
        this.maxBrightness = 1.0f;
        this.minHsvBrightness = 0.0f;
        this.maxHsvBrightness = 1.0f;
        this.delegate = colorPickerDelegate;
        this.colorEditText = new EditTextBoldCursor[2];
        setWillNotDraw(false);
        this.circleDrawable = context.getResources().getDrawable(R.drawable.knob_shadow).mutate();
        this.circlePaint = new Paint(1);
        this.colorWheelPaint = new Paint(5);
        this.valueSliderPaint = new Paint(5);
        Paint paint = new Paint();
        this.linePaint = paint;
        paint.setColor(301989888);
        setClipChildren(false);
        LinearLayout linearLayout = new LinearLayout(context) { // from class: ir.eitaa.ui.Components.ColorPicker.1
            private Paint paint;
            private RectF rect = new RectF();

            {
                Paint paint2 = new Paint(1);
                this.paint = paint2;
                paint2.setColor(Theme.getColor("dialogBackgroundGray"));
            }

            @Override // android.widget.LinearLayout, android.view.View
            protected void onDraw(Canvas canvas) {
                this.rect.set(ColorPicker.this.colorEditText[0].getLeft() - AndroidUtilities.dp(13.0f), AndroidUtilities.dp(5.0f), r0 + ((int) (AndroidUtilities.dp(91.0f) + (ColorPicker.this.clearButton.getVisibility() == 0 ? AndroidUtilities.dp(25.0f) * ColorPicker.this.clearButton.getAlpha() : 0.0f))), AndroidUtilities.dp(37.0f));
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), this.paint);
            }
        };
        this.linearLayout = linearLayout;
        linearLayout.setOrientation(0);
        addView(this.linearLayout, LayoutHelper.createFrame(-1, 54.0f, 51, 27.0f, -6.0f, 17.0f, 0.0f));
        this.linearLayout.setWillNotDraw(false);
        FrameLayout frameLayout = new FrameLayout(context);
        this.radioContainer = frameLayout;
        frameLayout.setClipChildren(false);
        addView(this.radioContainer, LayoutHelper.createFrame(174, 30.0f, 49, 72.0f, 1.0f, 0.0f, 0.0f));
        int i = 0;
        while (i < 4) {
            this.radioButton[i] = new RadioButton(context);
            this.radioButton[i].setChecked(this.selectedColor == i, false);
            this.radioContainer.addView(this.radioButton[i], LayoutHelper.createFrame(30, 30.0f, 48, 0.0f, 0.0f, 0.0f, 0.0f));
            this.radioButton[i].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ColorPicker$y_ysP8p896KDvpVrHMQgIG8ztPE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0$ColorPicker(view);
                }
            });
            i++;
        }
        final int i2 = 0;
        while (true) {
            EditTextBoldCursor[] editTextBoldCursorArr = this.colorEditText;
            if (i2 >= editTextBoldCursorArr.length) {
                break;
            }
            if (i2 % 2 == 0) {
                editTextBoldCursorArr[i2] = new EditTextBoldCursor(context) { // from class: ir.eitaa.ui.Components.ColorPicker.2
                    @Override // android.widget.TextView, android.view.View
                    public boolean onTouchEvent(MotionEvent event) {
                        if (getAlpha() == 1.0f && event.getAction() == 0) {
                            if (ColorPicker.this.colorEditText[i2 + 1].isFocused()) {
                                AndroidUtilities.showKeyboard(ColorPicker.this.colorEditText[i2 + 1]);
                            } else {
                                ColorPicker.this.colorEditText[i2 + 1].requestFocus();
                            }
                        }
                        return false;
                    }
                };
                this.colorEditText[i2].setBackgroundDrawable(null);
                this.colorEditText[i2].setText("#");
                this.colorEditText[i2].setEnabled(false);
                this.colorEditText[i2].setFocusable(false);
                this.colorEditText[i2].setPadding(0, AndroidUtilities.dp(5.0f), 0, AndroidUtilities.dp(16.0f));
                this.linearLayout.addView(this.colorEditText[i2], LayoutHelper.createLinear(-2, -1, 0.0f, 0.0f, 0.0f, 0.0f));
            } else {
                editTextBoldCursorArr[i2] = new EditTextBoldCursor(context) { // from class: ir.eitaa.ui.Components.ColorPicker.3
                    @Override // android.widget.TextView, android.view.View
                    public boolean onTouchEvent(MotionEvent event) {
                        if (getAlpha() != 1.0f) {
                            return false;
                        }
                        if (!isFocused()) {
                            requestFocus();
                            return false;
                        }
                        AndroidUtilities.showKeyboard(this);
                        return super.onTouchEvent(event);
                    }

                    @Override // android.view.View
                    public boolean getGlobalVisibleRect(android.graphics.Rect r, android.graphics.Point globalOffset) {
                        boolean globalVisibleRect = super.getGlobalVisibleRect(r, globalOffset);
                        r.bottom += AndroidUtilities.dp(40.0f);
                        return globalVisibleRect;
                    }

                    @Override // android.view.View
                    public void invalidate() {
                        super.invalidate();
                        ColorPicker.this.colorEditText[i2 - 1].invalidate();
                    }
                };
                this.colorEditText[i2].setBackgroundDrawable(null);
                this.colorEditText[i2].setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
                this.colorEditText[i2].setHint("8BC6ED");
                this.colorEditText[i2].setPadding(0, AndroidUtilities.dp(5.0f), 0, AndroidUtilities.dp(16.0f));
                this.linearLayout.addView(this.colorEditText[i2], LayoutHelper.createLinear(71, -1, 0.0f, 0.0f, 0.0f, 0.0f));
                this.colorEditText[i2].addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.Components.ColorPicker.4
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i3, int i22, int i32) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i3, int i22, int i32) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        ColorPicker colorPicker = ColorPicker.this;
                        if (colorPicker.ignoreTextChange) {
                            return;
                        }
                        colorPicker.ignoreTextChange = true;
                        int i3 = 0;
                        while (i3 < editable.length()) {
                            char cCharAt = editable.charAt(i3);
                            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'f') && (cCharAt < 'A' || cCharAt > 'F'))) {
                                editable.replace(i3, i3 + 1, "");
                                i3--;
                            }
                            i3++;
                        }
                        if (editable.length() == 0) {
                            ColorPicker.this.ignoreTextChange = false;
                            return;
                        }
                        ColorPicker colorPicker2 = ColorPicker.this;
                        colorPicker2.setColorInner(colorPicker2.getFieldColor(i2, -1));
                        int color = ColorPicker.this.getColor();
                        if (editable.length() == 6) {
                            editable.replace(0, editable.length(), String.format("%02x%02x%02x", Byte.valueOf((byte) Color.red(color)), Byte.valueOf((byte) Color.green(color)), Byte.valueOf((byte) Color.blue(color))).toUpperCase());
                            ColorPicker.this.colorEditText[i2].setSelection(editable.length());
                        }
                        ColorPicker.this.radioButton[ColorPicker.this.selectedColor].setColor(color);
                        ColorPicker.this.delegate.setColor(color, ColorPicker.this.selectedColor, true);
                        ColorPicker.this.ignoreTextChange = false;
                    }
                });
                this.colorEditText[i2].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ColorPicker$IcMwM6imnIObartnDALHdP0N-U8
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                        return ColorPicker.lambda$new$1(textView, i3, keyEvent);
                    }
                });
            }
            this.colorEditText[i2].setTextSize(1, 16.0f);
            this.colorEditText[i2].setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.colorEditText[i2].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.colorEditText[i2].setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.colorEditText[i2].setCursorSize(AndroidUtilities.dp(18.0f));
            this.colorEditText[i2].setCursorWidth(1.5f);
            this.colorEditText[i2].setSingleLine(true);
            this.colorEditText[i2].setGravity(19);
            this.colorEditText[i2].setHeaderHintColor(Theme.getColor("windowBackgroundWhiteBlueHeader"));
            this.colorEditText[i2].setTransformHintToHeader(true);
            this.colorEditText[i2].setInputType(524416);
            this.colorEditText[i2].setImeOptions(268435462);
            if (i2 == 1) {
                this.colorEditText[i2].requestFocus();
            } else if (i2 == 2 || i2 == 3) {
                this.colorEditText[i2].setVisibility(8);
            }
            i2++;
        }
        ImageView imageView = new ImageView(getContext());
        this.addButton = imageView;
        imageView.setBackground(Theme.createSelectorDrawable(Theme.getColor("dialogButtonSelector"), 1));
        this.addButton.setImageResource(R.drawable.themes_addcolor);
        this.addButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteBlackText"), PorterDuff.Mode.MULTIPLY));
        this.addButton.setScaleType(ImageView.ScaleType.CENTER);
        this.addButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ColorPicker$choa_54MwmISeNTPqhnhEOx1v-c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2$ColorPicker(view);
            }
        });
        this.addButton.setContentDescription(LocaleController.getString("Add", R.string.Add));
        addView(this.addButton, LayoutHelper.createFrame(30, 30.0f, 49, 36.0f, 1.0f, 0.0f, 0.0f));
        ImageView imageView2 = new ImageView(getContext()) { // from class: ir.eitaa.ui.Components.ColorPicker.6
            @Override // android.view.View
            public void setAlpha(float alpha) {
                super.setAlpha(alpha);
                ColorPicker.this.linearLayout.invalidate();
            }
        };
        this.clearButton = imageView2;
        imageView2.setBackground(Theme.createSelectorDrawable(Theme.getColor("dialogButtonSelector"), 1));
        this.clearButton.setImageResource(R.drawable.themes_deletecolor);
        this.clearButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteBlackText"), PorterDuff.Mode.MULTIPLY));
        this.clearButton.setAlpha(0.0f);
        this.clearButton.setScaleX(0.0f);
        this.clearButton.setScaleY(0.0f);
        this.clearButton.setScaleType(ImageView.ScaleType.CENTER);
        this.clearButton.setVisibility(4);
        this.clearButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ColorPicker$bspctLyIKDY_J_nlT0IYfJZL1Ug
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$3$ColorPicker(view);
            }
        });
        this.clearButton.setContentDescription(LocaleController.getString("ClearButton", R.string.ClearButton));
        addView(this.clearButton, LayoutHelper.createFrame(30, 30.0f, 51, 97.0f, 1.0f, 0.0f, 0.0f));
        TextView textView = new TextView(context);
        this.resetButton = textView;
        textView.setTextSize(1, 15.0f);
        this.resetButton.setTypeface(AndroidUtilities.getFontFamily(true));
        this.resetButton.setGravity(17);
        this.resetButton.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
        this.resetButton.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        addView(this.resetButton, LayoutHelper.createFrame(-2, 36.0f, 53, 0.0f, 3.0f, 14.0f, 0.0f));
        this.resetButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ColorPicker$29d-ENQoQ21EMCl7lhI65d08vpg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ColorPicker.lambda$new$4(view);
            }
        });
        if (hasMenu) {
            ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, null, 0, Theme.getColor("windowBackgroundWhiteBlackText"));
            this.menuItem = actionBarMenuItem;
            actionBarMenuItem.setLongClickEnabled(false);
            this.menuItem.setIcon(R.drawable.ic_ab_other);
            this.menuItem.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
            this.menuItem.addSubItem(1, R.drawable.msg_edit, LocaleController.getString("OpenInEditor", R.string.OpenInEditor));
            this.menuItem.addSubItem(2, R.drawable.msg_share, LocaleController.getString("ShareTheme", R.string.ShareTheme));
            this.menuItem.addSubItem(3, R.drawable.msg_delete, LocaleController.getString("DeleteTheme", R.string.DeleteTheme));
            this.menuItem.setMenuYOffset(-AndroidUtilities.dp(80.0f));
            this.menuItem.setSubMenuOpenSide(2);
            this.menuItem.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ColorPicker$7MHBYfqtxKgiZHKIjjDfm8oLUAA
                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
                public final void onItemClick(int i3) {
                    this.f$0.lambda$new$5$ColorPicker(i3);
                }
            });
            this.menuItem.setAdditionalYOffset(AndroidUtilities.dp(72.0f));
            this.menuItem.setTranslationX(AndroidUtilities.dp(6.0f));
            this.menuItem.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("dialogButtonSelector"), 1));
            addView(this.menuItem, LayoutHelper.createFrame(30, 30.0f, 53, 0.0f, 2.0f, 10.0f, 0.0f));
            this.menuItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ColorPicker$TRVGCZIWxzYWSSfR6pDkn1r3Jz4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$6$ColorPicker(view);
                }
            });
        }
        updateColorsPosition(null, 0, false, getMeasuredWidth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ColorPicker(View view) {
        RadioButton radioButton = (RadioButton) view;
        int i = 0;
        while (true) {
            RadioButton[] radioButtonArr = this.radioButton;
            if (i < radioButtonArr.length) {
                boolean z = radioButtonArr[i] == radioButton;
                radioButtonArr[i].setChecked(z, true);
                if (z) {
                    this.selectedColor = i;
                }
                i++;
            } else {
                int color = radioButton.getColor();
                setColorInner(color);
                this.colorEditText[1].setText(String.format("%02x%02x%02x", Byte.valueOf((byte) Color.red(color)), Byte.valueOf((byte) Color.green(color)), Byte.valueOf((byte) Color.blue(color))).toUpperCase());
                return;
            }
        }
    }

    static /* synthetic */ boolean lambda$new$1(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        AndroidUtilities.hideKeyboard(textView);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$ColorPicker(View view) {
        if (this.colorsAnimator != null) {
            return;
        }
        int i = this.colorsCount;
        if (i == 1) {
            if (this.radioButton[1].getColor() == 0) {
                RadioButton[] radioButtonArr = this.radioButton;
                radioButtonArr[1].setColor(generateGradientColors(radioButtonArr[0].getColor()));
            }
            if (this.myMessagesColor) {
                this.delegate.setColor(this.radioButton[0].getColor(), 0, true);
            }
            this.delegate.setColor(this.radioButton[1].getColor(), 1, true);
            this.colorsCount = 2;
        } else if (i == 2) {
            this.colorsCount = 3;
            if (this.radioButton[2].getColor() == 0) {
                float[] fArr = new float[3];
                Color.colorToHSV(this.radioButton[0].getColor(), fArr);
                if (fArr[0] > 180.0f) {
                    fArr[0] = fArr[0] - 60.0f;
                } else {
                    fArr[0] = fArr[0] + 60.0f;
                }
                this.radioButton[2].setColor(Color.HSVToColor(255, fArr));
            }
            this.delegate.setColor(this.radioButton[2].getColor(), 2, true);
        } else {
            if (i != 3) {
                return;
            }
            this.colorsCount = 4;
            if (this.radioButton[3].getColor() == 0) {
                RadioButton[] radioButtonArr2 = this.radioButton;
                radioButtonArr2[3].setColor(generateGradientColors(radioButtonArr2[2].getColor()));
            }
            this.delegate.setColor(this.radioButton[3].getColor(), 3, true);
        }
        ArrayList<Animator> arrayList = new ArrayList<>();
        if (this.colorsCount < this.maxColorsCount) {
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.ALPHA, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.SCALE_Y, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.TRANSLATION_X, (AndroidUtilities.dp(30.0f) * (this.colorsCount - 1)) + (AndroidUtilities.dp(13.0f) * (this.colorsCount - 1))));
        } else {
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.TRANSLATION_X, (AndroidUtilities.dp(30.0f) * (this.colorsCount - 1)) + (AndroidUtilities.dp(13.0f) * (this.colorsCount - 1))));
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.ALPHA, 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.SCALE_X, 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.SCALE_Y, 0.0f));
        }
        if (this.colorsCount > 1) {
            if (this.clearButton.getVisibility() != 0) {
                this.clearButton.setScaleX(0.0f);
                this.clearButton.setScaleY(0.0f);
            }
            this.clearButton.setVisibility(0);
            arrayList.add(ObjectAnimator.ofFloat(this.clearButton, (Property<ImageView, Float>) View.ALPHA, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.clearButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.clearButton, (Property<ImageView, Float>) View.SCALE_Y, 1.0f));
        }
        this.radioButton[this.colorsCount - 1].callOnClick();
        this.colorsAnimator = new AnimatorSet();
        updateColorsPosition(arrayList, 0, false, getMeasuredWidth());
        this.colorsAnimator.playTogether(arrayList);
        this.colorsAnimator.setDuration(180L);
        this.colorsAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
        this.colorsAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ColorPicker.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (ColorPicker.this.colorsCount == ColorPicker.this.maxColorsCount) {
                    ColorPicker.this.addButton.setVisibility(4);
                }
                ColorPicker.this.colorsAnimator = null;
            }
        });
        this.colorsAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$ColorPicker(View view) {
        RadioButton[] radioButtonArr;
        if (this.colorsAnimator != null) {
            return;
        }
        ArrayList<Animator> arrayList = new ArrayList<>();
        int i = this.colorsCount;
        if (i == 2) {
            this.colorsCount = 1;
            arrayList.add(ObjectAnimator.ofFloat(this.clearButton, (Property<ImageView, Float>) View.ALPHA, 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.clearButton, (Property<ImageView, Float>) View.SCALE_X, 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.clearButton, (Property<ImageView, Float>) View.SCALE_Y, 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.TRANSLATION_X, 0.0f));
        } else if (i == 3) {
            this.colorsCount = 2;
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.TRANSLATION_X, AndroidUtilities.dp(30.0f) + AndroidUtilities.dp(13.0f)));
        } else {
            if (i != 4) {
                return;
            }
            this.colorsCount = 3;
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.TRANSLATION_X, (AndroidUtilities.dp(30.0f) * 2) + (AndroidUtilities.dp(13.0f) * 2)));
        }
        if (this.colorsCount < this.maxColorsCount) {
            this.addButton.setVisibility(0);
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.ALPHA, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.SCALE_Y, 1.0f));
        } else {
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.ALPHA, 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.SCALE_X, 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.addButton, (Property<ImageView, Float>) View.SCALE_Y, 0.0f));
        }
        int i2 = this.selectedColor;
        if (i2 != 3) {
            RadioButton radioButton = this.radioButton[i2];
            int i3 = i2 + 1;
            while (true) {
                radioButtonArr = this.radioButton;
                if (i3 >= radioButtonArr.length) {
                    break;
                }
                radioButtonArr[i3 - 1] = radioButtonArr[i3];
                i3++;
            }
            radioButtonArr[3] = radioButton;
        }
        this.radioButton[0].callOnClick();
        int i4 = 0;
        while (true) {
            RadioButton[] radioButtonArr2 = this.radioButton;
            if (i4 < radioButtonArr2.length) {
                if (i4 < this.colorsCount) {
                    this.delegate.setColor(radioButtonArr2[i4].getColor(), i4, i4 == this.radioButton.length - 1);
                } else {
                    this.delegate.setColor(0, i4, i4 == radioButtonArr2.length - 1);
                }
                i4++;
            } else {
                this.colorsAnimator = new AnimatorSet();
                updateColorsPosition(arrayList, this.selectedColor, true, getMeasuredWidth());
                this.colorsAnimator.playTogether(arrayList);
                this.colorsAnimator.setDuration(180L);
                this.colorsAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                this.colorsAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ColorPicker.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (ColorPicker.this.colorsCount == 1) {
                            ColorPicker.this.clearButton.setVisibility(4);
                        }
                        for (int i5 = 0; i5 < ColorPicker.this.radioButton.length; i5++) {
                            if (ColorPicker.this.radioButton[i5].getTag(R.id.index_tag) == null) {
                                ColorPicker.this.radioButton[i5].setVisibility(4);
                            }
                        }
                        ColorPicker.this.colorsAnimator = null;
                    }
                });
                this.colorsAnimator.start();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$5$ColorPicker(int i) {
        if (i == 1 || i == 2) {
            this.delegate.openThemeCreate(i == 2);
        } else if (i == 3) {
            this.delegate.deleteTheme();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$6$ColorPicker(View view) {
        this.menuItem.toggleSubMenu();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        updateColorsPosition(null, 0, false, getMeasuredWidth());
    }

    private void updateColorsPosition(ArrayList<Animator> animators, int hidingIndex, boolean hiding, int width) {
        int i = this.colorsCount;
        float f = this.radioContainer.getLeft() + ((AndroidUtilities.dp(30.0f) * i) + ((i - 1) * AndroidUtilities.dp(13.0f))) > width - AndroidUtilities.dp(this.currentResetType == 1 ? 50.0f : 0.0f) ? r12 - r14 : 0.0f;
        if (animators != null) {
            animators.add(ObjectAnimator.ofFloat(this.radioContainer, (Property<FrameLayout, Float>) View.TRANSLATION_X, -f));
        } else {
            this.radioContainer.setTranslationX(-f);
        }
        int i2 = 0;
        int iDp = 0;
        while (true) {
            RadioButton[] radioButtonArr = this.radioButton;
            if (i2 >= radioButtonArr.length) {
                return;
            }
            boolean z = radioButtonArr[i2].getTag(R.id.index_tag) != null;
            if (i2 < this.colorsCount) {
                this.radioButton[i2].setVisibility(0);
                if (animators != null) {
                    if (!z) {
                        animators.add(ObjectAnimator.ofFloat(this.radioButton[i2], (Property<RadioButton, Float>) View.ALPHA, 1.0f));
                        animators.add(ObjectAnimator.ofFloat(this.radioButton[i2], (Property<RadioButton, Float>) View.SCALE_X, 1.0f));
                        animators.add(ObjectAnimator.ofFloat(this.radioButton[i2], (Property<RadioButton, Float>) View.SCALE_Y, 1.0f));
                    }
                    if (hiding || !(hiding || i2 == this.colorsCount - 1)) {
                        animators.add(ObjectAnimator.ofFloat(this.radioButton[i2], (Property<RadioButton, Float>) View.TRANSLATION_X, iDp));
                    } else {
                        this.radioButton[i2].setTranslationX(iDp);
                    }
                } else {
                    this.radioButton[i2].setVisibility(0);
                    if (this.colorsAnimator == null) {
                        this.radioButton[i2].setAlpha(1.0f);
                        this.radioButton[i2].setScaleX(1.0f);
                        this.radioButton[i2].setScaleY(1.0f);
                    }
                    this.radioButton[i2].setTranslationX(iDp);
                }
                this.radioButton[i2].setTag(R.id.index_tag, 1);
            } else {
                if (animators == null) {
                    this.radioButton[i2].setVisibility(4);
                    if (this.colorsAnimator == null) {
                        this.radioButton[i2].setAlpha(0.0f);
                        this.radioButton[i2].setScaleX(0.0f);
                        this.radioButton[i2].setScaleY(0.0f);
                    }
                } else if (z) {
                    animators.add(ObjectAnimator.ofFloat(this.radioButton[i2], (Property<RadioButton, Float>) View.ALPHA, 0.0f));
                    animators.add(ObjectAnimator.ofFloat(this.radioButton[i2], (Property<RadioButton, Float>) View.SCALE_X, 0.0f));
                    animators.add(ObjectAnimator.ofFloat(this.radioButton[i2], (Property<RadioButton, Float>) View.SCALE_Y, 0.0f));
                }
                if (!hiding) {
                    this.radioButton[i2].setTranslationX(iDp);
                }
                this.radioButton[i2].setTag(R.id.index_tag, null);
            }
            iDp += AndroidUtilities.dp(30.0f) + AndroidUtilities.dp(13.0f);
            i2++;
        }
    }

    public void hideKeyboard() {
        AndroidUtilities.hideKeyboard(this.colorEditText[1]);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a7  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r24) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ColorPicker.onDraw(android.graphics.Canvas):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFieldColor(int num, int defaultColor) {
        try {
            return Integer.parseInt(this.colorEditText[num].getText().toString(), 16) | (-16777216);
        } catch (Exception unused) {
            return defaultColor;
        }
    }

    private void drawPointerArrow(Canvas canvas, int x, int y, int color, boolean small) {
        int iDp = AndroidUtilities.dp(small ? 12.0f : 16.0f);
        this.circleDrawable.setBounds(x - iDp, y - iDp, x + iDp, iDp + y);
        this.circleDrawable.draw(canvas);
        this.circlePaint.setColor(-1);
        float f = x;
        float f2 = y;
        canvas.drawCircle(f, f2, AndroidUtilities.dp(small ? 11.0f : 15.0f), this.circlePaint);
        this.circlePaint.setColor(color);
        canvas.drawCircle(f, f2, AndroidUtilities.dp(small ? 9.0f : 13.0f), this.circlePaint);
    }

    @Override // android.view.View
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
        if (this.colorWheelWidth != width) {
            this.colorWheelWidth = width;
            this.colorWheelBitmap = createColorWheelBitmap(width, AndroidUtilities.dp(180.0f));
            this.colorGradient = null;
        }
    }

    private Bitmap createColorWheelBitmap(int width, int height) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        float f = width;
        float f2 = height;
        this.colorWheelPaint.setShader(new ComposeShader(new LinearGradient(0.0f, height / 3, 0.0f, f2, new int[]{-1, 0}, (float[]) null, Shader.TileMode.CLAMP), new LinearGradient(0.0f, 0.0f, f, 0.0f, new int[]{-65536, -256, -16711936, -16711681, -16776961, -65281, -65536}, (float[]) null, Shader.TileMode.CLAMP), PorterDuff.Mode.MULTIPLY));
        new Canvas(bitmapCreateBitmap).drawRect(0.0f, 0.0f, f, f2, this.colorWheelPaint);
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        if (r0 != 2) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ColorPicker.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorInner(int color) {
        Color.colorToHSV(color, this.colorHSV);
        int defaultColor = this.delegate.getDefaultColor(this.selectedColor);
        if (defaultColor == 0 || defaultColor != color) {
            updateHsvMinMaxBrightness();
        }
        this.colorGradient = null;
        invalidate();
    }

    public void setColor(int color, int num) {
        if (!this.ignoreTextChange) {
            this.ignoreTextChange = true;
            if (this.selectedColor == num) {
                String upperCase = String.format("%02x%02x%02x", Byte.valueOf((byte) Color.red(color)), Byte.valueOf((byte) Color.green(color)), Byte.valueOf((byte) Color.blue(color))).toUpperCase();
                this.colorEditText[1].setText(upperCase);
                this.colorEditText[1].setSelection(upperCase.length());
            }
            this.radioButton[num].setColor(color);
            this.ignoreTextChange = false;
        }
        setColorInner(color);
    }

    public void setHasChanges(final boolean value) {
        if (!value || this.resetButton.getTag() == null) {
            if ((value || this.resetButton.getTag() != null) && this.clearButton.getTag() == null) {
                this.resetButton.setTag(value ? 1 : null);
                AnimatorSet animatorSet = new AnimatorSet();
                ArrayList arrayList = new ArrayList();
                if (value) {
                    this.resetButton.setVisibility(0);
                }
                TextView textView = this.resetButton;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = value ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) property, fArr));
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ColorPicker.8
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (value) {
                            return;
                        }
                        ColorPicker.this.resetButton.setVisibility(8);
                    }
                });
                animatorSet.playTogether(arrayList);
                animatorSet.setDuration(180L);
                animatorSet.start();
            }
        }
    }

    public void setType(int resetType, boolean hasChanges, final int maxColorsCount, int newColorsCount, boolean myMessages, int angle, boolean animated) {
        if (resetType != this.currentResetType) {
            this.selectedColor = 0;
            int i = 0;
            while (i < 4) {
                this.radioButton[i].setChecked(i == this.selectedColor, true);
                i++;
            }
        }
        this.maxColorsCount = maxColorsCount;
        this.currentResetType = resetType;
        this.myMessagesColor = myMessages;
        this.colorsCount = newColorsCount;
        if (newColorsCount == 1) {
            this.addButton.setTranslationX(0.0f);
        } else if (newColorsCount == 2) {
            this.addButton.setTranslationX(AndroidUtilities.dp(30.0f) + AndroidUtilities.dp(13.0f));
        } else if (newColorsCount == 3) {
            this.addButton.setTranslationX((AndroidUtilities.dp(30.0f) * 2) + (AndroidUtilities.dp(13.0f) * 2));
        } else {
            this.addButton.setTranslationX((AndroidUtilities.dp(30.0f) * 3) + (AndroidUtilities.dp(13.0f) * 3));
        }
        ActionBarMenuItem actionBarMenuItem = this.menuItem;
        if (actionBarMenuItem != null) {
            if (resetType == 1) {
                actionBarMenuItem.setVisibility(0);
            } else {
                actionBarMenuItem.setVisibility(8);
                this.clearButton.setTranslationX(0.0f);
            }
        }
        if (maxColorsCount <= 1) {
            this.addButton.setVisibility(8);
            this.clearButton.setVisibility(8);
        } else {
            if (newColorsCount < maxColorsCount) {
                this.addButton.setVisibility(0);
                this.addButton.setScaleX(1.0f);
                this.addButton.setScaleY(1.0f);
                this.addButton.setAlpha(1.0f);
            } else {
                this.addButton.setVisibility(8);
            }
            if (newColorsCount > 1) {
                this.clearButton.setVisibility(0);
                this.clearButton.setScaleX(1.0f);
                this.clearButton.setScaleY(1.0f);
                this.clearButton.setAlpha(1.0f);
            } else {
                this.clearButton.setVisibility(8);
            }
        }
        this.linearLayout.invalidate();
        updateColorsPosition(null, 0, false, getMeasuredWidth());
        ArrayList arrayList = animated ? new ArrayList() : null;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(180L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ColorPicker.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (maxColorsCount <= 1) {
                    ColorPicker.this.clearButton.setVisibility(8);
                }
            }
        });
        animatorSet.start();
    }

    public int getColor() {
        float[] fArr = this.hsvTemp;
        float[] fArr2 = this.colorHSV;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = getBrightness();
        return (Color.HSVToColor(this.hsvTemp) & 16777215) | (-16777216);
    }

    private float getBrightness() {
        return Math.max(this.minHsvBrightness, Math.min(this.colorHSV[2], this.maxHsvBrightness));
    }

    private void updateHsvMinMaxBrightness() {
        ImageView imageView = this.clearButton;
        if (imageView == null) {
            return;
        }
        float f = imageView.getTag() != null ? 0.0f : this.minBrightness;
        float f2 = this.clearButton.getTag() != null ? 1.0f : this.maxBrightness;
        float[] fArr = this.colorHSV;
        float f3 = fArr[2];
        if (f == 0.0f && f2 == 1.0f) {
            this.minHsvBrightness = 0.0f;
            this.maxHsvBrightness = 1.0f;
            return;
        }
        fArr[2] = 1.0f;
        int iHSVToColor = Color.HSVToColor(fArr);
        this.colorHSV[2] = f3;
        float fComputePerceivedBrightness = AndroidUtilities.computePerceivedBrightness(iHSVToColor);
        float fMax = Math.max(0.0f, Math.min(f / fComputePerceivedBrightness, 1.0f));
        this.minHsvBrightness = fMax;
        this.maxHsvBrightness = Math.max(fMax, Math.min(f2 / fComputePerceivedBrightness, 1.0f));
    }

    public void setMinBrightness(float limit) {
        this.minBrightness = limit;
        updateHsvMinMaxBrightness();
    }

    public void setMaxBrightness(float limit) {
        this.maxBrightness = limit;
        updateHsvMinMaxBrightness();
    }

    public void provideThemeDescriptions(List<ThemeDescription> arrayList) {
        for (int i = 0; i < this.colorEditText.length; i++) {
            arrayList.add(new ThemeDescription(this.colorEditText[i], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(this.colorEditText[i], ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(this.colorEditText[i], ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
            arrayList.add(new ThemeDescription(this.colorEditText[i], ThemeDescription.FLAG_HINTTEXTCOLOR | ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "windowBackgroundWhiteBlueHeader"));
            arrayList.add(new ThemeDescription(this.colorEditText[i], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
            arrayList.add(new ThemeDescription(this.colorEditText[i], ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
        }
        arrayList.add(new ThemeDescription(this.clearButton, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.clearButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "dialogButtonSelector"));
        if (this.menuItem != null) {
            ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ColorPicker$fjP15KfO6duO5V5Yo6ywG2vSBEU
                @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
                public final void didSetColor() {
                    this.f$0.lambda$provideThemeDescriptions$7$ColorPicker();
                }

                @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
                public /* synthetic */ void onAnimationProgress(float f) {
                    ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
                }
            };
            arrayList.add(new ThemeDescription(this.menuItem, 0, null, null, null, themeDescriptionDelegate, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(this.menuItem, 0, null, null, null, themeDescriptionDelegate, "dialogButtonSelector"));
            arrayList.add(new ThemeDescription(this.menuItem, 0, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuItem"));
            arrayList.add(new ThemeDescription(this.menuItem, 0, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuItemIcon"));
            arrayList.add(new ThemeDescription(this.menuItem, 0, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuBackground"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$provideThemeDescriptions$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$provideThemeDescriptions$7$ColorPicker() {
        this.menuItem.setIconColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        Theme.setDrawableColor(this.menuItem.getBackground(), Theme.getColor("dialogButtonSelector"));
        this.menuItem.setPopupItemsColor(Theme.getColor("actionBarDefaultSubmenuItem"), false);
        this.menuItem.setPopupItemsColor(Theme.getColor("actionBarDefaultSubmenuItemIcon"), true);
        this.menuItem.redrawPopup(Theme.getColor("actionBarDefaultSubmenuBackground"));
    }

    public static int generateGradientColors(int color) {
        float[] fArr = new float[3];
        Color.colorToHSV(color, fArr);
        if (fArr[1] > 0.5f) {
            fArr[1] = fArr[1] - 0.15f;
        } else {
            fArr[1] = fArr[1] + 0.15f;
        }
        if (fArr[0] > 180.0f) {
            fArr[0] = fArr[0] - 20.0f;
        } else {
            fArr[0] = fArr[0] + 20.0f;
        }
        return Color.HSVToColor(255, fArr);
    }
}
