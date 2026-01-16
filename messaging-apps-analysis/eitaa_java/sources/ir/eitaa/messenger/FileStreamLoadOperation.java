package ir.eitaa.messenger;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$TL_document;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeFilename;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public class FileStreamLoadOperation extends BaseDataSource implements FileLoadOperationStream {
    private long bytesRemaining;
    private CountDownLatch countDownLatch;
    private int currentAccount;
    private int currentOffset;
    private TLRPC$Document document;
    private RandomAccessFile file;
    private FileLoadOperation loadOperation;
    private boolean opened;
    private Object parentObject;
    private Uri uri;

    @Override // com.google.android.exoplayer2.upstream.BaseDataSource, com.google.android.exoplayer2.upstream.DataSource
    public /* bridge */ /* synthetic */ Map<String, List<String>> getResponseHeaders() {
        return Collections.emptyMap();
    }

    public FileStreamLoadOperation() {
        super(false);
    }

    @Deprecated
    public FileStreamLoadOperation(TransferListener listener) {
        this();
        if (listener != null) {
            addTransferListener(listener);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        Uri uri = dataSpec.uri;
        this.uri = uri;
        int iIntValue = Utilities.parseInt(uri.getQueryParameter("account")).intValue();
        this.currentAccount = iIntValue;
        this.parentObject = FileLoader.getInstance(iIntValue).getParentObject(Utilities.parseInt(this.uri.getQueryParameter("rid")).intValue());
        TLRPC$TL_document tLRPC$TL_document = new TLRPC$TL_document();
        this.document = tLRPC$TL_document;
        tLRPC$TL_document.access_hash = Utilities.parseLong(this.uri.getQueryParameter("hash")).longValue();
        this.document.id = Utilities.parseLong(this.uri.getQueryParameter("id")).longValue();
        this.document.size = Utilities.parseInt(this.uri.getQueryParameter("size")).intValue();
        this.document.dc_id = Utilities.parseInt(this.uri.getQueryParameter("dc")).intValue();
        this.document.mime_type = this.uri.getQueryParameter("mime");
        this.document.file_reference = Utilities.hexToBytes(this.uri.getQueryParameter("reference"));
        TLRPC$TL_documentAttributeFilename tLRPC$TL_documentAttributeFilename = new TLRPC$TL_documentAttributeFilename();
        tLRPC$TL_documentAttributeFilename.file_name = this.uri.getQueryParameter("name");
        this.document.attributes.add(tLRPC$TL_documentAttributeFilename);
        if (this.document.mime_type.startsWith(MediaStreamTrack.VIDEO_TRACK_KIND)) {
            this.document.attributes.add(new TLRPC$TL_documentAttributeVideo());
        } else if (this.document.mime_type.startsWith(MediaStreamTrack.AUDIO_TRACK_KIND)) {
            this.document.attributes.add(new TLRPC$TL_documentAttributeAudio());
        }
        FileLoader fileLoader = FileLoader.getInstance(this.currentAccount);
        TLRPC$Document tLRPC$Document = this.document;
        Object obj = this.parentObject;
        int i = (int) dataSpec.position;
        this.currentOffset = i;
        this.loadOperation = fileLoader.loadStreamFile(this, tLRPC$Document, null, obj, i, false);
        long j = dataSpec.length;
        if (j == -1) {
            j = this.document.size - dataSpec.position;
        }
        this.bytesRemaining = j;
        if (j < 0) {
            throw new EOFException();
        }
        this.opened = true;
        transferStarted(dataSpec);
        if (this.loadOperation != null) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.loadOperation.getCurrentFile(), "r");
            this.file = randomAccessFile;
            randomAccessFile.seek(this.currentOffset);
        }
        return this.bytesRemaining;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] buffer, int offset, int readLength) throws InterruptedException, IOException {
        if (readLength == 0) {
            return 0;
        }
        long j = this.bytesRemaining;
        if (j == 0) {
            return -1;
        }
        if (j < readLength) {
            readLength = (int) j;
        }
        int i = 0;
        while (i == 0) {
            try {
                if (!this.opened) {
                    break;
                }
                i = this.loadOperation.getDownloadedLengthFromOffset(this.currentOffset, readLength)[0];
                if (i == 0) {
                    FileLoader.getInstance(this.currentAccount).loadStreamFile(this, this.document, null, this.parentObject, this.currentOffset, false);
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    this.countDownLatch = countDownLatch;
                    countDownLatch.await();
                }
            } catch (Exception e) {
                throw new IOException(e);
            }
        }
        if (!this.opened) {
            return 0;
        }
        this.file.readFully(buffer, offset, i);
        this.currentOffset += i;
        this.bytesRemaining -= i;
        bytesTransferred(i);
        return i;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        FileLoadOperation fileLoadOperation = this.loadOperation;
        if (fileLoadOperation != null) {
            fileLoadOperation.removeStreamListener(this);
        }
        RandomAccessFile randomAccessFile = this.file;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (Exception e) {
                FileLog.e(e);
            }
            this.file = null;
        }
        this.uri = null;
        if (this.opened) {
            this.opened = false;
            transferEnded();
        }
        CountDownLatch countDownLatch = this.countDownLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    @Override // ir.eitaa.messenger.FileLoadOperationStream
    public void newDataAvailable() {
        CountDownLatch countDownLatch = this.countDownLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }
}
