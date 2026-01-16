package ir.nasim.database;

import android.content.Context;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC7311Re1;
import ir.nasim.AbstractC9264Ze4;
import ir.nasim.C19323q92;
import ir.nasim.C26;
import ir.nasim.C5721Ko;
import ir.nasim.C92;
import ir.nasim.D26;
import ir.nasim.DD3;
import ir.nasim.FX6;
import ir.nasim.HD4;
import ir.nasim.HM1;
import ir.nasim.InterfaceC13266fw0;
import ir.nasim.InterfaceC14516i3;
import ir.nasim.InterfaceC16512lP1;
import ir.nasim.InterfaceC18665p25;
import ir.nasim.InterfaceC19083pl;
import ir.nasim.InterfaceC19600qd5;
import ir.nasim.InterfaceC20728sW;
import ir.nasim.InterfaceC5377Jb6;
import ir.nasim.InterfaceC6721Or6;
import ir.nasim.InterfaceC7346Ri0;
import ir.nasim.InterfaceC8150Us7;
import ir.nasim.KS2;
import ir.nasim.QI7;
import ir.nasim.UY1;
import ir.nasim.database.dailogLists.DialogDatabase;
import ir.nasim.database.dailogLists.c;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final InterfaceC19083pl a(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.I();
    }

    public final InterfaceC7346Ri0 b(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.K();
    }

    public final InterfaceC13266fw0 c(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.L();
    }

    public final ApplicationDatabase d(Context context, C19323q92 c19323q92) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c19323q92, "entityConverter");
        D26.a aVarA = C26.a(context, ApplicationDatabase.class, ((InterfaceC14516i3) C92.a(C5721Ko.a.d(), InterfaceC14516i3.class)).r0());
        AbstractC9264Ze4[] abstractC9264Ze4ArrA = ApplicationDatabase.INSTANCE.a();
        return (ApplicationDatabase) aVarA.b((AbstractC9264Ze4[]) Arrays.copyOf(abstractC9264Ze4ArrA, abstractC9264Ze4ArrA.length)).c(c19323q92).e();
    }

    public final HM1 e(DialogDatabase dialogDatabase) {
        AbstractC13042fc3.i(dialogDatabase, "database");
        return dialogDatabase.H();
    }

    public final DialogDatabase f(Context context, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "dialogDatabaseName");
        return DialogDatabase.INSTANCE.a(context, str);
    }

    public final c g(DialogDatabase dialogDatabase) {
        AbstractC13042fc3.i(dialogDatabase, "database");
        return dialogDatabase.I();
    }

    public final InterfaceC16512lP1 h(DialogDatabase dialogDatabase) {
        AbstractC13042fc3.i(dialogDatabase, "database");
        return dialogDatabase.J();
    }

    public final UY1 i(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.N();
    }

    public final InterfaceC20728sW j(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.J();
    }

    public final InterfaceC18665p25 k(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.Q();
    }

    public final KS2 l() {
        return new KS2();
    }

    public final DD3 m(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.O();
    }

    public final HD4 n(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.P();
    }

    public final InterfaceC19600qd5 o(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.R();
    }

    public final InterfaceC5377Jb6 p(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.S();
    }

    public final InterfaceC6721Or6 q(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.T();
    }

    public final FX6 r(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.U();
    }

    public final InterfaceC8150Us7 s(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.V();
    }

    public final AbstractC7311Re1 t(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.M();
    }

    public final QI7 u(ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(applicationDatabase, "database");
        return applicationDatabase.W();
    }
}
