package ir.nasim;

import android.graphics.Shader;
import java.util.List;

/* renamed from: ir.nasim.Mz3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6291Mz3 extends AbstractC4147Dw6 {
    private final List e;
    private final List f;
    private final long g;
    private final long h;
    private final int i;

    public /* synthetic */ C6291Mz3(List list, List list2, long j, long j2, int i, ED1 ed1) {
        this(list, list2, j, j2, i);
    }

    @Override // ir.nasim.AbstractC4147Dw6
    public Shader b(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (this.g >> 32)) == Float.POSITIVE_INFINITY ? j >> 32 : this.g >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (this.g & 4294967295L)) == Float.POSITIVE_INFINITY ? j & 4294967295L : this.g & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (this.h >> 32)) == Float.POSITIVE_INFINITY ? j >> 32 : this.h >> 32));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (this.h & 4294967295L)) == Float.POSITIVE_INFINITY ? j & 4294967295L : this.h & 4294967295L));
        return AbstractC4615Fw6.a(ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat4) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat3) << 32)), this.e, this.f, this.i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6291Mz3)) {
            return false;
        }
        C6291Mz3 c6291Mz3 = (C6291Mz3) obj;
        return AbstractC13042fc3.d(this.e, c6291Mz3.e) && AbstractC13042fc3.d(this.f, c6291Mz3.f) && ZG4.j(this.g, c6291Mz3.g) && ZG4.j(this.h, c6291Mz3.h) && AbstractC4553Fp7.f(this.i, c6291Mz3.i);
    }

    public int hashCode() {
        int iHashCode = this.e.hashCode() * 31;
        List list = this.f;
        return ((((((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + ZG4.o(this.g)) * 31) + ZG4.o(this.h)) * 31) + AbstractC4553Fp7.g(this.i);
    }

    public String toString() {
        String str;
        String str2 = "";
        if (((((this.g & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) == 0) {
            str = "start=" + ((Object) ZG4.s(this.g)) + ", ";
        } else {
            str = "";
        }
        if ((((9187343241974906880L ^ (this.h & 9187343241974906880L)) - 4294967297L) & (-9223372034707292160L)) == 0) {
            str2 = "end=" + ((Object) ZG4.s(this.h)) + ", ";
        }
        return "LinearGradient(colors=" + this.e + ", stops=" + this.f + ", " + str + str2 + "tileMode=" + ((Object) AbstractC4553Fp7.h(this.i)) + ')';
    }

    private C6291Mz3(List list, List list2, long j, long j2, int i) {
        this.e = list;
        this.f = list2;
        this.g = j;
        this.h = j2;
        this.i = i;
    }
}
