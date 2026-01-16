package ir.nasim.database.dailogLists;

import android.database.Cursor;
import android.gov.nist.core.Separators;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC11429cz6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC21126t92;
import ir.nasim.AbstractC5795Kw1;
import ir.nasim.AbstractC7716Sx1;
import ir.nasim.C19938rB7;
import ir.nasim.D26;
import ir.nasim.ED1;
import ir.nasim.HM1;
import ir.nasim.InterfaceC15121j27;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.O26;
import ir.nasim.UA2;
import ir.nasim.WY6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class a extends HM1 {
    public static final n o = new n(null);
    private final D26 a;
    private final AbstractC21126t92 b;
    private final AbstractC11429cz6 c;
    private final AbstractC11429cz6 d;
    private final AbstractC11429cz6 e;
    private final AbstractC11429cz6 f;
    private final AbstractC11429cz6 g;
    private final AbstractC11429cz6 h;
    private final AbstractC11429cz6 i;
    private final AbstractC11429cz6 j;
    private final AbstractC11429cz6 k;
    private final AbstractC11429cz6 l;
    private final AbstractC11429cz6 m;
    private final AbstractC11429cz6 n;

    public static final class A implements Callable {
        final /* synthetic */ List b;

        A(List list) {
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

    public static final class B implements Callable {
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;
        final /* synthetic */ boolean d;
        final /* synthetic */ boolean e;
        final /* synthetic */ long f;

        B(String str, boolean z, boolean z2, boolean z3, long j) {
            this.b = str;
            this.c = z;
            this.d = z2;
            this.e = z3;
            this.f = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = a.this.e.b();
            interfaceC15121j27B.U0(1, this.b);
            interfaceC15121j27B.k1(2, this.c ? 1L : 0L);
            interfaceC15121j27B.k1(3, this.d ? 1L : 0L);
            interfaceC15121j27B.k1(4, this.e ? 1L : 0L);
            interfaceC15121j27B.k1(5, this.f);
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

    public static final class C implements Callable {
        final /* synthetic */ String b;
        final /* synthetic */ Long c;
        final /* synthetic */ long d;

        C(String str, Long l, long j) {
            this.b = str;
            this.c = l;
            this.d = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = a.this.f.b();
            interfaceC15121j27B.U0(1, this.b);
            Long l = this.c;
            if (l == null) {
                interfaceC15121j27B.y1(2);
            } else {
                interfaceC15121j27B.k1(2, l.longValue());
            }
            interfaceC15121j27B.k1(3, this.d);
            try {
                a.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    a.this.a.F();
                } finally {
                    a.this.a.j();
                }
            } finally {
                a.this.f.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class D implements Callable {
        final /* synthetic */ long b;
        final /* synthetic */ DialogLastMessage c;
        final /* synthetic */ long d;

        D(long j, DialogLastMessage dialogLastMessage, long j2) {
            this.b = j;
            this.c = dialogLastMessage;
            this.d = j2;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = a.this.i.b();
            interfaceC15121j27B.k1(1, this.b);
            DialogLastMessage dialogLastMessage = this.c;
            String strD = dialogLastMessage == null ? null : f.a.d(dialogLastMessage);
            if (strD == null) {
                interfaceC15121j27B.y1(2);
            } else {
                interfaceC15121j27B.U0(2, strD);
            }
            interfaceC15121j27B.k1(3, this.d);
            try {
                a.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    a.this.a.F();
                } finally {
                    a.this.a.j();
                }
            } finally {
                a.this.i.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class E implements Callable {
        final /* synthetic */ int b;
        final /* synthetic */ long c;

        E(int i, long j) {
            this.b = i;
            this.c = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = a.this.h.b();
            interfaceC15121j27B.k1(1, this.b);
            interfaceC15121j27B.k1(2, this.c);
            try {
                a.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    a.this.a.F();
                } finally {
                    a.this.a.j();
                }
            } finally {
                a.this.h.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class F implements Callable {
        final /* synthetic */ List b;
        final /* synthetic */ long c;

        F(List list, long j) {
            this.b = list;
            this.c = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = a.this.j.b();
            String strF = f.a.f(this.b);
            if (strF == null) {
                interfaceC15121j27B.y1(1);
            } else {
                interfaceC15121j27B.U0(1, strF);
            }
            interfaceC15121j27B.k1(2, this.c);
            try {
                a.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    a.this.a.F();
                } finally {
                    a.this.a.j();
                }
            } finally {
                a.this.j.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class G implements Callable {
        final /* synthetic */ List b;
        final /* synthetic */ long c;

        G(List list, long j) {
            this.b = list;
            this.c = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = a.this.k.b();
            String strF = f.a.f(this.b);
            if (strF == null) {
                interfaceC15121j27B.y1(1);
            } else {
                interfaceC15121j27B.U0(1, strF);
            }
            interfaceC15121j27B.k1(2, this.c);
            try {
                a.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    a.this.a.F();
                } finally {
                    a.this.a.j();
                }
            } finally {
                a.this.k.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.a$a, reason: collision with other inner class name */
    public static final class C1012a extends AbstractC11429cz6 {
        C1012a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialogs SET unreadReActions = ? WHERE peerUid = ?";
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.a$b, reason: case insensitive filesystem */
    public static final class C11776b extends AbstractC11429cz6 {
        C11776b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialogs SET markAsUnRead = 1 WHERE peerUid = ?";
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.a$c, reason: case insensitive filesystem */
    public static final class C11777c extends AbstractC11429cz6 {
        C11777c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialogs SET markAsUnRead = 0, unreadCount = 0 WHERE peerUid = ?";
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.a$d, reason: case insensitive filesystem */
    public static final class C11778d extends AbstractC11429cz6 {
        C11778d(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialogs SET unreadReActions = null WHERE peerUid = ?";
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.a$e, reason: case insensitive filesystem */
    public static final class C11779e extends AbstractC21126t92 {
        C11779e(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR REPLACE INTO `dialogs` (`peerUid`,`rid`,`dialogTitle`,`sortDate`,`unreadCount`,`isDeletedAccount`,`draft`,`draftDate`,`isGroupCallRunning`,`exPeerType`,`puppetType`,`message`,`hasBlueTick`,`firstUnreadDate`,`unreadMentions`,`unreadReActions`,`isLocallyDeleted`,`isForwarded`,`markAsUnRead`,`hasMainWebApp`,`isPinned`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, DialogEntity dialogEntity) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(dialogEntity, "entity");
            interfaceC15121j27.k1(1, dialogEntity.getPeerUid());
            interfaceC15121j27.k1(2, dialogEntity.getRid());
            interfaceC15121j27.U0(3, dialogEntity.getDialogTitle());
            interfaceC15121j27.k1(4, dialogEntity.getSortDate());
            interfaceC15121j27.k1(5, dialogEntity.getUnreadCount());
            interfaceC15121j27.k1(6, dialogEntity.isDeletedAccount() ? 1L : 0L);
            String draft = dialogEntity.getDraft();
            if (draft == null) {
                interfaceC15121j27.y1(7);
            } else {
                interfaceC15121j27.U0(7, draft);
            }
            Long draftDate = dialogEntity.getDraftDate();
            if (draftDate == null) {
                interfaceC15121j27.y1(8);
            } else {
                interfaceC15121j27.k1(8, draftDate.longValue());
            }
            interfaceC15121j27.k1(9, dialogEntity.isGroupCallRunning() ? 1L : 0L);
            interfaceC15121j27.U0(10, dialogEntity.getExPeerType());
            String puppetType = dialogEntity.getPuppetType();
            if (puppetType == null) {
                interfaceC15121j27.y1(11);
            } else {
                interfaceC15121j27.U0(11, puppetType);
            }
            DialogLastMessage message = dialogEntity.getMessage();
            String strD = message == null ? null : f.a.d(message);
            if (strD == null) {
                interfaceC15121j27.y1(12);
            } else {
                interfaceC15121j27.U0(12, strD);
            }
            Boolean hasBlueTick = dialogEntity.getHasBlueTick();
            if ((hasBlueTick != null ? Integer.valueOf(hasBlueTick.booleanValue() ? 1 : 0) : null) == null) {
                interfaceC15121j27.y1(13);
            } else {
                interfaceC15121j27.k1(13, r0.intValue());
            }
            Long firstUnreadDate = dialogEntity.getFirstUnreadDate();
            if (firstUnreadDate == null) {
                interfaceC15121j27.y1(14);
            } else {
                interfaceC15121j27.k1(14, firstUnreadDate.longValue());
            }
            List<MessageIdentifier> unreadMentions = dialogEntity.getUnreadMentions();
            String strF = unreadMentions == null ? null : f.a.f(unreadMentions);
            if (strF == null) {
                interfaceC15121j27.y1(15);
            } else {
                interfaceC15121j27.U0(15, strF);
            }
            List<MessageIdentifier> unreadReActions = dialogEntity.getUnreadReActions();
            String strF2 = unreadReActions == null ? null : f.a.f(unreadReActions);
            if (strF2 == null) {
                interfaceC15121j27.y1(16);
            } else {
                interfaceC15121j27.U0(16, strF2);
            }
            interfaceC15121j27.k1(17, dialogEntity.isLocallyDeleted() ? 1L : 0L);
            interfaceC15121j27.k1(18, dialogEntity.isForwarded() ? 1L : 0L);
            Boolean markAsUnread = dialogEntity.getMarkAsUnread();
            if ((markAsUnread != null ? Integer.valueOf(markAsUnread.booleanValue() ? 1 : 0) : null) == null) {
                interfaceC15121j27.y1(19);
            } else {
                interfaceC15121j27.k1(19, r0.intValue());
            }
            interfaceC15121j27.k1(20, dialogEntity.getHasMainWebApp() ? 1L : 0L);
            Boolean boolIsPinned = dialogEntity.isPinned();
            if ((boolIsPinned != null ? Integer.valueOf(boolIsPinned.booleanValue() ? 1 : 0) : null) == null) {
                interfaceC15121j27.y1(21);
            } else {
                interfaceC15121j27.k1(21, r1.intValue());
            }
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.a$f, reason: case insensitive filesystem */
    public static final class C11780f extends AbstractC11429cz6 {
        C11780f(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM dialogs";
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.a$g, reason: case insensitive filesystem */
    public static final class C11781g extends AbstractC11429cz6 {
        C11781g(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM dialogs WHERE peerUid = ?";
        }
    }

    public static final class h extends AbstractC11429cz6 {
        h(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "\n        UPDATE dialogs \n        SET dialogTitle = ?, isDeletedAccount = ?, hasBlueTick = ?, hasMainWebApp = ?\n        WHERE peerUid = ?\n    ";
        }
    }

    public static final class i extends AbstractC11429cz6 {
        i(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialogs SET draft = ?, draftDate = ? WHERE peerUid = ?";
        }
    }

    public static final class j extends AbstractC11429cz6 {
        j(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialogs SET firstUnreadDate = ? WHERE peerUid = ?";
        }
    }

    public static final class k extends AbstractC11429cz6 {
        k(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialogs SET unreadCount = ? WHERE peerUid = ?";
        }
    }

    public static final class l extends AbstractC11429cz6 {
        l(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialogs SET rid = ?, message = ? WHERE peerUid = ?";
        }
    }

    public static final class m extends AbstractC11429cz6 {
        m(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialogs SET unreadMentions = ? WHERE peerUid = ?";
        }
    }

    public static final class n {
        private n() {
        }

        public final List a() {
            return AbstractC10360bX0.m();
        }

        public /* synthetic */ n(ED1 ed1) {
            this();
        }
    }

    static final class o extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ DialogEntity d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(DialogEntity dialogEntity, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = dialogEntity;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new o(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                a aVar = a.this;
                DialogEntity dialogEntity = this.d;
                this.b = 1;
                if (a.super.a(dialogEntity, this) == objE) {
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
            return ((o) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class p implements Callable {
        final /* synthetic */ long b;

        p(long j) {
            this.b = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = a.this.n.b();
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
                a.this.n.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class q implements Callable {
        q() {
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = a.this.c.b();
            try {
                a.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    a.this.a.F();
                } finally {
                    a.this.a.j();
                }
            } finally {
                a.this.c.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class r implements Callable {
        final /* synthetic */ long b;

        r(long j) {
            this.b = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = a.this.d.b();
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
                a.this.d.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    static final class s extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new s(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                a aVar = a.this;
                List list = this.d;
                this.b = 1;
                obj = a.super.h(list, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((s) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class t implements Callable {
        final /* synthetic */ O26 b;

        t(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DialogEntity call() throws Throwable {
            DialogEntity dialogEntity;
            Boolean boolValueOf;
            Long lValueOf;
            int i;
            int i2;
            boolean z;
            int i3;
            boolean z2;
            int i4;
            Boolean boolValueOf2;
            Boolean boolValueOf3;
            t tVar = this;
            Cursor cursorC = AbstractC7716Sx1.c(a.this.a, tVar.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "peerUid");
                int iE2 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_RID);
                int iE3 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_DIALOG_TITLE);
                int iE4 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_SORT_DATE);
                int iE5 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_UNREAD_COUNT);
                int iE6 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_IS_DELETED_ACCOUNT);
                int iE7 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_DRAFT);
                int iE8 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_DRAFT_DATE);
                int iE9 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_IS_GROUP_CALL_RUNNING);
                int iE10 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_EX_PEER_TYPE);
                int iE11 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_PUPPET_TYPE);
                int iE12 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_MESSAGE);
                int iE13 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_HAS_BLUE_TICK);
                int iE14 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_FIRST_UNREAD_DATE);
                try {
                    int iE15 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_UNREAD_MENTIONS_DATE);
                    int iE16 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_UNREAD_RE_ACTION_DATE);
                    int iE17 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_DELETED_LOCALLY);
                    int iE18 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_IS_FORWARDED);
                    int iE19 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_MARK_AS_UNREAD);
                    int iE20 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_HAS_MAIN_WEBAPP);
                    int iE21 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_IS_PINNED);
                    if (cursorC.moveToFirst()) {
                        long j = cursorC.getLong(iE);
                        long j2 = cursorC.getLong(iE2);
                        String string = cursorC.getString(iE3);
                        long j3 = cursorC.getLong(iE4);
                        int i5 = cursorC.getInt(iE5);
                        boolean z3 = cursorC.getInt(iE6) != 0;
                        String string2 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                        Long lValueOf2 = cursorC.isNull(iE8) ? null : Long.valueOf(cursorC.getLong(iE8));
                        boolean z4 = cursorC.getInt(iE9) != 0;
                        String string3 = cursorC.getString(iE10);
                        String string4 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                        String string5 = cursorC.isNull(iE12) ? null : cursorC.getString(iE12);
                        f fVar = f.a;
                        DialogLastMessage dialogLastMessageC = fVar.c(string5);
                        Integer numValueOf = cursorC.isNull(iE13) ? null : Integer.valueOf(cursorC.getInt(iE13));
                        if (numValueOf != null) {
                            boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                        } else {
                            boolValueOf = null;
                        }
                        if (cursorC.isNull(iE14)) {
                            i = iE15;
                            lValueOf = null;
                        } else {
                            lValueOf = Long.valueOf(cursorC.getLong(iE14));
                            i = iE15;
                        }
                        List listE = fVar.e(cursorC.isNull(i) ? null : cursorC.getString(i));
                        List listE2 = fVar.e(cursorC.isNull(iE16) ? null : cursorC.getString(iE16));
                        if (cursorC.getInt(iE17) != 0) {
                            z = true;
                            i2 = iE18;
                        } else {
                            i2 = iE18;
                            z = false;
                        }
                        if (cursorC.getInt(i2) != 0) {
                            z2 = true;
                            i3 = iE19;
                        } else {
                            i3 = iE19;
                            z2 = false;
                        }
                        Integer numValueOf2 = cursorC.isNull(i3) ? null : Integer.valueOf(cursorC.getInt(i3));
                        if (numValueOf2 != null) {
                            boolValueOf2 = Boolean.valueOf(numValueOf2.intValue() != 0);
                            i4 = iE20;
                        } else {
                            i4 = iE20;
                            boolValueOf2 = null;
                        }
                        boolean z5 = cursorC.getInt(i4) != 0;
                        Integer numValueOf3 = cursorC.isNull(iE21) ? null : Integer.valueOf(cursorC.getInt(iE21));
                        if (numValueOf3 != null) {
                            boolValueOf3 = Boolean.valueOf(numValueOf3.intValue() != 0);
                        } else {
                            boolValueOf3 = null;
                        }
                        dialogEntity = new DialogEntity(j, j2, string, j3, i5, z3, string2, lValueOf2, z4, string3, string4, dialogLastMessageC, boolValueOf, lValueOf, listE, listE2, z, z2, boolValueOf2, z5, boolValueOf3);
                    } else {
                        dialogEntity = null;
                    }
                    cursorC.close();
                    this.b.j();
                    return dialogEntity;
                } catch (Throwable th) {
                    th = th;
                    tVar = this;
                    cursorC.close();
                    tVar.b.j();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static final class u implements Callable {
        final /* synthetic */ O26 b;

        u(O26 o26) {
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

    public static final class v implements Callable {
        final /* synthetic */ long b;

        v(long j) {
            this.b = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = a.this.m.b();
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
                a.this.m.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class w implements Callable {
        final /* synthetic */ long b;

        w(long j) {
            this.b = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = a.this.l.b();
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
                a.this.l.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class x implements Callable {
        final /* synthetic */ List a;
        final /* synthetic */ a b;

        x(List list, a aVar) {
            this.a = list;
            this.b = aVar;
        }

        public void a() {
            StringBuilder sbB = WY6.b();
            sbB.append("UPDATE dialogs SET isLocallyDeleted = 1 WHERE peerUid IN (");
            WY6.a(sbB, this.a.size());
            sbB.append(Separators.RPAREN);
            String string = sbB.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            InterfaceC15121j27 interfaceC15121j27G = this.b.a.g(string);
            Iterator it = this.a.iterator();
            int i = 1;
            while (it.hasNext()) {
                interfaceC15121j27G.k1(i, ((Number) it.next()).longValue());
                i++;
            }
            this.b.a.e();
            try {
                interfaceC15121j27G.V();
                this.b.a.F();
            } finally {
                this.b.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class y implements Callable {
        final /* synthetic */ List a;
        final /* synthetic */ a b;

        y(List list, a aVar) {
            this.a = list;
            this.b = aVar;
        }

        public void a() {
            StringBuilder sbB = WY6.b();
            sbB.append("UPDATE dialogs SET isLocallyDeleted = 0 WHERE peerUid IN (");
            WY6.a(sbB, this.a.size());
            sbB.append(Separators.RPAREN);
            String string = sbB.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            InterfaceC15121j27 interfaceC15121j27G = this.b.a.g(string);
            Iterator it = this.a.iterator();
            int i = 1;
            while (it.hasNext()) {
                interfaceC15121j27G.k1(i, ((Number) it.next()).longValue());
                i++;
            }
            this.b.a.e();
            try {
                interfaceC15121j27G.V();
                this.b.a.F();
            } finally {
                this.b.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class z implements Callable {
        final /* synthetic */ DialogEntity b;

        z(DialogEntity dialogEntity) {
            this.b = dialogEntity;
        }

        public void a() {
            a.this.a.e();
            try {
                a.this.b.k(this.b);
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
        this.a = d26;
        this.b = new C11779e(d26);
        this.c = new C11780f(d26);
        this.d = new C11781g(d26);
        this.e = new h(d26);
        this.f = new i(d26);
        this.g = new j(d26);
        this.h = new k(d26);
        this.i = new l(d26);
        this.j = new m(d26);
        this.k = new C1012a(d26);
        this.l = new C11776b(d26);
        this.m = new C11777c(d26);
        this.n = new C11778d(d26);
    }

    @Override // ir.nasim.HM1
    public Object a(DialogEntity dialogEntity, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.a, new o(dialogEntity, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object e(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new p(j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object f(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new q(), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object g(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new r(j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object h(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return androidx.room.f.d(this.a, new s(list, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.HM1
    public Object j(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM dialogs WHERE peerUid = ? LIMIT 1", 1);
        o26A.k1(1, j2);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new t(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.HM1
    public Object k(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        StringBuilder sbB = WY6.b();
        sbB.append("SELECT peerUid FROM dialogs WHERE peerUid IN (");
        int size = list.size();
        WY6.a(sbB, size);
        sbB.append(Separators.RPAREN);
        String string = sbB.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        O26 o26A = O26.i.a(string, size);
        Iterator it = list.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            o26A.k1(i2, ((Number) it.next()).longValue());
            i2++;
        }
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new u(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.HM1
    public Object l(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new v(j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object m(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new w(j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object n(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new x(list, this), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object o(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new y(list, this), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object p(DialogEntity dialogEntity, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new z(dialogEntity), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object q(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new A(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object r(long j2, String str, boolean z2, boolean z3, boolean z4, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new B(str, z4, z2, z3, j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object t(long j2, String str, Long l2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new C(str, l2, j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object u(long j2, long j3, DialogLastMessage dialogLastMessage, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new D(j3, dialogLastMessage, j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object v(long j2, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new E(i2, j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object w(long j2, List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new F(list, j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.HM1
    public Object x(long j2, List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new G(list, j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }
}
