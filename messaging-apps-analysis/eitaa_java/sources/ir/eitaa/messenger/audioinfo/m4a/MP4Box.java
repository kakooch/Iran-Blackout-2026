package ir.eitaa.messenger.audioinfo.m4a;

import ir.eitaa.messenger.audioinfo.util.PositionInputStream;
import ir.eitaa.messenger.audioinfo.util.RangeInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class MP4Box<I extends PositionInputStream> {
    private MP4Atom child;
    protected final DataInput data;
    private final I input;
    private final MP4Box<?> parent;
    private final String type;

    public MP4Box(I input, MP4Box<?> parent, String type) {
        this.input = input;
        this.parent = parent;
        this.type = type;
        this.data = new DataInputStream(input);
    }

    public String getType() {
        return this.type;
    }

    public MP4Box<?> getParent() {
        return this.parent;
    }

    public long getPosition() {
        return this.input.getPosition();
    }

    public I getInput() {
        return this.input;
    }

    protected MP4Atom getChild() {
        return this.child;
    }

    public MP4Atom nextChild() throws IOException {
        RangeInputStream rangeInputStream;
        MP4Atom mP4Atom = this.child;
        if (mP4Atom != null) {
            mP4Atom.skip();
        }
        int i = this.data.readInt();
        byte[] bArr = new byte[4];
        this.data.readFully(bArr);
        String str = new String(bArr, "ISO8859_1");
        if (i == 1) {
            rangeInputStream = new RangeInputStream(this.input, 16L, this.data.readLong() - 16);
        } else {
            rangeInputStream = new RangeInputStream(this.input, 8L, i - 8);
        }
        MP4Atom mP4Atom2 = new MP4Atom(rangeInputStream, this, str);
        this.child = mP4Atom2;
        return mP4Atom2;
    }

    public MP4Atom nextChild(String expectedTypeExpression) throws IOException {
        MP4Atom mP4AtomNextChild = nextChild();
        if (mP4AtomNextChild.getType().matches(expectedTypeExpression)) {
            return mP4AtomNextChild;
        }
        throw new IOException("atom type mismatch, expected " + expectedTypeExpression + ", got " + mP4AtomNextChild.getType());
    }
}
