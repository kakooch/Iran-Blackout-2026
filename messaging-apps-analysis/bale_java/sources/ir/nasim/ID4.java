package ir.nasim;

import android.database.Cursor;
import ir.nasim.database.pinMessages.PinMessageEntity;
import java.util.List;

/* loaded from: classes5.dex */
public final class ID4 implements HD4 {
    public static final i k = new i(null);
    private final D26 a;
    private final AbstractC21126t92 b;
    private final C14482hz5 c;
    private final AbstractC11429cz6 d;
    private final AbstractC11429cz6 e;
    private final AbstractC11429cz6 f;
    private final AbstractC11429cz6 g;
    private final AbstractC11429cz6 h;
    private final AbstractC11429cz6 i;
    private final AbstractC11429cz6 j;

    public static final class a extends AbstractC21126t92 {
        final /* synthetic */ ID4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(D26 d26, ID4 id4) {
            super(d26);
            this.d = id4;
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR REPLACE INTO `notification_records` (`id`,`peer_id`,`message_rid`,`message_date`,`push_type`,`push_send_date`,`content`,`reaction_count`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, JD4 jd4) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(jd4, "entity");
            interfaceC15121j27.k1(1, jd4.b());
            interfaceC15121j27.U0(2, jd4.e());
            interfaceC15121j27.U0(3, jd4.d());
            interfaceC15121j27.k1(4, jd4.c());
            interfaceC15121j27.k1(5, this.d.c.b(jd4.g()));
            interfaceC15121j27.k1(6, jd4.f());
            String strA = jd4.a();
            if (strA == null) {
                interfaceC15121j27.y1(7);
            } else {
                interfaceC15121j27.U0(7, strA);
            }
            if (jd4.h() == null) {
                interfaceC15121j27.y1(8);
            } else {
                interfaceC15121j27.k1(8, r6.intValue());
            }
        }
    }

