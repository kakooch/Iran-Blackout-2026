package ir.appp.rghapp.rubinoPostSlider;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.logger.MyLog;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;

/* loaded from: classes3.dex */
public class FileLoadOperationStream implements DataSource {
    private long bytesRemaining;
    private CountDownLatch countDownLatch;
    private int currentAccount;
    private int currentOffset;
    private DataSpec dataSpec;
    private PhotoViewerObject document;
    private RandomAccessFile file;
    private final TransferListener listener;
    private FileLoadOperation loadOperation;
    private boolean opened;
    private Uri uri;

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public /* synthetic */ Map getResponseHeaders() {
        return Collections.emptyMap();
    }

    public FileLoadOperationStream() {
        this(null);
    }

    public FileLoadOperationStream(TransferListener transferListener) {
        this.listener = transferListener;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        PhotoViewerObject photoViewerObject;
        int i;
        this.uri = dataSpec.uri;
        this.dataSpec = dataSpec;
        this.currentAccount = UserConfig.selectedAccount;
        PhotoViewerObject photoViewerObject2 = new PhotoViewerObject();
        this.document = photoViewerObject2;
        photoViewerObject2.filePath = this.uri.getQueryParameter("url");
        this.document.postId = this.uri.getQueryParameter("postid");
        this.document.storyId = this.uri.getQueryParameter("storyid");
        this.document.size = Utilities.parseInt(this.uri.getQueryParameter("size")).intValue();
        PhotoViewerObject photoViewerObject3 = this.document;
        String str = photoViewerObject3.postId;
        if (str != null) {
            photoViewerObject3.setForVideo(str, BuildConfig.FLAVOR, photoViewerObject3.filePath, 0, 0, 0, null);
        } else {
            String str2 = photoViewerObject3.storyId;
            if (str2 != null) {
                photoViewerObject3.setForStoryVideo(str2, photoViewerObject3.filePath, 0, 0, 0);
            }
        }
        MyLog.e("RubinoDownload", "RubinoDownload loadStreamFile Open");
        FileLoaderRubinoPost fileLoaderRubinoPost = FileLoaderRubinoPost.getInstance(this.currentAccount);
        PhotoViewerObject photoViewerObject4 = this.document;
        int i2 = (int) dataSpec.position;
        this.currentOffset = i2;
        FileLoadOperation fileLoadOperationLoadStreamFile = fileLoaderRubinoPost.loadStreamFile(this, photoViewerObject4, null, i2, true);
        this.loadOperation = fileLoadOperationLoadStreamFile;
        if (fileLoadOperationLoadStreamFile != null && (photoViewerObject = fileLoadOperationLoadStreamFile.fileInlineObject) != null && (i = photoViewerObject.size) > 0) {
            this.document.size = i;
        }
        long j = dataSpec.length;
        if (j == -1) {
            j = this.document.size - dataSpec.position;
        }
        this.bytesRemaining = j;
        if (j < 0) {
            throw new EOFException();
        }
        this.opened = true;
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            transferListener.onTransferStart(this, dataSpec, true);
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.loadOperation.getCurrentFile(), "r");
        this.file = randomAccessFile;
        randomAccessFile.seek(this.currentOffset);
        MyLog.e("RubinoDownload1", "RubinoDownload1 video request Stream open" + dataSpec.position);
        return this.bytesRemaining;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws InterruptedException, IOException {
        int downloadedLengthFromOffset = 0;
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesRemaining;
        if (j == 0) {
            return -1;
        }
        if (j < i2) {
            i2 = (int) j;
        }
        while (downloadedLengthFromOffset == 0) {
            try {
                downloadedLengthFromOffset = this.loadOperation.getDownloadedLengthFromOffset(this.currentOffset, i2);
                if (downloadedLengthFromOffset == 0) {
                    if (this.loadOperation.isPaused()) {
                        MyLog.e("RubinoDownload", "RubinoDownload loadStreamFile");
                        FileLoaderRubinoPost.getInstance(this.currentAccount).loadStreamFile(this, this.document, null, this.currentOffset, true);
                    }
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    this.countDownLatch = countDownLatch;
                    countDownLatch.await();
                }
            } catch (Exception e) {
                throw new IOException(e);
            }
        }
        this.file.readFully(bArr, i, downloadedLengthFromOffset);
        this.currentOffset += downloadedLengthFromOffset;
        this.bytesRemaining -= downloadedLengthFromOffset;
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            transferListener.onBytesTransferred(this, this.dataSpec, true, downloadedLengthFromOffset);
        }
        return downloadedLengthFromOffset;
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
        CountDownLatch countDownLatch = this.countDownLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
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
            TransferListener transferListener = this.listener;
            if (transferListener != null) {
                transferListener.onTransferEnd(this, this.dataSpec, true);
            }
        }
    }

    protected void newDataAvailable() {
        CountDownLatch countDownLatch = this.countDownLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }
}
