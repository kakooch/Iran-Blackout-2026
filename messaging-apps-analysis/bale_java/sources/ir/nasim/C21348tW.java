package ir.nasim;

import android.database.Cursor;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.tW, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21348tW implements InterfaceC20728sW {
    public static final b c = new b(null);
    private final D26 a;
    private final AbstractC21126t92 b;

    /* renamed from: ir.nasim.tW$a */
    public static final class a extends AbstractC21126t92 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR REPLACE INTO `premium_badges` (`badgeId`,`url`,`mediaFormat`,`downloadedContent`) VALUES (?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, C5457Jk5 c5457Jk5) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(c5457Jk5, "entity");
            interfaceC15121j27.k1(1, c5457Jk5.a());
            interfaceC15121j27.U0(2, c5457Jk5.d());
            interfaceC15121j27.k1(3, c5457Jk5.c());
            byte[] bArrB = c5457Jk5.b();
            if (bArrB == null) {
                interfaceC15121j27.y1(4);
            } else {
                interfaceC15121j27.n1(4, bArrB);
            }
        }
    }

    /* renamed from: ir.nasim.tW$b */
    public static final class b {
        private b() {
        }

        public final List a() {
            return AbstractC10360bX0.m();
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.tW$c */
    public static final class c implements Callable {
        final /* synthetic */ O26 b;

        c(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C5457Jk5 call() {
            C5457Jk5 c5457Jk5 = null;
            Cursor cursorC = AbstractC7716Sx1.c(C21348tW.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "badgeId");
                int iE2 = AbstractC5795Kw1.e(cursorC, "url");
                int iE3 = AbstractC5795Kw1.e(cursorC, "mediaFormat");
                int iE4 = AbstractC5795Kw1.e(cursorC, "downloadedContent");
                if (cursorC.moveToFirst()) {
                    c5457Jk5 = new C5457Jk5(cursorC.getLong(iE), cursorC.getString(iE2), cursorC.getInt(iE3), cursorC.isNull(iE4) ? null : cursorC.getBlob(iE4));
                }
                return c5457Jk5;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    /* renamed from: ir.nasim.tW$d */
    public static final class d implements Callable {
        final /* synthetic */ O26 b;

        d(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C5457Jk5 call() {
            C5457Jk5 c5457Jk5 = null;
            Cursor cursorC = AbstractC7716Sx1.c(C21348tW.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "badgeId");
                int iE2 = AbstractC5795Kw1.e(cursorC, "url");
                int iE3 = AbstractC5795Kw1.e(cursorC, "mediaFormat");
                int iE4 = AbstractC5795Kw1.e(cursorC, "downloadedContent");
                if (cursorC.moveToFirst()) {
                    c5457Jk5 = new C5457Jk5(cursorC.getLong(iE), cursorC.getString(iE2), cursorC.getInt(iE3), cursorC.isNull(iE4) ? null : cursorC.getBlob(iE4));
                }
                return c5457Jk5;
            } finally {
                cursorC.close();
            }
        }

        protected final void finalize() {
            this.b.j();
        }
    }

    /* renamed from: ir.nasim.tW$e */
    public static final class e implements Callable {
        final /* synthetic */ C5457Jk5 b;

        e(C5457Jk5 c5457Jk5) {
            this.b = c5457Jk5;
        }

        public void a() {
            C21348tW.this.a.e();
            try {
                C21348tW.this.b.k(this.b);
                C21348tW.this.a.F();
            } finally {
                C21348tW.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public C21348tW(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.a = d26;
        this.b = new a(d26);
    }

    @Override // ir.nasim.InterfaceC20728sW
    public Object a(long j, String str, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM premium_badges WHERE badgeId = ? And url = ?", 2);
        o26A.k1(1, j);
        o26A.U0(2, str);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new c(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC20728sW
    public InterfaceC4557Fq2 b(long j, String str) {
        AbstractC13042fc3.i(str, "url");
        O26 o26A = O26.i.a("SELECT * FROM premium_badges WHERE badgeId = ? And url = ?", 2);
        o26A.k1(1, j);
        o26A.U0(2, str);
        return androidx.room.a.a.a(this.a, false, new String[]{"premium_badges"}, new d(o26A));
    }

    @Override // ir.nasim.InterfaceC20728sW
    public Object c(C5457Jk5 c5457Jk5, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new e(c5457Jk5), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }
}
