package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: classes3.dex */
abstract class f {
    a a;
    protected e b;

    public f(a aVar) {
        this.a = aVar;
    }

    abstract void a(Canvas canvas, float f);

    abstract void b(Canvas canvas, Paint paint, float f, float f2, int i);

    abstract void c(Canvas canvas, Paint paint);

    abstract int d();

    abstract int e();

    protected void f(e eVar) {
        this.b = eVar;
    }

    void g(Canvas canvas, float f) {
        this.a.e();
        a(canvas, f);
    }
}
