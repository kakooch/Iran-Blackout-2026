package ir.nasim;

import android.gov.nist.core.Separators;
import android.media.AudioRecord;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class LL4 extends K6 {
    private static final a l = new a(null);
    public static final int m = 8;
    private final String f;
    private final AudioRecord g;
    private final SA2 h;
    private int i;
    private final MediaController j;
    private final ByteBuffer k;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b {
    }

    public static final class c {
    }

    public static final class d {
    }

    public LL4(String str, AudioRecord audioRecord, SA2 sa2) {
        AbstractC13042fc3.i(str, "filePath");
        AbstractC13042fc3.i(audioRecord, "audioRecord");
        AbstractC13042fc3.i(sa2, "onProgress");
        this.f = str;
        this.g = audioRecord;
        this.h = sa2;
        this.j = MediaController.Y();
        this.k = ByteBuffer.allocateDirect(1920);
    }

    private final void A() {
        if (this.i != 1 || this.g.getState() == 0) {
            C19406qI3.j("OpusEncoder", "Ignoring the onIterateMessage(state: " + this.i + ", isNotInitialized: " + (this.g.getState() == 0) + Separators.RPAREN, new Object[0]);
            return;
        }
        C19406qI3.a("OpusEncoder", "onIterateMessage(state: " + this.i + Separators.RPAREN, new Object[0]);
        RZ7 rz7 = RZ7.a;
        byte[] bArrA = rz7.a(16384);
        int i = this.g.read(bArrA, 0, bArrA.length);
        if (i > 0) {
            D(bArrA, i);
        } else {
            rz7.b(bArrA);
        }
        this.h.invoke();
        if (i > 0 || this.g.getRecordingState() == 3) {
            r().d(new b());
        }
    }

    private final void B() {
        int i = this.i;
        if (i == 0) {
            C19406qI3.a("OpusEncoder", "onStart()", new Object[0]);
            this.j.startRecord(this.f, this.g.getSampleRate());
            this.i = 1;
            r().d(new b());
            return;
        }
        C19406qI3.j("OpusEncoder", "Ignoring the onStart(state: " + i + Separators.RPAREN, new Object[0]);
    }

    private final void C() {
        int i = this.i;
        if (i != 1) {
            C19406qI3.j("OpusEncoder", "Ignoring the onStopMessage(state: " + i + Separators.RPAREN, new Object[0]);
            return;
        }
        C19406qI3.a("OpusEncoder", "onStopMessage()", new Object[0]);
        this.g.release();
        this.j.stopRecord();
        this.i = 2;
        r().d(C12485eh5.a);
    }

    private final void D(byte[] bArr, int i) {
        int iLimit;
        if (this.i != 1) {
            return;
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i);
        byteBufferAllocateDirect.put(bArr, 0, i);
        byteBufferAllocateDirect.rewind();
        while (byteBufferAllocateDirect.hasRemaining()) {
            if (byteBufferAllocateDirect.remaining() > this.k.remaining()) {
                iLimit = byteBufferAllocateDirect.limit();
                byteBufferAllocateDirect.limit(this.k.remaining() + byteBufferAllocateDirect.position());
            } else {
                iLimit = -1;
            }
            this.k.put(byteBufferAllocateDirect);
            if (this.k.position() == this.k.limit()) {
                if (this.j.writeFrame(this.k, this.k.limit()) != 0) {
                    this.k.rewind();
                }
            }
            if (iLimit != -1) {
                byteBufferAllocateDirect.limit(iLimit);
            }
        }
    }

    @Override // ir.nasim.K6
    public void m(Object obj) {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof c) {
            B();
        } else if (obj instanceof b) {
            A();
        } else if (obj instanceof d) {
            C();
        }
    }
}
