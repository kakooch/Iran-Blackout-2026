package ir.nasim;

import android.text.style.TtsSpan;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Dw7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4148Dw7 {
    public static final TtsSpan a(AbstractC3914Cw7 abstractC3914Cw7) {
        if (abstractC3914Cw7 instanceof C22558vR7) {
            return b((C22558vR7) abstractC3914Cw7);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final TtsSpan b(C22558vR7 c22558vR7) {
        return new TtsSpan.VerbatimBuilder(c22558vR7.a()).build();
    }
}
