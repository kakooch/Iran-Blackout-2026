package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.dS7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC11702dS7 {
    public static final boolean a(AbstractC7310Re0 abstractC7310Re0) {
        AbstractC13042fc3.i(abstractC7310Re0, ParameterNames.VERSION);
        return abstractC7310Re0.a() == 1 && abstractC7310Re0.b() >= 4;
    }

    public static final boolean b(AbstractC7310Re0 abstractC7310Re0) {
        AbstractC13042fc3.i(abstractC7310Re0, ParameterNames.VERSION);
        return a(abstractC7310Re0);
    }
}
