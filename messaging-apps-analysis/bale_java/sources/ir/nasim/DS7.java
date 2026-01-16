package ir.nasim;

import android.gov.nist.core.Separators;
import android.net.Uri;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.tgwidgets.editor.messenger.video.MediaCodecVideoConvertor;
import java.io.File;

/* loaded from: classes5.dex */
public final class DS7 {
    private static final a m = new a(null);
    public static final int n = 8;
    private final C11458d25 a;
    private final long b;
    private final String c;
    private final String d;
    private final long e;
    private final long f;
    private final C7880To7 g;
    private final InterfaceC15419jZ0 h;
    private final InterfaceC18995pc1 i;
    private volatile boolean j;
    private InterfaceC13730gj3 k;
    private final InterfaceC20315ro1 l;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ DS7 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, DS7 ds7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = ds7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            ir.nasim.tgwidgets.editor.messenger.H hA;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C19406qI3.a("VideoCompress", "start: " + this.c, new Object[0]);
            C12889fL5 c12889fL5 = new C12889fL5();
            try {
                hA = AbstractC25148zo6.a(this.c);
            } catch (Exception e) {
                C19406qI3.a("VideoCompress", "failed:" + e.getMessage(), new Object[0]);
            }
            if (hA != null) {
                File file = new File(C4053Dm2.m("mp4"));
                C19406qI3.a("VideoCompress", "Start compressing video (estimatedSize: " + hA.p + Separators.RPAREN, new Object[0]);
                new MediaCodecVideoConvertor().b(this.c, file, hA.g, false, hA.h, hA.i, hA.k, hA.l, hA.n, hA.m, hA.j, hA.a, hA.b, hA.c, hA.c(), hA.t, hA.x, hA.y, hA.z, hA.B, hA.A, hA.r, null, hA.F, hA.G, hA.s, false, hA.D, hA.E);
                if (!this.d.j) {
                    c12889fL5.a = file;
                    DS7 ds7 = this.d;
                    if (ds7.j) {
                        ds7.f((File) c12889fL5.a);
                    } else {
                        ds7.i.b(((File) c12889fL5.a).length());
                        ds7.g((File) c12889fL5.a);
                    }
                    return C19938rB7.a;
                }
                this.d.f(file);
            } else {
                C19406qI3.b("VideoCompress", "Failed to find the codec.");
            }
            if (!this.d.j) {
                File file2 = new File(this.c);
                this.d.i.b(file2.length());
                this.d.g(file2);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public DS7(C11458d25 c11458d25, long j, String str, String str2, long j2, long j3, C7880To7 c7880To7, InterfaceC15419jZ0 interfaceC15419jZ0, InterfaceC18995pc1 interfaceC18995pc1) {
        AbstractC13042fc3.i(c11458d25, "currentPeer");
        AbstractC13042fc3.i(str, "caption");
        AbstractC13042fc3.i(str2, "mimeType");
        AbstractC13042fc3.i(interfaceC15419jZ0, "shareCallback");
        AbstractC13042fc3.i(interfaceC18995pc1, "compressCallback");
        this.a = c11458d25;
        this.b = j;
        this.c = str;
        this.d = str2;
        this.e = j2;
        this.f = j3;
        this.g = c7880To7;
        this.h = interfaceC15419jZ0;
        this.i = interfaceC18995pc1;
        this.l = AbstractC20906so1.a(C12366eV1.b().X(P17.b(null, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(File file) {
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            C19406qI3.b("VideoCompress", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(File file) {
        try {
            AbstractC5969Lp4.d().d3(this.a, this.e, Uri.fromFile(file), this.c, Long.valueOf(this.b), this.d, false, this.g).a(this.h);
        } catch (Exception e) {
            C19406qI3.b("VideoCompress", e.getMessage());
        }
    }

    public final void e() {
        C19406qI3.a("VideoCompress", "onCanceled", new Object[0]);
        this.j = true;
        InterfaceC13730gj3 interfaceC13730gj3 = this.k;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.i.a();
        AbstractC5969Lp4.d().z(this.a, AbstractC10360bX0.g(Long.valueOf(this.e)), AbstractC10360bX0.g(Long.valueOf(this.f)), true);
    }

    public final void h(String str) {
        AbstractC13042fc3.i(str, "videoFilePath");
        this.k = AbstractC10533bm0.d(this.l, null, null, new b(str, this, null), 3, null);
    }
}
