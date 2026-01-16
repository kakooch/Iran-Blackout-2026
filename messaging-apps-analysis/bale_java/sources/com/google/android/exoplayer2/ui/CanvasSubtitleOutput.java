package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ui.SubtitleView;
import ir.nasim.C14451hw1;
import ir.nasim.CF0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class CanvasSubtitleOutput extends View implements SubtitleView.a {
    private final List a;
    private List b;
    private int c;
    private float d;
    private CF0 e;
    private float f;

    public CanvasSubtitleOutput(Context context) {
        this(context, null);
    }

    private static C14451hw1 b(C14451hw1 c14451hw1) {
        C14451hw1.b bVarP = c14451hw1.c().k(-3.4028235E38f).l(RecyclerView.UNDEFINED_DURATION).p(null);
        if (c14451hw1.f == 0) {
            bVarP.h(1.0f - c14451hw1.e, 0);
        } else {
            bVarP.h((-c14451hw1.e) - 1.0f, 1);
        }
        int i = c14451hw1.g;
        if (i == 0) {
            bVarP.i(2);
        } else if (i == 2) {
            bVarP.i(0);
        }
        return bVarP.a();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List list, CF0 cf0, float f, int i, float f2) {
        this.b = list;
        this.e = cf0;
        this.d = f;
        this.c = i;
        this.f = f2;
        while (this.a.size() < list.size()) {
            this.a.add(new x(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List list = this.b;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i = paddingBottom - paddingTop;
        float fH = A.h(this.c, this.d, height, i);
        if (fH <= 0.0f) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            C14451hw1 c14451hw1B = (C14451hw1) list.get(i2);
            if (c14451hw1B.p != Integer.MIN_VALUE) {
                c14451hw1B = b(c14451hw1B);
            }
            C14451hw1 c14451hw1 = c14451hw1B;
            int i3 = paddingBottom;
            ((x) this.a.get(i2)).b(c14451hw1, this.e, fH, A.h(c14451hw1.n, c14451hw1.o, height, i), this.f, canvas, paddingLeft, paddingTop, width, i3);
            i2++;
            size = size;
            i = i;
            paddingBottom = i3;
            width = width;
        }
    }

    public CanvasSubtitleOutput(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ArrayList();
        this.b = Collections.emptyList();
        this.c = 0;
        this.d = 0.0533f;
        this.e = CF0.g;
        this.f = 0.08f;
    }
}
