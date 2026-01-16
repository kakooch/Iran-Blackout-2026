package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.ae2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C9835ae2 implements AbstractC18815pI3.a {
    public static final C9835ae2 b = new C9835ae2();

    private C9835ae2() {
    }

    @Override // ir.nasim.AbstractC18815pI3.a
    public void a(String str, String str2) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
        C19406qI3.a(str, str2, new Object[0]);
    }

    @Override // ir.nasim.AbstractC18815pI3.a
    public void b(String str, String str2) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
        C19406qI3.j(str, str2, new Object[0]);
    }

    @Override // ir.nasim.AbstractC18815pI3.a
    public void c(String str, String str2) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
        C19406qI3.b(str, str2);
    }

    @Override // ir.nasim.AbstractC18815pI3.a
    public void d(String str, String str2) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
        C19406qI3.g(str, str2, new Object[0]);
    }
}
