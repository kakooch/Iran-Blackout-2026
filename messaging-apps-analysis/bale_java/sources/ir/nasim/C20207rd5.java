package ir.nasim;

import android.database.Cursor;
import android.gov.nist.core.Separators;
import ir.nasim.database.pinMessages.PinMessageEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.rd5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20207rd5 implements InterfaceC19600qd5 {
    public static final f f = new f(null);
    private final D26 a;
    private final AbstractC19914r92 b;
    private final AbstractC11429cz6 c;
    private final AbstractC11429cz6 d;
    private final C21800u92 e;

    /* renamed from: ir.nasim.rd5$a */
    public static final class a extends AbstractC19914r92 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "UPDATE OR ABORT `pin_message` SET `peer_unique_id` = ?,`ex_peer_type` = ?,`message_rid` = ?,`message_date` = ?,`message_edited_at` = ? WHERE `peer_unique_id` = ? AND `ex_peer_type` = ? AND `message_rid` = ? AND `message_date` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC19914r92
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, PinMessageEntity pinMessageEntity) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(pinMessageEntity, "entity");
            interfaceC15121j27.k1(1, pinMessageEntity.getPeerUniqueId());
            interfaceC15121j27.k1(2, pinMessageEntity.getExPeerType());
            interfaceC15121j27.k1(3, pinMessageEntity.getRid());
            interfaceC15121j27.k1(4, pinMessageEntity.getDate());
            interfaceC15121j27.k1(5, pinMessageEntity.getEditedAt());
            interfaceC15121j27.k1(6, pinMessageEntity.getPeerUniqueId());
            interfaceC15121j27.k1(7, pinMessageEntity.getExPeerType());
            interfaceC15121j27.k1(8, pinMessageEntity.getRid());
            interfaceC15121j27.k1(9, pinMessageEntity.getDate());
        }
    }

    /* renamed from: ir.nasim.rd5$b */
    public static final class b extends AbstractC11429cz6 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "\n        DELETE FROM pin_message\n        WHERE peer_unique_id =?\n        AND message_rid=? \n        AND message_date = ?\n    ";
        }
    }

    /* renamed from: ir.nasim.rd5$c */
    public static final class c extends AbstractC11429cz6 {
        c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM pin_message WHERE peer_unique_id = ?";
        }
    }

    /* renamed from: ir.nasim.rd5$d */
    public static final class d extends AbstractC21126t92 {
        d(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT INTO `pin_message` (`peer_unique_id`,`ex_peer_type`,`message_rid`,`message_date`,`message_edited_at`) VALUES (?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, PinMessageEntity pinMessageEntity) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(pinMessageEntity, "entity");
            interfaceC15121j27.k1(1, pinMessageEntity.getPeerUniqueId());
            interfaceC15121j27.k1(2, pinMessageEntity.getExPeerType());
            interfaceC15121j27.k1(3, pinMessageEntity.getRid());
            interfaceC15121j27.k1(4, pinMessageEntity.getDate());
            interfaceC15121j27.k1(5, pinMessageEntity.getEditedAt());
        }
    }

    /* renamed from: ir.nasim.rd5$e */
    public static final class e extends AbstractC19914r92 {
        e(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "UPDATE `pin_message` SET `peer_unique_id` = ?,`ex_peer_type` = ?,`message_rid` = ?,`message_date` = ?,`message_edited_at` = ? WHERE `peer_unique_id` = ? AND `ex_peer_type` = ? AND `message_rid` = ? AND `message_date` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC19914r92
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, PinMessageEntity pinMessageEntity) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(pinMessageEntity, "entity");
            interfaceC15121j27.k1(1, pinMessageEntity.getPeerUniqueId());
            interfaceC15121j27.k1(2, pinMessageEntity.getExPeerType());
            interfaceC15121j27.k1(3, pinMessageEntity.getRid());
            interfaceC15121j27.k1(4, pinMessageEntity.getDate());
            interfaceC15121j27.k1(5, pinMessageEntity.getEditedAt());
            interfaceC15121j27.k1(6, pinMessageEntity.getPeerUniqueId());
            interfaceC15121j27.k1(7, pinMessageEntity.getExPeerType());
            interfaceC15121j27.k1(8, pinMessageEntity.getRid());
            interfaceC15121j27.k1(9, pinMessageEntity.getDate());
        }
    }

    /* renamed from: ir.nasim.rd5$f */
    public static final class f {
        private f() {
        }

        public final List a() {
            return AbstractC10360bX0.m();
        }

        public /* synthetic */ f(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.rd5$g */
    public static final class g implements Callable {
        final /* synthetic */ O26 b;

        g(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(C20207rd5.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_PEER_UNIQUE_ID);
                int iE2 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_EX_PEER_TYPE);
                int iE3 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_RID);
                int iE4 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_DATE);
                int iE5 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_EDITED_AT);
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new PinMessageEntity(cursorC.getLong(iE), cursorC.getInt(iE2), cursorC.getLong(iE3), cursorC.getLong(iE4), cursorC.getLong(iE5)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    /* renamed from: ir.nasim.rd5$h */
    public static final class h implements Callable {
        final /* synthetic */ O26 b;

        h(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(C20207rd5.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_PEER_UNIQUE_ID);
                int iE2 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_EX_PEER_TYPE);
                int iE3 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_RID);
                int iE4 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_DATE);
                int iE5 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_EDITED_AT);
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new PinMessageEntity(cursorC.getLong(iE), cursorC.getInt(iE2), cursorC.getLong(iE3), cursorC.getLong(iE4), cursorC.getLong(iE5)));
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

    /* renamed from: ir.nasim.rd5$i */
    public static final class i implements Callable {
        final /* synthetic */ List b;

        i(List list) {
            this.b = list;
        }

        public void a() {
            C20207rd5.this.a.e();
            try {
                C20207rd5.this.e.b(this.b);
                C20207rd5.this.a.F();
            } finally {
                C20207rd5.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rd5$j */
    public static final class j implements Callable {
        final /* synthetic */ long b;

        j(long j) {
            this.b = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = C20207rd5.this.d.b();
            interfaceC15121j27B.k1(1, this.b);
            try {
                C20207rd5.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    C20207rd5.this.a.F();
                } finally {
                    C20207rd5.this.a.j();
                }
            } finally {
                C20207rd5.this.d.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rd5$k */
    public static final class k implements Callable {
        final /* synthetic */ List a;
        final /* synthetic */ List b;
        final /* synthetic */ C20207rd5 c;
        final /* synthetic */ long d;

        k(List list, List list2, C20207rd5 c20207rd5, long j) {
            this.a = list;
            this.b = list2;
            this.c = c20207rd5;
            this.d = j;
        }

        public void a() {
            StringBuilder sbB = WY6.b();
            sbB.append(Separators.RETURN);
            sbB.append("          DELETE FROM pin_message");
            sbB.append(Separators.RETURN);
            sbB.append("          WHERE peer_unique_id =");
            sbB.append(Separators.QUESTION);
            sbB.append(Separators.RETURN);
            sbB.append("          AND message_rid in (");
            List list = this.a;
            int size = list == null ? 1 : list.size();
            WY6.a(sbB, size);
            sbB.append(") ");
            sbB.append(Separators.RETURN);
            sbB.append("          AND message_date in (");
            List list2 = this.b;
            WY6.a(sbB, list2 == null ? 1 : list2.size());
            sbB.append(") ");
            sbB.append(Separators.RETURN);
            sbB.append("    ");
            String string = sbB.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            InterfaceC15121j27 interfaceC15121j27G = this.c.a.g(string);
            interfaceC15121j27G.k1(1, this.d);
            List list3 = this.a;
            if (list3 == null) {
                interfaceC15121j27G.y1(2);
            } else {
                Iterator it = list3.iterator();
                int i = 2;
                while (it.hasNext()) {
                    interfaceC15121j27G.k1(i, ((Number) it.next()).longValue());
                    i++;
                }
            }
            int i2 = size + 2;
            List list4 = this.b;
            if (list4 == null) {
                interfaceC15121j27G.y1(i2);
            } else {
                Iterator it2 = list4.iterator();
                while (it2.hasNext()) {
                    interfaceC15121j27G.k1(i2, ((Number) it2.next()).longValue());
                    i2++;
                }
            }
            this.c.a.e();
            try {
                interfaceC15121j27G.V();
                this.c.a.F();
            } finally {
                this.c.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rd5$l */
    public static final class l implements Callable {
        final /* synthetic */ List b;

        l(List list) {
            this.b = list;
        }

        public void a() {
            C20207rd5.this.a.e();
            try {
                C20207rd5.this.b.k(this.b);
                C20207rd5.this.a.F();
            } finally {
                C20207rd5.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public C20207rd5(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.a = d26;
        this.b = new a(d26);
        this.c = new b(d26);
        this.d = new c(d26);
        this.e = new C21800u92(new d(d26), new e(d26));
    }

    @Override // ir.nasim.InterfaceC19600qd5
    public Object a(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM pin_message WHERE peer_unique_id =?", 1);
        o26A.k1(1, j2);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new g(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC19600qd5
    public Object b(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new l(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC19600qd5
    public InterfaceC4557Fq2 c(long j2) {
        O26 o26A = O26.i.a("SELECT * FROM pin_message WHERE peer_unique_id = ?", 1);
        o26A.k1(1, j2);
        return androidx.room.a.a.a(this.a, false, new String[]{PinMessageEntity.ENTITY_NAME}, new h(o26A));
    }

    @Override // ir.nasim.InterfaceC19600qd5
    public Object d(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new j(j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC19600qd5
    public Object e(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new i(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC19600qd5
    public Object f(long j2, List list, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new k(list, list2, this, j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }
}
