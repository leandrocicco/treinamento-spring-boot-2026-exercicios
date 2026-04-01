package br.uff.sti.aspect;

import br.uff.sti.destination.Destination;
import br.uff.sti.writer.Writer;
import br.uff.sti.util.Utils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodLogAspect {
    
    private final Destination logDestination;
    
    private final Writer writer;

    public MethodLogAspect(Destination logDestination, Writer logWriter) {
        this.logDestination = logDestination;
        this.writer = logWriter;
    }       

    @After("@annotation(br.uff.sti.annotations.Loga)")
    public void mehtodLog(JoinPoint joinPoint) throws Throwable {        
        Map<String,String> map = new LinkedHashMap<>();
        map.put("Method_Signature", joinPoint.getSignature().toShortString());
        map.put("Method_Class", joinPoint.getTarget().getClass().toString());
        map.put("DataHora", Utils.getDataHoraAtualFormatada());
        List<Map<String,String>> list = new ArrayList<>();
        list.add(map);       
        this.writer.write(list, this.logDestination, false);
    }
}
