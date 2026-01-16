package ir.eitaa.ui.Cells;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_theme;
import ir.eitaa.tgnet.TLRPC$TL_wallPaper;
import ir.eitaa.tgnet.TLRPC$WallPaper;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.MotionBackgroundDrawable;
import ir.eitaa.ui.Components.RadioButton;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.ThemeSetUrlActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class ThemesHorizontalListCell extends RecyclerListView implements NotificationCenter.NotificationCenterDelegate {
    private static byte[] bytes = new byte[Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV];
    private ThemesListAdapter adapter;
    private int currentType;
    private ArrayList<Theme.ThemeInfo> darkThemes;
    private ArrayList<Theme.ThemeInfo> defaultThemes;
    private boolean drawDivider;
    private LinearLayoutManager horizontalLayoutManager;
    private HashMap<String, Theme.ThemeInfo> loadingThemes;
    private HashMap<Theme.ThemeInfo, String> loadingWallpapers;
    private int prevCount;
    private Theme.ThemeInfo prevThemeInfo;

    protected void presentFragment(BaseFragment fragment) {
    }

    protected void showOptionsForTheme(Theme.ThemeInfo themeInfo) {
    }

    protected void updateRows() {
    }

    private class ThemesListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return false;
        }

        ThemesListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerListView.Holder(ThemesHorizontalListCell.this.new InnerThemeView(this.mContext));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) throws IOException {
            ArrayList arrayList;
            int size;
            InnerThemeView innerThemeView = (InnerThemeView) holder.itemView;
            if (position < ThemesHorizontalListCell.this.defaultThemes.size()) {
                arrayList = ThemesHorizontalListCell.this.defaultThemes;
                size = position;
            } else {
                arrayList = ThemesHorizontalListCell.this.darkThemes;
                size = position - ThemesHorizontalListCell.this.defaultThemes.size();
            }
            innerThemeView.setTheme((Theme.ThemeInfo) arrayList.get(size), position == getItemCount() - 1, position == 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ThemesHorizontalListCell themesHorizontalListCell = ThemesHorizontalListCell.this;
            return themesHorizontalListCell.prevCount = themesHorizontalListCell.defaultThemes.size() + ThemesHorizontalListCell.this.darkThemes.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class InnerThemeView extends FrameLayout {
        private ObjectAnimator accentAnimator;
        private boolean accentColorChanged;
        private int accentId;
        private float accentState;
        private int backColor;
        private Drawable backgroundDrawable;
        private Paint bitmapPaint;
        private BitmapShader bitmapShader;
        private RadioButton button;
        private int checkColor;
        private final ArgbEvaluator evaluator;
        private boolean hasWhiteBackground;
        private int inColor;
        private Drawable inDrawable;
        private boolean isFirst;
        private boolean isLast;
        private long lastDrawTime;
        private int loadingColor;
        private Drawable loadingDrawable;
        private int oldBackColor;
        private int oldCheckColor;
        private int oldInColor;
        private int oldOutColor;
        private Drawable optionsDrawable;
        private int outColor;
        private Drawable outDrawable;
        private Paint paint;
        private float placeholderAlpha;
        private boolean pressed;
        private RectF rect;
        private Matrix shaderMatrix;
        private TextPaint textPaint;
        private Theme.ThemeInfo themeInfo;

        public InnerThemeView(Context context) {
            super(context);
            this.rect = new RectF();
            this.paint = new Paint(1);
            this.textPaint = new TextPaint(1);
            this.evaluator = new ArgbEvaluator();
            this.bitmapPaint = new Paint(3);
            this.shaderMatrix = new Matrix();
            setWillNotDraw(false);
            this.inDrawable = context.getResources().getDrawable(R.drawable.minibubble_in).mutate();
            this.outDrawable = context.getResources().getDrawable(R.drawable.minibubble_out).mutate();
            this.textPaint.setTextSize(AndroidUtilities.dp(13.0f));
            this.textPaint.setTypeface(AndroidUtilities.getFontFamily(false));
            RadioButton radioButton = new RadioButton(context);
            this.button = radioButton;
            radioButton.setSize(AndroidUtilities.dp(20.0f));
            addView(this.button, LayoutHelper.createFrame(22, 22.0f, 51, 27.0f, 75.0f, 0.0f, 0.0f));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp((this.isLast ? 22 : 15) + 76 + (this.isFirst ? 22 : 0)), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(148.0f), 1073741824));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            Theme.ThemeInfo themeInfo;
            if (this.optionsDrawable == null || (themeInfo = this.themeInfo) == null || ((themeInfo.info != null && !themeInfo.themeLoaded) || ThemesHorizontalListCell.this.currentType != 0)) {
                return super.onTouchEvent(event);
            }
            int action = event.getAction();
            if (action == 0 || action == 1) {
                float x = event.getX();
                float y = event.getY();
                if (x > this.rect.centerX() && y < this.rect.centerY() - AndroidUtilities.dp(10.0f)) {
                    if (action == 0) {
                        this.pressed = true;
                    } else {
                        performHapticFeedback(3);
                        ThemesHorizontalListCell.this.showOptionsForTheme(this.themeInfo);
                    }
                }
                if (action == 1) {
                    this.pressed = false;
                }
            }
            return this.pressed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:107:0x023d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean parseTheme() {
            /*
                Method dump skipped, instructions count: 814
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ThemesHorizontalListCell.InnerThemeView.parseTheme():boolean");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$parseTheme$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$parseTheme$1$ThemesHorizontalListCell$InnerThemeView(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Cells.-$$Lambda$ThemesHorizontalListCell$InnerThemeView$6oMH0dbtPNoyp7XjwEMkm039-Zw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$parseTheme$0$ThemesHorizontalListCell$InnerThemeView(tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$parseTheme$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$parseTheme$0$ThemesHorizontalListCell$InnerThemeView(TLObject tLObject) {
            if (tLObject instanceof TLRPC$TL_wallPaper) {
                TLRPC$WallPaper tLRPC$WallPaper = (TLRPC$WallPaper) tLObject;
                String attachFileName = FileLoader.getAttachFileName(tLRPC$WallPaper.document);
                if (ThemesHorizontalListCell.this.loadingThemes.containsKey(attachFileName)) {
                    return;
                }
                ThemesHorizontalListCell.this.loadingThemes.put(attachFileName, this.themeInfo);
                FileLoader.getInstance(this.themeInfo.account).loadFile(tLRPC$WallPaper.document, tLRPC$WallPaper, 1, 1);
                return;
            }
            this.themeInfo.badWallpaper = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void applyTheme() throws IOException {
            this.inDrawable.setColorFilter(new PorterDuffColorFilter(this.themeInfo.getPreviewInColor(), PorterDuff.Mode.MULTIPLY));
            this.outDrawable.setColorFilter(new PorterDuffColorFilter(this.themeInfo.getPreviewOutColor(), PorterDuff.Mode.MULTIPLY));
            double[] dArrRgbToHsv = null;
            if (this.themeInfo.pathToFile == null) {
                updateColors(false);
                this.optionsDrawable = null;
            } else {
                this.optionsDrawable = getResources().getDrawable(R.drawable.preview_dots).mutate();
                int previewBackgroundColor = this.themeInfo.getPreviewBackgroundColor();
                this.backColor = previewBackgroundColor;
                this.oldBackColor = previewBackgroundColor;
            }
            this.bitmapShader = null;
            this.backgroundDrawable = null;
            Theme.ThemeInfo themeInfo = this.themeInfo;
            int i = themeInfo.previewBackgroundGradientColor1;
            if (i != 0 && themeInfo.previewBackgroundGradientColor2 != 0) {
                int previewBackgroundColor2 = this.themeInfo.getPreviewBackgroundColor();
                Theme.ThemeInfo themeInfo2 = this.themeInfo;
                MotionBackgroundDrawable motionBackgroundDrawable = new MotionBackgroundDrawable(previewBackgroundColor2, themeInfo2.previewBackgroundGradientColor1, themeInfo2.previewBackgroundGradientColor2, themeInfo2.previewBackgroundGradientColor3, true);
                motionBackgroundDrawable.setRoundRadius(AndroidUtilities.dp(6.0f));
                this.backgroundDrawable = motionBackgroundDrawable;
                dArrRgbToHsv = AndroidUtilities.rgbToHsv(Color.red(this.themeInfo.getPreviewBackgroundColor()), Color.green(this.themeInfo.getPreviewBackgroundColor()), Color.blue(this.themeInfo.getPreviewBackgroundColor()));
            } else if (i != 0) {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{this.themeInfo.getPreviewBackgroundColor(), this.themeInfo.previewBackgroundGradientColor1});
                gradientDrawable.setCornerRadius(AndroidUtilities.dp(6.0f));
                this.backgroundDrawable = gradientDrawable;
                dArrRgbToHsv = AndroidUtilities.rgbToHsv(Color.red(this.themeInfo.getPreviewBackgroundColor()), Color.green(this.themeInfo.getPreviewBackgroundColor()), Color.blue(this.themeInfo.getPreviewBackgroundColor()));
            } else if (themeInfo.previewWallpaperOffset > 0 || themeInfo.pathToWallpaper != null) {
                float fDp = AndroidUtilities.dp(76.0f);
                float fDp2 = AndroidUtilities.dp(97.0f);
                Theme.ThemeInfo themeInfo3 = this.themeInfo;
                Bitmap scaledBitmap = ThemesHorizontalListCell.getScaledBitmap(fDp, fDp2, themeInfo3.pathToWallpaper, themeInfo3.pathToFile, themeInfo3.previewWallpaperOffset);
                if (scaledBitmap != null) {
                    this.backgroundDrawable = new BitmapDrawable(scaledBitmap);
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    BitmapShader bitmapShader = new BitmapShader(scaledBitmap, tileMode, tileMode);
                    this.bitmapShader = bitmapShader;
                    this.bitmapPaint.setShader(bitmapShader);
                    int[] iArrCalcDrawableColor = AndroidUtilities.calcDrawableColor(this.backgroundDrawable);
                    dArrRgbToHsv = AndroidUtilities.rgbToHsv(Color.red(iArrCalcDrawableColor[0]), Color.green(iArrCalcDrawableColor[0]), Color.blue(iArrCalcDrawableColor[0]));
                }
            } else if (themeInfo.getPreviewBackgroundColor() != 0) {
                dArrRgbToHsv = AndroidUtilities.rgbToHsv(Color.red(this.themeInfo.getPreviewBackgroundColor()), Color.green(this.themeInfo.getPreviewBackgroundColor()), Color.blue(this.themeInfo.getPreviewBackgroundColor()));
            }
            if (dArrRgbToHsv != null && dArrRgbToHsv[1] <= 0.10000000149011612d && dArrRgbToHsv[2] >= 0.9599999785423279d) {
                this.hasWhiteBackground = true;
            } else {
                this.hasWhiteBackground = false;
            }
            if (this.themeInfo.getPreviewBackgroundColor() == 0 && this.themeInfo.previewParsed && this.backgroundDrawable == null) {
                Drawable drawableCreateDefaultWallpaper = Theme.createDefaultWallpaper(100, 200);
                this.backgroundDrawable = drawableCreateDefaultWallpaper;
                if (drawableCreateDefaultWallpaper instanceof MotionBackgroundDrawable) {
                    ((MotionBackgroundDrawable) drawableCreateDefaultWallpaper).setRoundRadius(AndroidUtilities.dp(6.0f));
                }
            }
            invalidate();
        }

        public void setTheme(Theme.ThemeInfo theme, boolean last, boolean first) throws IOException {
            Theme.ThemeInfo themeInfo;
            TLRPC$TL_theme tLRPC$TL_theme;
            this.themeInfo = theme;
            this.isFirst = first;
            this.isLast = last;
            this.accentId = theme.currentAccentId;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.button.getLayoutParams();
            layoutParams.leftMargin = AndroidUtilities.dp(this.isFirst ? 49.0f : 27.0f);
            this.button.setLayoutParams(layoutParams);
            this.placeholderAlpha = 0.0f;
            Theme.ThemeInfo themeInfo2 = this.themeInfo;
            if (themeInfo2.pathToFile != null && !themeInfo2.previewParsed) {
                themeInfo2.setPreviewInColor(Theme.getDefaultColor("chat_inBubble"));
                this.themeInfo.setPreviewOutColor(Theme.getDefaultColor("chat_outBubble"));
                boolean zExists = new File(this.themeInfo.pathToFile).exists();
                if ((!(zExists && parseTheme()) || !zExists) && (tLRPC$TL_theme = (themeInfo = this.themeInfo).info) != null) {
                    if (tLRPC$TL_theme.document != null) {
                        themeInfo.themeLoaded = false;
                        this.placeholderAlpha = 1.0f;
                        Drawable drawableMutate = getResources().getDrawable(R.drawable.msg_theme).mutate();
                        this.loadingDrawable = drawableMutate;
                        int color = Theme.getColor("windowBackgroundWhiteGrayText7");
                        this.loadingColor = color;
                        Theme.setDrawableColor(drawableMutate, color);
                        if (!zExists) {
                            String attachFileName = FileLoader.getAttachFileName(this.themeInfo.info.document);
                            if (!ThemesHorizontalListCell.this.loadingThemes.containsKey(attachFileName)) {
                                ThemesHorizontalListCell.this.loadingThemes.put(attachFileName, this.themeInfo);
                                FileLoader fileLoader = FileLoader.getInstance(this.themeInfo.account);
                                TLRPC$TL_theme tLRPC$TL_theme2 = this.themeInfo.info;
                                fileLoader.loadFile(tLRPC$TL_theme2.document, tLRPC$TL_theme2, 1, 1);
                            }
                        }
                    } else {
                        Drawable drawableMutate2 = getResources().getDrawable(R.drawable.preview_custom).mutate();
                        this.loadingDrawable = drawableMutate2;
                        int color2 = Theme.getColor("windowBackgroundWhiteGrayText7");
                        this.loadingColor = color2;
                        Theme.setDrawableColor(drawableMutate2, color2);
                    }
                }
            }
            applyTheme();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() throws IOException {
            TLRPC$TL_theme tLRPC$TL_theme;
            super.onAttachedToWindow();
            this.button.setChecked(this.themeInfo == (ThemesHorizontalListCell.this.currentType == 1 ? Theme.getCurrentNightTheme() : Theme.getCurrentTheme()), false);
            Theme.ThemeInfo themeInfo = this.themeInfo;
            if (themeInfo == null || (tLRPC$TL_theme = themeInfo.info) == null || themeInfo.themeLoaded) {
                return;
            }
            if (ThemesHorizontalListCell.this.loadingThemes.containsKey(FileLoader.getAttachFileName(tLRPC$TL_theme.document)) || ThemesHorizontalListCell.this.loadingWallpapers.containsKey(this.themeInfo)) {
                return;
            }
            this.themeInfo.themeLoaded = true;
            this.placeholderAlpha = 0.0f;
            parseTheme();
            applyTheme();
        }

        public void updateCurrentThemeCheck() {
            this.button.setChecked(this.themeInfo == (ThemesHorizontalListCell.this.currentType == 1 ? Theme.getCurrentNightTheme() : Theme.getCurrentTheme()), true);
        }

        void updateColors(boolean animate) {
            int i;
            int i2;
            this.oldInColor = this.inColor;
            this.oldOutColor = this.outColor;
            this.oldBackColor = this.backColor;
            this.oldCheckColor = this.checkColor;
            int i3 = 0;
            Theme.ThemeAccent accent = this.themeInfo.getAccent(false);
            if (accent != null) {
                i3 = accent.accentColor;
                i2 = accent.myMessagesAccentColor;
                if (i2 == 0) {
                    i2 = i3;
                }
                i = (int) accent.backgroundOverrideColor;
                if (i == 0) {
                    i = i3;
                }
            } else {
                i = 0;
                i2 = 0;
            }
            Theme.ThemeInfo themeInfo = this.themeInfo;
            this.inColor = Theme.changeColorAccent(themeInfo, i3, themeInfo.getPreviewInColor());
            Theme.ThemeInfo themeInfo2 = this.themeInfo;
            this.outColor = Theme.changeColorAccent(themeInfo2, i2, themeInfo2.getPreviewOutColor());
            Theme.ThemeInfo themeInfo3 = this.themeInfo;
            this.backColor = Theme.changeColorAccent(themeInfo3, i, themeInfo3.getPreviewBackgroundColor());
            this.checkColor = this.outColor;
            this.accentId = this.themeInfo.currentAccentId;
            ObjectAnimator objectAnimator = this.accentAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (animate) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "accentState", 0.0f, 1.0f);
                this.accentAnimator = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(200L);
                this.accentAnimator.start();
                return;
            }
            setAccentState(1.0f);
        }

        @Keep
        public float getAccentState() {
            return this.accentState;
        }

        @Keep
        public void setAccentState(float state) {
            this.accentState = state;
            this.accentColorChanged = true;
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            boolean z = true;
            if (this.accentId != this.themeInfo.currentAccentId) {
                updateColors(true);
            }
            int iDp = this.isFirst ? AndroidUtilities.dp(22.0f) : 0;
            float f = iDp;
            float fDp = AndroidUtilities.dp(11.0f);
            this.rect.set(f, fDp, AndroidUtilities.dp(76.0f) + iDp, r4 + AndroidUtilities.dp(97.0f));
            String string = TextUtils.ellipsize(getThemeName(), this.textPaint, (getMeasuredWidth() - AndroidUtilities.dp(this.isFirst ? 10.0f : 15.0f)) - (this.isLast ? AndroidUtilities.dp(7.0f) : 0), TextUtils.TruncateAt.END).toString();
            int iCeil = (int) Math.ceil(this.textPaint.measureText(string));
            this.textPaint.setColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            canvas.drawText(string, ((AndroidUtilities.dp(76.0f) - iCeil) / 2) + iDp, AndroidUtilities.dp(131.0f), this.textPaint);
            Theme.ThemeInfo themeInfo = this.themeInfo;
            TLRPC$TL_theme tLRPC$TL_theme = themeInfo.info;
            if (tLRPC$TL_theme != null && (tLRPC$TL_theme.document == null || !themeInfo.themeLoaded)) {
                z = false;
            }
            if (z) {
                this.paint.setColor(blend(this.oldBackColor, this.backColor));
                if (this.accentColorChanged) {
                    this.inDrawable.setColorFilter(new PorterDuffColorFilter(blend(this.oldInColor, this.inColor), PorterDuff.Mode.MULTIPLY));
                    this.outDrawable.setColorFilter(new PorterDuffColorFilter(blend(this.oldOutColor, this.outColor), PorterDuff.Mode.MULTIPLY));
                    this.accentColorChanged = false;
                }
                Drawable drawable = this.backgroundDrawable;
                if (drawable != null) {
                    if (this.bitmapShader != null) {
                        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                        float width = bitmapDrawable.getBitmap().getWidth();
                        float height = bitmapDrawable.getBitmap().getHeight();
                        float fWidth = width / this.rect.width();
                        float fHeight = height / this.rect.height();
                        this.shaderMatrix.reset();
                        float fMin = 1.0f / Math.min(fWidth, fHeight);
                        float f2 = width / fHeight;
                        if (f2 > this.rect.width()) {
                            this.shaderMatrix.setTranslate(f - ((f2 - this.rect.width()) / 2.0f), fDp);
                        } else {
                            this.shaderMatrix.setTranslate(f, fDp - (((height / fWidth) - this.rect.height()) / 2.0f));
                        }
                        this.shaderMatrix.preScale(fMin, fMin);
                        this.bitmapShader.setLocalMatrix(this.shaderMatrix);
                        canvas.drawRoundRect(this.rect, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), this.bitmapPaint);
                    } else {
                        RectF rectF = this.rect;
                        drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                        this.backgroundDrawable.draw(canvas);
                    }
                } else {
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), this.paint);
                }
                this.button.setColor(1728053247, -1);
                Theme.ThemeInfo themeInfo2 = this.themeInfo;
                if (themeInfo2.accentBaseColor != 0) {
                    if ("Day".equals(themeInfo2.name) || "Arctic Blue".equals(this.themeInfo.name)) {
                        this.button.setColor(-5000269, blend(this.oldCheckColor, this.checkColor));
                        Theme.chat_instantViewRectPaint.setColor(733001146);
                        canvas.drawRoundRect(this.rect, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), Theme.chat_instantViewRectPaint);
                    }
                } else if (this.hasWhiteBackground) {
                    this.button.setColor(-5000269, themeInfo2.getPreviewOutColor());
                    Theme.chat_instantViewRectPaint.setColor(733001146);
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), Theme.chat_instantViewRectPaint);
                }
                this.inDrawable.setBounds(AndroidUtilities.dp(6.0f) + iDp, AndroidUtilities.dp(22.0f), AndroidUtilities.dp(49.0f) + iDp, AndroidUtilities.dp(36.0f));
                this.inDrawable.draw(canvas);
                this.outDrawable.setBounds(AndroidUtilities.dp(27.0f) + iDp, AndroidUtilities.dp(41.0f), iDp + AndroidUtilities.dp(70.0f), AndroidUtilities.dp(55.0f));
                this.outDrawable.draw(canvas);
                if (this.optionsDrawable != null && ThemesHorizontalListCell.this.currentType == 0) {
                    int iDp2 = ((int) this.rect.right) - AndroidUtilities.dp(16.0f);
                    int iDp3 = ((int) this.rect.top) + AndroidUtilities.dp(6.0f);
                    Drawable drawable2 = this.optionsDrawable;
                    drawable2.setBounds(iDp2, iDp3, drawable2.getIntrinsicWidth() + iDp2, this.optionsDrawable.getIntrinsicHeight() + iDp3);
                    this.optionsDrawable.draw(canvas);
                }
            }
            Theme.ThemeInfo themeInfo3 = this.themeInfo;
            TLRPC$TL_theme tLRPC$TL_theme2 = themeInfo3.info;
            if (tLRPC$TL_theme2 != null && tLRPC$TL_theme2.document == null) {
                this.button.setAlpha(0.0f);
                Theme.chat_instantViewRectPaint.setColor(733001146);
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), Theme.chat_instantViewRectPaint);
                if (this.loadingDrawable != null) {
                    int color = Theme.getColor("windowBackgroundWhiteGrayText7");
                    if (this.loadingColor != color) {
                        Drawable drawable3 = this.loadingDrawable;
                        this.loadingColor = color;
                        Theme.setDrawableColor(drawable3, color);
                    }
                    int iCenterX = (int) (this.rect.centerX() - (this.loadingDrawable.getIntrinsicWidth() / 2));
                    int iCenterY = (int) (this.rect.centerY() - (this.loadingDrawable.getIntrinsicHeight() / 2));
                    Drawable drawable4 = this.loadingDrawable;
                    drawable4.setBounds(iCenterX, iCenterY, drawable4.getIntrinsicWidth() + iCenterX, this.loadingDrawable.getIntrinsicHeight() + iCenterY);
                    this.loadingDrawable.draw(canvas);
                    return;
                }
                return;
            }
            if ((tLRPC$TL_theme2 == null || themeInfo3.themeLoaded) && this.placeholderAlpha <= 0.0f) {
                if (this.button.getAlpha() != 1.0f) {
                    this.button.setAlpha(1.0f);
                    return;
                }
                return;
            }
            this.button.setAlpha(1.0f - this.placeholderAlpha);
            this.paint.setColor(Theme.getColor("windowBackgroundGray"));
            this.paint.setAlpha((int) (this.placeholderAlpha * 255.0f));
            canvas.drawRoundRect(this.rect, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), this.paint);
            if (this.loadingDrawable != null) {
                int color2 = Theme.getColor("windowBackgroundWhiteGrayText7");
                if (this.loadingColor != color2) {
                    Drawable drawable5 = this.loadingDrawable;
                    this.loadingColor = color2;
                    Theme.setDrawableColor(drawable5, color2);
                }
                int iCenterX2 = (int) (this.rect.centerX() - (this.loadingDrawable.getIntrinsicWidth() / 2));
                int iCenterY2 = (int) (this.rect.centerY() - (this.loadingDrawable.getIntrinsicHeight() / 2));
                this.loadingDrawable.setAlpha((int) (this.placeholderAlpha * 255.0f));
                Drawable drawable6 = this.loadingDrawable;
                drawable6.setBounds(iCenterX2, iCenterY2, drawable6.getIntrinsicWidth() + iCenterX2, this.loadingDrawable.getIntrinsicHeight() + iCenterY2);
                this.loadingDrawable.draw(canvas);
            }
            if (this.themeInfo.themeLoaded) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long jMin = Math.min(17L, jElapsedRealtime - this.lastDrawTime);
                this.lastDrawTime = jElapsedRealtime;
                float f3 = this.placeholderAlpha - (jMin / 180.0f);
                this.placeholderAlpha = f3;
                if (f3 < 0.0f) {
                    this.placeholderAlpha = 0.0f;
                }
                invalidate();
            }
        }

        private String getThemeName() {
            String name = this.themeInfo.getName();
            return name.toLowerCase().endsWith(".attheme") ? name.substring(0, name.lastIndexOf(46)) : name;
        }

        private int blend(int color1, int color2) {
            float f = this.accentState;
            return f == 1.0f ? color2 : ((Integer) this.evaluator.evaluate(f, Integer.valueOf(color1), Integer.valueOf(color2))).intValue();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setText(getThemeName());
            info.setClassName(Button.class.getName());
            info.setChecked(this.button.isChecked());
            info.setCheckable(true);
            info.setEnabled(true);
            if (Build.VERSION.SDK_INT >= 21) {
                info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
                info.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions)));
            }
        }
    }

    public ThemesHorizontalListCell(Context context, int type, ArrayList<Theme.ThemeInfo> def, ArrayList<Theme.ThemeInfo> dark) {
        super(context);
        this.loadingThemes = new HashMap<>();
        this.loadingWallpapers = new HashMap<>();
        this.darkThemes = dark;
        this.defaultThemes = def;
        this.currentType = type;
        if (type == 2) {
            setBackgroundColor(Theme.getColor("dialogBackground"));
        } else {
            setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        }
        setItemAnimator(null);
        setLayoutAnimation(null);
        this.horizontalLayoutManager = new LinearLayoutManager(context) { // from class: ir.eitaa.ui.Cells.ThemesHorizontalListCell.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        setPadding(0, 0, 0, 0);
        setClipToPadding(false);
        this.horizontalLayoutManager.setOrientation(0);
        setLayoutManager(this.horizontalLayoutManager);
        ThemesListAdapter themesListAdapter = new ThemesListAdapter(context);
        this.adapter = themesListAdapter;
        setAdapter(themesListAdapter);
        setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$ThemesHorizontalListCell$DIXnuffo9KmazyJvZb5q0PRgRgQ
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$new$0$ThemesHorizontalListCell(view, i);
            }
        });
        setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$ThemesHorizontalListCell$Eqjxzfg48UKUI2p_dcapeQVg1x4
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return this.f$0.lambda$new$1$ThemesHorizontalListCell(view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ThemesHorizontalListCell(View view, int i) {
        selectTheme(((InnerThemeView) view).themeInfo);
        int left = view.getLeft();
        int right = view.getRight();
        if (left < 0) {
            smoothScrollBy(left - AndroidUtilities.dp(8.0f), 0);
        } else if (right > getMeasuredWidth()) {
            smoothScrollBy(right - getMeasuredWidth(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$1$ThemesHorizontalListCell(View view, int i) {
        showOptionsForTheme(((InnerThemeView) view).themeInfo);
        return true;
    }

    public void selectTheme(Theme.ThemeInfo themeInfo) {
        TLRPC$TL_theme tLRPC$TL_theme = themeInfo.info;
        if (tLRPC$TL_theme != null) {
            if (!themeInfo.themeLoaded) {
                return;
            }
            if (tLRPC$TL_theme.document == null) {
                presentFragment(new ThemeSetUrlActivity(themeInfo, null, true));
                return;
            }
        }
        if (!TextUtils.isEmpty(themeInfo.assetName)) {
            Theme.PatternsLoader.createLoader(false);
        }
        if (this.currentType != 2) {
            SharedPreferences.Editor editorEdit = ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0).edit();
            editorEdit.putString((this.currentType == 1 || themeInfo.isDark()) ? "lastDarkTheme" : "lastDayTheme", themeInfo.getKey());
            editorEdit.commit();
        }
        if (this.currentType == 1) {
            if (themeInfo == Theme.getCurrentNightTheme()) {
                return;
            } else {
                Theme.setCurrentNightTheme(themeInfo);
            }
        } else if (themeInfo == Theme.getCurrentTheme()) {
            return;
        } else {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needSetDayNightTheme, themeInfo, Boolean.FALSE, null, -1);
        }
        updateRows();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof InnerThemeView) {
                ((InnerThemeView) childAt).updateCurrentThemeCheck();
            }
        }
    }

    public void setDrawDivider(boolean draw) {
        this.drawDivider = draw;
    }

    public void notifyDataSetChanged(int width) {
        if (this.prevCount == this.adapter.getItemCount()) {
            return;
        }
        this.adapter.notifyDataSetChanged();
        if (this.prevThemeInfo != (this.currentType == 1 ? Theme.getCurrentNightTheme() : Theme.getCurrentTheme())) {
            scrollToCurrentTheme(width, false);
        }
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e) {
        if (getParent() != null && getParent().getParent() != null) {
            getParent().getParent().requestDisallowInterceptTouchEvent(canScrollHorizontally(-1));
        }
        return super.onInterceptTouchEvent(e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.drawDivider) {
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(20.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
        }
    }

    public static Bitmap getScaledBitmap(float w, float h, String path, String streamPath, int streamOffset) throws IOException {
        FileInputStream fileInputStream;
        BitmapFactory.Options options;
        int i;
        int i2;
        Bitmap bitmapDecodeStream;
        int i3;
        try {
            try {
                options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                if (path != null) {
                    BitmapFactory.decodeFile(path, options);
                    fileInputStream = null;
                } else {
                    fileInputStream = new FileInputStream(streamPath);
                    try {
                        fileInputStream.getChannel().position(streamOffset);
                        BitmapFactory.decodeStream(fileInputStream, null, options);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            FileLog.e(th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return null;
                        } finally {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e) {
                                    FileLog.e(e);
                                }
                            }
                        }
                    }
                }
                i = options.outWidth;
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        if (i <= 0 || (i2 = options.outHeight) <= 0) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        }
        if (w > h && i < i2) {
            h = w;
            w = h;
        }
        float fMin = Math.min(i / w, i2 / h);
        options.inSampleSize = 1;
        if (fMin > 1.0f) {
            do {
                i3 = options.inSampleSize * 2;
                options.inSampleSize = i3;
            } while (i3 < fMin);
        }
        options.inJustDecodeBounds = false;
        if (path != null) {
            bitmapDecodeStream = BitmapFactory.decodeFile(path, options);
        } else {
            fileInputStream.getChannel().position(streamOffset);
            bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
        }
        return bitmapDecodeStream;
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        invalidateViews();
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < 3; i++) {
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.fileLoaded);
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.fileLoadFailed);
        }
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        for (int i = 0; i < 3; i++) {
            NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.fileLoaded);
            NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.fileLoadFailed);
        }
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) throws IOException {
        if (id == NotificationCenter.fileLoaded) {
            String str = (String) args[0];
            final File file = (File) args[1];
            final Theme.ThemeInfo themeInfo = this.loadingThemes.get(str);
            if (themeInfo != null) {
                this.loadingThemes.remove(str);
                if (this.loadingWallpapers.remove(themeInfo) != null) {
                    Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Cells.-$$Lambda$ThemesHorizontalListCell$0f0dqFV7y4Ax-kilgoBq_gQlGu8
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$didReceivedNotification$3$ThemesHorizontalListCell(themeInfo, file);
                        }
                    });
                    return;
                } else {
                    lambda$didReceivedNotification$2(themeInfo);
                    return;
                }
            }
            return;
        }
        if (id == NotificationCenter.fileLoadFailed) {
            this.loadingThemes.remove((String) args[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$3$ThemesHorizontalListCell(final Theme.ThemeInfo themeInfo, File file) {
        themeInfo.badWallpaper = !themeInfo.createBackground(file, themeInfo.pathToWallpaper);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Cells.-$$Lambda$ThemesHorizontalListCell$NGXUz2ExFNKrXpAQT5qSk0e4sUI
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.f$0.lambda$didReceivedNotification$2$ThemesHorizontalListCell(themeInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkVisibleTheme, reason: merged with bridge method [inline-methods] */
    public void lambda$didReceivedNotification$2$ThemesHorizontalListCell(Theme.ThemeInfo info) throws IOException {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof InnerThemeView) {
                InnerThemeView innerThemeView = (InnerThemeView) childAt;
                if (innerThemeView.themeInfo == info && innerThemeView.parseTheme()) {
                    innerThemeView.themeInfo.themeLoaded = true;
                    innerThemeView.applyTheme();
                }
            }
        }
    }

    public void scrollToCurrentTheme(int width, boolean animated) {
        View view;
        if (width == 0 && (view = (View) getParent()) != null) {
            width = view.getMeasuredWidth();
        }
        if (width == 0) {
            return;
        }
        Theme.ThemeInfo currentNightTheme = this.currentType == 1 ? Theme.getCurrentNightTheme() : Theme.getCurrentTheme();
        this.prevThemeInfo = currentNightTheme;
        int iIndexOf = this.defaultThemes.indexOf(currentNightTheme);
        if (iIndexOf >= 0 || (iIndexOf = this.darkThemes.indexOf(this.prevThemeInfo) + this.defaultThemes.size()) >= 0) {
            if (animated) {
                smoothScrollToPosition(iIndexOf);
            } else {
                this.horizontalLayoutManager.scrollToPositionWithOffset(iIndexOf, (width - AndroidUtilities.dp(76.0f)) / 2);
            }
        }
    }
}
