package ir.nasim;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* renamed from: ir.nasim.vM5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC22511vM5 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final OU3 e(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new SU3(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OU3 f(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new SU3(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C24411ya3 g(MatchResult matchResult) {
        return AbstractC23053wG5.y(matchResult.start(), matchResult.end());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C24411ya3 h(MatchResult matchResult, int i) {
        return AbstractC23053wG5.y(matchResult.start(i), matchResult.end(i));
    }
}
