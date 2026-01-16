package ir.nasim;

import android.database.Cursor;

/* renamed from: ir.nasim.jk5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15533jk5 implements InterfaceC14943ik5 {
    private final D26 a;
    private final AbstractC21126t92 b;

    /* renamed from: ir.nasim.jk5$a */
    class a extends AbstractC21126t92 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, C13742gk5 c13742gk5) {
            String str = c13742gk5.a;
            if (str == null) {
                interfaceC15121j27.y1(1);
            } else {
                interfaceC15121j27.U0(1, str);
            }
            Long l = c13742gk5.b;
            if (l == null) {
                interfaceC15121j27.y1(2);
            } else {
                interfaceC15121j27.k1(2, l.longValue());
            }
        }
    }

    public C15533jk5(D26 d26) {
        this.a = d26;
        this.b = new a(d26);
    }

    @Override // ir.nasim.InterfaceC14943ik5
    public void a(C13742gk5 c13742gk5) {
        this.a.d();
        this.a.e();
        try {
            this.b.k(c13742gk5);
            this.a.F();
        } finally {
            this.a.j();
        }
    }

    @Override // ir.nasim.InterfaceC14943ik5
    public Long b(String str) {
        O26 o26C = O26.c("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            o26C.y1(1);
        } else {
            o26C.U0(1, str);
        }
        this.a.d();
        Long lValueOf = null;
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            if (cursorC.moveToFirst() && !cursorC.isNull(0)) {
                lValueOf = Long.valueOf(cursorC.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorC.close();
            o26C.j();
        }
    }
}
