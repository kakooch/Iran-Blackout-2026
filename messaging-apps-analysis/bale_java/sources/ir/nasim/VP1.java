package ir.nasim;

import ir.nasim.C11669dP1;
import ir.nasim.C24904zP1;
import ir.nasim.PI7;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.dialoglist.data.model.DialogDTO;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class VP1 implements C24904zP1.a {
    private final long a;
    private final ExPeerType b;
    private C11669dP1.c c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PI7.a.values().length];
            try {
                iArr[PI7.a.EMPTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PI7.a.ONLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PI7.a.OFFLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public VP1(long j, ExPeerType exPeerType, C11669dP1.c cVar) {
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(cVar, "holder");
        this.a = j;
        this.b = exPeerType;
        this.c = cVar;
    }

    private final YI7 a(PI7.a aVar) {
        int i = aVar == null ? -1 : a.a[aVar.ordinal()];
        if (i == -1 || i == 1) {
            return null;
        }
        if (i == 2) {
            return YI7.a;
        }
        if (i == 3) {
            return YI7.b;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ir.nasim.C24904zP1.a
    public void b() {
        this.c = null;
    }

    @Override // ir.nasim.C24904zP1.a
    public void c(String str) {
        C11669dP1.c cVar = this.c;
        if (cVar != null) {
            cVar.U0(str);
        }
    }

    @Override // ir.nasim.C24904zP1.a
    public long d() {
        return this.a;
    }

    @Override // ir.nasim.C24904zP1.a
    public void e(EnumC18228oI7 enumC18228oI7) {
        C11669dP1.c cVar = this.c;
        if (cVar != null) {
            cVar.S0(enumC18228oI7);
        }
    }

    @Override // ir.nasim.C24904zP1.a
    public void f(SP1 sp1) throws IOException {
        AbstractC13042fc3.i(sp1, "update");
        C11669dP1.c cVar = this.c;
        if (cVar != null) {
            cVar.j1(sp1);
        }
    }

    @Override // ir.nasim.C24904zP1.a
    public void g(C24904zP1.b bVar) throws IOException {
        AbstractC13042fc3.i(bVar, "initialState");
        C11669dP1.c cVar = this.c;
        if (cVar != null) {
            cVar.f1(bVar.d(), bVar.c());
        }
        C11669dP1.c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.S0(bVar.b());
        }
        C11669dP1.c cVar3 = this.c;
        if (cVar3 != null) {
            cVar3.j1(bVar.a());
        }
    }

    @Override // ir.nasim.C24904zP1.a
    public void h(DialogDTO dialogDTO, Avatar avatar, String str) {
        AbstractC13042fc3.i(dialogDTO, "dialog");
        AbstractC13042fc3.i(str, "userName");
        C11669dP1.c cVar = this.c;
        if (cVar != null) {
            cVar.T0(dialogDTO.isPersonalSpace(), avatar, str, GM1.a(dialogDTO), dialogDTO.isDeletedAccount());
        }
    }

    @Override // ir.nasim.C24904zP1.a
    public void i(boolean z, boolean z2) {
        C11669dP1.c cVar;
        C11669dP1.c cVar2 = this.c;
        if (cVar2 != null) {
            Long lQ1 = cVar2.q1();
            long jD = d();
            if (lQ1 == null || lQ1.longValue() != jD || (cVar = this.c) == null) {
                return;
            }
            cVar.f1(z, z2);
        }
    }

    @Override // ir.nasim.C24904zP1.a
    public void j(String str) throws IOException {
        C11669dP1.c cVar;
        C11669dP1.c cVar2 = this.c;
        if (cVar2 != null) {
            Long lQ1 = cVar2.q1();
            long jD = d();
            if (lQ1 == null || lQ1.longValue() != jD || (cVar = this.c) == null) {
                return;
            }
            cVar.V0(str);
        }
    }

    @Override // ir.nasim.C24904zP1.a
    public void k(PI7 pi7) {
        C11669dP1.c cVar;
        C11669dP1.c cVar2 = this.c;
        if (cVar2 != null) {
            Long lQ1 = cVar2.q1();
            long jD = d();
            if (lQ1 == null || lQ1.longValue() != jD || (cVar = this.c) == null) {
                return;
            }
            cVar.e1(a(pi7 != null ? pi7.u() : null));
        }
    }

    @Override // ir.nasim.C24904zP1.a
    public ExPeerType z() {
        return this.b;
    }
}
