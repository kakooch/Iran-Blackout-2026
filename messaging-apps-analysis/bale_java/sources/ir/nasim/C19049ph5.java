package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import ir.nasim.C23345wl7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.ph5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19049ph5 extends AbstractC17457n0 {
    public static final a i = new a(null);
    public static final int j = 8;
    private boolean c;
    private long d;
    private String e;
    private List f;
    private EnumC9567aB g;
    private C16885m18 h;

    /* renamed from: ir.nasim.ph5$a */
    public static final class a {
        private a() {
        }

        public final C19049ph5 a(boolean z, long j, String str, List list, EnumC9567aB enumC9567aB, C16885m18 c16885m18) {
            AbstractC13042fc3.i(str, "question");
            AbstractC13042fc3.i(list, "answers");
            AbstractC13042fc3.i(enumC9567aB, "type");
            return new C19049ph5(new C8540Wk1(new C10219bH3(z, j, str, list, enumC9567aB, c16885m18)));
        }

        public final C19049ph5 b(boolean z, long j, String str, List list, EnumC9567aB enumC9567aB, ZA za) {
            AbstractC13042fc3.i(str, "question");
            AbstractC13042fc3.i(list, "answers");
            List<String> list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            for (String str2 : list2) {
                arrayList.add(new YA(list.indexOf(str2), str2));
            }
            return new C19049ph5(new C11909dl1(new XA(str, arrayList, z, enumC9567aB, za, j)));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C19049ph5(C8540Wk1 c8540Wk1) {
        super(c8540Wk1);
        AbstractC13042fc3.i(c8540Wk1, "contentLocalContainer");
        this.e = "";
        this.f = AbstractC10360bX0.m();
        AbstractC19230q0 abstractC19230q0C = c8540Wk1.c();
        AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalPoll");
        C10219bH3 c10219bH3 = (C10219bH3) abstractC19230q0C;
        this.c = c10219bH3.C();
        this.d = c10219bH3.u();
        this.e = c10219bH3.w();
        this.f = c10219bH3.s();
        this.g = c10219bH3.y();
        this.h = c10219bH3.z();
    }

    public static final C19049ph5 s(boolean z, long j2, String str, List list, EnumC9567aB enumC9567aB, ZA za) {
        return i.b(z, j2, str, list, enumC9567aB, za);
    }

    private final C16885m18 z(ZA za) {
        if (za == null) {
            return null;
        }
        long jS = za.s();
        List listQ = za.q();
        AbstractC13042fc3.h(listQ, "getChosenOptionIds(...)");
        List listR = za.r();
        AbstractC13042fc3.h(listR, "getOptionResults(...)");
        List<C12766fA> list = listR;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (C12766fA c12766fA : list) {
            arrayList.add(new C4011Dh5(c12766fA.q(), c12766fA.r()));
        }
        List listP1 = AbstractC15401jX0.p1(arrayList);
        boolean zY = za.y();
        List listU = za.u();
        AbstractC13042fc3.h(listU, "getRecentVoters(...)");
        return new C16885m18(jS, listQ, listP1, zY, za.w(), listU, za.u().size());
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i2, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.poll);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C19049ph5.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.PollContent");
        C19049ph5 c19049ph5 = (C19049ph5) obj;
        return this.c == c19049ph5.c && this.d == c19049ph5.d && AbstractC13042fc3.d(this.e, c19049ph5.e) && AbstractC13042fc3.d(this.f, c19049ph5.f) && this.g == c19049ph5.g && AbstractC13042fc3.d(this.h, c19049ph5.h);
    }

    public int hashCode() {
        int iHashCode = ((((((Boolean.hashCode(this.c) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        EnumC9567aB enumC9567aB = this.g;
        int iHashCode2 = (iHashCode + (enumC9567aB != null ? enumC9567aB.hashCode() : 0)) * 31;
        C16885m18 c16885m18 = this.h;
        return iHashCode2 + (c16885m18 != null ? c16885m18.hashCode() : 0);
    }

    @Override // ir.nasim.AbstractC17457n0
    public String j(Context context) {
        AbstractC13042fc3.i(context, "context");
        String string = this.g == EnumC9567aB.SINGLECHOICE ? context.getString(AbstractC12217eE5.poll_single_choice_label) : context.getString(AbstractC12217eE5.poll_multi_choice_label);
        AbstractC13042fc3.f(string);
        return context.getString(AbstractC12217eE5.poll) + Separators.SP + this.e + Separators.SP + string;
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return C23345wl7.a.c(C23345wl7.g, "", null, 2, null);
    }

    public final List r(List list) {
        AbstractC13042fc3.i(list, "answers");
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        int i2 = 0;
        for (Object obj : list2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            arrayList.add(new YA(i2, (String) obj));
            i2 = i3;
        }
        return arrayList;
    }

    public final List t() {
        return this.f;
    }

    public final long u() {
        return this.d;
    }

    public final String v() {
        return this.e;
    }

    public final EnumC9567aB w() {
        return this.g;
    }

    public final C16885m18 x() {
        return this.h;
    }

    public final boolean y() {
        return this.c;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C19049ph5(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "contentRemoteContainer");
        this.e = "";
        this.f = AbstractC10360bX0.m();
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiPollMessage");
        XA xa = (XA) abstractC24063xzC;
        this.c = xa.D();
        this.d = xa.w();
        this.e = xa.y();
        List listU = xa.u();
        AbstractC13042fc3.h(listU, "getOptions(...)");
        List list = listU;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((YA) it.next()).q());
        }
        this.f = arrayList;
        this.g = xa.C();
        this.h = z(xa.z());
    }
}
