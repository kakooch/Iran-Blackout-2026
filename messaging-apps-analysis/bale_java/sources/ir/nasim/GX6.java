package ir.nasim;

import android.database.Cursor;
import ir.nasim.database.model.story.WidgetCoordinateConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class GX6 implements FX6 {
    public static final d g = new d(null);
    private final D26 a;
    private final AbstractC21126t92 b;
    private final C9402Zt7 c;
    private final WidgetCoordinateConverter d;
    private final AbstractC19914r92 e;
    private final AbstractC11429cz6 f;

    public static final class a extends AbstractC21126t92 {
        final /* synthetic */ GX6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(D26 d26, GX6 gx6) {
            super(d26);
            this.d = gx6;
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR REPLACE INTO `story_widget` (`id`,`story_id`,`trait_case`,`widget_data`,`expiration_date`,`coordinates`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, HX6 hx6) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(hx6, "entity");
            interfaceC15121j27.k1(1, hx6.c());
            interfaceC15121j27.U0(2, hx6.d());
            String strB = this.d.c.b(hx6.e());
            if (strB == null) {
                interfaceC15121j27.y1(3);
            } else {
                interfaceC15121j27.U0(3, strB);
            }
            interfaceC15121j27.U0(4, hx6.f());
            interfaceC15121j27.k1(5, hx6.b());
            String strB2 = this.d.d.b(hx6.a());
            if (strB2 == null) {
                interfaceC15121j27.y1(6);
            } else {
                interfaceC15121j27.U0(6, strB2);
            }
        }
    }

    public static final class b extends AbstractC19914r92 {
        final /* synthetic */ GX6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(D26 d26, GX6 gx6) {
            super(d26);
            this.d = gx6;
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "UPDATE OR ABORT `story_widget` SET `id` = ?,`story_id` = ?,`trait_case` = ?,`widget_data` = ?,`expiration_date` = ?,`coordinates` = ? WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC19914r92
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, HX6 hx6) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(hx6, "entity");
            interfaceC15121j27.k1(1, hx6.c());
            interfaceC15121j27.U0(2, hx6.d());
            String strB = this.d.c.b(hx6.e());
            if (strB == null) {
                interfaceC15121j27.y1(3);
            } else {
                interfaceC15121j27.U0(3, strB);
            }
            interfaceC15121j27.U0(4, hx6.f());
            interfaceC15121j27.k1(5, hx6.b());
            String strB2 = this.d.d.b(hx6.a());
            if (strB2 == null) {
                interfaceC15121j27.y1(6);
            } else {
                interfaceC15121j27.U0(6, strB2);
            }
            interfaceC15121j27.k1(7, hx6.c());
        }
    }

    public static final class c extends AbstractC11429cz6 {
        c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM story_widget WHERE expiration_date < ?";
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
        final /* synthetic */ long b;

        e(long j) {
            this.b = j;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            InterfaceC15121j27 interfaceC15121j27B = GX6.this.f.b();
            interfaceC15121j27B.k1(1, this.b);
            try {
                GX6.this.a.e();
                try {
                    int iV = interfaceC15121j27B.V();
                    GX6.this.a.F();
                    return Integer.valueOf(iV);
                } finally {
                    GX6.this.a.j();
                }
            } finally {
                GX6.this.f.h(interfaceC15121j27B);
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
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(GX6.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "id");
                int iE2 = AbstractC5795Kw1.e(cursorC, "story_id");
                int iE3 = AbstractC5795Kw1.e(cursorC, "trait_case");
                int iE4 = AbstractC5795Kw1.e(cursorC, "widget_data");
                int iE5 = AbstractC5795Kw1.e(cursorC, "expiration_date");
                int iE6 = AbstractC5795Kw1.e(cursorC, "coordinates");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    int i = cursorC.getInt(iE);
                    String string = cursorC.getString(iE2);
                    EnumC9168Yt7 enumC9168Yt7A = GX6.this.c.a(cursorC.isNull(iE3) ? null : cursorC.getString(iE3));
                    if (enumC9168Yt7A == null) {
                        throw new IllegalStateException("Expected NON-NULL 'ir.nasim.database.model.story.TraitCase', but it was NULL.".toString());
                    }
                    arrayList.add(new HX6(i, string, enumC9168Yt7A, cursorC.getString(iE4), cursorC.getLong(iE5), GX6.this.d.a(cursorC.isNull(iE6) ? null : cursorC.getString(iE6))));
                }
                cursorC.close();
                this.b.j();
                return arrayList;
            } catch (Throwable th) {
                cursorC.close();
                this.b.j();
                throw th;
            }
        }
    }

    public static final class g implements Callable {
        final /* synthetic */ HX6[] b;

        g(HX6[] hx6Arr) {
            this.b = hx6Arr;
        }

        public void a() {
            GX6.this.a.e();
            try {
                GX6.this.b.l(this.b);
                GX6.this.a.F();
            } finally {
                GX6.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public GX6(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.c = new C9402Zt7();
        this.d = new WidgetCoordinateConverter();
        this.a = d26;
        this.b = new a(d26, this);
        this.e = new b(d26, this);
        this.f = new c(d26);
    }

    @Override // ir.nasim.FX6
    public Object a(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return androidx.room.a.a.c(this.a, true, new e(j), interfaceC20295rm1);
    }

    @Override // ir.nasim.FX6
    public Object b(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM story_widget WHERE story_id =?", 1);
        o26A.U0(1, str);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new f(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.FX6
    public Object c(HX6[] hx6Arr, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new g(hx6Arr), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }
}
