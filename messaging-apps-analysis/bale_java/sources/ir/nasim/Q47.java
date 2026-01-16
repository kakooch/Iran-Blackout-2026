package ir.nasim;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class Q47 implements P47 {
    private final D26 a;
    private final AbstractC21126t92 b;
    private final AbstractC11429cz6 c;

    class a extends AbstractC21126t92 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }

        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, O47 o47) {
            String str = o47.a;
            if (str == null) {
                interfaceC15121j27.y1(1);
            } else {
                interfaceC15121j27.U0(1, str);
            }
            interfaceC15121j27.k1(2, o47.b);
        }
    }

    class b extends AbstractC11429cz6 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public Q47(D26 d26) {
        this.a = d26;
        this.b = new a(d26);
        this.c = new b(d26);
    }

    @Override // ir.nasim.P47
    public void a(O47 o47) {
        this.a.d();
        this.a.e();
        try {
            this.b.k(o47);
            this.a.F();
        } finally {
            this.a.j();
        }
    }

    @Override // ir.nasim.P47
    public O47 b(String str) {
        O26 o26C = O26.c("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            o26C.y1(1);
        } else {
            o26C.U0(1, str);
        }
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            return cursorC.moveToFirst() ? new O47(cursorC.getString(AbstractC5795Kw1.e(cursorC, "work_spec_id")), cursorC.getInt(AbstractC5795Kw1.e(cursorC, "system_id"))) : null;
        } finally {
            cursorC.close();
            o26C.j();
        }
    }

    @Override // ir.nasim.P47
    public List c() {
        O26 o26C = O26.c("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorC.getCount());
            while (cursorC.moveToNext()) {
                arrayList.add(cursorC.getString(0));
            }
            return arrayList;
        } finally {
            cursorC.close();
            o26C.j();
        }
    }

    @Override // ir.nasim.P47
    public void d(String str) {
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.c.b();
        if (str == null) {
            interfaceC15121j27B.y1(1);
        } else {
            interfaceC15121j27B.U0(1, str);
        }
        this.a.e();
        try {
            interfaceC15121j27B.V();
            this.a.F();
        } finally {
            this.a.j();
            this.c.h(interfaceC15121j27B);
        }
    }
}
