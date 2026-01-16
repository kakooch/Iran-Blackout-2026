package ir.nasim.features.smiles.panel.emoji.db;

import android.database.Cursor;
import android.gov.nist.core.Separators;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21126t92;
import ir.nasim.AbstractC5795Kw1;
import ir.nasim.AbstractC7716Sx1;
import ir.nasim.C10731c62;
import ir.nasim.D26;
import ir.nasim.ED1;
import ir.nasim.InterfaceC10115b62;
import ir.nasim.InterfaceC15121j27;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.O26;
import ir.nasim.WY6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public final class a implements InterfaceC10115b62 {
    public static final b c = new b(null);
    public static final int d = 8;
    private final D26 a;
    private final AbstractC21126t92 b;

    /* renamed from: ir.nasim.features.smiles.panel.emoji.db.a$a, reason: collision with other inner class name */
    public static final class C1231a extends AbstractC21126t92 {
        C1231a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR ABORT INTO `keyword` (`id`,`emoji_code`,`pack_id`,`keywords_en`,`keywords_fa`) VALUES (nullif(?, 0),?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, C10731c62 c10731c62) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(c10731c62, "entity");
            interfaceC15121j27.k1(1, c10731c62.b());
            interfaceC15121j27.U0(2, c10731c62.a());
            interfaceC15121j27.k1(3, c10731c62.e());
            String strC = c10731c62.c();
            if (strC == null) {
                interfaceC15121j27.y1(4);
            } else {
                interfaceC15121j27.U0(4, strC);
            }
            String strD = c10731c62.d();
            if (strD == null) {
                interfaceC15121j27.y1(5);
            } else {
                interfaceC15121j27.U0(5, strD);
            }
        }
    }

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

    public static final class c implements Callable {
        final /* synthetic */ O26 b;

        c(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(a.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "id");
                int iE2 = AbstractC5795Kw1.e(cursorC, "emoji_code");
                int iE3 = AbstractC5795Kw1.e(cursorC, "pack_id");
                int iE4 = AbstractC5795Kw1.e(cursorC, "keywords_en");
                int iE5 = AbstractC5795Kw1.e(cursorC, "keywords_fa");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new C10731c62(cursorC.getInt(iE), cursorC.getString(iE2), cursorC.getInt(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : cursorC.getString(iE5)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    public static final class d implements Callable {
        final /* synthetic */ O26 b;

        d(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(a.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "id");
                int iE2 = AbstractC5795Kw1.e(cursorC, "emoji_code");
                int iE3 = AbstractC5795Kw1.e(cursorC, "pack_id");
                int iE4 = AbstractC5795Kw1.e(cursorC, "keywords_en");
                int iE5 = AbstractC5795Kw1.e(cursorC, "keywords_fa");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new C10731c62(cursorC.getInt(iE), cursorC.getString(iE2), cursorC.getInt(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : cursorC.getString(iE5)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    public static final class e implements Callable {
        final /* synthetic */ O26 b;

        e(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(a.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "id");
                int iE2 = AbstractC5795Kw1.e(cursorC, "emoji_code");
                int iE3 = AbstractC5795Kw1.e(cursorC, "pack_id");
                int iE4 = AbstractC5795Kw1.e(cursorC, "keywords_en");
                int iE5 = AbstractC5795Kw1.e(cursorC, "keywords_fa");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new C10731c62(cursorC.getInt(iE), cursorC.getString(iE2), cursorC.getInt(iE3), cursorC.isNull(iE4) ? null : cursorC.getString(iE4), cursorC.isNull(iE5) ? null : cursorC.getString(iE5)));
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

    public a(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.a = d26;
        this.b = new C1231a(d26);
    }

    @Override // ir.nasim.InterfaceC10115b62
    public InterfaceC4557Fq2 a(List list) {
        AbstractC13042fc3.i(list, "emojiCodes");
        StringBuilder sbB = WY6.b();
        sbB.append("SELECT * FROM keyword WHERE emoji_code in (");
        int size = list.size();
        WY6.a(sbB, size);
        sbB.append(Separators.RPAREN);
        String string = sbB.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        O26 o26A = O26.i.a(string, size);
        Iterator it = list.iterator();
        int i = 1;
        while (it.hasNext()) {
            o26A.U0(i, (String) it.next());
            i++;
        }
        return androidx.room.a.a.a(this.a, false, new String[]{"keyword"}, new e(o26A));
    }

    @Override // ir.nasim.InterfaceC10115b62
    public Object b(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM keyword WHERE keywords_fa LIKE '%' || ? || '%'", 1);
        o26A.U0(1, str);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new d(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC10115b62
    public Object c(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM keyword WHERE keywords_en LIKE '%' || ? || '%'", 1);
        o26A.U0(1, str);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new c(o26A), interfaceC20295rm1);
    }
}
