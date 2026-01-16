package ir.nasim;

import android.content.Context;
import java.util.List;

/* renamed from: ir.nasim.lk5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16715lk5 {

    /* renamed from: ir.nasim.lk5$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(Context context) {
            AbstractC13042fc3.i(context, "it");
            return AbstractC10360bX0.m();
        }
    }

    public static final InterfaceC23661xI5 a(String str, KO5 ko5, UA2 ua2, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(ua2, "produceMigrations");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        return new C18488ok5(str, ko5, ua2, interfaceC20315ro1);
    }

    public static /* synthetic */ InterfaceC23661xI5 b(String str, KO5 ko5, UA2 ua2, InterfaceC20315ro1 interfaceC20315ro1, int i, Object obj) {
        if ((i & 2) != 0) {
            ko5 = null;
        }
        if ((i & 4) != 0) {
            ua2 = a.e;
        }
        if ((i & 8) != 0) {
            interfaceC20315ro1 = AbstractC20906so1.a(C12366eV1.b().X(P17.b(null, 1, null)));
        }
        return a(str, ko5, ua2, interfaceC20315ro1);
    }
}
