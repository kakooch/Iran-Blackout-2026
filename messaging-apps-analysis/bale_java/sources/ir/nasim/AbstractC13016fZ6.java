package ir.nasim;

import java.util.regex.Pattern;

/* renamed from: ir.nasim.fZ6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC13016fZ6 {
    private static final Pattern a = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean a(String str) {
        return str == null || str.trim().isEmpty();
    }
}
