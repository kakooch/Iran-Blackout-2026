package ir.nasim;

import android.telephony.PhoneStateListener;

/* renamed from: ir.nasim.gU2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13585gU2 extends PhoneStateListener {
    public static final a a = new a(null);
    private static boolean b;

    /* renamed from: ir.nasim.gU2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, String str) {
        super.onCallStateChanged(i, str);
        if (i == 0) {
            b = false;
            return;
        }
        if (i == 1) {
            b = true;
            C23709xO c23709xO = C23709xO.a;
            c23709xO.h();
            c23709xO.q0();
            return;
        }
        if (i != 2) {
            return;
        }
        b = true;
        C23709xO c23709xO2 = C23709xO.a;
        c23709xO2.h();
        c23709xO2.q0();
    }
}
