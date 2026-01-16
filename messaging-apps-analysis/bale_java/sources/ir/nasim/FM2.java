package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public abstract class FM2 {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public static /* synthetic */ boolean d(a aVar, C14733iO2 c14733iO2, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return aVar.c(c14733iO2, z);
        }

        private final EM2 l(C14733iO2 c14733iO2, EnumC3698By7 enumC3698By7) {
            return j(c14733iO2).s(enumC3698By7) ? EM2.a : !e(c14733iO2).s(enumC3698By7) ? EM2.c : EM2.b;
        }

        public final boolean a(C14733iO2 c14733iO2) {
            if (c14733iO2 == null) {
                return false;
            }
            C24119y45 c24119y45J = j(c14733iO2);
            return c24119y45J.b() && c24119y45J.i();
        }

        public final boolean b(C14733iO2 c14733iO2) {
            if (c14733iO2 == null) {
                return false;
            }
            return j(c14733iO2).f();
        }

        public final boolean c(C14733iO2 c14733iO2, boolean z) {
            if (c14733iO2 == null) {
                return false;
            }
            return z ? j(c14733iO2).q() : ((Boolean) c14733iO2.f().b()).booleanValue() && j(c14733iO2).q();
        }

        public final C24119y45 e(C14733iO2 c14733iO2) {
            if (c14733iO2 == null) {
                return C24119y45.q.i();
            }
            if (c14733iO2.m().b() == null) {
                return c14733iO2.E().b() == W06.PUBLIC ? C24119y45.q.h() : C24119y45.q.f();
            }
            Object objB = c14733iO2.m().b();
            AbstractC13042fc3.f(objB);
            return (C24119y45) objB;
        }

        public final EM2 f(C14733iO2 c14733iO2) {
            return c14733iO2 == null ? EM2.c : l(c14733iO2, EnumC3698By7.l);
        }

        public final EM2 g(C14733iO2 c14733iO2) {
            return c14733iO2 == null ? EM2.c : l(c14733iO2, EnumC3698By7.l);
        }

        public final C24119y45 h(W06 w06, ZN2 zn2) {
            AbstractC13042fc3.i(w06, "restriction");
            AbstractC13042fc3.i(zn2, "groupType");
            return zn2 == ZN2.GROUP ? w06 == W06.PUBLIC ? C24119y45.q.g() : C24119y45.q.e() : C24119y45.q.a();
        }

        public final EM2 i(C14733iO2 c14733iO2) {
            return c14733iO2 == null ? EM2.c : l(c14733iO2, EnumC3698By7.k);
        }

        public final C24119y45 j(C14733iO2 c14733iO2) {
            C23104wM2 c23104wM2;
            if (c14733iO2 == null) {
                return C24119y45.q.i();
            }
            if (c14733iO2.q() != ZN2.GROUP) {
                if (c14733iO2.x() == AbstractC5969Lp4.f()) {
                    return C24119y45.q.c();
                }
                C24119y45 c24119y45 = (C24119y45) c14733iO2.z().b();
                if (c24119y45 != null) {
                    return c24119y45;
                }
                C19482qQ7 c19482qQ7S = c14733iO2.s();
                c23104wM2 = c19482qQ7S != null ? (C23104wM2) c19482qQ7S.b() : null;
                return (c23104wM2 == null || !c23104wM2.j()) ? C24119y45.q.b() : C24119y45.q.a();
            }
            if (c14733iO2.x() == AbstractC5969Lp4.f()) {
                return C24119y45.q.d();
            }
            C24119y45 c24119y452 = (C24119y45) c14733iO2.z().b();
            if (c24119y452 != null) {
                return c24119y452;
            }
            W06 w06 = (W06) c14733iO2.E().b();
            C19482qQ7 c19482qQ7S2 = c14733iO2.s();
            c23104wM2 = c19482qQ7S2 != null ? (C23104wM2) c19482qQ7S2.b() : null;
            return (c23104wM2 == null || !c23104wM2.j()) ? e(c14733iO2) : w06 == W06.PUBLIC ? C24119y45.q.g() : C24119y45.q.e();
        }

        public final String k(C24119y45 c24119y45, W06 w06, C24119y45 c24119y452, boolean z) {
            AbstractC13042fc3.i(c24119y45, "permissions");
            AbstractC13042fc3.i(w06, "restriction");
            AbstractC13042fc3.i(c24119y452, "defaultPermissions");
            ArrayList arrayList = new ArrayList();
            if ((c24119y45.q() ^ c24119y452.q()) && !c24119y45.q()) {
                arrayList.add(0, C5721Ko.a.d().getString(z ? AbstractC12217eE5.group_send_message : AbstractC12217eE5.channel_send_message));
            }
            if ((c24119y45.p() ^ c24119y452.p()) && !c24119y45.p()) {
                arrayList.add(0, C5721Ko.a.d().getString(z ? AbstractC12217eE5.group_send_media : AbstractC12217eE5.channel_send_media));
            }
            if ((c24119y45.o() ^ c24119y452.o()) && !c24119y45.o()) {
                arrayList.add(0, C5721Ko.a.d().getString(z ? AbstractC12217eE5.group_send_gift_sticker : AbstractC12217eE5.channel_send_gift_sticker));
            }
            if (w06 == W06.PRIVATE) {
                if ((c24119y45.k() ^ c24119y452.k()) && !c24119y45.k()) {
                    arrayList.add(0, C5721Ko.a.d().getString(z ? AbstractC12217eE5.group_pin_message : AbstractC12217eE5.channel_pin_message));
                }
                if ((c24119y45.f() ^ c24119y452.f()) && !c24119y45.f()) {
                    arrayList.add(0, C5721Ko.a.d().getString(z ? AbstractC12217eE5.group_change_info : AbstractC12217eE5.channel_change_info));
                }
            }
            if ((c24119y45.i() ^ c24119y452.i()) && !c24119y45.i()) {
                arrayList.add(0, C5721Ko.a.d().getString(z ? AbstractC12217eE5.group_add_member : AbstractC12217eE5.channel_add_member));
            }
            if (!(!arrayList.isEmpty())) {
                return "";
            }
            return C5721Ko.a.d().getString(AbstractC12217eE5.permission_exept) + Separators.SP + AbstractC15401jX0.A0(arrayList, "، ", null, null, 0, null, null, 62, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final boolean a(C14733iO2 c14733iO2) {
        return a.a(c14733iO2);
    }

    public static final boolean b(C14733iO2 c14733iO2) {
        return a.b(c14733iO2);
    }

    public static final C24119y45 c(C14733iO2 c14733iO2) {
        return a.e(c14733iO2);
    }

    public static final C24119y45 d(W06 w06, ZN2 zn2) {
        return a.h(w06, zn2);
    }

    public static final String e(C24119y45 c24119y45, W06 w06, C24119y45 c24119y452, boolean z) {
        return a.k(c24119y45, w06, c24119y452, z);
    }
}
