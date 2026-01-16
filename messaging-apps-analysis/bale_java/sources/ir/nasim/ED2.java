package ir.nasim;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class ED2 {
    private static final Pattern c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int a = -1;
    public int b = -1;

    private boolean b(String str) throws NumberFormatException {
        Matcher matcher = c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int i = Integer.parseInt((String) AbstractC9683aN7.j(matcher.group(1)), 16);
            int i2 = Integer.parseInt((String) AbstractC9683aN7.j(matcher.group(2)), 16);
            if (i <= 0 && i2 <= 0) {
                return false;
            }
            this.a = i;
            this.b = i2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean a() {
        return (this.a == -1 || this.b == -1) ? false : true;
    }

    public boolean c(Metadata metadata) {
        for (int i = 0; i < metadata.e(); i++) {
            Metadata.Entry entryD = metadata.d(i);
            if (entryD instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entryD;
                if ("iTunSMPB".equals(commentFrame.c) && b(commentFrame.d)) {
                    return true;
                }
            } else if (entryD instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) entryD;
                if ("com.apple.iTunes".equals(internalFrame.b) && "iTunSMPB".equals(internalFrame.c) && b(internalFrame.d)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean d(int i) {
        int i2 = i >> 12;
        int i3 = i & 4095;
        if (i2 <= 0 && i3 <= 0) {
            return false;
        }
        this.a = i2;
        this.b = i3;
        return true;
    }
}
