package androidx.compose.runtime.snapshots;

import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13424gC3;
import ir.nasim.AbstractC6703Op6;
import ir.nasim.AbstractC9131Yp6;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC17915nm3;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.RG6;
import ir.nasim.SG6;
import ir.nasim.V06;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class i implements Iterable, InterfaceC17915nm3 {
    public static final a e = new a(null);
    private static final i f = new i(0, 0, 0, null);
    private final long a;
    private final long b;
    private final long c;
    private final long[] d;

    public static final class a {
        private a() {
        }

        public final i a() {
            return i.f;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends V06 implements InterfaceC14603iB2 {
        Object a;
        int b;
        int c;
        int d;
        private /* synthetic */ Object e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = i.this.new b(interfaceC20295rm1);
            bVar.e = obj;
            return bVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(AbstractC6703Op6 abstractC6703Op6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(abstractC6703Op6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c3  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0073 -> B:19:0x0076). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0093 -> B:30:0x00b0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00ad -> B:30:0x00b0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d0 -> B:43:0x00f1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00ef -> B:42:0x00f0). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 248
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.i.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private i(long j, long j2, long j3, long[] jArr) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = jArr;
    }

    public final long A(long j) {
        long[] jArr = this.d;
        if (jArr != null) {
            return jArr[0];
        }
        if (this.b != 0) {
            return this.c + Long.numberOfTrailingZeros(r0);
        }
        return this.a != 0 ? this.c + 64 + Long.numberOfTrailingZeros(r0) : j;
    }

    public final i B(i iVar) {
        i iVarC;
        i iVar2 = f;
        if (iVar == iVar2) {
            return this;
        }
        if (this == iVar2) {
            return iVar;
        }
        long j = iVar.c;
        long j2 = this.c;
        if (j == j2) {
            long[] jArr = iVar.d;
            long[] jArr2 = this.d;
            if (jArr == jArr2) {
                return new i(iVar.a | this.a, iVar.b | this.b, j2, jArr2);
            }
        }
        int i = 0;
        if (this.d == null) {
            long[] jArr3 = this.d;
            if (jArr3 != null) {
                for (long j3 : jArr3) {
                    iVar = iVar.C(j3);
                }
            }
            if (this.b != 0) {
                for (int i2 = 0; i2 < 64; i2++) {
                    if ((this.b & (1 << i2)) != 0) {
                        iVar = iVar.C(this.c + i2);
                    }
                }
            }
            if (this.a != 0) {
                while (i < 64) {
                    if ((this.a & (1 << i)) != 0) {
                        iVar = iVar.C(this.c + i + 64);
                    }
                    i++;
                }
            }
            return iVar;
        }
        long[] jArr4 = iVar.d;
        if (jArr4 != null) {
            iVarC = this;
            for (long j4 : jArr4) {
                iVarC = iVarC.C(j4);
            }
        } else {
            iVarC = this;
        }
        if (iVar.b != 0) {
            for (int i3 = 0; i3 < 64; i3++) {
                if ((iVar.b & (1 << i3)) != 0) {
                    iVarC = iVarC.C(iVar.c + i3);
                }
            }
        }
        if (iVar.a != 0) {
            while (i < 64) {
                if ((iVar.a & (1 << i)) != 0) {
                    iVarC = iVarC.C(iVar.c + i + 64);
                }
                i++;
            }
        }
        return iVarC;
    }

    public final i C(long j) {
        long j2;
        long j3;
        long[] jArrB;
        long j4 = this.c;
        long j5 = j - j4;
        long j6 = 1;
        if (j5 >= 0 && j5 < 64) {
            long j7 = 1 << ((int) j5);
            long j8 = this.b;
            if ((j8 & j7) == 0) {
                return new i(this.a, j8 | j7, j4, this.d);
            }
        } else if (j5 >= 64 && j5 < 128) {
            long j9 = 1 << (((int) j5) - 64);
            long j10 = this.a;
            if ((j10 & j9) == 0) {
                return new i(j10 | j9, this.b, j4, this.d);
            }
        } else if (j5 < 128) {
            long[] jArr = this.d;
            if (jArr == null) {
                return new i(this.a, this.b, j4, new long[]{j});
            }
            int iA = SG6.a(jArr, j);
            if (iA < 0) {
                return new i(this.a, this.b, this.c, SG6.d(jArr, -(iA + 1), j));
            }
        } else if (!x(j)) {
            long j11 = this.a;
            long j12 = this.b;
            long j13 = this.c;
            long j14 = 64;
            long j15 = ((j + 1) / j14) * j14;
            if (j15 < 0) {
                j15 = 9223372036854775680L;
            }
            RG6 rg6 = null;
            long j16 = j11;
            while (true) {
                if (j13 >= j15) {
                    j2 = j12;
                    j3 = j13;
                    break;
                }
                if (j12 != 0) {
                    if (rg6 == null) {
                        rg6 = new RG6(this.d);
                    }
                    int i = 0;
                    while (i < 64) {
                        if ((j12 & (j6 << i)) != 0) {
                            rg6.a(i + j13);
                        }
                        i++;
                        j6 = 1;
                    }
                }
                if (j16 == 0) {
                    j2 = 0;
                    j3 = j15;
                    break;
                }
                j13 += j14;
                j12 = j16;
                j6 = 1;
                j16 = 0;
            }
            if (rg6 == null || (jArrB = rg6.b()) == null) {
                jArrB = this.d;
            }
            return new i(j16, j2, j3, jArrB).C(j);
        }
        return this;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return AbstractC9131Yp6.b(new b(null)).iterator();
    }

    public final i t(i iVar) {
        i iVarV;
        i iVar2 = f;
        if (iVar == iVar2) {
            return this;
        }
        if (this == iVar2) {
            return iVar2;
        }
        long j = iVar.c;
        long j2 = this.c;
        if (j == j2) {
            long[] jArr = iVar.d;
            long[] jArr2 = this.d;
            if (jArr == jArr2) {
                return new i((~iVar.a) & this.a, (~iVar.b) & this.b, j2, jArr2);
            }
        }
        long[] jArr3 = iVar.d;
        if (jArr3 != null) {
            iVarV = this;
            for (long j3 : jArr3) {
                iVarV = iVarV.v(j3);
            }
        } else {
            iVarV = this;
        }
        if (iVar.b != 0) {
            for (int i = 0; i < 64; i++) {
                if ((iVar.b & (1 << i)) != 0) {
                    iVarV = iVarV.v(iVar.c + i);
                }
            }
        }
        if (iVar.a != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if ((iVar.a & (1 << i2)) != 0) {
                    iVarV = iVarV.v(iVar.c + i2 + 64);
                }
            }
        }
        return iVarV;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(this, 10));
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).longValue()));
        }
        sb.append(AbstractC13424gC3.d(arrayList, null, null, null, 0, null, null, 63, null));
        sb.append(']');
        return sb.toString();
    }

    public final i v(long j) {
        long[] jArr;
        int iA;
        long j2 = this.c;
        long j3 = j - j2;
        if (j3 >= 0 && j3 < 64) {
            long j4 = 1 << ((int) j3);
            long j5 = this.b;
            if ((j5 & j4) != 0) {
                return new i(this.a, (~j4) & j5, j2, this.d);
            }
        } else if (j3 >= 64 && j3 < 128) {
            long j6 = 1 << (((int) j3) - 64);
            long j7 = this.a;
            if ((j7 & j6) != 0) {
                return new i(j7 & (~j6), this.b, j2, this.d);
            }
        } else if (j3 < 0 && (jArr = this.d) != null && (iA = SG6.a(jArr, j)) >= 0) {
            return new i(this.a, this.b, this.c, SG6.e(jArr, iA));
        }
        return this;
    }

    public final boolean x(long j) {
        long[] jArr;
        long j2 = j - this.c;
        if (j2 < 0 || j2 >= 64) {
            if (j2 < 64 || j2 >= 128) {
                if (j2 <= 0 && (jArr = this.d) != null && SG6.a(jArr, j) >= 0) {
                    return true;
                }
            } else if (((1 << (((int) j2) - 64)) & this.a) != 0) {
                return true;
            }
        } else if (((1 << ((int) j2)) & this.b) != 0) {
            return true;
        }
        return false;
    }
}
