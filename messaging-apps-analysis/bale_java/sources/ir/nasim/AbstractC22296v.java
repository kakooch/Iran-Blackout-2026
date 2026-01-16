package ir.nasim;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.FT1;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22296v {

    /* renamed from: ir.nasim.v$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC14254hc6.values().length];
            try {
                iArr[EnumC14254hc6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC14254hc6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public static final Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, Bitmap.Config config) {
        if (Build.VERSION.SDK_INT < 30) {
            return mediaMetadataRetriever.getFrameAtTime(j, i);
        }
        MediaMetadataRetriever.BitmapParams bitmapParamsA = AbstractC19229q.a();
        bitmapParamsA.setPreferredConfig(config);
        return mediaMetadataRetriever.getFrameAtTime(j, i, bitmapParamsA);
    }

    public static final Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, Bitmap.Config config) {
        if (Build.VERSION.SDK_INT < 30) {
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, i2, i3);
        }
        MediaMetadataRetriever.BitmapParams bitmapParamsA = AbstractC19229q.a();
        bitmapParamsA.setPreferredConfig(config);
        return mediaMetadataRetriever.getScaledFrameAtTime(j, i, i2, i3, bitmapParamsA);
    }

    public static final int c(FT1 ft1, EnumC14254hc6 enumC14254hc6) {
        if (ft1 instanceof FT1.a) {
            return ((FT1.a) ft1).a;
        }
        int i = a.a[enumC14254hc6.ordinal()];
        if (i == 1) {
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 2) {
            return Integer.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
