package ir.nasim;

import ir.nasim.C13245fu;

/* renamed from: ir.nasim.h83, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC13977h83 {
    public static final void a(C13245fu.b bVar, String str, String str2) {
        if (!(str2.length() > 0)) {
            P73.a("alternateText can't be an empty string.");
        }
        bVar.m("androidx.compose.foundation.text.inlineContent", str);
        bVar.h(str2);
        bVar.k();
    }

    public static /* synthetic */ void b(C13245fu.b bVar, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "�";
        }
        a(bVar, str, str2);
    }
}
