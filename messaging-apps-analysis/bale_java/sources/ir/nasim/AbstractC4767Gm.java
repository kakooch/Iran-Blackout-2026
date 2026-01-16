package ir.nasim;

import ir.nasim.MW1;

/* renamed from: ir.nasim.Gm, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4767Gm {
    public static final void a(C22007uW1 c22007uW1, MW1 mw1, EnumC8893Xt7 enumC8893Xt7, String str) {
        AbstractC13042fc3.i(c22007uW1, "<this>");
        AbstractC13042fc3.i(mw1, "documentState");
        AbstractC13042fc3.i(str, "mimeType");
        if ((mw1 instanceof MW1.b) && enumC8893Xt7 != null) {
            MW1.b bVar = (MW1.b) mw1;
            c22007uW1.I(new C4518Fm(enumC8893Xt7, str, bVar.a().b().getFileId(), bVar.a().b().getAccessHash()));
        }
    }
}
