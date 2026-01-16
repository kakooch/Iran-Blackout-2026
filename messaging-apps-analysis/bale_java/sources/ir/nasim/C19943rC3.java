package ir.nasim;

import android.text.Spannable;
import ir.nasim.AbstractC17757nW1;

/* renamed from: ir.nasim.rC3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19943rC3 {
    private final Spannable a;
    private final Spannable b;
    private final long c;
    private final AbstractC17757nW1.c.b d;

    public C19943rC3(Spannable spannable, Spannable spannable2, long j, AbstractC17757nW1.c.b bVar) {
        AbstractC13042fc3.i(spannable, "usersCountSpannable");
        AbstractC13042fc3.i(spannable2, "liveStatusSpannable");
        AbstractC13042fc3.i(bVar, "graphical");
        this.a = spannable;
        this.b = spannable2;
        this.c = j;
        this.d = bVar;
    }

    public final AbstractC17757nW1.c.b a() {
        return this.d;
    }

    public final long b() {
        return this.c;
    }

    public final Spannable c() {
        return this.b;
    }

    public final Spannable d() {
        return this.a;
    }
}
