package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC24846zI6;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes2.dex */
final class DN7 extends AbstractC24846zI6 {
    private final Object b;
    private final String c;
    private final AbstractC24846zI6.b d;
    private final GI3 e;

    public DN7(Object obj, String str, AbstractC24846zI6.b bVar, GI3 gi3) {
        AbstractC13042fc3.i(obj, "value");
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(bVar, "verificationMode");
        AbstractC13042fc3.i(gi3, "logger");
        this.b = obj;
        this.c = str;
        this.d = bVar;
        this.e = gi3;
    }

    @Override // ir.nasim.AbstractC24846zI6
    public Object a() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC24846zI6
    public AbstractC24846zI6 c(String str, UA2 ua2) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(ua2, "condition");
        return ((Boolean) ua2.invoke(this.b)).booleanValue() ? this : new C3283Af2(this.b, this.c, str, this.e, this.d);
    }
}
