package ir.nasim.core.modules.file.audio.audiofocus;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.media.AudioManager;
import androidx.media.AudioAttributesCompat;
import androidx.media.a;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19406qI3;
import ir.nasim.ED1;
import ir.nasim.core.modules.file.audio.audiofocus.c;
import java.util.Stack;
import livekit.org.webrtc.MediaStreamTrack;

/* loaded from: classes5.dex */
public final class a implements AudioManager.OnAudioFocusChangeListener {
    public static final C0992a h = new C0992a(null);
    public static final int i = 8;
    private static a j;
    private final AudioManager a;
    private boolean b;
    private int c;
    private androidx.media.a d;
    private final a.b e;
    private final Stack f;
    private c g;

    /* renamed from: ir.nasim.core.modules.file.audio.audiofocus.a$a, reason: collision with other inner class name */
    public static final class C0992a {
        private C0992a() {
        }

        public final a a() {
            if (a.j == null) {
                throw new IllegalStateException("Instance has not been initialized");
            }
            a aVar = a.j;
            if (aVar != null) {
                return aVar;
            }
            AbstractC13042fc3.y("instance");
            return null;
        }

        public final a b(Context context) {
            AbstractC13042fc3.i(context, "context");
            if (a.j != null) {
                throw new IllegalStateException("Instance has been initialized before");
            }
            Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            a aVar = new a((AudioManager) systemService, null);
            a.j = aVar;
            return aVar;
        }

        public /* synthetic */ C0992a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ a(AudioManager audioManager, ED1 ed1) {
        this(audioManager);
    }

    private final boolean f(c.a aVar) {
        if (this.c == aVar.j() && this.b) {
            return true;
        }
        this.e.c(new AudioAttributesCompat.a().c(1).b(aVar.j()).a());
        androidx.media.a aVarA = this.e.a();
        this.d = aVarA;
        boolean z = androidx.media.b.b(this.a, aVarA) == 1;
        this.b = z;
        return z;
    }

    public final void c(c cVar) {
        AbstractC13042fc3.i(cVar, "owner");
        C19406qI3.a("AudioFocusManager", cVar + " lost focus", new Object[0]);
        cVar.p(c.b.a);
        this.f.remove(cVar);
        if (cVar == this.g) {
            this.g = null;
        }
        if (this.b) {
            if (!(!this.f.isEmpty())) {
                androidx.media.a aVar = this.d;
                if (aVar != null) {
                    androidx.media.b.a(this.a, aVar);
                }
                this.d = null;
                this.b = false;
                return;
            }
            c cVar2 = (c) this.f.peek();
            if (cVar2 == this.g || !f(cVar2.getContentType())) {
                return;
            }
            C19406qI3.a("AudioFocusManager", cVar + " regained focus", new Object[0]);
            cVar2.r();
            this.g = cVar2;
        }
    }

    public final boolean d(c cVar) {
        AbstractC13042fc3.i(cVar, "owner");
        return cVar == this.g;
    }

    public final void e(c cVar) {
        AbstractC13042fc3.i(cVar, "owner");
        c cVar2 = this.g;
        if (cVar2 == cVar) {
            C19406qI3.a("AudioFocusManager", cVar + " gained focus", new Object[0]);
            cVar.x();
            return;
        }
        if (cVar2 != null) {
            C19406qI3.a("AudioFocusManager", cVar2 + " lost focus", new Object[0]);
            cVar2.p(c.b.a);
            if (!cVar2.q()) {
                this.f.remove(cVar2);
            }
        }
        this.g = null;
        this.f.remove(cVar);
        this.f.push(cVar);
        if (f(cVar.getContentType())) {
            C19406qI3.a("AudioFocusManager", cVar + " gained focus", new Object[0]);
            cVar.x();
            this.g = cVar;
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i2) {
        C19406qI3.a("AudioFocusManager", "onAudioFocusChange(" + i2 + Separators.RPAREN, new Object[0]);
        if (i2 == -3) {
            c cVar = this.g;
            if (cVar != null) {
                C19406qI3.a("AudioFocusManager", cVar + " lost focus (duck)", new Object[0]);
            }
            c cVar2 = this.g;
            if (cVar2 != null) {
                cVar2.p(c.b.b);
            }
            this.g = null;
            this.b = false;
            return;
        }
        if (i2 == -2 || i2 == -1) {
            c cVar3 = this.g;
            if (cVar3 != null) {
                C19406qI3.a("AudioFocusManager", cVar3 + " lost focus", new Object[0]);
            }
            c cVar4 = this.g;
            if (cVar4 != null) {
                cVar4.p(c.b.a);
            }
            this.g = null;
            this.b = false;
            return;
        }
        if (i2 != 1) {
            return;
        }
        if (this.g == null && (!this.f.isEmpty())) {
            c cVar5 = (c) this.f.peek();
            C19406qI3.a("AudioFocusManager", cVar5 + " gained focus", new Object[0]);
            cVar5.r();
            this.g = cVar5;
        }
        this.b = true;
    }

    private a(AudioManager audioManager) {
        this.a = audioManager;
        a.b bVarG = new a.b(2).e(this).g(false);
        AbstractC13042fc3.h(bVarG, "setWillPauseWhenDucked(...)");
        this.e = bVarG;
        this.f = new Stack();
    }
}
