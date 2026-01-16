package ir.nasim;

import ir.nasim.ID1;
import java.sql.Date;
import java.sql.Timestamp;

/* renamed from: ir.nasim.uJ6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC21895uJ6 {
    public static final boolean a;
    public static final ID1.b b;
    public static final ID1.b c;
    public static final InterfaceC6537Nx7 d;
    public static final InterfaceC6537Nx7 e;
    public static final InterfaceC6537Nx7 f;

    /* renamed from: ir.nasim.uJ6$a */
    class a extends ID1.b {
        a(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.ID1.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Date d(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    /* renamed from: ir.nasim.uJ6$b */
    class b extends ID1.b {
        b(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.ID1.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Timestamp d(java.util.Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        a = z;
        if (z) {
            b = new a(Date.class);
            c = new b(Timestamp.class);
            d = C20009rJ6.b;
            e = C20618sJ6.b;
            f = C21221tJ6.b;
            return;
        }
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
    }
}
