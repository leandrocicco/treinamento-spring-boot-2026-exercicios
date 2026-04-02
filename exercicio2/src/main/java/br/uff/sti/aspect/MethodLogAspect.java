package br.uff.sti.aspect;

import br.uff.sti.destination.Destination;
import br.uff.sti.writer.Writer;
import br.uff.sti.util.Utils;
import jakarta.annotation.PostConstruct;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodLogAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(MethodLogAspect.class);
    
    private final Destination logDestination;
    
    private final Writer logWriter;

    public MethodLogAspect(Destination logDestination, Writer logWriter) {
        this.logDestination = logDestination;
        this.logWriter = logWriter;
    }       
    
    @PostConstruct
    private void postConstruct() {
        this.logWriter.log(Arrays.asList("Method_Signature", "Method_Class", "DateTime"), 
                this.logDestination);
    }
    
    @After("@annotation(br.uff.sti.annotations.Loga)")
    public void mehtodLog(JoinPoint joinPoint) throws Throwable {    
        logger.debug("aspecto chamado: " + joinPoint.getSignature());        
        this.logWriter.log(Arrays.asList(joinPoint.getSignature().toShortString(), 
                            joinPoint.getTarget().getClass().toString(), 
                            Utils.getDataHoraAtualFormatada()),
                this.logDestination);
    }
}
