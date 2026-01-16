package ir.nasim;

import android.graphics.CornerPathEffect;
import android.graphics.Path;
import android.os.Build;
import android.text.Layout;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* renamed from: ir.nasim.nA3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C17561nA3 extends Path {
    private static CornerPathEffect l;
    private static int m;
    private Layout a;
    private int b;
    private float d;
    private float e;
    private boolean f;
    private int h;
    private int i;
    public float j;
    public float k;
    private float c = -1.0f;
    private boolean g = true;

    public C17561nA3(boolean z) {
        this.f = z;
    }

    public static int a() {
        return AbstractC21455b.F(5.0f);
    }

    public static CornerPathEffect b() {
        if (l == null || m != a()) {
            int iA = a();
            m = iA;
            l = new CornerPathEffect(iA);
        }
        return l;
    }

    @Override // android.graphics.Path
    public void addRect(float f, float f2, float f3, float f4, Path.Direction direction) {
        Layout layout = this.a;
        if (layout == null) {
            super.addRect(f, f2, f3, f4, direction);
            return;
        }
        try {
            float f5 = this.e;
            float f6 = f2 + f5;
            float spacingAdd = f5 + f4;
            float f7 = this.c;
            if (f7 == -1.0f) {
                this.c = f6;
            } else if (f7 != f6) {
                this.c = f6;
                this.b++;
            }
            float lineRight = layout.getLineRight(this.b);
            float lineLeft = this.a.getLineLeft(this.b);
            if (f < lineRight) {
                if (f > lineLeft || f3 > lineLeft) {
                    if (f3 <= lineRight) {
                        lineRight = f3;
                    }
                    if (f >= lineLeft) {
                        lineLeft = f;
                    }
                    float f8 = this.d;
                    float f9 = lineLeft + f8;
                    float f10 = f8 + lineRight;
                    if (Build.VERSION.SDK_INT < 28) {
                        spacingAdd -= spacingAdd != ((float) this.a.getHeight()) ? this.a.getSpacingAdd() : 0.0f;
                    } else if (spacingAdd - f6 > this.i) {
                        spacingAdd = this.e + (spacingAdd != ((float) this.a.getHeight()) ? this.a.getLineBottom(this.b) - this.a.getSpacingAdd() : 0.0f);
                    }
                    int i = this.h;
                    if (i < 0) {
                        spacingAdd += i;
                    } else if (i > 0) {
                        f6 += i;
                    }
                    float f11 = spacingAdd;
                    this.j = (f10 + f9) / 2.0f;
                    this.k = (f11 + f6) / 2.0f;
                    if (this.f && ir.nasim.tgwidgets.editor.messenger.v.e(33248)) {
                        super.addRect(f9 - (a() / 2.0f), f6, f10 + (a() / 2.0f), f11, direction);
                    } else {
                        super.addRect(f9, f6, f10, f11, direction);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void c(Layout layout, int i, float f) {
        d(layout, i, 0.0f, f);
    }

    public void d(Layout layout, int i, float f, float f2) {
        int lineCount;
        if (layout == null) {
            this.a = null;
            this.b = 0;
            this.c = -1.0f;
            this.d = f;
            this.e = f2;
            return;
        }
        this.a = layout;
        this.b = layout.getLineForOffset(i);
        this.c = -1.0f;
        this.d = f;
        this.e = f2;
        if (Build.VERSION.SDK_INT < 28 || (lineCount = layout.getLineCount()) <= 0) {
            return;
        }
        int i2 = lineCount - 1;
        this.i = layout.getLineBottom(i2) - layout.getLineTop(i2);
    }

    @Override // android.graphics.Path
    public void reset() {
        if (this.g) {
            super.reset();
        }
    }
}
