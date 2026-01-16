package ir.nasim;

import android.database.Cursor;
import ir.nasim.database.model.file.FileState;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class WY1 implements UY1 {
    public static final e g = new e(null);
    private final D26 a;
    private final AbstractC21126t92 b;
    private final InterfaceC9173Yu3 c;
    private final AbstractC19914r92 d;
    private final AbstractC11429cz6 e;
    private final AbstractC11429cz6 f;

    public static final class a extends AbstractC21126t92 {
        final /* synthetic */ WY1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(D26 d26, WY1 wy1) {
            super(d26);
            this.d = wy1;
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR REPLACE INTO `download_state` (`file_id`,`access_hash`,`file_name`,`file_size`,`file_path`,`file_state`) VALUES (?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, XY1 xy1) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(xy1, "entity");
            interfaceC15121j27.k1(1, xy1.d());
            interfaceC15121j27.k1(2, xy1.c());
            interfaceC15121j27.U0(3, xy1.e());
            interfaceC15121j27.k1(4, xy1.g());
            interfaceC15121j27.U0(5, xy1.f());
            interfaceC15121j27.U0(6, this.d.m().a(xy1.h()));
        }
    }

    public static final class b extends AbstractC19914r92 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "DELETE FROM `download_state` WHERE `file_id` = ? AND `access_hash` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC19914r92
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, C21564tl2 c21564tl2) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(c21564tl2, "entity");
            interfaceC15121j27.k1(1, c21564tl2.b());
            interfaceC15121j27.k1(2, c21564tl2.a());
        }
    }

    public static final class c extends AbstractC11429cz6 {
        c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM download_state";
        }
    }

    public static final class d extends AbstractC11429cz6 {
        d(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE sqlite_sequence SET seq = 0 WHERE name = 'download_state'";
        }
    }

    public static final class e {
        private e() {
        }

        public final List a() {
            return AbstractC9766aX0.e(C19323q92.class);
        }

        public /* synthetic */ e(ED1 ed1) {
            this();
        }
    }

    public static final class f implements Callable {
        final /* synthetic */ C21564tl2 b;

        f(C21564tl2 c21564tl2) {
            this.b = c21564tl2;
        }

        public void a() {
            WY1.this.a.e();
            try {
                WY1.this.d.j(this.b);
                WY1.this.a.F();
            } finally {
                WY1.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class g implements Callable {
        final /* synthetic */ List b;

        g(List list) {
            this.b = list;
        }

        public void a() {
            WY1.this.a.e();
            try {
                WY1.this.d.k(this.b);
                WY1.this.a.F();
            } finally {
                WY1.this.a.j();
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
            InterfaceC15121j27 interfaceC15121j27B = WY1.this.e.b();
            try {
                WY1.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    WY1.this.a.F();
                } finally {
                    WY1.this.a.j();
                }
            } finally {
                WY1.this.e.h(interfaceC15121j27B);
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
        public XY1 call() {
            XY1 xy1 = null;
            Cursor cursorC = AbstractC7716Sx1.c(WY1.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "file_id");
                int iE2 = AbstractC5795Kw1.e(cursorC, "access_hash");
                int iE3 = AbstractC5795Kw1.e(cursorC, "file_name");
                int iE4 = AbstractC5795Kw1.e(cursorC, "file_size");
                int iE5 = AbstractC5795Kw1.e(cursorC, "file_path");
                int iE6 = AbstractC5795Kw1.e(cursorC, "file_state");
                if (cursorC.moveToFirst()) {
                    long j = cursorC.getLong(iE);
                    long j2 = cursorC.getLong(iE2);
                    String string = cursorC.getString(iE3);
                    long j3 = cursorC.getLong(iE4);
                    String string2 = cursorC.getString(iE5);
                    FileState fileStateB = WY1.this.m().b(cursorC.getString(iE6));
                    if (fileStateB == null) {
                        throw new IllegalStateException("Expected NON-NULL 'ir.nasim.database.model.`file`.FileState', but it was NULL.".toString());
                    }
                    xy1 = new XY1(j, j2, string, j3, string2, fileStateB);
                }
                cursorC.close();
                this.b.j();
                return xy1;
            } catch (Throwable th) {
                cursorC.close();
                this.b.j();
                throw th;
            }
        }
    }

    static final class j extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ XY1 d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(XY1 xy1, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = xy1;
            this.e = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return WY1.this.new j(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                WY1 wy1 = WY1.this;
                XY1 xy1 = this.d;
                long j = this.e;
                this.b = 1;
                if (WY1.super.e(xy1, j, this) == objE) {
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
            return ((j) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class k implements Callable {
        k() {
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = WY1.this.f.b();
            try {
                WY1.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    WY1.this.a.F();
                } finally {
                    WY1.this.a.j();
                }
            } finally {
                WY1.this.f.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    static final class l extends AbstractC19859r37 implements UA2 {
        int b;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return WY1.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                WY1 wy1 = WY1.this;
                this.b = 1;
                if (WY1.super.b(this) == objE) {
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
            return ((l) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class m implements Callable {
        final /* synthetic */ XY1[] b;

        m(XY1[] xy1Arr) {
            this.b = xy1Arr;
        }

        public void a() {
            WY1.this.a.e();
            try {
                WY1.this.b.l(this.b);
                WY1.this.a.F();
            } finally {
                WY1.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class n implements Callable {
        final /* synthetic */ List b;

        n(List list) {
            this.b = list;
        }

        public void a() {
            WY1.this.a.e();
            try {
                WY1.this.b.j(this.b);
                WY1.this.a.F();
            } finally {
                WY1.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public WY1(final D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.VY1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return WY1.n(d26);
            }
        });
        this.a = d26;
        this.b = new a(d26, this);
        this.d = new b(d26);
        this.e = new c(d26);
        this.f = new d(d26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C19323q92 m() {
        return (C19323q92) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19323q92 n(D26 d26) {
        AbstractC13042fc3.i(d26, "$__db");
        Object objU = d26.u(C19323q92.class);
        if (objU != null) {
            return (C19323q92) objU;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // ir.nasim.UY1
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new h(), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.UY1
    public Object b(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.a, new l(null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.UY1
    public Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new k(), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.UY1
    public Object d(XY1[] xy1Arr, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new m(xy1Arr), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.UY1
    public Object e(XY1 xy1, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.a, new j(xy1, j2, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.UY1
    public Object f(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new g(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.UY1
    public Object g(C21564tl2 c21564tl2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new f(c21564tl2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.UY1
    public Object h(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new n(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.UY1
    public Object i(long j2, long j3, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM download_state WHERE ? = file_id AND ? = access_hash", 2);
        o26A.k1(1, j2);
        o26A.k1(2, j3);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new i(o26A), interfaceC20295rm1);
    }
}
