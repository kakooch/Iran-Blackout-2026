package ir.nasim;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import ir.nasim.C14451hw1;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: ir.nasim.Dk4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4037Dk4 extends WC6 {
    private final EW4 o;

    public C4037Dk4() {
        super("Mp4WebvttDecoder");
        this.o = new EW4();
    }

    private static C14451hw1 B(EW4 ew4, int i) throws SubtitleDecoderException {
        CharSequence charSequenceQ = null;
        C14451hw1.b bVarO = null;
        while (i > 0) {
            if (i < 8) {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int iO = ew4.o();
            int iO2 = ew4.o();
            int i2 = iO - 8;
            String strC = AbstractC9683aN7.C(ew4.e(), ew4.f(), i2);
            ew4.T(i2);
            i = (i - 8) - i2;
            if (iO2 == 1937011815) {
                bVarO = W88.o(strC);
            } else if (iO2 == 1885436268) {
                charSequenceQ = W88.q(null, strC.trim(), Collections.emptyList());
            }
        }
        if (charSequenceQ == null) {
            charSequenceQ = "";
        }
        return bVarO != null ? bVarO.o(charSequenceQ).a() : W88.l(charSequenceQ);
    }

    @Override // ir.nasim.WC6
    protected InterfaceC24081y07 A(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.o.Q(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.o.a() > 0) {
            if (this.o.a() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int iO = this.o.o();
            if (this.o.o() == 1987343459) {
                arrayList.add(B(this.o, iO - 8));
            } else {
                this.o.T(iO - 8);
            }
        }
        return new C4271Ek4(arrayList);
    }
}
