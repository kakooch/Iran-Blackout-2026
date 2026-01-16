package io.sentry.android.replay.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Range;
import android.view.Surface;
import io.sentry.C3155n3;
import io.sentry.Y2;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.ED1;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;

/* loaded from: classes3.dex */
public final class c {
    private final C3155n3 a;
    private final io.sentry.android.replay.video.a b;
    private final SA2 c;
    private final InterfaceC9173Yu3 d;
    private final MediaCodec e;
    private final InterfaceC9173Yu3 f;
    private final MediaCodec.BufferInfo g;
    private final io.sentry.android.replay.video.b h;
    private Surface i;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            boolean z = false;
            MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
            AbstractC13042fc3.h(codecInfos, "MediaCodecList(MediaCode…EGULAR_CODECS).codecInfos");
            int length = codecInfos.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String name = codecInfos[i].getName();
                AbstractC13042fc3.h(name, "it.name");
                if (AbstractC20762sZ6.X(name, "c2.exynos", false, 2, null)) {
                    z = true;
                    break;
                }
                i++;
            }
            return Boolean.valueOf(z);
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MediaFormat invoke() {
            int iA = c.this.g().a();
            try {
                MediaCodecInfo.VideoCapabilities videoCapabilities = c.this.e().getCodecInfo().getCapabilitiesForType(c.this.g().d()).getVideoCapabilities();
                if (!videoCapabilities.getBitrateRange().contains((Range<Integer>) Integer.valueOf(iA))) {
                    c.this.h().getLogger().c(Y2.DEBUG, "Encoder doesn't support the provided bitRate: " + iA + ", the value will be clamped to the closest one", new Object[0]);
                    Object objClamp = videoCapabilities.getBitrateRange().clamp(Integer.valueOf(iA));
                    AbstractC13042fc3.h(objClamp, "videoCapabilities.bitrateRange.clamp(bitRate)");
                    iA = ((Number) objClamp).intValue();
                }
            } catch (Throwable th) {
                c.this.h().getLogger().b(Y2.DEBUG, "Could not retrieve MediaCodec info", th);
            }
            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(c.this.g().d(), c.this.g().f(), c.this.g().e());
            AbstractC13042fc3.h(mediaFormatCreateVideoFormat, "createVideoFormat(\n     …ecordingHeight,\n        )");
            mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
            mediaFormatCreateVideoFormat.setInteger("bitrate", iA);
            mediaFormatCreateVideoFormat.setFloat("frame-rate", c.this.g().c());
            mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 6);
            return mediaFormatCreateVideoFormat;
        }
    }

    public c(C3155n3 c3155n3, io.sentry.android.replay.video.a aVar, SA2 sa2) {
        AbstractC13042fc3.i(c3155n3, "options");
        AbstractC13042fc3.i(aVar, "muxerConfig");
        this.a = c3155n3;
        this.b = aVar;
        this.c = sa2;
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        this.d = AbstractC13269fw3.b(enumC4870Gx3, a.e);
        MediaCodec mediaCodecCreateByCodecName = d() ? MediaCodec.createByCodecName("c2.android.avc.encoder") : MediaCodec.createEncoderByType(aVar.d());
        AbstractC13042fc3.h(mediaCodecCreateByCodecName, "if (hasExynosCodec) {\n  …rConfig.mimeType)\n      }");
        this.e = mediaCodecCreateByCodecName;
        this.f = AbstractC13269fw3.b(enumC4870Gx3, new b());
        this.g = new MediaCodec.BufferInfo();
        String absolutePath = aVar.b().getAbsolutePath();
        AbstractC13042fc3.h(absolutePath, "muxerConfig.file.absolutePath");
        this.h = new io.sentry.android.replay.video.b(absolutePath, aVar.c());
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x01e0, code lost:
    
        throw new java.lang.RuntimeException("encoderOutputBuffer " + r2 + " was null");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a(boolean r9) {
        /*
            Method dump skipped, instructions count: 481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.video.c.a(boolean):void");
    }

    private final boolean d() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    private final MediaFormat f() {
        return (MediaFormat) this.f.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.graphics.Bitmap r8) {
        /*
            r7 = this;
            java.lang.String r0 = "image"
            ir.nasim.AbstractC13042fc3.i(r8, r0)
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = "MANUFACTURER"
            ir.nasim.AbstractC13042fc3.h(r0, r1)
            java.lang.String r2 = "xiaomi"
            r3 = 1
            boolean r2 = ir.nasim.AbstractC14836iZ6.V(r0, r2, r3)
            r4 = 0
            if (r2 != 0) goto L4a
            ir.nasim.AbstractC13042fc3.h(r0, r1)
            java.lang.String r1 = "motorola"
            boolean r0 = ir.nasim.AbstractC14836iZ6.V(r0, r1, r3)
            if (r0 != 0) goto L4a
            io.sentry.android.replay.util.m r0 = io.sentry.android.replay.util.m.a
            io.sentry.android.replay.util.m$a r1 = io.sentry.android.replay.util.m.a.SOC_MANUFACTURER
            r2 = 2
            java.lang.String r5 = io.sentry.android.replay.util.m.b(r0, r1, r4, r2, r4)
            java.lang.String r6 = "spreadtrum"
            boolean r5 = ir.nasim.AbstractC14836iZ6.D(r5, r6, r3)
            if (r5 != 0) goto L4a
            java.lang.String r0 = io.sentry.android.replay.util.m.b(r0, r1, r4, r2, r4)
            java.lang.String r1 = "unisoc"
            boolean r0 = ir.nasim.AbstractC14836iZ6.D(r0, r1, r3)
            if (r0 == 0) goto L3f
            goto L4a
        L3f:
            android.view.Surface r0 = r7.i
            if (r0 == 0) goto L48
            android.graphics.Canvas r0 = r0.lockHardwareCanvas()
            goto L52
        L48:
            r0 = r4
            goto L52
        L4a:
            android.view.Surface r0 = r7.i
            if (r0 == 0) goto L48
            android.graphics.Canvas r0 = r0.lockCanvas(r4)
        L52:
            if (r0 == 0) goto L58
            r1 = 0
            r0.drawBitmap(r8, r1, r1, r4)
        L58:
            android.view.Surface r8 = r7.i
            if (r8 == 0) goto L5f
            r8.unlockCanvasAndPost(r0)
        L5f:
            r8 = 0
            r7.a(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.video.c.b(android.graphics.Bitmap):void");
    }

    public final long c() {
        return this.h.a();
    }

    public final MediaCodec e() {
        return this.e;
    }

    public final io.sentry.android.replay.video.a g() {
        return this.b;
    }

    public final C3155n3 h() {
        return this.a;
    }

    public final void i() {
        try {
            SA2 sa2 = this.c;
            if (sa2 != null) {
                sa2.invoke();
            }
            a(true);
            this.e.stop();
            this.e.release();
            Surface surface = this.i;
            if (surface != null) {
                surface.release();
            }
            this.h.d();
        } catch (Throwable th) {
            this.a.getLogger().b(Y2.DEBUG, "Failed to properly release video encoder", th);
        }
    }

    public final void j() {
        this.e.configure(f(), (Surface) null, (MediaCrypto) null, 1);
        this.i = this.e.createInputSurface();
        this.e.start();
        a(false);
    }

    public /* synthetic */ c(C3155n3 c3155n3, io.sentry.android.replay.video.a aVar, SA2 sa2, int i, ED1 ed1) {
        this(c3155n3, aVar, (i & 4) != 0 ? null : sa2);
    }
}
