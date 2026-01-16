package ir.nasim;

import android.net.Uri;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.rm2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C20296rm2 extends G90 implements InterfaceC23930xl2 {
    private static final ConcurrentHashMap n = new ConcurrentHashMap();
    private Uri e;
    private long f;
    private boolean g;
    private long h;
    private CountDownLatch i;
    private RandomAccessFile j;
    private AbstractC18106o57 k;
    private Object l;
    private int m;

    public C20296rm2() {
        super(false);
    }

    private int r() {
        Integer num = (Integer) n.get(Long.valueOf(this.k.c));
        if (num != null) {
            return num.intValue();
        }
        return 3;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(com.google.android.exoplayer2.upstream.b bVar) throws EOFException {
        Uri uri = bVar.a;
        this.e = uri;
        int iIntValue = Utilities.h(uri.getQueryParameter("account")).intValue();
        this.m = iIntValue;
        this.l = C4278El2.H(iIntValue).L(Utilities.h(this.e.getQueryParameter(DialogEntity.COLUMN_RID)).intValue());
        A77 a77 = new A77();
        this.k = a77;
        a77.d = Utilities.i(this.e.getQueryParameter("hash")).longValue();
        this.k.c = Utilities.i(this.e.getQueryParameter("id")).longValue();
        this.k.j = Utilities.i(this.e.getQueryParameter("size")).longValue();
        this.k.m = Utilities.h(this.e.getQueryParameter("dc")).intValue();
        this.k.i = this.e.getQueryParameter("mime");
        this.k.e = Utilities.g(this.e.getQueryParameter("reference"));
        G77 g77 = new G77();
        g77.i = this.e.getQueryParameter("name");
        this.k.p.add(g77);
        if (this.k.i.startsWith(MediaStreamTrack.VIDEO_TRACK_KIND)) {
            this.k.p.add(new N77());
        } else if (this.k.i.startsWith(MediaStreamTrack.AUDIO_TRACK_KIND)) {
            this.k.p.add(new C77());
        }
        C4278El2 c4278El2H = C4278El2.H(this.m);
        AbstractC18106o57 abstractC18106o57 = this.k;
        Object obj = this.l;
        long j = bVar.g;
        this.h = j;
        c4278El2H.c0(this, abstractC18106o57, null, obj, j, false, r());
        long j2 = bVar.h;
        if (j2 == -1) {
            j2 = this.k.j - bVar.g;
        }
        this.f = j2;
        if (j2 < 0) {
            throw new EOFException();
        }
        this.g = true;
        q(bVar);
        return this.f;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.j;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
            this.j = null;
        }
        this.e = null;
        if (this.g) {
            this.g = false;
            o();
        }
        CountDownLatch countDownLatch = this.i;
        if (countDownLatch != null) {
            countDownLatch.countDown();
            this.i = null;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Uri getUri() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC18631oz1
    public int read(byte[] bArr, int i, int i2) throws IOException {
        RandomAccessFile randomAccessFile;
        if (i2 == 0) {
            return 0;
        }
        if (this.f == 0) {
            return -1;
        }
        try {
            boolean z = this.g;
            if (z || (randomAccessFile = this.j) == null) {
                throw null;
            }
            if (!z) {
                return 0;
            }
            randomAccessFile.readFully(bArr, i, 0);
            long j = 0;
            this.h += j;
            this.f -= j;
            n(0);
            return 0;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
