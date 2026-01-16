package androidx.compose.foundation.layout;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C17784nZ1;
import ir.nasim.ED1;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BK\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0005\u001a\u00020\u00038\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u00038\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b \u0010\u001dR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/foundation/layout/SizeElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/layout/u;", "Lir/nasim/nZ1;", "minWidth", "minHeight", "maxWidth", "maxHeight", "", "enforceIncoming", "Lkotlin/Function1;", "Lir/nasim/T93;", "Lir/nasim/rB7;", "inspectorInfo", "<init>", "(FFFFZLir/nasim/UA2;Lir/nasim/ED1;)V", "l", "()Landroidx/compose/foundation/layout/u;", "node", "m", "(Landroidx/compose/foundation/layout/u;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "b", TokenNames.F, "c", "d", "e", "f", "Z", "g", "Lir/nasim/UA2;", "foundation-layout_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class SizeElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata */
    private final float minWidth;

    /* renamed from: c, reason: from kotlin metadata */
    private final float minHeight;

    /* renamed from: d, reason: from kotlin metadata */
    private final float maxWidth;

    /* renamed from: e, reason: from kotlin metadata */
    private final float maxHeight;

    /* renamed from: f, reason: from kotlin metadata */
    private final boolean enforceIncoming;

    /* renamed from: g, reason: from kotlin metadata */
    private final UA2 inspectorInfo;

    public /* synthetic */ SizeElement(float f, float f2, float f3, float f4, boolean z, UA2 ua2, ED1 ed1) {
        this(f, f2, f3, f4, z, ua2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SizeElement)) {
            return false;
        }
        SizeElement sizeElement = (SizeElement) other;
        return C17784nZ1.s(this.minWidth, sizeElement.minWidth) && C17784nZ1.s(this.minHeight, sizeElement.minHeight) && C17784nZ1.s(this.maxWidth, sizeElement.maxWidth) && C17784nZ1.s(this.maxHeight, sizeElement.maxHeight) && this.enforceIncoming == sizeElement.enforceIncoming;
    }

    public int hashCode() {
        return (((((((C17784nZ1.t(this.minWidth) * 31) + C17784nZ1.t(this.minHeight)) * 31) + C17784nZ1.t(this.maxWidth)) * 31) + C17784nZ1.t(this.maxHeight)) * 31) + Boolean.hashCode(this.enforceIncoming);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public u f() {
        return new u(this.minWidth, this.minHeight, this.maxWidth, this.maxHeight, this.enforceIncoming, null);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(u node) {
        node.A2(this.minWidth);
        node.z2(this.minHeight);
        node.y2(this.maxWidth);
        node.x2(this.maxHeight);
        node.w2(this.enforceIncoming);
    }

    public /* synthetic */ SizeElement(float f, float f2, float f3, float f4, boolean z, UA2 ua2, int i, ED1 ed1) {
        this((i & 1) != 0 ? C17784nZ1.b.c() : f, (i & 2) != 0 ? C17784nZ1.b.c() : f2, (i & 4) != 0 ? C17784nZ1.b.c() : f3, (i & 8) != 0 ? C17784nZ1.b.c() : f4, z, ua2, null);
    }

    private SizeElement(float f, float f2, float f3, float f4, boolean z, UA2 ua2) {
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
        this.inspectorInfo = ua2;
    }
}
