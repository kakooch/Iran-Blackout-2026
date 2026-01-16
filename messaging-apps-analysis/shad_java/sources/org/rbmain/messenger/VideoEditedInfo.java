package org.rbmain.messenger;

import android.graphics.Bitmap;
import android.view.View;
import java.util.ArrayList;
import java.util.Locale;
import org.rbmain.messenger.MediaController;
import org.rbmain.tgnet.SerializedData;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$InputEncryptedFile;
import org.rbmain.tgnet.TLRPC$InputFile;
import org.rbmain.ui.Components.PhotoFilterView;
import org.rbmain.ui.Components.Point;

/* loaded from: classes4.dex */
public class VideoEditedInfo {
    public int bitrate;
    public boolean canNotCompress;
    public boolean canceled;
    public transient Bitmap coverPhotoBitmap;
    public long coverPhotoTime;
    public MediaController.CropState cropState;
    public transient int currentAccount;
    public TLRPC$InputEncryptedFile encryptedFile;
    public float end;
    public long endTime;
    public long estimatedDuration;
    public long estimatedSize;
    public TLRPC$InputFile file;
    public MediaController.SavedFilterState filterState;
    public boolean isPhoto;
    public byte[] iv;
    public byte[] key;
    public ArrayList<MediaEntity> mediaEntities;
    public boolean muted;
    public int originalBitrate;
    public long originalDuration;
    public int originalHeight;
    public String originalPath;
    public int originalWidth;
    public String paintPath;
    public float progress;
    public int resultHeight;
    public int resultWidth;
    public int rnd;
    public int rotationValue;
    public boolean roundVideo;
    public float start;
    public long startTime;
    public int swipeX;
    public boolean videoConvertFirstWrite;
    public int quality = 87;
    public long avatarStartTime = -1;
    public int framerate = 24;
    public boolean needUpdateProgress = false;

    public static class MediaEntity {
        public Bitmap bitmap;
        public int color;
        public float currentFrame;
        public TLRPC$Document document;
        public int fontSize;
        public float framesPerDraw;
        public float height;
        public int[] metadata;
        public Object parentObject;
        public long ptr;
        public float rotation;
        public float scale;
        public byte subType;
        public String text;
        public float textViewHeight;
        public float textViewWidth;
        public float textViewX;
        public float textViewY;
        public byte type;
        public View view;
        public int viewHeight;
        public int viewWidth;
        public float width;
        public float x;
        public float y;

        public MediaEntity() {
        }

