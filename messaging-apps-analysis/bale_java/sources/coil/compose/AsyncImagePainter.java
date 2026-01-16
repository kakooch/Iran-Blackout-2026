package coil.compose;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.accompanist.drawablepainter.DrawablePainter;
import ir.nasim.AbstractC10222bH6;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12281eL6;
import ir.nasim.AbstractC12470eg0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19123pp;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.AbstractC4326Eq5;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C12366eV1;
import ir.nasim.C12412ea2;
import ir.nasim.C19938rB7;
import ir.nasim.C23553x7;
import ir.nasim.C6010Lu1;
import ir.nasim.ED1;
import ir.nasim.EV4;
import ir.nasim.EnumC18478oj5;
import ir.nasim.I07;
import ir.nasim.InterfaceC13157fl1;
import ir.nasim.InterfaceC14354hm4;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC18663p23;
import ir.nasim.InterfaceC18751pB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22139uj7;
import ir.nasim.InterfaceC22259uv7;
import ir.nasim.InterfaceC22409vB2;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.InterfaceC9336Zm4;
import ir.nasim.OD6;
import ir.nasim.P17;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.W23;
import ir.nasim.Y23;
import ir.nasim.YM5;
import ir.nasim.ZD6;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0003)\u0082\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\u00020\u000e*\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001b\u001a\u00020\u0001*\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001e\u001a\u00020\t*\u00020\u001dH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%H\u0014¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\tH\u0016¢\u0006\u0004\b)\u0010\u000bJ\u000f\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010\u000bJ\u000f\u0010+\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010\u000bR\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00104\u001a\b\u0012\u0004\u0012\u000201008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R/\u0010<\u001a\u0004\u0018\u00010\u00012\b\u00105\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R+\u0010!\u001a\u00020 2\u0006\u00105\u001a\u00020 8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR/\u0010&\u001a\u0004\u0018\u00010%2\b\u00105\u001a\u0004\u0018\u00010%8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bC\u00107\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010L\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000e8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bI\u0010J\"\u0004\bK\u0010\u0011R(\u0010P\u001a\u0004\u0018\u00010\u00012\b\u0010H\u001a\u0004\u0018\u00010\u00018\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bM\u0010N\"\u0004\bO\u0010;R.\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0Q8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR0\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010Q8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bX\u0010R\u001a\u0004\bY\u0010T\"\u0004\bZ\u0010VR\"\u0010c\u001a\u00020\\8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR(\u0010j\u001a\u00020d8\u0000@\u0000X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\be\u0010:\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010q\u001a\u00020\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR+\u0010v\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000e8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\br\u00107\u001a\u0004\bs\u0010t\"\u0004\bu\u0010\u0011R+\u0010\u0004\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bw\u00107\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R+\u0010\u0006\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00058F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u00107\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u001c\u0010\u0081\u0001\u001a\u0002018VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0007\u001a\u0005\bI\u0010\u0080\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0083\u0001"}, d2 = {"Lcoil/compose/AsyncImagePainter;", "Lir/nasim/EV4;", "Lir/nasim/YM5;", "Lir/nasim/W23;", "request", "Lir/nasim/p23;", "imageLoader", "<init>", "(Lir/nasim/W23;Lir/nasim/p23;)V", "Lir/nasim/rB7;", "u", "()V", TokenNames.R, "(Lir/nasim/W23;)Lir/nasim/W23;", "Lcoil/compose/AsyncImagePainter$State;", "input", TokenNames.S, "(Lcoil/compose/AsyncImagePainter$State;)V", "previous", "current", "Lcoil/compose/CrossfadePainter;", "B", "(Lcoil/compose/AsyncImagePainter$State;Lcoil/compose/AsyncImagePainter$State;)Lcoil/compose/CrossfadePainter;", "Lir/nasim/Y23;", "Q", "(Lir/nasim/Y23;)Lcoil/compose/AsyncImagePainter$State;", "Landroid/graphics/drawable/Drawable;", "P", "(Landroid/graphics/drawable/Drawable;)Lir/nasim/EV4;", "Lir/nasim/n02;", "n", "(Lir/nasim/n02;)V", "", "alpha", "", "a", "(F)Z", "Lir/nasim/zX0;", "colorFilter", "c", "(Lir/nasim/zX0;)Z", "b", "e", "d", "Lir/nasim/ro1;", "g", "Lir/nasim/ro1;", "rememberScope", "Lir/nasim/Zm4;", "Lir/nasim/OD6;", "h", "Lir/nasim/Zm4;", "drawSize", "<set-?>", "i", "Lir/nasim/Ym4;", "y", "()Lir/nasim/EV4;", TokenNames.I, "(Lir/nasim/EV4;)V", "painter", "j", "Lir/nasim/hm4;", "v", "()F", TokenNames.C, "(F)V", "k", "w", "()Lir/nasim/zX0;", "D", "(Lir/nasim/zX0;)V", "value", "l", "Lcoil/compose/AsyncImagePainter$State;", TokenNames.O, "_state", "m", "Lir/nasim/EV4;", "N", "_painter", "Lkotlin/Function1;", "Lir/nasim/UA2;", "getTransform$coil_compose_base_release", "()Lir/nasim/UA2;", TokenNames.M, "(Lir/nasim/UA2;)V", "transform", "o", "getOnState$coil_compose_base_release", "H", "onState", "Lir/nasim/fl1;", "p", "Lir/nasim/fl1;", "getContentScale$coil_compose_base_release", "()Lir/nasim/fl1;", TokenNames.E, "(Lir/nasim/fl1;)V", "contentScale", "Lir/nasim/no2;", "q", "getFilterQuality-f-v9h1I$coil_compose_base_release", "()I", TokenNames.F, "(I)V", "filterQuality", "r", "Z", "isPreview$coil_compose_base_release", "()Z", "J", "(Z)V", "isPreview", "s", "A", "()Lcoil/compose/AsyncImagePainter$State;", TokenNames.L, "state", "t", "z", "()Lir/nasim/W23;", TokenNames.K, "(Lir/nasim/W23;)V", "x", "()Lir/nasim/p23;", "G", "(Lir/nasim/p23;)V", "()J", "intrinsicSize", "State", "coil-compose-base_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class AsyncImagePainter extends EV4 implements YM5 {

    /* renamed from: v, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UA2 w = a.e;

    /* renamed from: g, reason: from kotlin metadata */
    private InterfaceC20315ro1 rememberScope;

    /* renamed from: h, reason: from kotlin metadata */
    private final InterfaceC9336Zm4 drawSize = AbstractC12281eL6.a(OD6.c(OD6.b.b()));

    /* renamed from: i, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 painter = AbstractC13472gH6.d(null, null, 2, null);

    /* renamed from: j, reason: from kotlin metadata */
    private final InterfaceC14354hm4 alpha = AbstractC4326Eq5.a(1.0f);

    /* renamed from: k, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 colorFilter = AbstractC13472gH6.d(null, null, 2, null);

    /* renamed from: l, reason: from kotlin metadata */
    private State _state;

    /* renamed from: m, reason: from kotlin metadata */
    private EV4 _painter;

    /* renamed from: n, reason: from kotlin metadata */
    private UA2 transform;

    /* renamed from: o, reason: from kotlin metadata */
    private UA2 onState;

    /* renamed from: p, reason: from kotlin metadata */
    private InterfaceC13157fl1 contentScale;

    /* renamed from: q, reason: from kotlin metadata */
    private int filterQuality;

    /* renamed from: r, reason: from kotlin metadata */
    private boolean isPreview;

    /* renamed from: s, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 state;

    /* renamed from: t, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 request;

    /* renamed from: u, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 imageLoader;

    public static abstract class State {

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Error;", "Lcoil/compose/AsyncImagePainter$State;", "Lir/nasim/EV4;", "painter", "Lir/nasim/ea2;", "result", "<init>", "(Lir/nasim/EV4;Lir/nasim/ea2;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/EV4;", "a", "()Lir/nasim/EV4;", "Lir/nasim/ea2;", "b", "()Lir/nasim/ea2;", "coil-compose-base_release"}, k = 1, mv = {1, 9, 0})
        public static final /* data */ class Error extends State {

            /* renamed from: a, reason: from kotlin metadata and from toString */
            private final C12412ea2 result;
            private final EV4 painter;

            public Error(EV4 ev4, C12412ea2 c12412ea2) {
                super(null);
                this.painter = ev4;
                this.result = c12412ea2;
            }

            @Override // coil.compose.AsyncImagePainter.State
            /* renamed from: a, reason: from getter */
            public EV4 getPainter() {
                return this.painter;
            }

            /* renamed from: b, reason: from getter */
            public final C12412ea2 getResult() {
                return this.result;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return AbstractC13042fc3.d(this.painter, error.painter) && AbstractC13042fc3.d(this.result, error.result);
            }

            public int hashCode() {
                EV4 ev4 = this.painter;
                return ((ev4 == null ? 0 : ev4.hashCode()) * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Error(painter=" + this.painter + ", result=" + this.result + ')';
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Loading;", "Lcoil/compose/AsyncImagePainter$State;", "Lir/nasim/EV4;", "painter", "<init>", "(Lir/nasim/EV4;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/EV4;", "a", "()Lir/nasim/EV4;", "coil-compose-base_release"}, k = 1, mv = {1, 9, 0})
        public static final /* data */ class Loading extends State {
            private final EV4 painter;

            public Loading(EV4 ev4) {
                super(null);
                this.painter = ev4;
            }

            @Override // coil.compose.AsyncImagePainter.State
            /* renamed from: a, reason: from getter */
            public EV4 getPainter() {
                return this.painter;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Loading) && AbstractC13042fc3.d(this.painter, ((Loading) other).painter);
            }

            public int hashCode() {
                EV4 ev4 = this.painter;
                if (ev4 == null) {
                    return 0;
                }
                return ev4.hashCode();
            }

            public String toString() {
                return "Loading(painter=" + this.painter + ')';
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Success;", "Lcoil/compose/AsyncImagePainter$State;", "Lir/nasim/EV4;", "painter", "Lir/nasim/I07;", "result", "<init>", "(Lir/nasim/EV4;Lir/nasim/I07;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/EV4;", "a", "()Lir/nasim/EV4;", "Lir/nasim/I07;", "b", "()Lir/nasim/I07;", "coil-compose-base_release"}, k = 1, mv = {1, 9, 0})
        public static final /* data */ class Success extends State {

            /* renamed from: a, reason: from kotlin metadata and from toString */
            private final I07 result;
            private final EV4 painter;

            public Success(EV4 ev4, I07 i07) {
                super(null);
                this.painter = ev4;
                this.result = i07;
            }

            @Override // coil.compose.AsyncImagePainter.State
            /* renamed from: a, reason: from getter */
            public EV4 getPainter() {
                return this.painter;
            }

            /* renamed from: b, reason: from getter */
            public final I07 getResult() {
                return this.result;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return AbstractC13042fc3.d(this.painter, success.painter) && AbstractC13042fc3.d(this.result, success.result);
            }

            public int hashCode() {
                return (this.painter.hashCode() * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Success(painter=" + this.painter + ", result=" + this.result + ')';
            }
        }

        public static final class a extends State {
            public static final a a = new a();

            private a() {
                super(null);
            }

            @Override // coil.compose.AsyncImagePainter.State
            /* renamed from: a */
            public EV4 getPainter() {
                return null;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof a);
            }

            public int hashCode() {
                return -1515560141;
            }

            public String toString() {
                return "Empty";
            }
        }

        private State() {
        }

        /* renamed from: a */
        public abstract EV4 getPainter();

        public /* synthetic */ State(ED1 ed1) {
            this();
        }
    }

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final State invoke(State state) {
            return state;
        }
    }

    /* renamed from: coil.compose.AsyncImagePainter$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final UA2 a() {
            return AsyncImagePainter.w;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ AsyncImagePainter e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AsyncImagePainter asyncImagePainter) {
                super(0);
                this.e = asyncImagePainter;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final W23 invoke() {
                return this.e.z();
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ AsyncImagePainter d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(AsyncImagePainter asyncImagePainter, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = asyncImagePainter;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AsyncImagePainter asyncImagePainter;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    W23 w23 = (W23) this.c;
                    AsyncImagePainter asyncImagePainter2 = this.d;
                    InterfaceC18663p23 interfaceC18663p23X = asyncImagePainter2.x();
                    W23 w23R = this.d.R(w23);
                    this.c = asyncImagePainter2;
                    this.b = 1;
                    obj = interfaceC18663p23X.a(w23R, this);
                    if (obj == objE) {
                        return objE;
                    }
                    asyncImagePainter = asyncImagePainter2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    asyncImagePainter = (AsyncImagePainter) this.c;
                    AbstractC10685c16.b(obj);
                }
                return asyncImagePainter.Q((Y23) obj);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(W23 w23, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(w23, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: coil.compose.AsyncImagePainter$c$c, reason: collision with other inner class name */
        /* synthetic */ class C0138c implements InterfaceC4806Gq2, InterfaceC22409vB2 {
            final /* synthetic */ AsyncImagePainter a;

            C0138c(AsyncImagePainter asyncImagePainter) {
                this.a = asyncImagePainter;
            }

            @Override // ir.nasim.InterfaceC22409vB2
            public final InterfaceC18751pB2 b() {
                return new C23553x7(2, this.a, AsyncImagePainter.class, "updateState", "updateState(Lcoil/compose/AsyncImagePainter$State;)V", 4);
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final Object a(State state, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objY = c.y(this.a, state, interfaceC20295rm1);
                return objY == AbstractC14862ic3.e() ? objY : C19938rB7.a;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof InterfaceC4806Gq2) && (obj instanceof InterfaceC22409vB2)) {
                    return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
                }
                return false;
            }

            public final int hashCode() {
                return b().hashCode();
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object y(AsyncImagePainter asyncImagePainter, State state, InterfaceC20295rm1 interfaceC20295rm1) {
            asyncImagePainter.S(state);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AsyncImagePainter.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.X(AbstractC10222bH6.r(new a(AsyncImagePainter.this)), new b(AsyncImagePainter.this, null));
                C0138c c0138c = new C0138c(AsyncImagePainter.this);
                this.b = 1;
                if (interfaceC4557Fq2X.b(c0138c, this) == objE) {
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
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class d implements InterfaceC22139uj7 {
        public d() {
        }

        @Override // ir.nasim.InterfaceC22139uj7
        public void a(Drawable drawable) {
        }

        @Override // ir.nasim.InterfaceC22139uj7
        public void b(Drawable drawable) {
            AsyncImagePainter.this.S(new State.Loading(drawable != null ? AsyncImagePainter.this.P(drawable) : null));
        }

        @Override // ir.nasim.InterfaceC22139uj7
        public void c(Drawable drawable) {
        }
    }

    static final class e implements ZD6 {

        public static final class a implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: coil.compose.AsyncImagePainter$e$a$a, reason: collision with other inner class name */
            public static final class C0139a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: coil.compose.AsyncImagePainter$e$a$a$a, reason: collision with other inner class name */
                public static final class C0140a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0140a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C0139a.this.a(null, this);
                    }
                }

                public C0139a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof coil.compose.AsyncImagePainter.e.a.C0139a.C0140a
                        if (r0 == 0) goto L13
                        r0 = r8
                        coil.compose.AsyncImagePainter$e$a$a$a r0 = (coil.compose.AsyncImagePainter.e.a.C0139a.C0140a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        coil.compose.AsyncImagePainter$e$a$a$a r0 = new coil.compose.AsyncImagePainter$e$a$a$a
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto L4b
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        ir.nasim.AbstractC10685c16.b(r8)
                        ir.nasim.Gq2 r8 = r6.a
                        ir.nasim.OD6 r7 = (ir.nasim.OD6) r7
                        long r4 = r7.m()
                        ir.nasim.PD6 r7 = coil.compose.b.b(r4)
                        if (r7 == 0) goto L4b
                        r0.b = r3
                        java.lang.Object r7 = r8.a(r7, r0)
                        if (r7 != r1) goto L4b
                        return r1
                    L4b:
                        ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: coil.compose.AsyncImagePainter.e.a.C0139a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C0139a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        e() {
        }

        @Override // ir.nasim.ZD6
        public final Object f(InterfaceC20295rm1 interfaceC20295rm1) {
            return AbstractC6459Nq2.G(new a(AsyncImagePainter.this.drawSize), interfaceC20295rm1);
        }
    }

    public AsyncImagePainter(W23 w23, InterfaceC18663p23 interfaceC18663p23) {
        State.a aVar = State.a.a;
        this._state = aVar;
        this.transform = w;
        this.contentScale = InterfaceC13157fl1.a.e();
        this.filterQuality = InterfaceC17460n02.i0.b();
        this.state = AbstractC13472gH6.d(aVar, null, 2, null);
        this.request = AbstractC13472gH6.d(w23, null, 2, null);
        this.imageLoader = AbstractC13472gH6.d(interfaceC18663p23, null, 2, null);
    }

    private final CrossfadePainter B(State previous, State current) {
        Y23 result;
        if (!(current instanceof State.Success)) {
            if (current instanceof State.Error) {
                result = ((State.Error) current).getResult();
            }
            return null;
        }
        result = ((State.Success) current).getResult();
        InterfaceC22259uv7 interfaceC22259uv7A = result.b().P().a(b.a, result);
        if (interfaceC22259uv7A instanceof C6010Lu1) {
            C6010Lu1 c6010Lu1 = (C6010Lu1) interfaceC22259uv7A;
            return new CrossfadePainter(previous instanceof State.Loading ? previous.getPainter() : null, current.getPainter(), this.contentScale, c6010Lu1.b(), ((result instanceof I07) && ((I07) result).d()) ? false : true, c6010Lu1.c());
        }
        return null;
    }

    private final void C(float f) {
        this.alpha.s(f);
    }

    private final void D(AbstractC24975zX0 abstractC24975zX0) {
        this.colorFilter.setValue(abstractC24975zX0);
    }

    private final void I(EV4 ev4) {
        this.painter.setValue(ev4);
    }

    private final void L(State state) {
        this.state.setValue(state);
    }

    private final void N(EV4 ev4) {
        this._painter = ev4;
        I(ev4);
    }

    private final void O(State state) {
        this._state = state;
        L(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EV4 P(Drawable drawable) {
        return drawable instanceof BitmapDrawable ? AbstractC12470eg0.b(AbstractC19123pp.c(((BitmapDrawable) drawable).getBitmap()), 0L, 0L, this.filterQuality, 6, null) : new DrawablePainter(drawable.mutate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State Q(Y23 y23) {
        if (y23 instanceof I07) {
            I07 i07 = (I07) y23;
            return new State.Success(P(i07.a()), i07);
        }
        if (!(y23 instanceof C12412ea2)) {
            throw new NoWhenBranchMatchedException();
        }
        Drawable drawableA = y23.a();
        return new State.Error(drawableA != null ? P(drawableA) : null, (C12412ea2) y23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final W23 R(W23 request) {
        W23.a aVarP = W23.R(request, null, 1, null).p(new d());
        if (request.q().m() == null) {
            aVarP.o(new e());
        }
        if (request.q().l() == null) {
            aVarP.n(g.j(this.contentScale));
        }
        if (request.q().k() != EnumC18478oj5.a) {
            aVarP.h(EnumC18478oj5.b);
        }
        return aVarP.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(State input) {
        State state = this._state;
        State state2 = (State) this.transform.invoke(input);
        O(state2);
        EV4 ev4B = B(state, state2);
        if (ev4B == null) {
            ev4B = state2.getPainter();
        }
        N(ev4B);
        if (this.rememberScope != null && state.getPainter() != state2.getPainter()) {
            Object painter = state.getPainter();
            YM5 ym5 = painter instanceof YM5 ? (YM5) painter : null;
            if (ym5 != null) {
                ym5.e();
            }
            Object painter2 = state2.getPainter();
            YM5 ym52 = painter2 instanceof YM5 ? (YM5) painter2 : null;
            if (ym52 != null) {
                ym52.b();
            }
        }
        UA2 ua2 = this.onState;
        if (ua2 != null) {
            ua2.invoke(state2);
        }
    }

    private final void u() {
        InterfaceC20315ro1 interfaceC20315ro1 = this.rememberScope;
        if (interfaceC20315ro1 != null) {
            AbstractC20906so1.d(interfaceC20315ro1, null, 1, null);
        }
        this.rememberScope = null;
    }

    private final float v() {
        return this.alpha.a();
    }

    private final AbstractC24975zX0 w() {
        return (AbstractC24975zX0) this.colorFilter.getValue();
    }

    private final EV4 y() {
        return (EV4) this.painter.getValue();
    }

    public final State A() {
        return (State) this.state.getValue();
    }

    public final void E(InterfaceC13157fl1 interfaceC13157fl1) {
        this.contentScale = interfaceC13157fl1;
    }

    public final void F(int i) {
        this.filterQuality = i;
    }

    public final void G(InterfaceC18663p23 interfaceC18663p23) {
        this.imageLoader.setValue(interfaceC18663p23);
    }

    public final void H(UA2 ua2) {
        this.onState = ua2;
    }

    public final void J(boolean z) {
        this.isPreview = z;
    }

    public final void K(W23 w23) {
        this.request.setValue(w23);
    }

    public final void M(UA2 ua2) {
        this.transform = ua2;
    }

    @Override // ir.nasim.EV4
    protected boolean a(float alpha) {
        C(alpha);
        return true;
    }

    @Override // ir.nasim.YM5
    public void b() {
        if (this.rememberScope != null) {
            return;
        }
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC20906so1.a(P17.b(null, 1, null).X(C12366eV1.c().F0()));
        this.rememberScope = interfaceC20315ro1A;
        Object obj = this._painter;
        YM5 ym5 = obj instanceof YM5 ? (YM5) obj : null;
        if (ym5 != null) {
            ym5.b();
        }
        if (!this.isPreview) {
            AbstractC10533bm0.d(interfaceC20315ro1A, null, null, new c(null), 3, null);
        } else {
            Drawable drawableF = W23.R(z(), null, 1, null).f(x().b()).a().F();
            S(new State.Loading(drawableF != null ? P(drawableF) : null));
        }
    }

    @Override // ir.nasim.EV4
    protected boolean c(AbstractC24975zX0 colorFilter) {
        D(colorFilter);
        return true;
    }

    @Override // ir.nasim.YM5
    public void d() {
        u();
        Object obj = this._painter;
        YM5 ym5 = obj instanceof YM5 ? (YM5) obj : null;
        if (ym5 != null) {
            ym5.d();
        }
    }

    @Override // ir.nasim.YM5
    public void e() {
        u();
        Object obj = this._painter;
        YM5 ym5 = obj instanceof YM5 ? (YM5) obj : null;
        if (ym5 != null) {
            ym5.e();
        }
    }

    @Override // ir.nasim.EV4
    /* renamed from: l */
    public long getIntrinsicSize() {
        EV4 ev4Y = y();
        return ev4Y != null ? ev4Y.getIntrinsicSize() : OD6.b.a();
    }

    @Override // ir.nasim.EV4
    protected void n(InterfaceC17460n02 interfaceC17460n02) {
        this.drawSize.setValue(OD6.c(interfaceC17460n02.d()));
        EV4 ev4Y = y();
        if (ev4Y != null) {
            ev4Y.j(interfaceC17460n02, interfaceC17460n02.d(), v(), w());
        }
    }

    public final InterfaceC18663p23 x() {
        return (InterfaceC18663p23) this.imageLoader.getValue();
    }

    public final W23 z() {
        return (W23) this.request.getValue();
    }
}
