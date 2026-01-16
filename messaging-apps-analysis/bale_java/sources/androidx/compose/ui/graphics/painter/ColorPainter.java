package androidx.compose.ui.graphics.painter;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.C24381yX0;
import ir.nasim.ED1;
import ir.nasim.EV4;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.OD6;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R \u0010(\u001a\u00020%8\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010 \u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/compose/ui/graphics/painter/ColorPainter;", "Lir/nasim/EV4;", "Lir/nasim/yX0;", "color", "<init>", "(JLir/nasim/ED1;)V", "Lir/nasim/n02;", "Lir/nasim/rB7;", "n", "(Lir/nasim/n02;)V", "", "alpha", "", "a", "(F)Z", "Lir/nasim/zX0;", "colorFilter", "c", "(Lir/nasim/zX0;)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "g", "J", "getColor-0d7_KjU", "()J", "h", TokenNames.F, "i", "Lir/nasim/zX0;", "Lir/nasim/OD6;", "j", "l", "intrinsicSize", "ui-graphics_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class ColorPainter extends EV4 {

    /* renamed from: g, reason: from kotlin metadata and from toString */
    private final long color;

    /* renamed from: h, reason: from kotlin metadata */
    private float alpha;

    /* renamed from: i, reason: from kotlin metadata */
    private AbstractC24975zX0 colorFilter;

    /* renamed from: j, reason: from kotlin metadata */
    private final long intrinsicSize;

    public /* synthetic */ ColorPainter(long j, ED1 ed1) {
        this(j);
    }

    @Override // ir.nasim.EV4
    protected boolean a(float alpha) {
        this.alpha = alpha;
        return true;
    }

    @Override // ir.nasim.EV4
    protected boolean c(AbstractC24975zX0 colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ColorPainter) && C24381yX0.q(this.color, ((ColorPainter) other).color);
    }

    public int hashCode() {
        return C24381yX0.w(this.color);
    }

    @Override // ir.nasim.EV4
    /* renamed from: l, reason: from getter */
    public long getIntrinsicSize() {
        return this.intrinsicSize;
    }

    @Override // ir.nasim.EV4
    protected void n(InterfaceC17460n02 interfaceC17460n02) {
        InterfaceC17460n02.C1(interfaceC17460n02, this.color, 0L, 0L, this.alpha, null, this.colorFilter, 0, 86, null);
    }

    public String toString() {
        return "ColorPainter(color=" + ((Object) C24381yX0.x(this.color)) + ')';
    }

    private ColorPainter(long j) {
        this.color = j;
        this.alpha = 1.0f;
        this.intrinsicSize = OD6.b.a();
    }
}
