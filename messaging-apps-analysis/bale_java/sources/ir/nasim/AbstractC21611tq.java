package ir.nasim;

import android.graphics.Path;
import ir.nasim.V05;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.tq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21611tq {

    /* renamed from: ir.nasim.tq$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[V05.b.values().length];
            try {
                iArr[V05.b.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[V05.b.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final V05 a() {
        return new C19724qq(null, 1, 0 == true ? 1 : 0);
    }

    public static final V05 c(Path path) {
        return new C19724qq(path);
    }

    public static final void d(String str) {
        throw new IllegalStateException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Path.Direction e(V05.b bVar) {
        int i = a.a[bVar.ordinal()];
        if (i == 1) {
            return Path.Direction.CCW;
        }
        if (i == 2) {
            return Path.Direction.CW;
        }
        throw new NoWhenBranchMatchedException();
    }
}
