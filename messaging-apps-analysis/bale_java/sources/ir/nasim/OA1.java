package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.nio.CharBuffer;

/* loaded from: classes2.dex */
public abstract class OA1 {
    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String fileName = stackTraceElement.getFileName();
        int lineNumber = stackTraceElement.getLineNumber();
        String methodName = stackTraceElement.getMethodName();
        StringBuilder sb = new StringBuilder(String.valueOf(fileName).length() + 18 + String.valueOf(methodName).length());
        sb.append(".(");
        sb.append(fileName);
        sb.append(":");
        sb.append(lineNumber);
        sb.append(") ");
        sb.append(methodName);
        sb.append("()");
        return sb.toString();
    }

    public static String b() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String fileName = stackTraceElement.getFileName();
        int lineNumber = stackTraceElement.getLineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(fileName).length() + 15);
        sb.append(".(");
        sb.append(fileName);
        sb.append(":");
        sb.append(lineNumber);
        sb.append(Separators.RPAREN);
        return sb.toString();
    }

    public static String c(Context context, int i) {
        if (i == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder(12);
            sb.append(Separators.QUESTION);
            sb.append(i);
            return sb.toString();
        }
    }

    public static String d(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String e(MotionLayout motionLayout, int i) {
        return f(motionLayout, i, -1);
    }

    public static String f(MotionLayout motionLayout, int i, int i2) throws Resources.NotFoundException {
        int length;
        if (i == -1) {
            return "UNDEFINED";
        }
        String resourceEntryName = motionLayout.getContext().getResources().getResourceEntryName(i);
        if (i2 == -1) {
            return resourceEntryName;
        }
        if (resourceEntryName.length() > i2) {
            resourceEntryName = resourceEntryName.replaceAll("([^_])[aeiou]+", "$1");
        }
        return (resourceEntryName.length() <= i2 || (length = resourceEntryName.replaceAll("[^_]", "").length()) <= 0) ? resourceEntryName : resourceEntryName.replaceAll(String.valueOf(CharBuffer.allocate((resourceEntryName.length() - i2) / length).toString().replace((char) 0, '.')).concat("_"), "_");
    }
}
