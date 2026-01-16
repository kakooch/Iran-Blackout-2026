package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C14451hw1;
import ir.nasim.CF0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class SubtitleView extends FrameLayout {
    private List a;
    private CF0 b;
    private int c;
    private float d;
    private float e;
    private boolean f;
    private boolean g;
    private int h;
    private a i;
    private View j;

    interface a {
        void a(List list, CF0 cf0, float f, int i, float f2);
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    private C14451hw1 a(C14451hw1 c14451hw1) {
        C14451hw1.b bVarC = c14451hw1.c();
        if (!this.f) {
            A.e(bVarC);
        } else if (!this.g) {
            A.f(bVarC);
        }
        return bVarC.a();
    }

    private void b(int i, float f) {
        this.c = i;
        this.d = f;
        c();
    }

    private void c() {
        this.i.a(getCuesWithStylingPreferencesApplied(), this.b, this.d, this.c, this.e);
    }

    private List<C14451hw1> getCuesWithStylingPreferencesApplied() {
        if (this.f && this.g) {
            return this.a;
        }
        ArrayList arrayList = new ArrayList(this.a.size());
        for (int i = 0; i < this.a.size(); i++) {
            arrayList.add(a((C14451hw1) this.a.get(i)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (AbstractC9683aN7.a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private CF0 getUserCaptionStyle() {
        if (AbstractC9683aN7.a < 19 || isInEditMode()) {
            return CF0.g;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? CF0.g : CF0.a(captioningManager.getUserStyle());
    }

    private <T extends View & a> void setView(T t) {
        removeView(this.j);
        View view = this.j;
        if (view instanceof WebViewSubtitleOutput) {
            ((WebViewSubtitleOutput) view).g();
        }
        this.j = t;
        this.i = t;
        addView(t);
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        this.g = z;
        c();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        this.f = z;
        c();
    }

    public void setBottomPaddingFraction(float f) {
        this.e = f;
        c();
    }

    public void setCues(List<C14451hw1> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.a = list;
        c();
    }

    public void setFixedTextSize(int i, float f) {
        Context context = getContext();
        b(2, TypedValue.applyDimension(i, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public void setFractionalTextSize(float f) {
        setFractionalTextSize(f, false);
    }

    public void setStyle(CF0 cf0) {
        this.b = cf0;
        c();
    }

    public void setUserDefaultStyle() {
        setStyle(getUserCaptionStyle());
    }

    public void setUserDefaultTextSize() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setViewType(int i) {
        if (this.h == i) {
            return;
        }
        if (i == 1) {
            setView(new CanvasSubtitleOutput(getContext()));
        } else {
            if (i != 2) {
                throw new IllegalArgumentException();
            }
            setView(new WebViewSubtitleOutput(getContext()));
        }
        this.h = i;
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = Collections.emptyList();
        this.b = CF0.g;
        this.c = 0;
        this.d = 0.0533f;
        this.e = 0.08f;
        this.f = true;
        this.g = true;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context);
        this.i = canvasSubtitleOutput;
        this.j = canvasSubtitleOutput;
        addView(canvasSubtitleOutput);
        this.h = 1;
    }

    public void setFractionalTextSize(float f, boolean z) {
        b(z ? 1 : 0, f);
    }
}
