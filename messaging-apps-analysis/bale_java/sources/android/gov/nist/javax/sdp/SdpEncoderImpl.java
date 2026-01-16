package android.gov.nist.javax.sdp;

import ir.nasim.InterfaceC8892Xt6;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class SdpEncoderImpl {
    public void output(InterfaceC8892Xt6 interfaceC8892Xt6, OutputStream outputStream) throws IOException {
        if (!(outputStream instanceof ObjectOutputStream)) {
            throw new IOException("The output stream has to be an instance of ObjectOutputStream");
        }
        ObjectOutputStream objectOutputStream = (ObjectOutputStream) outputStream;
        if (interfaceC8892Xt6 == null) {
            throw new IOException("The parameter is null");
        }
        objectOutputStream.writeObject(interfaceC8892Xt6);
    }

    public void setEncoding(String str) throws UnsupportedEncodingException {
        throw new UnsupportedEncodingException("Method not supported");
    }

    public void setRtpmapAttribute(boolean z) {
    }

    public void setTypedTime(boolean z) {
    }
}
