package ir.nasim;

import android.content.Context;
import ir.nasim.AbstractC10086b33;
import java.io.Closeable;
import java.io.File;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;

/* renamed from: ir.nasim.d33, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11466d33 {

    /* renamed from: ir.nasim.d33$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Context e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context) {
            super(0);
            this.e = context;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            return AbstractC18638p.m(this.e);
        }
    }

    /* renamed from: ir.nasim.d33$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Context e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context) {
            super(0);
            this.e = context;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            return AbstractC18638p.m(this.e);
        }
    }

    public static final AbstractC10086b33 a(BufferedSource bufferedSource, Context context) {
        return new LH6(bufferedSource, new a(context), null);
    }

    public static final AbstractC10086b33 b(BufferedSource bufferedSource, Context context, AbstractC10086b33.a aVar) {
        return new LH6(bufferedSource, new b(context), aVar);
    }

    public static final AbstractC10086b33 c(Path path, FileSystem fileSystem, String str, Closeable closeable) {
        return new C22154ul2(path, fileSystem, str, closeable, null);
    }

    public static /* synthetic */ AbstractC10086b33 d(Path path, FileSystem fileSystem, String str, Closeable closeable, int i, Object obj) {
        if ((i & 2) != 0) {
            fileSystem = FileSystem.SYSTEM;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            closeable = null;
        }
        return c(path, fileSystem, str, closeable);
    }
}
