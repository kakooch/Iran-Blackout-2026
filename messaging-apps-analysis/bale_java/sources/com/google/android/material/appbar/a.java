package com.google.android.material.appbar;

import android.view.View;
import ir.nasim.AbstractC12990fW7;

/* loaded from: classes3.dex */
class a {
    private final View a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f = true;
    private boolean g = true;

    public a(View view) {
        this.a = view;
    }

    void a() {
        View view = this.a;
        AbstractC12990fW7.a0(view, this.d - (view.getTop() - this.b));
        View view2 = this.a;
        AbstractC12990fW7.Z(view2, this.e - (view2.getLeft() - this.c));
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.d;
    }

    void d() {
        this.b = this.a.getTop();
        this.c = this.a.getLeft();
    }

    public boolean e(int i) {
        if (!this.g || this.e == i) {
            return false;
        }
        this.e = i;
        a();
        return true;
    }

    public boolean f(int i) {
        if (!this.f || this.d == i) {
            return false;
        }
        this.d = i;
        a();
        return true;
    }
}
