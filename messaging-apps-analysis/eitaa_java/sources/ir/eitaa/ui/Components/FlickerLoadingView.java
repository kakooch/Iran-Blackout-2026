package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.SystemClock;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.ui.ActionBar.Theme;
import java.util.Random;

/* loaded from: classes3.dex */
public class FlickerLoadingView extends View {
    private Paint backgroundPaint;
    private int color0;
    private int color1;
    private String colorKey1;
    private String colorKey2;
    private String colorKey3;
    private LinearGradient gradient;
    private int gradientWidth;
    private Paint headerPaint;
    private boolean isSingleCell;
    private int itemsCount;
    private long lastUpdateTime;
    private Matrix matrix;
    private int paddingLeft;
    private int paddingTop;
    private Paint paint;
    float[] randomParams;
    private RectF rectF;
    private final Theme.ResourcesProvider resourcesProvider;
    private boolean showDate;
    private int skipDrawItemsCount;
    private int totalTranslation;
    private boolean useHeaderOffset;
    private int viewType;

    public int getColumnsCount() {
        return 2;
    }

    public void setViewType(int type) {
        this.viewType = type;
        if (type == 11) {
            Random random = new Random();
            this.randomParams = new float[2];
            for (int i = 0; i < 2; i++) {
                this.randomParams[i] = Math.abs(random.nextInt() % 1000) / 1000.0f;
            }
        }
        invalidate();
    }

