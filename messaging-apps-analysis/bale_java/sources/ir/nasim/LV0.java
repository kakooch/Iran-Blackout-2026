package ir.nasim;

import android.content.ClipData;

/* loaded from: classes.dex */
public final class LV0 {
    public static final LV0 a = new LV0();

    private LV0() {
    }

    public static final boolean a(EV0 ev0) {
        if (ev0 == null) {
            return false;
        }
        return ev0.a().getDescription().hasMimeType("text/*");
    }

    public static final C13245fu b(EV0 ev0) {
        CharSequence text;
        ClipData.Item itemAt = ev0.a().getItemAt(0);
        if (itemAt == null || (text = itemAt.getText()) == null) {
            return null;
        }
        return MV0.a(text);
    }

    public static final EV0 c(C13245fu c13245fu) {
        if (c13245fu == null) {
            return null;
        }
        return new EV0(ClipData.newPlainText("plain text", MV0.b(c13245fu)));
    }
}
