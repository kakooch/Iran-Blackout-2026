package ir.nasim;

import ir.nasim.database.model.file.FileState;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.qm2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19687qm2 extends AbstractC6277Mx7 {
    private final List e(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        int length = bArr.length / 4;
        for (int i = 0; i < length; i++) {
            int i2 = i * 4;
            arrayList.add(Integer.valueOf((bArr[i2] & 255) | (bArr[i2 + 3] << 24) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8)));
        }
        return arrayList;
    }

    private final byte[] f(List list) {
        byte[] bArr = new byte[list.size() * 4];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            int iIntValue = ((Number) it.next()).intValue();
            for (int i3 = 0; i3 < 4; i3++) {
                bArr[(i * 4) + i3] = (byte) (iIntValue >> (i3 * 8));
            }
            i = i2;
        }
        return bArr;
    }

    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public FileState b(C12523el3 c12523el3) throws IOException, NumberFormatException {
        AbstractC13042fc3.i(c12523el3, "reader");
        FileState notDownloaded = null;
        if (c12523el3.l() && c12523el3.G() != EnumC16723ll3.NULL) {
            c12523el3.B();
            c12523el3.n0();
            String strT0 = c12523el3.T0();
            if (AbstractC13042fc3.d(strT0, FileState.Downloaded.class.getSimpleName())) {
                notDownloaded = FileState.Downloaded.INSTANCE;
            } else if (AbstractC13042fc3.d(strT0, FileState.NotDownloaded.class.getSimpleName())) {
                c12523el3.n0();
                int iR0 = c12523el3.r0();
                c12523el3.n0();
                notDownloaded = new FileState.NotDownloaded(iR0, e(C13393g90.g(C13393g90.d, c12523el3.T0(), 0, 0, 6, null)));
            }
            c12523el3.F();
        }
        return notDownloaded;
    }

    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(C22155ul3 c22155ul3, FileState fileState) throws IOException {
        AbstractC13042fc3.i(c22155ul3, "writer");
        if (fileState == null) {
            c22155ul3.s();
            return;
        }
        c22155ul3.d();
        c22155ul3.p("simpleName").X(fileState.getClass().getSimpleName());
        if (!AbstractC13042fc3.d(fileState, FileState.Downloaded.INSTANCE)) {
            if (!(fileState instanceof FileState.NotDownloaded)) {
                throw new NoWhenBranchMatchedException();
            }
            FileState.NotDownloaded notDownloaded = (FileState.NotDownloaded) fileState;
            c22155ul3.p("chunkSize").U(Integer.valueOf(notDownloaded.getChunkSize()));
            c22155ul3.p("remainingChunkIndices").X(C13393g90.l(C13393g90.d, f(notDownloaded.getRemainingChunkIndices()), 0, 0, 6, null));
        }
        c22155ul3.j();
    }
}
