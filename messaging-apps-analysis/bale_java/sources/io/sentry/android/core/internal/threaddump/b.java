package io.sentry.android.core.internal.threaddump;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class b {
    private final ArrayList a;
    private final int b = 0;
    private final int c;
    public int d;

    public b(ArrayList arrayList) {
        this.a = arrayList;
        this.c = arrayList.size();
    }

    public static b c(BufferedReader bufferedReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new b(arrayList);
            }
            i++;
            arrayList.add(new a(i, line));
        }
    }

    public boolean a() {
        return this.d < this.c;
    }

    public a b() {
        int i = this.d;
        if (i < this.b || i >= this.c) {
            return null;
        }
        ArrayList arrayList = this.a;
        this.d = i + 1;
        return (a) arrayList.get(i);
    }

    public void d() {
        this.d--;
    }
}
