package coil.compose;

import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.compose.ui.e;
import ir.nasim.AbstractC16045kc6;
import ir.nasim.AbstractC16636lc6;
import ir.nasim.AbstractC19606qe1;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.C22045ua3;
import ir.nasim.EV4;
import ir.nasim.InterfaceC10436bc3;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC13157fl1;
import ir.nasim.InterfaceC15687k02;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.InterfaceC23919xk1;
import ir.nasim.InterfaceC9236Zb3;
import ir.nasim.OD6;
import ir.nasim.UA2;
import ir.nasim.UD6;
import ir.nasim.ZV3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0013J&\u0010\u001b\u001a\u00020\u001a*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010!\u001a\u00020\u001f*\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J#\u0010#\u001a\u00020\u001f*\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b#\u0010\"J#\u0010%\u001a\u00020\u001f*\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001fH\u0016¢\u0006\u0004\b%\u0010\"J#\u0010&\u001a\u00020\u001f*\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001fH\u0016¢\u0006\u0004\b&\u0010\"J\u0013\u0010)\u001a\u00020(*\u00020'H\u0016¢\u0006\u0004\b)\u0010*R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010&\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"Lcoil/compose/ContentPainterNode;", "Landroidx/compose/ui/e$c;", "Lir/nasim/k02;", "Lir/nasim/tu3;", "Lir/nasim/EV4;", "painter", "Lir/nasim/em;", "alignment", "Lir/nasim/fl1;", "contentScale", "", "alpha", "Lir/nasim/zX0;", "colorFilter", "<init>", "(Lir/nasim/EV4;Lir/nasim/em;Lir/nasim/fl1;FLir/nasim/zX0;)V", "Lir/nasim/OD6;", "dstSize", "v2", "(J)J", "Lir/nasim/ne1;", "constraints", "x2", "Lir/nasim/eW3;", "Lir/nasim/ZV3;", "measurable", "Lir/nasim/dW3;", "b", "(Lir/nasim/eW3;Lir/nasim/ZV3;J)Lir/nasim/dW3;", "Lir/nasim/bc3;", "Lir/nasim/Zb3;", "", "height", "p", "(Lir/nasim/bc3;Lir/nasim/Zb3;I)I", "z", "width", "J", TokenNames.F, "Lir/nasim/xk1;", "Lir/nasim/rB7;", "o", "(Lir/nasim/xk1;)V", "Lir/nasim/EV4;", "w2", "()Lir/nasim/EV4;", "B2", "(Lir/nasim/EV4;)V", "Lir/nasim/em;", "getAlignment", "()Lir/nasim/em;", "y2", "(Lir/nasim/em;)V", "Lir/nasim/fl1;", "getContentScale", "()Lir/nasim/fl1;", "A2", "(Lir/nasim/fl1;)V", "q", "getAlpha", "()F", "c", "(F)V", "r", "Lir/nasim/zX0;", "getColorFilter", "()Lir/nasim/zX0;", "z2", "(Lir/nasim/zX0;)V", "", "Z1", "()Z", "shouldAutoInvalidate", "coil-compose-base_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class ContentPainterNode extends e.c implements InterfaceC15687k02, InterfaceC21655tu3 {

    /* renamed from: o, reason: from kotlin metadata */
    private InterfaceC12529em alignment;

    /* renamed from: p, reason: from kotlin metadata */
    private InterfaceC13157fl1 contentScale;
    private EV4 painter;

    /* renamed from: q, reason: from kotlin metadata */
    private float alpha;

    /* renamed from: r, reason: from kotlin metadata */
    private AbstractC24975zX0 colorFilter;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC21430te5 abstractC21430te5) {
            super(1);
            this.e = abstractC21430te5;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.l(aVar, this.e, 0, 0, 0.0f, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public ContentPainterNode(EV4 ev4, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0) {
        this.painter = ev4;
        this.alignment = interfaceC12529em;
        this.contentScale = interfaceC13157fl1;
        this.alpha = f;
        this.colorFilter = abstractC24975zX0;
    }

    private final long v2(long dstSize) {
        if (OD6.k(dstSize)) {
            return OD6.b.b();
        }
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (intrinsicSize == OD6.b.a()) {
            return dstSize;
        }
        float fI = OD6.i(intrinsicSize);
        if (Float.isInfinite(fI) || Float.isNaN(fI)) {
            fI = OD6.i(dstSize);
        }
        float fG = OD6.g(intrinsicSize);
        if (Float.isInfinite(fG) || Float.isNaN(fG)) {
            fG = OD6.g(dstSize);
        }
        long jA = UD6.a(fI, fG);
        long jA2 = this.contentScale.a(jA, dstSize);
        float fB = AbstractC16045kc6.b(jA2);
        if (Float.isInfinite(fB) || Float.isNaN(fB)) {
            return dstSize;
        }
        float fC = AbstractC16045kc6.c(jA2);
        return (Float.isInfinite(fC) || Float.isNaN(fC)) ? dstSize : AbstractC16636lc6.b(jA2, jA);
    }

    private final long x2(long constraints) {
        float fN;
        int iM;
        float fA;
        boolean zJ = C17833ne1.j(constraints);
        boolean zI = C17833ne1.i(constraints);
        if (zJ && zI) {
            return constraints;
        }
        boolean z = C17833ne1.h(constraints) && C17833ne1.g(constraints);
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (intrinsicSize == OD6.b.a()) {
            return z ? C17833ne1.d(constraints, C17833ne1.l(constraints), 0, C17833ne1.k(constraints), 0, 10, null) : constraints;
        }
        if (z && (zJ || zI)) {
            fN = C17833ne1.l(constraints);
            iM = C17833ne1.k(constraints);
        } else {
            float fI = OD6.i(intrinsicSize);
            float fG = OD6.g(intrinsicSize);
            fN = (Float.isInfinite(fI) || Float.isNaN(fI)) ? C17833ne1.n(constraints) : g.b(constraints, fI);
            if (!Float.isInfinite(fG) && !Float.isNaN(fG)) {
                fA = g.a(constraints, fG);
                long jV2 = v2(UD6.a(fN, fA));
                return C17833ne1.d(constraints, AbstractC19606qe1.g(constraints, AbstractC20723sV3.d(OD6.i(jV2))), 0, AbstractC19606qe1.f(constraints, AbstractC20723sV3.d(OD6.g(jV2))), 0, 10, null);
            }
            iM = C17833ne1.m(constraints);
        }
        fA = iM;
        long jV22 = v2(UD6.a(fN, fA));
        return C17833ne1.d(constraints, AbstractC19606qe1.g(constraints, AbstractC20723sV3.d(OD6.i(jV22))), 0, AbstractC19606qe1.f(constraints, AbstractC20723sV3.d(OD6.g(jV22))), 0, 10, null);
    }

    public final void A2(InterfaceC13157fl1 interfaceC13157fl1) {
        this.contentScale = interfaceC13157fl1;
    }

    public final void B2(EV4 ev4) {
        this.painter = ev4;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int F(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        if (this.painter.getIntrinsicSize() == OD6.b.a()) {
            return interfaceC9236Zb3.z(i);
        }
        int iZ = interfaceC9236Zb3.z(C17833ne1.l(x2(AbstractC19606qe1.b(0, i, 0, 0, 13, null))));
        return Math.max(AbstractC20723sV3.d(OD6.g(v2(UD6.a(i, iZ)))), iZ);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int J(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        if (this.painter.getIntrinsicSize() == OD6.b.a()) {
            return interfaceC9236Zb3.Z(i);
        }
        int iZ = interfaceC9236Zb3.Z(C17833ne1.l(x2(AbstractC19606qe1.b(0, i, 0, 0, 13, null))));
        return Math.max(AbstractC20723sV3.d(OD6.g(v2(UD6.a(i, iZ)))), iZ);
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(x2(j));
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new a(abstractC21430te5L0), 4, null);
    }

    public final void c(float f) {
        this.alpha = f;
    }

    @Override // ir.nasim.InterfaceC15687k02
    public void o(InterfaceC23919xk1 interfaceC23919xk1) {
        long jV2 = v2(interfaceC23919xk1.d());
        long jA = this.alignment.a(g.i(jV2), g.i(interfaceC23919xk1.d()), interfaceC23919xk1.getLayoutDirection());
        float fD = C22045ua3.d(jA);
        float fE = C22045ua3.e(jA);
        interfaceC23919xk1.z1().b().c(fD, fE);
        this.painter.j(interfaceC23919xk1, jV2, this.alpha, this.colorFilter);
        interfaceC23919xk1.z1().b().c(-fD, -fE);
        interfaceC23919xk1.N1();
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int p(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        if (this.painter.getIntrinsicSize() == OD6.b.a()) {
            return interfaceC9236Zb3.i0(i);
        }
        int iI0 = interfaceC9236Zb3.i0(C17833ne1.k(x2(AbstractC19606qe1.b(0, 0, 0, i, 7, null))));
        return Math.max(AbstractC20723sV3.d(OD6.i(v2(UD6.a(iI0, i)))), iI0);
    }

    /* renamed from: w2, reason: from getter */
    public final EV4 getPainter() {
        return this.painter;
    }

    public final void y2(InterfaceC12529em interfaceC12529em) {
        this.alignment = interfaceC12529em;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int z(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        if (this.painter.getIntrinsicSize() == OD6.b.a()) {
            return interfaceC9236Zb3.k0(i);
        }
        int iK0 = interfaceC9236Zb3.k0(C17833ne1.k(x2(AbstractC19606qe1.b(0, 0, 0, i, 7, null))));
        return Math.max(AbstractC20723sV3.d(OD6.i(v2(UD6.a(iK0, i)))), iK0);
    }

    public final void z2(AbstractC24975zX0 abstractC24975zX0) {
        this.colorFilter = abstractC24975zX0;
    }
}
