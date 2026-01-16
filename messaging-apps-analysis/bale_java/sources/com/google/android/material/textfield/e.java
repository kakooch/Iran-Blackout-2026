package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes3.dex */
abstract class e {
    TextInputLayout a;
    Context b;
    CheckableImageButton c;
    final int d;

    e(TextInputLayout textInputLayout, int i) {
        this.a = textInputLayout;
        this.b = textInputLayout.getContext();
        this.c = textInputLayout.getEndIconView();
        this.d = i;
    }

    abstract void a();

    boolean b(int i) {
        return true;
    }

    void c(boolean z) {
    }

    boolean d() {
        return false;
    }
}
