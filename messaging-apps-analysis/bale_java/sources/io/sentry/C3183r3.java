package io.sentry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: io.sentry.r3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3183r3 {
    private final C3155n3 a;

    public C3183r3(C3155n3 c3155n3) {
        this.a = c3155n3;
    }

    public List a(StackTraceElement[] stackTraceElementArr, boolean z) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                if (z || !className.startsWith("io.sentry.") || className.startsWith("io.sentry.samples.") || className.startsWith("io.sentry.mobile.")) {
                    io.sentry.protocol.z zVar = new io.sentry.protocol.z();
                    zVar.y(b(className));
                    zVar.C(className);
                    zVar.x(stackTraceElement.getMethodName());
                    zVar.w(stackTraceElement.getFileName());
                    if (stackTraceElement.getLineNumber() >= 0) {
                        zVar.A(Integer.valueOf(stackTraceElement.getLineNumber()));
                    }
                    zVar.D(Boolean.valueOf(stackTraceElement.isNativeMethod()));
                    arrayList.add(zVar);
                    if (arrayList.size() >= 100) {
                        break;
                    }
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public Boolean b(String str) {
        if (str == null || str.isEmpty()) {
            return Boolean.TRUE;
        }
        Iterator<String> it = this.a.getInAppIncludes().iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return Boolean.TRUE;
            }
        }
        Iterator<String> it2 = this.a.getInAppExcludes().iterator();
        while (it2.hasNext()) {
            if (str.startsWith(it2.next())) {
                return Boolean.FALSE;
            }
        }
        return null;
    }
}
