package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextUtils;
import java.util.List;

/* renamed from: ir.nasim.kq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16178kq implements InterfaceC10355bW4 {
    private final C17360mq a;
    private final int b;
    private final int c;
    private final long d;
    private final C10550bn7 e;
    private final CharSequence f;
    private final List g;

    /* renamed from: ir.nasim.kq$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AW5.values().length];
            try {
                iArr[AW5.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AW5.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.kq$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC5243Im7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC5243Im7 interfaceC5243Im7) {
            super(2);
            this.e = interfaceC5243Im7;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(RectF rectF, RectF rectF2) {
            return Boolean.valueOf(this.e.a(EK5.f(rectF), EK5.f(rectF2)));
        }
    }

    public /* synthetic */ C16178kq(C17360mq c17360mq, int i, int i2, long j, ED1 ed1) {
        this(c17360mq, i, i2, j);
    }

    private final C10550bn7 E(int i, int i2, TextUtils.TruncateAt truncateAt, int i3, int i4, int i5, int i6, int i7, CharSequence charSequence) {
        return new C10550bn7(charSequence, getWidth(), I(), i, truncateAt, this.a.j(), 1.0f, 0.0f, AbstractC16769lq.b(this.a.i()), true, i3, i5, i6, i7, i4, i2, null, null, this.a.h(), 196736, null);
    }

    static /* synthetic */ C10550bn7 F(C16178kq c16178kq, int i, int i2, TextUtils.TruncateAt truncateAt, int i3, int i4, int i5, int i6, int i7, CharSequence charSequence, int i8, Object obj) {
        return c16178kq.E(i, i2, truncateAt, i3, i4, i5, i6, i7, (i8 & 256) != 0 ? c16178kq.f : charSequence);
    }

    private final C4381Ew6[] H(C10550bn7 c10550bn7) {
        if (!(c10550bn7.G() instanceof Spanned)) {
            return null;
        }
        CharSequence charSequenceG = c10550bn7.G();
        AbstractC13042fc3.g(charSequenceG, "null cannot be cast to non-null type android.text.Spanned");
        if (!J((Spanned) charSequenceG, C4381Ew6.class)) {
            return null;
        }
        CharSequence charSequenceG2 = c10550bn7.G();
        AbstractC13042fc3.g(charSequenceG2, "null cannot be cast to non-null type android.text.Spanned");
        return (C4381Ew6[]) ((Spanned) charSequenceG2).getSpans(0, c10550bn7.G().length(), C4381Ew6.class);
    }

    private final boolean J(Spanned spanned, Class cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }

    private final void K(UE0 ue0) {
        Canvas canvasD = AbstractC7624Sn.d(ue0);
        if (q()) {
            canvasD.save();
            canvasD.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.e.M(canvasD);
        if (q()) {
            canvasD.restore();
        }
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public int A(int i) {
        return this.e.q(i);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public AW5 B(int i) {
        return this.e.L(i) ? AW5.b : AW5.a;
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public CK5 C(int i) {
        boolean z = false;
        if (i >= 0 && i < this.f.length()) {
            z = true;
        }
        if (!z) {
            N73.a("offset(" + i + ") is out of bounds [0," + this.f.length() + ')');
        }
        RectF rectFC = this.e.c(i);
        return new CK5(rectFC.left, rectFC.top, rectFC.right, rectFC.bottom);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public List D() {
        return this.g;
    }

    public float G(int i) {
        return this.e.k(i);
    }

    public final C13806gr I() {
        return this.a.k();
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public float a(int i) {
        return this.e.w(i);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public int b(int i) {
        return this.e.v(i);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public float c() {
        return this.a.c();
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public float d(int i) {
        return this.e.l(i);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public float e() {
        return this.a.e();
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public void f(UE0 ue0, AbstractC12520el0 abstractC12520el0, float f, C5566Jw6 c5566Jw6, C24525yl7 c24525yl7, AbstractC18051o02 abstractC18051o02, int i) {
        int iB = I().b();
        C13806gr c13806grI = I();
        float width = getWidth();
        float height = getHeight();
        c13806grI.e(abstractC12520el0, OD6.d((Float.floatToRawIntBits(height) & 4294967295L) | (Float.floatToRawIntBits(width) << 32)), f);
        c13806grI.h(c5566Jw6);
        c13806grI.i(c24525yl7);
        c13806grI.g(abstractC18051o02);
        c13806grI.d(i);
        K(ue0);
        I().d(iB);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public AW5 g(int i) {
        return this.e.z(this.e.q(i)) == 1 ? AW5.a : AW5.b;
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public float getHeight() {
        return this.e.f();
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public int getLineCount() {
        return this.e.m();
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public float getWidth() {
        return C17833ne1.l(this.d);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public CK5 h(int i) {
        if (!(i >= 0 && i <= this.f.length())) {
            N73.a("offset(" + i + ") is out of bounds [0," + this.f.length() + ']');
        }
        float fB = C10550bn7.B(this.e, i, false, 2, null);
        int iQ = this.e.q(i);
        return new CK5(fB, this.e.w(iQ), fB, this.e.l(iQ));
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public long j(int i) {
        Ja8 ja8I = this.e.I();
        return AbstractC4535Fn7.b(Ia8.b(ja8I, i), Ia8.a(ja8I, i));
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public float k() {
        return G(0);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public int l(long j) {
        return this.e.y(this.e.r((int) Float.intBitsToFloat((int) (4294967295L & j))), Float.intBitsToFloat((int) (j >> 32)));
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public boolean m(int i) {
        return this.e.K(i);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public int n(int i, boolean z) {
        return z ? this.e.x(i) : this.e.p(i);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public float o(int i) {
        return this.e.u(i);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public float p(int i) {
        return this.e.s(i);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public boolean q() {
        return this.e.d();
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public long s(CK5 ck5, int i, InterfaceC5243Im7 interfaceC5243Im7) {
        int[] iArrC = this.e.C(EK5.c(ck5), AbstractC19133pq.r(i), new b(interfaceC5243Im7));
        return iArrC == null ? C4301En7.b.a() : AbstractC4535Fn7.b(iArrC[0], iArrC[1]);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public int t(float f) {
        return this.e.r((int) f);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public V05 u(int i, int i2) {
        if (!(i >= 0 && i <= i2 && i2 <= this.f.length())) {
            N73.a("start(" + i + ") or end(" + i2 + ") is out of range [0.." + this.f.length() + "], or start > end!");
        }
        Path path = new Path();
        this.e.F(i, i2, path);
        return AbstractC21611tq.c(path);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public float v(int i, boolean z) {
        return z ? C10550bn7.B(this.e, i, false, 2, null) : C10550bn7.E(this.e, i, false, 2, null);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public float w(int i) {
        return this.e.t(i);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public void x(UE0 ue0, long j, C5566Jw6 c5566Jw6, C24525yl7 c24525yl7, AbstractC18051o02 abstractC18051o02, int i) {
        int iB = I().b();
        C13806gr c13806grI = I();
        c13806grI.f(j);
        c13806grI.h(c5566Jw6);
        c13806grI.i(c24525yl7);
        c13806grI.g(abstractC18051o02);
        c13806grI.d(i);
        K(ue0);
        I().d(iB);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public void y(long j, float[] fArr, int i) {
        this.e.a(C4301En7.l(j), C4301En7.k(j), fArr, i);
    }

    @Override // ir.nasim.InterfaceC10355bW4
    public float z() {
        return G(getLineCount() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x021b  */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private C16178kq(ir.nasim.C17360mq r30, int r31, int r32, long r33) {
        /*
            Method dump skipped, instructions count: 832
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16178kq.<init>(ir.nasim.mq, int, int, long):void");
    }
}
