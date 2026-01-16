package ir.nasim.core.modules.banking;

import java.util.List;

/* loaded from: classes5.dex */
public class i extends j {
    private final List c;
    private final boolean d;

    i(String str, String str2, List list) {
        super(str2);
        if (str != null) {
            this.d = Long.parseLong(str) == 0;
        } else {
            this.d = false;
        }
        this.c = list;
    }

    @Override // ir.nasim.core.modules.banking.j
    public boolean b() {
        return this.d;
    }

    public List c() {
        return this.c;
    }
}
