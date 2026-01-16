package ir.nasim;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.Vs7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8384Vs7 implements InterfaceC8150Us7 {
    public static final d e = new d(null);
    private final D26 a;
    private final AbstractC21126t92 b;
    private final AbstractC11429cz6 c;
    private final AbstractC11429cz6 d;

    /* renamed from: ir.nasim.Vs7$a */
    public static final class a extends AbstractC21126t92 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR REPLACE INTO `top-peer` (`id`,`peerId`,`score`) VALUES (nullif(?, 0),?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, C4580Fs7 c4580Fs7) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(c4580Fs7, "entity");
            interfaceC15121j27.k1(1, c4580Fs7.a());
            interfaceC15121j27.k1(2, c4580Fs7.b());
            interfaceC15121j27.k1(3, c4580Fs7.c());
        }
    }

    /* renamed from: ir.nasim.Vs7$b */
    public static final class b extends AbstractC11429cz6 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM `top-peer` WHERE peerId = ?";
        }
    }

    /* renamed from: ir.nasim.Vs7$c */
    public static final class c extends AbstractC11429cz6 {
        c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM `top-peer`";
        }
    }

    /* renamed from: ir.nasim.Vs7$d */
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

    /* renamed from: ir.nasim.Vs7$e */
    public static final class e implements Callable {
        e() {
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = C8384Vs7.this.d.b();
            try {
                C8384Vs7.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    C8384Vs7.this.a.F();
                } finally {
                    C8384Vs7.this.a.j();
                }
            } finally {
                C8384Vs7.this.d.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vs7$f */
    public static final class f implements Callable {
        final /* synthetic */ List b;

        f(List list) {
            this.b = list;
        }

        public void a() {
            C8384Vs7.this.a.e();
            try {
                C8384Vs7.this.b.j(this.b);
                C8384Vs7.this.a.F();
            } finally {
                C8384Vs7.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vs7$g */
    public static final class g implements Callable {
        final /* synthetic */ O26 b;

        g(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(C8384Vs7.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "id");
                int iE2 = AbstractC5795Kw1.e(cursorC, "peerId");
                int iE3 = AbstractC5795Kw1.e(cursorC, "score");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new C4580Fs7(cursorC.getInt(iE), cursorC.getLong(iE2), cursorC.getLong(iE3)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    /* renamed from: ir.nasim.Vs7$h */
    public static final class h implements Callable {
        final /* synthetic */ long b;

        h(long j) {
            this.b = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = C8384Vs7.this.c.b();
            interfaceC15121j27B.k1(1, this.b);
            try {
                C8384Vs7.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    C8384Vs7.this.a.F();
                } finally {
                    C8384Vs7.this.a.j();
                }
            } finally {
                C8384Vs7.this.c.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public C8384Vs7(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.a = d26;
        this.b = new a(d26);
        this.c = new b(d26);
        this.d = new c(d26);
    }

    @Override // ir.nasim.InterfaceC8150Us7
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new e(), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC8150Us7
    public Object b(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new f(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC8150Us7
    public Object c(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new h(j), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC8150Us7
    public Object d(InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM `top-peer` ORDER BY score DESC", 0);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new g(o26A), interfaceC20295rm1);
    }
}
