package ir.eitaa.ui.Components;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.collection.ArrayMap;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.Utilities;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BackgroundGradientDrawable extends GradientDrawable {
    private final Paint bitmapPaint;
    private final ArrayMap<IntSize, Bitmap> bitmaps;
    private final int[] colors;
    private final ArrayMap<View, Disposable> disposables;
    private boolean disposed;
    private final List<Runnable[]> ditheringRunnables;
    private final ArrayMap<IntSize, Boolean> isForExactBounds;

    public interface Disposable {
        void dispose();
    }

    public interface Listener {
        void onAllSizesReady();

        void onSizeReady(int width, int height);
    }

    public static class ListenerAdapter implements Listener {
        @Override // ir.eitaa.ui.Components.BackgroundGradientDrawable.Listener
        public void onAllSizesReady() {
        }

        @Override // ir.eitaa.ui.Components.BackgroundGradientDrawable.Listener
        public void onSizeReady(int width, int height) {
        }
    }

    public static class Sizes {
        private final IntSize[] arr;

        public enum Orientation {
            PORTRAIT,
            LANDSCAPE,
            BOTH
        }

        private Sizes(int width, int height, int... additionalSizes) {
            IntSize[] intSizeArr = new IntSize[(additionalSizes.length / 2) + 1];
            this.arr = intSizeArr;
            IntSize intSize = new IntSize(width, height);
            int i = 0;
            intSizeArr[0] = intSize;
            while (i < additionalSizes.length / 2) {
                int i2 = i + 1;
                int i3 = i * 2;
                this.arr[i2] = new IntSize(additionalSizes[i3], additionalSizes[i3 + 1]);
                i = i2;
            }
        }

        public static Sizes of(int width, int height, int... additionalSizes) {
            return new Sizes(width, height, additionalSizes);
        }

        public static Sizes ofDeviceScreen() {
            return ofDeviceScreen(0.5f);
        }

        public static Sizes ofDeviceScreen(float compressRatio) {
            return ofDeviceScreen(compressRatio, Orientation.BOTH);
        }

        public static Sizes ofDeviceScreen(Orientation orientation) {
            return ofDeviceScreen(0.5f, orientation);
        }

        public static Sizes ofDeviceScreen(float compressRatio, Orientation orientation) {
            android.graphics.Point point = AndroidUtilities.displaySize;
            int i = (int) (point.x * compressRatio);
            int i2 = (int) (point.y * compressRatio);
            if (i == i2) {
                return of(i, i2, new int[0]);
            }
            if (orientation == Orientation.BOTH) {
                return of(i, i2, i2, i);
            }
            return (orientation == Orientation.PORTRAIT) == (i < i2) ? of(i, i2, new int[0]) : of(i2, i, new int[0]);
        }
    }

    public BackgroundGradientDrawable(GradientDrawable.Orientation orientation, int[] colors) {
        super(orientation, colors);
        this.bitmaps = new ArrayMap<>();
        this.isForExactBounds = new ArrayMap<>();
        this.disposables = new ArrayMap<>();
        this.ditheringRunnables = new ArrayList();
        Paint paint = new Paint(1);
        this.bitmapPaint = paint;
        this.disposed = false;
        setDither(true);
        this.colors = colors;
        paint.setDither(true);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.disposed) {
            super.draw(canvas);
            return;
        }
        android.graphics.Rect bounds = getBounds();
        Bitmap bitmapFindBestBitmapForSize = findBestBitmapForSize(bounds.width(), bounds.height());
        if (bitmapFindBestBitmapForSize != null) {
            canvas.drawBitmap(bitmapFindBestBitmapForSize, (android.graphics.Rect) null, bounds, this.bitmapPaint);
        } else {
            super.draw(canvas);
        }
    }

    public Disposable drawExactBoundsSize(Canvas canvas, View ownerView) {
        return drawExactBoundsSize(canvas, ownerView, 0.5f);
    }

    public Disposable drawExactBoundsSize(Canvas canvas, final View ownerView, float compressRatio) throws InterruptedException {
        if (this.disposed) {
            super.draw(canvas);
            return null;
        }
        android.graphics.Rect bounds = getBounds();
        int iWidth = (int) (bounds.width() * compressRatio);
        int iHeight = (int) (bounds.height() * compressRatio);
        int size = this.bitmaps.size();
        for (int i = 0; i < size; i++) {
            IntSize intSizeKeyAt = this.bitmaps.keyAt(i);
            if (intSizeKeyAt.width == iWidth && intSizeKeyAt.height == iHeight) {
                Bitmap bitmapValueAt = this.bitmaps.valueAt(i);
                if (bitmapValueAt != null) {
                    canvas.drawBitmap(bitmapValueAt, (android.graphics.Rect) null, bounds, this.bitmapPaint);
                } else {
                    super.draw(canvas);
                }
                return this.disposables.get(ownerView);
            }
        }
        Disposable disposableRemove = this.disposables.remove(ownerView);
        if (disposableRemove != null) {
            disposableRemove.dispose();
        }
        IntSize intSize = new IntSize(iWidth, iHeight);
        this.bitmaps.put(intSize, null);
        this.isForExactBounds.put(intSize, Boolean.TRUE);
        final Disposable disposableStartDitheringInternal = startDitheringInternal(new IntSize[]{intSize}, new ListenerAdapter() { // from class: ir.eitaa.ui.Components.BackgroundGradientDrawable.1
            @Override // ir.eitaa.ui.Components.BackgroundGradientDrawable.ListenerAdapter, ir.eitaa.ui.Components.BackgroundGradientDrawable.Listener
            public void onAllSizesReady() {
                ownerView.invalidate();
            }
        }, 0L);
        Disposable disposablePut = this.disposables.put(ownerView, new Disposable() { // from class: ir.eitaa.ui.Components.-$$Lambda$BackgroundGradientDrawable$8wEoYsvDsxuS3VP0NKRjw3kUgp4
            @Override // ir.eitaa.ui.Components.BackgroundGradientDrawable.Disposable
            public final void dispose() {
                this.f$0.lambda$drawExactBoundsSize$0$BackgroundGradientDrawable(ownerView, disposableStartDitheringInternal);
            }
        });
        super.draw(canvas);
        return disposablePut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$drawExactBoundsSize$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$drawExactBoundsSize$0$BackgroundGradientDrawable(View view, Disposable disposable) {
        this.disposables.remove(view);
        disposable.dispose();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        super.setAlpha(alpha);
        this.bitmapPaint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.bitmapPaint.setColorFilter(colorFilter);
    }

    public int[] getColorsList() {
        return this.colors;
    }

    protected void finalize() throws Throwable {
        try {
            dispose();
        } finally {
            super.finalize();
        }
    }

    public Disposable startDithering(Sizes sizes, Listener listener) {
        return startDithering(sizes, listener, 0L);
    }

    public Disposable startDithering(Sizes sizes, Listener listener, long delay) {
        if (this.disposed) {
            return null;
        }
        ArrayList arrayList = new ArrayList(sizes.arr.length);
        for (int i = 0; i < sizes.arr.length; i++) {
            IntSize intSize = sizes.arr[i];
            if (!this.bitmaps.containsKey(intSize)) {
                this.bitmaps.put(intSize, null);
                arrayList.add(intSize);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return startDitheringInternal((IntSize[]) arrayList.toArray(new IntSize[0]), listener, delay);
    }

    private Disposable startDitheringInternal(final IntSize[] sizesArr, Listener listener, long delay) throws InterruptedException {
        if (sizesArr.length == 0) {
            return null;
        }
        final Listener[] listenerArr = {listener};
        final Runnable[] runnableArr = new Runnable[sizesArr.length];
        this.ditheringRunnables.add(runnableArr);
        for (int i = 0; i < sizesArr.length; i++) {
            final IntSize intSize = sizesArr[i];
            if (intSize.width != 0 && intSize.height != 0) {
                DispatchQueue dispatchQueue = Utilities.globalQueue;
                final int i2 = i;
                Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$BackgroundGradientDrawable$3WATNlfoPTAlm-A2_a75KjyVk50
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$startDitheringInternal$2$BackgroundGradientDrawable(intSize, runnableArr, i2, listenerArr);
                    }
                };
                runnableArr[i] = runnable;
                dispatchQueue.postRunnable(runnable, delay);
            }
        }
        return new Disposable() { // from class: ir.eitaa.ui.Components.-$$Lambda$BackgroundGradientDrawable$yTVZj8I3srEKmmSD5lh-LQO5SYQ
            @Override // ir.eitaa.ui.Components.BackgroundGradientDrawable.Disposable
            public final void dispose() throws InterruptedException {
                this.f$0.lambda$startDitheringInternal$3$BackgroundGradientDrawable(listenerArr, runnableArr, sizesArr);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startDitheringInternal$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startDitheringInternal$2$BackgroundGradientDrawable(final IntSize intSize, final Runnable[] runnableArr, final int i, final Listener[] listenerArr) {
        try {
            final Bitmap bitmapCreateDitheredGradientBitmap = createDitheredGradientBitmap(getOrientation(), this.colors, intSize.width, intSize.height);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$BackgroundGradientDrawable$HJ5ANvYVxIYciBDnUGqJIJsGhpk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startDitheringInternal$1$BackgroundGradientDrawable(runnableArr, bitmapCreateDitheredGradientBitmap, intSize, i, listenerArr);
                }
            });
        } catch (Throwable th) {
            final Bitmap bitmap = null;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$BackgroundGradientDrawable$HJ5ANvYVxIYciBDnUGqJIJsGhpk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startDitheringInternal$1$BackgroundGradientDrawable(runnableArr, bitmap, intSize, i, listenerArr);
                }
            });
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startDitheringInternal$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startDitheringInternal$1$BackgroundGradientDrawable(Runnable[] runnableArr, Bitmap bitmap, IntSize intSize, int i, Listener[] listenerArr) {
        if (!this.ditheringRunnables.contains(runnableArr)) {
            if (bitmap != null) {
                bitmap.recycle();
                return;
            }
            return;
        }
        if (bitmap != null) {
            this.bitmaps.put(intSize, bitmap);
        } else {
            this.bitmaps.remove(intSize);
            this.isForExactBounds.remove(intSize);
        }
        runnableArr[i] = null;
        boolean z = true;
        if (runnableArr.length > 1) {
            for (Runnable runnable : runnableArr) {
                if (runnable != null) {
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (!z) {
            this.ditheringRunnables.remove(runnableArr);
        }
        if (listenerArr[0] != null) {
            listenerArr[0].onSizeReady(intSize.width, intSize.height);
            if (z) {
                return;
            }
            listenerArr[0].onAllSizesReady();
            listenerArr[0] = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startDitheringInternal$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startDitheringInternal$3$BackgroundGradientDrawable(Listener[] listenerArr, Runnable[] runnableArr, IntSize[] intSizeArr) throws InterruptedException {
        listenerArr[0] = null;
        if (this.ditheringRunnables.contains(runnableArr)) {
            Utilities.globalQueue.cancelRunnables(runnableArr);
            this.ditheringRunnables.remove(runnableArr);
        }
        for (IntSize intSize : intSizeArr) {
            Bitmap bitmapRemove = this.bitmaps.remove(intSize);
            this.isForExactBounds.remove(intSize);
            if (bitmapRemove != null) {
                bitmapRemove.recycle();
            }
        }
    }

    public void dispose() throws InterruptedException {
        if (this.disposed) {
            return;
        }
        for (int size = this.ditheringRunnables.size() - 1; size >= 0; size--) {
            Utilities.globalQueue.cancelRunnables(this.ditheringRunnables.remove(size));
        }
        for (int size2 = this.bitmaps.size() - 1; size2 >= 0; size2--) {
            Bitmap bitmapRemoveAt = this.bitmaps.removeAt(size2);
            if (bitmapRemoveAt != null) {
                bitmapRemoveAt.recycle();
            }
        }
        this.isForExactBounds.clear();
        this.disposables.clear();
        this.disposed = true;
    }

    private Bitmap findBestBitmapForSize(int width, int height) {
        Bitmap bitmapValueAt;
        Boolean bool;
        int size = this.bitmaps.size();
        Bitmap bitmap = null;
        float f = Float.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            IntSize intSizeKeyAt = this.bitmaps.keyAt(i);
            float fSqrt = (float) Math.sqrt(Math.pow(width - intSizeKeyAt.width, 2.0d) + Math.pow(height - intSizeKeyAt.height, 2.0d));
            if (fSqrt < f && (bitmapValueAt = this.bitmaps.valueAt(i)) != null && ((bool = this.isForExactBounds.get(intSizeKeyAt)) == null || !bool.booleanValue())) {
                f = fSqrt;
                bitmap = bitmapValueAt;
            }
        }
        return bitmap;
    }

    /* renamed from: ir.eitaa.ui.Components.BackgroundGradientDrawable$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation;

        static {
            int[] iArr = new int[GradientDrawable.Orientation.values().length];
            $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation = iArr;
            try {
                iArr[GradientDrawable.Orientation.TOP_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[GradientDrawable.Orientation.TR_BL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[GradientDrawable.Orientation.RIGHT_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[GradientDrawable.Orientation.BR_TL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[GradientDrawable.Orientation.BOTTOM_TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[GradientDrawable.Orientation.BL_TR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[GradientDrawable.Orientation.LEFT_RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static android.graphics.Rect getGradientPoints(GradientDrawable.Orientation orientation, int width, int height) {
        android.graphics.Rect rect = new android.graphics.Rect();
        switch (AnonymousClass2.$SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[orientation.ordinal()]) {
            case 1:
                int i = width / 2;
                rect.left = i;
                rect.top = 0;
                rect.right = i;
                rect.bottom = height;
                return rect;
            case 2:
                rect.left = width;
                rect.top = 0;
                rect.right = 0;
                rect.bottom = height;
                return rect;
            case 3:
                rect.left = width;
                int i2 = height / 2;
                rect.top = i2;
                rect.right = 0;
                rect.bottom = i2;
                return rect;
            case 4:
                rect.left = width;
                rect.top = height;
                rect.right = 0;
                rect.bottom = 0;
                return rect;
            case 5:
                int i3 = width / 2;
                rect.left = i3;
                rect.top = height;
                rect.right = i3;
                rect.bottom = 0;
                return rect;
            case 6:
                rect.left = 0;
                rect.top = height;
                rect.right = width;
                rect.bottom = 0;
                return rect;
            case 7:
                rect.left = 0;
                int i4 = height / 2;
                rect.top = i4;
                rect.right = width;
                rect.bottom = i4;
                return rect;
            default:
                rect.left = 0;
                rect.top = 0;
                rect.right = width;
                rect.bottom = height;
                return rect;
        }
    }

    public static android.graphics.Rect getGradientPoints(int gradientAngle, int width, int height) {
        return getGradientPoints(getGradientOrientation(gradientAngle), width, height);
    }

    public static GradientDrawable.Orientation getGradientOrientation(int gradientAngle) {
        if (gradientAngle == 0) {
            return GradientDrawable.Orientation.BOTTOM_TOP;
        }
        if (gradientAngle == 90) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
        if (gradientAngle == 135) {
            return GradientDrawable.Orientation.TL_BR;
        }
        if (gradientAngle == 180) {
            return GradientDrawable.Orientation.TOP_BOTTOM;
        }
        if (gradientAngle == 225) {
            return GradientDrawable.Orientation.TR_BL;
        }
        if (gradientAngle == 270) {
            return GradientDrawable.Orientation.RIGHT_LEFT;
        }
        if (gradientAngle == 315) {
            return GradientDrawable.Orientation.BR_TL;
        }
        return GradientDrawable.Orientation.BL_TR;
    }

    public static BitmapDrawable createDitheredGradientBitmapDrawable(int angle, int[] colors, int width, int height) {
        return createDitheredGradientBitmapDrawable(getGradientOrientation(angle), colors, width, height);
    }

    public static BitmapDrawable createDitheredGradientBitmapDrawable(GradientDrawable.Orientation orientation, int[] colors, int width, int height) {
        return new BitmapDrawable(ApplicationLoader.applicationContext.getResources(), createDitheredGradientBitmap(orientation, colors, width, height));
    }

    private static Bitmap createDitheredGradientBitmap(GradientDrawable.Orientation orientation, int[] colors, int width, int height) {
        android.graphics.Rect gradientPoints = getGradientPoints(orientation, width, height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Utilities.drawDitheredGradient(bitmapCreateBitmap, colors, gradientPoints.left, gradientPoints.top, gradientPoints.right, gradientPoints.bottom);
        return bitmapCreateBitmap;
    }
}
