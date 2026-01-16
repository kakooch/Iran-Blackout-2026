package me.dm7.barcodescanner.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import ir.nasim.C17003mE0;
import ir.nasim.EC5;
import ir.nasim.HandlerThreadC12812fD0;
import ir.nasim.InterfaceC17461n03;
import ir.nasim.KA5;
import ir.nasim.OE5;
import ir.nasim.RD0;
import java.io.IOException;

/* loaded from: classes8.dex */
public abstract class BarcodeScannerView extends FrameLayout implements Camera.PreviewCallback {
    private C17003mE0 a;
    private CameraPreview b;
    private InterfaceC17461n03 c;
    private Rect d;
    private HandlerThreadC12812fD0 e;
    private Boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private int p;
    private boolean q;
    private float r;
    private int s;
    private float t;

    public BarcodeScannerView(Context context) {
        super(context);
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = getResources().getColor(KA5.viewfinder_laser);
        this.k = getResources().getColor(KA5.viewfinder_border);
        this.l = getResources().getColor(KA5.viewfinder_mask);
        this.m = getResources().getInteger(EC5.viewfinder_border_width);
        this.n = getResources().getInteger(EC5.viewfinder_border_length);
        this.o = false;
        this.p = 0;
        this.q = false;
        this.r = 1.0f;
        this.s = 0;
        this.t = 0.1f;
        d();
    }

    private void d() {
        this.c = a(getContext());
    }

    protected InterfaceC17461n03 a(Context context) {
        ViewFinderView viewFinderView = new ViewFinderView(context);
        viewFinderView.setBorderColor(this.k);
        viewFinderView.setLaserColor(this.j);
        viewFinderView.setLaserEnabled(this.i);
        viewFinderView.setBorderStrokeWidth(this.m);
        viewFinderView.setBorderLineLength(this.n);
        viewFinderView.setMaskColor(this.l);
        viewFinderView.setBorderCornerRounded(this.o);
        viewFinderView.setBorderCornerRadius(this.p);
        viewFinderView.setSquareViewFinder(this.q);
        viewFinderView.setViewFinderOffset(this.s);
        return viewFinderView;
    }

    public synchronized Rect b(int i, int i2) {
        try {
            if (this.d == null) {
                Rect framingRect = this.c.getFramingRect();
                int width = this.c.getWidth();
                int height = this.c.getHeight();
                if (framingRect != null && width != 0 && height != 0) {
                    Rect rect = new Rect(framingRect);
                    if (i < width) {
                        rect.left = (rect.left * i) / width;
                        rect.right = (rect.right * i) / width;
                    }
                    if (i2 < height) {
                        rect.top = (rect.top * i2) / height;
                        rect.bottom = (rect.bottom * i2) / height;
                    }
                    this.d = rect;
                }
                return null;
            }
            return this.d;
        } finally {
        }
    }

    public byte[] c(byte[] bArr, Camera camera) {
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        int i = previewSize.width;
        int i2 = previewSize.height;
        int rotationCount = getRotationCount();
        if (rotationCount == 1 || rotationCount == 3) {
            int i3 = 0;
            while (i3 < rotationCount) {
                byte[] bArr2 = new byte[bArr.length];
                for (int i4 = 0; i4 < i2; i4++) {
                    for (int i5 = 0; i5 < i; i5++) {
                        bArr2[(((i5 * i2) + i2) - i4) - 1] = bArr[(i4 * i) + i5];
                    }
                }
                i3++;
                bArr = bArr2;
                int i6 = i;
                i = i2;
                i2 = i6;
            }
        }
        return bArr;
    }

    protected void e() throws IOException {
        CameraPreview cameraPreview = this.b;
        if (cameraPreview != null) {
            cameraPreview.l();
        }
    }

    public void f() {
        g(RD0.b());
    }

    public void g(int i) {
        if (this.e == null) {
            this.e = new HandlerThreadC12812fD0(this);
        }
        this.e.b(i);
    }

    public boolean getFlash() {
        C17003mE0 c17003mE0 = this.a;
        return c17003mE0 != null && RD0.c(c17003mE0.a) && this.a.a.getParameters().getFlashMode().equals("torch");
    }

    public int getRotationCount() {
        return this.b.getDisplayOrientation() / 90;
    }

    public void h() {
        if (this.a != null) {
            this.b.m();
            this.b.setCamera(null, null);
            this.a.a.release();
            this.a = null;
        }
        HandlerThreadC12812fD0 handlerThreadC12812fD0 = this.e;
        if (handlerThreadC12812fD0 != null) {
            handlerThreadC12812fD0.quit();
            this.e = null;
        }
    }

    public void i() {
        CameraPreview cameraPreview = this.b;
        if (cameraPreview != null) {
            cameraPreview.m();
        }
    }

    public void j() {
        C17003mE0 c17003mE0 = this.a;
        if (c17003mE0 == null || !RD0.c(c17003mE0.a)) {
            return;
        }
        Camera.Parameters parameters = this.a.a.getParameters();
        if (parameters.getFlashMode().equals("torch")) {
            parameters.setFlashMode("off");
        } else {
            parameters.setFlashMode("torch");
        }
        this.a.a.setParameters(parameters);
    }

    public void setAspectTolerance(float f) {
        this.t = f;
    }

    public void setAutoFocus(boolean z) {
        this.g = z;
        CameraPreview cameraPreview = this.b;
        if (cameraPreview != null) {
            cameraPreview.setAutoFocus(z);
        }
    }

