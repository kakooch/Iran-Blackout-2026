package ir.nasim;

import ir.nasim.AbstractC21649tt7;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: ir.nasim.yP, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24308yP extends AbstractC20521s90 implements InterfaceC5306It7 {
    private final String a;
    private final Integer b;
    private final boolean c;
    private final boolean d;
    private final AbstractC21649tt7.g e;
    private final String f;
    private final boolean g;

    public /* synthetic */ C24308yP(String str, Integer num, boolean z, boolean z2, AbstractC21649tt7.g gVar, String str2, boolean z3, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? true : z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? null : gVar, (i & 32) == 0 ? str2 : null, (i & 64) != 0 ? false : z3);
    }

    public static /* synthetic */ C24308yP e(C24308yP c24308yP, String str, Integer num, boolean z, boolean z2, AbstractC21649tt7.g gVar, String str2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c24308yP.a;
        }
        if ((i & 2) != 0) {
            num = c24308yP.b;
        }
        Integer num2 = num;
        if ((i & 4) != 0) {
            z = c24308yP.c;
        }
        boolean z4 = z;
        if ((i & 8) != 0) {
            z2 = c24308yP.d;
        }
        boolean z5 = z2;
        if ((i & 16) != 0) {
            gVar = c24308yP.e;
        }
        AbstractC21649tt7.g gVar2 = gVar;
        if ((i & 32) != 0) {
            str2 = c24308yP.f;
        }
        String str3 = str2;
        if ((i & 64) != 0) {
            z3 = c24308yP.g;
        }
        return c24308yP.d(str, num2, z4, z5, gVar2, str3, z3);
    }

    @Override // ir.nasim.AbstractC20521s90
    public Integer a() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC20521s90
    public boolean b() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC20521s90
    public boolean c() {
        return this.d;
    }

    public final C24308yP d(String str, Integer num, boolean z, boolean z2, AbstractC21649tt7.g gVar, String str2, boolean z3) {
        return new C24308yP(str, num, z, z2, gVar, str2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24308yP)) {
            return false;
        }
        C24308yP c24308yP = (C24308yP) obj;
        return AbstractC13042fc3.d(this.a, c24308yP.a) && AbstractC13042fc3.d(this.b, c24308yP.b) && this.c == c24308yP.c && this.d == c24308yP.d && this.e == c24308yP.e && AbstractC13042fc3.d(this.f, c24308yP.f) && this.g == c24308yP.g;
    }

    public final Set f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!b()) {
            linkedHashSet.add(ME3.TF_NO_DTX);
        }
        if (this.g) {
            linkedHashSet.add(ME3.TF_PRECONNECT_BUFFER);
        }
        return linkedHashSet;
    }

    public AbstractC21649tt7.g g() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC5306It7
    public String getName() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31;
        AbstractC21649tt7.g gVar = this.e;
        int iHashCode3 = (iHashCode2 + (gVar == null ? 0 : gVar.hashCode())) * 31;
        String str2 = this.f;
        return ((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.g);
    }

    @Override // ir.nasim.InterfaceC5306It7
    public String i() {
        return this.f;
    }

    public String toString() {
        return "AudioTrackPublishOptions(name=" + this.a + ", audioBitrate=" + this.b + ", dtx=" + this.c + ", red=" + this.d + ", source=" + this.e + ", stream=" + this.f + ", preconnect=" + this.g + ')';
    }

    public C24308yP(String str, Integer num, boolean z, boolean z2, AbstractC21649tt7.g gVar, String str2, boolean z3) {
        this.a = str;
        this.b = num;
        this.c = z;
        this.d = z2;
        this.e = gVar;
        this.f = str2;
        this.g = z3;
    }

    public /* synthetic */ C24308yP(String str, AbstractC20521s90 abstractC20521s90, AbstractC21649tt7.g gVar, String str2, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : str, abstractC20521s90, (i & 4) != 0 ? null : gVar, (i & 8) != 0 ? null : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C24308yP(String str, AbstractC20521s90 abstractC20521s90, AbstractC21649tt7.g gVar, String str2) {
        this(str, abstractC20521s90.a(), abstractC20521s90.b(), abstractC20521s90.c(), gVar, str2, false, 64, null);
        AbstractC13042fc3.i(abstractC20521s90, "base");
    }
}
