package kz.dkazi.airastana.logging;

import kz.dkazi.airastana.enums.EventStatus;
import kz.dkazi.airastana.handler.LogEventHandler;
import kz.dkazi.airastana.utils.MessageUtils;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@AllArgsConstructor
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    private final LogEventHandler logEventHandler;

    @AfterThrowing(value = "@annotation(kz.dkazi.airastana.logging.LogEvent)", throwing = "e")
    public void logFailure(JoinPoint jp, Throwable e) {
        String errorMessage = MessageUtils.buildErrorMessage(jp, e);
        log.error(errorMessage);
        logEventHandler.handleEvent(jp, EventStatus.FAILURE, errorMessage);
    }

    @AfterReturning("@annotation(kz.dkazi.airastana.logging.LogEvent)")
    public void logSuccess(JoinPoint joinPoint) {
        logEventHandler.handleEvent(joinPoint);
    }

}
