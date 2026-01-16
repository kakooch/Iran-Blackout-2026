package ir.nasim;

import android.content.Context;
import android.media.AudioManager;
import ir.nasim.AbstractC14721iN;
import ir.nasim.InterfaceC20791sc6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.y0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC24073y0 implements InterfaceC20791sc6.a {
    private InterfaceC14603iB2 a;
    private c b;
    private final InterfaceC20791sc6 c;
    private List d;
    private AbstractC14721iN e;
    private AbstractC14721iN f;
    private SortedSet g;
    private boolean h;
    private boolean i;
    private NI3 j;
    private final C17083mN k;
    public static final b m = new b(null);
    private static final InterfaceC9173Yu3 l = AbstractC13269fw3.a(a.e);

    /* renamed from: ir.nasim.y0$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            return AbstractC10360bX0.p(AbstractC14721iN.a.class, AbstractC14721iN.d.class, AbstractC14721iN.b.class, AbstractC14721iN.c.class);
        }
    }

    /* renamed from: ir.nasim.y0$b */
    public static final class b {
        private b() {
        }

        public final List a() {
            return (List) AbstractC24073y0.l.getValue();
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.y0$c */
    public enum c {
        STARTED,
        ACTIVATED,
        STOPPED
    }

    /* renamed from: ir.nasim.y0$d */
    public static final class d implements InterfaceC18868pO2 {
        final /* synthetic */ Iterable a;

        public d(Iterable iterable) {
            this.a = iterable;
        }

        @Override // ir.nasim.InterfaceC18868pO2
        public Object a(Object obj) {
            return (Class) obj;
        }

        @Override // ir.nasim.InterfaceC18868pO2
        public Iterator b() {
            return this.a.iterator();
        }
    }

    /* renamed from: ir.nasim.y0$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        public static final e e = new e();

        e() {
            super(1);
        }

        public final boolean a(AbstractC14721iN abstractC14721iN) {
            return abstractC14721iN instanceof AbstractC14721iN.b;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((AbstractC14721iN) obj));
        }
    }

    public AbstractC24073y0(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, InterfaceC20791sc6 interfaceC20791sc6, boolean z, NI3 ni3, List list, C17083mN c17083mN) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(onAudioFocusChangeListener, "audioFocusChangeListener");
        AbstractC13042fc3.i(interfaceC20791sc6, "scanner");
        AbstractC13042fc3.i(ni3, "logger");
        AbstractC13042fc3.i(list, "preferredDeviceList");
        AbstractC13042fc3.i(c17083mN, "audioDeviceManager");
        this.j = ni3;
        this.k = c17083mN;
        this.b = c.STOPPED;
        this.c = interfaceC20791sc6;
        this.h = true;
        this.d = m(list);
        this.g = new ConcurrentSkipListSet(new C18265oN(this.d));
        this.j.a("AudioSwitch", "AudioSwitch(1.2.0)");
        NI3 ni32 = this.j;
        StringBuilder sb = new StringBuilder();
        sb.append("Preferred device list = ");
        List list2 = this.d;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Class) it.next()).getSimpleName());
        }
        sb.append(arrayList);
        ni32.a("AudioSwitch", sb.toString());
    }

    private final void e() {
        this.c.stop();
        this.a = null;
        this.b = c.STOPPED;
    }

    private final AbstractC14721iN k() {
        Object next;
        AbstractC14721iN abstractC14721iN = this.e;
        if (abstractC14721iN != null && this.c.a(abstractC14721iN)) {
            return abstractC14721iN;
        }
        Iterator it = this.g.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            AbstractC14721iN abstractC14721iN2 = (AbstractC14721iN) next;
            InterfaceC20791sc6 interfaceC20791sc6 = this.c;
            AbstractC13042fc3.h(abstractC14721iN2, "it");
            if (interfaceC20791sc6.a(abstractC14721iN2)) {
                break;
            }
        }
        return (AbstractC14721iN) next;
    }

    private final List m(List list) {
        if (!p(list)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!list.isEmpty()) {
            b bVar = m;
            if (!AbstractC13042fc3.d(list, bVar.a())) {
                List listP1 = AbstractC15401jX0.p1(bVar.a());
                listP1.removeAll(list);
                int i = 0;
                for (Object obj : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        AbstractC10360bX0.w();
                    }
                    listP1.add(i, (Class) obj);
                    i = i2;
                }
                return listP1;
            }
        }
        return m.a();
    }

    private final boolean p(List list) {
        Map mapA = AbstractC20659sO2.a(new d(list));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapA.entrySet()) {
            if (((Number) entry.getValue()).intValue() > 1) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap.isEmpty();
    }

    public static /* synthetic */ void t(AbstractC24073y0 abstractC24073y0, boolean z, AbstractC14721iN abstractC14721iN, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectAudioDevice");
        }
        if ((i & 2) != 0) {
            abstractC14721iN = abstractC24073y0.k();
        }
        abstractC24073y0.s(z, abstractC14721iN);
    }

    public final void A(boolean z) {
        this.h = z;
    }

    protected final void B(AbstractC14721iN abstractC14721iN) {
        this.e = abstractC14721iN;
    }

    protected final boolean C() {
        int iH = h();
        return this.i || iH == 3 || iH == 2;
    }

    public final void D(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "listener");
        this.a = interfaceC14603iB2;
        if (AbstractC24663z0.a[this.b.ordinal()] != 1) {
            this.j.a("AudioSwitch", "Redundant start() invocation while already in the started or activated state");
        } else {
            this.c.b(this);
            this.b = c.STARTED;
        }
    }

    public final void E() {
        int i = AbstractC24663z0.b[this.b.ordinal()];
        if (i == 1) {
            f();
            e();
        } else if (i == 2) {
            e();
        } else {
            if (i != 3) {
                return;
            }
            this.j.a("AudioSwitch", "Redundant stop() invocation while already in the stopped state");
        }
    }

    @Override // ir.nasim.InterfaceC20791sc6.a
    public void a(AbstractC14721iN abstractC14721iN) {
        AbstractC13042fc3.i(abstractC14721iN, "audioDevice");
        this.j.a("AudioSwitch", "onDeviceConnected(" + abstractC14721iN + ')');
        if ((abstractC14721iN instanceof AbstractC14721iN.b) && i().contains(new AbstractC14721iN.d(null, 1, null))) {
            return;
        }
        boolean zAdd = this.g.add(abstractC14721iN);
        if (abstractC14721iN instanceof AbstractC14721iN.d) {
            AbstractC13610gX0.I(this.g, e.e);
        }
        t(this, zAdd, null, 2, null);
    }

    public final void d() {
        AbstractC14721iN abstractC14721iN;
        int i = AbstractC24663z0.c[this.b.ordinal()];
        if (i == 1) {
            this.k.a();
            this.k.f(false);
            if (this.h) {
                this.k.j();
            }
            AbstractC14721iN abstractC14721iN2 = this.f;
            if (abstractC14721iN2 != null) {
                abstractC14721iN = C() ? abstractC14721iN2 : null;
                if (abstractC14721iN != null) {
                    q(abstractC14721iN);
                }
            }
            this.b = c.ACTIVATED;
            return;
        }
        if (i != 2) {
            if (i == 3) {
                throw new IllegalStateException();
            }
            return;
        }
        AbstractC14721iN abstractC14721iN3 = this.f;
        if (abstractC14721iN3 != null) {
            abstractC14721iN = C() ? abstractC14721iN3 : null;
            if (abstractC14721iN != null) {
                q(abstractC14721iN);
            }
        }
    }

    public final void f() {
        if (AbstractC24663z0.d[this.b.ordinal()] != 1) {
            return;
        }
        r();
        this.k.g();
        this.b = c.STARTED;
    }

    public final C17083mN g() {
        return this.k;
    }

    public final int h() {
        return this.k.d();
    }

    public final List i() {
        return AbstractC15401jX0.m1(this.g);
    }

    public final SortedSet j() {
        return this.g;
    }

    public final NI3 l() {
        return this.j;
    }

    public final AbstractC14721iN n() {
        return this.f;
    }

    protected final AbstractC14721iN o() {
        return this.e;
    }

    protected abstract void q(AbstractC14721iN abstractC14721iN);

    protected abstract void r();

    protected final void s(boolean z, AbstractC14721iN abstractC14721iN) {
        InterfaceC14603iB2 interfaceC14603iB2;
        if (AbstractC13042fc3.d(this.f, abstractC14721iN)) {
            if (!z || (interfaceC14603iB2 = this.a) == null) {
                return;
            }
            return;
        }
        if (C()) {
            this.j.a("AudioSwitch", "Current user selected AudioDevice = " + this.e);
            this.f = abstractC14721iN;
            if (this.b == c.ACTIVATED) {
                d();
            }
        }
        InterfaceC14603iB2 interfaceC14603iB22 = this.a;
        if (interfaceC14603iB22 != null) {
        }
    }

    public final void u(int i) {
        this.k.h(i);
    }

    public final void v(int i) {
        this.k.i(i);
    }

    public final void w(int i) {
        this.k.k(i);
    }

    public final void x(int i) {
        this.k.l(i);
    }

    public final void y(int i) {
        this.k.m(i);
    }

    public final void z(boolean z) {
        this.i = z;
    }

    public /* synthetic */ AbstractC24073y0(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, InterfaceC20791sc6 interfaceC20791sc6, boolean z, NI3 ni3, List list, C17083mN c17083mN, int i, ED1 ed1) {
        C17083mN c17083mN2;
        boolean z2 = (i & 8) != 0 ? true : z;
        NI3 c17386ms5 = (i & 16) != 0 ? new C17386ms5(z2) : ni3;
        if ((i & 64) != 0) {
            Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (systemService != null) {
                c17083mN2 = new C17083mN(context, c17386ms5, (AudioManager) systemService, null, null, onAudioFocusChangeListener, 24, null);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
            }
        } else {
            c17083mN2 = c17083mN;
        }
        this(context, onAudioFocusChangeListener, interfaceC20791sc6, z2, c17386ms5, list, c17083mN2);
    }
}
