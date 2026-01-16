package ir.nasim;

import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.exoplayer2.z0;
import ir.nasim.core.modules.file.audio.audiofocus.a;
import ir.nasim.core.modules.file.audio.audiofocus.c;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Vd2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C8244Vd2 implements ir.nasim.core.modules.file.audio.audiofocus.c, z0.d {
    private final c.a a;
    private final boolean b;
    private final boolean c;
    private boolean d;
    private InterfaceC2037k e;

    /* renamed from: ir.nasim.Vd2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.b.values().length];
            try {
                iArr[c.b.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c.b.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public C8244Vd2(c.a aVar, boolean z) {
        AbstractC13042fc3.i(aVar, "contentType");
        this.a = aVar;
        this.b = z;
        this.c = z;
    }

    public final void a(InterfaceC2037k interfaceC2037k) {
        AbstractC13042fc3.i(interfaceC2037k, "exoPlayer");
        this.e = interfaceC2037k;
        interfaceC2037k.m0(this);
    }

    public final void e() {
        this.d = false;
        InterfaceC2037k interfaceC2037k = this.e;
        if (interfaceC2037k != null) {
            interfaceC2037k.o(this);
        }
        this.e = null;
    }

    @Override // ir.nasim.core.modules.file.audio.audiofocus.c
    public c.a getContentType() {
        return this.a;
    }

    @Override // ir.nasim.core.modules.file.audio.audiofocus.c
    public void p(c.b bVar) {
        AbstractC13042fc3.i(bVar, "lossType");
        InterfaceC2037k interfaceC2037k = this.e;
        boolean z = false;
        if (interfaceC2037k != null && interfaceC2037k.X()) {
            z = true;
        }
        this.d = z;
        int i = a.a[bVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC2037k interfaceC2037k2 = this.e;
            if (interfaceC2037k2 != null) {
                interfaceC2037k2.g(0.5f);
                return;
            }
            return;
        }
        InterfaceC2037k interfaceC2037k3 = this.e;
        if (interfaceC2037k3 != null) {
            interfaceC2037k3.g(0.0f);
        }
        InterfaceC2037k interfaceC2037k4 = this.e;
        if (interfaceC2037k4 != null) {
            interfaceC2037k4.h();
        }
    }

    @Override // ir.nasim.core.modules.file.audio.audiofocus.c
    public boolean q() {
        return this.c;
    }

    @Override // ir.nasim.core.modules.file.audio.audiofocus.c
    public void r() {
        super.r();
        if (this.b && this.d) {
            this.d = false;
            InterfaceC2037k interfaceC2037k = this.e;
            if (interfaceC2037k != null) {
                interfaceC2037k.q();
            }
        }
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void r5(boolean z) {
        if (z) {
            a.C0992a c0992a = ir.nasim.core.modules.file.audio.audiofocus.a.h;
            if (c0992a.a().d(this)) {
                return;
            }
            c0992a.a().e(this);
        }
    }

    @Override // ir.nasim.core.modules.file.audio.audiofocus.c
    public void x() {
        InterfaceC2037k interfaceC2037k = this.e;
        if (interfaceC2037k != null) {
            interfaceC2037k.g(1.0f);
        }
    }

    public /* synthetic */ C8244Vd2(c.a aVar, boolean z, int i, ED1 ed1) {
        this(aVar, (i & 2) != 0 ? false : z);
    }
}
