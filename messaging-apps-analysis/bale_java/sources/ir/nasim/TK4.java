package ir.nasim;

import android.content.Context;
import android.content.Intent;
import ir.nasim.features.call.ui.CallActivity;

/* loaded from: classes5.dex */
public final class TK4 {
    public static final a b = new a(null);
    public static final int c = 8;
    private final Context a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public TK4(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
    }

    public final void a() {
        C19406qI3.a("OpenCallActivityUseCase", "openCallActivity", new Object[0]);
        Intent intent = new Intent(this.a, (Class<?>) CallActivity.class);
        intent.setAction("bale_voice_call");
        intent.addFlags(268435456);
        this.a.startActivity(intent);
    }
}
