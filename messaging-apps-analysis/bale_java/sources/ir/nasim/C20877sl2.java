package ir.nasim;

import android.content.Context;
import java.util.Arrays;
import java.util.Locale;

/* renamed from: ir.nasim.sl2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C20877sl2 {
    public static final C20877sl2 a = new C20877sl2();

    private C20877sl2() {
    }

    public static final String a(Context context, int i) {
        AbstractC13042fc3.i(context, "context");
        return b(context, i);
    }

    public static final String b(Context context, long j) {
        AbstractC13042fc3.i(context, "context");
        float f = j;
        return f < 1024.0f ? AbstractC20655sN7.c(context, AbstractC12217eE5.all_file_size_unit_bytes, XY6.v(String.valueOf(j))) : f < 1048576.0f ? AbstractC20655sN7.c(context, AbstractC12217eE5.all_file_size_unit_kbytes, a.c(f / 1024.0f)) : f < 1.0737418E9f ? AbstractC20655sN7.c(context, AbstractC12217eE5.all_file_size_unit_mbytes, a.c(f / 1048576.0f)) : AbstractC20655sN7.c(context, AbstractC12217eE5.all_file_size_unit_gbytes, a.c(f / 1.0737418E9f));
    }

    private final String c(float f) {
        DY6 dy6 = DY6.a;
        String str = String.format(Locale.ENGLISH, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
        AbstractC13042fc3.h(str, "format(...)");
        return XY6.v(AbstractC20762sZ6.E0(str, ".0"));
    }
}
