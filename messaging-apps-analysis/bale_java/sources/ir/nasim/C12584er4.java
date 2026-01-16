package ir.nasim;

import android.content.Context;
import android.util.Pair;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

/* renamed from: ir.nasim.er4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C12584er4 {
    private final C6461Nq4 a;
    private final ZK3 b;

    /* renamed from: ir.nasim.er4$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC19677ql2.values().length];
            a = iArr;
            try {
                iArr[EnumC19677ql2.ZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC19677ql2.GZIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C12584er4(C6461Nq4 c6461Nq4, ZK3 zk3) {
        this.a = c6461Nq4;
        this.b = zk3;
    }

    private C23677xK3 a(Context context, String str, String str2) {
        C6461Nq4 c6461Nq4;
        Pair pairA;
        C10255bL3 c10255bL3J;
        if (str2 == null || (c6461Nq4 = this.a) == null || (pairA = c6461Nq4.a(str)) == null) {
            return null;
        }
        EnumC19677ql2 enumC19677ql2 = (EnumC19677ql2) pairA.first;
        InputStream inputStream = (InputStream) pairA.second;
        int i = a.a[enumC19677ql2.ordinal()];
        if (i == 1) {
            c10255bL3J = JK3.J(context, new ZipInputStream(inputStream), str2);
        } else if (i != 2) {
            c10255bL3J = JK3.s(inputStream, str2);
        } else {
            try {
                c10255bL3J = JK3.s(new GZIPInputStream(inputStream), str2);
            } catch (IOException e) {
                c10255bL3J = new C10255bL3((Throwable) e);
            }
        }
        if (c10255bL3J.b() != null) {
            return (C23677xK3) c10255bL3J.b();
        }
        return null;
    }

    private C10255bL3 b(Context context, String str, String str2) throws IOException {
        JI3.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                TK3 tk3A = this.b.a(str);
                if (!tk3A.isSuccessful()) {
                    C10255bL3 c10255bL3 = new C10255bL3((Throwable) new IllegalArgumentException(tk3A.q1()));
                    try {
                        tk3A.close();
                    } catch (IOException e) {
                        JI3.d("LottieFetchResult close failed ", e);
                    }
                    return c10255bL3;
                }
                C10255bL3 c10255bL3E = e(context, str, tk3A.u0(), tk3A.o0(), str2);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(c10255bL3E.b() != null);
                JI3.a(sb.toString());
                try {
                    tk3A.close();
                } catch (IOException e2) {
                    JI3.d("LottieFetchResult close failed ", e2);
                }
                return c10255bL3E;
            } catch (Exception e3) {
                C10255bL3 c10255bL32 = new C10255bL3((Throwable) e3);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e4) {
                        JI3.d("LottieFetchResult close failed ", e4);
                    }
                }
                return c10255bL32;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e5) {
                    JI3.d("LottieFetchResult close failed ", e5);
                }
            }
            throw th;
        }
    }

    private C10255bL3 d(String str, InputStream inputStream, String str2) {
        C6461Nq4 c6461Nq4;
        return (str2 == null || (c6461Nq4 = this.a) == null) ? JK3.s(new GZIPInputStream(inputStream), null) : JK3.s(new GZIPInputStream(new FileInputStream(c6461Nq4.g(str, inputStream, EnumC19677ql2.GZIP))), str);
    }

    private C10255bL3 e(Context context, String str, InputStream inputStream, String str2, String str3) throws NoSuchAlgorithmException {
        C10255bL3 c10255bL3G;
        EnumC19677ql2 enumC19677ql2;
        C6461Nq4 c6461Nq4;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            JI3.a("Handling zip response.");
            EnumC19677ql2 enumC19677ql22 = EnumC19677ql2.ZIP;
            c10255bL3G = g(context, str, inputStream, str3);
            enumC19677ql2 = enumC19677ql22;
        } else if (str2.contains("application/gzip") || str2.contains("application/x-gzip") || str.split("\\?")[0].endsWith(".tgs")) {
            JI3.a("Handling gzip response.");
            enumC19677ql2 = EnumC19677ql2.GZIP;
            c10255bL3G = d(str, inputStream, str3);
        } else {
            JI3.a("Received json response.");
            enumC19677ql2 = EnumC19677ql2.JSON;
            c10255bL3G = f(str, inputStream, str3);
        }
        if (str3 != null && c10255bL3G.b() != null && (c6461Nq4 = this.a) != null) {
            c6461Nq4.f(str, enumC19677ql2);
        }
        return c10255bL3G;
    }

    private C10255bL3 f(String str, InputStream inputStream, String str2) {
        C6461Nq4 c6461Nq4;
        return (str2 == null || (c6461Nq4 = this.a) == null) ? JK3.s(inputStream, null) : JK3.s(new FileInputStream(c6461Nq4.g(str, inputStream, EnumC19677ql2.JSON).getAbsolutePath()), str);
    }

    private C10255bL3 g(Context context, String str, InputStream inputStream, String str2) {
        C6461Nq4 c6461Nq4;
        return (str2 == null || (c6461Nq4 = this.a) == null) ? JK3.J(context, new ZipInputStream(inputStream), null) : JK3.J(context, new ZipInputStream(new FileInputStream(c6461Nq4.g(str, inputStream, EnumC19677ql2.ZIP))), str);
    }

    public C10255bL3 c(Context context, String str, String str2) {
        C23677xK3 c23677xK3A = a(context, str, str2);
        if (c23677xK3A != null) {
            return new C10255bL3(c23677xK3A);
        }
        JI3.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(context, str, str2);
    }
}
