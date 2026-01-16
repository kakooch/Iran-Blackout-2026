package ir.eitaa.messenger;

import ir.eitaa.tgnet.TLRPC$Document;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public class AnimatedFileDrawableStream implements FileLoadOperationStream {
    private volatile boolean canceled;
    private CountDownLatch countDownLatch;
    private int currentAccount;
    private TLRPC$Document document;
    private String finishedFilePath;
    private boolean finishedLoadingFile;
    private boolean ignored;
    private int lastOffset;
    private FileLoadOperation loadOperation;
    private ImageLocation location;
    private Object parentObject;
    private boolean preview;
    private final Object sync = new Object();
    private boolean waitingForLoad;

    public AnimatedFileDrawableStream(TLRPC$Document d, ImageLocation l, Object p, int a, boolean prev) {
        this.document = d;
        this.location = l;
        this.parentObject = p;
        this.currentAccount = a;
        this.preview = prev;
        this.loadOperation = FileLoader.getInstance(a).loadStreamFile(this, this.document, this.location, this.parentObject, 0, this.preview);
    }

    public boolean isFinishedLoadingFile() {
        return this.finishedLoadingFile;
    }

    public String getFinishedFilePath() {
        return this.finishedFilePath;
    }

    public int read(int offset, int readLength) throws InterruptedException {
        synchronized (this.sync) {
            if (this.canceled) {
                return 0;
            }
            if (readLength == 0) {
                return 0;
            }
            int i = 0;
            while (i == 0) {
                try {
                    int[] downloadedLengthFromOffset = this.loadOperation.getDownloadedLengthFromOffset(offset, readLength);
                    i = downloadedLengthFromOffset[0];
                    if (!this.finishedLoadingFile && downloadedLengthFromOffset[1] != 0) {
                        this.finishedLoadingFile = true;
                        this.finishedFilePath = this.loadOperation.getCacheFileFinal().getAbsolutePath();
                    }
                    if (i == 0) {
                        if (this.loadOperation.isPaused() || this.lastOffset != offset || this.preview) {
                            FileLoader.getInstance(this.currentAccount).loadStreamFile(this, this.document, this.location, this.parentObject, offset, this.preview);
                        }
                        synchronized (this.sync) {
                            if (this.canceled) {
                                return 0;
                            }
                            this.countDownLatch = new CountDownLatch(1);
                        }
                        if (!this.preview) {
                            FileLoader.getInstance(this.currentAccount).setLoadingVideo(this.document, false, true);
                        }
                        this.waitingForLoad = true;
                        this.countDownLatch.await();
                        this.waitingForLoad = false;
                    }
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            this.lastOffset = offset + i;
            return i;
        }
    }

    public void cancel() {
        cancel(true);
    }

    public void cancel(boolean removeLoading) {
        synchronized (this.sync) {
            CountDownLatch countDownLatch = this.countDownLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
                if (removeLoading && !this.canceled && !this.preview) {
                    FileLoader.getInstance(this.currentAccount).removeLoadingVideo(this.document, false, true);
                }
            }
            this.canceled = true;
        }
    }

    public void reset() {
        synchronized (this.sync) {
            this.canceled = false;
        }
    }

    public TLRPC$Document getDocument() {
        return this.document;
    }

    public ImageLocation getLocation() {
        return this.location;
    }

    public Object getParentObject() {
        return this.document;
    }

    public boolean isPreview() {
        return this.preview;
    }

    public int getCurrentAccount() {
        return this.currentAccount;
    }

    public boolean isWaitingForLoad() {
        return this.waitingForLoad;
    }

    @Override // ir.eitaa.messenger.FileLoadOperationStream
    public void newDataAvailable() {
        CountDownLatch countDownLatch = this.countDownLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }
}
