package ir.eitaa.messenger.secretmedia;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.Utilities;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class EncryptedFileDataSource extends BaseDataSource {
    private long bytesRemaining;
    private RandomAccessFile file;
    private int fileOffset;
    private byte[] iv;
    private byte[] key;
    private boolean opened;
    private Uri uri;

    @Override // com.google.android.exoplayer2.upstream.BaseDataSource, com.google.android.exoplayer2.upstream.DataSource
    public /* bridge */ /* synthetic */ Map<String, List<String>> getResponseHeaders() {
        return Collections.emptyMap();
    }

    public static class EncryptedFileDataSourceException extends IOException {
        public EncryptedFileDataSourceException(IOException cause) {
            super(cause);
        }
    }

    public EncryptedFileDataSource() {
        super(false);
        this.key = new byte[32];
        this.iv = new byte[16];
    }

    @Deprecated
    public EncryptedFileDataSource(TransferListener listener) {
        this();
        if (listener != null) {
            addTransferListener(listener);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
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

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] buffer, int offset, int readLength) throws IOException {
        if (readLength == 0) {
            return 0;
        }
        long j = this.bytesRemaining;
        if (j == 0) {
            return -1;
        }
        try {
            int i = this.file.read(buffer, offset, (int) Math.min(j, readLength));
            Utilities.aesCtrDecryptionByteArray(buffer, this.key, this.iv, offset, i, this.fileOffset);
            this.fileOffset += i;
            if (i > 0) {
                this.bytesRemaining -= i;
                bytesTransferred(i);
            }
            return i;
        } catch (IOException e) {
            throw new EncryptedFileDataSourceException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
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
