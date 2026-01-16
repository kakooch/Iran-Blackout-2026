package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;

/* renamed from: ir.nasim.uE0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21844uE0 {
    private final VP6 a;
    private final SettingsModule b;

    /* renamed from: ir.nasim.uE0$a */
    static final class a extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA = C21844uE0.this.a(0, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    public C21844uE0(VP6 vp6, SettingsModule settingsModule) {
        AbstractC13042fc3.i(vp6, "storyApi");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.a = vp6;
        this.b = settingsModule;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(int r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C21844uE0.a
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.uE0$a r0 = (ir.nasim.C21844uE0.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.uE0$a r0 = new ir.nasim.uE0$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r5 = r6.l()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.VP6 r6 = r4.a
            r0.c = r3
            java.lang.Object r5 = r6.c(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21844uE0.a(int, ir.nasim.rm1):java.lang.Object");
    }

    public final boolean b(C14733iO2 c14733iO2) {
        AbstractC13042fc3.i(c14733iO2, "groupInfo");
        return C8386Vt0.a.ba() && c14733iO2.p() == ExPeerType.CHANNEL && ((Number) c14733iO2.u().b()).intValue() >= this.b.O3();
    }

    public final boolean c(C14733iO2 c14733iO2) {
        C19482qQ7 c19482qQ7S;
        C23104wM2 c23104wM2;
        AbstractC13042fc3.i(c14733iO2, "groupInfo");
        if (C8386Vt0.da() && c14733iO2.p() == ExPeerType.GROUP) {
            if (c14733iO2.x() == AbstractC5969Lp4.f()) {
                return true;
            }
            if (FM2.a.j(c14733iO2).c() && (c19482qQ7S = c14733iO2.s()) != null && (c23104wM2 = (C23104wM2) c19482qQ7S.b()) != null && c23104wM2.j()) {
                return true;
            }
        }
        return false;
    }
}
