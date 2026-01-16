package androidx.compose.ui.draw;

import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.compose.ui.e;
import ir.nasim.AbstractC16636lc6;
import ir.nasim.AbstractC19606qe1;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.C22045ua3;
import ir.nasim.C4414Fa3;
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
import ir.nasim.ZV3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b'\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BA\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0015J\u0016\u0010\u0019\u001a\u00020\u0006*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u0006*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001aJ&\u0010 \u001a\u00020\u001f*\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b \u0010!J#\u0010&\u001a\u00020$*\u00020\"2\u0006\u0010\u001e\u001a\u00020#2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J#\u0010(\u001a\u00020$*\u00020\"2\u0006\u0010\u001e\u001a\u00020#2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b(\u0010'J#\u0010*\u001a\u00020$*\u00020\"2\u0006\u0010\u001e\u001a\u00020#2\u0006\u0010)\u001a\u00020$H\u0016¢\u0006\u0004\b*\u0010'J#\u0010+\u001a\u00020$*\u00020\"2\u0006\u0010\u001e\u001a\u00020#2\u0006\u0010)\u001a\u00020$H\u0016¢\u0006\u0004\b+\u0010'J\u0013\u0010.\u001a\u00020-*\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010+\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010:R\u0014\u0010V\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010:\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006W"}, d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Lir/nasim/tu3;", "Landroidx/compose/ui/e$c;", "Lir/nasim/k02;", "Lir/nasim/EV4;", "painter", "", "sizeToIntrinsics", "Lir/nasim/em;", "alignment", "Lir/nasim/fl1;", "contentScale", "", "alpha", "Lir/nasim/zX0;", "colorFilter", "<init>", "(Lir/nasim/EV4;ZLir/nasim/em;Lir/nasim/fl1;FLir/nasim/zX0;)V", "Lir/nasim/OD6;", "dstSize", "v2", "(J)J", "Lir/nasim/ne1;", "constraints", "B2", "A2", "(J)Z", "z2", "Lir/nasim/eW3;", "Lir/nasim/ZV3;", "measurable", "Lir/nasim/dW3;", "b", "(Lir/nasim/eW3;Lir/nasim/ZV3;J)Lir/nasim/dW3;", "Lir/nasim/bc3;", "Lir/nasim/Zb3;", "", "height", "p", "(Lir/nasim/bc3;Lir/nasim/Zb3;I)I", "z", "width", "J", TokenNames.F, "Lir/nasim/xk1;", "Lir/nasim/rB7;", "o", "(Lir/nasim/xk1;)V", "", "toString", "()Ljava/lang/String;", "Lir/nasim/EV4;", "w2", "()Lir/nasim/EV4;", "F2", "(Lir/nasim/EV4;)V", "Z", "x2", "()Z", "G2", "(Z)V", "Lir/nasim/em;", "getAlignment", "()Lir/nasim/em;", "C2", "(Lir/nasim/em;)V", "q", "Lir/nasim/fl1;", "getContentScale", "()Lir/nasim/fl1;", "E2", "(Lir/nasim/fl1;)V", "r", "getAlpha", "()F", "c", "(F)V", "s", "Lir/nasim/zX0;", "getColorFilter", "()Lir/nasim/zX0;", "D2", "(Lir/nasim/zX0;)V", "y2", "useIntrinsicSize", "Z1", "shouldAutoInvalidate", "ui_release"}, k = 1, mv = {1, 9, 0})
/* renamed from: androidx.compose.ui.draw.PainterNode, reason: from toString */
/* loaded from: classes2.dex */
final class PainterModifier extends e.c implements InterfaceC21655tu3, InterfaceC15687k02 {

    /* renamed from: o, reason: from kotlin metadata and from toString */
    private boolean sizeToIntrinsics;

    /* renamed from: p, reason: from kotlin metadata and from toString */
    private InterfaceC12529em alignment;
    private EV4 painter;

    /* renamed from: q, reason: from kotlin metadata */
    private InterfaceC13157fl1 contentScale;

    /* renamed from: r, reason: from kotlin metadata and from toString */
    private float alpha;

    /* renamed from: s, reason: from kotlin metadata and from toString */
    private AbstractC24975zX0 colorFilter;

    /* renamed from: androidx.compose.ui.draw.PainterNode$a */
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

    public PainterModifier(EV4 ev4, boolean z, InterfaceC12529em interfaceC12529em, InterfaceC13157fl1 interfaceC13157fl1, float f, AbstractC24975zX0 abstractC24975zX0) {
        this.painter = ev4;
        this.sizeToIntrinsics = z;
        this.alignment = interfaceC12529em;
        this.contentScale = interfaceC13157fl1;
        this.alpha = f;
        this.colorFilter = abstractC24975zX0;
    }

