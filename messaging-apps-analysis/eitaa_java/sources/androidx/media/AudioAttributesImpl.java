package androidx.media;

import androidx.versionedparcelable.VersionedParcelable;

/* loaded from: classes.dex */
public interface AudioAttributesImpl extends VersionedParcelable {

    public interface Builder {
        AudioAttributesImpl build();

        Builder setContentType(int i);

        Builder setLegacyStreamType(int i);

        Builder setUsage(int i);
    }

    Object getAudioAttributes();

    int getLegacyStreamType();
}
