package ir.nasim.jaryan.feed.ui.components;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.exoplayer2.ui.B;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.LE5;
import ir.nasim.SA2;
import ir.nasim.VA5;
import ir.nasim.jaryan.feed.ui.components.DefaultTimeBar;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 è\u00012\u00020\u00012\u00020\u0002:\u0001EB=\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010&\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u001cH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b,\u0010+J\u000f\u0010-\u001a\u00020\u000fH\u0002¢\u0006\u0004\b-\u0010\u001bJ\u001f\u00100\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0003¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\u00132\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u000f2\b\b\u0001\u00106\u001a\u00020\u0007¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\u000f2\b\b\u0001\u00109\u001a\u00020\u0007¢\u0006\u0004\b:\u00108J\u0017\u0010<\u001a\u00020\u000f2\b\b\u0001\u0010;\u001a\u00020\u0007¢\u0006\u0004\b<\u00108J\u0017\u0010>\u001a\u00020\u000f2\b\b\u0001\u0010=\u001a\u00020\u0007¢\u0006\u0004\b>\u00108J\u0017\u0010@\u001a\u00020\u000f2\b\b\u0001\u0010?\u001a\u00020\u0007¢\u0006\u0004\b@\u00108J\u0017\u0010B\u001a\u00020\u000f2\b\b\u0001\u0010A\u001a\u00020\u0007¢\u0006\u0004\bB\u00108J\u0017\u0010E\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\rH\u0016¢\u0006\u0004\bH\u0010\u0011J\u0017\u0010J\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020\u0007H\u0016¢\u0006\u0004\bJ\u00108J\u0017\u0010L\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\rH\u0016¢\u0006\u0004\bL\u0010\u0011J\u0017\u0010N\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\rH\u0016¢\u0006\u0004\bN\u0010\u0011J\u0017\u0010P\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\rH\u0016¢\u0006\u0004\bP\u0010\u0011J\u000f\u0010Q\u001a\u00020\rH\u0016¢\u0006\u0004\bQ\u0010RJ+\u0010X\u001a\u00020\u000f2\b\u0010T\u001a\u0004\u0018\u00010S2\b\u0010V\u001a\u0004\u0018\u00010U2\u0006\u0010W\u001a\u00020\u0007H\u0016¢\u0006\u0004\bX\u0010YJ\u0017\u0010[\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020\u0013H\u0016¢\u0006\u0004\b[\u0010\u0016J\u0017\u0010\\\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b\\\u0010+J\u0017\u0010^\u001a\u00020\u00132\u0006\u0010]\u001a\u00020 H\u0016¢\u0006\u0004\b^\u0010_J\u001f\u0010b\u001a\u00020\u00132\u0006\u0010`\u001a\u00020\u00072\u0006\u0010]\u001a\u00020aH\u0016¢\u0006\u0004\bb\u0010cJ)\u0010h\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u00132\u0006\u0010e\u001a\u00020\u00072\b\u0010g\u001a\u0004\u0018\u00010fH\u0014¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u00020\u000fH\u0014¢\u0006\u0004\bj\u0010\u001bJ\u000f\u0010k\u001a\u00020\u000fH\u0016¢\u0006\u0004\bk\u0010\u001bJ\u001f\u0010n\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u0007H\u0014¢\u0006\u0004\bn\u00101J7\u0010t\u001a\u00020\u000f2\u0006\u0010o\u001a\u00020\u00132\u0006\u0010p\u001a\u00020\u00072\u0006\u0010q\u001a\u00020\u00072\u0006\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u0007H\u0014¢\u0006\u0004\bt\u0010uJ\u0017\u0010w\u001a\u00020\u000f2\u0006\u0010v\u001a\u00020\u0007H\u0016¢\u0006\u0004\bw\u00108J\u0017\u0010y\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020xH\u0016¢\u0006\u0004\by\u0010zJ\u0017\u0010}\u001a\u00020\u000f2\u0006\u0010|\u001a\u00020{H\u0016¢\u0006\u0004\b}\u0010~J&\u0010\u0082\u0001\u001a\u00020\u00132\u0006\u0010\u007f\u001a\u00020\u00072\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0016¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0016\u0010\u0085\u0001\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bE\u0010\u0084\u0001R\u0017\u0010\u0087\u0001\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0084\u0001R\u0017\u0010\u0089\u0001\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0084\u0001R\u0017\u0010\u008b\u0001\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0084\u0001R\u0018\u0010\u008f\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u0091\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u008e\u0001R\u0018\u0010\u0093\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u008e\u0001R\u0018\u0010\u0095\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u008e\u0001R\u0018\u0010\u0097\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u008e\u0001R\u0017\u0010\u0098\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b,\u0010\u008e\u0001R\u001a\u0010\u009a\u0001\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b*\u0010\u0099\u0001R\u0018\u0010\u009c\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b&\u0010\u009b\u0001R\u0019\u0010\u009e\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009b\u0001R\u0018\u0010\u009f\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001e\u0010\u009b\u0001R\u0018\u0010 \u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b#\u0010\u009b\u0001R\u0018\u0010¡\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0018\u0010\u009b\u0001R\u0018\u0010¢\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b4\u0010\u009b\u0001R\u0018\u0010£\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b0\u0010\u009b\u0001R\u0018\u0010¤\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0010\u0010\u009b\u0001R\u0016\u0010¥\u0001\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0015\u0010\u009b\u0001R\u001d\u0010ª\u0001\u001a\b0¦\u0001j\u0003`§\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u0017\u0010\u00ad\u0001\u001a\u00030«\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001a\u0010¬\u0001R\u0017\u0010°\u0001\u001a\u00030®\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b-\u0010¯\u0001R\u001d\u0010³\u0001\u001a\t\u0012\u0004\u0012\u00020C0±\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0012\u0010²\u0001R\u0016\u0010µ\u0001\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b%\u0010´\u0001R\u0017\u0010¸\u0001\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0019\u0010º\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010\u009b\u0001R\u0019\u0010½\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u0019\u0010¿\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010\u009b\u0001R\u001b\u0010Á\u0001\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010\u0084\u0001R\u0018\u0010Å\u0001\u001a\u00030Â\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u0019\u0010Æ\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010·\u0001R\u0019\u0010É\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u0019\u0010Ë\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010È\u0001R\u0018\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010¼\u0001R\u0018\u0010O\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010¼\u0001R\u0018\u0010K\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010¼\u0001R\u0018\u0010M\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010¼\u0001R\u0018\u0010W\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010\u009b\u0001R\u001a\u0010T\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u001a\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R \u0010Ù\u0001\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÕ\u0001\u0010Ö\u0001\u001a\u0006\b×\u0001\u0010Ø\u0001R \u0010Ü\u0001\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÚ\u0001\u0010Ö\u0001\u001a\u0006\bÛ\u0001\u0010Ø\u0001R \u0010ß\u0001\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÝ\u0001\u0010Ö\u0001\u001a\u0006\bÞ\u0001\u0010Ø\u0001R\u0016\u0010á\u0001\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bà\u0001\u0010RR\u0018\u0010å\u0001\u001a\u00030â\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bã\u0001\u0010ä\u0001R\u0016\u0010ç\u0001\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bæ\u0001\u0010R¨\u0006é\u0001"}, d2 = {"Lir/nasim/jaryan/feed/ui/components/DefaultTimeBar;", "Landroid/view/View;", "Lcom/google/android/exoplayer2/ui/B;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "timebarAttrs", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/util/AttributeSet;I)V", "", "scrubPosition", "Lir/nasim/rB7;", "s", "(J)V", "x", "", "canceled", "t", "(Z)V", "positionChange", "p", "(J)Z", "v", "()V", "", "xPosition", "n", "(F)V", "Landroid/view/MotionEvent;", "motionEvent", "Landroid/graphics/Point;", "o", "(Landroid/view/MotionEvent;)Landroid/graphics/Point;", "y", "l", "(FF)Z", "Landroid/graphics/Canvas;", "canvas", "k", "(Landroid/graphics/Canvas;)V", "j", "w", "width", "height", "r", "(II)V", "Landroid/graphics/drawable/Drawable;", "drawable", "q", "(Landroid/graphics/drawable/Drawable;)Z", "playedColor", "setPlayedColor", "(I)V", "scrubberColor", "setScrubberColor", "bufferedColor", "setBufferedColor", "unplayedColor", "setUnplayedColor", "adMarkerColor", "setAdMarkerColor", "playedAdMarkerColor", "setPlayedAdMarkerColor", "Lcom/google/android/exoplayer2/ui/B$a;", "listener", "a", "(Lcom/google/android/exoplayer2/ui/B$a;)V", "time", "setKeyTimeIncrement", "count", "setKeyCountIncrement", "position", "setPosition", "bufferedPosition", "setBufferedPosition", "duration", "setDuration", "getPreferredUpdateDelay", "()J", "", "adGroupTimesMs", "", "playedAdGroups", "adGroupCount", "setAdGroupTimesMs", "([J[ZI)V", "enabled", "setEnabled", "onDraw", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "keyCode", "Landroid/view/KeyEvent;", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "gainFocus", "direction", "Landroid/graphics/Rect;", "previouslyFocusedRect", "onFocusChanged", "(ZILandroid/graphics/Rect;)V", "drawableStateChanged", "jumpDrawablesToCurrentState", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "layoutDirection", "onRtlPropertiesChanged", "Landroid/view/accessibility/AccessibilityEvent;", "onInitializeAccessibilityEvent", "(Landroid/view/accessibility/AccessibilityEvent;)V", "Landroid/view/accessibility/AccessibilityNodeInfo;", ParameterNames.INFO, "onInitializeAccessibilityNodeInfo", "(Landroid/view/accessibility/AccessibilityNodeInfo;)V", "action", "Landroid/os/Bundle;", "args", "performAccessibilityAction", "(ILandroid/os/Bundle;)Z", "Landroid/graphics/Rect;", "seekBounds", "b", "progressBar", "c", "bufferedBar", "d", "scrubberBar", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "playedPaint", "f", "bufferedPaint", "g", "unplayedPaint", "h", "adMarkerPaint", "i", "playedAdMarkerPaint", "scrubberPaint", "Landroid/graphics/drawable/Drawable;", "scrubberDrawable", TokenNames.I, "barHeight", "m", "touchTargetHeight", "barGravity", "adMarkerWidth", "scrubberEnabledSize", "scrubberDisabledSize", "scrubberDraggedSize", "scrubberPadding", "fineScrubYThreshold", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "u", "Ljava/lang/StringBuilder;", "formatBuilder", "Ljava/util/Formatter;", "Ljava/util/Formatter;", "formatter", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "stopScrubbingRunnable", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "listeners", "Landroid/graphics/Point;", "touchPosition", "z", TokenNames.F, "density", "A", "keyCountIncrement", "B", "J", "keyTimeIncrement", "D", "lastCoarseScrubXPosition", "G", "lastExclusionRectangle", "Landroid/animation/ValueAnimator;", "H", "Landroid/animation/ValueAnimator;", "scrubberScalingAnimator", "scrubberScale", "z0", "Z", "scrubberPaddingDisabled", "A0", "scrubbing", "B0", "C0", "D0", "E0", "F0", "G0", "[J", "H0", "[Z", "I0", "Lir/nasim/Yu3;", "getPlayedRadius", "()F", "playedRadius", "J0", "getUnPlayedRadius", "unPlayedRadius", "K0", "getBufferedRadius", "bufferedRadius", "getScrubberPosition", "scrubberPosition", "", "getProgressText", "()Ljava/lang/String;", "progressText", "getPositionIncrement", "positionIncrement", "L0", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class DefaultTimeBar extends View implements B {

    /* renamed from: L0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int M0 = 8;

    /* renamed from: A, reason: from kotlin metadata */
    private int keyCountIncrement;

    /* renamed from: A0, reason: from kotlin metadata */
    private boolean scrubbing;

    /* renamed from: B, reason: from kotlin metadata */
    private long keyTimeIncrement;

    /* renamed from: B0, reason: from kotlin metadata */
    private long scrubPosition;

    /* renamed from: C0, reason: from kotlin metadata */
    private long duration;

    /* renamed from: D, reason: from kotlin metadata */
    private int lastCoarseScrubXPosition;

    /* renamed from: D0, reason: from kotlin metadata */
    private long position;

    /* renamed from: E0, reason: from kotlin metadata */
    private long bufferedPosition;

    /* renamed from: F0, reason: from kotlin metadata */
    private int adGroupCount;

    /* renamed from: G, reason: from kotlin metadata */
    private Rect lastExclusionRectangle;

    /* renamed from: G0, reason: from kotlin metadata */
    private long[] adGroupTimesMs;

    /* renamed from: H, reason: from kotlin metadata */
    private final ValueAnimator scrubberScalingAnimator;

    /* renamed from: H0, reason: from kotlin metadata */
    private boolean[] playedAdGroups;

    /* renamed from: I0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 playedRadius;

    /* renamed from: J, reason: from kotlin metadata */
    private float scrubberScale;

    /* renamed from: J0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 unPlayedRadius;

    /* renamed from: K0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 bufferedRadius;

    /* renamed from: a, reason: from kotlin metadata */
    private final Rect seekBounds;

    /* renamed from: b, reason: from kotlin metadata */
    private final Rect progressBar;

    /* renamed from: c, reason: from kotlin metadata */
    private final Rect bufferedBar;

    /* renamed from: d, reason: from kotlin metadata */
    private final Rect scrubberBar;

    /* renamed from: e, reason: from kotlin metadata */
    private final Paint playedPaint;

    /* renamed from: f, reason: from kotlin metadata */
    private final Paint bufferedPaint;

    /* renamed from: g, reason: from kotlin metadata */
    private final Paint unplayedPaint;

    /* renamed from: h, reason: from kotlin metadata */
    private final Paint adMarkerPaint;

    /* renamed from: i, reason: from kotlin metadata */
    private final Paint playedAdMarkerPaint;

    /* renamed from: j, reason: from kotlin metadata */
    private final Paint scrubberPaint;

    /* renamed from: k, reason: from kotlin metadata */
    private Drawable scrubberDrawable;

    /* renamed from: l, reason: from kotlin metadata */
    private int barHeight;

    /* renamed from: m, reason: from kotlin metadata */
    private int touchTargetHeight;

    /* renamed from: n, reason: from kotlin metadata */
    private int barGravity;

    /* renamed from: o, reason: from kotlin metadata */
    private int adMarkerWidth;

    /* renamed from: p, reason: from kotlin metadata */
    private int scrubberEnabledSize;

    /* renamed from: q, reason: from kotlin metadata */
    private int scrubberDisabledSize;

    /* renamed from: r, reason: from kotlin metadata */
    private int scrubberDraggedSize;

    /* renamed from: s, reason: from kotlin metadata */
    private int scrubberPadding;

    /* renamed from: t, reason: from kotlin metadata */
    private final int fineScrubYThreshold;

    /* renamed from: u, reason: from kotlin metadata */
    private final StringBuilder formatBuilder;

    /* renamed from: v, reason: from kotlin metadata */
    private final Formatter formatter;

    /* renamed from: w, reason: from kotlin metadata */
    private final Runnable stopScrubbingRunnable;

    /* renamed from: x, reason: from kotlin metadata */
    private final CopyOnWriteArraySet listeners;

    /* renamed from: y, reason: from kotlin metadata */
    private final Point touchPosition;

    /* renamed from: z, reason: from kotlin metadata */
    private final float density;

    /* renamed from: z0, reason: from kotlin metadata */
    private boolean scrubberPaddingDisabled;

    /* renamed from: ir.nasim.jaryan.feed.ui.components.DefaultTimeBar$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(float f, int i) {
            return (int) ((i * f) + 0.5f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int e(float f, int i) {
            return (int) (i / f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean f(Drawable drawable, int i) {
            return AbstractC9683aN7.a >= 23 && drawable.setLayoutDirection(i);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultTimeBar(Context context) {
        this(context, null, 0, null, 0, 30, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(DefaultTimeBar defaultTimeBar) {
        AbstractC13042fc3.i(defaultTimeBar, "this$0");
        defaultTimeBar.t(false);
    }

    private final float getBufferedRadius() {
        return ((Number) this.bufferedRadius.getValue()).floatValue();
    }

    private final float getPlayedRadius() {
        return ((Number) this.playedRadius.getValue()).floatValue();
    }

    private final long getPositionIncrement() {
        long j = this.keyTimeIncrement;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.duration;
        if (j2 == -9223372036854775807L) {
            return 0L;
        }
        return j2 / this.keyCountIncrement;
    }

    private final String getProgressText() {
        String strF0 = AbstractC9683aN7.f0(this.formatBuilder, this.formatter, this.position);
        AbstractC13042fc3.h(strF0, "getStringForTime(...)");
        return strF0;
    }

    private final long getScrubberPosition() {
        if (this.progressBar.width() <= 0 || this.duration == -9223372036854775807L) {
            return 0L;
        }
        return (this.scrubberBar.width() * this.duration) / this.progressBar.width();
    }

    private final float getUnPlayedRadius() {
        return ((Number) this.unPlayedRadius.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DefaultTimeBar defaultTimeBar, ValueAnimator valueAnimator) {
        AbstractC13042fc3.i(defaultTimeBar, "this$0");
        AbstractC13042fc3.i(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        AbstractC13042fc3.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        defaultTimeBar.scrubberScale = ((Float) animatedValue).floatValue();
        defaultTimeBar.invalidate(defaultTimeBar.seekBounds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float i() {
        return 2.0f;
    }

    private final void j(Canvas canvas) {
        if (this.duration <= 0) {
            return;
        }
        Rect rect = this.scrubberBar;
        int iP = AbstractC9683aN7.p(rect.right, rect.left, this.progressBar.right);
        int iCenterY = this.scrubberBar.centerY();
        Drawable drawable = this.scrubberDrawable;
        if (drawable == null) {
            canvas.drawCircle(iP, iCenterY, (int) ((((this.scrubbing || isFocused()) ? this.scrubberDraggedSize : isEnabled() ? this.scrubberEnabledSize : this.scrubberDisabledSize) * this.scrubberScale) / 2), this.scrubberPaint);
            return;
        }
        AbstractC13042fc3.f(drawable);
        int intrinsicWidth = (int) (drawable.getIntrinsicWidth() * this.scrubberScale);
        AbstractC13042fc3.f(this.scrubberDrawable);
        int intrinsicHeight = (int) (r4.getIntrinsicHeight() * this.scrubberScale);
        Drawable drawable2 = this.scrubberDrawable;
        AbstractC13042fc3.f(drawable2);
        int i = intrinsicWidth / 2;
        int i2 = intrinsicHeight / 2;
        drawable2.setBounds(iP - i, iCenterY - i2, iP + i, iCenterY + i2);
        Drawable drawable3 = this.scrubberDrawable;
        AbstractC13042fc3.f(drawable3);
        drawable3.draw(canvas);
    }

    private final void k(Canvas canvas) {
        int iHeight = this.progressBar.height();
        int iCenterY = this.progressBar.centerY() - (iHeight / 2);
        int i = iHeight + iCenterY;
        if (this.duration <= 0) {
            Rect rect = this.progressBar;
            canvas.drawRect(rect.left, iCenterY, rect.right, i, this.unplayedPaint);
            return;
        }
        Rect rect2 = this.bufferedBar;
        int i2 = rect2.left;
        int i3 = rect2.right;
        int iE = AbstractC23053wG5.e(AbstractC23053wG5.e(this.progressBar.left, i3), this.scrubberBar.right);
        int i4 = this.progressBar.right;
        if (iE < i4) {
            canvas.drawRoundRect(iE, iCenterY, i4, i, getUnPlayedRadius(), getUnPlayedRadius(), this.unplayedPaint);
        }
        int iE2 = AbstractC23053wG5.e(i2, this.scrubberBar.right);
        if (i3 > iE2) {
            canvas.drawRoundRect(iE2, iCenterY, i3, i, getBufferedRadius(), getBufferedRadius(), this.bufferedPaint);
        }
        if (this.scrubberBar.width() > 0) {
            Rect rect3 = this.scrubberBar;
            canvas.drawRoundRect(rect3.left, iCenterY, rect3.right, i, getPlayedRadius(), getPlayedRadius(), this.playedPaint);
        }
        if (this.adGroupCount == 0) {
            return;
        }
        Object objE = AbstractC20011rK.e(this.adGroupTimesMs);
        AbstractC13042fc3.h(objE, "checkNotNull(...)");
        long[] jArr = (long[]) objE;
        Object objE2 = AbstractC20011rK.e(this.playedAdGroups);
        AbstractC13042fc3.h(objE2, "checkNotNull(...)");
        boolean[] zArr = (boolean[]) objE2;
        int i5 = this.adMarkerWidth / 2;
        int i6 = this.adGroupCount;
        for (int i7 = 0; i7 < i6; i7++) {
            int iWidth = ((int) ((this.progressBar.width() * AbstractC9683aN7.q(jArr[i7], 0L, this.duration)) / this.duration)) - i5;
            Rect rect4 = this.progressBar;
            canvas.drawRect(rect4.left + Math.min(rect4.width() - this.adMarkerWidth, Math.max(0, iWidth)), iCenterY, r11 + this.adMarkerWidth, i, zArr[i7] ? this.playedAdMarkerPaint : this.adMarkerPaint);
        }
    }

    private final boolean l(float x, float y) {
        return this.seekBounds.contains((int) x, (int) y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float m(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return context.getResources().getDimension(VA5.radius_4);
    }

    private final void n(float xPosition) {
        Rect rect = this.scrubberBar;
        Rect rect2 = this.progressBar;
        rect.right = AbstractC9683aN7.p((int) xPosition, rect2.left, rect2.right);
    }

    private final Point o(MotionEvent motionEvent) {
        this.touchPosition.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.touchPosition;
    }

    private final boolean p(long positionChange) {
        long j = this.duration;
        if (j <= 0) {
            return false;
        }
        long j2 = this.scrubbing ? this.scrubPosition : this.position;
        long jQ = AbstractC9683aN7.q(j2 + positionChange, 0L, j);
        if (jQ == j2) {
            return false;
        }
        if (this.scrubbing) {
            x(jQ);
        } else {
            s(jQ);
        }
        v();
        return true;
    }

    private final boolean q(Drawable drawable) {
        return AbstractC9683aN7.a >= 23 && INSTANCE.f(drawable, getLayoutDirection());
    }

    private final void r(int width, int height) {
        Rect rect = this.lastExclusionRectangle;
        if (rect != null) {
            AbstractC13042fc3.f(rect);
            if (rect.width() == width) {
                Rect rect2 = this.lastExclusionRectangle;
                AbstractC13042fc3.f(rect2);
                if (rect2.height() == height) {
                    return;
                }
            }
        }
        Rect rect3 = new Rect(0, 0, width, height);
        this.lastExclusionRectangle = rect3;
        AbstractC13042fc3.f(rect3);
        setSystemGestureExclusionRects(AbstractC9766aX0.e(rect3));
    }

    private final void s(long scrubPosition) {
        this.scrubPosition = scrubPosition;
        this.scrubbing = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.listeners.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            ((B.a) it.next()).h(this, scrubPosition);
        }
    }

    private final void t(boolean canceled) {
        removeCallbacks(this.stopScrubbingRunnable);
        this.scrubbing = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.listeners.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            ((B.a) it.next()).e(this, this.scrubPosition, canceled);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float u(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return context.getResources().getDimension(VA5.radius_4);
    }

    private final void v() {
        this.bufferedBar.set(this.progressBar);
        this.scrubberBar.set(this.progressBar);
        long j = this.scrubbing ? this.scrubPosition : this.position;
        if (this.duration > 0) {
            int iWidth = (int) ((this.progressBar.width() * this.bufferedPosition) / this.duration);
            Rect rect = this.bufferedBar;
            Rect rect2 = this.progressBar;
            rect.right = AbstractC23053wG5.i(rect2.left + iWidth, rect2.right);
            int iWidth2 = (int) ((this.progressBar.width() * j) / this.duration);
            Rect rect3 = this.scrubberBar;
            Rect rect4 = this.progressBar;
            rect3.right = AbstractC23053wG5.i(rect4.left + iWidth2, rect4.right);
        } else {
            Rect rect5 = this.bufferedBar;
            int i = this.progressBar.left;
            rect5.right = i;
            this.scrubberBar.right = i;
        }
        invalidate(this.seekBounds);
    }

    private final void w() {
        Drawable drawable = this.scrubberDrawable;
        if (drawable != null) {
            AbstractC13042fc3.f(drawable);
            if (drawable.isStateful()) {
                Drawable drawable2 = this.scrubberDrawable;
                AbstractC13042fc3.f(drawable2);
                if (drawable2.setState(getDrawableState())) {
                    invalidate();
                }
            }
        }
    }

    private final void x(long scrubPosition) {
        if (this.scrubPosition == scrubPosition) {
            return;
        }
        this.scrubPosition = scrubPosition;
        Iterator it = this.listeners.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            ((B.a) it.next()).a(this, scrubPosition);
        }
    }

    @Override // com.google.android.exoplayer2.ui.B
    public void a(B.a listener) {
        AbstractC13042fc3.i(listener, "listener");
        AbstractC20011rK.e(listener);
        this.listeners.add(listener);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        w();
    }

    @Override // com.google.android.exoplayer2.ui.B
    public long getPreferredUpdateDelay() {
        if (INSTANCE.e(this.density, this.progressBar.width()) != 0) {
            long j = this.duration;
            if (j != 0 && j != -9223372036854775807L) {
                return 5L;
            }
        }
        return Long.MAX_VALUE;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.scrubberDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        canvas.save();
        k(canvas);
        j(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (!this.scrubbing || gainFocus) {
            return;
        }
        t(false);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        AbstractC13042fc3.i(event, "event");
        super.onInitializeAccessibilityEvent(event);
        if (event.getEventType() == 4) {
            event.getText().add(getProgressText());
        }
        event.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        AbstractC13042fc3.i(info, ParameterNames.INFO);
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName("android.widget.SeekBar");
        info.setContentDescription(getProgressText());
        if (this.duration <= 0) {
            return;
        }
        info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyDown(int r7, android.view.KeyEvent r8) {
        /*
            r6 = this;
            java.lang.String r0 = "event"
            ir.nasim.AbstractC13042fc3.i(r8, r0)
            boolean r0 = r6.isEnabled()
            if (r0 == 0) goto L46
            long r0 = r6.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r7 == r2) goto L3d
            r4 = 1000(0x3e8, double:4.94E-321)
            switch(r7) {
                case 21: goto L2b;
                case 22: goto L1a;
                case 23: goto L3d;
                default: goto L19;
            }
        L19:
            goto L46
        L1a:
            boolean r0 = r6.p(r0)
            if (r0 == 0) goto L46
            java.lang.Runnable r7 = r6.stopScrubbingRunnable
            r6.removeCallbacks(r7)
            java.lang.Runnable r7 = r6.stopScrubbingRunnable
            r6.postDelayed(r7, r4)
            return r3
        L2b:
            long r0 = -r0
            boolean r0 = r6.p(r0)
            if (r0 == 0) goto L46
            java.lang.Runnable r7 = r6.stopScrubbingRunnable
            r6.removeCallbacks(r7)
            java.lang.Runnable r7 = r6.stopScrubbingRunnable
            r6.postDelayed(r7, r4)
            return r3
        L3d:
            boolean r0 = r6.scrubbing
            if (r0 == 0) goto L46
            r7 = 0
            r6.t(r7)
            return r3
        L46:
            boolean r7 = super.onKeyDown(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.jaryan.feed.ui.components.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int paddingBottom;
        int iMax;
        int i = right - left;
        int i2 = bottom - top;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i - getPaddingRight();
        int i3 = this.scrubberPaddingDisabled ? 0 : this.scrubberPadding;
        if (this.barGravity == 1) {
            paddingBottom = (i2 - getPaddingBottom()) - this.touchTargetHeight;
            int paddingBottom2 = i2 - getPaddingBottom();
            int i4 = this.barHeight;
            iMax = (paddingBottom2 - i4) - Math.max(i3 - (i4 / 2), 0);
        } else {
            paddingBottom = (i2 - this.touchTargetHeight) / 2;
            iMax = (i2 - this.barHeight) / 2;
        }
        this.seekBounds.set(paddingLeft, paddingBottom, paddingRight, this.touchTargetHeight + paddingBottom);
        Rect rect = this.progressBar;
        Rect rect2 = this.seekBounds;
        rect.set(rect2.left + i3, iMax, rect2.right - i3, this.barHeight + iMax);
        if (AbstractC9683aN7.a >= 29) {
            r(i, i2);
        }
        v();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode == 0) {
            size = this.touchTargetHeight;
        } else if (mode != 1073741824) {
            size = Math.min(this.touchTargetHeight, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), size);
        w();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        Drawable drawable = this.scrubberDrawable;
        if (drawable != null) {
            Companion companion = INSTANCE;
            AbstractC13042fc3.f(drawable);
            if (companion.f(drawable, layoutDirection)) {
                invalidate();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "event"
            ir.nasim.AbstractC13042fc3.i(r8, r0)
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L7b
            long r2 = r7.duration
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L15
            goto L7b
        L15:
            android.graphics.Point r0 = r7.o(r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L62
            r5 = 3
            if (r3 == r4) goto L53
            r6 = 2
            if (r3 == r6) goto L2d
            if (r3 == r5) goto L53
            goto L7b
        L2d:
            boolean r8 = r7.scrubbing
            if (r8 == 0) goto L7b
            int r8 = r7.fineScrubYThreshold
            if (r0 >= r8) goto L3f
            int r8 = r7.lastCoarseScrubXPosition
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.n(r8)
            goto L45
        L3f:
            r7.lastCoarseScrubXPosition = r2
            float r8 = (float) r2
            r7.n(r8)
        L45:
            long r0 = r7.getScrubberPosition()
            r7.x(r0)
            r7.v()
            r7.invalidate()
            return r4
        L53:
            boolean r0 = r7.scrubbing
            if (r0 == 0) goto L7b
            int r8 = r8.getAction()
            if (r8 != r5) goto L5e
            r1 = r4
        L5e:
            r7.t(r1)
            return r4
        L62:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.l(r8, r0)
            if (r0 == 0) goto L7b
            r7.n(r8)
            long r0 = r7.getScrubberPosition()
            r7.s(r0)
            r7.v()
            r7.invalidate()
            return r4
        L7b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.jaryan.feed.ui.components.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int action, Bundle args) {
        if (super.performAccessibilityAction(action, args)) {
            return true;
        }
        if (this.duration <= 0) {
            return false;
        }
        if (action != 4096) {
            if (action != 8192) {
                return false;
            }
            if (p(-getPositionIncrement())) {
                t(false);
            }
        } else if (p(getPositionIncrement())) {
            t(false);
        }
        sendAccessibilityEvent(4);
        return true;
    }

    @Override // com.google.android.exoplayer2.ui.B
    public void setAdGroupTimesMs(long[] adGroupTimesMs, boolean[] playedAdGroups, int adGroupCount) {
        AbstractC20011rK.a(adGroupCount == 0 || !(adGroupTimesMs == null || playedAdGroups == null));
        this.adGroupCount = adGroupCount;
        this.adGroupTimesMs = adGroupTimesMs;
        this.playedAdGroups = playedAdGroups;
        v();
    }

    public final void setAdMarkerColor(int adMarkerColor) {
        this.adMarkerPaint.setColor(adMarkerColor);
        invalidate(this.seekBounds);
    }

    public final void setBufferedColor(int bufferedColor) {
        this.bufferedPaint.setColor(bufferedColor);
        invalidate(this.seekBounds);
    }

    @Override // com.google.android.exoplayer2.ui.B
    public void setBufferedPosition(long bufferedPosition) {
        if (this.bufferedPosition == bufferedPosition) {
            return;
        }
        this.bufferedPosition = bufferedPosition;
        v();
    }

    @Override // com.google.android.exoplayer2.ui.B
    public void setDuration(long duration) {
        if (this.duration == duration) {
            return;
        }
        this.duration = duration;
        if (this.scrubbing && duration == -9223372036854775807L) {
            t(true);
        }
        v();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.B
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (!this.scrubbing || enabled) {
            return;
        }
        t(true);
    }

    public void setKeyCountIncrement(int count) {
        AbstractC20011rK.a(count > 0);
        this.keyCountIncrement = count;
        this.keyTimeIncrement = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long time) {
        AbstractC20011rK.a(time > 0);
        this.keyCountIncrement = -1;
        this.keyTimeIncrement = time;
    }

    public final void setPlayedAdMarkerColor(int playedAdMarkerColor) {
        this.playedAdMarkerPaint.setColor(playedAdMarkerColor);
        invalidate(this.seekBounds);
    }

    public final void setPlayedColor(int playedColor) {
        this.playedPaint.setColor(playedColor);
        invalidate(this.seekBounds);
    }

    @Override // com.google.android.exoplayer2.ui.B
    public void setPosition(long position) {
        if (this.position == position) {
            return;
        }
        this.position = position;
        setContentDescription(getProgressText());
        v();
    }

    public final void setScrubberColor(int scrubberColor) {
        this.scrubberPaint.setColor(scrubberColor);
        invalidate(this.seekBounds);
    }

    public final void setUnplayedColor(int unplayedColor) {
        this.unplayedPaint.setColor(unplayedColor);
        invalidate(this.seekBounds);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, 0, 28, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null, 0, 24, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DefaultTimeBar(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2, int i2, int i3, ED1 ed1) {
        AttributeSet attributeSet3 = (i3 & 2) != 0 ? null : attributeSet;
        this(context, attributeSet3, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? attributeSet3 : attributeSet2, (i3 & 16) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultTimeBar(final Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2, int i2) {
        int iE;
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.seekBounds = new Rect();
        this.progressBar = new Rect();
        this.bufferedBar = new Rect();
        this.scrubberBar = new Rect();
        Paint paint = new Paint();
        this.playedPaint = paint;
        Paint paint2 = new Paint();
        this.bufferedPaint = paint2;
        Paint paint3 = new Paint();
        this.unplayedPaint = paint3;
        Paint paint4 = new Paint();
        this.adMarkerPaint = paint4;
        Paint paint5 = new Paint();
        this.playedAdMarkerPaint = paint5;
        Paint paint6 = new Paint();
        this.scrubberPaint = paint6;
        this.playedRadius = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.HF1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Float.valueOf(DefaultTimeBar.m(context));
            }
        });
        this.unPlayedRadius = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.JF1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Float.valueOf(DefaultTimeBar.u(context));
            }
        });
        this.bufferedRadius = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.LF1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Float.valueOf(DefaultTimeBar.i());
            }
        });
        paint6.setAntiAlias(true);
        this.listeners = new CopyOnWriteArraySet();
        this.touchPosition = new Point();
        float f = context.getResources().getDisplayMetrics().density;
        this.density = f;
        Companion companion = INSTANCE;
        this.fineScrubYThreshold = companion.d(f, -50);
        int iD = companion.d(f, 4);
        int iD2 = companion.d(f, 26);
        int iD3 = companion.d(f, 4);
        int iD4 = companion.d(f, 12);
        int iD5 = companion.d(f, 0);
        int iD6 = companion.d(f, 16);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, LE5.DefaultTimeBar, i, i2);
            AbstractC13042fc3.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(LE5.DefaultTimeBar_scrubber_drawable);
                this.scrubberDrawable = drawable;
                if (drawable != null) {
                    AbstractC13042fc3.f(drawable);
                    q(drawable);
                    Drawable drawable2 = this.scrubberDrawable;
                    AbstractC13042fc3.f(drawable2);
                    iD2 = AbstractC23053wG5.e(drawable2.getMinimumHeight(), iD2);
                }
                this.barHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(LE5.DefaultTimeBar_bar_height, iD);
                this.touchTargetHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(LE5.DefaultTimeBar_touch_target_height, iD2);
                this.barGravity = typedArrayObtainStyledAttributes.getInt(LE5.DefaultTimeBar_bar_gravity, 0);
                this.adMarkerWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(LE5.DefaultTimeBar_ad_marker_width, iD3);
                this.scrubberEnabledSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(LE5.DefaultTimeBar_scrubber_enabled_size, iD4);
                this.scrubberDisabledSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(LE5.DefaultTimeBar_scrubber_disabled_size, iD5);
                this.scrubberDraggedSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(LE5.DefaultTimeBar_scrubber_dragged_size, iD6);
                int i3 = typedArrayObtainStyledAttributes.getInt(LE5.DefaultTimeBar_played_color, -1);
                int i4 = typedArrayObtainStyledAttributes.getInt(LE5.DefaultTimeBar_scrubber_color, -1);
                int i5 = typedArrayObtainStyledAttributes.getInt(LE5.DefaultTimeBar_buffered_color, -855638017);
                int i6 = typedArrayObtainStyledAttributes.getInt(LE5.DefaultTimeBar_unplayed_color, 872415231);
                int i7 = typedArrayObtainStyledAttributes.getInt(LE5.DefaultTimeBar_ad_marker_color, -1291845888);
                int i8 = typedArrayObtainStyledAttributes.getInt(LE5.DefaultTimeBar_played_ad_marker_color, 872414976);
                paint.setColor(i3);
                paint6.setColor(i4);
                paint2.setColor(i5);
                paint3.setColor(i6);
                paint4.setColor(i7);
                paint5.setColor(i8);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.barHeight = iD;
            this.touchTargetHeight = iD2;
            this.barGravity = 0;
            this.adMarkerWidth = iD3;
            this.scrubberEnabledSize = iD4;
            this.scrubberDisabledSize = iD5;
            this.scrubberDraggedSize = iD6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.scrubberDrawable = null;
        }
        StringBuilder sb = new StringBuilder();
        this.formatBuilder = sb;
        this.formatter = new Formatter(sb, Locale.getDefault());
        this.stopScrubbingRunnable = new Runnable() { // from class: ir.nasim.MF1
            @Override // java.lang.Runnable
            public final void run() {
                DefaultTimeBar.g(this.a);
            }
        };
        Drawable drawable3 = this.scrubberDrawable;
        if (drawable3 != null) {
            AbstractC13042fc3.f(drawable3);
            iE = (drawable3.getMinimumWidth() + 1) / 2;
        } else {
            iE = (AbstractC23053wG5.e(this.scrubberDisabledSize, AbstractC23053wG5.e(this.scrubberEnabledSize, this.scrubberDraggedSize)) + 1) / 2;
        }
        this.scrubberPadding = iE;
        this.scrubberScale = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.scrubberScalingAnimator = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.NF1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                DefaultTimeBar.h(this.a, valueAnimator2);
            }
        });
        this.duration = -9223372036854775807L;
        this.keyTimeIncrement = -9223372036854775807L;
        this.keyCountIncrement = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
