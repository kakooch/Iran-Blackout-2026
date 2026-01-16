package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: ir.nasim.jm0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15548jm0 extends AbstractC15276jJ1 implements InterfaceC14958im0 {
    public static final a n = new a(null);
    private final boolean m;

    /* renamed from: ir.nasim.jm0$a */
    public static final class a {
        private a() {
        }

        public final C15548jm0 a(C9424Zw2 c9424Zw2, ON6 on6, InterfaceC8507Wg4 interfaceC8507Wg4, InputStream inputStream, boolean z) throws IOException {
            AbstractC13042fc3.i(c9424Zw2, "fqName");
            AbstractC13042fc3.i(on6, "storageManager");
            AbstractC13042fc3.i(interfaceC8507Wg4, "module");
            AbstractC13042fc3.i(inputStream, "inputStream");
            try {
                C13166fm0 c13166fm0A = C13166fm0.g.a(inputStream);
                if (c13166fm0A == null) {
                    AbstractC13042fc3.y(ParameterNames.VERSION);
                    throw null;
                }
                if (c13166fm0A.h()) {
                    C8938Xw5 c8938Xw5A0 = C8938Xw5.a0(inputStream, C12530em0.n.e());
                    YV0.a(inputStream, null);
                    AbstractC13042fc3.h(c8938Xw5A0, "proto");
                    return new C15548jm0(c9424Zw2, on6, interfaceC8507Wg4, c8938Xw5A0, c13166fm0A, z, null);
                }
                throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + C13166fm0.h + ", actual " + c13166fm0A + ". Please update Kotlin");
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    YV0.a(inputStream, th);
                    throw th2;
                }
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C15548jm0(C9424Zw2 c9424Zw2, ON6 on6, InterfaceC8507Wg4 interfaceC8507Wg4, C8938Xw5 c8938Xw5, C13166fm0 c13166fm0, boolean z, ED1 ed1) {
        this(c9424Zw2, on6, interfaceC8507Wg4, c8938Xw5, c13166fm0, z);
    }

    private C15548jm0(C9424Zw2 c9424Zw2, ON6 on6, InterfaceC8507Wg4 interfaceC8507Wg4, C8938Xw5 c8938Xw5, C13166fm0 c13166fm0, boolean z) {
        super(c9424Zw2, on6, interfaceC8507Wg4, c8938Xw5, c13166fm0, null);
        this.m = z;
    }
}
