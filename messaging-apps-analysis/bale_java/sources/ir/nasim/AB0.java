package ir.nasim;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AB0 implements InterfaceC10135b82 {
    private final boolean a;
    private final String b;
    private final int c;
    private final Map d = new HashMap();
    private final C6293Mz5 e;

    public AB0(String str, C6293Mz5 c6293Mz5) throws NumberFormatException {
        boolean z;
        int i;
        this.b = str;
        try {
            i = Integer.parseInt(str);
            z = true;
        } catch (NumberFormatException unused) {
            PI3.l("Camera2EncoderProfilesProvider", "Camera id is not an integer: " + str + ", unable to create Camera2EncoderProfilesProvider");
            z = false;
            i = -1;
        }
        this.a = z;
        this.c = i;
        this.e = c6293Mz5;
    }
}
