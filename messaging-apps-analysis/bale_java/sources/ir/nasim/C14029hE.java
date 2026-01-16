package ir.nasim;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* renamed from: ir.nasim.hE, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14029hE extends NC6 {
    private static Metadata c(DW4 dw4) {
        dw4.r(12);
        int iD = (dw4.d() + dw4.h(12)) - 4;
        dw4.r(44);
        dw4.s(dw4.h(12));
        dw4.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strL = null;
            if (dw4.d() >= iD) {
                break;
            }
            dw4.r(48);
            int iH = dw4.h(8);
            dw4.r(4);
            int iD2 = dw4.d() + dw4.h(12);
            String strL2 = null;
            while (dw4.d() < iD2) {
                int iH2 = dw4.h(8);
                int iH3 = dw4.h(8);
                int iD3 = dw4.d() + iH3;
                if (iH2 == 2) {
                    int iH4 = dw4.h(16);
                    dw4.r(8);
                    if (iH4 == 3) {
                        while (dw4.d() < iD3) {
                            strL = dw4.l(dw4.h(8), AbstractC12884fL0.a);
                            int iH5 = dw4.h(8);
                            for (int i = 0; i < iH5; i++) {
                                dw4.s(dw4.h(8));
                            }
                        }
                    }
                } else if (iH2 == 21) {
                    strL2 = dw4.l(iH3, AbstractC12884fL0.a);
                }
                dw4.p(iD3 * 8);
            }
            dw4.p(iD2 * 8);
            if (strL != null && strL2 != null) {
                arrayList.add(new AppInfoTable(iH, strL + strL2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    @Override // ir.nasim.NC6
    protected Metadata b(C24452ye4 c24452ye4, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new DW4(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
