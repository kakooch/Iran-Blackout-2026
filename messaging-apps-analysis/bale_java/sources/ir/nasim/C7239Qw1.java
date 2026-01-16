package ir.nasim;

import java.nio.ByteBuffer;
import livekit.org.webrtc.AudioProcessingFactory;
import livekit.org.webrtc.ExternalAudioProcessingFactory;

/* renamed from: ir.nasim.Qw1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C7239Qw1 implements InterfaceC12937fR {
    static final /* synthetic */ InterfaceC5239Im3[] f = {AbstractC10882cM5.f(new C5942Lm4(C7239Qw1.class, "capturePostProcessor", "getCapturePostProcessor()Lio/livekit/android/audio/AudioProcessorInterface;", 0)), AbstractC10882cM5.f(new C5942Lm4(C7239Qw1.class, "renderPreProcessor", "getRenderPreProcessor()Lio/livekit/android/audio/AudioProcessorInterface;", 0)), AbstractC10882cM5.f(new C5942Lm4(C7239Qw1.class, "bypassCapturePostProcessing", "getBypassCapturePostProcessing()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(C7239Qw1.class, "bypassRenderPreProcessing", "getBypassRenderPreProcessing()Z", 0))};
    private final ExternalAudioProcessingFactory a;
    private final C9927an4 b;
    private final C9927an4 c;
    private final C9927an4 d;
    private final C9927an4 e;

    /* renamed from: ir.nasim.Qw1$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        b() {
            super(2);
        }

        public final void a(boolean z, boolean z2) {
            C7239Qw1.this.a.setBypassFlagForCapturePost(z);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Qw1$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        c() {
            super(2);
        }

        public final void a(boolean z, boolean z2) {
            C7239Qw1.this.a.setBypassFlagForRenderPre(z);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Qw1$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        d() {
            super(2);
        }

        public final void a(BO bo, BO bo2) {
            C7239Qw1.this.a.setCapturePostProcessing(C7239Qw1.this.l(bo));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            AbstractC18350oW3.a(obj);
            AbstractC18350oW3.a(obj2);
            a(null, null);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Qw1$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        e() {
            super(2);
        }

        public final void a(BO bo, BO bo2) {
            C7239Qw1.this.a.setRenderPreProcessing(C7239Qw1.this.l(bo));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            AbstractC18350oW3.a(obj);
            AbstractC18350oW3.a(obj2);
            a(null, null);
            return C19938rB7.a;
        }
    }

    public C7239Qw1() {
        this.a = new ExternalAudioProcessingFactory();
        this.b = AbstractC5508Jq2.a(null, new d());
        this.c = AbstractC5508Jq2.a(null, new e());
        Boolean bool = Boolean.FALSE;
        this.d = AbstractC5508Jq2.a(bool, new b());
        this.e = AbstractC5508Jq2.a(bool, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExternalAudioProcessingFactory.AudioProcessing l(BO bo) {
        return new a(bo);
    }

    @Override // ir.nasim.InterfaceC24893zO
    public BO a() {
        AbstractC18350oW3.a(this.b.h(this, f[0]));
        return null;
    }

    @Override // ir.nasim.InterfaceC12937fR
    public void b(String str, String str2) {
        AbstractC13042fc3.i(str, "url");
        AbstractC13042fc3.i(str2, "token");
        a();
        g();
    }

    @Override // ir.nasim.InterfaceC24893zO
    public boolean c() {
        return ((Boolean) this.d.h(this, f[2])).booleanValue();
    }

    public final AudioProcessingFactory f() {
        return this.a;
    }

    public BO g() {
        AbstractC18350oW3.a(this.c.h(this, f[1]));
        return null;
    }

    public void h(boolean z) {
        this.d.i(this, f[2], Boolean.valueOf(z));
    }

    public void i(boolean z) {
        this.e.i(this, f[3], Boolean.valueOf(z));
    }

    public void j(BO bo) {
        this.b.i(this, f[0], bo);
    }

    public void k(BO bo) {
        this.c.i(this, f[1], bo);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C7239Qw1(CO co) {
        this();
        AbstractC13042fc3.i(co, "audioProcessorOptions");
        co.b();
        j(null);
        co.d();
        k(null);
        h(co.a());
        i(co.c());
    }

    /* renamed from: ir.nasim.Qw1$a */
    private static final class a implements ExternalAudioProcessingFactory.AudioProcessing {
        public a(BO bo) {
        }

        @Override // livekit.org.webrtc.ExternalAudioProcessingFactory.AudioProcessing
        public void reset(int i) {
        }

        @Override // livekit.org.webrtc.ExternalAudioProcessingFactory.AudioProcessing
        public void initialize(int i, int i2) {
        }

        @Override // livekit.org.webrtc.ExternalAudioProcessingFactory.AudioProcessing
        public void process(int i, int i2, ByteBuffer byteBuffer) {
        }
    }
}
