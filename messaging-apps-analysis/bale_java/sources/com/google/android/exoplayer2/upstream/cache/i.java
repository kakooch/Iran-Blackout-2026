package com.google.android.exoplayer2.upstream.cache;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC18533op0;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class i extends AbstractC18533op0 {
    private static final Pattern g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    private static final Pattern h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    private static final Pattern i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    private i(String str, long j, long j2, long j3, File file) {
        super(str, j, j2, j3, file);
    }

    public static i o(File file, long j, long j2, f fVar) {
        File file2;
        String strK;
        String name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            File fileT = t(file, fVar);
            if (fileT == null) {
                return null;
            }
            file2 = fileT;
            name = fileT.getName();
        }
        Matcher matcher = i.matcher(name);
        if (!matcher.matches() || (strK = fVar.k(Integer.parseInt((String) AbstractC20011rK.e(matcher.group(1))))) == null) {
            return null;
        }
        long length = j == -1 ? file2.length() : j;
        if (length == 0) {
            return null;
        }
        return new i(strK, Long.parseLong((String) AbstractC20011rK.e(matcher.group(2))), length, j2 == -9223372036854775807L ? Long.parseLong((String) AbstractC20011rK.e(matcher.group(3))) : j2, file2);
    }

    public static i p(File file, long j, f fVar) {
        return o(file, j, -9223372036854775807L, fVar);
    }

    public static i q(String str, long j, long j2) {
        return new i(str, j, j2, -9223372036854775807L, null);
    }

    public static i r(String str, long j) {
        return new i(str, j, -1L, -9223372036854775807L, null);
    }

    public static File s(File file, int i2, long j, long j2) {
        return new File(file, i2 + Separators.DOT + j + Separators.DOT + j2 + ".v3.exo");
    }

    private static File t(File file, f fVar) {
        String strB1;
        String name = file.getName();
        Matcher matcher = h.matcher(name);
        if (matcher.matches()) {
            strB1 = AbstractC9683aN7.b1((String) AbstractC20011rK.e(matcher.group(1)));
        } else {
            matcher = g.matcher(name);
            strB1 = matcher.matches() ? (String) AbstractC20011rK.e(matcher.group(1)) : null;
        }
        if (strB1 == null) {
            return null;
        }
        File fileS = s((File) AbstractC20011rK.i(file.getParentFile()), fVar.f(strB1), Long.parseLong((String) AbstractC20011rK.e(matcher.group(2))), Long.parseLong((String) AbstractC20011rK.e(matcher.group(3))));
        if (file.renameTo(fileS)) {
            return fileS;
        }
        return null;
    }

    public i j(File file, long j) {
        AbstractC20011rK.g(this.d);
        return new i(this.a, this.b, this.c, j, file);
    }
}
