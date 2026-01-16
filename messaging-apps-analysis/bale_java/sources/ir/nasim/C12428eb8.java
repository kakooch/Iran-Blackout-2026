package ir.nasim;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.eb8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12428eb8 implements InterfaceC11816db8 {
    private final D26 a;
    private final AbstractC21126t92 b;

    /* renamed from: ir.nasim.eb8$a */
    class a extends AbstractC21126t92 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, C11021cb8 c11021cb8) {
            String str = c11021cb8.a;
            if (str == null) {
                interfaceC15121j27.y1(1);
            } else {
                interfaceC15121j27.U0(1, str);
            }
            String str2 = c11021cb8.b;
            if (str2 == null) {
                interfaceC15121j27.y1(2);
            } else {
                interfaceC15121j27.U0(2, str2);
            }
        }
    }

    public C12428eb8(D26 d26) {
        this.a = d26;
        this.b = new a(d26);
    }

    @Override // ir.nasim.InterfaceC11816db8
    public List a(String str) {
        O26 o26C = O26.c("SELECT name FROM workname WHERE work_spec_id=?", 1);
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

    @Override // ir.nasim.InterfaceC11816db8
    public void b(C11021cb8 c11021cb8) {
        this.a.d();
        this.a.e();
        try {
            this.b.k(c11021cb8);
            this.a.F();
        } finally {
            this.a.j();
        }
    }
}
