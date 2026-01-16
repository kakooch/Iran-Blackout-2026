package androidx.compose.material.ripple;

import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.compose.ui.e;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16278l02;
import ir.nasim.AbstractC18075o26;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC4663Ga3;
import ir.nasim.C19938rB7;
import ir.nasim.C3587Bm4;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15687k02;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22645vb3;
import ir.nasim.InterfaceC23241wb3;
import ir.nasim.InterfaceC23919xk1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC6693Oo5;
import ir.nasim.InterfaceC9398Zt3;
import ir.nasim.InterfaceC9814ac1;
import ir.nasim.KG1;
import ir.nasim.OD6;
import ir.nasim.SA2;
import ir.nasim.VX0;
import ir.nasim.WH1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B5\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0014H\u0016¢\u0006\u0004\b!\u0010\"J\u0013\u0010$\u001a\u00020\u0014*\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0013\u0010'\u001a\u00020\u0014*\u00020&H&¢\u0006\u0004\b'\u0010(J*\u0010-\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020*2\u0006\u0010,\u001a\u00020+H&ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020)H&¢\u0006\u0004\b/\u00100R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u00101R\u001a\u0010\b\u001a\u00020\u00078\u0004X\u0084\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001a\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u00108R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001a\u0010?\u001a\u00020\u00078\u0006X\u0086D¢\u0006\f\n\u0004\b=\u00103\u001a\u0004\b>\u00105R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010,\u001a\u00020+8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bD\u00107\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR*\u0010N\u001a\u00020*2\u0006\u0010I\u001a\u00020*8\u0004@BX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u00103R\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00120Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0017\u0010W\u001a\u00020U8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bV\u0010M\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006X"}, d2 = {"Landroidx/compose/material/ripple/RippleNode;", "Landroidx/compose/ui/e$c;", "Lir/nasim/ac1;", "Lir/nasim/k02;", "Lir/nasim/Zt3;", "Lir/nasim/wb3;", "interactionSource", "", "bounded", "Lir/nasim/nZ1;", "radius", "Lir/nasim/VX0;", "color", "Lkotlin/Function0;", "Lir/nasim/n26;", "rippleAlpha", "<init>", "(Lir/nasim/wb3;ZFLir/nasim/VX0;Lir/nasim/SA2;Lir/nasim/ED1;)V", "Lir/nasim/Oo5;", "pressInteraction", "Lir/nasim/rB7;", "H2", "(Lir/nasim/Oo5;)V", "Lir/nasim/vb3;", "interaction", "Lir/nasim/ro1;", "scope", "J2", "(Lir/nasim/vb3;Lir/nasim/ro1;)V", "Lir/nasim/Fa3;", "size", TokenNames.S, "(J)V", "e2", "()V", "Lir/nasim/xk1;", "o", "(Lir/nasim/xk1;)V", "Lir/nasim/n02;", "B2", "(Lir/nasim/n02;)V", "Lir/nasim/Oo5$b;", "Lir/nasim/OD6;", "", "targetRadius", "A2", "(Lir/nasim/Oo5$b;JF)V", "I2", "(Lir/nasim/Oo5$b;)V", "Lir/nasim/wb3;", "p", "Z", "C2", "()Z", "q", TokenNames.F, "Lir/nasim/VX0;", "r", "Lir/nasim/SA2;", "D2", "()Lir/nasim/SA2;", "s", "Z1", "shouldAutoInvalidate", "Landroidx/compose/material/ripple/e;", "t", "Landroidx/compose/material/ripple/e;", "stateLayer", "u", "G2", "()F", "setTargetRadius", "(F)V", "<set-?>", "v", "J", "F2", "()J", "rippleSize", "w", "hasValidSize", "Lir/nasim/Bm4;", "x", "Lir/nasim/Bm4;", "pendingInteractions", "Lir/nasim/yX0;", "E2", "rippleColor", "material-ripple_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public abstract class RippleNode extends e.c implements InterfaceC9814ac1, InterfaceC15687k02, InterfaceC9398Zt3 {
    private final VX0 color;

    /* renamed from: o, reason: from kotlin metadata */
    private final InterfaceC23241wb3 interactionSource;

    /* renamed from: p, reason: from kotlin metadata */
    private final boolean bounded;

    /* renamed from: q, reason: from kotlin metadata */
    private final float radius;

    /* renamed from: r, reason: from kotlin metadata */
    private final SA2 rippleAlpha;

    /* renamed from: s, reason: from kotlin metadata */
    private final boolean shouldAutoInvalidate;

    /* renamed from: t, reason: from kotlin metadata */
    private e stateLayer;

    /* renamed from: u, reason: from kotlin metadata */
    private float targetRadius;

    /* renamed from: v, reason: from kotlin metadata */
    private long rippleSize;

    /* renamed from: w, reason: from kotlin metadata */
    private boolean hasValidSize;

    /* renamed from: x, reason: from kotlin metadata */
    private final C3587Bm4 pendingInteractions;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: androidx.compose.material.ripple.RippleNode$a$a, reason: collision with other inner class name */
        static final class C0052a implements InterfaceC4806Gq2 {
            final /* synthetic */ RippleNode a;
            final /* synthetic */ InterfaceC20315ro1 b;

            C0052a(RippleNode rippleNode, InterfaceC20315ro1 interfaceC20315ro1) {
                this.a = rippleNode;
                this.b = interfaceC20315ro1;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(InterfaceC22645vb3 interfaceC22645vb3, InterfaceC20295rm1 interfaceC20295rm1) {
                if (!(interfaceC22645vb3 instanceof InterfaceC6693Oo5)) {
                    this.a.J2(interfaceC22645vb3, this.b);
                } else if (this.a.hasValidSize) {
                    this.a.H2((InterfaceC6693Oo5) interfaceC22645vb3);
                } else {
                    this.a.pendingInteractions.n(interfaceC22645vb3);
                }
                return C19938rB7.a;
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = RippleNode.this.new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2B = RippleNode.this.interactionSource.b();
                C0052a c0052a = new C0052a(RippleNode.this, interfaceC20315ro1);
                this.b = 1;
                if (interfaceC4557Fq2B.b(c0052a, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ RippleNode(InterfaceC23241wb3 interfaceC23241wb3, boolean z, float f, VX0 vx0, SA2 sa2, ED1 ed1) {
        this(interfaceC23241wb3, z, f, vx0, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H2(InterfaceC6693Oo5 pressInteraction) {
        if (pressInteraction instanceof InterfaceC6693Oo5.b) {
            A2((InterfaceC6693Oo5.b) pressInteraction, this.rippleSize, this.targetRadius);
        } else if (pressInteraction instanceof InterfaceC6693Oo5.c) {
            I2(((InterfaceC6693Oo5.c) pressInteraction).a());
        } else if (pressInteraction instanceof InterfaceC6693Oo5.a) {
            I2(((InterfaceC6693Oo5.a) pressInteraction).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J2(InterfaceC22645vb3 interaction, InterfaceC20315ro1 scope) {
        e eVar = this.stateLayer;
        if (eVar == null) {
            eVar = new e(this.bounded, this.rippleAlpha);
            AbstractC16278l02.a(this);
            this.stateLayer = eVar;
        }
        eVar.c(interaction, scope);
    }

    public abstract void A2(InterfaceC6693Oo5.b interaction, long size, float targetRadius);

    public abstract void B2(InterfaceC17460n02 interfaceC17460n02);

    /* renamed from: C2, reason: from getter */
    protected final boolean getBounded() {
        return this.bounded;
    }

    /* renamed from: D2, reason: from getter */
    protected final SA2 getRippleAlpha() {
        return this.rippleAlpha;
    }

    public final long E2() {
        return this.color.a();
    }

    /* renamed from: F2, reason: from getter */
    protected final long getRippleSize() {
        return this.rippleSize;
    }

    /* renamed from: G2, reason: from getter */
    protected final float getTargetRadius() {
        return this.targetRadius;
    }

    public abstract void I2(InterfaceC6693Oo5.b interaction);

    @Override // ir.nasim.InterfaceC9398Zt3
    public void S(long size) {
        this.hasValidSize = true;
        WH1 wh1K = KG1.k(this);
        this.rippleSize = AbstractC4663Ga3.d(size);
        this.targetRadius = Float.isNaN(this.radius) ? AbstractC18075o26.a(wh1K, this.bounded, this.rippleSize) : wh1K.w1(this.radius);
        C3587Bm4 c3587Bm4 = this.pendingInteractions;
        Object[] objArr = c3587Bm4.a;
        int i = c3587Bm4.b;
        for (int i2 = 0; i2 < i; i2++) {
            H2((InterfaceC6693Oo5) objArr[i2]);
        }
        this.pendingInteractions.t();
    }

    @Override // androidx.compose.ui.e.c
    /* renamed from: Z1, reason: from getter */
    public final boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        AbstractC10533bm0.d(U1(), null, null, new a(null), 3, null);
    }

    @Override // ir.nasim.InterfaceC15687k02
    public void o(InterfaceC23919xk1 interfaceC23919xk1) throws Throwable {
        interfaceC23919xk1.N1();
        e eVar = this.stateLayer;
        if (eVar != null) {
            eVar.b(interfaceC23919xk1, this.targetRadius, E2());
        }
        B2(interfaceC23919xk1);
    }

    private RippleNode(InterfaceC23241wb3 interfaceC23241wb3, boolean z, float f, VX0 vx0, SA2 sa2) {
        this.interactionSource = interfaceC23241wb3;
        this.bounded = z;
        this.radius = f;
        this.color = vx0;
        this.rippleAlpha = sa2;
        this.rippleSize = OD6.b.b();
        this.pendingInteractions = new C3587Bm4(0, 1, null);
    }
}
