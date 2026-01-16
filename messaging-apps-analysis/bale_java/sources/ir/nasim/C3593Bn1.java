package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Bn1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3593Bn1 extends Z6 {

    /* renamed from: ir.nasim.Bn1$a */
    public static final class a implements InterfaceC15283jK {
        private final C11458d25 a;
        private final long b;
        private final long c;
        private final int d;

        public a(C11458d25 c11458d25, long j, long j2, int i) {
            AbstractC13042fc3.i(c11458d25, "peer");
            this.a = c11458d25;
            this.b = j;
            this.c = j2;
            this.d = i;
        }

        public final long a() {
            return this.c;
        }

        public final int b() {
            return this.d;
        }

        public final C11458d25 c() {
            return this.a;
        }

        public final long d() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Bn1$b */
    public static final class b {
        private final long a;
        private final boolean b;

        public b(long j, boolean z) {
            this.a = j;
            this.b = z;
        }

        public final long a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Bn1$c */
    public static final class c {
        private final boolean a;

        public c(boolean z) {
            this.a = z;
        }

        public final boolean a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bn1$d */
    public static final class d {
        private final boolean a;

        public d(boolean z) {
            this.a = z;
        }

        public final boolean a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bn1$e */
    public static final class e implements InterfaceC15283jK {
        private final long a;
        private final long b;

        public e(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public final long a() {
            return this.a;
        }

        public final long b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Bn1$f */
    public static final class f implements InterfaceC15283jK {
        public static final f a = new f();

        private f() {
        }
    }

    /* renamed from: ir.nasim.Bn1$g */
    public static final class g implements InterfaceC15283jK {
        private long a;

        public g(long j) {
            this.a = j;
        }

        public final long a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bn1$h */
    public static final class h implements InterfaceC15283jK {
        public static final h a = new h();

        private h() {
        }
    }

    /* renamed from: ir.nasim.Bn1$i */
    public static final class i implements InterfaceC15283jK {
        private final J44 a;

        public i(J44 j44) {
            AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            this.a = j44;
        }

        public final J44 a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bn1$j */
    public static final class j {
        private final C11458d25 a;

        public j(C11458d25 c11458d25) {
            this.a = c11458d25;
        }

        public final C11458d25 a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bn1$k */
    public static final class k {
        private final List a;

        public k(List list) {
            AbstractC13042fc3.i(list, "messages");
            this.a = list;
        }

        public final List a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bn1$l */
    public static final class l implements InterfaceC15283jK {
        private long a;

        public l(long j) {
            this.a = j;
        }

        public final long a() {
            return this.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3593Bn1(C9528a7 c9528a7) {
        super(c9528a7);
        AbstractC13042fc3.i(c9528a7, "dest");
    }

    public static /* synthetic */ C6517Nv5 A(C3593Bn1 c3593Bn1, C11458d25 c11458d25, InterfaceC21893uJ4 interfaceC21893uJ4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            interfaceC21893uJ4 = null;
        }
        return c3593Bn1.y(c11458d25, interfaceC21893uJ4);
    }

    public static /* synthetic */ C6517Nv5 z(C3593Bn1 c3593Bn1, C11458d25 c11458d25, long j2, long j3, int i2, InterfaceC21893uJ4 interfaceC21893uJ4, int i3, Object obj) {
        return c3593Bn1.x(c11458d25, j2, j3, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? null : interfaceC21893uJ4);
    }

    public final C6517Nv5 j(C11458d25 c11458d25, long j2, long j3, int i2) {
        AbstractC13042fc3.f(c11458d25);
        return c(new a(c11458d25, j2, j3, i2));
    }

    public final void k(long j2, boolean z) {
        i(new b(j2, z));
    }

    public final void l() {
        i(new d(false));
    }

    public final C6517Nv5 m(long j2, long j3) {
        return c(new e(j2, j3));
    }

    public final C6517Nv5 n() {
        C6517Nv5 c6517Nv5C = c(f.a);
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final C6517Nv5 o(long j2) {
        return c(new g(j2));
    }

    public final C6517Nv5 p() {
        return c(h.a);
    }

    public final C6517Nv5 q(J44 j44) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        return c(new i(j44));
    }

    public final void r(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "currentMessagesRange");
        i(new k(arrayList));
    }

    public final C6517Nv5 s(long j2) {
        C6517Nv5 c6517Nv5C = c(new l(j2));
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final C6517Nv5 t(long j2, long j3, J44 j44, C10508bj5 c10508bj5) {
        AbstractC13042fc3.i(j44, "discussionMessage");
        AbstractC13042fc3.i(c10508bj5, "postInfo");
        C6517Nv5 c6517Nv5C = c(new UK4(j2, j3, j44, c10508bj5));
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final C6517Nv5 u(C11458d25 c11458d25) {
        return A(this, c11458d25, null, 2, null);
    }

    public final C6517Nv5 v(C11458d25 c11458d25, long j2, long j3) {
        return z(this, c11458d25, j2, j3, 0, null, 24, null);
    }

    public final C6517Nv5 w(C11458d25 c11458d25, long j2, long j3, int i2) {
        return z(this, c11458d25, j2, j3, i2, null, 16, null);
    }

    public final C6517Nv5 x(C11458d25 c11458d25, long j2, long j3, int i2, InterfaceC21893uJ4 interfaceC21893uJ4) {
        C6517Nv5 c6517Nv5C = c(new C12279eL4(c11458d25, j2, j3, i2, interfaceC21893uJ4));
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final C6517Nv5 y(C11458d25 c11458d25, InterfaceC21893uJ4 interfaceC21893uJ4) {
        C6517Nv5 c6517Nv5C = c(new C10256bL4(c11458d25, interfaceC21893uJ4));
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }
}
