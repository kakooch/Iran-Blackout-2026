package ir.nasim;

import android.database.Cursor;
import android.gov.nist.core.Separators;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import ir.nasim.database.pinMessages.PinMessageEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class RI7 implements QI7 {
    public static final d d = new d(null);
    private final D26 a;
    private final AbstractC11429cz6 b;
    private final C21800u92 c;

    public static final class a extends AbstractC11429cz6 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "\n        UPDATE user_presences\n        SET last_seen = ?,\n            state = ?\n        WHERE peer_unique_id = ?\n          AND (last_seen < ? OR state <> ?)\n    ";
        }
    }

    public static final class b extends AbstractC21126t92 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT INTO `user_presences` (`peer_unique_id`,`last_seen`,`state`,`unknown`) VALUES (?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, SI7 si7) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(si7, "entity");
            interfaceC15121j27.k1(1, si7.b());
            interfaceC15121j27.k1(2, si7.a());
            interfaceC15121j27.k1(3, si7.c());
            interfaceC15121j27.k1(4, si7.d() ? 1L : 0L);
        }
    }

    public static final class c extends AbstractC19914r92 {
        c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "UPDATE `user_presences` SET `peer_unique_id` = ?,`last_seen` = ?,`state` = ?,`unknown` = ? WHERE `peer_unique_id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC19914r92
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, SI7 si7) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(si7, "entity");
            interfaceC15121j27.k1(1, si7.b());
            interfaceC15121j27.k1(2, si7.a());
            interfaceC15121j27.k1(3, si7.c());
            interfaceC15121j27.k1(4, si7.d() ? 1L : 0L);
            interfaceC15121j27.k1(5, si7.b());
        }
    }

    public static final class d {
        private d() {
        }

        public final List a() {
            return AbstractC10360bX0.m();
        }

        public /* synthetic */ d(ED1 ed1) {
            this();
        }
    }

    public static final class e implements Callable {
        final /* synthetic */ O26 b;

        e(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SI7 call() {
            SI7 si7 = null;
            Cursor cursorC = AbstractC7716Sx1.c(RI7.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_PEER_UNIQUE_ID);
                int iE2 = AbstractC5795Kw1.e(cursorC, "last_seen");
                int iE3 = AbstractC5795Kw1.e(cursorC, "state");
                int iE4 = AbstractC5795Kw1.e(cursorC, CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE);
                if (cursorC.moveToFirst()) {
                    si7 = new SI7(cursorC.getLong(iE), cursorC.getLong(iE2), cursorC.getInt(iE3), cursorC.getInt(iE4) != 0);
                }
                return si7;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    public static final class f implements Callable {
        final /* synthetic */ O26 b;

        f(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SI7 call() {
            SI7 si7 = null;
            Cursor cursorC = AbstractC7716Sx1.c(RI7.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_PEER_UNIQUE_ID);
                int iE2 = AbstractC5795Kw1.e(cursorC, "last_seen");
                int iE3 = AbstractC5795Kw1.e(cursorC, "state");
                int iE4 = AbstractC5795Kw1.e(cursorC, CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE);
                if (cursorC.moveToFirst()) {
                    si7 = new SI7(cursorC.getLong(iE), cursorC.getLong(iE2), cursorC.getInt(iE3), cursorC.getInt(iE4) != 0);
                }
                return si7;
            } finally {
                cursorC.close();
            }
        }

        protected final void finalize() {
            this.b.j();
        }
    }

    public static final class g implements Callable {
        final /* synthetic */ O26 b;

        g(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(RI7.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_PEER_UNIQUE_ID);
                int iE2 = AbstractC5795Kw1.e(cursorC, "last_seen");
                int iE3 = AbstractC5795Kw1.e(cursorC, "state");
                int iE4 = AbstractC5795Kw1.e(cursorC, CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE);
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new SI7(cursorC.getLong(iE), cursorC.getLong(iE2), cursorC.getInt(iE3), cursorC.getInt(iE4) != 0));
                }
                return arrayList;
            } finally {
                cursorC.close();
            }
        }

        protected final void finalize() {
            this.b.j();
        }
    }

    public static final class h implements Callable {
        final /* synthetic */ long b;
        final /* synthetic */ int c;
        final /* synthetic */ long d;

        h(long j, int i, long j2) {
            this.b = j;
            this.c = i;
            this.d = j2;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = RI7.this.b.b();
            interfaceC15121j27B.k1(1, this.b);
            interfaceC15121j27B.k1(2, this.c);
            interfaceC15121j27B.k1(3, this.d);
            interfaceC15121j27B.k1(4, this.b);
            interfaceC15121j27B.k1(5, this.c);
            try {
                RI7.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    RI7.this.a.F();
                } finally {
                    RI7.this.a.j();
                }
            } finally {
                RI7.this.b.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class i implements Callable {
        final /* synthetic */ SI7 b;

        i(SI7 si7) {
            this.b = si7;
        }

        public void a() {
            RI7.this.a.e();
            try {
                RI7.this.c.c(this.b);
                RI7.this.a.F();
            } finally {
                RI7.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class j implements Callable {
        final /* synthetic */ List b;

        j(List list) {
            this.b = list;
        }

        public void a() {
            RI7.this.a.e();
            try {
                RI7.this.c.b(this.b);
                RI7.this.a.F();
            } finally {
                RI7.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public RI7(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.a = d26;
        this.b = new a(d26);
        this.c = new C21800u92(new b(d26), new c(d26));
    }

    @Override // ir.nasim.QI7
    public InterfaceC4557Fq2 a(List list) {
        AbstractC13042fc3.i(list, "uniqueIds");
        StringBuilder sbB = WY6.b();
        sbB.append("SELECT * FROM user_presences WHERE peer_unique_id in (");
        int size = list.size();
        WY6.a(sbB, size);
        sbB.append(Separators.RPAREN);
        String string = sbB.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        O26 o26A = O26.i.a(string, size);
        Iterator it = list.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            o26A.k1(i2, ((Number) it.next()).longValue());
            i2++;
        }
        return androidx.room.a.a.a(this.a, false, new String[]{"user_presences"}, new g(o26A));
    }

    @Override // ir.nasim.QI7
    public InterfaceC4557Fq2 b(long j2) {
        O26 o26A = O26.i.a("SELECT * FROM user_presences WHERE peer_unique_id = ? LIMIT 1", 1);
        o26A.k1(1, j2);
        return androidx.room.a.a.a(this.a, false, new String[]{"user_presences"}, new f(o26A));
    }

    @Override // ir.nasim.QI7
    public Object c(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM user_presences WHERE peer_unique_id = ? LIMIT 1", 1);
        o26A.k1(1, j2);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new e(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.QI7
    public Object d(SI7 si7, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new i(si7), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.QI7
    public Object e(long j2, long j3, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new h(j3, i2, j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.QI7
    public Object f(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new j(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }
}
