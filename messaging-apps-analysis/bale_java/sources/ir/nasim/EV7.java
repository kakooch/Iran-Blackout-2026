package ir.nasim;

import ir.nasim.AbstractC21649tt7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import livekit.org.webrtc.VideoSink;
import livekit.org.webrtc.VideoTrack;

/* loaded from: classes3.dex */
public abstract class EV7 extends AbstractC21649tt7 {
    private final VideoTrack k;
    private final List l;

    public static final class a implements Callable {
        final /* synthetic */ FF5 a;
        final /* synthetic */ AbstractC21649tt7 b;
        final /* synthetic */ Object c;
        final /* synthetic */ EV7 d;
        final /* synthetic */ VideoSink e;

        public a(FF5 ff5, AbstractC21649tt7 abstractC21649tt7, Object obj, EV7 ev7, VideoSink videoSink) {
            this.a = ff5;
            this.b = abstractC21649tt7;
            this.c = obj;
            this.d = ev7;
            this.e = videoSink;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            if (this.a.a()) {
                return null;
            }
            if (this.b.j()) {
                return this.c;
            }
            this.b.h();
            this.d.t().add(this.e);
            this.d.h().addSink(this.e);
            return C19938rB7.a;
        }
    }

    public static final class b implements Callable {
        final /* synthetic */ FF5 a;
        final /* synthetic */ EV7 b;
        final /* synthetic */ VideoSink c;

        public b(FF5 ff5, EV7 ev7, VideoSink videoSink) {
            this.a = ff5;
            this.b = ev7;
            this.c = videoSink;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            if (this.a.a()) {
                return null;
            }
            if (!this.b.j()) {
                this.b.h().removeSink(this.c);
            }
            return Boolean.valueOf(this.b.t().remove(this.c));
        }
    }

    public static final class c implements Callable {
        final /* synthetic */ FF5 a;
        final /* synthetic */ EV7 b;

        public c(FF5 ff5, EV7 ev7) {
            this.a = ff5;
            this.b = ev7;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            if (this.a.a()) {
                return null;
            }
            if (!this.b.j()) {
                Iterator it = this.b.t().iterator();
                while (it.hasNext()) {
                    this.b.h().removeSink((VideoSink) it.next());
                }
            }
            this.b.t().clear();
            return C19938rB7.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EV7(String str, VideoTrack videoTrack, FF5 ff5) {
        super(str, AbstractC21649tt7.f.c, videoTrack, ff5);
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(videoTrack, "rtcTrack");
        AbstractC13042fc3.i(ff5, "rtcThreadToken");
        this.k = videoTrack;
        this.l = new ArrayList();
    }

    @Override // ir.nasim.AbstractC21649tt7
    public void q() {
        FF5 ff5G = g();
        if (!ff5G.a()) {
            String name = Thread.currentThread().getName();
            AbstractC13042fc3.h(name, "getName(...)");
            if (AbstractC20153rZ6.S(name, "LK_RTC_THREAD", false, 2, null)) {
                if (!j()) {
                    Iterator it = t().iterator();
                    while (it.hasNext()) {
                        h().removeSink((VideoSink) it.next());
                    }
                }
                t().clear();
            } else {
                IF5.b.submit(new c(ff5G, this)).get();
            }
        }
        super.q();
    }

    public void r(VideoSink videoSink) {
        AbstractC13042fc3.i(videoSink, "renderer");
        C19938rB7 c19938rB7 = C19938rB7.a;
        if (j()) {
            return;
        }
        FF5 ff5G = g();
        if (ff5G.a()) {
            return;
        }
        String name = Thread.currentThread().getName();
        AbstractC13042fc3.h(name, "getName(...)");
        if (!AbstractC20153rZ6.S(name, "LK_RTC_THREAD", false, 2, null)) {
            IF5.b.submit(new a(ff5G, this, c19938rB7, this, videoSink)).get();
        } else {
            if (j()) {
                return;
            }
            h();
            t().add(videoSink);
            h().addSink(videoSink);
        }
    }

    @Override // ir.nasim.AbstractC21649tt7
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public VideoTrack h() {
        return this.k;
    }

    protected final List t() {
        return this.l;
    }

    public void u(VideoSink videoSink) {
        AbstractC13042fc3.i(videoSink, "renderer");
        FF5 ff5G = g();
        if (ff5G.a()) {
            return;
        }
        String name = Thread.currentThread().getName();
        AbstractC13042fc3.h(name, "getName(...)");
        if (!AbstractC20153rZ6.S(name, "LK_RTC_THREAD", false, 2, null)) {
            IF5.b.submit(new b(ff5G, this, videoSink)).get();
            return;
        }
        if (!j()) {
            h().removeSink(videoSink);
        }
        t().remove(videoSink);
    }
}
