package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class Legend extends ComponentBase {
    private LegendEntry[] a;
    private LegendEntry[] b;
    private boolean c;
    private LegendHorizontalAlignment d;
    private LegendVerticalAlignment e;
    private LegendOrientation f;
    private boolean g;
    private LegendDirection h;
    private LegendForm i;
    private float j;
    private float k;
    private DashPathEffect l;
    private float m;
    public float mNeededHeight;
    public float mNeededWidth;
    public float mTextHeightMax;
    public float mTextWidthMax;
    private float n;
    private float o;
    private float p;
    private float q;
    private boolean r;
    private List s;
    private List t;
    private List u;

    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LegendOrientation.values().length];
            a = iArr;
            try {
                iArr[LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public Legend() {
        this.a = new LegendEntry[0];
        this.c = false;
        this.d = LegendHorizontalAlignment.LEFT;
        this.e = LegendVerticalAlignment.BOTTOM;
        this.f = LegendOrientation.HORIZONTAL;
        this.g = false;
        this.h = LegendDirection.LEFT_TO_RIGHT;
        this.i = LegendForm.SQUARE;
        this.j = 8.0f;
        this.k = 3.0f;
        this.l = null;
        this.m = 6.0f;
        this.n = 0.0f;
        this.o = 5.0f;
        this.p = 3.0f;
        this.q = 0.95f;
        this.mNeededWidth = 0.0f;
        this.mNeededHeight = 0.0f;
        this.mTextHeightMax = 0.0f;
        this.mTextWidthMax = 0.0f;
        this.r = false;
        this.s = new ArrayList(16);
        this.t = new ArrayList(16);
        this.u = new ArrayList(16);
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(3.0f);
    }

    public void calculateDimensions(Paint paint, ViewPortHandler viewPortHandler) {
        float f;
        float f2;
        float f3;
        float fConvertDpToPixel = Utils.convertDpToPixel(this.j);
        float fConvertDpToPixel2 = Utils.convertDpToPixel(this.p);
        float fConvertDpToPixel3 = Utils.convertDpToPixel(this.o);
        float fConvertDpToPixel4 = Utils.convertDpToPixel(this.m);
        float fConvertDpToPixel5 = Utils.convertDpToPixel(this.n);
        boolean z = this.r;
        LegendEntry[] legendEntryArr = this.a;
        int length = legendEntryArr.length;
        this.mTextWidthMax = getMaximumEntryWidth(paint);
        this.mTextHeightMax = getMaximumEntryHeight(paint);
        int i = a.a[this.f.ordinal()];
        if (i == 1) {
            float lineHeight = Utils.getLineHeight(paint);
            float fMax = 0.0f;
            float f4 = 0.0f;
            float fCalcTextWidth = 0.0f;
            boolean z2 = false;
            for (int i2 = 0; i2 < length; i2++) {
                LegendEntry legendEntry = legendEntryArr[i2];
                boolean z3 = legendEntry.form != LegendForm.NONE;
                float fConvertDpToPixel6 = Float.isNaN(legendEntry.formSize) ? fConvertDpToPixel : Utils.convertDpToPixel(legendEntry.formSize);
                String str = legendEntry.label;
                if (!z2) {
                    fCalcTextWidth = 0.0f;
                }
                if (z3) {
                    if (z2) {
                        fCalcTextWidth += fConvertDpToPixel2;
                    }
                    fCalcTextWidth += fConvertDpToPixel6;
                }
                if (str != null) {
                    if (z3 && !z2) {
                        fCalcTextWidth += fConvertDpToPixel3;
                    } else if (z2) {
                        fMax = Math.max(fMax, fCalcTextWidth);
                        f4 += lineHeight + fConvertDpToPixel5;
                        fCalcTextWidth = 0.0f;
                        z2 = false;
                    }
                    fCalcTextWidth += Utils.calcTextWidth(paint, str);
                    if (i2 < length - 1) {
                        f4 += lineHeight + fConvertDpToPixel5;
                    }
                } else {
                    fCalcTextWidth += fConvertDpToPixel6;
                    if (i2 < length - 1) {
                        fCalcTextWidth += fConvertDpToPixel2;
                    }
                    z2 = true;
                }
                fMax = Math.max(fMax, fCalcTextWidth);
            }
            this.mNeededWidth = fMax;
            this.mNeededHeight = f4;
        } else if (i == 2) {
            float lineHeight2 = Utils.getLineHeight(paint);
            float lineSpacing = Utils.getLineSpacing(paint) + fConvertDpToPixel5;
            float fContentWidth = viewPortHandler.contentWidth() * this.q;
            this.t.clear();
            this.s.clear();
            this.u.clear();
            int i3 = 0;
            float fMax2 = 0.0f;
            int i4 = -1;
            float f5 = 0.0f;
            float f6 = 0.0f;
            while (i3 < length) {
                LegendEntry legendEntry2 = legendEntryArr[i3];
                float f7 = fConvertDpToPixel;
                float f8 = fConvertDpToPixel4;
                boolean z4 = legendEntry2.form != LegendForm.NONE;
                float fConvertDpToPixel7 = Float.isNaN(legendEntry2.formSize) ? f7 : Utils.convertDpToPixel(legendEntry2.formSize);
                String str2 = legendEntry2.label;
                LegendEntry[] legendEntryArr2 = legendEntryArr;
                float f9 = lineSpacing;
                this.t.add(Boolean.FALSE);
                float f10 = i4 == -1 ? 0.0f : f5 + fConvertDpToPixel2;
                if (str2 != null) {
                    f = fConvertDpToPixel2;
                    this.s.add(Utils.calcTextSize(paint, str2));
                    f2 = f10 + (z4 ? fConvertDpToPixel3 + fConvertDpToPixel7 : 0.0f) + ((FSize) this.s.get(i3)).width;
                } else {
                    f = fConvertDpToPixel2;
                    float f11 = fConvertDpToPixel7;
                    this.s.add(FSize.getInstance(0.0f, 0.0f));
                    f2 = f10 + (z4 ? f11 : 0.0f);
                    if (i4 == -1) {
                        i4 = i3;
                    }
                }
                if (str2 != null || i3 == length - 1) {
                    float f12 = f6;
                    float f13 = f12 == 0.0f ? 0.0f : f8;
                    if (!z || f12 == 0.0f || fContentWidth - f12 >= f13 + f2) {
                        f3 = f12 + f13 + f2;
                    } else {
                        this.u.add(FSize.getInstance(f12, lineHeight2));
                        fMax2 = Math.max(fMax2, f12);
                        this.t.set(i4 > -1 ? i4 : i3, Boolean.TRUE);
                        f3 = f2;
                    }
                    if (i3 == length - 1) {
                        this.u.add(FSize.getInstance(f3, lineHeight2));
                        fMax2 = Math.max(fMax2, f3);
                    }
                    f6 = f3;
                }
                if (str2 != null) {
                    i4 = -1;
                }
                i3++;
                fConvertDpToPixel2 = f;
                fConvertDpToPixel = f7;
                fConvertDpToPixel4 = f8;
                lineSpacing = f9;
                f5 = f2;
                legendEntryArr = legendEntryArr2;
            }
            float f14 = lineSpacing;
            this.mNeededWidth = fMax2;
            this.mNeededHeight = (lineHeight2 * this.u.size()) + (f14 * (this.u.size() == 0 ? 0 : this.u.size() - 1));
        }
        this.mNeededHeight += this.mYOffset;
        this.mNeededWidth += this.mXOffset;
    }

    public List<Boolean> getCalculatedLabelBreakPoints() {
        return this.t;
    }

    public List<FSize> getCalculatedLabelSizes() {
        return this.s;
    }

    public List<FSize> getCalculatedLineSizes() {
        return this.u;
    }

    public LegendDirection getDirection() {
        return this.h;
    }

    public LegendEntry[] getEntries() {
        return this.a;
    }

    public LegendEntry[] getExtraEntries() {
        return this.b;
    }

    public LegendForm getForm() {
        return this.i;
    }

    public DashPathEffect getFormLineDashEffect() {
        return this.l;
    }

    public float getFormLineWidth() {
        return this.k;
    }

    public float getFormSize() {
        return this.j;
    }

    public float getFormToTextSpace() {
        return this.o;
    }

    public LegendHorizontalAlignment getHorizontalAlignment() {
        return this.d;
    }

    public float getMaxSizePercent() {
        return this.q;
    }

    public float getMaximumEntryHeight(Paint paint) {
        float f = 0.0f;
        for (LegendEntry legendEntry : this.a) {
            String str = legendEntry.label;
            if (str != null) {
                float fCalcTextHeight = Utils.calcTextHeight(paint, str);
                if (fCalcTextHeight > f) {
                    f = fCalcTextHeight;
                }
            }
        }
        return f;
    }

    public float getMaximumEntryWidth(Paint paint) {
        float fConvertDpToPixel = Utils.convertDpToPixel(this.o);
        float f = 0.0f;
        float f2 = 0.0f;
        for (LegendEntry legendEntry : this.a) {
            float fConvertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? this.j : legendEntry.formSize);
            if (fConvertDpToPixel2 > f2) {
                f2 = fConvertDpToPixel2;
            }
            String str = legendEntry.label;
            if (str != null) {
                float fCalcTextWidth = Utils.calcTextWidth(paint, str);
                if (fCalcTextWidth > f) {
                    f = fCalcTextWidth;
                }
            }
        }
        return f + f2 + fConvertDpToPixel;
    }

    public LegendOrientation getOrientation() {
        return this.f;
    }

    public float getStackSpace() {
        return this.p;
    }

    public LegendVerticalAlignment getVerticalAlignment() {
        return this.e;
    }

    public float getXEntrySpace() {
        return this.m;
    }

    public float getYEntrySpace() {
        return this.n;
    }

    public boolean isDrawInsideEnabled() {
        return this.g;
    }

    public boolean isLegendCustom() {
        return this.c;
    }

    public boolean isWordWrapEnabled() {
        return this.r;
    }

    public void resetCustom() {
        this.c = false;
    }

    public void setCustom(LegendEntry[] legendEntryArr) {
        this.a = legendEntryArr;
        this.c = true;
    }

    public void setDirection(LegendDirection legendDirection) {
        this.h = legendDirection;
    }

    public void setDrawInside(boolean z) {
        this.g = z;
    }

    public void setEntries(List<LegendEntry> list) {
        this.a = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void setExtra(List<LegendEntry> list) {
        this.b = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void setForm(LegendForm legendForm) {
        this.i = legendForm;
    }

    public void setFormLineDashEffect(DashPathEffect dashPathEffect) {
        this.l = dashPathEffect;
    }

    public void setFormLineWidth(float f) {
        this.k = f;
    }

    public void setFormSize(float f) {
        this.j = f;
    }

    public void setFormToTextSpace(float f) {
        this.o = f;
    }

    public void setHorizontalAlignment(LegendHorizontalAlignment legendHorizontalAlignment) {
        this.d = legendHorizontalAlignment;
    }

    public void setMaxSizePercent(float f) {
        this.q = f;
    }

    public void setOrientation(LegendOrientation legendOrientation) {
        this.f = legendOrientation;
    }

    public void setStackSpace(float f) {
        this.p = f;
    }

    public void setVerticalAlignment(LegendVerticalAlignment legendVerticalAlignment) {
        this.e = legendVerticalAlignment;
    }

    public void setWordWrapEnabled(boolean z) {
        this.r = z;
    }

    public void setXEntrySpace(float f) {
        this.m = f;
    }

    public void setYEntrySpace(float f) {
        this.n = f;
    }

    public void setExtra(LegendEntry[] legendEntryArr) {
        if (legendEntryArr == null) {
            legendEntryArr = new LegendEntry[0];
        }
        this.b = legendEntryArr;
    }

    public void setCustom(List<LegendEntry> list) {
        this.a = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
        this.c = true;
    }

    public void setExtra(int[] iArr, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < Math.min(iArr.length, strArr.length); i++) {
            LegendEntry legendEntry = new LegendEntry();
            int i2 = iArr[i];
            legendEntry.formColor = i2;
            legendEntry.label = strArr[i];
            if (i2 == 1122868 || i2 == 0) {
                legendEntry.form = LegendForm.NONE;
            } else if (i2 == 1122867) {
                legendEntry.form = LegendForm.EMPTY;
            }
            arrayList.add(legendEntry);
        }
        this.b = (LegendEntry[]) arrayList.toArray(new LegendEntry[arrayList.size()]);
    }

    public Legend(LegendEntry[] legendEntryArr) {
        this();
        if (legendEntryArr != null) {
            this.a = legendEntryArr;
            return;
        }
        throw new IllegalArgumentException("entries array is NULL");
    }
}
