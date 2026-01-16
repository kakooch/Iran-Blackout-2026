package ir.appp.rghapp;

/* loaded from: classes3.dex */
public class GLSceneState {
    private int backgroundDarkColor;
    private String backgroundFilePath;
    private int backgroundLightColor;
    private float brightness;
    private float contrast;
    private int filterId;
    private boolean isBackgroundGenerated;
    private boolean isImageMedia;
    private String mediaPath;
    private float mediaRotation;
    private float nextBrightness;
    private float nextContrast;
    private float nextSaturation;
    private float originalMediaRotation;
    private float saturation;
    private float scaleX;
    private float scaleY;
    public long videoPlaybackEndTime;
    public long videoPlaybackStartTime;
    private float xPosInNormalCoordination;
    private float yPosInNormalCoordination;

    public GLSceneState(int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, boolean z, String str, boolean z2, String str2, long j, long j2) {
        this.saturation = 1.0f;
        this.contrast = 1.0f;
        this.brightness = 0.0f;
        this.nextSaturation = 1.0f;
        this.nextContrast = 1.0f;
        this.nextBrightness = 0.0f;
        this.mediaRotation = 0.0f;
        this.originalMediaRotation = 0.0f;
        this.scaleX = 0.0f;
        this.scaleY = 0.0f;
        this.xPosInNormalCoordination = 0.0f;
        this.yPosInNormalCoordination = 0.0f;
        this.videoPlaybackStartTime = -1L;
        this.videoPlaybackEndTime = -1L;
        this.filterId = i;
        this.saturation = f;
        this.contrast = f2;
        this.brightness = f3;
        this.nextSaturation = f4;
        this.nextContrast = f5;
        this.nextBrightness = f6;
        this.mediaRotation = f7;
        this.originalMediaRotation = f8;
        this.scaleX = f9;
        this.scaleY = f10;
        this.xPosInNormalCoordination = f11;
        this.yPosInNormalCoordination = f12;
        this.isBackgroundGenerated = z;
        this.backgroundFilePath = str;
        this.isImageMedia = z2;
        this.mediaPath = str2;
        this.videoPlaybackStartTime = j;
        this.videoPlaybackEndTime = j2;
    }

    public GLSceneState(int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, boolean z, String str, boolean z2, String str2, long j, long j2, int i2, int i3) {
        this.saturation = 1.0f;
        this.contrast = 1.0f;
        this.brightness = 0.0f;
        this.nextSaturation = 1.0f;
        this.nextContrast = 1.0f;
        this.nextBrightness = 0.0f;
        this.mediaRotation = 0.0f;
        this.originalMediaRotation = 0.0f;
        this.scaleX = 0.0f;
        this.scaleY = 0.0f;
        this.xPosInNormalCoordination = 0.0f;
        this.yPosInNormalCoordination = 0.0f;
        this.videoPlaybackStartTime = -1L;
        this.videoPlaybackEndTime = -1L;
        this.filterId = i;
        this.saturation = f;
        this.contrast = f2;
        this.brightness = f3;
        this.nextSaturation = f4;
        this.nextContrast = f5;
        this.nextBrightness = f6;
        this.mediaRotation = f7;
        this.originalMediaRotation = f8;
        this.scaleX = f9;
        this.scaleY = f10;
        this.xPosInNormalCoordination = f11;
        this.yPosInNormalCoordination = f12;
        this.isBackgroundGenerated = z;
        this.backgroundFilePath = str;
        this.isImageMedia = z2;
        this.mediaPath = str2;
        this.videoPlaybackStartTime = j;
        this.videoPlaybackEndTime = j2;
        this.backgroundDarkColor = i2;
        this.backgroundLightColor = i3;
    }

    public int getFilterId() {
        return this.filterId;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public float getContrast() {
        return this.contrast;
    }

    public float getBrightness() {
        return this.brightness;
    }

    public float getNextSaturation() {
        return this.nextSaturation;
    }

    public float getNextContrast() {
        return this.nextContrast;
    }

    public float getNextBrightness() {
        return this.nextBrightness;
    }

    public float getMediaRotation() {
        return this.mediaRotation;
    }

    public float getOriginalMediaRotation() {
        return this.originalMediaRotation;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public float getxPosInNormalCoordination() {
        return this.xPosInNormalCoordination;
    }

    public float getyPosInNormalCoordination() {
        return this.yPosInNormalCoordination;
    }

    public boolean isBackgroundGenerated() {
        return this.isBackgroundGenerated;
    }

    public String getBackgroundFilePath() {
        return this.backgroundFilePath;
    }

    public String getMediaPath() {
        return this.mediaPath;
    }

    public long getVideoPlaybackStartTime() {
        return this.videoPlaybackStartTime;
    }

    public long getVideoPlaybackEndTime() {
        return this.videoPlaybackEndTime;
    }

    public boolean isImageMedia() {
        return this.isImageMedia;
    }

    public int getBackgroundDarkColor() {
        return this.backgroundDarkColor;
    }

    public int getBackgroundLightColor() {
        return this.backgroundLightColor;
    }

    public String toString() {
        return "GLSceneState{filterId=" + this.filterId + ", saturation=" + this.saturation + ", contrast=" + this.contrast + ", brightness=" + this.brightness + ", nextSaturation=" + this.nextSaturation + ", nextContrast=" + this.nextContrast + ", nextBrightness=" + this.nextBrightness + ", mediaRotation=" + this.mediaRotation + ", originalMediaRotation=" + this.originalMediaRotation + ", scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", xPosInNormalCoordination=" + this.xPosInNormalCoordination + ", yPosInNormalCoordination=" + this.yPosInNormalCoordination + ", isBackgroundGenerated=" + this.isBackgroundGenerated + ", backgroundFilePath='" + this.backgroundFilePath + "', isImageMedia=" + this.isImageMedia + ", mediaPath='" + this.mediaPath + "', videoPlaybackStartTime=" + this.videoPlaybackStartTime + ", videoPlaybackEndTime=" + this.videoPlaybackEndTime + '}';
    }
}
