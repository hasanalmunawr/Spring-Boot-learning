package hasanalmunawarDev.SpringBasic.processor;

import hasanalmunawarDev.SpringBasic.aware.NimAware;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class NimGeneratorBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof NimAware) {
           NimAware nimAware = (NimAware) bean;
           String uuid = UUID.randomUUID().toString();
           nimAware.setNim(uuid.substring(uuid.length()-8));
        }
        return bean;
    }
}
