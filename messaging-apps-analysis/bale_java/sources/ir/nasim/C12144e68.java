package ir.nasim;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: ir.nasim.e68, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12144e68 {
    public static final a b = new a(null);
    public static final int c = 8;
    private WeakReference a;

    /* renamed from: ir.nasim.e68$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C12144e68(InterfaceC14560i68 interfaceC14560i68) {
        AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
        this.a = new WeakReference(interfaceC14560i68);
    }

    public final void a() {
        this.a.clear();
    }

    public final C12144e68 b(InterfaceC14560i68 interfaceC14560i68) {
        AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
        this.a = new WeakReference(interfaceC14560i68);
        return this;
    }

    @JavascriptInterface
    public final void postEvent(String str, String str2) {
        AbstractC13042fc3.i(str, "methodType");
        AbstractC13042fc3.i(str2, "methodData");
        InterfaceC14560i68 interfaceC14560i68 = (InterfaceC14560i68) this.a.get();
        if (interfaceC14560i68 != null) {
            interfaceC14560i68.d4(str);
            EnumC15162j68.b.a(str).p(new JSONObject(str2), interfaceC14560i68);
        }
    }
}
