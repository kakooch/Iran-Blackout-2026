package ir.nasim;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.q25, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19256q25 implements InterfaceC18665p25 {
    public static final b c = new b(null);
    private final D26 a;
    private final AbstractC21126t92 b;

    /* renamed from: ir.nasim.q25$a */
    public static final class a extends AbstractC21126t92 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR REPLACE INTO `peer_click` (`id`,`peerId`,`clickCounts`) VALUES (nullif(?, 0),?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, C19847r25 c19847r25) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(c19847r25, "entity");
            interfaceC15121j27.k1(1, c19847r25.d());
            interfaceC15121j27.k1(2, c19847r25.e());
            interfaceC15121j27.k1(3, c19847r25.c());
        }
    }

    /* renamed from: ir.nasim.q25$b */
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

    /* renamed from: ir.nasim.q25$c */
    public static final class c implements Callable {
        final /* synthetic */ O26 b;

        c(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(C19256q25.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "id");
                int iE2 = AbstractC5795Kw1.e(cursorC, "peerId");
                int iE3 = AbstractC5795Kw1.e(cursorC, "clickCounts");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new C19847r25(cursorC.getInt(iE), cursorC.getLong(iE2), cursorC.getLong(iE3)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    /* renamed from: ir.nasim.q25$d */
    public static final class d implements Callable {
        final /* synthetic */ O26 b;

        d(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C19847r25 call() {
            Cursor cursorC = AbstractC7716Sx1.c(C19256q25.this.a, this.b, false, null);
            try {
                return cursorC.moveToFirst() ? new C19847r25(cursorC.getInt(AbstractC5795Kw1.e(cursorC, "id")), cursorC.getLong(AbstractC5795Kw1.e(cursorC, "peerId")), cursorC.getLong(AbstractC5795Kw1.e(cursorC, "clickCounts"))) : null;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    /* renamed from: ir.nasim.q25$e */
    public static final class e implements Callable {
        final /* synthetic */ C19847r25 b;

        e(C19847r25 c19847r25) {
            this.b = c19847r25;
        }

        public void a() {
            C19256q25.this.a.e();
            try {
                C19256q25.this.b.k(this.b);
                C19256q25.this.a.F();
            } finally {
                C19256q25.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.q25$f */
    static final class f extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C19256q25.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19256q25 c19256q25 = C19256q25.this;
                long j = this.d;
                this.b = 1;
                if (C19256q25.super.c(j, this) == objE) {
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
            return ((f) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C19256q25(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.a = d26;
        this.b = new a(d26);
    }

    @Override // ir.nasim.InterfaceC18665p25
    public Object a(C19847r25 c19847r25, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new e(c19847r25), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC18665p25
    public Object c(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.a, new f(j, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC18665p25
    public Object d(InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM `peer_click`", 0);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new c(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC18665p25
    public Object e(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM `peer_click` WHERE peerId = ? LIMIT 1", 1);
        o26A.k1(1, j);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new d(o26A), interfaceC20295rm1);
    }
}
