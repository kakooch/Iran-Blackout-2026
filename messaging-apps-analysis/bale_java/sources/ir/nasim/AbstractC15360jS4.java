package ir.nasim;

import java.text.ParseException;

/* renamed from: ir.nasim.jS4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC15360jS4 {
    public static final long a(D45 d45) throws ParseException {
        AbstractC13042fc3.i(d45, "<this>");
        D45 d452 = new D45(d45.E());
        d452.Q(0);
        d452.R(0);
        d452.S(0);
        Long lE = d452.E();
        AbstractC13042fc3.h(lE, "getTime(...)");
        return lE.longValue();
    }

    public static final long b(D45 d45) throws ParseException {
        AbstractC13042fc3.i(d45, "<this>");
        D45 d452 = new D45(d45.E());
        d452.Q(0);
        d452.R(0);
        d452.S(0);
        d452.k(1L);
        return d452.E().longValue() - 1;
    }
}
