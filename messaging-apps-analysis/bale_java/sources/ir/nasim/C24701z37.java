package ir.nasim;

import com.caverock.androidsvg.SVGParseException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: ir.nasim.z37, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24701z37 implements HW5 {
    @Override // ir.nasim.HW5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public DW5 a(InputStream inputStream, int i, int i2, HL4 hl4) throws IOException {
        AbstractC13042fc3.i(inputStream, "source");
        AbstractC13042fc3.i(hl4, "options");
        try {
            com.caverock.androidsvg.g gVarL = com.caverock.androidsvg.g.l(inputStream);
            if (i != Integer.MIN_VALUE) {
                gVarL.B(i);
            }
            if (i2 != Integer.MIN_VALUE) {
                gVarL.y(i2);
            }
            return new SC6(gVarL);
        } catch (SVGParseException e) {
            throw new IOException("Cannot load SVG from stream", e);
        }
    }

    @Override // ir.nasim.HW5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(InputStream inputStream, HL4 hl4) {
        AbstractC13042fc3.i(inputStream, "source");
        AbstractC13042fc3.i(hl4, "options");
        return true;
    }
}
