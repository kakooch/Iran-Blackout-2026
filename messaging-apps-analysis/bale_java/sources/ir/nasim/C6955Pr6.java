package ir.nasim;

import android.database.Cursor;
import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.database.converters.ServicesTypeConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.Pr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6955Pr6 implements InterfaceC6721Or6 {
    public static final c e = new c(null);
    private final D26 a;
    private final AbstractC21126t92 b;
    private final ServicesTypeConverter c;
    private final AbstractC11429cz6 d;

    /* renamed from: ir.nasim.Pr6$a */
    public static final class a extends AbstractC21126t92 {
        final /* synthetic */ C6955Pr6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(D26 d26, C6955Pr6 c6955Pr6) {
            super(d26);
            this.d = c6955Pr6;
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR REPLACE INTO `service_items` (`id`,`title`,`icon`,`custom_icon`,`badge`,`action`,`peer_id`,`peer_type`,`url`,`event_key`,`event_name`,`section_id`,`min_app_version`,`max_app_version`,`menu_items`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, C5988Lr6 c5988Lr6) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(c5988Lr6, "entity");
            interfaceC15121j27.k1(1, c5988Lr6.g());
            interfaceC15121j27.U0(2, c5988Lr6.n());
            interfaceC15121j27.U0(3, c5988Lr6.f());
            String strC = c5988Lr6.c();
            if (strC == null) {
                interfaceC15121j27.y1(4);
            } else {
                interfaceC15121j27.U0(4, strC);
            }
            String strB = c5988Lr6.b();
            if (strB == null) {
                interfaceC15121j27.y1(5);
            } else {
                interfaceC15121j27.U0(5, strB);
            }
            interfaceC15121j27.k1(6, c5988Lr6.a());
            if (c5988Lr6.k() == null) {
                interfaceC15121j27.y1(7);
            } else {
                interfaceC15121j27.k1(7, r0.intValue());
            }
            if (c5988Lr6.l() == null) {
                interfaceC15121j27.y1(8);
            } else {
                interfaceC15121j27.k1(8, r0.intValue());
            }
            String strO = c5988Lr6.o();
            if (strO == null) {
                interfaceC15121j27.y1(9);
            } else {
                interfaceC15121j27.U0(9, strO);
            }
            String strD = c5988Lr6.d();
            if (strD == null) {
                interfaceC15121j27.y1(10);
            } else {
                interfaceC15121j27.U0(10, strD);
            }
            String strE = c5988Lr6.e();
            if (strE == null) {
                interfaceC15121j27.y1(11);
            } else {
                interfaceC15121j27.U0(11, strE);
            }
            interfaceC15121j27.k1(12, c5988Lr6.m());
            interfaceC15121j27.k1(13, c5988Lr6.j());
            interfaceC15121j27.k1(14, c5988Lr6.h());
            String strA = this.d.c.a(c5988Lr6.i());
            if (strA == null) {
                interfaceC15121j27.y1(15);
            } else {
                interfaceC15121j27.U0(15, strA);
            }
        }
    }

    /* renamed from: ir.nasim.Pr6$b */
    public static final class b extends AbstractC11429cz6 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM service_items";
        }
    }

    /* renamed from: ir.nasim.Pr6$c */
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

    /* renamed from: ir.nasim.Pr6$d */
    public static final class d implements Callable {
        d() {
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = C6955Pr6.this.d.b();
            try {
                C6955Pr6.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    C6955Pr6.this.a.F();
                } finally {
                    C6955Pr6.this.a.j();
                }
            } finally {
                C6955Pr6.this.d.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Pr6$e */
    public static final class e implements Callable {
        final /* synthetic */ O26 b;

        e(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() throws Throwable {
            int i;
            int i2;
            String string;
            int i3;
            Cursor cursorC = AbstractC7716Sx1.c(C6955Pr6.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "id");
                int iE2 = AbstractC5795Kw1.e(cursorC, "title");
                int iE3 = AbstractC5795Kw1.e(cursorC, ParameterNames.ICON);
                int iE4 = AbstractC5795Kw1.e(cursorC, "custom_icon");
                int iE5 = AbstractC5795Kw1.e(cursorC, "badge");
                int iE6 = AbstractC5795Kw1.e(cursorC, "action");
                int iE7 = AbstractC5795Kw1.e(cursorC, "peer_id");
                int iE8 = AbstractC5795Kw1.e(cursorC, "peer_type");
                int iE9 = AbstractC5795Kw1.e(cursorC, "url");
                int iE10 = AbstractC5795Kw1.e(cursorC, "event_key");
                int iE11 = AbstractC5795Kw1.e(cursorC, "event_name");
                int iE12 = AbstractC5795Kw1.e(cursorC, "section_id");
                int iE13 = AbstractC5795Kw1.e(cursorC, "min_app_version");
                int iE14 = AbstractC5795Kw1.e(cursorC, "max_app_version");
                try {
                    int iE15 = AbstractC5795Kw1.e(cursorC, "menu_items");
                    int i4 = iE14;
                    ArrayList arrayList = new ArrayList(cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        int i5 = cursorC.getInt(iE);
                        String string2 = cursorC.getString(iE2);
                        String string3 = cursorC.getString(iE3);
                        String string4 = cursorC.isNull(iE4) ? null : cursorC.getString(iE4);
                        String string5 = cursorC.isNull(iE5) ? null : cursorC.getString(iE5);
                        int i6 = cursorC.getInt(iE6);
                        Integer numValueOf = cursorC.isNull(iE7) ? null : Integer.valueOf(cursorC.getInt(iE7));
                        Integer numValueOf2 = cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8));
                        String string6 = cursorC.isNull(iE9) ? null : cursorC.getString(iE9);
                        String string7 = cursorC.isNull(iE10) ? null : cursorC.getString(iE10);
                        String string8 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        int i7 = cursorC.getInt(iE12);
                        int i8 = cursorC.getInt(iE13);
                        int i9 = i4;
                        int i10 = cursorC.getInt(i9);
                        int i11 = iE;
                        int i12 = iE15;
                        if (cursorC.isNull(i12)) {
                            i = i12;
                            i3 = iE2;
                            i2 = i9;
                            string = null;
                        } else {
                            i = i12;
                            i2 = i9;
                            string = cursorC.getString(i12);
                            i3 = iE2;
                        }
                        try {
                            arrayList.add(new C5988Lr6(i5, string2, string3, string4, string5, i6, numValueOf, numValueOf2, string6, string7, string8, i7, i8, i10, C6955Pr6.this.c.b(string)));
                            iE2 = i3;
                            iE = i11;
                            iE15 = i;
                            i4 = i2;
                        } catch (Throwable th) {
                            th = th;
                            cursorC.close();
                            throw th;
                        }
                    }
                    cursorC.close();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        protected final void finalize() {
            this.b.j();
        }
    }

    /* renamed from: ir.nasim.Pr6$f */
    public static final class f implements Callable {
        final /* synthetic */ List b;

        f(List list) {
            this.b = list;
        }

        public void a() {
            C6955Pr6.this.a.e();
            try {
                C6955Pr6.this.b.j(this.b);
                C6955Pr6.this.a.F();
            } finally {
                C6955Pr6.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Pr6$g */
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
            return C6955Pr6.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6955Pr6 c6955Pr6 = C6955Pr6.this;
                List list = this.d;
                this.b = 1;
                if (C6955Pr6.super.b(list, this) == objE) {
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

    public C6955Pr6(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.c = new ServicesTypeConverter();
        this.a = d26;
        this.b = new a(d26, this);
        this.d = new b(d26);
    }

    @Override // ir.nasim.InterfaceC6721Or6
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new d(), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC6721Or6
    public Object b(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.a, new g(list, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC6721Or6
    public Object c(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new f(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC6721Or6
    public InterfaceC4557Fq2 e() {
        return androidx.room.a.a.a(this.a, false, new String[]{"service_items"}, new e(O26.i.a("SELECT * FROM service_items", 0)));
    }
}
