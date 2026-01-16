package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.text.Spannable;

/* renamed from: ir.nasim.Xn5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8837Xn5 extends C8337Vn5 {
    private final String d;
    private final Spannable e;
    private final int f;
    private final Spannable g;
    private final CharSequence h;

    public /* synthetic */ C8837Xn5(Spannable spannable, String str, String str2, Spannable spannable2, int i, Spannable spannable3, CharSequence charSequence, Spannable spannable4, int i2, ED1 ed1) {
        this(spannable, str, str2, spannable2, i, spannable3, (i2 & 64) != 0 ? null : charSequence, (i2 & 128) != 0 ? null : spannable4);
    }

    public final Spannable d() {
        return this.g;
    }

    public final Spannable e() {
        return this.e;
    }

    public final CharSequence f() {
        return this.h;
    }

    public final String g() {
        return this.d;
    }

    public final int h() {
        return this.f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8837Xn5(Spannable spannable, String str, String str2, Spannable spannable2, int i, Spannable spannable3, CharSequence charSequence, Spannable spannable4) {
        super(spannable, str, spannable4);
        AbstractC13042fc3.i(str2, ParameterNames.TEXT);
        this.d = str2;
        this.e = spannable2;
        this.f = i;
        this.g = spannable3;
        this.h = charSequence;
    }
}
