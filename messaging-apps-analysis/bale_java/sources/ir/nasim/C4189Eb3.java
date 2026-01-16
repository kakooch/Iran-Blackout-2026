package ir.nasim;

import android.content.Context;
import ir.nasim.BU1;
import java.io.File;

/* renamed from: ir.nasim.Eb3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4189Eb3 extends BU1 {

    /* renamed from: ir.nasim.Eb3$a */
    class a implements BU1.a {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // ir.nasim.BU1.a
        public File a() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.b != null ? new File(cacheDir, this.b) : cacheDir;
        }
    }

    public C4189Eb3(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public C4189Eb3(Context context, String str, long j) {
        super(new a(context, str), j);
    }
}
