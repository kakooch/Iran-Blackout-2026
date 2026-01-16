package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import ir.nasim.C25124zm2;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.um2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22164um2 implements InterfaceC20887sm2 {
    private static final a e = new a(null);
    private static final C20644sM5 f;
    private final Context a;
    private final SA2 b;
    private final String c;
    private final C25124zm2.b d;

    /* renamed from: ir.nasim.um2$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.um2$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NN6.values().length];
            try {
                iArr[NN6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NN6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NN6.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("[\\\\/:*?\"<>|\\x00-\\x1F]");
        AbstractC13042fc3.h(patternCompile, "compile(...)");
        f = new C20644sM5(patternCompile);
    }

    public C22164um2(Context context, SA2 sa2, String str, C25124zm2.b bVar) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(sa2, "randomNameGenerator");
        AbstractC13042fc3.i(str, "defaultExtension");
        AbstractC13042fc3.i(bVar, "fileSystemOutputFactory");
        this.a = context;
        this.b = sa2;
        this.c = str;
        this.d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e() {
        UUID uuidRandomUUID = UUID.randomUUID();
        return System.currentTimeMillis() + "_" + uuidRandomUUID;
    }

    private final String f(EnumC9082Yk2 enumC9082Yk2, NN6 nn6) {
        File cacheDir;
        int i = b.a[nn6.ordinal()];
        if (i == 1) {
            cacheDir = this.a.getCacheDir();
        } else if (i == 2) {
            cacheDir = this.a.getFilesDir();
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            cacheDir = this.a.getExternalFilesDir(null);
        }
        File file = new File(cacheDir, enumC9082Yk2.j());
        file.mkdirs();
        String absolutePath = file.getAbsolutePath();
        AbstractC13042fc3.h(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    private final String g(String str) {
        if (str == null || AbstractC20762sZ6.n0(str)) {
            return "";
        }
        String lowerCase = f.k(str, "_").toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return AbstractC20762sZ6.o1(lowerCase, '.', ' ', '_');
    }

    @Override // ir.nasim.InterfaceC20887sm2
    public String b(String str, EnumC9082Yk2 enumC9082Yk2, NN6 nn6) throws IOException {
        AbstractC13042fc3.i(str, "fileName");
        AbstractC13042fc3.i(enumC9082Yk2, "fileCategory");
        AbstractC13042fc3.i(nn6, "storageLocation");
        String strG = g(this.c);
        if (AbstractC20762sZ6.n0(strG)) {
            strG = this.c;
        }
        if (!AbstractC20762sZ6.n0(str)) {
            String string = AbstractC20762sZ6.n1(str).toString();
            int iQ0 = AbstractC20762sZ6.q0(string, '.', 0, false, 6, null);
            if (iQ0 >= 0 && iQ0 != string.length() - 1) {
                String strSubstring = string.substring(iQ0 + 1);
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                String strG2 = g(strSubstring);
                if (!(!AbstractC20762sZ6.n0(strG2))) {
                    strG2 = null;
                }
                if (strG2 != null) {
                    strG = strG2;
                }
            }
        }
        File file = new File(f(enumC9082Yk2, nn6), ((String) this.b.invoke()) + Separators.DOT + strG);
        file.createNewFile();
        String absolutePath = file.getAbsolutePath();
        AbstractC13042fc3.h(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    @Override // ir.nasim.InterfaceC20887sm2
    public InterfaceC23940xm2 c(long j, String str, boolean z) {
        AbstractC13042fc3.i(str, "filePath");
        return this.d.a(j, str, z, true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C22164um2(Context context, C25124zm2.b bVar) {
        this(context, new SA2() { // from class: ir.nasim.tm2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22164um2.e();
            }
        }, "bin", bVar);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(bVar, "fileSystemOutputFactory");
    }
}
