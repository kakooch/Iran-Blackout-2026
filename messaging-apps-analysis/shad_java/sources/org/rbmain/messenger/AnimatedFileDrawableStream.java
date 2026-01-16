package org.rbmain.messenger;

import java.util.concurrent.CountDownLatch;
import org.rbmain.tgnet.TLRPC$Document;

/* loaded from: classes4.dex */
public class AnimatedFileDrawableStream implements FileLoadOperationStream {
    private volatile boolean canceled;
    private CountDownLatch countDownLatch;
    private int currentAccount;
    private int debugCanceledCount;
    private boolean debugReportSend;
    private TLRPC$Document document;
    private String finishedFilePath;
    private boolean finishedLoadingFile;
    private long lastOffset;
    private FileLoadOperation loadOperation;
    private int loadingPriority;
    private ImageLocation location;
    private Object parentObject;
    private boolean preview;
    private final Object sync = new Object();
    private boolean waitingForLoad;

    public AnimatedFileDrawableStream(TLRPC$Document tLRPC$Document, ImageLocation imageLocation, Object obj, int i, boolean z, int i2) {
        this.document = tLRPC$Document;
        this.location = imageLocation;
        this.parentObject = obj;
        this.currentAccount = i;
        this.preview = z;
        this.loadingPriority = i2;
        this.loadOperation = FileLoader.getInstance(i).loadStreamFile(this, this.document, this.location, this.parentObject, 0, this.preview);
    }

    public boolean isFinishedLoadingFile() {
        return this.finishedLoadingFile;
    }

    public String getFinishedFilePath() {
        return this.finishedFilePath;
    }

    public int read(int i, int i2) throws InterruptedException {
        long j;
        synchronized (this.sync) {
            if (this.canceled) {
                int i3 = this.debugCanceledCount + 1;
                this.debugCanceledCount = i3;
                if (!this.debugReportSend && i3 > 200) {
                    this.debugReportSend = true;
                    if (BuildVars.DEBUG_PRIVATE_VERSION) {
                        throw new RuntimeException("infinity stream reading!!!");
                    }
                    FileLog.e(new RuntimeException("infinity stream reading!!!"));
                }
                return 0;
            }
            if (i2 == 0) {
                return 0;
            }
            long j2 = 0;
            while (j2 == 0) {
                try {
                    int[] downloadedLengthFromOffset = this.loadOperation.getDownloadedLengthFromOffset(i, i2);
                    j = downloadedLengthFromOffset[0];
                    try {
                        if (!this.finishedLoadingFile && downloadedLengthFromOffset[1] != 0) {
                            this.finishedLoadingFile = true;
                            this.finishedFilePath = this.loadOperation.getCacheFileFinal().getAbsolutePath();
                        }
                    } catch (Exception e) {
                        e = e;
                        j2 = j;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                if (j == 0) {
                    synchronized (this.sync) {
                        if (this.canceled) {
                            cancelLoadingInternal();
                            return 0;
                        }
                        this.countDownLatch = new CountDownLatch(1);
                        if (this.loadOperation.isPaused() || this.lastOffset != i || this.preview) {
                            FileLoadOperation fileLoadOperationLoadStreamFile = FileLoader.getInstance(this.currentAccount).loadStreamFile(this, this.document, this.location, this.parentObject, i, this.preview);
                            FileLoadOperation fileLoadOperation = this.loadOperation;
                            if (fileLoadOperation != fileLoadOperationLoadStreamFile) {
                                fileLoadOperation.removeStreamListener(this);
                                this.loadOperation = fileLoadOperationLoadStreamFile;
                            }
                            this.lastOffset = i + j;
                        }
                        synchronized (this.sync) {
                            if (this.canceled) {
                                this.countDownLatch = null;
                                cancelLoadingInternal();
                                return 0;
                            }
                        }
                        if (!this.preview) {
                            FileLoader.getInstance(this.currentAccount).setLoadingVideo(this.document, false, true);
                        }
                        CountDownLatch countDownLatch = this.countDownLatch;
                        if (countDownLatch != null) {
                            this.waitingForLoad = true;
                            countDownLatch.await();
                            this.waitingForLoad = false;
                        }
                        e = e;
                        j2 = j;
                        FileLog.e((Throwable) e, false);
                        return (int) j2;
                    }
                }
                j2 = j;
            }
            this.lastOffset = i + j2;
            return (int) j2;
        }
    }

    public void cancel() {
        cancel(true);
    }

    public void cancel(boolean z) {
        if (this.canceled) {
            return;
        }
        synchronized (this.sync) {
            CountDownLatch countDownLatch = this.countDownLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
                this.countDownLatch = null;
                if (z && !this.canceled && !this.preview) {
                    FileLoader.getInstance(this.currentAccount).removeLoadingVideo(this.document, false, true);
                }
            }
            Object obj = this.parentObject;
            if (obj instanceof MessageObject) {
                MessageObject messageObject = (MessageObject) obj;
                if (DownloadController.getInstance(messageObject.currentAccount).isDownloading(messageObject.getId())) {
                    z = false;
                }
            }
            if (z) {
                cancelLoadingInternal();
            }
            this.canceled = true;
        }
    }

    private void cancelLoadingInternal() {
        FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.document);
        if (this.location != null) {
            FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.location.location, "mp4");
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

    @Override // org.rbmain.messenger.FileLoadOperationStream
    public void newDataAvailable() {
        CountDownLatch countDownLatch = this.countDownLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
            this.countDownLatch = null;
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }
}
