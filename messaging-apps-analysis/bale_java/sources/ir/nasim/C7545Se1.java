package ir.nasim;

import android.database.Cursor;
import ir.nasim.database.entity.ContactEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.Se1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7545Se1 extends AbstractC7311Re1 {
    public static final d d = new d(null);
    private final D26 a;
    private final AbstractC11429cz6 b;
    private final C21800u92 c;

    /* renamed from: ir.nasim.Se1$a */
    public static final class a extends AbstractC11429cz6 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM contacts WHERE 1";
        }
    }

    /* renamed from: ir.nasim.Se1$b */
    public static final class b extends AbstractC21126t92 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT INTO `contacts` (`id`,`name`,`isBot`,`sortKey`,`avatarByte`) VALUES (?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, ContactEntity contactEntity) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(contactEntity, "entity");
            interfaceC15121j27.k1(1, contactEntity.getId());
            interfaceC15121j27.U0(2, contactEntity.getName());
            interfaceC15121j27.k1(3, contactEntity.isBot() ? 1L : 0L);
            interfaceC15121j27.k1(4, contactEntity.getSortKey());
            byte[] avatarByte = contactEntity.getAvatarByte();
            if (avatarByte == null) {
                interfaceC15121j27.y1(5);
            } else {
                interfaceC15121j27.n1(5, avatarByte);
            }
        }
    }

    /* renamed from: ir.nasim.Se1$c */
    public static final class c extends AbstractC19914r92 {
        c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "UPDATE `contacts` SET `id` = ?,`name` = ?,`isBot` = ?,`sortKey` = ?,`avatarByte` = ? WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC19914r92
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, ContactEntity contactEntity) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(contactEntity, "entity");
            interfaceC15121j27.k1(1, contactEntity.getId());
            interfaceC15121j27.U0(2, contactEntity.getName());
            interfaceC15121j27.k1(3, contactEntity.isBot() ? 1L : 0L);
            interfaceC15121j27.k1(4, contactEntity.getSortKey());
            byte[] avatarByte = contactEntity.getAvatarByte();
            if (avatarByte == null) {
                interfaceC15121j27.y1(5);
            } else {
                interfaceC15121j27.n1(5, avatarByte);
            }
            interfaceC15121j27.k1(6, contactEntity.getId());
        }
    }

    /* renamed from: ir.nasim.Se1$d */
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

    /* renamed from: ir.nasim.Se1$e */
    public static final class e implements Callable {
        e() {
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = C7545Se1.this.b.b();
            try {
                C7545Se1.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    C7545Se1.this.a.F();
                } finally {
                    C7545Se1.this.a.j();
                }
            } finally {
                C7545Se1.this.b.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Se1$f */
    public static final class f implements Callable {
        final /* synthetic */ InterfaceC14514i27 b;

        f(InterfaceC14514i27 interfaceC14514i27) {
            this.b = interfaceC14514i27;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(C7545Se1.this.a, this.b, false, null);
            try {
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(C7545Se1.this.j(cursorC));
                }
                return arrayList;
            } finally {
                cursorC.close();
            }
        }
    }

    /* renamed from: ir.nasim.Se1$g */
    public static final class g implements Callable {
        final /* synthetic */ O26 b;

        g(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(C7545Se1.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "id");
                int iE2 = AbstractC5795Kw1.e(cursorC, "name");
                int iE3 = AbstractC5795Kw1.e(cursorC, ContactEntity.COLUMN_IS_BOT);
                int iE4 = AbstractC5795Kw1.e(cursorC, ContactEntity.COLUMN_SORT_KEY);
                int iE5 = AbstractC5795Kw1.e(cursorC, ContactEntity.COLUMN_AVATAR_BYTE);
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new ContactEntity(cursorC.getInt(iE), cursorC.getString(iE2), cursorC.getInt(iE3) != 0, cursorC.getLong(iE4), cursorC.isNull(iE5) ? null : cursorC.getBlob(iE5)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    /* renamed from: ir.nasim.Se1$h */
    public static final class h implements Callable {
        final /* synthetic */ List b;

        h(List list) {
            this.b = list;
        }

        public void a() {
            C7545Se1.this.a.e();
            try {
                C7545Se1.this.c.b(this.b);
                C7545Se1.this.a.F();
            } finally {
                C7545Se1.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Se1$i */
    static final class i extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C7545Se1.this.new i(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C7545Se1 c7545Se1 = C7545Se1.this;
                List list = this.d;
                this.b = 1;
                if (C7545Se1.super.h(list, this) == objE) {
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
            return ((i) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C7545Se1(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.a = d26;
        this.b = new a(d26);
        this.c = new C21800u92(new b(d26), new c(d26));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContactEntity j(Cursor cursor) {
        int iD = AbstractC5795Kw1.d(cursor, "id");
        int iD2 = AbstractC5795Kw1.d(cursor, "name");
        int iD3 = AbstractC5795Kw1.d(cursor, ContactEntity.COLUMN_IS_BOT);
        int iD4 = AbstractC5795Kw1.d(cursor, ContactEntity.COLUMN_SORT_KEY);
        int iD5 = AbstractC5795Kw1.d(cursor, ContactEntity.COLUMN_AVATAR_BYTE);
        boolean z = false;
        int i2 = iD == -1 ? 0 : cursor.getInt(iD);
        if (iD2 == -1) {
            throw new IllegalStateException("Missing value for a NON-NULL column 'name', found NULL value instead.".toString());
        }
        String string = cursor.getString(iD2);
        if (iD3 != -1 && cursor.getInt(iD3) != 0) {
            z = true;
        }
        return new ContactEntity(i2, string, z, iD4 == -1 ? 0L : cursor.getLong(iD4), (iD5 == -1 || cursor.isNull(iD5)) ? null : cursor.getBlob(iD5));
    }

    @Override // ir.nasim.AbstractC7311Re1
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new e(), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC7311Re1
    public int b() {
        O26 o26A = O26.i.a("SELECT count(id) from contacts;", 0);
        this.a.d();
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26A, false, null);
        try {
            return cursorC.moveToFirst() ? cursorC.getInt(0) : 0;
        } finally {
            cursorC.close();
            o26A.j();
        }
    }

    @Override // ir.nasim.AbstractC7311Re1
    public Object c(InterfaceC14514i27 interfaceC14514i27, InterfaceC20295rm1 interfaceC20295rm1) {
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new f(interfaceC14514i27), interfaceC20295rm1);
    }

    @Override // ir.nasim.AbstractC7311Re1
    public Object d(String str, int i2, int i3, long j, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("\n            SELECT contacts.*, user_presences.unknown FROM contacts\n                LEFT JOIN user_presences ON contacts.id = user_presences.peer_unique_id\n                WHERE name LIKE '%' || ? || '%' ORDER BY\n                    CASE\n                        WHEN isBot = 1 THEN 1\n                        ELSE 0\n                    END,\n                    CASE\n                        WHEN last_seen < ? THEN 1\n                        ELSE 0\n                    END,\n                    CASE \n                        WHEN last_seen IS NULL THEN 1\n                        ELSE 0\n                    END,\n                    CASE\n                        WHEN unknown = 1 THEN 1\n                        ELSE 0\n                    END,\n                    CASE \n                         WHEN user_presences.state != 2 THEN 1 \n                         ELSE 0 \n                    END, last_seen DESC\n                    LIMIT ? OFFSET ?;\n    ", 4);
        o26A.U0(1, str);
        o26A.k1(2, j);
        o26A.k1(3, i3);
        o26A.k1(4, i2);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new g(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.AbstractC7311Re1
    public Object g(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new h(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC7311Re1
    public Object h(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.a, new i(list, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }
}
