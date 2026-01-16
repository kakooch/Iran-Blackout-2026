package ir.nasim;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.Kb6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5611Kb6 implements InterfaceC5377Jb6 {
    public static final c d = new c(null);
    private final D26 a;
    private final AbstractC21126t92 b;
    private final AbstractC11429cz6 c;

    /* renamed from: ir.nasim.Kb6$a */
    public static final class a extends AbstractC21126t92 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR REPLACE INTO `saved_gifs` (`id`,`file_id`,`access_hash`,`file_storage_version`,`width`,`height`,`file_size`,`duration`,`used_at`,`mime_type`,`thumb`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, C5845Lb6 c5845Lb6) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(c5845Lb6, "entity");
            interfaceC15121j27.k1(1, c5845Lb6.g());
            interfaceC15121j27.k1(2, c5845Lb6.c());
            interfaceC15121j27.k1(3, c5845Lb6.a());
            interfaceC15121j27.k1(4, c5845Lb6.e());
            interfaceC15121j27.k1(5, c5845Lb6.k());
            interfaceC15121j27.k1(6, c5845Lb6.f());
            interfaceC15121j27.k1(7, c5845Lb6.d());
            interfaceC15121j27.k1(8, c5845Lb6.b());
            interfaceC15121j27.k1(9, c5845Lb6.j());
            String strH = c5845Lb6.h();
            if (strH == null) {
                interfaceC15121j27.y1(10);
            } else {
                interfaceC15121j27.U0(10, strH);
            }
            byte[] bArrI = c5845Lb6.i();
            if (bArrI == null) {
                interfaceC15121j27.y1(11);
            } else {
                interfaceC15121j27.n1(11, bArrI);
            }
        }
    }

    /* renamed from: ir.nasim.Kb6$b */
    public static final class b extends AbstractC11429cz6 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM saved_gifs";
        }
    }

    /* renamed from: ir.nasim.Kb6$c */
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

    /* renamed from: ir.nasim.Kb6$d */
    public static final class d implements Callable {
        d() {
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = C5611Kb6.this.c.b();
            try {
                C5611Kb6.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    C5611Kb6.this.a.F();
                } finally {
                    C5611Kb6.this.a.j();
                }
            } finally {
                C5611Kb6.this.c.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Kb6$e */
    public static final class e implements Callable {
        final /* synthetic */ O26 b;

        e(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(C5611Kb6.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "id");
                int iE2 = AbstractC5795Kw1.e(cursorC, "file_id");
                int iE3 = AbstractC5795Kw1.e(cursorC, "access_hash");
                int iE4 = AbstractC5795Kw1.e(cursorC, "file_storage_version");
                int iE5 = AbstractC5795Kw1.e(cursorC, "width");
                int iE6 = AbstractC5795Kw1.e(cursorC, "height");
                int iE7 = AbstractC5795Kw1.e(cursorC, "file_size");
                int iE8 = AbstractC5795Kw1.e(cursorC, "duration");
                int iE9 = AbstractC5795Kw1.e(cursorC, "used_at");
                int iE10 = AbstractC5795Kw1.e(cursorC, "mime_type");
                int iE11 = AbstractC5795Kw1.e(cursorC, "thumb");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new C5845Lb6(cursorC.getInt(iE), cursorC.getLong(iE2), cursorC.getLong(iE3), cursorC.getInt(iE4), cursorC.getInt(iE5), cursorC.getInt(iE6), cursorC.getLong(iE7), cursorC.getInt(iE8), cursorC.getLong(iE9), cursorC.isNull(iE10) ? null : cursorC.getString(iE10), cursorC.isNull(iE11) ? null : cursorC.getBlob(iE11)));
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

    /* renamed from: ir.nasim.Kb6$f */
    public static final class f implements Callable {
        final /* synthetic */ List b;

        f(List list) {
            this.b = list;
        }

        public void a() {
            C5611Kb6.this.a.e();
            try {
                C5611Kb6.this.b.j(this.b);
                C5611Kb6.this.a.F();
            } finally {
                C5611Kb6.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Kb6$g */
    static final class g extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C5611Kb6.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C5611Kb6 c5611Kb6 = C5611Kb6.this;
                List list = this.d;
                this.b = 1;
                if (C5611Kb6.super.b(list, this) == objE) {
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
            return ((g) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C5611Kb6(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.a = d26;
        this.b = new a(d26);
        this.c = new b(d26);
    }

    @Override // ir.nasim.InterfaceC5377Jb6
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new d(), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC5377Jb6
    public Object b(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.a, new g(list, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC5377Jb6
    public Object c(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new f(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC5377Jb6
    public InterfaceC4557Fq2 d() {
        return androidx.room.a.a.a(this.a, false, new String[]{"saved_gifs"}, new e(O26.i.a("SELECT * FROM saved_gifs", 0)));
    }
}
