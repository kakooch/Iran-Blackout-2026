package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.Locale;

/* renamed from: ir.nasim.tg3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21448tg3 {
    public static final C21448tg3 a = new C21448tg3();
    private static long b = -1;
    public static final int c = 8;

    private C21448tg3() {
    }

    public static final void a(int i, int i2) {
        if (b != -1 && i == 1 && i2 != 1) {
            long jCurrentTimeMillis = (System.currentTimeMillis() - b) / 1000;
            if (jCurrentTimeMillis > 0) {
                C3343Am.i("flow_tab_click", AbstractC19460qO3.g(AbstractC4616Fw7.a("duration_seconds", Long.valueOf(jCurrentTimeMillis))));
            }
        }
        b = -1L;
    }

    public static final void b() {
        b = System.currentTimeMillis();
    }

    public static final void c() {
        b = -1L;
    }

    public final void d(int i, String str, ExPeerType exPeerType) {
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        if (str != null) {
            XV4 xv4A = AbstractC4616Fw7.a("peer_id", Integer.valueOf(i));
            XV4 xv4A2 = AbstractC4616Fw7.a("event_type", str);
            String lowerCase = exPeerType.toString().toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            C3343Am.i("flow_join", AbstractC20051rO3.n(xv4A, xv4A2, AbstractC4616Fw7.a("peer_type", lowerCase)));
        }
    }
}