        private MediaEntity(SerializedData serializedData) {
            this.type = serializedData.readByte(false);
            this.subType = serializedData.readByte(false);
            this.x = serializedData.readFloat(false);
            this.y = serializedData.readFloat(false);
            this.rotation = serializedData.readFloat(false);
            this.width = serializedData.readFloat(false);
            this.height = serializedData.readFloat(false);
            this.text = serializedData.readString(false);
            this.color = serializedData.readInt32(false);
            this.fontSize = serializedData.readInt32(false);
            this.viewWidth = serializedData.readInt32(false);
            this.viewHeight = serializedData.readInt32(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void serializeTo(SerializedData serializedData) {
            serializedData.writeByte(this.type);
            serializedData.writeByte(this.subType);
            serializedData.writeFloat(this.x);
            serializedData.writeFloat(this.y);
            serializedData.writeFloat(this.rotation);
            serializedData.writeFloat(this.width);
            serializedData.writeFloat(this.height);
            serializedData.writeString(this.text);
            serializedData.writeInt32(this.color);
            serializedData.writeInt32(this.fontSize);
            serializedData.writeInt32(this.viewWidth);
            serializedData.writeInt32(this.viewHeight);
        }

        public MediaEntity copy() {
            MediaEntity mediaEntity = new MediaEntity();
            mediaEntity.type = this.type;
            mediaEntity.subType = this.subType;
            mediaEntity.x = this.x;
            mediaEntity.y = this.y;
            mediaEntity.rotation = this.rotation;
            mediaEntity.width = this.width;
            mediaEntity.height = this.height;
            mediaEntity.text = this.text;
            mediaEntity.color = this.color;
            mediaEntity.fontSize = this.fontSize;
            mediaEntity.viewWidth = this.viewWidth;
            mediaEntity.viewHeight = this.viewHeight;
            mediaEntity.scale = this.scale;
            mediaEntity.textViewWidth = this.textViewWidth;
            mediaEntity.textViewHeight = this.textViewHeight;
            mediaEntity.textViewX = this.textViewX;
            mediaEntity.textViewY = this.textViewY;
            return mediaEntity;
        }
    }

    public String getString() {
        byte[] bytes;
        String strBytesToHex;
        PhotoFilterView.CurvesValue curvesValue;
        ArrayList<MediaEntity> arrayList;
        if (this.avatarStartTime == -1 && this.filterState == null && this.paintPath == null && (((arrayList = this.mediaEntities) == null || arrayList.isEmpty()) && this.cropState == null)) {
            strBytesToHex = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        } else {
            int length = this.filterState != null ? 170 : 10;
            String str = this.paintPath;
            if (str != null) {
                bytes = str.getBytes();
                length += bytes.length;
            } else {
                bytes = null;
            }
            SerializedData serializedData = new SerializedData(length);
            serializedData.writeInt32(5);
            serializedData.writeInt64(this.avatarStartTime);
            serializedData.writeInt32(this.originalBitrate);
            if (this.filterState != null) {
                serializedData.writeByte(1);
                serializedData.writeFloat(this.filterState.enhanceValue);
                serializedData.writeFloat(this.filterState.softenSkinValue);
                serializedData.writeFloat(this.filterState.exposureValue);
                serializedData.writeFloat(this.filterState.contrastValue);
                serializedData.writeFloat(this.filterState.warmthValue);
                serializedData.writeFloat(this.filterState.saturationValue);
                serializedData.writeFloat(this.filterState.fadeValue);
                serializedData.writeInt32(this.filterState.tintShadowsColor);
                serializedData.writeInt32(this.filterState.tintHighlightsColor);
                serializedData.writeFloat(this.filterState.highlightsValue);
                serializedData.writeFloat(this.filterState.shadowsValue);
                serializedData.writeFloat(this.filterState.vignetteValue);
                serializedData.writeFloat(this.filterState.grainValue);
                serializedData.writeInt32(this.filterState.blurType);
                serializedData.writeFloat(this.filterState.sharpenValue);
                serializedData.writeFloat(this.filterState.blurExcludeSize);
                Point point = this.filterState.blurExcludePoint;
                if (point != null) {
                    serializedData.writeFloat(point.x);
                    serializedData.writeFloat(this.filterState.blurExcludePoint.y);
                } else {
                    serializedData.writeFloat(0.0f);
                    serializedData.writeFloat(0.0f);
                }
                serializedData.writeFloat(this.filterState.blurExcludeBlurSize);
                serializedData.writeFloat(this.filterState.blurAngle);
                for (int i = 0; i < 4; i++) {
                    if (i == 0) {
                        curvesValue = this.filterState.curvesToolValue.luminanceCurve;
                    } else if (i == 1) {
                        curvesValue = this.filterState.curvesToolValue.redCurve;
                    } else if (i == 2) {
                        curvesValue = this.filterState.curvesToolValue.greenCurve;
                    } else {
                        curvesValue = this.filterState.curvesToolValue.blueCurve;
                    }
                    serializedData.writeFloat(curvesValue.blacksLevel);
                    serializedData.writeFloat(curvesValue.shadowsLevel);
                    serializedData.writeFloat(curvesValue.midtonesLevel);
                    serializedData.writeFloat(curvesValue.highlightsLevel);
                    serializedData.writeFloat(curvesValue.whitesLevel);
                }
            } else {
                serializedData.writeByte(0);
            }
            if (bytes != null) {
                serializedData.writeByte(1);
                serializedData.writeByteArray(bytes);
            } else {
                serializedData.writeByte(0);
            }
            ArrayList<MediaEntity> arrayList2 = this.mediaEntities;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                serializedData.writeByte(1);
                serializedData.writeInt32(this.mediaEntities.size());
                int size = this.mediaEntities.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.mediaEntities.get(i2).serializeTo(serializedData);
                }
                serializedData.writeByte(this.isPhoto ? 1 : 0);
            } else {
                serializedData.writeByte(0);
            }
            if (this.cropState != null) {
                serializedData.writeByte(1);
                serializedData.writeFloat(this.cropState.cropPx);
                serializedData.writeFloat(this.cropState.cropPy);
                serializedData.writeFloat(this.cropState.cropPw);
                serializedData.writeFloat(this.cropState.cropPh);
                serializedData.writeFloat(this.cropState.cropScale);
                serializedData.writeFloat(this.cropState.cropRotate);
                serializedData.writeInt32(this.cropState.transformWidth);
                serializedData.writeInt32(this.cropState.transformHeight);
                serializedData.writeInt32(this.cropState.transformRotation);
                serializedData.writeBool(this.cropState.mirrored);
            } else {
                serializedData.writeByte(0);
            }
            strBytesToHex = Utilities.bytesToHex(serializedData.toByteArray());
            serializedData.cleanup();
        }
        return String.format(Locale.US, "-1_%d_%d_%d_%d_%d_%d_%d_%d_%d_%d_-%s_%s", Long.valueOf(this.startTime), Long.valueOf(this.endTime), Integer.valueOf(this.rotationValue), Integer.valueOf(this.originalWidth), Integer.valueOf(this.originalHeight), Integer.valueOf(this.bitrate), Integer.valueOf(this.resultWidth), Integer.valueOf(this.resultHeight), Long.valueOf(this.originalDuration), Integer.valueOf(this.framerate), strBytesToHex, this.originalPath);
    }

