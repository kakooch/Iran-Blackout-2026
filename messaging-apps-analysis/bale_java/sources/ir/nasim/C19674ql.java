package ir.nasim;

import android.database.Cursor;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.ql, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19674ql implements InterfaceC19083pl {
    public static final c d = new c(null);
    private final D26 a;
    private final AbstractC21126t92 b;
    private final AbstractC19914r92 c;

    /* renamed from: ir.nasim.ql$a */
    public static final class a extends AbstractC21126t92 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR REPLACE INTO `aLbum_message_id` (`peer_unique_id`,`album_id`,`message_id`,`message_date`) VALUES (?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, G g) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(g, "entity");
            interfaceC15121j27.k1(1, g.d());
            interfaceC15121j27.k1(2, g.a());
            interfaceC15121j27.k1(3, g.c());
            interfaceC15121j27.k1(4, g.b());
        }
    }

    /* renamed from: ir.nasim.ql$b */
    public static final class b extends AbstractC19914r92 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "DELETE FROM `aLbum_message_id` WHERE `peer_unique_id` = ? AND `message_id` = ? AND `message_date` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC19914r92
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, G g) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(g, "entity");
            interfaceC15121j27.k1(1, g.d());
            interfaceC15121j27.k1(2, g.c());
            interfaceC15121j27.k1(3, g.b());
        }
    }

    /* renamed from: ir.nasim.ql$c */
    public static final class c {
        private c() {
        }

        public final List a() {
            return AbstractC10360bX0.m();
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.ql$d */
    public static final class d implements Callable {
        final /* synthetic */ G b;

        d(G g) {
            this.b = g;
        }

        public void a() {
            C19674ql.this.a.e();
            try {
                C19674ql.this.c.j(this.b);
                C19674ql.this.a.F();
            } finally {
                C19674ql.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ql$e */
    public static final class e implements Callable {
        final /* synthetic */ O26 b;

        e(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long call() {
            Long lValueOf = null;
            Cursor cursorC = AbstractC7716Sx1.c(C19674ql.this.a, this.b, false, null);
            try {
                if (cursorC.moveToFirst() && !cursorC.isNull(0)) {
                    lValueOf = Long.valueOf(cursorC.getLong(0));
                }
                return lValueOf;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    /* renamed from: ir.nasim.ql$f */
    public static final class f implements Callable {
        final /* synthetic */ List b;

        f(List list) {
            this.b = list;
        }

        public void a() {
            C19674ql.this.a.e();
            try {
                C19674ql.this.b.j(this.b);
                C19674ql.this.a.F();
            } finally {
                C19674ql.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public C19674ql(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.a = d26;
        this.b = new a(d26);
        this.c = new b(d26);
    }

    @Override // ir.nasim.InterfaceC19083pl
    public Object b(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new f(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC19083pl
    public Object c(long j, long j2, long j3, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT album_id FROM aLbum_message_id WHERE peer_unique_id = ? AND message_id = ? AND message_date = ?", 3);
        o26A.k1(1, j);
        o26A.k1(2, j2);
        o26A.k1(3, j3);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new e(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC19083pl
    public Object d(G g, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new d(g), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }
}
