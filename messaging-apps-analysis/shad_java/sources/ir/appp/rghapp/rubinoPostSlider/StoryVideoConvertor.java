package ir.appp.rghapp.rubinoPostSlider;

import android.graphics.Bitmap;
import android.media.MediaExtractor;
import ir.appp.rghapp.GLSceneState;
import ir.appp.rghapp.video.MP4Builder;
import java.io.File;
import org.rbmain.messenger.MediaController;

/* loaded from: classes3.dex */
public class StoryVideoConvertor {
    private MediaController.VideoConvertorListener callback;
    private MediaExtractor extractor;
    private MP4Builder mediaMuxer;

    public boolean convertVideo(String str, File file, int i, int i2, int i3, int i4, int i5, long j, long j2, boolean z, long j3, GLSceneState gLSceneState, boolean z2, Bitmap bitmap, MediaController.VideoConvertorListener videoConvertorListener) {
        this.callback = videoConvertorListener;
        return convertVideoInternal(str, file, i, i2, i3, i4, i5, j, j2, j3, z, false, gLSceneState, bitmap, z2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1070|113|114|(6:(4:1110|116|117|(6:(1:124)(2:122|123)|(3:128|(2:130|(2:131|(1:1234)(3:133|(2:145|1236)(2:139|(1:1238)(2:1235|143))|146)))(0)|147)|1177|148|149|(14:1151|151|(1:153)(1:157)|158|1137|199|200|(1:202)(1:203)|204|1139|205|206|(3:1230|208|1233)(4:1229|(6:1194|210|211|1192|212|(2:214|215)(1:216))(1:225)|226|1232)|1231)(0))(13:162|(11:1113|164|165|(3:169|(1:1244)(2:175|(2:1239|177)(1:1245))|179)|1241|180|181|1102|182|(1:185)|186)|198|1137|199|200|(0)(0)|204|1139|205|206|(0)(0)|1231))(1:196)|1139|205|206|(0)(0)|1231)|197|198|1137|199|200|(0)(0)|204) */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x047c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x047d, code lost:
    
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0191, code lost:
    
        r8 = r7;
        r3 = r3;
        r10 = r10;
        r14 = r14;
        r20 = r20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1029:0x0882 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1068:0x05ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1085:0x104d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1095:0x11cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1120:0x0e72 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1163:0x121b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1167:0x1142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1229:0x0408 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1230:0x03ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1246:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0536 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x053f A[Catch: Exception -> 0x05db, all -> 0x05e7, TRY_LEAVE, TryCatch #14 {Exception -> 0x05db, blocks: (B:271:0x053b, B:273:0x053f), top: B:1032:0x053b }] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x05c3 A[Catch: all -> 0x05af, Exception -> 0x05b5, TryCatch #39 {Exception -> 0x05b5, blocks: (B:294:0x05ab, B:302:0x05c3, B:304:0x05c8, B:305:0x05ce), top: B:1068:0x05ab }] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x05c8 A[Catch: all -> 0x05af, Exception -> 0x05b5, TryCatch #39 {Exception -> 0x05b5, blocks: (B:294:0x05ab, B:302:0x05c3, B:304:0x05c8, B:305:0x05ce), top: B:1068:0x05ab }] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0658  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x087d  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x087f  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x0937  */
    /* JADX WARN: Removed duplicated region for block: B:595:0x0b30  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0b33  */
    /* JADX WARN: Removed duplicated region for block: B:601:0x0b3d  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x0b59  */
    /* JADX WARN: Removed duplicated region for block: B:734:0x0d96  */
    /* JADX WARN: Removed duplicated region for block: B:736:0x0daf  */
    /* JADX WARN: Removed duplicated region for block: B:797:0x0e8c  */
    /* JADX WARN: Removed duplicated region for block: B:814:0x0ecc  */
    /* JADX WARN: Removed duplicated region for block: B:883:0x1044 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:885:0x1048  */
    /* JADX WARN: Removed duplicated region for block: B:912:0x10b1  */
    /* JADX WARN: Removed duplicated region for block: B:917:0x10cc A[Catch: Exception -> 0x111a, all -> 0x11be, TryCatch #76 {all -> 0x11be, blocks: (B:969:0x118c, B:915:0x10c3, B:917:0x10cc, B:928:0x1116, B:932:0x1122, B:934:0x1127, B:936:0x112f, B:937:0x1132), top: B:1126:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:928:0x1116 A[Catch: Exception -> 0x111a, all -> 0x11be, TryCatch #76 {all -> 0x11be, blocks: (B:969:0x118c, B:915:0x10c3, B:917:0x10cc, B:928:0x1116, B:932:0x1122, B:934:0x1127, B:936:0x112f, B:937:0x1132), top: B:1126:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:932:0x1122 A[Catch: Exception -> 0x111a, all -> 0x11be, TryCatch #76 {all -> 0x11be, blocks: (B:969:0x118c, B:915:0x10c3, B:917:0x10cc, B:928:0x1116, B:932:0x1122, B:934:0x1127, B:936:0x112f, B:937:0x1132), top: B:1126:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:934:0x1127 A[Catch: Exception -> 0x111a, all -> 0x11be, TryCatch #76 {all -> 0x11be, blocks: (B:969:0x118c, B:915:0x10c3, B:917:0x10cc, B:928:0x1116, B:932:0x1122, B:934:0x1127, B:936:0x112f, B:937:0x1132), top: B:1126:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:936:0x112f A[Catch: Exception -> 0x111a, all -> 0x11be, TryCatch #76 {all -> 0x11be, blocks: (B:969:0x118c, B:915:0x10c3, B:917:0x10cc, B:928:0x1116, B:932:0x1122, B:934:0x1127, B:936:0x112f, B:937:0x1132), top: B:1126:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:941:0x113b  */
    /* JADX WARN: Removed duplicated region for block: B:969:0x118c A[Catch: all -> 0x11be, TRY_ENTER, TRY_LEAVE, TryCatch #76 {all -> 0x11be, blocks: (B:969:0x118c, B:915:0x10c3, B:917:0x10cc, B:928:0x1116, B:932:0x1122, B:934:0x1127, B:936:0x112f, B:937:0x1132), top: B:1126:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:975:0x11c6  */
    /* JADX WARN: Removed duplicated region for block: B:986:0x11ea  */
    /* JADX WARN: Removed duplicated region for block: B:988:0x120b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:993:0x1214  */
    /* JADX WARN: Type inference failed for: r10v109 */
    /* JADX WARN: Type inference failed for: r10v110 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v47 */
    /* JADX WARN: Type inference failed for: r10v49 */
    /* JADX WARN: Type inference failed for: r10v50 */
    /* JADX WARN: Type inference failed for: r10v56, types: [ir.appp.rghapp.video.InputSurface] */
    /* JADX WARN: Type inference failed for: r10v58 */
    /* JADX WARN: Type inference failed for: r11v101 */
    /* JADX WARN: Type inference failed for: r11v105 */
    /* JADX WARN: Type inference failed for: r11v185 */
    /* JADX WARN: Type inference failed for: r11v186 */
    /* JADX WARN: Type inference failed for: r11v187 */
    /* JADX WARN: Type inference failed for: r11v188 */
    /* JADX WARN: Type inference failed for: r11v189 */
    /* JADX WARN: Type inference failed for: r11v190 */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v34, types: [android.media.MediaFormat] */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v38, types: [long] */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v151 */
    /* JADX WARN: Type inference failed for: r14v152 */
    /* JADX WARN: Type inference failed for: r14v154 */
    /* JADX WARN: Type inference failed for: r14v155 */
    /* JADX WARN: Type inference failed for: r14v162 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v41 */
    /* JADX WARN: Type inference failed for: r14v42 */
    /* JADX WARN: Type inference failed for: r14v56 */
    /* JADX WARN: Type inference failed for: r14v57 */
    /* JADX WARN: Type inference failed for: r20v12 */
    /* JADX WARN: Type inference failed for: r20v14 */
    /* JADX WARN: Type inference failed for: r20v15 */
    /* JADX WARN: Type inference failed for: r20v16 */
    /* JADX WARN: Type inference failed for: r20v17 */
    /* JADX WARN: Type inference failed for: r20v18 */
    /* JADX WARN: Type inference failed for: r20v19 */
    /* JADX WARN: Type inference failed for: r20v25 */
    /* JADX WARN: Type inference failed for: r20v35 */
    /* JADX WARN: Type inference failed for: r20v36 */
    /* JADX WARN: Type inference failed for: r20v37 */
    /* JADX WARN: Type inference failed for: r20v40 */
    /* JADX WARN: Type inference failed for: r20v65 */
    /* JADX WARN: Type inference failed for: r20v66 */
    /* JADX WARN: Type inference failed for: r20v67 */
    /* JADX WARN: Type inference failed for: r20v69 */
    /* JADX WARN: Type inference failed for: r20v70 */
    /* JADX WARN: Type inference failed for: r20v74 */
    /* JADX WARN: Type inference failed for: r2v136, types: [android.media.MediaCodec] */
    /* JADX WARN: Type inference failed for: r3v148 */
    /* JADX WARN: Type inference failed for: r3v150 */
    /* JADX WARN: Type inference failed for: r3v151 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v44, types: [android.media.MediaCodec] */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49, types: [android.media.MediaCodec] */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v96, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r75v0, types: [long] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean convertVideoInternal(java.lang.String r66, java.io.File r67, int r68, int r69, int r70, int r71, int r72, long r73, long r75, long r77, boolean r79, boolean r80, ir.appp.rghapp.GLSceneState r81, android.graphics.Bitmap r82, boolean r83) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 4660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.StoryVideoConvertor.convertVideoInternal(java.lang.String, java.io.File, int, int, int, int, int, long, long, long, boolean, boolean, ir.appp.rghapp.GLSceneState, android.graphics.Bitmap, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00f7 A[PHI: r26 r38
      0x00f7: PHI (r26v8 int) = (r26v6 int), (r26v14 int) binds: [B:56:0x00f5, B:53:0x00ed] A[DONT_GENERATE, DONT_INLINE]
      0x00f7: PHI (r38v7 boolean) = (r38v5 boolean), (r38v8 boolean) binds: [B:56:0x00f5, B:53:0x00ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0194  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long readAndWriteTracks(android.media.MediaExtractor r28, ir.appp.rghapp.video.MP4Builder r29, android.media.MediaCodec.BufferInfo r30, long r31, long r33, long r35, java.io.File r37, boolean r38) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.StoryVideoConvertor.readAndWriteTracks(android.media.MediaExtractor, ir.appp.rghapp.video.MP4Builder, android.media.MediaCodec$BufferInfo, long, long, long, java.io.File, boolean):long");
    }

    private void checkConversionCanceled() {
        MediaController.VideoConvertorListener videoConvertorListener = this.callback;
        if (videoConvertorListener != null && videoConvertorListener.checkConversionCanceled()) {
            throw new RuntimeException("canceled conversion");
        }
    }
}