    public boolean parseString(String str) {
        PhotoFilterView.CurvesValue curvesValue;
        if (str.length() < 6) {
            return false;
        }
        try {
            String[] strArrSplit = str.split("_");
            int i = 11;
            if (strArrSplit.length >= 11) {
                this.startTime = Long.parseLong(strArrSplit[1]);
                this.endTime = Long.parseLong(strArrSplit[2]);
                this.rotationValue = Integer.parseInt(strArrSplit[3]);
                this.originalWidth = Integer.parseInt(strArrSplit[4]);
                this.originalHeight = Integer.parseInt(strArrSplit[5]);
                this.bitrate = Integer.parseInt(strArrSplit[6]);
                this.resultWidth = Integer.parseInt(strArrSplit[7]);
                this.resultHeight = Integer.parseInt(strArrSplit[8]);
                this.originalDuration = Long.parseLong(strArrSplit[9]);
                this.framerate = Integer.parseInt(strArrSplit[10]);
                this.muted = this.bitrate == -1;
                if (strArrSplit[11].startsWith("-")) {
                    String strSubstring = strArrSplit[11].substring(1);
                    if (strSubstring.length() > 0) {
                        SerializedData serializedData = new SerializedData(Utilities.hexToBytes(strSubstring));
                        int int32 = serializedData.readInt32(false);
                        if (int32 >= 3) {
                            this.avatarStartTime = serializedData.readInt64(false);
                            this.originalBitrate = serializedData.readInt32(false);
                        }
                        if (serializedData.readByte(false) != 0) {
                            MediaController.SavedFilterState savedFilterState = new MediaController.SavedFilterState();
                            this.filterState = savedFilterState;
                            savedFilterState.enhanceValue = serializedData.readFloat(false);
                            if (int32 >= 5) {
                                this.filterState.softenSkinValue = serializedData.readFloat(false);
                            }
                            this.filterState.exposureValue = serializedData.readFloat(false);
                            this.filterState.contrastValue = serializedData.readFloat(false);
                            this.filterState.warmthValue = serializedData.readFloat(false);
                            this.filterState.saturationValue = serializedData.readFloat(false);
                            this.filterState.fadeValue = serializedData.readFloat(false);
                            this.filterState.tintShadowsColor = serializedData.readInt32(false);
                            this.filterState.tintHighlightsColor = serializedData.readInt32(false);
                            this.filterState.highlightsValue = serializedData.readFloat(false);
                            this.filterState.shadowsValue = serializedData.readFloat(false);
                            this.filterState.vignetteValue = serializedData.readFloat(false);
                            this.filterState.grainValue = serializedData.readFloat(false);
                            this.filterState.blurType = serializedData.readInt32(false);
                            this.filterState.sharpenValue = serializedData.readFloat(false);
                            this.filterState.blurExcludeSize = serializedData.readFloat(false);
                            this.filterState.blurExcludePoint = new Point(serializedData.readFloat(false), serializedData.readFloat(false));
                            this.filterState.blurExcludeBlurSize = serializedData.readFloat(false);
                            this.filterState.blurAngle = serializedData.readFloat(false);
                            for (int i2 = 0; i2 < 4; i2++) {
                                if (i2 == 0) {
                                    curvesValue = this.filterState.curvesToolValue.luminanceCurve;
                                } else if (i2 == 1) {
                                    curvesValue = this.filterState.curvesToolValue.redCurve;
                                } else if (i2 == 2) {
                                    curvesValue = this.filterState.curvesToolValue.greenCurve;
                                } else {
                                    curvesValue = this.filterState.curvesToolValue.blueCurve;
                                }
                                curvesValue.blacksLevel = serializedData.readFloat(false);
                                curvesValue.shadowsLevel = serializedData.readFloat(false);
                                curvesValue.midtonesLevel = serializedData.readFloat(false);
                                curvesValue.highlightsLevel = serializedData.readFloat(false);
                                curvesValue.whitesLevel = serializedData.readFloat(false);
                            }
                        }
                        if (serializedData.readByte(false) != 0) {
                            this.paintPath = new String(serializedData.readByteArray(false));
                        }
                        if (serializedData.readByte(false) != 0) {
                            int int322 = serializedData.readInt32(false);
                            this.mediaEntities = new ArrayList<>(int322);
                            for (int i3 = 0; i3 < int322; i3++) {
                                this.mediaEntities.add(new MediaEntity(serializedData));
                            }
                            this.isPhoto = serializedData.readByte(false) == 1;
                        }
                        if (int32 >= 2 && serializedData.readByte(false) != 0) {
                            MediaController.CropState cropState = new MediaController.CropState();
                            this.cropState = cropState;
                            cropState.cropPx = serializedData.readFloat(false);
                            this.cropState.cropPy = serializedData.readFloat(false);
                            this.cropState.cropPw = serializedData.readFloat(false);
                            this.cropState.cropPh = serializedData.readFloat(false);
                            this.cropState.cropScale = serializedData.readFloat(false);
                            this.cropState.cropRotate = serializedData.readFloat(false);
                            this.cropState.transformWidth = serializedData.readInt32(false);
                            this.cropState.transformHeight = serializedData.readInt32(false);
                            this.cropState.transformRotation = serializedData.readInt32(false);
                            if (int32 >= 4) {
                                this.cropState.mirrored = serializedData.readBool(false);
                            }
                        }
                        serializedData.cleanup();
                    }
                    i = 12;
                }
                while (i < strArrSplit.length) {
                    if (this.originalPath == null) {
                        this.originalPath = strArrSplit[i];
                    } else {
                        this.originalPath += "_" + strArrSplit[i];
                    }
                    i++;
                }
            }
            return true;
        } catch (Exception e) {
            FileLog.e(e);
            return false;
        }
    }

    public boolean needConvert() {
        boolean z;
        if (this.mediaEntities == null && this.paintPath == null && this.filterState == null && this.cropState == null && (z = this.roundVideo)) {
            if (z) {
                if (this.startTime <= 0) {
                    long j = this.endTime;
                    if (j == -1 || j == this.estimatedDuration) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public boolean canAutoPlaySourceVideo() {
        return this.roundVideo;
    }
}
