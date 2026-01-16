package ir.nasim;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* renamed from: ir.nasim.Km2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC5706Km2 {
    public static final void a(ReadableByteChannel readableByteChannel, FileChannel fileChannel) throws IOException {
        AbstractC13042fc3.i(readableByteChannel, "input");
        AbstractC13042fc3.i(fileChannel, "output");
        try {
            fileChannel.transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
            fileChannel.force(false);
        } finally {
            readableByteChannel.close();
            fileChannel.close();
        }
    }
}
