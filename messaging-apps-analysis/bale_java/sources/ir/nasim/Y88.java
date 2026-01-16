package ir.nasim;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class Y88 extends WC6 {
    private final EW4 o;
    private final T88 p;

    public Y88() {
        super("WebvttDecoder");
        this.o = new EW4();
        this.p = new T88();
    }

    private static int B(EW4 ew4) {
        int i = -1;
        int iF = 0;
        while (i == -1) {
            iF = ew4.f();
            String strQ = ew4.q();
            i = strQ == null ? 0 : "STYLE".equals(strQ) ? 2 : strQ.startsWith("NOTE") ? 1 : 3;
        }
        ew4.S(iF);
        return i;
    }

    private static void C(EW4 ew4) {
        while (!TextUtils.isEmpty(ew4.q())) {
        }
    }

    @Override // ir.nasim.WC6
    protected InterfaceC24081y07 A(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        V88 v88M;
        this.o.Q(bArr, i);
        ArrayList arrayList = new ArrayList();
        try {
            Z88.e(this.o);
            while (!TextUtils.isEmpty(this.o.q())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int iB = B(this.o);
                if (iB == 0) {
                    return new C10151b98(arrayList2);
                }
                if (iB == 1) {
                    C(this.o);
                } else if (iB == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.o.q();
                    arrayList.addAll(this.p.d(this.o));
                } else if (iB == 3 && (v88M = W88.m(this.o, arrayList)) != null) {
                    arrayList2.add(v88M);
                }
            }
        } catch (ParserException e) {
            throw new SubtitleDecoderException(e);
        }
    }
}
