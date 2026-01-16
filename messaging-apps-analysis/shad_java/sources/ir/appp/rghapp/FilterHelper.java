package ir.appp.rghapp;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import ir.appp.rghapp.rubinoPostSlider.StoryVideoConvertor;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.StoryObject;
import java.io.File;
import java.io.IOException;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.VideoEditedInfo;

/* loaded from: classes3.dex */
public class FilterHelper {
    private FilterProcessListener listener;
    private int lastOnCancelCalledRnd = -1;
    private int lastProgress = -1;
    private boolean cancelSavingProcess = false;

    public interface FilterProcessListener {
        void onFilterOperationCanceled(int i);

        void onFilterOperationCompleted(int i, String str);

        void onFilterOperationEstimatedOutputSize(int i);

        void onFilterOperationFailed(int i, String str, String str2);

        void onFilterProgressChanged(int i, double d, int i2);
    }

    private native void applyFilter(int i, RGHFilter rGHFilter, String str, String str2, String str3);

    private native void cancelOngoingFilterProcess();

    public FilterHelper(FilterProcessListener filterProcessListener) {
        this.listener = filterProcessListener;
    }

    public void applyFilterOnMedia(final StoryObject storyObject) {
        boolean z;
        FilterProcessListener filterProcessListener;
        int i;
        long j;
        long j2;
        long j3;
        FilterProcessListener filterProcessListener2;
        this.cancelSavingProcess = false;
        StoryObject.StoryTypeEnum storyTypeEnum = storyObject.story_type;
        if (storyTypeEnum == StoryObject.StoryTypeEnum.Video) {
            VideoEditedInfo videoEditedInfo = storyObject.videoEditedInfo;
            String str = videoEditedInfo.originalPath;
            long j4 = videoEditedInfo.startTime;
            if (j4 == 0) {
                j4 = -1;
            }
            long j5 = videoEditedInfo.endTime;
            if (j5 == 0) {
                j5 = -1;
            }
            int i2 = videoEditedInfo.resultWidth;
            int i3 = videoEditedInfo.resultHeight;
            int i4 = videoEditedInfo.bitrate;
            int i5 = videoEditedInfo.framerate;
            File file = new File(storyObject.localFilePathAfterSave);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                    if (this.listener != null) {
                        i = i3;
                        this.listener.onFilterOperationFailed(storyObject.rnd, "Write Error", "Failed to create local file to save media");
                    }
                }
                i = i3;
            } else {
                i = i3;
                file.delete();
            }
            long j6 = j4 * 1000;
            long j7 = j5 * 1000;
            if (j6 > 0 && j7 > 0) {
                j = j7 - j6;
            } else if (j7 > 0) {
                long jMin = Math.min(videoEditedInfo.originalDuration, j7);
                if (videoEditedInfo.originalDuration < j7) {
                    j3 = jMin;
                    j2 = -1;
                } else {
                    j2 = j7;
                    j3 = jMin;
                }
                MediaController.VideoConvertorListener videoConvertorListener = new MediaController.VideoConvertorListener() { // from class: ir.appp.rghapp.FilterHelper.1
                    @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
                    public void finishMakeVideo() {
                    }

                    @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
                    public boolean checkConversionCanceled() {
                        if (!FilterHelper.this.cancelSavingProcess) {
                            return false;
                        }
                        if (FilterHelper.this.listener == null) {
                            return true;
                        }
                        int i6 = FilterHelper.this.lastOnCancelCalledRnd;
                        int i7 = storyObject.rnd;
                        if (i6 == i7) {
                            return true;
                        }
                        FilterHelper.this.lastOnCancelCalledRnd = i7;
                        FilterHelper.this.listener.onFilterOperationCanceled(storyObject.rnd);
                        return true;
                    }

                    @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
                    public void didWriteData(long j8, float f) {
                        if (FilterHelper.this.listener == null || FilterHelper.this.cancelSavingProcess) {
                            return;
                        }
                        FilterHelper.this.listener.onFilterProgressChanged(storyObject.rnd, f, (int) j8);
                    }
                };
                MyLog.e("RGHBug", "startTime = " + j6 + " - endTime = " + j2 + " - duration = " + j3);
                new StoryVideoConvertor().convertVideo(str, file, i2, i, i5, i4, i4, j6, j2, true, j3, storyObject.glSceneState, false, storyObject.overlay, videoConvertorListener);
                filterProcessListener2 = this.listener;
                if (filterProcessListener2 != null && !this.cancelSavingProcess) {
                    filterProcessListener2.onFilterProgressChanged(storyObject.rnd, 100.0d, 0);
                }
            } else if (j6 > 0) {
                j = videoEditedInfo.originalDuration - j6;
            } else {
                j = videoEditedInfo.originalDuration;
            }
            long j8 = j;
            j2 = j7;
            j3 = j8;
            MediaController.VideoConvertorListener videoConvertorListener2 = new MediaController.VideoConvertorListener() { // from class: ir.appp.rghapp.FilterHelper.1
                @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
                public void finishMakeVideo() {
                }

                @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
                public boolean checkConversionCanceled() {
                    if (!FilterHelper.this.cancelSavingProcess) {
                        return false;
                    }
                    if (FilterHelper.this.listener == null) {
                        return true;
                    }
                    int i6 = FilterHelper.this.lastOnCancelCalledRnd;
                    int i7 = storyObject.rnd;
                    if (i6 == i7) {
                        return true;
                    }
                    FilterHelper.this.lastOnCancelCalledRnd = i7;
                    FilterHelper.this.listener.onFilterOperationCanceled(storyObject.rnd);
                    return true;
                }

                @Override // org.rbmain.messenger.MediaController.VideoConvertorListener
                public void didWriteData(long j82, float f) {
                    if (FilterHelper.this.listener == null || FilterHelper.this.cancelSavingProcess) {
                        return;
                    }
                    FilterHelper.this.listener.onFilterProgressChanged(storyObject.rnd, f, (int) j82);
                }
            };
            MyLog.e("RGHBug", "startTime = " + j6 + " - endTime = " + j2 + " - duration = " + j3);
            new StoryVideoConvertor().convertVideo(str, file, i2, i, i5, i4, i4, j6, j2, true, j3, storyObject.glSceneState, false, storyObject.overlay, videoConvertorListener2);
            filterProcessListener2 = this.listener;
            if (filterProcessListener2 != null) {
                filterProcessListener2.onFilterProgressChanged(storyObject.rnd, 100.0d, 0);
            }
        } else {
            if (storyTypeEnum != StoryObject.StoryTypeEnum.Picture) {
                z = false;
                if (z || (filterProcessListener = this.listener) == null || this.cancelSavingProcess) {
                    return;
                }
                filterProcessListener.onFilterOperationCompleted(storyObject.rnd, storyObject.localFilePathAfterSave);
                return;
            }
            Bitmap bitmap = storyObject.overlay;
            if (bitmap != null) {
                if (bitmap.getWidth() != storyObject.filteredBitmap.getWidth()) {
                    int width = storyObject.filteredBitmap.getWidth();
                    Bitmap bitmap2 = storyObject.overlay;
                    Bitmap resizedBitmap = Utils.getResizedBitmap(bitmap2, width, (int) (width * (storyObject.overlay.getHeight() / storyObject.overlay.getWidth())));
                    storyObject.overlay = resizedBitmap;
                    storyObject.lastOverlay = bitmap2;
                    Utils.putOverlayOnBitmap(storyObject.filteredBitmap, resizedBitmap);
                } else {
                    Utils.putOverlayOnBitmap(storyObject.filteredBitmap, storyObject.overlay);
                }
            }
            Utils.saveBitmapToPath(storyObject.filteredBitmap, storyObject.localFilePathAfterSave);
        }
        z = true;
        if (z) {
        }
    }

    public void applyFilterOnMedia(int i, RGHFilter rGHFilter, String str, String str2, String str3) {
        applyFilter(i, rGHFilter, str, str2, str3);
    }

    public void cancelFilteringProcess() {
        if (Utils.useNewStoryCreationSystem()) {
            this.cancelSavingProcess = true;
        } else {
            cancelOngoingFilterProcess();
        }
    }

    @Keep
    private void filterProgressChanged(int i, double d, int i2) {
        int i3 = (int) (100.0d * d);
        if (this.listener == null || this.lastProgress >= i3) {
            return;
        }
        this.lastProgress = i3;
        MyLog.e("JNI_HELPER", "progress for Operation " + i + " is = " + this.lastProgress);
        this.listener.onFilterProgressChanged(i, d, i2);
    }

    @Keep
    private void filterOperationCanceled(int i) {
        this.lastProgress = -1;
        FilterProcessListener filterProcessListener = this.listener;
        if (filterProcessListener != null) {
            filterProcessListener.onFilterOperationCanceled(i);
        }
        MyLog.e("JNI_HELPER", "Operation " + i + " canceled");
    }

    @Keep
    private void filterOperationCompleted(int i, String str) {
        this.lastProgress = -1;
        FilterProcessListener filterProcessListener = this.listener;
        if (filterProcessListener != null) {
            filterProcessListener.onFilterOperationCompleted(i, str);
        }
        MyLog.e("JNI_HELPER", "Operation " + i + " completed ");
    }

    @Keep
    private void filterOperationFailed(int i, String str, String str2) {
        this.lastProgress = -1;
        FilterProcessListener filterProcessListener = this.listener;
        if (filterProcessListener != null) {
            filterProcessListener.onFilterOperationFailed(i, str, str2);
        }
        MyLog.e("JNI_HELPER", "Operation " + i + " failed ");
    }

    @Keep
    private void filterOperationEstimatedOutputSize(int i) {
        FilterProcessListener filterProcessListener = this.listener;
        if (filterProcessListener != null) {
            filterProcessListener.onFilterOperationEstimatedOutputSize(i);
        }
    }
}
