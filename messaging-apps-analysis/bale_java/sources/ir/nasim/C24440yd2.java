package ir.nasim;

import android.os.Bundle;
import com.google.android.exoplayer2.C2018a0;
import ir.nasim.InterfaceC6170Mm;

/* renamed from: ir.nasim.yd2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24440yd2 implements InterfaceC6170Mm {
    public static final a g = new a(null);
    public static final int h = 8;
    private final InterfaceC19567qa2 a;
    private Integer b;
    private C2018a0 c;
    private final C16777lq7 d;
    private final KI5 e;
    private boolean f;

    /* renamed from: ir.nasim.yd2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C24440yd2(InterfaceC19567qa2 interfaceC19567qa2) {
        AbstractC13042fc3.i(interfaceC19567qa2, "serajAnalytics");
        this.a = interfaceC19567qa2;
        this.d = new C16777lq7();
        this.e = new KI5();
    }

    private final void b(EnumC8893Xt7 enumC8893Xt7, long j, long j2, String str, String str2) {
        if (j == 0 || enumC8893Xt7 == null || this.d.c() == 0 || this.d.a() == 0) {
            return;
        }
        this.a.a("time_to_first_frame_event", AbstractC20051rO3.n(AbstractC4616Fw7.a("origin", Integer.valueOf(enumC8893Xt7.p())), AbstractC4616Fw7.a("duration", Long.valueOf(j)), AbstractC4616Fw7.a("file_size", Long.valueOf(j2)), AbstractC4616Fw7.a("file_hash", str), AbstractC4616Fw7.a("file_mime_type", str2)));
    }

    private final void c() {
        C2018a0.h hVar;
        C2018a0 c2018a0 = this.c;
        Object obj = (c2018a0 == null || (hVar = c2018a0.b) == null) ? null : hVar.h;
        Bundle bundle = obj instanceof Bundle ? (Bundle) obj : null;
        Integer numValueOf = bundle != null ? Integer.valueOf(bundle.getInt("origin")) : null;
        if (this.e.a() <= 0 || numValueOf == null) {
            return;
        }
        this.a.a("rebuffering_time_event", AbstractC20051rO3.n(AbstractC4616Fw7.a("origin", numValueOf), AbstractC4616Fw7.a("duration", Long.valueOf(this.e.a())), AbstractC4616Fw7.a("value", Integer.valueOf((numValueOf.intValue() == EnumC8893Xt7.e.p() ? Float.valueOf(C24480yh2.a.c().D0()) : 0).intValue()))));
        this.e.d();
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void C(InterfaceC6170Mm.a aVar, Object obj, long j) {
        C2018a0.h hVar;
        C2018a0.h hVar2;
        C2018a0.h hVar3;
        C2018a0.h hVar4;
        AbstractC13042fc3.i(aVar, "eventTime");
        AbstractC13042fc3.i(obj, "output");
        super.C(aVar, obj, j);
        this.d.d(j);
        C2018a0 c2018a0 = this.c;
        String str = (c2018a0 == null || (hVar4 = c2018a0.b) == null) ? null : hVar4.b;
        Object obj2 = (c2018a0 == null || (hVar3 = c2018a0.b) == null) ? null : hVar3.h;
        Bundle bundle = obj2 instanceof Bundle ? (Bundle) obj2 : null;
        String string = bundle != null ? bundle.getString("file_hash") : null;
        C2018a0 c2018a02 = this.c;
        Object obj3 = (c2018a02 == null || (hVar2 = c2018a02.b) == null) ? null : hVar2.h;
        Bundle bundle2 = obj3 instanceof Bundle ? (Bundle) obj3 : null;
        Long lValueOf = bundle2 != null ? Long.valueOf(bundle2.getLong("file_size")) : null;
        C2018a0 c2018a03 = this.c;
        Object obj4 = (c2018a03 == null || (hVar = c2018a03.b) == null) ? null : hVar.h;
        Bundle bundle3 = obj4 instanceof Bundle ? (Bundle) obj4 : null;
        Integer numValueOf = bundle3 != null ? Integer.valueOf(bundle3.getInt("origin")) : null;
        if (numValueOf != null) {
            b(EnumC8893Xt7.b.a(numValueOf.intValue()), this.d.b(), lValueOf != null ? lValueOf.longValue() : 0L, string == null ? "" : string, str == null ? "" : str);
            this.d.f();
        }
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void R0(InterfaceC6170Mm.a aVar, C2018a0 c2018a0, int i) {
        AbstractC13042fc3.i(aVar, "eventTime");
        super.R0(aVar, c2018a0, i);
        this.d.f();
        if (c2018a0 != null) {
            this.d.e(aVar.a);
        }
        this.c = c2018a0;
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void b0(InterfaceC6170Mm.a aVar) {
        AbstractC13042fc3.i(aVar, "eventTime");
        super.b0(aVar);
        this.c = null;
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void h1(InterfaceC6170Mm.a aVar, boolean z, int i) {
        AbstractC13042fc3.i(aVar, "eventTime");
        this.b = Integer.valueOf(i);
        if (i == 2) {
            this.e.c(aVar);
            this.f = true;
        } else if (this.f) {
            this.e.b(aVar);
            this.f = false;
        }
        if (i == 4) {
            c();
        }
    }
}
