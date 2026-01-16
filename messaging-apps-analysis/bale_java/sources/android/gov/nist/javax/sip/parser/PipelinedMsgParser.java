package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.stack.QueuedMessageDispatchBase;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

/* loaded from: classes.dex */
public final class PipelinedMsgParser implements Runnable {
    private static final String CRLF = "\r\n";
    private static StackLogger logger = CommonLogger.getLogger(PipelinedMsgParser.class);
    private static int uid = 0;
    boolean isRunning;
    private int maxMessageSize;
    private ConcurrentHashMap<String, CallIDOrderingStructure> messagesOrderingMap;
    private Thread mythread;
    private Pipeline rawInputStream;
    protected SIPMessageListener sipMessageListener;
    private SIPTransactionStack sipStack;
    private int sizeCounter;
    private MessageParser smp;

    class CallIDOrderingStructure {
        private Semaphore semaphore = new Semaphore(1, true);
        private Queue<SIPMessage> messagesForCallID = new ConcurrentLinkedQueue();

        public CallIDOrderingStructure() {
        }

        public Queue<SIPMessage> getMessagesForCallID() {
            return this.messagesForCallID;
        }

        public Semaphore getSemaphore() {
            return this.semaphore;
        }
    }

    public class Dispatch implements Runnable, QueuedMessageDispatchBase {
        CallIDOrderingStructure callIDOrderingStructure;
        String callId;
        long time = System.currentTimeMillis();

        public Dispatch(CallIDOrderingStructure callIDOrderingStructure, String str) {
            this.callIDOrderingStructure = callIDOrderingStructure;
            this.callId = str;
        }

