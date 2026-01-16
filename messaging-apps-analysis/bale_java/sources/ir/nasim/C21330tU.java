package ir.nasim;

import android.view.autofill.AutofillId;

/* renamed from: ir.nasim.tU, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C21330tU {
    private final Object a;

    private C21330tU(AutofillId autofillId) {
        this.a = autofillId;
    }

    public static C21330tU b(AutofillId autofillId) {
        return new C21330tU(autofillId);
    }

    public AutofillId a() {
        return AbstractC20101rU.a(this.a);
    }
}
