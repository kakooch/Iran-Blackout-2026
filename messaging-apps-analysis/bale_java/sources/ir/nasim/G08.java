package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.media.AudioRecord;
import android.os.SystemClock;
import android.os.Vibrator;
import ir.nasim.LL4;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.File;

/* loaded from: classes6.dex */
public class G08 extends K6 {
    private static final a o = new a(null);
    public static final int p = 8;
    private final Context f;
    private g g;
    private int h;
    private AudioRecord i;
    private C9528a7 j;
    private long k;
    private long l;
    private String m;
    private Long n;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b {
        private final long a;

        public b(long j) {
            this.a = j;
        }

        public final long a() {
            return this.a;
        }
    }

    public static final class c {
        private final long a;

        public c(long j) {
            this.a = j;
        }

        public final long a() {
            return this.a;
        }
    }

    public static final class d {
        private final long a;

        public d(long j) {
            this.a = j;
        }

        public final long a() {
            return this.a;
        }
    }

    public static final class e {
        private final long a;

        public e(long j) {
            this.a = j;
        }

        public final long a() {
            return this.a;
        }
    }

    public static final class f {
        private final boolean a;
        private final long b;

        public f(boolean z, long j) {
            this.a = z;
            this.b = j;
        }

        public final long a() {
            return this.b;
        }

        public final boolean b() {
            return this.a;
        }
    }

    public interface g {
        void a(long j, long j2, String str);

        void b(long j);

        void c(long j);

        void d(long j, long j2, String str);

        void e(long j, long j2);

        void f(long j, long j2);

        void g(long j, long j2);
    }

    public G08(Context context, g gVar) {
        AbstractC13042fc3.i(context, "context");
        this.f = context;
        this.g = gVar;
    }

    private final String C(String str) {
        String strP = C4053Dm2.p();
        if (strP == null) {
            return null;
        }
        return new File(strP, str).getAbsolutePath();
    }

    private final void D(long j) throws IllegalStateException {
        C19406qI3.b("VoiceCapture", "onCrashMessage(state: " + this.h + ", id: " + j + Separators.RPAREN);
        AudioRecord audioRecord = this.i;
        if (audioRecord != null) {
            if (audioRecord != null) {
                audioRecord.stop();
            }
            AudioRecord audioRecord2 = this.i;
            if (audioRecord2 != null) {
                audioRecord2.release();
            }
            this.i = null;
        }
        C9528a7 c9528a7 = this.j;
        if (c9528a7 != null && c9528a7 != null) {
            c9528a7.d(new LL4.d());
        }
        g gVar = this.g;
        if (gVar != null) {
            gVar.b(j);
        }
        this.h = 0;
        this.n = null;
    }

    private final void E(long j) throws IllegalStateException {
        int i = this.h;
        if (i != 1) {
            C19406qI3.j("VoiceCapture", "onPauseMessage called when there is nothing to pause!!", new Object[0]);
            return;
        }
        C19406qI3.a("VoiceCapture", "onResumeMessage(state: " + i + ", id: " + j + Separators.RPAREN, new Object[0]);
        this.h = 2;
        AudioRecord audioRecord = this.i;
        if (audioRecord != null) {
            audioRecord.stop();
        }
        g gVar = this.g;
        if (gVar != null) {
            gVar.d(j, this.k, this.m);
        }
    }

    private final void F(long j) throws IllegalStateException {
        int i = this.h;
        if (i != 2) {
            C19406qI3.j("VoiceCapture", "onResumedMessage called when there is nothing to resume!!", new Object[0]);
            return;
        }
        C19406qI3.a("VoiceCapture", "onResumeMessage(state: " + i + ", id: " + j + Separators.RPAREN, new Object[0]);
        this.h = 1;
        AudioRecord audioRecord = this.i;
        if (audioRecord != null) {
            audioRecord.startRecording();
        }
        this.l = SystemClock.uptimeMillis();
        K(this.f);
        C9528a7 c9528a7 = this.j;
        if (c9528a7 != null) {
            c9528a7.d(new LL4.b());
        }
        g gVar = this.g;
        if (gVar != null) {
            gVar.e(j, this.k);
        }
    }

