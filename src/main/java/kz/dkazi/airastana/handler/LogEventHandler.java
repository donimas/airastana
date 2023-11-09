package kz.dkazi.airastana.handler;

import kz.dkazi.airastana.enums.EventStatus;
import kz.dkazi.airastana.logging.LogEvent;
import kz.dkazi.airastana.utils.MessageUtils;
import kz.dkazi.airastana.utils.SecurityUtils;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Instant;

@Component
@AllArgsConstructor
public class LogEventHandler {

    private final Logger log = LoggerFactory.getLogger(LogEventHandler.class);

    public void handleEvent(JoinPoint jp) {
        var methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();
        var annotation = method.getAnnotation(LogEvent.class);
        String message = MessageUtils.getDescription(jp, annotation.template(), annotation.values());
        handleEvent(jp, EventStatus.SUCCESS, message);
    }

    public void handleEvent(JoinPoint jp, EventStatus status, String message) {
        var methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();
        var annotation = method.getAnnotation(LogEvent.class);
        log.info("log type: {}", annotation.type());
        log.info("log status: {}", status);
        log.info("log message: {}", message);

        String currentUsername = SecurityUtils.getCurrentUserLogin().orElse("unknown");
        log.info("log username: {}", currentUsername);
        log.info("timestamp: {}", Instant.now());
    }

}
