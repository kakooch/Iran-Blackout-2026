package ir.appp.rghapp.videocompress;

import android.util.SparseArray;
import ir.appp.rghapp.videocompress.RGHCompress;
import ir.resaneh1.iptv.logger.MyLog;
import java.io.File;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.VideoEditedInfo;

/* loaded from: classes3.dex */
public class RGHCompress {
    private static volatile RGHCompress Instance;
    private final Object videoConvertSync = new Object();
    private ArrayList<VideoEditedInfo> videoConvertQueue = new ArrayList<>();
    private SparseArray<VideoEditedInfo> videoEditedInfoSparseArray = new SparseArray<>();
    private boolean cancelCurrentVideoConversion = false;

    public static RGHCompress getInstance() {
        RGHCompress rGHCompress = Instance;
        if (rGHCompress == null) {
            synchronized (RGHCompress.class) {
                rGHCompress = Instance;
                if (rGHCompress == null) {
                    rGHCompress = new RGHCompress();
                    Instance = rGHCompress;
                }
            }
        }
        return rGHCompress;
    }

    private static class VideoConvertRunnable implements Runnable {
        VideoEditedInfo mVideoEditInfo;

        private VideoConvertRunnable(VideoEditedInfo videoEditedInfo) {
            this.mVideoEditInfo = videoEditedInfo;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalArgumentException {
            RGHCompress.getInstance().convertVideo(this.mVideoEditInfo);
        }

        public static void runConversion(final VideoEditedInfo videoEditedInfo) {
            new Thread(new Runnable() { // from class: ir.appp.rghapp.videocompress.RGHCompress.VideoConvertRunnable.1
                @Override // java.lang.Runnable
                public void run() throws InterruptedException {
                    try {
                        Thread thread = new Thread(new VideoConvertRunnable(videoEditedInfo), "RGHVideoConvertRunnable");
                        thread.start();
                        thread.join();
                    } catch (Exception unused) {
                    }
                }
            }).start();
        }
    }

    public boolean scheduleVideoConvert(final VideoEditedInfo videoEditedInfo) {
        if (videoEditedInfo == null || videoEditedInfo.originalPath == null) {
            return false;
        }
        if (videoEditedInfo.canNotCompress) {
            AndroidUtilities.runOnUIThread(new Runnable(this) { // from class: ir.appp.rghapp.videocompress.RGHCompress.1
                @Override // java.lang.Runnable
                public void run() {
                    NotificationCenter notificationCenter = NotificationCenter.getInstance(videoEditedInfo.currentAccount);
                    int i = NotificationCenter.compressVideoDone;
                    VideoEditedInfo videoEditedInfo2 = videoEditedInfo;
                    notificationCenter.postNotificationName(i, Integer.valueOf(videoEditedInfo.rnd), videoEditedInfo2.originalPath, videoEditedInfo2);
                }
            });
            return true;
        }
        this.videoConvertQueue.add(videoEditedInfo);
        this.videoEditedInfoSparseArray.put(videoEditedInfo.rnd, videoEditedInfo);
        if (this.videoConvertQueue.size() == 1) {
            startVideoConvertFromQueue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(26:0|2|92|3|(2:8|(1:10)(2:11|(2:13|14)(2:15|16)))(1:7)|17|18|94|19|(1:21)|(1:23)|(1:25)|(1:27)|(1:29)(1:30)|(1:32)(1:33)|(1:35)|36|(4:42|(5:53|54|96|55|(5:65|98|(6:75|76|100|77|(1:79)(1:80)|81)(3:72|73|74)|82|83)(7:59|(2:61|(6:63|65|98|(7:67|75|76|100|77|(0)(0)|81)(0)|82|83))|64|98|(0)(0)|82|83))(1:(1:45)(6:47|(1:49)(2:50|(1:52)(0))|54|96|55|(5:65|98|(0)(0)|82|83)(0)))|89|90)(1:41)|46|54|96|55|(0)(0)|89|90|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01a7, code lost:
    
        r3 = r27;
        r2 = r28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0108 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0119 A[PHI: r3
      0x0119: PHI (r3v11 ??) = (r3v29 ??), (r3v30 ??), (r3v31 ??), (r3v23 ?? I:??[long, double]) binds: [B:56:0x0106, B:57:0x0108, B:58:0x010a, B:63:0x0116] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0136 A[Catch: Exception -> 0x01a5, TRY_LEAVE, TryCatch #3 {Exception -> 0x01a5, blocks: (B:74:0x012d, B:75:0x0136), top: B:98:0x011a }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0180 A[Catch: Exception -> 0x01b1, TryCatch #4 {Exception -> 0x01b1, blocks: (B:82:0x0195, B:77:0x0164, B:79:0x0180, B:80:0x018b), top: B:100:0x0164 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018b A[Catch: Exception -> 0x01b1, TryCatch #4 {Exception -> 0x01b1, blocks: (B:82:0x0195, B:77:0x0164, B:79:0x0180, B:80:0x018b), top: B:100:0x0164 }] */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean convertVideo(final org.rbmain.messenger.VideoEditedInfo r28) throws java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.videocompress.RGHCompress.convertVideo(org.rbmain.messenger.VideoEditedInfo):boolean");
    }

    /* renamed from: ir.appp.rghapp.videocompress.RGHCompress$3, reason: invalid class name */
    class AnonymousClass3 implements MediaController.VideoConvertorListener {
        final /* synthetic */ File val$cacheFile;
        final /* synthetic */ VideoEditedInfo val$videoEditedInfo;

        @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
        public void finishMakeVideo() {
        }

        AnonymousClass3(VideoEditedInfo videoEditedInfo, File file) {
            this.val$videoEditedInfo = videoEditedInfo;
            this.val$cacheFile = file;
        }

        @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
        public boolean checkConversionCanceled() {
            boolean z;
            synchronized (RGHCompress.this.videoConvertSync) {
                z = RGHCompress.this.cancelCurrentVideoConversion;
            }
            if (z) {
                throw new RuntimeException("canceled conversion");
            }
            return z;
        }

        @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
        public void didWriteData(final long j, float f) {
            MyLog.e("VideoConvertProgressss", "VideoConvertProgressss " + j + "  " + f);
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (f < 0.0f) {
                f = 0.0f;
            }
            final float f2 = f * 100.0f;
            final VideoEditedInfo videoEditedInfo = this.val$videoEditedInfo;
            final File file = this.val$cacheFile;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.videocompress.RGHCompress$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    RGHCompress.AnonymousClass3.lambda$didWriteData$0(videoEditedInfo, f2, file, j);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$didWriteData$0(VideoEditedInfo videoEditedInfo, float f, File file, long j) {
            videoEditedInfo.progress = f;
            NotificationCenter.getInstance(videoEditedInfo.currentAccount).postNotificationName(NotificationCenter.compressVideoProgressChanged, Integer.valueOf(videoEditedInfo.rnd), Float.valueOf(f), videoEditedInfo, file, Long.valueOf(j));
        }
    }

    private boolean startVideoConvertFromQueue() {
        if (this.videoConvertQueue.isEmpty()) {
            return false;
        }
        synchronized (this.videoConvertSync) {
            this.cancelCurrentVideoConversion = false;
        }
        VideoConvertRunnable.runConversion(this.videoConvertQueue.get(0));
        return true;
    }
}
