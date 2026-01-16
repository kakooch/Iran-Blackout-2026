package org.rbmain.messenger.secretmedia;

import android.net.Uri;
import com.google.android.exoplayer2t.upstream.BaseDataSource;
import com.google.android.exoplayer2t.upstream.DataSpec;
import com.google.android.exoplayer2t.upstream.TransferListener;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.Utilities;

/* loaded from: classes4.dex */
public final class EncryptedFileDataSource extends BaseDataSource {
    private long bytesRemaining;
    private RandomAccessFile file;
    private int fileOffset;
    private byte[] iv;
    private byte[] key;
    private boolean opened;
    private Uri uri;

    @Override // com.google.android.exoplayer2t.upstream.BaseDataSource, com.google.android.exoplayer2t.upstream.DataSource
    public /* bridge */ /* synthetic */ Map<String, List<String>> getResponseHeaders() {
        return Collections.emptyMap();
    }

    public static class EncryptedFileDataSourceException extends IOException {
        public EncryptedFileDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public EncryptedFileDataSource() {
        super(false);
        this.key = new byte[32];
        this.iv = new byte[16];
    }

    @Deprecated
    public EncryptedFileDataSource(TransferListener transferListener) {
        this();
        if (transferListener != null) {
            addTransferListener(transferListener);
        }
    }

    @Override // com.google.android.exoplayer2t.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        try {
            this.uri = dataSpec.uri;
            File file = new File(dataSpec.uri.getPath());
            String name = file.getName();
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(FileLoader.getInternalCacheDir(), name + ".key"), "r");
            randomAccessFile.read(this.key);
            randomAccessFile.read(this.iv);
            randomAccessFile.close();
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            this.file = randomAccessFile2;
            randomAccessFile2.seek(dataSpec.position);
            this.fileOffset = (int) dataSpec.position;
            long length = dataSpec.length;
            if (length == -1) {
                length = this.file.length() - dataSpec.position;
            }
            this.bytesRemaining = length;
            if (length < 0) {
                throw new EOFException();
            }
            this.opened = true;
            transferStarted(dataSpec);
            return this.bytesRemaining;
        } catch (IOException e) {
            throw new EncryptedFileDataSourceException(e);
        }
    }

    @Override // com.google.android.exoplayer2t.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesRemaining;
        if (j == 0) {
            return -1;
        }
        try {
            int i3 = this.file.read(bArr, i, (int) Math.min(j, i2));
            Utilities.aesCtrDecryptionByteArray(bArr, this.key, this.iv, i, i3, this.fileOffset);
            this.fileOffset += i3;
            if (i3 > 0) {
                this.bytesRemaining -= i3;
                bytesTransferred(i3);
            }
            return i3;
        } catch (IOException e) {
            throw new EncryptedFileDataSourceException(e);
        }
    }

    @Override // com.google.android.exoplayer2t.upstream.DataSource
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2t.upstream.DataSource
    public void close() throws EncryptedFileDataSourceException {
        this.uri = null;
        this.fileOffset = 0;
        try {
            try {
                RandomAccessFile randomAccessFile = this.file;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e) {
                throw new EncryptedFileDataSourceException(e);
            }
        } finally {
            this.file = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        }
    }
}
