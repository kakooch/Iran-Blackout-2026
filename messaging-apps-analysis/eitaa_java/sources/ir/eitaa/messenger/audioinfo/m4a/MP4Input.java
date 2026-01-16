package ir.eitaa.messenger.audioinfo.m4a;

import ir.eitaa.messenger.audioinfo.util.PositionInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class MP4Input extends MP4Box<PositionInputStream> {
    public MP4Input(InputStream delegate) {
        super(new PositionInputStream(delegate), null, "");
    }

    public MP4Atom nextChildUpTo(String expectedTypeExpression) throws IOException {
        MP4Atom mP4AtomNextChild;
        do {
            mP4AtomNextChild = nextChild();
        } while (!mP4AtomNextChild.getType().matches(expectedTypeExpression));
        return mP4AtomNextChild;
    }

    public String toString() {
        return "mp4[pos=" + getPosition() + "]";
    }
}
