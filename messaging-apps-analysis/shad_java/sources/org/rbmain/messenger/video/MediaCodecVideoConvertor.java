package org.rbmain.messenger.video;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import java.io.File;
import java.util.ArrayList;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.VideoEditedInfo;

/* loaded from: classes4.dex */
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

    public boolean convertVideo(String str, File file, int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2, long j3, boolean z2, long j4, MediaController.SavedFilterState savedFilterState, String str2, ArrayList<VideoEditedInfo.MediaEntity> arrayList, boolean z3, MediaController.CropState cropState, boolean z4, MediaController.VideoConvertorListener videoConvertorListener) {
        this.callback = videoConvertorListener;
        return convertVideoInternal(str, file, i, z, i2, i3, i4, i5, i6, i7, i8, j, j2, j3, j4, z2, false, savedFilterState, str2, arrayList, z3, cropState, z4);
    }

    public long getLastFrameTimestamp() {
        return this.endPresentationTime;
    }

    /* JADX WARN: Code restructure failed: missing block: B:629:0x0d42, code lost:
    
        r14 = r85;
        r2 = r92;
        r64 = r9;
        r47 = r11;
        r56 = r12;
        r8 = r15;
        r15 = r8;
        r66 = r65;
        r4 = false;
        r12 = r83;
        r11 = r1;
        r13 = r5;
        r7 = r21;
        r6 = r32;
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x025b, code lost:
    
        r1 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r6;
        r5 = r7;
        r6 = r8;
        r7 = r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1003:0x13a8  */
    /* JADX WARN: Removed duplicated region for block: B:1005:0x13ac  */
    /* JADX WARN: Removed duplicated region for block: B:1006:0x13b1  */
    /* JADX WARN: Removed duplicated region for block: B:1031:0x13fd  */
    /* JADX WARN: Removed duplicated region for block: B:1035:0x1407 A[Catch: all -> 0x14c1, Exception -> 0x14c3, TryCatch #68 {Exception -> 0x14c3, blocks: (B:1029:0x13f3, B:1033:0x1401, B:1035:0x1407, B:1037:0x140b, B:1038:0x1410, B:1044:0x1427, B:1045:0x1443, B:1053:0x147a, B:1054:0x149c, B:1059:0x14a2, B:1060:0x14c0), top: B:1306:0x13f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:1050:0x144f  */
    /* JADX WARN: Removed duplicated region for block: B:1149:0x16b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:1151:0x16b5  */
    /* JADX WARN: Removed duplicated region for block: B:1162:0x16fa A[Catch: all -> 0x170b, TRY_LEAVE, TryCatch #134 {all -> 0x170b, blocks: (B:1160:0x16f1, B:1162:0x16fa), top: B:1359:0x16f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:1186:0x1767 A[Catch: all -> 0x1759, TryCatch #36 {all -> 0x1759, blocks: (B:1181:0x1755, B:1186:0x1767, B:1188:0x176c, B:1190:0x1774, B:1191:0x1777), top: B:1277:0x1755 }] */
    /* JADX WARN: Removed duplicated region for block: B:1188:0x176c A[Catch: all -> 0x1759, TryCatch #36 {all -> 0x1759, blocks: (B:1181:0x1755, B:1186:0x1767, B:1188:0x176c, B:1190:0x1774, B:1191:0x1777), top: B:1277:0x1755 }] */
    /* JADX WARN: Removed duplicated region for block: B:1190:0x1774 A[Catch: all -> 0x1759, TryCatch #36 {all -> 0x1759, blocks: (B:1181:0x1755, B:1186:0x1767, B:1188:0x176c, B:1190:0x1774, B:1191:0x1777), top: B:1277:0x1755 }] */
    /* JADX WARN: Removed duplicated region for block: B:1195:0x1787  */
    /* JADX WARN: Removed duplicated region for block: B:1214:0x1802  */
    /* JADX WARN: Removed duplicated region for block: B:1223:0x1822  */
    /* JADX WARN: Removed duplicated region for block: B:1225:0x1854  */
    /* JADX WARN: Removed duplicated region for block: B:1265:0x13c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1277:0x1755 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1287:0x0974 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1302:0x178e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1309:0x069d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1353:0x0949 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1357:0x0951 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1371:0x1809 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1380:0x0d95 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1392:0x09e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1422:0x088b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1470:0x120f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1472:0x11f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x065c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x06ab A[Catch: all -> 0x06a1, TryCatch #70 {all -> 0x06a1, blocks: (B:284:0x069d, B:288:0x06ab, B:290:0x06b0, B:291:0x06b6), top: B:1309:0x069d }] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x06b0 A[Catch: all -> 0x06a1, TryCatch #70 {all -> 0x06a1, blocks: (B:284:0x069d, B:288:0x06ab, B:290:0x06b0, B:291:0x06b6), top: B:1309:0x069d }] */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0756  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0882  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0885  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x08c2  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x091b  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x0940  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x094e  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x096f A[PHI: r2
      0x096f: PHI (r2v40 android.media.MediaCodec) = (r2v37 android.media.MediaCodec), (r2v39 android.media.MediaCodec) binds: [B:439:0x094f, B:440:0x0951] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0a49  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x0a4f A[Catch: all -> 0x0a34, Exception -> 0x0a3b, TRY_LEAVE, TryCatch #149 {Exception -> 0x0a3b, all -> 0x0a34, blocks: (B:463:0x09e2, B:465:0x09ea, B:467:0x09fa, B:469:0x0a02, B:470:0x0a0d, B:472:0x0a15, B:473:0x0a20, B:475:0x0a28, B:483:0x0a4f), top: B:1392:0x09e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:497:0x0a85  */
    /* JADX WARN: Removed duplicated region for block: B:558:0x0bf4  */
    /* JADX WARN: Removed duplicated region for block: B:621:0x0d16  */
    /* JADX WARN: Removed duplicated region for block: B:622:0x0d19  */
    /* JADX WARN: Removed duplicated region for block: B:641:0x0d91  */
    /* JADX WARN: Removed duplicated region for block: B:741:0x0f51  */
    /* JADX WARN: Removed duplicated region for block: B:746:0x0f75 A[ADDED_TO_REGION, EDGE_INSN: B:746:0x0f75->B:1471:0x0f78 BREAK  A[LOOP:5: B:745:0x0f73->B:1473:0x0f73]] */
    /* JADX WARN: Removed duplicated region for block: B:751:0x0f96  */
    /* JADX WARN: Removed duplicated region for block: B:752:0x0f9f  */
    /* JADX WARN: Removed duplicated region for block: B:757:0x0fae  */
    /* JADX WARN: Removed duplicated region for block: B:758:0x0fc6  */
    /* JADX WARN: Removed duplicated region for block: B:895:0x11e7  */
    /* JADX WARN: Removed duplicated region for block: B:896:0x11e9  */
    /* JADX WARN: Removed duplicated region for block: B:974:0x133d  */
    /* JADX WARN: Removed duplicated region for block: B:982:0x1353  */
    /* JADX WARN: Removed duplicated region for block: B:986:0x135b  */
    /* JADX WARN: Removed duplicated region for block: B:987:0x1360  */
    /* JADX WARN: Removed duplicated region for block: B:990:0x1367  */
    /* JADX WARN: Type inference failed for: r6v207 */
    /* JADX WARN: Type inference failed for: r6v208 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 11 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean convertVideoInternal(java.lang.String r77, java.io.File r78, int r79, boolean r80, int r81, int r82, int r83, int r84, int r85, int r86, int r87, long r88, long r90, long r92, long r94, boolean r96, boolean r97, org.rbmain.messenger.MediaController.SavedFilterState r98, java.lang.String r99, java.util.ArrayList<org.rbmain.messenger.VideoEditedInfo.MediaEntity> r100, boolean r101, org.rbmain.messenger.MediaController.CropState r102, boolean r103) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 6352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.video.MediaCodecVideoConvertor.convertVideoInternal(java.lang.String, java.io.File, int, boolean, int, int, int, int, int, int, int, long, long, long, long, boolean, boolean, org.rbmain.messenger.MediaController$SavedFilterState, java.lang.String, java.util.ArrayList, boolean, org.rbmain.messenger.MediaController$CropState, boolean):boolean");
    }

    private boolean isMediatekAvcEncoder(MediaCodec mediaCodec) {
        return mediaCodec.getName().equals("c2.mtk.avc.encoder");
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
    private long readAndWriteTracks(android.media.MediaExtractor r29, org.rbmain.messenger.video.MP4Builder r30, android.media.MediaCodec.BufferInfo r31, long r32, long r34, long r36, java.io.File r38, boolean r39) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.video.MediaCodecVideoConvertor.readAndWriteTracks(android.media.MediaExtractor, org.rbmain.messenger.video.MP4Builder, android.media.MediaCodec$BufferInfo, long, long, long, java.io.File, boolean):long");
    }

    private void checkConversionCanceled() {
        MediaController.VideoConvertorListener videoConvertorListener = this.callback;
        if (videoConvertorListener != null && videoConvertorListener.checkConversionCanceled()) {
            throw new ConversionCanceledException();
        }
    }

    private static String createFragmentShader(int i, int i2, int i3, int i4, boolean z) {
        int iClamp = (int) Utilities.clamp((Math.max(i, i2) / Math.max(i4, i3)) * 0.8f, 2.0f, 1.0f);
        if (iClamp > 1) {
            iClamp = 1;
        }
        FileLog.d("source size " + i + "x" + i2 + "    dest size " + i3 + i4 + "   kernelRadius " + iClamp);
        if (z) {
            return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nconst float kernel = " + iClamp + ".0;\nconst float pixelSizeX = 1.0 / " + i + ".0;\nconst float pixelSizeY = 1.0 / " + i2 + ".0;\nuniform samplerExternalOES sTexture;\nvoid main() {\nvec3 accumulation = vec3(0);\nvec3 weightsum = vec3(0);\nfor (float x = -kernel; x <= kernel; x++){\n   for (float y = -kernel; y <= kernel; y++){\n       accumulation += texture2D(sTexture, vTextureCoord + vec2(x * pixelSizeX, y * pixelSizeY)).xyz;\n       weightsum += 1.0;\n   }\n}\ngl_FragColor = vec4(accumulation / weightsum, 1.0);\n}\n";
        }
        return "precision mediump float;\nvarying vec2 vTextureCoord;\nconst float kernel = " + iClamp + ".0;\nconst float pixelSizeX = 1.0 / " + i2 + ".0;\nconst float pixelSizeY = 1.0 / " + i + ".0;\nuniform sampler2D sTexture;\nvoid main() {\nvec3 accumulation = vec3(0);\nvec3 weightsum = vec3(0);\nfor (float x = -kernel; x <= kernel; x++){\n   for (float y = -kernel; y <= kernel; y++){\n       accumulation += texture2D(sTexture, vTextureCoord + vec2(x * pixelSizeX, y * pixelSizeY)).xyz;\n       weightsum += 1.0;\n   }\n}\ngl_FragColor = vec4(accumulation / weightsum, 1.0);\n}\n";
    }

    public class ConversionCanceledException extends RuntimeException {
        public ConversionCanceledException() {
            super("canceled conversion");
        }
    }
}
