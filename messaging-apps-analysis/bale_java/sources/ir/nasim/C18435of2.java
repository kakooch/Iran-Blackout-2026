package ir.nasim;

import android.graphics.PointF;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.of2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C18435of2 {
    private int a;
    private PointF b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private List h;
    private final List i;
    private float j;
    private float k;
    private float l;
    private final float m;

    public C18435of2(int i, PointF pointF, float f, float f2, float f3, float f4, float f5, C9155Ys3[] c9155Ys3Arr, C23939xm1[] c23939xm1Arr, float f6, float f7, float f8, float f9) {
        this.a = i;
        this.b = pointF;
        this.c = f;
        this.d = f2;
        this.e = f3;
        this.f = f4;
        this.g = f5;
        this.h = Arrays.asList(c9155Ys3Arr);
        this.i = Arrays.asList(c23939xm1Arr);
        this.j = c(f6);
        this.k = c(f7);
        this.l = c(f8);
        this.m = c(f9);
    }

    private static float c(float f) {
        if (f < 0.0f || f > 1.0f) {
            return -1.0f;
        }
        return f;
    }

    public int a() {
        return this.a;
    }

    public List b() {
        return this.h;
    }
}
