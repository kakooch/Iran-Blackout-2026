package org.rbmain.messenger;

import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$TL_inputFile;
import org.rbmain.tgnet.TLRPC$TL_secureFile;

/* loaded from: classes4.dex */
public class SecureDocument extends TLObject {
    public byte[] fileHash;
    public byte[] fileSecret;
    public TLRPC$TL_inputFile inputFile;
    public String path;
    public SecureDocumentKey secureDocumentKey;
    public TLRPC$TL_secureFile secureFile;
    public int type;

    public SecureDocument(SecureDocumentKey secureDocumentKey, TLRPC$TL_secureFile tLRPC$TL_secureFile, String str, byte[] bArr, byte[] bArr2) {
        this.secureDocumentKey = secureDocumentKey;
        this.secureFile = tLRPC$TL_secureFile;
        this.path = str;
        this.fileHash = bArr;
        this.fileSecret = bArr2;
    }
}