    public void setIsSingleCell(boolean b) {
        this.isSingleCell = b;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setColors(String key1, String key2, String key3) {
        this.colorKey1 = key1;
        this.colorKey2 = key2;
        this.colorKey3 = key3;
        invalidate();
    }

    public FlickerLoadingView(Context context) {
        this(context, null);
    }

    public FlickerLoadingView(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.paint = new Paint();
        this.headerPaint = new Paint();
        this.rectF = new RectF();
        this.showDate = true;
        this.colorKey1 = "windowBackgroundWhite";
        this.colorKey2 = "windowBackgroundGray";
        this.itemsCount = 1;
        this.resourcesProvider = resourcesProvider;
        this.matrix = new Matrix();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.isSingleCell) {
            if (this.itemsCount > 1 && View.MeasureSpec.getSize(heightMeasureSpec) > 0) {
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(heightMeasureSpec), getCellHeight(View.MeasureSpec.getSize(widthMeasureSpec)) * this.itemsCount), 1073741824));
                return;
            } else {
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(getCellHeight(View.MeasureSpec.getSize(widthMeasureSpec)), 1073741824));
                return;
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int themedColor = getThemedColor(this.colorKey1);
        int themedColor2 = getThemedColor(this.colorKey2);
        int i2 = 4;
        int i3 = 0;
        int i4 = 1;
        if (this.color1 != themedColor2 || this.color0 != themedColor) {
            this.color0 = themedColor;
            this.color1 = themedColor2;
            if (this.isSingleCell || (i = this.viewType) == 13 || i == 14) {
                int iDp = AndroidUtilities.dp(200.0f);
                this.gradientWidth = iDp;
                this.gradient = new LinearGradient(0.0f, 0.0f, iDp, 0.0f, new int[]{themedColor2, themedColor, themedColor, themedColor2}, new float[]{0.0f, 0.4f, 0.6f, 1.0f}, Shader.TileMode.CLAMP);
            } else {
                int iDp2 = AndroidUtilities.dp(600.0f);
                this.gradientWidth = iDp2;
                this.gradient = new LinearGradient(0.0f, 0.0f, 0.0f, iDp2, new int[]{themedColor2, themedColor, themedColor, themedColor2}, new float[]{0.0f, 0.4f, 0.6f, 1.0f}, Shader.TileMode.CLAMP);
            }
            this.paint.setShader(this.gradient);
        }
        int cellHeight = this.paddingTop;
        if (this.useHeaderOffset) {
            int iDp3 = cellHeight + AndroidUtilities.dp(32.0f);
            String str = this.colorKey3;
            if (str != null) {
                this.headerPaint.setColor(getThemedColor(str));
            }
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), AndroidUtilities.dp(32.0f), this.colorKey3 != null ? this.headerPaint : this.paint);
            cellHeight = iDp3;
        }
        float f = 16.0f;
        if (getViewType() == 7) {
            while (cellHeight <= getMeasuredHeight()) {
                int cellHeight2 = getCellHeight(getMeasuredWidth());
                canvas.drawCircle(checkRtl(AndroidUtilities.dp(10.0f) + r3), (cellHeight2 >> 1) + cellHeight, AndroidUtilities.dp(28.0f), this.paint);
                this.rectF.set(AndroidUtilities.dp(76.0f), AndroidUtilities.dp(16.0f) + cellHeight, AndroidUtilities.dp(148.0f), cellHeight + AndroidUtilities.dp(24.0f));
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                this.rectF.set(AndroidUtilities.dp(76.0f), AndroidUtilities.dp(38.0f) + cellHeight, AndroidUtilities.dp(268.0f), AndroidUtilities.dp(46.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                if (SharedConfig.useThreeLinesLayout) {
                    this.rectF.set(AndroidUtilities.dp(76.0f), AndroidUtilities.dp(54.0f) + cellHeight, AndroidUtilities.dp(220.0f), AndroidUtilities.dp(62.0f) + cellHeight);
                    checkRtl(this.rectF);
                    canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                }
                if (this.showDate) {
                    this.rectF.set(getMeasuredWidth() - AndroidUtilities.dp(50.0f), AndroidUtilities.dp(16.0f) + cellHeight, getMeasuredWidth() - AndroidUtilities.dp(12.0f), AndroidUtilities.dp(24.0f) + cellHeight);
                    checkRtl(this.rectF);
                    canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                }
                cellHeight += getCellHeight(getMeasuredWidth());
                i3++;
                if (this.isSingleCell && i3 >= this.itemsCount) {
                    break;
                }
            }
        } else if (getViewType() == 1) {
            while (cellHeight <= getMeasuredHeight()) {
                canvas.drawCircle(checkRtl(AndroidUtilities.dp(9.0f) + r2), (AndroidUtilities.dp(78.0f) >> 1) + cellHeight, AndroidUtilities.dp(25.0f), this.paint);
                this.rectF.set(AndroidUtilities.dp(68.0f), AndroidUtilities.dp(20.0f) + cellHeight, AndroidUtilities.dp(140.0f), AndroidUtilities.dp(28.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                this.rectF.set(AndroidUtilities.dp(68.0f), AndroidUtilities.dp(42.0f) + cellHeight, AndroidUtilities.dp(260.0f), AndroidUtilities.dp(50.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                if (this.showDate) {
                    this.rectF.set(getMeasuredWidth() - AndroidUtilities.dp(50.0f), AndroidUtilities.dp(20.0f) + cellHeight, getMeasuredWidth() - AndroidUtilities.dp(12.0f), AndroidUtilities.dp(28.0f) + cellHeight);
                    checkRtl(this.rectF);
                    canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                }
                cellHeight += getCellHeight(getMeasuredWidth());
                i3++;
                if (this.isSingleCell && i3 >= this.itemsCount) {
                    break;
                }
            }
        } else if (getViewType() == 2) {
            int measuredWidth = (getMeasuredWidth() - (AndroidUtilities.dp(2.0f) * (getColumnsCount() - 1))) / getColumnsCount();
            int iDp4 = cellHeight;
            int i5 = 0;
            while (true) {
                if (iDp4 >= getMeasuredHeight() && !this.isSingleCell) {
                    break;
                }
                for (int i6 = 0; i6 < getColumnsCount(); i6++) {
                    if (i5 != 0 || i6 >= this.skipDrawItemsCount) {
                        canvas.drawRect((measuredWidth + AndroidUtilities.dp(2.0f)) * i6, iDp4, r1 + measuredWidth, iDp4 + measuredWidth, this.paint);
                    }
                }
                iDp4 += measuredWidth + AndroidUtilities.dp(2.0f);
                i5++;
                if (this.isSingleCell && i5 >= 2) {
                    break;
                }
            }
        } else if (getViewType() == 3) {
            while (cellHeight <= getMeasuredHeight()) {
                this.rectF.set(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(8.0f) + cellHeight, AndroidUtilities.dp(52.0f), AndroidUtilities.dp(48.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                this.rectF.set(AndroidUtilities.dp(68.0f), AndroidUtilities.dp(12.0f) + cellHeight, AndroidUtilities.dp(140.0f), AndroidUtilities.dp(20.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                this.rectF.set(AndroidUtilities.dp(68.0f), AndroidUtilities.dp(34.0f) + cellHeight, AndroidUtilities.dp(260.0f), AndroidUtilities.dp(42.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                if (this.showDate) {
                    this.rectF.set(getMeasuredWidth() - AndroidUtilities.dp(50.0f), AndroidUtilities.dp(12.0f) + cellHeight, getMeasuredWidth() - AndroidUtilities.dp(12.0f), AndroidUtilities.dp(20.0f) + cellHeight);
                    checkRtl(this.rectF);
                    canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                }
                cellHeight += getCellHeight(getMeasuredWidth());
                i3++;
                if (this.isSingleCell && i3 >= this.itemsCount) {
                    break;
                }
            }
        } else if (getViewType() == 4) {
            while (cellHeight <= getMeasuredHeight()) {
                canvas.drawCircle(checkRtl(AndroidUtilities.dp(12.0f) + r2), AndroidUtilities.dp(6.0f) + cellHeight + r2, AndroidUtilities.dp(44.0f) >> 1, this.paint);
                this.rectF.set(AndroidUtilities.dp(68.0f), AndroidUtilities.dp(12.0f) + cellHeight, AndroidUtilities.dp(140.0f), AndroidUtilities.dp(20.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                this.rectF.set(AndroidUtilities.dp(68.0f), AndroidUtilities.dp(34.0f) + cellHeight, AndroidUtilities.dp(260.0f), AndroidUtilities.dp(42.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                if (this.showDate) {
                    this.rectF.set(getMeasuredWidth() - AndroidUtilities.dp(50.0f), AndroidUtilities.dp(12.0f) + cellHeight, getMeasuredWidth() - AndroidUtilities.dp(12.0f), AndroidUtilities.dp(20.0f) + cellHeight);
                    checkRtl(this.rectF);
                    canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                }
                cellHeight += getCellHeight(getMeasuredWidth());
                i3++;
                if (this.isSingleCell && i3 >= this.itemsCount) {
                    break;
                }
            }
        } else if (getViewType() == 5) {
            while (cellHeight <= getMeasuredHeight()) {
                this.rectF.set(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(11.0f) + cellHeight, AndroidUtilities.dp(62.0f), AndroidUtilities.dp(63.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                this.rectF.set(AndroidUtilities.dp(68.0f), AndroidUtilities.dp(12.0f) + cellHeight, AndroidUtilities.dp(140.0f), AndroidUtilities.dp(20.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                this.rectF.set(AndroidUtilities.dp(68.0f), AndroidUtilities.dp(34.0f) + cellHeight, AndroidUtilities.dp(268.0f), AndroidUtilities.dp(42.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                this.rectF.set(AndroidUtilities.dp(68.0f), AndroidUtilities.dp(54.0f) + cellHeight, AndroidUtilities.dp(188.0f), AndroidUtilities.dp(62.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                if (this.showDate) {
                    this.rectF.set(getMeasuredWidth() - AndroidUtilities.dp(50.0f), AndroidUtilities.dp(12.0f) + cellHeight, getMeasuredWidth() - AndroidUtilities.dp(12.0f), AndroidUtilities.dp(20.0f) + cellHeight);
                    checkRtl(this.rectF);
                    canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                }
                cellHeight += getCellHeight(getMeasuredWidth());
                i3++;
                if (this.isSingleCell && i3 >= this.itemsCount) {
                    break;
                }
            }
        } else if (getViewType() == 6 || getViewType() == 10) {
            while (cellHeight <= getMeasuredHeight()) {
                canvas.drawCircle(checkRtl(this.paddingLeft + AndroidUtilities.dp(9.0f) + r2), (AndroidUtilities.dp(64.0f) >> 1) + cellHeight, AndroidUtilities.dp(23.0f), this.paint);
                this.rectF.set(this.paddingLeft + AndroidUtilities.dp(68.0f), AndroidUtilities.dp(17.0f) + cellHeight, this.paddingLeft + AndroidUtilities.dp(260.0f), AndroidUtilities.dp(25.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                this.rectF.set(this.paddingLeft + AndroidUtilities.dp(68.0f), AndroidUtilities.dp(39.0f) + cellHeight, this.paddingLeft + AndroidUtilities.dp(140.0f), AndroidUtilities.dp(47.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                if (this.showDate) {
                    this.rectF.set(getMeasuredWidth() - AndroidUtilities.dp(50.0f), AndroidUtilities.dp(20.0f) + cellHeight, getMeasuredWidth() - AndroidUtilities.dp(12.0f), AndroidUtilities.dp(28.0f) + cellHeight);
                    checkRtl(this.rectF);
                    canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                }
                cellHeight += getCellHeight(getMeasuredWidth());
                i3++;
                if (this.isSingleCell && i3 >= this.itemsCount) {
                    break;
                }
            }
        } else if (getViewType() == 8) {
            while (cellHeight <= getMeasuredHeight()) {
                canvas.drawCircle(checkRtl(this.paddingLeft + AndroidUtilities.dp(11.0f) + r2), (AndroidUtilities.dp(64.0f) >> 1) + cellHeight, AndroidUtilities.dp(23.0f), this.paint);
                this.rectF.set(this.paddingLeft + AndroidUtilities.dp(68.0f), AndroidUtilities.dp(17.0f) + cellHeight, this.paddingLeft + AndroidUtilities.dp(140.0f), AndroidUtilities.dp(25.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                this.rectF.set(this.paddingLeft + AndroidUtilities.dp(68.0f), AndroidUtilities.dp(39.0f) + cellHeight, this.paddingLeft + AndroidUtilities.dp(260.0f), AndroidUtilities.dp(47.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                if (this.showDate) {
                    this.rectF.set(getMeasuredWidth() - AndroidUtilities.dp(50.0f), AndroidUtilities.dp(20.0f) + cellHeight, getMeasuredWidth() - AndroidUtilities.dp(12.0f), AndroidUtilities.dp(28.0f) + cellHeight);
                    checkRtl(this.rectF);
                    canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                }
                cellHeight += getCellHeight(getMeasuredWidth());
                i3++;
                if (this.isSingleCell && i3 >= this.itemsCount) {
                    break;
                }
            }
        } else if (getViewType() == 9) {
            while (cellHeight <= getMeasuredHeight()) {
                canvas.drawCircle(checkRtl(AndroidUtilities.dp(35.0f)), (getCellHeight(getMeasuredWidth()) >> 1) + cellHeight, AndroidUtilities.dp(32.0f) / 2, this.paint);
                this.rectF.set(AndroidUtilities.dp(72.0f), AndroidUtilities.dp(16.0f) + cellHeight, AndroidUtilities.dp(268.0f), AndroidUtilities.dp(24.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                this.rectF.set(AndroidUtilities.dp(72.0f), AndroidUtilities.dp(38.0f) + cellHeight, AndroidUtilities.dp(140.0f), AndroidUtilities.dp(46.0f) + cellHeight);
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                if (this.showDate) {
                    this.rectF.set(getMeasuredWidth() - AndroidUtilities.dp(50.0f), AndroidUtilities.dp(16.0f) + cellHeight, getMeasuredWidth() - AndroidUtilities.dp(12.0f), AndroidUtilities.dp(24.0f) + cellHeight);
                    checkRtl(this.rectF);
                    canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                }
                cellHeight += getCellHeight(getMeasuredWidth());
                i3++;
                if (this.isSingleCell && i3 >= this.itemsCount) {
                    break;
                }
            }
        } else if (getViewType() == 11) {
            int i7 = 0;
            while (cellHeight <= getMeasuredHeight()) {
                this.rectF.set(AndroidUtilities.dp(18.0f), AndroidUtilities.dp(14.0f), (getMeasuredWidth() * 0.5f) + AndroidUtilities.dp(this.randomParams[0] * 40.0f), AndroidUtilities.dp(14.0f) + AndroidUtilities.dp(8.0f));
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                this.rectF.set(getMeasuredWidth() - AndroidUtilities.dp(18.0f), AndroidUtilities.dp(14.0f), (getMeasuredWidth() - (getMeasuredWidth() * 0.2f)) - AndroidUtilities.dp(this.randomParams[0] * 20.0f), AndroidUtilities.dp(14.0f) + AndroidUtilities.dp(8.0f));
                checkRtl(this.rectF);
                canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                cellHeight += getCellHeight(getMeasuredWidth());
                i7++;
                if (this.isSingleCell && i7 >= this.itemsCount) {
                    break;
                }
            }
        } else if (getViewType() == 12) {
            int iDp5 = cellHeight + AndroidUtilities.dp(14.0f);
            while (iDp5 <= getMeasuredHeight()) {
                int measuredWidth2 = getMeasuredWidth() / i2;
                int i8 = 0;
                while (i8 < i2) {
                    float f2 = (measuredWidth2 * i8) + (measuredWidth2 / 2.0f);
                    canvas.drawCircle(f2, AndroidUtilities.dp(7.0f) + iDp5 + (AndroidUtilities.dp(56.0f) / 2.0f), AndroidUtilities.dp(28.0f), this.paint);
                    float fDp = AndroidUtilities.dp(7.0f) + iDp5 + AndroidUtilities.dp(56.0f) + AndroidUtilities.dp(f);
                    RectF rectF = AndroidUtilities.rectTmp;
                    rectF.set(f2 - AndroidUtilities.dp(24.0f), fDp - AndroidUtilities.dp(4.0f), f2 + AndroidUtilities.dp(24.0f), fDp + AndroidUtilities.dp(4.0f));
                    canvas.drawRoundRect(rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
                    i8++;
                    f = 16.0f;
                    i2 = 4;
                }
                iDp5 += getCellHeight(getMeasuredWidth());
                if (this.isSingleCell) {
                    break;
                }
                f = 16.0f;
                i2 = 4;
            }
        } else if (getViewType() == 13) {
            float measuredHeight = getMeasuredHeight() / 2.0f;
            RectF rectF2 = AndroidUtilities.rectTmp;
            rectF2.set(AndroidUtilities.dp(40.0f), measuredHeight - AndroidUtilities.dp(4.0f), getMeasuredWidth() - AndroidUtilities.dp(120.0f), AndroidUtilities.dp(4.0f) + measuredHeight);
            canvas.drawRoundRect(rectF2, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.paint);
            if (this.backgroundPaint == null) {
                Paint paint = new Paint(1);
                this.backgroundPaint = paint;
                paint.setColor(Theme.getColor("actionBarDefaultSubmenuBackground"));
            }
            while (i3 < 3) {
                canvas.drawCircle((getMeasuredWidth() - AndroidUtilities.dp(56.0f)) + AndroidUtilities.dp(13.0f) + (AndroidUtilities.dp(12.0f) * i3), measuredHeight, AndroidUtilities.dp(13.0f), this.backgroundPaint);
                canvas.drawCircle((getMeasuredWidth() - AndroidUtilities.dp(56.0f)) + AndroidUtilities.dp(13.0f) + (AndroidUtilities.dp(12.0f) * i3), measuredHeight, AndroidUtilities.dp(12.0f), this.paint);
                i3++;
            }
        } else if (getViewType() == 14) {
            int iDp6 = AndroidUtilities.dp(12.0f);
            int iDp7 = AndroidUtilities.dp(77.0f);
            int iDp8 = AndroidUtilities.dp(4.0f);
            float fDp2 = AndroidUtilities.dp(21.0f);
            float fDp3 = AndroidUtilities.dp(41.0f);
            while (iDp6 < getMeasuredWidth()) {
                if (this.backgroundPaint == null) {
                    Paint paint2 = new Paint(i4);
                    this.backgroundPaint = paint2;
                    paint2.setColor(Theme.getColor("dialogBackground"));
                }
                float fDp4 = AndroidUtilities.dp(8.0f) + iDp8;
                float fDp5 = AndroidUtilities.dp(22.0f) + iDp8;
                RectF rectF3 = AndroidUtilities.rectTmp;
                rectF3.set(AndroidUtilities.dp(4.0f) + iDp6, AndroidUtilities.dp(4.0f), r15 - AndroidUtilities.dp(4.0f), getMeasuredHeight() - AndroidUtilities.dp(4.0f));
                canvas.drawRoundRect(rectF3, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), this.paint);
                float f3 = iDp6;
                float f4 = fDp5 + f3;
                this.rectF.set(f4, fDp4, f4 + fDp3, fDp4 + fDp2);
                RectF rectF4 = this.rectF;
                canvas.drawRoundRect(rectF4, rectF4.height() * 0.5f, this.rectF.height() * 0.5f, this.backgroundPaint);
                float fDp6 = fDp4 + AndroidUtilities.dp(4.0f) + fDp2;
                float fDp7 = f3 + AndroidUtilities.dp(5.0f) + iDp8;
                this.rectF.set(fDp7, fDp6, fDp7 + fDp3, fDp6 + fDp2);
                RectF rectF5 = this.rectF;
                canvas.drawRoundRect(rectF5, rectF5.height() * 0.5f, this.rectF.height() * 0.5f, this.backgroundPaint);
                canvas.drawCircle(iDp6 + (iDp7 / 2), getMeasuredHeight() - AndroidUtilities.dp(20.0f), AndroidUtilities.dp(8.0f), this.backgroundPaint);
                iDp6 += iDp7;
                i4 = 1;
            }
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jAbs = Math.abs(this.lastUpdateTime - jElapsedRealtime);
        if (jAbs > 17) {
            jAbs = 16;
        }
        this.lastUpdateTime = jElapsedRealtime;
        if (this.isSingleCell || this.viewType == 13 || getViewType() == 14) {
            int measuredWidth3 = (int) (this.totalTranslation + ((jAbs * getMeasuredWidth()) / 400.0f));
            this.totalTranslation = measuredWidth3;
            if (measuredWidth3 >= getMeasuredWidth() * 2) {
                this.totalTranslation = (-this.gradientWidth) * 2;
            }
            this.matrix.setTranslate(this.totalTranslation, 0.0f);
        } else {
            int measuredHeight2 = (int) (this.totalTranslation + ((jAbs * getMeasuredHeight()) / 400.0f));
            this.totalTranslation = measuredHeight2;
            if (measuredHeight2 >= getMeasuredHeight() * 2) {
                this.totalTranslation = (-this.gradientWidth) * 2;
            }
            this.matrix.setTranslate(0.0f, this.totalTranslation);
        }
        this.gradient.setLocalMatrix(this.matrix);
        invalidate();
    }

    private float checkRtl(float x) {
        return LocaleController.isRTL ? getMeasuredWidth() - x : x;
    }

    private void checkRtl(RectF rectF) {
        if (LocaleController.isRTL) {
            rectF.left = getMeasuredWidth() - rectF.left;
            rectF.right = getMeasuredWidth() - rectF.right;
        }
    }

    private int getCellHeight(int width) {
        if (getViewType() == 7) {
            return AndroidUtilities.dp((SharedConfig.useThreeLinesLayout ? 78 : 72) + 1);
        }
        if (getViewType() == 1) {
            return AndroidUtilities.dp(78.0f) + 1;
        }
        if (getViewType() == 2) {
            return ((width - (AndroidUtilities.dp(2.0f) * (getColumnsCount() - 1))) / getColumnsCount()) + AndroidUtilities.dp(2.0f);
        }
        if (getViewType() == 3) {
            return AndroidUtilities.dp(56.0f) + 1;
        }
        if (getViewType() == 4) {
            return AndroidUtilities.dp(56.0f) + 1;
        }
        if (getViewType() == 5) {
            return AndroidUtilities.dp(80.0f);
        }
        if (getViewType() == 6) {
            return AndroidUtilities.dp(64.0f);
        }
        if (getViewType() == 9) {
            return AndroidUtilities.dp(66.0f);
        }
        if (getViewType() == 10) {
            return AndroidUtilities.dp(58.0f);
        }
        if (getViewType() == 8) {
            return AndroidUtilities.dp(61.0f);
        }
        if (getViewType() == 11) {
            return AndroidUtilities.dp(36.0f);
        }
        if (getViewType() == 12) {
            return AndroidUtilities.dp(103.0f);
        }
        return 0;
    }

    public void showDate(boolean showDate) {
        this.showDate = showDate;
    }

    public void setUseHeaderOffset(boolean useHeaderOffset) {
        this.useHeaderOffset = useHeaderOffset;
    }

    public void skipDrawItemsCount(int i) {
        this.skipDrawItemsCount = i;
    }

    public void setPaddingTop(int t) {
        this.paddingTop = t;
        invalidate();
    }

    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        invalidate();
    }

    public void setItemsCount(int i) {
        this.itemsCount = i;
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
