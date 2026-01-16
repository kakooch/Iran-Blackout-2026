package ir.eitaa.messenger.secretmedia;

import ir.eitaa.messenger.SecureDocumentKey;
import ir.eitaa.messenger.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public class EncryptedFileInputStream extends FileInputStream {
    private static final int MODE_CBC = 1;
    private static final int MODE_CTR = 0;
    private int currentMode;
    private int fileOffset;
    private byte[] iv;
    private byte[] key;

    public EncryptedFileInputStream(File file, File keyFile) throws Exception {
        super(file);
        this.key = new byte[32];
        this.iv = new byte[16];
        this.currentMode = 0;
        RandomAccessFile randomAccessFile = new RandomAccessFile(keyFile, "r");
        randomAccessFile.read(this.key, 0, 32);
        randomAccessFile.read(this.iv, 0, 16);
        randomAccessFile.close();
    }

    public EncryptedFileInputStream(File file, SecureDocumentKey secureDocumentKey) throws Exception {
        super(file);
        byte[] bArr = new byte[32];
        this.key = bArr;
        this.iv = new byte[16];
        this.currentMode = 1;
        System.arraycopy(secureDocumentKey.file_key, 0, bArr, 0, bArr.length);
        byte[] bArr2 = secureDocumentKey.file_iv;
        byte[] bArr3 = this.iv;
        System.arraycopy(bArr2, 0, bArr3, 0, bArr3.length);
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.currentMode == 1 && this.fileOffset == 0) {
            super.read(new byte[32], 0, 32);
            Utilities.aesCbcEncryptionByteArraySafe(b, this.key, this.iv, off, len, this.fileOffset, 0);
            this.fileOffset += 32;
            skip((r3[0] & 255) - 32);
        }
        int i = super.read(b, off, len);
        int i2 = this.currentMode;
        if (i2 == 1) {
            Utilities.aesCbcEncryptionByteArraySafe(b, this.key, this.iv, off, len, this.fileOffset, 0);
        } else if (i2 == 0) {
            Utilities.aesCtrDecryptionByteArray(b, this.key, this.iv, off, len, this.fileOffset);
        }
        this.fileOffset += len;
        return i;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public long skip(long n) throws IOException {
        this.fileOffset = (int) (this.fileOffset + n);
        return super.skip(n);
    }

    public static void decryptBytesWithKeyFile(byte[] bytes, int offset, int length, SecureDocumentKey secureDocumentKey) {
        Utilities.aesCbcEncryptionByteArraySafe(bytes, secureDocumentKey.file_key, secureDocumentKey.file_iv, offset, length, 0, 0);
    }

    public static void decryptBytesWithKeyFile(byte[] bytes, int offset, int length, File keyFile) throws Exception {
        byte[] bArr = new byte[32];
        byte[] bArr2 = new byte[16];
        RandomAccessFile randomAccessFile = new RandomAccessFile(keyFile, "r");
        randomAccessFile.read(bArr, 0, 32);
        randomAccessFile.read(bArr2, 0, 16);
        randomAccessFile.close();
        Utilities.aesCtrDecryptionByteArray(bytes, bArr, bArr2, offset, length, 0);
    }
}
