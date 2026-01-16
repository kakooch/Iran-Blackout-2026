package ir.nasim.database.dailogLists;

import android.database.Cursor;
import android.gov.nist.core.Separators;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC11429cz6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC19914r92;
import ir.nasim.AbstractC21126t92;
import ir.nasim.AbstractC5795Kw1;
import ir.nasim.AbstractC7716Sx1;
import ir.nasim.C19938rB7;
import ir.nasim.C21800u92;
import ir.nasim.D26;
import ir.nasim.ED1;
import ir.nasim.InterfaceC15121j27;
import ir.nasim.InterfaceC16512lP1;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.O26;
import ir.nasim.UA2;
import ir.nasim.WY6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class e implements InterfaceC16512lP1 {
    public static final C1016e e = new C1016e(null);
    private final D26 a;
    private final AbstractC11429cz6 b;
    private final AbstractC11429cz6 c;
    private final C21800u92 d;

    public static final class a extends AbstractC11429cz6 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "\n            DELETE FROM dialog_peer_unread_state\n            WHERE peerUid =?\n        ";
        }
    }

    public static final class b extends AbstractC11429cz6 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM dialog_peer_unread_state";
        }
    }

    public static final class c extends AbstractC21126t92 {
        c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT INTO `dialog_peer_unread_state` (`peerUid`,`isMute`) VALUES (?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, DialogPeerUnreadStateEntity dialogPeerUnreadStateEntity) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(dialogPeerUnreadStateEntity, "entity");
            interfaceC15121j27.k1(1, dialogPeerUnreadStateEntity.getPeerUid());
            interfaceC15121j27.k1(2, dialogPeerUnreadStateEntity.isMute() ? 1L : 0L);
        }
    }

    public static final class d extends AbstractC19914r92 {
        d(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "UPDATE `dialog_peer_unread_state` SET `peerUid` = ?,`isMute` = ? WHERE `peerUid` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC19914r92
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, DialogPeerUnreadStateEntity dialogPeerUnreadStateEntity) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(dialogPeerUnreadStateEntity, "entity");
            interfaceC15121j27.k1(1, dialogPeerUnreadStateEntity.getPeerUid());
            interfaceC15121j27.k1(2, dialogPeerUnreadStateEntity.isMute() ? 1L : 0L);
            interfaceC15121j27.k1(3, dialogPeerUnreadStateEntity.getPeerUid());
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.e$e, reason: collision with other inner class name */
    public static final class C1016e {
        private C1016e() {
        }

        public final List a() {
            return AbstractC10360bX0.m();
        }

        public /* synthetic */ C1016e(ED1 ed1) {
            this();
        }
    }

    public static final class f implements Callable {
        f() {
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = e.this.c.b();
            try {
                e.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    e.this.a.F();
                } finally {
                    e.this.a.j();
                }
            } finally {
                e.this.c.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class g implements Callable {
        final /* synthetic */ long b;

        g(long j) {
            this.b = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = e.this.b.b();
            interfaceC15121j27B.k1(1, this.b);
            try {
                e.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    e.this.a.F();
                } finally {
                    e.this.a.j();
                }
            } finally {
                e.this.b.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class h implements Callable {
        final /* synthetic */ List a;
        final /* synthetic */ e b;

        h(List list, e eVar) {
            this.a = list;
            this.b = eVar;
        }

        public void a() {
            StringBuilder sbB = WY6.b();
            sbB.append("DELETE FROM dialog_peer_unread_state WHERE peerUid IN (");
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

    public static final class i implements Callable {
        final /* synthetic */ O26 b;

        i(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(e.this.a, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "peerUid");
                int iE2 = AbstractC5795Kw1.e(cursorC, "isMute");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new DialogPeerUnreadStateEntity(cursorC.getLong(iE), cursorC.getInt(iE2) != 0));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    public static final class j implements Callable {
        final /* synthetic */ O26 b;

        j(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(e.this.a, this.b, false, null);
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

    public static final class k implements Callable {
        final /* synthetic */ O26 b;

        k(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            Cursor cursorC = AbstractC7716Sx1.c(e.this.a, this.b, false, null);
            try {
                Integer numValueOf = Integer.valueOf(cursorC.moveToFirst() ? cursorC.getInt(0) : 0);
                cursorC.close();
                return numValueOf;
            } catch (Throwable th) {
                cursorC.close();
                throw th;
            }
        }

        protected final void finalize() {
            this.b.j();
        }
    }

    static final class l extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return e.this.new l(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                e eVar = e.this;
                List list = this.d;
                this.b = 1;
                if (e.super.h(list, this) == objE) {
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
            return ((l) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class m implements Callable {
        final /* synthetic */ List b;

        m(List list) {
            this.b = list;
        }

        public void a() {
            e.this.a.e();
            try {
                e.this.d.b(this.b);
                e.this.a.F();
            } finally {
                e.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class n implements Callable {
        final /* synthetic */ DialogPeerUnreadStateEntity b;

        n(DialogPeerUnreadStateEntity dialogPeerUnreadStateEntity) {
            this.b = dialogPeerUnreadStateEntity;
        }

        public void a() {
            e.this.a.e();
            try {
                e.this.d.c(this.b);
                e.this.a.F();
            } finally {
                e.this.a.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    static final class o extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ Set d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(Set set, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = set;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return e.this.new o(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                e eVar = e.this;
                Set set = this.d;
                this.b = 1;
                if (e.super.k(set, this) == objE) {
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

    public e(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.a = d26;
        this.b = new a(d26);
        this.c = new b(d26);
        this.d = new C21800u92(new c(d26), new d(d26));
    }

    @Override // ir.nasim.InterfaceC16512lP1
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new f(), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC16512lP1
    public Object b(InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM dialog_peer_unread_state", 0);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new i(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC16512lP1
    public Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT peerUid FROM dialog_peer_unread_state", 0);
        return androidx.room.a.a.b(this.a, false, AbstractC7716Sx1.a(), new j(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC16512lP1
    public Object d(DialogPeerUnreadStateEntity dialogPeerUnreadStateEntity, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new n(dialogPeerUnreadStateEntity), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC16512lP1
    public Object f(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new h(list, this), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC16512lP1
    public Object g(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new g(j2), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC16512lP1
    public Object h(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.a, new l(list, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC16512lP1
    public InterfaceC4557Fq2 j() {
        return androidx.room.a.a.a(this.a, false, new String[]{DialogPeerUnreadStateEntity.TABLE_NAME}, new k(O26.i.a("SELECT COUNT(peerUid) from dialog_peer_unread_state where isMute = 0", 0)));
    }

    @Override // ir.nasim.InterfaceC16512lP1
    public Object k(Set set, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.a, new o(set, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC16512lP1
    public Object l(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new m(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }
}
