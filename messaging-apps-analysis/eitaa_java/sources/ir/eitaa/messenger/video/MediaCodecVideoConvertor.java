package ir.eitaa.messenger.video;

import android.media.MediaExtractor;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.VideoEditedInfo;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MediaCodecVideoConvertor {
    private static final int MEDIACODEC_TIMEOUT_DEFAULT = 2500;
    private static final int MEDIACODEC_TIMEOUT_INCREASED = 22000;
    private static final int PROCESSOR_TYPE_INTEL = 2;
    private static final int PROCESSOR_TYPE_MTK = 3;
    private static final int PROCESSOR_TYPE_OTHER = 0;
    private static final int PROCESSOR_TYPE_QCOM = 1;
    private static final int PROCESSOR_TYPE_SEC = 4;
    private static final int PROCESSOR_TYPE_TI = 5;
    private MediaController.VideoConvertorListener callback;
    private long endPresentationTime;
    private MediaExtractor extractor;
    private MP4Builder mediaMuxer;

    public boolean convertVideo(String videoPath, File cacheFile, int rotationValue, boolean isSecret, int resultWidth, int resultHeight, int framerate, int bitrate, int originalBitrate, long startTime, long endTime, long avatarStartTime, boolean needCompress, long duration, MediaController.SavedFilterState savedFilterState, String paintPath, ArrayList<VideoEditedInfo.MediaEntity> mediaEntities, boolean isPhoto, MediaController.CropState cropState, MediaController.VideoConvertorListener callback) {
        this.callback = callback;
        return convertVideoInternal(videoPath, cacheFile, rotationValue, isSecret, resultWidth, resultHeight, framerate, bitrate, originalBitrate, startTime, endTime, avatarStartTime, duration, needCompress, false, savedFilterState, paintPath, mediaEntities, isPhoto, cropState);
    }

    public long getLastFrameTimestamp() {
        return this.endPresentationTime;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Finally extract failed */
    @android.annotation.TargetApi(18)
    private boolean convertVideoInternal(java.lang.String r77, java.io.File r78, int r79, boolean r80, int r81, int r82, int r83, int r84, int r85, long r86, long r88, long r90, long r92, boolean r94, boolean r95, ir.eitaa.messenger.MediaController.SavedFilterState r96, java.lang.String r97, java.util.ArrayList<ir.eitaa.messenger.VideoEditedInfo.MediaEntity> r98, boolean r99, ir.eitaa.messenger.MediaController.CropState r100) {
        /*
            Method dump skipped, instructions count: 5309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.video.MediaCodecVideoConvertor.convertVideoInternal(java.lang.String, java.io.File, int, boolean, int, int, int, int, int, long, long, long, long, boolean, boolean, ir.eitaa.messenger.MediaController$SavedFilterState, java.lang.String, java.util.ArrayList, boolean, ir.eitaa.messenger.MediaController$CropState):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012d A[PHI: r26 r27
      0x012d: PHI (r26v8 int) = (r26v6 int), (r26v14 int) binds: [B:76:0x012b, B:73:0x0123] A[DONT_GENERATE, DONT_INLINE]
      0x012d: PHI (r27v6 int) = (r27v4 int), (r27v7 int) binds: [B:76:0x012b, B:73:0x0123] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long readAndWriteTracks(android.media.MediaExtractor r29, ir.eitaa.messenger.video.MP4Builder r30, android.media.MediaCodec.BufferInfo r31, long r32, long r34, long r36, java.io.File r38, boolean r39) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.video.MediaCodecVideoConvertor.readAndWriteTracks(android.media.MediaExtractor, ir.eitaa.messenger.video.MP4Builder, android.media.MediaCodec$BufferInfo, long, long, long, java.io.File, boolean):long");
    }

    private void checkConversionCanceled() {
        MediaController.VideoConvertorListener videoConvertorListener = this.callback;
        if (videoConvertorListener != null && videoConvertorListener.checkConversionCanceled()) {
            throw new RuntimeException("canceled conversion");
        }
    }
}
