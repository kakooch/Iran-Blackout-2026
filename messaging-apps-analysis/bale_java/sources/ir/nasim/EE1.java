package ir.nasim;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.graphics.ImageDecoder$OnPartialImageListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;

/* loaded from: classes2.dex */
public final class EE1 implements ImageDecoder$OnHeaderDecodedListener {
    private final C18331oU2 a = C18331oU2.b();
    private final int b;
    private final int c;
    private final EnumC18159oB1 d;
    private final AbstractC14220hZ1 e;
    private final boolean f;
    private final EnumC4038Dk5 g;

    class a implements ImageDecoder$OnPartialImageListener {
        a() {
        }

        public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
            return false;
        }
    }

    public EE1(int i, int i2, HL4 hl4) {
        this.b = i;
        this.c = i2;
        this.d = (EnumC18159oB1) hl4.c(C16602lZ1.f);
        this.e = (AbstractC14220hZ1) hl4.c(AbstractC14220hZ1.h);
        C23097wL4 c23097wL4 = C16602lZ1.j;
        this.f = hl4.c(c23097wL4) != null && ((Boolean) hl4.c(c23097wL4)).booleanValue();
        this.g = (EnumC4038Dk5) hl4.c(C16602lZ1.g);
    }

    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        if (this.a.f(this.b, this.c, this.f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.d == EnumC18159oB1.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a());
        Size size = imageInfo.getSize();
        int width = this.b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(size.getHeight() * fB);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        EnumC4038Dk5 enumC4038Dk5 = this.g;
        if (enumC4038Dk5 != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get((enumC4038Dk5 == EnumC4038Dk5.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }
}
