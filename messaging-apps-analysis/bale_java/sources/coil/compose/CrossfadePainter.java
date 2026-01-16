package coil.compose;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.SystemClock;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC16636lc6;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.AbstractC4326Eq5;
import ir.nasim.EV4;
import ir.nasim.InterfaceC13157fl1;
import ir.nasim.InterfaceC14354hm4;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC17916nm4;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.OD6;
import ir.nasim.UD6;
import ir.nasim.UG6;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0015\u001a\u00020\u0014*\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0002ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u0014*\u00020\u0010H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\b!\u0010\"R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+R+\u00104\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u00106R\u0016\u00108\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010+R+\u0010>\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R/\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010-\u001a\u0004\u0018\u00010\u001f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020\r8VX\u0096\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b,\u0010\u000f\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"Lcoil/compose/CrossfadePainter;", "Lir/nasim/EV4;", "start", "end", "Lir/nasim/fl1;", "contentScale", "", "durationMillis", "", "fadeStart", "preferExactIntrinsicSize", "<init>", "(Lir/nasim/EV4;Lir/nasim/EV4;Lir/nasim/fl1;IZZ)V", "Lir/nasim/OD6;", "p", "()J", "Lir/nasim/n02;", "painter", "", "alpha", "Lir/nasim/rB7;", "q", "(Lir/nasim/n02;Lir/nasim/EV4;F)V", "srcSize", "dstSize", "o", "(JJ)J", "n", "(Lir/nasim/n02;)V", "a", "(F)Z", "Lir/nasim/zX0;", "colorFilter", "c", "(Lir/nasim/zX0;)Z", "g", "Lir/nasim/EV4;", "h", "i", "Lir/nasim/fl1;", "j", TokenNames.I, "k", "Z", "l", "<set-?>", "m", "Lir/nasim/nm4;", "s", "()I", "v", "(I)V", "invalidateTick", "", "J", "startTimeMillis", "isDone", "Lir/nasim/hm4;", "t", "()F", "w", "(F)V", "maxAlpha", "Lir/nasim/Ym4;", "r", "()Lir/nasim/zX0;", "u", "(Lir/nasim/zX0;)V", "intrinsicSize", "coil-compose-base_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class CrossfadePainter extends EV4 {

    /* renamed from: g, reason: from kotlin metadata */
    private EV4 start;

    /* renamed from: h, reason: from kotlin metadata */
    private final EV4 end;

    /* renamed from: i, reason: from kotlin metadata */
    private final InterfaceC13157fl1 contentScale;

    /* renamed from: j, reason: from kotlin metadata */
    private final int durationMillis;

    /* renamed from: k, reason: from kotlin metadata */
    private final boolean fadeStart;

    /* renamed from: l, reason: from kotlin metadata */
    private final boolean preferExactIntrinsicSize;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean isDone;

    /* renamed from: m, reason: from kotlin metadata */
    private final InterfaceC17916nm4 invalidateTick = UG6.a(0);

    /* renamed from: n, reason: from kotlin metadata */
    private long startTimeMillis = -1;

    /* renamed from: p, reason: from kotlin metadata */
    private final InterfaceC14354hm4 maxAlpha = AbstractC4326Eq5.a(1.0f);

    /* renamed from: q, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 colorFilter = AbstractC13472gH6.d(null, null, 2, null);

    public CrossfadePainter(EV4 ev4, EV4 ev42, InterfaceC13157fl1 interfaceC13157fl1, int i, boolean z, boolean z2) {
        this.start = ev4;
        this.end = ev42;
        this.contentScale = interfaceC13157fl1;
        this.durationMillis = i;
        this.fadeStart = z;
        this.preferExactIntrinsicSize = z2;
    }

    private final long o(long srcSize, long dstSize) {
        OD6.a aVar = OD6.b;
        return (srcSize == aVar.a() || OD6.k(srcSize) || dstSize == aVar.a() || OD6.k(dstSize)) ? dstSize : AbstractC16636lc6.a(srcSize, this.contentScale.a(srcSize, dstSize));
    }

    private final long p() {
        EV4 ev4 = this.start;
        long intrinsicSize = ev4 != null ? ev4.getIntrinsicSize() : OD6.b.b();
        EV4 ev42 = this.end;
        long intrinsicSize2 = ev42 != null ? ev42.getIntrinsicSize() : OD6.b.b();
        OD6.a aVar = OD6.b;
        boolean z = intrinsicSize != aVar.a();
        boolean z2 = intrinsicSize2 != aVar.a();
        if (z && z2) {
            return UD6.a(Math.max(OD6.i(intrinsicSize), OD6.i(intrinsicSize2)), Math.max(OD6.g(intrinsicSize), OD6.g(intrinsicSize2)));
        }
        if (this.preferExactIntrinsicSize) {
            if (z) {
                return intrinsicSize;
            }
            if (z2) {
                return intrinsicSize2;
            }
        }
        return aVar.a();
    }

    private final void q(InterfaceC17460n02 interfaceC17460n02, EV4 ev4, float f) {
        if (ev4 == null || f <= 0.0f) {
            return;
        }
        long jD = interfaceC17460n02.d();
        long jO = o(ev4.getIntrinsicSize(), jD);
        if (jD == OD6.b.a() || OD6.k(jD)) {
            ev4.j(interfaceC17460n02, jO, f, r());
            return;
        }
        float f2 = 2;
        float fI = (OD6.i(jD) - OD6.i(jO)) / f2;
        float fG = (OD6.g(jD) - OD6.g(jO)) / f2;
        interfaceC17460n02.z1().b().h(fI, fG, fI, fG);
        ev4.j(interfaceC17460n02, jO, f, r());
        float f3 = -fI;
        float f4 = -fG;
        interfaceC17460n02.z1().b().h(f3, f4, f3, f4);
    }

    private final AbstractC24975zX0 r() {
        return (AbstractC24975zX0) this.colorFilter.getValue();
    }

    private final int s() {
        return this.invalidateTick.d();
    }

    private final float t() {
        return this.maxAlpha.a();
    }

    private final void u(AbstractC24975zX0 abstractC24975zX0) {
        this.colorFilter.setValue(abstractC24975zX0);
    }

    private final void v(int i) {
        this.invalidateTick.h(i);
    }

    private final void w(float f) {
        this.maxAlpha.s(f);
    }

    @Override // ir.nasim.EV4
    protected boolean a(float alpha) {
        w(alpha);
        return true;
    }

    @Override // ir.nasim.EV4
    protected boolean c(AbstractC24975zX0 colorFilter) {
        u(colorFilter);
        return true;
    }

    @Override // ir.nasim.EV4
    /* renamed from: l */
    public long getIntrinsicSize() {
        return p();
    }

    @Override // ir.nasim.EV4
    protected void n(InterfaceC17460n02 interfaceC17460n02) {
        if (this.isDone) {
            q(interfaceC17460n02, this.end, t());
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.startTimeMillis == -1) {
            this.startTimeMillis = jUptimeMillis;
        }
        float f = (jUptimeMillis - this.startTimeMillis) / this.durationMillis;
        float fL = AbstractC23053wG5.l(f, 0.0f, 1.0f) * t();
        float fT = this.fadeStart ? t() - fL : t();
        this.isDone = f >= 1.0f;
        q(interfaceC17460n02, this.start, fT);
        q(interfaceC17460n02, this.end, fL);
        if (this.isDone) {
            this.start = null;
        } else {
            v(s() + 1);
        }
    }
}
