package ir.nasim;

import android.graphics.Color;
import ir.nasim.AbstractC5542Ju0;
import ir.nasim.C9475a16;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.j68, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class EnumC15162j68 {
    public static final c b;
    public static final EnumC15162j68 c = new EnumC15162j68("INVALID_METHOD_TYPE", 0) { // from class: ir.nasim.j68.d
        {
            String str = "invalidMethodType";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            C19406qI3.a("WebApp", "WebAppMethodType Invalid.", new Object[0]);
        }
    };
    public static final EnumC15162j68 d = new EnumC15162j68("SETUP_BACK_BUTTON", 1) { // from class: ir.nasim.j68.e
        {
            String str = "web_app_setup_back_button";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            interfaceC14560i68.b4(jSONObject.optBoolean("is_visible", false));
        }
    };
    public static final EnumC15162j68 e = new EnumC15162j68("SETUP_SETTING_BUTTON", 2) { // from class: ir.nasim.j68.f
        {
            String str = "web_app_setup_settings_button";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            interfaceC14560i68.T4(jSONObject.optBoolean("is_visible", false));
        }
    };
    public static final EnumC15162j68 f = new EnumC15162j68("BOTTOM_SHEET_EXPANDED", 3) { // from class: ir.nasim.j68.b
        {
            String str = "web_app_expand";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            interfaceC14560i68.b5();
        }
    };
    public static final EnumC15162j68 g = new EnumC15162j68("WEB_APP_READY", 4) { // from class: ir.nasim.j68.n
        {
            String str = "web_app_ready";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            interfaceC14560i68.v0();
        }
    };
    public static final EnumC15162j68 h = new EnumC15162j68("WEB_APP_CLOSE", 5) { // from class: ir.nasim.j68.h
        {
            String str = "web_app_close";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            interfaceC14560i68.v3();
        }
    };
    public static final EnumC15162j68 i = new EnumC15162j68("WEB_APP_REQUEST_PHONE", 6) { // from class: ir.nasim.j68.o
        {
            String str = "web_app_request_phone";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            interfaceC14560i68.i2();
        }
    };
    public static final EnumC15162j68 j = new EnumC15162j68("WEB_APP_SETUP_CLOSING_BEHAVIOR", 7) { // from class: ir.nasim.j68.p
        {
            String str = "web_app_setup_closing_behavior";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            interfaceC14560i68.K3(jSONObject.optBoolean("need_confirmation", false));
        }
    };
    public static final EnumC15162j68 k = new EnumC15162j68("WEB_APP_SHORTCUT_ADD_TO_HOME_SCREEN", 8) { // from class: ir.nasim.j68.r
        {
            String str = "web_app_add_to_home_screen";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            interfaceC14560i68.T1();
        }
    };
    public static final EnumC15162j68 l = new EnumC15162j68("WEB_APP_CHECK_SHORTCUT_ADDED_TO_HOME_SCREEN", 9) { // from class: ir.nasim.j68.g
        {
            String str = "web_app_check_home_screen";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            interfaceC14560i68.Z();
        }
    };
    public static final EnumC15162j68 m = new EnumC15162j68("WEB_APP_OPEN_LINK", 10) { // from class: ir.nasim.j68.l
        {
            String str = "web_app_open_link";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            String strOptString = jSONObject.optString("url", "");
            boolean zOptBoolean = jSONObject.optBoolean("try_instant_view", true);
            AbstractC13042fc3.f(strOptString);
            interfaceC14560i68.g4(strOptString, zOptBoolean);
        }
    };
    public static final EnumC15162j68 n = new EnumC15162j68("WEB_APP_SET_HEADER_COLOR", 11) { // from class: ir.nasim.j68.q
        {
            String str = "web_app_set_header_color";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            Object objB;
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            String strOptString = jSONObject.optString("color", "");
            if (strOptString == null || strOptString.length() == 0) {
                String strOptString2 = jSONObject.optString("color_key", "");
                if (AbstractC13042fc3.d(strOptString2, "bg_color")) {
                    interfaceC14560i68.e1(new AbstractC5542Ju0.a(TA5.background));
                    return;
                } else {
                    if (AbstractC13042fc3.d(strOptString2, "secondary_bg_color")) {
                        interfaceC14560i68.e1(new AbstractC5542Ju0.a(TA5.n20));
                        return;
                    }
                    return;
                }
            }
            try {
                C9475a16.a aVar = C9475a16.b;
                interfaceC14560i68.e1(new AbstractC5542Ju0.b(Color.parseColor(strOptString)));
                objB = C9475a16.b(C19938rB7.a);
            } catch (Throwable th) {
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(th));
            }
            C9475a16.a(objB);
        }
    };
    public static final EnumC15162j68 o = new EnumC15162j68("WEB_APP_INVOKE_CUSTOM_METHOD", 12) { // from class: ir.nasim.j68.j
        {
            String str = "web_app_invoke_custom_method";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            String string;
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            String str = "";
            String strOptString = jSONObject.optString("req_id", "");
            String strOptString2 = jSONObject.optString("method", "");
            Object objOpt = jSONObject.opt("params");
            if (objOpt != null && (string = objOpt.toString()) != null) {
                str = string;
            }
            AbstractC13042fc3.f(strOptString);
            AbstractC13042fc3.f(strOptString2);
            interfaceC14560i68.l3(strOptString, strOptString2, str);
        }
    };
    public static final EnumC15162j68 p = new EnumC15162j68("WEB_APP_DATA_SEND", 13) { // from class: ir.nasim.j68.i
        {
            String str = "web_app_data_send";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            String strOptString = jSONObject.optString("data", "");
            AbstractC13042fc3.f(strOptString);
            interfaceC14560i68.e3(strOptString);
        }
    };
    public static final EnumC15162j68 q = new EnumC15162j68("WEB_APP_OPEN_QR", 14) { // from class: ir.nasim.j68.m
        {
            String str = "web_app_open_scan_qr_popup";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            interfaceC14560i68.c1();
        }
    };
    public static final EnumC15162j68 r = new EnumC15162j68("WEB_APP_OPEN_INVOICE", 15) { // from class: ir.nasim.j68.k
        {
            String str = "web_app_open_invoice";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            String strOptString = jSONObject.optString("invoiceParams", "");
            AbstractC13042fc3.f(strOptString);
            interfaceC14560i68.A4(strOptString);
        }
    };
    public static final EnumC15162j68 s = new EnumC15162j68("ASK_REVIEW", 16) { // from class: ir.nasim.j68.a
        {
            String str = "web_app_ask_review";
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC15162j68
        public void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68) {
            AbstractC13042fc3.i(jSONObject, "methodData");
            AbstractC13042fc3.i(interfaceC14560i68, "webAppMethodCallBack");
            String strOptString = jSONObject.optString("payload");
            AbstractC13042fc3.f(strOptString);
            if (!(!AbstractC20762sZ6.n0(strOptString))) {
                strOptString = null;
            }
            interfaceC14560i68.t3(strOptString);
        }
    };
    private static final /* synthetic */ EnumC15162j68[] t;
    private static final /* synthetic */ F92 u;
    private final String a;

    /* renamed from: ir.nasim.j68$c */
    public static final class c {
        private c() {
        }

        public final EnumC15162j68 a(String str) {
            Object next;
            AbstractC13042fc3.i(str, "value");
            Iterator<E> it = EnumC15162j68.q().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (AbstractC13042fc3.d(((EnumC15162j68) next).a, str)) {
                    break;
                }
            }
            EnumC15162j68 enumC15162j68 = (EnumC15162j68) next;
            return enumC15162j68 == null ? EnumC15162j68.c : enumC15162j68;
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC15162j68[] enumC15162j68ArrA = a();
        t = enumC15162j68ArrA;
        u = G92.a(enumC15162j68ArrA);
        b = new c(null);
    }

    public /* synthetic */ EnumC15162j68(String str, int i2, String str2, ED1 ed1) {
        this(str, i2, str2);
    }

    private static final /* synthetic */ EnumC15162j68[] a() {
        return new EnumC15162j68[]{c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s};
    }

    public static F92 q() {
        return u;
    }

    public static EnumC15162j68 valueOf(String str) {
        return (EnumC15162j68) Enum.valueOf(EnumC15162j68.class, str);
    }

    public static EnumC15162j68[] values() {
        return (EnumC15162j68[]) t.clone();
    }

    public abstract void p(JSONObject jSONObject, InterfaceC14560i68 interfaceC14560i68);

    private EnumC15162j68(String str, int i2, String str2) {
        this.a = str2;
    }
}
