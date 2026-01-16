package ir.nasim.jaryan.feed.data.db;

import android.database.Cursor;
import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC11429cz6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC21126t92;
import ir.nasim.AbstractC5795Kw1;
import ir.nasim.AbstractC7716Sx1;
import ir.nasim.C19938rB7;
import ir.nasim.C22114uh2;
import ir.nasim.C4026Dj2;
import ir.nasim.CW4;
import ir.nasim.D26;
import ir.nasim.ED1;
import ir.nasim.InterfaceC15121j27;
import ir.nasim.InterfaceC15500jh2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.O26;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.pinMessages.PinMessageEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class a implements InterfaceC15500jh2 {
    public static final d f = new d(null);
    public static final int g = 8;
    private final D26 a;
    private final AbstractC21126t92 b;
    private final FeedTypeConverter c;
    private final AbstractC11429cz6 d;
    private final AbstractC11429cz6 e;

    /* renamed from: ir.nasim.jaryan.feed.data.db.a$a, reason: collision with other inner class name */
    public static final class C1318a extends AbstractC21126t92 {
        final /* synthetic */ a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1318a(D26 d26, a aVar) {
            super(d26);
            this.d = aVar;
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR IGNORE INTO `feed` (`sort_id`,`rid`,`date`,`peer_id`,`ex_peer_type`,`message`,`reaction`,`forwarded_count`,`sender_uid`,`upvote_count`,`is_upvoted_by_me`,`category`,`message_type`,`tag`,`parent_post_id`,`grouped_id`,`comment_count`,`category_id`,`file_id`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, C22114uh2 c22114uh2) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(c22114uh2, "entity");
            interfaceC15121j27.k1(1, c22114uh2.p());
            interfaceC15121j27.k1(2, c22114uh2.n());
            interfaceC15121j27.k1(3, c22114uh2.d());
            interfaceC15121j27.k1(4, c22114uh2.l());
            interfaceC15121j27.U0(5, this.d.f(c22114uh2.e()));
            interfaceC15121j27.n1(6, c22114uh2.i());
            interfaceC15121j27.U0(7, this.d.c.i(c22114uh2.m()));
            if (c22114uh2.g() == null) {
                interfaceC15121j27.y1(8);
            } else {
                interfaceC15121j27.k1(8, r0.intValue());
            }
            interfaceC15121j27.k1(9, c22114uh2.o());
            if (c22114uh2.r() == null) {
                interfaceC15121j27.y1(10);
            } else {
                interfaceC15121j27.k1(10, r0.intValue());
            }
            Boolean boolS = c22114uh2.s();
            if ((boolS != null ? Integer.valueOf(boolS.booleanValue() ? 1 : 0) : null) == null) {
                interfaceC15121j27.y1(11);
            } else {
                interfaceC15121j27.k1(11, r0.intValue());
            }
            interfaceC15121j27.U0(12, c22114uh2.a());
            interfaceC15121j27.k1(13, c22114uh2.j());
            C4026Dj2 c4026Dj2Q = c22114uh2.q();
            String strB = c4026Dj2Q != null ? this.d.c.b(c4026Dj2Q) : null;
            if (strB == null) {
                interfaceC15121j27.y1(14);
            } else {
                interfaceC15121j27.U0(14, strB);
            }
            String strH = this.d.c.h(c22114uh2.k());
            if (strH == null) {
                interfaceC15121j27.y1(15);
            } else {
                interfaceC15121j27.U0(15, strH);
            }
            Long lH = c22114uh2.h();
            if (lH == null) {
                interfaceC15121j27.y1(16);
            } else {
                interfaceC15121j27.k1(16, lH.longValue());
            }
            if (c22114uh2.c() == null) {
                interfaceC15121j27.y1(17);
            } else {
                interfaceC15121j27.k1(17, r0.intValue());
            }
            interfaceC15121j27.k1(18, c22114uh2.b());
            interfaceC15121j27.k1(19, c22114uh2.f());
        }
    }

    public static final class b extends AbstractC11429cz6 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "Delete From feed";
        }
    }

    public static final class c extends AbstractC11429cz6 {
        c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM feed WHERE category_id = ?";
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

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ExPeerType.THREAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    public static final class f implements Callable {
        final /* synthetic */ int b;

        f(int i) {
            this.b = i;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = a.this.e.b();
            interfaceC15121j27B.k1(1, this.b);
            try {
                a.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    a.this.a.F();
                } finally {
                    a.this.a.j();
                }
            } finally {
                a.this.e.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class g implements Callable {
        final /* synthetic */ O26 b;

        g(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C22114uh2 call() {
            Boolean boolValueOf;
            C4026Dj2 c4026Dj2C;
            int i;
            Long lValueOf;
            int i2;
            Integer numValueOf;
            int i3;
            Cursor cursorC = AbstractC7716Sx1.c(a.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "sort_id");
                int iE2 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_RID);
                int iE3 = AbstractC5795Kw1.e(cursorC, "date");
                int iE4 = AbstractC5795Kw1.e(cursorC, "peer_id");
                int iE5 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_EX_PEER_TYPE);
                int iE6 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_MESSAGE);
                int iE7 = AbstractC5795Kw1.e(cursorC, "reaction");
                int iE8 = AbstractC5795Kw1.e(cursorC, "forwarded_count");
                int iE9 = AbstractC5795Kw1.e(cursorC, "sender_uid");
                int iE10 = AbstractC5795Kw1.e(cursorC, "upvote_count");
                int iE11 = AbstractC5795Kw1.e(cursorC, "is_upvoted_by_me");
                int iE12 = AbstractC5795Kw1.e(cursorC, SearchSuggestion.CATEGORY_ICON);
                int iE13 = AbstractC5795Kw1.e(cursorC, "message_type");
                int iE14 = AbstractC5795Kw1.e(cursorC, ParameterNames.TAG);
                int iE15 = AbstractC5795Kw1.e(cursorC, "parent_post_id");
                int iE16 = AbstractC5795Kw1.e(cursorC, "grouped_id");
                int iE17 = AbstractC5795Kw1.e(cursorC, "comment_count");
                int iE18 = AbstractC5795Kw1.e(cursorC, "category_id");
                int iE19 = AbstractC5795Kw1.e(cursorC, "file_id");
                if (!cursorC.moveToFirst()) {
                    throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type <ir.nasim.jaryan.feed.model.db.FeedEntity>.".toString());
                }
                long j = cursorC.getLong(iE);
                long j2 = cursorC.getLong(iE2);
                long j3 = cursorC.getLong(iE3);
                int i4 = cursorC.getInt(iE4);
                a aVar = a.this;
                String string = cursorC.getString(iE5);
                AbstractC13042fc3.h(string, "getString(...)");
                ExPeerType exPeerTypeG = aVar.g(string);
                byte[] blob = cursorC.getBlob(iE6);
                List listD = a.this.c.d(cursorC.getString(iE7));
                Integer numValueOf2 = cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8));
                int i5 = cursorC.getInt(iE9);
                Integer numValueOf3 = cursorC.isNull(iE10) ? null : Integer.valueOf(cursorC.getInt(iE10));
                Integer numValueOf4 = cursorC.isNull(iE11) ? null : Integer.valueOf(cursorC.getInt(iE11));
                if (numValueOf4 != null) {
                    boolValueOf = Boolean.valueOf(numValueOf4.intValue() != 0);
                } else {
                    boolValueOf = null;
                }
                String string2 = cursorC.getString(iE12);
                int i6 = cursorC.getInt(iE13);
                String string3 = cursorC.isNull(iE14) ? null : cursorC.getString(iE14);
                if (string3 == null) {
                    i = iE15;
                    c4026Dj2C = null;
                } else {
                    c4026Dj2C = a.this.c.c(string3);
                    i = iE15;
                }
                CW4 cw4G = a.this.c.g(cursorC.isNull(i) ? null : cursorC.getString(i));
                if (cursorC.isNull(iE16)) {
                    i2 = iE17;
                    lValueOf = null;
                } else {
                    lValueOf = Long.valueOf(cursorC.getLong(iE16));
                    i2 = iE17;
                }
                if (cursorC.isNull(i2)) {
                    i3 = iE18;
                    numValueOf = null;
                } else {
                    numValueOf = Integer.valueOf(cursorC.getInt(i2));
                    i3 = iE18;
                }
                C22114uh2 c22114uh2 = new C22114uh2(j, j2, j3, i4, exPeerTypeG, blob, listD, numValueOf2, i5, numValueOf3, boolValueOf, string2, i6, c4026Dj2C, cw4G, lValueOf, numValueOf, cursorC.getInt(i3), cursorC.getLong(iE19));
                cursorC.close();
                this.b.j();
                return c22114uh2;
            } catch (Throwable th) {
                cursorC.close();
                this.b.j();
                throw th;
            }
        }
    }

    public static final class h implements Callable {
        final /* synthetic */ O26 b;

        h(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Boolean boolValueOf;
            C4026Dj2 c4026Dj2C;
            int i;
            String string;
            Long lValueOf;
            int i2;
            Integer numValueOf;
            int i3;
            Cursor cursorC = AbstractC7716Sx1.c(a.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "sort_id");
                int iE2 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_RID);
                int iE3 = AbstractC5795Kw1.e(cursorC, "date");
                int iE4 = AbstractC5795Kw1.e(cursorC, "peer_id");
                int iE5 = AbstractC5795Kw1.e(cursorC, PinMessageEntity.COLS_EX_PEER_TYPE);
                int iE6 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_MESSAGE);
                int iE7 = AbstractC5795Kw1.e(cursorC, "reaction");
                int iE8 = AbstractC5795Kw1.e(cursorC, "forwarded_count");
                int iE9 = AbstractC5795Kw1.e(cursorC, "sender_uid");
                int iE10 = AbstractC5795Kw1.e(cursorC, "upvote_count");
                int iE11 = AbstractC5795Kw1.e(cursorC, "is_upvoted_by_me");
                int iE12 = AbstractC5795Kw1.e(cursorC, SearchSuggestion.CATEGORY_ICON);
                int iE13 = AbstractC5795Kw1.e(cursorC, "message_type");
                int iE14 = AbstractC5795Kw1.e(cursorC, ParameterNames.TAG);
                int iE15 = AbstractC5795Kw1.e(cursorC, "parent_post_id");
                int iE16 = AbstractC5795Kw1.e(cursorC, "grouped_id");
                int iE17 = AbstractC5795Kw1.e(cursorC, "comment_count");
                int iE18 = AbstractC5795Kw1.e(cursorC, "category_id");
                int iE19 = AbstractC5795Kw1.e(cursorC, "file_id");
                int i4 = iE13;
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    long j = cursorC.getLong(iE);
                    long j2 = cursorC.getLong(iE2);
                    long j3 = cursorC.getLong(iE3);
                    int i5 = cursorC.getInt(iE4);
                    a aVar = a.this;
                    int i6 = iE;
                    String string2 = cursorC.getString(iE5);
                    int i7 = iE2;
                    AbstractC13042fc3.h(string2, "getString(...)");
                    ExPeerType exPeerTypeG = aVar.g(string2);
                    byte[] blob = cursorC.getBlob(iE6);
                    List listD = a.this.c.d(cursorC.getString(iE7));
                    Integer numValueOf2 = cursorC.isNull(iE8) ? null : Integer.valueOf(cursorC.getInt(iE8));
                    int i8 = cursorC.getInt(iE9);
                    Integer numValueOf3 = cursorC.isNull(iE10) ? null : Integer.valueOf(cursorC.getInt(iE10));
                    Integer numValueOf4 = cursorC.isNull(iE11) ? null : Integer.valueOf(cursorC.getInt(iE11));
                    if (numValueOf4 != null) {
                        boolValueOf = Boolean.valueOf(numValueOf4.intValue() != 0);
                    } else {
                        boolValueOf = null;
                    }
                    String string3 = cursorC.getString(iE12);
                    int i9 = i4;
                    int i10 = cursorC.getInt(i9);
                    int i11 = iE14;
                    String string4 = cursorC.isNull(i11) ? null : cursorC.getString(i11);
                    if (string4 == null) {
                        i4 = i9;
                        i = iE15;
                        c4026Dj2C = null;
                    } else {
                        i4 = i9;
                        c4026Dj2C = a.this.c.c(string4);
                        i = iE15;
                    }
                    if (cursorC.isNull(i)) {
                        iE15 = i;
                        string = null;
                    } else {
                        string = cursorC.getString(i);
                        iE15 = i;
                    }
                    CW4 cw4G = a.this.c.g(string);
                    int i12 = iE16;
                    if (cursorC.isNull(i12)) {
                        i2 = iE17;
                        lValueOf = null;
                    } else {
                        lValueOf = Long.valueOf(cursorC.getLong(i12));
                        i2 = iE17;
                    }
                    if (cursorC.isNull(i2)) {
                        iE16 = i12;
                        i3 = iE18;
                        numValueOf = null;
                    } else {
                        iE16 = i12;
                        numValueOf = Integer.valueOf(cursorC.getInt(i2));
                        i3 = iE18;
                    }
                    int i13 = cursorC.getInt(i3);
                    iE18 = i3;
                    int i14 = iE19;
                    iE19 = i14;
                    arrayList.add(new C22114uh2(j, j2, j3, i5, exPeerTypeG, blob, listD, numValueOf2, i8, numValueOf3, boolValueOf, string3, i10, c4026Dj2C, cw4G, lValueOf, numValueOf, i13, cursorC.getLong(i14)));
                    iE14 = i11;
                    iE17 = i2;
                    iE = i6;
                    iE2 = i7;
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

    public static final class i implements Callable {
        final /* synthetic */ O26 b;

        i(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(a.this.a, this.b, false, null);
            try {
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(Long.valueOf(cursorC.getLong(0)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    public static final class j implements Callable {
        final /* synthetic */ List b;

        j(List list) {
            this.b = list;
        }

        public void a() {
            a.this.a.e();
            try {
                a.this.b.j(this.b);
                a.this.a.F();
            } finally {
                a.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public a(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.c = new FeedTypeConverter();
        this.a = d26;
        this.b = new C1318a(d26, this);
        this.d = new b(d26);
        this.e = new c(d26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(ExPeerType exPeerType) {
        switch (e.a[exPeerType.ordinal()]) {
            case 1:
                return "UNKNOWN";
            case 2:
                return "PRIVATE";
            case 3:
                return "GROUP";
            case 4:
                return "CHANNEL";
            case 5:
                return "BOT";
            case 6:
                return "THREAD";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final ExPeerType g(String str) {
        switch (str.hashCode()) {
            case -1821113846:
                if (str.equals("THREAD")) {
                    return ExPeerType.THREAD;
                }
                break;
            case 65959:
                if (str.equals("BOT")) {
                    return ExPeerType.BOT;
                }
                break;
            case 68091487:
                if (str.equals("GROUP")) {
                    return ExPeerType.GROUP;
                }
                break;
            case 403485027:
                if (str.equals("PRIVATE")) {
                    return ExPeerType.PRIVATE;
                }
                break;
            case 433141802:
                if (str.equals("UNKNOWN")) {
                    return ExPeerType.UNKNOWN;
                }
                break;
            case 1456933091:
                if (str.equals("CHANNEL")) {
                    return ExPeerType.CHANNEL;
                }
                break;
        }
        throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + str);
    }

    @Override // ir.nasim.InterfaceC15500jh2
    public Object a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new j(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC15500jh2
    public Object b(long j2, long j3, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM feed WHERE rid = ? and date = ? LIMIT 1", 2);
        o26A.k1(1, j2);
        o26A.k1(2, j3);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new g(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC15500jh2
    public Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT file_id FROM feed", 0);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new i(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC15500jh2
    public Object d(int i2, int i3, int i4, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM feed WHERE category_id = ? LIMIT ? OFFSET ?", 3);
        o26A.k1(1, i4);
        o26A.k1(2, i2);
        o26A.k1(3, i3);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new h(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC15500jh2
    public Object e(int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new f(i2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }
}
