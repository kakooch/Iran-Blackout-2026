package ir.eitaa.ui.Components;

import android.graphics.Bitmap;
import android.text.TextUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.ui.Cells.ChatMessageCell;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public class SlotsDrawable extends RLottieDrawable {
    private ReelValue center;
    private int[] frameCounts;
    private int[] frameNums;
    private ReelValue left;
    private long[] nativePtrs;
    private boolean playWinAnimation;
    private ReelValue right;
    private int[] secondFrameCounts;
    private int[] secondFrameNums;
    private long[] secondNativePtrs;

    enum ReelValue {
        bar,
        berries,
        lemon,
        seven,
        sevenWin
    }

    public SlotsDrawable(String diceEmoji, int w, int h) {
        super(diceEmoji, w, h);
        this.nativePtrs = new long[5];
        this.frameCounts = new int[5];
        this.frameNums = new int[5];
        this.secondNativePtrs = new long[3];
        this.secondFrameCounts = new int[3];
        this.secondFrameNums = new int[3];
        this.loadFrameRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$SlotsDrawable$Ngi0_RLngpK3H6LZAIXGr8ExPYs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$SlotsDrawable();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$SlotsDrawable() {
        int frame;
        Runnable runnable;
        if (this.isRecycled) {
            return;
        }
        if (this.nativePtr == 0 || (this.isDice == 2 && this.secondNativePtr == 0)) {
            CountDownLatch countDownLatch = this.frameWaitSync;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            RLottieDrawable.uiHandler.post(this.uiRunnableNoFrame);
            return;
        }
        if (this.backgroundBitmap == null) {
            try {
                this.backgroundBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        if (this.backgroundBitmap != null) {
            try {
                if (this.isDice == 1) {
                    int i = 0;
                    frame = -1;
                    while (true) {
                        long[] jArr = this.nativePtrs;
                        if (i >= jArr.length) {
                            break;
                        }
                        frame = RLottieDrawable.getFrame(jArr[i], this.frameNums[i], this.backgroundBitmap, this.width, this.height, this.backgroundBitmap.getRowBytes(), i == 0);
                        if (i != 0) {
                            int[] iArr = this.frameNums;
                            if (iArr[i] + 1 < this.frameCounts[i]) {
                                iArr[i] = iArr[i] + 1;
                            } else if (i != 4) {
                                iArr[i] = 0;
                                this.nextFrameIsLast = false;
                                if (this.secondNativePtr != 0) {
                                    this.isDice = 2;
                                }
                            }
                        }
                        i++;
                    }
                } else {
                    if (this.setLastFrame) {
                        int i2 = 0;
                        while (true) {
                            int[] iArr2 = this.secondFrameNums;
                            if (i2 >= iArr2.length) {
                                break;
                            }
                            iArr2[i2] = this.secondFrameCounts[i2] - 1;
                            i2++;
                        }
                    }
                    if (this.playWinAnimation) {
                        int[] iArr3 = this.frameNums;
                        if (iArr3[0] + 1 < this.frameCounts[0]) {
                            iArr3[0] = iArr3[0] + 1;
                        } else {
                            iArr3[0] = -1;
                        }
                    }
                    RLottieDrawable.getFrame(this.nativePtrs[0], Math.max(this.frameNums[0], 0), this.backgroundBitmap, this.width, this.height, this.backgroundBitmap.getRowBytes(), true);
                    int i3 = 0;
                    while (true) {
                        long[] jArr2 = this.secondNativePtrs;
                        if (i3 >= jArr2.length) {
                            break;
                        }
                        long j = jArr2[i3];
                        int[] iArr4 = this.secondFrameNums;
                        RLottieDrawable.getFrame(j, iArr4[i3] >= 0 ? iArr4[i3] : this.secondFrameCounts[i3] - 1, this.backgroundBitmap, this.width, this.height, this.backgroundBitmap.getRowBytes(), false);
                        if (!this.nextFrameIsLast) {
                            int[] iArr5 = this.secondFrameNums;
                            if (iArr5[i3] + 1 < this.secondFrameCounts[i3]) {
                                iArr5[i3] = iArr5[i3] + 1;
                            } else {
                                iArr5[i3] = -1;
                            }
                        }
                        i3++;
                    }
                    frame = RLottieDrawable.getFrame(this.nativePtrs[4], this.frameNums[4], this.backgroundBitmap, this.width, this.height, this.backgroundBitmap.getRowBytes(), false);
                    int[] iArr6 = this.frameNums;
                    if (iArr6[4] + 1 < this.frameCounts[4]) {
                        iArr6[4] = iArr6[4] + 1;
                    }
                    int[] iArr7 = this.secondFrameNums;
                    if (iArr7[0] == -1 && iArr7[1] == -1 && iArr7[2] == -1) {
                        this.nextFrameIsLast = true;
                        this.autoRepeatPlayCount++;
                    }
                    ReelValue reelValue = this.left;
                    ReelValue reelValue2 = this.right;
                    if (reelValue == reelValue2 && reelValue2 == this.center) {
                        if (this.secondFrameNums[0] == this.secondFrameCounts[0] - 100) {
                            this.playWinAnimation = true;
                            if (reelValue == ReelValue.sevenWin && (runnable = this.onFinishCallback.get()) != null) {
                                AndroidUtilities.runOnUIThread(runnable);
                            }
                        }
                    } else {
                        this.frameNums[0] = -1;
                    }
                }
                if (frame == -1) {
                    RLottieDrawable.uiHandler.post(this.uiRunnableNoFrame);
                    CountDownLatch countDownLatch2 = this.frameWaitSync;
                    if (countDownLatch2 != null) {
                        countDownLatch2.countDown();
                        return;
                    }
                    return;
                }
                this.nextRenderingBitmap = this.backgroundBitmap;
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        RLottieDrawable.uiHandler.post(this.uiRunnable);
        CountDownLatch countDownLatch3 = this.frameWaitSync;
        if (countDownLatch3 != null) {
            countDownLatch3.countDown();
        }
    }

    private ReelValue reelValue(int rawValue) {
        if (rawValue == 0) {
            return ReelValue.bar;
        }
        if (rawValue == 1) {
            return ReelValue.berries;
        }
        if (rawValue == 2) {
            return ReelValue.lemon;
        }
        return ReelValue.seven;
    }

    private void init(int rawValue) {
        int i = rawValue - 1;
        ReelValue reelValue = reelValue(i & 3);
        ReelValue reelValue2 = reelValue((i >> 2) & 3);
        ReelValue reelValue3 = reelValue(i >> 4);
        ReelValue reelValue4 = ReelValue.seven;
        if (reelValue == reelValue4 && reelValue2 == reelValue4 && reelValue3 == reelValue4) {
            reelValue = ReelValue.sevenWin;
            reelValue3 = reelValue;
            reelValue2 = reelValue3;
        }
        this.left = reelValue;
        this.center = reelValue2;
        this.right = reelValue3;
    }

    public boolean setBaseDice(final ChatMessageCell messageCell, final TLRPC$TL_messages_stickerSet stickerSet) {
        if (this.nativePtr == 0 && !this.loadingInBackground) {
            this.loadingInBackground = true;
            final MessageObject messageObject = messageCell.getMessageObject();
            final int i = messageCell.getMessageObject().currentAccount;
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$SlotsDrawable$7Yb5826aqvKNhnMhYl-lLyVtDI4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setBaseDice$5$SlotsDrawable(stickerSet, i, messageObject, messageCell);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setBaseDice$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setBaseDice$5$SlotsDrawable(final TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet, final int i, final MessageObject messageObject, final ChatMessageCell chatMessageCell) {
        if (this.destroyAfterLoading) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$SlotsDrawable$iqoqz6H4SH6V1tE6k8ERtL_oEUE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setBaseDice$1$SlotsDrawable();
                }
            });
            return;
        }
        int i2 = 0;
        boolean z = false;
        while (true) {
            long[] jArr = this.nativePtrs;
            if (i2 >= jArr.length) {
                break;
            }
            if (jArr[i2] == 0) {
                int i3 = 2;
                if (i2 == 0) {
                    i3 = 1;
                } else if (i2 == 1) {
                    i3 = 8;
                } else if (i2 == 2) {
                    i3 = 14;
                } else if (i2 == 3) {
                    i3 = 20;
                }
                final TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickerSet.documents.get(i3);
                String res = RLottieDrawable.readRes(FileLoader.getPathToAttach(tLRPC$Document, true), 0);
                if (TextUtils.isEmpty(res)) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$SlotsDrawable$ZWRyyCQCQmZvfRoq62EnGYeVAiw
                        @Override // java.lang.Runnable
                        public final void run() {
                            SlotsDrawable.lambda$setBaseDice$2(tLRPC$Document, i, messageObject, chatMessageCell, tLRPC$TL_messages_stickerSet);
                        }
                    });
                    z = true;
                } else {
                    this.nativePtrs[i2] = RLottieDrawable.createWithJson(res, "dice", this.metaData, null);
                    this.frameCounts[i2] = this.metaData[0];
                }
            }
            i2++;
        }
        if (z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$SlotsDrawable$Kh0J6fZUkTqfmRxhjVf54s44_DY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setBaseDice$3$SlotsDrawable();
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$SlotsDrawable$1rkZEd3YC3t3EBBjX8HemNRDuzs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setBaseDice$4$SlotsDrawable(i, chatMessageCell);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setBaseDice$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setBaseDice$1$SlotsDrawable() {
        this.loadingInBackground = false;
        if (this.secondLoadingInBackground || !this.destroyAfterLoading) {
            return;
        }
        recycle();
    }

    static /* synthetic */ void lambda$setBaseDice$2(TLRPC$Document tLRPC$Document, int i, MessageObject messageObject, ChatMessageCell chatMessageCell, TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        DownloadController.getInstance(i).addLoadingFileObserver(FileLoader.getAttachFileName(tLRPC$Document), messageObject, chatMessageCell);
        FileLoader.getInstance(i).loadFile(tLRPC$Document, tLRPC$TL_messages_stickerSet, 1, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setBaseDice$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setBaseDice$3$SlotsDrawable() {
        this.loadingInBackground = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setBaseDice$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setBaseDice$4$SlotsDrawable(int i, ChatMessageCell chatMessageCell) {
        this.loadingInBackground = false;
        if (!this.secondLoadingInBackground && this.destroyAfterLoading) {
            recycle();
            return;
        }
        this.nativePtr = this.nativePtrs[0];
        DownloadController.getInstance(i).removeLoadingFileObserver(chatMessageCell);
        this.timeBetweenFrames = Math.max(16, (int) (1000.0f / this.metaData[1]));
        scheduleNextGetFrame();
        invalidateInternal();
    }

    public boolean setDiceNumber(final ChatMessageCell messageCell, int number, final TLRPC$TL_messages_stickerSet stickerSet, final boolean instant) {
        if (this.secondNativePtr == 0 && !this.secondLoadingInBackground) {
            init(number);
            final MessageObject messageObject = messageCell.getMessageObject();
            final int i = messageCell.getMessageObject().currentAccount;
            this.secondLoadingInBackground = true;
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$SlotsDrawable$0A2GZGShzOajdJqQ0Uw4xFxf_iU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setDiceNumber$10$SlotsDrawable(stickerSet, i, messageObject, messageCell, instant);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d1  */
    /* renamed from: lambda$setDiceNumber$10, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$setDiceNumber$10$SlotsDrawable(final ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet r18, final int r19, final ir.eitaa.messenger.MessageObject r20, final ir.eitaa.ui.Cells.ChatMessageCell r21, final boolean r22) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.SlotsDrawable.lambda$setDiceNumber$10$SlotsDrawable(ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet, int, ir.eitaa.messenger.MessageObject, ir.eitaa.ui.Cells.ChatMessageCell, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setDiceNumber$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDiceNumber$6$SlotsDrawable() {
        this.secondLoadingInBackground = false;
        if (this.loadingInBackground || !this.destroyAfterLoading) {
            return;
        }
        recycle();
    }

    static /* synthetic */ void lambda$setDiceNumber$7(TLRPC$Document tLRPC$Document, int i, MessageObject messageObject, ChatMessageCell chatMessageCell, TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        DownloadController.getInstance(i).addLoadingFileObserver(FileLoader.getAttachFileName(tLRPC$Document), messageObject, chatMessageCell);
        FileLoader.getInstance(i).loadFile(tLRPC$Document, tLRPC$TL_messages_stickerSet, 1, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setDiceNumber$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDiceNumber$8$SlotsDrawable() {
        this.secondLoadingInBackground = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setDiceNumber$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDiceNumber$9$SlotsDrawable(boolean z, int i, ChatMessageCell chatMessageCell) {
        if (z && this.nextRenderingBitmap == null && this.renderingBitmap == null && this.loadFrameTask == null) {
            this.isDice = 2;
            this.setLastFrame = true;
        }
        this.secondLoadingInBackground = false;
        if (!this.loadingInBackground && this.destroyAfterLoading) {
            recycle();
            return;
        }
        this.secondNativePtr = this.secondNativePtrs[0];
        DownloadController.getInstance(i).removeLoadingFileObserver(chatMessageCell);
        this.timeBetweenFrames = Math.max(16, (int) (1000.0f / this.metaData[1]));
        scheduleNextGetFrame();
        invalidateInternal();
    }

    @Override // ir.eitaa.ui.Components.RLottieDrawable
    public void recycle() {
        int i = 0;
        this.isRunning = false;
        this.isRecycled = true;
        checkRunningTasks();
        if (this.loadingInBackground || this.secondLoadingInBackground) {
            this.destroyAfterLoading = true;
            return;
        }
        if (this.loadFrameTask != null || this.cacheGenerateTask != null) {
            this.destroyWhenDone = true;
            return;
        }
        int i2 = 0;
        while (true) {
            long[] jArr = this.nativePtrs;
            if (i2 >= jArr.length) {
                break;
            }
            if (jArr[i2] != 0) {
                if (jArr[i2] == this.nativePtr) {
                    this.nativePtr = 0L;
                }
                RLottieDrawable.destroy(this.nativePtrs[i2]);
                this.nativePtrs[i2] = 0;
            }
            i2++;
        }
        while (true) {
            long[] jArr2 = this.secondNativePtrs;
            if (i >= jArr2.length) {
                recycleResources();
                return;
            }
            if (jArr2[i] != 0) {
                if (jArr2[i] == this.secondNativePtr) {
                    this.secondNativePtr = 0L;
                }
                RLottieDrawable.destroy(this.secondNativePtrs[i]);
                this.secondNativePtrs[i] = 0;
            }
            i++;
        }
    }

    @Override // ir.eitaa.ui.Components.RLottieDrawable
    protected void decodeFrameFinishedInternal() {
        if (this.destroyWhenDone) {
            checkRunningTasks();
            if (this.loadFrameTask == null && this.cacheGenerateTask == null) {
                int i = 0;
                int i2 = 0;
                while (true) {
                    long[] jArr = this.nativePtrs;
                    if (i2 >= jArr.length) {
                        break;
                    }
                    if (jArr[i2] != 0) {
                        RLottieDrawable.destroy(jArr[i2]);
                        this.nativePtrs[i2] = 0;
                    }
                    i2++;
                }
                while (true) {
                    long[] jArr2 = this.secondNativePtrs;
                    if (i >= jArr2.length) {
                        break;
                    }
                    if (jArr2[i] != 0) {
                        RLottieDrawable.destroy(jArr2[i]);
                        this.secondNativePtrs[i] = 0;
                    }
                    i++;
                }
            }
        }
        if (this.nativePtr == 0 && this.secondNativePtr == 0) {
            recycleResources();
            return;
        }
        this.waitingForNextTask = true;
        if (!hasParentView()) {
            stop();
        }
        scheduleNextGetFrame();
    }
}
