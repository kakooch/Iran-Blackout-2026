package ir.nasim;

import android.util.Log;
import ir.nasim.AU1;
import ir.nasim.InterfaceC21989uU1;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public class CU1 implements InterfaceC21989uU1 {
    private final File b;
    private final long c;
    private AU1 e;
    private final C23765xU1 d = new C23765xU1();
    private final C18736p96 a = new C18736p96();

    protected CU1(File file, long j) {
        this.b = file;
        this.c = j;
    }

    public static InterfaceC21989uU1 c(File file, long j) {
        return new CU1(file, j);
    }

    private synchronized AU1 d() {
        try {
            if (this.e == null) {
                this.e = AU1.H(this.b, 1, 1, this.c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.e;
    }

    @Override // ir.nasim.InterfaceC21989uU1
    public File a(InterfaceC14373ho3 interfaceC14373ho3) {
        String strB = this.a.b(interfaceC14373ho3);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strB + " for for Key: " + interfaceC14373ho3);
        }
        try {
            AU1.e eVarZ = d().z(strB);
            if (eVarZ != null) {
                return eVarZ.a(0);
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }

    @Override // ir.nasim.InterfaceC21989uU1
    public void b(InterfaceC14373ho3 interfaceC14373ho3, InterfaceC21989uU1.b bVar) {
        AU1 au1D;
        String strB = this.a.b(interfaceC14373ho3);
        this.d.a(strB);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strB + " for for Key: " + interfaceC14373ho3);
            }
            try {
                au1D = d();
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
            if (au1D.z(strB) != null) {
                return;
            }
            AU1.c cVarS = au1D.s(strB);
            if (cVarS == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + strB);
            }
            try {
                if (bVar.a(cVarS.f(0))) {
                    cVarS.e();
                }
                cVarS.b();
            } catch (Throwable th) {
                cVarS.b();
                throw th;
            }
        } finally {
            this.d.b(strB);
        }
    }
}
