package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.C;
import ir.nasim.GE5;

/* loaded from: classes3.dex */
public class TabItem extends View {
    public final CharSequence a;
    public final Drawable b;
    public final int c;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C cU = C.u(context, attributeSet, GE5.TabItem);
        this.a = cU.p(GE5.TabItem_android_text);
        this.b = cU.g(GE5.TabItem_android_icon);
        this.c = cU.n(GE5.TabItem_android_layout, 0);
        cU.w();
    }
}
