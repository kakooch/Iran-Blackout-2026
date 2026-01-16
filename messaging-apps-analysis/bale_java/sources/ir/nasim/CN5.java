package ir.nasim;

import android.view.View;
import ir.nasim.AbstractC21649tt7;
import ir.nasim.AbstractC25199zt7;
import ir.nasim.AbstractC6718Or3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import livekit.org.webrtc.RtpReceiver;
import livekit.org.webrtc.VideoSink;
import livekit.org.webrtc.VideoTrack;

/* loaded from: classes3.dex */
public final class CN5 extends EV7 {
    private final boolean m;
    private final AbstractC13778go1 n;
    private InterfaceC20315ro1 o;
    private final Map p;
    private boolean q;
    private AbstractC21649tt7.e r;
    private RtpReceiver s;

    public interface a {
        CN5 a(String str, VideoTrack videoTrack, boolean z, RtpReceiver rtpReceiver);
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CN5.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C9080Yk0 c9080Yk0C = CN5.this.c();
                List list = this.d;
                this.b = 1;
                if (c9080Yk0C.d(list, this) == objE) {
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CN5(String str, VideoTrack videoTrack, boolean z, AbstractC13778go1 abstractC13778go1, RtpReceiver rtpReceiver, FF5 ff5) {
        super(str, videoTrack, ff5);
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(videoTrack, "rtcTrack");
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        AbstractC13042fc3.i(rtpReceiver, "receiver");
        AbstractC13042fc3.i(ff5, "rtcThreadToken");
        this.m = z;
        this.n = abstractC13778go1;
        this.o = AbstractC20906so1.a(abstractC13778go1.X(P17.b(null, 1, null)));
        this.p = new LinkedHashMap();
        this.r = new AbstractC21649tt7.e(0, 0);
        this.s = rtpReceiver;
    }

    private final Collection B() {
        return this.p.values();
    }

    private final boolean C() {
        boolean z;
        synchronized (this.p) {
            try {
                Collection collectionB = B();
                z = false;
                if (!(collectionB instanceof Collection) || !collectionB.isEmpty()) {
                    Iterator it = collectionB.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (((AbstractC10965cV7) it.next()).b()) {
                            z = true;
                            break;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    private final AbstractC21649tt7.e D() {
        int iMax;
        int iMax2;
        synchronized (this.p) {
            try {
                Iterator it = B().iterator();
                iMax = 0;
                iMax2 = 0;
                while (it.hasNext()) {
                    AbstractC21649tt7.e eVarD = ((AbstractC10965cV7) it.next()).d();
                    iMax = Math.max(iMax, eVarD.d());
                    iMax2 = Math.max(iMax2, eVarD.c());
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return new AbstractC21649tt7.e(iMax, iMax2);
    }

    private final void E() {
        boolean zC;
        AbstractC21649tt7.e eVarD;
        synchronized (this.p) {
            zC = C();
            eVarD = D();
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
        ArrayList arrayList = new ArrayList();
        if (zC != this.q) {
            this.q = zC;
            arrayList.add(new AbstractC25199zt7.c(this, zC));
        }
        if (!AbstractC13042fc3.d(eVarD, this.r)) {
            this.r = eVarD;
            arrayList.add(new AbstractC25199zt7.b(this, eVarD));
        }
        if (AbstractC15401jX0.f0(arrayList)) {
            AbstractC10533bm0.d(this.o, null, null, new b(arrayList, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(CN5 cn5, Observable observable, Object obj) {
        AbstractC13042fc3.i(cn5, "this$0");
        cn5.E();
    }

    public final boolean A() {
        return this.q;
    }

    @Override // ir.nasim.AbstractC21649tt7
    public void a() {
        super.a();
        AbstractC20906so1.d(this.o, null, 1, null);
    }

    @Override // ir.nasim.EV7, ir.nasim.AbstractC21649tt7
    public void q() {
        super.q();
        synchronized (this.p) {
            try {
                Iterator it = this.p.values().iterator();
                while (it.hasNext()) {
                    ((AbstractC10965cV7) it.next()).a();
                }
                this.p.clear();
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.EV7
    public void r(VideoSink videoSink) {
        AbstractC13042fc3.i(videoSink, "renderer");
        if (this.m && (videoSink instanceof View)) {
            w(videoSink, new C17190mY7((View) videoSink));
        } else {
            super.r(videoSink);
        }
    }

    @Override // ir.nasim.EV7
    public void u(VideoSink videoSink) {
        AbstractC10965cV7 abstractC10965cV7;
        AbstractC13042fc3.i(videoSink, "renderer");
        super.u(videoSink);
        synchronized (this.p) {
            abstractC10965cV7 = (AbstractC10965cV7) this.p.remove(videoSink);
        }
        if (abstractC10965cV7 != null) {
            abstractC10965cV7.a();
        }
        if (!this.m || abstractC10965cV7 == null) {
            return;
        }
        E();
    }

    public final void w(VideoSink videoSink, AbstractC10965cV7 abstractC10965cV7) {
        AbstractC13042fc3.i(videoSink, "renderer");
        AbstractC13042fc3.i(abstractC10965cV7, "visibility");
        super.r(videoSink);
        if (!this.m) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(null, "attempted to tracking video sink visibility on an non auto managed video track.", new Object[0]);
            return;
        }
        synchronized (this.p) {
            this.p.put(videoSink, abstractC10965cV7);
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
        abstractC10965cV7.addObserver(new Observer() { // from class: ir.nasim.BN5
            @Override // java.util.Observer
            public final void update(Observable observable, Object obj) {
                CN5.x(this.a, observable, obj);
            }
        });
        E();
    }

    public final boolean y() {
        return this.m;
    }

    public final AbstractC21649tt7.e z() {
        return this.r;
    }
}
