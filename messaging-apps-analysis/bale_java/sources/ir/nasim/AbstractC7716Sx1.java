package ir.nasim;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/* renamed from: ir.nasim.Sx1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7716Sx1 {
    public static final CancellationSignal a() {
        return C9486a27.b();
    }

    public static final void b(InterfaceC12694f27 interfaceC12694f27) throws IOException {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        List listC = AbstractC9766aX0.c();
        Cursor cursorR1 = interfaceC12694f27.r1("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        try {
            Cursor cursor = cursorR1;
            while (cursor.moveToNext()) {
                listC.add(cursor.getString(0));
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            YV0.a(cursorR1, null);
            for (String str : AbstractC9766aX0.a(listC)) {
                AbstractC13042fc3.h(str, "triggerName");
                if (AbstractC20153rZ6.S(str, "room_fts_content_sync_", false, 2, null)) {
                    interfaceC12694f27.O("DROP TRIGGER IF EXISTS " + str);
                }
            }
        } finally {
        }
    }

    public static final Cursor c(D26 d26, InterfaceC14514i27 interfaceC14514i27, boolean z, CancellationSignal cancellationSignal) {
        AbstractC13042fc3.i(d26, "db");
        AbstractC13042fc3.i(interfaceC14514i27, "sqLiteQuery");
        Cursor cursorD = d26.D(interfaceC14514i27, cancellationSignal);
        if (!z || !(cursorD instanceof AbstractWindowedCursor)) {
            return cursorD;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorD;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? AbstractC5795Kw1.a(cursorD) : cursorD;
    }

    public static final int d(File file) throws IOException {
        AbstractC13042fc3.i(file, "databaseFile");
        FileChannel channel = new FileInputStream(file).getChannel();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i = byteBufferAllocate.getInt();
            YV0.a(channel, null);
            return i;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                YV0.a(channel, th);
                throw th2;
            }
        }
    }
}
