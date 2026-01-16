package androidx.compose.foundation.layout;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.ED1;
import ir.nasim.PT1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Landroidx/compose/foundation/layout/FillElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/layout/i;", "Lir/nasim/PT1;", "direction", "", "fraction", "", "inspectorName", "<init>", "(Lir/nasim/PT1;FLjava/lang/String;)V", "l", "()Landroidx/compose/foundation/layout/i;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/foundation/layout/i;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "b", "Lir/nasim/PT1;", "c", TokenNames.F, "d", "Ljava/lang/String;", "e", "a", "foundation-layout_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class FillElement extends AbstractC25066zg4 {

    /* renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: from kotlin metadata */
    private final PT1 direction;

    /* renamed from: c, reason: from kotlin metadata */
    private final float fraction;

    /* renamed from: d, reason: from kotlin metadata */
    private final String inspectorName;

    /* renamed from: androidx.compose.foundation.layout.FillElement$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final FillElement a(float f) {
            return new FillElement(PT1.a, f, "fillMaxHeight");
        }

        public final FillElement b(float f) {
            return new FillElement(PT1.c, f, "fillMaxSize");
        }

        public final FillElement c(float f) {
            return new FillElement(PT1.b, f, "fillMaxWidth");
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public FillElement(PT1 pt1, float f, String str) {
        this.direction = pt1;
        this.fraction = f;
        this.inspectorName = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FillElement)) {
            return false;
        }
        FillElement fillElement = (FillElement) other;
        return this.direction == fillElement.direction && this.fraction == fillElement.fraction;
    }

    public int hashCode() {
        return (this.direction.hashCode() * 31) + Float.hashCode(this.fraction);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public i f() {
        return new i(this.direction, this.fraction);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(i node) {
        node.v2(this.direction);
        node.w2(this.fraction);
    }
}
