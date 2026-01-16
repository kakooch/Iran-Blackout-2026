package ir.nasim.tgwidgets.editor.messenger.video;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import ir.nasim.AbstractC19363qD5;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.FL3;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.l;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class MediaCodecVideoConvertor {
    private FL3 a;
    private MediaExtractor b;
    private long c;
    private MediaController.r d;
    private String e;

    public class ConversionCanceledException extends RuntimeException {
        public ConversionCanceledException() {
            super("canceled conversion");
        }
    }

    private void a() {
        MediaController.r rVar = this.d;
        if (rVar != null && rVar.c()) {
            throw new ConversionCanceledException();
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type update terminated with stack overflow, arg: (r10v14 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), method size: 6942
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 11 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 12 */
    private boolean c(java.lang.String r74, java.io.File r75, int r76, boolean r77, int r78, int r79, int r80, int r81, int r82, int r83, int r84, long r85, long r87, long r89, long r91, boolean r93, boolean r94, ir.nasim.tgwidgets.editor.messenger.MediaController.n r95, java.lang.String r96, java.util.ArrayList r97, boolean r98, ir.nasim.tgwidgets.editor.messenger.MediaController.i r99, boolean r100, java.lang.Integer r101, java.lang.Integer r102, boolean r103, boolean r104, ir.nasim.tgwidgets.editor.ui.stories.recorder.l.b r105, java.util.ArrayList r106, int r107) {
        /*
            Method dump skipped, instructions count: 6942
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.video.MediaCodecVideoConvertor.c(java.lang.String, java.io.File, int, boolean, int, int, int, int, int, int, int, long, long, long, long, boolean, boolean, ir.nasim.tgwidgets.editor.messenger.MediaController$n, java.lang.String, java.util.ArrayList, boolean, ir.nasim.tgwidgets.editor.messenger.MediaController$i, boolean, java.lang.Integer, java.lang.Integer, boolean, boolean, ir.nasim.tgwidgets.editor.ui.stories.recorder.l$b, java.util.ArrayList, int):boolean");
    }

    private MediaCodec d() throws IOException {
        MediaCodec mediaCodecCreateEncoderByType;
        if (!this.e.equals("video/hevc") || Build.VERSION.SDK_INT < 29) {
            this.e = "video/avc";
            mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("video/avc");
        } else {
            String strG = AbstractC8662Wx6.g();
            mediaCodecCreateEncoderByType = strG != null ? MediaCodec.createByCodecName(strG) : null;
        }
        if (mediaCodecCreateEncoderByType != null || !this.e.equals("video/hevc")) {
            return mediaCodecCreateEncoderByType;
        }
        this.e = "video/avc";
        return MediaCodec.createEncoderByType("video/avc");
    }

    private static String e(int i, int i2, int i3, int i4, boolean z, int i5) {
        int iC = (int) Utilities.c((Math.max(i, i2) / Math.max(i4, i3)) * 0.8f, 2.0f, 1.0f);
        if (iC > 1 && AbstractC8662Wx6.e()) {
            iC = 1;
        }
        int iMin = Math.min(i5, iC);
        AbstractC6403Nl2.a("source size " + i + "x" + i2 + "    dest size " + i3 + i4 + "   kernelRadius " + iMin);
        if (z) {
            return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nconst float kernel = " + iMin + ".0;\nconst float pixelSizeX = 1.0 / " + i + ".0;\nconst float pixelSizeY = 1.0 / " + i2 + ".0;\nuniform samplerExternalOES sTexture;\nvoid main() {\nvec3 accumulation = vec3(0);\nvec3 weightsum = vec3(0);\nfor (float x = -kernel; x <= kernel; x++){\n   for (float y = -kernel; y <= kernel; y++){\n       accumulation += texture2D(sTexture, vTextureCoord + vec2(x * pixelSizeX, y * pixelSizeY)).xyz;\n       weightsum += 1.0;\n   }\n}\ngl_FragColor = vec4(accumulation / weightsum, 1.0);\n}\n";
        }
        return "precision mediump float;\nvarying vec2 vTextureCoord;\nconst float kernel = " + iMin + ".0;\nconst float pixelSizeX = 1.0 / " + i2 + ".0;\nconst float pixelSizeY = 1.0 / " + i + ".0;\nuniform sampler2D sTexture;\nvoid main() {\nvec3 accumulation = vec3(0);\nvec3 weightsum = vec3(0);\nfor (float x = -kernel; x <= kernel; x++){\n   for (float y = -kernel; y <= kernel; y++){\n       accumulation += texture2D(sTexture, vTextureCoord + vec2(x * pixelSizeX, y * pixelSizeY)).xyz;\n       weightsum += 1.0;\n   }\n}\ngl_FragColor = vec4(accumulation / weightsum, 1.0);\n}\n";
    }

    public static void f(String str, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        int i = str.equals("video/hevc") ? 3 : 1;
        if (bufferInfo.size > 100) {
            byteBuffer.position(bufferInfo.offset);
            byte[] bArr = new byte[100];
            byteBuffer.get(bArr);
            int i2 = 0;
            for (int i3 = 0; i3 < 96; i3++) {
                if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 0 && bArr[i3 + 3] == 1 && (i2 = i2 + 1) > i) {
                    bufferInfo.offset += i3;
                    bufferInfo.size -= i3;
                    return;
                }
            }
        }
    }

    private MediaCodec g(MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            throw new RuntimeException("getDecoderByFormat: format is null");
        }
        ArrayList arrayList = new ArrayList();
        String string = mediaFormat.getString("mime");
        arrayList.add(string);
        if ("video/dolby-vision".equals(string)) {
            arrayList.add("video/hevc");
            arrayList.add("video/avc");
        }
        Exception exc = null;
        while (!arrayList.isEmpty()) {
            try {
                String str = (String) arrayList.remove(0);
                mediaFormat.setString("mime", str);
                return MediaCodec.createDecoderByType(str);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        throw new RuntimeException(exc);
    }

    private static String i(int i, int i2, int i3, int i4, boolean z, l.b bVar) {
        if (!z) {
            return "#version 320 es\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nout vec4 fragColor;\nvoid main() {\nfragColor = texture(sTexture, vTextureCoord);\n}\n";
        }
        return (bVar.a() == 1 ? RLottieDrawable.S(null, AbstractC19363qD5.yuv_hlg2rgb) : RLottieDrawable.S(null, AbstractC19363qD5.yuv_pq2rgb)).replace("$dstWidth", i3 + ".0").replace("$dstHeight", i4 + ".0") + "\nin vec2 vTextureCoord;\nout vec4 fragColor;\nvoid main() {\n    fragColor = TEX(vTextureCoord);\n}";
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011b A[PHI: r27 r28
      0x011b: PHI (r27v8 int) = (r27v6 int), (r27v14 int) binds: [B:75:0x0122, B:71:0x0118] A[DONT_GENERATE, DONT_INLINE]
      0x011b: PHI (r28v6 int) = (r28v4 int), (r28v7 int) binds: [B:75:0x0122, B:71:0x0118] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long j(android.media.MediaExtractor r30, ir.nasim.FL3 r31, android.media.MediaCodec.BufferInfo r32, long r33, long r35, long r37, java.io.File r39, boolean r40) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.video.MediaCodecVideoConvertor.j(android.media.MediaExtractor, ir.nasim.FL3, android.media.MediaCodec$BufferInfo, long, long, long, java.io.File, boolean):long");
    }

    public boolean b(String str, File file, int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2, long j3, boolean z2, long j4, MediaController.n nVar, String str2, ArrayList arrayList, boolean z3, MediaController.i iVar, boolean z4, MediaController.r rVar, Integer num, Integer num2, boolean z5, boolean z6, l.b bVar, ArrayList arrayList2) {
        this.d = rVar;
        return c(str, file, i, z, i2, i3, i4, i5, i6, i7, i8, j, j2, j3, j4, z2, false, nVar, str2, arrayList, z3, iVar, z4, num, num2, z5, z6, bVar, arrayList2, 0);
    }

    public long h() {
        return this.c;
    }
}
