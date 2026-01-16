package androidx.compose.material;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC10434bc1;
import ir.nasim.AbstractC20866sk1;
import ir.nasim.AbstractC22920w26;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17484n26;
import ir.nasim.C19257q26;
import ir.nasim.C19938rB7;
import ir.nasim.C20457s26;
import ir.nasim.C24381yX0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23241wb3;
import ir.nasim.InterfaceC9814ac1;
import ir.nasim.JG1;
import ir.nasim.RG1;
import ir.nasim.SA2;
import ir.nasim.SG4;
import ir.nasim.TG4;
import ir.nasim.UY0;
import ir.nasim.VX0;
import ir.nasim.VY0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/material/DelegatingThemeAwareRippleNode;", "Lir/nasim/RG1;", "Lir/nasim/ac1;", "Lir/nasim/SG4;", "Lir/nasim/wb3;", "interactionSource", "", "bounded", "Lir/nasim/nZ1;", "radius", "Lir/nasim/VX0;", "color", "<init>", "(Lir/nasim/wb3;ZFLir/nasim/VX0;Lir/nasim/ED1;)V", "Lir/nasim/rB7;", "H2", "()V", "F2", "G2", "e2", "x0", "q", "Lir/nasim/wb3;", "r", "Z", "s", TokenNames.F, "Lir/nasim/VX0;", "Lir/nasim/JG1;", "t", "Lir/nasim/JG1;", "rippleNode", "material_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class DelegatingThemeAwareRippleNode extends RG1 implements InterfaceC9814ac1, SG4 {
    private final VX0 color;

    /* renamed from: q, reason: from kotlin metadata */
    private final InterfaceC23241wb3 interactionSource;

    /* renamed from: r, reason: from kotlin metadata */
    private final boolean bounded;

    /* renamed from: s, reason: from kotlin metadata */
    private final float radius;

    /* renamed from: t, reason: from kotlin metadata */
    private JG1 rippleNode;

    static final class a implements VX0 {
        a() {
        }

        @Override // ir.nasim.VX0
        public final long a() {
            long jA = DelegatingThemeAwareRippleNode.this.color.a();
            if (jA != 16) {
                return jA;
            }
            C19257q26 c19257q26 = (C19257q26) AbstractC10434bc1.a(DelegatingThemeAwareRippleNode.this, androidx.compose.material.a.d());
            return (c19257q26 == null || c19257q26.a() == 16) ? C20457s26.a.b(((C24381yX0) AbstractC10434bc1.a(DelegatingThemeAwareRippleNode.this, AbstractC20866sk1.a())).y(), ((UY0) AbstractC10434bc1.a(DelegatingThemeAwareRippleNode.this, VY0.e())).o()) : c19257q26.a();
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C17484n26 invoke() {
            C17484n26 c17484n26B;
            C19257q26 c19257q26 = (C19257q26) AbstractC10434bc1.a(DelegatingThemeAwareRippleNode.this, androidx.compose.material.a.d());
            return (c19257q26 == null || (c17484n26B = c19257q26.b()) == null) ? C20457s26.a.a(((C24381yX0) AbstractC10434bc1.a(DelegatingThemeAwareRippleNode.this, AbstractC20866sk1.a())).y(), ((UY0) AbstractC10434bc1.a(DelegatingThemeAwareRippleNode.this, VY0.e())).o()) : c17484n26B;
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        public final void a() {
            if (((C19257q26) AbstractC10434bc1.a(DelegatingThemeAwareRippleNode.this, androidx.compose.material.a.d())) == null) {
                DelegatingThemeAwareRippleNode.this.G2();
            } else if (DelegatingThemeAwareRippleNode.this.rippleNode == null) {
                DelegatingThemeAwareRippleNode.this.F2();
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public /* synthetic */ DelegatingThemeAwareRippleNode(InterfaceC23241wb3 interfaceC23241wb3, boolean z, float f, VX0 vx0, ED1 ed1) {
        this(interfaceC23241wb3, z, f, vx0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F2() {
        this.rippleNode = v2(AbstractC22920w26.c(this.interactionSource, this.bounded, this.radius, new a(), new b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G2() {
        JG1 jg1 = this.rippleNode;
        if (jg1 != null) {
            y2(jg1);
        }
        this.rippleNode = null;
    }

    private final void H2() {
        TG4.a(this, new c());
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        H2();
    }

    @Override // ir.nasim.SG4
    public void x0() {
        H2();
    }

    private DelegatingThemeAwareRippleNode(InterfaceC23241wb3 interfaceC23241wb3, boolean z, float f, VX0 vx0) {
        this.interactionSource = interfaceC23241wb3;
        this.bounded = z;
        this.radius = f;
        this.color = vx0;
    }
}