    public static final class b extends AbstractC11429cz6 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM notification_records WHERE peer_id = ? AND message_rid = ? AND message_date = ? AND push_type != ? AND push_type != ?";
        }
    }

    public static final class c extends AbstractC11429cz6 {
        c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM notification_records WHERE peer_id = ? AND message_date <= ? AND push_type != ?";
        }
    }

    public static final class d extends AbstractC11429cz6 {
        d(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM notification_records WHERE peer_id = ? AND message_rid = ? AND message_date = ? AND content = ? AND push_type == ? AND push_send_date <= ?";
        }
    }

    public static final class e extends AbstractC11429cz6 {
        e(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM notification_records WHERE peer_id = ? AND message_rid = ? AND message_date = ? AND push_type = ? AND push_send_date < ?";
        }
    }

    public static final class f extends AbstractC11429cz6 {
        f(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM notification_records WHERE peer_id = ? AND message_rid = ? AND message_date = ? AND push_type = ?";
        }
    }

    public static final class g extends AbstractC11429cz6 {
        g(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM notification_records";
        }
    }

    public static final class h extends AbstractC11429cz6 {
        h(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE notification_records SET reaction_count = ? WHERE peer_id = ? AND message_rid = ? AND message_date = ? AND push_type = ?";
        }
    }

    public static final class i {
        private i() {
        }

        public final List a() {
            return AbstractC10360bX0.m();
        }

        public /* synthetic */ i(ED1 ed1) {
            this();
        }
    }

    public ID4(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.c = new C14482hz5();
        this.a = d26;
        this.b = new a(d26, this);
        this.d = new b(d26);
        this.e = new c(d26);
        this.f = new d(d26);
        this.g = new e(d26);
        this.h = new f(d26);
        this.i = new g(d26);
        this.j = new h(d26);
    }

    @Override // ir.nasim.HD4
    public JD4 c(String str, long j, EnumC13889gz5 enumC13889gz5) {
        AbstractC13042fc3.i(str, "messageRid");
        AbstractC13042fc3.i(enumC13889gz5, "replyType");
        O26 o26A = O26.i.a("SELECT * FROM notification_records WHERE message_rid = ? AND message_date= ?  AND push_type =? ORDER BY push_send_date DESC LIMIT 1", 3);
        o26A.U0(1, str);
        o26A.k1(2, j);
        o26A.k1(3, this.c.b(enumC13889gz5));
        this.a.d();
        JD4 jd4 = null;
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26A, false, null);
        try {
            int iE = AbstractC5795Kw1.e(cursorC, "id");
            int iE2 = AbstractC5795Kw1.e(cursorC, "peer_id");
            int iE3 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_RID);
            int iE4 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_DATE);
            int iE5 = AbstractC5795Kw1.e(cursorC, "push_type");
            int iE6 = AbstractC5795Kw1.e(cursorC, "push_send_date");
            int iE7 = AbstractC5795Kw1.e(cursorC, "content");
            int iE8 = AbstractC5795Kw1.e(cursorC, "reaction_count");
            if (cursorC.moveToFirst()) {
                jd4 = new JD4(cursorC.getLong(iE), cursorC.getString(iE2), cursorC.getString(iE3), cursorC.getLong(iE4), this.c.a(cursorC.getInt(iE5)), cursorC.getLong(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8)));
            }
            return jd4;
        } finally {
            cursorC.close();
            o26A.j();
        }
    }

    @Override // ir.nasim.HD4
    public Integer d(String str, String str2, long j, EnumC13889gz5 enumC13889gz5) {
        AbstractC13042fc3.i(str, "peerId");
        AbstractC13042fc3.i(str2, "messageRid");
        AbstractC13042fc3.i(enumC13889gz5, "reactionType");
        O26 o26A = O26.i.a("SELECT reaction_count FROM notification_records WHERE peer_id = ? AND message_rid = ? AND message_date = ? AND push_type = ?", 4);
        o26A.U0(1, str);
        o26A.U0(2, str2);
        o26A.k1(3, j);
        o26A.k1(4, this.c.b(enumC13889gz5));
        this.a.d();
        Integer numValueOf = null;
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26A, false, null);
        try {
            if (cursorC.moveToFirst() && !cursorC.isNull(0)) {
                numValueOf = Integer.valueOf(cursorC.getInt(0));
            }
            return numValueOf;
        } finally {
            cursorC.close();
            o26A.j();
        }
    }

    @Override // ir.nasim.HD4
    public JD4 e(String str, EnumC13889gz5 enumC13889gz5) {
        AbstractC13042fc3.i(str, "peerId");
        AbstractC13042fc3.i(enumC13889gz5, "readType");
        O26 o26A = O26.i.a("SELECT * FROM notification_records WHERE peer_id = ? AND push_type = ? ORDER BY push_send_date DESC LIMIT 1", 2);
        o26A.U0(1, str);
        o26A.k1(2, this.c.b(enumC13889gz5));
        this.a.d();
        JD4 jd4 = null;
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26A, false, null);
        try {
            int iE = AbstractC5795Kw1.e(cursorC, "id");
            int iE2 = AbstractC5795Kw1.e(cursorC, "peer_id");
            int iE3 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_RID);
            int iE4 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_DATE);
            int iE5 = AbstractC5795Kw1.e(cursorC, "push_type");
            int iE6 = AbstractC5795Kw1.e(cursorC, "push_send_date");
            int iE7 = AbstractC5795Kw1.e(cursorC, "content");
            int iE8 = AbstractC5795Kw1.e(cursorC, "reaction_count");
            if (cursorC.moveToFirst()) {
                jd4 = new JD4(cursorC.getLong(iE), cursorC.getString(iE2), cursorC.getString(iE3), cursorC.getLong(iE4), this.c.a(cursorC.getInt(iE5)), cursorC.getLong(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8)));
            }
            return jd4;
        } finally {
            cursorC.close();
            o26A.j();
        }
    }

    @Override // ir.nasim.HD4
    public JD4 g(String str, String str2, long j, EnumC13889gz5 enumC13889gz5, EnumC13889gz5 enumC13889gz52, EnumC13889gz5 enumC13889gz53) {
        AbstractC13042fc3.i(str, "peerId");
        AbstractC13042fc3.i(str2, "messageRid");
        AbstractC13042fc3.i(enumC13889gz5, "messageType");
        AbstractC13042fc3.i(enumC13889gz52, "mentionType");
        AbstractC13042fc3.i(enumC13889gz53, "replyType");
        O26 o26A = O26.i.a("SELECT * FROM notification_records WHERE peer_id = ? AND message_rid = ? AND message_date= ?  AND (push_type =? OR push_type = ? OR push_type =?) ORDER BY push_send_date DESC LIMIT 1", 6);
        o26A.U0(1, str);
        o26A.U0(2, str2);
        o26A.k1(3, j);
        o26A.k1(4, this.c.b(enumC13889gz5));
        o26A.k1(5, this.c.b(enumC13889gz52));
        o26A.k1(6, this.c.b(enumC13889gz53));
        this.a.d();
        JD4 jd4 = null;
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26A, false, null);
        try {
            int iE = AbstractC5795Kw1.e(cursorC, "id");
            int iE2 = AbstractC5795Kw1.e(cursorC, "peer_id");
            int iE3 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_RID);
            int iE4 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_DATE);
            int iE5 = AbstractC5795Kw1.e(cursorC, "push_type");
            int iE6 = AbstractC5795Kw1.e(cursorC, "push_send_date");
            int iE7 = AbstractC5795Kw1.e(cursorC, "content");
            int iE8 = AbstractC5795Kw1.e(cursorC, "reaction_count");
            if (cursorC.moveToFirst()) {
                jd4 = new JD4(cursorC.getLong(iE), cursorC.getString(iE2), cursorC.getString(iE3), cursorC.getLong(iE4), this.c.a(cursorC.getInt(iE5)), cursorC.getLong(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8)));
            }
            return jd4;
        } finally {
            cursorC.close();
            o26A.j();
        }
    }

    @Override // ir.nasim.HD4
    public void l(String str, String str2, long j, long j2, String str3, EnumC13889gz5 enumC13889gz5) {
        AbstractC13042fc3.i(str, "peerId");
        AbstractC13042fc3.i(str2, "messageRid");
        AbstractC13042fc3.i(str3, "reactionCode");
        AbstractC13042fc3.i(enumC13889gz5, "reactionType");
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.f.b();
        interfaceC15121j27B.U0(1, str);
        interfaceC15121j27B.U0(2, str2);
        interfaceC15121j27B.k1(3, j);
        interfaceC15121j27B.U0(4, str3);
        interfaceC15121j27B.k1(5, this.c.b(enumC13889gz5));
        interfaceC15121j27B.k1(6, j2);
        try {
            this.a.e();
            try {
                interfaceC15121j27B.V();
                this.a.F();
            } finally {
                this.a.j();
            }
        } finally {
            this.f.h(interfaceC15121j27B);
        }
    }

    @Override // ir.nasim.HD4
    public JD4 m(String str, String str2, long j, EnumC13889gz5 enumC13889gz5, long j2, String str3, Integer num) {
        AbstractC13042fc3.i(str, "peerId");
        AbstractC13042fc3.i(str2, "messageRid");
        AbstractC13042fc3.i(enumC13889gz5, "pushType");
        O26 o26A = O26.i.a("SELECT * FROM notification_records WHERE peer_id = ? AND message_rid = ? AND message_date= ?  AND push_type = ? AND push_send_date = ? AND content == ? AND reaction_count == ? ORDER BY push_send_date DESC LIMIT 1", 7);
        o26A.U0(1, str);
        o26A.U0(2, str2);
        o26A.k1(3, j);
        o26A.k1(4, this.c.b(enumC13889gz5));
        o26A.k1(5, j2);
        if (str3 == null) {
            o26A.y1(6);
        } else {
            o26A.U0(6, str3);
        }
        if (num == null) {
            o26A.y1(7);
        } else {
            o26A.k1(7, num.intValue());
        }
        this.a.d();
        JD4 jd4 = null;
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26A, false, null);
        try {
            int iE = AbstractC5795Kw1.e(cursorC, "id");
            int iE2 = AbstractC5795Kw1.e(cursorC, "peer_id");
            int iE3 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_RID);
            int iE4 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_DATE);
            int iE5 = AbstractC5795Kw1.e(cursorC, "push_type");
            int iE6 = AbstractC5795Kw1.e(cursorC, "push_send_date");
            int iE7 = AbstractC5795Kw1.e(cursorC, "content");
            int iE8 = AbstractC5795Kw1.e(cursorC, "reaction_count");
            if (cursorC.moveToFirst()) {
                jd4 = new JD4(cursorC.getLong(iE), cursorC.getString(iE2), cursorC.getString(iE3), cursorC.getLong(iE4), this.c.a(cursorC.getInt(iE5)), cursorC.getLong(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8)));
            }
            return jd4;
        } finally {
            cursorC.close();
            o26A.j();
        }
    }

    @Override // ir.nasim.HD4
    public void n(String str, String str2, long j, EnumC13889gz5 enumC13889gz5, EnumC13889gz5 enumC13889gz52) {
        AbstractC13042fc3.i(str, "peerId");
        AbstractC13042fc3.i(str2, "messageRid");
        AbstractC13042fc3.i(enumC13889gz5, "reactionType");
        AbstractC13042fc3.i(enumC13889gz52, "readType");
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.d.b();
        interfaceC15121j27B.U0(1, str);
        interfaceC15121j27B.U0(2, str2);
        interfaceC15121j27B.k1(3, j);
        interfaceC15121j27B.k1(4, this.c.b(enumC13889gz5));
        interfaceC15121j27B.k1(5, this.c.b(enumC13889gz52));
        try {
            this.a.e();
            try {
                interfaceC15121j27B.V();
                this.a.F();
            } finally {
                this.a.j();
            }
        } finally {
            this.d.h(interfaceC15121j27B);
        }
    }

    @Override // ir.nasim.HD4
    public JD4 o(String str, String str2, long j, String str3, EnumC13889gz5 enumC13889gz5) {
        AbstractC13042fc3.i(str, "peerId");
        AbstractC13042fc3.i(str2, "messageRid");
        AbstractC13042fc3.i(str3, "reactionCode");
        AbstractC13042fc3.i(enumC13889gz5, "reactionType");
        O26 o26A = O26.i.a("SELECT * FROM notification_records WHERE peer_id = ? AND message_rid = ? AND message_date= ? AND push_type = ? AND content == ? ORDER BY push_send_date DESC LIMIT 1", 5);
        o26A.U0(1, str);
        o26A.U0(2, str2);
        o26A.k1(3, j);
        o26A.k1(4, this.c.b(enumC13889gz5));
        o26A.U0(5, str3);
        this.a.d();
        JD4 jd4 = null;
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26A, false, null);
        try {
            int iE = AbstractC5795Kw1.e(cursorC, "id");
            int iE2 = AbstractC5795Kw1.e(cursorC, "peer_id");
            int iE3 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_RID);
            int iE4 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_DATE);
            int iE5 = AbstractC5795Kw1.e(cursorC, "push_type");
            int iE6 = AbstractC5795Kw1.e(cursorC, "push_send_date");
            int iE7 = AbstractC5795Kw1.e(cursorC, "content");
            int iE8 = AbstractC5795Kw1.e(cursorC, "reaction_count");
            if (cursorC.moveToFirst()) {
                jd4 = new JD4(cursorC.getLong(iE), cursorC.getString(iE2), cursorC.getString(iE3), cursorC.getLong(iE4), this.c.a(cursorC.getInt(iE5)), cursorC.getLong(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8)));
            }
            return jd4;
        } finally {
            cursorC.close();
            o26A.j();
        }
    }

    @Override // ir.nasim.HD4
    public void p(JD4 jd4) {
        AbstractC13042fc3.i(jd4, "item");
        this.a.d();
        this.a.e();
        try {
            this.b.k(jd4);
            this.a.F();
        } finally {
            this.a.j();
        }
    }

    @Override // ir.nasim.HD4
    public void q(String str, String str2, long j, EnumC13889gz5 enumC13889gz5, int i2) {
        AbstractC13042fc3.i(str, "peerId");
        AbstractC13042fc3.i(str2, "messageRid");
        AbstractC13042fc3.i(enumC13889gz5, "reactionType");
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.j.b();
        interfaceC15121j27B.k1(1, i2);
        interfaceC15121j27B.U0(2, str);
        interfaceC15121j27B.U0(3, str2);
        interfaceC15121j27B.k1(4, j);
        interfaceC15121j27B.k1(5, this.c.b(enumC13889gz5));
        try {
            this.a.e();
            try {
                interfaceC15121j27B.V();
                this.a.F();
            } finally {
                this.a.j();
            }
        } finally {
            this.j.h(interfaceC15121j27B);
        }
    }

    @Override // ir.nasim.HD4
    public JD4 s(String str, String str2, long j, EnumC13889gz5 enumC13889gz5) {
        AbstractC13042fc3.i(str, "peerId");
        AbstractC13042fc3.i(str2, "messageRid");
        AbstractC13042fc3.i(enumC13889gz5, "pushType");
        O26 o26A = O26.i.a("SELECT * FROM notification_records WHERE peer_id = ? AND message_rid = ? AND message_date= ? AND push_type = ? ORDER BY push_send_date DESC LIMIT 1", 4);
        o26A.U0(1, str);
        o26A.U0(2, str2);
        o26A.k1(3, j);
        o26A.k1(4, this.c.b(enumC13889gz5));
        this.a.d();
        JD4 jd4 = null;
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26A, false, null);
        try {
            int iE = AbstractC5795Kw1.e(cursorC, "id");
            int iE2 = AbstractC5795Kw1.e(cursorC, "peer_id");
            int iE3 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_RID);
            int iE4 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_DATE);
            int iE5 = AbstractC5795Kw1.e(cursorC, "push_type");
            int iE6 = AbstractC5795Kw1.e(cursorC, "push_send_date");
            int iE7 = AbstractC5795Kw1.e(cursorC, "content");
            int iE8 = AbstractC5795Kw1.e(cursorC, "reaction_count");
            if (cursorC.moveToFirst()) {
                jd4 = new JD4(cursorC.getLong(iE), cursorC.getString(iE2), cursorC.getString(iE3), cursorC.getLong(iE4), this.c.a(cursorC.getInt(iE5)), cursorC.getLong(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8)));
            }
            return jd4;
        } finally {
            cursorC.close();
            o26A.j();
        }
    }

    @Override // ir.nasim.HD4
    public JD4 t(String str, String str2, long j, EnumC13889gz5 enumC13889gz5, String str3) {
        AbstractC13042fc3.i(str, "peerId");
        AbstractC13042fc3.i(str2, "messageRid");
        AbstractC13042fc3.i(enumC13889gz5, "pushType");
        AbstractC13042fc3.i(str3, "content");
        O26 o26A = O26.i.a("SELECT * FROM notification_records WHERE peer_id = ? AND message_rid = ? AND message_date= ? AND push_type = ? AND content = ? ORDER BY push_send_date DESC LIMIT 1", 5);
        o26A.U0(1, str);
        o26A.U0(2, str2);
        o26A.k1(3, j);
        o26A.k1(4, this.c.b(enumC13889gz5));
        o26A.U0(5, str3);
        this.a.d();
        JD4 jd4 = null;
        Cursor cursorC = AbstractC7716Sx1.c(this.a, o26A, false, null);
        try {
            int iE = AbstractC5795Kw1.e(cursorC, "id");
            int iE2 = AbstractC5795Kw1.e(cursorC, "peer_id");
            int iE3 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_RID);
            int iE4 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_MESSAGE_DATE);
            int iE5 = AbstractC5795Kw1.e(cursorC, "push_type");
            int iE6 = AbstractC5795Kw1.e(cursorC, "push_send_date");
            int iE7 = AbstractC5795Kw1.e(cursorC, "content");
            int iE8 = AbstractC5795Kw1.e(cursorC, "reaction_count");
            if (cursorC.moveToFirst()) {
                jd4 = new JD4(cursorC.getLong(iE), cursorC.getString(iE2), cursorC.getString(iE3), cursorC.getLong(iE4), this.c.a(cursorC.getInt(iE5)), cursorC.getLong(iE6), cursorC.isNull(iE7) ? null : cursorC.getString(iE7), cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8)));
            }
            return jd4;
        } finally {
            cursorC.close();
            o26A.j();
        }
    }

    @Override // ir.nasim.HD4
    public void u(String str, String str2, long j, EnumC13889gz5 enumC13889gz5) {
        AbstractC13042fc3.i(str, "peerId");
        AbstractC13042fc3.i(str2, "messageRid");
        AbstractC13042fc3.i(enumC13889gz5, "pushType");
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.h.b();
        interfaceC15121j27B.U0(1, str);
        interfaceC15121j27B.U0(2, str2);
        interfaceC15121j27B.k1(3, j);
        interfaceC15121j27B.k1(4, this.c.b(enumC13889gz5));
        try {
            this.a.e();
            try {
                interfaceC15121j27B.V();
                this.a.F();
            } finally {
                this.a.j();
            }
        } finally {
            this.h.h(interfaceC15121j27B);
        }
    }

    @Override // ir.nasim.HD4
    public void v(String str, long j, EnumC13889gz5 enumC13889gz5) {
        AbstractC13042fc3.i(str, "peerId");
        AbstractC13042fc3.i(enumC13889gz5, "deleteType");
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.e.b();
        interfaceC15121j27B.U0(1, str);
        interfaceC15121j27B.k1(2, j);
        interfaceC15121j27B.k1(3, this.c.b(enumC13889gz5));
        try {
            this.a.e();
            try {
                interfaceC15121j27B.V();
                this.a.F();
            } finally {
                this.a.j();
            }
        } finally {
            this.e.h(interfaceC15121j27B);
        }
    }

    @Override // ir.nasim.HD4
    public void w(String str, String str2, long j, long j2, EnumC13889gz5 enumC13889gz5) {
        AbstractC13042fc3.i(str, "peerId");
        AbstractC13042fc3.i(str2, "messageRid");
        AbstractC13042fc3.i(enumC13889gz5, "reactionType");
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.g.b();
        interfaceC15121j27B.U0(1, str);
        interfaceC15121j27B.U0(2, str2);
        interfaceC15121j27B.k1(3, j);
        interfaceC15121j27B.k1(4, this.c.b(enumC13889gz5));
        interfaceC15121j27B.k1(5, j2);
        try {
            this.a.e();
            try {
                interfaceC15121j27B.V();
                this.a.F();
            } finally {
                this.a.j();
            }
        } finally {
            this.g.h(interfaceC15121j27B);
        }
    }
}