        @Override // android.gov.nist.javax.sip.stack.QueuedMessageDispatchBase
        public long getReceptionTime() {
            return this.time;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            Semaphore semaphore = this.callIDOrderingStructure.getSemaphore();
            Queue<SIPMessage> messagesForCallID = this.callIDOrderingStructure.getMessagesForCallID();
            if (PipelinedMsgParser.this.sipStack.sipEventInterceptor != null) {
                PipelinedMsgParser.this.sipStack.sipEventInterceptor.beforeMessage(messagesForCallID.peek());
            }
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                PipelinedMsgParser.logger.logError("Semaphore acquisition for callId " + this.callId + " interrupted", e);
            }
            SIPMessage sIPMessagePoll = messagesForCallID.poll();
            if (PipelinedMsgParser.logger.isLoggingEnabled(32)) {
                PipelinedMsgParser.logger.logDebug("semaphore acquired for message " + sIPMessagePoll);
            }
            try {
                try {
                    PipelinedMsgParser.this.sipMessageListener.processMessage(sIPMessagePoll);
                    if (messagesForCallID.size() <= 0) {
                        PipelinedMsgParser.this.messagesOrderingMap.remove(this.callId);
                        if (PipelinedMsgParser.logger.isLoggingEnabled(32)) {
                            PipelinedMsgParser.logger.logDebug("CallIDOrderingStructure removed for message " + this.callId);
                        }
                    }
                    if (PipelinedMsgParser.logger.isLoggingEnabled(32)) {
                        PipelinedMsgParser.logger.logDebug("releasing semaphore for message " + sIPMessagePoll);
                    }
                    semaphore.release();
                    if (PipelinedMsgParser.this.messagesOrderingMap.isEmpty()) {
                        synchronized (PipelinedMsgParser.this.messagesOrderingMap) {
                            PipelinedMsgParser.this.messagesOrderingMap.notify();
                        }
                    }
                } catch (Exception e2) {
                    PipelinedMsgParser.logger.logError("Error occured processing message", e2);
                    if (messagesForCallID.size() <= 0) {
                        PipelinedMsgParser.this.messagesOrderingMap.remove(this.callId);
                        if (PipelinedMsgParser.logger.isLoggingEnabled(32)) {
                            PipelinedMsgParser.logger.logDebug("CallIDOrderingStructure removed for message " + this.callId);
                        }
                    }
                    if (PipelinedMsgParser.logger.isLoggingEnabled(32)) {
                        PipelinedMsgParser.logger.logDebug("releasing semaphore for message " + sIPMessagePoll);
                    }
                    semaphore.release();
                    if (PipelinedMsgParser.this.messagesOrderingMap.isEmpty()) {
                        synchronized (PipelinedMsgParser.this.messagesOrderingMap) {
                            PipelinedMsgParser.this.messagesOrderingMap.notify();
                        }
                    }
                    if (PipelinedMsgParser.this.sipStack.sipEventInterceptor != null) {
                    }
                }
                if (PipelinedMsgParser.this.sipStack.sipEventInterceptor != null) {
                    PipelinedMsgParser.this.sipStack.sipEventInterceptor.afterMessage(sIPMessagePoll);
                }
                if (PipelinedMsgParser.logger.isLoggingEnabled(32)) {
                    PipelinedMsgParser.logger.logDebug("dispatch task done on " + sIPMessagePoll + " threadname " + PipelinedMsgParser.this.mythread.getName());
                }
            } catch (Throwable th) {
                if (messagesForCallID.size() <= 0) {
                    PipelinedMsgParser.this.messagesOrderingMap.remove(this.callId);
                    if (PipelinedMsgParser.logger.isLoggingEnabled(32)) {
                        PipelinedMsgParser.logger.logDebug("CallIDOrderingStructure removed for message " + this.callId);
                    }
                }
                if (PipelinedMsgParser.logger.isLoggingEnabled(32)) {
                    PipelinedMsgParser.logger.logDebug("releasing semaphore for message " + sIPMessagePoll);
                }
                semaphore.release();
                if (PipelinedMsgParser.this.messagesOrderingMap.isEmpty()) {
                    synchronized (PipelinedMsgParser.this.messagesOrderingMap) {
                        PipelinedMsgParser.this.messagesOrderingMap.notify();
                    }
                }
                if (PipelinedMsgParser.this.sipStack.sipEventInterceptor != null) {
                    PipelinedMsgParser.this.sipStack.sipEventInterceptor.afterMessage(sIPMessagePoll);
                }
                throw th;
            }
        }
    }

    protected PipelinedMsgParser() {
        this.smp = null;
        this.messagesOrderingMap = new ConcurrentHashMap<>();
        this.isRunning = false;
    }

    private void cleanMessageOrderingMap() {
        this.messagesOrderingMap.clear();
        synchronized (this.messagesOrderingMap) {
            this.messagesOrderingMap.notifyAll();
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("cleaned the messagesOrderingMap " + this + " threadname " + this.mythread.getName());
        }
    }

    private static synchronized int getNewUid() {
        int i;
        i = uid;
        uid = i + 1;
        return i;
    }

    private String readLine(InputStream inputStream) throws IOException {
        int i = 1024;
        byte[] bArr = new byte[1024];
        byte[] bArr2 = new byte[2];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw new IOException("End of stream");
            }
            int i5 = i4 & 255;
            char c = (char) i5;
            if (this.maxMessageSize > 0) {
                int i6 = this.sizeCounter - 1;
                this.sizeCounter = i6;
                if (i6 <= 0) {
                    throw new IOException("Max size exceeded!");
                }
            }
            if (c != '\r') {
                bArr[i2] = (byte) i5;
                i2++;
            } else if (i2 == 0) {
                bArr2[i3] = 13;
                i3++;
            }
            if (c == '\n') {
                if (i2 == 1 && i3 > 0) {
                    bArr2[i3] = 10;
                    i3++;
                }
                return (i2 != 1 || i3 <= 0) ? new String(bArr, 0, i2, "UTF-8") : new String(bArr2, 0, i3, "UTF-8");
            }
            if (i2 == i) {
                int i7 = i + 1024;
                byte[] bArr3 = new byte[i7];
                System.arraycopy(bArr, 0, bArr3, 0, i);
                i = i7;
                bArr = bArr3;
            }
        }
    }

    protected Object clone() {
        PipelinedMsgParser pipelinedMsgParser = new PipelinedMsgParser();
        pipelinedMsgParser.rawInputStream = this.rawInputStream;
        pipelinedMsgParser.sipMessageListener = this.sipMessageListener;
        new Thread(pipelinedMsgParser).setName("PipelineThread");
        return pipelinedMsgParser;
    }

    public void close() {
        this.isRunning = false;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Closing pipelinedmsgparser " + this + " threadname " + this.mythread.getName());
        }
        try {
            this.rawInputStream.close();
        } catch (IOException unused) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Couldn't close the rawInputStream " + this + " threadname " + this.mythread.getName() + " already closed ? " + this.rawInputStream.isClosed());
            }
        }
        if (PostParseExecutorServices.getPostParseExecutor() != null) {
            cleanMessageOrderingMap();
            synchronized (this.mythread) {
                this.mythread.notifyAll();
                this.mythread.interrupt();
            }
        }
    }

    public void processInput() {
        this.mythread.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x027a, code lost:
    
        if (android.gov.nist.javax.sip.parser.PipelinedMsgParser.logger.isLoggingEnabled(32) != false) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x027c, code lost:
    
        android.gov.nist.javax.sip.parser.PipelinedMsgParser.logger.logDebug("Detected a parsing issue " + r3.toString() + android.gov.nist.core.Separators.SP + r4.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        if (android.gov.nist.javax.sip.parser.PipelinedMsgParser.logger.isLoggingEnabled(32) == false) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        android.gov.nist.javax.sip.parser.PipelinedMsgParser.logger.logDebug("KeepAlive Double CRLF received, sending single CRLF as defined per RFC 5626 Section 4.4.1");
        android.gov.nist.javax.sip.parser.PipelinedMsgParser.logger.logDebug("~~~ setting isPreviousLineCRLF=false");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        r12.sipMessageListener.sendSingleCLRF();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        android.gov.nist.javax.sip.parser.PipelinedMsgParser.logger.logError("A problem occured while trying to send a single CLRF in response to a double CLRF", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00db, code lost:
    
        throw new java.io.IOException("Pre-content-length headers size exceeded. The size of the message of the headers prior to Content-Length is too large. This must be an invalid message. Limit is MAX_MESSAGE_SIZE/2=" + (r12.maxMessageSize / 2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00eb, code lost:
    
        r12.rawInputStream.stopTimer();
        r3.append(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f7, code lost:
    
        if (r1.isLoggingEnabled(32) == false) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f9, code lost:
    
        r1.logDebug("About to parse : " + r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0112, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0115, code lost:
    
        r6 = r3.toString().getBytes("UTF-8");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0120, code lost:
    
        r6 = r3.toString().getBytes();
     */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0431 A[Catch: IOException -> 0x0435, TRY_LEAVE, TryCatch #4 {IOException -> 0x0435, blocks: (B:206:0x0428, B:208:0x0431), top: B:223:0x0428 }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x01ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0007 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 1082
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.javax.sip.parser.PipelinedMsgParser.run():void");
    }

    public void setMessageListener(SIPMessageListener sIPMessageListener) {
        this.sipMessageListener = sIPMessageListener;
    }

    public PipelinedMsgParser(SIPTransactionStack sIPTransactionStack, SIPMessageListener sIPMessageListener, Pipeline pipeline, boolean z, int i) {
        this();
        this.sipStack = sIPTransactionStack;
        this.smp = sIPTransactionStack.getMessageParserFactory().createMessageParser(sIPTransactionStack);
        this.sipMessageListener = sIPMessageListener;
        this.rawInputStream = pipeline;
        this.maxMessageSize = i;
        Thread thread = new Thread(this);
        this.mythread = thread;
        thread.setName("PipelineThread-" + getNewUid());
    }

    public PipelinedMsgParser(SIPTransactionStack sIPTransactionStack, SIPMessageListener sIPMessageListener, Pipeline pipeline, int i) {
        this(sIPTransactionStack, sIPMessageListener, pipeline, false, i);
    }

    public PipelinedMsgParser(SIPTransactionStack sIPTransactionStack, Pipeline pipeline) {
        this(sIPTransactionStack, null, pipeline, false, 0);
    }
}
