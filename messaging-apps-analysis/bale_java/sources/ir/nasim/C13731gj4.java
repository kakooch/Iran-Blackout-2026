package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.InterfaceC8291Vi4;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.gj4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C13731gj4 implements InterfaceC13140fj4 {
    private final InterfaceC7821Ti4 a;

    public C13731gj4(InterfaceC7821Ti4 interfaceC7821Ti4) {
        AbstractC13042fc3.i(interfaceC7821Ti4, "monitoringDataSource");
        this.a = interfaceC7821Ti4;
    }

    @Override // ir.nasim.InterfaceC13140fj4
    public void b(String str, String str2, Throwable th) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
        this.a.a(new InterfaceC8291Vi4.a(str, str2, th));
    }
}
