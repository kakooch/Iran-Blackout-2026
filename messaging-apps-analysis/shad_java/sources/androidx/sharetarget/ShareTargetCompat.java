package androidx.sharetarget;

/* loaded from: classes.dex */
class ShareTargetCompat {
    final String[] mCategories;
    final String mTargetClass;
    final TargetData[] mTargetData;

    static class TargetData {
        final String mMimeType;

        TargetData(String scheme, String host, String port, String path, String pathPattern, String pathPrefix, String mimeType) {
            this.mMimeType = mimeType;
        }
    }

    ShareTargetCompat(TargetData[] data, String targetClass, String[] categories) {
        this.mTargetData = data;
        this.mTargetClass = targetClass;
        this.mCategories = categories;
    }
}
