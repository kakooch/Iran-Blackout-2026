package androidx.compose.foundation;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C17784nZ1;
import ir.nasim.DU3;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\u0007\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010\b\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010 R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b&\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/foundation/MarqueeModifierElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/q;", "", "iterations", "Landroidx/compose/foundation/p;", "animationMode", "delayMillis", "initialDelayMillis", "Lir/nasim/DU3;", "spacing", "Lir/nasim/nZ1;", "velocity", "<init>", "(IIIILir/nasim/DU3;FLir/nasim/ED1;)V", "l", "()Landroidx/compose/foundation/q;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/foundation/q;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", TokenNames.I, "c", "d", "e", "f", "Lir/nasim/DU3;", "g", TokenNames.F, "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final /* data */ class MarqueeModifierElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final int iterations;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final int animationMode;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final int delayMillis;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private final int initialDelayMillis;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    private final DU3 spacing;

    /* renamed from: g, reason: from kotlin metadata and from toString */
    private final float velocity;

    public /* synthetic */ MarqueeModifierElement(int i, int i2, int i3, int i4, DU3 du3, float f, ED1 ed1) {
        this(i, i2, i3, i4, du3, f);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarqueeModifierElement)) {
            return false;
        }
        MarqueeModifierElement marqueeModifierElement = (MarqueeModifierElement) other;
        return this.iterations == marqueeModifierElement.iterations && p.f(this.animationMode, marqueeModifierElement.animationMode) && this.delayMillis == marqueeModifierElement.delayMillis && this.initialDelayMillis == marqueeModifierElement.initialDelayMillis && AbstractC13042fc3.d(this.spacing, marqueeModifierElement.spacing) && C17784nZ1.s(this.velocity, marqueeModifierElement.velocity);
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.iterations) * 31) + p.g(this.animationMode)) * 31) + Integer.hashCode(this.delayMillis)) * 31) + Integer.hashCode(this.initialDelayMillis)) * 31) + this.spacing.hashCode()) * 31) + C17784nZ1.t(this.velocity);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public q f() {
        return new q(this.iterations, this.animationMode, this.delayMillis, this.initialDelayMillis, this.spacing, this.velocity, null);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(q node) {
        node.T2(this.iterations, this.animationMode, this.delayMillis, this.initialDelayMillis, this.spacing, this.velocity);
    }

    public String toString() {
        return "MarqueeModifierElement(iterations=" + this.iterations + ", animationMode=" + ((Object) p.h(this.animationMode)) + ", delayMillis=" + this.delayMillis + ", initialDelayMillis=" + this.initialDelayMillis + ", spacing=" + this.spacing + ", velocity=" + ((Object) C17784nZ1.u(this.velocity)) + ')';
    }

    private MarqueeModifierElement(int i, int i2, int i3, int i4, DU3 du3, float f) {
        this.iterations = i;
        this.animationMode = i2;
        this.delayMillis = i3;
        this.initialDelayMillis = i4;
        this.spacing = du3;
        this.velocity = f;
    }
}
