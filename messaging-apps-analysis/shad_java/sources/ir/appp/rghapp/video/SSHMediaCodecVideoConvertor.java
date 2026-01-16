package ir.appp.rghapp.video;

import android.content.Context;
import android.media.MediaExtractor;
import ir.appp.rghapp.RGHMediaHelper$SavedFilterState;
import java.io.File;
import org.rbmain.messenger.MediaController;

/* loaded from: classes3.dex */
public class SSHMediaCodecVideoConvertor {
    private MediaController.VideoConvertorListener callback;
    private long endPresentationTime;
    private MediaExtractor extractor;
    private MP4Builder mediaMuxer;

    public boolean convertVideo(Context context, String str, File file, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2, boolean z, long j3, RGHMediaHelper$SavedFilterState rGHMediaHelper$SavedFilterState, String str2, MediaController.CropState cropState, MediaController.VideoConvertorListener videoConvertorListener) {
        this.callback = videoConvertorListener;
        return convertVideoInternal(context, str, file, i, i2, i3, i4, i5, i6, i7, j, j2, j3, z, false, rGHMediaHelper$SavedFilterState, str2, cropState);
    }

    public long getLastFrameTimestamp() {
        return this.endPresentationTime;
    }

    /* JADX WARN: Code restructure failed: missing block: B:172:0x0362, code lost:
    
        r7 = r66;
        r9 = r68;
        r3 = r12;
        r6 = " framerate: ";
        r5 = "bitrate: ";
        r13 = "x";
        r35 = r42;
        r10 = r43;
        r4 = false;
        r22 = false;
        r11 = r67;
        r12 = r69;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x035d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0380 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x038e A[PHI: r7
      0x038e: PHI (r7v48 boolean) = (r7v46 boolean), (r7v46 boolean), (r7v99 boolean) binds: [B:174:0x037e, B:175:0x0380, B:176:0x0382] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x050f A[ADDED_TO_REGION, EDGE_INSN: B:249:0x050f->B:723:0x0512 BREAK  A[LOOP:1: B:248:0x050d->B:725:0x050d]] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x07fd  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x094f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0954  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x099b A[Catch: all -> 0x0a22, Exception -> 0x0a29, TryCatch #1 {all -> 0x0a22, blocks: (B:511:0x0992, B:513:0x099b, B:542:0x0a1e, B:548:0x0a32, B:550:0x0a37, B:552:0x0a3f, B:553:0x0a42, B:173:0x037b, B:176:0x0382, B:181:0x0390, B:185:0x03a0, B:187:0x03a6, B:189:0x03ac, B:191:0x03b3, B:193:0x03be, B:237:0x04ca, B:239:0x04d2, B:194:0x03d0, B:190:0x03af, B:205:0x0413, B:207:0x0424, B:208:0x042c, B:210:0x0430, B:212:0x0443, B:216:0x044d, B:218:0x0453, B:220:0x046e, B:222:0x0472, B:227:0x048e, B:211:0x043e), top: B:605:0x037b }] */
    /* JADX WARN: Removed duplicated region for block: B:540:0x0a02  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x0a1e A[Catch: all -> 0x0a22, Exception -> 0x0a29, TryCatch #1 {all -> 0x0a22, blocks: (B:511:0x0992, B:513:0x099b, B:542:0x0a1e, B:548:0x0a32, B:550:0x0a37, B:552:0x0a3f, B:553:0x0a42, B:173:0x037b, B:176:0x0382, B:181:0x0390, B:185:0x03a0, B:187:0x03a6, B:189:0x03ac, B:191:0x03b3, B:193:0x03be, B:237:0x04ca, B:239:0x04d2, B:194:0x03d0, B:190:0x03af, B:205:0x0413, B:207:0x0424, B:208:0x042c, B:210:0x0430, B:212:0x0443, B:216:0x044d, B:218:0x0453, B:220:0x046e, B:222:0x0472, B:227:0x048e, B:211:0x043e), top: B:605:0x037b }] */
    /* JADX WARN: Removed duplicated region for block: B:548:0x0a32 A[Catch: all -> 0x0a22, Exception -> 0x0a29, TryCatch #1 {all -> 0x0a22, blocks: (B:511:0x0992, B:513:0x099b, B:542:0x0a1e, B:548:0x0a32, B:550:0x0a37, B:552:0x0a3f, B:553:0x0a42, B:173:0x037b, B:176:0x0382, B:181:0x0390, B:185:0x03a0, B:187:0x03a6, B:189:0x03ac, B:191:0x03b3, B:193:0x03be, B:237:0x04ca, B:239:0x04d2, B:194:0x03d0, B:190:0x03af, B:205:0x0413, B:207:0x0424, B:208:0x042c, B:210:0x0430, B:212:0x0443, B:216:0x044d, B:218:0x0453, B:220:0x046e, B:222:0x0472, B:227:0x048e, B:211:0x043e), top: B:605:0x037b }] */
    /* JADX WARN: Removed duplicated region for block: B:550:0x0a37 A[Catch: all -> 0x0a22, Exception -> 0x0a29, TryCatch #1 {all -> 0x0a22, blocks: (B:511:0x0992, B:513:0x099b, B:542:0x0a1e, B:548:0x0a32, B:550:0x0a37, B:552:0x0a3f, B:553:0x0a42, B:173:0x037b, B:176:0x0382, B:181:0x0390, B:185:0x03a0, B:187:0x03a6, B:189:0x03ac, B:191:0x03b3, B:193:0x03be, B:237:0x04ca, B:239:0x04d2, B:194:0x03d0, B:190:0x03af, B:205:0x0413, B:207:0x0424, B:208:0x042c, B:210:0x0430, B:212:0x0443, B:216:0x044d, B:218:0x0453, B:220:0x046e, B:222:0x0472, B:227:0x048e, B:211:0x043e), top: B:605:0x037b }] */
    /* JADX WARN: Removed duplicated region for block: B:552:0x0a3f A[Catch: all -> 0x0a22, Exception -> 0x0a29, TryCatch #1 {all -> 0x0a22, blocks: (B:511:0x0992, B:513:0x099b, B:542:0x0a1e, B:548:0x0a32, B:550:0x0a37, B:552:0x0a3f, B:553:0x0a42, B:173:0x037b, B:176:0x0382, B:181:0x0390, B:185:0x03a0, B:187:0x03a6, B:189:0x03ac, B:191:0x03b3, B:193:0x03be, B:237:0x04ca, B:239:0x04d2, B:194:0x03d0, B:190:0x03af, B:205:0x0413, B:207:0x0424, B:208:0x042c, B:210:0x0430, B:212:0x0443, B:216:0x044d, B:218:0x0453, B:220:0x046e, B:222:0x0472, B:227:0x048e, B:211:0x043e), top: B:605:0x037b }] */
    /* JADX WARN: Removed duplicated region for block: B:557:0x0a4b  */
    /* JADX WARN: Removed duplicated region for block: B:576:0x0ab2  */
    /* JADX WARN: Removed duplicated region for block: B:585:0x0ad3  */
    /* JADX WARN: Removed duplicated region for block: B:587:0x0afc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:592:0x0b05  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x0390 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:630:0x0a52 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:674:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:676:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:678:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:684:0x0b0c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:693:0x0259 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:699:0x0ab9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:707:0x023f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0171 A[Catch: Exception -> 0x015e, all -> 0x0a71, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x015e, blocks: (B:63:0x0152, B:71:0x0171, B:75:0x01af, B:64:0x0157), top: B:619:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:722:0x073b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:724:0x0727 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:740:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01af A[Catch: Exception -> 0x015e, all -> 0x0a71, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x015e, blocks: (B:63:0x0152, B:71:0x0171, B:75:0x01af, B:64:0x0157), top: B:619:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01da  */
    /* JADX WARN: Type inference failed for: r10v15, types: [int] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v19, types: [long] */
    /* JADX WARN: Type inference failed for: r1v12, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r2v18, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r2v19, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r5v11, types: [int] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v59 */
    /* JADX WARN: Type inference failed for: r8v22, types: [android.media.MediaExtractor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean convertVideoInternal(android.content.Context r61, java.lang.String r62, java.io.File r63, int r64, int r65, int r66, int r67, int r68, int r69, int r70, long r71, long r73, long r75, boolean r77, boolean r78, ir.appp.rghapp.RGHMediaHelper$SavedFilterState r79, java.lang.String r80, org.rbmain.messenger.MediaController.CropState r81) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2853
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.video.SSHMediaCodecVideoConvertor.convertVideoInternal(android.content.Context, java.lang.String, java.io.File, int, int, int, int, int, int, int, long, long, long, boolean, boolean, ir.appp.rghapp.RGHMediaHelper$SavedFilterState, java.lang.String, org.rbmain.messenger.MediaController$CropState):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.video.SSHMediaCodecVideoConvertor.readAndWriteTracks(android.media.MediaExtractor, ir.appp.rghapp.video.MP4Builder, android.media.MediaCodec$BufferInfo, long, long, long, java.io.File, boolean):long");
    }

    private void checkConversionCanceled() {
        MediaController.VideoConvertorListener videoConvertorListener = this.callback;
        if (videoConvertorListener != null && videoConvertorListener.checkConversionCanceled()) {
            throw new RuntimeException("canceled conversion");
        }
    }
}
