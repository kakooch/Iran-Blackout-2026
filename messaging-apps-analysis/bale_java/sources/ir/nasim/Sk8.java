package ir.nasim;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
final class Sk8 implements InterfaceC19663qj8 {
    private final FileChannel a;
    private final long b;
    private final long c;

    public Sk8(FileChannel fileChannel, long j, long j2) {
        this.a = fileChannel;
        this.b = j;
        this.c = j2;
    }

    @Override // ir.nasim.InterfaceC19663qj8
    public final void a(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        MappedByteBuffer map = this.a.map(FileChannel.MapMode.READ_ONLY, this.b + j, i);
        map.load();
        for (MessageDigest messageDigest : messageDigestArr) {
            map.position(0);
            messageDigest.update(map);
        }
    }

    @Override // ir.nasim.InterfaceC19663qj8
    public final long zza() {
        return this.c;
    }
}
