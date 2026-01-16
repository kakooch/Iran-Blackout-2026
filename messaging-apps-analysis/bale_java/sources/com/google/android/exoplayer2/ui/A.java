package com.google.android.exoplayer2.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC20011rK;
import ir.nasim.C14451hw1;
import ir.nasim.InterfaceC10606bt3;
import ir.nasim.InterfaceC11281ck5;

/* loaded from: classes2.dex */
abstract class A {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean c(Object obj) {
        return !(obj instanceof InterfaceC10606bt3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    public static void e(C14451hw1.b bVar) {
        bVar.b();
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.o(SpannableString.valueOf(bVar.e()));
            }
            g((Spannable) AbstractC20011rK.e(bVar.e()), new InterfaceC11281ck5() { // from class: com.google.android.exoplayer2.ui.y
                @Override // ir.nasim.InterfaceC11281ck5
                public final boolean apply(Object obj) {
                    return A.c(obj);
                }
            });
        }
        f(bVar);
    }

    public static void f(C14451hw1.b bVar) {
        bVar.q(-3.4028235E38f, RecyclerView.UNDEFINED_DURATION);
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.o(SpannableString.valueOf(bVar.e()));
            }
            g((Spannable) AbstractC20011rK.e(bVar.e()), new InterfaceC11281ck5() { // from class: com.google.android.exoplayer2.ui.z
                @Override // ir.nasim.InterfaceC11281ck5
                public final boolean apply(Object obj) {
                    return A.d(obj);
                }
            });
        }
    }

    private static void g(Spannable spannable, InterfaceC11281ck5 interfaceC11281ck5) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (interfaceC11281ck5.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static float h(int i, float f, int i2, int i3) {
        float f2;
        if (f == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i == 0) {
            f2 = i3;
        } else {
            if (i != 1) {
                if (i != 2) {
                    return -3.4028235E38f;
                }
                return f;
            }
            f2 = i2;
        }
        return f * f2;
    }
}
