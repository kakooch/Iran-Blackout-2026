package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.p35, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C18675p35 {
    private final List a;
    private final int b;
    private int c;
    private final List d;
    private final C16734lm4 e;
    private final InterfaceC9173Yu3 f;

    /* renamed from: ir.nasim.p35$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        public final C7386Rm4 a() {
            C7386Rm4 c7386Rm4J = AbstractC5138Ib1.J(C18675p35.this.b().size());
            C18675p35 c18675p35 = C18675p35.this;
            int size = c18675p35.b().size();
            for (int i = 0; i < size; i++) {
                C23961xo3 c23961xo3 = (C23961xo3) c18675p35.b().get(i);
                C6405Nl4.a(c7386Rm4J, AbstractC5138Ib1.B(c23961xo3), c23961xo3);
            }
            return c7386Rm4J;
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            return C6405Nl4.b(a());
        }
    }

    public C18675p35(List list, int i) {
        this.a = list;
        this.b = i;
        if (!(i >= 0)) {
            AbstractC5214Ij5.a("Invalid start index");
        }
        this.d = new ArrayList();
        C16734lm4 c16734lm4 = new C16734lm4(0, 1, null);
        int size = list.size();
        int iC = 0;
        for (int i2 = 0; i2 < size; i2++) {
            C23961xo3 c23961xo3 = (C23961xo3) this.a.get(i2);
            c16734lm4.r(c23961xo3.b(), new C18850pM2(i2, iC, c23961xo3.c()));
            iC += c23961xo3.c();
        }
        this.e = c16734lm4;
        this.f = AbstractC13269fw3.a(new a());
    }

    public final int a() {
        return this.c;
    }

    public final List b() {
        return this.a;
    }

    public final C7386Rm4 c() {
        return ((C6405Nl4) this.f.getValue()).o();
    }

    public final C23961xo3 d(int i, Object obj) {
        return (C23961xo3) C6405Nl4.k(c(), obj != null ? new C8065Uj3(Integer.valueOf(i), obj) : Integer.valueOf(i));
    }

    public final int e() {
        return this.b;
    }

    public final List f() {
        return this.d;
    }

    public final int g(C23961xo3 c23961xo3) {
        C18850pM2 c18850pM2 = (C18850pM2) this.e.b(c23961xo3.b());
        if (c18850pM2 != null) {
            return c18850pM2.b();
        }
        return -1;
    }

    public final boolean h(C23961xo3 c23961xo3) {
        return this.d.add(c23961xo3);
    }

    public final void i(C23961xo3 c23961xo3, int i) {
        this.e.r(c23961xo3.b(), new C18850pM2(-1, i, 0));
    }

    public final void j(int i, int i2, int i3) {
        char c = 7;
        long j = -9187201950435737472L;
        if (i > i2) {
            C16734lm4 c16734lm4 = this.e;
            Object[] objArr = c16734lm4.c;
            long[] jArr = c16734lm4.a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i4 = 0;
            while (true) {
                long j2 = jArr[i4];
                if ((((~j2) << 7) & j2 & j) != j) {
                    int i5 = 8 - ((~(i4 - length)) >>> 31);
                    for (int i6 = 0; i6 < i5; i6++) {
                        if ((j2 & 255) < 128) {
                            C18850pM2 c18850pM2 = (C18850pM2) objArr[(i4 << 3) + i6];
                            int iB = c18850pM2.b();
                            if (i <= iB && iB < i + i3) {
                                c18850pM2.e((iB - i) + i2);
                            } else if (i2 <= iB && iB < i) {
                                c18850pM2.e(iB + i3);
                            }
                        }
                        j2 >>= 8;
                    }
                    if (i5 != 8) {
                        return;
                    }
                }
                if (i4 == length) {
                    return;
                }
                i4++;
                j = -9187201950435737472L;
            }
        } else {
            if (i2 <= i) {
                return;
            }
            C16734lm4 c16734lm42 = this.e;
            Object[] objArr2 = c16734lm42.c;
            long[] jArr2 = c16734lm42.a;
            int length2 = jArr2.length - 2;
            if (length2 < 0) {
                return;
            }
            int i7 = 0;
            while (true) {
                long j3 = jArr2[i7];
                if ((((~j3) << c) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i7 - length2)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((j3 & 255) < 128) {
                            C18850pM2 c18850pM22 = (C18850pM2) objArr2[(i7 << 3) + i9];
                            int iB2 = c18850pM22.b();
                            if (i <= iB2 && iB2 < i + i3) {
                                c18850pM22.e((iB2 - i) + i2);
                            } else if (i + 1 <= iB2 && iB2 < i2) {
                                c18850pM22.e(iB2 - i3);
                            }
                        }
                        j3 >>= 8;
                    }
                    if (i8 != 8) {
                        return;
                    }
                }
                if (i7 == length2) {
                    return;
                }
                i7++;
                c = 7;
            }
        }
    }

    public final void k(int i, int i2) {
        char c = 7;
        long j = -9187201950435737472L;
        if (i > i2) {
            C16734lm4 c16734lm4 = this.e;
            Object[] objArr = c16734lm4.c;
            long[] jArr = c16734lm4.a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                long j2 = jArr[i3];
                if ((((~j2) << 7) & j2 & j) != j) {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((j2 & 255) < 128) {
                            C18850pM2 c18850pM2 = (C18850pM2) objArr[(i3 << 3) + i5];
                            int iC = c18850pM2.c();
                            if (iC == i) {
                                c18850pM2.f(i2);
                            } else if (i2 <= iC && iC < i) {
                                c18850pM2.f(iC + 1);
                            }
                        }
                        j2 >>= 8;
                    }
                    if (i4 != 8) {
                        return;
                    }
                }
                if (i3 == length) {
                    return;
                }
                i3++;
                j = -9187201950435737472L;
            }
        } else {
            if (i2 <= i) {
                return;
            }
            C16734lm4 c16734lm42 = this.e;
            Object[] objArr2 = c16734lm42.c;
            long[] jArr2 = c16734lm42.a;
            int length2 = jArr2.length - 2;
            if (length2 < 0) {
                return;
            }
            int i6 = 0;
            while (true) {
                long j3 = jArr2[i6];
                if ((((~j3) << c) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i6 - length2)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((j3 & 255) < 128) {
                            C18850pM2 c18850pM22 = (C18850pM2) objArr2[(i6 << 3) + i8];
                            int iC2 = c18850pM22.c();
                            if (iC2 == i) {
                                c18850pM22.f(i2);
                            } else if (i + 1 <= iC2 && iC2 < i2) {
                                c18850pM22.f(iC2 - 1);
                            }
                        }
                        j3 >>= 8;
                    }
                    if (i7 != 8) {
                        return;
                    }
                }
                if (i6 == length2) {
                    return;
                }
                i6++;
                c = 7;
            }
        }
    }

    public final void l(int i) {
        this.c = i;
    }

    public final int m(C23961xo3 c23961xo3) {
        C18850pM2 c18850pM2 = (C18850pM2) this.e.b(c23961xo3.b());
        if (c18850pM2 != null) {
            return c18850pM2.c();
        }
        return -1;
    }

    public final boolean n(int i, int i2) {
        int iB;
        C18850pM2 c18850pM2 = (C18850pM2) this.e.b(i);
        if (c18850pM2 == null) {
            return false;
        }
        int iB2 = c18850pM2.b();
        int iA = i2 - c18850pM2.a();
        c18850pM2.d(i2);
        if (iA == 0) {
            return true;
        }
        C16734lm4 c16734lm4 = this.e;
        Object[] objArr = c16734lm4.c;
        long[] jArr = c16734lm4.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i3 = 0;
        while (true) {
            long j = jArr[i3];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j) < 128) {
                        C18850pM2 c18850pM22 = (C18850pM2) objArr[(i3 << 3) + i5];
                        if (c18850pM22.b() >= iB2 && !AbstractC13042fc3.d(c18850pM22, c18850pM2) && (iB = c18850pM22.b() + iA) >= 0) {
                            c18850pM22.e(iB);
                        }
                    }
                    j >>= 8;
                }
                if (i4 != 8) {
                    return true;
                }
            }
            if (i3 == length) {
                return true;
            }
            i3++;
        }
    }

    public final int o(C23961xo3 c23961xo3) {
        C18850pM2 c18850pM2 = (C18850pM2) this.e.b(c23961xo3.b());
        return c18850pM2 != null ? c18850pM2.a() : c23961xo3.c();
    }
}
