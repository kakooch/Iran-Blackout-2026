package ir.nasim;

import android.database.Cursor;
import ir.nasim.database.pinMessages.PinMessageEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class ED3 implements DD3 {
    public static final f f = new f(null);
    private final D26 a;
    private final AbstractC11429cz6 b;
    private final AbstractC11429cz6 c;
    private final AbstractC11429cz6 d;
    private final C21800u92 e;

    public static final class a extends AbstractC11429cz6 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM live_streams_new WHERE live_key = ?";
        }
    }

    public static final class b extends AbstractC11429cz6 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM live_streams_new";
        }
    }

    public static final class c extends AbstractC11429cz6 {
        c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE sqlite_sequence SET seq = 0 WHERE name = 'live_streams_new'";
        }
    }

    public static final class d extends AbstractC21126t92 {
        d(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT INTO `live_streams_new` (`live_key`,`peer_unique_id`,`message_rid`,`message_date`,`user_count`) VALUES (?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, HD3 hd3) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(hd3, "entity");
            interfaceC15121j27.k1(1, hd3.a());
            interfaceC15121j27.k1(2, hd3.d());
            interfaceC15121j27.k1(3, hd3.c());
            interfaceC15121j27.k1(4, hd3.b());
            interfaceC15121j27.k1(5, hd3.e());
        }
    }

    public static final class e extends AbstractC19914r92 {
        e(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "UPDATE `live_streams_new` SET `live_key` = ?,`peer_unique_id` = ?,`message_rid` = ?,`message_date` = ?,`user_count` = ? WHERE `live_key` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC19914r92
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, HD3 hd3) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(hd3, "entity");
            interfaceC15121j27.k1(1, hd3.a());
            interfaceC15121j27.k1(2, hd3.d());
            interfaceC15121j27.k1(3, hd3.c());
            interfaceC15121j27.k1(4, hd3.b());
            interfaceC15121j27.k1(5, hd3.e());
            interfaceC15121j27.k1(6, hd3.a());
        }
    }

    public static final class f {
        private f() {
        }

        public final List a() {
            return AbstractC10360bX0.m();
        }

        public /* synthetic */ f(ED1 ed1) {
            this();
        }
    }

    public static final class g implements Callable {
        final /* synthetic */ long b;

        g(long j) {
            this.b = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = ED3.this.b.b();
            interfaceC15121j27B.k1(1, this.b);
            try {
                ED3.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    ED3.this.a.F();
                } finally {
                    ED3.this.a.j();
                }
            } finally {
                ED3.this.b.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class h implements Callable {
        h() {
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = ED3.this.c.b();
            try {
                ED3.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    ED3.this.a.F();
                } finally {
                    ED3.this.a.j();
                }
            } finally {
                ED3.this.c.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class i implements Callable {
        final /* synthetic */ O26 b;

        i(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(ED3.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "live_key");
                int iE2 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_PEER_UNIQUE_ID);
                int iE3 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_RID);
                int iE4 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_DATE);
                int iE5 = AbstractC5795Kw1.e(cursorC, "user_count");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new HD3(cursorC.getLong(iE), cursorC.getLong(iE2), cursorC.getLong(iE3), cursorC.getLong(iE4), cursorC.getInt(iE5)));
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

    public static final class j implements Callable {
        j() {
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = ED3.this.d.b();
            try {
                ED3.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    ED3.this.a.F();
                } finally {
                    ED3.this.a.j();
                }
            } finally {
                ED3.this.d.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    static final class k extends AbstractC19859r37 implements UA2 {
        int b;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return ED3.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ED3 ed3 = ED3.this;
                this.b = 1;
                if (ED3.super.b(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class l implements Callable {
        final /* synthetic */ HD3 b;

        l(HD3 hd3) {
            this.b = hd3;
        }

        public void a() {
            ED3.this.a.e();
            try {
                ED3.this.e.c(this.b);
                ED3.this.a.F();
            } finally {
                ED3.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class m implements Callable {
        final /* synthetic */ Iterable b;

        m(Iterable iterable) {
            this.b = iterable;
        }

        public void a() {
            ED3.this.a.e();
            try {
                ED3.this.e.b(this.b);
                ED3.this.a.F();
            } finally {
                ED3.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public ED3(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.a = d26;
        this.b = new a(d26);
        this.c = new b(d26);
        this.d = new c(d26);
        this.e = new C21800u92(new d(d26), new e(d26));
    }

    @Override // ir.nasim.DD3
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new h(), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.DD3
    public Object b(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.a, new k(null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.DD3
    public Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new j(), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.DD3
    public Object d(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new g(j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.DD3
    public InterfaceC4557Fq2 e() {
        return androidx.room.a.a.a(this.a, false, new String[]{"live_streams_new"}, new i(O26.i.a("SELECT * FROM live_streams_new", 0)));
    }

    @Override // ir.nasim.DD3
    public Object f(Iterable iterable, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new m(iterable), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.DD3
    public Object h(HD3 hd3, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new l(hd3), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }
}
