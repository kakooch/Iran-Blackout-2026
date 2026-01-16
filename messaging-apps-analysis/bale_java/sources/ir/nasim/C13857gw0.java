package ir.nasim;

import android.database.Cursor;
import android.gov.nist.core.Separators;
import ir.nasim.database.converters.IntArrayTypeConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.gw0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13857gw0 implements InterfaceC13266fw0 {
    public static final d i = new d(null);
    private final D26 a;
    private final AbstractC21126t92 b;
    private final C18705p65 c;
    private final C12286eM2 d;
    private final IntArrayTypeConverter e;
    private final C4046Dl4 f;
    private final AbstractC11429cz6 g;
    private final AbstractC11429cz6 h;

    /* renamed from: ir.nasim.gw0$a */
    public static final class a extends AbstractC21126t92 {
        final /* synthetic */ C13857gw0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(D26 d26, C13857gw0 c13857gw0) {
            super(d26);
            this.d = c13857gw0;
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR REPLACE INTO `call_log` (`time`,`duration`,`peer`,`initiator`,`finisher`,`personal_call_state`,`group_call_state`,`id`,`peersList`,`state`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, C15057iw0 c15057iw0) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(c15057iw0, "entity");
            interfaceC15121j27.k1(1, c15057iw0.i());
            interfaceC15121j27.k1(2, c15057iw0.a());
            interfaceC15121j27.k1(3, c15057iw0.g());
            interfaceC15121j27.k1(4, c15057iw0.e());
            interfaceC15121j27.k1(5, c15057iw0.b());
            interfaceC15121j27.k1(6, this.d.c.a(c15057iw0.h()));
            interfaceC15121j27.k1(7, this.d.d.b(c15057iw0.c()));
            interfaceC15121j27.k1(8, c15057iw0.d());
            interfaceC15121j27.U0(9, this.d.e.b(c15057iw0.f().a()));
            interfaceC15121j27.k1(10, this.d.f.a(r6.b()));
        }
    }

    /* renamed from: ir.nasim.gw0$b */
    public static final class b extends AbstractC11429cz6 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE  FROM call_log";
        }
    }

    /* renamed from: ir.nasim.gw0$c */
    public static final class c extends AbstractC11429cz6 {
        c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE from call_log WHERE id= ?";
        }
    }

    /* renamed from: ir.nasim.gw0$d */
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

    /* renamed from: ir.nasim.gw0$e */
    public static final class e implements Callable {
        e() {
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = C13857gw0.this.g.b();
            try {
                C13857gw0.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    C13857gw0.this.a.F();
                } finally {
                    C13857gw0.this.a.j();
                }
            } finally {
                C13857gw0.this.g.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gw0$f */
    public static final class f implements Callable {
        final /* synthetic */ long b;

        f(long j) {
            this.b = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = C13857gw0.this.h.b();
            interfaceC15121j27B.k1(1, this.b);
            try {
                C13857gw0.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    C13857gw0.this.a.F();
                } finally {
                    C13857gw0.this.a.j();
                }
            } finally {
                C13857gw0.this.h.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gw0$g */
    public static final class g implements Callable {
        final /* synthetic */ List a;
        final /* synthetic */ C13857gw0 b;

        g(List list, C13857gw0 c13857gw0) {
            this.a = list;
            this.b = c13857gw0;
        }

        public void a() {
            StringBuilder sbB = WY6.b();
            sbB.append("delete from call_log where id NOT in (");
            WY6.a(sbB, this.a.size());
            sbB.append(Separators.RPAREN);
            String string = sbB.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            InterfaceC15121j27 interfaceC15121j27G = this.b.a.g(string);
            Iterator it = this.a.iterator();
            int i = 1;
            while (it.hasNext()) {
                interfaceC15121j27G.k1(i, ((Number) it.next()).longValue());
                i++;
            }
            this.b.a.e();
            try {
                interfaceC15121j27G.V();
                this.b.a.F();
            } finally {
                this.b.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gw0$h */
    public static final class h implements Callable {
        final /* synthetic */ O26 b;

        h(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            Cursor cursorC = AbstractC7716Sx1.c(C13857gw0.this.a, this.b, false, null);
            try {
                Integer numValueOf = Integer.valueOf(cursorC.moveToFirst() ? cursorC.getInt(0) : 0);
                cursorC.close();
                return numValueOf;
            } catch (Throwable th) {
                cursorC.close();
                throw th;
            }
        }

        protected final void finalize() {
            this.b.j();
        }
    }

    /* renamed from: ir.nasim.gw0$i */
    public static final class i implements Callable {
        final /* synthetic */ List b;

        i(List list) {
            this.b = list;
        }

        public void a() {
            C13857gw0.this.a.e();
            try {
                C13857gw0.this.b.j(this.b);
                C13857gw0.this.a.F();
            } finally {
                C13857gw0.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gw0$j */
    public static final class j extends AbstractC25251zz3 {
        final /* synthetic */ C13857gw0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(O26 o26, C13857gw0 c13857gw0, D26 d26, String[] strArr) {
            super(o26, d26, strArr);
            this.f = c13857gw0;
        }

        @Override // ir.nasim.AbstractC25251zz3
        protected List n(Cursor cursor) {
            Cursor cursor2 = cursor;
            AbstractC13042fc3.i(cursor2, "cursor");
            int iE = AbstractC5795Kw1.e(cursor2, "time");
            int iE2 = AbstractC5795Kw1.e(cursor2, "duration");
            int iE3 = AbstractC5795Kw1.e(cursor2, "peer");
            int iE4 = AbstractC5795Kw1.e(cursor2, "initiator");
            int iE5 = AbstractC5795Kw1.e(cursor2, "finisher");
            int iE6 = AbstractC5795Kw1.e(cursor2, "personal_call_state");
            int iE7 = AbstractC5795Kw1.e(cursor2, "group_call_state");
            int iE8 = AbstractC5795Kw1.e(cursor2, "id");
            int iE9 = AbstractC5795Kw1.e(cursor2, "peersList");
            int iE10 = AbstractC5795Kw1.e(cursor2, "state");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                arrayList.add(new C15057iw0(cursor2.getLong(iE), cursor2.getLong(iE2), cursor2.getLong(iE3), cursor2.getLong(iE4), cursor2.getLong(iE5), this.f.c.b(cursor2.getInt(iE6)), this.f.d.a(cursor2.getInt(iE7)), new C4997Hl4(this.f.e.a(cursor2.getString(iE9)), this.f.f.b(cursor2.getInt(iE10))), cursor2.getLong(iE8)));
                cursor2 = cursor;
            }
            return arrayList;
        }
    }

    public C13857gw0(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.c = new C18705p65();
        this.d = new C12286eM2();
        this.e = new IntArrayTypeConverter();
        this.f = new C4046Dl4();
        this.a = d26;
        this.b = new a(d26, this);
        this.g = new b(d26);
        this.h = new c(d26);
    }

    @Override // ir.nasim.InterfaceC13266fw0
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new e(), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC13266fw0
    public Object b(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new i(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC13266fw0
    public Object d(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new f(j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC13266fw0
    public InterfaceC4557Fq2 e() {
        return androidx.room.a.a.a(this.a, false, new String[]{"call_log"}, new h(O26.i.a("SELECT COUNT(*) FROM call_log", 0)));
    }

    @Override // ir.nasim.InterfaceC13266fw0
    public YT4 f() {
        return new j(O26.i.a("SELECT * FROM call_log ORDER BY time DESC", 0), this, this.a, new String[]{"call_log"});
    }

    @Override // ir.nasim.InterfaceC13266fw0
    public Object g(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new g(list, this), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }
}
