package ir.nasim;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* renamed from: ir.nasim.db2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11810db2 {
    private final ByteArrayOutputStream a;
    private final DataOutputStream b;

    public C11810db2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.a = byteArrayOutputStream;
        this.b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(EventMessage eventMessage) throws IOException {
        this.a.reset();
        try {
            b(this.b, eventMessage.a);
            String str = eventMessage.b;
            if (str == null) {
                str = "";
            }
            b(this.b, str);
            this.b.writeLong(eventMessage.c);
            this.b.writeLong(eventMessage.d);
            this.b.write(eventMessage.e);
            this.b.flush();
            return this.a.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
