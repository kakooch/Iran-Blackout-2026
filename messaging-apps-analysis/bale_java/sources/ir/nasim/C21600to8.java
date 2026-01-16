package ir.nasim;

import android.net.Uri;
import android.util.LogPrinter;

/* renamed from: ir.nasim.to8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C21600to8 implements InterfaceC11394cv8 {
    private static final Uri b;
    private final LogPrinter a = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("local");
        b = builder.build();
    }

    @Override // ir.nasim.InterfaceC11394cv8
    public final Uri c() {
        return b;
    }
}
