package ir.nasim;

import androidx.compose.ui.graphics.painter.BitmapPainter;

/* renamed from: ir.nasim.eg0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC12470eg0 {
    public static final BitmapPainter a(Y03 y03, long j, long j2, int i) {
        BitmapPainter bitmapPainter = new BitmapPainter(y03, j, j2, null);
        bitmapPainter.o(i);
        return bitmapPainter;
    }

    public static /* synthetic */ BitmapPainter b(Y03 y03, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = C22045ua3.b.b();
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = C4414Fa3.c((y03.getHeight() & 4294967295L) | (y03.getWidth() << 32));
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            i = AbstractC17934no2.a.a();
        }
        return a(y03, j3, j4, i);
    }
}
