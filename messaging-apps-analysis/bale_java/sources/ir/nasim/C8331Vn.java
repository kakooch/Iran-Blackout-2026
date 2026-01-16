package ir.nasim;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;

/* renamed from: ir.nasim.Vn, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8331Vn implements JV0 {
    private final ClipboardManager a;

    public C8331Vn(ClipboardManager clipboardManager) {
        this.a = clipboardManager;
    }

    @Override // ir.nasim.JV0
    public C13245fu a() {
        ClipData primaryClip = this.a.getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            return null;
        }
        ClipData.Item itemAt = primaryClip.getItemAt(0);
        return AbstractC8565Wn.a(itemAt != null ? itemAt.getText() : null);
    }

    @Override // ir.nasim.JV0
    public void b(C13245fu c13245fu) {
        this.a.setPrimaryClip(ClipData.newPlainText("plain text", AbstractC8565Wn.b(c13245fu)));
    }

    public EV0 c() {
        ClipData primaryClip = this.a.getPrimaryClip();
        if (primaryClip != null) {
            return new EV0(primaryClip);
        }
        return null;
    }

    public boolean d() {
        ClipDescription primaryClipDescription = this.a.getPrimaryClipDescription();
        if (primaryClipDescription != null) {
            return primaryClipDescription.hasMimeType("text/*");
        }
        return false;
    }

    public void e(EV0 ev0) {
        if (ev0 != null) {
            this.a.setPrimaryClip(ev0.a());
        } else if (Build.VERSION.SDK_INT >= 28) {
            C18592ov.a(this.a);
        } else {
            this.a.setPrimaryClip(ClipData.newPlainText("", ""));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C8331Vn(Context context) {
        Object systemService = context.getSystemService("clipboard");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        this((ClipboardManager) systemService);
    }
}