    public void setBorderAlpha(float f) {
        this.r = f;
        this.c.setBorderAlpha(f);
        this.c.setupViewFinder();
    }

    public void setBorderColor(int i) {
        this.k = i;
        this.c.setBorderColor(i);
        this.c.setupViewFinder();
    }

    public void setBorderCornerRadius(int i) {
        this.p = i;
        this.c.setBorderCornerRadius(i);
        this.c.setupViewFinder();
    }

    public void setBorderLineLength(int i) {
        this.n = i;
        this.c.setBorderLineLength(i);
        this.c.setupViewFinder();
    }

    public void setBorderStrokeWidth(int i) {
        this.m = i;
        this.c.setBorderStrokeWidth(i);
        this.c.setupViewFinder();
    }

    public void setFlash(boolean z) {
        this.f = Boolean.valueOf(z);
        C17003mE0 c17003mE0 = this.a;
        if (c17003mE0 == null || !RD0.c(c17003mE0.a)) {
            return;
        }
        Camera.Parameters parameters = this.a.a.getParameters();
        if (z) {
            if (parameters.getFlashMode().equals("torch")) {
                return;
            } else {
                parameters.setFlashMode("torch");
            }
        } else if (parameters.getFlashMode().equals("off")) {
            return;
        } else {
            parameters.setFlashMode("off");
        }
        this.a.a.setParameters(parameters);
    }

    public void setIsBorderCornerRounded(boolean z) {
        this.o = z;
        this.c.setBorderCornerRounded(z);
        this.c.setupViewFinder();
    }

    public void setLaserColor(int i) {
        this.j = i;
        this.c.setLaserColor(i);
        this.c.setupViewFinder();
    }

    public void setLaserEnabled(boolean z) {
        this.i = z;
        this.c.setLaserEnabled(z);
        this.c.setupViewFinder();
    }

    public void setMaskColor(int i) {
        this.l = i;
        this.c.setMaskColor(i);
        this.c.setupViewFinder();
    }

    public void setShouldScaleToFill(boolean z) {
        this.h = z;
    }

    public void setSquareViewFinder(boolean z) {
        this.q = z;
        this.c.setSquareViewFinder(z);
        this.c.setupViewFinder();
    }

    public void setupCameraPreview(C17003mE0 c17003mE0) {
        this.a = c17003mE0;
        if (c17003mE0 != null) {
            setupLayout(c17003mE0);
            this.c.setupViewFinder();
            Boolean bool = this.f;
            if (bool != null) {
                setFlash(bool.booleanValue());
            }
            setAutoFocus(this.g);
        }
    }

    public final void setupLayout(C17003mE0 c17003mE0) {
        removeAllViews();
        CameraPreview cameraPreview = new CameraPreview(getContext(), c17003mE0, this);
        this.b = cameraPreview;
        cameraPreview.setAspectTolerance(this.t);
        this.b.setShouldScaleToFill(this.h);
        if (this.h) {
            addView(this.b);
        } else {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setGravity(17);
            relativeLayout.setBackgroundColor(-16777216);
            relativeLayout.addView(this.b);
            addView(relativeLayout);
        }
        Object obj = this.c;
        if (!(obj instanceof View)) {
            throw new IllegalArgumentException("IViewFinder object returned by 'createViewFinderView()' should be instance of android.view.View");
        }
        addView((View) obj);
    }

    public BarcodeScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = getResources().getColor(KA5.viewfinder_laser);
        this.k = getResources().getColor(KA5.viewfinder_border);
        this.l = getResources().getColor(KA5.viewfinder_mask);
        this.m = getResources().getInteger(EC5.viewfinder_border_width);
        this.n = getResources().getInteger(EC5.viewfinder_border_length);
        this.o = false;
        this.p = 0;
        this.q = false;
        this.r = 1.0f;
        this.s = 0;
        this.t = 0.1f;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, OE5.BarcodeScannerView, 0, 0);
        try {
            setShouldScaleToFill(typedArrayObtainStyledAttributes.getBoolean(OE5.BarcodeScannerView_shouldScaleToFill, true));
            this.i = typedArrayObtainStyledAttributes.getBoolean(OE5.BarcodeScannerView_laserEnabled, this.i);
            this.j = typedArrayObtainStyledAttributes.getColor(OE5.BarcodeScannerView_laserColor, this.j);
            this.k = typedArrayObtainStyledAttributes.getColor(OE5.BarcodeScannerView_borderColor, this.k);
            this.l = typedArrayObtainStyledAttributes.getColor(OE5.BarcodeScannerView_maskColor, this.l);
            this.m = typedArrayObtainStyledAttributes.getDimensionPixelSize(OE5.BarcodeScannerView_borderWidth, this.m);
            this.n = typedArrayObtainStyledAttributes.getDimensionPixelSize(OE5.BarcodeScannerView_borderLength, this.n);
            this.o = typedArrayObtainStyledAttributes.getBoolean(OE5.BarcodeScannerView_roundedCorner, this.o);
            this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(OE5.BarcodeScannerView_cornerRadius, this.p);
            this.q = typedArrayObtainStyledAttributes.getBoolean(OE5.BarcodeScannerView_squaredFinder, this.q);
            this.r = typedArrayObtainStyledAttributes.getFloat(OE5.BarcodeScannerView_borderAlpha, this.r);
            this.s = typedArrayObtainStyledAttributes.getDimensionPixelSize(OE5.BarcodeScannerView_finderOffset, this.s);
            typedArrayObtainStyledAttributes.recycle();
            d();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
