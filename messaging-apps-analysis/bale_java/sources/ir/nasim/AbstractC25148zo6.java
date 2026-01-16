package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable;
import java.io.File;

/* renamed from: ir.nasim.zo6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC25148zo6 {
    public static C20786sc1 a = C20786sc1.c();
    private static volatile AbstractC25148zo6[] b = new AbstractC25148zo6[1];

    public static ir.nasim.tgwidgets.editor.messenger.H a(String str) {
        return b(str, a);
    }

    public static ir.nasim.tgwidgets.editor.messenger.H b(String str, C20786sc1 c20786sc1) {
        return c(str, c20786sc1, null);
    }

    public static ir.nasim.tgwidgets.editor.messenger.H c(String str, C20786sc1 c20786sc1, ir.nasim.tgwidgets.editor.messenger.H h) throws IllegalArgumentException {
        ir.nasim.tgwidgets.editor.messenger.H h2;
        boolean z;
        int[] iArr = new int[11];
        AnimatedFileDrawable.G0(str, iArr);
        if (iArr[0] == 0) {
            if (!AbstractC8814Xl0.b) {
                return null;
            }
            AbstractC6403Nl2.b("video hasn't avc1 atom");
            return null;
        }
        long length = new File(str).length();
        int iA0 = MediaController.a0(str);
        if (iA0 == -1) {
            iA0 = iArr[3];
        }
        int iZ0 = iA0;
        float f = iArr[4];
        long j = iArr[5];
        int i = iArr[7];
        ir.nasim.tgwidgets.editor.messenger.H hA = h != null ? h.a() : new ir.nasim.tgwidgets.editor.messenger.H();
        hA.r = true;
        if (h == null) {
            hA.a = -1L;
            hA.b = -1L;
            hA.q = ((long) Math.ceil(f)) * 1000;
        }
        hA.m = iZ0;
        hA.o = str;
        hA.j = iZ0;
        hA.n = i;
        int i2 = iArr[8];
        hA.g = i2;
        if (i2 % SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER == 90) {
            int i3 = iArr[2];
            hA.h = i3;
            hA.k = i3;
            int i4 = iArr[1];
            hA.i = i4;
            hA.l = i4;
        } else {
            int i5 = iArr[1];
            hA.h = i5;
            hA.k = i5;
            int i6 = iArr[2];
            hA.i = i6;
            hA.l = i6;
        }
        hA.t = (long) (f * 1000.0f);
        int iE = c20786sc1.e(Math.max(hA.h, hA.i));
        Integer numH = c20786sc1.h();
        if (numH != null && numH.intValue() > iE) {
            numH = Integer.valueOf(iE);
        }
        if (new File(str).length() < 1048576000) {
            if (numH == null || numH.intValue() != iE || Math.max(hA.h, hA.i) > 1280) {
                if (numH != null) {
                    iE = numH.intValue();
                }
                float f2 = iE != 1 ? iE != 2 ? iE != 3 ? 1280.0f : 848.0f : 640.0f : 432.0f;
                int i7 = hA.h;
                int i8 = hA.i;
                float f3 = f2 / (i7 > i8 ? i7 : i8);
                hA.k = Math.round((i7 * f3) / 2.0f) * 2;
                hA.l = Math.round((hA.i * f3) / 2.0f) * 2;
                z = true;
            } else {
                z = false;
            }
            h2 = hA;
            iZ0 = MediaController.z0(hA.i, hA.h, iZ0, hA.l, hA.k, c20786sc1.d());
        } else {
            h2 = hA;
            z = false;
        }
        if (z) {
            h2.m = iZ0;
            h2.p = (long) (j + (((f / 1000.0f) * MediaController.V(h2.k, h2.l, iZ0)) / 8.0f));
        } else {
            h2.k = h2.h;
            h2.l = h2.i;
            h2.m = iZ0;
            h2.p = length;
        }
        if (h2.p == 0) {
            h2.p = 1L;
        }
        return h2;
    }

    public static Bitmap d(String str, int i) {
        float f = i == 2 ? 1920.0f : i == 3 ? 96.0f : 512.0f;
        Bitmap bitmapE = e(str, 0L);
        if (bitmapE == null) {
            return bitmapE;
        }
        int width = bitmapE.getWidth();
        int height = bitmapE.getHeight();
        float f2 = width;
        if (f2 <= f && height <= f) {
            return bitmapE;
        }
        float fMax = Math.max(width, height) / f;
        return Bitmap.createScaledBitmap(bitmapE, (int) (f2 / fMax), (int) (height / fMax), true);
    }

    public static Bitmap e(String str, long j) {
        return f(str, j, null, false);
    }

    public static Bitmap f(String str, long j, int[] iArr, boolean z) {
        Bitmap bitmapA0;
        if (z) {
            AnimatedFileDrawable animatedFileDrawable = new AnimatedFileDrawable(new File(str), true, 0L, 0, null, null, null, 0L, 0, true, null);
            bitmapA0 = animatedFileDrawable.A0(j, z);
            if (iArr != null) {
                iArr[0] = animatedFileDrawable.D0();
            }
            animatedFileDrawable.O0();
            if (bitmapA0 == null) {
                return f(str, j, iArr, false);
            }
        } else {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            bitmapA0 = null;
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(j, 1);
                    if (frameAtTime == null) {
                        try {
                            frameAtTime = mediaMetadataRetriever.getFrameAtTime(j, 3);
                        } catch (Exception unused) {
                        }
                    }
                    bitmapA0 = frameAtTime;
                } catch (Exception unused2) {
                }
            } finally {
                try {
                    mediaMetadataRetriever.release();
                } catch (Throwable unused3) {
                }
            }
        }
        return bitmapA0;
    }
}
