package ir.appp.rghapp.video;

import android.media.MediaExtractor;
import java.io.File;
import org.rbmain.messenger.MediaController;

/* loaded from: classes3.dex */
public class MediaCodecVideoConvertor {
    MediaController.VideoConvertorListener callback;
    MediaExtractor extractor;
    MP4Builder mediaMuxer;

    public boolean convertVideo(String str, File file, int i, boolean z, int i2, int i3, int i4, int i5, long j, long j2, boolean z2, long j3, MediaController.VideoConvertorListener videoConvertorListener) {
        this.callback = videoConvertorListener;
        return convertVideoInternal(str, file, i, z, i2, i3, i4, i5, j, j2, j3, z2, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:184:0x0381, code lost:
    
        r9 = r75;
        r12 = r3;
        r5 = r29;
        r1 = false;
        r17 = false;
        r4 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x04d0 A[PHI: r7 r8 r18 r51 r58 r59 r60 r61 r62
      0x04d0: PHI (r7v5 android.media.MediaCodec$BufferInfo) = 
      (r7v4 android.media.MediaCodec$BufferInfo)
      (r7v7 android.media.MediaCodec$BufferInfo)
      (r7v7 android.media.MediaCodec$BufferInfo)
     binds: [B:253:0x04cc, B:247:0x049a, B:245:0x048e] A[DONT_GENERATE, DONT_INLINE]
      0x04d0: PHI (r8v4 long) = (r8v3 long), (r8v7 long), (r8v11 long) binds: [B:253:0x04cc, B:247:0x049a, B:245:0x048e] A[DONT_GENERATE, DONT_INLINE]
      0x04d0: PHI (r18v4 int) = (r18v3 int), (r18v7 int), (r18v9 int) binds: [B:253:0x04cc, B:247:0x049a, B:245:0x048e] A[DONT_GENERATE, DONT_INLINE]
      0x04d0: PHI (r51v2 long) = (r51v1 long), (r51v1 long), (r51v4 long) binds: [B:253:0x04cc, B:247:0x049a, B:245:0x048e] A[DONT_GENERATE, DONT_INLINE]
      0x04d0: PHI (r58v8 boolean) = (r58v7 boolean), (r58v10 boolean), (r58v10 boolean) binds: [B:253:0x04cc, B:247:0x049a, B:245:0x048e] A[DONT_GENERATE, DONT_INLINE]
      0x04d0: PHI (r59v2 int) = (r59v1 int), (r59v5 int), (r59v7 int) binds: [B:253:0x04cc, B:247:0x049a, B:245:0x048e] A[DONT_GENERATE, DONT_INLINE]
      0x04d0: PHI (r60v2 java.nio.ByteBuffer) = (r60v1 java.nio.ByteBuffer), (r60v4 java.nio.ByteBuffer), (r60v5 java.nio.ByteBuffer) binds: [B:253:0x04cc, B:247:0x049a, B:245:0x048e] A[DONT_GENERATE, DONT_INLINE]
      0x04d0: PHI (r61v2 int) = (r61v1 int), (r61v5 int), (r61v8 int) binds: [B:253:0x04cc, B:247:0x049a, B:245:0x048e] A[DONT_GENERATE, DONT_INLINE]
      0x04d0: PHI (r62v2 java.nio.ByteBuffer[]) = (r62v1 java.nio.ByteBuffer[]), (r62v4 java.nio.ByteBuffer[]), (r62v5 java.nio.ByteBuffer[]) binds: [B:253:0x04cc, B:247:0x049a, B:245:0x048e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:398:0x072d  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x0903  */
    /* JADX WARN: Removed duplicated region for block: B:539:0x0aba A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:544:0x0ad1 A[Catch: Exception -> 0x0af3, all -> 0x0b46, TryCatch #6 {Exception -> 0x0af3, blocks: (B:541:0x0abe, B:542:0x0aca, B:544:0x0ad1, B:546:0x0ad6, B:548:0x0adb, B:550:0x0ae3, B:552:0x0aeb, B:553:0x0aee), top: B:631:0x0abe }] */
    /* JADX WARN: Removed duplicated region for block: B:546:0x0ad6 A[Catch: Exception -> 0x0af3, all -> 0x0b46, TryCatch #6 {Exception -> 0x0af3, blocks: (B:541:0x0abe, B:542:0x0aca, B:544:0x0ad1, B:546:0x0ad6, B:548:0x0adb, B:550:0x0ae3, B:552:0x0aeb, B:553:0x0aee), top: B:631:0x0abe }] */
    /* JADX WARN: Removed duplicated region for block: B:548:0x0adb A[Catch: Exception -> 0x0af3, all -> 0x0b46, TryCatch #6 {Exception -> 0x0af3, blocks: (B:541:0x0abe, B:542:0x0aca, B:544:0x0ad1, B:546:0x0ad6, B:548:0x0adb, B:550:0x0ae3, B:552:0x0aeb, B:553:0x0aee), top: B:631:0x0abe }] */
    /* JADX WARN: Removed duplicated region for block: B:550:0x0ae3 A[Catch: Exception -> 0x0af3, all -> 0x0b46, TryCatch #6 {Exception -> 0x0af3, blocks: (B:541:0x0abe, B:542:0x0aca, B:544:0x0ad1, B:546:0x0ad6, B:548:0x0adb, B:550:0x0ae3, B:552:0x0aeb, B:553:0x0aee), top: B:631:0x0abe }] */
    /* JADX WARN: Removed duplicated region for block: B:552:0x0aeb A[Catch: Exception -> 0x0af3, all -> 0x0b46, TryCatch #6 {Exception -> 0x0af3, blocks: (B:541:0x0abe, B:542:0x0aca, B:544:0x0ad1, B:546:0x0ad6, B:548:0x0adb, B:550:0x0ae3, B:552:0x0aeb, B:553:0x0aee), top: B:631:0x0abe }] */
    /* JADX WARN: Removed duplicated region for block: B:574:0x0b30  */
    /* JADX WARN: Removed duplicated region for block: B:593:0x0b59  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x0b6c  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x0b8b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:609:0x0b94  */
    /* JADX WARN: Removed duplicated region for block: B:639:0x0b9b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:650:0x0b60 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:688:0x0b37 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:706:0x0752 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:707:0x073f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:723:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v22, types: [ir.appp.rghapp.video.InputSurface] */
    /* JADX WARN: Type inference failed for: r4v17, types: [android.media.MediaCodec] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v36, types: [android.media.MediaCodec] */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v47, types: [android.media.MediaCodec] */
    /* JADX WARN: Type inference failed for: r4v50, types: [android.media.MediaCodec] */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v69 */
    /* JADX WARN: Type inference failed for: r4v70 */
    /* JADX WARN: Type inference failed for: r4v71 */
    /* JADX WARN: Type inference failed for: r5v2, types: [ir.appp.rghapp.video.InputSurface] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v59, types: [ir.appp.rghapp.video.InputSurface] */
    /* JADX WARN: Type inference failed for: r5v69 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean convertVideoInternal(java.lang.String r68, java.io.File r69, int r70, boolean r71, int r72, int r73, int r74, int r75, long r76, long r78, long r80, boolean r82, boolean r83) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2983
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.video.MediaCodecVideoConvertor.convertVideoInternal(java.lang.String, java.io.File, int, boolean, int, int, int, int, long, long, long, boolean, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00e0 A[PHI: r27 r39
      0x00e0: PHI (r27v8 int) = (r27v6 int), (r27v14 int) binds: [B:52:0x00de, B:49:0x00d6] A[DONT_GENERATE, DONT_INLINE]
      0x00e0: PHI (r39v7 boolean) = (r39v5 boolean), (r39v8 boolean) binds: [B:52:0x00de, B:49:0x00d6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long readAndWriteTracks(android.media.MediaExtractor r29, ir.appp.rghapp.video.MP4Builder r30, android.media.MediaCodec.BufferInfo r31, long r32, long r34, long r36, java.io.File r38, boolean r39) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.video.MediaCodecVideoConvertor.readAndWriteTracks(android.media.MediaExtractor, ir.appp.rghapp.video.MP4Builder, android.media.MediaCodec$BufferInfo, long, long, long, java.io.File, boolean):long");
    }

    private void checkConversionCanceled() {
        MediaController.VideoConvertorListener videoConvertorListener = this.callback;
        if (videoConvertorListener != null && videoConvertorListener.checkConversionCanceled()) {
            throw new RuntimeException("canceled conversion");
        }
    }
}
