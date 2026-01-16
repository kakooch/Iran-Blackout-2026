package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

/* loaded from: classes5.dex */
public abstract class RN {
    public static final VL a(C8552Wl4 c8552Wl4, QN qn) {
        AbstractC13042fc3.i(c8552Wl4, "music");
        AbstractC13042fc3.i(qn, "audioData");
        String strC = qn.c() != null ? qn.c() : "";
        String strQ = qn.q() != null ? qn.q() : "";
        if (!TextUtils.isEmpty(c8552Wl4.h())) {
            strC = c8552Wl4.h();
        }
        String str = strC;
        if (!TextUtils.isEmpty(c8552Wl4.j())) {
            strQ = c8552Wl4.j();
        }
        return new C8552Wl4(c8552Wl4.c(), c8552Wl4.d(), str, strQ, c8552Wl4.b() == 0 ? qn.k() : c8552Wl4.b(), c8552Wl4.i() == null ? qn.h() : c8552Wl4.i(), c8552Wl4.a());
    }

    public static final VL b(String str, boolean z, J44 j44, T74 t74, QN qn) {
        String strB;
        String strY;
        Bitmap bitmapH;
        long jK;
        int iG;
        AbstractC13042fc3.i(str, "filePath");
        AbstractC13042fc3.i(j44, "currentMessage");
        AbstractC13042fc3.i(t74, "currentMessageId");
        long jG = 0;
        if (z) {
            int iU = j44.U();
            C24967zW1 c24967zW1H = j44.H();
            if (!(c24967zW1H instanceof J08)) {
                if (c24967zW1H instanceof TM) {
                    C24967zW1 c24967zW1H2 = j44.H();
                    AbstractC13042fc3.g(c24967zW1H2, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.AudioContent");
                    iG = ((TM) c24967zW1H2).G();
                }
                return new QZ7(str, t74, jG, iU, j44);
            }
            C24967zW1 c24967zW1H3 = j44.H();
            AbstractC13042fc3.g(c24967zW1H3, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.VoiceContent");
            iG = ((J08) c24967zW1H3).G();
            jG = iG;
            return new QZ7(str, t74, jG, iU, j44);
        }
        C24967zW1 c24967zW1H4 = j44.H();
        strB = "";
        if (c24967zW1H4 instanceof TM) {
            TM tm = (TM) c24967zW1H4;
            String strE = tm.E();
            if (strE == null) {
                strE = "";
            }
            String strK = tm.K();
            strB = strK != null ? strK : "";
            byte[] bArrF = tm.F();
            bitmapDecodeByteArray = bArrF != null ? BitmapFactory.decodeByteArray(tm.F(), 0, bArrF.length) : null;
            strY = strB;
            strB = strE;
            jG = tm.G();
        } else {
            strY = "";
        }
        if (qn != null) {
            if (qn.b() != null && TextUtils.isEmpty(strB)) {
                strB = qn.b();
            }
            if (qn.q() != null && TextUtils.isEmpty(strY)) {
                strY = qn.q();
            }
            bitmapH = qn.h();
            jK = qn.k();
        } else {
            long j = jG;
            bitmapH = bitmapDecodeByteArray;
            jK = j;
        }
        if (TextUtils.isEmpty(strY) && c24967zW1H4 != null) {
            strY = c24967zW1H4.y();
        }
        return new C8552Wl4(str, t74, strB, strY, jK, bitmapH, j44);
    }
}
