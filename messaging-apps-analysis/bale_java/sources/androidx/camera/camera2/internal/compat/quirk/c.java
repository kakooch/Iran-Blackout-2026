package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.core.impl.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c {
    static List a(t tVar) {
        ArrayList arrayList = new ArrayList();
        if (tVar.a(ImageCapturePixelHDRPlusQuirk.class, ImageCapturePixelHDRPlusQuirk.c())) {
            arrayList.add(new ImageCapturePixelHDRPlusQuirk());
        }
        if (tVar.a(ExtraCroppingQuirk.class, ExtraCroppingQuirk.e())) {
            arrayList.add(new ExtraCroppingQuirk());
        }
        if (tVar.a(Nexus4AndroidLTargetAspectRatioQuirk.class, Nexus4AndroidLTargetAspectRatioQuirk.d())) {
            arrayList.add(new Nexus4AndroidLTargetAspectRatioQuirk());
        }
        if (tVar.a(ExcludedSupportedSizesQuirk.class, ExcludedSupportedSizesQuirk.p())) {
            arrayList.add(new ExcludedSupportedSizesQuirk());
        }
        if (tVar.a(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class, CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.c())) {
            arrayList.add(new CrashWhenTakingPhotoWithAutoFlashAEModeQuirk());
        }
        if (tVar.a(PreviewPixelHDRnetQuirk.class, PreviewPixelHDRnetQuirk.c())) {
            arrayList.add(new PreviewPixelHDRnetQuirk());
        }
        if (tVar.a(StillCaptureFlashStopRepeatingQuirk.class, StillCaptureFlashStopRepeatingQuirk.c())) {
            arrayList.add(new StillCaptureFlashStopRepeatingQuirk());
        }
        if (tVar.a(ExtraSupportedSurfaceCombinationsQuirk.class, ExtraSupportedSurfaceCombinationsQuirk.h())) {
            arrayList.add(new ExtraSupportedSurfaceCombinationsQuirk());
        }
        if (tVar.a(FlashAvailabilityBufferUnderflowQuirk.class, FlashAvailabilityBufferUnderflowQuirk.d())) {
            arrayList.add(new FlashAvailabilityBufferUnderflowQuirk());
        }
        if (tVar.a(RepeatingStreamConstraintForVideoRecordingQuirk.class, RepeatingStreamConstraintForVideoRecordingQuirk.d())) {
            arrayList.add(new RepeatingStreamConstraintForVideoRecordingQuirk());
        }
        if (tVar.a(TextureViewIsClosedQuirk.class, TextureViewIsClosedQuirk.c())) {
            arrayList.add(new TextureViewIsClosedQuirk());
        }
        if (tVar.a(CaptureSessionOnClosedNotCalledQuirk.class, CaptureSessionOnClosedNotCalledQuirk.c())) {
            arrayList.add(new CaptureSessionOnClosedNotCalledQuirk());
        }
        if (tVar.a(TorchIsClosedAfterImageCapturingQuirk.class, TorchIsClosedAfterImageCapturingQuirk.c())) {
            arrayList.add(new TorchIsClosedAfterImageCapturingQuirk());
        }
        if (tVar.a(ZslDisablerQuirk.class, ZslDisablerQuirk.f())) {
            arrayList.add(new ZslDisablerQuirk());
        }
        if (tVar.a(ExtraSupportedOutputSizeQuirk.class, ExtraSupportedOutputSizeQuirk.f())) {
            arrayList.add(new ExtraSupportedOutputSizeQuirk());
        }
        if (tVar.a(InvalidVideoProfilesQuirk.class, InvalidVideoProfilesQuirk.p())) {
            arrayList.add(new InvalidVideoProfilesQuirk());
        }
        if (tVar.a(Preview3AThreadCrashQuirk.class, Preview3AThreadCrashQuirk.c())) {
            arrayList.add(new Preview3AThreadCrashQuirk());
        }
        if (tVar.a(SmallDisplaySizeQuirk.class, SmallDisplaySizeQuirk.d())) {
            arrayList.add(new SmallDisplaySizeQuirk());
        }
        if (tVar.a(CaptureSessionShouldUseMrirQuirk.class, CaptureSessionShouldUseMrirQuirk.c())) {
            arrayList.add(new CaptureSessionShouldUseMrirQuirk());
        }
        return arrayList;
    }
}
