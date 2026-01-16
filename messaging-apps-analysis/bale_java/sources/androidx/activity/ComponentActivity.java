package androidx.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.gov.nist.javax.sip.stack.SIPServerTransaction;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.ComponentActivity;
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.B;
import androidx.lifecycle.C;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.A44;
import ir.nasim.AI4;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC15744k6;
import ir.nasim.AbstractC18108o6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC22357v6;
import ir.nasim.AbstractC24133y6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.B6;
import ir.nasim.C13170fm4;
import ir.nasim.C14819iX7;
import ir.nasim.C16807lt7;
import ir.nasim.C17236md5;
import ir.nasim.C18093o44;
import ir.nasim.C19938rB7;
import ir.nasim.C23660xI4;
import ir.nasim.C3575Bl1;
import ir.nasim.C6665Ol4;
import ir.nasim.C7289Rb6;
import ir.nasim.C7523Sb6;
import ir.nasim.DJ4;
import ir.nasim.ED1;
import ir.nasim.InterfaceC10854cJ4;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC15879kK4;
import ir.nasim.InterfaceC17502n44;
import ir.nasim.InterfaceC17517n6;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC25043ze1;
import ir.nasim.InterfaceC7760Tb6;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.OJ4;
import ir.nasim.QA2;
import ir.nasim.RA2;
import ir.nasim.SA2;
import ir.nasim.UX7;
import ir.nasim.VX7;
import ir.nasim.WX7;
import ir.nasim.X5;
import ir.nasim.XX7;
import ir.nasim.YI4;
import ir.nasim.YX7;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Ø\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 Ø\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\u00022\u00020\t2\u00020\n2\u00020\u00022\u00020\u000b2\u00020\f2\u00020\u00022\u00020\r2\u00020\u000e:\by\u0084\u0001\u0090\u0001E\u0098\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001aH\u0015¢\u0006\u0004\b\u001f\u0010\u001dJ\u000f\u0010 \u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010!J\u0011\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\"\u0010!J\u0019\u0010%\u001a\u00020\u00112\b\b\u0001\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0019\u0010%\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b%\u0010)J#\u0010%\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b%\u0010,J#\u0010-\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b-\u0010,J\u000f\u0010.\u001a\u00020\u0011H\u0017¢\u0006\u0004\b.\u0010\u0010J\u0015\u00101\u001a\u00020\u00112\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J)\u00107\u001a\u0002062\u0006\u00103\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b7\u00108J\u001f\u00109\u001a\u0002062\u0006\u00103\u001a\u00020#2\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b9\u0010:J\u001f\u0010=\u001a\u0002062\u0006\u00103\u001a\u00020#2\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b=\u0010>J\u001f\u0010?\u001a\u00020\u00112\u0006\u00103\u001a\u00020#2\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\u00112\u0006\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u00020\u00112\u0006\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bE\u0010DJ\u000f\u0010F\u001a\u00020\u0011H\u0016¢\u0006\u0004\bF\u0010\u0010J\u000f\u0010G\u001a\u00020\u0011H\u0017¢\u0006\u0004\bG\u0010\u0010J\u001f\u0010K\u001a\u00020\u00112\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020#H\u0017¢\u0006\u0004\bK\u0010LJ)\u0010K\u001a\u00020\u00112\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020#2\b\u0010M\u001a\u0004\u0018\u00010\u001aH\u0017¢\u0006\u0004\bK\u0010NJA\u0010T\u001a\u00020\u00112\u0006\u0010I\u001a\u00020O2\u0006\u0010J\u001a\u00020#2\b\u0010P\u001a\u0004\u0018\u00010H2\u0006\u0010Q\u001a\u00020#2\u0006\u0010R\u001a\u00020#2\u0006\u0010S\u001a\u00020#H\u0017¢\u0006\u0004\bT\u0010UJK\u0010T\u001a\u00020\u00112\u0006\u0010I\u001a\u00020O2\u0006\u0010J\u001a\u00020#2\b\u0010P\u001a\u0004\u0018\u00010H2\u0006\u0010Q\u001a\u00020#2\u0006\u0010R\u001a\u00020#2\u0006\u0010S\u001a\u00020#2\b\u0010M\u001a\u0004\u0018\u00010\u001aH\u0017¢\u0006\u0004\bT\u0010VJ)\u0010Y\u001a\u00020\u00112\u0006\u0010J\u001a\u00020#2\u0006\u0010W\u001a\u00020#2\b\u0010X\u001a\u0004\u0018\u00010HH\u0015¢\u0006\u0004\bY\u0010ZJ-\u0010`\u001a\u00020\u00112\u0006\u0010J\u001a\u00020#2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\\0[2\u0006\u0010_\u001a\u00020^H\u0017¢\u0006\u0004\b`\u0010aJI\u0010k\u001a\b\u0012\u0004\u0012\u00028\u00000j\"\u0004\b\u0000\u0010b\"\u0004\b\u0001\u0010c2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010d2\u0006\u0010g\u001a\u00020f2\f\u0010i\u001a\b\u0012\u0004\u0012\u00028\u00010h¢\u0006\u0004\bk\u0010lJA\u0010m\u001a\b\u0012\u0004\u0012\u00028\u00000j\"\u0004\b\u0000\u0010b\"\u0004\b\u0001\u0010c2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010d2\f\u0010i\u001a\b\u0012\u0004\u0012\u00028\u00010h¢\u0006\u0004\bm\u0010nJ\u0017\u0010q\u001a\u00020\u00112\u0006\u0010p\u001a\u00020oH\u0017¢\u0006\u0004\bq\u0010rJ\u001b\u0010t\u001a\u00020\u00112\f\u00100\u001a\b\u0012\u0004\u0012\u00020o0s¢\u0006\u0004\bt\u0010uJ\u001b\u0010v\u001a\u00020\u00112\f\u00100\u001a\b\u0012\u0004\u0012\u00020o0s¢\u0006\u0004\bv\u0010uJ\u0017\u0010x\u001a\u00020\u00112\u0006\u0010w\u001a\u00020#H\u0017¢\u0006\u0004\bx\u0010&J\u001b\u0010y\u001a\u00020\u00112\f\u00100\u001a\b\u0012\u0004\u0012\u00020#0s¢\u0006\u0004\by\u0010uJ\u001b\u0010z\u001a\u00020\u00112\f\u00100\u001a\b\u0012\u0004\u0012\u00020#0s¢\u0006\u0004\bz\u0010uJ\u0017\u0010{\u001a\u00020\u00112\u0006\u0010I\u001a\u00020HH\u0015¢\u0006\u0004\b{\u0010|J\u001b\u0010}\u001a\u00020\u00112\f\u00100\u001a\b\u0012\u0004\u0012\u00020H0s¢\u0006\u0004\b}\u0010uJ\u0018\u0010\u007f\u001a\u00020\u00112\u0006\u0010~\u001a\u000206H\u0017¢\u0006\u0005\b\u007f\u0010\u0080\u0001J \u0010\u007f\u001a\u00020\u00112\u0006\u0010~\u001a\u0002062\u0006\u0010p\u001a\u00020oH\u0017¢\u0006\u0005\b\u007f\u0010\u0081\u0001J\u001e\u0010\u0083\u0001\u001a\u00020\u00112\r\u00100\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010s¢\u0006\u0005\b\u0083\u0001\u0010uJ\u001e\u0010\u0084\u0001\u001a\u00020\u00112\r\u00100\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010s¢\u0006\u0005\b\u0084\u0001\u0010uJ\u001b\u0010\u0086\u0001\u001a\u00020\u00112\u0007\u0010\u0085\u0001\u001a\u000206H\u0017¢\u0006\u0006\b\u0086\u0001\u0010\u0080\u0001J#\u0010\u0086\u0001\u001a\u00020\u00112\u0007\u0010\u0085\u0001\u001a\u0002062\u0006\u0010p\u001a\u00020oH\u0017¢\u0006\u0006\b\u0086\u0001\u0010\u0081\u0001J\u001e\u0010\u0088\u0001\u001a\u00020\u00112\r\u00100\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010s¢\u0006\u0005\b\u0088\u0001\u0010uJ\u001e\u0010\u0089\u0001\u001a\u00020\u00112\r\u00100\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010s¢\u0006\u0005\b\u0089\u0001\u0010uJ\u0011\u0010\u008a\u0001\u001a\u00020\u0011H\u0015¢\u0006\u0005\b\u008a\u0001\u0010\u0010J\u0011\u0010\u008b\u0001\u001a\u00020\u0011H\u0016¢\u0006\u0005\b\u008b\u0001\u0010\u0010R\u0018\u0010\u008e\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u008d\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001e\u0010\u0096\u0001\u001a\u00030\u0093\u00018\u0002X\u0082\u0004¢\u0006\u000e\n\u0005\bE\u0010\u0094\u0001\u0012\u0005\b\u0095\u0001\u0010\u0010R\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0017\u0010\u009d\u0001\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R!\u0010£\u0001\u001a\u00030\u009e\u00018VX\u0096\u0084\u0002¢\u0006\u0010\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R\u0018\u0010¥\u0001\u001a\u00020#8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b¤\u0001\u0010bR\u0018\u0010©\u0001\u001a\u00030¦\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001c\u0010\u00ad\u0001\u001a\u00020f8\u0006¢\u0006\u0010\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b\u0098\u0001\u0010¬\u0001R#\u0010°\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020o0s0®\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bz\u0010¯\u0001R$\u0010²\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0s0®\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0001\u0010¯\u0001R$\u0010´\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0s0®\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b³\u0001\u0010¯\u0001R$\u0010µ\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0082\u00010s0®\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bv\u0010¯\u0001R%\u0010·\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0087\u00010s0®\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010¯\u0001R\u001f\u0010º\u0001\u001a\n\u0012\u0005\u0012\u00030¸\u00010®\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010¯\u0001R\u0019\u0010½\u0001\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u0019\u0010¿\u0001\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¼\u0001R!\u0010Ã\u0001\u001a\u00030À\u00018VX\u0096\u0084\u0002¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010 \u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001R'\u0010È\u0001\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\u0017\n\u0006\bÄ\u0001\u0010 \u0001\u0012\u0005\bÇ\u0001\u0010\u0010\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u0018\u0010Ì\u0001\u001a\u00030É\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÊ\u0001\u0010Ë\u0001R\u0018\u0010Ï\u0001\u001a\u00030\u0097\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u0018\u0010Ó\u0001\u001a\u00030Ð\u00018WX\u0096\u0004¢\u0006\b\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0015\u0010×\u0001\u001a\u00030Ô\u00018F¢\u0006\b\u001a\u0006\bÕ\u0001\u0010Ö\u0001¨\u0006Ù\u0001"}, d2 = {"Landroidx/activity/ComponentActivity;", "Landroidx/core/app/ComponentActivity;", "", "Lir/nasim/oz3;", "Lir/nasim/jX7;", "Landroidx/lifecycle/h;", "Lir/nasim/Tb6;", "Lir/nasim/AI4;", "Lir/nasim/B6;", "Lir/nasim/YI4;", "Lir/nasim/kK4;", "Lir/nasim/DJ4;", "Lir/nasim/OJ4;", "Lir/nasim/n44;", "Lir/nasim/RA2;", "<init>", "()V", "Lir/nasim/rB7;", "j0", "Lir/nasim/xI4;", "dispatcher", "e0", "(Lir/nasim/xI4;)V", "Landroidx/activity/ComponentActivity$e;", "i0", "()Landroidx/activity/ComponentActivity$e;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onRetainNonConfigurationInstance", "()Ljava/lang/Object;", "s0", "", "layoutResID", "setContentView", "(I)V", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "addContentView", "l0", "Lir/nasim/cJ4;", "listener", "g0", "(Lir/nasim/cJ4;)V", "featureId", "Landroid/view/Menu;", "menu", "", "onPreparePanel", "(ILandroid/view/View;Landroid/view/Menu;)Z", "onCreatePanelMenu", "(ILandroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "onMenuItemSelected", "(ILandroid/view/MenuItem;)Z", "onPanelClosed", "(ILandroid/view/Menu;)V", "Lir/nasim/A44;", "provider", TokenNames.C, "(Lir/nasim/A44;)V", "e", "m0", "onBackPressed", "Landroid/content/Intent;", "intent", "requestCode", "startActivityForResult", "(Landroid/content/Intent;I)V", "options", "(Landroid/content/Intent;ILandroid/os/Bundle;)V", "Landroid/content/IntentSender;", "fillInIntent", "flagsMask", "flagsValues", "extraFlags", "startIntentSenderForResult", "(Landroid/content/IntentSender;ILandroid/content/Intent;III)V", "(Landroid/content/IntentSender;ILandroid/content/Intent;IIILandroid/os/Bundle;)V", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", TokenNames.I, TokenNames.O, "Lir/nasim/o6;", "contract", "Lir/nasim/y6;", "registry", "Lir/nasim/n6;", "callback", "Lir/nasim/v6;", "u0", "(Lir/nasim/o6;Lir/nasim/y6;Lir/nasim/n6;)Lir/nasim/v6;", "t0", "(Lir/nasim/o6;Lir/nasim/n6;)Lir/nasim/v6;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lir/nasim/ze1;", "B", "(Lir/nasim/ze1;)V", "o", "level", "onTrimMemory", "b", "l", "onNewIntent", "(Landroid/content/Intent;)V", "h0", "isInMultiWindowMode", "onMultiWindowModeChanged", "(Z)V", "(ZLandroid/content/res/Configuration;)V", "Lir/nasim/Ol4;", "a", "c", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "Lir/nasim/md5;", "t", "w", "onUserLeaveHint", "reportFullyDrawn", "Lir/nasim/Bl1;", "Lir/nasim/Bl1;", "contextAwareHelper", "Lir/nasim/o44;", "d", "Lir/nasim/o44;", "menuHostHelper", "Lir/nasim/Sb6;", "Lir/nasim/Sb6;", "getSavedStateRegistryController$annotations", "savedStateRegistryController", "Lir/nasim/iX7;", "f", "Lir/nasim/iX7;", "_viewModelStore", "g", "Landroidx/activity/ComponentActivity$e;", "reportFullyDrawnExecutor", "Lir/nasim/QA2;", "h", "Lir/nasim/Yu3;", "k0", "()Lir/nasim/QA2;", "fullyDrawnReporter", "i", "contentLayoutId", "Ljava/util/concurrent/atomic/AtomicInteger;", "j", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextLocalRequestCode", "k", "Lir/nasim/y6;", "()Lir/nasim/y6;", "activityResultRegistry", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onConfigurationChangedListeners", "m", "onTrimMemoryListeners", "n", "onNewIntentListeners", "onMultiWindowModeChangedListeners", "p", "onPictureInPictureModeChangedListeners", "Ljava/lang/Runnable;", "q", "onUserLeaveHintListeners", "r", "Z", "dispatchingOnMultiWindowModeChanged", "s", "dispatchingOnPictureInPictureModeChanged", "Landroidx/lifecycle/G$c;", "n3", "()Landroidx/lifecycle/G$c;", "defaultViewModelProviderFactory", "u", "z2", "()Lir/nasim/xI4;", "getOnBackPressedDispatcher$annotations", "onBackPressedDispatcher", "Landroidx/lifecycle/j;", "getLifecycle", "()Landroidx/lifecycle/j;", "lifecycle", "d1", "()Lir/nasim/iX7;", "viewModelStore", "Lir/nasim/ru1;", "p3", "()Lir/nasim/ru1;", "defaultViewModelCreationExtras", "Lir/nasim/Rb6;", "v1", "()Lir/nasim/Rb6;", "savedStateRegistry", "v", "activity_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements InterfaceC18633oz3, InterfaceC15408jX7, androidx.lifecycle.h, InterfaceC7760Tb6, AI4, B6, YI4, InterfaceC15879kK4, DJ4, OJ4, InterfaceC17502n44, RA2 {
    private static final c v = new c(null);

    /* renamed from: c, reason: from kotlin metadata */
    private final C3575Bl1 contextAwareHelper = new C3575Bl1();

    /* renamed from: d, reason: from kotlin metadata */
    private final C18093o44 menuHostHelper = new C18093o44(new Runnable() { // from class: ir.nasim.J01
        @Override // java.lang.Runnable
        public final void run() {
            ComponentActivity.o0(this.a);
        }
    });

    /* renamed from: e, reason: from kotlin metadata */
    private final C7523Sb6 savedStateRegistryController;

    /* renamed from: f, reason: from kotlin metadata */
    private C14819iX7 _viewModelStore;

    /* renamed from: g, reason: from kotlin metadata */
    private final e reportFullyDrawnExecutor;

    /* renamed from: h, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 fullyDrawnReporter;

    /* renamed from: i, reason: from kotlin metadata */
    private int contentLayoutId;

    /* renamed from: j, reason: from kotlin metadata */
    private final AtomicInteger nextLocalRequestCode;

    /* renamed from: k, reason: from kotlin metadata */
    private final AbstractC24133y6 activityResultRegistry;

    /* renamed from: l, reason: from kotlin metadata */
    private final CopyOnWriteArrayList onConfigurationChangedListeners;

    /* renamed from: m, reason: from kotlin metadata */
    private final CopyOnWriteArrayList onTrimMemoryListeners;

    /* renamed from: n, reason: from kotlin metadata */
    private final CopyOnWriteArrayList onNewIntentListeners;

    /* renamed from: o, reason: from kotlin metadata */
    private final CopyOnWriteArrayList onMultiWindowModeChangedListeners;

    /* renamed from: p, reason: from kotlin metadata */
    private final CopyOnWriteArrayList onPictureInPictureModeChangedListeners;

    /* renamed from: q, reason: from kotlin metadata */
    private final CopyOnWriteArrayList onUserLeaveHintListeners;

    /* renamed from: r, reason: from kotlin metadata */
    private boolean dispatchingOnMultiWindowModeChanged;

    /* renamed from: s, reason: from kotlin metadata */
    private boolean dispatchingOnPictureInPictureModeChanged;

    /* renamed from: t, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 defaultViewModelProviderFactory;

    /* renamed from: u, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 onBackPressedDispatcher;

    public static final class a implements n {
        a() {
        }

        @Override // androidx.lifecycle.n
        public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
            AbstractC13042fc3.i(interfaceC18633oz3, "source");
            AbstractC13042fc3.i(aVar, "event");
            ComponentActivity.this.j0();
            ComponentActivity.this.getLifecycle().d(this);
        }
    }

    private static final class b {
        public static final b a = new b();

        private b() {
        }

        public final OnBackInvokedDispatcher a(Activity activity) {
            AbstractC13042fc3.i(activity, "activity");
            OnBackInvokedDispatcher onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
            AbstractC13042fc3.h(onBackInvokedDispatcher, "activity.getOnBackInvokedDispatcher()");
            return onBackInvokedDispatcher;
        }
    }

    private static final class c {
        private c() {
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    public static final class d {
        private Object a;
        private C14819iX7 b;

        public final C14819iX7 a() {
            return this.b;
        }

        public final void b(Object obj) {
            this.a = obj;
        }

        public final void c(C14819iX7 c14819iX7) {
            this.b = c14819iX7;
        }
    }

    private interface e extends Executor {
        void S(View view);

        void j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class f implements e, ViewTreeObserver.OnDrawListener, Runnable {
        private final long a = SystemClock.uptimeMillis() + AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND;
        private Runnable b;
        private boolean c;

        public f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(f fVar) {
            AbstractC13042fc3.i(fVar, "this$0");
            Runnable runnable = fVar.b;
            if (runnable != null) {
                AbstractC13042fc3.f(runnable);
                runnable.run();
                fVar.b = null;
            }
        }

        @Override // androidx.activity.ComponentActivity.e
        public void S(View view) {
            AbstractC13042fc3.i(view, "view");
            if (this.c) {
                return;
            }
            this.c = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            AbstractC13042fc3.i(runnable, "runnable");
            this.b = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            AbstractC13042fc3.h(decorView, "window.decorView");
            if (!this.c) {
                decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ComponentActivity.f.b(this.a);
                    }
                });
            } else if (AbstractC13042fc3.d(Looper.myLooper(), Looper.getMainLooper())) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // androidx.activity.ComponentActivity.e
        public void j() {
            ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.b;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.a) {
                    this.c = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.b = null;
            if (ComponentActivity.this.k0().c()) {
                this.c = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public static final class g extends AbstractC24133y6 {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(g gVar, int i, AbstractC18108o6.a aVar) {
            AbstractC13042fc3.i(gVar, "this$0");
            gVar.f(i, aVar.a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(g gVar, int i, IntentSender.SendIntentException sendIntentException) {
            AbstractC13042fc3.i(gVar, "this$0");
            AbstractC13042fc3.i(sendIntentException, "$e");
            gVar.e(i, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", sendIntentException));
        }

        @Override // ir.nasim.AbstractC24133y6
        public void i(final int i, AbstractC18108o6 abstractC18108o6, Object obj, AbstractC15744k6 abstractC15744k6) {
            Bundle bundle;
            AbstractC13042fc3.i(abstractC18108o6, "contract");
            ComponentActivity componentActivity = ComponentActivity.this;
            final AbstractC18108o6.a aVarB = abstractC18108o6.b(componentActivity, obj);
            if (aVarB != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: ir.nasim.P01
                    @Override // java.lang.Runnable
                    public final void run() {
                        ComponentActivity.g.s(this.a, i, aVarB);
                    }
                });
                return;
            }
            Intent intentA = abstractC18108o6.a(componentActivity, obj);
            if (intentA.getExtras() != null) {
                Bundle extras = intentA.getExtras();
                AbstractC13042fc3.f(extras);
                if (extras.getClassLoader() == null) {
                    intentA.setExtrasClassLoader(componentActivity.getClassLoader());
                }
            }
            if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else {
                bundle = null;
            }
            if (AbstractC13042fc3.d("androidx.activity.result.contract.action.REQUEST_PERMISSIONS", intentA.getAction())) {
                String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                X5.w(componentActivity, stringArrayExtra, i);
                return;
            }
            if (!AbstractC13042fc3.d("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST", intentA.getAction())) {
                X5.A(componentActivity, intentA, i, bundle);
                return;
            }
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                AbstractC13042fc3.f(intentSenderRequest);
                X5.B(componentActivity, intentSenderRequest.getIntentSender(), i, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle);
            } catch (IntentSender.SendIntentException e) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: ir.nasim.Q01
                    @Override // java.lang.Runnable
                    public final void run() {
                        ComponentActivity.g.t(this.a, i, e);
                    }
                });
            }
        }
    }

    static final class h extends AbstractC8614Ws3 implements SA2 {
        h() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C invoke() {
            Application application = ComponentActivity.this.getApplication();
            ComponentActivity componentActivity = ComponentActivity.this;
            return new C(application, componentActivity, componentActivity.getIntent() != null ? ComponentActivity.this.getIntent().getExtras() : null);
        }
    }

    static final class i extends AbstractC8614Ws3 implements SA2 {

        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ ComponentActivity e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ComponentActivity componentActivity) {
                super(0);
                this.e = componentActivity;
            }

            public final void a() {
                this.e.reportFullyDrawn();
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        i() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final QA2 invoke() {
            return new QA2(ComponentActivity.this.reportFullyDrawnExecutor, new a(ComponentActivity.this));
        }
    }

    static final class j extends AbstractC8614Ws3 implements SA2 {
        j() {
            super(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ComponentActivity componentActivity) {
            AbstractC13042fc3.i(componentActivity, "this$0");
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e) {
                if (!AbstractC13042fc3.d(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e;
                }
            } catch (NullPointerException e2) {
                if (!AbstractC13042fc3.d(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(ComponentActivity componentActivity, C23660xI4 c23660xI4) {
            AbstractC13042fc3.i(componentActivity, "this$0");
            AbstractC13042fc3.i(c23660xI4, "$dispatcher");
            componentActivity.e0(c23660xI4);
        }

        @Override // ir.nasim.SA2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final C23660xI4 invoke() {
            final ComponentActivity componentActivity = ComponentActivity.this;
            final C23660xI4 c23660xI4 = new C23660xI4(new Runnable() { // from class: androidx.activity.b
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentActivity.j.d(componentActivity);
                }
            });
            final ComponentActivity componentActivity2 = ComponentActivity.this;
            if (Build.VERSION.SDK_INT >= 33) {
                if (AbstractC13042fc3.d(Looper.myLooper(), Looper.getMainLooper())) {
                    componentActivity2.e0(c23660xI4);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            ComponentActivity.j.f(componentActivity2, c23660xI4);
                        }
                    });
                }
            }
            return c23660xI4;
        }
    }

    public ComponentActivity() {
        C7523Sb6 c7523Sb6A = C7523Sb6.d.a(this);
        this.savedStateRegistryController = c7523Sb6A;
        this.reportFullyDrawnExecutor = i0();
        this.fullyDrawnReporter = AbstractC13269fw3.a(new i());
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new g();
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList();
        this.onNewIntentListeners = new CopyOnWriteArrayList();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList();
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.".toString());
        }
        getLifecycle().a(new n() { // from class: ir.nasim.K01
            @Override // androidx.lifecycle.n
            public final void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
                ComponentActivity.U(this.a, interfaceC18633oz3, aVar);
            }
        });
        getLifecycle().a(new n() { // from class: ir.nasim.L01
            @Override // androidx.lifecycle.n
            public final void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
                ComponentActivity.V(this.a, interfaceC18633oz3, aVar);
            }
        });
        getLifecycle().a(new a());
        c7523Sb6A.c();
        B.c(this);
        v1().h("android:support:activity-result", new C7289Rb6.c() { // from class: ir.nasim.M01
            @Override // ir.nasim.C7289Rb6.c
            public final Bundle b() {
                return ComponentActivity.X(this.a);
            }
        });
        g0(new InterfaceC10854cJ4() { // from class: ir.nasim.N01
            @Override // ir.nasim.InterfaceC10854cJ4
            public final void a(Context context) {
                ComponentActivity.Y(this.a, context);
            }
        });
        this.defaultViewModelProviderFactory = AbstractC13269fw3.a(new h());
        this.onBackPressedDispatcher = AbstractC13269fw3.a(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(ComponentActivity componentActivity, InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
        Window window;
        View viewPeekDecorView;
        AbstractC13042fc3.i(componentActivity, "this$0");
        AbstractC13042fc3.i(interfaceC18633oz3, "<anonymous parameter 0>");
        AbstractC13042fc3.i(aVar, "event");
        if (aVar != j.a.ON_STOP || (window = componentActivity.getWindow()) == null || (viewPeekDecorView = window.peekDecorView()) == null) {
            return;
        }
        viewPeekDecorView.cancelPendingInputEvents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(ComponentActivity componentActivity, InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
        AbstractC13042fc3.i(componentActivity, "this$0");
        AbstractC13042fc3.i(interfaceC18633oz3, "<anonymous parameter 0>");
        AbstractC13042fc3.i(aVar, "event");
        if (aVar == j.a.ON_DESTROY) {
            componentActivity.contextAwareHelper.b();
            if (!componentActivity.isChangingConfigurations()) {
                componentActivity.d1().a();
            }
            componentActivity.reportFullyDrawnExecutor.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle X(ComponentActivity componentActivity) {
        AbstractC13042fc3.i(componentActivity, "this$0");
        Bundle bundle = new Bundle();
        componentActivity.activityResultRegistry.k(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(ComponentActivity componentActivity, Context context) {
        AbstractC13042fc3.i(componentActivity, "this$0");
        AbstractC13042fc3.i(context, "it");
        Bundle bundleB = componentActivity.v1().b("android:support:activity-result");
        if (bundleB != null) {
            componentActivity.activityResultRegistry.j(bundleB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(final C23660xI4 dispatcher) {
        getLifecycle().a(new n() { // from class: ir.nasim.O01
            @Override // androidx.lifecycle.n
            public final void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
                ComponentActivity.f0(dispatcher, this, interfaceC18633oz3, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(C23660xI4 c23660xI4, ComponentActivity componentActivity, InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
        AbstractC13042fc3.i(c23660xI4, "$dispatcher");
        AbstractC13042fc3.i(componentActivity, "this$0");
        AbstractC13042fc3.i(interfaceC18633oz3, "<anonymous parameter 0>");
        AbstractC13042fc3.i(aVar, "event");
        if (aVar == j.a.ON_CREATE) {
            c23660xI4.o(b.a.a(componentActivity));
        }
    }

    private final e i0() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        if (this._viewModelStore == null) {
            d dVar = (d) getLastNonConfigurationInstance();
            if (dVar != null) {
                this._viewModelStore = dVar.a();
            }
            if (this._viewModelStore == null) {
                this._viewModelStore = new C14819iX7();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(ComponentActivity componentActivity) {
        AbstractC13042fc3.i(componentActivity, "this$0");
        componentActivity.m0();
    }

    @Override // ir.nasim.YI4
    public final void B(InterfaceC25043ze1 listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.onConfigurationChangedListeners.add(listener);
    }

    @Override // ir.nasim.InterfaceC17502n44
    public void C(A44 provider) {
        AbstractC13042fc3.i(provider, "provider");
        this.menuHostHelper.a(provider);
    }

    @Override // ir.nasim.DJ4
    public final void a(InterfaceC25043ze1 listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.onMultiWindowModeChangedListeners.add(listener);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        l0();
        e eVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        AbstractC13042fc3.h(decorView, "window.decorView");
        eVar.S(decorView);
        super.addContentView(view, params);
    }

    @Override // ir.nasim.InterfaceC15879kK4
    public final void b(InterfaceC25043ze1 listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.onTrimMemoryListeners.add(listener);
    }

    @Override // ir.nasim.DJ4
    public final void c(InterfaceC25043ze1 listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.onMultiWindowModeChangedListeners.remove(listener);
    }

    @Override // ir.nasim.InterfaceC15408jX7
    public C14819iX7 d1() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.".toString());
        }
        j0();
        C14819iX7 c14819iX7 = this._viewModelStore;
        AbstractC13042fc3.f(c14819iX7);
        return c14819iX7;
    }

    @Override // ir.nasim.InterfaceC17502n44
    public void e(A44 provider) {
        AbstractC13042fc3.i(provider, "provider");
        this.menuHostHelper.f(provider);
    }

    @Override // ir.nasim.B6
    /* renamed from: f, reason: from getter */
    public final AbstractC24133y6 getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    public final void g0(InterfaceC10854cJ4 listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.contextAwareHelper.a(listener);
    }

    @Override // androidx.core.app.ComponentActivity, ir.nasim.InterfaceC18633oz3
    public androidx.lifecycle.j getLifecycle() {
        return super.getLifecycle();
    }

    public final void h0(InterfaceC25043ze1 listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.onNewIntentListeners.add(listener);
    }

    public QA2 k0() {
        return (QA2) this.fullyDrawnReporter.getValue();
    }

    @Override // ir.nasim.InterfaceC15879kK4
    public final void l(InterfaceC25043ze1 listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.onTrimMemoryListeners.remove(listener);
    }

    public void l0() {
        View decorView = getWindow().getDecorView();
        AbstractC13042fc3.h(decorView, "window.decorView");
        VX7.b(decorView, this);
        View decorView2 = getWindow().getDecorView();
        AbstractC13042fc3.h(decorView2, "window.decorView");
        YX7.b(decorView2, this);
        View decorView3 = getWindow().getDecorView();
        AbstractC13042fc3.h(decorView3, "window.decorView");
        XX7.b(decorView3, this);
        View decorView4 = getWindow().getDecorView();
        AbstractC13042fc3.h(decorView4, "window.decorView");
        WX7.b(decorView4, this);
        View decorView5 = getWindow().getDecorView();
        AbstractC13042fc3.h(decorView5, "window.decorView");
        UX7.a(decorView5, this);
    }

    public void m0() {
        invalidateOptionsMenu();
    }

    @Override // androidx.lifecycle.h
    public G.c n3() {
        return (G.c) this.defaultViewModelProviderFactory.getValue();
    }

    @Override // ir.nasim.YI4
    public final void o(InterfaceC25043ze1 listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.onConfigurationChangedListeners.remove(listener);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (this.activityResultRegistry.e(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        z2().l();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Iterator it = this.onConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC25043ze1) it.next()).accept(newConfig);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        this.savedStateRegistryController.d(savedInstanceState);
        this.contextAwareHelper.c(this);
        super.onCreate(savedInstanceState);
        x.INSTANCE.c(this);
        int i2 = this.contentLayoutId;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        AbstractC13042fc3.i(menu, "menu");
        if (featureId != 0) {
            return true;
        }
        super.onCreatePanelMenu(featureId, menu);
        this.menuHostHelper.b(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        AbstractC13042fc3.i(item, "item");
        if (super.onMenuItemSelected(featureId, item)) {
            return true;
        }
        if (featureId == 0) {
            return this.menuHostHelper.d(item);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        if (this.dispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator it = this.onMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC25043ze1) it.next()).accept(new C6665Ol4(isInMultiWindowMode));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        AbstractC13042fc3.i(intent, "intent");
        super.onNewIntent(intent);
        Iterator it = this.onNewIntentListeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC25043ze1) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int featureId, Menu menu) {
        AbstractC13042fc3.i(menu, "menu");
        this.menuHostHelper.c(menu);
        super.onPanelClosed(featureId, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        if (this.dispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator it = this.onPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC25043ze1) it.next()).accept(new C17236md5(isInPictureInPictureMode));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        AbstractC13042fc3.i(menu, "menu");
        if (featureId != 0) {
            return true;
        }
        super.onPreparePanel(featureId, view, menu);
        this.menuHostHelper.e(menu);
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        if (this.activityResultRegistry.e(requestCode, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", permissions).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", grantResults))) {
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        d dVar;
        Object objS0 = s0();
        C14819iX7 c14819iX7A = this._viewModelStore;
        if (c14819iX7A == null && (dVar = (d) getLastNonConfigurationInstance()) != null) {
            c14819iX7A = dVar.a();
        }
        if (c14819iX7A == null && objS0 == null) {
            return null;
        }
        d dVar2 = new d();
        dVar2.b(objS0);
        dVar2.c(c14819iX7A);
        return dVar2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        AbstractC13042fc3.i(outState, "outState");
        if (getLifecycle() instanceof p) {
            androidx.lifecycle.j lifecycle = getLifecycle();
            AbstractC13042fc3.g(lifecycle, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            ((p) lifecycle).n(j.b.CREATED);
        }
        super.onSaveInstanceState(outState);
        this.savedStateRegistryController.e(outState);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Iterator it = this.onTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC25043ze1) it.next()).accept(Integer.valueOf(level));
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator it = this.onUserLeaveHintListeners.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @Override // androidx.lifecycle.h
    public AbstractC20375ru1 p3() {
        C13170fm4 c13170fm4 = new C13170fm4(null, 1, null);
        if (getApplication() != null) {
            AbstractC20375ru1.b bVar = G.a.h;
            Application application = getApplication();
            AbstractC13042fc3.h(application, SIPServerTransaction.CONTENT_TYPE_APPLICATION);
            c13170fm4.c(bVar, application);
        }
        c13170fm4.c(B.a, this);
        c13170fm4.c(B.b, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            c13170fm4.c(B.c, extras);
        }
        return c13170fm4;
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (C16807lt7.d()) {
                C16807lt7.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            k0().b();
            C16807lt7.b();
        } catch (Throwable th) {
            C16807lt7.b();
            throw th;
        }
    }

    public Object s0() {
        return null;
    }

    @Override // android.app.Activity
    public void setContentView(int layoutResID) {
        l0();
        e eVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        AbstractC13042fc3.h(decorView, "window.decorView");
        eVar.S(decorView);
        super.setContentView(layoutResID);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int requestCode) {
        AbstractC13042fc3.i(intent, "intent");
        super.startActivityForResult(intent, requestCode);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        AbstractC13042fc3.i(intent, "intent");
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override // ir.nasim.OJ4
    public final void t(InterfaceC25043ze1 listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.onPictureInPictureModeChangedListeners.add(listener);
    }

    public final AbstractC22357v6 t0(AbstractC18108o6 contract, InterfaceC17517n6 callback) {
        AbstractC13042fc3.i(contract, "contract");
        AbstractC13042fc3.i(callback, "callback");
        return u0(contract, this.activityResultRegistry, callback);
    }

    public final AbstractC22357v6 u0(AbstractC18108o6 contract, AbstractC24133y6 registry, InterfaceC17517n6 callback) {
        AbstractC13042fc3.i(contract, "contract");
        AbstractC13042fc3.i(registry, "registry");
        AbstractC13042fc3.i(callback, "callback");
        return registry.m("activity_rq#" + this.nextLocalRequestCode.getAndIncrement(), this, contract, callback);
    }

    @Override // ir.nasim.InterfaceC7760Tb6
    public final C7289Rb6 v1() {
        return this.savedStateRegistryController.b();
    }

    @Override // ir.nasim.OJ4
    public final void w(InterfaceC25043ze1 listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.onPictureInPictureModeChangedListeners.remove(listener);
    }

    @Override // ir.nasim.AI4
    public final C23660xI4 z2() {
        return (C23660xI4) this.onBackPressedDispatcher.getValue();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        AbstractC13042fc3.i(intent, "intent");
        super.startActivityForResult(intent, requestCode, options);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        AbstractC13042fc3.i(intent, "intent");
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
            this.dispatchingOnMultiWindowModeChanged = false;
            Iterator it = this.onMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                ((InterfaceC25043ze1) it.next()).accept(new C6665Ol4(isInMultiWindowMode, newConfig));
            }
        } catch (Throwable th) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
            this.dispatchingOnPictureInPictureModeChanged = false;
            Iterator it = this.onPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                ((InterfaceC25043ze1) it.next()).accept(new C17236md5(isInPictureInPictureMode, newConfig));
            }
        } catch (Throwable th) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        l0();
        e eVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        AbstractC13042fc3.h(decorView, "window.decorView");
        eVar.S(decorView);
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        l0();
        e eVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        AbstractC13042fc3.h(decorView, "window.decorView");
        eVar.S(decorView);
        super.setContentView(view, params);
    }
}
