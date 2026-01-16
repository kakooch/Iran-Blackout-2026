package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.TextColorThemeCell;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ThemeEditorView;
import ir.eitaa.ui.Components.WallpaperUpdater;
import ir.eitaa.ui.LaunchActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ThemeEditorView {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile ThemeEditorView Instance;
    private ArrayList<ThemeDescription> currentThemeDesription;
    private int currentThemeDesriptionPosition;
    private DecelerateInterpolator decelerateInterpolator;
    private EditorAlert editorAlert;
    private boolean hidden;
    private Activity parentActivity;
    private SharedPreferences preferences;
    private Theme.ThemeInfo themeInfo;
    private WallpaperUpdater wallpaperUpdater;
    private WindowManager.LayoutParams windowLayoutParams;
    private WindowManager windowManager;
    private FrameLayout windowView;
    private final int editorWidth = AndroidUtilities.dp(54.0f);
    private final int editorHeight = AndroidUtilities.dp(54.0f);

    public static ThemeEditorView getInstance() {
        return Instance;
    }

    public void destroy() {
        FrameLayout frameLayout;
        this.wallpaperUpdater.cleanup();
        if (this.parentActivity == null || (frameLayout = this.windowView) == null) {
            return;
        }
        try {
            this.windowManager.removeViewImmediate(frameLayout);
            this.windowView = null;
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            EditorAlert editorAlert = this.editorAlert;
            if (editorAlert != null) {
                editorAlert.dismiss();
                this.editorAlert = null;
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        this.parentActivity = null;
        Instance = null;
    }

    public class EditorAlert extends BottomSheet {
        private boolean animationInProgress;
        private FrameLayout bottomLayout;
        private FrameLayout bottomSaveLayout;
        private AnimatorSet colorChangeAnimation;
        private ColorPicker colorPicker;
        private FrameLayout frameLayout;
        private boolean ignoreTextChange;
        private LinearLayoutManager layoutManager;
        private ListAdapter listAdapter;
        private RecyclerListView listView;
        private int previousScrollPosition;
        private int scrollOffsetY;
        private SearchAdapter searchAdapter;
        private EmptyTextProgressView searchEmptyView;
        private SearchField searchField;
        private View[] shadow;
        private AnimatorSet[] shadowAnimation;
        private Drawable shadowDrawable;
        private boolean startedColorChange;
        private int topBeforeSwitch;

        @Override // ir.eitaa.ui.ActionBar.BottomSheet
        protected boolean canDismissWithSwipe() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        class SearchField extends FrameLayout {
            private ImageView clearSearchImageView;
            private EditTextBoldCursor searchEditText;

            public SearchField(Context context) {
                super(context);
                View view = new View(context);
                view.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), -854795));
                addView(view, LayoutHelper.createFrame(-1, 36.0f, 51, 14.0f, 11.0f, 14.0f, 0.0f));
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                imageView.setImageResource(R.drawable.smiles_inputsearch);
                imageView.setColorFilter(new PorterDuffColorFilter(-6182737, PorterDuff.Mode.MULTIPLY));
                addView(imageView, LayoutHelper.createFrame(36, 36.0f, 51, 16.0f, 11.0f, 0.0f, 0.0f));
                ImageView imageView2 = new ImageView(context);
                this.clearSearchImageView = imageView2;
                imageView2.setScaleType(ImageView.ScaleType.CENTER);
                ImageView imageView3 = this.clearSearchImageView;
                CloseProgressDrawable2 closeProgressDrawable2 = new CloseProgressDrawable2();
                imageView3.setImageDrawable(closeProgressDrawable2);
                closeProgressDrawable2.setSide(AndroidUtilities.dp(7.0f));
                this.clearSearchImageView.setScaleX(0.1f);
                this.clearSearchImageView.setScaleY(0.1f);
                this.clearSearchImageView.setAlpha(0.0f);
                this.clearSearchImageView.setColorFilter(new PorterDuffColorFilter(-6182737, PorterDuff.Mode.MULTIPLY));
                addView(this.clearSearchImageView, LayoutHelper.createFrame(36, 36.0f, 53, 14.0f, 11.0f, 14.0f, 0.0f));
                this.clearSearchImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ThemeEditorView$EditorAlert$SearchField$167T-AZrImSenUNQe0LQghGjV-I
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f$0.lambda$new$0$ThemeEditorView$EditorAlert$SearchField(view2);
                    }
                });
                EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context) { // from class: ir.eitaa.ui.Components.ThemeEditorView.EditorAlert.SearchField.1
                    @Override // android.view.View
                    public boolean dispatchTouchEvent(MotionEvent event) {
                        MotionEvent motionEventObtain = MotionEvent.obtain(event);
                        motionEventObtain.setLocation(motionEventObtain.getRawX(), motionEventObtain.getRawY() - ((BottomSheet) EditorAlert.this).containerView.getTranslationY());
                        EditorAlert.this.listView.dispatchTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                        return super.dispatchTouchEvent(event);
                    }
                };
                this.searchEditText = editTextBoldCursor;
                editTextBoldCursor.setTextSize(1, 16.0f);
                this.searchEditText.setHintTextColor(-6774617);
                this.searchEditText.setTextColor(-14540254);
                this.searchEditText.setBackgroundDrawable(null);
                this.searchEditText.setPadding(0, 0, 0, 0);
                this.searchEditText.setMaxLines(1);
                this.searchEditText.setLines(1);
                this.searchEditText.setSingleLine(true);
                this.searchEditText.setImeOptions(268435459);
                this.searchEditText.setHint(LocaleController.getString("Search", R.string.Search));
                this.searchEditText.setCursorColor(-11491093);
                this.searchEditText.setCursorSize(AndroidUtilities.dp(20.0f));
                this.searchEditText.setCursorWidth(1.5f);
                addView(this.searchEditText, LayoutHelper.createFrame(-1, 40.0f, 51, 54.0f, 9.0f, 46.0f, 0.0f));
                this.searchEditText.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.Components.ThemeEditorView.EditorAlert.SearchField.2
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) throws InterruptedException {
                        boolean z = SearchField.this.searchEditText.length() > 0;
                        if (z != (SearchField.this.clearSearchImageView.getAlpha() != 0.0f)) {
                            SearchField.this.clearSearchImageView.animate().alpha(z ? 1.0f : 0.0f).setDuration(150L).scaleX(z ? 1.0f : 0.1f).scaleY(z ? 1.0f : 0.1f).start();
                        }
                        String string = SearchField.this.searchEditText.getText().toString();
                        if (string.length() != 0) {
                            if (EditorAlert.this.searchEmptyView != null) {
                                EditorAlert.this.searchEmptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
                            }
                        } else if (EditorAlert.this.listView.getAdapter() != EditorAlert.this.listAdapter) {
                            int currentTop = EditorAlert.this.getCurrentTop();
                            EditorAlert.this.searchEmptyView.setText(LocaleController.getString("NoChats", R.string.NoChats));
                            EditorAlert.this.searchEmptyView.showTextView();
                            EditorAlert.this.listView.setAdapter(EditorAlert.this.listAdapter);
                            EditorAlert.this.listAdapter.notifyDataSetChanged();
                            if (currentTop > 0) {
                                EditorAlert.this.layoutManager.scrollToPositionWithOffset(0, -currentTop);
                            }
                        }
                        if (EditorAlert.this.searchAdapter != null) {
                            EditorAlert.this.searchAdapter.searchDialogs(string);
                        }
                    }
                });
                this.searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ThemeEditorView$EditorAlert$SearchField$uLn2EesR6KNFsWhmN_RMiTizVpU
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        return this.f$0.lambda$new$1$ThemeEditorView$EditorAlert$SearchField(textView, i, keyEvent);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$new$0$ThemeEditorView$EditorAlert$SearchField(View view) {
                this.searchEditText.setText("");
                AndroidUtilities.showKeyboard(this.searchEditText);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ boolean lambda$new$1$ThemeEditorView$EditorAlert$SearchField(TextView textView, int i, KeyEvent keyEvent) {
                if (keyEvent == null) {
                    return false;
                }
                if ((keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 84) && (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
                    return false;
                }
                AndroidUtilities.hideKeyboard(this.searchEditText);
                return false;
            }

            public void showKeyboard() {
                this.searchEditText.requestFocus();
                AndroidUtilities.showKeyboard(this.searchEditText);
            }

            @Override // android.view.ViewGroup, android.view.ViewParent
            public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                super.requestDisallowInterceptTouchEvent(disallowIntercept);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        class ColorPicker extends FrameLayout {
            private float alpha;
            private LinearGradient alphaGradient;
            private boolean alphaPressed;
            private Drawable circleDrawable;
            private Paint circlePaint;
            private boolean circlePressed;
            private EditTextBoldCursor[] colorEditText;
            private LinearGradient colorGradient;
            private float[] colorHSV;
            private boolean colorPressed;
            private Bitmap colorWheelBitmap;
            private Paint colorWheelPaint;
            private int colorWheelRadius;
            private DecelerateInterpolator decelerateInterpolator;
            private float[] hsvTemp;
            private LinearLayout linearLayout;
            private final int paramValueSliderWidth;
            private Paint valueSliderPaint;

            public ColorPicker(Context context) {
                super(context);
                this.paramValueSliderWidth = AndroidUtilities.dp(20.0f);
                this.colorEditText = new EditTextBoldCursor[4];
                this.colorHSV = new float[]{0.0f, 0.0f, 1.0f};
                this.alpha = 1.0f;
                this.hsvTemp = new float[3];
                this.decelerateInterpolator = new DecelerateInterpolator();
                setWillNotDraw(false);
                this.circlePaint = new Paint(1);
                this.circleDrawable = context.getResources().getDrawable(R.drawable.knob_shadow).mutate();
                Paint paint = new Paint();
                this.colorWheelPaint = paint;
                paint.setAntiAlias(true);
                this.colorWheelPaint.setDither(true);
                Paint paint2 = new Paint();
                this.valueSliderPaint = paint2;
                paint2.setAntiAlias(true);
                this.valueSliderPaint.setDither(true);
                LinearLayout linearLayout = new LinearLayout(context);
                this.linearLayout = linearLayout;
                linearLayout.setOrientation(0);
                addView(this.linearLayout, LayoutHelper.createFrame(-2, -2, 49));
                final int i = 0;
                while (i < 4) {
                    this.colorEditText[i] = new EditTextBoldCursor(context);
                    this.colorEditText[i].setInputType(2);
                    this.colorEditText[i].setTextColor(-14606047);
                    this.colorEditText[i].setCursorColor(-14606047);
                    this.colorEditText[i].setCursorSize(AndroidUtilities.dp(20.0f));
                    this.colorEditText[i].setCursorWidth(1.5f);
                    this.colorEditText[i].setTextSize(1, 18.0f);
                    this.colorEditText[i].setBackgroundDrawable(Theme.createEditTextDrawable(context, true));
                    this.colorEditText[i].setMaxLines(1);
                    this.colorEditText[i].setTag(Integer.valueOf(i));
                    this.colorEditText[i].setGravity(17);
                    if (i == 0) {
                        this.colorEditText[i].setHint("red");
                    } else if (i == 1) {
                        this.colorEditText[i].setHint("green");
                    } else if (i == 2) {
                        this.colorEditText[i].setHint("blue");
                    } else if (i == 3) {
                        this.colorEditText[i].setHint("alpha");
                    }
                    this.colorEditText[i].setImeOptions((i == 3 ? 6 : 5) | 268435456);
                    this.colorEditText[i].setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                    this.linearLayout.addView(this.colorEditText[i], LayoutHelper.createLinear(55, 36, 0.0f, 0.0f, i != 3 ? 16.0f : 0.0f, 0.0f));
                    this.colorEditText[i].addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.Components.ThemeEditorView.EditorAlert.ColorPicker.1
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                        }

                        /* JADX WARN: Removed duplicated region for block: B:24:0x00df A[LOOP:0: B:22:0x00cf->B:24:0x00df, LOOP_END] */
                        @Override // android.text.TextWatcher
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public void afterTextChanged(android.text.Editable r7) throws java.lang.NoSuchFieldException {
                            /*
                                Method dump skipped, instructions count: 259
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ThemeEditorView.EditorAlert.ColorPicker.AnonymousClass1.afterTextChanged(android.text.Editable):void");
                        }
                    });
                    this.colorEditText[i].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ThemeEditorView$EditorAlert$ColorPicker$tUfbXszSnZ9RdtnR2Fgj-Bohrdc
                        @Override // android.widget.TextView.OnEditorActionListener
                        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                            return ThemeEditorView.EditorAlert.ColorPicker.lambda$new$0(textView, i2, keyEvent);
                        }
                    });
                    i++;
                }
            }

            static /* synthetic */ boolean lambda$new$0(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6) {
                    return false;
                }
                AndroidUtilities.hideKeyboard(textView);
                return true;
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int iMin = Math.min(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
                measureChild(this.linearLayout, widthMeasureSpec, heightMeasureSpec);
                setMeasuredDimension(iMin, iMin);
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                float f;
                int width = (getWidth() / 2) - (this.paramValueSliderWidth * 2);
                int height = (getHeight() / 2) - AndroidUtilities.dp(8.0f);
                Bitmap bitmap = this.colorWheelBitmap;
                int i = this.colorWheelRadius;
                canvas.drawBitmap(bitmap, width - i, height - i, (Paint) null);
                double radians = (float) Math.toRadians(this.colorHSV[0]);
                double d = -Math.cos(radians);
                double d2 = this.colorHSV[1];
                Double.isNaN(d2);
                double d3 = d * d2;
                double d4 = this.colorWheelRadius;
                Double.isNaN(d4);
                int i2 = ((int) (d3 * d4)) + width;
                double d5 = -Math.sin(radians);
                float[] fArr = this.colorHSV;
                double d6 = fArr[1];
                Double.isNaN(d6);
                double d7 = d5 * d6;
                double d8 = this.colorWheelRadius;
                Double.isNaN(d8);
                float[] fArr2 = this.hsvTemp;
                fArr2[0] = fArr[0];
                fArr2[1] = fArr[1];
                fArr2[2] = 1.0f;
                drawPointerArrow(canvas, i2, ((int) (d7 * d8)) + height, Color.HSVToColor(fArr2));
                int i3 = this.colorWheelRadius;
                int i4 = width + i3 + this.paramValueSliderWidth;
                int i5 = height - i3;
                int iDp = AndroidUtilities.dp(9.0f);
                int i6 = this.colorWheelRadius * 2;
                if (this.colorGradient == null) {
                    this.colorGradient = new LinearGradient(i4, i5, i4 + iDp, i5 + i6, new int[]{-16777216, Color.HSVToColor(this.hsvTemp)}, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.valueSliderPaint.setShader(this.colorGradient);
                float f2 = i5;
                float f3 = i5 + i6;
                canvas.drawRect(i4, f2, i4 + iDp, f3, this.valueSliderPaint);
                int i7 = iDp / 2;
                float[] fArr3 = this.colorHSV;
                float f4 = i6;
                drawPointerArrow(canvas, i4 + i7, (int) ((fArr3[2] * f4) + f2), Color.HSVToColor(fArr3));
                int i8 = i4 + (this.paramValueSliderWidth * 2);
                if (this.alphaGradient == null) {
                    int iHSVToColor = Color.HSVToColor(this.hsvTemp);
                    f = f3;
                    this.alphaGradient = new LinearGradient(i8, f2, i8 + iDp, f, new int[]{iHSVToColor, iHSVToColor & 16777215}, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    f = f3;
                }
                this.valueSliderPaint.setShader(this.alphaGradient);
                canvas.drawRect(i8, f2, iDp + i8, f, this.valueSliderPaint);
                drawPointerArrow(canvas, i8 + i7, (int) (f2 + ((1.0f - this.alpha) * f4)), (Color.HSVToColor(this.colorHSV) & 16777215) | (((int) (this.alpha * 255.0f)) << 24));
            }

            private void drawPointerArrow(Canvas canvas, int x, int y, int color) {
                int iDp = AndroidUtilities.dp(13.0f);
                this.circleDrawable.setBounds(x - iDp, y - iDp, x + iDp, iDp + y);
                this.circleDrawable.draw(canvas);
                this.circlePaint.setColor(-1);
                float f = x;
                float f2 = y;
                canvas.drawCircle(f, f2, AndroidUtilities.dp(11.0f), this.circlePaint);
                this.circlePaint.setColor(color);
                canvas.drawCircle(f, f2, AndroidUtilities.dp(9.0f), this.circlePaint);
            }

            @Override // android.view.View
            protected void onSizeChanged(int width, int height, int oldw, int oldh) {
                int iMax = Math.max(1, ((width / 2) - (this.paramValueSliderWidth * 2)) - AndroidUtilities.dp(20.0f));
                this.colorWheelRadius = iMax;
                this.colorWheelBitmap = createColorWheelBitmap(iMax * 2, iMax * 2);
                this.colorGradient = null;
                this.alphaGradient = null;
            }

            private Bitmap createColorWheelBitmap(int width, int height) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                int[] iArr = new int[13];
                float[] fArr = {0.0f, 1.0f, 1.0f};
                for (int i = 0; i < 13; i++) {
                    fArr[0] = ((i * 30) + 180) % 360;
                    iArr[i] = Color.HSVToColor(fArr);
                }
                iArr[12] = iArr[0];
                float f = width / 2;
                float f2 = height / 2;
                this.colorWheelPaint.setShader(new ComposeShader(new SweepGradient(f, f2, iArr, (float[]) null), new RadialGradient(f, f2, this.colorWheelRadius, -1, 16777215, Shader.TileMode.CLAMP), PorterDuff.Mode.SRC_OVER));
                new Canvas(bitmapCreateBitmap).drawCircle(f, f2, this.colorWheelRadius, this.colorWheelPaint);
                return bitmapCreateBitmap;
            }

            private void startColorChange(boolean start) {
                if (EditorAlert.this.startedColorChange == start) {
                    return;
                }
                if (EditorAlert.this.colorChangeAnimation != null) {
                    EditorAlert.this.colorChangeAnimation.cancel();
                }
                EditorAlert.this.startedColorChange = start;
                EditorAlert.this.colorChangeAnimation = new AnimatorSet();
                AnimatorSet animatorSet = EditorAlert.this.colorChangeAnimation;
                Animator[] animatorArr = new Animator[2];
                ColorDrawable colorDrawable = ((BottomSheet) EditorAlert.this).backDrawable;
                Property<ColorDrawable, Integer> property = AnimationProperties.COLOR_DRAWABLE_ALPHA;
                int[] iArr = new int[1];
                iArr[0] = start ? 0 : 51;
                animatorArr[0] = ObjectAnimator.ofInt(colorDrawable, property, iArr);
                ViewGroup viewGroup = ((BottomSheet) EditorAlert.this).containerView;
                Property property2 = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = start ? 0.2f : 1.0f;
                animatorArr[1] = ObjectAnimator.ofFloat(viewGroup, (Property<ViewGroup, Float>) property2, fArr);
                animatorSet.playTogether(animatorArr);
                EditorAlert.this.colorChangeAnimation.setDuration(150L);
                EditorAlert.this.colorChangeAnimation.setInterpolator(this.decelerateInterpolator);
                EditorAlert.this.colorChangeAnimation.start();
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
            
                if (r1 != 2) goto L8;
             */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00bf  */
            /* JADX WARN: Removed duplicated region for block: B:57:0x0104  */
            @Override // android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onTouchEvent(android.view.MotionEvent r17) throws java.lang.NoSuchFieldException {
                /*
                    Method dump skipped, instructions count: 564
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ThemeEditorView.EditorAlert.ColorPicker.onTouchEvent(android.view.MotionEvent):boolean");
            }

            public void setColor(int color) {
                int iRed = Color.red(color);
                int iGreen = Color.green(color);
                int iBlue = Color.blue(color);
                int iAlpha = Color.alpha(color);
                if (!EditorAlert.this.ignoreTextChange) {
                    EditorAlert.this.ignoreTextChange = true;
                    this.colorEditText[0].setText("" + iRed);
                    this.colorEditText[1].setText("" + iGreen);
                    this.colorEditText[2].setText("" + iBlue);
                    this.colorEditText[3].setText("" + iAlpha);
                    for (int i = 0; i < 4; i++) {
                        EditTextBoldCursor[] editTextBoldCursorArr = this.colorEditText;
                        editTextBoldCursorArr[i].setSelection(editTextBoldCursorArr[i].length());
                    }
                    EditorAlert.this.ignoreTextChange = false;
                }
                this.alphaGradient = null;
                this.colorGradient = null;
                this.alpha = iAlpha / 255.0f;
                Color.colorToHSV(color, this.colorHSV);
                invalidate();
            }

            public int getColor() {
                return (Color.HSVToColor(this.colorHSV) & 16777215) | (((int) (this.alpha * 255.0f)) << 24);
            }
        }

        public EditorAlert(final Context context, ArrayList<ThemeDescription> items) {
            super(context, true);
            this.shadow = new View[2];
            this.shadowAnimation = new AnimatorSet[2];
            this.shadowDrawable = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
            FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.ThemeEditorView.EditorAlert.1
                private boolean ignoreLayout = false;
                private RectF rect1 = new RectF();

                @Override // android.view.ViewGroup
                public boolean onInterceptTouchEvent(MotionEvent ev) {
                    if (ev.getAction() == 0 && EditorAlert.this.scrollOffsetY != 0 && ev.getY() < EditorAlert.this.scrollOffsetY) {
                        EditorAlert.this.dismiss();
                        return true;
                    }
                    return super.onInterceptTouchEvent(ev);
                }

                @Override // android.view.View
                public boolean onTouchEvent(MotionEvent e) {
                    return !EditorAlert.this.isDismissed() && super.onTouchEvent(e);
                }

                @Override // android.widget.FrameLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    int size = View.MeasureSpec.getSize(widthMeasureSpec);
                    int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 21 && !((BottomSheet) EditorAlert.this).isFullscreen) {
                        this.ignoreLayout = true;
                        setPadding(((BottomSheet) EditorAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) EditorAlert.this).backgroundPaddingLeft, 0);
                        this.ignoreLayout = false;
                    }
                    int iDp = ((size2 - (i >= 21 ? AndroidUtilities.statusBarHeight : 0)) + AndroidUtilities.dp(8.0f)) - Math.min(size, size2 - (i >= 21 ? AndroidUtilities.statusBarHeight : 0));
                    if (EditorAlert.this.listView.getPaddingTop() != iDp) {
                        this.ignoreLayout = true;
                        EditorAlert.this.listView.getPaddingTop();
                        EditorAlert.this.listView.setPadding(0, iDp, 0, AndroidUtilities.dp(48.0f));
                        if (EditorAlert.this.colorPicker.getVisibility() == 0) {
                            EditorAlert editorAlert = EditorAlert.this;
                            editorAlert.setScrollOffsetY(editorAlert.listView.getPaddingTop());
                            EditorAlert.this.previousScrollPosition = 0;
                        }
                        this.ignoreLayout = false;
                    }
                    super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
                }

                @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
                protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                    super.onLayout(changed, left, top, right, bottom);
                    EditorAlert.this.updateLayout();
                }

                @Override // android.view.View, android.view.ViewParent
                public void requestLayout() {
                    if (this.ignoreLayout) {
                        return;
                    }
                    super.requestLayout();
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x00b4  */
                /* JADX WARN: Removed duplicated region for block: B:20:0x0154  */
                /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
                @Override // android.view.View
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                protected void onDraw(android.graphics.Canvas r14) {
                    /*
                        Method dump skipped, instructions count: 411
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ThemeEditorView.EditorAlert.AnonymousClass1.onDraw(android.graphics.Canvas):void");
                }
            };
            this.containerView = frameLayout;
            frameLayout.setWillNotDraw(false);
            ViewGroup viewGroup = this.containerView;
            int i = this.backgroundPaddingLeft;
            viewGroup.setPadding(i, 0, i, 0);
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.frameLayout = frameLayout2;
            frameLayout2.setBackgroundColor(-1);
            SearchField searchField = new SearchField(context);
            this.searchField = searchField;
            this.frameLayout.addView(searchField, LayoutHelper.createFrame(-1, -1, 51));
            RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.ThemeEditorView.EditorAlert.2
                @Override // ir.eitaa.ui.Components.RecyclerListView
                protected boolean allowSelectChildAtPosition(float x, float y) {
                    return y >= ((float) ((EditorAlert.this.scrollOffsetY + AndroidUtilities.dp(48.0f)) + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)));
                }
            };
            this.listView = recyclerListView;
            recyclerListView.setSelectorDrawableColor(251658240);
            this.listView.setPadding(0, 0, 0, AndroidUtilities.dp(48.0f));
            this.listView.setClipToPadding(false);
            RecyclerListView recyclerListView2 = this.listView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.layoutManager = linearLayoutManager;
            recyclerListView2.setLayoutManager(linearLayoutManager);
            this.listView.setHorizontalScrollBarEnabled(false);
            this.listView.setVerticalScrollBarEnabled(false);
            this.containerView.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
            RecyclerListView recyclerListView3 = this.listView;
            ListAdapter listAdapter = new ListAdapter(context, items);
            this.listAdapter = listAdapter;
            recyclerListView3.setAdapter(listAdapter);
            this.searchAdapter = new SearchAdapter(context);
            this.listView.setGlowColor(-657673);
            this.listView.setItemAnimator(null);
            this.listView.setLayoutAnimation(null);
            this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ThemeEditorView$EditorAlert$b6seA6AZHSAcSYlNsmIlxEkhxkU
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
                public final void onItemClick(View view, int i2) throws Throwable {
                    this.f$0.lambda$new$0$ThemeEditorView$EditorAlert(view, i2);
                }
            });
            this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.ThemeEditorView.EditorAlert.3
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    EditorAlert.this.updateLayout();
                }
            });
            EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
            this.searchEmptyView = emptyTextProgressView;
            emptyTextProgressView.setShowAtCenter(true);
            this.searchEmptyView.showTextView();
            this.searchEmptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
            this.listView.setEmptyView(this.searchEmptyView);
            this.containerView.addView(this.searchEmptyView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 52.0f, 0.0f, 0.0f));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 51);
            layoutParams.topMargin = AndroidUtilities.dp(58.0f);
            this.shadow[0] = new View(context);
            this.shadow[0].setBackgroundColor(301989888);
            this.shadow[0].setAlpha(0.0f);
            this.shadow[0].setTag(1);
            this.containerView.addView(this.shadow[0], layoutParams);
            this.containerView.addView(this.frameLayout, LayoutHelper.createFrame(-1, 58, 51));
            ColorPicker colorPicker = new ColorPicker(context);
            this.colorPicker = colorPicker;
            colorPicker.setVisibility(8);
            this.containerView.addView(this.colorPicker, LayoutHelper.createFrame(-1, -1, 1));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 83);
            layoutParams2.bottomMargin = AndroidUtilities.dp(48.0f);
            this.shadow[1] = new View(context);
            this.shadow[1].setBackgroundColor(301989888);
            this.containerView.addView(this.shadow[1], layoutParams2);
            FrameLayout frameLayout3 = new FrameLayout(context);
            this.bottomSaveLayout = frameLayout3;
            frameLayout3.setBackgroundColor(-1);
            this.containerView.addView(this.bottomSaveLayout, LayoutHelper.createFrame(-1, 48, 83));
            TextView textView = new TextView(context);
            textView.setTextSize(1, 14.0f);
            textView.setTextColor(-15095832);
            textView.setGravity(17);
            textView.setBackgroundDrawable(Theme.createSelectorDrawable(788529152, 0));
            textView.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
            textView.setText(LocaleController.getString("CloseEditor", R.string.CloseEditor).toUpperCase());
            textView.setTypeface(AndroidUtilities.getFontFamily(true));
            this.bottomSaveLayout.addView(textView, LayoutHelper.createFrame(-2, -1, 51));
            textView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ThemeEditorView$EditorAlert$6JJoBEAHVv6zKRzZ2W4mSBdpbHk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$1$ThemeEditorView$EditorAlert(view);
                }
            });
            TextView textView2 = new TextView(context);
            textView2.setTextSize(1, 14.0f);
            textView2.setTextColor(-15095832);
            textView2.setGravity(17);
            textView2.setBackgroundDrawable(Theme.createSelectorDrawable(788529152, 0));
            textView2.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
            textView2.setText(LocaleController.getString("SaveTheme", R.string.SaveTheme).toUpperCase());
            textView2.setTypeface(AndroidUtilities.getFontFamily(true));
            this.bottomSaveLayout.addView(textView2, LayoutHelper.createFrame(-2, -1, 53));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ThemeEditorView$EditorAlert$2t6zXqFJApv2__8Yhfpsikow5Vg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Throwable {
                    this.f$0.lambda$new$2$ThemeEditorView$EditorAlert(view);
                }
            });
            FrameLayout frameLayout4 = new FrameLayout(context);
            this.bottomLayout = frameLayout4;
            frameLayout4.setVisibility(8);
            this.bottomLayout.setBackgroundColor(-1);
            this.containerView.addView(this.bottomLayout, LayoutHelper.createFrame(-1, 48, 83));
            TextView textView3 = new TextView(context);
            textView3.setTextSize(1, 14.0f);
            textView3.setTextColor(-15095832);
            textView3.setGravity(17);
            textView3.setBackgroundDrawable(Theme.createSelectorDrawable(788529152, 0));
            textView3.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
            textView3.setText(LocaleController.getString("Cancel", R.string.Cancel).toUpperCase());
            textView3.setTypeface(AndroidUtilities.getFontFamily(true));
            this.bottomLayout.addView(textView3, LayoutHelper.createFrame(-2, -1, 51));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ThemeEditorView$EditorAlert$IdYfU2BcxSA19K9BA13D-Q-sMBY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Throwable {
                    this.f$0.lambda$new$3$ThemeEditorView$EditorAlert(view);
                }
            });
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            this.bottomLayout.addView(linearLayout, LayoutHelper.createFrame(-2, -1, 53));
            TextView textView4 = new TextView(context);
            textView4.setTextSize(1, 14.0f);
            textView4.setTextColor(-15095832);
            textView4.setGravity(17);
            textView4.setBackgroundDrawable(Theme.createSelectorDrawable(788529152, 0));
            textView4.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
            textView4.setText(LocaleController.getString("Default", R.string.Default).toUpperCase());
            textView4.setTypeface(AndroidUtilities.getFontFamily(true));
            linearLayout.addView(textView4, LayoutHelper.createFrame(-2, -1, 51));
            textView4.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ThemeEditorView$EditorAlert$1mzXKlAZ7cvGkioQOAcJFQ_pyIc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Throwable {
                    this.f$0.lambda$new$4$ThemeEditorView$EditorAlert(view);
                }
            });
            TextView textView5 = new TextView(context);
            textView5.setTextSize(1, 14.0f);
            textView5.setTextColor(-15095832);
            textView5.setGravity(17);
            textView5.setBackgroundDrawable(Theme.createSelectorDrawable(788529152, 0));
            textView5.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
            textView5.setText(LocaleController.getString("Save", R.string.Save).toUpperCase());
            textView5.setTypeface(AndroidUtilities.getFontFamily(true));
            linearLayout.addView(textView5, LayoutHelper.createFrame(-2, -1, 51));
            textView5.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ThemeEditorView$EditorAlert$VvSqSvMuONXwlLNIGuQzj3Vqo_8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Throwable {
                    this.f$0.lambda$new$5$ThemeEditorView$EditorAlert(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ThemeEditorView$EditorAlert(View view, int i) throws Throwable {
            if (i == 0) {
                return;
            }
            RecyclerView.Adapter adapter = this.listView.getAdapter();
            ListAdapter listAdapter = this.listAdapter;
            if (adapter == listAdapter) {
                ThemeEditorView.this.currentThemeDesription = listAdapter.getItem(i - 1);
            } else {
                ThemeEditorView.this.currentThemeDesription = this.searchAdapter.getItem(i - 1);
            }
            ThemeEditorView.this.currentThemeDesriptionPosition = i;
            for (int i2 = 0; i2 < ThemeEditorView.this.currentThemeDesription.size(); i2++) {
                ThemeDescription themeDescription = (ThemeDescription) ThemeEditorView.this.currentThemeDesription.get(i2);
                if (themeDescription.getCurrentKey().equals("chat_wallpaper")) {
                    ThemeEditorView.this.wallpaperUpdater.showAlert(true);
                    return;
                }
                themeDescription.startEditing();
                if (i2 == 0) {
                    this.colorPicker.setColor(themeDescription.getCurrentColor());
                }
            }
            setColorPickerVisible(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$1$ThemeEditorView$EditorAlert(View view) {
            dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$2$ThemeEditorView$EditorAlert(View view) throws Throwable {
            Theme.saveCurrentTheme(ThemeEditorView.this.themeInfo, true, false, false);
            setOnDismissListener(null);
            dismiss();
            ThemeEditorView.this.close();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$3$ThemeEditorView$EditorAlert(View view) throws Throwable {
            for (int i = 0; i < ThemeEditorView.this.currentThemeDesription.size(); i++) {
                ((ThemeDescription) ThemeEditorView.this.currentThemeDesription.get(i)).setPreviousColor();
            }
            setColorPickerVisible(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$4$ThemeEditorView$EditorAlert(View view) throws Throwable {
            for (int i = 0; i < ThemeEditorView.this.currentThemeDesription.size(); i++) {
                ((ThemeDescription) ThemeEditorView.this.currentThemeDesription.get(i)).setDefaultColor();
            }
            setColorPickerVisible(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$5$ThemeEditorView$EditorAlert(View view) throws Throwable {
            setColorPickerVisible(false);
        }

        private void runShadowAnimation(final int num, final boolean show) {
            if ((!show || this.shadow[num].getTag() == null) && (show || this.shadow[num].getTag() != null)) {
                return;
            }
            this.shadow[num].setTag(show ? null : 1);
            if (show) {
                this.shadow[num].setVisibility(0);
            }
            AnimatorSet[] animatorSetArr = this.shadowAnimation;
            if (animatorSetArr[num] != null) {
                animatorSetArr[num].cancel();
            }
            this.shadowAnimation[num] = new AnimatorSet();
            AnimatorSet animatorSet = this.shadowAnimation[num];
            Animator[] animatorArr = new Animator[1];
            View view = this.shadow[num];
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = show ? 1.0f : 0.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
            animatorSet.playTogether(animatorArr);
            this.shadowAnimation[num].setDuration(150L);
            this.shadowAnimation[num].addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ThemeEditorView.EditorAlert.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (EditorAlert.this.shadowAnimation[num] == null || !EditorAlert.this.shadowAnimation[num].equals(animation)) {
                        return;
                    }
                    if (!show) {
                        EditorAlert.this.shadow[num].setVisibility(4);
                    }
                    EditorAlert.this.shadowAnimation[num] = null;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    if (EditorAlert.this.shadowAnimation[num] == null || !EditorAlert.this.shadowAnimation[num].equals(animation)) {
                        return;
                    }
                    EditorAlert.this.shadowAnimation[num] = null;
                }
            });
            this.shadowAnimation[num].start();
        }

        @Override // ir.eitaa.ui.ActionBar.BottomSheet
        public void dismissInternal() {
            super.dismissInternal();
            if (this.searchField.searchEditText.isFocused()) {
                AndroidUtilities.hideKeyboard(this.searchField.searchEditText);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColorPickerVisible(boolean visible) throws Throwable {
            if (!visible) {
                if (ThemeEditorView.this.parentActivity != null) {
                    ((LaunchActivity) ThemeEditorView.this.parentActivity).rebuildAllFragments(false);
                }
                Theme.saveCurrentTheme(ThemeEditorView.this.themeInfo, false, false, false);
                if (this.listView.getAdapter() == this.listAdapter) {
                    AndroidUtilities.hideKeyboard(getCurrentFocus());
                }
                this.animationInProgress = true;
                this.listView.setVisibility(0);
                this.bottomSaveLayout.setVisibility(0);
                this.searchField.setVisibility(0);
                this.listView.setAlpha(0.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                Animator[] animatorArr = new Animator[8];
                animatorArr[0] = ObjectAnimator.ofFloat(this.colorPicker, (Property<ColorPicker, Float>) View.ALPHA, 0.0f);
                animatorArr[1] = ObjectAnimator.ofFloat(this.bottomLayout, (Property<FrameLayout, Float>) View.ALPHA, 0.0f);
                animatorArr[2] = ObjectAnimator.ofFloat(this.listView, (Property<RecyclerListView, Float>) View.ALPHA, 1.0f);
                animatorArr[3] = ObjectAnimator.ofFloat(this.frameLayout, (Property<FrameLayout, Float>) View.ALPHA, 1.0f);
                View[] viewArr = this.shadow;
                View view = viewArr[0];
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = viewArr[0].getTag() == null ? 1.0f : 0.0f;
                animatorArr[4] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
                animatorArr[5] = ObjectAnimator.ofFloat(this.searchEmptyView, (Property<EmptyTextProgressView, Float>) View.ALPHA, 1.0f);
                animatorArr[6] = ObjectAnimator.ofFloat(this.bottomSaveLayout, (Property<FrameLayout, Float>) View.ALPHA, 1.0f);
                animatorArr[7] = ObjectAnimator.ofInt(this, "scrollOffsetY", this.previousScrollPosition);
                animatorSet.playTogether(animatorArr);
                animatorSet.setDuration(150L);
                animatorSet.setInterpolator(ThemeEditorView.this.decelerateInterpolator);
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ThemeEditorView.EditorAlert.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (EditorAlert.this.listView.getAdapter() == EditorAlert.this.searchAdapter) {
                            EditorAlert.this.searchField.showKeyboard();
                        }
                        EditorAlert.this.colorPicker.setVisibility(8);
                        EditorAlert.this.bottomLayout.setVisibility(8);
                        EditorAlert.this.animationInProgress = false;
                    }
                });
                animatorSet.start();
                this.listView.getAdapter().notifyItemChanged(ThemeEditorView.this.currentThemeDesriptionPosition);
                return;
            }
            this.animationInProgress = true;
            this.colorPicker.setVisibility(0);
            this.bottomLayout.setVisibility(0);
            this.colorPicker.setAlpha(0.0f);
            this.bottomLayout.setAlpha(0.0f);
            this.previousScrollPosition = this.scrollOffsetY;
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.colorPicker, (Property<ColorPicker, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.bottomLayout, (Property<FrameLayout, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.listView, (Property<RecyclerListView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.frameLayout, (Property<FrameLayout, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.shadow[0], (Property<View, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.searchEmptyView, (Property<EmptyTextProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.bottomSaveLayout, (Property<FrameLayout, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofInt(this, "scrollOffsetY", this.listView.getPaddingTop()));
            animatorSet2.setDuration(150L);
            animatorSet2.setInterpolator(ThemeEditorView.this.decelerateInterpolator);
            animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ThemeEditorView.EditorAlert.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    EditorAlert.this.listView.setVisibility(4);
                    EditorAlert.this.searchField.setVisibility(4);
                    EditorAlert.this.bottomSaveLayout.setVisibility(4);
                    EditorAlert.this.animationInProgress = false;
                }
            });
            animatorSet2.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getCurrentTop() {
            if (this.listView.getChildCount() == 0) {
                return -1000;
            }
            int top = 0;
            View childAt = this.listView.getChildAt(0);
            RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
            if (holder == null) {
                return -1000;
            }
            int paddingTop = this.listView.getPaddingTop();
            if (holder.getAdapterPosition() == 0 && childAt.getTop() >= 0) {
                top = childAt.getTop();
            }
            return paddingTop - top;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @SuppressLint({"NewApi"})
        public void updateLayout() {
            int paddingTop;
            if (this.listView.getChildCount() <= 0 || this.listView.getVisibility() != 0 || this.animationInProgress) {
                return;
            }
            int i = 0;
            View childAt = this.listView.getChildAt(0);
            RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
            if (this.listView.getVisibility() != 0 || this.animationInProgress) {
                paddingTop = this.listView.getPaddingTop();
            } else {
                paddingTop = childAt.getTop() - AndroidUtilities.dp(8.0f);
            }
            if (paddingTop > (-AndroidUtilities.dp(1.0f)) && holder != null && holder.getAdapterPosition() == 0) {
                runShadowAnimation(0, false);
                i = paddingTop;
            } else {
                runShadowAnimation(0, true);
            }
            if (this.scrollOffsetY != i) {
                setScrollOffsetY(i);
            }
        }

        @Keep
        public int getScrollOffsetY() {
            return this.scrollOffsetY;
        }

        @Keep
        public void setScrollOffsetY(int value) {
            RecyclerListView recyclerListView = this.listView;
            this.scrollOffsetY = value;
            recyclerListView.setTopGlowOffset(value);
            this.frameLayout.setTranslationY(this.scrollOffsetY);
            this.colorPicker.setTranslationY(this.scrollOffsetY);
            this.searchEmptyView.setTranslationY(this.scrollOffsetY);
            this.containerView.invalidate();
        }

        public class SearchAdapter extends RecyclerListView.SelectionAdapter {
            private Context context;
            private int lastSearchId;
            private String lastSearchText;
            private Runnable searchRunnable;
            private ArrayList<ArrayList<ThemeDescription>> searchResult = new ArrayList<>();
            private ArrayList<CharSequence> searchNames = new ArrayList<>();

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemViewType(int i) {
                return i == 0 ? 1 : 0;
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
            public boolean isEnabled(RecyclerView.ViewHolder holder) {
                return true;
            }

            public SearchAdapter(Context context) {
                this.context = context;
            }

            public CharSequence generateSearchName(String name, String q) {
                if (TextUtils.isEmpty(name)) {
                    return "";
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                String strTrim = name.trim();
                String lowerCase = strTrim.toLowerCase();
                int i = 0;
                while (true) {
                    int iIndexOf = lowerCase.indexOf(q, i);
                    if (iIndexOf == -1) {
                        break;
                    }
                    int length = q.length() + iIndexOf;
                    if (i != 0 && i != iIndexOf + 1) {
                        spannableStringBuilder.append((CharSequence) strTrim.substring(i, iIndexOf));
                    } else if (i == 0 && iIndexOf != 0) {
                        spannableStringBuilder.append((CharSequence) strTrim.substring(0, iIndexOf));
                    }
                    String strSubstring = strTrim.substring(iIndexOf, Math.min(strTrim.length(), length));
                    if (strSubstring.startsWith(" ")) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    String strTrim2 = strSubstring.trim();
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) strTrim2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-11697229), length2, strTrim2.length() + length2, 33);
                    i = length;
                }
                if (i != -1 && i < strTrim.length()) {
                    spannableStringBuilder.append((CharSequence) strTrim.substring(i));
                }
                return spannableStringBuilder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: searchDialogsInternal, reason: merged with bridge method [inline-methods] */
            public void lambda$searchDialogs$1$ThemeEditorView$EditorAlert$SearchAdapter(final String query, final int searchId) {
                try {
                    String lowerCase = query.trim().toLowerCase();
                    if (lowerCase.length() == 0) {
                        this.lastSearchId = -1;
                        updateSearchResults(new ArrayList<>(), new ArrayList<>(), this.lastSearchId);
                        return;
                    }
                    String translitString = LocaleController.getInstance().getTranslitString(lowerCase);
                    if (lowerCase.equals(translitString) || translitString.length() == 0) {
                        translitString = null;
                    }
                    int i = (translitString != null ? 1 : 0) + 1;
                    String[] strArr = new String[i];
                    strArr[0] = lowerCase;
                    if (translitString != null) {
                        strArr[1] = translitString;
                    }
                    ArrayList<ArrayList<ThemeDescription>> arrayList = new ArrayList<>();
                    ArrayList<CharSequence> arrayList2 = new ArrayList<>();
                    int size = EditorAlert.this.listAdapter.items.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ArrayList<ThemeDescription> arrayList3 = (ArrayList) EditorAlert.this.listAdapter.items.get(i2);
                        String currentKey = arrayList3.get(0).getCurrentKey();
                        String lowerCase2 = currentKey.toLowerCase();
                        int i3 = 0;
                        while (true) {
                            if (i3 < i) {
                                String str = strArr[i3];
                                if (lowerCase2.contains(str)) {
                                    arrayList.add(arrayList3);
                                    arrayList2.add(generateSearchName(currentKey, str));
                                    break;
                                }
                                i3++;
                            }
                        }
                    }
                    updateSearchResults(arrayList, arrayList2, searchId);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }

            private void updateSearchResults(final ArrayList<ArrayList<ThemeDescription>> result, final ArrayList<CharSequence> names, final int searchId) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ThemeEditorView$EditorAlert$SearchAdapter$e1uABJLT5APVBg92G1owJO_NHlU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updateSearchResults$0$ThemeEditorView$EditorAlert$SearchAdapter(searchId, result, names);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$updateSearchResults$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$updateSearchResults$0$ThemeEditorView$EditorAlert$SearchAdapter(int i, ArrayList arrayList, ArrayList arrayList2) {
                if (i != this.lastSearchId) {
                    return;
                }
                if (EditorAlert.this.listView.getAdapter() != EditorAlert.this.searchAdapter) {
                    EditorAlert editorAlert = EditorAlert.this;
                    editorAlert.topBeforeSwitch = editorAlert.getCurrentTop();
                    EditorAlert.this.listView.setAdapter(EditorAlert.this.searchAdapter);
                    EditorAlert.this.searchAdapter.notifyDataSetChanged();
                }
                boolean z = !this.searchResult.isEmpty() && arrayList.isEmpty();
                boolean z2 = this.searchResult.isEmpty() && arrayList.isEmpty();
                if (z) {
                    EditorAlert editorAlert2 = EditorAlert.this;
                    editorAlert2.topBeforeSwitch = editorAlert2.getCurrentTop();
                }
                this.searchResult = arrayList;
                this.searchNames = arrayList2;
                notifyDataSetChanged();
                if (!z2 && !z && EditorAlert.this.topBeforeSwitch > 0) {
                    EditorAlert.this.layoutManager.scrollToPositionWithOffset(0, -EditorAlert.this.topBeforeSwitch);
                    EditorAlert.this.topBeforeSwitch = -1000;
                }
                EditorAlert.this.searchEmptyView.showTextView();
            }

            public void searchDialogs(final String query) throws InterruptedException {
                if (query == null || !query.equals(this.lastSearchText)) {
                    this.lastSearchText = query;
                    if (this.searchRunnable != null) {
                        Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                        this.searchRunnable = null;
                    }
                    if (query == null || query.length() == 0) {
                        this.searchResult.clear();
                        EditorAlert editorAlert = EditorAlert.this;
                        editorAlert.topBeforeSwitch = editorAlert.getCurrentTop();
                        this.lastSearchId = -1;
                        notifyDataSetChanged();
                        return;
                    }
                    final int i = this.lastSearchId + 1;
                    this.lastSearchId = i;
                    this.searchRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ThemeEditorView$EditorAlert$SearchAdapter$u4rF4uOU8wjQpQQ0DNTo2hlMFlo
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$searchDialogs$1$ThemeEditorView$EditorAlert$SearchAdapter(query, i);
                        }
                    };
                    Utilities.searchQueue.postRunnable(this.searchRunnable, 300L);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                if (this.searchResult.isEmpty()) {
                    return 0;
                }
                return this.searchResult.size() + 1;
            }

            public ArrayList<ThemeDescription> getItem(int i) {
                if (i < 0 || i >= this.searchResult.size()) {
                    return null;
                }
                return this.searchResult.get(i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View textColorThemeCell;
                if (viewType == 0) {
                    textColorThemeCell = new TextColorThemeCell(this.context);
                    textColorThemeCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                } else {
                    textColorThemeCell = new View(this.context);
                    textColorThemeCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(56.0f)));
                }
                return new RecyclerListView.Holder(textColorThemeCell);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                if (holder.getItemViewType() == 0) {
                    int i = position - 1;
                    ThemeDescription themeDescription = this.searchResult.get(i).get(0);
                    ((TextColorThemeCell) holder.itemView).setTextAndColor(this.searchNames.get(i), themeDescription.getCurrentKey().equals("chat_wallpaper") ? 0 : themeDescription.getSetColor());
                }
            }
        }

        private class ListAdapter extends RecyclerListView.SelectionAdapter {
            private Context context;
            private ArrayList<ArrayList<ThemeDescription>> items = new ArrayList<>();

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemViewType(int i) {
                return i == 0 ? 1 : 0;
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
            public boolean isEnabled(RecyclerView.ViewHolder holder) {
                return true;
            }

            public ListAdapter(Context context, ArrayList<ThemeDescription> descriptions) {
                this.context = context;
                HashMap map = new HashMap();
                int size = descriptions.size();
                for (int i = 0; i < size; i++) {
                    ThemeDescription themeDescription = descriptions.get(i);
                    String currentKey = themeDescription.getCurrentKey();
                    ArrayList<ThemeDescription> arrayList = (ArrayList) map.get(currentKey);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        map.put(currentKey, arrayList);
                        this.items.add(arrayList);
                    }
                    arrayList.add(themeDescription);
                }
                if (Build.VERSION.SDK_INT < 26 || map.containsKey("windowBackgroundGray")) {
                    return;
                }
                ArrayList<ThemeDescription> arrayList2 = new ArrayList<>();
                arrayList2.add(new ThemeDescription(null, 0, null, null, null, null, "windowBackgroundGray"));
                this.items.add(arrayList2);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                if (this.items.isEmpty()) {
                    return 0;
                }
                return this.items.size() + 1;
            }

            public ArrayList<ThemeDescription> getItem(int i) {
                if (i < 0 || i >= this.items.size()) {
                    return null;
                }
                return this.items.get(i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View textColorThemeCell;
                if (viewType == 0) {
                    textColorThemeCell = new TextColorThemeCell(this.context);
                    textColorThemeCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                } else {
                    textColorThemeCell = new View(this.context);
                    textColorThemeCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(56.0f)));
                }
                return new RecyclerListView.Holder(textColorThemeCell);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                if (holder.getItemViewType() == 0) {
                    ThemeDescription themeDescription = this.items.get(position - 1).get(0);
                    ((TextColorThemeCell) holder.itemView).setTextAndColor(themeDescription.getTitle(), themeDescription.getCurrentKey().equals("chat_wallpaper") ? 0 : themeDescription.getSetColor());
                }
            }
        }
    }

    public void show(Activity activity, final Theme.ThemeInfo theme) {
        if (Instance != null) {
            Instance.destroy();
        }
        this.hidden = false;
        this.themeInfo = theme;
        this.windowView = new AnonymousClass1(activity);
        this.windowManager = (WindowManager) activity.getSystemService("window");
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0);
        this.preferences = sharedPreferences;
        int i = sharedPreferences.getInt("sidex", 1);
        int i2 = this.preferences.getInt("sidey", 0);
        float f = this.preferences.getFloat("px", 0.0f);
        float f2 = this.preferences.getFloat("py", 0.0f);
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.windowLayoutParams = layoutParams;
            int i3 = this.editorWidth;
            layoutParams.width = i3;
            layoutParams.height = this.editorHeight;
            layoutParams.x = getSideCoord(true, i, f, i3);
            this.windowLayoutParams.y = getSideCoord(false, i2, f2, this.editorHeight);
            WindowManager.LayoutParams layoutParams2 = this.windowLayoutParams;
            layoutParams2.format = -3;
            layoutParams2.gravity = 51;
            layoutParams2.type = 99;
            layoutParams2.flags = 16777736;
            this.windowManager.addView(this.windowView, layoutParams2);
            this.wallpaperUpdater = new WallpaperUpdater(activity, null, new WallpaperUpdater.WallpaperUpdaterDelegate() { // from class: ir.eitaa.ui.Components.ThemeEditorView.2
                @Override // ir.eitaa.ui.Components.WallpaperUpdater.WallpaperUpdaterDelegate
                public void didSelectWallpaper(File file, Bitmap bitmap, boolean gallery) throws Throwable {
                    Theme.setThemeWallpaper(ThemeEditorView.this.themeInfo, bitmap, file);
                }

                @Override // ir.eitaa.ui.Components.WallpaperUpdater.WallpaperUpdaterDelegate
                public void needOpenColorPicker() throws Throwable {
                    for (int i4 = 0; i4 < ThemeEditorView.this.currentThemeDesription.size(); i4++) {
                        ThemeDescription themeDescription = (ThemeDescription) ThemeEditorView.this.currentThemeDesription.get(i4);
                        themeDescription.startEditing();
                        if (i4 == 0) {
                            ThemeEditorView.this.editorAlert.colorPicker.setColor(themeDescription.getCurrentColor());
                        }
                    }
                    ThemeEditorView.this.editorAlert.setColorPickerVisible(true);
                }
            });
            Instance = this;
            this.parentActivity = activity;
            showWithAnimation();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* renamed from: ir.eitaa.ui.Components.ThemeEditorView$1, reason: invalid class name */
    class AnonymousClass1 extends FrameLayout {
        private boolean dragging;
        private float startX;
        private float startY;

        static /* synthetic */ void lambda$onTouchEvent$0(DialogInterface dialogInterface) {
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent event) {
            return true;
        }

        AnonymousClass1(Context context) {
            super(context);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0093  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r11) {
            /*
                Method dump skipped, instructions count: 557
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ThemeEditorView.AnonymousClass1.onTouchEvent(android.view.MotionEvent):boolean");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onTouchEvent$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onTouchEvent$1$ThemeEditorView$1(DialogInterface dialogInterface) {
            ThemeEditorView.this.editorAlert = null;
            ThemeEditorView.this.show();
        }
    }

    private void showWithAnimation() {
        this.windowView.setBackgroundResource(R.drawable.theme_picker);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.windowView, (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.windowView, (Property<FrameLayout, Float>) View.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.windowView, (Property<FrameLayout, Float>) View.SCALE_Y, 0.0f, 1.0f));
        animatorSet.setInterpolator(this.decelerateInterpolator);
        animatorSet.setDuration(150L);
        animatorSet.start();
    }

    private static int getSideCoord(boolean isX, int side, float p, int sideSize) {
        int i;
        int iRound;
        if (isX) {
            i = AndroidUtilities.displaySize.x;
        } else {
            i = AndroidUtilities.displaySize.y - sideSize;
            sideSize = ActionBar.getCurrentActionBarHeight();
        }
        int i2 = i - sideSize;
        if (side == 0) {
            iRound = AndroidUtilities.dp(10.0f);
        } else if (side == 1) {
            iRound = i2 - AndroidUtilities.dp(10.0f);
        } else {
            iRound = Math.round((i2 - AndroidUtilities.dp(20.0f)) * p) + AndroidUtilities.dp(10.0f);
        }
        return !isX ? iRound + ActionBar.getCurrentActionBarHeight() : iRound;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.parentActivity == null) {
            return;
        }
        try {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.windowView, (Property<FrameLayout, Float>) View.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.windowView, (Property<FrameLayout, Float>) View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.windowView, (Property<FrameLayout, Float>) View.SCALE_Y, 1.0f, 0.0f));
            animatorSet.setInterpolator(this.decelerateInterpolator);
            animatorSet.setDuration(150L);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ThemeEditorView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (ThemeEditorView.this.windowView != null) {
                        ThemeEditorView.this.windowView.setBackground(null);
                        ThemeEditorView.this.windowManager.removeView(ThemeEditorView.this.windowView);
                    }
                }
            });
            animatorSet.start();
            this.hidden = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        if (this.parentActivity == null) {
            return;
        }
        try {
            this.windowManager.addView(this.windowView, this.windowLayoutParams);
            this.hidden = false;
            showWithAnimation();
        } catch (Exception unused) {
        }
    }

    public void close() {
        try {
            this.windowManager.removeView(this.windowView);
        } catch (Exception unused) {
        }
        this.parentActivity = null;
    }

    public void onConfigurationChanged() {
        int i = this.preferences.getInt("sidex", 1);
        int i2 = this.preferences.getInt("sidey", 0);
        float f = this.preferences.getFloat("px", 0.0f);
        float f2 = this.preferences.getFloat("py", 0.0f);
        this.windowLayoutParams.x = getSideCoord(true, i, f, this.editorWidth);
        this.windowLayoutParams.y = getSideCoord(false, i2, f2, this.editorHeight);
        try {
            if (this.windowView.getParent() != null) {
                this.windowManager.updateViewLayout(this.windowView, this.windowLayoutParams);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        WallpaperUpdater wallpaperUpdater = this.wallpaperUpdater;
        if (wallpaperUpdater != null) {
            wallpaperUpdater.onActivityResult(requestCode, resultCode, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void animateToBoundsMaybe() {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ThemeEditorView.animateToBoundsMaybe():void");
    }

    @Keep
    public int getX() {
        return this.windowLayoutParams.x;
    }

    @Keep
    public int getY() {
        return this.windowLayoutParams.y;
    }

    @Keep
    public void setX(int value) {
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        layoutParams.x = value;
        this.windowManager.updateViewLayout(this.windowView, layoutParams);
    }

    @Keep
    public void setY(int value) {
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        layoutParams.y = value;
        this.windowManager.updateViewLayout(this.windowView, layoutParams);
    }
}
