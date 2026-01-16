package android.gov.nist.javax.sip.stack;

import android.gov.nist.javax.sip.ClientTransactionExt;
import android.gov.nist.javax.sip.SipStackImpl;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface NioTlsChannelInterface {
    void addPlaintextBytes(byte[] bArr);

    ClientTransactionExt getEncapsulatedClientTransaction();

    SipStackImpl getSIPStack();

    ByteBuffer prepareAppDataBuffer();

    ByteBuffer prepareAppDataBuffer(int i);

    ByteBuffer prepareEncryptedDataBuffer();

    void sendEncryptedData(byte[] bArr);
}