    private final boolean A2(long j) {
        return !OD6.f(j, OD6.b.a()) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32))) & Integer.MAX_VALUE) < 2139095040;
    }

    private final long B2(long constraints) {
        boolean z = false;
        boolean z2 = C17833ne1.h(constraints) && C17833ne1.g(constraints);
        if (C17833ne1.j(constraints) && C17833ne1.i(constraints)) {
            z = true;
        }
        if ((!y2() && z2) || z) {
            return C17833ne1.d(constraints, C17833ne1.l(constraints), 0, C17833ne1.k(constraints), 0, 10, null);
        }
        long jL = this.painter.getIntrinsicSize();
        int iRound = A2(jL) ? Math.round(Float.intBitsToFloat((int) (jL >> 32))) : C17833ne1.n(constraints);
        int iRound2 = z2(jL) ? Math.round(Float.intBitsToFloat((int) (jL & 4294967295L))) : C17833ne1.m(constraints);
        long jV2 = v2(OD6.d((Float.floatToRawIntBits(AbstractC19606qe1.g(constraints, iRound)) << 32) | (Float.floatToRawIntBits(AbstractC19606qe1.f(constraints, iRound2)) & 4294967295L)));
        return C17833ne1.d(constraints, AbstractC19606qe1.g(constraints, Math.round(Float.intBitsToFloat((int) (jV2 >> 32)))), 0, AbstractC19606qe1.f(constraints, Math.round(Float.intBitsToFloat((int) (jV2 & 4294967295L)))), 0, 10, null);
    }

    private final long v2(long dstSize) {
        if (!y2()) {
            return dstSize;
        }
        long jD = OD6.d((Float.floatToRawIntBits(!A2(this.painter.getIntrinsicSize()) ? Float.intBitsToFloat((int) (dstSize >> 32)) : Float.intBitsToFloat((int) (this.painter.getIntrinsicSize() >> 32))) << 32) | (Float.floatToRawIntBits(!z2(this.painter.getIntrinsicSize()) ? Float.intBitsToFloat((int) (dstSize & 4294967295L)) : Float.intBitsToFloat((int) (this.painter.getIntrinsicSize() & 4294967295L))) & 4294967295L));
        return (Float.intBitsToFloat((int) (dstSize >> 32)) == 0.0f || Float.intBitsToFloat((int) (dstSize & 4294967295L)) == 0.0f) ? OD6.b.b() : AbstractC16636lc6.a(jD, this.contentScale.a(jD, dstSize));
    }

    private final boolean y2() {
        return this.sizeToIntrinsics && this.painter.getIntrinsicSize() != 9205357640488583168L;
    }

    private final boolean z2(long j) {
        return !OD6.f(j, OD6.b.a()) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L))) & Integer.MAX_VALUE) < 2139095040;
    }

    public final void C2(InterfaceC12529em interfaceC12529em) {
        this.alignment = interfaceC12529em;
    }

    public final void D2(AbstractC24975zX0 abstractC24975zX0) {
        this.colorFilter = abstractC24975zX0;
    }

    public final void E2(InterfaceC13157fl1 interfaceC13157fl1) {
        this.contentScale = interfaceC13157fl1;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int F(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        if (!y2()) {
            return interfaceC9236Zb3.z(i);
        }
        long jB2 = B2(AbstractC19606qe1.b(0, i, 0, 0, 13, null));
        return Math.max(C17833ne1.m(jB2), interfaceC9236Zb3.z(i));
    }

    public final void F2(EV4 ev4) {
        this.painter = ev4;
    }

    public final void G2(boolean z) {
        this.sizeToIntrinsics = z;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int J(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        if (!y2()) {
            return interfaceC9236Zb3.Z(i);
        }
        long jB2 = B2(AbstractC19606qe1.b(0, i, 0, 0, 13, null));
        return Math.max(C17833ne1.m(jB2), interfaceC9236Zb3.Z(i));
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(B2(j));
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new a(abstractC21430te5L0), 4, null);
    }

    public final void c(float f) {
        this.alpha = f;
    }

    @Override // ir.nasim.InterfaceC15687k02
    public void o(InterfaceC23919xk1 interfaceC23919xk1) {
        long jL = this.painter.getIntrinsicSize();
        float fIntBitsToFloat = A2(jL) ? Float.intBitsToFloat((int) (jL >> 32)) : Float.intBitsToFloat((int) (interfaceC23919xk1.d() >> 32));
        float fIntBitsToFloat2 = z2(jL) ? Float.intBitsToFloat((int) (jL & 4294967295L)) : Float.intBitsToFloat((int) (interfaceC23919xk1.d() & 4294967295L));
        long jD = OD6.d((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
        long jB = (Float.intBitsToFloat((int) (interfaceC23919xk1.d() >> 32)) == 0.0f || Float.intBitsToFloat((int) (interfaceC23919xk1.d() & 4294967295L)) == 0.0f) ? OD6.b.b() : AbstractC16636lc6.a(jD, this.contentScale.a(jD, interfaceC23919xk1.d()));
        long jA = this.alignment.a(C4414Fa3.c((Math.round(Float.intBitsToFloat((int) (jB & 4294967295L))) & 4294967295L) | (Math.round(Float.intBitsToFloat((int) (jB >> 32))) << 32)), C4414Fa3.c((Math.round(Float.intBitsToFloat((int) (interfaceC23919xk1.d() >> 32))) << 32) | (Math.round(Float.intBitsToFloat((int) (interfaceC23919xk1.d() & 4294967295L))) & 4294967295L)), interfaceC23919xk1.getLayoutDirection());
        float fK = C22045ua3.k(jA);
        float fL = C22045ua3.l(jA);
        interfaceC23919xk1.z1().b().c(fK, fL);
        try {
            this.painter.j(interfaceC23919xk1, jB, this.alpha, this.colorFilter);
            interfaceC23919xk1.z1().b().c(-fK, -fL);
            interfaceC23919xk1.N1();
        } catch (Throwable th) {
            interfaceC23919xk1.z1().b().c(-fK, -fL);
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int p(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        if (!y2()) {
            return interfaceC9236Zb3.i0(i);
        }
        long jB2 = B2(AbstractC19606qe1.b(0, 0, 0, i, 7, null));
        return Math.max(C17833ne1.n(jB2), interfaceC9236Zb3.i0(i));
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    /* renamed from: w2, reason: from getter */
    public final EV4 getPainter() {
        return this.painter;
    }

    /* renamed from: x2, reason: from getter */
    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int z(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        if (!y2()) {
            return interfaceC9236Zb3.k0(i);
        }
        long jB2 = B2(AbstractC19606qe1.b(0, 0, 0, i, 7, null));
        return Math.max(C17833ne1.n(jB2), interfaceC9236Zb3.k0(i));
    }
}
