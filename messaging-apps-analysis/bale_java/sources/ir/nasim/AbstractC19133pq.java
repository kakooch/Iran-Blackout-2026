package ir.nasim;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import ir.nasim.AbstractC4058Dm7;
import ir.nasim.C23811xZ2;
import ir.nasim.C4171Dz3;
import ir.nasim.C6399Nk7;

/* renamed from: ir.nasim.pq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19133pq {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence j(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : null;
        if (spannableString == null) {
            spannableString = new SpannableString(charSequence);
        }
        if (!AbstractC18227oI6.a(spannableString, Z53.class)) {
            AbstractC15863kI6.v(spannableString, new Z53(), spannableString.length() - 1, spannableString.length() - 1);
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(C10550bn7 c10550bn7, int i) {
        int iM = c10550bn7.m();
        for (int i2 = 0; i2 < iM; i2++) {
            if (c10550bn7.l(i2) > i) {
                return i2;
            }
        }
        return c10550bn7.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(C9348Zn7 c9348Zn7, boolean z) {
        if (!z || C13193fo7.e(c9348Zn7.q(), AbstractC13784go7.g(0)) || C13193fo7.e(c9348Zn7.q(), C13193fo7.b.a())) {
            return false;
        }
        int iZ = c9348Zn7.z();
        C6399Nk7.a aVar = C6399Nk7.b;
        return (C6399Nk7.k(iZ, aVar.g()) || C6399Nk7.k(c9348Zn7.z(), aVar.f()) || C6399Nk7.k(c9348Zn7.z(), aVar.c())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(int i) {
        C6399Nk7.a aVar = C6399Nk7.b;
        if (C6399Nk7.k(i, aVar.d())) {
            return 3;
        }
        if (C6399Nk7.k(i, aVar.e())) {
            return 4;
        }
        if (C6399Nk7.k(i, aVar.a())) {
            return 2;
        }
        return (!C6399Nk7.k(i, aVar.f()) && C6399Nk7.k(i, aVar.b())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(int i) {
        C4171Dz3.b.a aVar = C4171Dz3.b.a;
        if (C4171Dz3.b.e(i, aVar.c())) {
            return 0;
        }
        if (C4171Dz3.b.e(i, aVar.b())) {
            return 1;
        }
        return C4171Dz3.b.e(i, aVar.a()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(int i) {
        C23811xZ2.a aVar = C23811xZ2.b;
        if (C23811xZ2.g(i, aVar.a())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        C23811xZ2.g(i, aVar.b());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(int i) {
        C4171Dz3.c.a aVar = C4171Dz3.c.a;
        if (C4171Dz3.c.f(i, aVar.a())) {
            return 0;
        }
        if (C4171Dz3.c.f(i, aVar.b())) {
            return 1;
        }
        if (C4171Dz3.c.f(i, aVar.c())) {
            return 2;
        }
        return C4171Dz3.c.f(i, aVar.d()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(int i) {
        C4171Dz3.d.a aVar = C4171Dz3.d.a;
        return (!C4171Dz3.d.d(i, aVar.a()) && C4171Dz3.d.d(i, aVar.b())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int r(int i) {
        AbstractC4058Dm7.a aVar = AbstractC4058Dm7.a;
        return (!AbstractC4058Dm7.d(i, aVar.a()) && AbstractC4058Dm7.d(i, aVar.b())) ? 1 : 0;
    }
}