    private final void G(final long j) throws IllegalStateException {
        C19406qI3.a("VoiceCapture", "onStartMessage(state: " + this.h + ", id: " + j + Separators.RPAREN, new Object[0]);
        if (this.h == 1) {
            C19406qI3.j("VoiceCapture", "Already started", new Object[0]);
            return;
        }
        final String strC = C("voice_msg_" + AbstractC17026mG5.a.k() + ".opus");
        if (strC == null) {
            C19406qI3.b("VoiceCapture", "onStartMessage: AudioFIleName is null");
            r().d(new b(j));
            this.m = null;
            return;
        }
        this.n = Long.valueOf(j);
        this.m = strC;
        final AudioRecord audioRecord = new AudioRecord(1, 16000, 16, 2, AudioRecord.getMinBufferSize(16000, 16, 2) * 16);
        audioRecord.startRecording();
        this.i = audioRecord;
        this.j = C12736f7.n().c(C4614Fw5.d(new V6() { // from class: ir.nasim.E08
            @Override // ir.nasim.V6
            public final K6 create() {
                return G08.H(strC, audioRecord, this, j);
            }
        }), "actor/opus_encoder");
        this.h = 1;
        g gVar = this.g;
        if (gVar != null) {
            gVar.c(j);
        }
        this.k = 0L;
        this.l = SystemClock.uptimeMillis();
        K(this.f);
        C9528a7 c9528a7 = this.j;
        if (c9528a7 != null) {
            c9528a7.d(new LL4.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 H(String str, AudioRecord audioRecord, final G08 g08, final long j) {
        AbstractC13042fc3.i(audioRecord, "$audioRecord");
        AbstractC13042fc3.i(g08, "this$0");
        return new LL4(str, audioRecord, new SA2() { // from class: ir.nasim.F08
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return G08.I(this.a, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I(G08 g08, long j) {
        AbstractC13042fc3.i(g08, "this$0");
        Long l = g08.n;
        if (l == null || l.longValue() != j) {
            return C19938rB7.a;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j2 = g08.k + (jUptimeMillis - g08.l);
        g08.k = j2;
        g gVar = g08.g;
        if (gVar != null) {
            gVar.g(j, j2);
        }
        g08.l = jUptimeMillis;
        C19406qI3.a("VoiceCapture", "OnProgress(totalDuration: " + g08.k + ", previousCountedTime: " + jUptimeMillis + Separators.RPAREN, new Object[0]);
        g gVar2 = g08.g;
        if (gVar2 != null) {
            gVar2.g(j, g08.k);
        }
        return C19938rB7.a;
    }

    private final void J(long j, boolean z) throws IllegalStateException {
        C19406qI3.a("VoiceCapture", "onStopMessage(state: " + this.h + ", id: " + j + ", cancel: " + z + Separators.RPAREN, new Object[0]);
        if (this.h == 0) {
            C19406qI3.j("VoiceCapture", "Already stopped!", new Object[0]);
            return;
        }
        this.n = null;
        AudioRecord audioRecord = this.i;
        if (audioRecord != null) {
            audioRecord.stop();
        }
        this.i = null;
        C9528a7 c9528a7 = this.j;
        if (c9528a7 != null) {
            c9528a7.d(new LL4.d());
        }
        long jUptimeMillis = this.k + (SystemClock.uptimeMillis() - this.l);
        this.k = jUptimeMillis;
        if (z) {
            g gVar = this.g;
            if (gVar != null) {
                gVar.f(j, jUptimeMillis);
            }
        } else {
            g gVar2 = this.g;
            if (gVar2 != null) {
                gVar2.a(j, jUptimeMillis, this.m);
            }
        }
        this.h = 0;
    }

    private final void K(Context context) {
        try {
            Object systemService = context.getSystemService("vibrator");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            ((Vibrator) systemService).vibrate(20L);
        } catch (Exception e2) {
            C19406qI3.c("VoiceCapture", "Failed to vibrate", e2);
        }
    }

    @Override // ir.nasim.K6
    public void m(Object obj) throws IllegalStateException {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof e) {
            G(((e) obj).a());
            return;
        }
        if (obj instanceof d) {
            F(((d) obj).a());
            return;
        }
        if (obj instanceof c) {
            E(((c) obj).a());
            return;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            J(fVar.a(), fVar.b());
        } else if (obj instanceof b) {
            D(((b) obj).a());
        }
    }

    @Override // ir.nasim.K6
    public void n() {
        C19406qI3.a("VoiceCapture", "postStop()", new Object[0]);
        super.n();
        this.g = null;
    }
}
