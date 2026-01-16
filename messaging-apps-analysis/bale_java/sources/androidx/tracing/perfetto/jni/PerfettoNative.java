package androidx.tracing.perfetto.jni;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.C19327q96;
import ir.nasim.InterfaceC20234rg2;
import ir.nasim.InterfaceC22243uu1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0087 ¢\u0006\u0004\b\u0005\u0010\u0003J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0087 ¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004H\u0087 ¢\u0006\u0004\b\f\u0010\u0003J\u0010\u0010\r\u001a\u00020\bH\u0087 ¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0003J\u001d\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/tracing/perfetto/jni/PerfettoNative;", "", "<init>", "()V", "Lir/nasim/rB7;", "nativeRegisterWithPerfetto", "", "key", "", "traceInfo", "nativeTraceEventBegin", "(ILjava/lang/String;)V", "nativeTraceEventEnd", "nativeVersion", "()Ljava/lang/String;", "a", "Ljava/io/File;", "file", "Lir/nasim/q96;", "loader", "b", "(Ljava/io/File;Lir/nasim/q96;)V", "tracing-perfetto_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class PerfettoNative {
    public static final PerfettoNative a = new PerfettoNative();

    public static final class a {
        public static final a a = new a();
        private static final Map b = AbstractC20051rO3.n(AbstractC4616Fw7.a("arm64-v8a", "a152fbd7ebaa109a9c3cf6bbb6d585aa0df08f97ae022b2090b1096a8f5e2665"), AbstractC4616Fw7.a("armeabi-v7a", "b2821c9ddb77a3f070cce42be7cd3255d7ec92c868d7d518a99ed968d9018b9f"), AbstractC4616Fw7.a("x86", "4cefdc75fe41deeeb2306891c25ce4db33599698cc6fcb2e82caad5aece9aa09"), AbstractC4616Fw7.a("x86_64", "23daf0750238cf96bf9ea9fa1b13ae1d2eeb17644ea5439e18939ec6a8b9e5be"));

        private a() {
        }

        public final Map a() {
            return b;
        }
    }

    private PerfettoNative() {
    }

    public static final native void nativeRegisterWithPerfetto();

    @InterfaceC20234rg2
    public static final native void nativeTraceEventBegin(int key, String traceInfo);

    @InterfaceC22243uu1
    public static final native void nativeTraceEventEnd();

    public static final native String nativeVersion();

    public final void a() {
        System.loadLibrary("tracing_perfetto");
    }

    public final void b(File file, C19327q96 loader) throws FileNotFoundException {
        AbstractC13042fc3.i(file, "file");
        AbstractC13042fc3.i(loader, "loader");
        loader.f(file, a.a.a());
    }
}
