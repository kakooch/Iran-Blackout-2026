package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.core.impl.t;
import ir.nasim.C19349qC0;
import ir.nasim.C5826Kz5;
import ir.nasim.C6293Mz5;
import ir.nasim.PI3;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a {
    public static C6293Mz5 a(String str, C19349qC0 c19349qC0) {
        t tVarA = C5826Kz5.b().a();
        ArrayList arrayList = new ArrayList();
        if (tVarA.a(AeFpsRangeLegacyQuirk.class, AeFpsRangeLegacyQuirk.e(c19349qC0))) {
            arrayList.add(new AeFpsRangeLegacyQuirk(c19349qC0));
        }
        if (tVarA.a(AspectRatioLegacyApi21Quirk.class, AspectRatioLegacyApi21Quirk.d(c19349qC0))) {
            arrayList.add(new AspectRatioLegacyApi21Quirk());
        }
        if (tVarA.a(JpegHalCorruptImageQuirk.class, JpegHalCorruptImageQuirk.c(c19349qC0))) {
            arrayList.add(new JpegHalCorruptImageQuirk());
        }
        if (tVarA.a(JpegCaptureDownsizingQuirk.class, JpegCaptureDownsizingQuirk.c(c19349qC0))) {
            arrayList.add(new JpegCaptureDownsizingQuirk());
        }
        if (tVarA.a(CamcorderProfileResolutionQuirk.class, CamcorderProfileResolutionQuirk.c(c19349qC0))) {
            arrayList.add(new CamcorderProfileResolutionQuirk(c19349qC0));
        }
        if (tVarA.a(CaptureNoResponseQuirk.class, CaptureNoResponseQuirk.c(c19349qC0))) {
            arrayList.add(new CaptureNoResponseQuirk());
        }
        if (tVarA.a(LegacyCameraOutputConfigNullPointerQuirk.class, LegacyCameraOutputConfigNullPointerQuirk.c(c19349qC0))) {
            arrayList.add(new LegacyCameraOutputConfigNullPointerQuirk());
        }
        if (tVarA.a(LegacyCameraSurfaceCleanupQuirk.class, LegacyCameraSurfaceCleanupQuirk.d(c19349qC0))) {
            arrayList.add(new LegacyCameraSurfaceCleanupQuirk());
        }
        if (tVarA.a(ImageCaptureWashedOutImageQuirk.class, ImageCaptureWashedOutImageQuirk.c(c19349qC0))) {
            arrayList.add(new ImageCaptureWashedOutImageQuirk());
        }
        if (tVarA.a(CameraNoResponseWhenEnablingFlashQuirk.class, CameraNoResponseWhenEnablingFlashQuirk.c(c19349qC0))) {
            arrayList.add(new CameraNoResponseWhenEnablingFlashQuirk());
        }
        if (tVarA.a(YuvImageOnePixelShiftQuirk.class, YuvImageOnePixelShiftQuirk.i(c19349qC0))) {
            arrayList.add(new YuvImageOnePixelShiftQuirk());
        }
        if (tVarA.a(FlashTooSlowQuirk.class, FlashTooSlowQuirk.d(c19349qC0))) {
            arrayList.add(new FlashTooSlowQuirk());
        }
        if (tVarA.a(AfRegionFlipHorizontallyQuirk.class, AfRegionFlipHorizontallyQuirk.c(c19349qC0))) {
            arrayList.add(new AfRegionFlipHorizontallyQuirk());
        }
        if (tVarA.a(ConfigureSurfaceToSecondarySessionFailQuirk.class, ConfigureSurfaceToSecondarySessionFailQuirk.c(c19349qC0))) {
            arrayList.add(new ConfigureSurfaceToSecondarySessionFailQuirk());
        }
        if (tVarA.a(PreviewOrientationIncorrectQuirk.class, PreviewOrientationIncorrectQuirk.c(c19349qC0))) {
            arrayList.add(new PreviewOrientationIncorrectQuirk());
        }
        if (tVarA.a(CaptureSessionStuckQuirk.class, CaptureSessionStuckQuirk.c(c19349qC0))) {
            arrayList.add(new CaptureSessionStuckQuirk());
        }
        if (tVarA.a(ImageCaptureFlashNotFireQuirk.class, ImageCaptureFlashNotFireQuirk.c(c19349qC0))) {
            arrayList.add(new ImageCaptureFlashNotFireQuirk());
        }
        if (tVarA.a(ImageCaptureWithFlashUnderexposureQuirk.class, ImageCaptureWithFlashUnderexposureQuirk.c(c19349qC0))) {
            arrayList.add(new ImageCaptureWithFlashUnderexposureQuirk());
        }
        if (tVarA.a(ImageCaptureFailWithAutoFlashQuirk.class, ImageCaptureFailWithAutoFlashQuirk.c(c19349qC0))) {
            arrayList.add(new ImageCaptureFailWithAutoFlashQuirk());
        }
        if (tVarA.a(IncorrectCaptureStateQuirk.class, IncorrectCaptureStateQuirk.c(c19349qC0))) {
            arrayList.add(new IncorrectCaptureStateQuirk());
        }
        if (tVarA.a(TorchFlashRequiredFor3aUpdateQuirk.class, TorchFlashRequiredFor3aUpdateQuirk.f(c19349qC0))) {
            arrayList.add(new TorchFlashRequiredFor3aUpdateQuirk(c19349qC0));
        }
        if (tVarA.a(PreviewStretchWhenVideoCaptureIsBoundQuirk.class, PreviewStretchWhenVideoCaptureIsBoundQuirk.i())) {
            arrayList.add(new PreviewStretchWhenVideoCaptureIsBoundQuirk());
        }
        if (tVarA.a(PreviewDelayWhenVideoCaptureIsBoundQuirk.class, PreviewDelayWhenVideoCaptureIsBoundQuirk.c())) {
            arrayList.add(new PreviewDelayWhenVideoCaptureIsBoundQuirk());
        }
        if (tVarA.a(ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.class, ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.j())) {
            arrayList.add(new ImageCaptureFailedWhenVideoCaptureIsBoundQuirk());
        }
        if (tVarA.a(TemporalNoiseQuirk.class, TemporalNoiseQuirk.d(c19349qC0))) {
            arrayList.add(new TemporalNoiseQuirk());
        }
        if (tVarA.a(ImageCaptureFailedForVideoSnapshotQuirk.class, ImageCaptureFailedForVideoSnapshotQuirk.e())) {
            arrayList.add(new ImageCaptureFailedForVideoSnapshotQuirk());
        }
        C6293Mz5 c6293Mz5 = new C6293Mz5(arrayList);
        PI3.a("CameraQuirks", "camera2 CameraQuirks = " + C6293Mz5.d(c6293Mz5));
        return c6293Mz5;
    }
}
