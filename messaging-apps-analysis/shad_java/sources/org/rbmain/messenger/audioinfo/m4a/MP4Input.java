package org.rbmain.messenger.audioinfo.m4a;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.IOException;
import java.io.InputStream;
import org.rbmain.messenger.audioinfo.util.PositionInputStream;

/* loaded from: classes4.dex */
public final class MP4Input extends MP4Box<PositionInputStream> {
    public MP4Input(InputStream inputStream) {
        super(new PositionInputStream(inputStream), null, BuildConfig.FLAVOR);
    }

    public MP4Atom nextChildUpTo(String str) throws IOException {
        MP4Atom mP4AtomNextChild;
        do {
            mP4AtomNextChild = nextChild();
        } while (!mP4AtomNextChild.getType().matches(str));
        return mP4AtomNextChild;
    }

    public String toString() {
        return "mp4[pos=" + getPosition() + "]";
    }
}
