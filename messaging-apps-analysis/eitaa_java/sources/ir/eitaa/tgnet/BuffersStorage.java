package ir.eitaa.tgnet;

import ir.eitaa.messenger.FileLog;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BuffersStorage {
    private static volatile BuffersStorage Instance;
    private static final Object sync = new Object();
    private boolean isThreadSafe;
    private final ArrayList<NativeByteBuffer> freeBuffers128 = new ArrayList<>();
    private final ArrayList<NativeByteBuffer> freeBuffers1024 = new ArrayList<>();
    private final ArrayList<NativeByteBuffer> freeBuffers4096 = new ArrayList<>();
    private final ArrayList<NativeByteBuffer> freeBuffers16384 = new ArrayList<>();
    private final ArrayList<NativeByteBuffer> freeBuffers32768 = new ArrayList<>();
    private final ArrayList<NativeByteBuffer> freeBuffersBig = new ArrayList<>();

    public static BuffersStorage getInstance() {
        BuffersStorage buffersStorage = Instance;
        if (buffersStorage == null) {
            synchronized (BuffersStorage.class) {
                buffersStorage = Instance;
                if (buffersStorage == null) {
                    buffersStorage = new BuffersStorage(true);
                    Instance = buffersStorage;
                }
            }
        }
        return buffersStorage;
    }

    public BuffersStorage(boolean threadSafe) {
        this.isThreadSafe = threadSafe;
        for (int i = 0; i < 5; i++) {
            try {
                this.freeBuffers128.add(new NativeByteBuffer(128));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.eitaa.tgnet.NativeByteBuffer getFreeBuffer(int r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 > 0) goto L4
            return r0
        L4:
            r1 = 280000(0x445c0, float:3.92364E-40)
            r2 = 40000(0x9c40, float:5.6052E-41)
            r3 = 16584(0x40c8, float:2.3239E-41)
            r4 = 4296(0x10c8, float:6.02E-42)
            r5 = 1224(0x4c8, float:1.715E-42)
            r6 = 128(0x80, float:1.8E-43)
            r7 = 0
            if (r10 > r6) goto L1d
            java.util.ArrayList<ir.eitaa.tgnet.NativeByteBuffer> r1 = r9.freeBuffers128
            r2 = 128(0x80, float:1.8E-43)
        L19:
            r8 = r1
            r1 = r0
            r0 = r8
            goto L47
        L1d:
            if (r10 > r5) goto L24
            java.util.ArrayList<ir.eitaa.tgnet.NativeByteBuffer> r1 = r9.freeBuffers1024
            r2 = 1224(0x4c8, float:1.715E-42)
            goto L19
        L24:
            if (r10 > r4) goto L2b
            java.util.ArrayList<ir.eitaa.tgnet.NativeByteBuffer> r1 = r9.freeBuffers4096
            r2 = 4296(0x10c8, float:6.02E-42)
            goto L19
        L2b:
            if (r10 > r3) goto L32
            java.util.ArrayList<ir.eitaa.tgnet.NativeByteBuffer> r1 = r9.freeBuffers16384
            r2 = 16584(0x40c8, float:2.3239E-41)
            goto L19
        L32:
            if (r10 > r2) goto L37
            java.util.ArrayList<ir.eitaa.tgnet.NativeByteBuffer> r1 = r9.freeBuffers32768
            goto L19
        L37:
            if (r10 > r1) goto L41
            java.util.ArrayList<ir.eitaa.tgnet.NativeByteBuffer> r2 = r9.freeBuffersBig
            r1 = r0
            r0 = r2
            r2 = 280000(0x445c0, float:3.92364E-40)
            goto L47
        L41:
            ir.eitaa.tgnet.NativeByteBuffer r1 = new ir.eitaa.tgnet.NativeByteBuffer     // Catch: java.lang.Exception -> L91
            r1.<init>(r10)     // Catch: java.lang.Exception -> L91
            r2 = 0
        L47:
            if (r0 == 0) goto L87
            boolean r3 = r9.isThreadSafe
            if (r3 == 0) goto L64
            java.lang.Object r3 = ir.eitaa.tgnet.BuffersStorage.sync
            monitor-enter(r3)
            int r4 = r0.size()     // Catch: java.lang.Throwable -> L61
            if (r4 <= 0) goto L5f
            java.lang.Object r1 = r0.get(r7)     // Catch: java.lang.Throwable -> L61
            ir.eitaa.tgnet.NativeByteBuffer r1 = (ir.eitaa.tgnet.NativeByteBuffer) r1     // Catch: java.lang.Throwable -> L61
            r0.remove(r7)     // Catch: java.lang.Throwable -> L61
        L5f:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L61
            goto L73
        L61:
            r10 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L61
            throw r10
        L64:
            int r3 = r0.size()
            if (r3 <= 0) goto L73
            java.lang.Object r1 = r0.get(r7)
            ir.eitaa.tgnet.NativeByteBuffer r1 = (ir.eitaa.tgnet.NativeByteBuffer) r1
            r0.remove(r7)
        L73:
            if (r1 != 0) goto L87
            ir.eitaa.tgnet.NativeByteBuffer r1 = new ir.eitaa.tgnet.NativeByteBuffer     // Catch: java.lang.Exception -> L80
            r1.<init>(r2)     // Catch: java.lang.Exception -> L80
            java.lang.String r0 = "tmessages - create new  + byteCountbuffer"
            ir.eitaa.messenger.FileLog.e(r0)
            goto L87
        L80:
            r10 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r10)
            throw r0
        L87:
            java.nio.ByteBuffer r0 = r1.buffer
            java.nio.Buffer r10 = r0.limit(r10)
            r10.rewind()
            return r1
        L91:
            r10 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r10)
            goto L99
        L98:
            throw r0
        L99:
            goto L98
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.tgnet.BuffersStorage.getFreeBuffer(int):ir.eitaa.tgnet.NativeByteBuffer");
    }

    public void reuseFreeBuffer(NativeByteBuffer buffer) {
        if (buffer == null) {
            return;
        }
        ArrayList<NativeByteBuffer> arrayList = null;
        if (buffer.buffer.capacity() == 128) {
            arrayList = this.freeBuffers128;
        } else if (buffer.buffer.capacity() == 1224) {
            arrayList = this.freeBuffers1024;
        } else if (buffer.buffer.capacity() == 4296) {
            arrayList = this.freeBuffers4096;
        } else if (buffer.buffer.capacity() == 16584) {
            arrayList = this.freeBuffers16384;
        } else if (buffer.buffer.capacity() == 40000) {
            arrayList = this.freeBuffers32768;
        } else if (buffer.buffer.capacity() == 280000) {
            arrayList = this.freeBuffersBig;
        }
        if (arrayList != null) {
            if (this.isThreadSafe) {
                synchronized (sync) {
                    if (arrayList.size() < 10) {
                        arrayList.add(buffer);
                    } else {
                        FileLog.e("tmessages - too more");
                    }
                }
                return;
            }
            if (arrayList.size() < 10) {
                arrayList.add(buffer);
            }
        }
    }
}
