package ir.nasim;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.eI1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12249eI1 implements InterfaceC11606dI1 {
    private final D26 a;
    private final AbstractC21126t92 b;

    /* renamed from: ir.nasim.eI1$a */
    class a extends AbstractC21126t92 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, C9632aI1 c9632aI1) {
            String str = c9632aI1.a;
            if (str == null) {
                interfaceC15121j27.y1(1);
            } else {
                interfaceC15121j27.U0(1, str);
            }
            String str2 = c9632aI1.b;
            if (str2 == null) {
                interfaceC15121j27.y1(2);
            } else {
                interfaceC15121j27.U0(2, str2);
            }
        }
    }

    public C12249eI1(D26 d26) {
        this.a = d26;
        this.b = new a(d26);
    }

    @Override // ir.nasim.InterfaceC11606dI1
    public void a(C9632aI1 c9632aI1) {
        this.a.d();
        this.a.e();
        try {
            this.b.k(c9632aI1);
            this.a.F();
        } finally {
            this.a.j();
        }
    }

    @Override // ir.nasim.InterfaceC11606dI1
    public List b(String str) {
        O26 o26C = O26.c("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            o26C.y1(1);
        } else {
            o26C.U0(1, str);
        }
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

    @Override // ir.nasim.InterfaceC11606dI1
    public boolean c(String str) {
        O26 o26C = O26.c("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            o26C.y1(1);
        } else {
            o26C.U0(1, str);
        }
        this.a.d();
        boolean z = false;
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            if (cursorC.moveToFirst()) {
                z = cursorC.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorC.close();
            o26C.j();
        }
    }

    @Override // ir.nasim.InterfaceC11606dI1
    public boolean d(String str) {
        O26 o26C = O26.c("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            o26C.y1(1);
        } else {
            o26C.U0(1, str);
        }
        this.a.d();
        boolean z = false;
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26C, false, null);
        try {
            if (cursorC.moveToFirst()) {
                z = cursorC.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorC.close();
            o26C.j();
        }
    }
}
