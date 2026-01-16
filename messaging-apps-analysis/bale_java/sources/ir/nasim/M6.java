package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.G08;
import ir.nasim.M6;
import ir.nasim.R08;

/* loaded from: classes6.dex */
public final class M6 extends R08 {
    private static final a g = new a(null);
    public static final int h = 8;
    private C9528a7 b;
    private final R08.b c;
    private final InterfaceC14603iB2 d;
    private Long e;
    private final c f;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class c implements G08.g {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(M6 m6, long j) {
            AbstractC13042fc3.i(m6, "this$0");
            Long l = m6.e;
            if (l != null && j == l.longValue()) {
                m6.l().e(j);
                return;
            }
            C19406qI3.j("ABVoiceRecorder", "CurrentId(" + m6.e + ") is not the same as id(" + j + ") in onPaused()", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(M6 m6, long j, long j2) {
            AbstractC13042fc3.i(m6, "this$0");
            Long l = m6.e;
            if (l != null && j == l.longValue()) {
                R08.b.c(m6.l(), j, Long.valueOf(j2), null, 4, null);
                return;
            }
            C19406qI3.j("ABVoiceRecorder", "CurrentId(" + m6.e + ") is not the same as id(" + j + ") in onRecordCancel()", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(M6 m6, long j) {
            AbstractC13042fc3.i(m6, "this$0");
            Long l = m6.e;
            if (l != null && j == l.longValue()) {
                m6.l().b(j, null, new Exception("Failed to record voice."));
                return;
            }
            C19406qI3.j("ABVoiceRecorder", "CurrentId(" + m6.e + ") is not the same as id(" + j + ") in onRecordCrash()", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(long j, long j2, String str, M6 m6) {
            AbstractC13042fc3.i(m6, "this$0");
            if (j > 1000) {
                C19406qI3.a("ABVoiceRecorder", "onSendVoice(id: " + j2 + ", time: " + j + ", fileName: " + str + Separators.RPAREN, new Object[0]);
                m6.d.invoke(Long.valueOf(j), str);
            } else {
                C19406qI3.j("ABVoiceRecorder", "Ignoring the recorded file because of low duration(" + j + ")!!", new Object[0]);
            }
            Long l = m6.e;
            if (l != null && j2 == l.longValue()) {
                if (str != null) {
                    m6.l().m(j2, j);
                    return;
                } else {
                    m6.l().b(j2, Long.valueOf(j), new Exception("Output file was null"));
                    return;
                }
            }
            C19406qI3.j("ABVoiceRecorder", "CurrentId(" + m6.e + ") is not the same as id(" + j2 + ") in onRecordEnd()", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(M6 m6, long j, long j2) {
            AbstractC13042fc3.i(m6, "this$0");
            Long l = m6.e;
            if (l != null && j == l.longValue()) {
                m6.l().g(j, j2);
                return;
            }
            C19406qI3.j("ABVoiceRecorder", "CurrentId(" + m6.e + ") is not the same as id(" + j + ") in onRecordProgress()", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(M6 m6, long j) {
            AbstractC13042fc3.i(m6, "this$0");
            Long l = m6.e;
            if (l != null && j == l.longValue()) {
                m6.l().k(j);
                return;
            }
            C19406qI3.j("ABVoiceRecorder", "CurrentId(" + m6.e + ") is not the same as id(" + j + ") in onRecordStart()", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void u(M6 m6, long j, long j2) {
            AbstractC13042fc3.i(m6, "this$0");
            Long l = m6.e;
            if (l != null && j == l.longValue()) {
                m6.l().i(j, j2);
                return;
            }
            C19406qI3.j("ABVoiceRecorder", "CurrentId(" + m6.e + ") is not the same as id(" + j + ") in onResumed()", new Object[0]);
        }

        @Override // ir.nasim.G08.g
        public void a(final long j, final long j2, final String str) {
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            final M6 m6 = M6.this;
            aVar.F(new Runnable() { // from class: ir.nasim.R6
                @Override // java.lang.Runnable
                public final void run() {
                    M6.c.r(j2, j, str, m6);
                }
            });
        }

        @Override // ir.nasim.G08.g
        public void b(final long j) {
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            final M6 m6 = M6.this;
            aVar.F(new Runnable() { // from class: ir.nasim.S6
                @Override // java.lang.Runnable
                public final void run() {
                    M6.c.q(m6, j);
                }
            });
        }

        @Override // ir.nasim.G08.g
        public void c(final long j) {
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            final M6 m6 = M6.this;
            aVar.F(new Runnable() { // from class: ir.nasim.P6
                @Override // java.lang.Runnable
                public final void run() {
                    M6.c.t(m6, j);
                }
            });
        }

        @Override // ir.nasim.G08.g
        public void d(final long j, long j2, String str) {
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            final M6 m6 = M6.this;
            aVar.F(new Runnable() { // from class: ir.nasim.N6
                @Override // java.lang.Runnable
                public final void run() {
                    M6.c.o(m6, j);
                }
            });
        }

        @Override // ir.nasim.G08.g
        public void e(final long j, final long j2) {
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            final M6 m6 = M6.this;
            aVar.F(new Runnable() { // from class: ir.nasim.Q6
                @Override // java.lang.Runnable
                public final void run() {
                    M6.c.u(m6, j, j2);
                }
            });
        }

        @Override // ir.nasim.G08.g
        public void f(final long j, final long j2) {
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            final M6 m6 = M6.this;
            aVar.F(new Runnable() { // from class: ir.nasim.O6
                @Override // java.lang.Runnable
                public final void run() {
                    M6.c.p(m6, j, j2);
                }
            });
        }

        @Override // ir.nasim.G08.g
        public void g(final long j, final long j2) {
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            final M6 m6 = M6.this;
            aVar.F(new Runnable() { // from class: ir.nasim.T6
                @Override // java.lang.Runnable
                public final void run() {
                    M6.c.s(m6, j, j2);
                }
            });
        }
    }

    public M6(C9528a7 c9528a7, R08.b bVar, b bVar2, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(bVar, "listener");
        AbstractC13042fc3.i(bVar2, "voiceCaptureCallbackDelegator");
        AbstractC13042fc3.i(interfaceC14603iB2, "onSendVoice");
        this.b = c9528a7;
        this.c = bVar;
        this.d = interfaceC14603iB2;
        c cVar = new c();
        this.f = cVar;
        bVar2.h(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 i(Context context, b bVar) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(bVar, "$voiceCaptureCallbackDelegator");
        return new G08(context, bVar);
    }

    private final void m(String str) {
        C19406qI3.b("ABVoiceRecorder", "Ignoring the " + str + " call because of null currentId!!");
    }

    @Override // ir.nasim.R08
    public void a() {
        Long l = this.e;
        if (l == null) {
            m("cancelRecording");
            return;
        }
        long jLongValue = l.longValue();
        C19406qI3.a("ABVoiceRecorder", "cancelRecording(" + jLongValue + Separators.RPAREN, new Object[0]);
        C9528a7 c9528a7 = this.b;
        if (c9528a7 != null) {
            c9528a7.d(new G08.f(true, jLongValue));
        }
    }

    @Override // ir.nasim.R08
    public void b() {
        Long l = this.e;
        if (l == null) {
            m("pauseRecording");
            return;
        }
        long jLongValue = l.longValue();
        C19406qI3.a("ABVoiceRecorder", "pauseRecording(" + jLongValue + Separators.RPAREN, new Object[0]);
        C9528a7 c9528a7 = this.b;
        if (c9528a7 != null) {
            c9528a7.d(new G08.c(jLongValue));
        }
    }

    @Override // ir.nasim.R08
    public void c() {
        C19406qI3.a("ABVoiceRecorder", "release()", new Object[0]);
        C9528a7 c9528a7 = this.b;
        if (c9528a7 != null) {
            c9528a7.d(C12485eh5.a);
        }
        this.b = null;
        this.e = null;
    }

    @Override // ir.nasim.R08
    public void d() {
        Long l = this.e;
        if (l == null) {
            m("resumeRecording");
            return;
        }
        long jLongValue = l.longValue();
        C19406qI3.a("ABVoiceRecorder", "resumeRecording(" + jLongValue + Separators.RPAREN, new Object[0]);
        C9528a7 c9528a7 = this.b;
        if (c9528a7 != null) {
            c9528a7.d(new G08.d(jLongValue));
        }
    }

    @Override // ir.nasim.R08
    public long f() {
        long jK = AbstractC17026mG5.a.k();
        C19406qI3.a("ABVoiceRecorder", "startRecording(" + jK + Separators.RPAREN, new Object[0]);
        Long l = this.e;
        if (l != null) {
            long jLongValue = l.longValue();
            C9528a7 c9528a7 = this.b;
            if (c9528a7 != null) {
                c9528a7.d(new G08.f(true, jLongValue));
            }
        }
        this.e = Long.valueOf(jK);
        C9528a7 c9528a72 = this.b;
        if (c9528a72 != null) {
            c9528a72.d(new G08.e(jK));
        }
        return jK;
    }

    @Override // ir.nasim.R08
    public void g() {
        Long l = this.e;
        if (l == null) {
            m("stopRecording");
            return;
        }
        long jLongValue = l.longValue();
        C19406qI3.a("ABVoiceRecorder", "stopRecording(" + jLongValue + Separators.RPAREN, new Object[0]);
        C9528a7 c9528a7 = this.b;
        if (c9528a7 != null) {
            c9528a7.d(new G08.f(false, jLongValue));
        }
    }

    public R08.b l() {
        return this.c;
    }

    public static final class b implements G08.g {
        private G08.g a;

        public b(G08.g gVar) {
            this.a = gVar;
        }

        @Override // ir.nasim.G08.g
        public void a(long j, long j2, String str) {
            G08.g gVar = this.a;
            if (gVar != null) {
                gVar.a(j, j2, str);
            }
        }

        @Override // ir.nasim.G08.g
        public void b(long j) {
            G08.g gVar = this.a;
            if (gVar != null) {
                gVar.b(j);
            }
        }

        @Override // ir.nasim.G08.g
        public void c(long j) {
            G08.g gVar = this.a;
            if (gVar != null) {
                gVar.c(j);
            }
        }

        @Override // ir.nasim.G08.g
        public void d(long j, long j2, String str) {
            G08.g gVar = this.a;
            if (gVar != null) {
                gVar.d(j, j2, str);
            }
        }

        @Override // ir.nasim.G08.g
        public void e(long j, long j2) {
            G08.g gVar = this.a;
            if (gVar != null) {
                gVar.e(j, j2);
            }
        }

        @Override // ir.nasim.G08.g
        public void f(long j, long j2) {
            G08.g gVar = this.a;
            if (gVar != null) {
                gVar.f(j, j2);
            }
        }

        @Override // ir.nasim.G08.g
        public void g(long j, long j2) {
            G08.g gVar = this.a;
            if (gVar != null) {
                gVar.g(j, j2);
            }
        }

        public final void h(G08.g gVar) {
            this.a = gVar;
        }

        public /* synthetic */ b(G08.g gVar, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : gVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public M6(Context context, String str, R08.b bVar, InterfaceC14603iB2 interfaceC14603iB2) {
        this(context, str, bVar, interfaceC14603iB2, new b(null, 1, 0 == true ? 1 : 0));
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "uniqueId");
        AbstractC13042fc3.i(bVar, "listener");
        AbstractC13042fc3.i(interfaceC14603iB2, "onSendVoice");
    }

    private M6(final Context context, String str, R08.b bVar, InterfaceC14603iB2 interfaceC14603iB2, final b bVar2) {
        this(C12736f7.n().c(C4614Fw5.d(new V6() { // from class: ir.nasim.L6
            @Override // ir.nasim.V6
            public final K6 create() {
                return M6.i(context, bVar2);
            }
        }).a("D_voice_capture"), "actor/voice_capture__" + str), bVar, bVar2, interfaceC14603iB2);
    }
}
