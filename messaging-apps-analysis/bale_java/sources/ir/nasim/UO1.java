package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.RP1;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class UO1 {
    public static final UO1 a = new UO1();

    public static final class a {
        public static final a a = new a();

        private a() {
        }

        public static final void a(String str) {
            c(str, null, 2, null);
        }

        public static final void b(String str, String str2) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append("updateName: " + str + " | ");
            }
            if (str2 != null) {
                sb.append("message: " + str2 + " | ");
            }
            String string = sb.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            String string2 = AbstractC20762sZ6.n1(string).toString();
            UO1.a.a("Actor", string2, string2);
        }

        public static /* synthetic */ void c(String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            b(str, str2);
        }

        public static final void d(String str, Throwable th) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            UO1.a.c("Actor", str, th);
        }
    }

    public static final class b {
        public static final b a = new b();

        private b() {
        }

        public static /* synthetic */ void b(b bVar, String str, String str2, String str3, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            bVar.a(str, str2, str3);
        }

        public final void a(String str, String str2, String str3) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            StringBuilder sb = new StringBuilder();
            if (str2 != null) {
                sb.append("TraitCase: " + str2 + " | ");
            }
            if (str3 != null) {
                sb.append("Content: " + str3);
            }
            String string = sb.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            UO1.a.a("Mapping", str, AbstractC20762sZ6.n1(string).toString());
        }
    }

    public static final class c {
        public static final c a = new c();

        private c() {
        }

        public static /* synthetic */ void b(c cVar, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            cVar.a(str, str2);
        }

        public static /* synthetic */ void d(c cVar, String str, Throwable th, int i, Object obj) {
            if ((i & 2) != 0) {
                th = null;
            }
            cVar.c(str, th);
        }

        public final void a(String str, String str2) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            UO1.a.a("DB", str, str2);
        }

        public final void c(String str, Throwable th) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            UO1.a.c("DB", str, th);
        }
    }

    public static final class d {
        public static final d a = new d();

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        public static final class a {
            public static final a a = new a("PagingSource", 0);
            public static final a b = new a("Manager", 1);
            public static final a c = new a("Adapter", 2);
            public static final a d = new a("Mediator", 3);
            public static final a e = new a("Undefined", 4);
            public static final a f = new a("Fragment", 5);
            public static final a g = new a("ViewModel", 6);
            public static final a h = new a("Invalidation", 7);
            private static final /* synthetic */ a[] i;
            private static final /* synthetic */ F92 j;

            static {
                a[] aVarArrA = a();
                i = aVarArrA;
                j = G92.a(aVarArrA);
            }

            private a(String str, int i2) {
            }

            private static final /* synthetic */ a[] a() {
                return new a[]{a, b, c, d, e, f, g, h};
            }

            public static a valueOf(String str) {
                return (a) Enum.valueOf(a.class, str);
            }

            public static a[] values() {
                return (a[]) i.clone();
            }
        }

        private d() {
        }

        public static /* synthetic */ void d(d dVar, String str, Throwable th, a aVar, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                th = null;
            }
            if ((i2 & 4) != 0) {
                aVar = a.e;
            }
            dVar.c(str, th, aVar, i);
        }

        public final void a(int i, String str, a aVar) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(aVar, "section");
            b(i, str, aVar.name());
        }

        public final void b(int i, String str, String str2) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(str2, "section");
            UO1.b(UO1.a, "PAGER", i + "-" + str2 + ": " + str, null, 4, null);
        }

        public final void c(String str, Throwable th, a aVar, int i) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(aVar, "section");
            UO1.a.c("PAGER", i + ":" + aVar.name() + ": " + str, th);
        }
    }

    public static final class e {
        public static final e a = new e();

        private e() {
        }

        public static /* synthetic */ void b(e eVar, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            eVar.a(str, str2);
        }

        public final void a(String str, String str2) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            UO1.a.a("REMOTE", str, str2);
        }

        public final void c(String str, Throwable th) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            UO1.a.c("REMOTE", str, th);
        }
    }

    public static final class f {
        public static final f a = new f();

        private f() {
        }

        public static final void a(RP1 rp1) {
            AbstractC13042fc3.i(rp1, "update");
            if (rp1 instanceof RP1.l) {
                RP1.l lVar = (RP1.l) rp1;
                a.b("UnreadCountChanged", "peer=" + lVar.a() + ", unread=" + lVar.b());
                return;
            }
            if (rp1 instanceof RP1.j) {
                RP1.j jVar = (RP1.j) rp1;
                a.b("PeerRead", "peer=" + jVar.c() + ", state=" + jVar.b());
                return;
            }
            if (rp1 instanceof RP1.d) {
                RP1.d dVar = (RP1.d) rp1;
                a.b("DraftChanged", "peer=" + dVar.c() + ", date=" + dVar.b());
                return;
            }
            if (rp1 instanceof RP1.g) {
                RP1.g gVar = (RP1.g) rp1;
                a.b("MentionRead", "peer=" + gVar.b() + ", hasMention=" + gVar.a());
                return;
            }
            if (rp1 instanceof RP1.k) {
                RP1.k kVar = (RP1.k) rp1;
                a.b("ReactionStateChange", "peer=" + kVar.b() + ", reaction='" + kVar.a() + Separators.QUOTE);
                return;
            }
            if (rp1 instanceof RP1.h) {
                f fVar = a;
                StringBuilder sb = new StringBuilder();
                RP1.h hVar = (RP1.h) rp1;
                sb.append("peer=" + hVar.b());
                sb.append(", rid=" + hVar.c());
                sb.append(", sortDate=" + hVar.e());
                C19938rB7 c19938rB7 = C19938rB7.a;
                String string = sb.toString();
                AbstractC13042fc3.h(string, "toString(...)");
                fVar.b("NewMessage", string);
                return;
            }
            if (rp1 instanceof RP1.b) {
                a.b("DialogsDeletedLocally", "peers=" + ((RP1.b) rp1).a());
                return;
            }
            if (rp1 instanceof RP1.c) {
                a.b("DialogsRestored", "peers=" + ((RP1.c) rp1).a());
                return;
            }
            if (rp1 instanceof RP1.f) {
                RP1.f fVar2 = (RP1.f) rp1;
                a.b("MarkedAsUnReadChanged", "peers=" + fVar2.a() + ", isUnRead=" + fVar2.b());
                return;
            }
            if (rp1 instanceof RP1.i) {
                RP1.i iVar = (RP1.i) rp1;
                a.b("NotificationChanged", "peers=" + iVar.a() + ", enabled=" + iVar.b());
                return;
            }
            if (rp1 instanceof RP1.e) {
                a.b("GroupChanged", String.valueOf(((RP1.e) rp1).b()));
                return;
            }
            if (rp1 instanceof RP1.m) {
                a.b("UserChanged", String.valueOf(((RP1.m) rp1).b()));
                return;
            }
            boolean z = rp1 instanceof RP1.a;
            if (z) {
                a.b("DeleteDialogs", String.valueOf(((RP1.a) rp1).a()));
            } else {
                if (!z) {
                    throw new NoWhenBranchMatchedException();
                }
                a.b("DeleteDialogs", String.valueOf(((RP1.a) rp1).a()));
            }
        }

        private final void b(String str, String str2) {
            C19406qI3.a("Dialog-UiUpdate-" + str, str2, new Object[0]);
        }
    }

    private UO1() {
    }

    public static /* synthetic */ void b(UO1 uo1, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        uo1.a(str, str2, str3);
    }

    public final void a(String str, String str2, String str3) {
        AbstractC13042fc3.i(str, "tagSuffix");
        AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
        String str4 = "Dialog-" + str;
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        if (str3 != null) {
            sb.append(" | Info: " + str3);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        C19406qI3.a(str4, string, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.lang.String r3, java.lang.String r4, java.lang.Throwable r5) {
        /*
            r2 = this;
            java.lang.String r0 = "tagSuffix"
            ir.nasim.AbstractC13042fc3.i(r3, r0)
            java.lang.String r0 = "message"
            ir.nasim.AbstractC13042fc3.i(r4, r0)
            boolean r0 = ir.nasim.AbstractC14836iZ6.n0(r3)
            r0 = r0 ^ 1
            if (r0 == 0) goto L14
            r0 = r3
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L2a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Dialog-"
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            if (r3 != 0) goto L2c
        L2a:
            java.lang.String r3 = "Dialog"
        L2c:
            ir.nasim.C19406qI3.c(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.UO1.c(java.lang.String, java.lang.String, java.lang.Throwable):void");
    }
}
